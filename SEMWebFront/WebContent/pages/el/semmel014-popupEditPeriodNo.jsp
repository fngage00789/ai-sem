<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsgPopup"/>
	<rich:modalPanel id="popupEditPeriod" width="650" autosized="true" minWidth="220" moveable="true">
		<f:facet name="header">
				<h:outputText value="#{jspMsgPopup['header.popup.editPeriod']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditPeriod" style="cursor:pointer"/>
					<rich:componentControl for="popupEditPeriod" attachTo="hidePopupEditPeriod" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEditPeriod">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel014Bean.renderedMsgFormPopup}">
					 		<f:facet name="header">
	                        	<h:outputText value="Entered Data Status:"></h:outputText>
	                    	</f:facet>
				 			<f:facet name="errorMarker">
				 				 <h:graphicImage value="images/error.gif" />  
		                    </f:facet>
	                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmEditPeriod"> 
				<rich:panel id="pnlRentalEditPeriod">
				<f:facet name="header">
							<h:outputText value="#{jspMsgPopup['header.popup.editPeriod']}"/>
				</f:facet>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsgPopup['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtContractNo" value="#{semmel014Bean.verMaster.contractNo}" disabled="true"/>
									</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['column.header.meterNo']}" styleClass="ms7" />
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtExpenseType" value="#{semmel014Bean.meterId}" disabled="true" />
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['column.header.periodStartDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calBeginDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmel014Bean.fromTermOfPaymentDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
									</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['column.header.periodEndDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calEndDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmel014Bean.toTermOfPaymentDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['column.header.tfpd']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calPeriodStartDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmel014Bean.termOfPaymentDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
									</td>
				                	<td align="right" width="25%">
										
		                			</td>
		                			<td width="25%">
		                				
				                	</td>
			                	 </tr>
			                	 <tr>	
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsgPopup['label.popup.periodNo']}" styleClass="ms7"/>
		                			</td>
		                			<td  colspan="3">
			                			<h:inputText id="txtPeriodNoStart" value="#{semmel014Bean.periodNo}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 styleClass="inputRight"
			                			 maxlength="6" 
			                			 disabled="false">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0"/>
										</h:inputText>
				                	</td>
			                	 </tr>			                	 
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="#{jspMsgPopup['btn.save']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="popupEditPeriod,pnlContract,pnlExpensePeriod" 
									oncomplete="if(#{semmel014Bean.popupClose == 'true'})#{rich:component('popupEditPeriod')}.hide();">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL014-3" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="doUpdatePeriod" />	
									</a4j:commandButton>
									
									<rich:spacer width="10"/>
									<a4j:commandButton id="btnPopupCancel" value="#{jspMsgPopup['btn.cancel']}" styleClass="rich-button"
									reRender="popupEditPeriod" 
									oncomplete="#{rich:component('popupEditPeriod')}.hide();">
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				<!-- end content criteria -->
		</a4j:form>
	</rich:modalPanel>