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
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();" rendered="false">
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
											<a4j:actionparam name="detailPageFlag" value="PY" />
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
			<!-- group[1] >> -->
			
				
			
			
			<!-- group[3] >> -->
			<h:panelGrid id="payeeInfoHistDetail" width="98%" style="border:solid 1px gray;">
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}"/></f:facet>
					
					<!-- payee info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="80%" align="center">
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.nameTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:68%;text-align:left;" colspan="3">
												<h:outputText id="payeeInfoHistDetailPayeeName" value="#{semmmm001Bean.payeeInfoHistDetail.payeeName}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.citizen.id']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailIdCard" value="#{semmmm001Bean.payeeInfoHistDetail.idCard}" styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.personl.tax.idTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailTaxId" value="#{semmmm001Bean.payeeInfoHistDetail.taxId}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.address1Txt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailAddress1" value="#{semmmm001Bean.payeeInfoHistDetail.payeeAddress1}"  styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.address2Txt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailAddress2" value="#{semmmm001Bean.payeeInfoHistDetail.payeeAddress2}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_tambolTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText  id="payeeInfoHistDetailTambol" value="#{semmmm001Bean.payeeInfoHistDetail.tambol}" styleClass="ms7"/>
												
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_amphurTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailAmphur" value="#{semmmm001Bean.payeeInfoHistDetail.amphur}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_provinceTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailProvince" value="#{semmmm001Bean.payeeInfoHistDetail.province}" styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.th_post.codeTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailPostCode" value="#{semmmm001Bean.payeeInfoHistDetail.postCode}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.contact.nameTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailContractName" value="#{semmmm001Bean.payeeInfoHistDetail.contactName}" styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.telephoneTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailTelephone" value="#{semmmm001Bean.payeeInfoHistDetail.telephone}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.mobileTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailMobile" value="#{semmmm001Bean.payeeInfoHistDetail.mobileNo}" styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.faxTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailFax" value="#{semmmm001Bean.payeeInfoHistDetail.fax}" styleClass="ms7"/>
											</td>
										</tr>
										<tr>
											<td style="text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.emailTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailEmail" value="#{semmmm001Bean.payeeInfoHistDetail.email}" styleClass="ms7"/>
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
												<h:outputText id="payeeInfoHistDetailRemark" value="#{semmmm001Bean.payeeInfoHistDetail.remark}" styleClass="ms7"/>
											</td>
											<td style="width:10%; text-align:left;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.statusTxt']}"/>
											</td>
											<td style="width:1%;" >
												<h:outputText value=":" styleClass="ms7"/>
											</td>
											<td style="width:28%;text-align:left;">
												<h:outputText id="payeeInfoHistDetailPayeeStatus" value="#{semmmm001Bean.payeeInfoHistDetail.payeeStatusTxt}" styleClass="ms7"></h:outputText>
												
											</td>
										</tr>
									</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				<!-- payee info panel << -->
				
				
			</h:panelGrid>
			
			<div style="clear:both; height:5px;"></div>
			
			<h:panelGrid style="width:97%;">
							<rich:tabPanel id="panelPayeeTab" selectedTab="#{semmmm001Bean.payeeSelectedTab}" switchType="client" style="width:100%;">
								<rich:tab label="#{jspMsg['header.vendor.address']}" id="tabP0" onlabelclick="setTabNoP0();">
									<a4j:jsFunction name="setTabNoP0" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP0">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP0"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab0Payee"  viewId="../../pages/mm/semmmm001tab0PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.rentor.address']}" id="tabP1" onlabelclick="setTabNoP1();">
									<a4j:jsFunction name="setTabNoP1" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP1">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP1"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab1Payee"  viewId="../../pages/mm/semmmm001tab1PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.elector.address']}" id="tabP2" onlabelclick="setTabNoP2();">
									<a4j:jsFunction name="setTabNoP2" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP2">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP2"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab2Payee"  viewId="../../pages/mm/semmmm001tab2PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.property.address']}" id="tabP3" onlabelclick="setTabNoP3();">
									<a4j:jsFunction name="setTabNoP3" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP3">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP3"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab3Payee" viewId="../../pages/mm/semmmm001tab3PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.insure.address']}" id="tabP4" onlabelclick="setTabNoP4();">
									<a4j:jsFunction name="setTabNoP4" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP4">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP4"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab4Payee" viewId="../../pages/mm/semmmm001tab4PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.construct.address']}" id="tabP5" onlabelclick="setTabNoP5();">
									<a4j:jsFunction name="setTabNoP5" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP5">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP5"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab5Payee" viewId="../../pages/mm/semmmm001tab5PayeeHist.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.withholder.address']}" id="tabP6" onlabelclick="setTabNoP6();" rendered="false">
									<a4j:jsFunction name="setTabNoP6" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP6">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4DETAIL" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP6"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab6Payee" viewId="../../pages/mm/semmmm001tab6PayeeHist.jsp" />
								</rich:tab>
							</rich:tabPanel>
						</h:panelGrid>
						
						<div style="clear:both; height:5px;"></div>
						
						<rich:panel style="width:98%;">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.payee']}"/></f:facet>
						
							<div id="tabPayeeHistoryChange" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
										<rich:dataTable id="dtbPYHistoryList" width="100%" 
										cellpadding="0" cellspacing="0" border="0" 
										value="#{semmmm001Bean.historyResultList}" var="historyObj"
										reRender="dtbPYHistoryList" rows="#{semmmm001Bean.rowPerPage}"
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
														<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPYHistoryList"
															maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrllPYHistoryList" style="background-color: #cccccc;"
															page="#{semmmm001Bean.scrollerPage}">
														<a4j:support event="onclick" reRender="dtbPYHistoryList"></a4j:support>
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
