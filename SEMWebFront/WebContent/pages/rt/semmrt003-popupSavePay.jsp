<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
	<rich:modalPanel id="popupRentalPayNormal" width="650" autosized="true" minWidth="220" moveable="true">
		<f:facet name="header">
				<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupRentalPayNormal" style="cursor:pointer"/>
					<rich:componentControl for="popupRentalPayNormal" attachTo="hidePopupRentalPayNormal" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupSave">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormPopup}">
					 		<f:facet name="header">
	                        	<h:outputText value="Entered Data Status:"></h:outputText>
	                    	</f:facet>
				 			<f:facet name="errorMarker">
				 				 <h:graphicImage value="images/error.gif" />  
		                    </f:facet>
	                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmSave"> 
				<rich:panel id="pnlRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.name']}"/>
				</f:facet>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.totalAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtTotalAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.totalAmt}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 styleClass="inputRight"
			                			 maxlength="16" 
										 disabled="true">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										</h:inputText>
										
									</td>
				                	<td align="right" width="25%">
									<h:selectBooleanCheckbox id="chkDepositFlag" value="#{semmrt003Bean.chkDeposit}" onchange="ChangeDeposit2();" disabled="#{semmrt003Bean.periodNo == '1'}"/>
									<a4j:jsFunction name="ChangeDeposit2" action="#{semmrt003Action.onRenderDepositAmt}"
															 reRender="txtDepositAmt,txtPaymentAmt,frmErrorPopupSave"/>
									<h:outputText value="#{jspMsg['label.depositFlag']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtDepositAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.depositAmt}"
										  onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			  onblur="return numberformat.moneyFormat(this);"
			                			  onfocus="return numberformat.setCursorPosToEnd(this);"
			                			  styleClass="inputRight"
			                			  maxlength="16" 
										  disabled="#{semmrt003Bean.renderedDepositAmt}">
										    <a4j:support event="onchange" action="#{semmrt003Action.onRenderTotal}" reRender="txtPaymentAmt"></a4j:support>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										 </h:inputText>
										 
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.paymentAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<h:inputText id="txtPaymentAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.paymentAmt}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 styleClass="inputRight"
			                			 maxlength="16" 
			                			 disabled="true">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmrt003Bean.rentalPayNormalSearchDSP.paymentType}" onchange="ChangeCalendar();">
												<f:selectItems value="#{semmrt003Bean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmrt003Action.onRenderPaymentMethod}"
										 reRender="cldTransferDt,cldChqReceiveDt,cldChqDt,ddlPaymentMethod,frmErrorPopupSave">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentMethod" value="#{semmrt003Bean.rentalPayNormalSearchDSP.paymentMethod}" disabled="#{semmrt003Bean.renderedPaymentMethod}">
												<f:selectItems value="#{semmrt003Bean.paymentMethodList}"/>
												<a4j:support event="onchange" reRender="cldTransferDt,cldChqReceiveDt,cldChqDt,ddlPaymentMethod,frmErrorPopupSave"></a4j:support>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bankAccNo']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankAccNo" value="#{semmrt003Bean.rentalPayNormalSearchDSP.bankAccNo}" size="18" maxlength="15" disabled="true"/>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankName" value="#{semmrt003Bean.rentalPayNormalSearchDSP.bankName}" size="18" maxlength="15" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldChqDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmrt003Bean.rentalPayNormalSearchDSP.chqDt}"
											disabled="#{semmrt003Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.chqDt']}"
											oninputblur="validateCalendarFromToWithPaymentType('popupFrmSave','cldChqDt','cldChqReceiveDt','#{semmrt003Bean.rentalPayNormalSearchDSP.paymentMethod}');"
									 		oncollapse="validateCalendarFromToWithPaymentType('popupFrmSave','cldChqDt','cldChqReceiveDt','#{semmrt003Bean.rentalPayNormalSearchDSP.paymentMethod}');">
											</rich:calendar>
											<a4j:jsFunction name="changeDt"  ></a4j:jsFunction>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldChqReceiveDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt003Bean.rentalPayNormalSearchDSP.chqReceiveDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt003Bean.renderedChqReceiveDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.chqReceiveDt']}">
										
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldTransferDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt003Bean.rentalPayNormalSearchDSP.transferDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt003Bean.renderedTransferDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.transferDt']}">
											
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="75%">
			                			<h:inputTextarea id="txtRemark" value="#{semmrt003Bean.rentalPayNormalSearchDSP.remark}" rows="3" cols="65"/>
				                	</td>
	   		                	 </tr>			                	 
			                	 <tr>
				                	<td width="25%">
		                			</td>
		                			<td width="75%" colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmError,frmSearchResult" 
									oncomplete="if(#{semmrt003Bean.popupClose == 'true'})#{rich:component('popupRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSavePay" />
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmError">
										<rich:componentControl for="popupRentalPayNormal" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				<!-- end content criteria -->
		</a4j:form>
	</rich:modalPanel>
	
	
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mrt003PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mrt003PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mrt003PopUp_addVendor" attachTo="hide-mrt003PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMrt003PopUp_addVendor">
		
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
                				<h:inputText id="txtVendorCode" value="#{semmrt003Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmrt003Bean.vendorMasterPopupObjParam.vendorName}" 
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
					<a4j:commandButton value="Search" action="#{semmrt003Action.doSearchPopupAddVendor}"
					reRender="frmmrt003PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmrt003Action.doClearPopupAddVendor}"
					reRender="frmMrt003PopUp_addVendor, dataTable_searchVendor"
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
							var="vendorLst"  value="#{semmrt003Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmrt003Action.doSelectPopupAddVendor}"
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
										<h:outputText id="mrt003_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mrt003_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mrt003_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mrt003_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmrt003Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmrt003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmrt003Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMrt003PopUp_addVendor"></a4j:support>
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
					    <rich:componentControl for="mrt003PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->