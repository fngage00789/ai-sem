<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.co.semmco005" var="jspMsg"/>
<h:panelGrid width="100%">

	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>	
			<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco005Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
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
									<td align="right" width="25%" valign="baseline">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%" valign="bottom">
		                			<a4j:region>
		                				<h:selectOneMenu id="ddlCompany" value="#{semmco005Bean.criteriaSP.company}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmco005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay, ddlContractStatus" action="#{semmco005Action.renderCompany}"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmco005Bean.criteriaSP.company}" styleClass="ms28"/>
										</a4j:region>
				                	</td>
				                	<td align="right" width="25%" valign="bottom">
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%" valign="bottom">
									<h:selectOneMenu id="ddlRegion" value="#{semmco005Bean.criteriaSP.region}"> 
										<f:selectItems value="#{semmco005Bean.regionList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	
			                	  <tr>
			                	  <td align="right" width="20%" valign="top" rowspan="1">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputTextarea id="txtContractNo" value="#{semmco005Bean.criteriaSP.contractNo}" rows="3" cols="35"
		                			onblur="setFormatContractNo(this)"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semmco005Bean.criteriaSP.locationId}" size="18" maxlength="15"/>
				                	</td>
			                	 </tr>
			                	  <tr>
									
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteName" value="#{semmco005Bean.criteriaSP.siteName}" size="30" maxlength="35"/>
				                	</td>
			                	 </tr>
			                	  <tr>
								 <td align="right" width="25%">
								 <h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
	                			</td>
	                			<td width="25%">
		                			<table width="100%">
		                			<tr>
		                			<td>
									<rich:calendar id="cldEffDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco005Bean.criteriaSP.effDateFrom}"
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
									   value="#{semmco005Bean.criteriaSP.effDateTo}"
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
			                	<td align="right" width="25%">
			                	<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
	                			</td>
	                			<td width="25%">
	                				<table width="100%">
		                			<tr>
		                			<td>
									<rich:calendar id="cldExpDateFrom" locale="th" enableManualInput="true" 
								   datePattern="dd/MM/yyyy" 
								   value="#{semmco005Bean.criteriaSP.expDateFrom}"
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
									   value="#{semmco005Bean.criteriaSP.expDateTo}"
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
	                			<h:inputText id="txtLessorName" value="#{semmco005Bean.criteriaSP.lessorName}" size="30" maxlength="100"/>
			                	</td>
			                	<td width="20%"></td>
			                	<td width="30%">
			                	<h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmco005Bean.chkNoExpireFlag}" 
								styleClass="ms7"/>
				                <h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
			                	</td>
		                	 </tr>
		                	  <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:selectOneMenu id="ddlContractStatus" value="#{semmco005Bean.criteriaSP.contractStatus}"> 
									<f:selectItems value="#{semmco005Bean.contractStatusList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.groupNo']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:inputText id="txtGroupNo" value="#{semmco005Bean.criteriaSP.groupNo}" size="15" maxlength="15"/>
			                	</td>
		                	 </tr>
		                	 <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.dutyPayStatus']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:selectOneMenu id="ddlDutyPayStatus" value="#{semmco005Bean.criteriaSP.dutyPayStatus}"> 
									<f:selectItems value="#{semmco005Bean.dutyPayStatusList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								
	                			</td>
	                			<td width="30%">
	                			
			                	</td>
			                	<td align="right" width="20%">
	                			</td>
	                			<td width="30%">
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
							<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO005" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,pnlSearchResultLegal,frmSearchResult,btnPrintCheckDoc">
			           		<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO005" />
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
				<td width="40%">
	           	<h:panelGroup>
	           	
	           	<a4j:commandButton id="btnAdd" value="#{jspMsg['label.saveContract']}" styleClass="rich-button"
					oncomplete="#{rich:component('popupAddContractStatus')}.show(); return false"  
	            	action="#{navAction.navi}" reRender="popupAddContractStatus,popupFrmAddContractStatus,pnlAddContractStatus" 
	            	style="width:120" disabled="#{semmco005Bean.disabledBtnAdd}">
	            		<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO005" />
						<a4j:actionparam name="methodWithNavi" value="initAddContractStatus" />
					</a4j:commandButton>
	           	
				</h:panelGroup>	
				</td>
				<td align="left" width="60%">
				</td>
				</tr>
				</table>
				</h:panelGroup>
				</h:panelGrid>
				
				<!-- ShowReport Panel -->
				<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowReport" rendered="#{semmco005RPTBean.displayShowReport}" style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmco005RPTAction.showReport}"  />								
						<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
					</h:panelGroup>							
				</h:panelGrid>
				<!-- End Code -->
				
				
				<!-- dataTable -->
				<h:panelGrid  width="95%">
				<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" rendered="#{semmco005Bean.renderedContract}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2100"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco005Bean.msgDataNotFound}" rendered="#{semmco005Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="100%" id="dtbContract" cellpadding="1" cellspacing="0" border="0"
							var="contractSP" value="#{semmco005Bean.contractSPList}" reRender="dtbContract" 
							rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							rendered="#{semmco005Bean.renderedContract}">
							<a4j:support event="onRowClick"   action="#{semmco005Action.getRowIdOnClick}" reRender="dtbContract">
								<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								<h:selectBooleanCheckbox id="chkBoxAll" value="#{semmco005Bean.chkSelAll}" disabled="#{semmco005Bean.disableSelectAll}">
										<a4j:support event="onclick" action="#{semmco005Action.selectAllRow}" 
											reRender="btnAdd,dtbContract,chkBoxAll"/>
								</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center"><h:selectBooleanCheckbox id="contractSelected" value="#{contractSP.checkBox}" rendered="#{contractSP.dataObj.rowId != null and contractSP.disableCheckBox}">
										<a4j:support event="onclick" action="#{semmco005Action.onRenderButton}" reRender="pnlSearchResult,btnAdd,dtbContract,contractSelected">
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
										<a4j:actionparam name="status" value="#{contractSP.dataObj.contractStatusName}" />
										<a4j:actionparam name="checked" value="#{contractSP.checkBox}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
									
								
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText  styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
            					<a4j:commandLink id="hlkEdit" value="#{jspMsg['label.saveContract']}"
            					action="#{navAction.navi}" reRender="oppContent" onclick="changeTab();">
									<a4j:actionparam name="navModule" value="co" />
	            					<a4j:actionparam name="navProgram" value="SEMMCO005-2" />	
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO005" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateContract" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
									<a4j:actionparam name="siteName" value="#{contractSP.dataObj.siteName}"/>
									<a4j:actionparam name="company" value="#{contractSP.dataObj.company}"/>
									<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}" />
									<a4j:actionparam name="groupNumber" value="#{contractSP.dataObj.groupNo}" />
            					</a4j:commandLink>
            					<a4j:jsFunction name="changeTab" action="#{semmco005Action.setTabNo}">
            						<a4j:actionparam name="tabNo" value="2"/>
            					</a4j:jsFunction>
								</div>
							</rich:column>
							
							
							<rich:column  sortBy="#{contractSP.dataObj.groupNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.groupNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.groupNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{contractSP.dataObj.contractNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{contractSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.oldContractNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.oldContractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{contractSP.dataObj.oldContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.siteName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractSP.dataObj.effDate}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.effDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.expDate}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.expDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{contractSP.dataObj.lessorName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.lessorName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.lessorName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.dutyPayStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dutyPayStatusName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.dutyPayStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.remark}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.contractStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.contractStatusName}" styleClass="contentform" />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{contractSP.dataObj.borrowStatus}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.borrowStatus']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.borrowStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{contractSP.dataObj.siteStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.stieStatusName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.flowStatus}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
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
											<f:param value="#{fn:length(semmco005Bean.contractSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContract"
											maxPages="#{semmco005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContract" 
											style="background-color: #cccccc;"
											page="#{semmco005Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						</rich:panel>
						<!--  data table for role Legal -->
						<rich:panel id="pnlSearchResultLegal" styleClass="sem_autoScrollbar" rendered="#{semmco005Bean.renderedLegal}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1700"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco005Bean.msgDataNotFound}" rendered="#{semmco005Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="100%" id="dtbContractLegal" cellpadding="1" cellspacing="0" border="0"
							var="contractSP" value="#{semmco005Bean.contractSPList}" reRender="dtbContractLegal" 
							rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							rendered="#{semmco005Bean.renderedLegal}">
							<a4j:support event="onRowClick"   action="#{semmco005Action.getRowIdOnClick}" reRender="dtbContractLegal">
								<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
								<h:selectBooleanCheckbox value="#{semmco005Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmco005Action.selectAllRow}" 
											reRender="btnPrintCheckDoc,btnExport,dtbContractLegal"/>
								</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="contractSelected" value="#{contractSP.checkBox}" 
										rendered="#{contractSP.dataObj.rowId != null}">
										<a4j:support event="onclick" action="#{semmco005Action.onRenderButton}" 
										reRender="btnPrintCheckDoc,btnExport,dtbContract,pnlSearchResultLegal">
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"	
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText  styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
            					<a4j:commandLink id="hlkEdit" value="#{jspMsg['label.saveContract']}"
            					action="#{navAction.navi}" reRender="oppContent">
									<a4j:actionparam name="navModule" value="co" />
	            					<a4j:actionparam name="navProgram" value="SEMMCO005-2" />	
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO005" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateContract" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
									<a4j:actionparam name="siteName" value="#{contractSP.dataObj.siteName}"/>
									<a4j:actionparam name="company" value="#{contractSP.dataObj.company}"/>
									<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}" />
            					</a4j:commandLink>          							
								</div>
							</rich:column>
						<rich:column  sortBy="#{contractSP.dataObj.docNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
						title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractSP.dataObj.groupNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.groupNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.groupNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{contractSP.dataObj.contractNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkLegalViewPopupSiteInfo" value="#{contractSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.oldContractNo}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.oldContractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkLegalViewPopupSiteInfo2" value="#{contractSP.dataObj.oldContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO005-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{contractSP.dataObj.siteName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.reqTypeName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqTypeName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.reqTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.title}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.title}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.outDate}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.outDate']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.outDateStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.checkDocStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.checkDocStatusName']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.checkDocStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.contractStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.contractStatusName}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.siteStatusName}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteStatusName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{contractSP.dataObj.flowStatus}" styleClass="#{(semmco005Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
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
											<f:param value="#{fn:length(semmco005Bean.contractSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractLegal"
											maxPages="#{semmco005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractLegal" 
											style="background-color: #cccccc;"
											page="#{semmco005Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				<jsp:include page="../../pages/co/semmco005-popupSaveContract.jsp" />
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
				

