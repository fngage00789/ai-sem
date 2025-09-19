<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.PRPrepaid']}"/> 
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="frmAddPaymentPRPrepaid">
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
							rendered="#{!semmel006Bean.comeFromOtherPage}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doBackSearchPage" />
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
						<a4j:commandButton id="btnCancel8"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage8}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancel7"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage7}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL007-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL007" />
							<a4j:actionparam name="methodWithNavi" value="doBackSearchPage" />
						</a4j:commandButton>
	           		</td>
	           		<td>
						<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" 
						disabled="#{semmel006Bean.viewMode}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doSavePRPrepaid" />
						</a4j:commandButton>						
	           		</td>	           		
	           		<td>
						<a4j:commandButton id="btnNew" value="Cancel" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							disabled="#{semmel006Bean.viewMode || semmel006Bean.comeFromPage8}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="initPaymentPRPrepaid" />
						</a4j:commandButton>
	           		</td>
	           		</tr>
				</table>
				  </td>
           		</tr>
				</table>
				</h:panelGroup>
		</h:panelGrid>		
		
		<!-- 1. Start Contract Info(  ) -->
		<h:panelGrid width="90%">
					<rich:panel id="contractInfo">
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
																	
			                		<a4j:commandButton id="btnPopupSearchSite"  
			                		oncomplete="#{rich:component('popupSearchSite')}.show(); return false"
									value="#{jspMsg['btn.searchSite']}" styleClass="rich-button" disabled="#{semmel006Bean.viewMode}"
									reRender="oppContent,popupSearchSite,popupFrmSearch,pnlPopupSearchResult,pnlPaymentList,contractInfo,prepaidInfo,paymentInfo,expenseDetail"
				            		action="#{navAction.navi}" style="width:150px;">
				            		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006" />
									<a4j:actionparam name="moduleWithNavi" value="el" />	
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
									<a4j:actionparam name="methodWithNavi" value="initPopupSearchSitePR" />
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
										<h:outputText value=" " styleClass="ms7"/>
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
																	
							</table>
							</h:panelGroup>	

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>		
		<!-- 1. End Contract Info () -->
		
		
		
		<!--  2. Start Prepaid Info ()  -->
		<h:panelGrid width="90%" id="tableELDetail">
			<rich:panel id="pnlElDetailResult" style="width: 100%" rendered="true">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.elDetail']}" />
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbElDetail" cellpadding="1" cellspacing="0" border="0" 
							var="elDetail"  value="#{semmel006Bean.elUseTypeList}" reRender="dtbElDetail" 
							rows="5" rowClasses="cur" styleClass="contentform">
							<!-- begin column -->
							
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.seq']}" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.seqNo}" />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.vendorId']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.vendorCode}" />
								</div>
							</rich:column>
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.vendorName']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{elDetail.vendorName}" />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.vat']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.vatType}" />
								</div>
							</rich:column>
							
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.percentVat']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.pVatRate}" />
								</div>
							</rich:column>
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.payPeriod']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.payPeriodType}" />
								</div>
							</rich:column>
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.periodAmt']}" style="width: 80"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{elDetail.periodAmt}" >
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.startDt']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.periodStartDtTH}">
									<f:convertDateTime pattern="dd/MM/yyyy"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.endDate']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.periodEndDtTH}" >
									<f:convertDateTime pattern="dd/MM/yyyy"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.ref']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.refSeq}" />
								</div>
							</rich:column>
							
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elDetail.remark']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{elDetail.remark}" />
								</div>
							</rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.elUseTypeList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="9">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbElDetail"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstElDetail" 
											style="background-color: #cccccc;"
											page="#{semmel006Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
		</h:panelGrid>				
		
		<!--  2. End Prepaid Info()  -->


		
		<!--  3.Start Expense Info () -->
		<h:panelGrid width="90%">
					<rich:panel id="paymentInfo">
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
																				
											<a4j:commandButton id="btnViewExpenseHis" value="#{jspMsg['btn.btnViewExpenseHis']}"  
											styleClass="rich-button" style="width:100px;" 
											disabled="#{semmel006Bean.disableViewExpenseHisButton}"
											 oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
											 reRender="frmPaymentHistList,frmErrorPopup"
											action="#{semmel006Action.paymentHistPopupInterface}">
											</a4j:commandButton>
											
											<rich:spacer width="5"/>

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
											<h:selectOneMenu id="docTypeId" value="#{semmel006Bean.payment.docType}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elDocTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.payment.docNo}"  disabled="#{semmel006Bean.viewMode}" style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											disabled="#{semmel006Bean.viewMode}"
				                			 value="#{semmel006Bean.payment.docDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>										
									</tr>									
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="vendorIdDisplay" value="#{semmel006Bean.payment.vendorId}" onchange="getVendorDetail();">
												<f:selectItems value="#{semmel006Bean.vendorIdList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="getVendorDetail" action="#{semmel006Action.changePaymentTypeELPR}" reRender="paymentInfo">
											<a4j:actionparam name="fromChangeVendorMaster" value="Y"></a4j:actionparam>
											</a4j:jsFunction>
											<rich:spacer width="5"/>
											
											<a4j:commandButton id="btnVendorMaster" value="#{jspMsg['label.vendorMaster']}" styleClass="rich-button" disabled="#{semmel006Bean.viewMode}" 
						            		action="#{navAction.navi}" reRender="oppContent" style="width:100">
											    <a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
												<a4j:actionparam name="contractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}" />
												
												<a4j:actionparam name="navModuleFrom" value="el" />
												<a4j:actionparam name="navProgramFrom" value="SEMMEL006-6" />
												<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL006" />
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
											<h:selectOneMenu id="paymentTypeId" value="#{semmel006Bean.payment.paymentType}"   disabled="#{semmel006Bean.paymentTypeDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" onchange="changePaymentTypeELPR();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentTypeList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="changePaymentTypeELPR" reRender="paymentInfo,payment,paymentPostpaidInfo" action="#{semmel006Action.changePaymentTypeELPR}">
												<f:param name="fromChangePaymentType" value="Y"></f:param>
											</a4j:jsFunction>
											
										</td>									
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="paymentMethodId" value="#{semmel006Bean.payment.paymentMethod}"  disabled="#{semmel006Bean.paymentMethodDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentMethodList}"/>
												<a4j:support event="onchange" reRender="paymentInfo"></a4j:support>
											</h:selectOneMenu>
										</td>											
									</tr>										
									<tr>
										<td align="right" width="25%">						
											<c:if test="${semmel006Bean.bankNameMandatory eq true}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>											
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="bankNameDisplay" value="#{semmel006Bean.payment.bankName}" styleClass="ms7"/>
										</td>
										<td align="right" width="25%">										
											<c:if test="${semmel006Bean.bankAccountMandatory eq true}">
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
				                			 value="#{semmel006Bean.payment.chqPostingDt}" inputSize="18" 
				                			 disabled="#{semmel006Bean.chqPostingDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 oninputblur="validateCalendarFromToWithPaymentType('frmAddPaymentPRPrepaid','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
				                			 oncollapse="validateCalendarFromToWithPaymentType('frmAddPaymentPRPrepaid','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
				                			 />
										   
										   <a4j:jsFunction name="doChangehqPostDate" 
				                			 reRender="cldchqReceivedDt"
				                			 action="#{semmel006Action.doChangehqPostDate}"
				                			 />
				                			 
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
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td>
										<td width="25%">
				                			 <h:inputTextarea id="textAreaRemark" value="#{semmel006Bean.payment.remark}" disabled="#{semmel006Bean.remarkDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" cols="40" rows="3" />				                		
										</td>
									</tr>
																																								
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>		
		<!--  3.End Expense Info () -->
		
		<!--  4.Start Expense Detail  ()-->
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
								<td align="right" width="15%">										
									<h:outputText value="#{jspMsg['label.totalExpense']}" styleClass="ms7"/>
								</td>
								<td width="25%">											
									<h:inputText  value="#{semmel006Bean.payment.totalExpense}" styleClass="ms7" disabled="true"/>
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.totalExpenseUnit']}" styleClass="ms7"/>									
								</td>	
								<td align="right" width="15%">	
									<rich:spacer width="5"/>
								</td>
								<td width="50%">	
									<rich:spacer width="5"/>			
								</td>
							</tr>	
							<tr>
								<td align="right" width="15%">									
									<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
								</td>
								
								<td width="25%">
									
									<h:selectBooleanCheckbox id="chksiteType" value="#{semmel006Bean.payment.whtCheckBoolean}" onclick="doChangeWhtELPaymentPR();"  styleClass="ms7"/>		                		
									<a4j:jsFunction name="doChangeWhtELPaymentPR" reRender="expenseDetail, pnlPaymentList" action="#{semmel006Action.doChangeWhtELPaymentPR}"/>
									
							
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.whtRatePercent']}" styleClass="ms7"/>
									<rich:spacer width="5"/>
									
								
								<h:inputText  value="#{semmel006Bean.payment.whtRate}" 	 onchange="doRecalCulateTotalVatPR_Prepaid();" 
									disabled="#{semmel006Bean.whtRateDisable||semmel006Bean.viewMode}" size="5"/>
										
										<a4j:jsFunction name="doRecalCulateTotalVatPR_Prepaid" reRender="expenseDetail, pnlPaymentList" action="#{semmel006Action.doRecalCulateTotalVatPR_Prepaid}"/>
								                   
	
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
								</td>
								
								<td align="right" width="15%">									
									<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
								</td>
								<td width="50%">
								
								<h:selectOneRadio value="#{semmel006Bean.payment.whtType}"  	disabled="#{semmel006Bean.whtTypeDisable||semmel006Bean.viewMode}" onclick="doCalculateChqAmt();"  styleClass="ms7" rendered="true"
				                layout="lineDirection">
		                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.whtType01']}" />
		                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.whtType02']}" />
		                		</h:selectOneRadio>		
		                		
										<a4j:jsFunction name="doCalculateChqAmt" reRender="expenseDetail, pnlPaymentList" action="#{semmel006Action.doCalculateChqAmt}"/>                     
		                		
								</td>
							</tr>	
							<tr>
								<td align="right" width="15%">				
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>				
									<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7"/>
								</td>
								<td width="25%">

									<h:inputText  value="#{semmel006Bean.payment.payAmt}"
											disabled="true"
											size="20"
										maxlength="18"
										styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>											
									
									
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>	
								</td>
								<td align="right" width="15%">
									
									<h:outputText value="#{jspMsg['label.whtAmt']}" styleClass="ms7"/>
								</td>
								<td width="50%">
									
									<h:inputText id="txtwhtAmt" value="#{semmel006Bean.payment.whtAmt}"
										disabled="#{semmel006Bean.whtAmtDisable}" 
										onchange="doChangePaymentWhtAmtPrepaid();" 		
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
									<a4j:jsFunction name="doChangePaymentWhtAmtPrepaid" 
									reRender="frmError,expenseDetail,pnlPaymentList" 
									action="#{semmel006Action.doChangePaymentWhtAmtPrepaid}"/>
									
							
								</td>
							</tr>																	
							<tr>
								<td align="right" width="15%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
								</td>
								<td width="25%">
		
									<h:inputText  value="#{semmel006Bean.payment.excludeVatAmt}"
											disabled="true"
											size="20"
										maxlength="18"
										styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>										
																		
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>									

								</td>
								<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
								</td>
								<td width="50%">	
															
									<h:inputText id="txtvatAmt" value="#{semmel006Bean.payment.vatAmt}"
										onchange="doChangePaymentVatAmt();" 
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
								<a4j:jsFunction name="doChangePaymentVatAmt" reRender="frmError,expenseDetail" action="#{semmel006Action.doChangePaymentVatAmt}"/>                     
									
								</td>
							</tr>										
							
							<tr>
								<td align="right" width="15%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
								</td>
								<td width="25%">
	
									<h:inputText  value="#{semmel006Bean.payment.includeVatAmt}"
											disabled="true"
											size="20"
										maxlength="18"
										styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>										
																			
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>												
								</td>
								<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.chqAmt']}" styleClass="ms7"/>
								</td>
								<td width="50%">
	
										
											<h:inputText  value="#{semmel006Bean.payment.chqAmt}"
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
								
									
			                		<a4j:commandButton id="btnPopupSearchInstallment"  
			                		oncomplete="#{rich:component('popupSearchInstallment')}.show(); return false"
									value="Add" styleClass="rich-button"  
									disabled="#{semmel006Bean.disableAddModelButton||semmel006Bean.viewMode}"
									rendered="#{!semmel006Bean.comeFromPage8}"
									reRender="popupSearchInstallment,popupFrmSearch,pnlPopupSearchInstallmentResult"
				            		action="#{navAction.navi}" >
				            		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006" />
									<a4j:actionparam name="moduleWithNavi" value="el" />	
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
									<a4j:actionparam name="methodWithNavi" value="initPopupSearchInstallment" />
		            				</a4j:commandButton>							
									
									
																
									<rich:spacer width="5"/>
									
									
									
									<a4j:commandButton id="btnUpdateELPostpaid" value="Update" styleClass="rich-button" 
									action="#{navAction.navi}"  disabled="#{semmel006Bean.disableUpdateModelButton||semmel006Bean.viewMode}"
									rendered="false"
									reRender="oppContent,frmAddPaymentELPostpaid"   >
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doUpdateELPostpaid" />
									</a4j:commandButton>									
									
									<rich:spacer width="5"/>
															
									<a4j:commandButton id="btnClearELPostpaid" value="Clear" styleClass="rich-button" 
									action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode}"
									rendered="false"  
									reRender="oppContent,frmAddPaymentELPostpaid"   >
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doClearELPostpaid" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnSave1" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" disabled="#{semmel006Bean.viewMode}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doSavePRPrepaid" />
						</a4j:commandButton>					
												
				           		</td>
							</tr>																						
						</table>
					</h:panelGroup>								

				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>		
		
		<!--  4.End Expense Detail () -->
		
		<!--  5.Start Expense List  ()-->
		<!--  Start Payment Model List  -->
				<!-- begin content layout data grid -->
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlPaymentList" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.paymentList']}" style="width: 2400"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentList" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentDetail"  rowKeyVar="rowIndex" value="#{semmel006Bean.paymentDetailList}" reRender="dtbPaymentList" 	rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->
						
							<rich:column rendered="#{!semmel006Bean.comeFromPage8}">
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
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />										
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
									<h:outputText  value="#{jspMsg['column.header.termOfPaymentDt1']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.dueDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.fromTermOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.toTermOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
					
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
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
									<h:outputText  value="#{jspMsg['column.header.whtAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.whtAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.whtType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.whtTypeTxt}"/>
								</div>
							</rich:column>	
							<rich:column rendered="false">
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
		<!--  5.End Expense List ()-->
		
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
				<jsp:include page="../../pages/el/semmel006-popupSearchSitePR-prepaid.jsp" />	
				<jsp:include page="../../pages/el/semmel006-popupSearchInstallment.jsp" />		
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
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
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
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
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