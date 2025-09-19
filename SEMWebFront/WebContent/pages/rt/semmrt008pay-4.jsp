<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt008" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchPettyCash">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmSearchPay']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt008PayBean.renderedMsgFormSearch}" style=" width : 322px; height : 34px;">
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
			<a4j:form id="frmSearchPettyCash">
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
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<!--<h:selectOneMenu label="#{jspMsg['label.company']}" id="ddlCompanyBK" 
		                							 value="#{semmrt008PayBean.tmpPettyCashPay.company}" 
		                							 onchange="setRequireValidate();"> 
										<f:selectItems value="#{semmrt008PayBean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="setRequireValidate" reRender="companyDisplay">
										
									</a4j:jsFunction>
									-->
									<a4j:region>
									<h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlCompany" 
													 value="#{semmrt008PayBean.tmpPettyCashPay.company}" >
						                		
												<f:selectItems value="#{semmrt008PayBean.companyList}"/>
												<f:selectItem itemValue="AWN2" itemLabel="AWN2"/>
												<a4j:support event="onchange"  reRender="companyDisplay">
								                </a4j:support>
									</h:selectOneMenu>
									</a4j:region>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmrt008PayBean.tmpPettyCashPay.company}" styleClass="ms28"/>
									
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:selectOneMenu label="#{jspMsg['label.region']}" id="ddlRegion" 
		                							 value="#{semmrt008PayBean.tmpPettyCashPay.region}" > 
										<f:selectItems value="#{semmrt008PayBean.regionList}"/>
									</h:selectOneMenu>
				                	</td>
				                	
			                	 </tr> 
			                	 
			                	 <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.payNo']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText label="#{jspMsg['label.payNo']}" id="txtPayNo" value="#{semmrt008PayBean.tmpPettyCashPay.pettyCashPayNo}" />
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="Ref. Batch Clear :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:inputText  id="txtRefClearBatchNo" value="#{semmrt008PayBean.tmpPettyCashPay.refClrBatchNo}" />
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.requestName']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText label="#{jspMsg['label.requestName']}" id="txtReqName" value="#{semmrt008PayBean.tmpPettyCashPay.requestName}" />
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.requestType']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:selectOneMenu label="#{jspMsg['label.region']}" id="ddlReqType" 
		                							 value="#{semmrt008PayBean.tmpPettyCashPay.requestType}"> 
										<f:selectItems value="#{semmrt008PayBean.expenseTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.requestSubject']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu label="#{jspMsg['label.requestSubject']}" id="ddlReqSubj" value="#{semmrt008PayBean.tmpPettyCashPay.requestSubject}"> 
										<f:selectItems value="#{semmrt008PayBean.requestSubjList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.requestDtFrom']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
									<rich:calendar id="cldRequestDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008PayBean.tmpPettyCashPay.requestDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputkeyup="this.value = this.value.substring(0, 10);"
											   oninputblur="validateRichCalendarFromTo('frmSearchPettyCash','cldRequestDtFrom','cldRequestDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearchPettyCash','cldRequestDtFrom','cldRequestDtTo');"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.requestDtFrom']}"
											   >
										</rich:calendar> 
										<rich:spacer width="2"></rich:spacer> 
										<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
										<rich:spacer width="2"></rich:spacer>
	                					<rich:calendar id="cldRequestDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008PayBean.tmpPettyCashPay.requestDtTo}"
											   showWeeksBar="false"
											   inputSize="13"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputkeyup="this.value = this.value.substring(0, 10);"
											   oninputblur="validateRichCalendarFromTo('frmSearchPettyCash','cldRequestDtTo','cldRequestDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearchPettyCash','cldRequestDtTo','cldRequestDtFrom');"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.requestDtFrom']}">
												
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText label="#{jspMsg['label.contractNo']}" id="txtContractNo" value="#{semmrt008PayBean.tmpPettyCashPay.contractNo}" />
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.siteName']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:inputText label="#{jspMsg['label.siteName']}" id="txtSiteName" value="#{semmrt008PayBean.tmpPettyCashPay.siteName}" />
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.dueDtFrom']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
	                					<rich:calendar id="cldDueDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008PayBean.tmpPettyCashPay.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputblur="validateRichCalendarFromTo('frmSearchPettyCash','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearchPettyCash','cldDueDtFrom','cldDueDtTo');"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.dueDtFrom']}"
											   >
											  
										</rich:calendar> 
										<rich:spacer width="2"></rich:spacer> 
										<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
										<rich:spacer width="2"></rich:spacer>
	                					<rich:calendar id="cldDueDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008PayBean.tmpPettyCashPay.dueDtTo}"
											   showWeeksBar="false"
											   inputSize="13"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputblur="validateRichCalendarFromTo('frmSearchPettyCash','cldDueDtTo','cldDueDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearchPettyCash','cldDueDtTo','cldDueDtFrom');"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.dueDtFrom']}">
										</rich:calendar>
				                	</td>
				                	<td align="right" width="15%">
									<h:outputText value="#{jspMsg['label.category']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:selectOneMenu label="#{jspMsg['label.category']}" id="ddlCategory" value="#{semmrt008PayBean.tmpPettyCashPay.category}"> 
										<f:selectItems value="#{semmrt008PayBean.categoryList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.payStatus']} :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu label="#{jspMsg['label.payStatus']}" id="ddlPayStatus" value="#{semmrt008PayBean.tmpPettyCashPay.pettyCashPayStatus}"> 
										<f:selectItems value="#{semmrt008PayBean.payStatusList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right">
		                			</td>
		                			<td colspan="3">
		                				<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,btnExport">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
										<a4j:actionparam name="mode" value="SEARCH" />
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchPettyCash">
						           		<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="doClear" />
						           		</a4j:commandButton>
				                	</td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				<a4j:form id="frmButton">
				<!-- begin content button -->
				
				<h:panelGrid width="96%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table width="100%" border="0">
							<tr>
								<td align="right">
									<a4j:commandButton id="btnNew" styleClass="rich-button" 
					            	action="#{navAction.navi}" value="New"  
					            	reRender="oppContent" style="width:60"
					            	rendered="#{semmrt008PayBean.renderer['btnNew']}"
					            	>
					            		<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="INSERT" />
										<a4j:actionparam name="eventType" value="Add" />
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnExport" value="Export" styleClass="rich-button" 
									 action="#{navAction.navi}" reRender="frmError,frmShowReportExcel,pnlShowReportExcel,frmSearchResult,btnExport" 
									 disabled="#{semmrt008PayBean.disabledBtnExport}">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="semmrt00" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
											<a4j:actionparam name="methodWithNavi" value="initExportPropertyTax" />
									</a4j:commandButton>
	            					<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnApprove" oncomplete="#{rich:component('mdpConfirmApproveDialog')}.show(); return false" styleClass="rich-button" 
								    action="#{navAction.navi}" value="Approve"  
								    reRender="oppContent" style="width:70"
								    rendered="#{semmrt008PayBean.rendererSSO['btnSMBCL001']}"
								    >
										<a4j:actionparam name="navModule" value="rt" />
					         			<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Approve" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnCancel" oncomplete="#{rich:component('mdpConfirmCancelDialog')}.show(); return false" styleClass="rich-button" 
								    action="#{navAction.navi}" value="Cancel"  
								    reRender="oppContent" style="width:60"
								    rendered="#{semmrt008PayBean.renderer['btnCancel']}">
										<a4j:actionparam name="navModule" value="rt" />
					         			<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Cancel" />
									</a4j:commandButton>
			                	</td>
		                	 </tr> 
		                </table>
		            </h:panelGroup>
		        </h:panelGrid>
					
					
				<!-- end content button -->
				</a4j:form>
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="120%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2200"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt008PayBean.msgDataNotFound}" rendered="#{semmrt008PayBean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						
						<rich:dataTable width="100%" id="dtbPettyCashPay" cellpadding="1" cellspacing="0" border="0"
							var="pettyCashPay" value="#{semmrt008PayBean.pettyCashPayList}" 
							rows="#{semmrt008PayBean.rowPerPage}"
							rowClasses="cur" 
							styleClass="dataTable" >

							
							<rich:column styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}" >
								
								<f:facet name="header">
								<a4j:region>
									<h:selectBooleanCheckbox value="#{semmrt008PayBean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmrt008PayAction.selectAllRow}" reRender="btnExport,dtbPettyCashPay"/>
									</h:selectBooleanCheckbox>
								</a4j:region>
								</f:facet>
								
								<a4j:region>
								<h:selectBooleanCheckbox id="chkSelect"  value="#{pettyCashPay.checkBox}">
									<a4j:support event="onclick" action="#{semmrt008PayAction.onRenderExportButton}" reRender="btnExport">
										<a4j:actionparam name="rowId" value="#{pettyCashPay.dataObj.rowId}" />
									</a4j:support>
								</h:selectBooleanCheckbox>
								</a4j:region>
							</rich:column>
							
							<rich:column  styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}"
										  rendered="#{semmrt008PayBean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" 
	            									   reRender="oppContent" 
	            									   image="images/edit.png" 
	            									   style="FONT-SIZE: xx-small; height: 15; width: 15"
	            									   id="btnEdit"
	            									   >
					            		<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{pettyCashPay.dataObj.rowId}"/>
										<a4j:actionparam name="companyName" value="#{pettyCashPay.dataObj.company}"/>
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Edit" />
	            					</a4j:commandButton>
	            					                 							
								</div>
							</rich:column>
							<rich:column  styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}" 
										  rendered="#{semmrt008Bean.renderer['btnDelete']}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   			   action="#{navAction.navi}" 
     									   			   image="images/delete.png" 
     									   			   style="height: 15; width: 15"
     									   			   id="btnDelete"
     									   			   >
     									   <a4j:actionparam name="navModule" value="rt" />
				           				   <a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
										   <a4j:actionparam name="moduleWithNavi" value="rt" />
										   <a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
										   <a4j:actionparam name="methodWithNavi" value="initDelPettyCashPay" />
										   <a4j:actionparam name="rowId" value="#{pettyCashPay.dataObj.rowId}"/>	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column sortBy="#{pettyCashPay.dataObj.pettyCashPayNo}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.payNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.pettyCashPayNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.refClrBatchNo}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Batch Clear" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.refClrBatchNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.exportDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.exportDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.exportDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{pettyCashPay.dataObj.requestName}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.requestName']}" styleClass="contentform" style="width:150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.requestName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.requestSubject}"  styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.requestSubject']}" styleClass="contentform" style="width:150" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{pettyCashPay.dataObj.requestSubject}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.requestAmt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.requestAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCashPay.dataObj.requestAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.vatTypeName}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Vat" styleClass="contentform" style="width: 45"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.vatTypeName}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{pettyCashPay.dataObj.vatType}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.requestAmt']} Vat" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCashPay.dataObj.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.incRequestAmt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.incRequestAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCashPay.dataObj.incRequestAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.taxInvoiceNo}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.taxInvoiceNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.taxInvoiceNo}" styleClass="contentform" />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{pettyCashPay.dataObj.taxInvoiceDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.taxInvoiceDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.taxInvoiceDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.requestDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.requestDtFrom']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.requestDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  style="width: 90" sortBy="#{pettyCashPay.dataObj.contractNo}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.contractNo}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pettyCashPay.dataObj.siteName}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="contentform" style="width: 125"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  style="width: 90" sortBy="#{pettyCashPay.dataObj.effectiveDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.effDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.effectiveDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pettyCashPay.dataObj.expireDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expireDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.expireDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column style="width: 140" sortBy="#{pettyCashPay.dataObj.expenseTypeName}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.expenseTypeName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.dueDt}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.dueDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.dueDt}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCashPay.dataObj.pettyCashPayStatus}" styleClass="#{(semmrt008PayBean.tmpRowId==pettyCashPay.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.payStatus']}" styleClass="contentform" style="width: 80" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCashPay.dataObj.pettyCashPayStatusName}" styleClass="contentform" />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt008PayBean.pettyCashPayList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="5">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPettyCashPay"
											maxPages="#{semmrt008PayBean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstPettyCashPay" 
											style="background-color: #cccccc;"
											page="#{semmrt008PayBean.scrollerPage}" 
										/>
									</rich:column>
									<rich:column colspan="12">
										<h:outputFormat value="จำนวนเงินรวม  : "/>
										<h:outputText value="#{semmrt008PayBean.tmpPettyCashPay.totalAmount}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
										</h:outputText>
										<h:outputFormat value=" บาท"/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
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
						<h:outputText value="#{semmrt008PayBean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doDelPettyCash" />
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

<rich:modalPanel id="mdpConfirmApproveDialog" autosized="true" rendered="#{semmrt008PayBean.renderedDailog}">	
	<f:facet name="header">
    	<h:outputText value="Confirm Approve"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmApproveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="3" styleClass="contentlabelform" width="230px">
						<h:outputText value="#{semmrt008PayBean.msgDoApprove}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doApprove" />
							<rich:componentControl for="mdpConfirmApproveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmApproveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmCancelDialog" autosized="true" rendered="#{semmrt008PayBean.renderedDailog}">	
	<f:facet name="header">
    	<h:outputText value="Confirm Cancel"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCancelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="3" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmrt008PayBean.msgDoCancel}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doCancel" />
							<rich:componentControl for="mdpConfirmCancelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCancelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<a4j:form id="frmShowReportExcel">
<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmrt008PayBean.displayReportFlag}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmrt008PayAction.doExportExcel}"  />								
		<script>document.getElementById('incContent:frmShowReportExcel:bthShowReportExcel').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>

