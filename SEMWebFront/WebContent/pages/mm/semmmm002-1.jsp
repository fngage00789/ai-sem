<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm002" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.search.flow']}"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco002Bean.renderedMsgFormSearch}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<!-- criteria panel -->
		<a4j:form id="frmCriteriaSearch">
			<rich:panel id="pnlSearchCriteria">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.criteria.name']}"/></f:facet>
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.company']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="searchCompany" value="#{semmmm002Bean.criteria.company}" style="width:160px;" onchange="GetCompanyJS();">
		                					<f:selectItems value="#{semmmm002Bean.companyList}" />
		                				</h:selectOneMenu>
		                				<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
                                        <rich:spacer width="10"></rich:spacer>
                                        <h:outputText id="companyDisplay" value="#{semmmm002Bean.criteria.company}" styleClass="ms28"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.region']}"/>
									</td>
									<td style="width:30%;">
										
				                		<h:selectManyCheckbox value="#{semmmm002Bean.criteria.arrRegion}" styleClass="ms7">
								   			<f:selectItems value="#{semmmm002Bean.regionList}" />
								   		</h:selectManyCheckbox>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.type']}"/>
									</td>
									<td width="30%;">
										<rich:spacer width="3"></rich:spacer>
										<h:selectBooleanCheckbox id="chkPicoType" value="#{semmmm002Bean.chkPicoType}" style="vertical-align:bottom;" />
				                		<h:outputText value="PICO" styleClass="ms7" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchSiteName" value="#{semmmm002Bean.criteria.siteName}" 
										style="width:70%;" maxlength="20" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchContractNo" value="#{semmmm002Bean.criteria.contractNo}" 
										style="width:30%;" maxlength="50" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchLocationId" value="#{semmmm002Bean.criteria.locationId}" 
										style="width:30%;" maxlength="50" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.expense.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="searchExpenseType" value="#{semmmm002Bean.criteria.expenseType}" 
										style="width:160px;">
		                					<f:selectItems value="#{semmmm002Bean.expenseTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.location.code']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchLocationCode" value="#{semmmm002Bean.criteria.locationCode}" 
										style="width:30%;" maxlength="20" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										
									</td>
									<td style="width:30%;">
										
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.site.code']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchSiteCode" value="#{semmmm002Bean.criteria.siteCode}" 
										style="width:30%;" maxlength="20" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Vendor Code : "/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchVendorCode" value="#{semmmm002Bean.criteria.vendorCode}" 
										style="width:40%;" maxlength="50" />
										
										<a4j:commandButton id="btnCnvrtVendor" value="..." styleClass="rich-button" 
							            action="#{semmmm002Action.initConvertVendor}" reRender="searchVendorCode, mmm002PopUpCommon_convertVendorCode" 
							            style="margin: 0 0 0 5px; height:22px; vertical-align:top;"
							            oncomplete="#{rich:component('mmm002PopUpCommon_convertVendorCode')}.show();">
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Payee Code : "/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchPayeeCode" value="#{semmmm002Bean.criteria.payeeCode}" 
										style="width:30%;" maxlength="50" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										
									</td>
									<td style="width:30%;">
										<rich:spacer width="3"></rich:spacer>
										<h:selectBooleanCheckbox id="chkVendorType" value="#{semmmm002Bean.chkVendorType}" style="vertical-align:bottom;" />
				                		<h:outputText value="VENDOR" styleClass="ms7" style="margin-left:2px;" />
				                		
				                		<rich:spacer width="20"></rich:spacer>
				                		
				                		<h:selectBooleanCheckbox id="chkPayeeType" value="#{semmmm002Bean.chkPayeeType}" style="vertical-align:bottom;" />
				                		<h:outputText value="PAYEE" styleClass="ms7" style="margin-left:2px;" />
				                		
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										
									</td>
									<td style="width:30%;">
									
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.or.payee.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchVendorName" value="#{semmmm002Bean.criteria.vendorName}" 
										style="width:89%;" maxlength="255" />
									</td>
									
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.citizen.and.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchIdCard" value="#{semmmm002Bean.criteria.idCard}"  size="30" maxlength="13" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
										style="width:40%;"/>
										
										<a4j:jsFunction name="checkIdCard" action="#{semmmm002Action.doCheckIdCard}"
											reRender="incContent"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank']}"/>
									</td>
									<td style="width:30%;">
										
		                				<h:inputText id="searchBank" value="#{semmmm002Bean.criteria.bankCode}" style="width:300px;"></h:inputText>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchBankBranch" value="#{semmmm002Bean.criteria.bankBranchCode}" 
										style="width:70%;" maxlength="100" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchAccountNo" value="#{semmmm002Bean.criteria.accountNo}" 
										onkeypress="return numberformat.keyPressDecimalOnly('searchAccountNo', event);" 
										style="width:40%;" maxlength="20" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchAccountName" value="#{semmmm002Bean.criteria.accountName}" 
										style="width:70%;" maxlength="255" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.create.by']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchCreateBy" value="#{semmmm002Bean.criteria.createBy}" 
										style="width:41%;" maxlength="255" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.batch.no']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="searchBatchNo" value="#{semmmm002Bean.criteria.batchNo}" 
										style="width:40%;" maxlength="20" />
									</td>
								</tr>
								
								
								
								
								<tr>
									<td colspan="4" align="left">
				                		<rich:simpleTogglePanel id="pnlSubSearch"  switchType="client" label="#{jspMsg['header.criteria.name2']}" 
				                		opened="false" width="100%">
				                			<table align="center" width="100%">
												<tr>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.vendor.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchVendorStatus" value="#{semmmm002Bean.criteria.vendorStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.vendorStatusList}" />
						                				</h:selectOneMenu>
													</td>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchVendorFlowStatus" value="#{semmmm002Bean.criteria.vendorFlowStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.vendorFlowStatusList}" />
						                				</h:selectOneMenu>
													</td>
												</tr>
												<tr>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.block.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBlockStatus" value="#{semmmm002Bean.criteria.blockStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.blockStatusList}" />
						                				</h:selectOneMenu>
													</td>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.blacklist.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBlackListStatus" value="#{semmmm002Bean.criteria.blackListStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.blackListStatusList}" />
						                				</h:selectOneMenu>
													</td>
												</tr>
												<tr>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.payee.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchPayeeStatus" value="#{semmmm002Bean.criteria.payeeStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.payeeStatusList}" />
						                				</h:selectOneMenu>
													</td>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.payee.flow.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchPayeeFlowStatus" value="#{semmmm002Bean.criteria.payeeFlowStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.payeeFlowStatusList}" />
						                				</h:selectOneMenu>
													</td>
												</tr>
												
												<tr>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBookbankStatus" value="#{semmmm002Bean.criteria.bookbankStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.bookbankStatusList}" />
						                				</h:selectOneMenu>
													</td>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBookbankFlowStatus" value="#{semmmm002Bean.criteria.bookbankFlowStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.bookbankFlowStatusList}" />
						                				</h:selectOneMenu>
													</td>
												</tr>
												<tr>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.bookbank.payee.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBookbankPayeeStatus" value="#{semmmm002Bean.criteria.bookbankPayeeStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.bookbankPayeeStatusList}" />
						                				</h:selectOneMenu>
													</td>
													<td style="width:20%; text-align:right;" class="ms7">
														<h:outputText value="#{jspMsg['label.bookbank.payee.flow.status']}"/>
													</td>
													<td style="width:30%;">
														<h:selectOneMenu id="searchBookbankPayeeFlowStatus" value="#{semmmm002Bean.criteria.bookbankPayeeFlowStatus}" style="width:160px;">
						                					<f:selectItems value="#{semmmm002Bean.bookbankPayeeFlowStatusList}" />
						                				</h:selectOneMenu>
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
						action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, frmSearch, groupResultButton1, groupResultButton2, pnlSubBtn" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, frmSearch, groupResultButton1, groupResultButton2, pnlSubBtn">
			           		<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
		           		</a4j:commandButton>
					</h:panelGrid>
			</rich:panel>
		
			<!-- div style="clear:both; height:10px;"></div -->
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco002Bean.renderedMsgFormSearch}">
				<f:facet name="header">
                	<h:outputText value="Entered Data Status:"></h:outputText>
            	</f:facet>
		 		<f:facet name="errorMarker">
		 			 <h:graphicImage value="images/error.gif" />  
                </f:facet>
            </rich:messages>
			
			<h:panelGrid>
				<!-- button other -->
				<h:panelGrid columns="11" id="groupResultButton1">
					<a4j:commandButton id="btnApproveM2Vendor" value="Send Infomation To SAP" styleClass="rich-button"
						action="#{navAction.navi}" style="padding-left: 0px;width:165px;"
						onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						rendered="true" disabled="#{semmmm002Bean.disableBtnMNG2ApproveVendor}"
						reRender="txtNavProgram, oppContent">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
							<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_VENDOR" />
							<a4j:actionparam name="actionType" value="M2A" />
					</a4j:commandButton>
				
					<a4j:commandButton id="btnApproveVendor" value="Approve Vendor" styleClass="rich-button"
					action="#{navAction.navi}" style="padding-left: 0px; width:85px;"
					rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
					disabled="#{semmmm002Bean.disableBtnApproveVendor}" reRender="txtNavProgram, oppContent"
					oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;">
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
						<a4j:actionparam name="actionBtnType" value="APPROVE_VENDOR" />
						<a4j:actionparam name="actionType" value="MA" />
						<a4j:actionparam name="btnType" value="VD" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnRejectVendor" value="Reject Vendor" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectVendor}" 
	           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	reRender="oppContent,txtNavProgram" style="padding-left: 0px;width:75px;"
	           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="initReject" />
						<a4j:actionparam name="actionBtnType" value="REJECT_VENDOR" />
						<a4j:actionparam name="actionType" value="MR" />
						<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
	           		</a4j:commandButton>
					
					<a4j:commandButton id="btnSndVendorToMng2" value="Send Vendor To Manager2" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendVendorToMNG2}" 
	           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
	           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}" 
	           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px;width:135px;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="SEND_VENDOR_TO_MANAGER2" />
						<a4j:actionparam name="reqManager2" value="Y" />
	           		</a4j:commandButton>
	           		
	           		<rich:spacer width="10px"></rich:spacer>
	           		
	           		<a4j:commandButton id="btnApproveBookbank" value="Approve Bookbank" styleClass="rich-button"
					action="#{navAction.navi}" style="padding-left: 0px;width:98px;"
					rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
					disabled="#{semmmm002Bean.disableBtnApproveBookbank}" reRender="txtNavProgram, oppContent"
					oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;">
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
						<a4j:actionparam name="actionBtnType" value="APPROVE_BOOKBANK" />
						<a4j:actionparam name="actionType" value="MA" />
						<a4j:actionparam name="btnType" value="VB" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnRejectBookbank" value="Reject Bookbank" styleClass="rich-button" 
					rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectBookbank}" reRender="oppContent,txtNavProgram"
	           	 	style="padding-left: 0px;width:85px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="initReject" />
						<a4j:actionparam name="actionBtnType" value="REJECT_BOOKBANK" />
						<a4j:actionparam name="actionType" value="MR" />
						<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
	           		</a4j:commandButton>
					
					<a4j:commandButton id="btnSndBookbankToMng2" value="Send Bookbank To Manager2" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendBookbankToMNG2}" 
	           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
	           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px;width:147px;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="SEND_BOOKBANK_TO_MANAGER2" />
						<a4j:actionparam name="reqManager2" value="Y" />
	           		</a4j:commandButton>
				</h:panelGrid>
				
				<h:panelGrid columns="10" id="groupResultButton2">
					<a4j:commandButton id="btnApprovePayee" value="Approve Payee" styleClass="rich-button"
					action="#{navAction.navi}" rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}" 
					oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;"
					disabled="#{semmmm002Bean.disableBtnApprovePayee}" reRender="txtNavProgram, oppContent"
					style="padding-left: 0px; width:80px;">
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
						<a4j:actionparam name="actionBtnType" value="APPROVE_PAYEE" />
						<a4j:actionparam name="actionType" value="MA" />
						<a4j:actionparam name="btnType" value="PY" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnRejectPayee" value="Reject Payee" styleClass="rich-button" 
					rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectPayee}" reRender="oppContent,txtNavProgram"
	           	 	style="padding-left: 0px; width:67px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="initReject" />
						<a4j:actionparam name="actionBtnType" value="REJECT_PAYEE" />
						<a4j:actionparam name="actionType" value="MR" />
						<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
	           		</a4j:commandButton>
					
					<a4j:commandButton id="btnSndPayeeToMng2" value="Send Payee To Manager2" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendPayeeToMNG2}" 
	           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
	           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px; width:130px;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="SEND_PAYEE_TO_MANAGER2" />
						<a4j:actionparam name="reqManager2" value="Y" />
	           		</a4j:commandButton>
	           		
	           		<rich:spacer width="10px"></rich:spacer>
	           		
	           		<a4j:commandButton id="btnApprovePayeeBookbank" value="Approve BookBank Payee" styleClass="rich-button"
					action="#{navAction.navi}" rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
					oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;"
					disabled="#{semmmm002Bean.disableBtnApprovePayeeBookbank}" reRender="txtNavProgram, oppContent"
					style="padding-left: 0px; width:130px;">
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
						<a4j:actionparam name="actionBtnType" value="APPROVE_PAYEE_BOOKBANK" />
						<a4j:actionparam name="actionType" value="MA" />
						<a4j:actionparam name="btnType" value="PB" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnRejectPayeeBookbank" value="Reject BookBank Payee" styleClass="rich-button" 
					rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectPayeeBookbank}" reRender="oppContent,txtNavProgram"
	           	 	style="padding-left: 0px; width:120px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="initReject" />
						<a4j:actionparam name="actionBtnType" value="REJECT_PAYEE_BOOKBANK" />
						<a4j:actionparam name="actionType" value="MR" />
						<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
	           		</a4j:commandButton>
					
					<a4j:commandButton id="btnSndPayeeBookbankToMng2" value="Send BookBank Payee To Manager2" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendPayeeBookbankToMNG2}" 
	           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
	           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
	           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px; width:180px;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="SEND_PAYEE_BOOKBANK_TO_MANAGER2" />
						<a4j:actionparam name="reqManager2" value="Y" />
	           		</a4j:commandButton>
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:simpleTogglePanel id="pnlSubBtn"  switchType="client" label="#{jspMsg['header.btn.manager2']}" opened="false" width="100%" rendered="false">
				
				<h:panelGrid>
					<!-- button other -->
					<h:panelGrid columns="11" id="groupResultSubButton1">
						
		           		
						
						<a4j:commandButton id="btnRejectM2Vendor" value="Manager2 Reject Vendor" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnMNG2RejectVendor}" 
		           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
		           	 	reRender="oppContent,txtNavProgram"
		           	 	style="padding-left: 0px;width:125px;"
		           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
			           		<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="initReject" />
							<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_VENDOR" />
							<a4j:actionparam name="actionType" value="M2R" />
							<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
		           		</a4j:commandButton>
		           		
		           		<rich:spacer width="10px"></rich:spacer>
		           		
		           		<a4j:commandButton id="btnApproveM2Bookbank" value="Manager2 Approve Bookbank" styleClass="rich-button"
						action="#{navAction.navi}" 
						rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
						onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						disabled="#{semmmm002Bean.disableBtnMNG2ApproveBookbank}" reRender="txtNavProgram, oppContent"
						style="padding-left: 0px;width:148px;">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
							<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_BOOKBANK" />
							<a4j:actionparam name="actionType" value="M2A" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnRejectM2Bookbank" value="Manager2 Reject Bookbank" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" 
		           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
		           	 	disabled="#{semmmm002Bean.disableBtnMNG2RejectBookbank}" reRender="oppContent,txtNavProgram"
		           	 	style="padding-left: 0px;width:137px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
			           		<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="initReject" />
							<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_BOOKBANK" />
							<a4j:actionparam name="actionType" value="M2R" />
							<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
		           		</a4j:commandButton>
					</h:panelGrid>
					
					<h:panelGrid columns="10" id="groupResultSubButton2">
						
		           		<a4j:commandButton id="btnApproveM2Payee" value="Manager2 Approve Payee" styleClass="rich-button"
						action="#{navAction.navi}"
						rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}" 
						onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						disabled="#{semmmm002Bean.disableBtnMNG2ApprovePayee}" reRender="txtNavProgram, oppContent"
						style="padding-left: 0px; width:130px;">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
							<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_PAYEE" />
							<a4j:actionparam name="actionType" value="M2A" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnRejectM2Payee" value="Manager2 Reject Payee" styleClass="rich-button" 
		           	 	action="#{navAction.navi}"
		           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
		           	 	 disabled="#{semmmm002Bean.disableBtnMNG2RejectPayee}" reRender="oppContent,txtNavProgram"
		           	 	style="padding-left: 0px; width:120px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
			           		<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="initReject" />
							<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_PAYEE" />
							<a4j:actionparam name="actionType" value="M2R" />
							<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
		           		</a4j:commandButton>
		           		
		           		<a4j:commandButton id="btnApproveM2PayeeBookbank" value="Manager2 Approve BookBank Payee" styleClass="rich-button"
						action="#{navAction.navi}" 
						rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
						onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						disabled="#{semmmm002Bean.disableBtnMNG2ApprovePayeeBookbank}" reRender="txtNavProgram, oppContent"
						style="padding-left: 0px; width:180px;">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
							<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_PAYEE_BOOKBANK" />
							<a4j:actionparam name="actionType" value="M2A" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnRejectM2PayeeBookbank" value="Manager2 Reject BookBank Payee" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" 
		           	 	rendered="#{semmmm002Bean.rendererSSO['btnSMBVM001']}"
		           	 	disabled="#{semmmm002Bean.disableBtnMNG2RejectPayeeBookbank}" reRender="oppContent,txtNavProgram"
		           	 	style="padding-left: 0px; width:170px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectDetail')}.show();">
			           		<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
							<a4j:actionparam name="methodWithNavi" value="initReject" />
							<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_PAYEE_BOOKBANK" />
							<a4j:actionparam name="actionType" value="M2R" />
							<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
		           		</a4j:commandButton>
					</h:panelGrid>
				</h:panelGrid>
				
			</rich:simpleTogglePanel>
		</a4j:form>
		
		<!-- result panel -->
		<a4j:form id="frmResultSearch">
			<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
				<f:facet name="header" ><h:outputText value="#{jspMsg['header.result.name']}" style="width:4800px;"/></f:facet>
				
				<center>
				<div align="center">
                	<h:outputLabel style="color:red;size:20px" value="#{semmmm002Bean.msgDataNotFound}" rendered="#{semmmm002Bean.renderedMsgDataNotFound}" />
               	</div>
					
					<rich:dataTable id="dtbResultList" width="100%" 
					cellpadding="0" cellspacing="0" border="0" 
					value="#{semmmm002Bean.vendorMasterResultList}" var="resultObj"
					reRender="dtbResultList" rows="#{semmmm002Bean.rowPerPage}"
					rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
						<rich:column style="" title="">
							<f:facet name="header">
								<h:selectBooleanCheckbox value="#{semmmm002Bean.chkSelAll}" style="width: 20px">
									<a4j:support event="onclick" 
									action="#{semmmm002Action.selectAllRow}" 
									reRender="dtbResultList,btnApproveVendor,btnSndVendorToMng2,btnRejectVendor,btnApproveM2Vendor,btnRejectM2Vendor,
									btnApproveBookbank,btnSndBookbankToMng2,btnRejectBookbank,btnApproveM2Bookbank,btnRejectM2Bookbank,
									btnApprovePayee,btnSndPayeeToMng2,btnRejectPayee,btnApproveM2Payee,btnRejectM2Payee,
									btnApprovePayeeBookbank,btnSndPayeeBookbankToMng2,btnRejectPayeeBookbank,
									btnApproveM2PayeeBookbank,btnRejectM2PayeeBookbank" />
								</h:selectBooleanCheckbox>
							</f:facet>
							
							<div align="center" style="">
								<h:selectBooleanCheckbox id="dtbResultSelected" value="#{resultObj.checkBox}" 
								rendered="#{resultObj.dataObj.renderedCheckbox}">
									<a4j:support event="onclick" action="#{semmmm002Action.selectRow}" 
									reRender="dtbResultList,btnApproveVendor,btnSndVendorToMng2,btnRejectVendor,btnApproveM2Vendor,btnRejectM2Vendor,
									btnApproveBookbank,btnSndBookbankToMng2,btnRejectBookbank,btnApproveM2Bookbank,btnRejectM2Bookbank,
									btnApprovePayee,btnSndPayeeToMng2,btnRejectPayee,btnApproveM2Payee,btnRejectM2Payee,
									btnApprovePayeeBookbank,btnSndPayeeBookbankToMng2,btnRejectPayeeBookbank,
									btnApproveM2PayeeBookbank,btnRejectM2PayeeBookbank" />
								</h:selectBooleanCheckbox>
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.actionType}" rendered="true">
							<f:facet name="header">
								<h:outputText value="Action" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.actionType}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.otherStatus}" rendered="true">
							<f:facet name="header">
								<h:outputText value="Status" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.otherStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.allStatus}" rendered="false">
							<f:facet name="header">
								<h:outputText value="All Status" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.allStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorFlowStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="#{resultObj.dataObj.vendorCode}" sortBy="#{resultObj.dataObj.vendorCode}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<a4j:commandLink id="hlkVendorCode" value="#{resultObj.dataObj.vendorCode}" 
								action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
									<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNavi" value="doForwardFromTodoPage" />
									<a4j:actionparam name="mode" value="Edit" />
									<a4j:actionparam name="headType" value="Vendor" />
									<a4j:actionparam name="contractNoParam" value="#{resultObj.dataObj.contractNo}" />
									<a4j:actionparam name="vendorIdParam" value="#{resultObj.dataObj.vendorId}" />
									<a4j:actionparam name="bookbankIdParam" value="#{resultObj.dataObj.bookbankId}" />
									<a4j:actionparam name="payeeIdParam" value="#{resultObj.dataObj.payeeId}" />
									<a4j:actionparam name="payeeBookbankIdParam" value="#{resultObj.dataObj.payeeBookbankId}" />
									<a4j:actionparam name="actionType" value="#{resultObj.dataObj.actionType}" />
									<a4j:actionparam name="navProgramBack" value="SEMMMM002-1" />
									<a4j:actionparam name="navModuleBack" value="mm" />
									<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNaviBack" value="doBackwardFromTodoPage" />
									<a4j:actionparam name="backOtherPageFlag" value="Y" />
									<a4j:actionparam name="todoManagerFlag" value="Y" />
									<a4j:actionparam name="actionId" value="PAGE_SEARCH_FLOW_VIEW" />
								</a4j:commandLink>
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:150px;">
								<h:outputText value="#{resultObj.dataObj.vendorName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.idCard}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.citizen.id.and.taxid']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.idCard}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.taxId}" rendered="false">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.taxId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBranchNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.branch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorBranchNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractType}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:100px;">
								<h:outputText value="#{resultObj.dataObj.contractType}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{resultObj.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{resultObj.dataObj.viewSiteInfoId}" />
								</a4j:commandLink>
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractOldNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractOldNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.expenseType}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.expenseType}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.networkStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.networkStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractEffectiveDt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contracteffectivedt']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractEffectiveDtStr}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractExpireDt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractexpiredt']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractExpireDtStr}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationId}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.locationId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationCode}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.locationCode}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:120px;">
								<h:outputText value="#{resultObj.dataObj.locationName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBlockStatus}"  rendered="false">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBatch}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="#{resultObj.dataObj.bankName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:150px;">
								<h:outputText value="#{resultObj.dataObj.bankName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.accountNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.accountNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.accountName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:120px;">
								<h:outputText value="#{resultObj.dataObj.accountName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankFlowStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankBatch}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeId}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:120px;">
								<h:outputText value="#{resultObj.dataObj.payeeName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="">
								<h:outputText value="#{resultObj.dataObj.payeeStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeFlowStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBatch}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBankName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:120px;">
								<h:outputText value="#{resultObj.dataObj.payeeBankName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeAccountNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeAccountName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="left" style="width:120px;">
								<h:outputText value="#{resultObj.dataObj.payeeAccountName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankPayeeStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBookbankFlowStatus}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeBookbankFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankPayeeBatch}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankPayeeBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.lotNo}"   rendered="false">
							<f:facet name="header">
								<h:outputText value="Lot No" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.lotNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.remark}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width:580px;"/>
							</f:facet>
							
							<div align="left" style="width:580px;">
								<h:outputText value="#{resultObj.dataObj.remark}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorEffectiveDt}" rendered="false">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:100px;">
								<h:outputText value="#{resultObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<!-- footer -->
						<f:facet name="footer">
							<rich:columnGroup>
								<!-- > 1 -->
								<rich:column colspan="4">
									<h:outputFormat value="#{msg['message.totalRecords']}">
										<f:param value="#{fn:length(semmmm002Bean.vendorMasterResultList)}"></f:param>
									</h:outputFormat>
								</rich:column>
								<!-- > 2 -->
								<rich:column colspan="41">
									<rich:datascroller immediate="true" rendered="true" align="left" for="dtbResultList"
										maxPages="#{semmmm002Bean.rowPerPage}" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" 
										id="dataScrllResultList" style="background-color: #cccccc;"
										page="#{semmmm002Bean.scrollerPage}">
									<a4j:support event="onclick" reRender="dtbResultList"></a4j:support>
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
						<!-- footer -->
						
					</rich:dataTable>
				
				</center>
				
			</rich:panel>
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm002PopupCommon.jsp"/>