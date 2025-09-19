<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt007" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchClearReceipt">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			 <a4j:form id="frmError">
			 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt007Bean.renderedMsgFormSearch}">
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
                                    rendered="#{semmrt007Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
                              <a4j:actionparam name="navModule" value="rt" />
                              <a4j:actionparam name="navProgram" value="SEMMRT007-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="rt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                      
                          </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
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
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="25%" valign="baseline" colspan="2">
											<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="30%" valign="bottom" >
											<h:selectOneMenu id="ddlCompany" value="#{semmrt007Bean.criteria.company}" onchange="GetCompanyJS();">
												<f:selectItems value="#{semmrt007Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmrt007Bean.criteria.company}" styleClass="ms28"/>
					                	</td>
					                	<td width="17%" align="right">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
											</h:panelGroup>
										</td>
										<td width="5%" valign="baseline">
											<h:selectOneMenu id="ddlRegion" value="#{semmrt007Bean.criteria.region}">
												<f:selectItems value="#{semmrt007Bean.regionList}"/>
											</h:selectOneMenu>
										</td>
										<td width="15%" align="right">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.reqtype']}" styleClass="ms7" rendered="false"/>
											<h:outputText value="#{jspMsg['label.jobType']}" styleClass="ms7"/>
										</td>
										<td width="5%">
											<h:selectOneMenu id="ddlJobType" value="#{semmrt007Bean.criteria.reqType}">
												<f:selectItems value="#{semmrt007Bean.jobTypeList}"/>
											</h:selectOneMenu>
										</td>
				                	</tr>
				                	<tr>
										<td align="right" width="25%" colspan="2">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
										</td><td width="15%">
											<h:inputText value="#{semmrt007Bean.criteria.batchNo}"></h:inputText>
										</td><td width="15%" align="right">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.doc92']}" styleClass="ms7"/>
										</td><td width="5%">
											<h:inputText value="#{semmrt007Bean.criteria.doc92}" style="width: 100px" size="20"/>
										</td><td width="20%" align="right">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.doc68']}" styleClass="ms7"/>
										</td><td width="20%">
											<h:inputText value="#{semmrt007Bean.criteria.doc68}" />
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.locationId']} :" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtLocationId" value="#{semmrt007Bean.criteria.locationId}"></h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.locationCode']} :" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtLocationCode" value="#{semmrt007Bean.criteria.locationCode}"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteCode']} :" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtSiteCode" value="#{semmrt007Bean.criteria.siteCode}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtContractNo" value="#{semmrt007Bean.criteria.contractNo}"></h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.periodNo']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText value="#{semmrt007Bean.criteria.periodNo}" style="width: 50px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtSiteName" value="#{semmrt007Bean.criteria.siteName}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="Module :" styleClass="ms7"/>
											</h:panelGroup>
										</td><td>
											<h:selectOneMenu id="ddlModuleType" value="#{semmrt007Bean.criteria.moduleType}" onchange="GetExpenseType();">
												<f:selectItems value="#{semmrt007Bean.moduleTypeList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetExpenseType" action="#{navAction.navi}" reRender="ddlExpenseType">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
												<a4j:actionparam name="methodWithNavi" value="getDDLExpenseType" />
											</a4j:jsFunction>
										</td><td align="right">
												<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
										</td><td>
											<h:selectOneMenu id="ddlExpenseType" value="#{semmrt007Bean.criteria.expenseType}">
												<f:selectItems value="#{semmrt007Bean.expenseTypeList}"/>
											</h:selectOneMenu>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.dueDt']}" styleClass="ms7"/>
										</td><td>
											<rich:calendar id="cldDueDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt007Bean.criteria.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="10" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDateFrom','cldDueDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDateFrom','cldDueDateTo');"
											   label="#{jspMsg['column.header.inDtFrom']}">
										</rich:calendar>
									    <rich:spacer width="5"/>
									 	<h:outputText value="#{jspMsg['label.dueDtTo']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldDueDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt007Bean.criteria.dueDtTo}"
											   showWeeksBar="false" 
											   inputSize="10" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDateTo','cldDueDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDateTo','cldDueDateFrom');"
											   label="#{jspMsg['column.header.inDtTo']}">
										</rich:calendar>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:panelGroup>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
											</h:panelGroup>
										</td>
										<td>
											<h:selectOneMenu id="ddlPaymentType" value="#{semmrt007Bean.criteria.paymentType}">
												<f:selectItems value="#{semmrt007Bean.paymentTypeList}"/>
											</h:selectOneMenu>
										</td><td align="right">
												<h:outputText value="#{jspMsg['label.chqNo']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtChqNo" value="#{semmrt007Bean.criteria.chqNo}"></h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.amt']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtAmt" value="#{semmrt007Bean.criteria.amtStr}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.receiptType']}" styleClass="ms7"/>
											</h:panelGroup>
										</td>
										<td colspan="2">
											<h:selectOneRadio id="rbtPayPeriodType" styleClass="ms7" 
		                						value="#{semmrt007Bean.criteria.receiptType}">
												<f:selectItem itemValue="ALL" itemLabel="#{jspMsg['label.receiptType1']}" />
									            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.receiptType2']}" />
									            <f:selectItem itemValue="01,02" itemLabel="#{jspMsg['label.receiptType3']}" />
											</h:selectOneRadio>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.receiptNo']} :" styleClass="ms7" />
										</td>
										<td >
											<h:inputText id="txtReceiptNo" value="#{semmrt007Bean.criteria.receiptNo}"></h:inputText>
										</td>
										<td>
											<h:selectBooleanCheckbox id="txtLocalGovt" value="#{semmrt007Bean.criteria.localGovt}" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.local']}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:outputText value="Vendor/Payee Name :" styleClass="ms7"></h:outputText>
										</td>
										<td align="left" >
											<h:inputText id="txtLessorName" value="#{semmrt007Bean.criteria.lessorName}" style="width: 250px"/>
										</td>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.contactName']}" styleClass="ms7"></h:outputText>
										</td>
										<td align="left">
											<h:inputText id="txtContactName" value="#{semmrt007Bean.criteria.contractName}" style="width: 250px"/>
										</td>
										<td align="right">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.clrReceiptStatus']}" styleClass="ms7"></h:outputText>
										</td>
										<td>
											<h:selectOneMenu id="ddlClrReceiptStatus" value="#{semmrt007Bean.criteria.clrReceiptStatus}">
												<f:selectItems value="#{semmrt007Bean.clrReceiptStatusList2}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7u" />
											<rich:spacer width="20"></rich:spacer>
											<h:outputText value="#{jspMsg['label.lessorHouseNo']}" styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputText id="txtLessorHouseNo" value="#{semmrt007Bean.criteria.lessorHouseNo}" style="width: 250px"></h:inputText>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.lessorProvince']}" styleClass="ms7"></h:outputText>
										</td><td>
											<h:selectOneMenu id="ddlLessorProvince" value="#{semmrt007Bean.criteria.province}">
												<f:selectItems value="#{semmrt007Bean.provinceList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.taxId']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText value="#{semmrt007Bean.criteria.taxId}"></h:inputText>
										</td>
										<td align="right">
											
										</td>
										<td align="right">
											<h:selectBooleanCheckbox id="chkDeposit" value="#{semmrt007Bean.criteria.depositFlag}" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText id="lblDeposit" value="#{jspMsg['label.depositFlag']}" styleClass="ms7"/>
										</td>
										<td align="right">
											<h:selectBooleanCheckbox id="txtExportStatus" value="#{semmrt007Bean.criteria.exportStatusFlag}" />
										</td>
										<td align="left">
											<h:outputText id="lblLimitLost" value="#{jspMsg['label.exportStatus']}" styleClass="ms7"/>
										</td>
										
										
									</tr>
									<tr>
										
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText value="#{semmrt007Bean.criteria.createBy}"></h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.smClearDate']}" styleClass="ms7"/>
										</td><td>
											<rich:calendar id="cldSmClearDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt007Bean.criteria.smClearFrom}"
											   showWeeksBar="false" 
											   inputSize="10" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldSmClearDateFrom','cldSmClearDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSmClearDateFrom','cldSmClearDateTo');"
											   label="#{jspMsg['column.header.inDtFrom']}">
										</rich:calendar>
									    <rich:spacer width="5"/>
									 	<h:outputText value="#{jspMsg['label.smClearDateTo']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldSmClearDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt007Bean.criteria.smClearTo}"
											   showWeeksBar="false" 
											   inputSize="10" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldSmClearDateTo','cldSmClearDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSmClearDateTo','cldSmClearDateFrom');"
											   label="#{jspMsg['column.header.inDtTo']}">
										</rich:calendar>
										</td>
										<td align="right">
											
										</td>
										<td align="left">
											
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchClearReceipt,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,dtbClearReceipt">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="pnlSearchClearReceipt,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			
			<a4j:form id="frmResult">
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt007Bean.renderedMsgFormMiddle}"/>
				</div>
				
				<h:panelGrid id="grdActionCommand" width="90%">
					<h:panelGroup>
						<table width="100%">
							<tr><td width="50%">
								<h:commandButton id ="btnExport" value="Export" action="#{semmrt007Action.doExportExcel}" styleClass="rich-button" 
								disabled="#{semmrt007Bean.disBtnExport}" 
								rendered="#{semmrt007Bean.renderer['btnExport'] or semmrt007Bean.renderedOnToDoList}">
									<a4j:support event="onclick" action="#{navAction.navi}" 
									reRender="frmError,frmResult,pnlSearchResult,grdActionCommand" >
									</a4j:support>
								</h:commandButton>
								
								<rich:spacer width="5"/>
								
								<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clrbatch']}" styleClass="rich-button"
								style="width:80px;" action="#{navAction.navi}" reRender="frmError,frmResult,pnlSearchResult,grdActionCommand"
								disabled="#{semmrt007Bean.disBtnExport}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="doUpdateClearBatch" />
								</a4j:commandButton>
								
								<rich:spacer width="5"/>
								
								<a4j:commandButton id="btnExportLetterId" value="Export Letter" styleClass="rich-button" 
			            		disabled="#{semmrt007Bean.disBtnExport}"
                                action="#{navAction.navi}" reRender="frmError,frmResult,pnlShowReportEpt,grdActionCommand"
                                style=" width : 97px;">
	                                  <a4j:actionparam name="navModule" value="rt" />
	                                  <a4j:actionparam name="navProgram" value="SEMMRT007-1" />
	                                  <a4j:actionparam name="moduleWithNavi" value="rt" />
	                                  <a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
	                                  <a4j:actionparam name="methodWithNavi" value="doExportLetter" />
                                </a4j:commandButton>
                                
								<rich:spacer width="5"/>
								
								<a4j:commandButton id="btnSMS" value="#{jspMsg['btn.sms']}" styleClass="rich-button"
								style="width:80px" action="#{navAction.navi}" reRender="frmError,frmResult,pnlSearchResult,grdActionCommand"
								disabled="#{semmrt007Bean.disBtn}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="doSendSMS" />
								</a4j:commandButton>
								
								<rich:spacer width="5"/>
								
								<a4j:commandButton id="btnEMAIL" value="#{jspMsg['btn.email']}" styleClass="rich-button"
								style="width:85px;" action="#{navAction.navi}" reRender="frmError,frmResult,pnlSearchResult,grdActionCommand"
								disabled="#{semmrt007Bean.disBtn}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="doSendEmail" />
								</a4j:commandButton>
								
								<rich:spacer width="20"/>
								
								
								<a4j:commandButton id="btnExportData" value="#{jspMsg['btn.exportdata']}" styleClass="rich-button" 
			            		disabled="#{semmrt007Bean.disBtnExport}"
                                action="#{navAction.navi}" reRender="frmError,frmResult,pnlShowReportData,grdActionCommand"
                                style=" width : 97px;">
	                                  <a4j:actionparam name="navModule" value="rt" />
	                                  <a4j:actionparam name="navProgram" value="SEMMRT007-1" />
	                                  <a4j:actionparam name="moduleWithNavi" value="rt" />
	                                  <a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
	                                  <a4j:actionparam name="methodWithNavi" value="doExportData" />
                                </a4j:commandButton>
                            
								
								<rich:spacer width="20"/>
								
								<a4j:commandButton id="btnNotClearReceipt" value="#{jspMsg['btn.notClr']}" styleClass="rich-button"
								style="width:105px;" action="#{navAction.navi}" reRender="frmError,frmResult,pnlSearchResult,grdActionCommand"
								oncomplete="#{rich:component('popupFrmNotClearReceipt')}.show(); return false"
								disabled="#{semmrt007Bean.disabledBtnNotClr}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateClearRecriptStatus" />
									<a4j:actionparam name="clearReciptFlag" value="Y" />
								</a4j:commandButton>
								
								<rich:spacer width="5"/>
								
								<a4j:commandButton id="btnClearReceipt" value="#{jspMsg['btn.clr']}" styleClass="rich-button"
								style="width:80px;" action="#{navAction.navi}" reRender="frmError,frmResult,pnlSearchResult,grdActionCommand"
								disabled="#{semmrt007Bean.disabledBtnClr}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="doUpdateClearReceiptStatus" />
									<a4j:actionparam name="clearReciptFlag" value="N" />
								</a4j:commandButton>
							</td><td width="50%"><div align="right">
								<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.smClear']}" styleClass="rich-button" 
								disabled="#{semmrt007Bean.disabledBtnOth}"
								action="#{navAction.navi}" reRender="pnlSearchClearReceipt,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,dtbClearReceipt,frmResult"
								rendered="#{semmrt007Bean.rendererSSO['btnSMBCR001']}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="doSMClear" />
									
								</a4j:commandButton>
								<rich:spacer width="5" />
								<a4j:commandButton id="btnFnClr" value="#{jspMsg['btn.fnClear']}" 
									oncomplete="if(#{semmrt007Bean.popupOpen == 'true'})#{rich:component('popupFrmSaveClrRecStatus')}.show(); return false" 
									reRender="popupFrmSaveClrRecStatus,pnlSearchClearReceipt" action="#{navAction.navi}" 
									disabled="#{semmrt007Bean.disabledBtnOth}" 
									styleClass="rich-button" 
									rendered="#{semmrt007Bean.rendererSSO['btnSMBCR003']}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSaveClrRecStatus" />
									<a4j:actionparam name="mode" value="1" />
									<a4j:actionparam name="msg" value="Clear" />
									<a4j:actionparam name="status" value="03" />
								</a4j:commandButton>
								<rich:spacer width="5"/>
								<a4j:commandButton id="btnFnRej" value="#{jspMsg['btn.fnReject']}" 
									oncomplete="if(#{semmrt007Bean.popupOpen == 'true'})#{rich:component('popupFrmSaveClrRecStatus')}.show(); return false" 
									reRender="popupFrmSaveClrRecStatus,pnlSearchClearReceipt" action="#{navAction.navi}" 
									disabled="#{semmrt007Bean.disabledBtnOth}" 
									styleClass="rich-button" 
									rendered="#{semmrt007Bean.rendererSSO['btnSMBCR003']}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSaveClrRecStatus" />
									<a4j:actionparam name="mode" value="2" />
									<a4j:actionparam name="msg" value="Reject" />
									<a4j:actionparam name="status" value="04" />
								</a4j:commandButton>
								<rich:spacer width="5"/>
								<a4j:commandButton id="btnAcClr" value="#{jspMsg['btn.acClear']}" 
									oncomplete="if(#{semmrt007Bean.popupOpen == 'true'})#{rich:component('popupFrmSaveClrRecStatus')}.show(); return false" 
									reRender="popupFrmSaveClrRecStatus,pnlSearchClearReceipt" action="#{navAction.navi}" 
									disabled="#{semmrt007Bean.disabledBtnOth}" 
									styleClass="rich-button" 
									rendered="#{semmrt007Bean.rendererSSO['btnSMBCR002']}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSaveClrRecStatus" />
									<a4j:actionparam name="mode" value="3" />
									<a4j:actionparam name="msg" value="Clear" />
									<a4j:actionparam name="status" value="05" />
								</a4j:commandButton>
								<rich:spacer width="5"/>
								<a4j:commandButton id="btnAcRej" value="#{jspMsg['btn.acReject']}" 
									oncomplete="if(#{semmrt007Bean.popupOpen == 'true'})#{rich:component('popupFrmSaveClrRecStatus')}.show(); return false" 
									reRender="popupFrmSaveClrRecStatus,pnlSearchClearReceipt" action="#{navAction.navi}" 
									disabled="#{semmrt007Bean.disabledBtnOth}" 
									styleClass="rich-button" 
									rendered="#{semmrt007Bean.rendererSSO['btnSMBCR002']}">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSaveClrRecStatus" />
									<a4j:actionparam name="mode" value="4" />
									<a4j:actionparam name="msg" value="Reject" />
									<a4j:actionparam name="status" value="06" />
								</a4j:commandButton>
							</div></td></tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				<!-- end content button -->
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 5100"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt007Bean.msgDataNotFound}" rendered="#{semmrt007Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbClearReceipt" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="clrReceipt"  value="#{semmrt007Bean.resultList}" reRender="dtbClearReceipt" 
							rows="#{semmrt007Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmrt007Action.getRowIdOnClick}" reRender="dtbClearReceipt">
								<a4j:actionparam name="rowId" value="#{clrReceipt.dataObj.rowId}" />
							</a4j:support>
							<!-- begin column -->
							<rich:column styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmrt007Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmrt007Action.selectAllRow}" 
											reRender="btnExport,grdActionCommand,dtbClearReceipt"/>
										<a4j:actionparam name="company" value="#{clrReceipt.dataObj.company}" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="clrReceiptSelected" value="#{clrReceipt.checkBox}" 
									rendered="#{clrReceipt.dataObj.rentalClrRecId != null}">
										<a4j:support event="onclick" action="#{semmrt007Action.onRenderButton}" reRender="btnExport,grdActionCommand,dtbClearReceipt">
											<a4j:actionparam name="rowId" value="#{clrReceipt.dataObj.rowId}" />
											<a4j:actionparam name="company" value="#{clrReceipt.dataObj.company}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmrt007Bean.renderer['btnEdit'] or semmrt007Bean.renderedOnToDoList}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Edit" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
									action="#{navAction.navi}" title="edit" id="btnEdit" 
									oncomplete="#{rich:component('popupFrmSaveClrRec')}.show(); return false" 
									reRender="popupFrmSaveClrRec" 
									rendered="#{clrReceipt.dataObj.clrReceiptStatus == '01' || clrReceipt.dataObj.clrReceiptStatus == '02' || clrReceipt.dataObj.clrReceiptStatus == '04' || clrReceipt.dataObj.clrReceiptStatus == '06'}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
										<a4j:actionparam name="methodWithNavi" value="initPopupSaveClrRec" />
										<a4j:actionparam name="rowId" value="#{clrReceipt.dataObj.rowId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							
							
		
							<%-- <rich:column sortBy="#{clrReceipt.dataObj.donateFlag}"  
                                styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
                                title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
                                <f:facet name="header">
                                    <h:outputText value="expenseType" style="width: 72"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{clrReceipt.dataObj.expenseType}">
                                    </h:outputText>
                                </div>
                            </rich:column> --%>
							<rich:column sortBy="#{clrReceipt.dataObj.donateFlag}"  
                                styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
                                title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.donateFlag']}" style="width: 72"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{clrReceipt.dataObj.donateFlag}">
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
							<rich:column sortBy="#{clrReceipt.dataObj.doc92}"  
                                styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
                                title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.doc92New']}" style="width: 72"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{clrReceipt.dataObj.doc92}">
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column sortBy="#{clrReceipt.dataObj.doc68}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc684New']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.doc68}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.contractNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" style="width: 60"/>
								</f:facet>
								<div align="center">
										<a4j:commandLink id="hypView" value="#{clrReceipt.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{clrReceipt.dataObj.siteInfoId}" />
										</a4j:commandLink>
										
									<!--<h:outputText value="#{clrReceipt.dataObj.contractNo}" />-->
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.oldContractNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContractNo']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.oldContractNo}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.siteName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" style="width: 180"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.siteName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.vendorCode}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.vendorCode}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.vendorName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.vendorName}" />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.periodStartDt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dueDt']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.periodStartDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.period}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.period']}" style="width: 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.period}">
									</h:outputText>
								</div>
							</rich:column>
							 
							<rich:column sortBy="#{clrReceipt.dataObj.payWhtTypeName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payWhtTypeName']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.payWhtTypeName}" />
								</div>
							</rich:column> 
							<rich:column sortBy="#{clrReceipt.dataObj.periodAmt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.amt']}" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.periodAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.payPeriodType}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodType']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.payPeriodType}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.payVatTypeName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payVatTypeName']}" style="width: 40"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.vatAmount}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							
							<rich:column sortBy="#{clrReceipt.dataObj.whtAmt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payWhtAmt']}" style="width: 40"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.whtAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.intAmount}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.intAmt']}" style="width: 40"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.intAmount}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.netAmout}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.netAmt']}" style="width: 40"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.netAmout}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.chqNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqNo']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.chqNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.chqDt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.chqDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.chqClearingStatus}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clrChqStatus']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.chqClearingStatus}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.transferDt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.transferDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.receiptNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.receiptNo']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.receiptNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.taxInvoiceNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxInvoiceNo']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.taxInvoiceNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.taxInvoiceDt}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxInvoiceDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.taxInvoiceDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.remark}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.remark}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.clrReceiptStatusName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clrReceiptStatusName']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.clrReceiptStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.clrRejectReason}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clrRejectReason']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.clrRejectReason}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.remainCount}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remainCount']}"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.remainCount}">
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.emailFlag}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.emailFlag']}" style="width: 100"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.emailFlag}"></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.smsFlag}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.smsFlag']}" style="width: 100"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{clrReceipt.dataObj.smsFlag}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{clrReceipt.dataObj.batchNo}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.batchNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.receiptStatusName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.receiptStatusName']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.receiptStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.periodNoStart}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.period']}"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.periodNoStart}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.reqType}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqtype']}" style="width: 170px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.reqType}">
									</h:outputText>
								</div>
							</rich:column> 
							<rich:column sortBy="#{clrReceipt.dataObj.contractName}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contactname']}" style="width: 250px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.contractName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.siteAddr}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteAddr']}" style="width: 250px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.siteAddr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.vendorAddr}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorAddr']}" style="width: 250px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{clrReceipt.dataObj.vendorAddr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.vendorTel}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorTel']}" style="width: 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.vendorTel}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.vendorEmail}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorEmail']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.vendorEmail}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{clrReceipt.dataObj.createBy}" 
								styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Create By" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{clrReceipt.dataObj.createBy}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
							rendered="#{semmrt007Bean.renderer['btnEdit'] or semmrt007Bean.renderedOnToDoList}" 
							title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton value="Update Doc" style="width: 90;" 
									action="#{navAction.navi}" title="updateDoc" id="btnUpdateDoc" 
									reRender="popupFrmUpdateDoc" 
									oncomplete="#{rich:component('popupFrmUpdateDoc')}.show(); return false" 
									styleClass="rich-button"
									rendered="#{clrReceipt.dataObj.clrReceiptStatus == '01' || clrReceipt.dataObj.clrReceiptStatus == '02' || clrReceipt.dataObj.clrReceiptStatus == '04' || clrReceipt.dataObj.clrReceiptStatus == '06'}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT007-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT007" />
										<a4j:actionparam name="methodWithNavi" value="initPopupUpdateDoc" />
										<a4j:actionparam name="rowId" value="#{clrReceipt.dataObj.rowId}"/>
										<a4j:actionparam name="transPaymentId" value="#{clrReceipt.dataObj.transPaymentId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt007Bean.tmpRowId==clrReceipt.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{clrReceipt.dataObj.contractNo} #{clrReceipt.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" style="width: 50px"/>
								</f:facet>
					        	<div align="left">
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
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value="CR"/>
										<a4j:actionparam name="contractNo" value="#{clrReceipt.dataObj.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
					        	</div>
					        </rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt007Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="39">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbClearReceipt"
											maxPages="#{semmrt007Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstClearReceipt" 
											style="background-color: #cccccc;"
											page="#{semmrt007Bean.scrollerPage}" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
				<h:panelGrid id="pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
					    <h:panelGroup id="pnlInShowReportEpt" rendered="#{semmrt007Bean.displayReportFlag}" style="height:0px;width:0px;" >
					        <h:commandButton value="Report" id="bthShowReportEpt" style="height:0px;width:0px;display:none;" action="#{semmrt007Action.doExportExcelLetter}"  />                              
					        <script>document.getElementById('incContent:frmResult:bthShowReportEpt').click();</script>
					    </h:panelGroup>                         
					</h:panelGrid>
					
				<h:panelGrid id="pnlShowReportData" style="height:0px;width:0px;" width="0px" columns="0" >
					    <h:panelGroup id="pnlInShowReportData" rendered="#{semmrt007Bean.displayReportDataFlag}" style="height:0px;width:0px;" >
					        <h:commandButton value="Report" id="bthShowReportData" style="height:0px;width:0px;display:none;" action="#{semmrt007Action.doExportExcelData}"  />                              
					        <script>document.getElementById('incContent:frmResult:bthShowReportData').click();</script>
					    </h:panelGroup>                         
				</h:panelGrid>
			</a4j:form>
		</h:panelGrid>
		<jsp:include page="../../pages/rt/semmrt007-popup.jsp" />
	</rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
