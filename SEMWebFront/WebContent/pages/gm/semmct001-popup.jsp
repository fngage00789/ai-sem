<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:modalPanel id="popupFrmSelectVendor" width="950" minWidth="950"  height="550" style="overflow:auto;" >
		<f:facet name="header"><h:outputText value="Popup Select Vendor"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpSelVendor" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSelectVendor" attachTo="hidePopUpSelVendor" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmSelectVendor">
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<rich:panel  style="height:500px,overflow:auto;" >
						<f:facet name="header">
							<h:outputText value="รายการ Vendor"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<rich:dataTable width="100%" id="dtbVendorSel" cellpadding="1" cellspacing="0" border="0"
							var="vendorSel" value="#{semmct001Bean.vendorMasterSelList}" 
							rows="10"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column style="width:18" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}" width="5%">
								<f:facet name="header">
								</f:facet>
								<div align="center">
								<sem:radioButton id="rdBtSel"
					  							 name="rdCol"
					  							 overrideName="true"
					  							 value="#{semmct001Bean.selectedRadio}"
					  							 itemValue="#{vendorSel.rowId}"/>
								</div>
							</rich:column>
													
							<rich:column  style="width: 90" sortBy="#{vendorSel.vendorCode}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Vendor Code" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorSel.vendorCode}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  style="width: 90" sortBy="#{vendorSel.company}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Company" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorSel.company}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column style="width:150" sortBy="#{vendorSel.vendorName1}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Vendor Name1" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorSel.vendorName1}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorSel.idCard}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="เลขประจำตัวประชาชน" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorSel.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorSel.taxId}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="เลขประจำตัวผู้เสียภาษี" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorSel.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorSel.address}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}" width="300px">
								<f:facet name="header">
									<h:outputText value="ที่อยู่" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorSel.address}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorSel.branchNo}" styleClass="#{(semmct001Bean.tmpRowId==vendorSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Branch Id" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorSel.branchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct001Bean.vendorMasterSelList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="5">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendorSel"
											maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendorSel" 
											style="background-color: #cccccc;"
											page="#{semmct001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
								
						</h:panelGroup>
						</h:panelGrid>
						</rich:panel>
						<!-- end content criteria -->
						<h:panelGrid  id="grdSearchCommand" columns="2">
							<a4j:commandButton id="btnSelectVendor" value="Select" styleClass="rich-button"
							action="#{navAction.navi}" >
							<a4j:support event="oncomplete" reRender="oppContent"></a4j:support>
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSelectVendor" />
							<a4j:actionparam name="mode" value="SELECT" />
							<rich:componentControl for="popupFrmSelectVendor" operation="hide" event="onclick" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancelVendor" value="Cancel" styleClass="rich-button" 
							action="#{navAction.navi}" >
								<a4j:support event="oncomplete" reRender="oppContent"></a4j:support>
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
								<a4j:actionparam name="methodWithNavi" value="doClearSelectVendor" />
								<rich:componentControl for="popupFrmSelectVendor" operation="hide" event="onclick" />
							</a4j:commandButton>
			           		
						</h:panelGrid>
				</h:panelGrid>
		</h:panelGrid>
		</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupFrmSelectPayee" width="700" height="550" style="overflow:auto;">
		<f:facet name="header"><h:outputText value="Popup Select Payee"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpSelPayee" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSelectPayee" attachTo="hidePopUpSelPayee" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmSelectPayee">
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<rich:panel>
						<f:facet name="header">
							<h:outputText value="รายการ Payee"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<rich:dataTable width="100%" id="dtbPayeeSel" cellpadding="1" cellspacing="0" border="0"
							var="payeeSel" value="#{semmct001Bean.payeeMasterSelList}" 
							rows="10"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column style="width:18" styleClass="#{(semmct001Bean.tmpRowId==payeeSel.rowId)?'onClick':'unClick'}" width="5%">
								<f:facet name="header">
								</f:facet>
								<div align="center">
								<sem:radioButton id="rdBtSel"
					  							 name="rdCol"
					  							 overrideName="true"
					  							 value="#{semmct001Bean.selectedRadio}"
					  							 itemValue="#{payeeSel.rowId}"/>
								</div>
							</rich:column>
														
							<rich:column  style="width: 90" sortBy="#{payeeSel.payeeName}" styleClass="#{(semmct001Bean.tmpRowId==payeeSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Payee Name" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{payeeSel.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column style="width:240" sortBy="#{payeeSel.idCard}" styleClass="#{(semmct001Bean.tmpRowId==payeeSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="เลขที่ประจำตัวประชาชน" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{payeeSel.idCard}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{payeeSel.taxId}" styleClass="#{(semmct001Bean.tmpRowId==payeeSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="เลขประจำตัวผู้เสียภาษี" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{payeeSel.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{payeeSel.address}" styleClass="#{(semmct001Bean.tmpRowId==payeeSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ที่อยู่" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{payeeSel.address}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct001Bean.payeeMasterSelList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="2">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPayeeSel"
											maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstPayeeSel" 
											style="background-color: #cccccc;"
											page="#{semmct001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
								
						</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSelectPayee" value="Select" styleClass="rich-button"
							action="#{navAction.navi}" >
							<a4j:support event="oncomplete" reRender="frmSave,pnlPayeeMaster"></a4j:support>
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSelectPayee" />
							<rich:componentControl for="popupFrmSelectPayee" operation="hide" event="onclick" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancelPayee" value="Cancel" styleClass="rich-button" 
							action="#{navAction.navi}">
								<a4j:support event="oncomplete" reRender="frmSave,pnlPayeeMaster"></a4j:support>
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
								<a4j:actionparam name="methodWithNavi" value="doClearSelectPayee" />
								<rich:componentControl for="popupFrmSelectPayee" operation="hide" event="onclick" />
							</a4j:commandButton>
			           		
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
		</h:panelGrid>
		</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupFrmSelectBank" width="700"  height="550" style="overflow:auto;">
		<f:facet name="header"><h:outputText value="Popup Select Bank"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpSelBank" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSelectBank" attachTo="hidePopUpSelBank" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmSelectBank">
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="เงื่อนไขการค้นหา"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr valign="baseline">
									<td align="right" width="20%">
									<h:outputText value="Bank Code :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" >
		                			<h:inputText id="txtBankCode" value="#{semmct001Bean.criteriaBank.bankCode}"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="Bank Name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" >
		                			<h:inputText id="txtBankName" value="#{semmct001Bean.criteriaBank.bankName}"/>
				                	</td>
			                	 </tr>
			                	  
			                	  <tr>
									<td align="right">
									<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
										reRender="frmError,pnlSearchResult" >
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doSearchBankCode" />
									</a4j:commandButton>
									</td>
		                			<td>
					            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
					            	 	action="#{navAction.navi}" reRender="txtBankCode,txtBankName">
					            		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="#{navAction.navPrograme}" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doClearSearchBankCriteria" />
					            	</a4j:commandButton>
		                			</td>
		                			<td colspan="2">
		                			</td>
			                    </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
					
					
				</h:panelGrid>
				
				
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<rich:panel id="pnlSearchResult">
						<f:facet name="header">
							<h:outputText value="ค้นหา Bank"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct001Bean.msgDataNotFound}" rendered="#{semmct001Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<rich:dataTable width="100%" id="dtbBankSel" cellpadding="1" cellspacing="0" border="0"
							var="bankSel" value="#{semmct001Bean.bankSelList}" 
							rows="10"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column style="width:18" styleClass="#{(semmct001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}" width="5%">
								<f:facet name="header">
								</f:facet>
								<div align="center">
								<sem:radioButton id="rdBtSel"
					  							 name="rdCol"
					  							 overrideName="true"
					  							 value="#{semmct001Bean.selectedRadio}"
					  							 itemValue="#{bankSel.bankCode}"/>
								</div>
							</rich:column>
														
							<rich:column  style="width: 90" sortBy="#{bankSel.bankCode}" styleClass="#{(semmct001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Bank Code" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{bankSel.bankCode}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column style="width:240" sortBy="#{bankSel.bankName}" styleClass="#{(semmct001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Bank Name" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bankSel.bankName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{bankSel.bankBranch}" styleClass="#{(semmct001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Bank Branch" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bankSel.bankBranch}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct001Bean.bankSelList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="3">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBankSel"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendorSel" 
											style="background-color: #cccccc;"
											page="#{semmct001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
								
						</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSelectVendorBookBank" value="Select" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent,frmSave">
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSelectBank" />
							<rich:componentControl for="popupFrmSelectBank" operation="hide" event="onclick" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancelVendorBookBank" value="Cancel" styleClass="rich-button" immediate="true">
								<rich:componentControl for="popupFrmSelectBank" operation="hide" event="onclick" />
							</a4j:commandButton>
			           		
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
		</a4j:form>
</rich:modalPanel>



