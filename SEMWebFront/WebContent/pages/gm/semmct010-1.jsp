<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct010" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Leader Approve" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct010Bean.renderedMsgFormSearch}" style="width : 302px; height : 21px;">
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                 </rich:messages>
            </a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<h:panelGrid  width="90%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                
		                	<h:panelGrid width="90%" columns="4" border="0" cellspacing="0">
		                	<h:panelGroup>
		                	<table width="100%">
		                		<tr>
		                		<td align="right" width="20%">
		                		<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7" />
		                		</td>
		                		<td width="30%">
			                		<h:selectOneMenu id="txtCompany" value="#{semmct010Bean.criteriaVendorSP.company}" onchange="reRenderBtnExport();" >
			                			<f:selectItems value="#{semmct010Bean.companyList}"/>
			                		</h:selectOneMenu></td>
			                		<a4j:jsFunction name="reRenderBtnExport" reRender="btnExportBank"></a4j:jsFunction>
		                		<td align="right" width="20%"><h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7" /></td>
		                		<td width="30%">
			                		<h:inputText id="txtRegion" value="#{semmct010Bean.criteriaVendorSP.region}" maxlength="25" onblur="reRenderBtnExport();"></h:inputText>
			                		<rich:spacer width="5"/>
			                		<h:selectBooleanCheckbox id="picoFlag" value="#{semmct010Bean.criteriaVendorSP.picoFlag}"></h:selectBooleanCheckbox>
			                		<rich:spacer width="5"/>
			                		<h:outputText value="#{jspMsg['label.pico']}" styleClass="ms7"/>
		                		</tr>
		                		<tr>
		                		<td align="right" width="20%">
		                		<h:outputText value="#{jspMsg['label.vendorCode']} :" styleClass="ms7" />
		                		</td>
		                		<td width="30%">
		                			<h:inputText id="txtVendorCode" value="#{semmct010Bean.criteriaVendorSP.vendorCode}" 
		                			style="margin-right:5px;" label="#{jspMsg['label.vendorCode']}" >
		                			</h:inputText>
		                			
		                			<!-- >> fixed by.. YUT 2015/10/18 -->
		                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
						            action="#{semmct010Action.initAddVendor}" reRender="oppContent"
						            oncomplete="#{rich:component('mct010PopUp_addVendor')}.show(); return false">
									</a4j:commandButton>
		                			<!-- << -->	
		                		</td>
		                		<td align="right" width="20%"><h:outputText value="#{jspMsg['label.vendorName']} :" styleClass="ms7" /></td>
		                		<td width="30%"><h:inputText id="txtVendorName" value="#{semmct010Bean.criteriaVendorSP.vendorName}" maxlength="255"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.idCard']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtIdCard" value="#{semmct010Bean.criteriaVendorSP.idCard}" maxlength="13"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.taxId']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtTaxId" value="#{semmct010Bean.criteriaVendorSP.taxId}" maxlength="13"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.contactNo']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtContactNo" value="#{semmct010Bean.criteriaVendorSP.contractNo}" maxlength="20"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.siteName']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtSiteName" value="#{semmct010Bean.criteriaVendorSP.siteName}" maxlength="255"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.accNo']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtBankAccNo" value="#{semmct010Bean.criteriaVendorSP.bankAccNo}" maxlength="15"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.accName']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtBankAccName" value="#{semmct010Bean.criteriaVendorSP.bankAccName}" maxlength="255"></h:inputText></td>
		                		</tr>
		                		
		                		<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.status']} Vendor :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
	                			<h:selectOneMenu id="ddlVendorStatus" value="#{semmct010Bean.criteriaVendorSP.vendorStatus}">
								<f:selectItems value="#{semmct010Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.status']} BookBank :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:selectOneMenu id="ddlBookBank" value="#{semmct010Bean.criteriaVendorSP.bookBankStatus}"> 
								<f:selectItems value="#{semmct010Bean.bookbankStatusSelList}"/>
								</h:selectOneMenu>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.payeeStatus']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
	                			<h:selectOneMenu id="ddlVendorPayeeStatus" value="#{semmct010Bean.criteriaVendorSP.payeeStatus}">
								<f:selectItems value="#{semmct010Bean.payeeStatusSelList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.status']} Payee BookBank :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:selectOneMenu id="ddlBookBankPayee" value="#{semmct010Bean.criteriaVendorSP.payeeBookBankStatus}"> 
								<f:selectItems value="#{semmct010Bean.payeeBookbankStatusSelList}"/>
								</h:selectOneMenu>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.batchNo']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
								<h:inputText id="txtBatchNo" value="#{semmct010Bean.criteriaVendorSP.batchNo}" maxlength="15"></h:inputText>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.lotNo']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:inputText id="txtLotNo" value="#{semmct010Bean.criteriaVendorSP.lotNo}" maxlength="15"></h:inputText>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.createByUser']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
								<h:inputText id="txtCrateByUser" value="#{semmct010Bean.criteriaVendorSP.createBy}"></h:inputText>
			                	</td>
			                	<td align="right" width="20%">
								
	                			</td>
	                			<td width="30%" >
	                			
				                </td>
			                	</tr>
		                		</table>
		                		 </h:panelGroup>
		                	</h:panelGrid>
		                	
		               
		               
		                <h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,panSearchCriteria,pnlSearchResult" >
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT010" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>
			            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,pnlSearchResult">
			            		<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT010" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
			             
	            	</h:panelGrid>
		            </rich:panel>
		            
				</h:panelGrid>
	            
				<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
				<table width="100%" border="0">
				<tr align="left">
				<td>
					<a4j:commandButton id="btnApproveBookbankPayee" value="Approve" styleClass="rich-button" disabled="#{semmct010Bean.disabledButtonApprove}"
					 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
			         rendered="#{semmct010Bean.rendererSSO['btnSMBVM001'] and semmct010Bean.renderer['btnApproveBookbankPayee']}"
			         action="#{navAction.navi}" reRender="popupApproveBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT010-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="approve" />
					</a4j:commandButton>
         			<rich:spacer width="5"/>
					<a4j:commandButton id="btnRejectBookbankPayee" value="Reject" styleClass="rich-button" disabled="#{semmct010Bean.disabledButtonApprove}"
					 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
			         rendered="#{semmct010Bean.rendererSSO['btnSMBVM001'] and semmct010Bean.renderer['btnRejectBookbankPayee']}"
			         action="#{navAction.navi}" reRender="popupApproveBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT010-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="reject" />
					</a4j:commandButton>
           		</td>
           		</tr>
           		</table>
           		</h:panelGroup>
           		</h:panelGrid>
             
				<h:panelGrid width="90%">
					
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style = "width :2300px "/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct010Bean.msgDataNotFound}" rendered="#{semmct010Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						<rich:dataTable width="95%" id="dtbVendor" cellpadding="1" cellspacing="0" border="0"
							var="vendor" value="#{semmct010Bean.vendorMasterList}" reRender="dstVendor" 
							rows="#{semmct010Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							
							<rich:column styleClass="#{(semmct010Bean.tmpRowId==vendor.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmct010Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmct010Action.selectAllRow}" reRender="dtbVendor,btnApproveBookbankPayee,btnRejectBookbankPayee"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="chkSelect"  value="#{vendor.checkBox}" rendered="#{vendor.dataObj.renderedChkSelect}">
									<a4j:support event="onclick" action="#{semmct010Action.onRender}" reRender="dtbVendor,btnApproveBookbankPayee,btnRejectBookbankPayee">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.rowId}" />
									</a4j:support>
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							
							<rich:column rendered="false" >
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" image="images/edit.png" 
	            									   style="height: 15; width: 15" reRender="oppContent"
	            									   id="btnEdit">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="isQueryContract" value="false"></a4j:actionparam>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="navModuleFrom" value="gm" />
										<a4j:actionparam name="navProgramFrom" value="SEMMCT001-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT001" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="modePanelInfo" value="INSERT" />
										<a4j:actionparam name="eventType" value="Edit" />
										<a4j:actionparam name="isPageFrom" value="true" />
										<a4j:actionparam name="contractNo" value="#{vendor.dataObj.contractNo}" />
										<a4j:actionparam name="expenseType" value="#{vendor.dataObj.expenseType}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column rendered="false">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            									   action="#{navAction.navi}" 
	            									   image="images/delete.png" style="height: 15; width: 15"
	            									   id="btnDelete"
	            									   rendered="#{vendor.dataObj.vendorCode eq null}">
										<a4j:actionparam name="navModule" value="gm" />
		            					<a4j:actionparam name="navProgram" value="SEMMCT001-1" />	
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="mode" value="DELETE" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton  id="btnView" action="#{navAction.navi}" 
						            					image="images/view.png" 
						            					style="height: 15; width: 15"
						            					reRender="oppContent">
	            						<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="isQueryContract" value="false"></a4j:actionparam>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
										<a4j:actionparam name="methodWithNavi" value="pageLoadCrossBean" />
										<a4j:actionparam name="navModuleFrom" value="gm" />
										<a4j:actionparam name="navProgramFrom" value="SEMMCT010-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT010" />
										<a4j:actionparam name="mode" value="SELECT"/>
										<a4j:actionparam name="isPageFrom" value="true" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.actionType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.actionType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.branchId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.branchId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" styleClass="contentform" style = "width :200px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.idCard']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contactNo']}" styleClass="contentform" style = "width :100px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseTypeDesc']}" styleClass="contentform" style = "width :200px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.expenseTypeDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.reqType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style = "width :200px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankName']}" styleClass="contentform" style = "width :200px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankAccountNo']}" styleClass="contentform" style = "width :200px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} Vendor" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorStatus}" styleClass="contentform" 
									rendered="#{vendor.dataObj.renderedVendorRejectPopup == false}" />
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,mct010_popupReject"
	            					id="mct010_cmlVendorStatus" value="#{vendor.dataObj.vendorStatus}"
	            					rendered="#{vendor.dataObj.renderedVendorRejectPopup}"
	            					oncomplete="#{rich:component('mct010_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT010-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="VV" />
	            					</a4j:commandLink>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} BookBank" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorBookbankStatus}" styleClass="contentform" 
									rendered="#{vendor.dataObj.renderedVendorBookbankRejectPopup == false}" />
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,mct010_popupReject"
	            					id="mct010_cmlVendorBoobankStatus" value="#{vendor.dataObj.vendorBookbankStatus}"
	            					rendered="#{vendor.dataObj.renderedVendorBookbankRejectPopup}"
	            					oncomplete="#{rich:component('mct010_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT010-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="VB" />
	            					</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeName}" styleClass="contentform" style = "width :100px " />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeBankName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeBookBankNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBankNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbankStatus']} Payee" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBookBankStatus}" styleClass="contentform"  
									rendered="#{vendor.dataObj.renderedPayeeBookbankRejectPopup == false}"/>
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,mct010_popupReject"
	            					id="mct001_cmlPayeeBoobankStatus" value="#{vendor.dataObj.payeeBookBankStatus}"
	            					rendered="#{vendor.dataObj.renderedPayeeBookbankRejectPopup}"
	            					oncomplete="#{rich:component('mct010_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT010-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="PB" />
	            					</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.remark}" styleClass="contentform"  style = "width :200px "/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.batchNo}" styleClass="contentform"  style = "width :200px "/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.lotNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.lotNo}" styleClass="contentform"  style = "width :200px "/>
								</div>
							</rich:column>				
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct010Bean.vendorMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="18">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendor"
											maxPages="#{semmct010Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmct010Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>	
			<jsp:include page="../../pages/gm/semmct010-popup.jsp"/>			
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct010Bean.msgDoDelete}"  styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbVendor,frmSearch" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT001-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSaveVendorMaster" />
							<a4j:actionparam name="mode" value="DELETE" />
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
	<a4j:form id="frmShowReportExcel_">
	<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
		<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmct010Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportBookBank}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	</a4j:form>
</rich:modalPanel>


<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_00] -->
	<!-- popupReject -->
	
	<rich:modalPanel id="mct010_popupReject" width="600" minWidth="600"  height="200" style="overflow:auto;" >
			<f:facet name="header">
				<h:outputText value="บันทึกอนุมัติ"/></f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct010_popupReject" style="cursor:pointer"/>
					<rich:componentControl for="mct010_popupReject" attachTo="hide-mct010_popupReject" operation="hide" event="onclick" />
					</div>
				</h:panelGroup>
			</f:facet>
			<a4j:form id="frmReject">
			
			<h:panelGrid columnClasses="gridContent" width="100%">
					<!-- begin content layout criteria -->
					<h:panelGrid width="100%">
						<rich:panel  style="height:500px,overflow:auto;" >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.recordStatus']} #{semmct010Bean.type}"/>
							</f:facet>
							<!-- begin content criteria -->
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['column.header.recordStatus']} #{semmct010Bean.type} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct010Bean.rejectPopupObjParam.status}" styleClass="ms7"></h:outputText>
										</td>
									</tr>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['label.rejectDT']} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct010Bean.rejectPopupObjParam.rejectDTStr}" styleClass="ms7"></h:outputText>
										</td>
									</tr>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['column.header.remark']} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct010Bean.rejectPopupObjParam.result}" styleClass="ms7"></h:outputText>
										</td>
									</tr>
								</table>
									
							</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
							<!-- end content criteria -->
							<h:panelGrid  id="grdSearchCommand" columns="2">
								
								<a4j:commandButton id="btnCancel" value="Close" styleClass="rich-button" >
									<a4j:support event="oncomplete" reRender="oppContent"></a4j:support>
									
									<rich:componentControl for="mct010_popupReject" operation="hide" event="onclick" />
								</a4j:commandButton>
				           		
							</h:panelGrid>
					</h:panelGrid>
			</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>
