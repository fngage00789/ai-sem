<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Vendor Master" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct001Bean.renderedMsgFormSearch}" style="width : 302px; height : 21px;">
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
			                		<h:selectOneMenu id="txtCompany" value="#{semmct001Bean.criteriaVendorSP.company}" onchange="reRenderBtnExport();" >
			                			<f:selectItems value="#{semmct001Bean.companyList}"/>
			                		</h:selectOneMenu></td>
			                		<a4j:jsFunction name="reRenderBtnExport" reRender="btnExportBank"></a4j:jsFunction>
		                		<td align="right" width="20%"><h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7" /></td>
		                		<td width="30%">
			                		<h:inputText id="txtRegion" value="#{semmct001Bean.criteriaVendorSP.region}" onblur="reRenderBtnExport();"></h:inputText>
			                		<rich:spacer width="5"/>
			                		<h:selectBooleanCheckbox id="picoFlag" value="#{semmct001Bean.criteriaVendorSP.picoFlag}"></h:selectBooleanCheckbox>
			                		<rich:spacer width="5"/>
			                		<h:outputText value="#{jspMsg['label.pico']}" styleClass="ms7"/>
		                		</tr>
		                		<tr>
		                		<td align="right" width="20%">
		                		<h:outputText value="#{jspMsg['label.vendorCode']} :" styleClass="ms7" />
		                		</td>
		                		<td width="30%"><h:inputText id="txtVendorCode" value="#{semmct001Bean.criteriaVendorSP.vendorCode}" label="#{jspMsg['label.vendorCode']}" ></h:inputText></td>
		                		<td align="right" width="20%"><h:outputText value="#{jspMsg['label.vendorName']} :" styleClass="ms7" /></td>
		                		<td width="30%"><h:inputText id="txtVendorName" value="#{semmct001Bean.criteriaVendorSP.vendorName}"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.idCard']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtIdCard" value="#{semmct001Bean.criteriaVendorSP.idCard}"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.taxId']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtTaxId" value="#{semmct001Bean.criteriaVendorSP.taxId}"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.contactNo']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtContactNo" value="#{semmct001Bean.criteriaVendorSP.contractNo}"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.siteName']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtSiteName" value="#{semmct001Bean.criteriaVendorSP.siteName}"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.accNo']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtBankAccNo" value="#{semmct001Bean.criteriaVendorSP.bankAccNo}"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.accName']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtBankAccName" value="#{semmct001Bean.criteriaVendorSP.bankAccName}"></h:inputText></td>
		                		</tr>
		                		
		                		<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.status']} Vendor :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
	                			<h:selectOneMenu id="ddlVendorStatus" value="#{semmct001Bean.criteriaVendorSP.vendorStatus}">
								<f:selectItems value="#{semmct001Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.status']} BookBank :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:selectOneMenu id="ddlBookBank" value="#{semmct001Bean.criteriaVendorSP.bookBankStatus}"> 
								<f:selectItems value="#{semmct001Bean.bookbankStatusSelList}"/>
								</h:selectOneMenu>
				                </td>
			                	</tr>
		                		</table>
		                		 </h:panelGroup>
		                	</h:panelGrid>
		                	
		               
		               
		                <h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,panSearchCriteria,pnlSearchResult" >
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>
			            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,pnlSearchResult">
			            		<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
					<a4j:commandButton id="btnNew" styleClass="rich-button" action="#{navAction.navi}" 
						value="New"  rendered="#{semmct002Bean.renderer['btnNew']}" reRender="oppContent" 
						style="width:60" immediate="true">
	            		<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="INSERT" />
						<a4j:actionparam name="eventType" value="Add" />
						<a4j:actionparam name="navModuleFrom" value="gm" />
						<a4j:actionparam name="navProgramFrom" value="SEMMCT001-1" />
						<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT001" />
						<a4j:actionparam name="isPageFrom" value="true" />
					</a4j:commandButton>
	            	<rich:spacer width="5"></rich:spacer>
					<h:commandButton id ="btnExport" action="#{semmct001Action.doExportExcel}" 
									 rendered="#{semmct002Bean.renderer['btnExport']}" 
         							 styleClass="rich-button" value="Export Vendor" >
         			</h:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="Export Bookbank" id="btnExportBank" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="Export Vendor ส่ง Leader" id="btnExportToLeader" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
         			<a4j:commandButton value="Send Vendor To SAP" id="btnSendLeaderApprove" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
         			<a4j:commandButton value="Export Vendor Bookbank ส่ง Leader" id="btnSendLeaderApprove" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="Send Vendor Bookbank To Leader Approve" id="btnExportPayeeToLeader" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
         			<a4j:commandButton value="Export Payee ส่ง Leader" id="btnSendPayeeLeaderApprove" rendered="#{semmct002Bean.renderer['btnExport']}" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			
         			<rich:spacer width="5"></rich:spacer>
					
         			<a4j:commandButton value="Send Payee To Leader Approve" id="btnGenFileToSap" rendered="true"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doGenFileToSap" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
					
         			<a4j:commandButton value="Export Payee Bookbank ส่ง Leader" id="btnGenFileToSap" rendered="true"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doGenFileToSap" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
					
         			<a4j:commandButton value="Send Payee Bookbank To Leader Approve" id="btnGenFileToSap" rendered="true"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doGenFileToSap" />
         			</a4j:commandButton>
           		</td>
           		</tr>
           		</table>
           		</h:panelGroup>
           		</h:panelGrid>
             
				<h:panelGrid width="90%">
					
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style = "width :1720px "/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct001Bean.msgDataNotFound}" rendered="#{semmct001Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						<rich:dataTable width="95%" id="dtbVendor" cellpadding="1" cellspacing="0" border="0"
							var="vendor" value="#{semmct001Bean.vendorMasterList}" reRender="dstVendor" 
							rows="#{semmct001Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							
							<rich:column styleClass="#{(semmct001Bean.tmpRowId==vendor.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmct001Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmct001Action.selectAllRow}" reRender="dtbVendor"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="chkSelect"  value="#{vendor.checkBox}">
									<a4j:support event="onclick" action="#{semmct001Action.onRender}" reRender="dtbVendor">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.rowId}" />
									</a4j:support>
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							
							<rich:column rendered="#{semmct002Bean.renderer['btnEdit']}" >
								<f:facet name="header">
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
							<rich:column>
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
							<rich:column rendered="#{semmct002Bean.renderer['btnView']}">
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
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="navModuleFrom" value="gm" />
										<a4j:actionparam name="navProgramFrom" value="SEMMCT001-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT001" />
										<a4j:actionparam name="mode" value="SELECT"/>
										<a4j:actionparam name="isPageFrom" value="true" />
	            					</a4j:commandButton>          							
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
									<h:outputText value="#{jspMsg['column.header.taxId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contactNo']}" styleClass="contentform" style = "width :100px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.contractNoDesc}" styleClass="contentform"  />
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
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} Vendor" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} BookBank" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bookBankStatus}" styleClass="contentform" style="color:#{vendor.dataObj.color} !important"  />
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
									<h:outputText value="#{jspMsg['column.header.payeeStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.booBankStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBookBankStatus}" styleClass="contentform"  />
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
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct001Bean.vendorMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="12">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendor"
											maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmct001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
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
						<h:outputText value="#{semmct001Bean.msgDoDelete}"  styleClass="ms7" />
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
		<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmct001Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportBookBank}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

