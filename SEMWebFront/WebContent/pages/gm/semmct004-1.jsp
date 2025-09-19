<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<f:loadBundle basename="resources.gm.semmct004" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchCostCenter">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.pageName']}" />
		</f:facet>
		<a4j:form id="grdErrorMsg">
			<table width="100%" border="0">
				<tr>
					<td></td>
					<td><a4j:form id="frmError">
						<rich:messages layout="list" errorClass="ms7red"
							warnClass="ms7blue" infoClass="ms7green"
							style="width : 822px; height : 21px;"
							rendered="#{semmct004Bean.renderedMsgFormSearch}">
							<f:facet name="errorMarker">
								<h:graphicImage value="images/error.gif" />
							</f:facet>
						</rich:messages>
					</a4j:form></td>
				</tr>
			</table>
		</a4j:form>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%" border="0">
									<tr>
										<td align="right" width="10%" valign="bottom"><h:graphicImage
											value="images/icon_required.gif" /> <rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']} :"
											styleClass="ms7" /></td>
										<td colspan="1"><h:selectOneMenu
											label="#{jspMsg['label.All']}" id="ddlCompany"
											value="#{semmct004Bean.costCenterSearch.company}"
											onchange="setRequireValidate();">
											<f:selectItems value="#{semmct004Bean.companyList}" />
										</h:selectOneMenu> <a4j:jsFunction name="setRequireValidate"
											reRender="companyDisplay,grdErrorMsg">

										</a4j:jsFunction> <rich:spacer width="10"></rich:spacer> <h:outputText
											id="companyDisplay"
											value="#{semmct004Bean.costCenterSearch.company}"
											styleClass="ms28" /></td>
										<td align="right"><h:outputText
											value="#{jspMsg['label.region']} :" styleClass="ms7" /></td>
										<td><h:selectOneMenu label="#{jspMsg['label.All']}"
											id="ddlRegion"
											value="#{semmct004Bean.costCenterSearch.region}"
											onchange="setRequireValidate();">
											<f:selectItems value="#{semmct004Bean.regionList}" />
										</h:selectOneMenu> <h:outputText></h:outputText></td>
									</tr>

									<tr>
										<td align="right"><h:outputText
											value="#{jspMsg['column.header.costCenter']} :"
											styleClass="ms7" /></td>
										<td width="30%" colspan="3"><h:inputText
											id="txtCostCenter"
											value="#{semmct004Bean.costCenterSearch.costCenter}" /></td>
									</tr>

									<tr>
										<td align="right"><h:outputText
											value="#{jspMsg['label.recStatus']} :" styleClass="ms7" /></td>
										<td colspan="3"><h:selectOneMenu
											label="#{jspMsg['label.All']}" id="ddlStatus"
											value="#{semmct004Bean.costCenterSearch.recordStatus}"
											onchange="setRequireValidate();">
											<f:selectItems value="#{semmct004Bean.statusList}" />
										</h:selectOneMenu></td>
									</tr>

								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch"
								value="#{jspMsg['btn.label.search']}" styleClass="rich-button"
								action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult,grdErrorMsg">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>

							<a4j:commandButton id="btnClear"
								value="#{jspMsg['btn.label.clear']}" styleClass="rich-button"
								action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,grdErrorMsg">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>

			<!-- end content layout criteria -->
			<a4j:form id="frmButton">
				<!-- begin content button -->
				<h:panelGrid columns="3" id="grdAddCommand">
					<a4j:commandButton id="btnNew" styleClass="rich-button"
						action="#{navAction.navi}" value="#{jspMsg['btn.label.new']}"
						rendered="#{semmct004Bean.renderer['btnNew']}"
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT004-2" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="ADD" />
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
			</a4j:form>
			<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.costDetail']}"
								style="width: 1280" />
						</f:facet>
						<div align="center"><h:outputLabel
							style="color:red;size:20px"
							value="#{semmct004Bean.msgDataNotFound}"
							rendered="#{semmct004Bean.renderedMsgDataNotFound}" /></div>
						<div align="left"><h:message for="pnlSearchResult"
							errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>

						<rich:dataTable width="100%" id="costCenterTable" cellpadding="1"
							cellspacing="0" border="0" var="costCenter"
							value="#{semmct004Bean.costCenterList}"
							rows="#{semmct004Bean.rowPerPage}" rowClasses="cur"
							styleClass="dataTable">

							<rich:column styleClass="unClick" rendered="#{semmct004Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.edit']}"
										styleClass="contentform" style="width: 40" />
								</f:facet>
								<div align="center"><a4j:commandButton id="btnEdit"
									action="#{navAction.navi}" reRender="oppContent"
									image="images/edit.png" style="height: 15; width: 15">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT004-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
									<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									<a4j:actionparam name="costId" value="#{costCenter.dataObj.rowId}" />
									<a4j:actionparam name="mode" value="EDIT" />
								</a4j:commandButton></div>
							</rich:column>
							<rich:column styleClass="unClick" rendered="#{semmct004Bean.renderer['btnDelete']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.delete']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><a4j:commandButton
									oncomplete="#{rich:component('ccConfirmDelDialog')}.show(); return false"
									action="#{navAction.navi}" image="images/delete.png"
									rendered="#{semmct004Bean.renderer['btnDelete']}"
									style="height: 15; width: 15" >
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT004-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
									<a4j:actionparam name="methodWithNavi" value="initDel" />
									<a4j:actionparam name="costId" value="#{costCenter.dataObj.rowId}" />
								</a4j:commandButton></div>
							</rich:column>

							<rich:column styleClass="unClick" rendered="#{semmct004Bean.renderer['btnView']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.view']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><a4j:commandButton
									action="#{navAction.navi}" image="images/view.png"
									style="height: 15; width: 15" reRender="oppContent">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT004-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
									<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									<a4j:actionparam name="costId"
										value="#{costCenter.dataObj.rowId}" />
									<a4j:actionparam name="mode" value="VIEW" />
								</a4j:commandButton></div>
							</rich:column>
							<rich:column style="width: 90"
								sortBy="#{costCenter.dataObj.company}" styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.company']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{costCenter.dataObj.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column style="width:240"
								sortBy="#{costCenter.dataObj.costCenter}" styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.costCenter']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{costCenter.dataObj.costCenter}"
									styleClass="contentform" /></div>
							</rich:column>
							<rich:column sortBy="#{costCenter.dataObj.costDesc}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.costDesc']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{costCenter.dataObj.costDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{costCenter.dataObj.region}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.region']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{costCenter.dataObj.region}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{costCenter.dataObj.effectiveDate}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.eff_Date']}" styleClass="contentform">
									</h:outputText>
								</f:facet>
								<div align="center"><h:outputText
									value="#{costCenter.dataObj.effectiveDate}"
									styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText></div>
							</rich:column>
							<rich:column sortBy="#{costCenter.dataObj.recordStatus}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.recStatus']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{costCenter.dataObj.recordStatus}"
									styleClass="contentform" /></div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct004Bean.costCenterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="10">
										<rich:datascroller immediate="true" rendered="true"
											align="left" for="costCenterTable"
											maxPages="#{semmct004Bean.rowPerPage}"
											selectedStyleClass="selectScroll" stepControls="hide"
											fastControls="auto" boundaryControls="auto"
											id="dstCostCenter" style="background-color: #cccccc;"
											page="#{semmct004Bean.scrollerPage}" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>

						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="ccConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT004-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT004" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />
							<rich:componentControl for="ccConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No"  styleClass="rich-button" immediate="true">
						    <rich:componentControl for="ccConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
