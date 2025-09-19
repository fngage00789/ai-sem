<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
				<a4j:form id="frmSearchPay">
					<h:panelGroup>
						<table width="100%">
							<tr><td colspan="2">
									<table id="menuLink" width="100%">
										<tr>
											<td width="13%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="RENTAL" />
													<a4j:actionparam name="param1" value="" />
												</a4j:commandLink>
											</td>
											<td width="7%" align="left">
												<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="DEPOSIT" />
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.checkPremium']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-5" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doLoadCheckPremium" />
													<a4j:actionparam name="rentalMasterId" value="#{semmrt001Bean.displayFrmRental.rentalMasterId}" />
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.expenseSend']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
													<a4j:actionparam name="methodWithNavi" value="doSearch" />
												</a4j:commandLink>
											</td>
											<td width="70%" align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" style="font-size:12px;">
												</a4j:commandLink>
											</td>
										</tr>
									</table>
							</td></tr>
							<tr>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr><td>
											<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="oppContent">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="mode" value="SEARCH" />
											</a4j:commandButton>
										</td></tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td colspan="4" width="100%">
										<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
		                				<rich:calendar id="cldDueDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" 
			                			 datePattern="dd/MM/yyyy" 
			                			 value="#{semmrt001PayBean.rentalPayNormalSearchSP.dueDtFrom}" 
			                			 inputSize="13" 
										 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);"
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.dueDtTo']}"
										>
			                			</rich:calendar>
			                			<rich:spacer width="15"/>
				                		<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmSearchPay,pnlSearchResult,tblMessageRentalPay">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="frmSearchPay,pnlSearchResult,tblMessageRentalPay">
										 	<a4j:actionparam name="navModule" value="rt" />
										 	<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
											<a4j:actionparam name="methodWithNavi" value="doClear" />
						           		</a4j:commandButton>
				                	</td>
							</tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<table>
					<tr><td><rich:messages id="tblMessageRentalPay" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true" rendered="#{semmrt001PayBean.renderedMsgFormTop}"/></td></tr>
				</table>
				<h:panelGrid columns="12" id="grdSearchCommand">
							<a4j:commandButton id="btnTotalAmt" value="#{jspMsg['btn.totalDisbursement']}" styleClass="rich-button" disabled="#{semmrt001PayBean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmSearchPay,tblMessageRentalPay"
							 style="width:72">
							  			<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="AG" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleTotalAmt" value="#{jspMsg['btn.cancleTotalDisbursement']}" styleClass="rich-button" disabled="#{semmrt001PayBean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmSearchPay,tblMessageRentalPay"
							 style="width:100">
							 			<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="CG" />
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
			           		
			           		<a4j:commandButton id="btnSendReam" value="#{jspMsg['btn.sendReam']}" styleClass="rich-button" disabled="#{semmrt001PayBean.disabledBtnExport}"
			           		 action="#{navAction.navi}" reRender="pnlSearchResult,frmSearchPay,tblMessageRentalPay"
			           		 style="width:62">
			           		 			<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="AP" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleSendReam" value="#{jspMsg['btn.cancleSendReam']}" styleClass="rich-button" disabled="#{semmrt001PayBean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmSearchPay,tblMessageRentalPay"
							 style="width:100">
							 			<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="CP" />
			           		</a4j:commandButton>
			           		
			           		<rich:spacer width="15"/>
						<h:commandButton id ="btnExport" action="#{semmrt001PayAction.doExportExcel}"
			           	 styleClass="rich-button" value="#{jspMsg['btn.export']}" disabled="#{semmrt001PayBean.disabledBtnExport}" >	
	            		</h:commandButton>
						<a4j:commandButton id="btnPrint" style="width:80px" styleClass="rich-button"
	           						   reRender="frmError, frmSearchResult"
	           						   value="Print" 
	           						   disabled="#{semmrt001PayBean.disabledBtnExport}"
	           						   action="#{navAction.navi}"
	           						   >
							
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport" rendered="#{semmrt003RPTBean.displayShowReport}"/>
							</a4j:commandButton>
						</h:panelGrid>
						
				
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 4600"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt001PayBean.msgDataNotFound}" rendered="#{semmrt001PayBean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
							var="rentalPayNormalSP" value="#{semmrt001PayBean.rentalPayNormalSearchSPList}" reRender="dstRentalPayNormalSrch" 
							rows="#{semmrt001PayBean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmrt001PayAction.getRowIdOnClick}" reRender="dtbRentalPayNormalSrch">
								<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
							</a4j:support> 
							
							<rich:column styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmrt001PayBean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmrt001PayAction.selectAllRow}" reRender="dtbRentalPayNormalSrch,btnTotalAmt,
										btnCancleTotalAmt,btnCancleTotalDisbursement,btnCancleSendReam,btnSendReam,btnExport,btnPrint"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{rentalPayNormalSP.checkBox}" rendered="#{rentalPayNormalSP.dataObj.renderColumn}">
										<a4j:support event="onclick" action="#{semmrt001PayAction.onRenderExportButton}" reRender="dtbRentalPayNormalSrch,btnTotalAmt,
										btnCancleTotalAmt,btnCancleTotalDisbursement,btnCancleSendReam,btnSendReam,btnExport,btnPrint">
											<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:75px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypSavePay" value="#{jspMsg['label.cLink']}" oncomplete="#{rich:component('popupRentalPayNormal')}.show(); return false"
									 reRender="popupFrmSave,frmErrorPopupSave" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>	
										<a4j:actionparam name="paymentGroupNo" value="#{rentalPayNormalSP.dataObj.paymentGroupNo}"/>
										<a4j:actionparam name="vendorMasterId" value="#{rentalPayNormalSP.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="payeeId" value="#{rentalPayNormalSP.dataObj.payeeId}"/>
										<a4j:actionparam name="expenseType" value="#{rentalPayNormalSP.dataObj.expenseType}"/>
										<a4j:actionparam name="contractNo" value="#{rentalPayNormalSP.dataObj.contractNo}"/>
										<a4j:actionparam name="statusEdit" value="savePay"/>		
										<a4j:actionparam name="pageStatus" value="SavePay"/>
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="Edit" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnEdit" image="images/edit.png" style="height: 15; width: 15;" oncomplete="#{rich:component('popupEditRentalPayNormal')}.show(); return false"
									 action="#{navAction.navi}" reRender="popupFrmEdit">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>	
										<a4j:actionparam name="pageStatus" value="initEdit"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.contractNo}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.contractNo}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentalPayNormalSP.dataObj.siteName}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.siteName}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.effDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}"   styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.effDt}" styleClass="contentform"  >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expDt}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueDt}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseTypeDesc}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expenseTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseDesc}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseDesc']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expenseDesc}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.serviceName}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="service" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.serviceName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.verdorId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodY}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodY']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodY}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodM}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodM']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodM}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodD}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodD']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodD}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform"  style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expStatus}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expApprove}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expApprove']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expApprove}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentRequestDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentRequestDt']}" styleClass="contentform"  style="width:100px"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentRequestDt}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentType}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankName}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqDt}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqReceiveDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqReceiveDt}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.transferDt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.transferDt}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pettyAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remark}" styleClass="#{(semmrt001PayBean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPayNormalSrch" 
									maxPages="10" id="dstRentalPayNormalSrch" selectedStyleClass="selectScroll" 
									page="#{semmrt001PayBean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/rt/semmrt001-4Popup.jsp"/>
			<jsp:include page="../../pages/rt/semmrt001Pay-popupSavePay.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>