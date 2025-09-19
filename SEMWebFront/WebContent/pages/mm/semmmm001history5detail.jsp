<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.history.bookbank.payee.info']}"/></f:facet>	
	
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
		
		<a4j:form id="frmVendorBookbankInfo">
			<h:panelGroup id="pnlButton">
				<table width="95%">
					<tr class="ms7">
						<td width="50%" align="left">
					
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr class="ms7">
									<td>
						           		<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button" rendered="false"
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
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoadHist" />
											<a4j:actionparam name="backDetailFlag" value="Y" />
											<a4j:actionparam name="detailPageFlag" value="PB" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
						           		</a4j:commandButton>
					           		</td>
			           			</tr>
			           		</table>
           				</td>
           			</tr>
				</table>
			</h:panelGroup>
			
			<rich:panel>
				<f:facet name="header"><h:outputText value="#{jspMsg['header.expense.bookbankpayee']}"/></f:facet>
				
				<!-- bookbank payee info panel -->
				<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="80%" align="center">
							<tr>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.account.typeTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;" colspan="3">
									<h:outputText id="bookbankPayeeInfoHistDetailAccountType" value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.accountTypeTxt}" styleClass="ms7"></h:outputText>
									
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.bank.codeTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailBankCode" 
									value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.bankCode}" styleClass="ms7"/>
								</td>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.bankTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailBank" 
									value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.bankName}" styleClass="ms7"/>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.bank.branchTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailBankBranch" value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.bankBranch}" styleClass="ms7"/>
									
								</td>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.th_provinceTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailProvince" value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.provinceTxt}" styleClass="ms7"/>
									
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.account.numberTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailAccountNo" value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.accountNo}" styleClass="ms7"/>
									
								</td>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.account.nameTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailAccountName" 
									value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.accountName}" styleClass="ms7"/>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:left;" class="ms7">
									<h:outputText value="#{jspMsg['label.remarkTxt']}"/>
								</td>
								<td style="width:1%;" >
									<h:outputText value=":" styleClass="ms7"/>
								</td>
								<td style="width:28%;text-align:left;">
									<h:outputText id="bookbankPayeeInfoHistDetailRemark" value="#{semmmm001Bean.bookbankPayeeInfoHistDetail.remark}" styleClass="ms7"/>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</rich:panel>
			
			<rich:panel>
				<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.bookbank.payee']}"/></f:facet>
				
				<div id="tabBookbankPayeeHistoryChange" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
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
							
							<div align="center">
								<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
							</f:facet>
							
							<div align="center">
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
		</a4j:form>
	
	</rich:panel>
	
	
</h:panelGrid>