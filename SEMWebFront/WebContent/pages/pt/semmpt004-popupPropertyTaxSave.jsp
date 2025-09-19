<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.propertyTax.semmpt004" var="jspMsg"/>
	<rich:modalPanel id="popupPropertyTaxPayForm" width="750" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupPropertyTaxPayForm']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupPropertyTaxPayForm" style="cursor:pointer"/>
					<rich:componentControl for="popupPropertyTaxPayForm" attachTo="hidePopupPropertyTaxPayForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupSave">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmSave"> 
			<rich:panel id="pnlPropertyTaxPayForm">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupPropertyTaxPayForm']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmpt004Bean.mpt004Pay.paymentType}" onchange="ChangeCalendar();">
											<f:selectItems value="#{semmpt004Bean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmpt004Action.onRenderPaymentMethod}"  
										 reRender="ddlPaymentMethod,cldChqDt,cldChqReceiveDt,cldTransferDt">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="25%">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.paymentType2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentMethod" value="#{semmpt004Bean.mpt004Pay.paymentMethod}">
											<f:selectItems value="#{semmpt004Bean.paymentMethodList}"/>
											<a4j:support event="onchange" reRender="pnlPropertyTaxPayForm"></a4j:support>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankName" value="#{semmpt004Bean.mpt004Pay.bankName}" disabled="true"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bankAccNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtBankAccNo" value="#{semmpt004Bean.mpt004Pay.bankAccNo}" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldChqDt" 
		                					locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmpt004Bean.mpt004Pay.chqDt}"
											disabled="#{semmpt004Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											cellWidth="20px" cellHeight="20px" 
											label="#{jspMsg['column.header.chqDt']}"
											oninputblur="validateCalendarFromToWithPaymentType('contentPopupPropertyTaxSave:popupFrmSave','cldChqDt','cldChqReceiveDt','#{semmpt004Bean.mpt004Pay.paymentMethod}');"
									 		oncollapse="validateCalendarFromToWithPaymentType('contentPopupPropertyTaxSave:popupFrmSave','cldChqDt','cldChqReceiveDt','#{semmpt004Bean.mpt004Pay.paymentMethod}');">
										</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldChqReceiveDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy"  value="#{semmpt004Bean.mpt004Pay.chqReceive}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmpt004Bean.renderedChqReceiveDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.chqReceiveDt']}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldTransferDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" showWeeksBar="false"
										inputSize="13" value="#{semmpt004Bean.mpt004Pay.transferDt}"
										disabled="#{semmpt004Bean.renderedTransferDt}"
										/>
		                			</td>
		                			<td align="right" width="25%">
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlDocType" value="#{semmpt004Bean.mpt004Pay.docType}">
											<f:selectItems value="#{semmpt004Bean.docTypeList}"/>
										</h:selectOneMenu>
		                			</td>
				                </tr>
				                <tr>
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtDocNo" value="#{semmpt004Bean.mpt004Pay.docNo}" size="18" maxlength="15"/>
		                			</td>
		                			<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldDocDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmpt004Bean.mpt004Pay.docDt}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
		                			</td>
				                </tr>
			                	<tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtRemark" value="#{semmpt004Bean.mpt004Pay.remark}" cols="30" rows="3"/>
				                	</td>
				                </tr>
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupEdtSave" value="Save" styleClass="rich-button"
									 action="#{navAction.navi}" reRender="frmError,frmErrorPopupSave,pnlSearchResult"
									 oncomplete="if(#{semmpt004Bean.popupClose == 'true'})#{rich:component('popupPropertyTaxPayForm')}.hide();">
									 	<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
										<a4j:actionparam name="methodWithNavi" value="doUpdatePay" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" reRender="frmError">
										<rich:componentControl for="popupPropertyTaxPayForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	<rich:modalPanel id="popupApprovePropertyTax" width="470" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupApprovePropertyTax" style="cursor:pointer"/>
					<rich:componentControl for="popupApprovePropertyTax" attachTo="hidePopupApprovePropertyTax" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupApproveSave">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAct">
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpApprove']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" valign="top" colspan="3" width="50%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtremark" value="#{semmpt004Bean.remark}" rows="3" cols="60"/>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td colspan="3" width="50%"></td>
			                	 	<td width="25%">
			                	 		<a4j:commandButton id="btnPopupApproveSave" value="Save" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupApproveSave,pnlSearchResult,frmError" 
									oncomplete="if(#{semmpt004Bean.popupClose == 'true'})#{rich:component('popupApprovePropertyTax')}.hide();">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
										<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,frmError" >
									 	<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
										<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
										<rich:componentControl for="popupApprovePropertyTax" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mpt004PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mpt004PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mpt004PopUp_addVendor" attachTo="hide-mpt004PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMpt004PopUp_addVendor">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="เงื่อนไขการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmpt004Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmpt004Bean.vendorMasterPopupObjParam.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmpt004Action.doSearchPopupAddVendor}"
					reRender="frmmpt004PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmpt004Action.doClearPopupAddVendor}"
					reRender="frmMpt004PopUp_addVendor, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="ผลการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmpt004Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmpt004Action.doSelectPopupAddVendor}"
											reRender="oppContent">
												<a4j:actionparam name="paramVendorCode" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="paramVendorName" value="#{vendorLst.dataObj.vendorName}" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code ใหม่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mpt004_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mpt004_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mpt004_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mpt004_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmpt004Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmpt004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmpt004Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMpt004PopUp_addVendor"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mpt004PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->		