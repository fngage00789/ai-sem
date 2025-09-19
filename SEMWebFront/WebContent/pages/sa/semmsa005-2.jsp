<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.sa.semmsa005" var="jspMsg"/>

<rich:modalPanel id="popupAddBorrowContract" width="600" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddContractStatus" style="cursor:pointer"/>
				<rich:componentControl for="popupAddBorrowContract" attachTo="hidePopupAddContractStatus" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<h:messages id="errorPopup" errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
				<a4j:form id="popupFrmAddContractStatus"> 
				<rich:panel id="pnlAddContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.add']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td valign="bottom" colspan="3">
			                			<h:selectOneMenu id="ddlCompany" value="#{semmsa005Bean.borrowRequest.company}" 
			                				onchange="GetCompanyJSPopup();" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW' or semmsa005Bean.mode == 'EDIT'}">
											<f:selectItems value="#{semmsa005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJSPopup" reRender="companyDisplayPopup,btnAdd"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplayPopup" value="#{semmsa005Bean.borrowRequest.company}" styleClass="ms28"/>
					                </td>
			                	 </tr>
								<tr>
									<td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td width="30%" valign="bottom">
			                			<h:inputText label="#{jspMsg['label.docNo']}" id="txtContractNo"
			                				disabled="true" 
			                				value="#{semmsa005Bean.borrowRequest.docNo}" />
					                </td>
									<td align="right" width="20%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.receiveDt']}" styleClass="ms7"/>
			                		</td>
			                		<td width="30%">
		                				<rich:calendar id="cldReceiveDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmsa005Bean.borrowRequest.receiveDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px" 
											label="#{jspMsg['label.receiveDt']}" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}">
										</rich:calendar> 
					                 </td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.samSendDt']}" styleClass="ms7"/>
			                		</td>
			                		<td>
		                				<rich:calendar id="cldSamSendDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmsa005Bean.borrowRequest.samSendDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px" 
											label="#{jspMsg['label.samSendDt']}" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}">
										</rich:calendar> 
					                 </td>
					                 
					                 <td align="right">
										<h:outputText value="#{jspMsg['label.samAssignSendDt']}" styleClass="ms7"/>
			                		</td>
			                		<td>
		                				<rich:calendar id="cldSamAssignSendDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmsa005Bean.borrowRequest.samAssignSendDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px" 
											label="#{jspMsg['label.samAssignSendDt']}" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}">
										</rich:calendar> 
					                 </td>
			                	 </tr>
			                	 <tr>
			                	 <td align="right" width="20%">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.siteNum']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">
			                			<h:inputText label="#{jspMsg['label.siteNum']}" id="txtSiteNum" 
			                				value="#{semmsa005Bean.borrowRequest.siteNum}" 
			                				maxlength="6"
				                			onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
				                			styleClass="inputRight" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
					                </td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" rendered="false"/>
		                			</td>
			                		<td colspan="3">
		                				<h:inputTextarea id="txtContractNoAdd" cols="40" rows="3"
			                				value="#{semmsa005Bean.contractAdd}" readonly="true" rendered="false"/>
			                			<rich:spacer width="3" rendered="false"></rich:spacer>
			                			<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.add']}" styleClass="rich-button"
			                				disabled="#{semmsa005Bean.borrowRequest.company == null or semmsa005Bean.borrowRequest.company == '' or semmsa005Bean.mode == 'VIEW'}"
											action="#{navAction.navi}" reRender="dtbBorrowRequest,frmError,popupFrmError,pnlBorrowRequest,popupAddNewContract"
											oncomplete="#{rich:component('popupAddNewContract')}.show(); return false" rendered="false">
											<a4j:actionparam name="navModule" value="sa" />
											<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
											<a4j:actionparam name="moduleWithNavi" value="sa" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
											<a4j:actionparam name="methodWithNavi" value="doInitAddContract" />
										</a4j:commandButton>
	                				</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                				<h:inputTextarea id="txtRemark" value="#{semmsa005Bean.borrowRequest.remark}" 
		                					cols="40" rows="3" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
				                	</td>
			                	 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdPopupCommand">
						<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="dtbBorrowRequest,frmError,popupFrmError,pnlBorrowRequest"
							rendered="#{semmsa005Bean.mode eq 'ADD'}"
							oncomplete="if(#{semmsa005Bean.popupClose == 'true'})#{rich:component('popupAddBorrowContract')}.hide();">
							<a4j:actionparam name="navModule" value="sa" />
							<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="doSaveBorrowContract" />
						</a4j:commandButton>
						<a4j:commandButton id="btnEdit" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="dtbBorrowRequest,frmError,popupFrmError,pnlBorrowRequest"
							rendered="#{semmsa005Bean.mode eq 'EDIT'}"
							oncomplete="if(#{semmsa005Bean.popupClose == 'true'})#{rich:component('popupAddBorrowContract')}.hide();">
							<a4j:actionparam name="navModule" value="sa" />
							<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateBorrowContract" />
						</a4j:commandButton>
						<a4j:commandButton id="btnClose" value="Cancel" styleClass="rich-button"
							action="#{navAction.navi}" reRender="dtbBorrowRequest,frmError,popupFrmError,pnlBorrowRequest"
							oncomplete="#{rich:component('popupAddBorrowContract')}.hide();">
							<a4j:actionparam name="navModule" value="sa" />
							<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="doCancelBorrow" />
						</a4j:commandButton>
					</h:panelGrid>
						</rich:panel>
				</a4j:form>
</rich:modalPanel>

