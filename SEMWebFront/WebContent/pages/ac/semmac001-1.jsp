<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.account.semmac001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>

		<h:panelGroup style="width:100%;">		
		
		<h:panelGrid>
		<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right" width="20%" valign="bottom">
				                	<h:panelGroup>
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td colspan="3" width="80%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmac001Bean.mac001Srch.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmac001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmac001Bean.mac001Srch.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="Module :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlModuleType" value="#{semmac001Bean.mac001Srch.moduleType}" onchange="ChangeModuleType();">
											<f:selectItems value="#{semmac001Bean.moduleTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeModuleType" action="#{semmac001Action.onRenderExpenseType}"  
													 reRender="ddlExpenseType">
															
										</a4j:jsFunction>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmac001Bean.mac001Srch.expenseType}">
											<f:selectItems value="#{semmac001Bean.expenseTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlSiteStatus" value="#{semmac001Bean.mac001Srch.siteStatus}">
											<f:selectItems value="#{semmac001Bean.siteStatusList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.batchNumber']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtBatchNo" value="#{semmac001Bean.mac001Srch.paymentBatchNo}" size="23" maxlength="20"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtDocNo" value="#{semmac001Bean.mac001Srch.paymentDocnoSrch}" size="23" maxlength="20"/>
									</td>
							</tr>
							<tr>
								<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtContractNo" value="#{semmac001Bean.mac001Srch.contractNo}" size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.policyNo']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPolicyNo" value="#{semmac001Bean.mac001Srch.policyNo}" size="23" maxlength="20"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentStatus" value="#{semmac001Bean.mac001Srch.paymentStatus}">
											<f:selectItems value="#{semmac001Bean.paymentStatusList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.paymentDocType']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentDocType" value="#{semmac001Bean.mac001Srch.paymentDocType}">
											<f:selectItems value="#{semmac001Bean.paymentDocType}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.paymentDocNo']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPaymentDocNo" value="#{semmac001Bean.mac001Srch.paymentDocNo}" size="23" maxlength="20"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Vendor Code :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorCode" value="#{semmac001Bean.mac001Srch.vendorCode}" 
										style="margin-right:5px;" size="23" maxlength="20"/>
										
										<!-- >> fixed by.. YUT 2015/10/18 -->
			                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
							            action="#{semmac001Action.initAddVendor}" reRender="oppContent"
							            oncomplete="#{rich:component('mac001PopUp_addVendor')}.show(); return false">
										</a4j:commandButton>
			                			<!-- << -->	
									</td>
									<td align="right" width="20%">
										<h:outputText value="Vendor Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorName" value="#{semmac001Bean.mac001Srch.vendorName}" size="23" maxlength="20"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtSiteName" value="#{semmac001Bean.mac001Srch.siteName}" size="30" maxlength="255"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentType" value="#{semmac001Bean.mac001Srch.paymentType}">
											<f:selectItems value="#{semmac001Bean.paymentTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldPaymentDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.paymentDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.paymentDtFrom']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldPaymentDtFrom','cldPaymentDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldPaymentDtFrom','cldPaymentDtTo');"
											   >
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="To :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldPaymentDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.paymentDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.paymentDtTo']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldPaymentDtTo','cldPaymentDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldPaymentDtTo','cldPaymentDtFrom');"
											   >
										</rich:calendar>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.chqReceiveDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldChqReceiveDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.chqReceiveDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.chqReceiveDtFrom']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldChqReceiveDtFrom','cldChqReceiveDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldChqReceiveDtFrom','cldChqReceiveDtTo');"
											   >
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="To :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldChqReceiveDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.chqReceiveDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.chqReceiveDtTo']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldChqReceiveDtTo','cldChqReceiveDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldChqReceiveDtTo','cldChqReceiveDtFrom');"
											   >
										</rich:calendar>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.transferDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldTransferDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.transferDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.transferDtFrom']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldTransferDtFrom','cldTransferDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldTransferDtFrom','cldTransferDtTo');"
											   >
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="To :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldTransferDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac001Bean.mac001Srch.transferDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.transferDtTo']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldTransferDtTo','cldTransferDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldTransferDtTo','cldTransferDtFrom');"
											   >
										</rich:calendar>
									</td>
							</tr>
							
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
							reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="ac" />
								<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
								<a4j:actionparam name="moduleWithNavi" value="ac" />
								<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />							
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
							reRender="frmError,pnlSearchResult,pnlSearchCriteria,btnApprove,btnReject">
								<a4j:actionparam name="navModule" value="ac" />
								<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
								<a4j:actionparam name="moduleWithNavi" value="ac" />
								<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />							
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
					<table border="0" width="100%">
						<tr>
							<td align="left" width="70%">
								<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmac001Bean.disabledBtnExport}"
					           		 oncomplete="#{rich:component('popupRemarkApprove')}.show(); return false" 
					           		  action="#{navAction.navi}" reRender="popupRemarkApprove,pnlSearchResult,frmError"
					           		  rendered="#{semmac001Bean.renderer['btnApprove']}">
					           		  	<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNavi" value="initApprove" />
										<a4j:actionparam name="btnApproveStatus" value="AA" />			           		 
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmac001Bean.disabledBtnExport}"
					           		 oncomplete="#{rich:component('popupRemarkApprove')}.show(); return false" 
					           		  action="#{navAction.navi}" reRender="popupRemarkApprove,pnlSearchResult,frmError"
					           		  rendered="#{semmac001Bean.renderer['btnReject']}">
					           		  	<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNavi" value="initApprove" />
										<a4j:actionparam name="btnApproveStatus" value="CA" />			           		 
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
							</td>
							<td align="right">
								<a4j:commandButton id="btnImportFile"
								reRender="oppContent"
								value="#{jspMsg['btn.import']}" styleClass="rich-button"
								style="width:110"
								oncomplete="#{rich:component('popupImportFile')}.show(); return false" 
								rendered="#{semmac001Bean.renderer['btnLoadFile']}">
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="100%">
					<rich:panel id="pnlSearchResult" >
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.result.name']}"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmac001Bean.msgDataNotFound}" rendered="#{semmac001Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac001Bean.renderedMsgFormMiddle}"/>
						</div>
						
					<center>				
					<div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">

						 <rich:dataTable id="dtbMac001Srch" cellpadding="1" cellspacing="0" border="0"
							var="mac001SrchSP" value="#{semmac001Bean.mac001SrchList}" reRender="dstMac001Srch" 
							rows="#{semmac001Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmac001Action.getRowIdOnClick}" reRender="dtbMac001Srch">
								<a4j:actionparam name="paymentGroupNo" value="#{mac001SrchSP.dataObj.paymentGroupNo}" />
							</a4j:support> 
							<rich:column styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmac001Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmac001Action.selectAllRow}" reRender="dtbMac001Srch,btnApprove,btnReject"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mac001SrchSP.checkBox}" rendered="#{mac001SrchSP.dataObj.renderCheckBox}">
										<a4j:support event="onclick" action="#{semmac001Action.onRenderExportButton}" reRender="dtbMac001Srch,btnApprove,btnReject">
											<a4j:actionparam name="rowId" value="#{mac001SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{mac001SrchSP.dataObj.paymentDocNo}" style="width:90px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentDocNo']}" styleClass="contentform" />
								</f:facet>
								<a4j:commandLink id="hypEdit" value="#{mac001SrchSP.dataObj.paymentDocNo}" 
								style="white-space:nowrap;" action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-2" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{mac001SrchSP.dataObj.rowId}" />	
										<a4j:actionparam name="statusPage" value="SEMMAC001" />
										<a4j:actionparam name="navModuleFrom" value="ac" />
										<a4j:actionparam name="navProgramFrom" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNaviFrom" value="ac" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNaviFrom" value="doBack" />
								</a4j:commandLink>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.preContractNo}" style="width:50px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value=""   styleClass="contentform"/>
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.reqType}"/>
							</rich:column>
							<rich:column sortBy="#{mac001SrchSP.dataObj.expenseType}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mac001SrchSP.dataObj.expenseDesc}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseDesc']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.expenseDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mac001SrchSP.dataObj.periodNo}" style="width:50px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform" />
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.periodNo}" styleClass="contentform" />
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.periodStartDt}" style="width:100px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodStartDt']}" styleClass="contentform" />
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.periodStartDt}" styleClass="contentform" style="white-space:nowrap;">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.periodEndDt}" style="width:100px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodEndDt']}" styleClass="contentform"/>
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.periodEndDt}" styleClass="contentform" style="white-space:nowrap;">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.contractNo}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{mac001SrchSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mac001SrchSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.siteStatus}" style="width:100px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="contentform" style="white-space:nowrap;"/>
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.siteStatus}" styleClass="contentform" />
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.networkStatus}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.networkStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<%-- commented by.. YUT 2015/02/12 --%>
							<%-- 
							<rich:column  sortBy="#{mac001SrchSP.dataObj.pmsStatus}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pmsStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.pmsStatus}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							--%>
							
							<rich:column  sortBy="#{mac001SrchSP.dataObj.invoiceNo}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Invoice No" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.invoiceNo}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac001SrchSP.dataObj.totalAmt}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="INC_AMT" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac001SrchSP.dataObj.totalAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac001SrchSP.dataObj.chequeAmt}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="CHEQUE_AMT" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac001SrchSP.dataObj.chequeAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.whtAmt}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="WHT_AMT" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac001SrchSP.dataObj.whtAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac001SrchSP.dataObj.jobDay}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.jobDay']}" styleClass="contentform"  style="width:12px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac001SrchSP.dataObj.jobDay}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.paymentStatusDesc}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<a4j:commandLink id="hlkPopupSap" value="Reject SAP" 
									 oncomplete="#{rich:component('popupView')}.show(); return false"
									 rendered="#{mac001SrchSP.dataObj.renderedLinkSap}"
									 action="#{semmac001Action.doSearchR}"
									 reRender="popupFrmView">
										<a4j:actionparam name="rowId" value="#{mac001SrchSP.dataObj.rowId}" />
									</a4j:commandLink>
									<h:outputText value="#{mac001SrchSP.dataObj.paymentStatusDesc}" styleClass="contentform" rendered="#{mac001SrchSP.dataObj.renderedPaymentStatusDesc}"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.chqDt}" style="width:100px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform" />
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.chqDt}" styleClass="contentform" style="white-space:nowrap;">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.chqReceiveDt}" style="width:100px; text-align:center;"
							styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform" />
								</f:facet>
								<h:outputText value="#{mac001SrchSP.dataObj.chqReceiveDt}" styleClass="contentform" style="white-space:nowrap;">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</rich:column>
							<rich:column  sortBy="#{mac001SrchSP.dataObj.fileName}" styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="File Name" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac001SrchSP.dataObj.fileName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column styleClass="#{(semmac001Bean.tmpRowId==mac001SrchSP.dataObj.paymentGroupNo)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnUploadPicture"
										action="#{navAction.navi}"
										reRender="oppContent,popupUploadPictureCriteria"
										value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
										oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
										<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value=""/>
										<a4j:actionparam name="contractNo" value="#{mac001SrchSP.dataObj.contractNo}"/>
										<a4j:actionparam name="viewMode" value="Y"/>
									</a4j:commandButton>
								</div>
							</rich:column>	
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmac001Bean.mac001SrchList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="16">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMac001Srch" 
										maxPages="10" id="dstMac001Srch" selectedStyleClass="selectScroll" 
										page="#{semmac001Bean.scrollerPage}"/>
									</rich:column>
								</rich:columnGroup>		
							</f:facet>
						</rich:dataTable>
						
						<div align="left">
							<div style="clear:both; height:5px;"></div>
							<h:outputText value="***" style="font-style:bold; color:red; padding:0 5px 0 5px;" />
							<h:outputText value="N = NEW, R = RENEW, C = CHANGE, E = EXTRA" styleClass="ms7" style="font-style:italic;" />
							<div style="clear:both; height:5px;"></div>
						</div>
						
					</div>	
					</center>					
					
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/ac/semmac001-popupRemark.jsp" />
			<jsp:include page="../../pages/popup/viewSap-popup.jsp" />
		</h:panelGrid>
		
		</h:panelGroup>
		
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="popupImportFile" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Upload Info"></h:outputText>
    </f:facet>
	<a4j:form id="frmUploadInfo">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listener}"
								listHeight="50" listWidth="300"
								addControlLabel="Browse..."
								immediate="true"
								immediateUpload="true" uploadButtonClassDisabled="true" cleanButtonClassDisabled="true"
								autoclear="true" acceptedTypes="xls,xlsx" >
									<a4j:support event="onuploadcomplete" reRender="frmSearchIR008" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC001" />
										<a4j:actionparam name="methodWithNavi" value="doImport" />
									</a4j:support>
									<a4j:support event="oncomplete" reRender="frmSearch"/>
									<rich:componentControl for="popupImportFile" operation="hide" event="oncomplete"/>
										
					</rich:fileUpload>
					
				</td>
			</tr>
			<tr>
				<td align="left">
					<h:panelGrid columns="1" styleClass="contentlabelform">
						<a4j:commandButton id="btnPopupBack" value="Close" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="popupImportFile" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>