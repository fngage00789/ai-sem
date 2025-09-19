<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct011" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Approve Payee" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct011Bean.renderedMsgFormSearch}" style="width : 302px; height : 21px;">
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
		                		<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.status']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
	                			<h:selectOneMenu id="ddlStatus" value="#{semmct011Bean.criteriaVendorSP.recordStatus}">
								<f:selectItems value="#{semmct011Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								
	                			</td>
	                			<td width="30%" >
	                			
				                </td>
			                	</tr>
		                	
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.name']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtIdCard" value="#{semmct011Bean.criteriaVendorSP.payeeName}" maxlength="255"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.idCard']} " styleClass="ms7" /></td>
		                		<td><h:inputText id="txtTaxId" value="#{semmct011Bean.criteriaVendorSP.idCard}" maxlength="13"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td align="right"><h:outputText value="#{jspMsg['label.contactNo']} :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtContactNo" value="#{semmct011Bean.criteriaVendorSP.contractNo}" maxlength="20"></h:inputText></td>
		                		<td align="right"><h:outputText value="#{jspMsg['label.siteName']} " styleClass="ms7" /></td>
		                		<td><h:inputText id="txtSiteName" value="#{semmct011Bean.criteriaVendorSP.siteName}" maxlength="255"></h:inputText></td>
		                		</tr>
		                		
		                		<tr valign="baseline">
								<td align="right" width="20%">
								
								<h:outputText value="#{jspMsg['label.batchNo']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
								<h:inputText id="txtBatchNo" value="#{semmct011Bean.criteriaVendorSP.batchNo}" maxlength="15"></h:inputText>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.lotNo']} :" styleClass="ms7" rendered="false"/>
	                			</td>
	                			<td width="30%" >
	                			<h:inputText id="txtLotNo" value="#{semmct011Bean.criteriaVendorSP.lotNo}" rendered="false"></h:inputText>
				                </td>
			                	</tr>
			                	
			                	<tr valign="baseline">
									<td align="right" width="20%">
									
										<h:outputText value="#{jspMsg['label.createByUser']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="baseline">
										<h:inputText id="txtCrateByUser" value="#{semmct011Bean.criteriaVendorSP.createBy}"></h:inputText>
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
								<a4j:actionparam name="navProgram" value="SEMMCT011" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT011" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>
			            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,pnlSearchResult">
			            		<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT011" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT011" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
			             
	            	</h:panelGrid>
		            </rich:panel>
		            
				</h:panelGrid>
	            <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct011Bean.renderedMsgFormSearch}">
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
				<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
				<table width="100%" border="0">
				<tr align="left">
				<td>
					<a4j:commandButton id="btnApprove" styleClass="rich-button" action="#{navAction.navi}" 
						disabled="#{semmct011Bean.disabledBtnApproveAndReject}"
						value="Approve"  rendered="#{semmct011Bean.rendererSSO['btnSMBPM001'] and semmct002Bean.renderer['btnApprove']}" reRender="oppContent" 
						style="width:70" immediate="true"
						oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false">
	            		<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT011-1" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT011" />
						<a4j:actionparam name="methodWithNavi" value="initApprove" />
						<a4j:actionparam name="btnApproveStatus" value="AA" />
					</a4j:commandButton>
	            	<rich:spacer width="5"></rich:spacer>
					<a4j:commandButton id="btnRejectFinance" value="Reject" styleClass="rich-button" disabled="#{semmct011Bean.disabledBtnApproveAndReject}"
					 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
			         rendered="#{semmct011Bean.rendererSSO['btnSMBPM001'] and semmct011Bean.renderer['btnRejectFinance']}"
			         action="#{navAction.navi}" reRender="popupApproveBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT011-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT011" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="AC" />
					</a4j:commandButton>
         			<rich:spacer width="5"/>
           		</td>
           		</tr>
           		</table>
           		</h:panelGroup>
           		</h:panelGrid>
             
				<h:panelGrid width="90%">
					
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style = "width :1550px "/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct011Bean.msgDataNotFound}" rendered="#{semmct011Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						<rich:dataTable width="95%" id="dtbVendor" cellpadding="1" cellspacing="0" border="0"
							var="vendor" value="#{semmct011Bean.vendorMasterList}" reRender="dstVendor" 
							rows="#{semmct011Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							
							<rich:column styleClass="#{(semmct011Bean.tmpRowId==vendor.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmct011Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmct011Action.selectAllRow}" reRender="dtbVendor,btnApprove,btnRejectFinance"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="chkSelect"  value="#{vendor.checkBox}" rendered="#{vendor.dataObj.renderedChkSelect}">
									<a4j:support event="onclick" action="#{semmct011Action.onRender}" 
									reRender="dtbVendor,btnApprove,btnRejectFinance">
										<a4j:actionparam name="rowId" value="#{vendor.dataObj.rowId}" />
									</a4j:support>
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.vendorType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeName']}" styleClass="contentform" style = "width :200px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeName}" styleClass="contentform"  />
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
									<h:outputText value="#{jspMsg['column.header.payeeAddress']}" styleClass="contentform" style = "width :200px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.payeeAddress}" styleClass="contentform"  />
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
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style = "width :150px "/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendor.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.status']}" styleClass="contentform" style = "width :90px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.recordStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" styleClass="contentform" style = "width :90px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.batchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style = "width :300px "/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendor.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.createBy']}" styleClass="contentform" style = "width :100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.createDT']}" styleClass="contentform" style = "width :100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.createDtStr}" styleClass="contentform" style="color:#{vendor.dataObj.color} !important"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.approveBy']}" styleClass="contentform" style = "width :100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.approveBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.approveDT']}" styleClass="contentform" style = "width :100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.dataObj.approveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
										
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct011Bean.vendorMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="12">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendor"
											maxPages="#{semmct011Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmct011Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>	
			<jsp:include page="../../pages/gm/semmct011-popup.jsp"/>			
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
						<h:outputText value="#{semmct011Bean.msgDoDelete}"  styleClass="ms7" />
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
		<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmct011Bean.displayReport}" style="height:0px;width:0px;" >
			<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmct001Action.doExportBookBank}"  />								
			<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportExcel').click();</script>
		</h:panelGroup>							
	</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

