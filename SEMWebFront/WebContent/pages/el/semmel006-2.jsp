<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>

<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.ELBill']}"/> 
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>

		<a4j:form id="frmAddPaymentELBill">
		
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
							 rendered="#{!semmel006Bean.comeFromPage8}">
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
						disabled="#{semmel006Bean.viewMode}"
						action="#{navAction.navi}"  reRender="oppContent,frmAddPaymentELBill"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSaveELBill" />
						</a4j:commandButton>							
						
						
	           		</td>	           		
	           		<td>
						<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
						disabled="#{semmel006Bean.viewMode || semmel006Bean.comeFromPage8}"
						action="#{navAction.navi}"  reRender="oppContent,frmAddPaymentELBill"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentELBill" />
						</a4j:commandButton>				
	           		</td>
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
		</h:panelGrid>



                 
		<!-- Company Detail -->
				
				<table width="100%">
				<h:panelGrid width="90%">
					<rich:panel id="companyDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.companyDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="25%">											
											<h:selectOneMenu id="ddlCompany62" value="#{semmel006Bean.payment.company}" 
											 disabled="#{semmel006Bean.viewMode || semmel006Bean.morethanOneNotExpenseSite}"
											  onchange="GetCompanyJS();" style="width:120px;"
											  >
											<f:selectItems value="#{semmel006Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay62,btnAddNewSite"/>
											
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay62" value="#{semmel006Bean.payment.company}" styleClass="ms28"/>											
										</td>									
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="ddlElectricUseType62" value="#{semmel006Bean.payment.electricUseType}" 
											disabled="#{semmel006Bean.viewMode || semmel006Bean.morethanOneNotExpenseSite}" 
											onchange="changeElectricUseType_ELBill();"  style="width:120px;">
												<f:selectItems value="#{semmel006Bean.electricUseTypeList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="changeElectricUseType_ELBill" reRender="payment,btnAddNewSite" 
											action="#{semmel006Action.changeElectricUseType_ELBill}"/>
										</td>											
									</tr>						
																					
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  Payment Detail 1 -->
	
				<h:panelGrid width="90%">
					<rich:panel id="payment">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.payment']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup id="pnlPayment">
							<table width="100%" border="0">
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
										</td>
										<td width="20%">
											<h:outputText value="#{semmel006Bean.payment.expenseTypeDisplay}" styleClass="ms7" />
										</td>									
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlDocType62" 
											value="#{semmel006Bean.payment.docType}" 
											disabled="#{semmel006Bean.viewMode}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elDocTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>	
									<tr>
										<td align="right" >
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td>
										<td >
											<h:inputText id="txtdocNo62" value="#{semmel006Bean.payment.docNo}" disabled="#{semmel006Bean.viewMode}"style="width:120px;"></h:inputText>
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldDocDt62" showWeeksBar="false" locale="th/TH" disabled="#{semmel006Bean.viewMode}" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.docDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>


																					
										</td>										
									</tr>	
									
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.invTotalSite']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText  value="#{semmel006Bean.payment.invTotalSite}" disabled="#{semmel006Bean.viewMode}" 
                                            size="18" maxlength="15"
                                            onchange="recalculateAdNewExpenseSite();" 
                                            onkeypress="return numberformat.keyPressIntegerOnly(this, event);"  style="width:120px; text-align: right;">										
											<f:convertNumber pattern="#,##0"/>
											<a4j:jsFunction name="recalculateAdNewExpenseSite" reRender="frmError, paymentDetail,pnlNoPaymentSite,btnExport,frmError,popupFrmError,txtInvTotalExcludeVat,btnAddNewSite" 
											action="#{semmel006Action.recalculateAdNewExpenseSite}"/>                           
                                       </h:inputText>    
										</td>
										<td align="right">
											
										</td>
										<td>
												
										</td>										
									</tr>	
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7" />
										</td>
										<td>
										<h:selectOneRadio value="#{semmel006Bean.payment.vatType}" disabled="#{semmel006Bean.viewMode}"
												 styleClass="ms7" rendered="true"
												 onclick="doChangeVATTypeELTempPage62();"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}"  />		
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />			                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>		
					                	<a4j:jsFunction name="doChangeVATTypeELTempPage62" reRender="payment, frmError,paymentDetail" action="#{semmel006Action.doChangeVATTypeELPage62}"/>  
										</td>
									</tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.elBillpayAmt']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtelPayAmt" value="#{semmel006Bean.payment.elBillPayAmt}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doRecalCulateVATELCRAmt2();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											<a4j:jsFunction name="doRecalCulateVATELCRAmt2" 
											reRender="payment,paymentDetail,txtPayAmt,txtInvTotalExcludeVat,txtInvTotalVat,txtActaulPayAmt" 
											action="#{semmel006Action.doRecalCulateVATELCRAmt}"/>
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.invTotalIncludeVat']}" styleClass="ms7"/>
										</td>
										<td>
  	
                                           <h:inputText id="txtInvTotalIncludeVat" 
                                           value="#{semmel006Bean.payment.invTotalIncludeVat}" 
  											onchange="recalculateAdNewExpenseSite();" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18" disabled="true"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	                                        	
                                        											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
 											
										</td>							
									<tr>
									
								   </tr>								
									
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.invTotalExcludeVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
			                               <h:inputText id="txtInvTotalExcludeVat" value="#{semmel006Bean.payment.invTotalExcludeVat}" 
			                               disabled="#{semmel006Bean.disableMode}"
											onchange="recalculateAdNewExpenseSite();" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
												styleClass="inputRight"												
												>
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	              						
		                                    <rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>										
										
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.invTotalVat']}" styleClass="ms7"/>
										</td>
										<td >
											<h:inputText id="txtInvTotalVat" value="#{semmel006Bean.payment.invTotalVat}" 
											disabled="#{semmel006Bean.viewMode || semmel006Bean.disableInvTotalVat}"
 											onchange="doChangeVatAmtPage62();" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	 
											<a4j:jsFunction name="doChangeVatAmtPage62" reRender="payment, frmError, paymentDetail" 
											action="#{semmel006Action.doChangeVatAmtPage62}"/>  
                                        	
                                        							
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
									</tr>	
									<tr>
										
										
										<td align="right">
											
											<h:outputText value="#{jspMsg['label.invTotalIncludeVatCR']}" styleClass="ms7"/>
										</td>
										<td>

  											<h:inputText id="txtInvTotalIncludeVatCR" 
  											value="#{semmel006Bean.payment.includeVatAmtCR}" 
  											disabled="#{semmel006Bean.viewMode}"
  											     onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doRecalCulateVATELCRAmt();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											<a4j:jsFunction name="doRecalCulateVATELCRAmt" 
											reRender="payment,paymentDetail,txtPayAmt,txtInvTotalExcludeVat,txtInvTotalVat,txtActaulPayAmt" 
											action="#{semmel006Action.doRecalCulateVATELCRAmt}"/>
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.actaulPayAmt']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtActaulPayAmt" 
											value="#{semmel006Bean.payment.payAmt}"
											disabled="#{semmel006Bean.disableMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doRecalCulateVATELCRAmt();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
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
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"/>
										</td>
										<td >
											<h:outputLabel id="vendorIdDisplay" value="#{semmel006Bean.payment.vendorId}" styleClass="ms7"/>
										</td>
										<td align="right" >
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputLabel id="vendorNameDisplay" value="#{semmel006Bean.payment.vendorName}" styleClass="ms7"/>	
										</td>
									</tr>																																								
									<tr>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.payeeId']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputLabel id="payeeIdDisplay" value="#{semmel006Bean.payment.payeeId}" styleClass="ms7"/>										
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputLabel id="payeeNameDisplay" value="#{semmel006Bean.payment.payeeName}" styleClass="ms7"/>
										</td>
									</tr>	
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
										</td>
										<td>											
											<h:selectOneMenu id="ddlelectricUseType" value="#{semmel006Bean.payment.paymentType}" disabled="#{semmel006Bean.viewMode}"
											 onchange="changePaymentTypeELBill();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentTypeList}"/>
											</h:selectOneMenu>	
											<a4j:jsFunction name="changePaymentTypeELBill" reRender="payment, frmError" action="#{semmel006Action.changePaymentTypeELBill}"/>
																		
											
										</td>									
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
										</td>
										<td>										
											<h:selectOneMenu id="ddlpaymentMethod62" value="#{semmel006Bean.payment.paymentMethod}" style="width:120px;"
											disabled="#{semmel006Bean.paymentMethodDisable||semmel006Bean.viewMode}">
												<f:selectItems value="#{semmel006Bean.ctPaymentMethodList}"/>
												<a4j:support event="onchange" reRender="pnlPayment"></a4j:support>
											</h:selectOneMenu>
										</td>											
									</tr>										
									<tr>
										<td align="right">						
											<c:if test="${semmel006Bean.bankNameMandatory eq 'true'}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>											
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputLabel id="bankNameDisplay" value="#{semmel006Bean.payment.bankName}" styleClass="ms7"/>
										</td>
										<td align="right">										
											<c:if test="${semmel006Bean.bankAccountMandatory eq 'true'}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>												
											<h:outputText value="#{jspMsg['label.bankAccount']}" styleClass="ms7"/>
										</td>
										<td>
											<h:outputLabel id="bankAccountDisplay" value="#{semmel006Bean.payment.bankAccount}" styleClass="ms7"/>
										</td>
									</tr>									
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.chqPostingDt']}" styleClass="ms7"/>
										</td>
										<td>
										<!-- if == f deutsche bank -->
											<rich:calendar id="cldchqPostingDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.chqPostingDt}" inputSize="18" disabled="#{semmel006Bean.chqPostingDtDisable||semmel006Bean.viewMode}"
				                			 oninputblur="validateCalendarFromToWithPaymentType('frmAddPaymentELBill','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
				                			 oncollapse="validateCalendarFromToWithPaymentType('frmAddPaymentELBill','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
											 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.chqReceivedDt']}" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldchqReceivedDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.chqReceivedDt}" inputSize="18" disabled="#{semmel006Bean.chqReceivedDtDisable||semmel006Bean.viewMode }"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
									</tr>										

									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldtransferDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.transferDt}" inputSize="18" disabled="#{semmel006Bean.transferDtDisable||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td>
										<td>
				                			 <h:inputTextarea id="textAreaRemark" value="#{semmel006Bean.payment.remark}" disabled="#{semmel006Bean.viewMode}" cols="40" rows="3" />
				                		
										</td>
									</tr>
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>


	<!--  Payment Detail 2 -->
	

				<h:panelGrid width="90%">
					<rich:panel id="paymentDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.paymentDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.dbTotalSite']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="dbTotalSiteDisplay" value="#{semmel006Bean.payment.dbTotalSite}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>											
										</td>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.noDbTotalSite']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="noDbTotalSiteDisplay" value="#{semmel006Bean.payment.noDbTotalSite}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>											
										</td>
									</tr>											
									<tr>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.dbTotalExcludeVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="dbTotalExcludeVatDisplay" value="#{semmel006Bean.payment.dbTotalExcludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.noDbTotalExcludeVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="noDbTotalExcludeVatDisplay" value="#{semmel006Bean.payment.noDbTotalExcludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.dbTotalVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="dbTotalVatDisplay" value="#{semmel006Bean.payment.dbTotalVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.noDbTotalVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="noDbTotalVatDisplay" value="#{semmel006Bean.payment.noDbTotalVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.dbTotalIncludeVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="dbTotalIncludeVatDisplay" value="#{semmel006Bean.payment.dbTotalIncludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
										<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.noDbIncludeVat']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="dbIncludeVatDisplay" value="#{semmel006Bean.payment.noDbIncludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										</td>
									</tr>																			
																	
																					
							</table>
							</h:panelGroup>		
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>

<!-- Add Site -->

		<h:panelGrid columnClasses="gridContent" width="90%">
			<h:panelGroup>
				<table width="90%">
				<tr>
					<td width="100%" align="left">
					
					
	            	<a4j:commandButton id="btnAddNewSite" value="#{jspMsg['btn.addNewSite']}" 
	            	disabled="#{semmel006Bean.viewMode || semmel006Bean.payment.dbTotalSite<=0 
	            	|| semmel006Bean.payment.dbTotalSite == NULL || semmel006Bean.payment.company == '' || semmel006Bean.payment.electricUseType == '' }"
	            	 styleClass="rich-button" 
	            	 action="#{navAction.navi}"
						oncomplete="#{rich:component('popupNotExpenseSite')}.show(); return false" 
						reRender="popupAddNotExpenseSite,popupFrmSearch,popupFrmError" 
						style="width:150">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="initAddNewSite" />
					</a4j:commandButton>
					<rich:spacer width="5"/>
					<h:commandButton id ="btnExport" action="#{semmel006Action.doExportExcel}" style="width:180px"					 
	            		styleClass="rich-button" value="#{jspMsg['btn.exportNoPayment']}" disabled="#{semmel006Bean.viewMode 
	            		 }">
	            	</h:commandButton>	

           		</tr>
				</table>
			</h:panelGroup>
		</h:panelGrid>


		<h:panelGrid columnClasses="gridContent" width="90%">
			<h:panelGroup>
				<table width="90%">
					<tr>
						<td align="left" width="25%">
							<h:outputText value="#{jspMsg['header.noPayment']}" styleClass="ms7"/>
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
		
		

<!-- Start  Search Result  -->		
		
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlNoPaymentSite" styleClass="sem_autoScrollbar">
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbnotPaymentSiteList" width="100%" cellpadding="1" cellspacing="0" border="0" 
							rowKeyVar="rowIndex"
							var="notExpenseSite"  value="#{semmel006Bean.notExpenseSiteList}" 
							reRender="dtbnotPaymentSiteList" 	
							rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.delete']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            										disabled="#{semmel006Bean.viewMode}"
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="paymentDetail,pnlNoPaymentSite,btnExport,popupFrmError" 
	            									   image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteNotExpenseSite" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>
	            					</a4j:commandButton>          							
								</div>									
							</rich:column>
							
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invNo}"/>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invSiteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invSiteName}"/>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invAreaCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invAreaCode}"/>
								</div>
							</rich:column>							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invAreaName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invAreaName}"/>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.meterId}"/>
								</div>
							</rich:column>								
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invTermOfPaymentDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invExcludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invExcludeVatAmt}" >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>										

							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>										
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invIncludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{notExpenseSite.invIncludeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
										
						</rich:dataTable>
						<!-- end dataTable -->						
					</rich:panel>					
				</h:panelGrid>
				<!-- end content layout data grid -->
				
		<!--  Start Footer -->
				<h:panelGrid  width="90%">
				<rich:panel id="elPaymentBillFooter">
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
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th/TH" dateStyle="medium" />
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
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th/TH" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>										
						</table>
					</h:panelGroup>
					</rich:panel>
				</h:panelGrid>	
		</table>
		<!--  End Footer -->	
		
				
				
		

<!-- End Search Result -->
		
		

		</a4j:form>
		<jsp:include page="../../pages/el/semmel006-popupNotExpense.jsp" />
	</rich:panel>
</h:panelGrid>



<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirmed Message"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">						
						<h:outputText value="#{semmel006Bean.confirmDeleteMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
						reRender="companyDetail, paymentDetail,pnlNoPaymentSite,btnExport,popupFrmError" 	>
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL006" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteNotExpenseSite" />							
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
