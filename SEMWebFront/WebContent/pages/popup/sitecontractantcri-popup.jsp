<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi003" var="jspMsgPopup2" />
<rich:modalPanel id="popupSearchContractAntCri" width="750" height="550"
	moveable="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgPopup2['header.popup.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidepopupSearchContractAntCri" style="cursor:pointer" /> <rich:componentControl
				for="popupSearchContractAntCri"
				attachTo="hidepopupSearchContractAntCri" operation="hide"
				event="onclick" /></div>
		</h:panelGroup>
	</f:facet>

	<h:panelGrid>
		<a4j:form id="popupFrmError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue"
				infoClass="ms7green"
				rendered="#{popupSiteContractAntCriBean.renderedMsgFormSearch}">
				<f:facet name="header">
					<h:outputText value="Entered Data Status:"></h:outputText>
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="images/error.gif" />
				</f:facet>
			</rich:messages>
		</a4j:form>
	</h:panelGrid>

	<h:form id="popupFrmSearch">
		<h:panelGrid width="97%">
			<rich:panel id="pnlPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsgPopup2['header.criteria.name']}" />
				</f:facet>
				<!-- begin content criteria -->

				<h:panelGroup>
					<table width="97%" border="0" cellpadding="0" cellspacing="1">
						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgPopup2['label.company']}" styleClass="ms7" /></td>
							<td colspan="3"><h:selectOneMenu id="ddlPopupCompany"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.company}">
								<f:selectItems
									value="#{popupSiteContractAntCriBean.companyList}" />
							</h:selectOneMenu></td>
						</tr>
						<tr>
							<td align="right" width="22%"><h:outputText
								value="#{jspMsgPopup2['label.contractNo']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupContractNo"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.contractNo}" />
							</td>
							<td align="right" width="22%"><h:outputText
								value="#{jspMsgPopup2['label.siteName']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupSiteName"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.siteName}"
								size="41" /></td>
						</tr>
						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgPopup2['label.vendorName']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupVendorName"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.vendorName}" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgPopup2['label.vendorAddress']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupVendorAddress"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.vendorAddress}"
								size="41" /></td>
						</tr>

						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgPopup2['label.payeeName']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupPayeeName"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.payeeName}" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgPopup2['label.payeeAddress']}" styleClass="ms7" /></td>
							<td><h:inputText id="txtPopupPayeeAddress"
								value="#{popupSiteContractAntCriBean.popupContractCriteria.payeeAddress}"
								size="41" /></td>
						</tr>

						<tr>
							<td colspan="4"><!-- end content criteria --> <h:panelGroup>
								<a4j:commandButton id="btnPopupSearch"
									value="#{jspMsgPopup2['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}"
									reRender="popupFrmError, popupFrmSearch, pnlPopupSearchResult">
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram"
										value="sitecontractantcri-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi"
										value="PopupSiteContractAntCri" />
									<a4j:actionparam name="methodWithNavi"
										value="doSearchPopupContractNo" />
								</a4j:commandButton>
								<rich:spacer width="10"></rich:spacer>
								<a4j:commandButton id="btnClear"
									value="#{jspMsgPopup2['btn.clear']}" styleClass="rich-button"
									action="#{navAction.navi}"
									reRender="popupFrmError, popupFrmSearch, pnlPopupSearchResult">
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram"
										value="sitecontractantcri-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi"
										value="PopupSiteContractAntCri" />
									<a4j:actionparam name="methodWithNavi"
										value="doClearPopupContractNo" />
								</a4j:commandButton>
							</h:panelGroup></td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>

		<div style="overflow: auto; height: 100%; width: 100%"><rich:panel
			id="pnlPopupSearchResult">
			<f:facet name="header">
				<h:outputText
					value="#{jspMsgPopup2['header.popup.resultTable.name']}" />
			</f:facet>
			<h:panelGrid width="97%">
				<rich:dataTable id="dtbPopupContractNo" width="100%"
					value="#{popupSiteContractAntCriBean.contractList}"
					rowKeyVar="RegInd" var="contractSP"
					rows="#{popupSiteContractAntCriBean.rowPerPage}" rowClasses="cur"
					styleClass="dataTable">
					<a4j:support event="onRowClick"
						action="#{popupSiteContractAntCriAction.getRowIdOnClick}"
						reRender="dtbPopupContractNo">
						<a4j:actionparam name="rowId" value="#{contractSP.rowId}" />
					</a4j:support>

					<rich:column id="ContractNoSelect"
						styleClass="#{(popupSiteContractAntCriBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}"
						style="width:45px;">
						<div align="center"><a4j:commandLink id="cmlSelect"
							value="Select" action="#{navAction.navi}"
							reRender="pnlSearchCriteria,pnlPopupSearchResult">
							<a4j:actionparam name="navModule" value="common" />
							<a4j:actionparam name="navProgram" value="sitecontractantcri-popup" />
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupSiteContractAntCri" />
							<a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
							<a4j:actionparam name="contractNo" value="#{contractSP.contractNo}" />
							<rich:componentControl for="popupSearchContractAntCri"
								operation="hide" event="oncomplete" />
						</a4j:commandLink></div>
					</rich:column>
					<rich:column id="colContractNo" sortBy="#{contractSP.contractNo}"
						styleClass="#{(popupSiteContractAntCriBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsgPopup2['column.popup.header.contractNo']}"
								styleClass="contentform" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{contractSP.contractNo}" styleClass="contentform" /></div>
					</rich:column>

					<rich:column id="colSiteName" sortBy="#{contractSP.siteName}"
						styleClass="#{(popupSiteContractAntCriBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsgPopup2['column.popup.header.siteName']}"
								styleClass="contentform" />
						</f:facet>
						<div align="left"><h:outputText
							value="#{contractSP.siteName}" styleClass="contentform" /></div>
					</rich:column>
					<rich:column id="colEffDate" sortBy="#{contractSP.effDate}"
						styleClass="#{(popupSiteContractAntCriBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsgPopup2['column.header.popup.effDate']}"
								styleClass="contentform" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{contractSP.effDate}" styleClass="contentform">
							<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
						</h:outputText></div>
					</rich:column>
					<rich:column id="colExpDate" sortBy="#{contractSP.expDate}"
						styleClass="#{(popupSiteContractAntCriBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsgPopup2['column.header.popup.expDate']}"
								styleClass="contentform" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{contractSP.expDate}" styleClass="contentform">
							<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
						</h:outputText></div>
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller immediate="true" rendered="true" align="left"
							for="dtbPopupContractNo" maxPages="10" id="dstPopupContractNo"
							boundaryControls="auto" fastControls="auto" stepControls="autto"
							selectedStyleClass="selectScroll" />
					</f:facet>
				</rich:dataTable>
			</h:panelGrid>
		</rich:panel></div>
	</h:form>
</rich:modalPanel>

