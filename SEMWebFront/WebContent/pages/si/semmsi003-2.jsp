<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.siteinfo.semmsi003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlAddSiteTerminate">
		<f:facet name="header">
		<h:outputText value="#{jspMsg['header.add.name']} - #{semmsi003Bean.pageStatus}"/>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmAddSiteTerminate">
			<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="50%" align="left">
					
				</td>
				<td width="50%" align="right" valign="bottom">
					<table id="tblButton">
					<tr>
					<td>
					<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent" rendered="#{semmsi003Bean.renderBtnBack}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI003"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		</td>
	           		<td>
	           		<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent,pnlAddSiteTerminate,frmAddSiteTerminate,frmError,pnlLog" rendered="#{semmsi003Bean.renderBtnSave}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI003-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
					<a4j:actionparam name="methodWithNavi" value="doUpdate" />
	           		</a4j:commandButton>
	           		</td>
	           		
	           		<td>
	           		<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" 
	           		oncomplete="#{rich:component('mdpConfirmResetDialog')}.show(); return false" 
	           		rendered="#{semmsi003Bean.renderBtnNew}">
	           		</a4j:commandButton>
	           		</td>
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
				
				<!-- begin content layout criteria -->
					<rich:panel id="pnlAddSiteTerminate">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
							<tr>
									<td align="right" width="25%" valign="baseline">
									<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="75%" colspan="3" valign="bottom">
		                			<h:selectOneMenu id="ddlCompany" value="#{semmsi003Bean.siteTerminate.company}"
		                			readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmsi003Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay,btnPopupSearchContractNo"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmsi003Bean.siteTerminate.company}" styleClass="ms28"/>
				                	</td>
			                	 </tr>
			                	 
							<tr>
									<td align="right" width="25%">
									<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtDocNo" value="#{semmsi003Bean.siteTerminate.docNo}" 
		                			readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"
		                			size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.cancelContractNo']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                			<h:panelGroup>
		                			<h:inputText id="txtContractNo" value="#{popupSiteContractBean.contractNo}" onchange="GetLocationListJS();"
		                			readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"
		                			size="23" maxlength="20"/>
		                			<a4j:jsFunction name="GetLocationListJS" reRender="frmAddSiteTerminate,dtbLocation" action="#{popupSiteContractAction.getLocationList}"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
									value="..."  reRender="popupSearchContractNo,popupFrmSearch"
				            		action="#{navAction.navi}"  rendered="#{semmsi003Bean.renderBtnPopup}">
				            		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI003-2" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
									<a4j:actionparam name="company" value="#{semmsi003Bean.siteTerminate.company}" />
									<a4j:actionparam name="page" value="semmsi003" />
		            				</a4j:commandButton>
		                			</h:panelGroup>
		                			
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtReqOfficer" value="#{semmsi003Bean.siteTerminate.reqOfficer}" 
		                			readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"
		                			size="30" maxlength="100"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.docDate']} :" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
									<rich:calendar id="cldDocDate" locale="th" enableManualInput="true"  
									datePattern="dd/MM/yyyy" 
									value="#{semmsi003Bean.siteTerminate.docDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									oninputkeyup="this.value = this.value.substring(0, 10);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.docDate']}"
									readonly="#{semmsi003Bean.disabledModeView}" 
									disabled="#{semmsi003Bean.disabledModeView}">
									<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmError" />
									<a4j:support event="onchanged" ajaxSingle="true" reRender="frmError" />
									</rich:calendar> 
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtTitle" value="#{semmsi003Bean.siteTerminate.title}"
		                			readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"
		                			size="30" maxlength="200"/>
		                			
				                	</td>
				                	
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtEffDate" value="#{popupSiteContractBean.effDate}" readonly="true" disabled="true" size="13" >
		                			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
		                			</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtExpDate" value="#{popupSiteContractBean.expDate}" readonly="true" disabled="true" size="13" >
		                			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
		                			</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 <td colspan="4">
			                	 <!-- begin content layout data grid -->
								 <rich:panel id="pnlResultSearchLocation">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.add.resultTable.name']}"/> 
									</f:facet>
									<rich:dataTable width="97%" id="dtbLocation" cellpadding="1" cellspacing="0" border="0"
									var="siteInfoMapLocSP" value="#{popupSiteContractBean.siteInfoMapLocSPList}" reRender="dtbLocation" 
									rows="#{popupSiteContractBean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
									<a4j:support event="onRowClick"   action="#{semmsi003Action.getRowIdOnClick}" reRender="dtbLocation">
										<a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
									</a4j:support>
											<rich:column sortBy="#{siteInfoMapLocSP.locationId}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" />
												</f:facet>
												<div align="center">
													<h:outputText value="#{siteInfoMapLocSP.locationId}" styleClass="contentform"  />
												</div>
											</rich:column>
											<rich:column sortBy="#{siteInfoMapLocSP.locationCode}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.locationCode']}" styleClass="contentform" />
												</f:facet>
												<div align="center">
													<h:outputText value="#{siteInfoMapLocSP.locationCode}" styleClass="contentform"></h:outputText>
												</div>
											</rich:column>
											<rich:column sortBy="#{siteInfoMapLocSP.locationName}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.locationName']}" styleClass="contentform" />
												</f:facet>
												<div align="left">
													<h:outputText value="#{siteInfoMapLocSP.locationName}" styleClass="contentform"  />
												</div>
											</rich:column>
											<rich:column sortBy="#{siteInfoMapLocSP.region}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform" />
												</f:facet>
												<div align="center">
													<h:outputText value="#{siteInfoMapLocSP.region}" styleClass="contentform"  />
												</div>
											</rich:column>
											<rich:column sortBy="#{siteInfoMapLocSP.stationType}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.stationType']}" styleClass="contentform" />
												</f:facet>
												<div align="center">
													<h:outputText value="#{siteInfoMapLocSP.stationType}" styleClass="contentform"  />
												</div>
											</rich:column>
											<rich:column sortBy="#{siteInfoMapLocSP.networkStatus}" styleClass="#{(semmsi003Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform" />
												</f:facet>
												<div align="center">
													<h:outputText value="#{siteInfoMapLocSP.networkStatus}" styleClass="contentform"  />
												</div>
											</rich:column>								
											<f:facet name="footer">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLocation" 
													maxPages="10" id="dstLocation" selectedStyleClass="selectScroll" />
											</f:facet>
										</rich:dataTable>
								</rich:panel>
								<!-- end content layout data grid -->
			                	 </td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 <td align="right" valign="top" width="25%">
			                	 <h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
			                	 </td>
			                	 <td colspan="3">
			                	 <h:inputTextarea id="txtDetail" value="#{semmsi003Bean.siteTerminate.detail}" 
			                	 rows="3" cols="100" readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"/>
			                	 </td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 <td align="right" width="25%">
			                	 <h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
			                	 	<h:outputText value="#{jspMsg['label.invalidDate']} :" styleClass="ms7"/>
			                	 	</h:panelGroup>
			                	 </td>
			                	 <td colspan="3">
									<rich:calendar id="cldInvalidDate" locale="th" enableManualInput="true"  
									datePattern="dd/MM/yyyy" 
									value="#{semmsi003Bean.siteTerminate.invalidDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									oninputkeyup="this.value = this.value.substring(0, 10);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.invalidDate']}"
									readonly="#{semmsi003Bean.disabledModeView}" 
									disabled="#{semmsi003Bean.disabledModeView}">
									<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmError" />
									<a4j:support event="onchanged" ajaxSingle="true" reRender="frmError" />
									</rich:calendar> 
			                	 </td>
			                	 </tr>
			                	 
			                	  <tr>
			                	 <td align="right" valign="top" width="25%">
			                	 <h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
			                	 </td>
			                	 <td colspan="3">
			                	 <h:inputTextarea id="txtRemark" value="#{semmsi003Bean.siteTerminate.remark}" 
			                	 rows="3" cols="100" readonly="#{semmsi003Bean.disabledModeView}" disabled="#{semmsi003Bean.disabledModeView}"/>
			                	 </td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				<!-- end content layout criteria -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlLog" >
				
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtCreateBy" value="#{semmsi003Bean.siteTerminate.createBy}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			 <rich:calendar id="cldCreateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="#{semmsi003Bean.siteTerminate.createDt}" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtUpdateBy" value="#{semmsi003Bean.siteTerminate.updateBy}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			 <rich:calendar id="cldUpdateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="#{semmsi003Bean.siteTerminate.updateDt}" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
				                	</td>
				                	
			                	 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
					
					</rich:panel>
					
				
			</a4j:form>
		</h:panelGrid>
		<jsp:include page="../../pages/popup/sitecontract-popup.jsp" />
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmResetDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmResetDialog">
		<table width="270px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="250px">
						<h:outputText value="#{semmsi003Bean.confirmResetMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="pnlAddSiteTerminate,frmAddSiteTerminate,dtbLocation,pnlLoctionList,frmError" >
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
							<a4j:actionparam name="methodWithNavi" value="doReset" />							
							<rich:componentControl for="mdpConfirmResetDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmResetDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>