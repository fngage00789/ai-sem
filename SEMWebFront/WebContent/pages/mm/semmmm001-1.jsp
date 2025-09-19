<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="th.co.ais.util.*" %>
    
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
		
		<h:panelGrid columnClasses="gridContent" width="100%">
            <!-- begin content layout criteria -->
        	<h:panelGrid width="96%">
        		<!-- criteria panel -->
				<a4j:form id="frmCriteriaSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.criteria.name']}"/></f:facet>
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td style="width:25%; text-align:right;">
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												<h:selectOneMenu id="searchCompany" value="#{semmmm001Bean.vendorMasterCriteria.company}" 
												style="width:120px;">
				                					<f:selectItems value="#{semmmm001Bean.companyList}" />
				                				</h:selectOneMenu>
				                				
				                				<rich:spacer width="3"></rich:spacer>
												<h:selectBooleanCheckbox id="chkDummyFlag" value="#{semmmm001Bean.chkDummyFlag}" style="vertical-align:bottom;" />
						                		<h:outputText value="#{jspMsg['label.th.dummy.contract']}" styleClass="ms7" style="margin-left:2px;" />
											</td>
											<td style="width:25%; text-align:right;">
												<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												
						                		<h:selectManyCheckbox value="#{semmmm001Bean.vendorMasterCriteria.arrRegion}" styleClass="ms7" style="width:320px;">
										   			<f:selectItems value="#{semmmm001Bean.regionList}" />
										   		</h:selectManyCheckbox>
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;">
												<h:outputText value="#{jspMsg['label.type']}" styleClass="ms7"/>
											</td>
											<td width="25%;">
												<rich:spacer width="3"></rich:spacer>
												<h:selectBooleanCheckbox id="chkPicoType" value="#{semmmm001Bean.chkPicoType}" style="vertical-align:bottom;" />
						                		<h:outputText value="PICO" styleClass="ms7" style="margin-left:2px;" />
											</td>
											<td style="width:25%; text-align:right;" >
												<h:outputText value="#{jspMsg['label.location.contract.name']}" styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchSiteName" value="#{semmmm001Bean.vendorMasterCriteria.siteName}" 
												style="width:70%;" maxlength="20" />
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;">
												<h:outputText value="#{jspMsg['label.contract.number']}" styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchContractNo" value="#{semmmm001Bean.vendorMasterCriteria.contractNo}" 
												style="width:30%;" maxlength="50" />
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.location.id']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchLocationId" value="#{semmmm001Bean.vendorMasterCriteria.locationId}" 
												style="width:30%;" maxlength="50" />
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;">
												<h:outputText value="#{jspMsg['label.expense.type']}" styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												<h:selectOneMenu id="searchExpenseType" value="#{semmmm001Bean.vendorMasterCriteria.expenseType}" 
												style="width:160px;">
				                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:25%; text-align:right;" >
												<h:outputText value="#{jspMsg['label.location.code']}" styleClass="ms7"/>
												
											</td>
											<td style="width:25%;">
												<table align="left" border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td style="">
															<h:inputText id="searchLocationCode" value="#{semmmm001Bean.vendorMasterCriteria.locationCode}" 
															style="width:78%;" maxlength="20" />
														</td>
														<td style="width:23%;" >
															<h:outputText value="#{jspMsg['label.site.code']}" styleClass="ms7"/>
														</td>
														<td >
															<h:inputText id="searchSiteCode" value="#{semmmm001Bean.vendorMasterCriteria.siteCode}" 
															style="width:80%;" maxlength="20" />
														</td>
													</tr>
												</table>
											</td>
											
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												
											</td>
											<td style="width:25%;">
												
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												
											</td>
											<td style="width:25%;">
											
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" >
												<h:outputText value="Vendor Code : " styleClass="ms7"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchVendorCode" value="#{semmmm001Bean.vendorMasterCriteria.vendorCode}" 
												style="width:40%;" maxlength="50" />
												
												<a4j:commandButton id="btnCnvrtVendor" value="..." styleClass="rich-button" 
									            action="#{semmmm001Action.initConvertVendor}" reRender="searchVendorCode, mmm001PopUpCommon_convertVendorCode" 
									            style="margin: 0 0 0 5px; height:22px; vertical-align:top;"
									            oncomplete="#{rich:component('mmm001PopUpCommon_convertVendorCode')}.show();">
												</a4j:commandButton>
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="Payee Code : "/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchPayeeCode" value="#{semmmm001Bean.vendorMasterCriteria.payeeCode}" 
												style="width:30%;" maxlength="50" />
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												
											</td>
											<td style="width:25%;">
												<h:selectBooleanCheckbox id="chkVendorType" value="#{semmmm001Bean.chkVendorType}" style="vertical-align:bottom;" />
						                		<h:outputText value="Vendor" styleClass="ms7" style="margin-left:2px;" />
						                		
						                		<rich:spacer width="20"></rich:spacer>
						                		
						                		<h:selectBooleanCheckbox id="chkPayeeType" value="#{semmmm001Bean.chkPayeeType}" style="vertical-align:bottom;" />
						                		<h:outputText value="Payee" styleClass="ms7" style="margin-left:2px;" />
						                		
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												
											</td>
											<td style="width:25%;">
											
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.or.payee.name']}"/>
											</td>
											<td style="width:25%; text-align:left;">
												<h:inputText id="searchVendorName" value="#{semmmm001Bean.vendorMasterCriteria.vendorName}" 
												style="width:89%;" maxlength="255" />
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.citizen.id']} / #{jspMsg['label.taxpayer']} : "/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchIdCard" value="#{semmmm001Bean.vendorMasterCriteria.idCard}" 
												onkeypress="return numberformat.keyPressDecimalAsterisk(this, event);" 
												style="width:40%;" maxlength="13" />
											</td>
										</tr>
										
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bank']}"/>
											</td>
											<td style="width:25%;">
												
												<a4j:region> 
													<h:selectOneMenu id="searchBank" value="#{semmmm001Bean.vendorMasterCriteria.bankCode}"> 
				                                        <f:selectItems value="#{semmmm001Bean.bankNameSearchList}"/>
				                                    </h:selectOneMenu>  
												</a4j:region>
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bank.branch']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchBankBranch" value="#{semmmm001Bean.vendorMasterCriteria.bankBranch}" 
												style="width:70%;" maxlength="100" />
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.number']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchAccountNo" value="#{semmmm001Bean.vendorMasterCriteria.accountNo}" 
												onkeypress="return numberformat.keyPressDecimalAsterisk('searchAccountNo', event);" 
												style="width:40%;" maxlength="20" />
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.name']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchAccountName" value="#{semmmm001Bean.vendorMasterCriteria.accountName}" 
												style="width:70%;" maxlength="255" />
											</td>
										</tr>
										<tr>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.create.by']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchCreateBy" value="#{semmmm001Bean.vendorMasterCriteria.createBy}" 
												style="width:41%;" maxlength="255" />
											</td>
											<td style="width:25%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.batch.no.and.lot.no']}"/>
											</td>
											<td style="width:25%;">
												<h:inputText id="searchBatchNo" value="#{semmmm001Bean.vendorMasterCriteria.batchNo}" 
												style="width:40%;" maxlength="20" />
											</td>
										</tr>
										
										<tr>
											<td colspan="4" align="left">
						                		<rich:simpleTogglePanel id="pnlSubSearch"  switchType="client" label="#{jspMsg['header.criteria.name2']}" 
						                		opened="false" width="100%">
						                			<table align="center" width="100%">
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.vendor.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchVendorStatus" value="#{semmmm001Bean.vendorMasterCriteria.vendorStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchVendorFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.vendorFlowStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.vendorFlowStatusList}" />
								                				</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.block.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBlockStatus" value="#{semmmm001Bean.vendorMasterCriteria.blockStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.blockStatusList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.blacklist.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBlackListStatus" value="#{semmmm001Bean.vendorMasterCriteria.blackListStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.blackListStatusList}" />
								                				</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.payee.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchPayeeStatus" value="#{semmmm001Bean.vendorMasterCriteria.payeeStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.payeeStatusList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.payee.flow.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchPayeeFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.payeeFlowStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.payeeFlowStatusList}" />
								                				</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBookbankStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.bookbankStatusList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBookbankFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankFlowStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
								                				</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.bookbank.payee.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBookbankPayeeStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankPayeeStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.bookbankPayeeStatusList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.bookbank.payee.flow.status']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchBookbankPayeeFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankPayeeFlowStatus}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.bookbankPayeeFlowStatusList}" />
								                				</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td style="width:25%; text-align:right;" class="ms7">
																<h:outputText value="#{jspMsg['label.no.export.batch']}"/>
															</td>
															<td style="width:25%;">
																<h:selectOneMenu id="searchNoExportBatch" value="#{semmmm001Bean.vendorMasterCriteria.noExportBatch}" style="width:160px;">
								                					<f:selectItems value="#{semmmm001Bean.noExportBatchList}" />
								                				</h:selectOneMenu>
															</td>
															<td style="width:25%; text-align:right;" class="ms7">
																
															</td>
															<td style="width:25%;">
																
															</td>
														</tr>
													</table>
												</rich:simpleTogglePanel>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							
							<!-- button search + clear -->
							<h:panelGrid columns="2" id="groupSearchButton">
								<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
								action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, pnlSearchTmnResult, frmSearch, vendorMasterSelectedAll, vendorMasterTmnSelectedAll, 
																	 dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  				 btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete,btnExpExcel" >
									<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
								
								<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           	 	action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, pnlSearchTmnResult, frmSearch, vendorMasterSelectedAll, vendorMasterTmnSelectedAll, 
																	 dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  				 btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete,btnExpExcel">
					           		<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				           		</a4j:commandButton>
							</h:panelGrid>
					</rich:panel>
					
					<!-- response message panel -->
			<h:panelGrid>
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
	                       	<h:outputText value="Entered Data Status:"></h:outputText>
	                   	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
	                </rich:messages>
			</h:panelGrid>
				
					<!-- div style="clear:both; height:10px;"></div -->
					<h:panelGrid id="vendorBtnPnl" style="width:95%;">
						<!-- button other -->
						<h:panelGrid columns="10" id="groupResultButton">
							 
			           		<a4j:commandButton id="btnNewVendor" value="New Vendor" styleClass="rich-button" 
			           		disabled="false" style="padding-left: 5px; width:77px;"
							action="#{navAction.navi}" reRender="oppContent, txtNavProgram">
							    <a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doNewVendorClearContent" />
								<a4j:actionparam name="mode" value="New" />
								<a4j:actionparam name="headType" value="Vendor" />
								<a4j:actionparam name="contractNoParam" value="" />
								<a4j:actionparam name="vendorIdParam" value="" />
								<a4j:actionparam name="newVendorFlag" value="Y"/>
								<a4j:actionparam name="btnActionType" value="N" />
								<a4j:actionparam name="actionId" value="PAGE_VENDOR_SEARCH_NEW" />
							</a4j:commandButton>
							
							
							<a4j:commandButton id="btnExpBtchVD" value="Export Vendor" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchVD}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, pnlTmnSearchResult, dtbResultList, pnlShowReportVendorExcel,vendorBtnPnl,vendorBtnPnl2"
			           	 	style="padding-left: 5px; width:85px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VD" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngVD" value="Send Vendor to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerVD}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2"
							oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
							style="padding-left: 5px; width:135px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_VD" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpBtchVB" value="Export Bookbank" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchVB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="frmResultSearch, pnlTmnSearchResult, dtbResultList, pnlShowReportVendorBookbankExcel,vendorBtnPnl,vendorBtnPnl2"
			           	 	style="padding-left: 5px; width:95px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VB" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngVB" value="Send  Bookbank to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerVB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:149px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_VB" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpBtchPY" value="Export Payee" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchPY}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, pnlTmnSearchResult, dtbResultList, pnlShowReportPayeeToLeaderExcel,vendorBtnPnl,vendorBtnPnl2"
			           	 	style="padding-left: 5px; width:78px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PY" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngPY" value="Send Payee to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerPY}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:129px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_PY" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpBtchPB" value="Export BookBank Payee" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchPB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, pnlTmnSearchResult, dtbResultList, pnlShowReportPayeeBookbankToLeaderExcel,vendorBtnPnl,vendorBtnPnl2"
			           	 	style="padding-left: 5px; width:128px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PB" />
			           		</a4j:commandButton>
			           		
			           		
			           		<a4j:commandButton id="btnSndMngPB" value="Send BookBank Payee to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerPB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:179px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_PB" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnDelete" value="#{jspMsg['btn.deletevendor']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnDelete}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2"
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="DELETE" />
			           		</a4j:commandButton>
						</h:panelGrid>
						
					</h:panelGrid>
					
					<!-- div style="clear:both; height:10px;"></div -->
					<h:panelGrid id="vendorBtnPnl2" style="width:95%;">
						<!-- button other -->
						<h:panelGrid columns="3" id="groupResultButton2">
							<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clearBatch']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnClearBatch}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl,vendorBtnPnl2"
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="CLEAR_BATCH" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnCancel}" rendered="false"
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, pnlTmnSearchResult, dtbResultList,vendorBtnPnl, vendorBtnPnl2"
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="CANCEL" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpExcel" value="Export Excel" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportExcel}"
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, pnlTmnSearchResult, dtbResultList, pnlShowReportExcel,vendorBtnPnl,vendorBtnPnl2"
			           	 	style="padding-left: 5px; width:85px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_EXCEL" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</h:panelGrid>	
					
				</a4j:form>
				
				
				<!-- result panel [ACTIVED and EXPIRED] -->
				<a4j:form id="frmResultSearch">
					
					<h:panelGrid  width="90%">
		             	<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
		             		<f:facet name="header"><h:outputText value="#{jspMsg['header.result.name']} [ACTIVED and EXPIRED]" style=""/></f:facet>
		             		
		             		<rich:dataTable id="dtbResultList" width="100%" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.vendorMasterResultList}" var="vendorMasterObj"
							reRender="dtbResultList" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
								
								<rich:column style="" title="">
									<f:facet name="header">
										
										<h:selectBooleanCheckbox value="#{semmmm001Bean.chkSelAllTblAct}" 
										id="vendorMasterSelectedAll" style="width:20px;">
											<a4j:support event="onclick" 
											action="#{semmmm001Action.selectAllRow}" 
											reRender="dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete, btnClearBatch, btnCancel, btnExpExcel" >
												<a4j:actionparam name="tblChkParam" value="ACT" />	
											</a4j:support>
										</h:selectBooleanCheckbox>
										
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="vendorMasterSelected" value="#{vendorMasterObj.checkBox}">
											<a4j:support event="onclick" action="#{semmmm001Action.selectRow}" 
											reRender="dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete, btnClearBatch, btnCancel, btnExpExcel" >
												<a4j:actionparam name="tblChkParam" value="ACT" />									  
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.actionType}" rendered="true">
									<f:facet name="header">
										<h:outputText value="Action" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.actionType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.otherStatus}" rendered="true">
									<f:facet name="header">
										<h:outputText value="Status" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.otherStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="History" rendered="true">
									<f:facet name="header">
										
									</f:facet>
									
									<div align="center">
										<h:graphicImage id="historyIconImg" value="images/history.png" 
							           	rendered="#{vendorMasterObj.dataObj.historyFlag eq 'Y'}" 
							           	style="height:15px; width:15px;"></h:graphicImage>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.allStatus}" rendered="false">
									<f:facet name="header">
										<h:outputText value="All Status" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.allStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<a4j:commandLink id="hlkVendorCode" value="#{vendorMasterObj.dataObj.vendorCode}" 
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
										oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="contractNoParam" value="#{vendorMasterObj.dataObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{vendorMasterObj.dataObj.vendorId}" />
											
											<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{vendorMasterObj.dataObj.vendorEffectiveDtStr}" />
											<a4j:actionparam name="effectiveDtStrParam" value="#{vendorMasterObj.dataObj.effectiveDtStr}" />
											<a4j:actionparam name="expireDtStrParam" value="#{vendorMasterObj.dataObj.expireDtStr}" />
											<a4j:actionparam name="expenseTypeIdParam" value="#{vendorMasterObj.dataObj.expenseTypeId}" />
											<a4j:actionparam name="payTypeIdParam" value="#{vendorMasterObj.dataObj.payTypeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{vendorMasterObj.dataObj.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="PAGE_VENDOR_SEARCH_VIEW" />
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.idCard}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.citizen.id.and.taxid']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.idCard}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.taxId}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.taxId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorBranchNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.branch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorBranchNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{vendorMasterObj.dataObj.contractType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{vendorMasterObj.dataObj.contractNo}" 
											oncomplete="showViewSiteInfoPopup()"
											action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{vendorMasterObj.dataObj.viewSiteInfoId}" />
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractOldNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.contractOldNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.expenseType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.contractStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.networkStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.networkStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractEffectiveDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contracteffectivedt']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.contractEffectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.contractExpireDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractexpiredt']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.contractExpireDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.locationId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.locationCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.locationCode}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.locationName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterObj.dataObj.locationName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorBlockStatus}"  rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="" sortBy="#{vendorMasterObj.dataObj.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorMasterObj.dataObj.bankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.accountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.accountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.accountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterObj.dataObj.accountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeBankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeBankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeAccountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.payeeAccountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterObj.dataObj.payeeAccountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankPayeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankPayeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.bookbankPayeeBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.bookbankPayeeBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.lotNo}"   rendered="false">
									<f:facet name="header">
										<h:outputText value="Lot No" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterObj.dataObj.lotNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width:580px;"/>
									</f:facet>
									
									<div align="left" style="width:580px;">
										<h:outputText value="#{vendorMasterObj.dataObj.remark}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterObj.dataObj.vendorEffectiveDt}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{vendorMasterObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.vendorMasterResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="38">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbResultList"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllResultList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbResultList"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
								
							</rich:dataTable>
		             	</rich:panel>
					</h:panelGrid>    
					
					<rich:spacer height="10"/>
					
					<!-- result panel [TERMINATED and PREVIOUS] -->
					<h:panelGrid  width="90%">
		             	<rich:panel id="pnlTmnSearchResult" styleClass="sem_autoScrollbar" >
		             		<f:facet name="header"><h:outputText value="#{jspMsg['header.result.name']} [TERMINATED and PREVIOUS]" style=""/></f:facet>
		             		
		             		<rich:dataTable id="dtbTmnResultList" width="100%" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.vendorMasterTerminateResultList}" var="vendorMasterTmnObj"
							reRender="dtbTmnResultList" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
								
								<rich:column style="" title="">
									<f:facet name="header">
										
										<h:selectBooleanCheckbox value="#{semmmm001Bean.chkSelAllTblTmn}" 
										id="vendorMasterTmnSelectedAll" style="width:20px;">
											<a4j:support event="onclick" 
											action="#{semmmm001Action.selectAllRow}" 
											reRender="dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete,btnExpExcel" >
												<a4j:actionparam name="tblChkParam" value="TMN" />
											</a4j:support>
										</h:selectBooleanCheckbox>
										
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="vendorMasterTmnSelected" value="#{vendorMasterTmnObj.checkBox}">
											<a4j:support event="onclick" action="#{semmmm001Action.selectRow}" 
											reRender="dtbResultList, dtbTmnResultList, vendorBtnPnl, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
													  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete,btnExpExcel" >
												<a4j:actionparam name="tblChkParam" value="TMN" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.actionType}" rendered="true">
									<f:facet name="header">
										<h:outputText value="Action" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.actionType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.otherStatus}" rendered="true">
									<f:facet name="header">
										<h:outputText value="Status" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.otherStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="History" rendered="true">
									<f:facet name="header">
										
									</f:facet>
									
									<div align="center">
										<h:graphicImage id="historyIconImg" value="images/history.png" 
							           	rendered="#{vendorMasterTmnObj.dataObj.historyFlag eq 'Y'}" 
							           	style="height:15px; width:15px;"></h:graphicImage>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.allStatus}" rendered="false">
									<f:facet name="header">
										<h:outputText value="All Status" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.allStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title=""  sortBy="#{vendorMasterTmnObj.dataObj.vendorCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<a4j:commandLink id="hlkTmnVendorCode" value="#{vendorMasterTmnObj.dataObj.vendorCode}" 
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
										oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="contractNoParam" value="#{vendorMasterTmnObj.dataObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{vendorMasterTmnObj.dataObj.vendorId}" />
											
											<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{vendorMasterTmnObj.dataObj.vendorEffectiveDtStr}" />
											<a4j:actionparam name="effectiveDtStrParam" value="#{vendorMasterTmnObj.dataObj.effectiveDtStr}" />
											<a4j:actionparam name="expireDtStrParam" value="#{vendorMasterTmnObj.dataObj.expireDtStr}" />
											<a4j:actionparam name="expenseTypeIdParam" value="#{vendorMasterTmnObj.dataObj.expenseTypeId}" />
											<a4j:actionparam name="payTypeIdParam" value="#{vendorMasterTmnObj.dataObj.payTypeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{vendorMasterTmnObj.dataObj.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="PAGE_VENDOR_SEARCH_VIEW" />
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.actionState}" rendered="false">
									<f:facet name="header">
										<h:outputText value="Master Type" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.actionState}" styleClass="contentform"  />
									</div>
								</rich:column>
							
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.idCard}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.citizen.id.and.taxid']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.idCard}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.taxId}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.taxId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorBranchNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.branch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorBranchNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.contractType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{vendorMasterTmnObj.dataObj.contractNo}" 
											oncomplete="showViewSiteInfoPopup()"
											action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{vendorMasterTmnObj.dataObj.viewSiteInfoId}" />
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractOldNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.contractOldNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.expenseType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.contractStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.networkStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.networkStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractEffectiveDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contracteffectivedt']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.contractEffectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.contractExpireDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractexpiredt']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.contractExpireDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.locationId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.locationCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.locationCode}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.locationName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.locationName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorBlockStatus}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column title="" sortBy="#{vendorMasterTmnObj.dataObj.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.accountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.accountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.accountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.accountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeBankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeBankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeAccountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.payeeAccountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.payeeAccountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankPayeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankPayeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.lotNo}"  rendered="false">
									<f:facet name="header">
										<h:outputText value="Lot No" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.lotNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.bookbankPayeeBatch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.batch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.bookbankPayeeBatch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width:580px;"/>
									</f:facet>
									
									<div align="left" style="width:580px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.remark}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorMasterTmnObj.dataObj.vendorEffectiveDt}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:100px;">
										<h:outputText value="#{vendorMasterTmnObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.vendorMasterTerminateResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="38">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbTmnResultList"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllTmnResultList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbTmnResultList"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
								
							</rich:dataTable>
		             	</rich:panel>
		            </h:panelGrid>
					
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0">
						<h:panelGroup>
							<table border="0" >
								<tr>
									<td style="text-align:left;" colspan="2" class="ms7">
										<h:outputText value="Action" />
									</td>
											
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="N" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= New" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="E" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= Edit" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="C" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= Change" styleClass="ms7" />
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="D" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= Delete" styleClass="ms7"/>
									</td>
								</tr>
							</table>
						</h:panelGroup>
						<h:panelGroup style="height: 10px;">
						</h:panelGroup>
						<h:panelGroup>
							<table border="0" >
								<tr>
									<td style="text-align:left;" colspan="2" class="ms7">
										<h:outputText value="Status" />
									</td>
											
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="BO" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= Block" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="BL" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= Blacklist" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="AB" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= #{jspMsg['text.status.ab']}" styleClass="ms7" />
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="NC" styleClass="ms7"/>
									</td>
											
									<td style="text-align:left;" class="ms7">
										<h:outputText value="= #{jspMsg['text.status.nc']}" styleClass="ms7" />
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					
				</a4j:form>
        	</h:panelGrid>
       	</h:panelGrid>
					                    
			
	<a4j:jsFunction name="test" process="#{rich:component('mmm001PopUpCommon_exportBatchRetResult')}.show(); return false;"
	reRender="oppContent"></a4j:jsFunction>

	
	</rich:panel>
	
	<a4j:form id="frmShowReportExcel_">
	
					<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportExcel}" />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
							
					<h:panelGrid id="pnlShowReportVendorExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorToLeader}" />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorBookbankExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorBookbankExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportPayeeToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeBookbankToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeBookbankToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
		
	</a4j:form>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>