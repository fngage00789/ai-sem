<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel001-vmp" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Vendor Master" />
		</f:facet>
		<h:panelGrid id="hpnlError">
			<a4j:form id="frmError_vmp">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch_vmp">             
				<h:panelGrid width="90%" id="hpnSearchResult">
					
					<rich:panel id="pnlSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" />
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir010Bean.msgDataNotFound}" rendered="#{semmir010Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						<rich:dataTable width="95%" id="dtbVendor" cellpadding="1" cellspacing="0" border="0"
							var="vendor" value="#{semmir010Bean.vendorMapPayeeList}" reRender="dstVendor" 
							rows="#{semmir010Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							
							<rich:column id="siteCheck" width="50">
								<f:facet name="header">
									<h:outputText value="Select" />
								</f:facet>
								<div align="center">
								<sem:radioButton id="rdBtSel"
				  							name="rdCol"
				  							overrideName="true"
				  							value="#{semmir010Bean.selectedRadio}"
				  							itemValue="#{vendor.rowId}"/></div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton action="#{navAction.navi}" image="images/edit.png" 
	            									   style="height: 15; width: 15" reRender="oppContent"
	            									   id="btnEdit">
										
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
										<a4j:actionparam name="mode" value="Edit" />
										<a4j:actionparam name="headType" value="Vendor" />
										<a4j:actionparam name="vendorIdParam" value="#{vendor.vendorMasterId.rowId}"/>
										<a4j:actionparam name="contractNoParam" value="#{vendor.contractNo}" />
										<a4j:actionparam name="expenseTypeIdParam" value="18" />
										<a4j:actionparam name="isPageFrom" value="true" />
															
										<a4j:actionparam name="navModuleBack" value="ir" />
										<a4j:actionparam name="navProgramBack" value="SEMMIR010-VMP" />
										<a4j:actionparam name="actionWithNaviBack" value="SEMMIR010"/>
										<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
										<a4j:actionparam name="backOtherPageFlag" value="Y" />
										<a4j:actionparam name="todoManagerFlag" value="N" />
										<a4j:actionparam name="btnActionType" value="E" />
										<a4j:actionparam name="verifyFlag" value="Y" />
										<a4j:actionparam name="actionId" value="PAGE_VERIFY_EDIT" />
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
	            									   id="btnDelete">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{vendor.vendorMasterId.rowId}"/>
										<a4j:actionparam name="vendorMapPayeeId" value="#{vendor.rowId}"/>
										<a4j:actionparam name="mode" value="DELETE" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton  id="btnView" action="#{navAction.navi}" 
						            					image="images/view.png" 
						            					style="height: 15; width: 15"
						            					reRender="oppContent">
	            						<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
										<a4j:actionparam name="mode" value="Edit" />
										<a4j:actionparam name="headType" value="Vendor" />
										<a4j:actionparam name="vendorIdParam" value="#{vendor.vendorMasterId.rowId}"/>
										<a4j:actionparam name="contractNoParam" value="#{vendor.contractNo}" />
										<a4j:actionparam name="expenseTypeIdParam" value="18" />
										<a4j:actionparam name="isPageFrom" value="true" />
															
										<a4j:actionparam name="navModuleBack" value="ir" />
										<a4j:actionparam name="navProgramBack" value="SEMMIR010-VMP" />
										<a4j:actionparam name="actionWithNaviBack" value="SEMMIR010"/>
										<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
										<a4j:actionparam name="backOtherPageFlag" value="Y" />
										<a4j:actionparam name="todoManagerFlag" value="N" />
										<a4j:actionparam name="verifyFlag" value="Y" />
										<a4j:actionparam name="actionId" value="PAGE_VERIFY_EDIT" />
	            					</a4j:commandButton>   
								         							
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.vendorName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.idCard']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contactNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmir010Bean.popupPolicySP.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} Vendor" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.vendorStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recordStatus']} BookBank" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorBookbank.vendorBookbankStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column style="width:200px">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.expenseTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendor.vendorMasterId.remark}" styleClass="contentform"  />
								</div>
							</rich:column>						
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="13">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir010Bean.vendorMapPayeeList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="9">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendor"
											maxPages="#{semmir010Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmir010Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid columns="4">
					<a4j:commandButton  id="btnSiteAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 
										value="#{jspMsg['btn.save']}" 
										reRender="oppContent">
						<a4j:actionparam name="navModule" value="#{semmir010Bean.navModuleFrom}" />
            			<a4j:actionparam name="navProgram" value="#{semmir010Bean.navProgramFrom}" />	
						<a4j:actionparam name="moduleWithNavi" value="#{semmir010Bean.navModuleFrom}" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
						<a4j:actionparam name="methodWithNavi" value="doSaveVendorMapPayee" />
						<a4j:actionparam name="navModuleFrom" value="ir" />
						<a4j:actionparam name="navProgramFrom" value="SEMMIR010-1" />
						<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR010" />
								
					</a4j:commandButton>
					<a4j:commandButton id="btnSearchSiteCancel" styleClass="rich-button" value="#{jspMsg['btn.cancel']}" reRender="oppContent" action="#{navAction.navi}">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMMIR010-2" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
						<a4j:actionparam name="methodWithNavi" value="doBack" />
					</a4j:commandButton>
					<a4j:commandButton id="btnSearchSiteNew" styleClass="rich-button" value="New" reRender="oppContent" action="#{navAction.navi}">
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
						<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
						<a4j:actionparam name="mode" value="Edit" />
						<a4j:actionparam name="headType" value="Vendor" />
						<a4j:actionparam name="contractNoParam" value="#{semmir010Bean.popupPolicySP.contractNo}" />
						<a4j:actionparam name="expenseTypeIdParam" value="18" />
						<a4j:actionparam name="isPageFrom" value="true" />
											
						<a4j:actionparam name="navModuleBack" value="ir" />
						<a4j:actionparam name="navProgramBack" value="SEMMIR010-VMP" />
						<a4j:actionparam name="actionWithNaviBack" value="SEMMIR010"/>
						<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
						<a4j:actionparam name="backOtherPageFlag" value="Y" />
						<a4j:actionparam name="todoManagerFlag" value="N" />
						<a4j:actionparam name="btnActionType" value="N" />
						<a4j:actionparam name="verifyFlag" value="Y" />
						<a4j:actionparam name="actionId" value="PAGE_VERIFY_NEW" />
					</a4j:commandButton>
					<a4j:commandButton id="btnBack" styleClass="rich-button" value="#{jspMsg['btn.back']}" reRender="oppContent" action="#{navAction.navi}">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMMIR010-2" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
						<a4j:actionparam name="methodWithNavi" value="doBack" />		
					</a4j:commandButton>
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
						<h:outputText value="#{semmir010Bean.msgDoDelete}"  styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbVendor,frmSearch_vmp" >
							<a4j:actionparam name="navModule" value="el" />
           					<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteVendorMaster" />
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
</rich:modalPanel>