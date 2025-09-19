<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.popup.popup-el-payment" var="jspMsg2" />
<rich:modalPanel id="popupElPayment" minHeight="500" minWidth="800" autosized="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg2['header.chooseDocNo']}"></h:outputText>
		</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidePopupVendorSupplier" style="cursor:pointer" /> 
				<rich:componentControl for="popupElPayment" attachTo="hidePopupVendorSupplier" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:panelGrid>
		<a4j:form id="popupFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green"
				infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	<h:form id="popupFrmSearch">
		<h:panelGrid width="90%" id="grdPopupSearchCriteria">
			<rich:panel id="pnlPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsg2['header.chooseDocNo']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid width="100%"  border="0" cellpadding="0"
					cellspacing="1">
					<h:panelGroup>
						<table width="90%" border="0" >
							<tr>
								<td align="right" width="35%">
								    <h:outputText
									value="#{jspMsg2['label.company']}" styleClass="ms7" />
									</td>
								<td  width="25%">
									<h:outputText
									value="#{semmel005Bean.company}" styleClass="ms7" />
														</td>
								<td align="right" width="30%">
								    <h:outputText
									value="#{jspMsg2['label.electricUseType']}" styleClass="ms7" />
									</td>
								
								<td>
								 <h:outputText
									value="#{semmel005Bean.electricUseType}" styleClass="ms7" />
								</td>
							</tr>
							
							<tr>
								<td align="right">
								    
								    <h:outputText
									value="#{jspMsg2['label.docNo']}" styleClass="ms7" />
								</td>
								<td>
								<h:inputText id="txtvendorCode"
									value="#{popupElPaymentBean.docNo}" styleClass="ms7" maxlength="50" />
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
										<td align="right">
											<h:outputText value="#{jspMsg2['label.docDTFrom']}" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldUploadMeterDtFrom" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.docDTFrom}" 
												oninputblur="validateRichCalendarFromTo('popupFrmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
											    oncollapse="validateRichCalendarFromTo('popupFrmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg2['label.docDTTo']}" styleClass="ms7"/>
										</td>
										
										<td>
											<rich:calendar id="cldUProcessDtTo" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.docDTTo}" 
												oninputblur="validateRichCalendarFromTo('popupFrmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
											    oncollapse="validateRichCalendarFromTo('popupFrmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td>
									</tr>
							<tr>
								<td ></td>
								<td ></td>
								<td ></td>
								<td ></td>
							</tr>
							<tr>
								<td colspan="4"><!-- end content criteria -->
								 <h:panelGroup>
									<a4j:commandButton id="btnPopupSearch"
										value="#{jspMsg2['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
										reRender="dtbPopupContractNo,pnlPopupSearchResult,popupFrmError">
										<a4j:actionparam name="navModule" value="popup" />
										<a4j:actionparam name="navProgram" value="popup-el-payment" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupElPayment" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
									</a4j:commandButton> 
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnClear"
										value="#{jspMsg2['btn.clear']}" styleClass="rich-button"
										action="#{navAction.navi}"
										reRender="dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="el-payment-popup" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupElPayment" />
										<a4j:actionparam name="methodWithNavi" value="doClearPopupElPayment" />
									</a4j:commandButton>
								<rich:spacer width="10"></rich:spacer>
								<a4j:commandButton id="btnPopupColse_1"
									value="Close" styleClass="rich-button" 
									oncomplete="#{rich:component('popupElPayment')}.hide(); return false" /> 
								
								</h:panelGroup>
								</td>
								
							</tr>

						</table>
					</h:panelGroup>
				</h:panelGrid>

			</rich:panel>
		</h:panelGrid>
		
		<rich:panel id="pnlPopupSearchResult" styleClass="sem_autoScrollbarHalf" style="width:700;height:200px">
			<f:facet name="header">
				<h:outputText value="#{jspMsg2['header.docNoDetail']}" />
			</f:facet>
			<rich:dataTable id="dtbVendorSupplier"
				value="#{popupElPaymentBean.paymentList}"
				rowKeyVar="RowInd" var="paymentObj"
				rowClasses="cur" rows="#{popupElPaymentBean.rowPerPage}"  
				styleClass="contentform">

				<rich:column id="ContractNoSelect" width="10%">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.select']}"
							styleClass="contentform" style="width:50px" />
					</f:facet>
					<div align="center">
						<a4j:commandLink id="cmlSelect"
							value="Select" action="#{navAction.navi}"
							reRender="txtdocDT,txtdocNo,txtpaymentStatus,txtdbTotalSite,txtexcludeVatAmt,txtvatAmt,txtincludeVatAmt,txtInvImportStatus"
							oncomplete="#{rich:component('popupElPayment')}.hide(); return false">
							
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="PopupVendorSupplier" />
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupElPayment" />
							<a4j:actionparam name="methodWithNavi" value="doSelectPayment" />
							<a4j:actionparam name="refDocNo" value="#{paymentObj.refDocNo}" />
							<a4j:actionparam name="paymentId" value="#{paymentObj.rowId}" />
							<a4j:actionparam name="docNo" value="#{paymentObj.docNo}" />
							<a4j:actionparam name="index" value="#{RowInd}" />
							
							
							
							
						</a4j:commandLink>
					</div>
				</rich:column>

				<rich:column id="colName">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.company']}"
							styleClass="contentform"  /> 
					</f:facet>
					<div align="left"><h:outputText
						value="#{paymentObj.company}" styleClass="contentform"
						 /></div>
				</rich:column>
				
				<rich:column id="colelectricUseType">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.electricUseType']}"
							styleClass="contentform"  /> 
					</f:facet>
					<div align="left"><h:outputText
						value="#{semmel005Bean.electricUseType}" styleClass="contentform"
						 /></div>
				</rich:column>
				<rich:column id="colIdentityId">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.docNo']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.docNo}" styleClass="contentform"
						 /></div>
				</rich:column>
				<rich:column id="colTaxId">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.docDt']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.docDt}" styleClass="contentform">
						<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th/TH" />
					</h:outputText></div>
				</rich:column>

				<rich:column id="colAddress">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.paymentStatus']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.paymentStatusDisplay}" styleClass="contentform"  />
						
					</div>
				</rich:column>
				
				<rich:column id="colsiteNo">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.siteNo']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.dbTotalSite}" styleClass="contentform"  />
						
					</div>
				</rich:column>
				
				<rich:column id="colexcludeVat">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.excludeVat']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.dbTotalExcludeVat}" styleClass="contentform" 
						 />
						
					</div>
				</rich:column>
				
				<rich:column id="colVat">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column. vat']}"
							styleClass="contentform"  />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.dbTotalVat}" styleClass="contentform" 
						 />
						
					</div>
				</rich:column>
				<rich:column id="colincludeVat">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column. includeVat']}"
							styleClass="contentform" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{paymentObj.dbTotalIncludeVat}" styleClass="contentform" 
						 />
						
					</div>
				</rich:column>
				<f:facet name="footer">
					<rich:datascroller immediate="true" rendered="true" align="left" 
						for="dtbVendorSupplier" maxPages="10" id="dstPopupContractNo"
						selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
		</rich:panel>
		
	</h:form>
</rich:modalPanel>

