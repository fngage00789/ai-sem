<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.co.semmco001" var="jspMsg"/>
<h:panelGrid width="100%">

	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>	
			<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mco001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmco001Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
                              <a4j:actionparam name="navModule" value="co" />
                              <a4j:actionparam name="navProgram" value="SEMMCO001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="co" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
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
				<a4j:form id="frmSearchCriteria">
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
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="bottom">
		                			<a4j:region>
		                				<h:selectOneMenu id="ddlCompany" value="#{semmco001Bean.criteriaSP.company}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmco001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay, ddlContractStatus" action="#{semmco001Action.renderCompany}"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmco001Bean.criteriaSP.company}" styleClass="ms28"/>
										</a4j:region>
				                	</td>
				                	<td align="right" width="20%" valign="bottom">
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="bottom">
									<h:selectOneMenu id="ddlRegion" value="#{semmco001Bean.criteriaSP.region}"> 
										<f:selectItems value="#{semmco001Bean.regionList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
									<h:inputText id="txtDocNo" value="#{semmco001Bean.criteriaSP.docNo}" size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:panelGroup>
										<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu id="ddlReqType" value="#{semmco001Bean.criteriaSP.reqType}"> 
										<f:selectItems value="#{semmco001Bean.reqTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtTitle" value="#{semmco001Bean.criteriaSP.title}" size="30" maxlength="35"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semmco001Bean.criteriaSP.locationId}" size="18" maxlength="15"/>
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNo" value="#{semmco001Bean.criteriaSP.contractNo}" size="23" maxlength="20"
		                			onblur="setFormatContractNo(this)"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteName" value="#{semmco001Bean.criteriaSP.siteName}" size="30" maxlength="35"/>
				                	</td>
			                	 </tr>
			                	 <tr>
								 	<td align="right" width="20%">
								 		<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
	                				</td>
	                				<td width="30%">
			                			<table width="100%">
			                				<tr>
			                				<td>
												<rich:calendar id="cldEffDateFrom" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmco001Bean.criteriaSP.effDateFrom}"
												   showWeeksBar="false" 
												   inputSize="13" 
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   cellWidth="20px" cellHeight="20px"
												   oninputblur="validateRichCalendarFromTo('frmSearch','cldEffDateFrom','cldEffDateTo');"
												   oncollapse="validateRichCalendarFromTo('frmSearch','cldEffDateFrom','cldEffDateTo');"
												   label="#{jspMsg['column.header.effDate']}"
												   >
											</rich:calendar> 
										</td>
										<td><h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/></td>
									<td>
									<rich:calendar id="cldEffDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco001Bean.criteriaSP.effDateTo}"
									   showWeeksBar="false"
									   inputSize="13"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   oninputblur="validateRichCalendarFromTo('frmSearch','cldEffDateTo','cldEffDateFrom');"
									   oncollapse="validateRichCalendarFromTo('frmSearch','cldEffDateTo','cldEffDateFrom');"
									   label="#{jspMsg['column.header.effDate']}">
								</rich:calendar>
									</td>
									</tr>
									</table>
			                	</td>
			                	<td align="right" width="20%">
			                	<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<table width="100%">
		                			<tr>
		                			<td>
									<rich:calendar id="cldExpDateFrom" locale="th" enableManualInput="true" 
								   datePattern="dd/MM/yyyy" 
								   value="#{semmco001Bean.criteriaSP.expDateFrom}"
								   showWeeksBar="false" 
								   inputSize="13" 
								   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								   cellWidth="20px" cellHeight="20px"
								   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpDateFrom','cldExpDateTo');"
								   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpDateFrom','cldExpDateTo');"
								   label="#{jspMsg['column.header.expDate']}"
								   >
								</rich:calendar> 
									</td>
									<td><h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/></td>
									<td>
										<rich:calendar id="cldExpDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco001Bean.criteriaSP.expDateTo}"
									   showWeeksBar="false" 
									   inputSize="13" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpDateTo','cldExpDateFrom');"
									   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpDateTo','cldExpDateFrom');"
									   label="#{jspMsg['column.header.expDate']}"
									   >
									</rich:calendar> 
									</td>
									</tr>
									</table>
			                	</td>
		                	 </tr>
			                 <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:inputText id="txtLessorName" value="#{semmco001Bean.criteriaSP.lessorName}" size="30" maxlength="100"/>
			                	</td>
			                	<td width="20%"></td>
			                	<td width="30%">
			                	<h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmco001Bean.chkNoExpireFlag}" 
								styleClass="ms7"/>
				                <h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
			                	</td>
		                	 </tr>
		                	  <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:selectOneMenu id="ddlContractStatus" value="#{semmco001Bean.criteriaSP.contractStatus}"> 
									<f:selectItems value="#{semmco001Bean.contractStatusList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.checkDocStatus']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:selectOneMenu id="ddlCheckDocStatus" value="#{semmco001Bean.criteriaSP.checkDocStatus}"> 
									<f:selectItems value="#{semmco001Bean.checkDocStatusList}"/>
								</h:selectOneMenu>
			                	</td>
		                	 </tr>
		                	 <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.dutyPayStatus']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:selectOneMenu id="ddlDutyPayStatus" value="#{semmco001Bean.criteriaSP.dutyPayStatus}"> 
									<f:selectItems value="#{semmco001Bean.dutyPayStatusList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:inputText id="txtBatchNo" value="#{semmco001Bean.criteriaSP.batchNo}" size="15" maxlength="15"/>
			                	</td>
			                	<td align="right" width="20%">
	                			</td>
	                			<td width="30%">
			                	</td>
		                	 </tr>
		                	<tr>
							<td align="right" width="20%">
                			</td>
                			<td width="80%" colspan="3">
		                		<h:selectBooleanCheckbox id="rbtCurrentFlag"  value="#{semmco001Bean.criteriaSP.currentFlagBoolean}"  styleClass="ms7" rendered="true" onclick="GetCompanyJS();">
		                		</h:selectBooleanCheckbox>
		                		<rich:spacer width="5"></rich:spacer>
		                		<h:outputText value="#{jspMsg['label.currentFlag']}" styleClass="ms7"></h:outputText>
		                	</td>
	                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,pnlSearchResultLegal,frmSearchResult" >
							<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,pnlSearchResultLegal,frmSearchResult,btnPrintCheckDoc">
			           		<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- panel result -->
				<a4j:form id="frmSearchResult">	
				<h:panelGrid id="grdAddCommand">
				<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="40%" colspan="3">
	           		<a4j:commandButton id="btnPrintCheckDoc" style="width:130px" styleClass="rich-button"
	           						   reRender="frmError, frmSearchResult"
	           						   disabled="#{semmco001Bean.disabledBtnPrint}" 
	           						   value="#{jspMsg['btn.print']}" 
	           						   action="#{navAction.navi}"
	           						   rendered="#{semmco001Bean.renderer['btnPrintCheckDoc'] or semmco001Bean.renderedOnToDoList}">
							
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO001RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport" rendered="#{semmco001RPTBean.displayShowReport}"/>
					</a4j:commandButton>
					
					<h:commandButton id="btnExportContract" value="Export Contract" styleClass="rich-button" 
            	action="#{semmco001Action.doExportExcelContract}"  style="width:130" 
            	rendered="#{!semmco001Bean.renderer['btnExport'] or semmco001Bean.renderedOnToDoList}"
            	  disabled="#{semmco001Bean.disabledBtnPrint}">
				</h:commandButton>
				</td>
				<td align="left" width="60%">
				<h:panelGroup rendered="#{semmco001Bean.renderedLegal}">
           		<h:commandButton id="btnExport" value="#{jspMsg['btn.export']}" styleClass="rich-button" 
            	action="#{semmco001Action.doExportExcel}"  style="width:130" 
            	disabled="#{semmco001Bean.disabledBtnExport}"
            	rendered="#{semmco001Bean.renderer['btnExport'] or semmco001Bean.renderedOnToDoList}">
				</h:commandButton>
				</h:panelGroup>
				</td>
				</tr>
				</table>
				</h:panelGroup>
				</h:panelGrid>
				
				<!-- ShowReport Panel -->
				<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowReport" rendered="#{semmco001RPTBean.displayShowReport}" style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmco001RPTAction.showReport}"  />								
						<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
					</h:panelGroup>							
				</h:panelGrid>
				<!-- End Code -->
				
				
				<!-- dataTable -->
				<h:panelGrid  width="95%">
				<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" rendered="#{semmco001Bean.renderedContract}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width:2340px"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco001Bean.msgDataNotFound}" rendered="#{semmco001Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="100%" id="dtbContract" cellpadding="1" cellspacing="0" border="0"
							var="contractSP" value="#{semmco001Bean.contractSPList}" reRender="dtbContract" 
							rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							rendered="#{semmco001Bean.renderedContract}">
							<a4j:support event="onRowClick"   action="#{semmco001Action.getRowIdOnClick}" reRender="dtbContract">
								<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								<h:selectBooleanCheckbox value="#{semmco001Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmco001Action.selectAllRow}" 
											reRender="btnPrintCheckDoc,btnExport,btnExportContract,dtbContract"/>
								</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="contractSelected" value="#{contractSP.checkBox}" 
										rendered="#{contractSP.dataObj.rowId != null}">
										<a4j:support event="onclick" action="#{semmco001Action.onRenderButton}" 
										reRender="btnPrintCheckDoc,btnExport,btnExportContract,dtbContract">
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							rendered="#{semmco001Bean.renderer['hlkEdit'] or semmco001Bean.renderedOnToDoList}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText  styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
            					<a4j:commandLink id="hlkEdit" value="#{jspMsg['label.saveContract']}"
            					action="#{navAction.navi}" reRender="oppContent" onclick="changeTab();">
									<a4j:actionparam name="navModule" value="co" />
	            					<a4j:actionparam name="navProgram" value="SEMMCO001-2" />	
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateContract" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
									<a4j:actionparam name="siteName" value="#{contractSP.dataObj.siteName}"/>
									<a4j:actionparam name="company" value="#{contractSP.dataObj.company}"/>
									<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}" />
									<a4j:actionparam name="picoFlag" value="#{contractSP.dataObj.picoFlag}" />
									<a4j:actionparam name="siteAppId" value="#{contractSP.dataObj.siteAppId}" />
                                    <a4j:actionparam name="placeType" value="#{contractSP.dataObj.placeType}" />
                                    <a4j:actionparam name="partiesType" value="#{contractSP.dataObj.partiesType}" />
                                    <a4j:actionparam name="placeTypeRemark" value="#{contractSP.dataObj.placeTypeRemark}" />
                                    <a4j:actionparam name="partiesTypeRemark" value="#{contractSP.dataObj.partiesTypeRemark}" />
                                    <a4j:actionparam name="docApproveId" value="#{contractSP.dataObj.docApproveId}" />
            					</a4j:commandLink>
            					<a4j:jsFunction name="changeTab" action="#{semmco001Action.setTabNo}">
            						<a4j:actionparam name="tabNo" value="2"/>
            					</a4j:jsFunction>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.docNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.contractNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{contractSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.oldContractNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.oldContractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{contractSP.dataObj.oldContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.siteName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.reqTypeName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqTypeName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.reqTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.title}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.title}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.effDate}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.effDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.expDate}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.expDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{contractSP.dataObj.lessorName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.lessorName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.lessorName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.dutyPayStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dutyPayStatusName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.dutyPayStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.remark}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width: 350"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.contractStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.contractStatusName}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.borrowStatus}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.borrowStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.borrowStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.siteStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.flowStatus}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.flowStatus}" styleClass="contentform"  style="width:200px"/>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco001Bean.contractSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContract"
											maxPages="#{semmco001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContract" 
											style="background-color: #cccccc;"
											page="#{semmco001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						</rich:panel>
						<!--  data table for role Legal -->
						<rich:panel id="pnlSearchResultLegal" styleClass="sem_autoScrollbar" rendered="#{semmco001Bean.renderedLegal}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1900"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco001Bean.msgDataNotFound}" rendered="#{semmco001Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="100%" id="dtbContractLegal" cellpadding="1" cellspacing="0" border="0"
							var="contractSP" value="#{semmco001Bean.contractSPList}" reRender="dtbContractLegal" 
							rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							rendered="#{semmco001Bean.renderedLegal}">
							<a4j:support event="onRowClick"   action="#{semmco001Action.getRowIdOnClick}" reRender="dtbContractLegal">
								<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
								<h:selectBooleanCheckbox value="#{semmco001Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmco001Action.selectAllRow}" 
											reRender="btnPrintCheckDoc,btnExport,btnExportContract,dtbContractLegal"/>
								</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="contractSelected" value="#{contractSP.checkBox}" 
										rendered="#{contractSP.dataObj.rowId != null}">
										<a4j:support event="onclick" action="#{semmco001Action.onRenderButton}" 
										reRender="btnPrintCheckDoc,btnExport,btnExportContract,dtbContract">
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"	
							rendered="#{semmco001Bean.renderer['hlkEdit'] or semmco001Bean.renderedOnToDoList}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText  styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandLink id="hlkEdit" value="#{jspMsg['label.saveContract']}"
	            					action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO001-2" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateContract" />
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
										<a4j:actionparam name="siteName" value="#{contractSP.dataObj.siteName}"/>
										<a4j:actionparam name="company" value="#{contractSP.dataObj.company}"/>
										<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}" />
										<a4j:actionparam name="docApproveId" value="#{contractSP.dataObj.docApproveId}" />
										<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}" />
										<a4j:actionparam name="picoFlag" value="#{contractSP.dataObj.picoFlag}" />
										<a4j:actionparam name="siteAppId" value="#{contractSP.dataObj.siteAppId}" />
                                   	 	<a4j:actionparam name="placeType" value="#{contractSP.dataObj.placeType}" />
                                    	<a4j:actionparam name="partiesType" value="#{contractSP.dataObj.partiesType}" />
                                    	<a4j:actionparam name="placeTypeRemark" value="#{contractSP.dataObj.placeTypeRemark}" />
                                    	<a4j:actionparam name="partiesTypeRemark" value="#{contractSP.dataObj.partiesTypeRemark}" />
	            					</a4j:commandLink>         							
								</div>
							</rich:column>
						<rich:column  sortBy="#{contractSP.dataObj.docNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
						title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.contractNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkLegalViewPopupSiteInfo" value="#{contractSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.oldContractNo}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.oldContractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkLegalViewPopupSiteInfo2" value="#{contractSP.dataObj.oldContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{contractSP.dataObj.siteName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.reqTypeName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqTypeName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.reqTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.title}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.title}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.outDate}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.outDate']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.outDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.checkDocStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.checkDocStatusName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.checkDocStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.contractStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.contractStatusName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractSP.dataObj.borrowStatus}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.borrowStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.borrowStatus}" styleClass="contentform" />
								</div>
							</rich:column>	
								
							<rich:column  sortBy="#{contractSP.dataObj.siteStatusName}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteStatusName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.flowStatus}" styleClass="#{(semmco001Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.flowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco001Bean.contractSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractLegal"
											maxPages="#{semmco001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractLegal" 
											style="background-color: #cccccc;"
											page="#{semmco001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
				

