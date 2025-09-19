<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
				<a4j:form id="frmSearchPay">
					<h:panelGroup>
						<table width="100%">
							<tr><td colspan="2">
									<table id="menuLink" width="100%">
										<tr>
											<td width="13%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="RENTAL" />
													<a4j:actionparam name="param1" value="" />
												</a4j:commandLink>
											</td>
											<td width="7%" align="left">
												<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="DEPOSIT" />
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.checkPremium']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-5" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doLoadCheckPremium" />
													<a4j:actionparam name="rentalMasterId" value="#{semmrt001Bean.displayFrmRental.rentalMasterId}" />
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.expenseSend']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="contractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" />
													<a4j:actionparam name="mode" value="RENTALPAYMENT" />
												</a4j:commandLink>
											</td>
											<td width="70%" align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" style="font-size:12px;">
												</a4j:commandLink>
											</td>
										</tr>
									</table>
							</td></tr>
							<tr>
								<td width="50%" align="left">
									<table id="tblMessage">
										<tr><td>
											<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												rendered="#{semmrt001Bean.renderedMsgFormSearch}">
											 		<f:facet name="header">
							                        	<h:outputText value="Entered Data Status:"></h:outputText>
							                    	</f:facet>
										 			<f:facet name="errorMarker">
										 				 <h:graphicImage value="images/error.gif" />  
								                    </f:facet>
							                </rich:messages>
										</td></tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr><td>
											<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="oppContent">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="mode" value="SEARCH" />
											</a4j:commandButton>
										</td></tr>
									</table>
								</td>
							</tr>
							
						</table>
					</h:panelGroup>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2080"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt001Bean.msgDataNotFound}" rendered="#{semmrt001Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
							var="rentalPaySP" value="#{semmrt001Bean.rentPayList}" reRender="dstRentalPayNormalSrch" 
							rows="#{semmrt001Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodStartDt']}" styleClass="contentform" style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.periodStartDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="contentform"/>
								</f:facet>
							<div align="center">
									<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;" oncomplete="#{rich:component('popupRentalEditPeriod')}.show(); return false"
									 action="#{navAction.navi}" reRender="popupFrmEditPeriod" >
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-5" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="initEditPeriod" />	
										<a4j:actionparam name="rentalPaymentId" value="#{rentalPaySP.rentalPaymentId}"/>
										<a4j:actionparam name="expenseType" value="#{rentalPaySP.expenseTypeDesc}"/>
										<a4j:actionparam name="periodStartDt" value="#{rentalPaySP.periodStartDtStr}"/>
										<a4j:actionparam name="periodType" value="#{rentalPaySP.payPeriodType}"/>
										<a4j:actionparam name="periodNoStart" value="#{rentalPaySP.periodNoStart}"/>
									</a4j:commandButton>
								</div>
								</rich:column>
								
								
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNoStart']}" styleClass="contentform"  style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.periodNoStart}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseTypeDesc']}"   styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.expenseTypeDesc}" styleClass="contentform"  >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseDesc']}"   styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.expenseDesc}" styleClass="contentform"  >
									
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.serviceName']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.serviceName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.vendorName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.payeeName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodY']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.payPeriodY}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodM']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.payPeriodM}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodD']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.payPeriodD}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.excAmt']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.excAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.incAmt']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.incAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform"  style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt001Bean.rentPayList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPayNormalSrch"
											maxPages="#{semmrt001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmrt001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/rt/semmrt001-popupEditPeriodNo.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>