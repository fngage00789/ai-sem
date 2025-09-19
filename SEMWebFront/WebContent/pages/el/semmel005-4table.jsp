<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid style="width: 95%" id="pnlSearchResult">
					<rich:panel id="pnlSearchResultELPAY01" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY01'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 1620"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY01" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY01List}" reRender="dtbUploadTextELPAY01" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" 
										reRender="btnCloseJob,btnUnpaid,pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.companyName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.companyName']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.companyName}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>								
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup" style=" width : 70px;" value="View" styleClass="rich-button" 
											action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							           		oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
											<a4j:actionparam name="fromPage" value="semmel006Page"/>
											<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
											<a4j:actionparam name="groupOwnerGroup" value=""/>
											<a4j:actionparam name="groupFlagType" value="UP"/>
											<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>	
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>						
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY01List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="15">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY01"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY01" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable 1 -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY02" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY02'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 1620"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY02" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY02List}" reRender="dtbUploadTextELPAY02" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>								
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>																
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL02" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth02" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>						
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY02List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="14">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY02"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY02" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable 2 -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY03" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY03'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2500"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY03" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY03List}" reRender="dtbUploadTextELPAY03" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.oldContractNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.contractNo}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterType']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterType}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>		
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL03" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth03" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup03" style=" width : 70px; height : 21px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>								
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY03List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY03"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY03" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY04" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY04'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2500"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY04" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY04List}" reRender="dtbUploadTextELPAY04" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>		
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>			
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL04" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth04" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup04" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>						
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY04List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="22">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY04"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY04" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					
					<rich:panel id="pnlSearchResultELPAY05" styleClass="sem_autoScrollbar" 
					rendered="#{semmel005Bean.errorCode=='ELPAY05'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2950"/>
						</f:facet>
						<!-- begin dataTable -->	
											
						<rich:dataTable id="dtbUploadTextELPAY05" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY05List}" reRender="dtbUploadTextELPAY05" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							
							<rich:column sortBy="#{uploadText.billPeriodTH}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.pDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtPDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.lDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtLDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.pRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.pRead}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.lRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.lRead}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.ct}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.ct']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.ct}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.kwhTotal}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.kwhTotal']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhTotal}"/>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							
							---------------------------------------------
							<rich:column sortBy="#{uploadText.billPeriodTH}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.installmentPDateTH}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmentPDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmentPDateTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.installmentLDateTH}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmentLDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmentLDateTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.installmenPRead}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmenPRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmenPRead}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.installmenLRead}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmenLRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmenLRead}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.installmenKWH}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmenKWH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmenKWH}"/>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.installmenVatAmount}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmenVatAmount']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmenVatAmount}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.installmenIncVatAmount}" rendered="flase"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.installmenIncVatAmount']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.installmenIncVatAmount}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							---------------------------------------------------
							
							
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL05" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth05" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup05" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>								
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY05List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="36">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY05"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY05" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY11" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY11'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2600"/>
						</f:facet>
						<!-- begin dataTable -->						
						<rich:dataTable id="dtbUploadTextELPAY11" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY11List}" reRender="dtbUploadTextELPAY11" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.pDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtPDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.lDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtLDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.pRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.pRead}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.lRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.lRead}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.ct}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.ct']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.ct}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.kwhTotal}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.kwhTotal']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhTotal}"/>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL06" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth06" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup06" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>								
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY11List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="28">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY11"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY11" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY06" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY06'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2600"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY06" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY06List}" reRender="dtbUploadTextELPAY06" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.siteStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.siteStatusDesc}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.processStatusCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.processStatus']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.processStatusCodeDesc}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>								
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL07" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth07" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup07" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true"  styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>									
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY06List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY06"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY06" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY07" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY07'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2600"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY07" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY07List}" reRender="dtbUploadTextELPAY07" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.pDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtPDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.lDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtLDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.pRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.pRead}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.lRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.lRead}"/>
								</div>								
							</rich:column>
							
							-------------------
							
							<rich:column sortBy="#{uploadText.kwhOn}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Kwh On" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhOn}">
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.kwhOff}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Kwh Off" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhOff}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.kwhTotal}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Kwh Total" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhTotal}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electDemandOn}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC DEMAND ON" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electDemandOn}">
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electDemandOff}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC DEMAND OFF" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electDemandOff}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electDemandPart}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC DEMAND PART" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electDemandPart}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electOnpeak}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC ON PEAK" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electOnpeak}">
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electOffpeak}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC OFF PEAK" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electOffpeak}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electDemand}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ELECTRIC DEMAND" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electDemand}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.reactive}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="RE-ACTIVE" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.reactive}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.remark}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.incompleateData']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.remark}"/>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL08" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth08" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup08" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY07List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="37">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY07"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY07" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:panel id="pnlSearchResultELPAY08" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY08'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 1620"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY08" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY08List}" reRender="dtbUploadTextELPAY08" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}"/>
								</div>								
							</rich:column>							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.debit']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.debit']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initEditFromUploadText"/>
										<a4j:actionparam name="targetPayment" value="#{uploadText.textFileId.paymentId.rowId}"/>
										<a4j:actionparam name="isComeFromOtherPage" value="Y"/>
										<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
										<a4j:actionparam name="navModuleFrom" value="el" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
										<a4j:actionparam name="methodWithNaviFrom" value="backToPage4"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.credit']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									soon
								</div>								
							</rich:column>
							<rich:column rendered="true"  styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>	
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY08List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="11">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY08"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY08" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					
					<rich:panel id="pnlSearchResultELPAY12" styleClass="sem_autoScrollbar" rendered="#{semmel005Bean.errorCode=='ELPAY12'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2600"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextELPAY12" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextELPAY12List}" reRender="dtbUploadTextELPAY06" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.oldContractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 200"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.siteStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.siteStatusDesc}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.processStatusCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.processStatus']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.processStatusCodeDesc}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.billPeriodTH}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billperiod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billPeriodTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>								
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL09" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth09" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup09" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true"  styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>									
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY12List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY12"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY12" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					
					<!-- New Fail dataTable -->
					<rich:panel id="pnlSearchResultELPAY13PT" styleClass="sem_autoScrollbar" 
					rendered="#{semmel005Bean.errorCode=='ELPAY13' || 
					semmel005Bean.errorCode=='ELPAY14' || 
					semmel005Bean.errorCode=='ELPAY15' || 
					semmel005Bean.errorCode=='ELPAY16' || 
					semmel005Bean.errorCode=='ELPAY17' || 
					semmel005Bean.errorCode=='ELPAY18'}">
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultFailed}" style="width: 2550"/>
						</f:facet>
						<!-- begin dataTable -->	
											
						<rich:dataTable id="dtbUploadTextELPAY13PT" cellpadding="1" cellspacing="0" border="0" 
						var="uploadText"  value="#{semmel005Bean.uploadTextELPAY13List}" reRender="dtbUploadTextELPAY13PT" 
						rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" reRender="btnCloseJob, pnlSearchResult,btnTruth" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							
							<rich:column sortBy="#{uploadText.seqNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.contractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.oldContractNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.previousContractNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.oldContractNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.electricUseType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUseType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.electricUseType}"/>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.address}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.addr']}" style="width: 250"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.address}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.locationId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationid']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.locationId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 300"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.siteName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.effDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.effDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.expDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.siteStatusDesc}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatusDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.networkStatusDesc}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.meterId}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							
							
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.areaCode}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.region.rowId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.region.rowId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.province.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.province.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.amphur.thaiName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amphur']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.amphur.thaiName}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.meterType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterType']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterType}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.meterRate}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterRate']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterRate}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.pDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtPDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							
							<rich:column sortBy="#{uploadText.lDt}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lDateTH']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.txtLDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.pRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.pRead}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.lRead}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lRead']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.lRead}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.kwhTotal}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.kwhTotal']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.kwhTotal}"/>
								</div>								
							</rich:column>						
													
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invVatAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.invAmt}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>	
							
							
							<rich:column sortBy="#{uploadText.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.errorDesc}"/>
									<h:outputText value="#{uploadText.ownerGroup}"/>
								</div>								
							</rich:column>	
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
										<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch4"/>
									    </a4j:commandButton>
									</div>							
							</rich:column>
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1ViewEL10" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-4" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth10" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billperiodPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
															
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup10" style=" width : 70px;" value="View" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							        oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
										<a4j:actionparam name="fromPage" value="semmel006Page"/>
										<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
										<a4j:actionparam name="groupFlagType" value="UP"/>
										<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>								
							<f:facet name="footer">
							<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextELPAY13List)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="33">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextELPAY13PT"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextELPAY13PT" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>