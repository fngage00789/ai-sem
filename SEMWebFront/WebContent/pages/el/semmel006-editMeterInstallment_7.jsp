<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupUpdatemeterInstallment7" width="950" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.updateMeterInstalment.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
		    <h:graphicImage value="images/ico_close.png" 
		    id="updatemeterInstallment7" style="cursor:pointer"/>
			<rich:componentControl for="popupUpdatemeterInstallment7" 
			attachTo="updatemeterInstallment7" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmErrorEditInstallment7">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>	
		
	<h:form id="popupFrmEditInstallment7"> 	
		<rich:panel>
				<table border="0">	
					
					<tr>
										<td align="right" >		
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.company}" styleClass="ms7"/>
										</td>	
										<td align="right" >											
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.oldContractNo}" styleClass="ms7"/>
										</td>																				
									</tr>																					
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractNo}" styleClass="ms7"/>
										</td>	
										<td align="right" >											
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.electricUseTypeDisplay}" styleClass="ms7"/>
										</td>																				
									</tr>																														
									<tr>
										<td align="right">											
											<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractStartDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>	
										<td align="right" >										
											<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractEndDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>																				
									</tr>	
					<tr>
						<td align="right">
							<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
						</td>
						<td>
							<h:outputText value="#{semmel006Bean.installmentEdit.meterId}" styleClass="ms7" />
						</td>
						<td align="right">
							<h:outputText value="#{jspMsg['label.refMerterId']}" styleClass="ms7" >
							
							</h:outputText>
               			</td>
               			<td>
               				<h:outputText value="#{semmel006Bean.installmentEdit.refMeterId}" styleClass="ms7" />
	                	</td>
					</tr>				
					<tr>
						<td align="right">
							<h:outputText value="#{jspMsg['label.termOfPayment']}" styleClass="ms7" />
						</td>
						<td>
							<h:outputText value="#{semmel006Bean.installmentEdit.termOfPaymentDt}" styleClass="ms7">
							<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
							</h:outputText>
							
						</td>
						<td align="right" >
							
               			</td>
               			<td>
               				
	                	</td>
					</tr>				
					
					<tr>
						<td align="right" >
							
							<rich:spacer width="5"/>	
							<h:outputText value="#{jspMsg['label.pDate']}" styleClass="ms7"/>
						</td>
						<td >
							<rich:calendar  showWeeksBar="false" locale="th/TH"  
							disabled="#{semmel006Bean.viewMode}" 
							enableManualInput="true" datePattern="dd/MM/yyyy" 
				            value="#{semmel006Bean.installmentEdit.pDate}" inputSize="18" 
				            oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
					 </td>	
					<td align="right" >
						
						<rich:spacer width="5"/>	
						<h:outputText value="#{jspMsg['label.lDate']}" styleClass="ms7"/>
					</td>
					<td>
						<rich:calendar showWeeksBar="false" locale="th/TH"  disabled="#{semmel006Bean.viewMode}" 
						enableManualInput="true" datePattern="dd/MM/yyyy" 
				        value="#{semmel006Bean.installmentEdit.lDate}" inputSize="18" 
				        oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
					</td>											
					</tr>			
					<tr>
										<td align="right" >											
											
									         <rich:spacer width="5"/>	
						
											<h:outputText value="#{jspMsg['label.pRead']}" styleClass="ms7"/>
										</td>
										<td width="35%">
												<h:inputText value="#{semmel006Bean.installmentEdit.pRaed}"
												id ="inputPRead"	
												disabled="#{semmel006Bean.viewMode}" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												styleClass="inputRight"></h:inputText>
										</td>
										<td align="right" >											
											
											<rich:spacer width="5"/>	
						
											<h:outputText value="#{jspMsg['label.lRead']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.installmentEdit.lRaed}"	
											id ="inputLRead"
											disabled="#{semmel006Bean.viewMode}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											styleClass="inputRight">
											</h:inputText>
											
												                			 
										</td>
									</tr>
								<tr>
										<td align="right">											
											
											<rich:spacer width="5"/>	
						
											<h:outputText value="#{jspMsg['label.kwhTotal']}" styleClass="ms7"/>
										</td>
										<td >
											<h:inputText value="#{semmel006Bean.installmentEdit.kwh}" 
											id ="inputKwhTotal"
											disabled="#{semmel006Bean.viewMode}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											styleClass="inputRight"></h:inputText>
										</td>
										<td align="right">
											
										</td>

										<td >							
																				
																					
										</td>
									</tr>		
	           	 	 
	           	 					 <tr>
										<td align="right" width="20%">							
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>				
											<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7"/>
										</td>
										<td >											
											<h:inputText id="txtPayAmt" value="#{semmel006Bean.installmentEdit.payAmt}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doCulateVATEditInstallment();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
																			
											<a4j:jsFunction name="doCulateVATEditInstallment" 
											reRender="frmError,popupFrmEditInstallment7" 
											action="#{semmel006Action.docalCulateVATEditInstallment}"/>                     
								
											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											
											
										</td>
										<td align="right" >		
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
										</td>

										<td width="30%">	
												<h:selectOneRadio value="#{semmel006Bean.installmentEdit.vatType}" 
												disabled="#{semmel006Bean.viewMode}" 
												onclick="doCulateVATEditInstallment();" 
												styleClass="ms7" rendered="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />		
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />				                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>											
											
										</td>
									</tr>	
                	                <tr>
										<td align="right" >
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td >							
				
											<h:inputText value="#{semmel006Bean.installmentEdit.exculdeVat}"  styleClass="inputRight" 
											disabled="false">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>                       
												<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>

										</td>
										<td align="right" >
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td>
							
											<h:inputText id="txtVatAmt" value="#{semmel006Bean.installmentEdit.vatAmt}"
											
											disabled="#{semmel006Bean.vatAmtDisable||semmel006Bean.viewMode}" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
											               
											
										</td>
									</tr>	
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td >
											<h:inputText id="txtIncludeVatAmt" value="#{semmel006Bean.installmentEdit.inculdeVat}"	
											disabled="false"						
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText >											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
										<td align="right">
											
										</td>
										<td>	
											
											
										</td>
									</tr>									
	           	 	 <tr>
                	 <td colspan="4">
                	 		<!-- end content criteria -->
					
					<h:panelGroup>					
						<a4j:commandButton id="btnPopupEdit7" value="Save" styleClass="rich-button"
					action="#{navAction.navi}" 
					reRender="popupFrmEditInstallment7,popupFrmSearch7,dtbPopupSite,pnlPopupSearchResult,popupFrmError7,pnlPaymentList,popupFrmErrorEditInstallment7" >
					<a4j:actionparam name="navModule" value="el" />
					<a4j:actionparam name="navProgram" value="SEMMEL006-7-1" />
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doUpdateMeterInstallment7" />
					</a4j:commandButton>
					<rich:spacer width="10"></rich:spacer>
					<a4j:commandButton id="btnBackEdit7" value="Back" styleClass="rich-button"
					action="#{navAction.navi}" 
					reRender="popupFrmEditInstallment7,popupFrmSearch7,dtbPopupSite,pnlPopupSearchResult,popupFrmError7,pnlPaymentList,pnlPaymentList,popupFrmErrorEditInstallment7" >
					<a4j:actionparam name="navModule" value="el" />
					<a4j:actionparam name="navProgram" value="SEMMEL006-7-1" />
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doBackMeterInstallment7" />
					</a4j:commandButton>
					<rich:spacer width="10"></rich:spacer>
					<rich:componentControl for="popupUpdatemeterInstallment7" attachTo="btnEditInstallmentCancel" operation="hide" event="onclick" />
					<rich:componentControl for="popupUpdatemeterInstallment7" attachTo="btnBackEdit7" operation="hide" event="onclick" />
					
					</h:panelGroup>
                	 </td>
                	 </tr>			                	
				</table>
			</rich:panel>
						
	</h:form>
</rich:modalPanel>

