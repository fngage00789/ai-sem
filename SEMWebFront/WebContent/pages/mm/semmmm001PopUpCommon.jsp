
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
	<!-- mmm001PopUpCommon_retStatus -->
	<rich:modalPanel id="mmm001PopUpCommon_retStatus" autosized="true" rendered="#{semmmm001Bean.renderedResultMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_retStatus" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_retStatus" attachTo="hide-mmm001PopUpCommon_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="300">
				<!-- /// -->
				<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" styleClass="ms7"/>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					
					<a4j:commandButton id="btnNormal" value="Ok" styleClass="rich-button" immediate="true" >
					    <rich:componentControl for="mmm001PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
					
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_retStatus -->
	<!-- << [POPUP_01] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_02] -->
	<!-- mmm001PopUpCommon_exportBatchRetResult -->
	<rich:modalPanel id="mmm001PopUpCommon_exportBatchRetResult" autosized="true" rendered="#{semmmm001Bean.renderedExportBatchResultAlert}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Export Result Return"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_exportBatchRetResult" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_exportBatchRetResult" attachTo="hide-mmm001PopUpCommon_exportBatchRetResult" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmExportBatchRetResultDialog">
			<div id="tabResult" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 

				<rich:dataTable id="dtbExportBatchResultList" width="100%" 
				cellpadding="0" cellspacing="0" border="0" 
				value="#{semmmm001Bean.exportBatchResultList}" var="exportBatchResultObj"
				reRender="dtbExportBatchResultList" rows="#{semmmm001Bean.rowPerPage}"
				rowClasses="cur" styleClass="contentform" rowKeyVar="row">
					
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.vendorCode}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.action.type']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.actionType}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.vendorName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.idCard}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.taxId}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.contractType}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.contractNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.contractOldNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.expenseType}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.locationId}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.locationCode}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.locationName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.vendorStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.bankName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.accountNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.accountName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeId}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeBankName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.payeeAccountName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{exportBatchResultObj.dataObj.remark}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<!-- footer -->
					<f:facet name="footer">
						<rich:columnGroup>
							<!-- > 1 -->
							<rich:column colspan="4">
								<h:outputFormat value="#{msg['message.totalRecords']}">
									<f:param value="#{fn:length(semmmm001Bean.exportBatchResultList)}"></f:param>
								</h:outputFormat>
							</rich:column>
							<!-- > 2 -->
							<rich:column colspan="22">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbExportBatchResultList"
									maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="auto" boundaryControls="auto" 
									id="dataScrllResultList" style="background-color: #cccccc;"
									page="#{semmmm001Bean.scrollerPage}">
								<a4j:support event="onclick" reRender="dtbExportBatchResultList"></a4j:support>
								</rich:datascroller>
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<!-- footer -->
					
				</rich:dataTable>
			</div>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right; padding-top:5px;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton id="btnNormal" value="Ok" styleClass="rich-button" immediate="true" >
					    <rich:componentControl for="mmm001PopUpCommon_exportBatchRetResult" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_exportBatchRetResult -->
	<!-- << [POPUP_02] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	<!-- mmm001PopUpCommon_semSapVedorInfoList -->
	<rich:modalPanel id="mmm001PopUpCommon_semSapVedorInfoList" autosized="true" rendered="#{semmmm001Bean.renderedPopupSAPVendorInfo}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Vendor Info List"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_semSapVedorInfoList" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_semSapVedorInfoList" attachTo="hide-mmm001PopUpCommon_semSapVedorInfoList" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmSemSapVendorInfoDialog">
			<div id="tabResult" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 

				<rich:dataTable id="dtbSemSapVendorInfoList" width="100%" 
				cellpadding="0" cellspacing="0" border="0" 
				value="#{semmmm001Bean.popupSAPVendorlist}" var="semSapVendorObj"
				reRender="dtbSemSapVendorInfoList" rows="10"
				rowClasses="cur" styleClass="contentform" rowKeyVar="row">
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="Select" styleClass="contentform"/>
						</f:facet>
						<div align="center">
							<!-- SAP >> -->
							<a4j:commandLink id="hlkVendorSAPSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPVendorInfo == 'true'}">
								<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNavi" value="doViewVendorSAPInfo" />
									<a4j:actionparam name="rowIdParam" value="#{semSapVendorObj.dataObj.rowId}" />
									<a4j:actionparam name="actionId" value="CHECK_VENDOR" />
							</a4j:commandLink>
							
							<!-- SEM mode 'NEW' + 'EDIT' >> -->
							<a4j:commandLink id="hlkVendorSEMSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPVendorInfo == 'false' and semmmm001Bean.vendorInfo.saveFlag != 'C'}">
								<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNavi" value="doSelectVendor" />
									<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
									<a4j:actionparam name="vendorIdParam" value="#{semSapVendorObj.dataObj.vendorId}" />
									<a4j:actionparam name="actionId" value="CHECK_VENDOR" />
							</a4j:commandLink>
							<!-- SEM mode 'CHANGE' >> -->
							<a4j:commandLink id="hlkVendorSEMSelectedModeChange" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPVendorInfo == 'false' and semmmm001Bean.vendorInfo.saveFlag == 'C'}">
								<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
									<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorIdModeChange" />
									<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
									<a4j:actionparam name="vendorIdParam" value="#{semSapVendorObj.dataObj.vendorId}" />
									<a4j:actionparam name="actionId" value="CHECK_VENDOR" />
							</a4j:commandLink>
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.blockstatus']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.blackliststatus']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.vendorBlackListStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.sap.role']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.role}" styleClass="contentform"  />
						</div>
					</rich:column>
						
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.vendorId}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.vendorCode}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:150px;">
							<h:outputText value="#{semSapVendorObj.dataObj.vendorName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.idCard}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapVendorObj.dataObj.taxId}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.branch.no']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center" style="width:80px;">
							<h:outputText value="#{semSapVendorObj.dataObj.branchNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.address']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:150px;">
							<h:outputText value="#{semSapVendorObj.dataObj.address}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.tambol']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapVendorObj.dataObj.tambolName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.amphur']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapVendorObj.dataObj.amphurName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapVendorObj.dataObj.provinceName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.post.code']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center" style="">
							<h:outputText value="#{semSapVendorObj.dataObj.postCode}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center" style="">
							<h:outputText value="#{semSapVendorObj.dataObj.regionName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<!-- footer -->
					<f:facet name="footer">
						<rich:columnGroup>
							<!-- > 1 -->
							<rich:column colspan="4">
								<h:outputFormat value="#{msg['message.totalRecords']}">
									<f:param value="#{fn:length(semmmm001Bean.popupSAPVendorlist)}"></f:param>
								</h:outputFormat>
							</rich:column>
							<!-- > 2 -->
							<rich:column colspan="9">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSemSapVendorInfoList"
									maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="auto" boundaryControls="auto" 
									id="dataScrllResultList" style="background-color: #cccccc;"
									page="#{semmmm001Bean.scrollerPage}">
								<a4j:support event="onclick" reRender="dtbSemSapVendorInfoList"></a4j:support>
								</rich:datascroller>
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<!-- footer -->
					
				</rich:dataTable>
			</div>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right; padding-top:5px;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" immediate="true" >
					    <rich:componentControl for="mmm001PopUpCommon_semSapVedorInfoList" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_semSapVedorInfoList -->
	<!-- << [POPUP_03] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_04] -->
	<!-- mmm001PopUpCommon_semSapBookbankList -->
	<rich:modalPanel id="mmm001PopUpCommon_semSapBookbankList" autosized="true" 
	rendered="#{semmmm001Bean.renderedPopupSAPBookbankInfo}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Bookbank Info List"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_semSapBookbankList" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_semSapBookbankList" attachTo="hide-mmm001PopUpCommon_semSapBookbankList" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmSemSapBookbankDialog">
			<div id="tabResult" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 

				<rich:dataTable id="dtbSemSapBookbankList" width="100%" 
				cellpadding="0" cellspacing="0" border="0" 
				value="#{semmmm001Bean.semSapBookbankList}" var="semSapBookbankObj"
				reRender="dtbSemSapBookbankList" rows="#{semmmm001Bean.rowPerPage}"
				rowClasses="cur" styleClass="contentform" rowKeyVar="row">
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="Select" styleClass="contentform"/>
						</f:facet>
						<div align="center">
							<!-- SAP >> -->
							<a4j:commandLink id="hlkBookbankSAPSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPBookbankInfo == 'true' 
							and semmmm001Bean.pageParam == 'BOOKBANK'}">
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
								<a4j:actionparam name="methodWithNavi" value="doViewBookbankSAPInfo" />
								<a4j:actionparam name="rowIdParam" value="#{semSapBookbankObj.dataObj.rowId}" />
							</a4j:commandLink>
							<a4j:commandLink id="hlkBookbankPayeeSAPSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPBookbankInfo == 'true' 
							and semmmm001Bean.pageParam == 'BOOKBANK_PAYEE'}">
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
								<a4j:actionparam name="methodWithNavi" value="doViewBBPayeeSAPInfo" />
								<a4j:actionparam name="rowIdParam" value="#{semSapBookbankObj.dataObj.rowId}" />
							</a4j:commandLink>
							
							<!-- SEM >> -->
							<a4j:commandLink id="hlkBookbankSEMSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPBookbankInfo == 'false' 
							and semmmm001Bean.pageParam == 'BOOKBANK'}">
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
								<a4j:actionparam name="methodWithNavi" value="doViewBookbankByVendorBookbankId" />
								<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
								<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
								<a4j:actionparam name="vendorBookbankIdParam" value="#{semSapBookbankObj.dataObj.vendorBookbankId}" />
							</a4j:commandLink>
							<a4j:commandLink id="hlkBookbankPayeeSEMSelected" value="select"
							action="#{navAction.navi}" reRender="oppContent" 
							rendered="#{semmmm001Bean.renderedBtnSAPBookbankInfo == 'false' 
							and semmmm001Bean.pageParam == 'BOOKBANK_PAYEE'}">
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
								<a4j:actionparam name="methodWithNavi" value="doGetBBPayeeDetail" />
								<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
								<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
								<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
								<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.vendorMapPayeeId}" />
								<a4j:actionparam name="bookbankPayeeIdParam" value="#{semSapBookbankObj.dataObj.vendorBookbankId}" />
							</a4j:commandLink>
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapBookbankObj.dataObj.accountName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapBookbankObj.dataObj.accountNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapBookbankObj.dataObj.accountType}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapBookbankObj.dataObj.bankCode}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:150px;">
							<h:outputText value="#{semSapBookbankObj.dataObj.bankName}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapBookbankObj.dataObj.bankBranch}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:100px;">
							<h:outputText value="#{semSapBookbankObj.dataObj.province}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="left" style="width:120px;">
							<h:outputText value="#{semSapBookbankObj.dataObj.remark}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapBookbankObj.dataObj.bookbankStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<rich:column style="" title="">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
						</f:facet>
						
						<div align="center">
							<h:outputText value="#{semSapBookbankObj.dataObj.activeStatus}" styleClass="contentform"  />
						</div>
					</rich:column>
					
					<!-- footer -->
					<f:facet name="footer">
						<rich:columnGroup>
							<!-- > 1 -->
							<rich:column colspan="4">
								<h:outputFormat value="#{msg['message.totalRecords']}">
									<f:param value="#{fn:length(semmmm001Bean.semSapBookbankList)}"></f:param>
								</h:outputFormat>
							</rich:column>
							<!-- > 2 -->
							<rich:column colspan="7">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSemSapBookbankList"
									maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="auto" boundaryControls="auto" 
									id="dataScrllSemSapBookbankList" style="background-color: #cccccc;"
									page="#{semmmm001Bean.scrollerPage}">
								<a4j:support event="onclick" reRender="dtbSemSapBookbankList"></a4j:support>
								</rich:datascroller>
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<!-- footer -->
					
				</rich:dataTable>
			</div>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right; padding-top:5px;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" immediate="true" >
					    <rich:componentControl for="mmm001PopUpCommon_semSapBookbankList" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_semSapBookbankList -->
	<!-- << [POPUP_04] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->		

	<!-- >> [POPUP_05] -->
	<!-- mmm001PopUpCommon_askForNewContract -->
	<rich:modalPanel id="mmm001PopUpCommon_askForNewContract" autosized="true" 
	rendered="#{semmmm001Bean.renderedAskForNewContract}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.process_confirm']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_askForNewContract" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_askForNewContract" attachTo="hide-mmm001PopUpCommon_askForNewContract" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmAskForNewContractDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="300">
				<!-- /// -->
				<h:outputText value="#{jspMsg['label.ask.for.new.contract']}"/>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton id="btnOk" value="Ok" styleClass="rich-button" immediate="true"
					action="#{navAction.navi}" reRender="oppContent">
					    
					    <a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
						<a4j:actionparam name="methodWithNavi" value="doNewVendor" />
						<a4j:actionparam name="contractNoParam" value="" />
						<a4j:actionparam name="vendorIdParam" value="" />
						
						<rich:componentControl for="mmm001PopUpCommon_askForNewContract" operation="hide" event="onclick" />
					</a4j:commandButton>
					<rich:spacer width="5"></rich:spacer>
					<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mmm001PopUpCommon_askForNewContract" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_askForNewContract -->
	<!-- << [POPUP_05] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- mmm001PopUpCommon_Select Bank -->
	<!-- << [POPUP_06] -->
	<rich:modalPanel id="popupFrmSelectBank" width="700"  height="550" style="overflow:auto;">
			<f:facet name="header"><h:outputText value="Popup Select Bank"/></f:facet>
			<f:facet name="controls">
				<h:panelGroup>
					<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopUpSelBank" style="cursor:pointer"/>
					<rich:componentControl for="popupFrmSelectBank" attachTo="hidePopUpSelBank" operation="hide" event="onclick" />
					</div>
				</h:panelGroup>
			</f:facet>
			<a4j:form id="frmSelectBank">
			<h:panelGrid columnClasses="gridContent" width="100%">
					<!-- begin content layout criteria -->
						<rich:panel id="panSearchCriteria">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.criteria.name']}"/>
							</f:facet>
							<!-- begin content criteria -->
							<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
								<table width="100%" border="0">
									<tr valign="baseline">
										<td align="right" width="20%">
										<h:outputText value="Bank Code :" styleClass="ms7"/>
			                			</td>
			                			<td width="30%" >
			                			<h:inputText id="txtBankCode" value="#{semmmm001Bean.criteriaBank.bankCode}"
			                			 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
					                	</td>
					                	<td align="right" width="20%">
										<h:outputText value="Bank Name :" styleClass="ms7"/>
			                			</td>
			                			<td width="30%" >
			                			<h:inputText id="txtBankName" value="#{semmmm001Bean.criteriaBank.bankName}"/>
					                	</td>
				                	 </tr>
				                	  
				                	  <tr>
										<td align="right">
										<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
											reRender="frmError,pnlSearchResult" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navPrograme}" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doSearchBankCode" />
										</a4j:commandButton>
										</td>
			                			<td>
							            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
							            	 	action="#{navAction.navi}" reRender="txtBankCode,txtBankName">
							            		<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navPrograme}" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="doClearSearchBankCriteria" />
							            	</a4j:commandButton>
			                			</td>
			                			<td colspan="2">
			                			</td>
				                    </tr>
								</table>
								</h:panelGroup>
							</h:panelGrid>
							<!-- end content criteria -->
						</rich:panel>
					</h:panelGrid>
					
					<!-- begin content layout criteria -->
					<h:panelGrid width="100%">
						<rich:panel id="pnlSearchResult">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['label.header.selectbank']}"/>
							</f:facet>
							<div align="center">
								<h:outputLabel style="color:red;size:20px" value="#{semmmm001Bean.msgDataNotFound}" rendered="#{semmmm001Bean.renderedMsgDataNotFound}" />
							</div>
							<!-- begin content criteria -->
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<rich:dataTable width="100%" id="dtbBankSel" cellpadding="1" cellspacing="0" border="0"
								var="bankSel" value="#{semmmm001Bean.bankSelList}" 
								rows="10"
								rowClasses="cur" 
								styleClass="dataTable" >
								
								<rich:column style="width:18" styleClass="#{(semmmm001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}" width="5%">
									<f:facet name="header">
									</f:facet>
									<div align="center">
										<sem:radioButton id="rdBtSel"
						  							 name="rdCol"
						  							 overrideName="true"
						  							 value="#{semmmm001Bean.selectedRadio}"
						  							 itemValue="#{bankSel.bankCode}"/>
									</div>
								</rich:column>
															
								<rich:column  style="width: 90" sortBy="#{bankSel.bankCode}" styleClass="#{(semmmm001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="Bank Code" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankSel.bankCode}" styleClass="contentform"/>
									</div>
								</rich:column>
								<rich:column style="width:240" sortBy="#{bankSel.bankName}" styleClass="#{(semmmm001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="Bank Name" styleClass="contentform" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankSel.bankName}" styleClass="contentform"/>
									</div>
								</rich:column>
								<rich:column  sortBy="#{bankSel.bankBranch}" styleClass="#{(semmmm001Bean.tmpRowId==bankSel.rowId)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="Bank Branch" styleClass="contentform" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankSel.bankBranch}" styleClass="contentform"  />
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.bankSelList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="3">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBankSel"
												maxPages="10"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstVendorSel" 
												style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>					
								</f:facet>
								
							</rich:dataTable>
									
							</h:panelGroup>
							</h:panelGrid>
							<!-- end content criteria -->
							<h:panelGrid columns="3" id="grdSearchCommand">
								<a4j:commandButton id="btnSelectVendorBookBank" value="Select" styleClass="rich-button"
								action="#{navAction.navi}" reRender="oppContent, frmSave, bookbankpayeeInfoPanel, 
								bookbankPayeeInfoBankCode, bookbankPayeeInfoBankName, bookbankPayeeInfoBankBranch,
								bookbankPayeeInfoProvince">
									<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navPrograme}" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doSelectBank" />
									<rich:componentControl for="popupFrmSelectBank" operation="hide" event="onclick" />
								</a4j:commandButton>
								
								<a4j:commandButton id="btnCancelVendorBookBank" value="Cancel" styleClass="rich-button" immediate="true">
									<rich:componentControl for="popupFrmSelectBank" operation="hide" event="onclick" />
								</a4j:commandButton>
				           		
							</h:panelGrid>
						</rich:panel>
					</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>
	
	<!-- mmm001PopUpCommon_Select Bank -->
	<!-- << [POPUP_06] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->
	<!-- mmm001PopUpCommon_new Bank -->
	<!-- << [POPUP_07] -->

	<!-- popupNewOrUpdateBankMaster -->
	<rich:modalPanel id="panel_popupNewOrUpdateBankMaster" width="800" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Bank Master"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-panel_popupNewOrUpdateBankMaster" style="cursor:pointer" />
					<rich:componentControl for="panel_popupNewOrUpdateBankMaster" attachTo="hide-panel_popupNewOrUpdateBankMaster" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid>
			<a4j:form id="frmError-newOrUpdateBankMasterForm">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedDailog}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="newOrUpdateBankMasterForm"> 
			<rich:panel id="panel_newOrUpdateBankMaster">
				<center>
				<h:panelGrid width="90%">
				<h:panelGroup>
					<table  style="width:100%;">
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankCode']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:10%;" colspan="3" align="left">
								<a4j:region> 
									<h:selectOneMenu id="dlgTxtBankGroupCode" value="#{semmmm001Bean.itemBankMasterSP}" 
										disabled="#{semmmm001Bean.disbledDialogField}"
										converter="bankMasterSPConverter"> 
                                        <f:selectItems value="#{semmmm001Bean.bankSelectionSearchList}"/>
                                        <a4j:support event="onchange" action="#{semmmm001Action.doSemiLiveSearch}" reRender="dlgTxtBankName,  dlgTxtBankBranchCode, dlgTxtBankBranch, dlgSlctProvinceList,   chkForEdit">
											<a4j:actionparam name="methodWithNavi" value="doSemiLiveSearch" />
											<a4j:actionparam name="paramLiveMode" value="GROUP_CODE" />
										</a4j:support>
                                    </h:selectOneMenu>  
								</a4j:region>
							</td>
						</tr>
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankBranchCode']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:10%;">
					            <a4j:region> 
					            	<h:inputText id="dlgTxtBankBranchCode" value="#{semmmm001Bean.itemBankMasterSP.bankBranchCode}"
					            	onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
					            	styleClass="contentform" maxlength="5" style="width:100%;">
					            	
						            	<a4j:support event="onkeyup" action="#{semmmm001Action.doSemiLiveSearch}" reRender="dlgTxtBankBranch, dlgSlctProvinceList">
											<a4j:actionparam name="methodWithNavi" value="doSemiLiveSearch" />
											<a4j:actionparam name="paramLiveMode" value="BRANCH_CODE" />
										</a4j:support>
					            	
					            	</h:inputText>
					            </a4j:region>
							</td>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankBranchName']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:50%;">
				            	<h:inputText id="dlgTxtBankBranch" value="#{semmmm001Bean.itemBankMasterSP.bankBranch}" 
				            	styleClass="contentform" maxlength="300" style="width:90%;" />
							</td>
						</tr>
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.province']} :" styleClass="ms7"/>
				            </td>
							<td colspan="3" align="left">
								<h:selectOneMenu id="dlgSlctProvinceList" value="#{semmmm001Bean.itemBankMasterSP.provinceId}">
									<f:selectItems value="#{semmmm001Bean.provinceBookbankList}" />
								</h:selectOneMenu> 
					        </td>
					     </tr> 
					</table>
				</h:panelGroup>
				</h:panelGrid>
				</center>
			</rich:panel>	
			
			<div style="clear:both; height:0px;"></div>
			
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton id="saveBtn" value="Save" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="pnlSearchResult, oppContent,frmSave"
					process="newOrUpdateBankMasterForm"
					oncomplete="if(#{semmmm001Bean.popupClose == 'true'}) {#{rich:component('panel_popupNewOrUpdateBankMaster')}.hide();}" >
							<a4j:actionparam name="navModule" value="mm" />
	          				<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navPrograme}" />	
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="#{semmmm001Bean.doMode}" />
					</a4j:commandButton>
					
					<rich:spacer width="5px" />
	
					<a4j:commandButton value="Cancel" styleClass="rich-button" reRender="newOrUpdateBankMasterForm">
						<rich:componentControl for="panel_popupNewOrUpdateBankMaster" operation="hide" event="onclick" />
					</a4j:commandButton>
					
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>	
	</rich:modalPanel>
	<!-- popupNewOrUpdateBankMaster -->
	
	
	<!-- mmm001PopUpCommon_new Bank -->
	<!-- << [POPUP_07] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->
	
	<!-- >> [POPUP_08] -->
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<rich:modalPanel id="mmm001PopUpCommon_convertVendorCode" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vendor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_convertVendorCode" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_convertVendorCode" attachTo="hide-mmm001PopUpCommon_convertVendorCode" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_convertVendorCode">
		
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
                				<h:inputText id="txtVendorCode" value="#{semmmm001Bean.vendorInfo.vendorCode}" 
                				 size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmmm001Bean.vendorInfo.vendorName}" 
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
					<a4j:commandButton value="Search" action="#{semmmm001Action.doSearchPopupConvertVendor}"
					reRender="frmMmm001PopUpCommon_convertVendorCode, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmmm001Action.initConvertVendor}"
					reRender="frmMmm001PopUpCommon_convertVendorCode, dataTable_searchVendor"
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
							var="vendorLst"  value="#{semmmm001Bean.convertVendorResultList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmmm001Action.doSelectConvertVendor}"
											reRender="searchVendorCode">
												<a4j:actionparam name="vendorCodeParam" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="vendorNameParam" value="#{vendorLst.dataObj.vendorName}" />
												
												<rich:componentControl for="mmm001PopUpCommon_convertVendorCode" operation="hide" event="onclick" />
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
								<rich:column styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left" style="white-space:nowrap;">
										<h:outputText id="mmm001_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left" style="white-space:nowrap;">
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
												<f:param value="#{fn:length(semmmm001Bean.convertVendorResultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmmm001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMmm001PopUpCommon_convertVendorCode"></a4j:support>
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
					    <rich:componentControl for="mmm001PopUpCommon_convertVendorCode" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_08] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_09] -->
	<!-- mmm001PopUpCommon_searchContract -->
	<rich:modalPanel id="mmm001PopUpCommon_searchContract" autosized="true" 
	rendered="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Search Contract"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_searchContract" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_searchContract" attachTo="hide-mmm001PopUpCommon_searchContract" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="frmMmm001PopUpCommon_searchContract">
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
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.company']}"/>
							</td>
							<td style="width:30%;">
								<h:selectOneMenu id="searchCompany" value="#{semmmm001Bean.popupSearchContractCriteria.company}" 
								style="width:120px;">
                					<f:selectItems value="#{semmmm001Bean.companyList}" />
                				</h:selectOneMenu>
							</td>
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.region']}"/>
							</td>
							<td style="width:40%;">
		                		<h:selectManyCheckbox id="searchArrRegion" value="#{semmmm001Bean.popupSearchContractCriteria.arrRegion}" styleClass="ms7">
						   			<f:selectItems value="#{semmmm001Bean.regionList}" />
						   		</h:selectManyCheckbox>
							</td>
						</tr>
						<tr>
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.contract.number']}"/>
							</td>
							<td style="width:30%;">
								<h:inputText id="searchContractNo" value="#{semmmm001Bean.popupSearchContractCriteria.contractNo}" 
								style="width:70%;" maxlength="50" />
							</td>
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.location.id']}"/>
							</td>
							<td style="width:40%;">
								<h:inputText id="searchLocationId" value="#{semmmm001Bean.popupSearchContractCriteria.locationId}" 
								style="width:70%;" maxlength="50" />
							</td>
						</tr>
						<tr>
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.contract.name']}"/>
							</td>
							<td style="width:30%;">
								<h:inputText id="searchContractName" value="#{semmmm001Bean.popupSearchContractCriteria.contractName}" 
								style="width:70%;" maxlength="50" />
							</td>
							<td style="width:15%; text-align:right;" class="ms7">
								<h:outputText value="#{jspMsg['label.site.name']}"/>
							</td>
							<td style="width:40%;">
								<h:inputText id="searchSiteName" value="#{semmmm001Bean.popupSearchContractCriteria.siteName}" 
								style="width:70%;" maxlength="20" />
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
					<a4j:commandButton value="Search" action="#{semmmm001Action.doSearchPopupContract}"
					reRender="frmMmm001PopUpCommon_searchContract, dataTable_resultContract" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmmm001Action.initPopupSearchContract}"
					reRender="frmMmm001PopUpCommon_searchContract, dataTable_resultContract"
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
					<div style="width:900px; overflow-y:scroll; border:1px solid #e0e0e0;"> 
						<rich:dataTable style="width:100%;" id="dataTable_resultContract" cellpadding="1" cellspacing="0" border="0" 
						var="contractObj"  value="#{semmmm001Bean.popupSearchContractResultList}" reRender="dataTable_resultContract, dataScrll_resultContract" 
						rows="10" rowClasses="cur" styleClass="dataTable">
							
							<!-- >> column -->
							<rich:column style="width:20px;" styleClass="tableFirstCol">
								<f:facet name="header">
									<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
								</f:facet>
								<div align="center">
									<a4j:commandLink value="select" style="height:15px; width:15px;" 
									action="#{navAction.navi}" reRender="oppContent, txtNavProgram"
									rendered="#{semmmm001Bean.renderedPnlForWithoutContract}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSelectContractPopup" />
										<a4j:actionparam name="contractNoParam" value="#{contractObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="" />
						
										<%--rich:componentControl for="mmm001PopUpCommon_searchContract" operation="hide" event="onclick" /--%>
									</a4j:commandLink>
									
									<a4j:commandLink value="select" style="height:15px; width:15px;" 
									action="#{navAction.navi}" reRender="oppContent, txtNavProgram"
									rendered="#{semmmm001Bean.renderedPnlForWithoutContract == 'false'}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-1cntrt" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSelectContractForAssignOrChange" />
										<a4j:actionparam name="contractNoParam" value="#{contractObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
						
										<%--rich:componentControl for="mmm001PopUpCommon_searchContract" operation="hide" event="onclick" /--%>
									</a4j:commandLink>
								</div>	
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractOldNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractOldNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.site.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.region}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.region}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.expireDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.expireDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<!-- << column -->
				            
				            <!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.popupSearchContractResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="6">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_resultContract"
												maxPages="#{semmmm001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrll_resultContract" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmMmm001PopUpCommon_searchContract"></a4j:support>
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
			<h:panelGrid width="100%" columns="1" cellpadding="0" cellspacing="1" style="">
				<h:panelGroup style="">
					<table style="width:100%;">
						<tr>
							<td style="width:15%;" class="ms7">
								&nbsp;
							</td>
							<td style="" height="20" class="ms7">
								<%--
								<a4j:region>
									<h:selectBooleanCheckbox id="chkNewVendorWithoutContract" 
									value="#{semmmm001Bean.chkNewVendorWithoutContract}" 
									rendered="#{semmmm001Bean.renderedPnlForWithoutContract}"
									style="margin-left:-3px; vertical-align:middle;">
										<a4j:support event="onclick" action="#{semmmm001Action.doChkWithoutContract}" 
										reRender="frmMmm001PopUpCommon_searchContract" >
										</a4j:support>
									</h:selectBooleanCheckbox>
								</a4j:region>
		                		<h:outputText value="New Vendor without Contract" styleClass="ms7" 
		                		rendered="#{semmmm001Bean.renderedPnlForWithoutContract}" 
		                		style="margin-left:2px; vertical-align:middle;" /> 
		                		--%>
							</td>
							<td class="ms7"style="width:5%; text-align:right;">
								<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true" style="">
								    <rich:componentControl for="mmm001PopUpCommon_searchContract" operation="hide" event="onclick" />
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
			<%--
			<rich:spacer rendered="#{semmmm001Bean.chkNewVendorWithoutContract}" />
			
			<!-- >> additional without contract -->
			<h:panelGrid width="100%" style="border:1px solid #e0e0e0;" 
			id="withoutContractRemarkPnl" rendered="#{semmmm001Bean.chkNewVendorWithoutContract}">
				<h:panelGroup>
				
					<table width="100%">
						<tr>
							<td style="width:15%;" class="ms7">
								&nbsp;
							</td>
							<td style="width:1%; vertical-align:top;" class="ms7">
								<h:outputText value="*" style="font-style:bold; color:red;" />
							</td>
							<td style="vertical-align:top;" class="ms7">
								<h:outputText value="#{jspMsg['label.remark']}" styleClass="contentform" 
								style="vertical-align:top;"/>
								
								<h:inputTextarea id="searchContract_withOutCntrctRemark" value="#{semmmm001Bean.vendorInfo.withoutContractRemark}" 
								style="width:70%; height:70px; font-size:13px; font-family: Arial, Verdana, sans-serif;">
								</h:inputTextarea>
							</td>
						</tr>
					</table>
				
					<a4j:commandButton value="Ok" styleClass="rich-button" style="float:right;"
					action="#{navAction.navi}" reRender="oppContent, txtNavProgram, withOutCntrctRemark" >
						<a4j:actionparam name="navModule" value="mm" />
						<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
						<a4j:actionparam name="moduleWithNavi" value="mm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
						<a4j:actionparam name="methodWithNavi" value="doSelectContractPopup" />
						<a4j:actionparam name="contractNoParam" value="" />
						<a4j:actionparam name="vendorIdParam" value="" />
					</a4j:commandButton>
					
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional without contract -->
			--%>
			
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_searchContract -->
	<!-- << [POPUP_09] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_10] -->
	<!-- mmm001PopUpCommon_searchPayee -->
	<rich:modalPanel id="mmm001PopUpCommon_searchPayee" autosized="true" 
	rendered="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Search Payee"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_searchPayee" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_searchPayee" attachTo="hide-mmm001PopUpCommon_searchPayee" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="frmMmm001PopUpCommon_searchPayee">
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['header.payee.info']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
						<rich:dataTable style="width:100%;" id="dataTable_resultPayee" cellpadding="1" cellspacing="0" border="0" 
						var="payeeObj"  value="#{semmmm001Bean.popupPayeeResultList}" reRender="dataTable_resultPayee, dataScrll_resultPayee" 
						rows="10" rowClasses="cur" styleClass="dataTable">
							
							<!-- >> column -->
							<rich:column style="width:20px;" styleClass="tableFirstCol">
								<f:facet name="header">
									<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
								</f:facet>
								<div align="center">
									<a4j:commandLink value="select" style="height:15px; width:15px;" 
									action="#{semmmm001Action.doSelectPayeePopup}"
									reRender="oppContent">
										<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
									</a4j:commandLink>
								</div>	
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{payeeObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.idCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.taxId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeAddress1}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.address']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.payeeAddress1}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- << column -->
				            
				            <!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.popupPayeeResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="2">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_resultPayee"
												maxPages="#{semmmm001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrll_resultPayee" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmMmm001PopUpCommon_searchPayee"></a4j:support>
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
					    <rich:componentControl for="mmm001PopUpCommon_searchPayee" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_searchPayee -->
	<!-- << [POPUP_10] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->
	<rich:modalPanel id="popupSearchSiteContract" autosized="true" minWidth="220" minHeight="600" moveable="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Popup Select Contract"></h:outputText>
			</h:panelGroup>
		</f:facet>

		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSearchSiteContract" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchSiteContract" attachTo="hidePopupSearchSiteContract" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupSiteContractBean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<h:form id="popupFrmSearchSiteContract"> 
			<rich:panel id="pnlPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.criteria.name']}"/>
				</f:facet>
				
				<!-- begin content criteria -->
				<h:panelGroup style="width:100%;">
					<table width="100%">
						<tr>
							<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.contract.number']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                				<h:inputText id="txtPopupContractNo" value="#{semmmm001Bean.popupSearchContractCriteria.contractNo}"/>
		                	</td>
		                	<td align="right" width="15%">
								<h:outputText value="#{jspMsg['label.site.name']}" styleClass="ms7"/>
                			</td>
                			<td width="35%">
                				<h:inputText id="txtPopupSiteName" value="#{semmmm001Bean.popupSearchContractCriteria.siteName}" size="30"/>
		                	</td>
	                	 </tr>
	                	 
	                	 <tr>
		                	<td align="right" width="20%">
		                		<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                			</td>
                			<td colspan="3">
	                			<h:selectOneMenu id="ddlPopupCompany" value="#{semmmm001Bean.popupSearchContractCriteria.company}">
									<f:selectItems value="#{semmmm001Bean.companyList}"/>
								</h:selectOneMenu>
		                	</td>
	                	 </tr>
	                	 
	                	 <tr>
		                	<td width="20%"></td>
                			<td colspan="3">
	                			<h:selectOneRadio id="rbtCurrentFlag" value="#{semmmm001Bean.popupSearchContractCriteria.currentFlag}"  styleClass="ms7" rendered="true">
	                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['desc.current.info']}" />
	                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['desc.history.info']}"/>
	                			</h:selectOneRadio>
		                	</td>
	                	 </tr>
	                	 <tr>
	                	 	<td colspan="4">
	                	 		<!-- >> button search/clear -->
								<h:panelGrid columns="1">
									<h:panelGroup style="">
										<a4j:commandButton value="Search" action="#{semmmm001Action.doSearchPopupSiteContract}"
										reRender="popupFrmSearchSiteContract, dtbPopupSiteContract" 
										styleClass="rich-button" style="margin-right:10px;">
										</a4j:commandButton>
										
										<a4j:commandButton value="Clear" action="#{semmmm001Action.initPopupSiteContract}"
										reRender="popupFrmSearchSiteContract, dtbPopupSiteContract"
										styleClass="rich-button">
											
										</a4j:commandButton>
									</h:panelGroup>
								</h:panelGrid>
								<!-- << button search/clear -->
	                	 	</td>
	                	</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
			
			<div style="clear:both; height:10px;"></div>
				
			<rich:panel id="pnlPopupSearchSiteContractResult">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.result.name']}" />
				</f:facet>
				
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid #e0e0e0;"> 
				
						<rich:dataTable id="dtbPopupSiteContract" width="100%"
						value="#{semmmm001Bean.popupSearchContractResultList}" 
						rowKeyVar="RegInd" var="contractObj" 
						rows="8"
						rowClasses="cur" styleClass="dataTable">
						
						<!-- >> column -->
							<rich:column style="width:20px;" styleClass="tableFirstCol">
								<f:facet name="header">
									<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
								</f:facet>
								<div align="center">
									<a4j:commandLink value="select" style="height:15px; width:15px;" 
									action="#{navAction.navi}" reRender="oppContent, txtNavProgram, vendorInfoCompany, vendorInfOtherExpenseFlag">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageSelectSiteContractPopup" />
										<a4j:actionparam name="contractNoParam" value="#{contractObj.dataObj.contractNo}" />
										<a4j:actionparam name="effectiveDtStrParam" value="#{contractObj.dataObj.effectiveDtStr}" />
										<a4j:actionparam name="expireDtStrParam" value="#{contractObj.dataObj.expireDtStr}" />
										<a4j:actionparam name="companyParam" value="#{contractObj.dataObj.company}" />
										<a4j:actionparam name="vendorEffectiveDt" value="#{contractObj.dataObj.vendorEffectiveDtStr}" />
										<a4j:actionparam name="contractNameParam" value="#{contractObj.dataObj.contractName}" />
										
										<a4j:actionparam name="vendorContFlag" value="#{semmmm001Bean.vendorContFlag}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SELECT_CONTRACT" />
									</a4j:commandLink>
								</div>	
							</rich:column>
							
							<rich:column style="width:100px;" title="" sortBy="#{contractObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="width:100px;" title="" sortBy="#{contractObj.dataObj.contractNoOld}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractNoOld}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="width:100px;" title="" sortBy="#{contractObj.dataObj.contractType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="width:100px;" title="" sortBy="#{contractObj.dataObj.contractStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.contractStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.site.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.networkStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.network.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="width:80px;" title="" sortBy="#{contractObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="width:80px;" title="" sortBy="#{contractObj.dataObj.expireDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.expireDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.locationId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.locationCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="white-space:nowrap;">
									<h:outputText value="#{contractObj.dataObj.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPopupSiteContract" 
								maxPages="10" id="dstPopupSiteContract" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</div>
					</center>
				</h:panelGroup>
			</rich:panel>
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="popupSearchSiteContract" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		</h:form>
	</rich:modalPanel>
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_12] -->
	<!-- mmm001PopUpCommon_changeVendor -->
	<rich:modalPanel id="mmm001PopUpCommon_changeVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vendor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_changeVendor" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_changeVendor" attachTo="hide-mmm001PopUpCommon_changeVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_changeVendor">
		
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
                				<h:inputText id="txtVendorCode" value="#{semmmm001Bean.changeVendorCriteria.vendorCode}" 
                				 size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmmm001Bean.changeVendorCriteria.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['column.header.citizen.id']} / #{jspMsg['column.header.personal.tax.id']} :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorIdCard" value="#{semmmm001Bean.changeVendorCriteria.idCard}" 
                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
                				maxlength="13"/>
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
					<a4j:commandButton value="Search" action="#{semmmm001Action.doSearchPopupChangeVendor}"
					reRender="frmMmm001PopUpCommon_changeVendor,dataTable_searchVendorContract" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmmm001Action.initChangeVendor}"
					reRender="frmMmm001PopUpCommon_changeVendor,mmm001PopUpCommon_changeVendor,dataTable_searchVendorContract"
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
							
							<rich:dataTable id="dataTable_searchVendorContract" width="100%" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.popupSAPVendorlist}" var="semSapVendorObj"
							reRender="dtbSemSapVendorInfoList" rows="7"
							rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform"/>
									</f:facet>
									<div align="center">
										<!-- SAP >> -->
										<a4j:commandLink id="hlkSelectVendorCode" value="select" 
										action="#{navAction.navi}" reRender="oppContent, expenseContractNo, expenseExpenseEffectiveDt, expenseEffectiveDt, 
													expenseExpireDt, expenseExpenseType, rdoExpensePayType, btnSaveVendorDetail" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doSelectVendorByVendorId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semSapVendorObj.dataObj.vendorId}" />
											<a4j:actionparam name="changeType" value="S" />
											<a4j:actionparam name="btnActionType" value="C" />
											<a4j:actionparam name="actionId" value="CHANGE_SELECT_VENDOR" />
										</a4j:commandLink>
										
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.blockstatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.blackliststatus']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.vendorBlackListStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.sap.role']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.role}" styleClass="contentform"  />
									</div>
								</rich:column>
									
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.vendorId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.vendorCode}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{semSapVendorObj.dataObj.vendorName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.idCard}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{semSapVendorObj.dataObj.taxId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.branch.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="width:80px;">
										<h:outputText value="#{semSapVendorObj.dataObj.branchNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.address']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{semSapVendorObj.dataObj.address}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.tambol']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{semSapVendorObj.dataObj.tambolName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.amphur']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{semSapVendorObj.dataObj.amphurName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{semSapVendorObj.dataObj.provinceName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.post.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="">
										<h:outputText value="#{semSapVendorObj.dataObj.postCode}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center" style="">
										<h:outputText value="#{semSapVendorObj.dataObj.regionName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.popupSAPVendorlist)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="12">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendorContract"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllResultList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dataTable_searchVendorContract"></a4j:support>
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
					    <rich:componentControl for="mmm001PopUpCommon_changeVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_12] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_13] -->
	<!-- mmm001PopUpCommon_controllerBtnSave -->
	<rich:modalPanel id="mmm001PopUpCommon_controllerBtnSave" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Save Detail"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_controllerBtnSave" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_changeVendor" attachTo="hide-mmm001PopUpCommon_controllerBtnSave" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_controllerBtnSave">
		
			<rich:panel id="pnlRentalPayNormal">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		<h:graphicImage value="images/error.gif"  rendered="#{semmmm001Bean.renderedBtnCloseVendor}"/>
			                		<rich:spacer width="15px"></rich:spacer>
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedMsgPopupSave}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedMsgPopupSave == false}" styleClass="ms7"></h:outputText>
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
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.closeBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCloseVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSave" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_controllerBtnSave"
									rendered="#{semmmm001Bean.renderedBtnOKVendor}" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnOKVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.yesBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_controllerBtnSave"
									rendered="#{semmmm001Bean.renderedBtnYesVendor}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="Y" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnYesVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.noBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_controllerBtnSave"
									rendered="#{semmmm001Bean.renderedBtnNoVendor}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="N" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNoVendor}"/>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCencelVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSave" operation="hide" event="onclick" />
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
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_13] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->
	
	<!-- >> [POPUP_14] -->
	<!-- mmm001PopUpCommon_changePayee -->
	<rich:modalPanel id="mmm001PopUpCommon_changePayee" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Payee"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_changePayee" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_changePayee" attachTo="hide-mmm001PopUpCommon_changePayee" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_changePayee">
		
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
								<h:outputText value="Payee Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtvCode" value="#{semmmm001Bean.changePayeeCriteria.payeeCode}" 
                				 size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Payee Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtPayeeName" value="#{semmmm001Bean.changePayeeCriteria.payeeName}" 
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
					<a4j:commandButton value="Search" action="#{semmmm001Action.doSearchPopupChangePayee}"
					reRender="frmMmm001PopUpCommon_changePayee,dataTable_searchPayeeContract" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmmm001Action.initChangeVendor}"
					reRender="frmMmm001PopUpCommon_changeVendor,mmm001PopUpCommon_changeVendor,dataTable_searchVendorContract"
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
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmmm001Bean.msgDataNotFound}" rendered="#{semmmm001Bean.renderedMsgDataNotFound}" />
                        </div>
							
						<rich:dataTable style="width:100%;" id="dataTable_searchPayeeContract" cellpadding="1" cellspacing="0" border="0" 
						var="payeeObj"  value="#{semmmm001Bean.popupPayeeResultList}" reRender="dataTable_searchPayeeContract, dataScrll_resultChangePayee" 
						rows="10" rowClasses="cur" styleClass="dataTable">
							
							<!-- >> column -->
							<rich:column style="width:20px;" styleClass="tableFirstCol">
								<f:facet name="header">
									<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
								</f:facet>
								<div align="center">
									<a4j:commandLink value="select" style="height:15px; width:15px;" 
									action="#{semmmm001Action.doChangePayeePopup}"
									reRender="oppContent">
										<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
										<a4j:actionparam name="changeType" value="S" />
										<a4j:actionparam name="btnActionType" value="C" />
									</a4j:commandLink>
								</div>	
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{payeeObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.idCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.taxId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeAddress1}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.address']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{payeeObj.dataObj.payeeAddress1}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- << column -->
				            
				            <!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.popupPayeeResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="2">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchPayeeContract"
												maxPages="#{semmmm001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrll_resultChangePayee" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmMmm001PopUpCommon_changePayee"></a4j:support>
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
					    <rich:componentControl for="mmm001PopUpCommon_changePayee" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_14] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->	
	<!-- >> [POPUP_15] -->
	<!-- mmm001PopUpCommon_confirmPopup -->
	<rich:modalPanel id="mmm001PopUpCommon_confirmPopup" width="900" autosized="true" top="20">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_confirmPopup" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_confirmPopup" attachTo="hide-mmm001PopUpCommon_confirmPopup" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="mmm001_frmConfirm">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;width:100%;" >
				<!-- /// -->
				<h:outputText value="#{semmmm001Bean.confirmMsg}" styleClass="ms7"/>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="text-align:center;width:100%;">
				<h:panelGroup >
					<a4j:commandButton id="btnCancelDeleteVendor" value="Cancel" styleClass="rich-button" immediate="true" reRender="oppContent">
					    <rich:componentControl for="mmm001PopUpCommon_confirmPopup" operation="hide" event="onclick" />
					</a4j:commandButton>
					
					<rich:spacer width="5"/>
					
					<a4j:commandButton id="btnVendorDelete" value="Ok" action="#{semmmm001Action.doDeleteVendorContract}"
					 styleClass="rich-button" reRender="oppContent">
					        <a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoDelete}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdDelete}" />
						    <a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdDelete}" />
					</a4j:commandButton>
					
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_confirmPopup -->
	<!-- << [POPUP_15] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_17] -->
	<!-- mmm001PopUpCommon_confirm -->
	<rich:modalPanel id="mmm001PopUpCommon_confirm" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Popup Confirm"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_confirm" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_confirm" attachTo="hide-mmm001PopUpCommon_confirm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_confirm">
		
			<rich:panel id="pnlconfirm">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		
			                		
			                		<h:outputText value="#{semmmm001Bean.renderedMsgConfirm}" 
			                		rendered="true" styleClass="ms7"></h:outputText>
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
									
									
									<a4j:commandButton value="Yes" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_confirm"
									rendered="#{semmmm001Bean.renderedBtnCheck}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNavi}" />
										<a4j:actionparam name="confirmFlag" value="Y" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnCheck}" />
									
									<a4j:commandButton value="No" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_confirm"
									rendered="#{semmmm001Bean.renderedBtnCheck}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNavi}" />
										<a4j:actionparam name="confirmFlag" value="N" />
									</a4j:commandButton>
									
									
									<a4j:commandButton value="Yes" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_confirm"
									rendered="#{semmmm001Bean.renderedBtnUncheck}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNavi}" />
										<a4j:actionparam name="confirmFlag" value="N" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnUncheck}" />
									
									<a4j:commandButton value="No" action="#{navAction.navi}"
									reRender="oppContent,frmMmm001PopUpCommon_confirm"
									rendered="#{semmmm001Bean.renderedBtnUncheck}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNavi}" />
										<a4j:actionparam name="confirmFlag" value="Y" />
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
	<!-- mmm001PopUpCommon_confirm -->
	<!-- << [POPUP_17] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->


<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_18] -->
	<!-- mmm001PopUpCommon_retStatusDelete -->
	<rich:modalPanel id="mmm001PopUpCommon_retStatusDelete" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Popup Confirm"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_retStatusDelete" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_retStatusDelete" attachTo="hide-mmm001PopUpCommon_retStatusDelete" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_retStatusDelete">
		
			<rich:panel id="pnlconfirm">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		
			                		
			                		<h:outputText value="#{semmmm001Bean.renderedMsgConfirm}" 
			                		rendered="true" styleClass="ms7"></h:outputText>
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
									
									
									<a4j:commandButton value="OK" action="#{navAction.navi}"
									reRender="oppContent,mmm001PopUpCommon_retStatusDelete"
									rendered="#{semmmm001Bean.renderedBtnCheck}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNavi}" />
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
	<!-- mmm001PopUpCommon_retStatusDelete -->
	<!-- << [POPUP_18] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- >> [POPUP_19] -->
	<!-- mmm001PopUpCommon_controllerBtnBack -->
	<rich:modalPanel id="mmm001PopUpCommon_controllerBtnBack" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Back"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_controllerBtnBack" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" attachTo="hide-mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_controllerBtnBack">
		
			<rich:panel id="pnlRentalPayNormal">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		<h:outputText value="#{semmmm001Bean.resultMsg}" 
			                		rendered="true" styleClass="ms7red"></h:outputText>
			         			</td>
			         		</tr>
			         	</table>
			         </h:panelGroup>
                    
                </h:panelGrid>        	
			
				<div style="clear:both; height:10px;"></div>
	
				<!-- >> button Back Vendor -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="true">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									<a4j:commandButton id="btnSaveVendorDetailPopup" title="SAVE VENDOR" reRender="oppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										rendered="#{semmmm001Bean.renderedBtnBackVD}"
										action="#{semmmm001Action.doValidateVendorSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.show(); return false;">
									</a4j:commandButton>
									
									<a4j:commandButton id="btnSaveBankInfoPopup" title="SAVE Bookbank Vendor" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	 	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBack"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										rendered="#{semmmm001Bean.renderedBtnBackVB}" 
										action="#{semmmm001Action.doValidateBookbankSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<a4j:commandButton id="btnSavePayeeInfoPopup" title="SAVE payee" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
									panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBack"
									value="#{jspMsg['btn.save']}" styleClass="rich-button"
									rendered="#{semmmm001Bean.renderedBtnBackPY}" 
									action="#{semmmm001Action.doValidatePayeeSaveDraft}"
									oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<a4j:commandButton id="btnSavePayeeBBInfoPopup" title="SAVE Bookbank Payee" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
									panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBack"
									value="#{jspMsg['btn.save']}" styleClass="rich-button"
									rendered="#{semmmm001Bean.renderedBtnBackPB}"
									action="#{semmmm001Action.doValidateBBPayeeSaveDraft}"
									oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
								
									<a4j:commandButton id="btnBackPopup" value="#{jspMsg['btn.back']}" title="BVD" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" rendered="true">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Vendor -->
				
				
				<!-- >> button Back Vendor Bookbank -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									
									<rich:spacer width="5"/>
								
									<a4j:commandButton id="btnBackBankInfoPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.renderedBtnBackOthPageFlow == false}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodoBankInfoPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" rendered="#{semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.renderedBtnBackOthPageFlow == false}">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackOthBankInfoPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnBackOthPageFlow}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Vendor Bookbank -->
				
				<!-- >> button Back Payee -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnBackPayeePopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.renderedBtnBackOthPageFlow == false}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodoPayeePopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" rendered="#{semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.renderedBtnBackOthPageFlow == false}">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackOthPayeePopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnBackOthPageFlow}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Payee -->
				
				<!-- >> button Back Payee Bookbank -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnBackPBPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.renderedBtnBackOthPageFlow == false and semmmm001Bean.payeePageFlag == false}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackPayeePBPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.renderedBtnBackOthPageFlow == false and semmmm001Bean.payeePageFlag}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodoPBPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" rendered="#{semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.renderedBtnBackOthPageFlow == false}">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackOthPBPopup" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
					           	 	oncomplete="onTopPage();" rendered="#{semmmm001Bean.renderedBtnBackOthPageFlow}">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Payee Bookbank -->
				
				
				
				<!-- >> button Back Cancel Vendor -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									<a4j:commandButton id="btnSaveVendorDetailBCPopup" reRender="oppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, 
						           	 	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBackCancel"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.validatePage.saveButton == 'N'}" 
										rendered="#{semmmm001Bean.validatePage.saveButton != 'H'}"
										action="#{semmmm001Action.doValidateVendorSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBackCancel')}.show(); return false;">
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
								
									<a4j:commandButton id="btnCancelVendorDetailBack" reRender="txtNavProgram, oppContent"
										value="#{jspMsg['btn.back']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.validatePage.cancelButton == 'N'}"
										rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"
										action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorId}" />
											
											<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseEffectiveDtStrParam}" />
											<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.effectiveDtStrParam}" />
											<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expireDtStrParam}" />
											<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseTypeIdParam}" />
											<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payTypeIdParam}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdParam}" />
											<a4j:actionparam name="cancelFlag" value="Y" />
											<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
										</a4j:commandButton>
									
									<rich:spacer width="5" />
									
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Cancel Vendor -->
				
				
				<!-- >> button Back Cancel Vendor Bookbank -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									<a4j:commandButton id="btnSaveBankInfoBCPopup" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	 	mmmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBackCancel"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbank}" 
										action="#{semmmm001Action.doValidateBookbankSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBackCancel')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
								
									<a4j:commandButton id="btnCancelBookbankDetailPopup" reRender="txtNavProgram, oppContent"
										value="#{jspMsg['btn.back']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbank}" action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doCancelBookbankByVendorBookbankId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoVB}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdVB}" />
											<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorBookbankId}" />
											<a4j:actionparam name="btnActionType" value="CANCEL" />
											<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true">
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Cancel Vendor Bookbank -->
				
				<!-- >> button Back Cancel Payee -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									<a4j:commandButton id="btnSavePayeeInfoBCPopup" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
									panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBackCancel"
									value="#{jspMsg['btn.save']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.disableBtnSavePayee}" 
									action="#{semmmm001Action.doValidatePayeeSaveDraft}"
									oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBackCancel')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnCancelPayeeDetailPopup" reRender="txtNavProgram, oppContent"
									value="#{jspMsg['btn.back']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.disableBtnSavePayee}" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewPayeeByPayeeId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPY}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPY}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPY}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPY}" />
										<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Cancel Payee -->
				
				<!-- >> button Back Cancel Payee Bookbank -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;" rendered="false">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									<a4j:commandButton id="btnSavePayeeBBInfoBCPopup" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
									panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,
						           	mmm001PopUpCommon_controllerBtnBack,mmm001PopUpCommon_controllerBtnSaveAndBackCancel"
									value="#{jspMsg['btn.save']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" 
									action="#{semmmm001Action.doValidateBBPayeeSaveDraft}"
									oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBackCancel')}.show(); return false;">	
										
									</a4j:commandButton>
									
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnCancelPayeeBookbankDetail" reRender="txtNavProgram, oppContent"
									value="#{jspMsg['btn.back']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doBBPayeeCancel" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPB}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPB}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPB}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.bookbankPayeeIdPB}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPB}" />
										<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
									</a4j:commandButton>

									<rich:spacer width="5"/>
									
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" rendered="true" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnBack" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button Back Cancel Payee Bookbank -->
			</rich:panel>
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_convertVendorCode -->
	<!-- << [POPUP_19] -->
	
	<!-- >> [POPUP_20] -->
	<!-- mmm001PopUpCommon_controllerBtnSaveAndBack -->
	<rich:modalPanel id="mmm001PopUpCommon_controllerBtnSaveAndBack" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Save Detail"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_controllerBtnSaveAndBack" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBack" attachTo="hide-mmm001PopUpCommon_controllerBtnSaveAndBack" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_controllerBtnSaveAndBack">
		
			<rich:panel id="pnlRentalPayNormal">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		<h:graphicImage value="images/error.gif"  rendered="#{semmmm001Bean.renderedBtnCloseVendor}"/>
			                		<rich:spacer width="15px"></rich:spacer>
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedBtnCloseVendor}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedBtnOKVendor or semmmm001Bean.renderedBtnYesVendor}" styleClass="ms7"></h:outputText>
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
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.closeBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCloseVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBack" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									rendered="#{semmmm001Bean.renderedBtnOKVendor}" 
									styleClass="rich-button" 
									oncomplete="if(#{semmmm001Bean.saveSuccessFlag == 'true'})changePage();#{rich:component('mdpWait')}.show();
									if(#{semmmm001Bean.saveSuccessFlag == 'false'})#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.hide();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnOKVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.yesBtnLabel}" action="#{navAction.navi}"
									rendered="#{semmmm001Bean.renderedBtnYesVendor}" 
									styleClass="rich-button"
									oncomplete="if(#{semmmm001Bean.saveSuccessFlag == 'true'})changePage();#{rich:component('mdpWait')}.show();
									if(#{semmmm001Bean.saveSuccessFlag == 'false'})#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.hide();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="Y" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnYesVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.noBtnLabel}" action="#{navAction.navi}"
									rendered="#{semmmm001Bean.renderedBtnNoVendor}" 
									styleClass="rich-button" 
									oncomplete="if(#{semmmm001Bean.saveSuccessFlag == 'true'})changePage();#{rich:component('mdpWait')}.show();
									if(#{semmmm001Bean.saveSuccessFlag == 'false'})#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBack')}.hide();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="N" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNoVendor}"/>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCencelVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBack" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:jsFunction name="changePage" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:jsFunction>
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
	<!-- mmm001PopUpCommon_controllerBtnSaveAndBack -->
	<!-- << [POPUP_20] -->
	
	<!-- >> [POPUP_21] -->
	<!-- mmm001PopUpCommon_controllerBtnSaveAndBackCancel -->
	<rich:modalPanel id="mmm001PopUpCommon_controllerBtnSaveAndBackCancel" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Save Detail"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_controllerBtnSaveAndBacCancelk" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBackCancel" attachTo="hide-mmm001PopUpCommon_controllerBtnSaveAndBackCancel" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_controllerBtnSaveAndBackCancel">
		
			<rich:panel id="pnlRentalPayNormal">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		<h:graphicImage value="images/error.gif"  rendered="#{semmmm001Bean.renderedBtnCloseVendor}"/>
			                		<rich:spacer width="15px"></rich:spacer>
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedBtnCloseVendor}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmmm001Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmmm001Bean.renderedBtnOKVendor or semmmm001Bean.renderedBtnYesVendor}" styleClass="ms7"></h:outputText>
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
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.closeBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCloseVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBackCancel" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									oncomplete="changePage();#{rich:component('mdpWait')}.show();"
									rendered="#{semmmm001Bean.renderedBtnOKVendor}" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnOKVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.yesBtnLabel}" action="#{navAction.navi}"
									oncomplete="changePage();#{rich:component('mdpWait')}.show();"
									rendered="#{semmmm001Bean.renderedBtnYesVendor}" 
									styleClass="rich-button">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="Y" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnYesVendor}" />
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.noBtnLabel}" action="#{navAction.navi}"
									rendered="#{semmmm001Bean.renderedBtnNoVendor}" 
									styleClass="rich-button" 
									oncomplete="if(#{semmmm001Bean.saveSuccessFlag == 'true'})changePage();#{rich:component('mdpWait')}.show();
									if(#{semmmm001Bean.saveSuccessFlag == 'false'})#{rich:component('mmm001PopUpCommon_controllerBtnSaveAndBackCancel')}.hide();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="validateFlag" value="N" />
										<a4j:actionparam name="validateCaseId" value="#{semmmm001Bean.retResultObj.validateCaseId}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="SAVE_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNoVendor}"/>
									
									<a4j:commandButton value="#{semmmm001Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" immediate="true" rendered="#{semmmm001Bean.renderedBtnCencelVendor}" >
								    	<rich:componentControl for="mmm001PopUpCommon_controllerBtnSaveAndBackCancel" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<a4j:jsFunction name="changePage" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
										<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
											
										<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.expenseEffectiveDtStrParamBackAfterSave}" />
										<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.effectiveDtStrParamBackAfterSave}" />
										<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.expireDtStrParamBackAfterSave}" />
										<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.expenseTypeIdParamBackAfterSave}" />
										<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.payTypeIdParamBackAfterSave}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
										<a4j:actionparam name="cancelFlag" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:jsFunction>
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
	<!-- mmm001PopUpCommon_controllerBtnSaveAndBackCancel -->
	<!-- << [POPUP_21] -->
	
	
	<!-- >> [POPUP_22] -->
	<!-- mmm001PopUpCommon_confirmDetail -->
	<rich:modalPanel id="mmm001PopUpCommon_confirmDetail" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.view.confirm']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mmm001PopUpCommon_confirmDetail" style="cursor:pointer" />
					<rich:componentControl for="mmm001PopUpCommon_confirmDetail" attachTo="hide-mmm001PopUpCommon_confirmDetail" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMmm001PopUpCommon_confirmDetail">
		
			<rich:panel id="pnlRentalPayNormal">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                	<div id="tabconfirmChange" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
						<rich:dataTable id="dtbHistoryList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.confirmResultList}" var="historyObj"
						reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
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
			
				<div style="clear:both; height:10px;"></div>
	
			</rich:panel>
		</a4j:form>
	
	</rich:modalPanel>
	<!-- mmm001PopUpCommon_confirmDetail -->
	<!-- << [POPUP_22] -->
