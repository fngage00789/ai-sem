<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.account.semmac004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="Manual Interface SAP"/></f:facet>
		<h:panelGrid>
		<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac004Bean.renderedMsgFormSearch}">
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
				<h:panelGrid width="96%">
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
											<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td colspan="3" width="80%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmac004Bean.mac004Srch.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmac004Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmac004Bean.mac004Srch.company}" styleClass="ms28"/>
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
		                				<h:selectOneMenu id="ddlModuleType" value="#{semmac004Bean.mac004Srch.moduleType}" onchange="ChangeModuleType();">
											<f:selectItems value="#{semmac004Bean.moduleTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeModuleType" action="#{semmac004Action.onRenderExpenseType}"  
													 reRender="ddlExpenseType"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtContractNo" value="#{semmac004Bean.mac004Srch.contractNo}" size="23" maxlength="20"/>
				                	</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmac004Bean.mac004Srch.expenseType}" onchange="ChangeModuleType();">
											<f:selectItems value="#{semmac004Bean.expenseTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Vendor Code :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorCode" value="#{semmac004Bean.mac004Srch.vendorCode}" 
										style="margin-right:5px;" size="23" maxlength="20"/>
										
										<!-- >> fixed by.. YUT 2015/10/18 -->
			                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
							            action="#{semmac004Action.initAddVendor}" reRender="oppContent"
							            oncomplete="#{rich:component('mac004PopUp_addVendor')}.show(); return false">
										</a4j:commandButton>
			                			<!-- << -->	
									</td>
									<td align="right" width="20%">
										<h:outputText value="Vendor Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorName" value="#{semmac004Bean.mac004Srch.vendorName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
								<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtDocNo" value="#{semmac004Bean.mac004Srch.docNo}" size="23" maxlength="20"/>
				                	</td>
				                	
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentBatchNo']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtBatchNo" value="#{semmac004Bean.mac004Srch.paymentBatchNo}" size="23" maxlength="20"/>
		                				
		                			
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.refSem2']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPaymentDocNo" value="#{semmac004Bean.mac004Srch.refSem}" size="23" maxlength="20"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docNoStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentStatus" value="#{semmac004Bean.mac004Srch.paymentStatus}">
											<f:selectItems value="#{semmac004Bean.paymentStatusList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.doc68']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText value="#{semmac004Bean.mac004Srch.doc68}" size="23" maxlength="20"/>
									</td>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.docPayment']}" styleClass="ms7"/>
									</td>
									<td width="30%">
									<h:inputText value="#{semmac004Bean.mac004Srch.docPayment}" size="23" maxlength="20"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docCancel']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText value="#{semmac004Bean.mac004Srch.docCancel}" size="23" maxlength="20"/>
									</td>
									<td align="right" width="20%">
									</td>
									<td width="30%">
									</td>
								</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,pnlSearchResult">
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />			
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}" 
							 reRender="frmError,pnlSearchResult,pnlSearchCriteria">
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
									<a4j:actionparam name="methodWithNavi" value="doClearSession" />							
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
								
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="List Interface SAP" style="width: 3020"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmac004Bean.msgDataNotFound}" rendered="#{semmac004Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac004Bean.renderedMsgFormMiddle}"/>
						</div>
						 <rich:dataTable id="dtbMac004Srch" cellpadding="1" cellspacing="0" border="0"
							var="mac004SrchSP" value="#{semmac004Bean.mac004SrchList}" reRender="dstMac004Srch" 
							rows="#{semmac004Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmac004Action.getRowIdOnClick}" reRender="dtbMac004Srch">
								<a4j:actionparam name="rowId" value="#{mac004SrchSP.rowId}" />
							</a4j:support> 
							<rich:column id="btnApprove" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkApprove" value="#{jspMsg['btn.manual']}" action="#{navAction.navi}" reRender="popupFrmSave"
									 oncomplete="#{rich:component('popupApproveForm')}.show(); return false" >
					           		  		<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
											<a4j:actionparam name="moduleWithNavi" value="ac" />
											<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{mac004SrchSP.rowId}" />		         		 
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{mac004SrchSP.refSem}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.refSem']}" styleClass="contentform"  style="width:130px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.refSem}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mac004SrchSP.expenseType}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mac004SrchSP.periodNo}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.periodNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.periodStartDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodStartDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.periodStartDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.periodEndDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodEndDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.periodEndDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.contractNo}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{mac004SrchSP.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mac004SrchSP.siteInfoId}" />
									</a4j:commandLink>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.preSiteContracNo}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.preContractNo']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypViewPreSiteInfo" value="#{mac004SrchSP.preSiteContracNo}" rendered="#{mac004SrchSP.renderedLinkPrecontract}"
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mac004SrchSP.preSiteInfoId}" />
									</a4j:commandLink>								
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.siteStatus}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.siteStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.paymentBatchNo}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.batchNo']}" styleClass="contentform" style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.paymentBatchNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.networkStatus}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.netwrokStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.networkStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.docNo}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Invoice No" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.docNo}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac004SrchSP.totalAmt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Amount" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac004SrchSP.totalAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac004SrchSP.payAmt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Net Amount" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac004SrchSP.payAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mac004SrchSP.jobDay}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.jobDay']}" styleClass="contentform"  style="width:12px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mac004SrchSP.jobDay}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.paymentStatusDesc}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<a4j:commandLink id="hlkPopupSap" value="Reject SAP" 
									 oncomplete="#{rich:component('popupView')}.show(); return false"
									 rendered="#{mac004SrchSP.renderedLinkSap}"
									 action="#{semmac001Action.doSearchR}"
									 reRender="popupFrmView">
										<a4j:actionparam name="rowId" value="#{mac004SrchSP.rowId}" />
									</a4j:commandLink>
									<h:outputText value="#{mac004SrchSP.paymentStatusDesc}" styleClass="contentform" rendered="#{mac004SrchSP.renderedPaymentStatusDesc}"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.chqDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.chqDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.chqReceiveDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.chqReceiveDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.doc68}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc68']}" styleClass="contentform"  style="width:70px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.doc68}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.doc68Dt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc68Dt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.doc68DtDisplay}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.docPayment}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docPayment']}" styleClass="contentform"  style="width:70px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.docPayment}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.docPaymentDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docPaymentDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.docPaymentDtDisplay}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.docCancel}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCancel']}" styleClass="contentform"  style="width:70px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.docCancel}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.docCancelDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCancelDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.docCancelDtDisplay}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.updateBy}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform"  style="width:70px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.updateBy}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac004SrchSP.updateDt}" styleClass="#{(semmac004Bean.tmpRowId==mac004SrchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Update Date" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac004SrchSP.updateDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmac004Bean.mac004SrchList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="22">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMac004Srch" 
										maxPages="10" id="dstMac004Srch" selectedStyleClass="selectScroll" 
										page="#{semmac004Bean.scrollerPage}"/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/ac/semmac004-popup.jsp" />
			<jsp:include page="../../pages/popup/viewSap-popup.jsp" />
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

