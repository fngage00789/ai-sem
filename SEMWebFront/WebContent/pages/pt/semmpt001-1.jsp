<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt001Bean.renderedMsgFormTop}">
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
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mpt001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmpt001Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
                              <a4j:actionparam name="navModule" value="pt" />
                              <a4j:actionparam name="navProgram" value="SEMMPT001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="pt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
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
							<tr>
				                	<td align="right" width="20%" valign="baseline">
				                	<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmpt001Bean.mpt001Srch.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmpt001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmpt001Bean.mpt001Srch.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmpt001Bean.mpt001Srch.contractNo}" size="23" maxlength="20"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlRegion" 
															 value="#{semmpt001Bean.mpt001Srch.region}"
															 onchange="GetRegionJS();">
												<a4j:jsFunction name="GetRegionJS" reRender="ddlProvince" action="#{semmpt001Action.renderProvinceList}"/>
												<f:selectItems value="#{semmpt001Bean.regionList}"/>
											</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlProvince" value="#{semmpt001Bean.mpt001Srch.province}">
											<f:selectItems value="#{semmpt001Bean.provinceList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt001Bean.mpt001Srch.ptTaxPayType}">
											<f:selectItems value="#{semmpt001Bean.propertyTaxTypeSchList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox id="chkPayGoveFlag" value="#{semmpt001Bean.chkPayGovtFlag}"></h:selectBooleanCheckbox>
										<h:outputText value="#{jspMsg['label.payGovtFlag']}" styleClass="ms7"/>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="search" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
						     action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSearchCriteria,btnSavePropertyTax,btnCanclePropertyTax,btnExport">
						 		 <a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
				<h:panelGrid columns="3" id="grdAddNewCommand">
						<a4j:commandButton id="btnSavePropertyTax" value="#{jspMsg['btn.savePropertyTax']}" style="width:130px" styleClass="rich-button"
						 action="#{navAction.navi}" reRender="frmError,pnlSearchResult" disabled="#{semmpt001Bean.disabledBtnExport}"
						 rendered="#{semmpt001Bean.renderer['btnSavePropertyTax']}">
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
							<a4j:actionparam name="methodWithNavi" value="doUpdate" />
							<a4j:actionparam name="payGovtFlag" value="Y" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnCanclePropertyTax" value="#{jspMsg['btn.canclePropertyTax']}" styleClass="rich-button" style="width:160px"
						 action="#{navAction.navi}" reRender="frmError,pnlSearchResult" disabled="#{semmpt001Bean.disabledBtnExport}"
						 rendered="#{semmpt001Bean.renderer['btnCanclePropertyTax']}">
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
							<a4j:actionparam name="methodWithNavi" value="doUpdate" />
							<a4j:actionparam name="payGovtFlag" value="N" />
						</a4j:commandButton>
						
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1255"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt001Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmpt001Bean.msgDataNotFound}" rendered="#{semmpt001Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbMpt001Srch" cellpadding="1" cellspacing="0" border="0"
							var="mpt001SrchSP" value="#{semmpt001Bean.mpt001SrchList}" reRender="dstMpt001Srch" 
							rows="#{semmpt001Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmpt001Action.getRowIdOnClick}" reRender="dtbMpt001Srch">
								<a4j:actionparam name="rowId" value="#{mpt001SrchSP.dataObj.rowId}" />
							</a4j:support> 
							<rich:column styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmpt001Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmpt001Action.selectAllRow}" reRender="dtbMpt001Srch,btnSavePropertyTax,btnCanclePropertyTax,btnExport"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mpt001SrchSP.checkBox}" rendered="#{mpt001SrchSP.dataObj.renderColumn}">
										<a4j:support event="onclick" action="#{semmpt001Action.onRenderExportButton}" reRender="dtbMpt001Srch,btnSavePropertyTax,btnCanclePropertyTax,btnExport">
											<a4j:actionparam name="rowId" value="#{mpt001SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox> 
								</div>
							</rich:column>
							<rich:column id="btnEdit" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmpt001Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="ms7" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;" 
									 oncomplete="#{rich:component('popupPropertyTax')}.show(); return false" 
									 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,popupPropertyTax"
									 rendered="#{mpt001SrchSP.dataObj.renderEditColumn}">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
										<a4j:actionparam name="methodWithNavi" value="initSave" />
										<a4j:actionparam name="contractNo" value="#{mpt001SrchSP.dataObj.contractNo}" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.contractNo}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkView" value="#{mpt001SrchSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt001SrchSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt001SrchSP.dataObj.company}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform"  style="width:25px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchSP.dataObj.company}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.region}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}"   styleClass="contentform" style="width:40px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchSP.dataObj.region}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.pTaxPayDesc}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxPayDesc']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt001SrchSP.dataObj.pTaxPayDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.payGovtFlag}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payGovtFlag']}" styleClass="contentform"  style="width:25px"/>
								</f:facet>
								<div align="center">
									
									<h:outputText value="#{mpt001SrchSP.dataObj.payGovtFlag}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.constructionName}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.constructionName']}" styleClass="contentform"  style="width:25px"/>
								</f:facet>
								<div align="center">
									
									<h:outputText value="#{mpt001SrchSP.dataObj.constructionName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column id="hlkSelectVendor" sortBy="#{mpt001SrchSP.dataObj.vendorName}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmpt001Bean.renderer['hlkSelectVendor']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:panelGroup rendered="#{mpt001SrchSP.dataObj.renderLinkVendorPtax}">
									<a4j:commandLink id="hlkIniSelectVendor" value="Select Vendor"  rendered="#{mpt001SrchSP.dataObj.renderLinkVendor}"
										reRender="oppContent" action="#{navAction.navi}">
										<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="contractNoParam" value="#{mpt001SrchSP.dataObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{mpt001SrchSP.dataObj.vendorMasterId}" />
											<a4j:actionparam name="expenseTypeIdParam" value="13" />
											<a4j:actionparam name="isPageFrom" value="true" />
											
											<a4j:actionparam name="navModuleBack" value="pt" />
											<a4j:actionparam name="navProgramBack" value="SEMMPT001-1" />
											<a4j:actionparam name="actionWithNaviBack" value="SEMMPT001"/>
											<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
											<a4j:actionparam name="backOtherPageFlag" value="Y" />
											<a4j:actionparam name="todoManagerFlag" value="N" />
											<a4j:actionparam name="btnActionType" value="N" />
											<a4j:actionparam name="verifyFlag" value="Y" />
											<a4j:actionparam name="actionId" value="PAGE_VERIFY_NEW" />
									</a4j:commandLink>
									<h:outputText value="#{mpt001SrchSP.dataObj.vendorName}" styleClass="contentform" >
									</h:outputText>
									</h:panelGroup>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.province}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt001SrchSP.dataObj.province}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.updateBy}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt001SrchSP.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt001SrchSP.dataObj.updateDt}" styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchSP.dataObj.updateDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmpt001Bean.tmpRowId==mpt001SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" styleClass="contentform"  style="width:40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView" value="#{jspMsg['column.view']}" styleClass="rich-button"  style="width:70px"
									 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,popupResult,pnlPopupSearchResult"
									 oncomplete="if(#{semmpt001Bean.popupClose == 'true'})#{rich:component('popupViewPropertyTax')}.show(); return false">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="contractNo" value="#{mpt001SrchSP.dataObj.contractNo}" />
										</a4j:commandButton>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt001Srch" 
									maxPages="10" id="dstMpt001Srch" selectedStyleClass="selectScroll" 
									page="#{semmpt001Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/pt/semmpt001-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
