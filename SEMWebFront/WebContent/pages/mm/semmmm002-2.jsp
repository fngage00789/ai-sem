<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm002" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel style="width:99%;">
		<f:facet name="header" >
			<h:outputText value="#{jspMsg['header.reject.detail']}"/>
		</f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm002Bean.renderedMsgFormSearch}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		
		
		<!-- result panel -->
		<a4j:form id="frmResultSearch">
			<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.result.name']}" style="width:240%"/>
				</f:facet>
				
				<center>
				<div align="center">
                	<h:outputLabel style="color:red;size:20px" value="#{semmmm002Bean.msgDataNotFound}" rendered="#{semmmm002Bean.renderedMsgDataNotFound}" />
               	</div>
					
					<rich:dataTable id="dtbResultList" width="100%" 
					cellpadding="0" cellspacing="0" border="0" 
					value="#{semmmm002Bean.vendorMasterRejectList}" var="resultObj"
					reRender="dtbResultList" rows="#{semmmm002Bean.rowPerPage}"
					rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
						
						
						<rich:column title="#{resultObj.dataObj.actionType}" sortBy="#{resultObj.dataObj.actionType}" rendered="false">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.actionType']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.actionType}" styleClass="contentform"  />
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
									<a4j:actionparam name="navProgramBack" value="SEMMMM002-2" />
									<a4j:actionparam name="navModuleBack" value="mm" />
									<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNaviBack" value="doBackwardFromTodoPage" />
									<a4j:actionparam name="backOtherPageFlag" value="Y" />
									<a4j:actionparam name="todoManagerFlag" value="Y" />
								</a4j:commandLink>
							</div>
						</rich:column>
						
						<rich:column title="#{resultObj.dataObj.vendorName}" sortBy="#{resultObj.dataObj.vendorName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.vendorName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.idCard}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.taxId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractType}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.contractOldNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.expenseType}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.locationId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.locationCode}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.locationName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorBlock}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.bankName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.accountNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.accountName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeId}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.payeeName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.payeeBankName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center" style="width:200px;text-align:left;">
								<h:outputText value="#{resultObj.dataObj.payeeAccountName}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeBookbankStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeBookbankFlowStatus}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendor.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.vendorBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.payee.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.payeeBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.bookbank.payee.batch']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.bookbankPayeeBatch}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="" sortBy="">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
								<h:outputText value="#{resultObj.dataObj.remark}" styleClass="contentform"  />
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
								<rich:column colspan="30">
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
	
		
		<!-- criteria panel -->
		<a4j:form id="frmCriteriaSearch">
			
		
			<!-- div style="clear:both; height:10px;"></div -->
			<h:panelGrid style="width:100%;">
				<!-- button other -->
				<h:panelGrid style="width:100%;margin: 0 auto;vertical-align:top;" columns="2">
					
					<h:panelGroup styleClass="ms7" style="vertical-align:top;">
						<h:graphicImage style="vertical-align:top;" value="images/icon_required.gif"/>
						
						<rich:spacer style="vertical-align:top;" width="5"></rich:spacer>
						
						<h:outputLabel styleClass="ms7" value="Remark :" style="vertical-align:top;"></h:outputLabel>
						
						<rich:spacer style="vertical-align:top;" width="5"></rich:spacer>
						<h:inputTextarea label="Remark" id="mmm002_rejectRemark" value="#{semmmm002Bean.rejectRemark}" rows="5" cols="100" style="width:90%;" styleClass="ms7">
					</h:inputTextarea>
					</h:panelGroup>
						
							
					
					
				</h:panelGrid>
				<h:panelGrid columns="6" id="groupResultButton" style="margin: 0 auto;">
					
						<a4j:commandButton id="doCancelBtn" value="Cancel" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendToMNG2}" reRender="txtNavProgram, oppContent"
		           	 	style="margin: 0 auto;" rendered="#{semmmm002Bean.renderedTodoRejectButton == 'false'}">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
		           		</a4j:commandButton>
		           		
		           		<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnReject}" reRender="txtNavProgram, oppContent"
		           	 	style="margin: 0 auto;" rendered="#{semmmm002Bean.renderedTodoRejectButton == 'false'}"
		           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doReject" />
						<a4j:actionparam name="btnEvent" value="N" />
						<a4j:actionparam name="actionBtnType" value="MR" />
		           		</a4j:commandButton>
		           		
		           		<a4j:commandButton id="doCancelBtnTodo" value="CancelT" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendToMNG2}" reRender="txtNavProgram, oppContent"
		           	 	style="margin: 0 auto;" rendered="#{semmmm002Bean.renderedTodoRejectButton}">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doSearchTree" />
		           		</a4j:commandButton>
		           		
		           		<a4j:commandButton id="btnRejectTodo" value="RejectT" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnReject}" reRender="txtNavProgram, oppContent"
		           	 	style="margin: 0 auto;" rendered="#{semmmm002Bean.renderedTodoRejectButton}"
		           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
		           		<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doReject" />
						<a4j:actionparam name="btnEvent" value="N" />
		           		</a4j:commandButton>
					
				</h:panelGrid>
			</h:panelGrid>
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>