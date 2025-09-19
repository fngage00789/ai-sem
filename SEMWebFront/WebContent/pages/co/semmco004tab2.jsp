<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid width="95%">
					<rich:panel id="pnlContractTot" rendered="false">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.contractTot']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
	                		<tr>
							<td align="left" colspan="2">
							<h:outputText value="#{jspMsg['label.caseAIS']}" styleClass="ms7" style="text-decoration: underline"/>
                			</td>
	                		</tr>
	               			<tr>
							<td align="right" width="30%">
							<h:outputText value="#{jspMsg['label.sendTOT']}" styleClass="ms7" />
                			</td>
                			<td align="left" width="70%">
							<h:selectOneRadio id="rbtTotSendFlag" value="#{semmco004tab1Bean.contract.totSendFlag}"  styleClass="ms7" rendered="true" 
							onclick="changeSend(this.value);" disabled="#{not semmco004tab1Bean.renderedEditTot}">
                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.send']} " />
                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.notSend']}"/>
                			</h:selectOneRadio>
                			<script type="text/javascript">
                				function changeSend(status){
                					if(status == 'N'){
										document.getElementById("incContent:frmContract:txtTotRemarkNotSend").style.display = '';
										document.getElementById("incContent:frmContract:remarkLabel").style.display = '';
										document.getElementById("incContent:frmContract:remarkRq").style.display = '';
									}else{
										document.getElementById("incContent:frmContract:txtTotRemarkNotSend").style.display = 'none';
										document.getElementById("incContent:frmContract:remarkLabel").style.display = 'none';
										document.getElementById("incContent:frmContract:remarkRq").style.display = 'none';
									}
                    			}
                			</script>
                			</td>
	                		</tr>
	                		<tr id="sendRemark">
							<td align="right" width="30%" valign="top">
							<h:graphicImage value="images/icon_required.gif" id="remarkRq" style="#{semmco004tab1Bean.contract.totSendFlag eq 'Y'?'display:none':''}"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.totRemarkNotSend']}" styleClass="ms7" style="#{semmco004tab1Bean.contract.totSendFlag eq 'Y'?'display:none':''}" id="remarkLabel"/>
                			</td>
                			<td align="left" width="70%">
                			 <h:inputTextarea id="txtTotRemarkNotSend" value="#{semmco004tab1Bean.contract.totRemarkNotSend}" 
                			 disabled="#{not semmco004tab1Bean.renderedEditDuty}"
                			 rows="3" cols="100" style="#{semmco004tab1Bean.contract.totSendFlag eq 'Y'?'display:none':''}"/>
                			</td>
	                		</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				</h:panelGrid>
	<h:panelGrid id="pnlTab2" width="95%">
		<rich:panel id="pnlContractFile">
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.tab.contractFile']}" />
			</f:facet>
			<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup >
					<table width="100%">
						<tr>     
							<td align="right" width="20%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.contractDocType']}" styleClass="ms7" />
							</td>
							<td width="60%">
								<h:selectOneMenu id="ddlContractDocType" value="#{semeco001Bean.contractDocType}">
									<f:selectItems value="#{semmco004tab2Bean.contractDocType}" />	 					
								</h:selectOneMenu>
								
								<rich:spacer width="10"></rich:spacer> 
								<a4j:commandButton id="btnPrint" styleClass="rich-button"
												   value="#{jspMsg['btn.create']}" 
												   action="#{navAction.navi}"
												   reRender="frmContract,frmContractError" >
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="report" />
									<a4j:actionparam name="actionWithNavi" value="SEMECO001" />
									<a4j:actionparam name="methodWithNavi" value="doRunReport" />
									<a4j:actionparam name="fromPage" value="SEMMCO004" />
									
									<a4j:support event="oncomplete" reRender="pnlResultContractFile" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO004TAB2" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO004Tab2" />
										<a4j:actionparam name="methodWithNavi" value="doSearchContractFile" />
									</a4j:support>
								</a4j:commandButton>
							</td>
							<td align="right" width="20%">
								<a4j:commandButton id="btnUploadPicture"
									action="#{navAction.navi}"
									reRender="oppContent,popupUploadPictureCriteria"
									value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
									oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
									<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
									<a4j:actionparam name="refId" value="" />
									<a4j:actionparam name="module" value="INTERNAL"/>
									<a4j:actionparam name="contractNo" value="#{semmco004Bean.contractNoParam}"/>
									<a4j:actionparam name="viewMode" value="N"/>
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
		<rich:spacer height="10"></rich:spacer>
		<!-- panel contract status history -->
		
		<rich:panel id="pnlResultContractFile">
			<f:facet name="header">
				<h:outputText value="#{jspMsg['header.panel.contractFile']}" />
			</f:facet>
			<rich:dataTable width="97%" id="dtbContractFile" cellpadding="1"
				cellspacing="0" border="0" var="contractFileSP"
				value="#{semmco004tab2Bean.contractFileSPList}"
				rows="10" rowClasses="cur"
				styleClass="dataTable">
				<a4j:support event="onRowClick"
					action="#{semmco004tab2Action.getRowIdOnClick}"
					reRender="dtbContractFile">
					<a4j:actionparam name="rowId" value="#{contractFileSP.rowId}" />
				</a4j:support>
				<rich:column
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="Delete" styleClass="contentform"
							style="width: 40" />
					</f:facet>
					<div align="center"><a4j:commandButton
						id="btnDeleteContractFile"
						oncomplete="#{rich:component('mdpConfirmDelDialogContractFile')}.show(); return false"
						action="#{navAction.navi}" image="images/delete.png"
						style="height: 15; width: 15">
						<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO004TAB2" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO004Tab2" />
						<a4j:actionparam name="methodWithNavi"
							value="initDeleteContractFile" />
						<a4j:actionparam name="rowId" value="#{contractFileSP.rowId}" />
					</a4j:commandButton></div>
				</rich:column>
				<rich:column
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="Download" styleClass="contentform"
							style="width: 40" />
					</f:facet>
					<div align="center">
					<h:commandLink id="btnDownloadFile" 
								   value="Download" 
								   action="#{semmco004tab2Action.doDownloadContractFile}">
						<a4j:support event="oncomplete" reRender="frmContractError"/>
						<f:param name="rowId" value="#{contractFileSP.rowId}" />
					</h:commandLink></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.contractDocTypeName}"
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText
							value="#{jspMsg['column.header.contractDocTypeName']}"
							styleClass="contentform" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{contractFileSP.contractDocTypeName}"
						styleClass="contentform">
					</h:outputText></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.fileName}"
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.FileName']}"
							styleClass="contentform" />
					</f:facet>
					<div align="left"><h:outputText
						value="#{contractFileSP.fileName}" styleClass="contentform" /></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.updateBy}"
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.updateBy2']}"
							styleClass="contentform" />
					</f:facet>
					<div align="left"><h:outputText
						value="#{contractFileSP.updateBy}" styleClass="contentform" /></div>
				</rich:column>
				<rich:column  sortBy="#{contractFileSP.updateDt}"
					styleClass="#{(semmco004tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.updateDate']}"
							styleClass="contentform" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{contractFileSP.updateDt}" styleClass="contentform">
						<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="en" />
					</h:outputText></div>
				</rich:column>
				<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco004tab2Bean.contractFileSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractFile"
											maxPages="#{semmco004tab2Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractFile" 
											style="background-color: #cccccc;"
											page="#{semmco004tab2Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
			</rich:dataTable>
		</rich:panel>
	</h:panelGrid>
</h:panelGrid>
