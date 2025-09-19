
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<!-- =================================================================================== -->
<!-- =================================================================================== -->		
	<!-- >> [POPUP_01] -->
	<!-- mmm001PopUpHistory1 -->
	<rich:modalPanel id="mmm001PopUpHistory1" width="1150" height="600" >	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.history.contract.info']}"/>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpHistory1" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpHistory1" attachTo="hide-mmm001PopUpHistory1" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
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
		
		<h:panelGrid id="panelButtonHistory1">
			<a4j:form id="frmButtonHistory1">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
									      		
								    	<a4j:commandButton value="Close" styleClass="rich-button" immediate="true"
			                            reRender="txtNavProgram, oppContent, frmError">
			                             	<rich:componentControl for="mmm001PopUpHistory1" operation="hide" event="onclick" />
			                            </a4j:commandButton>
			                            <rich:spacer width="10"></rich:spacer>
							    	</td>
					        	</tr>
					    	</table>
		           		</td>
		           	</tr>
				</table>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid width="1100" id="popupHistory1_Display">
			<rich:panel style="width:1100px; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
				<a4j:form id="frmContractInfo">
					
					<!-- group[1] >> -->
					<rich:panel rendered="#{semmmm001Bean.visiblePnlContractInfo}">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}" style="text-align:left;"/></f:facet>
						
						<!-- contract info panel -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number']}" />
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractNo" value="#{semmmm001Bean.contractInfoHist.contractNo}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}"
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.region']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.address']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.code']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
				                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.expire.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.network.status']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
				                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.status']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
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
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.owner.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
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
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.list.of.vendor.by.contract']}" style="width:3000px;text-align:left;"/></f:facet>
						
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
											action="#{semmmm001Action.doVendorHistory}" reRender="oppContent,txtNavProgram" 
											oncomplete="#{rich:component('mmm001PopUpHistory2')}.show();onTopPage();">
													<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
													<a4j:actionparam name="contractNoParam" value="#{vendorObj.dataObj.contractNo}" />
													<a4j:actionparam name="historyPage" value="VD" />
													<a4j:actionparam name="backButtonFlag" value="Y"></a4j:actionparam>
													<a4j:actionparam name="popupName" value="mmm001PopUpHistory1"></a4j:actionparam>
													<rich:componentControl for="mmm001PopUpHistory1" operation="hide" event="onclick" />
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
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.change']}" style="width:1600px;text-align:left;"/></f:facet>
						
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
											<h:outputText  value="#{dataObj.dataObj.paymentType}" styleClass="contentform" />
										</div>
									</rich:column>
									
									<rich:column title="#{dataObj.dataObj.effectiveDt}" sortBy="#{dataObj.dataObj.effectiveDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:120px;">
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
											<h:outputText value="#{dataObj.dataObj.vendorCode}" styleClass="contentform" />
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
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}" style="width:1900px;text-align:left;"/></f:facet>
						
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
										
										<div align="center"  style="width:80px;">
											<h:outputText value="#{vendorObj.dataObj.contractPaymentDtStr}" styleClass="contentform"  />
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
		
		
	</rich:modalPanel>
	<!-- mmm001PopUpHistory1 -->
	<!-- << [POPUP_01] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_02] -->
	<!-- mmm001PopUpHistory2 -->
	<rich:modalPanel id="mmm001PopUpHistory2" width="1150" height="600">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.history.vendor.info']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpHistory2" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpHistory2" attachTo="hide-mmm001PopUpHistory2" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid id="panelButtonHistory2">
			<a4j:form id="frmButtonHistory2">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doContractHistory}" reRender="txtNavProgram, oppContent"
						           	 	rendered="#{semmmm001Bean.renderedBtnBack}"
						           	 	oncomplete="#{rich:component('mmm001PopUpHistory1')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoHist.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfoHist.contractNo}" />
											<a4j:actionparam name="historyPage" value="CT" />
											<rich:componentControl for="mmm001PopUpHistory2" operation="hide" event="onclick" />
						           		</a4j:commandButton>
									
										<rich:spacer width="10"></rich:spacer>
								           		
								    	<a4j:commandButton value="Close" styleClass="rich-button" immediate="true"
			                            reRender="mmm001PopUpHistory2,frmError">
			                             	<rich:componentControl for="mmm001PopUpHistory2" operation="hide" event="onclick" />
			                            </a4j:commandButton>
			                            <rich:spacer width="10"></rich:spacer>
							    	</td>
					        	</tr>
					    	</table>
		           		</td>
		           	</tr>
				</table>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid width="1100" id="popupHistory2_Display">
			<rich:panel style="width:1100px; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
				<a4j:form id="frmVendorInfo" >
					
					<!-- group[1] >> -->
					<rich:panel rendered="#{semmmm001Bean.visiblePnlContractInfo}">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}" style="text-align:left;"/></f:facet>
						
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
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}"
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.region']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.address']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.code']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
				                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.expire.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.network.status']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.status']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
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
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.owner.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
									</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					<!-- group[1] << -->
						
					<rich:spacer />
				
					<!-- group[2] >> -->
					<h:panelGrid id="vendorInfoHist" width="700px" style="border:solid 1px gray;">
						<rich:panel>
							<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}" style="text-align:left;"/></f:facet>
							
							<!-- vendor info panel -->
							<h:panelGrid width="1000px"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.expense.type']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistExpenseType" value="#{semmmm001Bean.vendorInfoHist.expenseType}" 
												readonly="true" styleClass="ms8blueReadOnly" disabled="#{semmmm001Bean.disableContent}" style="width:200px;">
				                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.company']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistCompany" value="#{semmmm001Bean.vendorInfoHist.company}" style="width:80px;"
												readonly="true" styleClass="ms8blueReadOnly" disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" >
				                					<f:selectItems value="#{semmmm001Bean.companyList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.vendor.type']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistVendorType" value="#{semmmm001Bean.vendorInfoHist.vendorType}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"
												readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.block.flag']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistVendorBlockStatus" value="#{semmmm001Bean.vendorInfoHist.vendorBlockStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:80px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.code']}"/>
											</td>
											<td colspan="3">
												<h:inputText id="vendorInfoHistVendorCode" value="#{semmmm001Bean.vendorInfoHist.vendorCode}" 
												disabled="#{semmmm001Bean.disableContent}" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="vendorInfoHistVendorName1" value="#{semmmm001Bean.vendorInfoHist.vendorName1}" 
				                				disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName2" value="#{semmmm001Bean.vendorInfoHist.vendorName2}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName3" value="#{semmmm001Bean.vendorInfoHist.vendorName3}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName4" value="#{semmmm001Bean.vendorInfoHist.vendorName4}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistIdCard" value="#{semmmm001Bean.vendorInfoHist.idCard}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
												size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistTaxId" value="#{semmmm001Bean.vendorInfoHist.taxId}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
												size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%;" class="">
												<h:outputText value=""/>
											</td>
											<td style="width:30%;">
												<h:outputText value="#{jspMsg['btn.check.vendor.info']}" style="color:red;" rendered="false"/>
												<a4j:commandButton id="btnChkVendor" value="..."  
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
												style="margin-left:5px;" rendered="false"
			           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapVedorInfoList')}.show(); return false;"
												action="#{semmmm001Action.doChkVendor}" reRender="oppContent"> 
												</a4j:commandButton>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.hq.branch']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistHqBranch" value="#{semmmm001Bean.vendorInfoHist.hqFlag}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
				                				</h:selectOneMenu>
				                				&nbsp;
				                				<h:outputText value="#{jspMsg['label.branch.code']}" />
				                				<h:inputText id="vendorInfoHistBranchNo" value="#{semmmm001Bean.vendorInfoHist.branchNo}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"  
												maxlength="20" style="width:50px;"  />
											</td>
										</tr>
										<tr>
											<td colspan="3" style="text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistVendorStatus" value="#{semmmm001Bean.vendorInfoHist.vendorStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" disabled="#{semmmm001Bean.disableContent}" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
						
						<div style="clear:both; height:5px;"></div>
						
						<rich:panel style="width:1055px; overflow:auto; text-align:left;" styleClass="sem_autoScrollbar">
							<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.vendor']}" style="text-align:left;"/></f:facet>
							
							<div id="tabVendorHistoryChange" style="border:1px solid e0e0e0;"> 
								<rich:dataTable id="dtbHistoryList" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.historyResultList}" var="historyObj"
								reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center"  style="width:50px;">
											<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:100px;">
											<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:400px;">
											<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:400px;">
											<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:100px;">
											<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="2">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryList" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
								</rich:dataTable>
							</div>
							
						</rich:panel>
					</h:panelGrid>
					<!-- group[2] << -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- group[3] >> -->
					<rich:panel style="width:1100px; overflow:auto; " styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.bank.info']}" style="text-align:left;"/></f:facet>
						
									<rich:dataTable id="dtbBookbankList" width="100%" 
									cellpadding="0" cellspacing="0" border="0" 
									value="#{semmmm001Bean.bookbankHistList}" var="bookbankObj"
									reRender="dtbBookbankList" rows="#{semmmm001Bean.rowPerPage}"
									rowClasses="cur" styleClass="contentform" rowKeyVar="row">
										
										<rich:column title="#{bookbankObj.dataObj.accountName}" sortBy="#{bookbankObj.dataObj.accountName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:150px;">
												<h:outputText value="#{bookbankObj.dataObj.accountName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.accountNo}" sortBy="#{bookbankObj.dataObj.accountNo}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<a4j:commandLink id="hlkBookbankAccountNo" value="#{bookbankObj.dataObj.accountNo}" 
												action="#{semmmm001Action.doBookbankHistory}" reRender="oppContent,txtNavProgram" 
												oncomplete="#{rich:component('mmm001PopUpHistory3')}.show();onTopPage();">
														<a4j:actionparam name="contractNoParam" value="#{bookbankObj.dataObj.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{bookbankObj.dataObj.vendorId}" />
														<a4j:actionparam name="bookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
														<a4j:actionparam name="historyPage" value="VB" />
														<a4j:actionparam name="backButtonFlag" value="Y"></a4j:actionparam>
														<a4j:actionparam name="popupName" value="mmm001PopUpHistory2"></a4j:actionparam>
														<rich:componentControl for="mmm001PopUpHistory2" operation="hide" event="onclick" />
												</a4j:commandLink>
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.accountType}" sortBy="#{bookbankObj.dataObj.accountType}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.accountType}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.bankCode}" sortBy="#{bookbankObj.dataObj.bankCode}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.bankCode}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.bankName}" sortBy="#{bookbankObj.dataObj.bankName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:150px;">
												<h:outputText value="#{bookbankObj.dataObj.bankName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.bankBranch}" sortBy="#{bookbankObj.dataObj.bankBranch}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:120px;">
												<h:outputText value="#{bookbankObj.dataObj.bankBranch}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.province}" sortBy="#{bookbankObj.dataObj.province}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:100px;">
												<h:outputText value="#{bookbankObj.dataObj.province}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.remark}" sortBy="#{bookbankObj.dataObj.remark}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:150px;">
												<h:outputText value="#{bookbankObj.dataObj.remark}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.bookbankStatus}" sortBy="#{bookbankObj.dataObj.bookbankStatus}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.bookbankStatus}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column title="#{bookbankObj.dataObj.activeStatus}" sortBy="#{bookbankObj.dataObj.activeStatus}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.activeStatus}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<!-- footer -->
										<f:facet name="footer">
											<rich:columnGroup>
												<!-- > 1 -->
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmmm001Bean.bookbankList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<!-- > 2 -->
												<rich:column colspan="6">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBookbankList"
														maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dataScrllBookbankList" style="background-color: #cccccc;"
														page="#{semmmm001Bean.scrollerPage}">
													<a4j:support event="onclick" reRender="dtbBookbankList"></a4j:support>
													</rich:datascroller>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
										<!-- footer -->
										
									</rich:dataTable>
						
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto; " styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.list.of.payee.and.bookbankpayee']}" style="text-align:left;"/></f:facet>
						
						
						
							<rich:dataTable id="dtbPayeeList" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.payeeHistList}" var="payeeObj"
								reRender="dtbPayeeList" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{payeeObj.dataObj.payeeId}" sortBy="#{payeeObj.dataObj.payeeId}">
										<f:facet name="header">
											<h:outputText value="Payee Code" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<a4j:commandLink id="hlkPayeeId" value="#{payeeObj.dataObj.payeeId}" 
												action="#{semmmm001Action.doPayeeHistory}" reRender="oppContent,txtNavProgram" 
												oncomplete="#{rich:component('mmm001PopUpHistory4')}.show();onTopPage();">
													<a4j:actionparam name="vendorIdParam" value="#{payeeObj.dataObj.vendorId}" />
													<a4j:actionparam name="contractNoParam" value="#{payeeObj.dataObj.contractNo}" />
													<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
													<a4j:actionparam name="historyPage" value="PY" />
													<a4j:actionparam name="backButtonFlag" value="Y"></a4j:actionparam>
													<a4j:actionparam name="popupName" value="mmm001PopUpHistory3"></a4j:actionparam>
													<rich:componentControl for="mmm001PopUpHistory2" operation="hide" event="onclick" />
											</a4j:commandLink>
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.payeeName}" sortBy="#{payeeObj.dataObj.payeeName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="left" style="width:120px;">
											<h:outputText value="#{payeeObj.dataObj.payeeName}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.payeeStatus}" sortBy="#{payeeObj.dataObj.payeeStatus}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{payeeObj.dataObj.payeeStatus}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.bankName}" sortBy="#{payeeObj.dataObj.bankName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="left" style="width:120px;">
											<h:outputText value="#{payeeObj.dataObj.bankName}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.accountNo}" sortBy="#{payeeObj.dataObj.accountNo}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<a4j:commandLink id="hlkPayeeAccountNo" value="#{payeeObj.dataObj.accountNo}" 
												action="#{semmmm001Action.doBookbankPayeeHistory}" reRender="oppContent,txtNavProgram" 
												oncomplete="#{rich:component('mmm001PopUpHistory5')}.show();onTopPage();">
													<a4j:actionparam name="vendorIdParam" value="#{payeeObj.dataObj.vendorId}" />
													<a4j:actionparam name="contractNoParam" value="#{payeeObj.dataObj.contractNo}" />
													<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
													<a4j:actionparam name="bookbankPayeeIdParam" value="#{payeeObj.dataObj.bookbankPayeeId}" />
													<a4j:actionparam name="historyPage" value="PB" />
													<a4j:actionparam name="backButtonFlag" value="Y"></a4j:actionparam>
													<a4j:actionparam name="popupName" value="mmm001PopUpHistory4"></a4j:actionparam>
													<rich:componentControl for="mmm001PopUpHistory2" operation="hide" event="onclick" />
											</a4j:commandLink>
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.accountName}" sortBy="#{payeeObj.dataObj.accountName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="left" style="width:120px;">
											<h:outputText value="#{payeeObj.dataObj.accountName}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.bookbankPayeeStatus}" sortBy="#{payeeObj.dataObj.bookbankPayeeStatus}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{payeeObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{payeeObj.dataObj.expenseType}" sortBy="#{payeeObj.dataObj.expenseType}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{payeeObj.dataObj.expenseType}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmmm001Bean.payeeList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="4">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPayeeList"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllPayeeList" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbPayeeList"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
						
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}" style="width:1900px;text-align:left;"/></f:facet>
						
						<center>
							
							<rich:dataTable id="dtbHistoryOfVendorPaymentByContract" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.contractPayHistoryList}" var="vendorObj"
								reRender="dtbHistoryOfVendorPaymentByContract" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{vendorObj.dataObj.contractPaymentDt}" sortBy="#{vendorObj.dataObj.contractPaymentDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymentdt']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{vendorObj.dataObj.contractPaymentDtStr}" styleClass="contentform"  />
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
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryOfVendorPaymentByContract"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryOfVendorPaymentByContract" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryOfVendorPaymentByContract"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
							
						</center>
					</rich:panel>
					<!-- group[3] << -->
				</a4j:form>
			</rich:panel>
		</h:panelGrid>	
		
	</rich:modalPanel>
	<!-- mmm001PopUpHistory2 -->
	<!-- << [POPUP_02] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	<!-- mmm001PopUpHistory3 -->
	<rich:modalPanel id="mmm001PopUpHistory3" width="1150" height="600">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.history.bookbank.info']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpHistory3" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpHistory3" attachTo="hide-mmm001PopUpHistory3" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid id="panelButtonHistory3">
			<a4j:form id="frmButtonHistory3">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doVendorHistory}" reRender="txtNavProgram, oppContent"
						           	 	rendered="#{semmmm001Bean.renderedBtnBack}"
						           	 	oncomplete="#{rich:component('mmm001PopUpHistory2')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoHist.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfoHist.contractNo}" />
											<a4j:actionparam name="historyPage" value="VD" />
											<a4j:actionparam name="backButtonFlag" value="#{semmmm001Bean.backButtonFlag}" />
											<rich:componentControl for="mmm001PopUpHistory3" operation="hide" event="onclick" />
						           		</a4j:commandButton>
									
										<rich:spacer width="10"></rich:spacer>
								           		
								    	<a4j:commandButton value="Close" styleClass="rich-button" immediate="true"
			                            reRender="mmm001PopUpHistory3,frmError">
			                             	<rich:componentControl for="mmm001PopUpHistory3" operation="hide" event="onclick" />
			                            </a4j:commandButton>
			                            <rich:spacer width="10"></rich:spacer>
							    	</td>
					        	</tr>
					    	</table>
		           		</td>
		           	</tr>
				</table>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid width="1100" id="popupHistory3_Display">
			<rich:panel style="width:1100px; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
				<a4j:form id="frmVendorBookbankInfo">
					<!-- group[1] >> -->
					<rich:panel rendered="#{semmmm001Bean.visiblePnlContractInfo}">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}" style="text-align:left;"/></f:facet>
						
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
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}"
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.region']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.address']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.code']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
				                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.expire.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.network.status']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.status']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
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
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.owner.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
									</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					<!-- group[1] << -->
						
					<div style="clear:both; height:10px;"></div>
				
					<!-- group[2] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
						
						<!-- vendor info panel -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.expense.type']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistExpenseType" value="#{semmmm001Bean.vendorInfoHist.expenseType}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
				                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.company']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistCompany" value="#{semmmm001Bean.vendorInfoHist.company}" 
												style="width:100px;"
												readonly="true" styleClass="ms8blueReadOnly" >
				                					<f:selectItems value="#{semmmm001Bean.companyList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.vendor.type']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistVendorType" value="#{semmmm001Bean.vendorInfoHist.vendorType}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.block.flag']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistBlockFlag" value="#{semmmm001Bean.vendorInfoHist.vendorBlockStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:100px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.code']}"/>
											</td>
											<td colspan="3">
				                				<h:inputText id="vendorInfoHistVendorCode" value="#{semmmm001Bean.vendorInfoHist.vendorCode}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="50" size="30" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName1" value="#{semmmm001Bean.vendorInfoHist.vendorName1}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName2" value="#{semmmm001Bean.vendorInfoHist.vendorName2}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName3" value="#{semmmm001Bean.vendorInfoHist.vendorName3}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistVendorName4" value="#{semmmm001Bean.vendorInfoHist.vendorName4}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistIdCard" value="#{semmmm001Bean.vendorInfoHist.idCard}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="vendorInfoHistTaxId" value="#{semmmm001Bean.vendorInfoHist.taxId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13" />
											</td>
										</tr>
										<tr>
											<td colspan="3" style="text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.hq.branch']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistHqBranch" value="#{semmmm001Bean.vendorInfoHist.hqFlag}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
				                				</h:selectOneMenu>
				                				&nbsp;
				                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
				                				<h:inputText id="vendorInfoHistBranchNo" value="#{semmmm001Bean.vendorInfoHist.branchNo}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="20" style="width:50px;"  />
											</td>
										</tr>
										<tr>
											<td colspan="3" style="text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="vendorInfoHistVendorStatus" value="#{semmmm001Bean.vendorInfoHist.vendorStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
									</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<!-- group[2] << -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- group[3] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.bank.info']}" style="text-align:left;"/></f:facet>
						
						<center>
						
							
							<table width="95%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.type']}"/>
											</td>
											<td colspan="3">
												<h:selectOneMenu id="bankInfoAccountType" value="#{semmmm001Bean.bookbankInfoHist.accountType}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:100px;">
				                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bank.code']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="bankInfoBankCode" value="#{semmmm001Bean.bookbankInfoHist.bankCode}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
												style="width:96px;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bank']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="bankInfoBankName" value="#{semmmm001Bean.bookbankInfoHist.bankCode}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.bankList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bank.branch']}"/>
											</td>
											<td style="width:30%;">
												<h:inputTextarea id="bankInfoBankBranch" value="#{semmmm001Bean.bookbankInfoHist.bankBranch}" 
												style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_province']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="bankInfoProvince" value="#{semmmm001Bean.bookbankInfoHist.province}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;;">
				                					<f:selectItems value="#{semmmm001Bean.provinceList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.account.number']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="bankInfoAccountNo" value="#{semmmm001Bean.bookbankInfoHist.accountNo}" 
												disabled="#{semmmm001Bean.disableContent}" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="bankInfoAccountName" value="#{semmmm001Bean.bookbankInfoHist.accountName}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.remark']}"/>
											</td>
											<td style="width:30%;">
												<h:inputTextarea id="bankInfoRemark" value="#{semmmm001Bean.bookbankInfoHist.remark}" 
												style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="Active Status"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="bankInfoActiveStatus" value="#{semmmm001Bean.bookbankInfoHist.activeStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="">
				                					<f:selectItem itemLabel="-- Select --" itemValue=""/>
				                					<f:selectItem itemLabel="Yes" itemValue="Y"/>
				                					<f:selectItem itemLabel="No" itemValue="N"/>
				                				</h:selectOneMenu>
											</td>
										</tr>
									</table>
							
						
						</center>
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.info']}" style="text-align:left;"/></f:facet>
						
							<rich:dataTable id="dtbHistoryList"
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.historyResultList}" var="historyObj"
							reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
								<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:400px;">
										<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:400px;">
										<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="3">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllHistoryList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
						
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}" style="width:1900px;text-align:left;"/></f:facet>
						
						<center>
							
							<rich:dataTable id="dtbHistoryOfBookbankPaymentByContract" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.contractPayHistoryList}" var="vendorObj"
								reRender="dtbHistoryOfBookbankPaymentByContract" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{vendorObj.dataObj.contractPaymentDt}" sortBy="#{vendorObj.dataObj.contractPaymentDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymentdt']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{vendorObj.dataObj.contractPaymentDtStr}" styleClass="contentform"  />
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
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryOfBookbankPaymentByContract"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryOfBookbankPaymentByContract" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryOfBookbankPaymentByContract"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
							
						</center>
					</rich:panel>
					<!-- group[3] << -->
				</a4j:form>
			</rich:panel>
		</h:panelGrid>	
	</rich:modalPanel>
	<!-- mmm001PopUpHistory3 -->
	<!-- << [POPUP_03] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_04] -->
	<!-- mmm001PopUpHistory4 -->
	<rich:modalPanel id="mmm001PopUpHistory4" width="1150" height="600">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.history.payee.info']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpHistory4" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpHistory4" attachTo="hide-mmm001PopUpHistory4" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid id="panelButtonHistory4">
			<a4j:form id="frmButtonHistory4">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doVendorHistory}" reRender="txtNavProgram, oppContent"
						           	 	rendered="#{semmmm001Bean.renderedBtnBack}"
						           	 	oncomplete="#{rich:component('mmm001PopUpHistory2')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoHist.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfoHist.contractNo}" />
											<a4j:actionparam name="historyPage" value="VD" />
											<a4j:actionparam name="backButtonFlag" value="#{semmmm001Bean.backButtonFlag}" />
											<rich:componentControl for="mmm001PopUpHistory4" operation="hide" event="onclick" />
						           		</a4j:commandButton>
									
										<rich:spacer width="10"></rich:spacer>
								           		
								    	<a4j:commandButton value="Close" styleClass="rich-button" immediate="true"
			                            reRender="mmm001PopUpHistory4,frmError">
			                             	<rich:componentControl for="mmm001PopUpHistory4" operation="hide" event="onclick" />
			                            </a4j:commandButton>
			                            <rich:spacer width="10"></rich:spacer>
							    	</td>
					        	</tr>
					    	</table>
		           		</td>
		           	</tr>
				</table>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid width="1100" id="popupHistory4_Display">
			<rich:panel style="width:1100px; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
				<a4j:form id="frmPayeeInfo">
					<h:panelGroup id="pnlButton">
						<table width="100%">
							<tr>
								<td width="50%" align="left">
							
								</td>
								<td width="50%" align="right" valign="bottom">
									<table id="tblButton">
										<tr>
											<td>
								           		
												<rich:spacer width="5"/>
												
							           		</td>
					           			</tr>
					           		</table>
		           				</td>
		           			</tr>
						</table>
					</h:panelGroup>
					<!-- group[1] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}" style="text-align:left;"/></f:facet>
						
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
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.region']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.address']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" style=" height : 21px;"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.effective.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.code']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
				                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.expire.date']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.network.status']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.status']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
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
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.owner.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}"/>
											</td>
											<td style="width:30%;">
				                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
				                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
									</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					<!-- group[1] << -->
						
					<div style="clear:both; height:10px;"></div>
				
					<!-- group[2] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
						
						<!-- vendor info panel -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.expense.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistExpenseType" value="#{semmmm001Bean.vendorInfoHist.expenseType}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
			                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
			                				</h:selectOneMenu>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.company']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistCompany" value="#{semmmm001Bean.vendorInfoHist.company}" 
											style="width:100px;"
											readonly="true" styleClass="ms8blueReadOnly" >
			                					<f:selectItems value="#{semmmm001Bean.companyList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistVendorType" value="#{semmmm001Bean.vendorInfoHist.vendorType}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
			                				</h:selectOneMenu>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.block.flag']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistBlockFlag" value="#{semmmm001Bean.vendorInfoHist.vendorBlockStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:100px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.code']}"/>
										</td>
										<td colspan="3">
			                				<h:inputText id="vendorInfoHistVendorCode" value="#{semmmm001Bean.vendorInfoHist.vendorCode}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="50" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName1" value="#{semmmm001Bean.vendorInfoHist.vendorName1}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName2" value="#{semmmm001Bean.vendorInfoHist.vendorName2}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName3" value="#{semmmm001Bean.vendorInfoHist.vendorName3}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName4" value="#{semmmm001Bean.vendorInfoHist.vendorName4}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistIdCard" value="#{semmmm001Bean.vendorInfoHist.idCard}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistTaxId" value="#{semmmm001Bean.vendorInfoHist.taxId}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13"/>
										</td>
									</tr>
									<tr>
										<td colspan="3" style="text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.hq.branch']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistHqBranch" value="#{semmmm001Bean.vendorInfoHist.hqFlag}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
			                				</h:selectOneMenu>
			                				&nbsp;
			                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
			                				<h:inputText id="vendorInfoHistBranchNo" value="#{semmmm001Bean.vendorInfoHist.branchNo}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="20" style="width:50px;"  />
										</td>
									</tr>
									<tr>
										<td colspan="3" style="text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.status']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistVendorStatus" value="#{semmmm001Bean.vendorInfoHist.vendorStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<!-- group[2] << -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- group[3] >> -->
					<h:panelGrid id="payeeInfoHist" width="95%" style="border:solid 1px gray;">
						<rich:panel>
							<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}"/></f:facet>
							
							<!-- payee info -->
							<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.payee.name']}"/>
											</td>
											<td colspan="3">
												<h:inputText id="payeeInfoHistPayeeName" value="#{semmmm001Bean.payeeInfoHist.payeeName}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistIdCard" value="#{semmmm001Bean.payeeInfoHist.idCard}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistTaxId" value="#{semmmm001Bean.payeeInfoHist.taxId}" 
												readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.address1']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistAddress1" value="#{semmmm001Bean.payeeInfoHist.payeeAddress1}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="13" style="width:70%;"  />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.address2']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistAddress2" value="#{semmmm001Bean.payeeInfoHist.payeeAddress2}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="13" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_tambol']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="payeeInfoHistTambol" value="#{semmmm001Bean.payeeInfoHist.tambol}" 
												readonly="true" styleClass="ms8blueReadOnly"  style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.tambolList}"/>
												</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_amphur']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="payeeInfoHistAmphur" value="#{semmmm001Bean.payeeInfoHist.amphur}" 
												readonly="true" styleClass="ms8blueReadOnly"  style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.amphurList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.th_province']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="payeeInfoHistProvince" value="#{semmmm001Bean.payeeInfoHist.province}" 
												readonly="true" styleClass="ms8blueReadOnly"  style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.provinceList}"/>
												</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_post.code']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistPostCode" value="#{semmmm001Bean.payeeInfoHist.postCode}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="5" style="width:120px;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistContractName" value="#{semmmm001Bean.payeeInfoHist.contactName}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="" style="width:70%;"  />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistTelephone" value="#{semmmm001Bean.payeeInfoHist.telephone}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.mobile']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistMobile" value="#{semmmm001Bean.payeeInfoHist.mobileNo}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="" style="width:70%; height : 21px;"  />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.fax']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistFax" value="#{semmmm001Bean.payeeInfoHist.fax}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td colspan="3" style="text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.email']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="payeeInfoHistEmail" value="#{semmmm001Bean.payeeInfoHist.email}" 
												readonly="true" styleClass="ms8blueReadOnly" maxlength="" style="width:70%;"  />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.remark']}"/>
											</td>
											<td style="width:30%;">
												<h:inputTextarea id="payeeInfoHistRemark" value="#{semmmm001Bean.payeeInfoHist.remark}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:26%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="payeeInfoHistPayeeStatus" value="#{semmmm001Bean.payeeInfoHist.payeeStatus}" 
												readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.payeeStatusList}" />
				                				</h:selectOneMenu>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
						<!-- payee info panel << -->
						
						<div style="clear:both; height:5px;"></div>
						
						<rich:panel>
							<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payee']}" style="text-align:left;"/></f:facet>
							
							<div id="tabPayeeHistoryChange" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
								<rich:dataTable id="dtbHistoryList" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.historyResultList}" var="historyObj"
								reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:100px;">
											<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:100px;">
											<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:400px;">
											<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:400px;">
											<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center" style="width:100px;">
											<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="2">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryList" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
								</rich:dataTable>
							</div>
							</center>
						</rich:panel>
					</h:panelGrid>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}" style="width:1900px;text-align:left;"/></f:facet>
						
						<center>
							
							<rich:dataTable id="dtbHistoryOfPayeePaymentByContract" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.contractPayHistoryList}" var="vendorObj"
								reRender="dtbHistoryOfPayeePaymentByContract" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{vendorObj.dataObj.contractPaymentDt}" sortBy="#{vendorObj.dataObj.contractPaymentDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymentdt']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{vendorObj.dataObj.contractPaymentDtStr}" styleClass="contentform"  />
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
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryOfPayeePaymentByContract"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryOfPayeePaymentByContract" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryOfPayeePaymentByContract"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
							
						</center>
					</rich:panel>
					<!-- group[3] << -->
				</a4j:form>
			</rich:panel>
		</h:panelGrid>
	</rich:modalPanel>
	<!-- mmm001PopUpHistory4 -->
	<!-- << [POPUP_04] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->		

	<!-- >> [POPUP_05] -->
	<!-- mmm001PopUpHistory5 -->
	<rich:modalPanel id="mmm001PopUpHistory5" width="1150" height="600">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.history.bookbank.payee.info']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpHistory5" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpHistory5" attachTo="hide-mmm001PopUpHistory5" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid id="panelButtonHistory5">
			<a4j:form id="frmButtonHistory5">
				<table width="100%">
					<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doVendorHistory}" reRender="txtNavProgram, oppContent"
						           	 	rendered="#{semmmm001Bean.renderedBtnBack}"
						           	 	oncomplete="#{rich:component('mmm001PopUpHistory2')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoHist.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfoHist.contractNo}" />
											<a4j:actionparam name="historyPage" value="VD" />
											<a4j:actionparam name="backButtonFlag" value="#{semmmm001Bean.backButtonFlag}" />
											<rich:componentControl for="mmm001PopUpHistory5" operation="hide" event="onclick" />
						           		</a4j:commandButton>
									
										<rich:spacer width="10"></rich:spacer>
								           		
								    	<a4j:commandButton value="Close" styleClass="rich-button" immediate="true"
			                            reRender="mmm001PopUpHistory5,frmError">
			                             	<rich:componentControl for="mmm001PopUpHistory5" operation="hide" event="onclick" />
			                            </a4j:commandButton>
			                            <rich:spacer width="10"></rich:spacer>
							    	</td>
					        	</tr>
					    	</table>
		           		</td>
		           	</tr>
				</table>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid width="1100" id="popupHistory5_Display">
			<rich:panel style="width:1100px; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
				<a4j:form id="frmPayeeBookbankInfo">
					
					<!-- group[1] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}" style="text-align:left;"/></f:facet>
						
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
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistContractOldNo" value="#{semmmm001Bean.contractInfoHist.contractOldNo}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.region']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="region" value="#{semmmm001Bean.contractInfoHist.region}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.site.name']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistSiteName" value="#{semmmm001Bean.contractInfoHist.siteName}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.site.address']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistSiteLoaction" value="#{semmmm001Bean.contractInfoHist.siteLocation}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.firstEffectiveDtStr}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.location.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistLocationId" value="#{semmmm001Bean.contractInfoHist.locationId}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.effective.date']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistEffectiveDtStr" value="#{semmmm001Bean.contractInfoHist.effectiveDtStr}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.location.code']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoHistLocationCode" value="#{semmmm001Bean.contractInfoHist.locationCode}" 
			                				readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.expire.date']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistExpireDtStr" value="#{semmmm001Bean.contractInfoHist.expireDtStr}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.network.status']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoHistNetworkStatus" value="#{semmmm001Bean.contractInfoHist.networkStatus}" 
			                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.status']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistContractStatus" value="#{semmmm001Bean.contractInfoHist.contractStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
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
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.owner.name']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoHistOwnerName" value="#{semmmm001Bean.contractInfoHist.ownerName}" 
			                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.name']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistContractName" value="#{semmmm001Bean.contractInfoHist.contractName}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contact.name']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoHistContactName" value="#{semmmm001Bean.contractInfoHist.contactName}" 
			                				readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.telephone']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoHistTelephone" value="#{semmmm001Bean.contractInfoHist.telephone}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					<!-- group[1] << -->
						
					<div style="clear:both; height:5px;"></div>
				
					<!-- group[2] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}" style="text-align:left;"/></f:facet>
						
						<!-- vendor info panel -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.expense.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistExpenseType" value="#{semmmm001Bean.vendorInfoHist.expenseType}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:100px;">
			                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
			                				</h:selectOneMenu>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.company']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistCompany" value="#{semmmm001Bean.vendorInfoHist.company}" style="width:100px;"
											readonly="true" styleClass="ms8blueReadOnly" >
			                					<f:selectItems value="#{semmmm001Bean.companyList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistVendorType" value="#{semmmm001Bean.vendorInfoHist.vendorType}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:200px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
			                				</h:selectOneMenu>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.block.flag']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistBlockFlag" value="#{semmmm001Bean.vendorInfoHist.vendorBlockStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:100px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.code']}"/>
										</td>
										<td colspan="3">
			                				<h:inputText id="vendorInfoHistVendorCode" value="#{semmmm001Bean.vendorInfoHist.vendorCode}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName1" value="#{semmmm001Bean.vendorInfoHist.vendorName1}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName2" value="#{semmmm001Bean.vendorInfoHist.vendorName2}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName3" value="#{semmmm001Bean.vendorInfoHist.vendorName3}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistVendorName4" value="#{semmmm001Bean.vendorInfoHist.vendorName4}" 
											readonly="true" styleClass="ms8blueReadOnly" maxlength="200" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistIdCard" value="#{semmmm001Bean.vendorInfoHist.idCard}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoHistTaxId" value="#{semmmm001Bean.vendorInfoHist.taxId}" 
											readonly="true" styleClass="ms8blueReadOnly" size="30" maxlength="13"/>
										</td>
									</tr>
									<tr>
										<td colspan="3" style="text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.hq.branch']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistHqBranch" value="#{semmmm001Bean.vendorInfoHist.hqFlag}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
			                				</h:selectOneMenu>
			                				&nbsp;
			                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
			                				<h:inputText id="vendorInfoHistBranchNo" value="#{semmmm001Bean.vendorInfoHist.branchNo}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:50px;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Withhold :"/>
										</td>
										<td style="width:30%;">
			                				<a4j:region>
												<h:selectOneMenu id="vendorInfoHistWhtId" value="#{semmmm001Bean.vendorInfoHist.whtId}" 
												readonly="true" styleClass="ms8blueReadOnly" 
												onchange="vendorInfoHist_GetWithholdJS();"  style="width:100px;">
													<f:selectItems value="#{semmmm001Bean.withholdList}" />
												</h:selectOneMenu>
												
												<a4j:jsFunction name="vendorInfoHist_GetWithholdJS" 
												reRender="vendorInfoHistWhtType, vendorInfoHistWhtCode" 
												action="#{semmmm001Action.doGetWithhold}">
												</a4j:jsFunction>
											</a4j:region>
			                				&nbsp;
			                				<h:outputText value="W/H Type : " styleClass="ms7" />
			                				<h:inputText id="vendorInfoHistWhtType" value="#{semmmm001Bean.vendorInfoHist.whtType}" 
											readonly="true" styleClass="ms8blueReadOnly"  
											maxlength="20" style="width:30px; text-align:center;"  />
											&nbsp;
			                				<h:outputText value="W/H Code : " styleClass="ms7" />
			                				<h:inputText id="vendorInfoHistWhtCode" value="#{semmmm001Bean.vendorInfoHist.whtCode}" 
											readonly="true" styleClass="ms8blueReadOnly"  
											maxlength="20" style="width:30px; text-align:center;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.status']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHistVendorStatus" value="#{semmmm001Bean.vendorInfoHist.vendorStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value=""/>
										</td>
										<td colspan="3">
											<h:selectBooleanCheckbox id="chkVAT" 
											value="#{semmmm001Bean.vendorInfoHist.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
											readonly="true" styleClass="ms8blueReadOnly" />
					                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<!-- group[2] << -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- group[3] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}" style="text-align:left;"/></f:facet>
						
						<!-- payee info -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Payee Code : "/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInPayeeCode" value="#{semmmm001Bean.payeeInfoHist.payeeCode}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											size="30" maxlength="30"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Payee Type : "/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeInfoHistPayeeType" value="#{semmmm001Bean.payeeInfoHist.payeeType}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.payee.name']}"/>
										</td>
										<td colspan="3">
											<h:inputText id="payeeInfoHistPayeeName" value="#{semmmm001Bean.payeeInfoHist.payeeName}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistIdCard" value="#{semmmm001Bean.payeeInfoHist.idCard}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											size="30" maxlength="13" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistTaxId" value="#{semmmm001Bean.payeeInfoHist.taxId}" 
											readonly="true" styleClass="ms8blueReadOnly"  
											size="30" maxlength="13" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.address1']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistAddress1" value="#{semmmm001Bean.payeeInfoHist.payeeAddress1}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.address2']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistAddress2" value="#{semmmm001Bean.payeeInfoHist.payeeAddress2}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.th_tambol']}"/>
										</td>
										<td style="width:30%;">
											<a4j:region>
												<h:selectOneMenu id="payeeInfoHistTambol" value="#{semmmm001Bean.payeeInfoHist.tambol}" 
												readonly="true" styleClass="ms8blueReadOnly" 
												 style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.tambolList}"/>
												</h:selectOneMenu>
											</a4j:region>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.th_amphur']}"/>
										</td>
										<td style="width:30%;">
											<a4j:region>
												<h:selectOneMenu id="payeeInfoHistAmphur" value="#{semmmm001Bean.payeeInfoHist.amphur}" 
												readonly="true" styleClass="ms8blueReadOnly" 
												onchange="payeeInfoHist_GetTambolListJS();"  style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.amphurList}"/>
												</h:selectOneMenu>
												
												<a4j:jsFunction name="payeeInfoHist_GetTambolListJS" reRender="payeeInfoHistTambol" 
												action="#{semmmm001Action.doSetPayeeLocation}">
												</a4j:jsFunction>
											</a4j:region>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.th_province']}"/>
										</td>
										<td style="width:30%;">
			                				<a4j:region>
												<h:selectOneMenu id="payeeInfoHistProvince" value="#{semmmm001Bean.payeeInfoHist.province}" 
												readonly="true" styleClass="ms8blueReadOnly" 
												onchange="payeeInfoHist_GetAmphurListJS();"  style="width:120px;">
													<f:selectItems value="#{semmmm001Bean.payeeInfoHist.provinceList}"/>
												</h:selectOneMenu>
												
												<a4j:jsFunction name="payeeInfoHist_GetAmphurListJS" reRender="payeeInfoHistAmphur, payeeInfoHistTambol" 
												action="#{semmmm001Action.doSetPayeeLocation}">
												</a4j:jsFunction>
											</a4j:region>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.th_post.code']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistPostCode" value="#{semmmm001Bean.payeeInfoHist.postCode}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="5" style="width:120px;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contact.name']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistContractName" value="#{semmmm001Bean.payeeInfoHist.contactName}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.telephone']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistTelephone" value="#{semmmm001Bean.payeeInfoHist.telephone}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.mobile']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistMobile" value="#{semmmm001Bean.payeeInfoHist.mobileNo}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%; height : 21px;"  />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.fax']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistFax" value="#{semmmm001Bean.payeeInfoHist.fax}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td colspan="3" style="text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.email']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoHistEmail" value="#{semmmm001Bean.payeeInfoHist.email}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											maxlength="13" style="width:70%;"  />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.remark']}"/>
										</td>
										<td style="width:30%;">
											<h:inputTextarea id="payeeInfoHistRemark" value="#{semmmm001Bean.payeeInfoHist.remark}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.payee.status']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeInfoHistPayeeStatus" value="#{semmmm001Bean.payeeInfoHist.payeeStatus}" 
											readonly="true" styleClass="ms8blueReadOnly" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.payeeStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<!-- group[3] << -->
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.expense.bookbankpayee']}" style="text-align:left;"/></f:facet>
						
						<!-- bookbank payee info panel -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.contract.number']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistContractNo" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.contractNo}" 
											size="30" maxlength="30" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.expense.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="bookbankPayeeInfoHistExpenseType" value="#{semmmm001Bean.bookbankPayeeInfoHist.expenseType}" 
											readonly="true" styleClass="ms8blueReadOnly" 
											style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.bookbank.effective.date']}"/>
										</td>
										<td colspan="3">
											<h:inputText id="bookbankPayeeInfoHistBookbankEffectiveDtStr" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.effectiveDtStr}" 
											size="30" maxlength="30" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.effective.date']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistFirstEffectiveDtStr" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.firstEffectiveDtStr}" 
											size="30" maxlength="30"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.expire.date']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistExpireDtStr" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.expireDtStr}" 
											size="30" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.pay.type']}"/>
										</td>
										<td colspan="3" class="ms7" >
											<h:selectOneRadio id="bookbankPayeeInfoHistPayType" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.payType}">
												<f:selectItem itemLabel="#{jspMsg['desc.pay.type.check']}" itemValue="01"/>
												<f:selectItem itemLabel="#{jspMsg['desc.pay.type.transfer']}" itemValue="02"/>
											</h:selectOneRadio>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.account.type']}"/>
										</td>
										<td colspan="3">
											<h:selectOneMenu id="bookbankPayeeInfoHistAccountType" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.accountType}" style="width:100px;">
			                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.bank.code']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistBankCode" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.bankCode}" 
											size="30" maxlength="30" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.bank']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistBank" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.bankName}" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.bank.branch']}"/>
										</td>
										<td style="width:30%;">
											<h:inputTextarea id="bookbankPayeeInfoHistBankBranch" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.bankBranch}" 
											style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.th_province']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="bookbankPayeeInfoHistProvince" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.province}" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.account.number']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistAccountNo" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.accountNo}" 
											size="30" maxlength="30" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.account.name']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="bookbankPayeeInfoHistAccountName" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.accountName}" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.remark']}"/>
										</td>
										<td colspan="3">
											<h:inputTextarea id="bookbankPayeeInfoHistRemark" 
											readonly="true" styleClass="ms8blueReadOnly"
											value="#{semmmm001Bean.bookbankPayeeInfoHist.remark}" 
											style="width:26%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					<!-- group[4] >> -->
					<rich:panel>
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.bookbank.payee']}" style="text-align:left;"/></f:facet>
						
						<div id="tabBookbankPayeeHistoryChange" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable id="dtbHistoryList" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.historyResultList}" var="historyObj"
							reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:400px;">
										<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:400px;">
										<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="3">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllHistoryList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
						</div>
						
					</rich:panel>
					
					<div style="clear:both; height:5px;"></div>
					
					<rich:panel style="width:1100px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payment.by.contract']}" style="width:1900px;text-align:left;"/></f:facet>
						
						<center>
							
							<rich:dataTable id="dtbHistoryOfBookbankPayeePaymentByContract" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.contractPayHistoryList}" var="vendorObj"
								reRender="dtbHistoryOfBookbankPayeePaymentByContract" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{vendorObj.dataObj.contractPaymentDt}" sortBy="#{vendorObj.dataObj.contractPaymentDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.contract.pay.hist.paymentdt']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{vendorObj.dataObj.contractPaymentDtStr}" styleClass="contentform"  />
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
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryOfBookbankPayeePaymentByContract"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryOfBookbankPayeePaymentByContract" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryOfBookbankPayeePaymentByContract"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
							
						</center>
					</rich:panel>
					<!-- group[4] << -->
				</a4j:form>
			</rich:panel>
		</h:panelGrid>
	</rich:modalPanel>
	<!-- mmm001PopUpHistory5 -->
	<!-- << [POPUP_05] -->
	
