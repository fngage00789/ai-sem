<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt002" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt002Bean.renderedMsgFormTop}">
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
							<tr>
								<td align="right" width="20%" valign="baseline">
				                	<h:panelGroup id="gTxtCompany"  >
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:panelGroup id="gCompany" >
			                				<h:selectOneMenu id="ddlCompany" value="#{semmpt002Bean.mpt002Srch.company}" onchange="GetCompanyJS();">
												<f:selectItems value="#{semmpt002Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmpt002Bean.mpt002Srch.company}" styleClass="ms28"/>
				                		</h:panelGroup>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup id="gTxtPTaxYaer" >
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.pTaxYearFrom']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:panelGroup id="gPTaxYear" >
			                				<h:selectOneMenu id="ddlYearFrom" value="#{semmpt002Bean.mpt002Srch.pTaxYearFrom}" onchange="renderPtaxYearTo();">
												<a4j:jsFunction name="renderPtaxYearTo" reRender="ddlYearTo" action="#{semmpt002Action.doDefaultPtaxYearFrom}"/>
												<f:selectItems value="#{semmpt002Bean.pTaxYearFromList}"/>
											</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
			                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
			                				<rich:spacer width="5"/>
			                				<h:selectOneMenu id="ddlYearTo" value="#{semmpt002Bean.mpt002Srch.pTaxYearTo}">
												<f:selectItems value="#{semmpt002Bean.pTaxYearToList}"/>
											</h:selectOneMenu>
										</h:panelGroup>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:panelGroup id="gTxtContractNo" >
					                		<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</h:panelGroup>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmpt002Bean.mpt002Srch.contractNo}" size="23" maxlength="20"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:panelGroup id="gTxtRegion" >
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</h:panelGroup>	
									</td>
									<td width="30%">
											<h:selectOneMenu id="ddlRegion" 
															 value="#{semmpt002Bean.mpt002Srch.region}"
															 onchange="GetRegionJS();">
												<a4j:jsFunction name="GetRegionJS" reRender="ddlProvince" action="#{semmpt002Action.renderProvinceList}"/>
												<f:selectItems value="#{semmpt002Bean.regionList}"/>
											</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlProvince" 
														 value="#{semmpt002Bean.mpt002Srch.province}" 
														 onchange="GetSiteAmphurListJS(),GetGovtJS();">
											
											<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlAmphur" action="#{semmpt002Action.renderAmphurList}"/>
											<a4j:jsFunction name="GetGovtJS" reRender="ddlGovt" action="#{semmpt002Action.renderGovtList}"/>
											<f:selectItems value="#{semmpt002Bean.provinceList}"/>	
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlAmphur" value="#{semmpt002Bean.mpt002Srch.amphur}">
											<f:selectItems value="#{semmpt002Bean.amphurList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt002Bean.mpt002Srch.pTaxPayType}" disabled="true">
											<f:selectItems value="#{semmpt002Bean.pTaxPayTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payGovtFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox value="#{semmpt002Bean.chkPayGovtFlag}"></h:selectBooleanCheckbox>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtLessorName" value="#{semmpt002Bean.mpt002Srch.lessorName}" size="30" maxlength="255"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.govtName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlGovt" value="#{semmpt002Bean.mpt002Srch.govtName}" >
											<f:selectItems value="#{semmpt002Bean.govtList}"/>	
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="optPTaxStatus" value="#{semmpt002Bean.mpt002Srch.pTaxStatus}">
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus1']}" itemValue="01" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus2']}" itemValue="02" />											
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeName" value="#{semmpt002Bean.mpt002Srch.payeeName}" size="30" maxlength="255"/>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="search" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,btnEstimate,btnCancleEstimate,test">
							 	<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT002" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
 							 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSearchCriteria">
 							 	<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT002" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />					 		 
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
				<h:panelGrid columns="3" id="grdAddNewCommand">
						<a4j:commandButton id="btnEstimate" value="#{jspMsg['btn.savePropertyTax']}" styleClass="rich-button" 
						 disabled="#{semmpt002Bean.disabledBtnExport}"
						 action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt002Bean.renderer['btnEstimate']}">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT002" />
								<a4j:actionparam name="methodWithNavi" value="doUpdate" />
								<a4j:actionparam name="estmFlag" value="Y" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancleEstimate" value="#{jspMsg['btn.canclePropertyTax']}" styleClass="rich-button" 
						 disabled="#{semmpt002Bean.disabledBtnExport}"
						 action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt002Bean.renderer['btnCancleEstimate']}">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT002" />
								<a4j:actionparam name="methodWithNavi" value="doUpdate" />
								<a4j:actionparam name="estmFlag" value="N" />
						</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2660"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt002Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmpt002Bean.msgDataNotFound}" rendered="#{semmpt002Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbMpt002Srch" cellpadding="1" cellspacing="0" border="0"
							var="mpt002SrchSP" value="#{semmpt002Bean.mpt002SrchList}" reRender="dstMpt002Srch" 
							rows="#{semmpt002Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmpt002Action.getRowIdOnClick}" reRender="dtbMpt002Srch">
								<a4j:actionparam name="rowId" value="#{mpt002SrchSP.dataObj.rowId}" />
							</a4j:support> 
							<rich:column styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmpt002Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmpt002Action.selectAllRow}" reRender="dtbMpt002Srch,btnEstimate,btnCancleEstimate"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mpt002SrchSP.checkBox}" rendered="#{mpt002SrchSP.dataObj.renderCheckbox}">
										<a4j:support event="onclick" action="#{semmpt002Action.onRenderExportButton}" reRender="dtbMpt002Srch,btnEstimate,btnCancleEstimate">
											<a4j:actionparam name="rowId" value="#{mpt002SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>  
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.contractNo}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkView" value="#{mpt002SrchSP.dataObj.contractNo}" rendered="#{mpt002SrchSP.dataObj.renderedContractNo}"
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt002SrchSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchSP.dataObj.preContractNo}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.preContractNo']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPreSiteInfoId" value="#{mpt002SrchSP.dataObj.preContractNo}" rendered="#{mpt002SrchSP.dataObj.renderedPreContractNo}"
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt002SrchSP.dataObj.preSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.company}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"   styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.pTaxYear}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxYear']}" styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.pTaxYear}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.siteStatus}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.siteStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.payGovtFlag}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payGovtFlag']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.payGovtFlag}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="hlkSelectVendor" sortBy="#{mpt002SrchSP.dataObj.govtName}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmpt002Bean.renderer['hlkSelectVendor']}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.govtName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<a4j:commandLink id="hlkIniSelectVendor" value="Select Vendor"  rendered="#{mpt002SrchSP.dataObj.renderLinkVendor}"
										reRender="oppContent" action="#{navAction.navi}">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="INSERT" />
										<a4j:actionparam name="eventType" value="Add" />
										<a4j:actionparam name="navModuleFrom" value="pt" />
										<a4j:actionparam name="navProgramFrom" value="SEMMPT002-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMPT002" />
										<a4j:actionparam name="isPageFrom" value="true" />
										<a4j:actionparam name="expenseType" value="13" />
										<a4j:actionparam name="contractNo" value="#{mpt002SrchSP.dataObj.contractNo}" />
									</a4j:commandLink>
									<h:outputText value="#{mpt002SrchSP.dataObj.govtName}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.province}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchSP.dataObj.province}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.payeeName}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchSP.dataObj.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchSP.dataObj.contractEffDt}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractEffDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.contractEffDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchSP.dataObj.contractExpDt}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractExpDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.contractExpDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchSP.dataObj.pTaxStartDt}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxStartDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.pTaxStartDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchSP.dataObj.pTaxEndDt}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxEndDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchSP.dataObj.pTaxEndDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.siteName}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchSP.dataObj.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.siteAddress}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteAddress']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchSP.dataObj.siteAddress}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchSP.dataObj.lessorName}" styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt002SrchSP.dataObj.contractNo} #{mpt002SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lessorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchSP.dataObj.lessorName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmpt002Bean.tmpRowId==mpt002SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView" value="#{jspMsg['column.view']}" styleClass="rich-button"  style="width:100px"
									 action="#{navAction.navi}" reRender="frmErrorpnlSearchResult,pnlSearchResult,popupResult,popupViewPropertyTax,pnlPopupSearchResult"
									 oncomplete="if(#{semmpt002Bean.popupClose == 'true'})#{rich:component('popupViewPropertyTax')}.show(); return false">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT002-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT002" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="contractNo" value="#{mpt002SrchSP.dataObj.contractNo}" />
										</a4j:commandButton>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt002Srch" 
									maxPages="10" id="dstMpt002Srch" selectedStyleClass="selectScroll" 
									page="#{semmpt002Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/pt/semmpt002-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
