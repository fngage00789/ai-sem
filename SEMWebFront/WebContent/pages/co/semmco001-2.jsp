<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<f:loadBundle basename="resources.co.semmco001" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlContract">
		<f:facet name="header">
			<h:outputText id="txtHeader"
				value="#{jspMsg['tab.header']} #{semmco001Bean.tabHeader}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmContractError">
				<rich:messages layout="list" globalOnly="true" errorClass="ms7red"
					warnClass="ms7blue" infoClass="ms7green"
					rendered="#{semmco001Bean.renderedMsgFormTop}">
					<f:facet name="header">
						<h:outputText value="Entered Data Status:"></h:outputText>
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="images/error.gif" />
					</f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGrid>

		<h:panelGrid columnClasses="gridContent" width="93%">
			<a4j:form id="frmContract">
				<h:panelGroup id="pnlButton">
					<table width="100%">
						<tr>
							<td width="50%" align="left"></td>
							<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td><a4j:commandButton id="btnView"
										value="#{jspMsg['btn.siteInfo']}" styleClass="rich-button"
										action="#{navAction.navi}" style="width:80"
										reRender="oppContent,pnlSiteInfo">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
										<a4j:actionparam name="methodWithNavi" value="initSiteInfo" />
										<a4j:actionparam name="rowId"
											value="#{semmco001Bean.siteInfoParam}" />
										<a4j:actionparam name="page" value="CONTRACT" />
										<a4j:actionparam name="mode" value="VIEW" />
									</a4j:commandButton></td>
									<td><a4j:commandButton id="btnBack"
										value="#{jspMsg['btn.back']}" styleClass="rich-button"
										action="#{navAction.navi}"
										reRender="oppContent,frmSearchCriteria,pnlSearchResult,dtbContract">
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
										<a4j:actionparam name="methodWithNavi" value="doBack" />
									</a4j:commandButton></td>
									<td><a4j:commandButton id="btnAdd"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										action="#{navAction.navi}"
										reRender="frmContract,frmContractError">
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO001-2" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
										<a4j:actionparam name="methodWithNavi" value="doUpdateTab" />
										<a4j:actionparam name="tabNo" value="#{semmco001Bean.tabNo}" />
									</a4j:commandButton></td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- start panel tab -->
				<rich:tabPanel  switchType="client" selectedTab="#{semmco001Bean.tabNo}">
					<!-- tab1 -->
					<rich:tab label="#{jspMsg['label.tab.contract']}" id="tab1" name="1"
						onlabelclick="setTabNo1();">
						<a4j:jsFunction name="setTabNo1"
							action="#{semmco001Action.setTabNo}"
							reRender="pnlTab1,txtHeader,pnlButton,frmFileUpload,frmContractError">
							<a4j:actionparam name="tabNo" value="1"></a4j:actionparam>
						</a4j:jsFunction>
						<jsp:include page="../../pages/co/semmco001tab1.jsp" />
					</rich:tab>
					<!-- tab2 -->
					<rich:tab label="#{jspMsg['label.tab.contractFile']}" id="tab2" name="2"
						onlabelclick="setTabNo2();" rendered="#{semmco001Bean.renderedTab2}">
						<a4j:jsFunction name="setTabNo2"
							action="#{semmco001Action.setTabNo}"
							reRender="pnlTab2,txtHeader,pnlButton,frmFileUpload,frmContractError">
							<a4j:actionparam name="tabNo" value="2"></a4j:actionparam>
						</a4j:jsFunction>
						<jsp:include page="../../pages/co/semmco001tab2.jsp" />
					</rich:tab>
					<!-- tab3 -->
					<rich:tab label="#{jspMsg['label.tab.contractDoc']}" id="tab3" name="3"
						onlabelclick="setTabNo3();">
						<a4j:jsFunction name="setTabNo3"
							action="#{semmco001Action.setTabNo}"
							oncomplete="renderChkBox();"
							reRender="pnlTab3,pnlRentalType,pnlRentalType1,txtHeader,pnlButton,frmFileUpload,frmContractError">
							<a4j:actionparam name="tabNo" value="3"></a4j:actionparam>
						</a4j:jsFunction>
						<jsp:include page="../../pages/co/semmco001tab3.jsp" />
					</rich:tab>
				</rich:tabPanel>
				<!-- end panel tab -->
			</a4j:form>
			
			<a4j:form id="frmFileUpload">
				<rich:panel id="pnlFileUpload" rendered="false">
					<h:panelGrid width="93%">
						<rich:panel>
							<f:facet name="header">
								<h:outputText value="Browse File" />
							</f:facet>
							<h:panelGrid>
								<rich:message for="txtFileUpload" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco001Bean.renderedMsgFormBottom}">
									<f:facet name="errorMarker">
										<h:graphicImage value="images/error.gif" />
									</f:facet>
								</rich:message>
							</h:panelGrid>
							
							<rich:fileUpload id="txtFileUpload" listHeight="58" listWidth="900px"
								fileUploadListener="#{fileUploadBean.listener}"
								immediateUpload="#{fileUploadBean.autoUpload}"
								allowFlash="#{fileUploadBean.useFlash}"
								addControlLabel="Browse..." 
								autoclear="true"
								disabled="#{!semmco001Bean.renderedColDel}">
								
								<a4j:support event="onuploadcomplete" reRender="oppContent" oncomplete="document.getElementById('incContent:frmContract:tab2_lbl').click();"
									action="#{navAction.navi}">
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO001TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
									<a4j:actionparam name="methodWithNavi" value="doCreateAttachment" />
									<a4j:actionparam name="refId" value="#{semmco001Bean.contractIdParam}" />
								</a4j:support>
	
								<f:facet name="label">
									<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
								</f:facet>
							</rich:fileUpload>
							<rich:spacer height="15"></rich:spacer>
							<rich:dataTable id="dtbFileUpload" width="97%"
								border="0" cellpadding="1" cellspacing="0"
								var="attachment" value="#{semmco001Bean.attachmentList}"
								rows="#{semmco001Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="dataTable">
								<rich:column width="5%"
									rendered="#{semmco001Bean.renderedColDel}">
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform" />
									</f:facet>
									<div align="center"><a4j:commandButton
										oncomplete="#{rich:component('mdpConfirmDelDialogAttachment')}.show(); return false"
										action="#{navAction.navi}" image="images/delete.png"
										style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO001TAB2" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
										<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
										<a4j:actionparam name="rowId" value="#{attachment.rowId}" />
									</a4j:commandButton></div>
								</rich:column>
	
								<rich:column sortBy="#{attachment.fileName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.fileName']}"
											styleClass="contentform" />
									</f:facet>
									<div align="left"><h:commandLink
										action="#{semmco001Action.doDownload}"
										value="#{attachment.fileName}"
										disabled="#{!semmco001Bean.renderedColDel}">
										<f:param name="pathName" value="#{attachment.attachmentPath}"></f:param>
										<f:param name="fileName" value="#{attachment.fileName}"></f:param>
									</h:commandLink></div>
								</rich:column>
								<rich:column sortBy="#{attachment.createBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.createBy']}"
											styleClass="contentform" />
									</f:facet>
									<div align="center"><h:outputText
										value="#{attachment.createBy}" styleClass="contentform" /></div>
								</rich:column>
								<rich:column sortBy="#{attachment.createDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.createDt']}"
											styleClass="contentform" />
									</f:facet>
									<div align="center"><h:outputText
										value="#{attachment.createDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy HH:mm:ss" locale="en" />
									</h:outputText></div>
								</rich:column>
	
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="left"
										for="dtbFileUpload" maxPages="10" id="dstFileUpload"
										selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
						</rich:panel>
					</h:panelGrid>
				</rich:panel>
			</a4j:form>
			
			<rich:panel id="pnlLog">
					<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%"><h:outputText
										value="#{jspMsg['label.createBy']}" styleClass="ms7" /></td>
									<td width="30%"><h:inputText id="txtCreateBy"
										value="#{semmco001Bean.createBy}" readonly="true"
										disabled="true" size="30" maxlength="50" /></td>
									<td align="right" width="20%"><h:outputText
										value="#{jspMsg['label.createDate']}" styleClass="ms7" /></td>
									<td width="30%"><rich:calendar id="cldCreateDate"
										locale="th" datePattern="dd/MM/yyyy HH:mm:ss"
										value="#{semmco001Bean.createDate}" showWeeksBar="false"
										inputSize="20" cellWidth="20px" cellHeight="20px"
										buttonIcon="/images/hide-button.png"
										buttonIconDisabled="/images/hide-button.png" disabled="true" />
									</td>
								</tr>

								<tr>
									<td align="right" width="20%"><h:outputText
										value="#{jspMsg['label.updateBy']}" styleClass="ms7" /></td>
									<td width="30%"><h:inputText id="txtUpdateBy"
										value="#{semmco001Bean.updateBy}" readonly="true"
										disabled="true" size="30" maxlength="50" /></td>
									<td align="right" width="20%"><h:outputText
										value="#{jspMsg['label.updateDate']}" styleClass="ms7" /></td>
									<td width="30%"><rich:calendar id="cldUpdateDate"
										locale="th" datePattern="dd/MM/yyyy HH:mm:ss"
										value="#{semmco001Bean.updateDate}" showWeeksBar="false"
										inputSize="20" cellWidth="20px" cellHeight="20px"
										buttonIcon="/images/hide-button.png"
										buttonIconDisabled="/images/hide-button.png" disabled="true" />
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<!-- Delete ContractStatus History -->
<rich:modalPanel id="mdpConfirmDelDialogContractStatusHistory"
	autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Delete"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialogContractStatusHistory">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="180px">
					<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="pnlContractStatusHistory,dtbContractStatusHistory,pnlEditContractStatus">
						<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
						<a4j:actionparam name="methodWithNavi"
							value="doDeleteContractStatusHistory" />
						<rich:componentControl
							for="mdpConfirmDelDialogContractStatusHistory" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl
							for="mdpConfirmDelDialogContractStatusHistory" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>

<!-- Delete Contract File -->
<rich:modalPanel id="mdpConfirmDelDialogContractFile" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Delete"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialogContractFile">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="180px">
					<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="pnlTab2pnlContractFile,pnlResultContractFile,dtbContractFile,frmContractError">
						<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO001TAB2" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab2" />
						<a4j:actionparam name="methodWithNavi"
							value="doDeleteContractFile" />
						<rich:componentControl for="mdpConfirmDelDialogContractFile"
							operation="hide" event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmDelDialogContractFile"
							operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelDialogAttachment" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
			<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
										   immediate="true" reRender="dtbFileUpload,txtFileUpload" >
							<a4j:actionparam name="navModule" value="co" />
	          				<a4j:actionparam name="navProgram" value="SEMMCO001TAB2" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<rich:componentControl for="mdpConfirmDelDialogAttachment" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialogAttachment" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
