<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi006Bean.renderedMsgFormTop}">
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
				                	<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmsi006Bean.approveRenewSearchSP.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmsi006Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmsi006Bean.approveRenewSearchSP.company}" styleClass="ms28"/>
				                	</td>
				                	
							</tr>
							<tr>
								<td align="right" width="20%" valign="bottom">
				                	<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                		</td>
		                		<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlRegion" value="#{semmsi006Bean.approveRenewSearchSP.region}">
											<f:selectItems value="#{semmsi006Bean.regionList}"/>
											<a4j:support event="onchange" action="#{semmsi006Action.regionChange}" reRender="ddlZone"/>
										</h:selectOneMenu>
				                </td>
								<td align="right" width="20%" valign="bottom">
				                	<h:outputText value="#{jspMsg['label.zone']}" styleClass="ms7"/>
		                		</td>
		                		<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlZone" value="#{semmsi006Bean.approveRenewSearchSP.zone}">
											<f:selectItems value="#{semmsi006Bean.zoneList}"/>
										</h:selectOneMenu>
				                </td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtcontractNo" value="#{semmsi006Bean.approveRenewSearchSP.contractNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlSiteType" value="#{semmsi006Bean.approveRenewSearchSP.siteType}">
											<f:selectItems value="#{semmsi006Bean.siteTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldContractStartDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmsi006Bean.approveRenewSearchSP.contractStartDt}" inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									 cellWidth="20px" cellHeight="20px"
									 label="#{jspMsg['column.header.contractStartDt']}">
									 </rich:calendar>
				                	</td>
				                	<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldContractEndDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			value="#{semmsi006Bean.approveRenewSearchSP.contractEndDt}" inputSize="13"
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									 cellWidth="20px" cellHeight="20px"
									 label="#{jspMsg['column.header.contractEndDt']}"
									 />
		                										
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				<h:selectBooleanCheckbox id="chkcontractNoEndFlag" styleClass="ms7" value=""/>
		                				<h:outputText value="#{jspMsg['label.contractNoEndFlag']}" styleClass="ms7"/>
				                	</td>
				                	<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semmsi006Bean.approveRenewSearchSP.locationId}"
		                			size="18" maxlength="15"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
				                	<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationName" value="#{semmsi006Bean.approveRenewSearchSP.locationCode}"
		                			size="18" maxlength="15"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteName" value="#{semmsi006Bean.approveRenewSearchSP.siteName}"
		                			 size="30" maxlength="200"/>
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 		<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.sendRenewFrom']}" styleClass="ms7"/>
									
		                			</td>
		                			<td colspan="3"  width="80%">
		                			<rich:calendar id="cldSendRenewDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi006Bean.approveRenewSearchSP.sendRenewDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											    oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										       cellWidth="20px" cellHeight="20px"
										       oninputblur="validateRichCalendarFromTo('frmSearch','cldSendRenewDtFrom','cldSendRenewTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSendRenewDtFrom','cldSendRenewTo');"
										       label="#{jspMsg['column.header.approveDateFrom']}">
											  
										</rich:calendar>
									<rich:spacer width="5"/>	
									<h:outputText value="#{jspMsg['label.sendRenewTo']}" styleClass="ms7"/>
									<rich:spacer width="5"/>
									<rich:calendar id="cldSendRenewTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi006Bean.approveRenewSearchSP.sendRenewDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											    oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										       cellWidth="20px" cellHeight="20px"
										       oninputblur="validateRichCalendarFromTo('frmSearch','cldSendRenewTo','cldSendRenewDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSendRenewTo','cldSendRenewDtFrom');"
										       label="#{jspMsg['column.header.approveDateTo']}">
											   
										</rich:calendar>

				                </tr>
			                	 <tr>
			                	 <td align="right" width="25%">
			                	 <h:outputText value="#{jspMsg['label.approveBackDtFrom']}" styleClass="ms7"/>
			                	 </td>
			                	 <td colspan="3" width="75%">
				                	 <rich:calendar id="cldApproveBackDtFrom" showWeeksBar="false" locale="th/TH" enableManualInput="true" 
											 datePattern="dd/MM/yyyy" value="#{semmsi006Bean.approveRenewSearchSP.approveBackDtFrom}" inputSize="13"
											 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											 cellWidth="20px" cellHeight="20px"
											 oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveBackDtFrom','cldApproveBackDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveBackDtFrom','cldApproveBackDtTo');"
											 label="#{jspMsg['column.header.approveBackDateFrom']}">
											 
									 </rich:calendar>
								 <rich:spacer width="5"/>	
								 <h:outputText value="#{jspMsg['label.approveBackDtTo']}" styleClass="ms7"/>
								 <rich:spacer width="5"/>
								 	 <rich:calendar id="cldApproveBackDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" 
											 datePattern="dd/MM/yyyy" value="#{semmsi006Bean.approveRenewSearchSP.approveBackDtTo}" inputSize="13"
											 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											 cellWidth="20px" cellHeight="20px"
											 oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveBackDtTo','cldApproveBackDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveBackDtTo','cldApproveBackDtFrom');"
											 label="#{jspMsg['column.header.approveBackDateTo']}">
											 
									 </rich:calendar>	 
			                	 </td>
			                	 
			                	 
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.sendRenewType']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	<h:selectOneMenu id="ddlSendRenewType" value="#{semmsi006Bean.approveRenewSearchSP.sendRenewType}">
											<f:selectItems value="#{semmsi006Bean.sendRenewTypeList}"/>
										</h:selectOneMenu>
								 </td>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.approveStatus']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	<h:selectOneMenu id="ddlApproveStatus" value="#{semmsi006Bean.approveRenewSearchSP.approveStatus}">
											<f:selectItems value="#{semmsi006Bean.approveStatusList}"/>
										</h:selectOneMenu>
								 </td>
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
								 	<h:outputText value="#{jspMsg['label.sendRenewStatus']}" styleClass="ms7"/>
								 </td>
								 <td>
								 <h:selectOneMenu id="ddlSendRenewStatus" value="#{semmsi006Bean.approveRenewSearchSP.sendRenewStatus}">
											<f:selectItems value="#{semmsi006Bean.sendRenewStatusList}"/>
										</h:selectOneMenu>		
								 </td>								 
								 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			           		  	<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi006Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid columns="3" id="grdAddNewCommand">
					<a4j:commandButton id="btnApproveRenew" value="#{jspMsg['btn.approveStatus1']}" styleClass="rich-button" disabled="#{semmsi006Bean.disabledBtnExport}" 
					 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,mdpConfirmSaveDialog" rendered="#{semmsi006Bean.renderer['btnApproveRenew']}"
					 oncomplete="if(#{semmsi006Bean.tmpFlagChkBtn == 'true'}){
			           		 		#{rich:component('mdpConfirmSaveDialog')}.show(); return false}">
					 			<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateApproveStatus" />
								<a4j:actionparam name="checkApproveStatus" value="1" />
					</a4j:commandButton>
					<a4j:commandButton id="btnCancleApproveRenew" value="#{jspMsg['btn.approveStatus2']}" styleClass="rich-button" disabled="#{semmsi006Bean.disabledBtnExport}" 
					 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,mdpConfirmSaveDialog" rendered="#{semmsi006Bean.renderer['btnCancleApproveRenew']}"
					 oncomplete="if(#{semmsi006Bean.tmpFlagChkBtn == 'true'}){
			           		 		#{rich:component('mdpConfirmSaveDialog')}.show(); return false}">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateApproveStatus" />
								<a4j:actionparam name="checkApproveStatus" value="2" />
					</a4j:commandButton>
					<a4j:commandButton id="btnApproveResult" value="#{jspMsg['btn.approveStatus3']}" styleClass="rich-button" disabled="#{semmsi006Bean.disabledBtnExport}" 
					 action="#{navAction.navi}" reRender="frmError,pnlSearchResult" rendered="#{semmsi006Bean.renderer['btnApproveResult']}">
					 			<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateSendRenewStatus" />
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2650"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi006Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi006Bean.msgDataNotFound}" rendered="#{semmsi006Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbApproveRenewSrch" cellpadding="1" cellspacing="0" border="0"
							var="approveRenewSP" value="#{semmsi006Bean.approveRenewSearchSPList}" reRender="dstApproveRenewSrch" 
							rows="#{semmsi006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable" >
							<a4j:support event="onRowClick"   action="#{semmsi006Action.getRowIdOnClick}" reRender="dtbApproveRenewSrch">
								<a4j:actionparam name="rowId" value="#{approveRenewSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:selectBooleanCheckbox style="width: 20" value="#{semmsi006Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmsi006Action.selectAllRow}" reRender="dtbApproveRenewSrch,btnApproveRenew,btnCancleApproveRenew,btnApproveResult"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center" style="width: 20px;">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{approveRenewSP.checkBox}">
										<a4j:support event="onclick" action="#{semmsi006Action.onRenderExportButton}" reRender="dtbApproveRenewSrch,btnApproveRenew,btnCancleApproveRenew,btnApproveResult">
											<a4j:actionparam name="rowId" value="#{approveRenewSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>        							
								</div>
							</rich:column>
							<rich:column id="btnEdit" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmsi006Bean.renderer['btnEdit']}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width:36px"/>
								</f:facet>
								<div align="center" style="width:36px;"> 	
									<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;" action="#{navAction.navi}"  styleClass="ms7"
									 oncomplete="#{rich:component('popupApproveRenewEdit')}.show(); return false" reRender="popupApproveRenewEdit">
									 <a4j:actionparam name="navModule" value="si" />
									 <a4j:actionparam name="navProgram" value="SEMMSI006-1" />
						   		   	<a4j:actionparam name="moduleWithNavi" value="si" />
									 <a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
									 <a4j:actionparam name="methodWithNavi" value="initEdit" />
									 <a4j:actionparam name="rowId" value="#{approveRenewSP.dataObj.rowId}" />
									</a4j:commandButton>						
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.renewAgeDesc}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.renewAgeDesc']}" styleClass="contentform" style="width:36px"/>
								</f:facet>
								<div align="center" style="width:36px;">
									<h:outputText value="#{approveRenewSP.dataObj.renewAgeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column width="1%" sortBy="#{approveRenewSP.dataObj.remark}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform" style="width:240px"/>
								</f:facet>
								<div align="left" style="width:240px;">
									<h:outputText value="#{approveRenewSP.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.contractNo}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<h:outputText value="#{approveRenewSP.dataObj.contractNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.siteName}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:210px"/>
								</f:facet>
								<div align="left" style="width:210px">
									<h:outputText value="#{approveRenewSP.dataObj.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.locationId}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style="width:72px"/>
								</f:facet>
								<div align="center" style="width:72px">
									<h:outputText value="#{approveRenewSP.dataObj.locationId}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.locationCode}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center" style="width:60px">
									<h:outputText value="#{approveRenewSP.dataObj.locationCode}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.networkStatus}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<h:outputText value="#{approveRenewSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{approveRenewSP.dataObj.effDt}" width="1%" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.effDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.expDt}" width="1%" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.address}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.address']}" styleClass="contentform" style="width:240px"/>
								</f:facet>
								<div align="left" style="width:240px">
									<h:outputText value="#{approveRenewSP.dataObj.address}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.sendRenewType}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewType']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<h:outputText value="#{approveRenewSP.dataObj.sendRenewType}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.approveStatus}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.approveStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<h:outputText value="#{approveRenewSP.dataObj.approveStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.sendRenewStatus}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewStatus']}" styleClass="contentform" style="width:160px"/>
								</f:facet>
								<div align="center" style="width:160px">
									<h:outputText value="#{approveRenewSP.dataObj.sendRenewStatus}" styleClass="contentform" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.approveBackDt}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.approveBackDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.approveBackDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.sendRenewBackDt}" width="1%" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewBackDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.sendRenewBackDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{approveRenewSP.dataObj.siteStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{approveRenewSP.dataObj.flowStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.flowStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{approveRenewSP.dataObj.flowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi006Bean.approveRenewSearchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="15">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbApproveRenewSrch"
											maxPages="#{semmsi006Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstApproveRenewSrch" 
											style="background-color: #cccccc;"
											page="#{semmsi006Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/si/semmsi006-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmSaveDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Save"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmSaveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmsi006Bean.msgConfirmSave}" styleClass="ms7" />
					</h:panelGrid></td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true"  reRender="frmError,pnlSearchResult" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI006-1" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
										<a4j:actionparam name="methodWithNavi" value="doConfirmSave" />								
							<rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" reRender="frmError">
						    <rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>