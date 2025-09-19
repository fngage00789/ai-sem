<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac001" var="jspMsg"/>
	<rich:modalPanel id="popupViewApproveForms" width="600" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupViewApproveForms" style="cursor:pointer"/>
					<rich:componentControl for="popupViewApproveForms" attachTo="hidePopupViewApproveForms" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupSave">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmSave"> 
			<rich:panel id="pnlApproveForm">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupApprove']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentTypePopupSave" value="#{semmac001Bean.mac001SrchD.paymentType}" onchange="ChangeCalendar();">
											<f:selectItems value="#{semmac001Bean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmac001Action.onRenderPaymentMethod}"  
										 reRender="cldChqDtPopupSave,cldChqReceiveDtPopupSave,cldTransferDtPopupSave,ddlPaymentMethodPopupSave">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentMethodPopupSave" value="#{semmac001Bean.mac001SrchD.paymentMethod}" disabled="#{semmac001Bean.disablePaymentMethod}">
											<f:selectItems value="#{semmac001Bean.paymentMethodList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.chqDtPopup']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldChqDtPopupSave" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac001Bean.mac001SrchD.chqDt}"
											disabled="#{semmac001Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.chqDt']}">
												
											</rich:calendar>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldChqReceiveDtPopupSave" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac001Bean.mac001SrchD.chqReceiveDt}"
											disabled="#{semmac001Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.chqDt']}">
											
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
		                				<rich:calendar id="cldTransferDtPopupSave" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" showWeeksBar="false"
										inputSize="13" value="#{semmac001Bean.mac001SrchD.transferDt}"
										disabled="#{semmac001Bean.renderedTransferDt}"
										/>
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
									<a4j:commandButton id="btnPopupSave" value="Save" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupSave,dtbMac001Srch,frmError,frmSearch2" 
									oncomplete="if(#{semmac001Bean.popupClose == 'true'})#{rich:component('popupViewApproveForms')}.hide();">
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNavi" value="doSavePay" />
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupSave,dtbMac001Srch,frmError">
										<rich:componentControl for="popupViewApproveForms" operation="hide" event="onclick" />
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
	
	<rich:modalPanel id="popupSap" width="920" height="480" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupRemarkApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupSap" style="cursor:pointer"/>
					<rich:componentControl for="popupSap" attachTo="hidePopupSap" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmSap">
			 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
								<f:facet name="header" >
									<h:outputText value="#{jspMsg['btn.viewSap']}" style="width: 1500"/>
								</f:facet>
								<div align="center">
									<h:outputLabel style="color:red;size:20px" value="#{semmac001Bean.msgDataNotFound}" rendered="#{semmac001Bean.renderedMsgDataNotFound}" />
								</div>
								 <rich:dataTable id="dtbMac001Sap" cellpadding="1" cellspacing="0" border="0" width="90%"
									var="mac001Sap" value="#{semmac001Bean.mac001SapList}" reRender="dstMac001Sap" 
									rows="#{semmac001Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
									
									<rich:column  sortBy="#{mac001Sap.drcr}" >
										<f:facet name="header">
											<h:outputText value="D/C" styleClass="contentform" style="width:12px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.drcr}" styleClass="contentform"/>
										</div>
									</rich:column>
									<rich:column sortBy="#{mac001Sap.accNo}" >
										<f:facet name="header">
											<h:outputText value="Acc Number" styleClass="contentform"  style="width:72px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.accNo}" styleClass="contentform" />
										</div>
									</rich:column>
									<rich:column sortBy="#{mac001Sap.specialGl}" >
										<f:facet name="header">
											<h:outputText value="Special GL" styleClass="contentform"  style="width:12px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.specialGl}" styleClass="contentform" />
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.accDesc}" >
										<f:facet name="header">
											<h:outputText value="Acc Desc" styleClass="contentform"  style="width:90px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.accDesc}" styleClass="contentform"/>
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.expenseDesc}" >
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.expenseDesc']}" styleClass="contentform"  style="width:90px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.expenseDesc}" styleClass="contentform"/>
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.costCenter}" >
										<f:facet name="header">
											<h:outputText value="Cost Center" styleClass="contentform"  style="width:60px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.costCenter}" styleClass="contentform"/>
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.wbsNo}" >
										<f:facet name="header">
											<h:outputText value="WBS" styleClass="contentform" style="width:150px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.wbsNo}" styleClass="contentform" />
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.amount}" >
										<f:facet name="header">
											<h:outputText value="Amount" styleClass="contentform" style="width:110px"/>
										</f:facet>
										<div align="right">
											<h:outputText value="#{mac001Sap.amount}" styleClass="contentform">
												<f:convertNumber pattern="#,##0.00"/>
											</h:outputText>
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.taxCode}" >
										<f:facet name="header">
											<h:outputText value="TAX Code" styleClass="contentform"  style="width:12px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{mac001Sap.taxCode}" styleClass="contentform" >
											</h:outputText>
										</div>
									</rich:column>
									<rich:column  sortBy="#{mac001Sap.taxBase}" >
										<f:facet name="header">
											<h:outputText value="Tax Base" styleClass="contentform"  style="width:110px"/>
										</f:facet>
										<div align="right">
											<h:outputText value="#{mac001Sap.taxBase}" styleClass="contentform">
												<f:convertNumber pattern="#,##0.00"/>
											</h:outputText>
										</div>
									</rich:column>	
									<rich:column  sortBy="#{mac001Sap.whtCode}" >
										<f:facet name="header">
											<h:outputText value="WHT Code" styleClass="contentform"  style="width:12px"/>
										</f:facet>
										<div align="right">
											<h:outputText value="#{mac001Sap.whtCode}" styleClass="contentform"/>
										</div>
									</rich:column>	
									<rich:column  sortBy="#{mac001Sap.whtBase}" >
										<f:facet name="header">
											<h:outputText value="WHT Base" styleClass="contentform"  style="width:110px"/>
										</f:facet>
										<div align="right">
											<h:outputText value="#{mac001Sap.whtBase}" styleClass="contentform">
												<f:convertNumber pattern="#,##0.00"/>
											</h:outputText>
										</div>
									</rich:column>	
									<rich:column  sortBy="#{mac001Sap.whtAmt}" >
										<f:facet name="header">
											<h:outputText value="WHT Amount" styleClass="contentform"  style="width:110px"/>
										</f:facet>
										<div align="right">
											<h:outputText value="#{mac001Sap.whtAmt}" styleClass="contentform">
												<f:convertNumber pattern="#,##0.00"/>
											</h:outputText>
										</div>
									</rich:column>									
									<rich:column  sortBy="#{mac001Sap.lineItemText}" >
										<f:facet name="header">
											<h:outputText value="Line Item Text" styleClass="contentform"  style="width:180px"/>
										</f:facet>
										<div align="left">
											<h:outputText value="#{mac001Sap.lineItemText}" styleClass="contentform"/>
										</div>
									</rich:column>
									
									<f:facet name="footer">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMac001Sap" 
											maxPages="10" id="dstMac001Sap" selectedStyleClass="selectScroll" 
											page="#{semmac001Bean.scrollerPage}"/>
									</f:facet>
								</rich:dataTable>
							</rich:panel>
						</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>