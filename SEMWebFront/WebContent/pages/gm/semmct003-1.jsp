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
			<table width="100%" border="0">
			<tr><td></td>
			<td>
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
			</td></tr>
			</table>
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
										
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.payeeType']}" styleClass="ms7"/>
				                	</td>
				                	<td width="30%">
				                		<h:selectOneMenu id="ddlPayeeType" value="#{semmct003Bean.approveBookBankSP.payeeType}">
											<f:selectItems value="#{semmct003Bean.payeeTypeList}"/>
										</h:selectOneMenu>
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
		                				<h:inputText id="txtContractNo" value="#{semmct003Bean.approveBookBankSP.contractNo}" size="23" maxlength="20"></h:inputText>
				                	</td>
				                	<td width="20%" align="right">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtSiteName" value="#{semmct003Bean.approveBookBankSP.siteName}" size="30" maxlength="255"></h:inputText>
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
								<h:outputText value="#{jspMsg['label.lotNo']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%" >
	                			<h:inputText id="txtLotNo" maxlength="15" value="#{semmct003Bean.approveBookBankSP.lotNo}"></h:inputText>
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
									<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError,frmButton,pnlSearchResult,pnlSearchCriteria,
							 btnApproveAccount,btnRejectAccount,btnApproveFinance,btnRejectFinance">
			           				<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				<a4j:form id="frmButton">
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
					<a4j:commandButton id="btnCheckerFinance" value="Fn Checker" styleClass="rich-button" 
					 rendered="#{semmct003Bean.rendererSSO['btnSMBBB001']}" disabled="#{semmct003Bean.disabledBtnCheckerAndReject}"
					 oncomplete="#{rich:component('popupCheckerBookBank')}.show(); return false"
			         action="#{navAction.navi}" reRender="popupCheckerBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
								<a4j:actionparam name="methodWithNavi" value="initChecker" />
								<a4j:actionparam name="btnApproveStatus" value="APPROVE" />
					</a4j:commandButton>
					<a4j:commandButton id="btnCheckerRejectFinance" value="Fn Checker Reject" styleClass="rich-button" 
					 rendered="#{semmct003Bean.rendererSSO['btnSMBBB001']}" disabled="#{semmct003Bean.disabledBtnCheckerAndReject}"
					 oncomplete="#{rich:component('popupCheckerBookBank')}.show(); return false"
			         action="#{navAction.navi}" reRender="popupCheckerBookBank"
			         style="width:130">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
								<a4j:actionparam name="methodWithNavi" value="initChecker" />
								<a4j:actionparam name="btnApproveStatus" value="REJECT" />
					</a4j:commandButton>	
					<a4j:commandButton id="btnApproveFinance" value="Fn Approve" styleClass="rich-button" 
					 rendered="#{semmct003Bean.rendererSSO['btnSMBBB002']}" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
					 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
			         action="#{navAction.navi}" reRender="popupApproveBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="APPROVE" />
					</a4j:commandButton>													
					<a4j:commandButton id="btnRejectFinance" value="Fn Reject" styleClass="rich-button" 
					 rendered="#{semmct003Bean.rendererSSO['btnSMBBB002']}" disabled="#{semmct003Bean.disabledBtnApproveAndReject}"
					 oncomplete="#{rich:component('popupApproveBookBank')}.show(); return false"
			         action="#{navAction.navi}" reRender="popupApproveBookBank">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="REJECT" />
					</a4j:commandButton>
					<rich:spacer width="5"/>
					<a4j:commandButton value="#{jspMsg['btn.exportVendorBookBankToLeader']}" id="mct003_btnExportVendorBookBankToLeader" rendered="true"
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
				<!-- end content button -->
				</a4j:form>
				<!-- begin export content -->
				<a4j:form id="mct003_frmShowReportExcel_">
					
					<h:panelGrid id="mct003_pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;margin:0px;padding:0px;" width="0px" columns="0" >
						<h:panelGroup id="mct003_pnlInShowReportVendorBookbankExcel" rendered="#{semmct003Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="mct003_bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmct003Action.doExportVendorBookbankToLeader}"  />								
							<script>document.getElementById('incContent:mct003_frmShowReportExcel_:mct003_bthShowReportVendorBookbankExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
				</a4j:form>
				<!-- end export content -->
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2600"/>
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
							
							<rich:column styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmct003Bean.chkSelAll}" disabled="#{semmct003Bean.disableChkAll}">
										<a4j:support event="onclick" action="#{semmct003Action.selectAllRow}" reRender="dtbApproveBookBankSrch,btnApproveAccount,btnRejectAccount,
																														btnApproveFinance,btnRejectFinance,btnExport,btnCheckerFinance,
																														btnCheckerRejectFinance,mct003_btnExportVendorBookBankToLeader"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{approveBookBankSP.checkBox}" rendered="#{approveBookBankSP.dataObj.renderedCheckBox}">
										<a4j:support event="onclick" action="#{semmct003Action.onRenderExportButton}" reRender="dtbApproveBookBankSrch,btnApproveAccount,
																																btnRejectAccount,btnApproveFinance,
																																btnRejectFinance,btnExport,btnCheckerFinance,
																																btnCheckerRejectFinance,mct003_btnExportVendorBookBankToLeader">
											<a4j:actionparam name="rowId" value="#{approveBookBankSP.dataObj.rowId}" />
											<a4j:actionparam name="status" value="#{approveBookBankSP.dataObj.recordStatus}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeTypeDesc']}" styleClass="contentform" style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.payeeTypeDesc}" styleClass="ms7" />	
								</div>
							</rich:column>
							<rich:column id="Edit" sortBy="#{approveBookBankSP.dataObj.payeeName}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.payeeName}"/>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.payeeIdCard}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeIdCard']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.payeeIdCard}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{approveBookBankSP.dataObj.bankAccType}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccType}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankAccNo}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccNo}" styleClass="contentform"  >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankAccName}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccName']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankAccName}" styleClass="contentform" >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankCode}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Bank Code" styleClass="contentform"  style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.bankCode}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankName}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.bankBranche}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankBranch']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.bankBranch}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{approveBookBankSP.dataObj.province}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.province}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.newBankFlag}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="New Bank" styleClass="contentform"  style="width:12px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.newBankFlag}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{approveBookBankSP.dataObj.contractNo}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{approveBookBankSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{approveBookBankSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.siteName}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.recordStatusDesc}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.recordStatusDesc']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.recordStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.lotNo}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lotNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{approveBookBankSP.dataObj.lotNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.remark}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.createBy}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Create By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.createDt}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Create Date" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.createDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.checkerBy}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Checker By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.checkerBy}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.checkerDt}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Checker Date" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{approveBookBankSP.dataObj.checkerDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveBookBankSP.dataObj.approveBy}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Approve By" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{approveBookBankSP.dataObj.approveBy}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveBookBankSP.dataObj.approveDt}" styleClass="#{(semmct003Bean.tmpRowId==approveBookBankSP.dataObj.rowId)?'onClick':'unClick'}">
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
			<jsp:include page="../../pages/gm/semmct003-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>