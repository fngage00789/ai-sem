<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.co.semmco003" var="jspMsg"/>

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
									<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" align="left">
			                			<h:inputText id="txtContractNoAddPop" 
			                				value="#{semmco003Bean.addContractNo}"/>
			                			
			                			<rich:spacer width="5"></rich:spacer>
			                			
			                			<a4j:commandButton id="btnSearchCtx" value="#{jspMsg['btn.search']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="pnlContractSearchResultPopup,dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult" >
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
											<a4j:actionparam name="methodWithNavi" value="doSearchBeforAddContract" />
										</a4j:commandButton>
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
								<h:outputLabel style="color:red;size:20px" value="#{semmco003Bean.msgDataNotFound}" rendered="#{semmco003Bean.renderedMsgDataNotFound}" />
							</div>
							 <rich:dataTable width="98%" id="dtbContcfBorrowRequestPopup" cellpadding="1" cellspacing="0" border="0"
								var="contractSP" value="#{semmco003Bean.contractSPList}" reRender="dtbBorrowRequestPopup" 
								rows="10" rowClasses="cur" styleClass="dataTable">
								<a4j:support event="onRowClick"   action="#{semmco003Action.getRowIdOnClick2}" reRender="dtbBorrowRequestPopup">
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.contractNo}" />
								</a4j:support>
								<rich:column id="colSelectPop"
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}" 
									rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
									<f:facet name="header" >
										<h:outputText value="Select" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
		            					<h:selectBooleanCheckbox id="siteAcqSelected" value="#{contractSP.checkBox}" 
	                                        rendered="true" disabled="#{contractSP.dataObj.statusBorrow != 'Y'}">
	                                        <a4j:support event="onclick" action="#{semmco003Action.onRenderButton}" 
	                                        reRender="btnApprove, clearBatchNo, btnExport, btnNew, dtbSiteInfo, popupRequestType, btnReassign,btnAddCtx">
	                                        	<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
	                                    	</a4j:support>
                                   	 	</h:selectBooleanCheckbox>						
									</div>
								</rich:column>
								
								<rich:column  id="colContContractNoPop" sortBy="#{contractSP.dataObj.contractNo}" 
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 40"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.contractNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column  id="colContSiteNamePop" sortBy="#{contractSP.dataObj.siteName}" 
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width: 100"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column  id="colContCirclePop" sortBy="#{contractSP.dataObj.cycleNo}" 
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.cycle']}" styleClass="contentform" style="width: 20px;"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{contractSP.dataObj.cycleNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column id="colContEffectiveDtPop" sortBy="#{contractSP.dataObj.effectiveDt}" 
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
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
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
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
									styleClass="#{(semmco003Bean.tmpRowId2==contractSP.dataObj.contractNo)?'onClick':'unClick'}">
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
												<f:param value="#{fn:length(semmco003Bean.contractSPList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContcfBorrowRequestPopup"
											maxPages="#{semmco003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBorrowContractPop" 
											style="background-color: #cccccc;"
											page="#{semmco003Bean.scrollerPage}" 
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
											disabled="#{semmco003Bean.disabledBtnAdd}"
											action="#{navAction.navi}" reRender="dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,
											popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult,btnAddCtx,pnlContractSearchResultPopup" >
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
											<a4j:actionparam name="methodWithNavi" value="doAddContract" />
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnClearContract" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="dtbBorrowRequestPopup,popupFrmErrorPopup,txtContractNoAddPop,
											popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult,btnAddCtx,pnlContractSearchResultPopup" >
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
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
							<h:outputLabel style="color:red;size:20px" value="#{semmco003Bean.msgDataNotFound}" rendered="#{semmco003Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="98%" id="dtbBorrowRequestPopup" cellpadding="1" cellspacing="0" border="0"
							var="borrowSP" value="#{semmco003Bean.borrowSPList}" reRender="dtbBorrowRequestPopup" 
							rows="10" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsa005Action.getRowIdOnClick2}" reRender="dtbBorrowRequestPopup">
								<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}" />
							</a4j:support>
							<rich:column id="colDeletePop" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}" 
								rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
								<f:facet name="header" >
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDeletePopup" 
	            						oncomplete="#{rich:component('mdpConfirmDelPop')}.show(); return false" 
	            						image="images/delete.png" style="height: 15; width: 15"
	            						action="#{navAction.navi}" 
	            						reRender="frmConfirmDelDialog2,btnAddCtx,pnlContractSearchResultPopup,mdpConfirmDelPop"
	            						rendered="#{(borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == '')and !semmco003Bean.onePopupFlag}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-1" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
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
	            						rendered="#{(borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == '')and semmco003Bean.onePopupFlag}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
										<a4j:actionparam name="fromPopup" value="popup" />	
	            					</a4j:commandButton>        							
								</div>
							</rich:column>
							
							<rich:column  id="colContractNoPop" sortBy="#{borrowSP.dataObj.contractNo}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.contractNo}" styleClass="contentform"  />
									<h:inputHidden value="#{borrowSP.dataObj.returnContractId}"/>
								</div>
							</rich:column>
							
							<rich:column  id="colSiteNamePop" sortBy="#{borrowSP.dataObj.siteName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  id="colCirclePop" sortBy="#{borrowSP.dataObj.cycle}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.cycle']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.cycle}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							
							
							<rich:column id="colEffectiveDtPop" sortBy="#{borrowSP.dataObj.effectiveDt}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
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
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
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
											<f:param value="#{fn:length(semmco003Bean.borrowSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBorrowRequestPopup"
											maxPages="#{semmco003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBorrowPop" 
											style="background-color: #cccccc;"
											page="#{semmco003Bean.scrollerPage}" 
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
							reRender="pnlSearchResultPopup,pnlContractSearchResultPopup,popupFrmErrorPopup,popupFrmAddContractStatus,txtContractNoAdd,dtbBorrowRequest,pnlSearchResult" rendered="#{!semmco003Bean.onePopupFlag}" >
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-1" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="deleteContract" />
							<rich:componentControl for="mdpConfirmDelPop" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" id="delPop02"
							reRender="pnlSearchResultPopup,pnlContractSearchResultPopup,popupFrmErrorPopup,popupFrmAddContractStatus,txtContractNoAdd,pnlSearchResult" rendered="#{semmco003Bean.onePopupFlag}">
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
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
