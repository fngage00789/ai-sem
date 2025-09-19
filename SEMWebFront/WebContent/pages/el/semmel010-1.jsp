<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel010-1" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.searchBG']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.search']}"/>
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
										<h:selectOneMenu id="ddlCompany" value="#{semmel010Bean.company}" 
										onchange="GetCompanyJS();" style="width:150px;">
											<f:selectItems value="#{semmel010Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmel010Bean.company}" styleClass="ms28"/>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
										    <h:graphicImage value="images/icon_required.gif"/>
										    <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlElectricUseType" value="#{semmel010Bean.electricUseType}" 
											style="width:150px;">
											<f:selectItems value="#{semmel010Bean.electricUseTypeList}"/>
										</h:selectOneMenu>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtContractNo" value="#{semmel010Bean.contractNo}" 
												style="width:150px;" maxlength="15"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.startDtFrom']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldStartDtFrom" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel010Bean.startDtFrom}" 
												showWeeksBar="false" inputStyle="width:150px;"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldStartDtFrom','cldstartDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldStartDtFrom','cldstartDtTo');">
											</rich:calendar>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.startDtTo']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldstartDtTo" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel010Bean.startDtTo}" 
												showWeeksBar="false" inputStyle="width:150px;"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldstartDtTo','cldStartDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldstartDtTo','cldStartDtFrom');">
											</rich:calendar>
										</td>
									</tr>																	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDtFrom']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldUploadMeterDtFrom" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel010Bean.endDtFrom}" 
												showWeeksBar="false" inputStyle="width:150px;"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');">
											</rich:calendar>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDtTo']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<rich:calendar id="cldUploadMeterDtTo" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel010Bean.endDtTo}" 
												showWeeksBar="false" inputStyle="width:150px;"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtTo','cldUploadMeterDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtTo','cldUploadMeterDtFrom');">
											</rich:calendar>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" 
								reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,panSearchResult">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			<a4j:form id="frmResult">	
				<h:panelGrid columns="2" id="grdBtnRenewCommand">			
				<a4j:commandButton id="bthRenewBG" value="#{jspMsg['btn.renewBG']}" styleClass="rich-button" 
			    action="#{navAction.navi}" reRender="oppContent" disabled="#{semmel010Bean.disableBtnRenewBg}"
			    rendered="#{semmel010Bean.renderer['btnRenewBG']}">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
								<a4j:actionparam name="methodWithNavi" value="initEL010_2" />
			            	</a4j:commandButton>
			    </h:panelGrid>
				<!-- end content button -->
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.moneyBG']}" style="width: 1620"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbBgMaster" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="bgMaster"  value="#{semmel010Bean.bgMasterList}" reRender="dtbBgMaster" 
							rowKeyVar="rowIndex"
							rows="#{semmel010Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<!-- begin column -->
							<rich:column styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel010Bean.chkSelAllBgMaster}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel010Action.selectAllRowBgMaster}" reRender="dtbBgMaster"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="managementSelected" value="#{bgMaster.selected}" disabled="#{bgMaster.disableCheckbox}">
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<div align="center">									
										<h:outputText value="#{jspMsg['column.edit']}" style="width: 25"/>
									</div>
								</f:facet>
								<div align="center">									
									<a4j:commandButton value="#{jspMsg['column.edit']}" action="#{navAction.navi}"
										reRender="pnlSearchSiteApprove,oppContent" image="images/edit.png" style="height: 15; width: 15" 
										rendered="#{bgMaster.disableEditButton}">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
											<a4j:actionparam name="methodWithNavi" value="doEdit" />
											<a4j:actionparam name="rowId" value="#{bgMaster.rowId}" />
											<a4j:actionparam name="rowIndex" value="#{rowIndex}" />
										</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 25"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['column.view']}" 
									action="#{navAction.navi}" rendered="#{bgMaster.disableViewButton}"
										reRender="oppContent" image="images/view.png" style="height: 15; width: 15">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
											<a4j:actionparam name="methodWithNavi" value="doView" />
											<a4j:actionparam name="rowId" value="#{bgMaster.rowId}" />
									</a4j:commandButton>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}"
										  rendered="true">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDelete" rendered="#{bgMaster.disableDelbtn}"
	            					oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" 
     									   style="height: 15; width: 15">
     									   <a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
										   <a4j:actionparam name="methodWithNavi" value="initDelBgMaster" />
										   <a4j:actionparam name="rowId" value="#{bgMaster.rowId}" />	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{bgMaster.contractNo}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{bgMaster.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{bgMaster.locationId}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.siteName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{bgMaster.company}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" style="width: 30"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.company}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{bgMaster.electricUseTypeDisplay}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.electricType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.electricUseTypeDisplay}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{bgMaster.bgTypeDisplay}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bgType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgTypeDisplay}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{bgMaster.bgNo}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['meterInfo.bgNo']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgNo}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{bgMaster.bgBankNameDisplay}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bank']}" style="width: 150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgBankNameDisplay}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{bgMaster.startDt}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.startDt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgStartDtDisplay}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{bgMaster.bgEndDt}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.endDate']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgEndDtDisplay}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{bgMaster.bgAmt}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.moneyAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgAmt}">
										<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{bgMaster.totalSite}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalSite']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.totalSiteChange}">
										<f:convertNumber pattern = "#,###"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{bgMaster.totalRemainSite}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalRemainSite']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.totalSiteRemain}">
										<f:convertNumber pattern = "#,###"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{bgMaster.bgStatus}" styleClass="#{(semmel010Bean.tmpRowId==bgMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bgStatus']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{bgMaster.bgStatusDisplay}"/>
								</div>								
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbBgMaster" 
									maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
					<rich:panel id="pnlSearchResult2" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.moneyCash']}" style="width: 1620"/>
						</f:facet>
						<rich:dataTable id="dtbDepositDetail" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="dsDetail"  value="#{semmel010Bean.depositDetailList}" reRender="dtbDepositDetail" 
							rows="#{semmel010Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<!-- begin column -->
							<rich:column styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel010Bean.chkSelAllDepositDetail}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel010Action.selectAllRowDepositDetail}" reRender="dtbDepositDetail"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="depositDetailSelected" value="#{dsDetail.selected}">
									
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							
							
							<rich:column sortBy="#{dsDetail.electricId.contractNo}" styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNoDep']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{dsDetail.electricId.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{dsDetail.electricId.siteName}" styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteNameDep']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dsDetail.electricId.siteName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{dsDetail.electricId.company}" styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.companyDep']}" style="width: 30"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dsDetail.electricId.company}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{dsDetail.electricId.electricUseTypeDisplay}" styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.electricTypeDep']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dsDetail.electricId.electricUseTypeDisplay}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{dsDetail.moneyAmt}" styleClass="#{(semmel010Bean.tmpRowId==dsDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.moneyAmtDep']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dsDetail.depositAmt}">
										<f:convertNumber type="currency" currencySymbol=""/>
							        </h:outputText>
								</div>								
							</rich:column>		
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbDepositDetail" 
									maxPages="10" id="dstDeposit" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmct002Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" 
						reRender="pnlSearchResult" >
							<a4j:actionparam name="navModule" value="el" />
				           	<a4j:actionparam name="navProgram" value="SEMMEL010-1" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
							<a4j:actionparam name="methodWithNavi" value="doDelBGMaster" />
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
