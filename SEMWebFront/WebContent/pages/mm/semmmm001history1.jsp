<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.history.contract.info']}"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="frmContractInfo">
			<h:panelGroup id="pnlButton">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
					
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
						           		<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfoHist.siteInfoId}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						           	 	oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						           		</a4j:commandButton>
					           		</td>
			           			</tr>
			           		</table>
           				</td>
           			</tr>
				</table>
			</h:panelGroup>
			<!-- group[1] >> -->
			<rich:panel rendered="#{semmmm001Bean.visiblePnlContractInfo}">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}"/></f:facet>
				
				<!-- contract info panel -->
				<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistContractNo" value="#{semmmm001Bean.contractInfoHist.contractNo}" 
										disabled="true" size="30" maxlength="30" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}"
										disabled="true" size="30" maxlength="30" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.region']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
										disabled="true" size="30" maxlength="30" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.address']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
										disabled="true" size="30" maxlength="30" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
										disabled="true" size="30" maxlength="30" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.effective.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
										disabled="true" size="30" maxlength="30"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.code']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
		                				disabled="true" size="30" maxlength="30"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.expire.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
										disabled="true" size="30" maxlength="30" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.network.status']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
		                				disabled="true" size="30" maxlength="30"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.status']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
										disabled="true" size="30" maxlength="30"/>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										&nbsp;
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.pennding.status']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistPendingStatus" value="#{semmmm001Bean.contractInfoHist.pendingStatus}" 
										disabled="true" size="30" maxlength="30"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.owner.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contact.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.telephone']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
							</table>
					</h:panelGroup>
				</h:panelGrid>
				
			</rich:panel>
			<!-- group[1] << -->
				
			<div style="clear:both; height:10px;"></div>
		
			<!-- group[2] >> -->
			<!-- history data table panel -->
			<rich:panel styleClass="sem_autoScrollbar">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.list.of.vendor.by.contract']}"/></f:facet>
				
				<center>
						
						<rich:dataTable id="dtbVendorListByContract" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.vendorContractHistList}" var="vendorObj"
						reRender="dtbVendorListByContract" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{vendorObj.dataObj.vendorCode}" sortBy="#{vendorObj.dataObj.vendorCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkVendorCode" value="#{vendorObj.dataObj.vendorCode}" 
									action="#{navAction.navi}" reRender="oppContent,txtNavProgram" 
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doVendorHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{vendorObj.dataObj.contractNo}" />
											<a4j:actionparam name="historyPage" value="VD" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorName}" sortBy="#{vendorObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.idCard}" sortBy="#{vendorObj.dataObj.idCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.taxId}" sortBy="#{vendorObj.dataObj.taxId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.expenseType}" sortBy="#{vendorObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.siteName}" sortBy="#{vendorObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.site.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorStatus}" sortBy="#{vendorObj.dataObj.vendorStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorFlowStatus}" sortBy="#{vendorObj.dataObj.vendorFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorBlockStatus}" sortBy="#{vendorObj.dataObj.vendorBlockStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bankName}" sortBy="#{vendorObj.dataObj.bankName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bankBranch}" sortBy="#{vendorObj.dataObj.bankBranch}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.bankBranch}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.accountNo}" sortBy="#{vendorObj.dataObj.accountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.accountName}" sortBy="#{vendorObj.dataObj.accountName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.accountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bookbankStatus}" sortBy="#{vendorObj.dataObj.bookbankStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bookbankFlowStatus}" sortBy="#{vendorObj.dataObj.bookbankFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeId}" sortBy="#{vendorObj.dataObj.payeeId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeName}" sortBy="#{vendorObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeStatus}" sortBy="#{vendorObj.dataObj.payeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeFlowStatus}" sortBy="#{vendorObj.dataObj.payeeFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeBankName}" sortBy="#{vendorObj.dataObj.payeeBankName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.payeeBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeAccountNo}" sortBy="#{vendorObj.dataObj.payeeAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeAccountName}" sortBy="#{vendorObj.dataObj.payeeAccountName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.payeeAccountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bookbankPayeeStatus}" sortBy="#{vendorObj.dataObj.bookbankPayeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.bookbankPayeeFlowStatus}" sortBy="#{vendorObj.dataObj.bookbankPayeeFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.vendorContractList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendorListByContract"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllVendorListByContract" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbVendorListByContract"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
						
				</center>
			</rich:panel>
			
			<div style="clear:both; height:5px;"></div>
			
			<rich:panel styleClass="sem_autoScrollbar">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.change']}"/></f:facet>
				
				<center>
					
					<rich:dataTable id="dtbContractHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractHistoryList}" var="dataObj"
						reRender="dtbContractHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{dataObj.dataObj.paymentType}" sortBy="#{dataObj.dataObj.paymentType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.paymenttype']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkVendorCode" value="#{dataObj.dataObj.paymentType}" 
									action="#{navAction.navi}" reRender="oppContent,txtNavProgram" 
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="contractNoParam" value="#{dataObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{dataObj.dataObj.vendorId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.effectiveDt}" sortBy="#{dataObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{dataObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.expireDt}" sortBy="#{dataObj.dataObj.expireDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.expireDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.vendorCode}" sortBy="#{dataObj.dataObj.vendorCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.vendorName}" sortBy="#{dataObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{dataObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.group}" sortBy="#{dataObj.dataObj.group}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.group']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{dataObj.dataObj.group}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.whtType}" sortBy="#{dataObj.dataObj.whtType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.wht']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.whtType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.vatType}" sortBy="#{dataObj.dataObj.vatType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.vat']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.vatType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.bookbankNo}" sortBy="#{dataObj.dataObj.bookbankNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.AcctNo']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.bookbankNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.bookbankAcc}" sortBy="#{dataObj.dataObj.bookbankAcc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.AcctName']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{dataObj.dataObj.bookbankAcc}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.payeeId}" sortBy="#{dataObj.dataObj.payeeId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.payee.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{dataObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.payeeName}" sortBy="#{dataObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.payeeBookbankNo}" sortBy="#{dataObj.dataObj.payeeBookbankNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.payee.bookbank.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{dataObj.dataObj.payeeBookbankNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{dataObj.dataObj.payeeBookbankAcc}" sortBy="#{dataObj.dataObj.payeeBookbankAcc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.hist.payee.bookbank.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{dataObj.dataObj.payeeBookbankAcc}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.contractHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllContractHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbContractHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
				
				</center>
			</rich:panel>
			
			<div style="clear:both; height:5px;"></div>
			
			<rich:panel styleClass="sem_autoScrollbar">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}"/></f:facet>
				
				<center>
					
					<rich:dataTable id="dtbHistoryOfPaymentByContract" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractPayHistoryList}" var="vendorObj"
						reRender="dtbHistoryOfPaymentByContract" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{vendorObj.dataObj.contractPaymentDt}" sortBy="#{vendorObj.dataObj.contractPaymentDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymentdt']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="width:80px;">
									<a4j:commandLink id="hlkVendorCode" value="#{vendorObj.dataObj.contractPaymentDtStr}" 
									action="#{navAction.navi}" reRender="oppContent" 
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="contractNoParam" value="#{vendorObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.invoiceNo}" sortBy="#{vendorObj.dataObj.invoiceNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.invoiceNo']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.invoiceNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.period}" sortBy="#{vendorObj.dataObj.period}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.period']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.period}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.expenseType}" sortBy="#{vendorObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.expensetype']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorCode}" sortBy="#{vendorObj.dataObj.vendorCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.vendorcode']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.vendorName}" sortBy="#{vendorObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.vendorname']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeId}" sortBy="#{vendorObj.dataObj.payeeId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.payeeid']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.payeeName}" sortBy="#{vendorObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.payeename']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.paymentType}" sortBy="#{vendorObj.dataObj.paymentType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymenttype']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.paymentType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.periodType}" sortBy="#{vendorObj.dataObj.periodType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.periodtype']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.periodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.periodY}" sortBy="#{vendorObj.dataObj.periodY}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.periody']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.periodY}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.periodM}" sortBy="#{vendorObj.dataObj.periodM}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.periodm']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.periodM}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.periodD}" sortBy="#{vendorObj.dataObj.periodD}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.periodd']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.periodD}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.totalPaymentAmg}" sortBy="#{vendorObj.dataObj.totalPaymentAmg}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.totalpayamg']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.totalPaymentAmg}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{jspMsg['column.header.contract.pay.hist.vat']}" sortBy="#{jspMsg['column.header.contract.pay.hist.vat']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.vat']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vat}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.wht}" sortBy="#{vendorObj.dataObj.wht}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.wht']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.wht}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.docNoCancel}" sortBy="#{vendorObj.dataObj.docNoCancel}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.doccancel']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.docNoCancel}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{vendorObj.dataObj.docNo}" sortBy="#{vendorObj.dataObj.docNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.pay.hist.docno']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.vendorContractList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryOfPaymentByContract"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllHistoryOfPaymentByContract" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbHistoryOfPaymentByContract"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
					
				</center>
			</rich:panel>
			<!-- group[2] << -->
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>