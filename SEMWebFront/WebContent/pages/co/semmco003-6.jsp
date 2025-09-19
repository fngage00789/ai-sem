<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.co.semmco003" var="jspMsg"/>

<h:panelGrid width="100%">
	<rich:panel id="pnlBorrowContract">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
				<a4j:form id="frmSearchBorrow">
					<h:panelGrid width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td width="50%" align="left">
										<table id="tblMessage">
											<tr><td>
												<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
													rendered="#{semmco003Bean.renderedMsgFormTop}">
												 		<f:facet name="header">
								                        	<h:outputText value="Entered Data Status:"></h:outputText>
								                    	</f:facet>
											 			<f:facet name="errorMarker">
											 				 <h:graphicImage value="images/error.gif" />  
									                    </f:facet>
								            	</rich:messages>
											</td></tr>
										</table>
									</td>
									<td width="50%" align="right" valign="baseline">
										<table id="tblButton">
											<tr><td>
												<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
													action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="co" />
													<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
													<a4j:actionparam name="moduleWithNavi" value="co" />
													<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
													<a4j:actionparam name="methodWithNavi" value="doBack" />
													<a4j:actionparam name="mode" value="SEARCH" />
												</a4j:commandButton>
											</td></tr>
										</table>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%" valign="baseline">
									<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="80%" colspan="3" valign="bottom">
									<h:selectOneMenu id="ddlCompany" value="#{semmco003Bean.criteriaBorrow.company}" 
										onchange="GetCompanyJS();" disabled="true">
										<f:selectItems value="#{semmco003Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmco003Bean.criteriaBorrow.company}" styleClass="ms28"/>
				                	</td>
			                	 </tr>
								<tr>
									<td align="right" width="20%" valign="top">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
		                			</td>
		                			<td width="80%" colspan="3">
		                			<h:inputTextarea id="txtContractNo" value="#{semmco003Bean.viewContractNo}" 
		                				cols="50" rows="3" />
	                				</td>
			                	 </tr>
			                	 
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" 
							reRender="pnlBorrowContract,frmShowError,pnlSearchCriteria,pnlSearchResult,frmSearchContract" >
							<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO003-3" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="doSearchContract" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	  action="#{navAction.navi}"  
			           	 	  reRender="pnlBorrowContract,pnlSearchCriteria,pnlSearchResult,frmSearchBorrow">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO003-6" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
								<a4j:actionparam name="methodWithNavi" value="doClearBorrow" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					
					<br/>
					<h:panelGrid  columns="6" id="grdAddCommand">
		            	<h:commandButton id="btnExport" value="#{jspMsg['btn.export.borrow']}" styleClass="rich-button"
							action="#{semmco003Action.doExportExcel}" disabled="#{semmco003Bean.disabledBtnExport}" 
							rendered="#{semmco003Bean.renderer['btnExport']}">
						</h:commandButton>
						<a4j:commandButton value="#{jspMsg['btn.borrow.request']}"
							oncomplete="if(#{semmco003Bean.popupBorrowOpen == 'true'})#{rich:component('popupBorrowContract')}.show();if(#{semmco003Bean.popupAlert == 'true'})#{rich:component('mdpAlertDialog')}.show(); return false"  
						    action="#{navAction.navi}" reRender="popupBorrowContract,frmAlertDialog" 
						    styleClass="rich-button" disabled="#{semmco003Bean.disabledBtnExport}" 
						    rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="initBorrowContract" />
							<a4j:actionparam name="mode" value="MULTIADD" />
							<a4j:actionparam name="popup" value="BORROW" />
	            		</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg['btn.return.request']}"
							oncomplete="if(#{semmco003Bean.popupBorrowOpen == 'true'})#{rich:component('popupReturnContract')}.show();if(#{semmco003Bean.popupAlert == 'true'})#{rich:component('mdpAlertDialog')}.show(); return false"  
						    action="#{navAction.navi}" reRender="popupReturnContract,popupFrmAddContractReturn,pnlRentalType,frmAlertDialog" 
						    styleClass="rich-button" disabled="#{semmco003Bean.disBtnBorrow}" 
						    rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="doinitReturnContract" />
							<a4j:actionparam name="returnID" value=""/>
							<a4j:actionparam name="mode" value="MULTIADD" />
							<a4j:actionparam name="popup" value="RETURN" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnAddContract" value="#{jspMsg['btn.add']}" styleClass="rich-button"
			                				disabled="#{semmco003Bean.criteriaBorrow.company == null or semmco003Bean.criteriaBorrow.company == '' or semmco003Bean.mode == 'VIEW'}"
											action="#{navAction.navi}" reRender="popupFrmError,pnlBorrowRequest,popupAddNewContract"
											oncomplete="#{rich:component('popupAddNewContract')}.show(); return false">
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO003-6" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
											<a4j:actionparam name="methodWithNavi" value="doInitAddContract" />
											<a4j:actionparam name="onePopup" value="trueFlag" />
						</a4j:commandButton>
										
						<a4j:commandButton id="btnApproveBorrow" value="#{jspMsg['btn.appBorrow']}" 
						action="#{navAction.navi}"  styleClass="rich-button"
		                disabled="#{semmco003Bean.disabledBtnExport}"
		                reRender="popupFrmError,pnlSearchResult" 
		                onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
		                	<a4j:actionparam name="navModule" value="co" />
		                    <a4j:actionparam name="navProgram" value="SEMMCO003-6" />
		                                                    
		                    <a4j:actionparam name="moduleWithNavi" value="co" />
		                    <a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
		                    <a4j:actionparam name="methodWithNavi" value="doApproveBorrow" />
		                    
							<a4j:actionparam name="approveStatus" value="Y" />
		               	</a4j:commandButton>
		               	
		               	<a4j:commandButton id="btnNotApproveBorrow" value="#{jspMsg['btn.notAppBorrow']}" 
						action="#{navAction.navi}"  styleClass="rich-button"
		                disabled="#{semmco003Bean.disabledBtnExport}"
		                reRender="popupFrmError,pnlSearchResult" 
		                onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
		                	<a4j:actionparam name="navModule" value="co" />
		                    <a4j:actionparam name="navProgram" value="SEMMCO003-6" />
		                                                    
		                    <a4j:actionparam name="moduleWithNavi" value="co" />
		                    <a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
		                    <a4j:actionparam name="methodWithNavi" value="doApproveBorrow" />
		                    
							<a4j:actionparam name="approveStatus" value="N" />
		               	</a4j:commandButton>
					</h:panelGrid>
					</a4j:form>
					
					
					<a4j:form id="frmSearchBorrowResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				<h:panelGrid  width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1400"/>
						</f:facet>
 						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco003Bean.msgDataNotFound}" rendered="#{semmco003Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbBorrowRequest" cellpadding="1" cellspacing="0" border="0"
							var="borrowSP" value="#{semmco003Bean.borrowSPList}" reRender="dtbBorrowRequest" 
							rows="10" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmco003Action.getRowIdOnClick2}" reRender="dtbBorrowRequest">
								<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}" />
							</a4j:support>
							<rich:column style="width:18" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}" 
								width="5%" rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmco003Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmco003Action.selectAllRow}" reRender="dtbBorrowRequest,btnExport,frmButton,grdAddCommand"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox id="chkSelect"  value="#{borrowSP.checkBox}">
									<a4j:support event="onclick" action="#{semmco003Action.onRenderExportButton}" reRender="btnExport,frmButton,dtbBorrowRequest,grdAddCommand">
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}" />
									</a4j:support>
								</h:selectBooleanCheckbox>
							</rich:column>
							<rich:column id="colDelete" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}" 
								rendered="#{semmco003Bean.modeReturn != 'VIEW'}">
								<f:facet name="header" >
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDelete" 
	            						oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            						image="images/delete.png" style="height: 15; width: 15"
	            						action="#{navAction.navi}" 
	            						rendered="#{borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == ''}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
	            					</a4j:commandButton>        							
								</div>
							</rich:column>
							
							<rich:column id="colBorrow" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:panelGroup rendered="#{(borrowSP.dataObj.returnName == null || borrowSP.dataObj.returnName == '') && semmco003Bean.modeReturn != 'VIEW'}">
									<a4j:commandLink id="btnEdit" value="#{jspMsg['btn.borrow.request']}"
										oncomplete="#{rich:component('popupBorrowContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupBorrowContract">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="effDt" value="#{borrowSP.dataObj.effDtStr}"/>
										<a4j:actionparam name="expDt" value="#{borrowSP.dataObj.expDtStr}"/>
										<a4j:actionparam name="mode" value="EDIT" />
	            					</a4j:commandLink>   
	            					</h:panelGroup>
	            					<h:panelGroup rendered="#{(borrowSP.dataObj.returnName != null && borrowSP.dataObj.returnName != '') && semmco003Bean.modeReturn != 'VIEW'}">
									<a4j:commandLink id="btnEditModeView" value="#{jspMsg['btn.borrow.request']}"
										oncomplete="#{rich:component('popupBorrowContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupBorrowContract">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="mode" value="VIEW" />
	            					</a4j:commandLink>
									</h:panelGroup>
									<h:panelGroup rendered="#{(borrowSP.dataObj.borrowName != null && borrowSP.dataObj.borrowName != '') && semmco003Bean.modeReturn == 'VIEW'}">
									<a4j:commandLink id="btnEditModeView2" value="#{jspMsg['btn.borrow.request']}"
										oncomplete="#{rich:component('popupBorrowContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupBorrowContract">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="mode" value="VIEW" />
	            					</a4j:commandLink>
									</h:panelGroup>
								</div>
							</rich:column>
							
							<rich:column id="colReturn" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
								
	            					<a4j:commandLink id="btnReturn" value="#{jspMsg['btn.return.request']}"
										oncomplete="#{rich:component('popupReturnContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupReturnContract,popupFrmAddContractReturn,pnlRentalType" 
						            	rendered="#{(borrowSP.dataObj.borrowName != null && borrowSP.dataObj.borrowName != '' &&  borrowSP.dataObj.cantBorrowFlg == 'N') && semmco003Bean.modeReturn != 'VIEW'}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="doinitReturnContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
										<a4j:actionparam name="mode" value="EDIT" />
										<a4j:actionparam name="siteAppId" value="#{borrowSP.dataObj.siteAppId}" />
                                   	 	<a4j:actionparam name="placeType" value="#{borrowSP.dataObj.placeType}" />
                                    	<a4j:actionparam name="partiesType" value="#{borrowSP.dataObj.partiesType}" />
                                    	<a4j:actionparam name="placeTypeRemark" value="#{borrowSP.dataObj.placeTypeRemark}" />
                                    	<a4j:actionparam name="partiesTypeRemark" value="#{borrowSP.dataObj.partiesTypeRemark}" />
                                    	<a4j:actionparam name="docApproveId" value="#{borrowSP.dataObj.docApproveId}" />
	            					</a4j:commandLink>
	            					<a4j:commandLink id="btnReturnView" value="#{jspMsg['btn.return.request']}"
										oncomplete="#{rich:component('popupReturnContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupReturnContract,popupFrmAddContractReturn,pnlRentalType" 
						            	rendered="#{(borrowSP.dataObj.returnName != null && borrowSP.dataObj.returnName != '') && semmco003Bean.modeReturn == 'VIEW'}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="doinitReturnContract" />
										<a4j:actionparam name="contractID" value="#{borrowSP.dataObj.borrowContractId}"/>
										<a4j:actionparam name="returnID" value="#{borrowSP.dataObj.returnContractId}"/>
										<a4j:actionparam name="mode" value="VIEW" />
										<a4j:actionparam name="siteAppId" value="#{borrowSP.dataObj.siteAppId}" />
                                   	 	<a4j:actionparam name="placeType" value="#{borrowSP.dataObj.placeType}" />
                                    	<a4j:actionparam name="partiesType" value="#{borrowSP.dataObj.partiesType}" />
                                    	<a4j:actionparam name="placeTypeRemark" value="#{borrowSP.dataObj.placeTypeRemark}" />
                                    	<a4j:actionparam name="partiesTypeRemark" value="#{borrowSP.dataObj.partiesTypeRemark}" />
                                    	<a4j:actionparam name="docApproveId" value="#{borrowSP.dataObj.docApproveId}" />
	            					</a4j:commandLink>  							
								</div>
							</rich:column>
							
							<rich:column  id="colContractNo" sortBy="#{borrowSP.dataObj.contractNo}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  id="colSiteName" sortBy="#{borrowSP.dataObj.siteName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column id="colEffectiveDt" sortBy="#{borrowSP.dataObj.effectiveDt}" 
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
							
							<rich:column  id="colExpireDt" sortBy="#{borrowSP.dataObj.expireDt}" 
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
							
							<rich:column  id="colDocContractFlag" sortBy="#{borrowSP.dataObj.docContractFlag}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docContractFlag']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.docContractFlag}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colDocApproveFlag" sortBy="#{borrowSP.dataObj.docApproveFlag}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docApproveFlag']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.docApproveFlag}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colRemarkDocOther" sortBy="#{borrowSP.dataObj.remarkDocOther}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkDocOther']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.remarkDocOther}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colBorrowForTypeName" sortBy="#{borrowSP.dataObj.borrowForTypeName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowForTypeName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowForTypeName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colBorrowOfficerName" sortBy="#{borrowSP.dataObj.borrowOfficerName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowOfficerName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowOfficerName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colBorrowName" sortBy="#{borrowSP.dataObj.borrowName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colBorrowDt" sortBy="#{borrowSP.dataObj.borrowDt}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowDt']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column id="colReturnName" sortBy="#{borrowSP.dataObj.returnName}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.returnName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.returnName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="colReturnDt" sortBy="#{borrowSP.dataObj.returnDt}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.returnDt']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.returnDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  id="colRemarkCannotBorrow"  sortBy="#{borrowSP.dataObj.remarkCannotBorrow}" 
								styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkCannotBorrow']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.remarkCannotBorrow}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{borrowSP.dataObj.borrowStatus}" 
							styleClass="#{(semmco003Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowStatus']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{borrowSP.dataObj.borrowContractType}" 
							styleClass="#{(semmsa005Bean.tmpRowId2==borrowSP.dataObj.borrowContractId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.borrowContractType']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.borrowContractType}" styleClass="contentform" />
								</div>
							</rich:column>
								
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco003Bean.borrowSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="16">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBorrowRequest"
											maxPages="#{semmco003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmco003Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
					
				</h:panelGrid>
		</h:panelGrid>
		
		
	</rich:panel>
	<jsp:include page="../../pages/co/semmco003-4.jsp" />
	<jsp:include page="../../pages/co/semmco003-5.jsp" />
	
</h:panelGrid>

<jsp:include page="../../pages/co/semmco003-popup.jsp" />

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="oppContent,pnlLog,dtbBorrowRequest,frmSearchBorrow" >
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="deleteContract" />
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
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
<rich:modalPanel id="mdpAlertDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Warning"></h:outputText>
    </f:facet>
	<a4j:form id="frmAlertDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmco003Bean.contentAlert}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" 
							oncomplete="#{rich:component('popupBorrowContract')}.show();"
							reRender="oppContent,pnlLog,dtbBorrowRequest,frmBorrowError" 
							rendered="#{semmco003Bean.btnBorrowPopup == 'BORROW'}">
							<rich:componentControl for="mdpAlertDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" 
							oncomplete="#{rich:component('popupReturnContract')}.show();"
							reRender="oppContent,pnlLog,dtbBorrowRequest,frmBorrowError" 
							rendered="#{semmco003Bean.btnBorrowPopup == 'RETURN'}">
							<rich:componentControl for="mdpAlertDialog" operation="hide" event="onclick" />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpAlertDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>