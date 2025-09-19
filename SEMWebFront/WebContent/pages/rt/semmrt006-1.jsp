<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchReturnDeposit">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												rendered="#{semmrt006Bean.renderedMsgFormSearch}">
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
                        <a4j:commandButton id="mrt006_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmrt006Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
                              <a4j:actionparam name="navModule" value="rt" />
                              <a4j:actionparam name="navProgram" value="SEMMRT006-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="rt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
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
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="80%" colspan="3" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmrt006Bean.criteria.company}" onchange="GetCompanyJS();">
												<f:selectItems value="#{semmrt006Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmrt006Bean.criteria.company}" styleClass="ms28"/>
					                	</td>
				                	</tr>
				                	<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText value="#{semmrt006Bean.criteria.contractNo}"></h:inputText>
										</td><td align="right" width="15%">
												<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td><td width="35%">
											<h:inputText value="#{semmrt006Bean.criteria.siteName}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlRegion" value="#{semmrt006Bean.criteria.region}">
												<f:selectItems value="#{semmrt006Bean.regionList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
										</td><td width="35%">
											<h:selectOneMenu id="ddlSiteType" value="#{semmrt006Bean.criteria.siteType}">
												<f:selectItems value="#{semmrt006Bean.siteTypeList}"/>
											</h:selectOneMenu>
											<rich:spacer width="10"/>
											<h:selectBooleanCheckbox id="picoSelect" value="#{semmrt006Bean.criteria.chkPico}"/>
											<rich:spacer width="5"/>
											<h:outputText value="PICO" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right">
												<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7"/>
										</td><td>
											<h:selectOneMenu id="ddlDepositType" value="#{semmrt006Bean.criteria.depositType}">
												<a4j:support event="onchange" action="#{semmrt006Action.onChangeDdlDepositType}" 
													reRender="ddlReturnDpsStatus"></a4j:support>
												<f:selectItems value="#{semmrt006Bean.depositTypeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.bgEndFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
									    <rich:calendar id="cldInDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt006Bean.criteria.bgExpireFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldInDateFrom','cldInDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldInDateFrom','cldInDateTo');"
											   label="#{jspMsg['column.header.inDtFrom']}">
											   
										</rich:calendar>
									    <rich:spacer width="5"/>
									 	<h:outputText value="#{jspMsg['label.bgEndTo']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldInDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt006Bean.criteria.bgExpireTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldInDateTo','cldInDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldInDateTo','cldInDateFrom');"
											   label="#{jspMsg['column.header.inDtTo']}">
											   
										</rich:calendar>
									</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtBgNo" value="#{semmrt006Bean.criteria.bgNo}"></h:inputText>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.bgBank']}" styleClass="ms7" />
										</td><td>
											<h:selectOneMenu id="ddlBgBank" value="#{semmrt006Bean.criteria.bgBank}">
												<f:selectItems value="#{semmrt006Bean.bgBankList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
												<h:outputText value="#{jspMsg['label.acceptType']}" styleClass="ms7"/>
										</td><td>
											<h:selectOneMenu id="ddlReqType" value="#{semmrt006Bean.criteria.reqType}">
												<f:selectItems value="#{semmrt006Bean.reqTypeList}"/>
											</h:selectOneMenu>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"></h:outputText>
										</td><td>
											<h:selectOneMenu id="ddlExpenseType" value="#{semmrt006Bean.criteria.expenseType}">
												<f:selectItems value="#{semmrt006Bean.expenseTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.returnDpsStatus']}" styleClass="ms7"></h:outputText>
										</td>
										<td align="left" colspan="3">
											<h:selectOneMenu id="ddlReturnDpsStatus" value="#{semmrt006Bean.criteria.returnDepositStatus}">
												<f:selectItems value="#{semmrt006Bean.returnDpsStatus2List}"/>
											</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchReturnDeposit,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,dtbReturnDeposit">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbReturnDeposit">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			
			<a4j:form id="frmResult">
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 3250"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt006Bean.msgDataNotFound}" rendered="#{semmrt006Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbReturnDeposit" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="returnDpst"  value="#{semmrt006Bean.resultList}" reRender="dtbReturnDeposit" 
							rows="#{semmrt006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmrt006Action.getRowIdOnClick}" reRender="dtbReturnDeposit">
								<a4j:actionparam name="rowId" value="#{returnDpst.rowId}" />
							</a4j:support>
							<!-- begin column -->
							<rich:column styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								rendered="#{semmrt006Bean.renderer['hlkReSm']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.sm']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.link.returnSave']}" 
										action="#{navAction.navi}" id="hypReSm" 
										oncomplete="#{rich:component('popupFrmSaveReDpst')}.show(); return false" 
										reRender="popupFrmSaveReDpst"
										rendered="#{semmrt006Bean.rendererSSO['btnSMBCD001']}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="role" value="SM" />
										<a4j:actionparam name="rowId" value="#{returnDpst.rowId}" />
										<a4j:actionparam name="expenseType" value="#{returnDpst.expenseType}" />
										<a4j:actionparam name="company" value="#{returnDpst.company}" />
										<a4j:actionparam name="returnDepositId" value="#{returnDpst.returnDepositId}" />
										<a4j:actionparam name="depositDetailId" value="#{returnDpst.depositDetailId}" />
										<a4j:actionparam name="siteInfoId" value="#{returnDpst.siteInfoId}" />
										<a4j:actionparam name="contractNo" value="#{returnDpst.contractNo}" />
										<a4j:actionparam name="depositType" value="#{returnDpst.depositType}" />
										<a4j:actionparam name="depositAmt" value="#{returnDpst.depositAmt}" />
										<a4j:actionparam name="depositRentAmt" value="#{returnDpst.depositRentAmt}" />
										<a4j:actionparam name="depositBalanceAmt" value="#{returnDpst.depositBalanceAmt}" />
										<a4j:actionparam name="depositReturnAmt" value="#{returnDpst.depositReturnAmt}" />
										<a4j:actionparam name="returnDepositStatus" value="#{returnDpst.returnDepositStatus}" />
										
										<a4j:actionparam name="bgNo" value="#{returnDpst.bgNo}" />
										<a4j:actionparam name="bgBank" value="#{returnDpst.bgBankName}" />
										<a4j:actionparam name="bgStartDt" value="#{returnDpst.bgStartDtStr}" />
										<a4j:actionparam name="bgEndDt" value="#{returnDpst.bgEndDtStr}" />
										
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								rendered="#{semmrt006Bean.renderer['hlkReFn']}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.fn']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.link.returnSave']}" 
										action="#{navAction.navi}" id="hypReFn" 
										oncomplete="#{rich:component('popupFrmSaveReDpst')}.show(); return false" 
										rendered="#{semmrt006Bean.rendererSSO['btnSMBCD003'] && returnDpst.returnDepositId != null && returnDpst.depositType == '01' && returnDpst.returnDepositStatus != '01' && returnDpst.returnDepositStatus != '02'}" 
										reRender="popupFrmSaveReDpst">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="role" value="FN" />
										<a4j:actionparam name="rowId" value="#{returnDpst.rowId}" />
										<a4j:actionparam name="company" value="#{returnDpst.company}" />
										<a4j:actionparam name="returnDepositId" value="#{returnDpst.returnDepositId}" />
										<a4j:actionparam name="depositDetailId" value="#{returnDpst.depositDetailId}" />
										<a4j:actionparam name="siteInfoId" value="#{returnDpst.siteInfoId}" />
										<a4j:actionparam name="contractNo" value="#{returnDpst.contractNo}" />
										<a4j:actionparam name="depositType" value="#{returnDpst.depositType}" />
										<a4j:actionparam name="depositAmt" value="#{returnDpst.depositAmt}" />
										<a4j:actionparam name="depositRentAmt" value="#{returnDpst.depositRentAmt}" />
										<a4j:actionparam name="depositBalanceAmt" value="#{returnDpst.depositBalanceAmt}" />
										<a4j:actionparam name="depositReturnAmt" value="#{returnDpst.depositReturnAmt}" />
										<a4j:actionparam name="returnDepositStatus" value="#{returnDpst.returnDepositStatus}" />
										
										<a4j:actionparam name="bgNo" value="#{returnDpst.bgNo}" />
										<a4j:actionparam name="bgBank" value="#{returnDpst.bgBankName}" />
										<a4j:actionparam name="bgStartDt" value="#{returnDpst.bgStartDtStr}" />
										<a4j:actionparam name="bgEndDt" value="#{returnDpst.bgEndDtStr}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								rendered="#{semmrt006Bean.renderer['hlkReAc']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.ac']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.link.returnSave']}" 
										action="#{navAction.navi}" id="hypReAc" 
										oncomplete="#{rich:component('popupFrmSaveReDpst')}.show(); return false" 
										rendered="#{semmrt006Bean.rendererSSO['btnSMBCD002'] && returnDpst.returnDepositId != null && returnDpst.depositType == '02' && returnDpst.returnDepositStatus != '01' && returnDpst.returnDepositStatus != '02'}" 
										reRender="popupFrmSaveReDpst">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="role" value="AC" />
										<a4j:actionparam name="rowId" value="#{returnDpst.rowId}" />
										<a4j:actionparam name="company" value="#{returnDpst.company}" />
										<a4j:actionparam name="returnDepositId" value="#{returnDpst.returnDepositId}" />
										<a4j:actionparam name="depositDetailId" value="#{returnDpst.depositDetailId}" />
										<a4j:actionparam name="siteInfoId" value="#{returnDpst.siteInfoId}" />
										<a4j:actionparam name="contractNo" value="#{returnDpst.contractNo}" />
										<a4j:actionparam name="depositType" value="#{returnDpst.depositType}" />
										<a4j:actionparam name="depositAmt" value="#{returnDpst.depositAmt}" />
										<a4j:actionparam name="depositRentAmt" value="#{returnDpst.depositRentAmt}" />
										<a4j:actionparam name="depositBalanceAmt" value="#{returnDpst.depositBalanceAmt}" />
										<a4j:actionparam name="depositReturnAmt" value="#{returnDpst.depositReturnAmt}" />
										<a4j:actionparam name="returnDepositStatus" value="#{returnDpst.returnDepositStatus}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								rendered="#{semmrt006Bean.renderer['hlkUpload']}">
								<f:facet name="header">
									<h:outputText value="" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:panelGroup>
									<a4j:commandLink value="#{jspMsg['column.link.upload']}" 
										action="#{navAction.navi}" id="hypUpload" 
										oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" 
										reRender="oppContent,popupUploadPictureCriteria">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
										<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value="RD"/>
										<a4j:actionparam name="contractNo" value="#{returnDpst.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandLink>
									</h:panelGroup>
									<h:panelGroup rendered="#{returnDpst.returnDepositStatus == '04' && returnDpst.returnDepositStatus == '07'}">
									<a4j:commandLink value="#{jspMsg['column.link.upload']}" 
										action="#{navAction.navi}" id="hypDownload" 
										oncomplete="#{rich:component('popupFrmUpload')}.show(); return false"
										rendered="#{returnDpst.returnDepositId != null}" 
										reRender="popupFrmUpload">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupUpload" />
										<a4j:actionparam name="mode" value="DOWNLOAD" />
										<a4j:actionparam name="returnDepositId" value="#{returnDpst.returnDepositId}" />
									</a4j:commandLink>
									</h:panelGroup>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{returnDpst.contractNo}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.contractNo}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.siteName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" style="width: 180"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.siteName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.reqTypeName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqTypeName']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.reqTypeName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.expenseTypeName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseTypeName']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.expenseTypeName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositTypeName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositTypeName']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.depositTypeName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.bgNo}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgNo']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.bgNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.bgBankName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgBank']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.bgBankName}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{returnDpst.bgStartDtStr}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgStartDt']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.bgStartDtTh}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.bgEndDtStr}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgEndDt']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.bgEndDtTh}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.bgReturnDtTh}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bgReturnDt']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.bgReturnDtTh}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{returnDpst.vendorCode}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.vendorName}"  
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.vendorName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.amt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.depositAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.vatTypeName}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatTypeName']}" style="width: 30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.vatAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.vatAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositIncAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositIncAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.depositIncAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositRentAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositRentAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.depositRentAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositBalanceAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositBalanceAmt2']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.depositBalanceAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.depositReturnAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositReturnAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.depositReturnAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.returnBalanceAmt}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.returnBalanceAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{returnDpst.returnBalanceAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.remark}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.remark}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.returnDepositStatus}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.returnDpsStatus']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.returnDpsStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.reason}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reason']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{returnDpst.reason}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.receiptNo}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.receiptNo']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.receiptNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.taxInvoiceNo}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxInvoiceNo']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.taxInvoiceNo}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{returnDpst.siteStatus}" 
								styleClass="#{(semmrt006Bean.tmpRowId==returnDpst.rowId)?'onClick':'unClick'}" 
								title="#{returnDpst.contractNo} #{returnDpst.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{returnDpst.siteStatus}">
									</h:outputText>
								</div>
							</rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt006Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="26">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbReturnDeposit"
											maxPages="#{semmrt006Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstClearReceipt" 
											style="background-color: #cccccc;"
											page="#{semmrt006Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
		<jsp:include page="../../pages/rt/semmrt006-popup.jsp" />
	</rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>