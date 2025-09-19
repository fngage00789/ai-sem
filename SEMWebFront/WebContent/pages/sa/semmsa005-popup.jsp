<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.sa.semmsa005" var="jspMsg"/>

<rich:modalPanel id="popupAddNewContract" autosized="true" minWidth="800" height="600">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']}" styleClass="width:800px"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddNewContract" style="cursor:pointer"/>
				<rich:componentControl for="popupAddNewContract" attachTo="hidePopupAddNewContract" operation="hide" event="onclick">
				<a4j:support reRender="txtContractNoAdd"></a4j:support>
				</rich:componentControl>
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmErrorPopup">
				<h:messages id="errorPopup" errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
				
				<a4j:form id="pnlSearchAddContract" ajaxSubmit="true">
				<rich:panel id="pnlSearchContract" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.contract']}" style="width:800px"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%" valign="top">
									<h:graphicImage value="images/icon_required.gif" rendered="false"/>
									<rich:spacer width="5" rendered="false"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputTextarea id="txtContractNoAddPop" value="#{semmsa005Bean.addContractNo}" 
		                				cols="50" rows="3" onblur="renderedBtnSearch();#{rich:component('mdpWait')}.hide();" />
			                			
			                			<a4j:jsFunction name="renderedBtnSearch" reRender="btnSearchCtx" ></a4j:jsFunction>
			                			
	                				</td>
	                				<td align="right" width="20%" valign="top">
	                					<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
	                				</td>
	                				<td width="30%" align="left" valign="top">
	                					<h:inputText id="txtSiteNameAddPop" 
			                				value="#{semmsa005Bean.addSiteName}" onblur="renderedBtnSearch();#{rich:component('mdpWait')}.hide();"/>
	                				</td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">
	                					<h:outputText value="#{jspMsg['label.location']}" styleClass="ms7" />
	                				</td>
	                				<td width="30%" align="left">
	                					<h:inputText id="txtLocationAddPop" 
			                				value="#{semmsa005Bean.addLocation}" onblur="renderedBtnSearch();#{rich:component('mdpWait')}.hide();"/>
	                				</td>
	                				<td align="right" width="20%">
	                				</td>
	                				<td width="30%" align="left">
	                				
	                				</td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">
	                					
	                				</td>
	                				<td width="30%" align="left">
	                					<a4j:commandButton id="btnSearchCtx" value="#{jspMsg['btn.search']}" styleClass="rich-button"
											action="#{navAction.navi}"
											disabled="#{semmsa005Bean.addContractNo == '' &&
											 semmsa005Bean.addSiteName == '' && 
											 semmsa005Bean.addLocation == ''}" 
											reRender="pnlContractSearchResultPopup,dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult" >
											<a4j:actionparam name="navModule" value="sa" />
											<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
											<a4j:actionparam name="moduleWithNavi" value="sa" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
											<a4j:actionparam name="methodWithNavi" value="doSearchBeforAddContract" />
										</a4j:commandButton>
	                				</td>
	                				<td align="right" width="20%">
	                					
	                				</td>
	                				<td width="30%" align="left">
	                				
	                				</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
					
					<!-- search result -->
					<h:panelGrid  width="100%">
							<rich:panel id="pnlContractSearchResultPopup">
							<f:facet name="header" >
								<h:outputText value="#{jspMsg['header.selectBorrow']}" style="width:600px"/>
							</f:facet>
	 						<div align="center">
								<h:outputLabel style="color:red;size:20px" value="#{semmsa005Bean.msgDataNotFound}" rendered="#{semmsa005Bean.renderedMsgDataNotFound}" />
							</div>
							 <rich:dataTable width="98%" id="dtbContcfBorrowRequestPopup" cellpadding="1" cellspacing="0" border="0"
								var="contractSP" value="#{semmsa005Bean.contractSPList}" reRender="dtbBorrowRequestPopup" 
								rows="10" rowClasses="cur" styleClass="dataTable">
								<a4j:support event="onRowClick"   action="#{semmsa005Action.getRowIdOnClick2}" reRender="dtbBorrowRequestPopup">
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.contractNo}" />
								</a4j:support>
								<rich:column id="colSelectPop"
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}" 
									rendered="#{semmsa005Bean.modeReturn != 'VIEW'}">
									<f:facet name="header" >
										<h:outputText value="Select" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
		            					<h:selectBooleanCheckbox id="siteAcqSelected" value="#{contractSP.checkBox}" 
	                                        rendered="true" disabled="#{contractSP.dataObj.statusBorrow != 'Y'}">
	                                        <a4j:support event="onclick" action="#{semmsa005Action.onRenderButton}" 
	                                        reRender="btnApprove, clearBatchNo, btnExport, btnNew, dtbSiteInfo, popupRequestType, btnReassign,btnAddCtx">
	                                        	<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
	                                    	</a4j:support>
                                   	 	</h:selectBooleanCheckbox>						
									</div>
								</rich:column>
								
								<rich:column  id="colContContractNoPop" sortBy="#{contractSP.dataObj.contractNo}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.contractNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column  id="colContSiteNamePop" sortBy="#{contractSP.dataObj.siteName}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width: 100"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column  id="colContCirclePop" sortBy="#{contractSP.dataObj.cycleNo}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.cycle']}" styleClass="contentform" style="width: 20px;"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.cycleNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column id="colContEffectiveDtPop" sortBy="#{contractSP.dataObj.effectiveDt}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.effectiveDt']}" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.effectiveDt}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								
								<rich:column  id="colContExpireDtPop" sortBy="#{contractSP.dataObj.expireDt}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.expireDt']}" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.expireDt}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								
								<rich:column  id="colBorrowStatusPop" sortBy="#{contractSP.dataObj.statusBorrowDesc}" 
									styleClass="#{(semmsa005Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.borrowStatus']}" styleClass="contentform" style="width: 50"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.statusBorrowDesc}" styleClass="contentform"  />
									</div>
								</rich:column>
									
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa005Bean.contractSPList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContcfBorrowRequestPopup"
											maxPages="#{semmsa005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBorrowContractPop" 
											style="background-color: #cccccc;"
											page="#{semmsa005Bean.scrollerPage}" 
										/>
									</rich:column>
									</rich:columnGroup>
								</f:facet>
								</rich:dataTable>
								</rich:panel>
						</h:panelGrid>
					<!-- END search result -->
					
					<h:panelGrid>
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td>
									<a4j:commandButton id="btnAddCtx" value="#{jspMsg['btn.add']}" styleClass="rich-button"
											disabled="#{semmsa005Bean.disabledBtnAdd}"
											action="#{navAction.navi}" reRender="dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,
											popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult,btnAddCtx,pnlContractSearchResultPopup" >
											<a4j:actionparam name="navModule" value="sa" />
											<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
											<a4j:actionparam name="moduleWithNavi" value="sa" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
											<a4j:actionparam name="methodWithNavi" value="doAddContract" />
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnClearContract" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,
											popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult,btnAddCtx,pnlContractSearchResultPopup" >
											<a4j:actionparam name="navModule" value="sa" />
											<a4j:actionparam name="navProgram" value="SEMMSA005-1" />
											<a4j:actionparam name="moduleWithNavi" value="sa" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
											<a4j:actionparam name="methodWithNavi" value="doClearAddContrac" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid  width="100%">
						<rich:panel id="pnlSearchResultPopup">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width:600px"/>
						</f:facet>
 						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsa005Bean.msgDataNotFound}" rendered="#{semmsa005Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="98%" id="dtbBorrowRequestPopup" cellpadding="1" cellspacing="0" border="0"
							var="borrowSP" value="#{semmsa005Bean.borrowSPList}" reRender="dtbBorrowRequestPopup" 
							rows="10" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsa005Action.getRowIdOnClick2}" reRender="dtbBorrowRequestPopup">
								<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}" />
							</a4j:support>
							<rich:column id="colDeletePop" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}" 
								rendered="#{semmsa005Bean.modeReturn != 'VIEW'}">
								<f:facet name="header" >
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDeletePopup" 
	            						oncomplete="#{rich:component('mdpConfirmDelPop')}.show(); return false" 
	            						image="images/delete.png" style="height: 15; width: 15"
	            						action="#{navAction.navi}" 
	            						reRender="frmConfirmDelDialog2,btnAddCtx,pnlContractSearchResultPopup,mdpConfirmDelPop"
	            						rendered="#{(borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == '')and !semmsa005Bean.onePopupFlag}">
										<a4j:actionparam name="navModule" value="sa" />
		            					<a4j:actionparam name="navProgram" value="SEMMSA005-1" />	
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
										<a4j:actionparam name="fromPopup" value="popup" />	
	            					</a4j:commandButton>     
	            					<a4j:commandButton id="btnDeletePopup2" 
	            						oncomplete="#{rich:component('mdpConfirmDelPop')}.show(); return false" 
	            						image="images/delete.png" style="height: 15; width: 15"
	            						action="#{navAction.navi}"
	            						reRender="frmConfirmDelDialog2,btnAddCtx,pnlContractSearchResultPopup,mdpConfirmDelPop" 
	            						rendered="#{(borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == '')and semmsa005Bean.onePopupFlag}">
										<a4j:actionparam name="navModule" value="sa" />
		            					<a4j:actionparam name="navProgram" value="SEMMSA005-6" />	
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
										<a4j:actionparam name="fromPopup" value="popup" />	
	            					</a4j:commandButton>        							
								</div>
							</rich:column>
							
							<rich:column  id="colContractNoPop" sortBy="#{borrowSP.dataObj.contractNo}" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.contractNo}" styleClass="contentform"  />
									<h:inputHidden value="#{borrowSP.dataObj.returnContractId}"/>
								</div>
							</rich:column>
							
							<rich:column  id="colSiteNamePop" sortBy="#{borrowSP.dataObj.siteName}" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  id="colCirclePop" sortBy="#{borrowSP.dataObj.cycle}" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.cycle']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.cycle}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							
							
							<rich:column id="colEffectiveDtPop" sortBy="#{borrowSP.dataObj.effectiveDt}" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effectiveDt']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.effectiveDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  id="colExpireDtPop" sortBy="#{borrowSP.dataObj.expireDt}" 
								styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expireDt']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.expireDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
								
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsa005Bean.borrowSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBorrowRequestPopup"
											maxPages="#{semmsa005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBorrowPop" 
											style="background-color: #cccccc;"
											page="#{semmsa005Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
					<h:panelGrid>
										<a4j:commandButton value="Close" styleClass="rich-button" reRender="txtContractNoAdd,pnlSearchResult" immediate="true">
											<rich:componentControl for="popupAddNewContract" operation="hide" event="onclick"  />
										</a4j:commandButton>
					</h:panelGrid>
				</h:panelGrid>
					</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelPop" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog2">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelformDel" width="170px">
						<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelformDel">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" id="delPop01"
							reRender="pnlSearchResultPopup,pnlContractSearchResultPopup,popupFrmErrorPopup,popupFrmAddContractStatus,txtContractNoAdd,dtbBorrowRequest,pnlSearchResult" rendered="#{!semmsa005Bean.onePopupFlag}" >
							<a4j:actionparam name="navModule" value="sa" />
		            		<a4j:actionparam name="navProgram" value="SEMMSA005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="deleteContract" />
							<rich:componentControl for="mdpConfirmDelPop" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" id="delPop02"
							reRender="pnlSearchResultPopup,pnlContractSearchResultPopup,popupFrmErrorPopup,popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult" rendered="#{semmsa005Bean.onePopupFlag}">
							<a4j:actionparam name="navModule" value="sa" />
		            		<a4j:actionparam name="navProgram" value="SEMMSA005-6" />	
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="deleteContract" />
							<rich:componentControl for="mdpConfirmDelPop" operation="hide" event="oncomplete"  />
						</a4j:commandButton>													
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelPop" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- ----------------------------------------------------- -->

<!-- popup download borrow contract -->
<rich:modalPanel id="popupDownloadContractFile" width="300"  height="400" autosized="true" minWidth="220" moveable="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Download Contract file"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupDownloadContractFile" style="cursor:pointer"/>
				<rich:componentControl for="popupDownloadContractFile" attachTo="hidepopupDownloadContractFile" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	
	<h:panelGrid width="100%">
		<a4j:form id="frmDownloadContractFile">
			<rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
				<f:facet name="errorMarker">
		 		   <h:graphicImage value="images/error.gif" />  
                </f:facet>
			 </rich:messages>
			 
			
		     <rich:panel>
		     	<f:facet name="header">
					<h:outputText value="Search File"/>
				</f:facet>
			     <table width="100%">
			  	 	
			  	 	<tr>
			     		<td colspan="4">
					     	<rich:dataTable id="dtbFileDownload" cellpadding="1" cellspacing="0" border="0"
							var="attachment" value="#{semmsa005Bean.srchFileSPList}" 
							rows="#{semmsa005Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform" style="height : 79px; width : 600px;">
								
							
							<rich:column sortBy="#{attachment.fileName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.fileName']}" styleClass="contentform" style= " width : 300px" />
									</f:facet>
									<div align="left">
										<h:commandLink action="#{navAction.doDownload}" value="#{attachment.fileName}">
			 								<f:param name="pathName" value="#{attachment.attachmentPath}"/>	
			 								<f:param name="fileName" value="#{attachment.fileName}"/>
					         			</h:commandLink>     
									</div>
								</rich:column>
								
								<rich:column sortBy="#{attachment.updateBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.updateBy']}" styleClass="contentform" style= " width : 100px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.updateBy}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.updateDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.updateDt']}" styleClass="contentform" style= " width : 150px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.updateDtStr}" styleClass="contentform" >
										</h:outputText>
									</div>
								</rich:column>
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa005Bean.srchFileSPList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="5">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbFileDownload"
												maxPages="#{semmsa005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstPicFileDownload" 
												style="background-color: #cccccc;"
												page="#{semmsa005Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
							</rich:dataTable>
						</td>
					</tr>
				</table>
		    </rich:panel>
		    <br/>
		    <a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
		    <rich:componentControl for="popupDownloadContractFile" operation="hide" event="onclick" />
			</a4j:commandButton>
		</a4j:form>
		</h:panelGrid>
		
</rich:modalPanel>