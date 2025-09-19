<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct002" var="jspMsg"/>
<h:panelGrid width="100%" id="pnlCT002_1">
	<rich:panel id="pnlSearchBGMaster">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.master.search']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorCT002Search">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct002Bean.renderedMsgFormSearch}">
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
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="20%" valign="bottom">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.companyName']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlCompany" 
		                							 value="#{semmct002Bean.tmpBgMaster.company}" 
		                							 onchange="setRequireValidate();"> 
										<f:selectItems value="#{semmct002Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="setRequireValidate" reRender="companyDisplay,ddlExpense">
										
									</a4j:jsFunction>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmct002Bean.tmpBgMaster.company}" styleClass="ms28"/>
				                	</td>
				                	
			                	 </tr> 
			                	 
								<tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText label="#{jspMsg['label.contractNo']}" id="txtContractNo" value="#{semmct002Bean.tmpBgMaster.contractNo}" />
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.stationName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:inputText id="txtStationName" value="#{semmct002Bean.tmpBgMaster.siteName}" size="42"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
									<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                				<h:inputText id="txtVendorId" value="#{semmct002Bean.tmpBgMaster.vendorId}"
		                				style="margin-right:5px;" />
		                			
		                				<!-- >> fixed by.. YUT 2015/10/18 -->
			                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
							            action="#{semmct002Action.initAddVendor}" reRender="oppContent"
							            oncomplete="#{rich:component('mct002PopUp_addVendor')}.show(); return false">
										</a4j:commandButton>
			                			<!-- << -->	
				                	</td>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtVendorName" value="#{semmct002Bean.tmpBgMaster.vendorName}" size="42"/>
									<rich:spacer width="5"/>
									
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right"><!--
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									--><h:outputText value="#{jspMsg['label.expensesType']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlExpense" value="#{semmct002Bean.tmpBgMaster.expenseType}" 
		                							 label="#{jspMsg['column.header.expensesType']}"
		                							 > 
										<f:selectItems value="#{semmct002Bean.expenseTypeList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtBgNo" value="#{semmct002Bean.tmpBgMaster.bgNo}">
		                			</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right">
									<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlBank" value="#{semmct002Bean.tmpBgMaster.bgBank}"> 
										<f:selectItems value="#{semmct002Bean.bankNameList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7"/>
		                			</td>
		                			<td>
	                					<rich:calendar id="cldStartDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmct002Bean.tmpBgMaster.bgStartDt}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldStartDt','cldEndStartDt');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldStartDt','cldEndStartDt');"
											   label="#{jspMsg['column.header.startDt']}"
											   >
										</rich:calendar> 
										<rich:spacer width="1"></rich:spacer> -
	                					<rich:calendar id="cldEndStartDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmct002Bean.tmpBgMaster.bgEndDt}"
											   showWeeksBar="false"
											   inputSize="13"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldEndStartDt','cldStartDt');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldEndStartDt','cldStartDt');"
											   label="#{jspMsg['column.header.startDt']}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right">
									<h:outputText value="#{jspMsg['label.status']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlStatus" value="#{semmct002Bean.tmpBgMaster.bgStatus}"> 
										<f:selectItems value="#{semmct002Bean.bgStatusList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldEndDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmct002Bean.tmpBgMaster.ctrStartDt}"
												   showWeeksBar="false"
												   inputSize="13"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldEndDt','cldEndEndDt');"
											 	   oncollapse="validateRichCalendarFromTo('frmSearch','cldEndDt','cldEndEndDt');"
											   	   label="#{jspMsg['column.header.endDt']}">
									</rich:calendar>
									<rich:spacer width="1"></rich:spacer> -
									<rich:calendar id="cldEndEndDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmct002Bean.tmpBgMaster.ctrEndDt}"
												   showWeeksBar="false"
												   inputSize="13"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldEndEndDt','cldEndDt');"
											 	   oncollapse="validateRichCalendarFromTo('frmSearch','cldEndEndDt','cldEndDt');"
											   	   label="#{jspMsg['column.header.endDt']}">
									</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmErrorCT002Search,pnlSearchCriteria,pnlSearchResult">
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT002-1" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmErrorCT002Search,pnlSearchCriteria,pnlSearchResult,frmSearch">
			           		<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT002-1" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				<a4j:form id="frmButton">
				<!-- begin content button -->
				<h:panelGrid  columns="3" id="grdAddCommand">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.newBG']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" rendered="#{semmct002Bean.rendererSSO['btnSMBBG001']}" reRender="oppContent">
	            		<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="navModuleFrom" value="gm" />
						<a4j:actionparam name="navProgramFrom" value="SEMMCT002-1" />
						<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT002" />
						<a4j:actionparam name="isPageFrom" value="true" />
						<a4j:actionparam name="mode" value="INSERT" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnReject" oncomplete="#{rich:component('popupFrmRejectBG')}.show(); return false" styleClass="rich-button" 
				    action="#{navAction.navi}" value="#{jspMsg['btn.fnReject']}"  reRender="oppContent" 
				    disabled="#{semmct002Bean.disabledBtnExport}" rendered="#{semmct002Bean.rendererSSO['btnSMBBG002']}" >
						<a4j:actionparam name="navModule" value="gm" />
	         			<a4j:actionparam name="navProgram" value="SEMMCT002-1" />	
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="UPDATE" />
						<a4j:actionparam name="bgStatus" value="R" />
					</a4j:commandButton>
					
					<h:commandButton id ="btnExport" action="#{semmct002Action.doExportExcel}"  
	            					 styleClass="rich-button" value="#{jspMsg['btn.exportExcel']}"
	            					 rendered="#{semmct002Bean.renderer['btnExport']}" 
	            					 disabled="#{semmct002Bean.disabledBtnExport}">
	            	</h:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				</a4j:form>
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="130%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1280"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct002Bean.msgDataNotFound}" rendered="#{semmct002Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						
						<rich:dataTable width="100%" id="dtbBGMaster" cellpadding="1" cellspacing="0" border="0"
							var="bgMaster" value="#{semmct002Bean.bgMasterList}" 
							rows="#{semmct002Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column  styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmct002Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmct002Action.selectAllRow}" reRender="dtbBGMaster,btnExport,frmButton"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox id="chkSelect"  value="#{bgMaster.checkBox}">
									<a4j:support event="onclick" action="#{semmct002Action.onRenderExportButton}" reRender="btnExport,frmButton,dtbBGMaster">
										<a4j:actionparam name="rowId" value="#{bgMaster.dataObj.rowId}" />
									</a4j:support>
									
								</h:selectBooleanCheckbox>
							</rich:column>
							<rich:column  styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}"
										  rendered="#{semmct002Bean.renderer['btnEditSM']}">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnEditSM" action="#{navAction.navi}" 
	            									   reRender="oppContent" 
	            									   image="images/edit.png" 
	            									   style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="gm" />
		            					<a4j:actionparam name="navProgram" value="SEMMCT002-2" />	
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{bgMaster.dataObj.rowId}"/>
										<a4j:actionparam name="navModuleFrom" value="gm" />
										<a4j:actionparam name="navProgramFrom" value="SEMMCT002-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT002" />
										<a4j:actionparam name="isPageFrom" value="true" />
										<a4j:actionparam name="mode" value="UPDATE" />
	            					</a4j:commandButton>
	            					 
								</div>
							</rich:column>
							<rich:column  styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}" 
										  rendered="#{semmct002Bean.renderer['btnEditFN']}">
								<f:facet name="header">
									<h:outputText value="Edit FN" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					 
	            					<a4j:commandButton id="btnEditFN" oncomplete="#{rich:component('popupFrmSaveBG')}.show(); return false"
	            									   action="#{navAction.navi}" 
	            									   reRender="oppContent"
	            									   image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="gm" />
		            					<a4j:actionparam name="navProgram" value="SEMMCT002-1" />	
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{bgMaster.dataObj.rowId}"/>
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="bgStatus" value="F" />
	            					</a4j:commandButton>  
	            					                 							
								</div>
							</rich:column>
							<rich:column  styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}"
										  rendered="#{semmct002Bean.renderer['btnDelete']}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDelete" oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15">
     									   <a4j:actionparam name="navModule" value="gm" />
				           				   <a4j:actionparam name="navProgram" value="SEMMCT002-1" />	
										   <a4j:actionparam name="moduleWithNavi" value="gm" />
										   <a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										   <a4j:actionparam name="methodWithNavi" value="initDelBgMaster" />
										   <a4j:actionparam name="rowId" value="#{bgMaster.dataObj.rowId}"/>	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column  styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}"
										  rendered="#{semmct002Bean.renderer['btnView']}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton  id="btnView" action="#{navAction.navi}" image="images/view.png" style="height: 15; width: 15"
	            					reRender="oppContent">
										<a4j:actionparam name="navModule" value="gm" />
		            					<a4j:actionparam name="navProgram" value="SEMMCT002-2" />	
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{bgMaster.dataObj.rowId}"/>
										<a4j:actionparam name="siteInfoId" value="#{bgMaster.dataObj.siteInfoId}"/>
										<a4j:actionparam name="mode" value="SELECT"/>
										<a4j:actionparam name="navModuleFrom" value="gm" />
										<a4j:actionparam name="navProgramFrom" value="SEMMCT002-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMCT002" />
										<a4j:actionparam name="isPageFrom" value="true" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column  sortBy="#{bgMaster.dataObj.contractNo}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.dataObj.contractNo}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column style="width: 300" sortBy="#{bgMaster.dataObj.siteName}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.stationName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.dataObj.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{bgMaster.dataObj.expenseName}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expensesType']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.dataObj.expenseName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{bgMaster.dataObj.bgNo}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgNo']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.dataObj.bgNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  style="width: 300" sortBy="#{bgMaster.dataObj.bgBankName}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.dataObj.bgBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{bgMaster.dataObj.bgStartDt}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.startDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.dataObj.bgStartDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{bgMaster.dataObj.bgEndDt}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.endDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									
									<h:outputText value="#{bgMaster.dataObj.bgEndDt}" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{bgMaster.dataObj.bgAmt}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.amount']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{bgMaster.dataObj.bgAmt}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  style="width: 120" sortBy="#{bgMaster.dataObj.bgStatusName}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.status']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.dataObj.bgStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{bgMaster.dataObj.rejectReason}" styleClass="#{(semmct002Bean.tmpRowId==bgMaster.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rejectReason']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.dataObj.rejectReason}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct002Bean.bgMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="11">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBGMaster"
											maxPages="#{semmct002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmct002Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/gm/semmct002-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct002Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbBGMaster" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT002-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doDelBGMaster" />
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>


