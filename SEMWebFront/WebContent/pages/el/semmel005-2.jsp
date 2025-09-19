<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/popup-el-payment.jsp" />
<f:loadBundle basename="resources.el.semmel005-2" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlAddFileData">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.fileData']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<a4j:form id="frmSearch">
						<h:panelGrid width="95%">
					<rich:panel id="pnlImportResult">				
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%" border="0" >
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="20%">
											<h:selectOneMenu id="ddlCompany" value="#{semmel005Bean.company}" 
											onchange="GetCompanyJS();" style="width:120px;">
											<f:selectItems value="#{semmel005Bean.companyList}"
											/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" 
										reRender="companyDisplay,btnPopupSearchElPayment"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" 
										value="#{semmel005Bean.company}" styleClass="ms28"/>
										</td>
										
										
										
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.typeOfFile']}" styleClass="ms7"/>
										</td>
										<td width="20%">
											<h:selectOneMenu id="ddlTypeOfFile" value="#{semmel005Bean.typeOfFile}" 
											onchange="GetFileType();">
												<f:selectItem itemValue="01" itemLabel="Text" />
												<f:selectItem itemValue="02" itemLabel="Excel" />
											
											</h:selectOneMenu>
											<a4j:jsFunction name="GetFileType" action="#{semmel005Action.getFileType}" reRender="ddlFileType,txtFileUpload"/>
										</td>
										
										
									</tr>									
									<tr>
										<td align="right" width="20%" >
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.refDocId']}" styleClass="ms7"/>
										</td>
										
										<td>											
												<h:inputText id="txtdocNo" value="#{popupElPaymentBean.payment.docNo}" 
												 maxlength="25" readonly="true" 
												disabled="true"
												/>
													<a4j:jsFunction name="GetLocationListJS" 
													reRender="txtdocNo" />
													<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnPopupSearchElPayment"  
													oncomplete="#{rich:component('popupElPayment')}.show(); return false"
													value="#{jspMsg['btn.searchInv']}"
													reRender="popupElPayment" 
													action="#{navAction.navi}"
													disabled="#{semmel005Bean.company == '' || semmel005Bean.fileType == '' }">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL005-2" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
														<a4j:actionparam name="methodWithNavi" value="initPopupSearchInvDetail" />
														
													</a4j:commandButton>
										</td>
											
										
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.fileType']}" styleClass="ms7"/>
											
											
										</td>
										<td align="left"  width="20%" >
											<h:selectOneMenu id="ddlFileType" value="#{semmel005Bean.fileType}" 
											onchange="GetCompanyJS();">
												<f:selectItems value="#{semmel005Bean.fileTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText  value="#{jspMsg['label.refDocDT']}" styleClass="ms7"/>	
										</td>
										<td align="left">
											<h:outputText id="txtdocDT" value="#{popupElPaymentBean.payment.docDtTH}" styleClass="ms7"/>
										</td>
									    
									    <td align="right">
											<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
										</td>
										<td align="left">
											<h:outputText id="txtpaymentStatus" value="#{popupElPaymentBean.payment.paymentStatus}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteNo']}" styleClass="ms7"/>
										</td>
										<td align="left">
											<h:outputText id="txtdbTotalSite" value="#{popupElPaymentBean.payment.dbTotalSite}" styleClass="ms7"/>
										</td>
									    
									    <td align="right">
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td align="left">
											<h:outputText  id="txtexcludeVatAmt" value="#{popupElPaymentBean.payment.dbTotalExcludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td align="left">
											<h:outputText id="txtvatAmt" value="#{popupElPaymentBean.payment.dbTotalVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
										</td>
									   
									    <td align="right">
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td align="left">
											<h:outputText id="txtincludeVatAmt" value="#{popupElPaymentBean.payment.dbTotalIncludeVat}" styleClass="ms7">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											
											<h:outputText value="#{jspMsg['label.invimportStatus']}" styleClass="ms7"/>
											
										</td>
										<td align="left">
											<h:outputText id="txtInvImportStatus" value="#{popupElPaymentBean.payment.elImportStatusDetail}" 
										styleClass="ms10" style="red"/>
										</td>
									   
									    <td align="right">
										
										</td>
										<td align="left">
										
										</td>
									</tr>
									<tr>
										<td align="right"  valign="top">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										
										</td>
										
										<td colspan="4" align="center">
											<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1">
											<h:panelGroup>
												<table width="100%" align="center">
													<tr>
														<td>
															<rich:fileUpload id="txtFileUpload" 
															fileUploadListener="#{semmel005Action.uploadFileListener}"
																		  maxFilesQuantity="100"
															              listHeight="158"
																		  listWidth="365px"
															              addControlLabel="Browse..."
															              acceptedTypes="#{semmel005Bean.fileProperty}"
															              immediate="true"
															              
															              >
												         	</rich:fileUpload>
														</td>
													</tr>	
												</table>
											</h:panelGroup>
										</h:panelGrid>											
										</td>
									</tr>
									
									<tr>
										
										<td align="center" colspan="5">
											<h:panelGrid columns="2" id="grdSave">
												<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
													action="#{navAction.navi}" reRender="oppContent,txtFileUpload">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
												</a4j:commandButton>
												<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
								            	 	action="#{navAction.navi}" reRender="oppContent">
								            		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
								            	</a4j:commandButton>
											</h:panelGrid>
										</td>
									</tr>
									<tr>
										
									</tr>
									<tr>
										
									</tr>
									<tr>
										
									</tr>										
									<tr>
										
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

