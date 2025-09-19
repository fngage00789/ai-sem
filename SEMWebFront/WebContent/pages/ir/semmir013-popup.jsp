<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir013" var="jspMsg"/>
	<rich:modalPanel id="popupEditClaim" width="750" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpEdt']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidepopupEditClaim" style="cursor:pointer"/>
					<rich:componentControl for="popupEditClaim" attachTo="hidepopupEditClaim" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEdtSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmEdit"> 
			<rich:panel id="pnlEditClaim">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpEdt']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
			                	 
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.policy']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPolicy" value="#{semmir013Bean.mir013Edt.draftNo}">
			                				<f:selectItems value="#{semmir013Bean.policySelectList}"/>
			                				<a4j:support event="onchange" action="#{semmir013Action.selectPolicy}" reRender="popupFrmEdit"></a4j:support>
			                			</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.effDt']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldEffectiveDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.effDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.effDt']}"
										disabled="true">
										</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.expDt']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldExpireDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.expDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.expDt']}"
										disabled="true">
										</rich:calendar>
				                	</td>
			                	 </tr>
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.claimAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtClaimAmt" value="#{semmir013Bean.mir013Edt.claimAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.insurChqNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtInsurChqNo" value="#{semmir013Bean.mir013Edt.insurChqNo}" size="18"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.insurChqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldInsurChqDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.insurChqDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.insurChqDt']}"
										disabled="false">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.insurRecpNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtInsurRecpNo" value="#{semmir013Bean.mir013Edt.insurRecpNo}" size="18" />
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.insurRecpDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldInsurRecpDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.insurRecpDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.insurRecpDt']}"
										disabled="false">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	 <td colspan="4">
				                	 	<hr>
				                	 </td>
			                	 </tr>
 							                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.transgerFlg']}" styleClass="ms7"/>
		                			</td>
				                	<td align="left" width="25%">
										<h:selectOneRadio id="rbtTransferFlg" value="#{semmir013Bean.mir013Edt.transferFlg}" layout="lineDirection" styleClass="ms7" rendered="true">
	                    					<f:selectItem  itemValue="N" itemLabel="#{jspMsg['label.transferFlgN']}"/>
	                    					<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.transferFlgY']}"/>
	                    				</h:selectOneRadio>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.tfChqAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<h:inputText id="txtTfChqAmt" value="#{semmir013Bean.mir013Edt.tfChqAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.tfChqNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtTfChqNo" value="#{semmir013Bean.mir013Edt.tfChqNo}" size="18" />
									
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.tfChqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldTfChqDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.tfChqDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.tfChqDt']}"
										disabled="false">
										</rich:calendar>
										
				                	</td>
			                	 </tr>
			                	 <tr>
				                	 <td colspan="4">
				                	 	<hr>
				                	 </td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.litigantFlg']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneRadio id="rbtLitigantFlg" value="#{semmir013Bean.mir013Edt.litigantFlg}" layout="lineDirection" styleClass="ms7" rendered="true">
	                    					<f:selectItem  itemValue="N" itemLabel="#{jspMsg['label.litigantFlgN']}"/>
	                    					<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.litigantFlgY']}"/>
	                    				</h:selectOneRadio>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.litigantAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtLitigantAmt" value="#{semmir013Bean.mir013Edt.litigantAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.litigantRecpNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtLitigantRecpNo" value="#{semmir013Bean.mir013Edt.litigantRecpNo}" size="18"/>
				                	</td>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.litigantRecpDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldLitigantRecpDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir013Bean.mir013Edt.litigantRecpDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.chqReceiveDt']}"
										disabled="false">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	 <td colspan="4">
				                	 	<hr>
				                	 </td>
			                	 </tr>
			                	 <tr>
			                	 
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.statusClaim']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlStatusClaim" value="#{semmir013Bean.mir013Edt.claimStatus}">
			                				<f:selectItems value="#{semmir013Bean.claimStatusList}"/>
			                			</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
			                	 
				                	<td align="right" width="25%" style="vertical-align:text-top;">
											<h:outputText value="#{jspMsg['label.statusClaim']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputTextarea id="txtRemark" value="#{semmir013Bean.mir013Edt.remark}" cols="30" rows="5"/>
				                	</td>
				                </tr>
				                
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupEdtSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmResult,frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" 
									oncomplete="if(#{semmir013Bean.popupClose == 'true'})#{rich:component('popupEditClaim')}.hide();">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR013-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" 
									 reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" >
										<rich:componentControl for="popupEditClaim" operation="hide" event="onclick" />
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
