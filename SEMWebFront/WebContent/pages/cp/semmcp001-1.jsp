<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<f:loadBundle basename="resources.construction.semmcp001" var="jspMsg"/>
<h:panelGrid width="100%">
<rich:panel>
	<f:facet name="header">
		<h:outputText value="#{jspMsg['header.name']}"/>
	</f:facet>
	<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
	</h:panelGrid>
	<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mcp001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmcp001Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
			                  <a4j:actionparam name="navModule" value="cp" />
			                  <a4j:actionparam name="navProgram" value="SEMMCP001-0" />
			                  
			                  <a4j:actionparam name="moduleWithNavi" value="cp" />
			                  <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
			                  <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
			                  
			                  <a4j:actionparam name="backWard" value="Y" />
			                                        
			              </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
    </h:panelGrid>
	<h:panelGrid columnClasses="gridContent" width="100%">
	<!-- begin content layout criteria -->
					<h:panelGrid width="96%">
					<a4j:form id="frmSearch">
						<rich:panel id="pnlSearchCriteria">
							<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr valign="baseline">
										<td align="right" width="20%"><h:panelGroup>
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}"
												styleClass="ms7" />
										</h:panelGroup></td>
										<td width="30%">
										<h:selectOneMenu id="ddlCompany"
											value="#{semmcp001Bean.constructionPermissionForSearch.companyCri}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmcp001Bean.companyList}" />
											<a4j:jsFunction name="GetCompanyJS" action="#{navAction.navi}" oncomplete="ConStatusChange();"
															 reRender="companyDisplay,ddlConstructType,ddlConstructStatus,pnlSearchCriteria">
																<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
																<a4j:actionparam name="moduleWithNavi" value="cp" />
																<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
																<a4j:actionparam name="methodWithNavi" value="companyChange" />
											</a4j:jsFunction>
										</h:selectOneMenu>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmcp001Bean.constructionPermissionForSearch.companyCri}" styleClass="ms28"/>
										</td>
										<td align="right" width="20%" ><h:outputText
											value="#{jspMsg['label.region']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:selectOneMenu id="ddlRegion"	value="#{semmcp001Bean.constructionPermissionForSearch.regionCri}">
												<f:selectItems value="#{semmcp001Bean.regionList}" />
											</h:selectOneMenu>
										</td>		
									</tr>

									<tr valign="bottom">
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText
											value="#{jspMsg['label.contractNo']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:inputText id="txtcontractNo" 
												value="#{semmcp001Bean.constructionPermissionForSearch.contractNoCri}"
												size="18" maxlength="15" disabled="#{semmcp001Bean.constructionPermissionForSearch.contractNo}"/>
										<h:selectBooleanCheckbox  value="#{semmcp001Bean.constructionPermissionForSearch.noContractMigrate}" />
											<rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.noContract']}" styleClass="ms7" /> 			
										</td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.siteName']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtLocationName"
											value="#{semmcp001Bean.constructionPermissionForSearch.siteNameCri}"
											size="30" maxlength="200" /></td>
									</tr>

									<tr valign="bottom">
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" /></td>
										<td width="30%">
										<h:inputText id="txtLocationId"
											value="#{semmcp001Bean.constructionPermissionForSearch.locationIdCri}"
											size="18" maxlength="15" /></td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteConstructStatusName']}"
											styleClass="ms7" /></td>
										<td width="30%">
											<h:selectOneMenu id="ddlSiteConstructStatus" value="#{semmcp001Bean.constructionPermissionForSearch.siteConstructStatusCri}" onchange="changeStatus();ConStatusChange();">
												<f:selectItems value="#{semmcp001Bean.siteConstructStatusTmpList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="changeStatus" action="#{semmcp001Action.changeStatus}" reRender="frmSearch">
											</a4j:jsFunction>
											<script type="text/javascript">
												function ConStatusChange(){
												/*	var val = document.getElementById('incContent:frmSearch:ddlSiteConstructStatus').value;
													var comVal = document.getElementById('incContent:frmSearch:ddlCompany').value;
													if(val != "01" || comVal == null){
														document.getElementById('incContent:frmSearch:txtDocNo').disabled = true;
														document.getElementById('incContent:frmSearch:txtSupplier').disabled = true;
														document.getElementById('incContent:frmSearch:totSendDocNo').disabled = true;
														document.getElementById('incContent:frmSearch:totRefDocNo').disabled = true;
														document.getElementById('incContent:frmSearch:txtConPermissionDocNo').disabled = true;
														document.getElementById('incContent:frmSearch:txtConBuildDocNo').disabled = true;
														document.getElementById('incContent:frmSearch:ddlConstructType').disabled = true;
														document.getElementById('incContent:frmSearch:ddlConstructStatus').disabled = true;
														document.getElementById('incContent:frmSearch:txtConBillNo').disabled = true;
														document.getElementById('incContent:frmSearch:ddlConBillPayStatus').disabled = true;
														
														// clear fields
														document.getElementById('incContent:frmSearch:txtDocNo').value = '';
														document.getElementById('incContent:frmSearch:txtSupplier').value = '';
														document.getElementById('incContent:frmSearch:totSendDocNo').value = '';
														document.getElementById('incContent:frmSearch:totRefDocNo').value = '';
														document.getElementById('incContent:frmSearch:txtConPermissionDocNo').value = '';
														document.getElementById('incContent:frmSearch:txtConBuildDocNo').value = '';
														document.getElementById('incContent:frmSearch:ddlConstructType').value = '';
														document.getElementById('incContent:frmSearch:ddlConstructStatus').value = '';
														document.getElementById('incContent:frmSearch:txtConBillNo').value = '';
														document.getElementById('incContent:frmSearch:ddlConBillPayStatus').value = '';
													}else{
														document.getElementById('incContent:frmSearch:txtDocNo').disabled = false;
														document.getElementById('incContent:frmSearch:txtSupplier').disabled = false;
														document.getElementById('incContent:frmSearch:totSendDocNo').disabled = false;
														document.getElementById('incContent:frmSearch:totRefDocNo').disabled = false;
														document.getElementById('incContent:frmSearch:txtConPermissionDocNo').disabled = false;
														document.getElementById('incContent:frmSearch:txtConBuildDocNo').disabled = false;
														document.getElementById('incContent:frmSearch:ddlConstructType').disabled = false;
														document.getElementById('incContent:frmSearch:ddlConstructStatus').disabled = false;
														document.getElementById('incContent:frmSearch:txtConBillNo').disabled = false;
														document.getElementById('incContent:frmSearch:ddlConBillPayStatus').disabled = false;
													}*/
												}
											</script>
										</td>
									</tr>
									
									<tr valign="bottom">
										<td align="right" width="20%">
										
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:inputText id="txtLocationCode"
											value="#{semmcp001Bean.constructionPermissionForSearch.locationCodeCri}"
											size="18" maxlength="15" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteCode']}"
											styleClass="ms7" /></td>
										<td width="30%">
											<h:inputText id="txtSiteCode"
											value="#{semmcp001Bean.constructionPermissionForSearch.siteCodeCri}"
											size="18" maxlength="15" />
											
										</td>
									</tr>

									<tr valign="bottom">
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.docNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtDocNo"
											value="#{semmcp001Bean.constructionPermissionForSearch.docNoCri}"
											disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											size="23" maxlength="20" />
											
											
											
										</td>
										
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.supplier']}" styleClass="ms7" /></td>
										<td width="30%">
										
										<h:inputText id="txtSupplier"
											value="#{semmcp001Bean.constructionPermissionForSearch.supplierNameCri}"
											disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											size="30" maxlength="255" />
										</td>
									</tr>
									
									<tr valign="bottom">
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.totSendDocNo']} :" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="totSendDocNo" disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											value="#{semmcp001Bean.constructionPermissionForSearch.totSendDocNoCri}"
											size="23" maxlength="20" />
										</td>
										
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.totRefDocNo']} :" styleClass="ms7" /></td>
										<td width="30%">
										
										<h:inputText id="totRefDocNo"
											value="#{semmcp001Bean.constructionPermissionForSearch.totRefDocNoCri}"
											disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											size="30" maxlength="255" />
										</td>
									</tr>

									<tr valign="bottom">
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.conPermissionDocNo']}"
											styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtConPermissionDocNo"
											value="#{semmcp001Bean.constructionPermissionForSearch.conPermissionDocNoCri}" disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											size="23" maxlength="20" /></td>
										
										<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.conBuildDocNo']}" styleClass="ms7" />

										</td>
										<td width="30%">
										<h:inputText id="txtConBuildDocNo"
											value="#{semmcp001Bean.constructionPermissionForSearch.conBuildDocNoCri}"
											disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											size="23" maxlength="20" />
									</td>
									</tr>
									<tr valign="bottom">
										<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.constructType']}" styleClass="ms7" />
										</td>
										<td width="30%">
										
										<h:selectOneMenu id="ddlConstructType"  value="#{semmcp001Bean.constructionPermissionForSearch.constructTypeCri}" onchange="changeDDLConstructionStatus();" 
										disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}" >  
											<f:selectItems value="#{semmcp001Bean.constructTypeList}" />
										</h:selectOneMenu>
										<a4j:jsFunction name="changeDDLConstructionStatus" action="#{navAction.navi}"
															 reRender="ddlConstructStatus">
																<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
																<a4j:actionparam name="moduleWithNavi" value="cp" />
																<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
																<a4j:actionparam name="methodWithNavi" value="changeCriteriaConstructStatusListDropdown" />
											   				</a4j:jsFunction>
										</td>
										
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.constructStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlConstructStatus" value="#{semmcp001Bean.constructionPermissionForSearch.constructStatusCri}" disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}">
													<f:selectItems value="#{semmcp001Bean.constructStatusList}" />
											</h:selectOneMenu>
										</td>

									</tr>									
									<tr valign="bottom">
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.conBillNo']}" styleClass="ms7" /></td>
										<td>
										<h:inputText id="txtConBillNo" disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}"
											value="#{semmcp001Bean.constructionPermissionForSearch.conBillNoCri}"
											size="23" maxlength="20" />
										</td>
										
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.conBillPayStatus']}" styleClass="ms7" />
										</td>
										<td>
										<h:selectOneMenu id="ddlConBillPayStatus" value="#{semmcp001Bean.constructionPermissionForSearch.conBillPayStatusCri}" disabled="#{semmcp001Bean.constructionPermissionForSearch.checkDisabled}">
												<f:selectItems value="#{semmcp001Bean.conBillPayStatusList}" />
										</h:selectOneMenu>
										</td>
										
									
								 </tr>
								 <tr valign="bottom">
								 <td align="right" width="20%">
									
								 </td>
								 <td>
								 
								 	<h:selectOneRadio id="rbtMigrateType" 
								 	 value="#{semmcp001Bean.constructionPermissionForSearch.migrateFlagCri}"
								 	 layout="lineDirection"	styleClass="ms7" rendered="true" >
											<a4j:jsFunction name="rentTypeShow"  reRender="frmSearch,pnlMigrateFlag"/>
											<f:selectItem itemValue="Y" itemLabel="New"  />
											<f:selectItem itemValue="N" itemLabel="Existing" />	
									</h:selectOneRadio>
									 
								 </td>
								 <td align="right" width="20%">									
									<h:outputText value="#{jspMsg['label.dummy']}" styleClass="ms7" /> 	
											
								 </td>
								 <td>
								 	<h:selectBooleanCheckbox value="#{semmcp001Bean.constructionPermissionForSearch.dummyFlagMigrate}"/>
									<rich:spacer width="5" />	
								 </td>
								 </tr>
								 
							</table>
									</h:panelGroup>
								</h:panelGrid>
								
					<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult" oncomplete="ConStatusChange();">
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			           		<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
					</h:panelGrid>
							</rich:panel>
						</a4j:form>
					</h:panelGrid>						
					<a4j:form id="frmSearchResult">	
						<!-- begin content layout data grid-->	
						
						<h:outputText value="#{queryConstrucSearchSP.siteInfoId}"></h:outputText>
								<h:outputText value="#{queryConstrucSearchSP.siteContructId}"></h:outputText>
								<h:outputText value="#{queryConstrucSearchSP.siteName}"></h:outputText>					
						<h:panelGrid  width="90%">
							<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
							<f:facet name="header" >
								<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
								<script>
									document.getElementById("incContent:frmSearchResult:pnlSearchResult_header").style.width = "3200px";
								</script>
							</f:facet>
							
							<rich:dataTable id="dtbQueryConstructSrch" width="500" cellpadding="1" cellspacing="0" border="0"
								var="queryConstrucSearchSP" value="#{semmcp001Bean.constructionPermissionSearchSPList}" reRender="dstQueryConstructSrch" 
								rows="#{semmcp001Bean.rowPerPage}"
								rowClasses="cur" 
								styleClass="dataTable">
								<a4j:support event="onRowClick"   action="#{semmcp001Action.getRowIdOnClick}" reRender="dtbQueryConstructSrch">
									<a4j:actionparam name="rowId" value="#{queryConstrucSearchSP.rowId}" />
								</a4j:support>
							<rich:column id="hlkEdit" style="width:140px" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}" rendered="#{semmcp001Bean.renderer['hlkEdit']}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:140px"/>
								</f:facet>
								<div align="center" style="width:140px">
								<a4j:commandLink id="hypAdd" value="#{jspMsg['record.listConBuidDocNo']}"  action="#{navAction.navi}"	reRender="oppContent" rendered="#{queryConstrucSearchSP.editableFlag eq 'Y'}">
									<a4j:actionparam name="navModule" value="cp" />
									<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
									<a4j:actionparam name="moduleWithNavi" value="cp" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
									<a4j:actionparam name="methodWithNavi" value="doShow" />
									<a4j:actionparam name="siteInfoIdParam" value="#{queryConstrucSearchSP.siteInfoId}" />
									<a4j:actionparam name="siteContructIdParam" value="#{queryConstrucSearchSP.rowId}" />
									<a4j:actionparam name="contractIdParam" value="#{queryConstrucSearchSP.contractId}" />
									<a4j:actionparam name="terminateFlag" value="#{queryConstrucSearchSP.terminateFlag}" />
									<a4j:actionparam name="siteContractNoParam" value="#{queryConstrucSearchSP.contractNo}" />
									<a4j:actionparam name="siteNameParam" value="#{queryConstrucSearchSP.siteName}" />
									<a4j:actionparam name="migrateFlag" value="#{queryConstrucSearchSP.migrateFlag}" />
								</a4j:commandLink>
								</div>
							</rich:column>	
							<rich:column  styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}" style = "width : 40">
								<f:facet name="header">
								</f:facet>
								<div align="center" style = "width : 40px;"><a4j:commandButton
									action="#{navAction.navi}" image="images/view.png"
									style="height: 15; width: 15" reRender="oppContent">
									<a4j:actionparam name="navModule" value="cp" />
									<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
									<a4j:actionparam name="moduleWithNavi" value="cp" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
									<a4j:actionparam name="methodWithNavi" value="doShow" />
									<a4j:actionparam name="siteInfoIdParam" value="#{queryConstrucSearchSP.siteInfoId}" />
									<a4j:actionparam name="siteContructIdParam" value="#{queryConstrucSearchSP.rowId}" />
									<a4j:actionparam name="siteContractNoParam" value="#{queryConstrucSearchSP.contractNo}" />
									<a4j:actionparam name="siteNameParam" value="#{queryConstrucSearchSP.siteName}" />
									<a4j:actionparam name="mode" value="VIEW"/>
								</a4j:commandButton></div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.contractNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}" 
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<a4j:commandLink id="hypView" value="#{queryConstrucSearchSP.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{queryConstrucSearchSP.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.siteName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.siteName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.locationId}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:80px">
									<h:outputText value="#{queryConstrucSearchSP.locationId}" styleClass="contentform" style="width:80px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.locationCode}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:80px">
									<h:outputText value="#{queryConstrucSearchSP.locationCode}" styleClass="contentform" style="width:80px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.siteCode}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteCode']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:80px">
									<h:outputText value="#{queryConstrucSearchSP.siteCode}" styleClass="contentform" style="width:80px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryConstrucSearchSP.siteConstructStatus}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteConstructStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{queryConstrucSearchSP.siteConstructStatusName}" styleClass="contentform" style="width:100px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{queryConstrucSearchSP.docNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.docNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{queryConstrucSearchSP.supplierName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.supplier']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.supplierName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{queryConstrucSearchSP.totSendDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.totSendDocNo']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.totSendDocNo}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{queryConstrucSearchSP.totRefDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.totRefDocNo']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.totRefDocNo}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{queryConstrucSearchSP.conPermissionDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conPermissionDocNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.conPermissionDocNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{queryConstrucSearchSP.conBuildDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBuildDocNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.conBuildDocNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{queryConstrucSearchSP.constructTypeName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.constructType']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.constructTypeName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{queryConstrucSearchSP.constructStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.constructStutus']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.constructStatusName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{queryConstrucSearchSP.conBillNo}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBillNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.conBillNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>		
						   
						   <rich:column  sortBy="#{queryConstrucSearchSP.conBillPayStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
						   	title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBillPayStatus']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.conBillPayStatusName}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>	
								
							 <rich:column  sortBy="#{queryConstrucSearchSP.siteStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
							 	title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{queryConstrucSearchSP.siteStatusName}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							 <rich:column  sortBy="#{queryConstrucSearchSP.flowStatus}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								 title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{queryConstrucSearchSP.flowStatus}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>	
							
							<rich:column  styleClass="#{(semmcp001Bean.tmpRowId==queryConstrucSearchSP.rowId)?'onClick':'unClick'}"
								 title="#{queryConstrucSearchSP.contractNo} #{queryConstrucSearchSP.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform" style="width:115px"/>
								</f:facet>
								<div align="center" style="width:115px">
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
										<a4j:actionparam name="refId" value="#{queryConstrucSearchSP.siteInfoId}" />
										<a4j:actionparam name="module" value="CP"/>
										<a4j:actionparam name="contractNo" value="#{queryConstrucSearchSP.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
								</div>
							</rich:column>
								
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmcp001Bean.constructionPermissionSearchSPList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="16">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbQueryConstructSrch" 
												maxPages="10" id="dstQueryConstructSrch" selectedStyleClass="selectScroll"
												page="#{semmcp001Bean.scrollerPage}" />
										</rich:column>
									</rich:columnGroup>
									</f:facet>
								</rich:dataTable>
							
							</rich:panel>
						</h:panelGrid>	
						<!-- End  -->
					</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>