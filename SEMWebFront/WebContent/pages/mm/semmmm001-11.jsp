<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.master.sap.name']}"/></f:facet>	
	
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
		
		<a4j:form id="frmBookbankInfo">
			<rich:spacer rendered="#{semmmm001Bean.visiblePnlContractInfo}" />
			
			<!-- group[3] >> -->
			<h:panelGrid id="bankInfoSap" width="98%" style="border:solid 1px gray;">
				<!-- button bankInfo -->
				

				<!-- bank info panel >> -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.bank.info']} (#{jspMsg['header.vendor.sap']})"/></f:facet>
					
					<!-- bank info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bankInfoAccountType" value="#{semmmm001Bean.bookbankSapInfo.accountType}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="">
		                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.code']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoBankCode" value="#{semmmm001Bean.bookbankSapInfo.bankCode}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;">
		                					<f:selectItems value="#{semmmm001Bean.bankList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoBankName" value="#{semmmm001Bean.bookbankSapInfo.bankName}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoBankBranch" value="#{semmmm001Bean.bookbankSapInfo.bankBranch}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoProvince" value="#{semmmm001Bean.bookbankSapInfo.province}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;">
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
										<h:inputText id="bankInfoAccountNo" value="#{semmmm001Bean.bookbankSapInfo.accountNo}" 
										disabled="#{semmmm001Bean.disableContent}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoAccountName" value="#{semmmm001Bean.bookbankSapInfo.accountName}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoRemark" value="#{semmmm001Bean.bookbankSapInfo.remark}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Active Status"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoActiveStatus" value="#{semmmm001Bean.bookbankSapInfo.activeStatus}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="">
		                					<f:selectItem itemLabel="-- Select --" itemValue=""/>
		                					<f:selectItem itemLabel="Yes" itemValue="Y"/>
		                					<f:selectItem itemLabel="No" itemValue="N"/>
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
			
				<!-- bank info panel (compare content) >> -->
				
				</rich:panel>
				<!-- bank info panel << -->
			</h:panelGrid>
			
			<rich:spacer height="5px"></rich:spacer>
			
			<h:panelGrid id="bankInfoSEM" width="98%">
			<rich:panel id="bookbankInfo_compareContent" >
					<f:facet name="header"><h:outputText value="#{jspMsg['header.bank.info']} (#{jspMsg['header.vendor.sem']})"/></f:facet>
					
					<!-- bank info -->
					<h:panelGrid width="98%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bankInfoCmpAccountType" value="#{semmmm001Bean.bookbankSemInfo.accountType}" 
										disabled="#{semmmm001Bean.viewMode}" style="">
		                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.code']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpBankCode" value="#{semmmm001Bean.bookbankSemInfo.bankCode}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;">
		                					<f:selectItems value="#{semmmm001Bean.bankList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoCmpBankName" value="#{semmmm001Bean.bookbankSemInfo.bankName}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoCmpBankBranch" value="#{semmmm001Bean.bookbankSemInfo.bankBranch}" 
										disabled="#{semmmm001Bean.viewMode}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpProvince" value="#{semmmm001Bean.bookbankSemInfo.province}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;">
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
										<h:inputText id="bankInfoCmpAccountNo" value="#{semmmm001Bean.bookbankSemInfo.accountNo}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoCmpAccountName" value="#{semmmm001Bean.bookbankSemInfo.accountName}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoCmpRemark" value="#{semmmm001Bean.bookbankSemInfo.remark}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Active Status"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpActiveStatus" value="#{semmmm001Bean.bookbankSemInfo.activeStatus}" 
										disabled="#{semmmm001Bean.viewMode}" style="">
		                					<f:selectItem itemLabel="-- Select --" itemValue=""/>
		                					<f:selectItem itemLabel="Yes" itemValue="Y"/>
		                					<f:selectItem itemLabel="No" itemValue="N"/>
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					
						
						<!-- button bank info -->
					<h:panelGrid id="groupBookbankHistoryButton" width="100%">
						<h:panelGroup>
							<table width="98%">
								<tr>
									<td style="width:50%; text-align:left;"> 
										<a4j:commandButton id="btnCopySapToSem" value="#{jspMsg['btn.label.copysap']}" 
										styleClass="rich-button" rendered="#{semmmm001Bean.viewMode eq 'false'}"
										action="#{navAction.navi}" reRender="frmBookbankInfo,btnSaveBankInfo" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-11" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doCopySapToSem" />
											<a4j:actionparam name="actionParam" value="VB" />
										</a4j:commandButton>
									</td>
									<td style="width:50%; text-align:right;">
										<a4j:commandButton id="btnBookbankHistory" 
										value="Bookbank History" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnHistory}" 
										reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doBookbankHistory" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</h:panelGrid>	
				</rich:panel>
				</h:panelGrid>	
				
				<!-- button bank info -->
				<h:panelGrid id="groupBookbankInfoButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:100%;">
									<a4j:commandButton id="btnSaveBankInfo" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSaveBookbank}" 
									rendered="#{semmmm001Bean.viewMode eq 'false'}"
									onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 	reRender="oppContent,txtNavProgram" oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-11" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSaveChangeBookbankInfo" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnBackBankInfo" value="#{jspMsg['btn.back']}" styleClass="rich-button"
									rendered="#{semmmm001Bean.viewMode eq 'false'}"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									</a4j:commandButton>
									<a4j:commandButton id="btnBackManagerTodo" value="#{jspMsg['btn.back']}T" styleClass="rich-button"
									rendered="#{semmmm001Bean.viewMode}"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			
			<rich:spacer />
			
			<!-- group[5] >> -->
			<h:panelGrid id="contractInfo" width="98%" style="border:solid 1px gray;">
				<!-- contact list panel >> -->
				<rich:panel styleClass="sem_autoScrollbar">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.list']}"/></f:facet>
					
					<center>
					
						
						<rich:dataTable id="dtbContractList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractList}" var="contractObj"
						reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.view']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="">
									<h:outputText value="view" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
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
									<rich:column colspan="9">
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
					
					</center>
				</rich:panel>
				<!-- contract list panel << -->
			</h:panelGrid>
			<!-- group[5] << -->
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>
<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>