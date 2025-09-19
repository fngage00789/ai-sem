<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearch">
		<f:facet name="header"><h:outputText value="Approve BookBank"/></f:facet>
		<h:panelGrid>
			
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="20%">
									
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.recordStatus']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPayeeStatus" value="#{semmct003Bean.approveBookBankSP.recordStatus}">
											<f:selectItems value="#{semmct003Bean.payeeStatusList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
										
										
				                	</td>
				                	<td width="30%">
				                		
				                	</td>
			                	 </tr> 
			                	 
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPayeeName" value="#{semmct003Bean.approveBookBankSP.payeeName}" size="30" maxlength="255"></h:inputText>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.idCard']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtIdCard" value="#{semmct003Bean.approveBookBankSP.idCard}" size="18" maxlength="13"></h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.bankAccNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtBankAccNo" value="#{semmct003Bean.approveBookBankSP.bankAccNo}" size="18" maxlength="15"></h:inputText>
				                	</td>
				                	<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.bankAccName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtBankAccName" value="#{semmct003Bean.approveBookBankSP.bankAccName}" size="30" maxlength="255"></h:inputText>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtContractNo" value="#{semmct003Bean.approveBookBankSP.contractNo}" size="23" maxlength="20" style="width:100px;"></h:inputText>
				                	</td>
				                	<td width="20%" align="right">
									
		                			</td>
		                			<td width="30%">
		                				
				                	</td>
			                	 </tr>
			                	 
			                	 <tr valign="baseline">
								<td align="right" width="20%">
								
									<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" valign="baseline">
									<h:inputText id="txtBatchNo" value="#{semmct003Bean.approveBookBankSP.batchNo}" maxlength="15" style=" height : 21px;"></h:inputText>
			                	</td>
			                	<td align="right" width="20%">
								
	                			</td>
	                			<td width="30%" >
	                			
				                </td>
			                	</tr>
			                	 
			                	  <tr>
									<td align="right">
									<h:outputText value="Bank Status :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                				<h:selectOneMenu id="ddlBankStatus" value="#{semmct003Bean.approveBookBankSP.bankStatus}">
											<f:selectItems value="#{semmct003Bean.bankStatusList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	<tr valign="baseline">
									<td align="right" width="20%">
									
										<h:outputText value="#{jspMsg['label.createByUser']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="baseline">
										<h:inputText id="txtCrateByUser" value="#{semmct003Bean.approveBookBankSP.createBy}"></h:inputText>
				                	</td>
				                	<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%" >
		                			
					                </td>
			                	</tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError,frmButton,pnlSearchResult">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="doSearchSap" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError,frmButton,pnlSearchResult,pnlSearchCriteria,
							 btnApproveAccount,btnRejectAccount,btnApproveFinance,btnRejectFinance">
			           				<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormSearch}">
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
	                </rich:messages>
					<!-- begin content button -->
					<h:panelGrid  columns="8" id="grdAddCommand">
						<a4j:commandButton id="btnApproveAccount" value="Ac Approve" styleClass="rich-button" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
						 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
				         action="#{navAction.navi}" reRender="popupApproveBookBank"
				         rendered="false">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initApprove" />
									<a4j:actionparam name="btnApproveStatus" value="AA" />
						</a4j:commandButton>													
						<a4j:commandButton id="btnRejectAccount" value="Ac Reject" styleClass="rich-button" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
						 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
				         rendered="false"
				         action="#{navAction.navi}" reRender="popupApproveBookBank">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initApprove" />
									<a4j:actionparam name="btnApproveStatus" value="AC" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCheckerFinance" value="Checker Approve" styleClass="rich-button" 
						 rendered="#{semmct003Bean.rendererSSO['btnSMBBB001']}" disabled="#{semmct003Bean.disabledBtnCheckerAndReject}"
						 oncomplete="#{rich:component('popupSapCheckerBookBank')}.show(); return false"
				         action="#{navAction.navi}" reRender="popupCheckerBookBank,oppContent">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initChecker" />
									<a4j:actionparam name="btnApproveStatus" value="APPROVE" />
									<a4j:actionparam name="actionType" value="CA" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCheckerRejectFinance" value="Checker Reject" styleClass="rich-button" 
						 rendered="#{semmct003Bean.rendererSSO['btnSMBBB001']}" disabled="#{semmct003Bean.disabledBtnCheckerAndReject}"
						 oncomplete="#{rich:component('popupSapCheckerBookBank')}.show(); return false"
				         action="#{navAction.navi}" reRender="popupCheckerBookBank,oppContent"
				         style="width:130">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initChecker" />
									<a4j:actionparam name="btnApproveStatus" value="REJECT" />
									<a4j:actionparam name="actionType" value="CR" />
						</a4j:commandButton>	
						<a4j:commandButton id="btnApproveFinance" value="Finance Approve" styleClass="rich-button" 
						 rendered="#{semmct003Bean.rendererSSO['btnSMBBB002']}" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
						 oncomplete="#{rich:component('popupSapCheckerBookBank')}.show(); return false"
				         action="#{navAction.navi}" reRender="popupApproveBookBank,oppContent">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initApprove" />
									<a4j:actionparam name="btnApproveStatus" value="APPROVE" />
									<a4j:actionparam name="actionType" value="FA" />
						</a4j:commandButton>													
						<a4j:commandButton id="btnRejectFinance" value="Finance Reject" styleClass="rich-button" 
						 rendered="#{semmct003Bean.rendererSSO['btnSMBBB002']}" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
						 oncomplete="#{rich:component('popupSapCheckerBookBank')}.show(); return false"
				         action="#{navAction.navi}" reRender="popupApproveBookBank,oppContent">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="initApprove" />
									<a4j:actionparam name="btnApproveStatus" value="REJECT" />
									<a4j:actionparam name="actionType" value="FR" />
						</a4j:commandButton>
						<rich:spacer width="5"/>
						<a4j:commandButton value="#{jspMsg['btn.exportVendorBookBankToLeader']}" id="mct003_btnExportVendorBookBankToLeader" rendered="false"
	         			disabled="#{semmct003Bean.disabledExportVendorBtn}"
	         			styleClass="rich-button" action="#{navAction.navi}" reRender="frmError,frmSearch,mct003_pnlShowReportVendorBookbankExcel" 
	         			style="width:150px;">
	         				<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT003" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
							<a4j:actionparam name="methodWithNavi" value="initExportVendorBookbankToLeader" />
	         			</a4j:commandButton>
	         			
						<h:commandButton id ="btnExport" action="#{semmct003Action.doExportExcel}"  
										 disabled="#{semmct003Bean.disabledBtnExport}"
										 rendered="false"
	         							 styleClass="rich-button" value="Export" >
	         			</h:commandButton>
					</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				
				
				<a4j:form id="frmSearchResult" >
				
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2800"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct003Bean.msgDataNotFound}" rendered="#{semmct003Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormMiddle}"/>
						</div>
						 <rich:dataTable width="100%" id="dtbApproveBookBankSrch" cellpadding="1" cellspacing="0" border="0"
							var="approveBookBankSP" value="#{semmct003Bean.approveBookBankSPList}" reRender="dstApproveBookBankSrch" 
							rows="#{semmct003Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmct003Action.getRowIdOnClick}" reRender="dtbApproveBookBankSrch,btnApprove,btnReject">
								<a4j:actionparam name="rowId" value="#{approveBookBankSP.dataObj.rowId}" />
							</a4j:support> 
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmct003Bean.chkSelAll}" disabled="#{semmct003Bean.disableChkAll}">
										<a4j:support event="onclick" action="#{semmct003Action.selectSapAllRow}" reRender="dtbApproveBookBankSrch,btnApproveAccount,btnRejectAccount,
																														btnApproveFinance,btnRejectFinance,btnExport,btnCheckerFinance,
																														btnCheckerRejectFinance,mct003_btnExportVendorBookBankToLeader"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{approveBookBankSP.checkBox}" rendered="#{approveBookBankSP.dataObj.renderedCheckBox}">
										<a4j:support event="onclick" action="#{semmct003Action.onRenderSapExportButton}" reRender="dtbApproveBookBankSrch,btnApproveAccount,
																																btnRejectAccount,btnApproveFinance,
																																btnRejectFinance,btnExport,btnCheckerFinance,
																																btnCheckerRejectFinance,mct003_btnExportVendorBookBankToLeader">
											<a4j:actionparam name="rowId" value="#{approveBookBankSP.dataObj.rowId}" />
											<a4j:actionparam name="status" value="#{approveBookBankSP.dataObj.recordStatus}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.actiontype']}" styleClass="contentform" style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.actionType}" styleClass="ms7" />	
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.banktype']}" styleClass="contentform" style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankType}" styleClass="ms7" />	
								</div>
							</rich:column>
							<rich:column id="vendor_code" sortBy="#{approveBookBankSP.dataObj.vendorCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.vendorCode}"/>
									
								</div>
							</rich:column>
							<rich:column id="vendor_name" sortBy="#{approveBookBankSP.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.vendorName}"/>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.payeeIdCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeIdCard']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.payeeIdCard}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{approveBookBankSP.dataObj.bankAccType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccType}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankAccNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccNo}" styleClass="contentform"  >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankAccName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccName']}" styleClass="contentform" style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccName}" styleClass="contentform" >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankCode}">
								<f:facet name="header">
									<h:outputText value="Bank Code" styleClass="contentform"  style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankCode}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankBranch}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankBranch']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankBranch}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.recordStatusDesc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.recordStatusDesc']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.recordStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.batchNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.batchno']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.batchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.remark}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.createBy}">
								<f:facet name="header">
									<h:outputText value="Create By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.createDt}">
								<f:facet name="header">
									<h:outputText value="Create Date" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.createDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.checkerBy}">
								<f:facet name="header">
									<h:outputText value="Checker By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.checkerBy}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.checkerDt}">
								<f:facet name="header">
									<h:outputText value="Checker Date" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.checkerDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.approveBy}">
								<f:facet name="header">
									<h:outputText value="Approve By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.approveBy}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.approveDt}">
								<f:facet name="header">
									<h:outputText value="Approve Date" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.approveDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmct003Bean.approveBookBankSPList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="24">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbApproveBookBankSrch"
                                            maxPages="#{semmct003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dtbApproveBookBankSrch" 
                                            style="background-color: #cccccc;"
                                            page="#{semmct003Bean.scrollerPage}"
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<!-- begin export content -->
				<a4j:form id="mct003_frmShowReportExcel_" style="height:0px;width:0px;margin:0px;padding:0px;">
					
					<h:panelGrid id="mct003_pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;margin:0px;padding:0px;" width="0px" columns="0" >
						<h:panelGroup id="mct003_pnlInShowReportVendorBookbankExcel" rendered="#{semmct003Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="mct003_bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmct003Action.doExportVendorBookbankToLeader}"  />								
							<script>document.getElementById('incContent:mct003_frmShowReportExcel_:mct003_bthShowReportVendorBookbankExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
				</a4j:form>
				<!-- end export content -->
			
			<jsp:include page="../../pages/gm/semmct003-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>