<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<f:loadBundle basename="resources.el.semmel007" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchmeterInstall">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError_01">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>		
		
		<h:panelGrid columnClasses="gridContent" width="100%">			
			<a4j:form id="frmSearch">
				<!-- ++++++++++++++++++ Start Not Expense Info ++++++++++++++++++ 
				<h:panelGrid width="90%" rendered="false">
					<rich:panel id="pnlNotPayInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseInfo']}" />
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalNotExpenseSite']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel007Bean.prepaidInfo.totalExpenseSite}" styleClass="ms7" />
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalNotExpenseBill']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel007Bean.prepaidInfo.totalExpenseBill}" styleClass="ms7" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				-->
				<!-- ++++++++++++++++++ End Not Expense Info ++++++++++++++++++ -->
				
				<!-- ++++++++++++++++++ Start Search Section ++++++++++++++++++ -->				
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria']}" />
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0"	cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="25%" valign="bottom">
										 <h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
										 <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td width="75%" colspan="3">
											<h:selectOneMenu value="#{semmel007Bean.criteria.company}" onchange="GetCompanyJS();" style="width:200px;">
												<f:selectItems value="#{semmel007Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS"	reRender="pnlSearchCriteria" /><rich:spacer width="10"/>
											<h:outputText id="companyDisplay" 
											value="#{semmel007Bean.criteria.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel007Bean.criteria.contractNo}" style="width:200px;"/>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel007Bean.criteria.siteName}" style="width:200px;"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel007Bean.criteria.region}" onchange="changeRegion();" style="width:200px;">
												<f:selectItems value="#{semmel007Bean.regionList}" />
											</h:selectOneMenu> 
											<a4j:jsFunction name="changeRegion"
												reRender="pnlSearchmeterInstall,frmError_01,frmSearch,pnlSearchCriteria,pnlSearchResult"
												action="#{semmel007Action.changeRegion}" />
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel007Bean.criteria.province}" style="width:200px;">
												<f:selectItems value="#{semmel007Bean.provinceList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel007Bean.criteria.locationId}" style="width:200px;"/>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel007Bean.criteria.locationCode}" style="width:200px;"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy" id="paymentDtFrom"
												value="#{semmel007Bean.criteria.fromTermOfPaymentDt}"
												inputSize="18"
												oninputblur="validateRichCalendarFromTo('frmSearch','paymentDtFrom','paymentDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','paymentDtFrom','paymentDtTo');"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												id="paymentDtTo"
												value="#{semmel007Bean.criteria.toTermOfPaymentDt}"
												inputSize="18"
												oninputblur="validateRichCalendarFromTo('frmSearch','paymentDtTo','paymentDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','paymentDtTo','paymentDtFrom');"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.picoCell']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectBooleanCheckbox value="#{semmel007Bean.criteria.checkSite}" styleClass="ms7" />										
										</td>
										<td align="right" width="25%"></td>
										<td width="25%"></td>
									</tr>
								</table>
							</h:panelGroup>							
							<h:panelGrid columns="4" id="grdSearchCommand">
								<a4j:commandButton id="btnSearch" value="Search"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="pnlSearchCriteria,frmError_01,frmSearch,pnlSearchCriteria,pnlSearchResult">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL007-1" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL007" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
								<a4j:commandButton id="btnClear" value="Clear"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="pnlSearchCriteria,frmError_01,pnlSearchCriteria,panSearchResult">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL007" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL007" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
								</a4j:commandButton>
							</h:panelGrid>							
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- ++++++++++++++++++ End Search Section ++++++++++++++++++ -->
			</a4j:form>

			<!-- ++++++++++++++++++ Start Search Result ++++++++++++++++++ -->
			<a4j:form id="frmResult">				
				<h:panelGrid style="width:93%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.searchResult']}" style="width:1000px" />
						</f:facet>						
						<rich:dataTable id="dtbmeterInstall" width="95%" cellpadding="0"
							cellspacing="0" border="0" var="meterInstall"
							value="#{semmel007Bean.resultList}" reRender="dtbmeterInstall"
							rows="#{semmel007Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<a4j:support event="onRowClick" action="#{semmel007Action.getRowIdOnClick}"
								reRender="dtbmeterInstall">
								<a4j:actionparam name="rowId" value="#{meterInstall.rowId}" />
							</a4j:support>							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterInstallDetail']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="bthPRPrepaid" value="#{jspMsg['column.header.meterInstallDetail']}" styleClass="rich-button" 
					            	action="#{navAction.navi}" reRender="oppContent,paymentDetail,payment" style="width:70"
					            	rendered="#{semmel007Bean.renderer['btnPRPrepaid']}">
									    <a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL007" />
										<a4j:actionparam name="methodWithNavi" value="initPaymentPRPrepaid4Page6" />
										<a4j:actionparam name="rowId" value="#{meterInstall.rowId}" />
										<a4j:actionparam name="contractNo" value="#{meterInstall.contractNo}" />
									</a4j:commandButton>									
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInstall.contractNo}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInstall.company}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInstall.siteName}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}"
										styleClass="contentform" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{meterInstall.region}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInstall.locationId}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInstall.locationCode}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodName']}" styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInstall.periodName}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInstall.periodNo}" styleClass="contentform" /></div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dueDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{meterInstall.dueDateStr}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.excAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right"">
									<h:outputText value="#{meterInstall.excAmt}" styleClass="contentform">
										<f:convertNumber type="number" pattern="#,##0.00"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="50px">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vat']}" styleClass="contentform" />
								</f:facet>
								<div align="right"">
									<h:outputText value="#{meterInstall.vatAmt}" styleClass="contentform">
										<f:convertNumber type="number" pattern="#,##0.00"  />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.incAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right"">
									<h:outputText value="#{meterInstall.incAmt}" styleClass="contentform">
										<f:convertNumber type="number" pattern="#,##0.00"  />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column width="50px">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.wht']}" styleClass="contentform" />
								</f:facet>
								<div align="right"">
									<h:outputText value="#{meterInstall.whtAmt}" styleClass="contentform">
										<f:convertNumber type="number" pattern="#,##0.00"  />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right"">
									<h:outputText value="#{meterInstall.chqAmt}" styleClass="contentform">
										<f:convertNumber type="number" pattern="#,##0.00"  />
									</h:outputText>
								</div>
							</rich:column>	
														
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true"
									align="center" for="dtbmeterInstall" maxPages="10" 
									id="dstdtbmeterInstall" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>						
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
			<!-- ++++++++++++++++++ End Search Result ++++++++++++++++++ -->
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>