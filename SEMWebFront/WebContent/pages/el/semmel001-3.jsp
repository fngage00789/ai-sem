<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel001-3" var="jspMsg" />
<h:panelGrid width="100%">

	<rich:panel id="pnlVerifyJob">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid columnClasses="gridContent" width="90%">

			<a4j:form id="frmVerifyJob">

				<!-- begin content layout -->

				<h:panelGrid width="100%">

					<h:panelGroup>

						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<table id="tblMessage">
										<tr>
											<td><h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" /></td>
										</tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td>
												<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="3" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<rich:panel id="pnlContractInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.company}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.oldContractNo}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.regionLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.siteStatusLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationId}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationCode}" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlElectricUseInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.electricUseInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%"> 
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricUseTypeLabel}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<rich:spacer width="1"/>
										</td>
										<td width="30%">
											<h:selectBooleanCheckbox title="chkTransferFlag" value="#{semmel001Bean.wrapper.electricManage.transferFlagBoolean}" disabled="true"/>
											<h:outputText value="#{jspMsg['label.transferFlag']}" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlCoverageInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.coverageInfo']}" />
							<rich:spacer width="2" />
							<a4j:commandButton id="btnBGDetail" styleClass="rich-button" value="#{jspMsg['btn.bgDetail']}" action="#{navAction.navi}">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doInitBGDetail" />
							</a4j:commandButton>
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgTotalRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7" />
										</td>
										<td width="75%" colspan="3">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgNo}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.coverageMoney']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgAmt}" styleClass="ms7">
												<f:convertNumber type="currency" currencySymbol=""/>
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bankNameLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.startDate']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgStartDtLabel}" styleClass="ms7"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgEndDtLabel}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalSite']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.totalSiteBg}" styleClass="ms7">
												<f:convertNumber type="number"/>
											</h:outputText>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalRemainSite']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.totalSiteRemain}" styleClass="ms7">
												<f:convertNumber type="number"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgDetailRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<rich:panel id="pnlBGDetailResult">
												<rich:dataTable id="dtbBGDetail" width="95%" cellpadding="1" cellspacing="0" border="0" 
													var="bgDetail" value="#{semmel001Bean.wrapper.bgDepositDetailList}" reRender="dtbBGDetail" 
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
													styleClass="contentform" >
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.bgNo']}" />
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.bgNo}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.bankName']}" />
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.bankNameLabel}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.coverageMoney']}"/>
														</f:facet>
														<div align="right">
															<h:outputText value="#{bgDetail.bgAmt}">
																<f:convertNumber type="currency" currencySymbol=""/>
															</h:outputText>
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.remark']}"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.remark}"/>
														</div>
													</rich:column>
												</rich:dataTable>
											</rich:panel>
										</td>
									</tr>
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgCashRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<rich:panel id="pnlBGCashResult">
												<rich:dataTable id="dtbBGCash" width="95%" cellpadding="1" cellspacing="0" border="0" 
													var="bgCash" value="#{semmel001Bean.wrapper.cashDepositDetailList}" reRender="dtbBGCash" 
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
													styleClass="contentform" >
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.coverageMoney']}" />
														</f:facet>
														<div align="right">
															<h:outputText value="#{bgCash.depositAmt}" >
																<f:convertNumber type="currency" currencySymbol=""/>
															</h:outputText>
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.vatType']}" />
														</f:facet>
														<div align="center">
															<h:outputText value="#{bgCash.vatTypeLabel}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.remark']}"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgCash.remark}" />
														</div>
													</rich:column>
												</rich:dataTable>
											</rich:panel>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlMeterInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<rich:panel id="pnlMeterInfoResult">
							
								<rich:dataTable id="dtbMeterInfo" width="50%" cellpadding="1" cellspacing="0" border="0" 
									var="meterId" value="#{semmel001Bean.wrapper.meterInstallmentList}" reRender="dtbMeterInfo" 
									rowKeyVar="row"
									onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
									styleClass="contentform" >
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.meterNo']}" />
										</f:facet>
										<div align="center">
											<a4j:commandLink value="#{meterId}" oncomplete="#{rich:component('mdpMeterInfoDialog')}.show(); return false" action="#{navAction.navi}" reRender="mdpMeterInfoDialog">
												<a4j:actionparam name="navModule" value="el" />
				            					<a4j:actionparam name="navProgram" value="SEMMEL001-3" />	
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doInitMeterInfoPopup" />
												<a4j:actionparam name="meterId" value="#{meterId}" />
												<a4j:actionparam name="meterIdOnly" value="true" />
											</a4j:commandLink>
										</div>
									</rich:column>
								</rich:dataTable>
								
							</rich:panel>
							
						</h:panelGrid>
						
					</rich:panel>
					
				</h:panelGrid>
				
			</a4j:form>
			
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>

<rich:modalPanel id="mdpMeterInfoDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.meterInfoPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmMeterInfoDialog">
	
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:outputText value="#{jspMsg['label.meterInfo']}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td>
					<rich:dataTable id="dtbMeterInfoPopup" width="95%" cellpadding="1" cellspacing="0" border="0" 
						var="meterInfoPopup" value="#{semmel001Bean.wrapper.selectedMeterInstallmentList}" reRender="dtbMeterInfoPopup" 
						rows="#{semmel001Bean.rowPerPage}"
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						styleClass="contentform" >
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.meterNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{meterInfoPopup.meterId}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.termOfPayment']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{meterInfoPopup.termOfPaymentDtStr}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.accrueAmt']}" />
							</f:facet>
							<div align="right">
								<h:outputText value="#{meterInfoPopup.accureAmt}">
									<f:convertNumber type="currency"  currencySymbol=""/>
								</h:outputText>
							</div>
						</rich:column>
						
						<f:facet name="footer">
							<rich:datascroller immediate="true" rendered="true"
								align="center" for="dtbMeterInfoPopup" maxPages="10"
								id="dtbMeterInfoPopupPaging" selectedStyleClass="selectScroll" />
						</f:facet>
					</rich:dataTable>
				</td>
			</tr>
			<tr>
				<td><rich:spacer width="5"/></td>
			</tr>
			<tr>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.close']}" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mdpMeterInfoDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

