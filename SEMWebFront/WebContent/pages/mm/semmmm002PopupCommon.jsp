
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.mm.semmmm002" var="jspMsg" />

<!-- =================================================================================== -->
<!-- =================================================================================== -->
	
	<!-- >> [POPUP_01] -->
	<!-- mmm002PopUpCommon_convertVendorCode -->
	<rich:modalPanel id="mmm002PopUpCommon_convertVendorCode" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm002PopUpCommon_convertVendorCode" style="cursor:pointer" />
					<rich:componentControl for="mmm002PopUpCommon_convertVendorCode" attachTo="hide-mmm002PopUpCommon_convertVendorCode" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm002PopUpCommon_ConvertVendorCode">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['header.criteria.name']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmmm002Bean.vendorInfo.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmmm002Bean.vendorInfo.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmmm002Action.doSearchPopupConvertVendor}"
					reRender="frmMmm002PopUpCommon_ConvertVendorCode, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmmm002Action.initConvertVendor}"
					reRender="frmMmm002PopUpCommon_ConvertVendorCode, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['header.result.name']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmmm002Bean.convertVendorResultList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="7" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmmm002Action.doSelectConvertVendor}"
											reRender="searchVendorCode">
												<a4j:actionparam name="vendorCodeParam" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="vendorNameParam" value="#{vendorLst.dataObj.vendorName}" />
												
												<rich:componentControl for="mmm002PopUpCommon_convertVendorCode" operation="hide" event="onclick" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code (New)" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mmm001_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code (Old)" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mmm001_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mmm001_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mmm001_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm002Bean.convertVendorResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmmm002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmmm002Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMmm002PopUpCommon_ConvertVendorCode"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mmm002PopUpCommon_convertVendorCode" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm002PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_01] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_02] -->
	<!-- mmm002PopUpCommon_RejectDetail -->
	<rich:modalPanel id="mmm002PopUpCommon_RejectDetail" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.reject.detail']}"/>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm002PopUpCommon_RejectDetail" style="cursor:pointer" />
					<rich:componentControl for="mmm002PopUpCommon_RejectDetail" attachTo="hide-mmm002PopUpCommon_RejectDetail" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm002PopUpCommon_RejectDetail">
		
		
			
			<div style="clear:both; height:10px;"></div>

			
			
			<!-- >> group result -->
			<rich:panel id="pnlRejectDetail" styleClass="sem_autoScrollbar" >
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['header.result.name']}" style="width:4000px;"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
						<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
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
											<a4j:actionparam name="navProgramBack" value="#{semmmm002Bean.navProgramBack}" />
											<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
											<a4j:actionparam name="navModuleBack" value="mm" />
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
						</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
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
				
						
					<a4j:commandButton id="btn" value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mmm002PopUpCommon_RejectDetail" operation="hide" event="onclick" />
					</a4j:commandButton>
					
		           		
		           	<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button" 
		           	 action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
		           	 style="margin: 0 auto;" 
		           	 onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
			           		
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-1" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="#{semmmm002Bean.actionBtnType}" />
						<a4j:actionparam name="actionType" value="#{semmmm002Bean.actionType}" />
						<rich:componentControl for="mmm002PopUpCommon_RejectDetail" operation="hide" event="onclick" />
		           	</a4j:commandButton>
		           		
				</h:panelGrid>
			</h:panelGrid>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm002PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_02] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_03] -->
	<!-- mmm002PopUpCommon_confirm -->
	<rich:modalPanel id="mmm002PopUpCommon_controllerBtnSave" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Popup Confirm"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_controllerBtnSave" style="cursor:pointer" />
					<rich:componentControl for="mmm002PopUpCommon_controllerBtnSave" attachTo="hide-mmm001PopUpCommon_controllerBtnSave" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm002PopUpCommon_confirm">
		
			<rich:panel id="pnlconfirm">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		<h:graphicImage value="images/error.gif"  rendered="#{semmmm002Bean.renderedBtnCloseVendor}"/>
			                		<rich:spacer width="15px"></rich:spacer>
			                		<h:outputText value="#{semmmm002Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm002Bean.renderedMsgPopupSave}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmmm002Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm002Bean.renderedMsgPopupSave == false}" styleClass="ms7"></h:outputText>
			         			</td>
			         		</tr>
			         	</table>
			         </h:panelGroup>
                    
                </h:panelGrid>          	
			
				<div style="clear:both; height:10px;"></div>
	
				<!-- >> button search/clear -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									<a4j:commandButton value="#{semmmm002Bean.retResultObj.closeBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm002Bean.renderedBtnCloseVendor}" >
								    	<rich:componentControl for="mmm002PopUpCommon_controllerBtnSave" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:commandButton value="#{semmmm002Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm002PopUpCommon_controllerBtnSave"
									rendered="#{semmmm002Bean.renderedBtnOKVendor}" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm002Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm002Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="actionBtnType" value="#{semmmm002Bean.retResultObj.actionBtnType}" />
										<a4j:actionparam name="actionType" value="MA" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm002Bean.renderedBtnOKVendor}" />
									
									<a4j:commandButton value="#{semmmm002Bean.retResultObj.yesBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm002PopUpCommon_controllerBtnSave"
									rendered="#{semmmm002Bean.renderedBtnYesVendor}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm002Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm002Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="Y" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm002Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="actionBtnType" value="#{semmmm002Bean.retResultObj.actionBtnType}" />
										<a4j:actionparam name="actionType" value="MA" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm002Bean.renderedBtnYesVendor}" />
									
									<a4j:commandButton value="#{semmmm002Bean.retResultObj.noBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm002PopUpCommon_controllerBtnSave"
									rendered="#{semmmm002Bean.renderedBtnNoVendor}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm002Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm002Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="N" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm002Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="actionBtnType" value="#{semmmm002Bean.retResultObj.actionBtnType}" />
										<a4j:actionparam name="actionType" value="MA" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm002Bean.renderedBtnNoVendor}"/>
									
									<a4j:commandButton value="#{semmmm002Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm002Bean.renderedBtnCencelVendor}" >
								    	<rich:componentControl for="mmm002PopUpCommon_controllerBtnSave" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button search/clear -->
			</rich:panel>
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm002PopUpCommon_confirm -->
	<!-- << [POPUP_03] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->


<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_04] -->
	<!-- mmm002PopUpCommon_RejectTodolist -->
	<rich:modalPanel id="mmm002PopUpCommon_RejectTodolist" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.reject.detail']}"/>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm002PopUpCommon_RejectTodolist" style="cursor:pointer" />
					<rich:componentControl for="mmm002PopUpCommon_RejectTodolist" attachTo="hide-mmm002PopUpCommon_RejectTodolist" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm002PopUpCommon_RejectTodolist">
		
		
			
			<div style="clear:both; height:10px;"></div>

			
			
			<!-- >> group result -->
			<rich:panel id="pnlRejectTodolist" styleClass="sem_autoScrollbar" >
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['header.result.name']}" style="width:4000px;"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
						<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
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
											<a4j:actionparam name="navProgramBack" value="#{semmmm002Bean.navProgramBack}" />
											<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
											<a4j:actionparam name="navModuleBack" value="mm" />
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
						</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
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
				
						
					<a4j:commandButton id="btn" value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mmm002PopUpCommon_RejectTodolist" operation="hide" event="onclick" />
					</a4j:commandButton>
					
		           		
		           	<a4j:commandButton id="btnRejectTodo" value="Reject" styleClass="rich-button" 
		           	 action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
		           	 style="margin: 0 auto;" 
		           	 onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
			           		
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
						<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
						<a4j:actionparam name="actionBtnType" value="#{semmmm002Bean.actionBtnType}" />
						<a4j:actionparam name="actionType" value="#{semmmm002Bean.actionType}" />
						<rich:componentControl for="mmm002PopUpCommon_RejectTodolist" operation="hide" event="onclick" />
		           	</a4j:commandButton>
		           		
				</h:panelGrid>
			</h:panelGrid>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm002PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_04] -->
