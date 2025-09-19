<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt007" var="jspMsg2"/>
<rich:modalPanel id="popupFrmSaveClrRec" width="650" autosized="true" minWidth="220">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmAdd']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSaveClrRec" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSaveClrRec" attachTo="hidePopupSaveClrRec" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="frmSaveClrRec">
		<h:panelGrid>
			<h:messages id="errorClrRec" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['header.frmAdd']}"/>
					</f:facet>
					<!-- begin content criteria -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table border="0">
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.amt']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText id="txtAmt" value="#{semmrt007Bean.rentalClrRec.sumAmt}" 
				                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                				onblur="return numberformat.moneyFormat(this);"
		                				onfocus="return numberformat.setCursorPosToEnd(this);"
		                				maxlength="16" disabled="true" 
		                				styleClass="inputRight">
				                		<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                	</h:inputText>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.receiveNo']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText id="txtReceiveNo" value="#{semmrt007Bean.rentalClrRec.receiptNo}" />
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.taxInvoiceNo']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText id="txtTaxInvoiceNo" value="#{semmrt007Bean.rentalClrRec.taxInvoiceNo}" />
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.taxInvoiceDt']}" styleClass="ms7" />
								</td>
								<td>
		                			<rich:calendar id="cldTaxInvoiceDt" locale="en/US" enableManualInput="true" 
										datePattern="dd/MM/yyyy" showWeeksBar="false" inputSize="13" 
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
										value="#{semmrt007Bean.rentalClrRec.taxInvoiceDt}"/>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.remark']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputTextarea id="txtRemark" value="#{semmrt007Bean.rentalClrRec.remark}"
		                				rows="3" cols="50"></h:inputTextarea>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.status']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:selectOneMenu id="ddlStatus" value="#{semmrt007Bean.rentalClrRec.clrReceiptStatus}"> 
										<f:selectItems value="#{semmrt007Bean.clrReceiptStatusList}"/>
									</h:selectOneMenu>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.batchNo']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText id="txtBatchNo" value="#{semmrt007Bean.rentalClrRec.batchNo}" 
		                				disabled="true"/>
				                </td>
							</tr>
							<h:panelGroup  rendered="#{semmrt007Bean.rentalClrRec.displayDonateFlag}">
							<tr>
								<td align="right" width="30%">
									
								</td>
								<td>
		                			<h:selectBooleanCheckbox id="txtDonateFlag" value="#{semmrt007Bean.rentalClrRec.donateFlagBoolean}" />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg2['label.donateFlag']}" styleClass="ms7"/>
				                </td>
							</tr>
							</h:panelGroup>
						</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- end content criteria -->
					<h:panelGrid columns="2" id="grdPopupCommand">
						<a4j:commandButton value="#{jspMsg2['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" 
							oncomplete="if(#{semmrt007Bean.popupClose == 'true'})#{rich:component('popupFrmSaveClrRec')}.hide();"
							reRender="frmSaveClrRec,dtbClearReceipt,frmSearch">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg2['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmSaveClrRec" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupFrmSaveClrRecStatus" width="650" autosized="true" minWidth="220">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmAddFnAc']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSaveClrRecStatus" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSaveClrRecStatus" attachTo="hidePopupSaveClrRecStatus" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="frmSaveClrRecStatus"> 
		<h:panelGrid>
			<h:messages id="errorPopupStatus" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['header.frmAddFnAc']}"/>
					</f:facet>
					<!-- begin content criteria -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table border="0">
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.status']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:selectOneMenu id="ddlStatus" value="#{semmrt007Bean.rentalClrRec.clrReceiptStatus}" 
		                				disabled="true"> 
										<f:selectItems value="#{semmrt007Bean.clrReceiptStatusList}"/>
									</h:selectOneMenu>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.clrRejectReason']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputTextarea id="txtReceiveNo" value="#{semmrt007Bean.rentalClrRec.clrRejectReason}"
		                				rows="3" cols="50"></h:inputTextarea>
				                </td>
							</tr>
						</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- end content criteria -->
					<h:panelGrid columns="2">
						<a4j:commandButton value="#{jspMsg2['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" 
							oncomplete="if(#{semmrt007Bean.popupClose == 'true'})#{rich:component('popupFrmSaveClrRecStatus')}.hide();"
							reRender="frmSaveClrRecStatus,dtbClearReceipt,frmSearch">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
							<a4j:actionparam name="methodWithNavi" value="doSaveStatus" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg2['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmSaveClrRecStatus" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

<!-- POPUP Update Doc -->
<rich:modalPanel id="popupFrmUpdateDoc" width="900" autosized="true" minWidth="220">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmAdd']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupUpdateDoc" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmUpdateDoc" attachTo="hidePopupUpdateDoc" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="frmUpdateDoc">
		<h:panelGrid>
			<h:messages id="error" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['header.frmAdd']}"/>
					</f:facet>
					<!-- begin content criteria -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table border="0">
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.company']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.company}" disabled="true" >
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.contractNo']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.contractNo}" disabled="true" >
				                	</h:inputText>
								</td>
							</tr>
							
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.siteName']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.siteName}" disabled="true" >
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.locationId']} :" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.locationId}" disabled="true" >
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.vendorId']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.vendorId}" disabled="true" >
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.vendorName']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.vendorName}" disabled="true" >
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.termOfPayDt']} :" styleClass="ms7" />
								</td>
								<td>
		                			
				                	<rich:calendar  locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmrt007Bean.updateDocSP.periodStartDt}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="true"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
									</rich:calendar>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.periodNo']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.periodNoStart}" disabled="true" >
										
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.paymentAmt']} :" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.paymentAmt}" disabled="true" styleClass="inputRight">
		                				<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.vat']} :" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.vat}" disabled="true" styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.whtAmt']} :" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.whtAmt}" disabled="true" styleClass="inputRight">
		                				<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.totalAmt']} :" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.totalAmt}" disabled="true" styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.chqNo']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText value="#{semmrt007Bean.updateDocSP.chqNo}" disabled="true" >
				                	</h:inputText>
				                </td>
				                <td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.chqDt']} :" styleClass="ms7" />
								</td>
								<td>
									
				                	<rich:calendar  locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmrt007Bean.updateDocSP.chqDt}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="true"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.transferDt']} :" styleClass="ms7" />
								</td>
								<td>
				                	<rich:calendar  locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmrt007Bean.updateDocSP.transferDtStr}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="true"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
									</rich:calendar>
				                </td>
				                <td align="right" width="25%">
									
								</td>
								<td>
									
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.doc68']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.doc68}" disabled="false" >
				                	</h:inputText>
								</td>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.doc68Dt']} :" styleClass="ms7" />
								</td>
								<td>
									
				                	<rich:calendar  locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmrt007Bean.updateDocSP.doc68Dt}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="false"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
									</rich:calendar>
								</td>
				                
							</tr>
							<tr>
								
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.doc92']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText value="#{semmrt007Bean.updateDocSP.doc92}" disabled="false" >
				                	</h:inputText>
								</td>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg2['label.doc92Dt']} :" styleClass="ms7" />
								</td>
								<td>
		                			<rich:calendar  locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmrt007Bean.updateDocSP.doc92Dt}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="false"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
									</rich:calendar>
				                </td>
				                
							</tr>
							
						</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- end content criteria -->
					<h:panelGrid columns="2" id="grdPopupCommand">
						<a4j:commandButton value="#{jspMsg2['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" 
							oncomplete="if(#{semmrt007Bean.popupClose == 'true'})#{rich:component('popupFrmUpdateDoc')}.hide();"
							reRender="popupFrmUpdateDoc,dtbClearReceipt,frmSearch">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateDoc" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg2['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmUpdateDoc" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

<!-- Popup NotClearReceipt -->
<rich:modalPanel id="popupFrmNotClearReceipt" width="650" autosized="true" minWidth="220">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmAdd']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupNotClearReceipt" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmNotClearReceipt" attachTo="hidePopupNotClearReceipt" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="frmNotClearReceipt">
		<h:panelGrid>
			<h:messages id="errorClrRec" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['label.frmPopupNotCR']}"/>
					</f:facet>
					<!-- begin content criteria -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table border="0" width="100%">
							<tr>
								<td align="right" width="15%" valign="top">
									<h:outputText value="#{jspMsg2['label.remark']}" styleClass="ms7" />
								</td>
								<td width="85%">
		                			<h:inputTextarea id="remarkTxt" value="#{semmrt007Bean.notClearRecriptSP.remark}" 
		                			 rows="10" style="width:100%">
		                			
		                			</h:inputTextarea>
				                </td>
							</tr>
							
						</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- end content criteria -->
					<h:panelGrid columns="2" id="grdPopupCommand">
					
						<a4j:commandButton id="btnSaveClearReceipt" value="#{jspMsg['btn.save']}" styleClass="rich-button"
						style="width:105px;" action="#{navAction.navi}" 
						reRender="popupFrmNotClearReceipt,frmError,frmResult,pnlSearchResult,grdActionCommand">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateNotClearReceiptStatus" />
							<a4j:actionparam name="clearReciptFlag" value="Y" />
						</a4j:commandButton>
						
						
						<a4j:commandButton value="#{jspMsg2['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmNotClearReceipt" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>