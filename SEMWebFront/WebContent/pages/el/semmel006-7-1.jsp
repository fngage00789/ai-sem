<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.EL7']}"/> 
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="frmPaymentEL7">
		<h:panelGrid columnClasses="gridContent" width="90%">
			<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="50%" align="left">					
				</td>
				<td width="50%" align="right" valign="bottom">
					<table id="tblButton">
					<tr>
					<td>
						<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent" 
								rendered="#{!semmel006Bean.comeFromPage8 && !semmel006Bean.fromAction}"
								>
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL006-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
							<a4j:actionparam name="methodWithNavi" value="doBackSearchPage" />
						</a4j:commandButton>
					</td>
	           		<td>

						
						<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
						action="#{navAction.navi}"  
						disabled="#{semmel006Bean.viewMode}" 
						reRender="oppContent,pnlPaymentList,frmPaymentEL7"   
						rendered="flase"
					    >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSave7" />
						</a4j:commandButton>							
						
					</td>	           		
	           		<td>
						<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
						action="#{navAction.navi}"  
						reRender="oppContent,paymentELtmpInfo,frmPaymentEL7"   
						disabled="#{semmel006Bean.disablePage7}"
						>
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPayment7" />
						</a4j:commandButton>						
	           		</td>
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
		</h:panelGrid>		
		<!-- Start Contract Info -->
				<h:panelGrid width="95%">
					<rich:panel id="contractInfo7">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">							
									<tr>
										<td align="right" width="25%">											
										</td>
										<td width="25%">											
				                		<a4j:commandButton id="btnPopupSearchSite7" 
				                		disabled="#{semmel006Bean.viewMode}"  
				                		oncomplete="#{rich:component('popupSearchSite7')}.show(); return false"
										value="#{jspMsg['btn.searchSiteUpdateInstallment']}" styleClass="rich-button"  
										reRender="oppContent,popupFrmSearch7" 
										rendered="#{semmel006Bean.renderPage7}"
					            		action="#{navAction.navi}" style="width:250px;">
					            		<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006" />
										<a4j:actionparam name="moduleWithNavi" value="el" />	
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
										<a4j:actionparam name="methodWithNavi" value="doInitpopupSearchSite7" />
			            				</a4j:commandButton>			            					
										</td>	
										<td align="right" width="25%">									
										</td>
										<td width="25%">											
										</td>																				
									</tr>	
										<tr>
										<td align="right" width="25%">		
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.company}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.oldContractNo}" styleClass="ms7"/>
										</td>																				
									</tr>																					
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractNo}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.electricUseTypeDisplay}" styleClass="ms7"/>
										</td>																				
									</tr>																														
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractStartDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>	
										<td align="right" width="25%">										
											<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.contractEndDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.siteName}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.eAreaCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.areaName}" styleClass="ms7"/>
										</td>																				
									</tr>
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.siteStatusDisplay}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.networkStatusDisplay}" styleClass="ms7"/>
										</td>																				
									</tr>		
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.locationId}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteSearch7.locationCode}" styleClass="ms7"/>
										</td>																				
									</tr>											
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>			
	<!--  End Contract Info -->		
	  <!--  2.  Start Meter Detail -->
	  <h:panelGrid width="95%">
					<rich:panel id="meterDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="25%" align="left" colspan="3">
											<h:selectOneMenu id ="meterListId" value="#{semmel006Bean.popupSiteCriteria.meterId}"  
											disabled="#{semmel006Bean.meterIdDisable||semmel006Bean.viewMode}" 
											style="width:120px;">
												<f:selectItems value="#{semmel006Bean.meterIdList}"/>
												<a4j:support event="onchange" action="#{semmel006Action.doChangeMeterUpdateInstallment}" 
												reRender="meterDetail,expenseDetail"/>
											</h:selectOneMenu>
										</td>										
									</tr>	
										<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.refMeterId']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.meterInfo.referMeterId}" styleClass="ms7"/>
										</td>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.previousKhw']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.meterInfo.lastKWHTotal}" styleClass="ms7"  disabled="true"/>													
										</td>											
									</tr>	
										
										<tr>
										<td align="right" width="25%">
											
											<h:outputText value="#{jspMsg['label.pMeterStatus']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneRadio value="#{semmel006Bean.meterInfo.pMeterStatus}"  styleClass="ms7" disabled="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="ON" itemLabel="ON" />
					                				<f:selectItem itemValue="OFF" itemLabel="OFF" />					                				
					                		</h:selectOneRadio>		
										</td>		
																
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.pMeterVATType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneRadio value="#{semmel006Bean.meterInfo.lastUnitVatType}"  styleClass="ms7" disabled="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />				                				
					                		</h:selectOneRadio>		
										</td>											
									</tr>																						
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>	
						
		<!--  End Meter Detail -->		
	    	
	
	<!-- Search Installment -->
				<h:panelGrid width="95%">
					<rich:panel id="payment7Info">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.searchMeterInstallment']}"/>
						</f:facet>
						<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%" border ="0">	
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="35%">
											 <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/><rich:spacer width="3"/>									
											<h:selectOneMenu id="fromTermOfPaymentDtMonthId"  
											value="#{semmel006Bean.paymentDetail.fromTermOfPaymentMonth}"  
											disabled="#{semmel006Bean.viewMode || semmel006Bean.disableTermOfPaymentDtMonth ||semmel006Bean.editPrivateTermOfPayment}"  
											style="width:80px;">
											<f:selectItems value="#{semmel006Bean.monthList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doSetTermOfPayment}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId"
											/>
											</h:selectOneMenu>
											
											<rich:spacer width="3"/>
											<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/><rich:spacer width="3"/>
											<h:selectOneMenu id="fromTermOfPaymentDtYearId" 
											 value="#{semmel006Bean.paymentDetail.fromTermOfPaymentYear}"  
											 disabled="#{semmel006Bean.viewMode || semmel006Bean.disableTermOfPaymentDtYear ||semmel006Bean.editPrivateTermOfPayment}"  
											 style="width:80px;">
											<f:selectItems value="#{semmel006Bean.yearList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doSetTermOfPayment}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId"
											/>
											</h:selectOneMenu>
											
				                			 <rich:spacer width="5"/>
				                			 <rich:calendar  showWeeksBar="false" locale="th/TH" 
											enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 disabled="#{semmel006Bean.viewMode || semmel006Bean.disableFromTermOfPaymentDt||semmel006Bean.editPrivateTermOfPayment}"
				                			 id="paymentDtFrom"
				                			 value="#{semmel006Bean.paymentDetail.fromTermOfPaymentDt}" 
				                			 rendered="flase"
				                			 inputSize="18"
				                			 oncollapse="doChangeTermOfPaymentDate()"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 />
				                			 <a4j:jsFunction name="doChangeTermOfPaymentDate" 
				                			 reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,fromTermOfPaymentDtMonthId,fromTermOfPaymentDtYearId"
				                			 action="#{semmel006Action.doChangeTermOfPayment}"/>
				                			 
										</td>	
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											
				                			 <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/><rich:spacer width="3"/>									
											<h:selectOneMenu id="toTermOfPaymentDtMonthId"  
											value="#{semmel006Bean.paymentDetail.toTermOfPaymentMonth}"  
											disabled="#{semmel006Bean.viewMode || semmel006Bean.disableTermOfPaymentDtMonth ||semmel006Bean.editPrivateTermOfPayment}"  style="width:80px;">
												<f:selectItems value="#{semmel006Bean.monthList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doSetTermOfPayment}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId"
											/>
											</h:selectOneMenu><rich:spacer width="3"/>
											<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/><rich:spacer width="3"/>
											<h:selectOneMenu id="toTermOfPaymentDtYearId" 
											 value="#{semmel006Bean.paymentDetail.toTermOfPaymentYear}"  
											 disabled="#{semmel006Bean.viewMode || semmel006Bean.disableTermOfPaymentDtYear||semmel006Bean.editPrivateTermOfPayment}"  
											 style="width:80px;">
												<f:selectItems value="#{semmel006Bean.yearList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doSetTermOfPayment}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId"
											/>
											</h:selectOneMenu>
										<rich:spacer width="5"/>
										<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 disabled="#{semmel006Bean.viewMode || semmel006Bean.disableFromTermOfPaymentDt ||semmel006Bean.editPrivateTermOfPayment}"
				                			 id="paymentDtTo"
				                			 value="#{semmel006Bean.paymentDetail.toTermOfPaymentDt}" inputSize="18" 
				                			 rendered="flase"
				                			 oncollapse="doChangeTermOfPaymentDate()"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 />
										</td>											
								</tr>						
								
								<tr>	
								<td align="left" colspan=4">
								<a4j:commandButton id="btnSearch1" value="Search" styleClass="rich-button" 
										action="#{navAction.navi}"  
										disabled="#{semmel006Bean.viewMode}" 
										reRender="oppContent,pnlPaymentList,frmPaymentEL7,frmError"   
										
					    			>
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doSearchInstallment7" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnClear1" value="Clear" styleClass="rich-button" 
										action="#{navAction.navi}"  
										disabled="#{semmel006Bean.viewMode}" 
										reRender="oppContent,pnlPaymentList,frmPaymentEL7,payment7Info"   
										
					    			>
									<rich:spacer width="5"/>
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doClearSearchInstallment7" />
									</a4j:commandButton>								
							</td>
								
								
								</tr>	
									
								
																																								
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Installment -->	

		
	<!--  Start Payment Model List  -->
	
							
				<h:panelGrid style="width: 100%">
					<rich:panel id="pnlPaymentList" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.MeterInstallment']}"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentList" width="100%" cellpadding="0" cellspacing="0" border="0" 
							var="installment"  rowKeyVar="rowIndex" value="#{semmel006Bean.installmentSearch7lList}" 
							reRender="dtbPaymentList" 	rowClasses="cur" styleClass="dataTable">

							
							

							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.edit']}"  styleClass="contentform"  
									rendered="#{semmel006Bean.renderPage7}"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('popupUpdatemeterInstallment7')}.show(); return false" 
	            										disabled="#{semmel006Bean.viewMode}"
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="paymentDetail,pnlNoPaymentSite,popupFrmError,popupUpdatemeterInstallment7" 
	            									   image="images/edit.png" style="height: 15; width: 15"
	            									   rendered="#{semmel006Bean.renderPage7}">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initEditInstallmentPage7" />
										<a4j:actionparam name="rowIndex" value="#{installment.meterInstallmentID}"/>
	            					</a4j:commandButton>          							
								</div>									
							</rich:column>

							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.meterId}"/>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.refMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.refMeterId}"/>
								</div>
							</rich:column>
																		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.termOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.termOfPaymentDt}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column rendered="flase">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricFrom']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.fromTermOfPaymentDt}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column rendered="flase">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricTo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.toTermOfPaymentDt}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invIncludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.inculdeVat}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.exculdeVat}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.vatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>										
							
							
									
							<rich:column rendered="true">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.pDate']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.pDate}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column rendered="true">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.lDate']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.lDate}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.pRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.pRaed}">
									<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="0" />
									</h:outputText>
								</div>
							</rich:column>				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.lRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.lRaed}">
									<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="0" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.kwhTotal']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{installment.kwh}">
									<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="0" />
									</h:outputText>
								</div>
							</rich:column>											
																
						</rich:dataTable>
						<!-- end dataTable -->						
					</rich:panel>					
				</h:panelGrid>
				<!-- end content layout data grid -->
	<!--  End Payment Model List -->	
	
		<!--  Start Footer -->
				<h:panelGrid  width="90%">
				<rich:panel id="ELTmpFooter">
					<h:panelGroup>
						<table width="90%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText  value="#{semmel006Bean.payment.createBy}" styleClass="ms7"></h:outputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.displayCreateDate}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText   value="#{semmel006Bean.payment.updateBy}" styleClass="ms7">											
											</h:outputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText   value="#{semmel006Bean.payment.displayUpdateDate}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>											
						</table>
					</h:panelGroup>
					</rich:panel>
				</h:panelGrid>	
		
		<!--  End Footer -->			
			
		</a4j:form>
		<jsp:include page="../../pages/el/semmel006-popupSearchSite_7-2.jsp" />
		<jsp:include page="../../pages/el/semmel006-editMeterInstallment_7.jsp" />		
	 
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirmed Message"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel006Bean.popupDelMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="pnlPaymentList,payment7Info">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doDeletePaymentDetailPage7" />
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="mdpConfirmEditDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirmed Message"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmEditDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="oppContent,expenseDetail,paymentELtmpInfo,frmAddPaymentELPostpaid">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doUPdatePaymentDetailFromModel" />
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="mdpUpdateInstallment" autosized="true">
	<f:facet name="header">
		<h:outputText value="Update Meter Installment"></h:outputText>
	</f:facet>
	<a4j:form id="frmEditInstallmentDialog">
		<table width="850px" border="2" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="4">
					
				</td>
			</tr>
			<tr>
				<td>
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</td>
				<td>
					<h:inputText value="#{semmel006Bean.installmentEdit.meterId}" styleClass="ms7"  disabled="true"/>
				</td>
				<td>
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</td>
				<td>
					<h:inputText value="#{semmel006Bean.installmentEdit.refMeterId}" styleClass="ms7"  disabled="true"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</td>
				<td>
					<h:inputText value="#{semmel006Bean.installmentEdit.meterId}" styleClass="ms7"  disabled="true"/>
				</td>
				<td>
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</td>
				<td>
					<h:inputText value="#{semmel006Bean.installmentEdit.refMeterId}" styleClass="ms7"  disabled="true"/>
				</td>
			</tr>
			
			
			
			<tr>
				<td><h:panelGrid columns="4" styleClass="contentlabelform">
					<a4j:commandButton value="Save" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="oppContent,expenseDetail,paymentELtmpInfo,frmAddPaymentELPostpaid">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doUPdatePaymentDetailFromModel" />
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="Back" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpUpdateInstallment" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>