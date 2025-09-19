<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.master.name']}"/></f:facet>	
	
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
			<!-- group[1] >> -->
			<h:panelGrid id="pnlContractInfo" width="100%" style="border:solid 1px gray;">
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}"/></f:facet>
					
					<!-- contract info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoContractNo" value="#{semmmm001Bean.contractInfo.contractNo}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoContractOldNo" value="#{semmmm001Bean.contractInfo.contractOldNo}"
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.region']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="region" value="#{semmmm001Bean.contractInfo.region}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoSiteName" value="#{semmmm001Bean.contractInfo.siteName}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.address']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoSiteLoaction" value="#{semmmm001Bean.contractInfo.siteLocation}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfo.firstEffectiveDtStr}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoLocationId" value="#{semmmm001Bean.contractInfo.locationId}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.effective.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoEffectiveDtStr" value="#{semmmm001Bean.contractInfo.effectiveDtStr}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.code']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoLocationCode" value="#{semmmm001Bean.contractInfo.locationCode}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.expire.date']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoExpireDtStr" value="#{semmmm001Bean.contractInfo.expireDtStr}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.network.status']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoNetworkStatus" value="#{semmmm001Bean.contractInfo.networkStatus}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.status']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoContractStatus" value="#{semmmm001Bean.contractInfo.contractStatus}" 
										disabled="true" style="width:70%;" />
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
										<h:inputText id="contractInfoPendingStatus" value="#{semmmm001Bean.contractInfo.pendingStatus}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.owner.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoOwnerName" value="#{semmmm001Bean.contractInfo.ownerName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoContractName" value="#{semmmm001Bean.contractInfo.contractName}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contact.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoContactName" value="#{semmmm001Bean.contractInfo.contactName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.telephone']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoTelephone" value="#{semmmm001Bean.contractInfo.telephone}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button info + back -->
					<h:panelGrid id="groupInfoButton" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:100%; text-align:right;">
										<a4j:commandButton id="btnContractHistory" value="Contract History" 
										styleClass="rich-button"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
										oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY1" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doContractHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.vendorInfo.contractNo}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" 
										oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfo.siteInfoId}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
						           	 	oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
											<a4j:actionparam name="contractNoParam" value="" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				
				<!-- data table panel -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.list.of.vendor.by.contract']}"/></f:facet>
					
					<center>
					<div id="tabResult" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
						
						<rich:dataTable id="dtbVendorListByContract" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.vendorContractList}" var="vendorObj"
						reRender="dtbVendorListByContract" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkVendorCode" value="#{vendorObj.dataObj.vendorCode}" 
									action="#{navAction.navi}" reRender="oppContent, txtNavProgram" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.site.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.bankBranch}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.accountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{vendorObj.dataObj.payeeBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{vendorObj.dataObj.payeeAccountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{vendorObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
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
						
					</div>
					</center>
				</rich:panel>
			
			</h:panelGrid>
			<!-- group[1] << -->
			
			<rich:spacer />
			
			<!-- group[2] >> -->
			<!-- info data table panel -->
			<h:panelGrid id="pnlVendorInfo" width="100%" style="border:solid 1px gray;">
			
				<rich:panel id="vendorInfo">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
				
					<!-- vendor info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.expense.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoExpenseType" value="#{semmmm001Bean.vendorInfo.expenseType}" style="width:200px;">
		                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.company']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoCompany" value="#{semmmm001Bean.vendorInfo.company}" style="width:100px;"
										disabled="true" >
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
										<h:selectOneMenu id="vendorInfoVendorType" value="#{semmmm001Bean.vendorInfo.vendorType}" 
										disabled="true" 
										style="width:200px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.block.flag']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorBlockStatus" value="#{semmmm001Bean.vendorInfo.vendorBlockStatus}" 
										disabled="true" style="width:100px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.code']}"/>
									</td>
									<td colspan="3">
										<h:inputText id="vendorInfoVendorCode" value="#{semmmm001Bean.vendorInfo.vendorCode}" 
										disabled="true" style="width:26%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="vendorInfoVendorName1" value="#{semmmm001Bean.vendorInfo.vendorName1}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName2" value="#{semmmm001Bean.vendorInfo.vendorName2}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName3" value="#{semmmm001Bean.vendorInfo.vendorName3}" 
										disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName4" value="#{semmmm001Bean.vendorInfo.vendorName4}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoIdCard" value="#{semmmm001Bean.vendorInfo.idCard}" 
										disabled="true" 
										style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoTaxId" value="#{semmmm001Bean.vendorInfo.taxId}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%;" class="">
										<h:outputText value=""/>
									</td>
									<td style="width:30%;">
										<h:outputText value="#{jspMsg['btn.check.vendor.info']}" style="color:red;" styleClass="ms7"/>
										<a4j:commandButton id="btnChkVendor" value="..." styleClass="" 
										disabled="true" style="margin-left:5px;"> 
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.hq.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoHqBranch" value="#{semmmm001Bean.vendorInfo.hqFlag}" 
										disabled="true" 
										style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
		                				<h:inputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfo.branchNo}" 
										disabled="true"  
										maxlength="20" style="width:50px;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Withhold :"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoWhtId" value="#{semmmm001Bean.vendorInfo.whtId}" 
										disabled="true" styleClass="" style="width:100px;">
											<f:selectItems value="#{semmmm001Bean.withholdList}" />
										</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="W/H Type : " styleClass="ms7" />
		                				<h:inputText id="vendorInfoWhtType" value="#{semmmm001Bean.vendorInfo.whtType}" 
										disabled="true" maxlength="20" style="width:30px; text-align:center;" styleClass="" />
										&nbsp;
		                				<h:outputText value="W/H Code : " styleClass="ms7" />
		                				<h:inputText id="vendorInfoWhtCode" value="#{semmmm001Bean.vendorInfo.whtCode}" 
										disabled="true" maxlength="20" style="width:30px; text-align:center;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorStatus" value="#{semmmm001Bean.vendorInfo.vendorStatus}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value=""/>
									</td>
									<td colspan="3">
										<h:selectBooleanCheckbox id="chkVAT" disabled="true"
										value="#{semmmm001Bean.vendorInfo.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" />
				                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.pay.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneRadio id="rdoPayType" label="#{jspMsg['desc.pay.type.check']}"
										disabled="true"
										value="#{semmmm001Bean.vendorInfo.payType}" styleClass="ms7">
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['desc.pay.type.check']}" />
											<f:selectItem itemValue="02" itemLabel="#{jspMsg['desc.pay.type.transfer']}" />
										</h:selectOneRadio>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="Effective Date"/>
									</td>
									<td style="width:30%;">
										<rich:calendar id="vendorInfoEffectiveDt" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmmm001Bean.vendorInfo.effectiveDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return false;"
									   	   cellWidth="15px" cellHeight="20px"
									   	   
									   	   label=""
									   	   disabled="true"
									   	   styleClass="ms7">
										</rich:calendar>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button history -->
					<h:panelGrid id="groupHistoryButton" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:100%; text-align:right;">
										<a4j:commandButton id="btnVendorHistory" value="Vendor History" 
										styleClass="rich-button" disabled="#{semmmm001Bean.disableBtnEditVendor}"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doVendorHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
				</rich:panel>
				
				<!-- button vedor detail -->
				<h:panelGrid id="groupVendorDetailButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:100%;">
									<a4j:commandButton id="btnSaveVendorDetail" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSaveVendor}" 
									onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 	reRender="oppContent" oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doAssignContractToVendor" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnBackVendorDetail" value="#{jspMsg['btn.back']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="contractNoParam" value="" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				
				<!-- contact list panel >> -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.of.vendor.list']} "/></f:facet>
					
					<center>
					<div id="tabContact" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
						
						<rich:dataTable id="dtbContractList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractList}" var="contractObj"
						reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkContractNo" value="#{contractObj.dataObj.contractNo}" 
									action="#{navAction.navi}" reRender="oppContent, txtNavProgram" 
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="contractNoParam" value="#{contractObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{contractObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.accountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{contractObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankPayeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.contractList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="8">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractList"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllContractList" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbContractList"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
					</div>
					</center>
				</rich:panel>
				<!-- contract list panel << -->
				
			</h:panelGrid>
			<!-- group[2] << -->
			
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>