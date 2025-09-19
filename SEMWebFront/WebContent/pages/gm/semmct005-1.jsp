<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<f:loadBundle basename="resources.gm.semmct005" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchGLAcc">
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
							rendered="#{semmct005Bean.renderedMsgFormSearch}">
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
											value="#{semmct005Bean.glAccSearch.company}"
											onchange="setRequireValidate();">
											<f:selectItems value="#{semmct005Bean.companyList}" />
										</h:selectOneMenu> <a4j:jsFunction name="setRequireValidate"
											reRender="companyDisplay,grdErrorMsg">

										</a4j:jsFunction> <rich:spacer width="10"></rich:spacer> <h:outputText
											id="companyDisplay"
											value="#{semmct005Bean.glAccSearch.company}"
											styleClass="ms28" /></td>
										<td align="right"><h:outputText
											value="#{jspMsg['label.exType']} :" styleClass="ms7" /></td>
										<td><h:selectOneMenu label="#{jspMsg['label.All']}"
											id="ddlRegion"
											value="#{semmct005Bean.glAccSearch.expenseType}"
											onchange="setRequireValidate();">
											<f:selectItems value="#{semmct005Bean.expenseList}" />
										</h:selectOneMenu> <h:outputText></h:outputText></td>
									</tr>

									<tr>
										<td align="right"><h:outputText
											value="#{jspMsg['label.glAccount']} :"
											styleClass="ms7" /></td>
										<td><h:inputText
											id="txtGlAccount"
											value="#{semmct005Bean.glAccSearch.glAccount}" /></td>
                                        
                                        <td align="right"><h:outputText
                                            value="#{jspMsg['label.glType']} :" styleClass="ms7" /></td>
                                        <td><h:selectOneMenu label="#{jspMsg['label.All']}"
                                            id="glType"
                                            value="#{semmct005Bean.glAccSearch.glType}"
                                            onchange="setRequireValidate();">
                                            <f:selectItems value="#{semmct005Bean.glTypeList}" />
                                        </h:selectOneMenu> <h:outputText></h:outputText></td>
									</tr>

									<tr>
										<td align="right"><h:outputText
											value="#{jspMsg['label.recStatus']} :" styleClass="ms7" /></td>
										<td colspan="3"><h:selectOneMenu
											label="#{jspMsg['label.All']}" id="ddlStatus"
											value="#{semmct005Bean.glAccSearch.recordStatus}">
											<f:selectItems value="#{semmct005Bean.statusList}" />
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
								<a4j:actionparam name="navProgram" value="SEMMCT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>

							<a4j:commandButton id="btnClear"
								value="#{jspMsg['btn.label.clear']}" styleClass="rich-button"
								action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,grdErrorMsg">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
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
						rendered="#{semmct004Bean.renderer['btnNew']}"
						action="#{navAction.navi}" value="#{jspMsg['btn.label.add']}"
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT005-2" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
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
							<h:outputText value="#{jspMsg['label.glDetail']}"
								style="width: 1280" />
						</f:facet>
						<div align="center"><h:outputLabel
							style="color:red;size:20px"
							value="#{semmct005Bean.msgDataNotFound}"
							rendered="#{semmct005Bean.renderedMsgDataNotFound}" /></div>
						<div align="left"><h:message for="pnlSearchResult"
							errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>

						<rich:dataTable width="100%" id="glAccTable" cellpadding="1"
							cellspacing="0" border="0" var="glAcc"
							value="#{semmct005Bean.glAccList}"
							rows="#{semmct005Bean.rowPerPage}" rowClasses="cur"
							styleClass="dataTable">

							<rich:column styleClass="unClick" rendered="#{semmct005Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.edit']}"
										styleClass="contentform" style="width: 40" />
								</f:facet>
								<div align="center"><a4j:commandButton id="btnEdit"
									action="#{navAction.navi}" reRender="oppContent"
									image="images/edit.png" style="height: 15; width: 15">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT005-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
									<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									<a4j:actionparam name="glId" value="#{glAcc.dataObj.rowId}" />
									<a4j:actionparam name="mode" value="EDIT" />
								</a4j:commandButton></div>
							</rich:column>
							<rich:column styleClass="unClick" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.delete']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><a4j:commandButton
									oncomplete="#{rich:component('glConfirmDelDialog')}.show(); return false"
									action="#{navAction.navi}" image="images/delete.png"
									style="height: 15; width: 15" >
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT005-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
									<a4j:actionparam name="methodWithNavi" value="initDel" />
									<a4j:actionparam name="glId" value="#{glAcc.dataObj.rowId}" />
								</a4j:commandButton></div>
							</rich:column>

							<rich:column styleClass="unClick" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.view']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><a4j:commandButton
									action="#{navAction.navi}" image="images/view.png"
									style="height: 15; width: 15" reRender="oppContent"
									>
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT005-2" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
									<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									<a4j:actionparam name="glId"
										value="#{glAcc.dataObj.rowId}" />
									<a4j:actionparam name="mode" value="VIEW" />
								</a4j:commandButton></div>
							</rich:column>
							<rich:column style="width: 60"
								sortBy="#{glAcc.dataObj.company}" styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.company']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{glAcc.dataObj.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column style="width:70"
								sortBy="#{glAcc.dataObj.glAccount}" styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.glAccount']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{glAcc.dataObj.glAccount}"
									styleClass="contentform" /></div>
							</rich:column>
							<rich:column sortBy="#{glAcc.dataObj.glAccDesc}"
								styleClass="unClick" style="width:240">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.glAccDesc']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{glAcc.dataObj.glAccDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{glAcc.dataObj.expenseType}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.exType']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{glAcc.dataObj.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{glAcc.dataObj.glType}"
                                styleClass="unClick">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.glType']}"
                                        styleClass="contentform" />
                                </f:facet>
                                <div align="left"><h:outputText
                                    value="#{glAcc.dataObj.glType}"
                                    styleClass="contentform" /></div>
                            </rich:column>
							<rich:column sortBy="#{glAcc.dataObj.placeType}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.placeType']}" styleClass="contentform">
									</h:outputText>
								</f:facet>
								<div align="left"><h:outputText
									value="#{glAcc.dataObj.placeType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{glAcc.dataObj.effectiveDate}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.effDate']}" styleClass="contentform">
									</h:outputText>
								</f:facet>
								<div align="center"><h:outputText
									value="#{glAcc.dataObj.effectiveDate}"
									styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText></div>
							</rich:column>
							<rich:column sortBy="#{glAcc.dataObj.recordStatus}"
								styleClass="unClick">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.recStatus']}"
										styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{glAcc.dataObj.recordStatus}"
									styleClass="contentform" /></div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct005Bean.glAccList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="10">
										<rich:datascroller immediate="true" rendered="true"
											align="left" for="glAccTable"
											maxPages="#{semmct005Bean.rowPerPage}"
											selectedStyleClass="selectScroll" stepControls="hide"
											fastControls="auto" boundaryControls="auto"
											id="dstGLAccount" style="background-color: #cccccc;"
											page="#{semmct005Bean.scrollerPage}" />
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
<rich:modalPanel id="glConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct005Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />
							<rich:componentControl for="glConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No"  styleClass="rich-button" immediate="true">
						    <rich:componentControl for="glConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
