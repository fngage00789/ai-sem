<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.history.payee.info']}"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="frmContractInfo">
			<h:panelGroup id="pnlButton">
				<table width="98%">
					<tr>
						<td width="50%" align="left">
					
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr>
									<td>
						           		<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfoHist.siteInfoId}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						           	 	oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoadHist" />
						           		</a4j:commandButton>
					           		</td>
			           			</tr>
			           		</table>
           				</td>
           			</tr>
				</table>
			</h:panelGroup>
			<!-- group[1] >> -->
			
				
			
			
			<!-- group[3] >> -->
			<h:panelGrid id="payeeInfoHist" width="98%" style="border:solid 1px gray;">
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}"/></f:facet>
					
					<!-- payee info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.name']}" styleClass="ms7"/>
											</td>
											<td colspan="3">
												<h:outputText id="payeeInfoHistPayeeName" value="#{semmmm001Bean.payeeInfoHist.payeeName}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;">
												<h:outputText value="#{jspMsg['label.citizen.id']} :" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistIdCard" value="#{semmmm001Bean.payeeInfoHist.idCard}" styleClass="ms7"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.personl.tax.id']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistTaxId" value="#{semmmm001Bean.payeeInfoHist.taxId}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.address1']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistAddress1" value="#{semmmm001Bean.payeeInfoHist.payeeAddress1}" styleClass="ms7" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.address2']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistAddress2" value="#{semmmm001Bean.payeeInfoHist.payeeAddress2}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_tambol']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText  id="payeeInfoHistTambol" value="#{semmmm001Bean.payeeInfoHist.tambolName}" styleClass="ms7"/>
												
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_amphur']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistAmphur" value="#{semmmm001Bean.payeeInfoHist.amphurName}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_province']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistProvince" value="#{semmmm001Bean.payeeInfoHist.provinceTxt}" styleClass="ms7"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistPostCode" value="#{semmmm001Bean.payeeInfoHist.postCode}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistContractName" value="#{semmmm001Bean.payeeInfoHist.contactName}" styleClass="ms7"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephone']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistTelephone" value="#{semmmm001Bean.payeeInfoHist.telephone}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistMobile" value="#{semmmm001Bean.payeeInfoHist.mobileNo}" styleClass="ms7"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistFax" value="#{semmmm001Bean.payeeInfoHist.fax}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td colspan="3" style="text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistEmail" value="#{semmmm001Bean.payeeInfoHist.email}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistRemark" value="#{semmmm001Bean.payeeInfoHist.remark}" styleClass="ms7"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.status']}" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:outputText id="payeeInfoHistPayeeStatus" value="#{semmmm001Bean.payeeInfoHist.payeeFlowStatusTxt}" styleClass="ms7"></h:outputText>
												
											</td>
										</tr>
									</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				<!-- payee info panel << -->
				
				<div style="clear:both; height:5px;"></div>
				
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payee']}"/></f:facet>
					
					<div id="tabPayeeHistoryChange" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						<rich:dataTable id="dtbHistoryList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.historyResultList}" var="historyObj"
						reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left">
									<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left">
									<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="3">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllHistoryList" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
						</rich:dataTable>
					</div>
				</rich:panel>
			</h:panelGrid>
			
			<div style="clear:both; height:5px;"></div>
			
			<!-- panel rental payment -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.rental.payment.hist']}" style="text-align:left;"/></f:facet>
					
					
					<div id="tabRentalPaymentHistory" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						<rich:dataTable id="dtbRentalPaymentHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.rtPaymentHistoryList}" var="rentalObj"
						reRender="dtbRentalPaymentHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
							<rich:column  sortBy="#{rentalObj.dataObj.contractNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt003Bean.renderer['hlkSavePay'] or semmrt003Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.contractNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.oldContractNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.oldContractNo']}" styleClass="contentform" style="width:60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.oldContractNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentBatchNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.batchNo']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentBatchNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="210" sortBy="#{rentalObj.dataObj.siteName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText id="hypRentalPayPopup" value="#{rentalObj.dataObj.siteName}"></h:outputText>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.effDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDtNew']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.effDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.expDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDtnew']}" styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.dueDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueDtNew']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.dueDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.periodNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.periodNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.expenseType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.expenseTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.expenseType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allowtype']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypPopApproveType" value= "#{rentalObj.dataObj.reqType}" 
										oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
										 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="sIdHistory" value="#{rentalObj.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>			
							<rich:column  sortBy="#{rentalObj.dataObj.vendorCode}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.verdorId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.vendorName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalObj.dataObj.payeeName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.payPeriodType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.periodY}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriod']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.payPeriod}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.dueAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.dueAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.vatAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.whtRate}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.whtAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.chqAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.chqAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.siteStatus}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform"  style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.networkStatus}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentRequestDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentRequestDt']}" styleClass="contentform"  style="width:100px"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentRequestDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentStatusDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentTypeDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.bankName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="PaymentType" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.chqDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqReceiveDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.chqReceiveDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.transferDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.transferDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.depositAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.depositAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.depositAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.pettyAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pettyAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.pettyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.totalAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.totalAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.bankAccNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalObj.dataObj.remarkVerify}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkVerify']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.remarkVerify}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.remarkPending}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkPending']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.remarkPending}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.remark}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.remarkOther}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkOther']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.remarkOther}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.docSettingDebt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCreate']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.docSettingDebt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.docCuttingDebt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCut']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText id="hlkCutting" value="#{rentalObj.dataObj.docCuttingDebt}" ></h:outputText>
									
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalObj.dataObj.docCancel}" styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCancel']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.docCancel}" styleClass="contentform"  />
								</div>
							</rich:column>

							<!-- fixed by.. YUT 2014/09/30 >> -->
							<rich:column  styleClass="#{(semmrt003Bean.tmpRowId==rentalObj.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform"  style="width:100px;"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.sendInfoStatus}" styleClass="contentform" />
								</div>
							</rich:column>
																
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.rtPaymentHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPaymentHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrlldtbRentalPaymentHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbRentalPaymentHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
									
						</rich:dataTable>
					</div>
					
				</rich:panel>
				<!-- End panel rental payment -->
				
				<div style="clear:both; height:5px;"></div>
				
				<!-- panel electric payment -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.el.payment.hist']}" style="text-align:left;"/></f:facet>
					
					
					<div id="tabElPaymentHistory" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						
						<rich:dataTable id="dtbElPaymentHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.elPaymentHistoryList}" var="rentalObj"
						reRender="dtbElPaymentHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
							<rich:column  sortBy="#{rentalObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width:50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.contractNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.oldContractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.oldContractNo']}" styleClass="contentform" style="width:60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.oldContractNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.company}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.company}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="210" sortBy="#{rentalObj.dataObj.siteName}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText id="hypRentalPayPopup" value="#{rentalObj.dataObj.siteName}"></h:outputText>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.effDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDtNew']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.effDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.expDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDtnew']}" styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.siteStatusShow}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.siteStatusShow}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.netWorkStatusShow}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.netWorkStatusShow}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.expenseTypeShow}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseType']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.expenseTypeShow}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentStatusShow}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentStatus']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.paymentStatusShow}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>			
							<rich:column  sortBy="#{rentalObj.dataObj.docTypeShow}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docType']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.docTypeShow}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalObj.dataObj.docNo}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalObj.dataObj.docDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docDt']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalObj.dataObj.docDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.vendorId}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.vendorName}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							
							
							<rich:column  sortBy="#{rentalObj.dataObj.payeeId}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.payeeName}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeeName']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.periodNo}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentPeriod']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.periodNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.payAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.payAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.vatType}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.vatType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.excludeVatAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.excludeVatAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.excludeVatAmt}" styleClass="contentform">
							        	<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.vatAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.vatAmt}" styleClass="contentform">
							        	<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.includeVatAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.includeVatAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.includeVatAmt}" styleClass="contentform">
							        	<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.whtAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.whtAmt}" styleClass="contentform">
							        	<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqAmt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.chqAmt}" styleClass="contentform">
							        	<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentMethod}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentMethod']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentMethod}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.paymentType}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentType']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.paymentType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.bankName}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankName']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.bankAccount}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankAccount']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.bankAccount}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqPostingDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqPostingDt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalObj.dataObj.chqPostingDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqReceivedDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqReceivedDt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.chqReceivedDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.transferDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferDt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.transferDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.remark}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.batchNo}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.batchNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.rejectReason}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rejectReason']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.rejectReason}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqNo}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.chqNo']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.chqNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.chqClearingDt}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clearingChqDate']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.chqClearingDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.doc68}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc68']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.doc68}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.doc92}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc92']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.doc92}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalObj.dataObj.doc69}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.doc69']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.doc69}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.payment_channel}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentChannel']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.payment_channel}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalObj.dataObj.sendInfoStatus}" title="#{rentalObj.dataObj.contractNo} #{rentalObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalObj.dataObj.sendInfoStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
																
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.elPaymentHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbElPaymentHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrlldtbElPaymentHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbElPaymentHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
									
						</rich:dataTable>
					</div>
					
				</rich:panel>
				<!-- End panel electric payment -->
				
				<div style="clear:both; height:5px;"></div>
				
				<!-- panel property tax payment -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.pt.payment.hist']}" style="text-align:left;"/></f:facet>
					
				
					<div id="tabPtPaymentHistory" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						<rich:dataTable id="dtbPtPaymentHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.ptPaymentHistoryList}" var="vendorPtObj"
						reRender="dtbPtPaymentHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
							<rich:column  sortBy="#{vendorPtObj.dataObj.contractNo}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText id="hlkView" value="#{vendorPtObj.dataObj.contractNo}" ></h:outputText>
									
								</div>
							</rich:column>
							<rich:column sortBy="#{vendorPtObj.dataObj.siteName}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{vendorPtObj.dataObj.pTaxYear}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxYear']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.pTaxYear}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.paymentStatus}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.paymentStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.periodNo}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform" style="width:12px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.periodNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.expenseType}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.vendorCode}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.vendorName}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.vendorName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorPtObj.dataObj.payeeName}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorPtObj.dataObj.excAmt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.excAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.excAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorPtObj.dataObj.whtAmt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.whtAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.vatAmt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.vatAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.chqAmt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.chqAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.diffAmt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorPtObj.dataObj.diffAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.paymentTypeDesc}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.paymentTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorPtObj.dataObj.bankName}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.bankName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.bankAccNo}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.bankAccNo}" styleClass="contentform"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{vendorPtObj.dataObj.chqDt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.chqDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{vendorPtObj.dataObj.chqReceiveDt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.chqReceiveDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{vendorPtObj.dataObj.transferDt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.transferDtStr}" styleClass="contentform">
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.diffRemark}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffRemark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.diffRemark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.remark}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.exportFlag}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportFlag']}" styleClass="contentform"  style="width:6px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.exportFlag}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{vendorPtObj.dataObj.exportDt}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.exportDtStr}" styleClass="contentform">
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.docType}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorPtObj.dataObj.docTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.doc68}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.doc68}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorPtObj.dataObj.doc92}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText id="hlkCutting" value="#{vendorPtObj.dataObj.doc92}" ></h:outputText>
									
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorPtObj.dataObj.doc69}" styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorPtObj.dataObj.contractNo} #{vendorPtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc69']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.doc69}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<!-- fixed by.. YUT 2014/09/30 >> -->
							<rich:column styleClass="#{(semmpt004Bean.tmpRowId==vendorPtObj.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform"  style="width:100px;"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorPtObj.dataObj.sendInfoStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							
									
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.ptPaymentHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="29">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPtPaymentHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrlldtbPtPaymentHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbPtPaymentHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
									
						</rich:dataTable>
					</div>
					
				</rich:panel>
				<!-- End panel property tax payment -->
				
				<div style="clear:both; height:5px;"></div>
				
				<!-- panel insurance payment -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.ir.payment.hist']}" style="text-align:left;"/></f:facet>
					
					<div id="tabIrPaymentHistory" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						<rich:dataTable id="dtbIrPaymentHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.irPaymentHistoryList}" var="vendorIrObj"
						reRender="dtbIrPaymentHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
							<rich:column sortBy="#{vendorIrObj.dataObj.docType}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="ms7" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.docTypeDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.networkType}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.networkTypeDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column width="210" sortBy="#{vendorIrObj.dataObj.company}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.company}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.transferTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}"   styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.transferTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.policyTypeDesc}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyType']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.policyTypeDesc}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.policyNo}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.policyNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.vendorCode}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.vendorName}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform" style = "width : 100px " />
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorIrObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{vendorIrObj.dataObj.payeeName}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.excAmt}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amount']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.excAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorIrObj.dataObj.vatAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vat']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.vatAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.whtAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.wht']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.whtAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.dutyAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.duty']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.dutyAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.totalPayAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmount']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.totalPayAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.totalAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalSystem']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.totalAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.diffAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diff']}" styleClass="contentform" style = "width : 60px" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{vendorIrObj.dataObj.diffAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.invoiceNo}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invoiceNo']}" styleClass="contentform"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.invoiceNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column  sortBy="#{vendorIrObj.dataObj.paymentDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentDt']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.paymentDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.paymentStatusDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style = "width : 150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.paymentStatusDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.paymentTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.paymentTypeDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.paymentMethodDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bank']}" styleClass="contentform" style = "width : 150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorIrObj.dataObj.paymentMethodDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							
							<!--  -->
							<rich:column  sortBy="#{vendorIrObj.dataObj.invoiceNo}" styleClass=""
								title="#{vendorIrObj.dataObj.contractNo} #{vendorIrObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCut']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText id="hlkCutting" value="#{vendorIrObj.dataObj.doc92}" ></h:outputText>
									
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorIrObj.dataObj.remark}" styleClass=""
								title="#{vendorIrObj.dataObj.contractNo} #{vendorIrObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{vendorIrObj.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<!--  -->
							
							<rich:column  sortBy="#{vendorIrObj.dataObj.chqDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.chqDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{vendorIrObj.dataObj.chqReceiveDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.chqReceiveDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.transferDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.transferDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.updateBy}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorIrObj.dataObj.updateDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style = "width : 80px" />
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{vendorIrObj.dataObj.updateDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorIrObj.dataObj.sendInfoStatus}" >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform" style = "width : 80px" />
                                    
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{vendorIrObj.dataObj.sendInfoStatus}" styleClass="contentform">
                                    </h:outputText>
                                </div>
                            </rich:column>
                            	
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.irPaymentHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="29">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbIrPaymentHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrlldtbIrPaymentHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbIrPaymentHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
									
						</rich:dataTable>
					</div>
					
				</rich:panel>
				<!-- End panel insurance payment -->
				
				<div style="clear:both; height:5px;"></div>
				
				<!-- panel CT payment -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.ct.payment.hist']}" style="text-align:left;"/></f:facet>
					
					
					<div id="tabCtPaymentHistory" style="width:1250px; overflow-x:scroll; overflow-y:none; border:1px solid #e0e0e0;"> 
						<rich:dataTable id="dtbCtPaymentHist" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.ctPaymentHistoryList}" var="vendorCtObj"
						reRender="dtbCtPaymentHist" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
							<rich:column  sortBy="#{vendorCtObj.dataObj.contractNo}" styleClass="#{(semmmm001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px">
									<h:outputText id="hypView" value="#{vendorCtObj.dataObj.contractNo}" ></h:outputText>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorCtObj.dataObj.siteName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.siteName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorCtObj.dataObj.locationId}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:80px">
									<h:outputText value="#{vendorCtObj.dataObj.locationId}" styleClass="contentform" style="width:80px" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{vendorCtObj.dataObj.siteConstructStatus}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteConstructStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px">
									<h:outputText value="#{vendorCtObj.dataObj.siteConstructStatusName}" styleClass="contentform" style="width:100px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.docNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.docNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{vendorCtObj.dataObj.supplierName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.supplier']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.supplierName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.totSendDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.totSendDocNo']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.totSendDocNo}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.totRefDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.totRefDocNo']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.totRefDocNo}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.conPermissionDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conPermissionDocNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.conPermissionDocNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{vendorCtObj.dataObj.conBuildDocNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBuildDocNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.conBuildDocNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							<rich:column  sortBy="#{vendorCtObj.dataObj.constructTypeName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.constructType']}" styleClass="contentform"  />
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.constructTypeName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.constructStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.constructStutus']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.constructStatusName}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{vendorCtObj.dataObj.conBillNo}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBillNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.conBillNo}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>		
						   
						   <rich:column  sortBy="#{vendorCtObj.dataObj.conBillPayStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
						   	title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.conBillPayStatus']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.conBillPayStatusName}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>	
								
							 <rich:column  sortBy="#{vendorCtObj.dataObj.siteStatusName}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
							 	title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center" style="width:120px">
									<h:outputText value="#{vendorCtObj.dataObj.siteStatusName}" styleClass="contentform" style="width:120px" />
								</div>
							</rich:column>
								
							 <rich:column  sortBy="#{vendorCtObj.dataObj.flowStatus}" styleClass="#{(semmcp001Bean.tmpRowId==vendorCtObj.dataObj.rowId)?'onClick':'unClick'}"
								 title="#{vendorCtObj.dataObj.contractNo} #{vendorCtObj.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center" style="width:200px">
									<h:outputText value="#{vendorCtObj.dataObj.flowStatus}" styleClass="contentform" style="width:200px" />
								</div>
							</rich:column>
									
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.ctPaymentHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="20">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbCtPaymentHist"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrlldtbCtPaymentHist" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbCtPaymentHist"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
									
						</rich:dataTable>
					</div>
				</rich:panel>
				<!-- hide panel changed vendor history -->
				<!-- End panel CT payment -->
			
			<rich:panel styleClass="sem_autoScrollbar" rendered="false">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.list.of.contract']}"/></f:facet>
				
				<center>
				
					<rich:dataTable id="dtbContractList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractHistList}" var="contractObj"
						reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.view']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="">
									<h:outputText value="view" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.contractNo}" sortBy="#{contractObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.expenseType}" sortBy="#{contractObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.vendorName}" sortBy="#{contractObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{contractObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.vendorStatus}" sortBy="#{contractObj.dataObj.vendorStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.accountNo}" sortBy="#{contractObj.dataObj.accountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.bookbankStatus}" sortBy="#{contractObj.dataObj.bookbankStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.payeeName}" sortBy="#{contractObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{contractObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.payeeStatus}" sortBy="#{contractObj.dataObj.payeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.payeeAccountNo}" sortBy="#{contractObj.dataObj.payeeAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.bookbankPayeeStatus}" sortBy="#{contractObj.dataObj.bookbankPayeeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.payType}" sortBy="#{contractObj.dataObj.payType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{contractObj.dataObj.effectiveDtStr}" sortBy="#{contractObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.contractList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="9">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractList"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllContractList" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbContractList"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
					
				</center>
			</rich:panel>
			<!-- group[3] << -->
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>
