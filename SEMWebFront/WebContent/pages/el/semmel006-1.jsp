<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchPayment">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>

		<h:panelGrid columnClasses="gridContent" width="100%">		
<!-- Search  -->
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
														
									<tr>
										<td align="right" width="25%" valign="baseline">											
						
											<c:if test="${empty semmel006Bean.criteria.contractNo}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>										
											
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="75%" colspan="3">
											<h:selectOneMenu id="ddlCompany" value="#{semmel006Bean.criteria.company}" onchange="GetCompanyJS();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="pnlSearchCriteria"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText   value="#{semmel006Bean.criteria.company}" styleClass="ms28"/>											
										</td>					
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
										<h:inputText   value="#{semmel006Bean.criteria.contractNo}"  style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText   value="#{semmel006Bean.criteria.siteName}" style="width:120px;"></h:inputText>
										</td>
									</tr>	
									
									<tr>
										<td align="right" width="25%">
											<c:if test="${empty semmel006Bean.criteria.contractNo}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>			
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu   value="#{semmel006Bean.criteria.electricUseType}"  onchange="changeElectricUseTypeJS();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.electricUseTypeList}"/>
											</h:selectOneMenu>
	
											<a4j:jsFunction name="changeElectricUseTypeJS" reRender="pnlSearchCriteria" action="#{semmel006Action.changeElectricUseType}"/>
							
											
										</td>									
										<td align="right" width="25%">
											<c:if test="${empty semmel006Bean.criteria.contractNo}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>			
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu   value="#{semmel006Bean.criteria.expenseType}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elExpenseTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>							
									
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td>
										<td>
											<h:selectOneMenu  value="#{semmel006Bean.criteria.region}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.regionList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.meterNo']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText  value="#{semmel006Bean.criteria.meterId}" style="width:120px;"></h:inputText>
										</td>
									</tr>									
									
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText   value="#{semmel006Bean.criteria.locationId}" style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText    value="#{semmel006Bean.criteria.locationCode}" style="width:120px;"></h:inputText>
										</td>
									</tr>									
									
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar  id="paymentDtFrom" showWeeksBar="false" locale="th" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.criteria.fromTermOfPaymentDt}" inputSize="18" 
				                			 oninputblur="validateRichCalendarFromTo('frmSearch','paymentDtFrom','paymentDtTo');"
											 oncollapse="validateRichCalendarFromTo('frmSearch','paymentDtFrom','paymentDtTo');"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar  id="paymentDtTo"
											showWeeksBar="false" locale="th" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.criteria.toTermOfPaymentDt}" inputSize="18" 
				                			 oninputblur="validateRichCalendarFromTo('frmSearch','paymentDtTo','paymentDtFrom');"
											 oncollapse="validateRichCalendarFromTo('frmSearch','paymentDtTo','paymentDtFrom');"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
									</tr>		

									<tr>
										<td align="right" width="25%">
											
										</td>
										<td width="25%">
											<h:selectBooleanCheckbox id="chksiteType" value="#{semmel006Bean.criteria.siteTypeBoolean}" styleClass="ms7"/>
					                		<h:outputText value="#{jspMsg['label.picoCell']}" styleClass="ms7" />										
										</td>
										<td align="right" width="25%">
											
										</td>
										<td width="25%">
											
										</td>
									</tr>	
						

																					
							</table>
							</h:panelGroup>								
							<h:panelGrid columns="4" id="grdSearchCommand">	            	
									<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
										reRender="pnlSearchPayment,frmError,frmSearch,pnlSearchCriteria,pnlSearchResult,pnlSearchResultEL_POSTPAID,pnlSearchResultEL_TEMP, nlSearchResultPR_POSTPAID, pnlSearchResultPR_PREPAID" >										
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-1" />										
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
									</a4j:commandButton>
									<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
					            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,panSearchResult,pnlSearchResultEL_POSTPAID,pnlSearchResultEL_TEMP, nlSearchResultPR_POSTPAID, pnlSearchResultPR_PREPAID">
					            		<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doClear" />
					            	</a4j:commandButton>
			
							</h:panelGrid>
						<!-- end content criteria -->
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			
			
	
			<h:panelGrid columns="7" id="grdactionButton">	    
					<a4j:commandButton id="btnELBill" value="#{jspMsg['btn.btnELBill']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"  reRender="oppContent,pnlNoPaymentSite"   style="width:150"
	            	rendered="#{semmel006Bean.renderer['btnELBill']}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentELBill" />
					</a4j:commandButton>

					<a4j:commandButton id="btnELPostpaid" value="#{jspMsg['btn.btnELPostpaid']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"  reRender="oppContent,paymentDetail,paymentConclude,payment"   style="width:150"
	            	rendered="#{semmel006Bean.renderer['btnELPostpaid']}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentELPostpaid" />
					</a4j:commandButton>
					<a4j:commandButton id="btnELTemp" value="#{jspMsg['btn.btnELTemp']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"   reRender="oppContent,paymentDetail,paymentConclude,payment"  style="width:190"
	            	rendered="#{semmel006Bean.renderer['btnELTemp']}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentELTemporary" />
					</a4j:commandButton>
					<a4j:commandButton id="btnPRPostpaid" value="#{jspMsg['btn.btnPRPostpaid']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"  reRender="oppContent,paymentDetail,payment"  style="width:150"
	            	rendered="#{semmel006Bean.renderer['btnPRPostpaid']}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentPRPostpaid" />
					</a4j:commandButton>
					<a4j:commandButton id="btnPRPrepaid" value="#{jspMsg['btn.btnPRPrepaid']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" reRender="oppContent,paymentDetail,payment"   style="width:150"
	            	rendered="#{semmel006Bean.renderer['btnPRPrepaid']}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentPRPrepaid" />
					</a4j:commandButton>
					<a4j:commandButton id="btnCredit" value="#{jspMsg['btn.btn7']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" 
	            	reRender="oppContent,paymentDetail,payment"   
	            	style="width:150"
	            	rendered="true">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPayment7" />
					</a4j:commandButton>
					<a4j:commandButton id="btnCredit_1" value="#{jspMsg['btn.btn8']}" 
					styleClass="rich-button" 
	            	action="#{navAction.navi}" 
	            	reRender="oppContent,paymentDetail,payment"   
	            	style="width:150"
	            	rendered="false">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPayment7" />
					</a4j:commandButton>
					
						 					 					 	
								 					 					 					 	
			</h:panelGrid>

			</a4j:form>

<!-- Start  Search Result  -->		
			<a4j:form id="frmResult">
<!-- Start Display 	1. EL_BILL -->						
				<c:if test="${semmel006Bean.expenseType=='EL_BILL'}">
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.table.EL_BILL']}" style="width: 100%"/>
						</f:facet>
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbpayment" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentSearch"  value="#{semmel006Bean.resultList}" reRender="dtbpayment" 
							rows="#{semmel006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									
									<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent,companyDetail,payment,paymentDetail,pnlNoPaymentSite,dtbnotPaymentSiteList" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>									

								</div>
							</rich:column>											
							
							<rich:column sortBy="#{paymentSearch.company}" >
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{paymentSearch.electricUseType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricUseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.electricUseTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>
														
							<rich:column sortBy="#{paymentSearch.docNo}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>							
							
							<rich:column sortBy="#{paymentSearch.docDtTH}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.docDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>							
														
							<rich:column sortBy="#{paymentSearch.invTotalSite}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invTotalSite']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.invTotalSite}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>							
							
							<rich:column sortBy="#{paymentSearch.dbTotalSite}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.dbTotalSite']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.dbTotalSite}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.invTotalIncludeVat}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invTotalIncludeVat']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.invTotalIncludeVat}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							
							<rich:column sortBy="#{paymentSearch.dbTotalIncludeVat}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.dbTotalIncludeVat']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.dbTotalIncludeVat}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.invTotalVat']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.invTotalVat}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							
							<rich:column sortBy="#{paymentSearch.dbTotalVat}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.dbTotalVat']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.dbTotalVat}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									
										<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
								<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />										
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.transferDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.remark}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform"  style="width: 300"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>								


							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel006Bean.resultList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="18">
											<rich:datascroller immediate="true" rendered="true" align="center" for="dtbpayment" 
												maxPages="10" id="dstdtbpayment" selectedStyleClass="selectScroll" />
										</rich:column>
									</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
			
																
				
				</h:panelGrid>			
				<!-- end content layout data grid -->
			</c:if>	
			
<!-- Start Display 	2. EL_POSTPAID -->				
				<c:if test="${semmel006Bean.expenseType=='EL_POSTPAID'}">
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResultEL_POSTPAID" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.table.EL_POSTPAID']}" style="width: 100%"/>
						</f:facet>
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbpayment" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentSearch"  value="#{semmel006Bean.resultList}" reRender="dtbpayment" 
							rows="#{semmel006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->



							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShow2" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>		
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.contractNo}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.oldContractId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.previousContractId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.oldContractId}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<rich:column sortBy="#{paymentSearch.company}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.siteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.effectiveDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.effectiveDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.effectiveDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.expireDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expireDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expireDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.networkStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.networkStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.networkStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterStatus}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterStatus2']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterStatus}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterId}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
																				
							<rich:column sortBy="#{paymentSearch.electricUseType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricUseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.electricUseTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.region}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.region']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.region}" styleClass="contentform"  />
								</div>
							</rich:column>										
							
							<rich:column sortBy="#{paymentSearch.locationId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.locationCode}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>											
							<rich:column sortBy="#{paymentSearch.vendorId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vendorName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorName}" styleClass="contentform" style="width: 200" />
								</div>
							</rich:column>															


							<rich:column sortBy="#{paymentSearch.payeeId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.payeeName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>												
							<rich:column sortBy="#{paymentSearch.expenseType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expenseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expenseTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.termOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.termOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.termOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.pRead}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.pRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.pRead}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0"/> 
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.lRead}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.lRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.lRead}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0"/> 
									</h:outputText>
								</div>
							</rich:column>								
							
							
							<rich:column sortBy="#{paymentSearch.kwhTotal}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.kwhTotal']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.kwhTotal}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0"/> 
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.excludeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.vatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.includeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.includeVatAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>						
																				

							
							
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>			

							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									
									<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform" style="width: 200" />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.remark}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform"  style="width: 300"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>								


							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="27">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbpayment" 
											maxPages="10" id="dstdtbpayment" selectedStyleClass="selectScroll" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->						
						
						
					</rich:panel>
				</h:panelGrid>
				</c:if>	
<!-- Start End 	EL_POSTPAID -->		

<!-- Start Display 	3. EL_TEMP -->						
				<c:if test="${semmel006Bean.expenseType=='EL_TEMP'}">
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResultEL_TEMP" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.table.EL_TEMP']}" style="width: 100%"/>
						</f:facet>
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbpayment" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentSearch"  value="#{semmel006Bean.resultList}" reRender="dtbpayment" 
							rows="#{semmel006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->


							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShow2" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>	
								</div>
							</rich:column>
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.oldContractId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.previousContractId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.oldContractId}" styleClass="contentform"  />
								</div>
							</rich:column>	
													
							<rich:column sortBy="#{paymentSearch.company}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.siteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteName}" styleClass="contentform" style="width: 200"  />
								</div>
							</rich:column>							

<rich:column sortBy="#{paymentSearch.effectiveDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.effectiveDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.effectiveDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.expireDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expireDt']}"  styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expireDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.networkStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.networkStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.networkStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterStatus}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterStatus2']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterStatus}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterId}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>

							<rich:column sortBy="#{paymentSearch.region}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.region']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.region}" styleClass="contentform"  />
								</div>
							</rich:column>										
							
							<rich:column sortBy="#{paymentSearch.locationId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.locationCode}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>				
							
							
							<rich:column sortBy="#{paymentSearch.vendorId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vendorName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorName}" styleClass="contentform" style="width: 200" />
								</div>
							</rich:column>															


							<rich:column sortBy="#{paymentSearch.payeeId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.payeeName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>																				
							

							<rich:column sortBy="#{paymentSearch.fromTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.fromTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							 
							<rich:column sortBy="#{paymentSearch.toTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.toTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	

							
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.totalTermOfPayment']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="1" styleClass="contentform"/>
								</div>
							</rich:column>	
							
																				
							<rich:column sortBy="#{paymentSearch.pRead}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.pRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.pRead}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.lRead}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.lRead']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.lRead}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>								
							
							
							<rich:column sortBy="#{paymentSearch.kwhTotal}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.kwhTotal']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.kwhTotal}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>	
							
							
						
							<rich:column sortBy="#{paymentSearch.payAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatTypeDisplay}" styleClass="contentform"  >									
									</h:outputText>
								</div>
							</rich:column>	
							
																					
							
							<rich:column sortBy="#{paymentSearch.excludeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.vatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.includeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.includeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>						
																				
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />
								
								</div>
							</rich:column>										

							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />
									
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.transferDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="29">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbpayment" 
											maxPages="10" id="dstdtbpayment" selectedStyleClass="selectScroll" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->						
						
					</rich:panel>
				</h:panelGrid>
				</c:if>	
<!-- Start End 	EL_TEMP -->						
<!-- Start Display 	4. PR_POSTPAID -->						
				<c:if test="${semmel006Bean.expenseType=='PR_POSTPAID'}">
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResultPR_POSTPAID" styleClass="sem_el_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.table.PR_POSTPAID']}" style="width:100%"/>
						</f:facet>
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbpayment" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentSearch"  value="#{semmel006Bean.resultList}" reRender="dtbpayment" 
							rows="#{semmel006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable" rendered="true">

							<!-- begin column -->



							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShowPage5" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>	
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.contractNo}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.oldContractId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.previousContractId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.oldContractId}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<rich:column sortBy="#{paymentSearch.company}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.siteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>							
							<rich:column sortBy="#{paymentSearch.effectiveDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.effectiveDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.effectiveDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.expireDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expireDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expireDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteStatusDisplay}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.networkStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.networkStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.networkStatusDisplay}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterStatus}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterStatus}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterStatus2']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterStatus}" styleClass="contentform"  />
								</div>
							</rich:column>

							<rich:column sortBy="#{paymentSearch.region}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.region']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.region}" styleClass="contentform"  />
								</div>
							</rich:column>										
							
							<rich:column sortBy="#{paymentSearch.locationId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.locationCode}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>				
							
							
							<rich:column sortBy="#{paymentSearch.vendorId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vendorName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>															


							<rich:column sortBy="#{paymentSearch.payeeId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.payeeName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>																				
							<rich:column sortBy="#{paymentSearch.expenseType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expenseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expenseTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>								
							
							<rich:column sortBy="#{paymentSearch.fromTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.fromTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.toTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.toTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.totalTermOfPayment']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="1" styleClass="contentform"  />
								</div>
							</rich:column>	
							
							
													
							<rich:column sortBy="#{paymentSearch.unitPrice}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitPrice']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.unitPrice}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.unitVatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitVatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.unitVatTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>								

						
							<rich:column sortBy="#{paymentSearch.payAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>	
							
																					
							
							<rich:column sortBy="#{paymentSearch.excludeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.vatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.includeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.includeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		

							<rich:column sortBy="#{paymentSearch.whtAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.whtAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.whtAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								

							
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.transferDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.remark}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform" style="width: 300" />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>				

							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="37">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbpayment" 
											maxPages="10" id="dstdtbpayment" selectedStyleClass="selectScroll" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						
						<!-- end dataTable -->						
						
					
				
				
<!-- Test Momo -->

				<div style="height:480px ; width:100%; overflow-x:auto; overflow-y: auto; " >
				<rich:scrollableDataTable rowKeyVar="rkv" frozenColCount="5" 
                width="100%" id="carList"  height="470px"   
               	var="paymentSearch"  value="#{semmel006Bean.resultList}"
			    rows="#{semmel006Bean.rowPerPage}" 
			    rowClasses="cur"  rendered="false"
			     
			    >

               <rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  
									styleClass="contentform" />
								</f:facet>
								<div align="center">
										<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShowPage5" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>	
								</div>
							</rich:column>
							<rich:column id ='contractNo' >
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractNo']}"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.contractNo}"  />
								</div>
							</rich:column>							
							<rich:column id ='company' sortBy="#{paymentSearch.company}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column >
							<rich:column id= "siteName" sortBy="#{paymentSearch.siteName}" width="200px" styleClass="contentform" >
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.siteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteName}" styleClass="contentform"  
									style="width: 200"/>
								</div>
							</rich:column>							

							<rich:column id = "region" sortBy="#{paymentSearch.region}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.region']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.region}" styleClass="contentform"  />
								</div>
							</rich:column>										
							
							<rich:column sortBy="#{paymentSearch.locationId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.locationCode}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>				
							
							
							<rich:column sortBy="#{paymentSearch.vendorId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vendorName}" width="200px">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" 
									style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>															


							<rich:column sortBy="#{paymentSearch.payeeId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.payeeName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>																				
							<rich:column sortBy="#{paymentSearch.expenseType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expenseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expenseTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>								
							
							<rich:column sortBy="#{paymentSearch.fromTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.fromTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.toTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.toTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.totalTermOfPayment']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="1" styleClass="contentform"  />
								</div>
							</rich:column>	
							
							
													
							<rich:column sortBy="#{paymentSearch.unitPrice}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitPrice']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.unitPrice}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.unitVatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitVatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.unitVatTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>								

						
							<rich:column sortBy="#{paymentSearch.payAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>	
							
																					
							
							<rich:column sortBy="#{paymentSearch.excludeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.vatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.includeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.includeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		

							<rich:column sortBy="#{paymentSearch.whtAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.whtAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.whtAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								

							
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.transferDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.remark}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform" style="width: 300" />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>				
               <f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="carList" 
									maxPages="10" id="dstdtbpayment_1" selectedStyleClass="selectScroll" />
							</f:facet>
            </rich:scrollableDataTable>
            </div> 
            
            </rich:panel>
            </h:panelGrid>
				</c:if>	
<!-- Start End 	PR_POSTPAID -->					


	
<!-- Start Display 	5. PR_PREPAID -->						
				<c:if test="${semmel006Bean.expenseType=='PR_PREPAID'}">
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResultPR_PREPAID" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.table.PR_PREPAID']}" style="width: 3000px"/>
						</f:facet>
						<!-- begin dataTable -->
						
						<rich:dataTable id="dtbpayment" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentSearch"  value="#{semmel006Bean.resultList}" reRender="dtbpayment" 
							rows="#{semmel006Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->



							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentDetail']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
										<a4j:commandLink value="View" action="#{navAction.navi}"
									reRender="oppContent" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="doShowPage5" />
										<a4j:actionparam name="viewRowNumber" value="#{paymentSearch.rowNumber}" />
									</a4j:commandLink>	
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.contractNo}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.oldContractId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.previousContractId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.oldContractId}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<rich:column sortBy="#{paymentSearch.company}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.company']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.siteName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	
							
							
							<rich:column sortBy="#{paymentSearch.effectiveDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.effectiveDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.effectiveDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.expireDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expireDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.expireDt}" styleClass="contentform"  style="width: 70">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.siteStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.contractStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.siteStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.networkStatusDisplay}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.networkStatus']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.networkStatusDisplay}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterStatus}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterStatus2']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterStatus}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{paymentSearch.meterId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.meterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.meterId}" styleClass="contentform"  style="width: 90"/>
								</div>
							</rich:column>
							

							<rich:column sortBy="#{paymentSearch.region}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.region']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.region}" styleClass="contentform"  />
								</div>
							</rich:column>										
							
							<rich:column sortBy="#{paymentSearch.locationId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>									
							<rich:column sortBy="#{paymentSearch.locationCode}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.locationCode']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>				
							
							
							<rich:column sortBy="#{paymentSearch.vendorId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vendorName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vendorName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>															


							<rich:column sortBy="#{paymentSearch.payeeId}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.payeeName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payeeName}" styleClass="contentform"  style="width: 200" />
								</div>
							</rich:column>			
							
							
							<rich:column >
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.periodTypePlusInternal']}"  styleClass="contentform" />									
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.periodName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column sortBy="#{paymentSearch.fromTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.fromTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.fromTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>		
							
							<rich:column sortBy="#{paymentSearch.toTermOfPaymentDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.toTermOfPaymentDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.toTermOfPaymentDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.totalTermOfPayment']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="1" styleClass="contentform"  >	</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column sortBy="#{paymentSearch.payAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.payAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.vatType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatTypeDisplay}" styleClass="contentform"  />
								</div>
							</rich:column>	
							
																					
							
							<rich:column sortBy="#{paymentSearch.excludeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.excludeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.vatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.vatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.includeVatAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.includeVatAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		

							<rich:column sortBy="#{paymentSearch.whtAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.whtAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.whtAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							
							
							<rich:column sortBy="#{paymentSearch.chqAmt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.paymentMethod}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentTypeDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.paymentType}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.paymentMethodDisplay}" styleClass="contentform"  />

								</div>
							</rich:column>									

							<rich:column sortBy="#{paymentSearch.bankName}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankName}" styleClass="contentform"  style="width: 200"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.bankAccount}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.chqPostingDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqPostingDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								

							<rich:column sortBy="#{paymentSearch.chqReceivedDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.chqReceivedDtTH}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>								
							<rich:column sortBy="#{paymentSearch.transferDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.transferDtTH}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>									
								</div>
							</rich:column>		
							<rich:column sortBy="#{paymentSearch.remark}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.remark}" styleClass="contentform"  style="width: 300"/>
								</div>
							</rich:column>	

							<rich:column sortBy="#{paymentSearch.createBy}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createBy']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createBy}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{paymentSearch.createDt}">
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.createDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentSearch.createDtTH}" styleClass="contentform" >									
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="18">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbpayment" 
											maxPages="10" id="dstdtbpayment" selectedStyleClass="selectScroll" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->						
						
					</rich:panel>
				</h:panelGrid>
				</c:if>	
<!-- Start End 	PR_PREPAID -->		
			</a4j:form>
<!-- End Search Result -->
		</h:panelGrid>	
	</rich:panel>
</h:panelGrid>