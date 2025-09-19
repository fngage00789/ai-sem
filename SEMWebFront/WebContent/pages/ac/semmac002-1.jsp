<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac002" var="jspMsg"/>
<h:panelGrid width="100%" style="text-align: center;">
	<rich:panel style="text-align: left;">
		<f:facet name="header">
				<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
				<tr><td></td>
				<td>
				<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac002Bean.renderedMsgFormSearch}">
					 		<f:facet name="header">
	                        	<h:outputText value="Entered Data Status:"></h:outputText>
	                    	</f:facet>
				 			<f:facet name="errorMarker">
				 				 <h:graphicImage value="images/error.gif" />  
		                    </f:facet>
	                </rich:messages>
				</a4j:form>
				</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="95%">
			<!-- begin content layout criteria -->
			<h:panelGrid width="95%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria" ><%--rendered="#{semmac002Bean.renderer['pnlSearchCriteria']}" --%>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="baseline">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>										
										</td>
										<td colspan="3" width="80%" valign="bottom">
											<h:inputText id="txtFileName" value="#{semmac002Bean.sapTrxLogSrch.fileName}" size="23" maxlength="100" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%" valign="baseline">
											<h:outputText value="#{jspMsg['label.status']}" styleClass="ms7" />										
										</td>
										<td colspan="3" width="80%" valign="bottom">
											<h:selectOneMenu id="ddlStatus" value="#{semmac002Bean.sapTrxLogSrch.status}">
												<f:selectItems value="#{semmac002Bean.sapStatusList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%" valign="baseline"><h:panelGroup>
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</h:panelGroup></td>
										<td colspan="3" width="80%" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmac002Bean.sapTrxLogSrch.company}"
												onchange="GetCompanyJS();">
												<f:selectItems value="#{semmac002Bean.companyList}" />
											</h:selectOneMenu> 
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" />
											<rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmac002Bean.sapTrxLogSrch.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtCreateBy" value="#{semmac002Bean.sapTrxLogSrch.createBy}" size="15" maxlength="50"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:inputText id="txtUpdateBy" value="#{semmac002Bean.sapTrxLogSrch.updateBy}" size="15" maxlength="50"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="cldCreateDtFrom"
												locale="th" enableManualInput="true" datePattern="dd/MM/yyyy"
												value="#{semmac002Bean.sapTrxLogSrch.createDtFrom}" showWeeksBar="false" inputSize="8"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputkeyup="this.value = this.value.substring(0, 10);" cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.createDtFrom']}">
												<%--a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldCreateDtTo">
													<a4j:actionparam name="navModule" value="ac" />
													<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
													<a4j:actionparam name="moduleWithNavi" value="ac" />
													<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
												</a4j:support>
												<a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldCreateDtTo">
													<a4j:actionparam name="navModule" value="ac" />
													<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
													<a4j:actionparam name="moduleWithNavi" value="ac" />
													<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
												</a4j:support--%>
											</rich:calendar> 
											<rich:spacer width="3" /><h:outputText value="-" styleClass="ms7" /> <rich:spacer width="3" /> 
											<rich:calendar id="cldCreateDtTo" showWeeksBar="false" locale="th/TH"
												enableManualInput="true" datePattern="dd/MM/yyyy" value="#{semmac002Bean.sapTrxLogSrch.createDtTo}"
												inputSize="8" oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputkeyup="this.value = this.value.substring(0, 10);" cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.createDtTo']}" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="cldUpdateDtFrom"
												locale="th" enableManualInput="true" datePattern="dd/MM/yyyy"
												value="#{semmac002Bean.sapTrxLogSrch.updateDtFrom}" showWeeksBar="false" inputSize="8"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputkeyup="this.value = this.value.substring(0, 10);" cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.updateDtFrom']}">
												<%--a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldUpdateDtTo">
													<a4j:actionparam name="navModule" value="ac" />
													<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
													<a4j:actionparam name="moduleWithNavi" value="ac" />
													<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
												</a4j:support>
												<a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldUpdateDtTo">
													<a4j:actionparam name="navModule" value="ac" />
													<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
													<a4j:actionparam name="moduleWithNavi" value="ac" />
													<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
												</a4j:support--%>
											</rich:calendar> 
											<rich:spacer width="3" /><h:outputText value="-" styleClass="ms7" /> <rich:spacer width="3" /> 
											<rich:calendar id="cldUpdateDtTo" showWeeksBar="false" locale="th/TH"
												enableManualInput="true" datePattern="dd/MM/yyyy" value="#{semmac002Bean.sapTrxLogSrch.updateDtTo}"
												inputSize="8" oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputkeyup="this.value = this.value.substring(0, 10);" cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.updateDtTo']}" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
							
							<h:panelGrid columns="3" id="grdSearchCommand">
								<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmError,pnlSearchResult" >
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />							
								</a4j:commandButton>
								<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSearchCriteria">
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC002-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC002" />
									<a4j:actionparam name="methodWithNavi" value="doClearSession" />							
								</a4j:commandButton>
							</h:panelGrid>
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
			<!-- end content layout criteria -->
			
			<a4j:form id="frmSearchResult">				
				<!-- begin content button-->
				<%--h:panelGrid id="grdAddNewCommand" columns="6"></h:panelGrid--%>
				<table border="0" width="95%">
					<tr>
						<td align="left">
							<a4j:commandButton id="btnReGenerate" value="#{jspMsg['btn.regenerate']}" styleClass="rich-button" 
								disabled="#{semmac002Bean.disabler['btnReGenerate'] or semmac002Bean.disabledBtnRegenerate}" 
								rendered="#{semmac002Bean.renderer['btnReGenerate']}" />
						</td>
						<td align="right">
							<a4j:commandButton id="btnLoadResponse" value="#{jspMsg['btn.loadresponse']}" styleClass="rich-button" 
								rendered="#{semmac002Bean.renderer['btnLoadResponse']}" disabled="#{semmac002Bean.disabler['btnLoadResponse']}" /><%--rendered="#{semmac002Bean.renderer['btnLoadResponse']}" disabled="#{semmac002Bean.disabler['btnLoadResponse']}"--%>
							<a4j:commandButton id="btnLoadCancelDoc" value="#{jspMsg['btn.loadcanceldoc']}" styleClass="rich-button" 
								rendered="#{semmac002Bean.renderer['btnLoadCancelDoc']}" disabled="#{semmac002Bean.disabler['btnLoadCancelDoc']}" /><%--rendered="#{semmac002Bean.renderer['btnLoadCancelDoc']}" disabled="#{semmac002Bean.disabler['btnLoadCancelDoc']}"--%>
							<a4j:commandButton id="btnLoadPayment" value="#{jspMsg['btn.loadpayment']}" styleClass="rich-button" 
								rendered="#{semmac002Bean.renderer['btnLoadPayment']}" disabled="#{semmac002Bean.disabler['btnLoadPayment']}" /><%--rendered="#{semmac002Bean.renderer['btnLoadPayment']}" disabled="#{semmac002Bean.disabler['btnLoadPayment']}"--%>
							<a4j:commandButton id="btnLoadVendor" value="#{jspMsg['btn.loadvendor']}" styleClass="rich-button" 
								rendered="#{semmac002Bean.renderer['btnLoadVendor']}" disabled="#{semmac002Bean.disabler['btnLoadVendor']}" /><%--rendered="#{semmac002Bean.renderer['btnLoadVendor']}" disabled="#{semmac002Bean.disabler['btnLoadVendor']}"--%>
							<a4j:commandButton id="btnLoadCancelText" value="#{jspMsg['btn.loadcanceltext']}" styleClass="rich-button" 
								rendered="#{semmac002Bean.renderer['btnLoadCancelText']}" disabled="#{semmac002Bean.disabler['btnLoadCancelText']}" /><%--rendered="#{semmac002Bean.renderer['btnLoadCancelText']}" disabled="#{semmac002Bean.disabler['btnLoadCancelText']}" --%>
						</td>
					</tr>
				</table>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="Table Result" style="width: 100%"/>
						</f:facet>
						<rich:dataTable width="100%" id="dtbSapTrxLogSrch" cellpadding="1" cellspacing="0" border="0"
							var="wrapSapTrxLog" value="#{semmac002Bean.sapTrxLogSrchList}" reRender="dstSapTrxLogSrch" 
							rows="#{semmac002Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur" >
							
							<%--a4j:support event="onRowClick" action="#{semmac002Action.getRowIdOnClick}" >
								<a4j:actionparam name="rowId" value="#{wrapSapTrxLog.dataObj.rowId}" />
							</a4j:support--%>
							
							<rich:column >
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmac002Bean.chkSelAll}" style="width: 20px" onclick="onChechAllClick();onRenderButton();">
										<a4j:jsFunction name="onChechAllClick" action="#{semmac002Action.selectAllRow}" reRender="dtbSapTrxLogSrch" />
										<a4j:jsFunction name="onRenderButton" action="#{semmac002Action.onRenderAddButton}" reRender="btnReGenerate" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox value="#{wrapSapTrxLog.checkBox}" disabled="#{wrapSapTrxLog.dataObj.disableCheckBox}" ><%--onclick="onRenderButton()"--%>
										<%--a4j:jsFunction name="onRenderButton" action="#{semmac002Action.onRenderAddButton}" reRender="btnReGenerate" /--%>
										<a4j:support event="onclick" action="#{semmac002Action.onRenderAddButton}" reRender="btnReGenerate">
											<a4j:actionparam name="rowId" value="#{wrapSapTrxLog.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>  
								</div>
							</rich:column>
							<rich:column width="5%" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnView" image="images/view.png" style="height: 15; width: 15" title="view" 
	            						reRender="dtbSapTrxLogSrch,popupFrmAct" action="#{semmac002Action.getRowIdOnClick}" 
	            						oncomplete="#{rich:component('popupInterfaceSAP')}.show(); return false;" >
										<a4j:actionparam name="rowId" value="#{wrapSapTrxLog.dataObj.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{wrapSapTrxLog.dataObj.fileName}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.fileName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<%--a4j:commandLink value="#{wrapSapTrxLog.dataObj.fileName}" reRender="dtbSapTrxLogSrch,popupFrmAct"  
										oncomplete="#{rich:component('popupInterfaceSAP')}.show(); return false;" 
										action="#{semmac002Action.getRowIdOnClick}">
										<a4j:actionparam name="rowId" value="#{wrapSapTrxLog.dataObj.rowId}" />
									</a4j:commandLink>
									<a4j:commandLink value="#{wrapSapTrxLog.dataObj.fileName}" /--%>
									<h:outputText value="#{wrapSapTrxLog.dataObj.fileName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{wrapSapTrxLog.dataObj.status}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.status']}" styleClass="contentform"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.status}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{wrapSapTrxLog.dataObj.company}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{wrapSapTrxLog.dataObj.createBy}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.createBy']}"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.createBy}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{wrapSapTrxLog.dataObj.createDt}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.createDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.createDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{wrapSapTrxLog.dataObj.updateBy}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.updateBy}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{wrapSapTrxLog.dataObj.updateDt}" styleClass="#{(semmac002Bean.tmpRowId==wrapSapTrxLog.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{wrapSapTrxLog.dataObj.updateDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSapTrxLogSrch" 
									maxPages="10" id="dstSapTrxLogSrch" selectedStyleClass="selectScroll" page="#{semmac002Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>	
			<jsp:include page="../../pages/ac/semmac002-popup.jsp"/>		
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

