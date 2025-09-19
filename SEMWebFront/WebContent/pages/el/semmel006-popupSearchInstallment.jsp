<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchInstallment" width="350" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.popup.installment.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
		    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchInstallment" style="cursor:pointer"/>
			<rich:componentControl for="popupSearchInstallment" attachTo="hidepopupSearchInstallment" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmInstallmentError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>	
		
	<h:form id="popupFrmInstallmentSearch"> 				
				<h:panelGrid  id="grdPopupSearchInstallmentResult">
					<rich:panel id="pnlPopupSearchInstallmentResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.installment.tableheadername']}" />
						</f:facet>						
						
						<rich:dataTable id="dtbPopupInstallment" width="95%"
						value="#{semmel006Bean.privatePrepaidResult}" rows="10" 
						rowKeyVar="RegInd" var="installment" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						styleClass="contentform">		
						
						
							<rich:column id="siteCheck" width="50">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel006Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" 
										action="#{semmel006Action.selectAllRowPRPrepaid}" 
										reRender="pnlPopupSearchInstallmentResult,dtbPopupInstallment" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox disabled="#{installment.paidFlag=='Y'}"	
									id="installmentSelected" value="#{installment.selected}">
									<a4j:support event="onclick" reRender="dtbPopupInstallment,installmentSelected"></a4j:support>										
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>						

						
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.groupNo']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{installment.periodNo}" styleClass="contentform"  />
							</div>
						</rich:column>							
						 					
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.dueDt']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{installment.dueDtTH}" styleClass="contentform"  >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
							</div>
						</rich:column>											
						
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.fromTermOfPayment']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{installment.fromTermOfPaymentDtTH}" styleClass="contentform"  >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
							</div>
						</rich:column>					
						
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.toTermOfPayment']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{installment.toTermOfPaymentDtTH}" styleClass="contentform"  >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
							</div>
						</rich:column>					
						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.popup.installment.periodAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{installment.periodAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
						</rich:column>





						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.popup.installment.vatAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{installment.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
						</rich:column>
						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.popup.installment.excludeVatAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{installment.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
						</rich:column>
						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.popup.installment.includeVatAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{installment.includeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
						</rich:column>
						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.popup.installment.chqAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{installment.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
						</rich:column>
																														
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupInstallment" 
									maxPages="10" id="dstPopupInstallment" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				<h:panelGrid columns="2">
				<a4j:commandButton  id="btnInstallmentAddBySelect" styleClass="rich-button" 
									action="#{navAction.navi}" 
									value="Save" 
									reRender="contractInfo,expenseDetail,frmAddPaymentPRPrepaid,pnlPaymentList"  >
					<a4j:actionparam name="navModule" value="el" />
           			<a4j:actionparam name="navProgram" value="SEMMEL006-6" />	
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doAddInstallment" />	
					
				</a4j:commandButton>
				<a4j:commandButton id="btnSearchInstallmentCancel" styleClass="rich-button" value="Cancel"/>
				<rich:componentControl for="popupSearchInstallment" attachTo="btnSearchInstallmentCancel,btnInstallmentAddBySelect" operation="hide" event="onclick" />
			</h:panelGrid>							
		</h:panelGrid>			
	</h:form>
</rich:modalPanel>

