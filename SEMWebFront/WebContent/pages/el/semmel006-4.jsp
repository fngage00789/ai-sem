<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="../../pages/popup/vendorSupplier-popup.jsp" />
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.ELTemp']}"/> 
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="frmAddPaymentELTemp">
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
								rendered="#{!semmel006Bean.comeFromPage8 && !semmel006Bean.comeFromPage9}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL006-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
							<a4j:actionparam name="methodWithNavi" value="doBackSearchPage" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancel2"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage8}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancel9"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage9}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
	           		</td>
	           		<td>

						
						<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
						action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode}" reRender="oppContent,pnlPaymentList,frmAddPaymentELTemp"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSaveELTmp" />
						</a4j:commandButton>							
						
						
	           		</td>	           		
	           		<td> 
						<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
						action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode || semmel006Bean.comeFromPage8}" reRender="oppContent,paymentELtmpInfo,frmAddPaymentELTemp"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentELTemporary" />
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
					<rich:panel id="contractInfoELtmp">
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
				                		<a4j:commandButton id="btnPopupSearchSiteELTmp" disabled="#{semmel006Bean.viewMode}"  
				                		oncomplete="#{rich:component('popupSearchSiteELTmp')}.show(); return false"
										value="#{jspMsg['btn.searchSite']}" styleClass="rich-button"  
										reRender="oppContent,paymentELtmpInfo,popupFrmSearchELTmp,popupFrmSearchELTmp"
					            		action="#{navAction.navi}" style="width:150px;">
					            		<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006" />
										<a4j:actionparam name="moduleWithNavi" value="el" />	
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
										<a4j:actionparam name="methodWithNavi" value="initPopupSearchSiteELTmp" />
			            				</a4j:commandButton>			            					
										</td>	
										<td align="right" width="25%">									
										</td>
										<td width="25%">											
										</td>																				
									</tr>	
										<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.company}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.oldContractNo}" styleClass="ms7"/>
										</td>																				
									</tr>																					
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<a4j:commandLink id="hypPopApproveType" value= "#{semmel006Bean.popupSiteCriteria.contractNo}" 
												oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
												 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod" 
												 rendered="true">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="#{semmel006Bean.pageFrom}" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
												<a4j:actionparam name="methodWithNavi" value="initPopup" />
												<a4j:actionparam name="sIdHistory" value="#{semmel006Bean.popupSiteCriteria.siteInfoId}"  />
											</a4j:commandLink>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.electricUseTypeDisplay}" styleClass="ms7"/>
										</td>																				
									</tr>																														
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.contractStartDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>	
										<td align="right" width="25%">										
											<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.contractEndDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.siteName}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.eAreaCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.eAreaCode}" styleClass="ms7"/>
										</td>																				
									</tr>
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.siteStatusDisplay}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="#{semmel006Bean.styleClassName}"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.networkStatusDisplay}" styleClass="#{semmel006Bean.styleClassName}"/>
										</td>																				
									</tr>		
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.locationId}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.locationCode}" styleClass="ms7"/>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.meterId}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.eOnMeterDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.eOnMeterDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>																				
									</tr>														
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>			
	<!--  End Contract Info -->		
			
	<!-- Start Expense Info -->
				<h:panelGrid width="90%">
					<rich:panel id="paymentELtmpInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseInfo']}"/>
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
											<a4j:commandButton id="btnViewExpenseHis" value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
											 oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
											  disabled="#{semmel006Bean.viewMode || semmel006Bean.disableViewExpenseHisButton}"
											 reRender="frmPaymentHistList,frmErrorPopup"
											action="#{semmel006Action.paymentHistPopupInterface}">
											</a4j:commandButton>
											<rich:spacer width="5"/>											
											<a4j:commandButton id="btnViewMeterInfo"  
											value="#{jspMsg['btn.btnViewMeterInfo']}" styleClass="rich-button"  reRender="oppContent"
											 disabled="#{semmel006Bean.viewMode || semmel006Bean.disableViewMeterInfoButton}"
						            		action="#{navAction.navi}" style="width:150px;">
						            		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
											<a4j:actionparam name="moduleWithNavi" value="el" />	
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001"/>									
											<a4j:actionparam name="methodWithNavi" value="doView13" />
											<a4j:actionparam name="manageRowId" value="#{semmel006Bean.popupSiteCriteria.electricId}"/>	
											<a4j:actionparam name="manageContractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}"/>
											<a4j:actionparam name="fromPage" value="SEMMEL006-4"/>	
				            				</a4j:commandButton>		
										</td>	
										<td>
										</td>											
										<td align="right" width="25%">												
										</td>
										<td width="25%">											
										</td>																				
									</tr>								
							
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.expenseTypeDisplay}" styleClass="ms7" />											
										</td>																	
										<td align="right" width="25%">
											
											<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
										</td>
										<td width="25%">										
											<h:selectOneMenu  value="#{semmel006Bean.payment.docType}" disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"  style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elDocTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>	
									<tr>
										<td align="right" width="25%">
										
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.payment.docNo}"  disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"  style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">
										
											<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" 
				                			 value="#{semmel006Bean.payment.docDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>										
									</tr>	
									<tr>
										<td align="right" width="25%"><h:outputText value="#{jspMsg['label.vendorType']}" styleClass="ms7"/></td>
										<td colspan="3">
											<h:selectOneRadio value="#{semmel006Bean.payment.vendorType}" id="vendorTypeId" disabled="#{semmel006Bean.viewMode||semmel006Bean.disableMoreThanOneDetail || semmel006Bean.disableVendorTypeButton}"
												 styleClass="ms7" rendered="true"
												 onclick="doClickVendorType();"
							                layout="lineDirection">
					                				<f:selectItems value="#{semmel006Bean.vendorTypeList}"/>
					                		</h:selectOneRadio>
					                		<a4j:jsFunction name="doClickVendorType" reRender="expenseDetail, paymentELtmpInfo" action="#{semmel006Action.doClickVendorType}"/>
										</td>
									</tr>												
									<tr>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7" rendered="#{semmel006Bean.payment.vendorType=='V'}"/>
											<h:outputText value="#{jspMsg['label.supplier']}" styleClass="ms7" rendered="#{semmel006Bean.payment.vendorType=='S'}"/>
										</td>
										<td width="25%">
											<h:outputLabel id="vendorIdDisplay" value="#{semmel006Bean.payment.vendorId}" styleClass="ms7"/>
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnVendorMaster" value="#{jspMsg['label.vendorMaster']}" styleClass="rich-button" 
						            		action="#{navAction.navi}" reRender="oppContent" style="width:100" rendered="#{semmel006Bean.payment.vendorType=='V'}"
						            		disabled="#{semmel006Bean.disableMoreThanOneDetail || semmel006Bean.disableVendorTypeButton}">
											    <a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
												<a4j:actionparam name="contractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}" />
												
												<a4j:actionparam name="navModuleFrom" value="el" />
												<a4j:actionparam name="navProgramFrom" value="SEMMEL006-4" />
												<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL006" />
											</a4j:commandButton>
											<a4j:commandButton id="btnSupplier" value="#{jspMsg['btn.supplier']}" styleClass="rich-button" 
											oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
											reRender="popupVendorSupplier" disabled="#{semmel006Bean.disableMoreThanOneDetail || semmel006Bean.disableVendorTypeButton}"
						            		action="#{navAction.navi}" style="width:100" rendered="#{semmel006Bean.payment.vendorType=='S'}">
											    <a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
												<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
												<a4j:actionparam name="popupType" value="SUPPLIER" />
												<a4j:actionparam name="page" value="semmel006" />
											</a4j:commandButton>
										</td>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="vendorNameDisplay" value="#{semmel006Bean.payment.vendorName}" styleClass="ms7"/>	
										</td>
									</tr>																																								
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="payeeIdDisplay" value="#{semmel006Bean.payment.payeeId}" styleClass="ms7"/>										
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="payeeNameDisplay" value="#{semmel006Bean.payment.payeeName}" styleClass="ms7"/>
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											
											<h:selectOneMenu  value="#{semmel006Bean.payment.paymentType}" disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"  onchange="changePaymentTypeELPostpaid();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentTypeList}"/>
											</h:selectOneMenu>	
											<a4j:jsFunction name="changePaymentTypeELPostpaid" reRender="frmError,payment,paymentELtmpInfo" action="#{semmel006Action.changePaymentTypeELPostpaid}"/>
																								
											
										</td>									
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu value="#{semmel006Bean.payment.paymentMethod}"  disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.paymentMethodDisable||semmel006Bean.viewMode}" onchange="changePaymentMethodELPostpaid();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentMethodList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="changePaymentMethodELPostpaid" reRender="frmError,payment,paymentELtmpInfo" action="#{semmel006Action.changePaymentMethodELPostpaid}"/>
										</td>											
									</tr>										
									<tr>
										<td align="right" width="25%">						
											<c:if test="${semmel006Bean.bankNameMandatory eq 'true'}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>											
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="bankNameDisplay" value="#{semmel006Bean.payment.bankName}" styleClass="ms7"/>
										</td>
										<td align="right" width="25%">										
											<c:if test="${semmel006Bean.bankAccountMandatory eq 'true'}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>												
											<h:outputText value="#{jspMsg['label.bankAccount']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="bankAccountDisplay" value="#{semmel006Bean.payment.bankAccount}" styleClass="ms7"/>
										</td>
									</tr>									
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqPostingDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldchqPostingDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											
				                			 value="#{semmel006Bean.payment.chqPostingDt}" inputSize="18" disabled="#{semmel006Bean.chqPostingDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 oninputblur="validateCalendarFromToWithPaymentType('frmAddPaymentELTemp','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
									 		 oncollapse="validateCalendarFromToWithPaymentType('frmAddPaymentELTemp','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
				                			 />
										  
										  <a4j:jsFunction name="doChangehqPostDate" 
				                			 reRender="cldchqReceivedDt"
				                			 action="#{semmel006Action.doChangehqPostDate}"/>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqReceivedDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldchqReceivedDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.chqReceivedDt}" inputSize="18" disabled="#{semmel006Bean.chqReceivedDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
									</tr>										

									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldtransferDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.transferDt}" inputSize="18" disabled="#{semmel006Bean.transferDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										
										</td>
										<td align="right" width="25%">
											<h:graphicImage id= "remarkRequire" value="images/icon_required.gif" 
											rendered="#{!semmel006Bean.byPassValidationELTempTermOfPayment}"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td>
										<td width="25%">
				                			 <h:inputTextarea id="textAreaRemark" value="#{semmel006Bean.payment.remark}" disabled="#{semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"  cols="40" rows="3" />
				                		
										</td>
									</tr>		 																																
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Expense Info -->				
		<!-- Start Expense Detail -->
			
				<h:panelGrid width="90%">
					<rich:panel id="expenseDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.validateELPostPaid']}" styleClass="ms7" />
									</td>
									<td width="25%">
										<h:selectBooleanCheckbox id="crValidateELPostPaidTemp" 
										value="#{semmel006Bean.byPassValidationELTempTermOfPayment}" 
										styleClass="ms7"
										 onclick="doChangeValidateELTemp();" 
										/>	                		 									
 										<a4j:jsFunction name="doChangeValidateELTemp" 
 										reRender="paymentELtmpInfo" 
 										/>
									</td>
									<td align="right" width="25%">
										
									</td>
									<td width="25%">
										
									</td>
								</tr>						
								<tr>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7"/>
									</td>
									<td width="25%">
										<rich:calendar  showWeeksBar="false" locale="th/TH" disabled="#{semmel006Bean.viewMode}"
										enableManualInput="true" datePattern="dd/MM/yyyy" id="paymentFromDt"
			                			 value="#{semmel006Bean.paymentDetail.fromTermOfPaymentDt}" inputSize="20" 
			                			 oninputblur="validateRichCalendarFromTo('frmAddPaymentELTemp','paymentFromDt','paymentToDt');"
										 oncollapse="validateRichCalendarFromTo('frmAddPaymentELTemp','paymentFromDt','paymentToDt');"
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
									</td>	
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7"/>
									</td>
									<td width="25%">
										<rich:calendar showWeeksBar="false" locale="th/TH" disabled="#{semmel006Bean.viewMode}"
										enableManualInput="true" datePattern="dd/MM/yyyy" id="paymentToDt"
			                			 value="#{semmel006Bean.paymentDetail.toTermOfPaymentDt}" inputSize="20" 
			                			 oninputblur="validateRichCalendarFromTo('frmAddPaymentELTemp','paymentToDt','paymentFromDt');"
										 oncollapse="validateRichCalendarFromTo('frmAddPaymentELTemp','paymentToDt','paymentFromDt');"
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
									</td>											
								</tr>							
					
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.pRead']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.paymentDetail.pRead}" disabled="#{semmel006Bean.viewMode}" id="inputPRead"
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											onblur="doCalculateKwhTotal()"											
											styleClass="inputRight"></h:inputText>	
										</td>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.lRead']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.paymentDetail.lRead}" disabled="#{semmel006Bean.viewMode}" id="inputLRead"
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"	
											onblur="doCalculateKwhTotal()"											
											styleClass="inputRight"></h:inputText>	
										</td>
										<a4j:jsFunction name="doCalculateKwhTotal" 
				                			 reRender="inputKwhTotal,inputLRead,inputPRead, txtPayAmt"
				                			 action="#{semmel006Action.doCalculateKwhTotal}">
				                			 <a4j:support event="oncomplete" reRender="frmError,expenseDetail" action="#{semmel006Action.doRecalCulateVATPR}">
											</a4j:support>
				                			 </a4j:jsFunction>
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.kwhTotal']}" styleClass="ms7"/>
										</td> 
										<td width="25%">											
											<h:inputText  value="#{semmel006Bean.paymentDetail.kwhTotal}" disabled="#{semmel006Bean.viewMode}" id="inputKwhTotal"
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"											
											styleClass="inputRight"></h:inputText>										
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.unitPrice']}" styleClass="ms7"/>
										</td>

										<td width="25%">							
											<h:inputText id="txtUnitPrice" value="#{semmel006Bean.paymentDetail.unitPrice}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="doCalculateKwhTotal();return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>												
																					
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">							
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>				
											<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">											
											<h:inputText id="txtPayAmt" value="#{semmel006Bean.paymentDetail.payAmt}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doRecalCulateVATELTemp();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											<a4j:jsFunction name="doRecalCulateVATELTemp" reRender="expenseDetail" action="#{semmel006Action.doRecalCulateVATELTemp}"/>                     
				
											
										</td>
										<td align="right" width="25%">		
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
										</td>

										<td width="25%">	
												<h:selectOneRadio id="mel006_CBVatType" value="#{semmel006Bean.paymentDetail.vatType}" disabled="false"
												 styleClass="ms7" rendered="true"
												 onclick="doChangeVATTypeELTemp();"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />	
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />					                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>		
					                	<a4j:jsFunction name="doChangeVATTypeELTemp" reRender="expenseDetail" action="#{semmel006Action.doChangeVATTypeELTemp}"/>                     
										
											 
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">											
											<h:inputText id="txtExcludeVatAmt" value="#{semmel006Bean.paymentDetail.excludeVatAmt}"						
												disabled="true"
												size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>												
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>

										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
							
											<h:inputText id="txtVatAmt" value="#{semmel006Bean.paymentDetail.vatAmt}"
											disabled="#{semmel006Bean.viewMode||semmel006Bean.vatAmtDisable}"
												onchange="doChangeVatAmtTemp();" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											<a4j:jsFunction name="reCalculatePaymentDetailConclution" reRender="paymentDetail" action="#{semmel006Action.reCalculatePaymentDetailConclution}"/>                     
											<a4j:jsFunction name="doChangeVatAmtTemp" reRender="frmError,paymentDetail,expenseDetail" action="#{semmel006Action.doChangeVatAmtPage64}"/>                     
											
											
											<a4j:jsFunction name="doChangeVatAmt" reRender="frmError,paymentDetail,expenseDetail" action="#{semmel006Action.doChangeVatAmt}"/>                     
											
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="txtIncludeVatAmt" value="#{semmel006Bean.paymentDetail.includeVatAmt}" 
												disabled="true"
												size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.chqAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">								
											<h:inputText id="txtChqAmt" value="#{semmel006Bean.paymentDetail.chqAmt}"
													disabled="true"
													size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
									</tr>					
													
									<tr>										
										<td colspan="4" >
											<a4j:commandButton id="btnAddELPostpaidToModel" value="Add" styleClass="rich-button" 
											disabled="#{semmel006Bean.disableAddModelButton||semmel006Bean.viewMode}"
											action="#{navAction.navi}"  reRender="oppContent,expenseDetail,paymentELtmpInfo,frmAddPaymentELTmp,pnlPaymentList,dtbPaymentList"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doAddPaymentDetailToModel" />
											</a4j:commandButton>										
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnUpdateELPostpaid" value="Update" styleClass="rich-button" 
											disabled="#{semmel006Bean.disableUpdateModelButton||semmel006Bean.viewMode}"
											action="#{navAction.navi}"  reRender="expenseDetail,oppContent,frmAddPaymentELTmp"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doUPdatePaymentDetailToModel" />
											</a4j:commandButton>												
											<rich:spacer width="5"/>																	
											<a4j:commandButton id="btnClearELPostpaid" value="Clear" styleClass="rich-button" 
											action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode}" reRender="oppContent,expenseDetail,frmAddPaymentELTmp"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doClearPaymentDetail" />
											</a4j:commandButton>						
						           		</td>
									</tr>																						
							</table>
							</h:panelGroup>				
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>			
	<!--  End Expense Detail -->		
		<!-- Start Expense Info conclude -->
				<h:panelGrid width="90%">
					<rich:panel id="expenseInfoConclude">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseInfoConClude']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.totalExpense']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.totalExpense}" styleClass="ms7"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.total']}" styleClass="ms7"/>											
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.excludeVatAmt}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										</td>																				
									</tr>										
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>										
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.vatAmt}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>										
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.includeVatAmt}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>										
										</td>																				
									</tr>																	
							</table>
							</h:panelGroup>								
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Expense Info conclude -->		
	
		<h:panelGrid columnClasses="gridContent" width="90%">
			<h:panelGroup>
				<table width="90%">
					<tr>
						<td align="left" width="25%">
							<h:outputText value="#{jspMsg['header.paymentList']}" styleClass="ms7"/>
						</td>
						<td width="25%">							
						</td>
						<td align="right" width="25%">											
						</td>
						<td width="25%">											
						</td>
					</tr>	
				</table>
			</h:panelGroup>
		</h:panelGrid>
	<!--  Start Payment Model List  -->
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlPaymentList" styleClass="sem_autoScrollbar">
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentList" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentDetail"  
							rowKeyVar="rowIndex"
							value="#{semmel006Bean.paymentDetailList}" 
							reRender="dtbPaymentList" 	
							rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.edit']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">  
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmEditDialog')}.show(); return false" 
	            							action="#{navAction.navi}" 
	            							disabled="#{semmel006Bean.viewMode}"
	            									   	image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el"/>
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initUPdatePaymentDetailFromModel" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />	
	            					</a4j:commandButton>   	            					
	            					       							
								</div>									
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.delete']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">								
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            									   action="#{navAction.navi}" 
	            									   disabled="#{semmel006Bean.viewMode}"
	            									   image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initDeletePaymentDetailFromModel" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>										
	            					</a4j:commandButton>	            					          							
								</div>									
							</rich:column>							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expenseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.expenseTypeDisplay}"/>
								</div>
							</rich:column>				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docTypeDisplay}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docNo}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	

							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.vendorId}"/>
								</div>
							</rich:column>		
							
																					<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.vendorName}"/>
								</div>
							</rich:column>		
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.payeeId}"/>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.payeeName}"/>
								</div>
							</rich:column>		

							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.fromTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>		
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.toTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitPrice']}"  styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{paymentDetail.unitPrice}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{paymentDetail.payAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.vatTypeTxt}"/>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.excludeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.vatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.includeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.chqAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.paymentTypeTxt}"/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.paymentMethodTxt}"/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.bankName}"/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.bankAccount}"/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.chqPostingDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.chqReceivedDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.transferDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.remark}"/>
								</div>
							</rich:column>									
						</rich:dataTable>
						<!-- end dataTable -->						
					</rich:panel>					
				</h:panelGrid>
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
		<jsp:include page="../../pages/el/semmel006-popupSearchSiteELTmp.jsp" />
		<jsp:include page="../../pages/el/semmel006-popupOldDoc.jsp" />		
		<jsp:include page="../../pages/el/semmel006_popup.jsp" />	
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
						reRender="oppContent,expenseDetail,paymentELtmpInfo,frmAddPaymentELPostpaid">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doDeletePaymentDetailFromModel" />
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
						reRender="oppContent,expenseDetail,paymentELtmpInfo,frmAddPaymentELPostpaid,mel006_CBVatType">
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
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>