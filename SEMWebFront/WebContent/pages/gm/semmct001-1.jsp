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
		                		<td width="30%">
		                			<h:inputText id="txtVendorCode" value="#{semmct001Bean.criteriaVendorSP.vendorCode}"
		                			style="margin-right:5px;" label="#{jspMsg['label.vendorCode']}" />
		                			
		                			<!-- >> fixed by.. YUT 2015/10/18 -->
		                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
						            action="#{semmct001Action.initAddVendor}" reRender="oppContent"
						            oncomplete="#{rich:component('mct001PopUp_addVendor')}.show();">
									</a4j:commandButton>
		                			<!-- << -->
		                		</td>
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
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.payeeStatus']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
	                			<h:selectOneMenu id="ddlVendorPayeeStatus" value="#{semmct001Bean.criteriaVendorSP.payeeStatus}">
								<f:selectItems value="#{semmct001Bean.payeeStatusSelList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.status']} Payee BookBank :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:selectOneMenu id="ddlBookBankPayee" value="#{semmct001Bean.criteriaVendorSP.payeeBookBankStatus}"> 
								<f:selectItems value="#{semmct001Bean.payeeBookbankStatusSelList}"/>
								</h:selectOneMenu>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.batchNo']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
								<h:inputText id="txtBatchNo" value="#{semmct001Bean.criteriaVendorSP.batchNo}"></h:inputText>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.lotNo']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:inputText id="txtLotNo" value="#{semmct001Bean.criteriaVendorSP.lotNo}"></h:inputText>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.createByUser']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
								<h:inputText id="txtCrateByUser" value="#{semmct001Bean.criteriaVendorSP.createBy}"></h:inputText>
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
	            <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct001Bean.renderedMsgFormSearch}">
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
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
									 rendered="false" 
         							 styleClass="rich-button" value="Export Vendor" >
         			</h:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="Export Bookbank" id="btnExportBank" rendered="false" disabled="#{semmct001Bean.criteriaVendorSP.company == '' or semmct001Bean.criteriaVendorSP.company == null || semmct001Bean.criteriaVendorSP.region == ''}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,frmShowReportExcel_,pnlShowReportExcel" >
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportBookbank" />
         			</a4j:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="#{jspMsg['btn.exportVendorToLeader']}" id="btnExportVendorToLeader" rendered="true" 
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlShowReportVendorExcel" 
         			style="width:100px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportVendorToLeader" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
         			<a4j:commandButton value="#{jspMsg['btn.sendVendorToSAP']}" id="btnSendVendorToSAP" rendered="true"
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlSearchResult" 
         			style="width:130px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doSendVendorToSAP" />
         			</a4j:commandButton>
         			<rich:spacer width="15"></rich:spacer>
         			<a4j:commandButton value="#{jspMsg['btn.exportVendorBookBankToLeader']}" id="btnExportVendorBookBankToLeader" rendered="true"
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlShowReportVendorBookbankExcel" 
         			style="width:150px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportVendorBookbankToLeader" />
         			</a4j:commandButton>
         			<rich:spacer width="5"/>
         			<a4j:commandButton value="#{jspMsg['btn.sendVendorBookbankToLeaderApplrove']}" id="btnSendVendorBookbankToLeaderApprove" rendered="true" 
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlSearchResult" 
         			style="width:190px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doSendVendorBookBankToLeaderApprove" />
         			</a4j:commandButton>
         			
         			<rich:spacer width="15"></rich:spacer>
         			<a4j:commandButton value="#{jspMsg['btn.exportPayeeToLeader']}" id="btnExportPayeeToLeader" rendered="true"
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlShowReportPayeeToLeaderExcel" 
         			style="width:90px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportPayeeToLeader" />
         			</a4j:commandButton>
         			
         			<rich:spacer width="5"></rich:spacer>
					
         			<a4j:commandButton value="#{jspMsg['btn.sendPayeeToLeaderApprove']}" id="btnSendPayeeToLeaderApprove" rendered="true"
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlSearchResult" 
         			style="width:140px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="doSendPayeeToLeaderApprove" />
         			</a4j:commandButton>
         			
         			<rich:spacer width="15"></rich:spacer>
					
         			<a4j:commandButton value="#{jspMsg['btn.exportPayeeBookbankToLeader']}" id="btnExportPayeeBookbankToLeader" rendered="true"
         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlShowReportPayeeBookbankToLeaderExcel" 
         			style="width:140px;">
         				<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT001" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
						<a4j:actionparam name="methodWithNavi" value="initExportPayeeBookbankToLeader" />
         			</a4j:commandButton>
         			<rich:spacer width="5"></rich:spacer>
         			<a4j:commandButton value="#{jspMsg['btn.sendPayeeBookbankToLeaderApprove']}" id="btnSendPayeeBookbankToLeaderApprove" rendered="true"
	         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
	         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlSearchResult" 
	         			style="width:190px;">
	         				<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSendPayeeBookbankToLeaderApprove" />
	         			</a4j:commandButton>
           		</td>
           		</tr>
           		<tr>
           			<td>
           			<a4j:commandButton value="#{jspMsg['btn.clearBatch']}" id="btnClearBatch" rendered="true"
	         			disabled="#{semmct001Bean.disabledExportVendorBtn}"
	         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,pnlSearchResult" 
	         			style="width:100px;">
	         				<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doClearBatch" />
	         			</a4j:commandButton>
         			
         			
           			</td>
           		</tr>
           		
           		</table>
           		</h:panelGroup>
           		</h:panelGrid>
             
				<h:panelGrid width="90%">
					
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style = "width :2800px "/>
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
										<a4j:support event="onclick" action="#{semmct001Action.selectAllRow}" 
										reRender="dtbVendor,btnExportVendorToLeader,btnSendVendorToSAP,btnExportVendorBookBankToLeader,
										btnSendVendorBookbankToLeaderApprove,btnExportPayeeToLeader,btnSendPayeeToLeaderApprove,
										btnExportPayeeBookbankToLeader,btnSendPayeeBookbankToLeaderApprove,btnClearBatch"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="chkSelect"  value="#{vendor.checkBox}">
									<a4j:support event="onclick" action="#{semmct001Action.onRender}" 
									reRender="dtbVendor,btnExportVendorToLeader,btnSendVendorToSAP,btnExportVendorBookBankToLeader,
									btnSendVendorBookbankToLeaderApprove,btnExportPayeeToLeader,btnSendPayeeToLeaderApprove,
									btnExportPayeeBookbankToLeader,btnSendPayeeBookbankToLeaderApprove,btnClearBatch">
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
									<h:outputText value="#{jspMsg['column.header.actionType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.actionType}" styleClass="contentform"  />
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
									<h:outputText value="#{jspMsg['column.header.branchId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.branchId}" styleClass="contentform"  />
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
									<h:outputText value="#{jspMsg['column.header.expenseTypeDesc']}" styleClass="contentform" style = "width :100px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.expenseTypeDesc}" styleClass="contentform"  />
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
									<h:outputText value="#{vendor.dataObj.vendorStatus}" styleClass="contentform" 
									rendered="#{vendor.dataObj.renderedVendorRejectPopup == false}" />
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,popupReject"
	            					id="cmlVendorStatus" value="#{vendor.dataObj.vendorStatus}"
	            					rendered="#{vendor.dataObj.renderedVendorRejectPopup}"
	            					oncomplete="#{rich:component('mct001_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="VV" />
	            					</a4j:commandLink>
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
									<h:outputText value="#{jspMsg['column.header.accountNo']}" styleClass="contentform" style = "width :200px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.accountName']}" styleClass="contentform" style = "width :200px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bankAccName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} BookBank" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bookBankStatus}" styleClass="contentform" 
									rendered="#{vendor.dataObj.renderedVendorBookbankRejectPopup == false}"/>
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,popupReject"
	            					id="cmlVendorBoobankStatus" value="#{vendor.dataObj.bookBankStatus}"
	            					rendered="#{vendor.dataObj.renderedVendorBookbankRejectPopup}"
	            					oncomplete="#{rich:component('mct001_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
									<h:outputText value="#{jspMsg['column.header.payeeStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeStatus}" styleClass="contentform" 
									rendered="#{vendor.dataObj.renderedPayeeRejectPopup == false}" />
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,popupReject"
	            					id="cmlPayeeStatus" value="#{vendor.dataObj.payeeStatus}"
	            					rendered="#{vendor.dataObj.renderedPayeeRejectPopup}"
	            					oncomplete="#{rich:component('mct001_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="PP" />
	            					</a4j:commandLink>
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
									<h:outputText value="#{jspMsg['column.header.payeeAccountNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeAccountName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBankAccName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeBookbankStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBookBankStatus}" styleClass="contentform"  
									rendered="#{vendor.dataObj.renderedPayeeBookbankRejectPopup == false}"/>
									
									<a4j:commandLink action="#{navAction.navi}" reRender="oppContent,popupReject"
	            					id="cmlPayeeBoobankStatus" value="#{vendor.dataObj.bookBankStatus}"
	            					rendered="#{vendor.dataObj.renderedPayeeBookbankRejectPopup}"
	            					oncomplete="#{rich:component('mct001_popupReject')}.show(); return false">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doInitStatusPopup" />
										<a4j:actionparam name="vendorMasterId" value="#{vendor.dataObj.vendorMasterId}" />
										<a4j:actionparam name="statusType" value="PB" />
	            					</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" styleClass="contentform" style="width:140" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.batchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbankBatchNo']}" styleClass="contentform" style="width:140" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.bookbankBatchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeBatchNo']}" styleClass="contentform" style="width:140" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBatchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeBookbankBatchNo']}" styleClass="contentform" style="width:140" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeBookbankBatchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.lotNo']}" styleClass="contentform" style="width:140"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.lotNo}" styleClass="contentform"  />
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
									<rich:column colspan="26">
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
	<h:panelGrid id="pnlShowReportVendorExcel" style="height:0px;width:0px;" width="0px" columns="0" >
		<h:panelGroup id="pnlInShowReportVendorExcel" rendered="#{semmct001Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportVendorExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportVendorToLeader}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	<h:panelGrid id="pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;" width="0px" columns="0" >
		<h:panelGroup id="pnlInShowReportVendorBookbankExcel" rendered="#{semmct001Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportVendorBookbankToLeader}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorBookbankExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	<h:panelGrid id="pnlShowReportPayeeToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
		<h:panelGroup id="pnlInShowReportPayeeToLeaderExcel" rendered="#{semmct001Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportPayeeToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportPayeeToLeader}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeToLeaderExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	<h:panelGrid id="pnlShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
		<h:panelGroup id="pnlInShowReportPayeeBookbankToLeaderExcel" rendered="#{semmct001Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportPayeeBookbankToLeader}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeBookbankToLeaderExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	</a4j:form>
</rich:modalPanel>


<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mct001PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct001PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mct001PopUp_addVendor" attachTo="hide-mct001PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMct001PopUp_addVendor">
		
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
                				<h:inputText id="txtVendorCode" value="#{semmct001Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmct001Bean.vendorMasterPopupObjParam.vendorName}" 
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
					<a4j:commandButton value="Search" action="#{semmct001Action.doSearchPopupAddVendor}"
					reRender="frmMct001PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmct001Action.doClearPopupAddVendor}"
					reRender="frmMct001PopUp_addVendor, dataTable_searchVendor"
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
							var="vendorLst"  value="#{semmct001Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmct001Action.doSelectPopupAddVendor}"
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
										<h:outputText id="mct001_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mct001_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mct001_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mct001_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmct001Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmct001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMct001PopUp_addVendor"></a4j:support>
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
					    <rich:componentControl for="mct001PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_00] -->
	<!-- popupHistory -->
	<rich:modalPanel id="mct001_popupHistory" width="1000" height="450">	
	   	<f:facet name="header">
        	<h:outputText value="ประวัติการแก้ไขข้อมูล (vendor)..." style="width: 100%"/>
       	</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct001_popupHistory" style="cursor:pointer" />
					<rich:componentControl for="mct001_popupHistory" attachTo="hide-mct001_popupHistory" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
	     	<h:panelGroup  style="width:100%;" styleClass="sem_autoScrollbar">
				<!-- >> group repeat -->
	         	<div align="center">
	                 <h:outputLabel style="color:red;size:20px" value="#{semmct001Bean.msgDataNotFound}" rendered="#{semmct001Bean.renderedMsgDataNotFound}" />
	         	</div>
	         
	         	<div style="overflow-y:auto; width:100%; height:380px;">
	         	
		         	<!-- top >> -->
	                <table style="width:100%; border-bottom:#97a822 solid 1px;">
	                    <tr>
	                        <td style="width:25%; text-align:center;">
	                            <h:outputText value="Vendor Code : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:25%; text-align:center;">
	                            <h:outputText value="ชื่อ-นามสกุล : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:25%; text-align:center;">
	                            <h:outputText value="TAX ID : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:25%; text-align:center;">
	                            <h:outputText value="วันที่แก้ไขล่าสุด : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                </table>
	                <!-- top << -->
	                
	                <!-- summary >> -->
	                <table style="width:100%; border-bottom:#97a822 solid 1px;">
	                    <tr>
	                        <td style="width:20%; text-align:right;">
	                            <h:outputText value="ที่อยู่ : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:right;">
	                            <h:outputText value="ตำบล/แขวง : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:right;">
	                            <h:outputText value="อำเภอ/เขต : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td style="width:20%; text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td style="width:20%; text-align:right;">
	                            <h:outputText value="จังหวัด : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:right;">
	                            <h:outputText value="รหัสไปรษณีย์: " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td colspan="3" style="text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td style="width:20%; text-align:right;">
	                            <h:outputText value="Tel. : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:15%; text-align:right;">
	                            <h:outputText value="Mobile : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td colspan="3" style="text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td style="width:20%; text-align:right;">
	                            <h:outputText value="สัญญาเลขที่ : " style="font-weight:bold;" styleClass="ms7" />
	                        </td>
	                        <td colspan="5" style="text-align:left;">
	                            <h:outputText value="xxxx" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                </table>
	                <!-- summary << -->
	                
	                <div style="clear:both; height:5px;"></div>
		         	
					<rich:dataTable style="width:100%;" cellpadding="1" cellspacing="0" border="1"
		         	var="item_"  value="" reRender="" 
		         	rows="" rowClasses="cur" styleClass="dataTable">
		             	<rich:column>
		                 	<div align="center">
		                        
			                  	<!-- detail >> -->
			                  	<table style="width:100%;">
			                  		<tr>
			                          	<td colspan="4" style="text-align:left; background-color:#b5c729; border:1px solid #97a822;">
			                              	<h:outputText value="ข้อมูล Vendor" style="" styleClass="ms7" />
			                          	</td>
			                       	</tr>
			                      	<tr>
			                          	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                           	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                      	</tr>
			                      	<tr>
			                          	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                           	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                      	</tr>
			                      	<tr>
			                          	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                           	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                      	</tr>
			                      	<tr>
			                          	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                           	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                      	</tr>
			                      	<tr>
			                          	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                           	<td style="width:25%; text-align:right;">
			                              	<h:outputText value="xxx : " style="" styleClass="ms7" />
			                          	</td>
			                          	<td style="width:25%; text-align:left;">
			                              	<h:outputText value="xxx" style="" styleClass="ms7" />
			                          	</td>
			                      	</tr>
			                  	</table>
			                  	<!-- detail << -->
							</div>
						</rich:column>
		        	</rich:dataTable>
	        	</div>
	        </h:panelGroup>
	        
	        <div style="clear:both; height:10px;"></div>
	        
	        
	        <!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mct001_popupHistory" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
	            
		<!-- /h:form --> 
	</rich:modalPanel>
	<!-- popupHistory -->
	<!-- << [POPUP_00] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_00] -->
	<!-- popupReject -->
	
	<rich:modalPanel id="mct001_popupReject" width="600" minWidth="600"  height="200" style="overflow:auto;" >
			<f:facet name="header">
				<h:outputText value="บันทึกอนุมัติ"/></f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct001_popupReject" style="cursor:pointer"/>
					<rich:componentControl for="mct001_popupReject" attachTo="hide-mct001_popupReject" operation="hide" event="onclick" />
					</div>
				</h:panelGroup>
			</f:facet>
			<a4j:form id="frmReject">
			
			<h:panelGrid columnClasses="gridContent" width="100%">
					<!-- begin content layout criteria -->
					<h:panelGrid width="100%">
						<rich:panel  style="height:500px,overflow:auto;" >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.recordStatus']} #{semmct001Bean.type}"/>
							</f:facet>
							<!-- begin content criteria -->
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['column.header.recordStatus']} #{semmct001Bean.type} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct001Bean.rejectPopupObjParam.status}" styleClass="ms7"></h:outputText>
										</td>
									</tr>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['label.rejectDT']} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct001Bean.rejectPopupObjParam.rejectDTStr}" styleClass="ms7"></h:outputText>
										</td>
									</tr>
									<tr>
										<td>
											<h:outputText value="#{jspMsg['column.header.remark']} :" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:outputText value="#{semmct001Bean.rejectPopupObjParam.result}" styleClass="ms7"></h:outputText>
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
									
									<rich:componentControl for="mct001_popupReject" operation="hide" event="onclick" />
								</a4j:commandButton>
				           		
							</h:panelGrid>
					</h:panelGrid>
			</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>