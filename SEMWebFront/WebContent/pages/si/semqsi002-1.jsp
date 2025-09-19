<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.siteinfo.semqsi002" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green"
					infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<!-- begin content layout criteria -->
			<h:panelGrid width="96%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.locationId']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtLocationId"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.locationId}"
											size="18" maxlength="15" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.locationCode']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtLocationCode"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.locationCode}"
											size="18" maxlength="15" /></td>
									</tr>

									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.contractStatus']}" styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="ddlSiteStatus"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.siteStatus}">
											<f:selectItems value="#{semqsi002Bean.siteStatusList}" />
										</h:selectOneMenu></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.networkStatus']}" styleClass="ms7" />
										</td>
										<td width="30%"><h:selectOneMenu id="ddlNetworkStatus"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.networkStatus}">
											<f:selectItems value="#{semqsi002Bean.networkStatusList}" />
										</h:selectOneMenu></td>
									</tr>
									<tr>
									</tr>
									<tr>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.pmsStatus']}" styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="ddlPMSStatus"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.pmsStatus}">
											<f:selectItems value="#{semqsi002Bean.pmsStatusList}" />
										</h:selectOneMenu></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.contractNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtcontractNo"
											value="#{semqsi002Bean.queryNetworkStatusSearchSP.contractNo}"
											size="23" maxlength="20" /></td>

									</tr>
									<tr>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>

						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMQSI002-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMQSI002" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>

							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMQSI002-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMQSI002" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>

			<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid-->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"
								style="width:1040px" />
						</f:facet>
						<rich:dataTable id="dtbQueryNetworkSrch" cellpadding="1"
							cellspacing="0" border="0" var="queryNetworkStatusSearchSP"
							value="#{semqsi002Bean.queryNetworkStatusSearchSPList}"
							reRender="dstQueryNetworkSrch" rows="#{semqsi001Bean.rowPerPage}"
							styleClass="dataTable">

							<rich:column sortBy="#{queryNetworkStatusSearchSP.locationId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}"
										styleClass="contentform" style="width:72px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.locationId}"
									styleClass="contentform" style="width:72px" /></div>
							</rich:column>
							<rich:column sortBy="#{queryNetworkStatusSearchSP.locationCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}"
										styleClass="contentform" style="width:72px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.locationCode}"
									styleClass="contentform" style="width:72px" /></div>
							</rich:column>
							<rich:column sortBy="#{queryNetworkStatusSearchSP.siteStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}"
										styleClass="contentform" style="width:90px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.siteStatus}"
									styleClass="contentform" style="width:90px">
								</h:outputText></div>
							</rich:column>
							<rich:column sortBy="#{queryNetworkStatusSearchSP.networkStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}"
										styleClass="contentform" style="width:90px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.networkStatus}"
									styleClass="contentform" style="width:90px" /></div>
							</rich:column>

							<rich:column sortBy="#{queryNetworkStatusSearchSP.pmsStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pmsStatus']}"
										styleClass="contentform" style="width:90px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.pmsStatus}"
									styleClass="contentform" style="width:90px" /></div>
							</rich:column>
							<rich:column sortBy="#{queryNetworkStatusSearchSP.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}"
										styleClass="contentform" style="width:90px" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{queryNetworkStatusSearchSP.contractNo}"
									styleClass="contentform" style="width:90px" /></div>
							</rich:column>


							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left"
									for="dtbQueryNetworkSrch" maxPages="10"
									id="dstQueryNetworkSrch" selectedStyleClass="selectScroll" />
							</f:facet>

						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- End  -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
