<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt003Bean.renderedMsgFormSearch}">
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
                        <a4j:commandButton id="mpt003_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmpt003Bean.renderedOnToDoList}"
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
				                	<h:panelGroup id="gTxtCompany"  >
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:panelGroup id="gCompany" >
			                				<h:selectOneMenu id="ddlCompany" value="#{semmpt003Bean.mpt003Srch.company}"  onchange="GetCompanyJS();">
												<f:selectItems value="#{semmpt003Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmpt003Bean.mpt003Srch.company}" styleClass="ms28"/>
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
			                				<h:selectOneMenu id="ddlYearFrom" value="#{semmpt003Bean.mpt003Srch.pTaxYearFrom}" onchange="renderPtaxYearTo();">
												<a4j:jsFunction name="renderPtaxYearTo" reRender="ddlYearTo" action="#{semmpt003Action.doDefaultPtaxYearFrom}"/>
												<f:selectItems value="#{semmpt003Bean.pTaxYearFromList}"/>
											</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
			                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
			                				<rich:spacer width="5"/>
			                				<h:selectOneMenu id="ddlYearTo" value="#{semmpt003Bean.mpt003Srch.pTaxYearTo}">
												<f:selectItems value="#{semmpt003Bean.pTaxYearToList}"/>
											</h:selectOneMenu>
										</h:panelGroup>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
				                		<h:panelGroup id="gTxtContractNo" >
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</h:panelGroup>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmpt003Bean.mpt003Srch.contractNo}" size="23" maxlength="20">
										<a4j:support event="onchange" reRender="frmSearch"></a4j:support>
										</h:inputText>
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
														 value="#{semmpt003Bean.mpt003Srch.region}"
														 onchange="GetRegionJS();">
											
											<a4j:support event="onchange" action="#{semmpt003Action.validateRenderSearch}" 
														 reRender="txtContractNo,gTxtContractNo,pnlSearchCriteria,frmSearch"/>
											<a4j:jsFunction name="GetRegionJS" reRender="ddlProvince" action="#{semmpt003Action.renderProvinceList}"/>
											<f:selectItems value="#{semmpt003Bean.regionList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlProvince" 
														 value="#{semmpt003Bean.mpt003Srch.province}" 
														 onchange="GetSiteAmphurListJS(),GetGovtJS();">
											
											<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlAmphur" action="#{semmpt003Action.renderAmphurList}"/>
											<a4j:jsFunction name="GetGovtJS" reRender="ddlGovt" action="#{semmpt003Action.renderGovtList}"/>
											<f:selectItems value="#{semmpt003Bean.provinceList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlAmphur" value="#{semmpt003Bean.mpt003Srch.amphure}">
											<f:selectItems value="#{semmpt003Bean.amphurList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt003Bean.mpt003Srch.pTaxPayType}" disabled="true">
											<f:selectItems value="#{semmpt003Bean.pTaxPayTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payGovtFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox value="#{semmpt003Bean.chkPayGovtFlag}"></h:selectBooleanCheckbox>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtLessorName" value="#{semmpt003Bean.mpt003Srch.lessorName}" size="30" maxlength="255"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.govtName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlGovt" value="#{semmpt003Bean.mpt003Srch.govtName}" >
											<f:selectItems value="#{semmpt003Bean.govtList}"/>	
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="optPTaxStatus" value="#{semmpt003Bean.mpt003Srch.pTaxStatus}">
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus1']}" itemValue="01" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus2']}" itemValue="02" />											
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeName" value="#{semmpt003Bean.mpt003Srch.payeeName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
							<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxEstmStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxEstmStatus" value="#{semmpt003Bean.mpt003Srch.pTaxEstmStatus}">
											<f:selectItems value="#{semmpt003Bean.pTaxEstmStatusList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentStatus" value="#{semmpt003Bean.mpt003Srch.paymentStatus}">
											<f:selectItems value="#{semmpt003Bean.paymentStatusList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
							 reRender="frmError,pnlSearchResult,btnCancleEstimate,btnExport">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
							 reRender="frmError,pnlSearchResult,btnCancleEstimate,btnExport,pnlSearchCriteria">
							 	<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />					 		 
							</a4j:commandButton>
							
							<a4j:commandButton id="btnExportLetterId" value="Export Letter" styleClass="rich-button" 
						 disabled="false" action="#{navAction.navi}" reRender="frmError,frmShowReport,pnlShowReportEpt" rendered="true">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="doExportLetter" />
						</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
				<h:panelGrid columns="5" id="grdAddNewCommand">
						<a4j:commandButton id="btnEstimate" value="#{jspMsg['btn.savePropertyTax']}" styleClass="rich-button" 
						 disabled="#{semmpt003Bean.disabledBtnEstimate}" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt003Bean.renderer['btnCancleEstimate']}">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="doUpdatePropertyTax" />
								<a4j:actionparam name="estmFlag" value="Y" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnCancleEstimate" value="#{jspMsg['btn.canclePropertyTax']}" styleClass="rich-button" action="#{navAction.navi}"
						 disabled="#{semmpt003Bean.disabledBtnExport}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt003Bean.renderer['btnCancleEstimate']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="doUpdate" />
						</a4j:commandButton>
	            		<a4j:commandButton id="btnExport" value="Export To Excel" styleClass="rich-button" 
						 action="#{navAction.navi}" reRender="frmError,frmShowReportExcel,pnlShowReportExcel" 
						 rendered="#{semmpt003Bean.renderer['btnExport']}"
						 disabled="#{semmpt003Bean.disabledBtnExport}">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
								<a4j:actionparam name="methodWithNavi" value="initExportExcel" />
						</a4j:commandButton>
	            		
	            		
	            		<a4j:commandButton id ="btnExportA3" action="#{semmpt003RPTAction.runReport}" 
			           		 styleClass="rich-button" value="Export A3" disabled="#{semmpt003Bean.disabledBtnExport}"
							  rendered="#{semmpt003Bean.renderer['btnExport']}">
							 <a4j:support event="oncomplete" reRender="frmSearch,frmShowReport,pnlShowReport" rendered="#{semmpt003RPTBean.displayShowReport}"></a4j:support>
	            		</a4j:commandButton>
	            		
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 3550"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmpt003Bean.msgDataNotFound}" rendered="#{semmpt003Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbMpt003Srch" cellpadding="1" cellspacing="0" border="0"
							var="mpt003SrchSP" value="#{semmpt003Bean.mpt003SrchList}" reRender="dstMpt003Srch" 
							rows="#{semmpt003Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmpt003Action.getRowIdOnClick}" reRender="dtbMpt003Srch">
								<a4j:actionparam name="rowId" value="#{mpt003SrchSP.dataObj.rowId}" />
							</a4j:support> 
							<rich:column styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmpt003Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmpt003Action.selectAllRow}" reRender="dtbMpt003Srch,btnExport,btnCancleEstimate,btnExportA3,btnEstimate"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mpt003SrchSP.checkBox}">
										<a4j:support event="onclick" action="#{semmpt003Action.onRenderExportButton}" reRender="dtbMpt003Srch,btnCancleEstimate,btnExport,btnExportA3,btnEstimate">
											<a4j:actionparam name="rowId" value="#{mpt003SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>  
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Edit" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										action="#{navAction.navi}" reRender="popupShowEditProperty" title="edit" oncomplete="#{rich:component('popupShowEditProperty')}.show();"
										id="btnEdit" rendered="true">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
										<a4j:actionparam name="methodWithNavi" value="initEditPropertyTax" />
										<a4j:actionparam name="rowId" value="#{mpt003SrchSP.dataObj.rowId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							
							
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.contractNo}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkView" value="#{mpt003SrchSP.dataObj.contractNo}"
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt003SrchSP.dataObj.siteInfoId}" />
										
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt003SrchSP.dataObj.preContractNo}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.preContractNo']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPreSiteInfoId" value="#{mpt003SrchSP.dataObj.preContractNo}" rendered="#{mpt003SrchSP.dataObj.renderedPreContractNo}"
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt003SrchSP.dataObj.preSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.company}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"   styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.pTaxYear}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxYear']}" styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.pTaxYear}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.paymentStatus}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.paymentStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.pTaxEstmStatus}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxEstmStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.pTaxEstmStatus}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.rentPreAmt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.rentPreAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt003SrchSP.dataObj.rentPreAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.rentAmt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.rentAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt003SrchSP.dataObj.rentAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.pTaxAmt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt003SrchSP.dataObj.pTaxAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.payGovtFlag}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payGovtFlag']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.payGovtFlag}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.govtName}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.govtName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.govtName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.province}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.province}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.payeeName}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt003SrchSP.dataObj.contractEffDt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractEffDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.contractEffDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt003SrchSP.dataObj.contractExpDt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractExpDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.contractExpDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt003SrchSP.dataObj.pTaxStartDt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxStartDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.pTaxStartDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt003SrchSP.dataObj.pTaxEndDt}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxEndDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt003SrchSP.dataObj.pTaxEndDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.siteName}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.siteAddress}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteAddress']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.siteAddress}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.lessorName}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lessorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.lessorName}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							
							
							<rich:column  sortBy="#{mpt003SrchSP.dataObj.remark}" styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt003SrchSP.dataObj.contractNo} #{mpt003SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:300px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt003SrchSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							
							
							<rich:column styleClass="#{(semmpt003Bean.tmpRowId==mpt003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView" value="#{jspMsg['column.view']}" styleClass="rich-button"  style="width:100px"
									 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,popupResult,popupViewPropertyTax,pnlPopupSearchResult"
									 oncomplete="if(#{semmpt002Bean.popupClose == 'true'})#{rich:component('popupViewPropertyTax')}.show(); return false">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="contractNo" value="#{mpt003SrchSP.dataObj.contractNo}" />
										</a4j:commandButton>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt003Srch" 
									maxPages="10" id="dstMpt003Srch" selectedStyleClass="selectScroll" 
									page="#{semmpt003Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/pt/semmpt002-popup.jsp"/>
			<jsp:include page="../../pages/pt/semmpt003-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmShowReport">
<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReport" rendered="#{semmpt003RPTBean.displayShowReport}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmpt003RPTAction.showReport}"  />								
		<script>document.getElementById('incContent:frmShowReport:bthShowReport').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>

<a4j:form id="frmShowReportEpt">
<h:panelGrid id="pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReportEpt" rendered="#{semmpt003Bean.displayReportFlag}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmpt003Action.doExportExcelLetter}"  />								
		<script>document.getElementById('incContent:frmShowReportEpt:bthShowReport').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>

<a4j:form id="frmShowReportExcel">
<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmpt003Bean.displayReportExcelFlag}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmpt003Action.doExportExcel}"  />								
		<script>document.getElementById('incContent:frmShowReportExcel:bthShowReportExcel').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>