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
						
						<a4j:commandButton id="btnCancel9"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage9 && !semmel006Bean.fromAction}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBack_update" value="Back" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent" 
								rendered="#{semmel006Bean.comeFromPage8 && !semmel006Bean.fromAction}"
								>
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL008"/>
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBack_update2" value="Back" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent" 
								rendered="#{semmel006Bean.fromAction}"
								>
							<a4j:actionparam name="navModule" value="#{semmel006Bean.navModuleFrom}" />
	            			<a4j:actionparam name="navProgram" value="#{semmel006Bean.navProgramFrom}" />	
							<a4j:actionparam name="moduleWithNavi" value="#{semmel006Bean.navModuleFrom}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmel006Bean.actionWithNaviFrom}" />
							<a4j:actionparam name="methodWithNavi" value="doBack" />
						</a4j:commandButton>
						
	           		</td>
	           		<td>

						
						<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
						action="#{navAction.navi}"  
						disabled="#{semmel006Bean.viewMode}" 
						reRender="oppContent,pnlPaymentList,frmPaymentEL7"   
						rendered="#{!semmel006Bean.comeFromPage8}"
					    >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSave7" />
						</a4j:commandButton>							
						
						<a4j:commandButton id="btnUpdate" value="Save" styleClass="rich-button" 
						action="#{navAction.navi}"  
						disabled="#{semmel006Bean.viewMode}" 
						reRender="oppContent,pnlPaymentList,frmPaymentEL7"
						rendered="#{semmel006Bean.comeFromPage8}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doUpdate7" />
						</a4j:commandButton>
	           		</td>	           		
	           		<td>
						<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
						action="#{navAction.navi}"  
						reRender="oppContent,paymentELtmpInfo,frmPaymentEL7"   
						disabled="#{semmel006Bean.disablePage7}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
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
				<h:panelGrid width="90%">
					<rich:panel id="contractInfo7">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">							
									<tr>
										<td align="right" width="25%">											
										</td>
										<td width="25%">											
				                		<a4j:commandButton id="btnPopupSearchSite7" disabled="#{semmel006Bean.viewMode}"  
				                		oncomplete="#{rich:component('popupSearchSite7')}.show(); return false"
										value="#{jspMsg['btn.searchSite']}" styleClass="rich-button"  
										reRender="oppContent,popupFrmSearch7" 
										rendered="#{semmel006Bean.renderPage7}"
					            		action="#{navAction.navi}" style="width:150px;">
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
			
	<!-- Start Pay-In Info -->
				<h:panelGrid width="90%">
					<rich:panel id="payinInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.payinInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
								
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.payIn']}" styleClass="ms7" />
									</td>
									<td width="25%">
										<h:selectBooleanCheckbox id="crPayInFlag" value="#{semmel006Bean.payment.crPayInFlagBoolean}" 
										onclick="doChangePayInFlage();"  styleClass="ms7"/>	                		 									
 										<a4j:jsFunction name="doChangePayInFlage" reRender="payinInfo" 
 										action="#{semmel006Action.doChangePayInFlage}"/>
									
									
									</td>
									<td align="right" width="25%">
										
									</td>
									<td width="25%">
										
									</td>
								</tr>						
								
								<tr>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif" rendered="false"/>
										<h:outputText value="#{jspMsg['label.crPayinChqNo']}" styleClass="ms7" />
									</td>
									<td width="25%">
									<h:inputText   value="#{semmel006Bean.payment.crPayinChqNo}"  
									disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}" style="width:120px;"></h:inputText>
									</td>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"  
										rendered="#{semmel006Bean.payment.crPayInFlagBoolean}"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.crPayinAmt']}" styleClass="ms7"/>
									</td>
									<td width="25%">
										<h:inputText id="txtInvTotalIncludeVatCR" value="#{semmel006Bean.payment.crPayinAmt}"		
										 disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}" 						 
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
										onblur="return numberformat.moneyFormat(this);"
										onfocus="return numberformat.setCursorPosToEnd(this);"
										size="18" 
										maxlength="18"
										styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:inputText> 
									</td>	
								</tr>		
								<tr>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif" 
										rendered="#{semmel006Bean.payment.crPayInFlagBoolean}"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.crBankName']}" styleClass="ms7" />
									</td>
									<td width="25%">
										<h:selectOneMenu   value="#{semmel006Bean.payment.crBankName}"  rendered="flase"
										disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}"  style="width:120px;">
											<f:selectItems value="#{semmel006Bean.crBankNameList}"/>
										</h:selectOneMenu>
										<h:inputText   value="#{semmel006Bean.payment.crBankName}"   
										disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}" style="width:120px;"></h:inputText>
										
									</td>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.crBankNo']}" styleClass="ms7" />
									</td>
									<td width="25%">
										<h:inputText   value="#{semmel006Bean.payment.crBankNo}"   
										disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}" style="width:120px;"></h:inputText>
									</td>
								</tr>
			
								<tr>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif" rendered="#{semmel006Bean.payment.crPayInFlagBoolean}"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.crPayinDt']}" styleClass="ms7" />
									</td>
									<td width="25%">
										<rich:calendar id="crPayinDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy"
										 disabled="#{!semmel006Bean.payment.crPayInFlagBoolean}"  
			                			 value="#{semmel006Bean.payment.crPayInDt}" inputSize="18"
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
			
									</td>
									<td align="right" width="25%">
										 
									</td>
									<td width="25%">
										 
									</td>
								</tr>
								</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Pay-In Info -->				

	
	<!-- Start Return Info -->
				<h:panelGrid width="90%">
					<rich:panel id="payment7Info">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.returnInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%" border ="0">	
								<tr>
									<td align="right" width="25%" >
										<h:outputText value="#{jspMsg['label.checkChqDetail']}" styleClass="ms7" rendered="false"/>
									</td>
									<td width="25%">
										<h:selectBooleanCheckbox id="crCreditFlag" value="#{semmel006Bean.payment.crCreditFlagBoolean}"  
										onclick="doChangeCreditFlag();"  styleClass="ms7" rendered="false"/>	                		 									
										<a4j:jsFunction name="doChangeCreditFlag" reRender="payment7Info"  
										action="#{semmel006Action.doChangeCreditFlag}"/>
															
									</td>
									<td align="right" width="25%">
										
									</td>
									<td width="25%">
										
									</td>
								</tr>														
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" 
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
										</td>
										<td width="20%">
											<h:outputText value="#{semmel006Bean.payment.expenseTypeDisplay}" styleClass="ms7" />
										</td>			
																
										<td align="right" width="25%">	
											<h:graphicImage value="images/icon_required.gif" 
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>										
											<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="docTypeId"  value="#{semmel006Bean.payment.docType}" 
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"  style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elDocTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>	
									
									<tr>
										<td align="right" width="25%">		
											<h:graphicImage value="images/icon_required.gif" 
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.payment.docNo}" 
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}" style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">		
											<h:graphicImage value="images/icon_required.gif" 
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											 disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}" 
				                			 value="#{semmel006Bean.payment.docDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>										
									</tr>	
									
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" 
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>	
											 
											<h:outputText value="#{jspMsg['label.refDocNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.refDocNo}" style="width:120px;"  
											disabled="#{true}"></h:inputText>
					                		<rich:spacer width="5"/>	
					                		<a4j:commandButton id="btnPopupSearchOldDoc7"  
					                		oncomplete="#{rich:component('popupSearchOldDoc7')}.show(); return false"
											value="#{jspMsg['btn.searchOldDoc']}" styleClass="rich-button" 
											reRender="oppContent,popupOldDocFrmSearch7"
						            		action="#{navAction.navi}" style="width:150px;" 
						            		rendered="#{semmel006Bean.renderPage7}" 
						            		disabled="#{!semmel006Bean.payment.crCreditFlagBoolean || 
						            		          (semmel006Bean.popupSiteSearch7.company == null ||  semmel006Bean.popupSiteSearch7.company ==''
						            		          ||(semmel006Bean.popupSiteSearch7.electricUseTypeDisplay == null|| semmel006Bean.popupSiteSearch7.electricUseTypeDisplay == ''))}" >
						            		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006" />
											<a4j:actionparam name="moduleWithNavi" value="el" />	
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
											<a4j:actionparam name="methodWithNavi" value="initPopupSearchOldDoc7" />
				            				</a4j:commandButton>											
										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" 
											rendered="false"/><rich:spacer width="5"/>	
											<h:outputText value="#{jspMsg['label.refDocDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
										<h:inputText value="#{semmel006Bean.payment.refDocDtTH}"   disabled="#{true}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:inputText>
										</td>										
									</tr>
										<tr>
										<td>
										<h:graphicImage value="images/icon_required.gif" 
											rendered="false"/><rich:spacer width="5"/>	
											<h:outputText value="#{jspMsg['label.merterId']}" styleClass="ms7" rendered="false"/>
										</td>
										<td>
										<h:inputText value="#{semmel006Bean.paymentDetail.meterId}"   
										disabled="#{true}" rendered="false">
										</h:inputText>
										</td>
										
										<td>
										
										</td>
										<td>
										</td>							
																									
									</tr>
									<tr>
										<td align="right" width="15%">							
											<h:graphicImage value="images/icon_required.gif"  
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>				
											<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7"/>
										</td>
										<td width="20%">											
											<h:inputText id="txtPayAmt" value="#{semmel006Bean.payment.payAmt}"
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doCulateCRVatAmtPage7();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
																			
											<a4j:jsFunction name="doCulateCRVatAmtPage7" 
											reRender="frmError,payment7Info,pnlPaymentList" 
											action="#{semmel006Action.doCulateCRVatAmtPage7}"/>                     
								
											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											
											
										</td>
										<td align="right" width="20%">		
											<h:graphicImage value="images/icon_required.gif"  
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
										</td>

										<td width="45%">	
												<h:selectOneRadio value="#{semmel006Bean.payment.vatType}" 
												disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}" 
												onclick="doCulateCRVatAmtPage7();" 
												styleClass="ms7" rendered="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />		
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />				                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>											
											
										</td>
									</tr>	
									
									
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"  
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="35%">							
				
											<h:inputText value="#{semmel006Bean.payment.excludeVatAmt}"  
											styleClass="inputRight" disabled="true">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>                       
												<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>

										</td>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"  
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
							
											<h:inputText id="txtVatAmt" value="#{semmel006Bean.payment.vatAmt}"
											
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												onchange="doChangeVatAmtPage65();" 
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											<a4j:jsFunction name="doChangeVatAmt5" reRender="frmError,expenseDetail" 
											action="#{semmel006Action.doChangeVatAmt5}"/>
											<a4j:jsFunction name="doChangeVatAmtPage65" reRender="frmError,expenseDetail" 
											action="#{semmel006Action.doChangeVatAmtPage65}"/>                      
											
										</td>
									</tr>	
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"  
											rendered="#{semmel006Bean.payment.crCreditFlagBoolean}"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="35%">
											<h:inputText id="txtIncludeVatAmt" value="#{semmel006Bean.payment.includeVatAmt}"	
											disabled="true"						
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText >											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td>
										<td width="25%">
				                			 <h:inputTextarea id="textAreaRemark" value="#{semmel006Bean.payment.remark}" 
				                			 disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"  cols="40" rows="3" />				                		
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" 
											rendered="false"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7" rendered="false"/>
										</td>
										<td width="25%">
											<h:inputText id="vendorIdDisplay" value="#{semmel006Bean.payment.vendorId}" rendered="false"
										
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}" styleClass="ms7"/>
											<rich:spacer width="5"/>

										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" 
											rendered="false" /><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7" rendered="false"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.payment.vendorName}"  rendered="false"
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"  styleClass="ms7"/>	
										</td>
									</tr>																																								
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeId']}" styleClass="ms7" rendered="false"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.payeeId}"  
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}"  styleClass="ms7" rendered="false"/>										
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7" rendered="false"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.payeeName}"   
											disabled="#{!semmel006Bean.payment.crCreditFlagBoolean}" styleClass="ms7" rendered="false"/>
										</td>
									</tr>	
								
																																								
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Return Info -->		

		<h:panelGrid columnClasses="gridContent" width="90%">
			<h:panelGroup>
				<table width="90%">

							
				</table>
			</h:panelGroup>
		</h:panelGrid>
	<!--  Start Payment Model List  -->
	
							
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlPaymentList" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.returnList']}"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentList" width="100%" cellpadding="0" cellspacing="0" border="0" 
							var="paymentDetail"  rowKeyVar="rowIndex" value="#{semmel006Bean.paymentDetailList}" 
							reRender="dtbPaymentList" 	rowClasses="cur" styleClass="dataTable">

							
							

							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.delete']}"  styleClass="contentform"  
									rendered="#{semmel006Bean.renderPage7}"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            										disabled="#{semmel006Bean.viewMode}"
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="paymentDetail,pnlNoPaymentSite,btnExport,popupFrmError" 
	            									   image="images/delete.png" style="height: 15; width: 15"
	            									   rendered="#{semmel006Bean.renderPage7}">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initDeletePaymentDetailPage7" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>
	            					</a4j:commandButton>          							
								</div>									
							</rich:column>

							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.meterId}"/>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.refMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.referMeterId}"/>
								</div>
							</rich:column>
																		
							<rich:column rendered="flase">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.termOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.termOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column rendered="true">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricFrom']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.fromTermOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column rendered="true">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricTo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.toTermOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invIncludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.includeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.vatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>										
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invExcludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.excludeVatAmt}" >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>										
							

							<rich:column rendered="false">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.crPayinChqNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<h:outputText value="#{semmel006Bean.payment.crPayinChqNo} "/>
								</div>
							</rich:column>	
							
							<rich:column rendered="false">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<h:outputText value="#{semmel006Bean.payment.crBankName}" />
								</div>
							</rich:column>	
							
							<rich:column rendered="false">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.accNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<h:outputText value=" #{semmel006Bean.payment.crBankNo}"/>
								</div>
							</rich:column>								
							<rich:column rendered="false">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<h:outputText value="#{semmel006Bean.payment.remark} "/>
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
											<h:outputText value="#{semmel006Bean.payment.createDt}" styleClass="ms7">
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
											<h:outputText   value="#{semmel006Bean.payment.updateDt}" styleClass="ms7">
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
		<jsp:include page="../../pages/el/semmel006-popupSearchSite_7.jsp" />
		<jsp:include page="../../pages/el/semmel006-popupOldDoc7.jsp" />		
	 
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



