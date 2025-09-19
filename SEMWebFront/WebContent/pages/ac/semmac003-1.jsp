<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.account.semmac003" var="jspMsg"/>
<h:panelGrid width="100%" style="text-align: center;">
	<rich:panel style="text-align: left;">
		<f:facet name="header">
				<h:outputText value="Manage Interface SAP"/>
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
				<tr><td></td>
				<td>
				<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac003Bean.renderedMsgFormSearch}">
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
					<rich:panel id="pnlSearchCriteria" ><%--rendered="#{semmac002Bean.renderer['pnlSearchCriteria']}" --%>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="baseline">
										<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>										
										</td>
										<td colspan="3" width="80%" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmac003Bean.mac003Srch.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmac003Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmac003Bean.mac003Srch.company}" styleClass="ms28"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.errorDtFrom']}" styleClass="ms7" />										
										</td>
										<td width="30%">
											<rich:calendar id="cldErrorDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac003Bean.mac003Srch.errorDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											    oninputblur="validateRichCalendarFromTo('frmSearch','cldErrorDtFrom','cldErrorDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldErrorDtFrom','cldErrorDtTo');"
											   label="#{jspMsg['column.header.errorDtFrom']}">
											   
											</rich:calendar>
											<rich:spacer width="5"/>
											<h:outputText value="To :" styleClass="ms7" />
											<rich:spacer width="5"/>
											<rich:calendar id="cldErrorDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmac003Bean.mac003Srch.errorDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldErrorDtTo','cldErrorDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldErrorDtTo','cldErrorDtFrom');"
											   label="#{jspMsg['column.header.errorDtTo']}">
											   
											</rich:calendar>
										</td>
										<td align="right" width="20%">
											<h:outputText value="Error Description :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtErrorDesc" value="#{semmac003Bean.mac003Srch.errorDesc}" size="30" maxlength="255"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%" valign="baseline">
											<h:outputText value="Status :" styleClass="ms7" />
										</td>
										<td width="30%" valign="bottom">
											<h:selectOneMenu id="ddlErrorStatus" value="#{semmac003Bean.mac003Srch.errorStatus}">
												<f:selectItems value="#{semmac003Bean.errorStatusList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="Remark :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtRemark" value="#{semmac003Bean.mac003Srch.remark}" size="30" maxlength="255"/>
										</td>
									</tr>
								</table>
							</h:panelGroup>
							
							<h:panelGrid columns="3" id="grdSearchCommand">
								<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmError,pnlSearchResult" >
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC003-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC003" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />							
								</a4j:commandButton>
								<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSearchCriteria">
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC003-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC003" />
									<a4j:actionparam name="methodWithNavi" value="doClearSession" />							
								</a4j:commandButton>
							</h:panelGrid>
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
			<!-- end content layout criteria -->
			
			<a4j:form id="frmSearchResult">				
				<!-- begin content button-->
				<%--h:panelGrid id="grdAddNewCommand" columns="6"></h:panelGrid--%>
				<table border="0" width="96%">
					<tr>
						<td align="left">
							<a4j:commandButton id="btnUpdateStatus" value="Update Status" styleClass="rich-button" disabled="#{semmac003Bean.disableBtnUpdateStatus}"
							 oncomplete="#{rich:component('popupSapErrorLog')}.show(); return false"
							 rendered="#{semmac003Bean.renderer['btnUpdateStatus']}" 
							 >
								
							</a4j:commandButton>
						</td>
						<td align="right">
							<a4j:commandButton id="btnLoadResponse" value="Refresh File SAP" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmError"
									rendered="#{semmac003Bean.renderer['btnLoadResponse']}">
									<a4j:actionparam name="navModule" value="ac" />
									<a4j:actionparam name="navProgram" value="SEMMAC003-1" />
									<a4j:actionparam name="moduleWithNavi" value="ac" />
									<a4j:actionparam name="actionWithNavi" value="SEMMAC003" />
									<a4j:actionparam name="methodWithNavi" value="doRefreshSAP" />							
								</a4j:commandButton>
						</td>
					</tr>
				</table>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="Table Result" style="width: 100%"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmac003Bean.msgDataNotFound}" rendered="#{semmac003Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac003Bean.renderedMsgFormMiddle}"/>
						</div>
						<rich:dataTable width="100%" id="dtbMac003Srch" cellpadding="1" cellspacing="0" border="0"
							var="mac003SrchSP" value="#{semmac003Bean.mac003SrchList}" reRender="dstMac003Srch" 
							rows="#{semmac003Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur" >
							
							<a4j:support event="onRowClick" action="#{semmac003Action.getRowIdOnClick}" reRender="dtbMac003Srch">
								<a4j:actionparam name="rowId" value="#{mac003SrchSP.dataObj.rowId}" />
							</a4j:support>
							
							<rich:column styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmac003Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmac003Action.selectAllRow}" reRender="dtbMac003Srch,btnUpdateStatus"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mac003SrchSP.checkBox}" >
										<a4j:support event="onclick" action="#{semmac003Action.onRenderButton}" reRender="dtbMac003Srch,btnUpdateStatus">
											<a4j:actionparam name="rowId" value="#{mac003SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column sortBy="#{mac003SrchSP.dataObj.company}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Compamy" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.company}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mac003SrchSP.dataObj.errorDt}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Interface Date" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.errorDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.transPaymentId}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Reference SEM"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.transPaymentId}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.paymentDocNo}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentDocNo']}"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.paymentDocNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.transAmt}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Amount" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.transAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.doc68}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}"   styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.doc68}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.doc92}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.doc92}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.errorStatusDesc}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Status" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.errorStatusDesc}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.errorDesc}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Error Description" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.errorDesc}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.remark}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Remark" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.fileName}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="SAP FileName" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.fileName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.updateBy}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.updateBy}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mac003SrchSP.dataObj.updateDt}" styleClass="#{(semmac003Bean.tmpRowId==mac003SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Update Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mac003SrchSP.dataObj.updateDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmac003Bean.mac003SrchList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="11">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMac003Srch"
											maxPages="#{semmac003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstMac003Srch" 
											style="background-color: #cccccc;"
											page="#{semmac003Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>	
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>	
			<jsp:include page="../../pages/ac/semmac003-popup.jsp" />		
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

