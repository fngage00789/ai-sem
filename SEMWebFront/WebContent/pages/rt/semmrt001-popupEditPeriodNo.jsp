<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
	<rich:modalPanel id="popupRentalEditPeriod" width="650" autosized="true" minWidth="220" moveable="true">
		<f:facet name="header">
				<h:outputText value="#{jspMsg['header.popup.editPeriod']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupRentalEditPeriod" style="cursor:pointer"/>
					<rich:componentControl for="popupRentalEditPeriod" attachTo="hidePopupRentalEditPeriod" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEditPeriod">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt001Bean.renderedMsgFormPopup}">
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
							<h:outputText value="#{jspMsg['header.popup.editPeriod']}"/>
				</f:facet>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtContractNo" value="#{semmrt001Bean.contractNo}" disabled="true"/>
									</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.expenseTypePop']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtExpenseType" value="#{semmrt001Bean.expenseType}" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.beginDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calBeginDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmrt001Bean.effDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
									</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calEndDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmrt001Bean.expDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.popup.payPeriodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtPayPeriodType" value="#{semmrt001Bean.periodType}" disabled="true"/>
									</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.popup.periodStartDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="calPeriodStartDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmrt001Bean.periodStartDt}"
											disabled="true"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px">
											</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>	
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.popup.periodNo']}" styleClass="ms7"/>
		                			</td>
		                			<td  colspan="3">
			                			<h:inputText id="txtPeriodNoStart" value="#{semmrt001Bean.periodNo}"
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
									<a4j:commandButton id="btnPopupSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="popupRentalEditPeriod,dtbRentalPayNormalSrch,pnlSearchResult" 
									oncomplete="if(#{semmrt001Bean.popupClose == 'true'})#{rich:component('popupRentalEditPeriod')}.hide();">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT001-5" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
											<a4j:actionparam name="methodWithNavi" value="doUpdatePeriod" />	
									</a4j:commandButton>
									
									<rich:spacer width="10"/>
									<a4j:commandButton id="btnPopupCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
									reRender="popupRentalEditPeriod" 
									oncomplete="#{rich:component('popupRentalEditPeriod')}.hide();">
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