<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/vendorSupplier-popup.jsp" />
<jsp:include page="../../pages/el/semmel006_popupAddVendor.jsp" /> 
<f:loadBundle basename="resources.construction.semmcp001" var="jspMsg"/>
<h:panelGrid width="100%">
<script>
		function switchStatus(){
			var index = document.getElementById('incContent:frmSaveData:ddlConstructType').seletedIndex;
			if(index == 1){
				totStackProcess();
			}else{
				if(index == 2){
					suppStackProcess();
				}
			}
		}
		 
		function totStackProcess(){
			var step = new Array();
			step[0] = document.getElementById('incContent:frmSaveData:cldTOTSupReqDateInputDate');
			step[1] = document.getElementById('incContent:frmSaveData:cldSendTOTDateInputDate');
			step[2] = document.getElementById('incContent:frmSaveData:ddlTOTResultStatus');
			step[3] = document.getElementById('incContent:frmSaveData:cldTOTSendSupDateInputDate');
			step[4] = document.getElementById('incContent:frmSaveData:cldTOTSupReceiveDateInputDate');
			step[5] = document.getElementById('incContent:frmSaveData:cldRejectDateInputDate');
			step[6] = document.getElementById('incContent:frmSaveData:cldClearRejectDateInputDate');
			var i = 0;
			for(i = step.length-1; i >= 0; i--){
				if(step[i].value != ""){
					switch(i){
						case 0: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '01';break;
						case 1: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '02';break;
						case 2: changeItemWithTotStatus();break;
						case 3: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '03';break;
						case 4: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '06';break;
						case 5: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '07';break;
						case 6: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '08';break;
					}
					return true;
				}
			}
		}
	
		function suppStackProcess(){
			var step = new Array();
			step[0] = document.getElementById('incContent:frmSaveData:cldConSupReqDateInputDate');
			step[1] = document.getElementById('incContent:frmSaveData:cldConSendSupDateInputDate');
			step[2] = document.getElementById('incContent:frmSaveData:ddlConResultStatus');
			step[3] = document.getElementById('incContent:frmSaveData:cldRejectDateInputDate');
			step[4] = document.getElementById('incContent:frmSaveData:cldClearRejectDateInputDate');
			var i = 0;
			for(i = step.length-1; i >= 0; i--){
				if(step[i].value != ""){
					switch(i){
						case 0: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '01';break;
						case 1: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '02';break;
						case 2: changeItemWithSuppStatus();break;
						case 3: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '06';break;
						case 4: document.getElementById('incContent:frmSaveData:ddlConstructStatus').value = '07';break;
					}
					return true;
				}
			}
		}

		function changeItemWithTotStatus(){
			var index = new Array(); 
			index[0]='03';
			index[1]='04';
			if(document.getElementById('incContent:frmSaveData:ddlTOTResultStatus').selectedIndex > 0){
				changeItemWithSelectedList('frmSaveData','ddlTOTResultStatus','frmSaveData', 'ddlConstructStatus', index);
				if (document.getElementById('incContent:frmSaveData:ddlTOTResultStatus').selectedIndex == 2){
					document.getElementById('totRemark').style.display = "";
				}else{
					document.getElementById('totRemark').style.display = "none";
				}
			}else{
				totStackProcess();
			}
			return true;
		}

		function changeItemWithSuppStatus(){
			var index = new Array(); 
			index[0]='04';
			index[1]='05';
			if(document.getElementById('incContent:frmSaveData:ddlConResultStatus').selectedIndex > 0){
				changeItemWithSelectedList('frmSaveData','ddlConResultStatus','frmSaveData', 'ddlConstructStatus', index);
				if (document.getElementById('incContent:frmSaveData:ddlConResultStatus').selectedIndex == 2){
					document.getElementById('conRemark').style.display = "";
				}else{
					document.getElementById('conRemark').style.display = "none";
				}
			}else{
				suppStackProcess();
			}
			return true;
		}

		function changeRejectCase(){
   			var _item = document.getElementById('incContent:frmSaveData:ddlConstructType');
	   		if(_item.selectedIndex == 1){
   				changeItemWithIndex('frmSaveData','ddlConstructStatus','07');
   				totStackProcess();
   			}
	   		else{
	   			changeItemWithIndex('frmSaveData','ddlConstructStatus','06');
	   			suppStackProcess();
	   		}
			return true;
	   	}

		function changeClearRejectCase(){
   			var _item = document.getElementById('incContent:frmSaveData:ddlConstructType');
	   		if(_item.selectedIndex == 1){
   				changeItemWithIndex('frmSaveData','ddlConstructStatus','08');
   				totStackProcess();
   			}
	   		else{
	   			changeItemWithIndex('frmSaveData','ddlConstructStatus','07');
	   			suppStackProcess();
	   		}
			return true;
	   	}
	</script>
<rich:panel>
	<f:facet name="header">
		<h:outputText value="#{jspMsg['header.name']}"/>
	</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError2">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmcp001Bean.renderedMsgFormTop}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSaveData">
					<h:panelGrid width="90%" >
						<h:panelGroup>
							<table align="right">
						<tr>
							<td>
							<table>
								<tr>
									<td>
										<a4j:commandButton styleClass="rich-button" id="btnTransfer" value="#{jspMsg['btn.transfer']}"
					                     action="#{navAction.navi}" reRender="oppContent,pnlSearchCriteria,frmAddSiteInfo,frmSiteInfoError,txtOldContractNo,popupTransferDummyContract"
					                     rendered="#{semmcp001Bean.constructionPermissionTransferSP.recordStatus == 'Y'}"
					                     oncomplete="#{rich:component('popupTransferDummyContract')}.show(); return false;">
					                      <a4j:actionparam name="navModule" value="cp" />
					                      <a4j:actionparam name="navProgram" value="SEMMCP001-2" />
					                      <a4j:actionparam name="moduleWithNavi" value="cp" />
					                      <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
					                      <a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
					                      <a4j:actionparam name="fromButton" value="oldContractNo" />
					                    </a4j:commandButton>
									</td>
									<td>
										<a4j:commandButton styleClass="rich-button" id="btnRollBack" value="#{jspMsg['btn.rollBack']}"
					                     action="#{navAction.navi}" reRender="oppContent,pnlSearchCriteria,frmAddSiteInfo,frmSiteInfoError,txtOldContractNo,popupRollBackDummyContract"
					                     rendered="#{semmcp001Bean.constructionPermissionTransferSP.recordStatus == 'N'}"
					                     oncomplete="#{rich:component('popupRollBackDummyContract')}.show(); return false;">
					                      <a4j:actionparam name="navModule" value="cp" />
					                      <a4j:actionparam name="navProgram" value="SEMMCP001-2" />
					                      <a4j:actionparam name="moduleWithNavi" value="common" />
					                      <a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
					                      <a4j:actionparam name="methodWithNavi" value="doSearchContractForRollBack" />
					                      
					                      
					                    </a4j:commandButton>
									</td>
									<td>
										<a4j:commandButton id="btnDocumentContract"  value="#{jspMsg['btn.documentContract']}"
											styleClass="rich-button" action="#{navAction.navi}" reRender="popupDocContractFrm" 
											oncomplete="#{rich:component('popupDocContract')}.show(); return false">
											<a4j:actionparam name="navModule" value="cp" />
											<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
											<a4j:actionparam name="methodWithNavi" value="initPopupDocContract" />
										</a4j:commandButton>
									</td>
									<td align="right" valign="bottom">
										<a4j:commandButton id="btnRun" style="width:130px" styleClass="rich-button"
														   reRender="frmError2"
														   rendered="#{semmcp001Bean.disableBtnConstructStatus and not semmcp001Bean.viewMode}"
														   value="#{jspMsg['btn.printDocTOT']}" 
														   action="#{navAction.navi}">
										
											<a4j:actionparam name="navModule" value="cp" />
											<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
											<a4j:actionparam name="moduleWithNavi" value="report" />
											<a4j:actionparam name="actionWithNavi" value="SEMECP001" />
											<a4j:actionparam name="methodWithNavi" value="doRunReport" />
											
											<a4j:support event="oncomplete" reRender="frmError2, pnlShowReport" rendered="#{semecp001Bean.displayShowReport}"/>
										</a4j:commandButton>
									</td>
									<td align="right" valign="bottom">										
										<a4j:commandButton id="btnPrintPermissionDocNo" style="width:130px" styleClass="rich-button"
														   reRender="frmError2"
														   rendered="#{semmcp001Bean.disableBtnTot and not semmcp001Bean.viewMode}"
														   value="#{jspMsg['btn.printPermissionDoc']}" 
														   action="#{navAction.navi}">
										
											<a4j:actionparam name="navModule" value="cp" />
											<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
											<a4j:actionparam name="moduleWithNavi" value="report" />
											<a4j:actionparam name="actionWithNavi" value="SEMECP002" />
											<a4j:actionparam name="methodWithNavi" value="doRunReport" />
											
											<a4j:support event="oncomplete" reRender="frmError2, pnlShowReport2" rendered="#{semecp002Bean.displayShowReport}"/>
										</a4j:commandButton>
									</td>
								<td align="right" valign="bottom">
										<a4j:commandButton
											id="btnBack" 
											value="#{jspMsg['btn.back']}"
											styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="oppContent">
											<a4j:actionparam name="navModule" value="cp" />
											<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
											<a4j:actionparam name="methodWithNavi" value="doClearSession" />
										</a4j:commandButton>
								</td>
								<td align="right" valign="bottom">
									<a4j:commandButton
										id="btnSave" 
										value="#{jspMsg['btn.save']}"
										styleClass="rich-button" 
										action="#{navAction.navi}"
										rendered="#{not semmcp001Bean.viewMode}"
										reRender="frmError2,frmSaveData,pnlLog,pnlShowNoticeTOT,pnlShowConstructRequest,pnlShowDetailConstruct,pnlShowNoticeReject,btnRun,btnPrintPermissionDocNo,cldCreateDate">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
										<a4j:actionparam name="moduleWithNavi" value="cp" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
										<a4j:actionparam name="methodWithNavi" value="doUpdate" />
										
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							</td>
						</tr>
					</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- ShowReport Panel -->
					<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semecp001Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semecp001Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSaveData:bthShowReport').click();</script>
							</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReport2" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport2" rendered="#{semecp002Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport2" style="height:0px;width:0px;display:none;" action="#{semecp002Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSaveData:bthShowReport2').click();</script>
							</h:panelGroup>							
					</h:panelGrid>
					<!-- End Code -->

					<!-- begin content layout criteria -->
					<h:panelGrid width="90%" id="seGrid">
							<rich:panel id="pnlSearchCriteria">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.detail.construct']}"/>
								</f:facet>
							<!-- begin content criteria -->
							<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
								<table width="100%" >
									<tr valign="bottom">
										<td align="right" width="25%">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td width="25%">
											<h:selectOneMenu id="ddlCompany"
												value="#{semmcp001Bean.constructionPermissionSearchSP.companyCri}" disabled="true">
												<f:selectItems value="#{semmcp001Bean.companyList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="25%">
										</td>
										<td width="25%">
										</td>
									</tr>

									<tr valign="bottom">
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText id="txtcontractNo" value="#{semmcp001Bean.constructionPermissionSearchSP.contractNo}"
												 size="23" maxlength="20" disabled="true"/>
										</td>
										
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="25%">
										<h:inputText id="txtSiteName"
											value="#{semmcp001Bean.constructionPermissionSearchSP.siteName}"
											size="30" maxlength="200" disabled="true"/>
										</td>
									</tr>

									<tr valign="bottom">
										<td width="25%">
										</td>
										<td colspan="3" width="25%">
											<rich:dataTable id="dtbQueryConstructLocationSrch"  cellpadding="1" cellspacing="0" border="0"
												var="queryConstructLocationSearchSP" value="#{semmcp001Bean.constructionPermissionLocationSearchSPList}" reRender="frmSaveData,dstQueryConstructLocationSrch" 
												rows="#{semmcp001Bean.rowPerPage}"
												rowClasses="cur" 
												styleClass="dataTable">
													<a4j:support event="onRowClick"   action="#{semmcp001Action.getRowIdOnClick}" reRender="dtbQueryConstructLocationSrch">
														<a4j:actionparam name="rowId" value="#{queryConstructLocationSearchSP.rowId}" />
													</a4j:support>	
													<rich:column  sortBy="#{queryConstructLocationSearchSP.locationId}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstructLocationSearchSP.rowId)?'onClick':'unClick'}">
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style="width:72px"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{queryConstructLocationSearchSP.locationId}" styleClass="contentform" style="width:72px" />
														</div>
													</rich:column>
													<rich:column  sortBy="#{queryConstructLocationSearchSP.locationName}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstructLocationSearchSP.rowId)?'onClick':'unClick'}">
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:200px"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{queryConstructLocationSearchSP.locationName}" styleClass="contentform" style="width:200px" />
														</div>
													</rich:column>
													<rich:column  sortBy="#{queryConstructLocationSearchSP.region}" styleClass="#{(semmcp001Bean.tmpRowId==queryConstructLocationSearchSP.rowId)?'onClick':'unClick'}">
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.region']}" styleClass="contentform" style="width:60px" />
														</f:facet>
														<div align="center">
																<h:outputText value="#{queryConstructLocationSearchSP.region}" styleClass="contentform" style="width:60px" >
																</h:outputText>
														</div>
													</rich:column>
														
														
											<f:facet name="footer">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbQueryConstructLocationSrch" 
												maxPages="10" id="dstQueryConstructLocationSrch" selectedStyleClass="selectScroll"
												page="#{semmcp001Bean.scrollerPage}"  />
											</f:facet>
											</rich:dataTable>
										</td>
										
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText	value="#{jspMsg['label.siteConstructStatusName']}"	styleClass="ms7" />
									    </td>
										<td width="25%">
												<h:selectOneMenu id="ddlSiteConstructStatus" value="#{semmcp001Bean.constructionPermissionSearchSP.siteConstructStatus}" onchange="expandPanel();"  
												disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}">
														<f:selectItems value="#{semmcp001Bean.siteConstructStatusList}" />
												</h:selectOneMenu>
													<a4j:jsFunction name="expandPanel"  action="#{navAction.navi}" 
													reRender="frmError2,frmSaveData,pnlShowApproveConstruct,ddlConstructType,ddlConstructStatus,pnlShowNoticeReject" >
																<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
																<a4j:actionparam name="moduleWithNavi" value="cp" />
																<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
																<a4j:actionparam name="methodWithNavi" value="expandApprovePanel" />
												   </a4j:jsFunction>
										</td>
										<td align="right" width="25%">
										</td>
										<td width="25%">
										</td>
								 </tr>
								 <tr>
								 	<td align="right">
									 	<h:graphicImage value="images/icon_required.gif"  rendered="#{not semmcp001Bean.nonCostruct}"/>
										<rich:spacer width="5"></rich:spacer>
									 	<h:outputText value="#{jspMsg['label.remarkNoRequest']} :" styleClass="ms7"  rendered="#{not semmcp001Bean.nonCostruct}"/>
								 	</td>
								 	<td colspan="3">
								 		<h:inputTextarea value="#{semmcp001Bean.constructionPermissionSearchSP.remarkNoRequest}" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}" rows="4" cols="60" rendered="#{not semmcp001Bean.nonCostruct}"></h:inputTextarea>
								 	</td>
								 	<td></td>
								 </tr>
							</table>						
									</h:panelGroup>
								</h:panelGrid>
							</rich:panel>
						</h:panelGrid>
					<!-- End content layout criteria -->
						
					
					<!-- Begin Panel ShowAppoveConstruct PopupClass -->	
						<rich:spacer height="3"></rich:spacer>
						<h:panelGrid width="90%">
						<rich:panel id="pnlShowApproveConstruct" rendered="#{semmcp001Bean.constructionPermissionSearchSP.checkExpandPanel}">
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
									<table width="100%" border=0>
												<tr>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText id="txtDocNo" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.docNo}"	size="18" maxlength="15" disabled="true" />
													</td>
													<td align="right" width="25%">
														 <h:graphicImage value="images/icon_required.gif" />
														 <rich:spacer width="5"></rich:spacer>
														 <h:outputText value="#{jspMsg['label.sentDocNoDate']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<rich:calendar id="cldSentDocNoDate" 
						                				 showWeeksBar="false" locale="th/TH" 
						                				 enableManualInput="true" datePattern="dd/MM/yyyy" 
			                							 value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.docDt}" 
			                							 inputSize="13" 
			                							 disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
			                			 				 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														 cellWidth="20px" cellHeight="20px" 
														 label="#{jspMsg['column.header.sentDocNoDate']}"/>
													</td>
												</tr>
			
												<tr>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.project']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText id="txtProject" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.project}"  size="30" maxlength="200" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
													
													<td align="right" width="25%">
													</td>
													<td width="25%">
													</td>
												</tr>
			
												<tr>
													<td align="right" width="25%">
														<h:graphicImage value="images/icon_required.gif" />
														<rich:spacer width="5"></rich:spacer>
														<h:outputText value="#{jspMsg['label.supplier']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:panelGroup>
								                			<h:inputText id="txtSupplier" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorFullName} " onchange="GetLocationListJS();"	readonly="true" disabled="true"	size="30" maxlength="255"/>
								                			<a4j:jsFunction name="GetLocationListJS" reRender="frmSaveData,pnlShowApproveConstruct" />
								                			<rich:spacer width="2"></rich:spacer>
								            				<a4j:commandButton id="btnPopupSearchSupplier"  
								            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
															value="..." 
															disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
															reRender="popupVendorSupplier" 
										            		action="#{navAction.navi}">
											            		<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
																<a4j:actionparam name="moduleWithNavi" value="common" />
																<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																<a4j:actionparam name="popupType" value="SUPPLIER" />
																<a4j:actionparam name="page" value="semmcp001" />
								            				</a4j:commandButton>
						                				</h:panelGroup>
													</td>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.contractPerson']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText id="txtContactName" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.contactName}" size="30"   maxlength="100" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.tel']}" styleClass="ms7"/>
												    </td>
													<td width="25%" colspan="2">
															<h:inputTextarea  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.telephone}" cols="30" rows="3"  disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
													<td align="right" width="25%">
													</td>
													<td width="25%">
													</td>
											 </tr>
											 <tr>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.fax}" size="30"   maxlength="50" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText id="txtEmail"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.email}" size="30" maxlength="50" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
													</td>
													<td width="50%" colspan="3">
														<h:inputTextarea  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.detail}" cols="80" rows="3"  disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
												</tr>
												<tr>
													<td align="right" width="25%">
														<h:graphicImage value="images/icon_required.gif" />
														<rich:spacer width="5"></rich:spacer>
														<h:outputText value="#{jspMsg['label.antennaType']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:selectOneMenu id="ddlAntennaType" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.postType}" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}">
															<f:selectItems value="#{popupVendorSupplierBean.postTypeList}" />
														</h:selectOneMenu>
													</td>
													<td align="right" width="25%">
														<h:graphicImage value="images/icon_required.gif" />
														<rich:spacer width="5"></rich:spacer>
														<h:outputText value="#{jspMsg['label.antennaHeight']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:inputText id="txtAntennaHeight"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.postHeight}" size="13" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
															onblur="return numberformat.moneyFormat(this);"
															onfocus="return numberformat.setCursorPosToEnd(this);"
															maxlength="16"
															styleClass="inputRight">
														<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
														</h:inputText>
														&nbsp;<h:outputText value="#{jspMsg['label.unitAntennaType']}" styleClass="ms7"/>
														
														
													</td>
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
													</td>
													<td width="50%" colspan="3">
														<h:inputTextarea  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.other}" cols="80" rows="3" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
													
												</tr>
												<tr>
													<td align="right" width="25%">
														<h:graphicImage value="images/icon_required.gif" />
														<rich:spacer width="5"></rich:spacer>
														<h:outputText value="#{jspMsg['label.governmentPermission']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:panelGroup>
						                					<h:inputText id="txtLocalName"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorFullNameLocal}" onchange="GetLocationListJS();" 	readonly="false" size="30" maxlength="255" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/> 
									                			<a4j:jsFunction name="GetLocationListJS" reRender="frmSaveData,pnlShowApproveConstruct" />
									                			<rich:spacer width="2"></rich:spacer>
									            				<a4j:commandButton id="btnPopupLocalName"  
									            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
									            				disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
																value="..." 
																reRender="popupVendorSupplier"
											            		action="#{navAction.navi}" >
												            		<a4j:actionparam name="navModule" value="cp" />
																	<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
																	<a4j:actionparam name="moduleWithNavi" value="common" />
																	<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																	<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																	<a4j:actionparam name="popupType" value="LOCAL_DEPART" />
																	<a4j:actionparam name="page" value="semmcp001" />
																	<a4j:actionparam name="provinceId" value="#{semmcp001Bean.constructionPermissionSearchSP.tokenProvince}"/>
									            				</a4j:commandButton>
					                					</h:panelGroup>
													</td>
													<td align="right" width="25%">
													</td>
													<td width="25%">
													</td>
												</tr>
												<tr>
													<td align="right" width="25%">
														<u><h:outputText value="#{jspMsg['label.addressInstitution']}" styleClass="ms7"/></u>
													</td>
													<td width="25%">
													</td>
													<td align="right" width="25%">
													</td>
													<td width="25%">
													</td>
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.houseNo']}" styleClass="ms7"/>
													</td>
													<td width="50%" colspan="3">
														<h:inputTextarea  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.address1}" cols="80" rows="2" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}" />
													</td>
													
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.district']}" styleClass="ms7"/>
													</td>
													<td width="25%" colspan="3">
														<h:inputTextarea  id="txtDistrict"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.address2}" cols="80" rows="2" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
												</tr>
												<tr>
													<td align="right" width="25%" valign="top">
														<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
													</td>
													<td width="25%" colspan="4">
														<h:inputTextarea id="txtProvince"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.city}" cols="80" rows="2" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
													</td>
												</tr>
												<tr>
													<td align="right" width="25%">
														<h:graphicImage value="images/icon_required.gif" />
														<rich:spacer width="5"></rich:spacer>
														<h:outputText value="#{jspMsg['label.constructType']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:selectOneMenu id="ddlConstructType"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.constructType}" 
														 disabled="#{semmcp001Bean.disableConstructType or semmcp001Bean.viewMode or not semmcp001Bean.editable}"
														 onchange="changeDDLConstructionStatus();switchStatus();">  
															<f:selectItems value="#{popupVendorSupplierBean.constructTypeList}"/>
																</h:selectOneMenu>
															<a4j:jsFunction name="changeDDLConstructionStatus" action="#{navAction.navi}"
															 reRender="frmError2,frmSaveData,ddlConstructStatus,pnlShowNoticeTOT,pnlShowConstructRequest,pnlShowDetailConstruct,pnlShowNoticeReject,
															 btnRun,btnPrintPermissionDocNo"  >
																<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
																<a4j:actionparam name="moduleWithNavi" value="cp" />
																<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
																<a4j:actionparam name="methodWithNavi" value="changeCriteriaConstructStatusListDropdownCp002" />
																<a4j:actionparam name="page" value="semmcp001-2" />
																<a4j:actionparam name="dropdownActionStatus" value="Y" />
											   				</a4j:jsFunction>
													</td>
													<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.constructStatus']}" styleClass="ms7"/>
													</td>
													<td width="25%">
														<h:selectOneMenu id="ddlConstructStatus" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.constructStatus}" disabled="true">
															<f:selectItems value="#{popupVendorSupplierBean.constructStatusList}" />
														</h:selectOneMenu>
													</td>
												</tr>
									 </table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
				</h:panelGrid>
			<!-- End Panel ShowAppoveConstruct PopupClass -->	
						
						<!-- Begin Panel Notice TOT แจ้งเพื่อทราบไปยัง TOT -->
					<rich:spacer height="3"></rich:spacer>
					<h:panelGrid width="90%">
					<rich:panel id="pnlShowNoticeTOT" rendered="#{semmcp001Bean.constructionPermissionSearchSP.checkExpandPanelTOT and semmcp001Bean.constructionPermissionSearchSP.checkExpandPanel}">	
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.noticeTOT']}"/>
						</f:facet>
					<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
										<table width="100%" border=0>
													<tr>
														<td align="right" width="25%">
															<h:graphicImage value="images/icon_required.gif" />
															<rich:spacer width="5"/>
															<h:outputText value="#{jspMsg['label.tot_sup_req_dt']}" styleClass="ms7"/>
														</td>
														<td width="25%">
															<rich:calendar id="cldTOTSupReqDate" locale="th" enableManualInput="true" 
														   datePattern="dd/MM/yyyy" 
														   value="#{semmcp001Bean.constructionPermissionSearchSP.tot_sup_req_dt}" 
														   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
														   showWeeksBar="false" 
														   inputSize="13" 
														   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														   cellWidth="20px" cellHeight="20px"
														   oninputblur="totStackProcess();"
											   			   oncollapse="totStackProcess();"
														   label="#{jspMsg['column.header.TOTSupReqDate']}"></rich:calendar>
														</td>
														<td align="right" width="25%">
															<h:graphicImage value="images/icon_required.gif" />
															<rich:spacer width="5"/>
															<h:outputText value="#{jspMsg['label.tot_send_doc_no']}" styleClass="ms7"/>
														</td>
														<td width="25%">
															<h:inputText id="txtTOTSendDocNo"  value="#{semmcp001Bean.constructionPermissionSearchSP.tot_send_doc_no}" size="20" maxlength="20" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
														</td>
													</tr>
				
													<tr>
														<td align="right" width="25%">
															<h:outputText value="#{jspMsg['label.tot_send_tot_dt']}" styleClass="ms7"/>
														</td>
														<td width="25%">
															<rich:calendar id="cldSendTOTDate" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmcp001Bean.constructionPermissionSearchSP.tot_send_tot_dt}" 
															   showWeeksBar="false" 
															   inputSize="13" 
															   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   cellWidth="20px" cellHeight="20px"
															   label="#{jspMsg['column.header.sendTOTDate']}"
															   oninputblur="totStackProcess();"
											   			   	   oncollapse="totStackProcess();"
															   ></rich:calendar>
														</td>
														
														<td align="right" width="25%">
														</td>
														<td width="25%">
														</td>
													</tr>
				
													<tr>
														<td align="right" width="25%">
															<h:outputText value="#{jspMsg['label.tot_return_dt']}" styleClass="ms7"/>
														</td>
														<td colspan="2" width="25%">
															<rich:calendar id="cldReturnDate" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmcp001Bean.constructionPermissionSearchSP.tot_return_dt}" 
															   showWeeksBar="false" 
															   inputSize="13" 
															   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   cellWidth="20px" cellHeight="20px"
															   label="#{jspMsg['column.header.returnDate']}"
															   />
														</td>
														<td width="25%">
														</td>
													</tr>
													<tr>
														<td align="right" width="25%">
															<h:outputText value="#{jspMsg['label.tot_result_status']}" styleClass="ms7"/>	
													    </td>
														<td width="25%">
															<h:selectOneMenu id="ddlTOTResultStatus" value="#{semmcp001Bean.constructionPermissionSearchSP.tot_result_status}" 
															onchange="RenderConstructStatus();totStackProcess();" disabled="#{semmcp001Bean.viewMode or semmcp001Bean.payable or semmcp001Bean.conPayable}">
																<f:selectItems value="#{semmcp001Bean.totResultStatusList}" />
															</h:selectOneMenu>
															<a4j:jsFunction name="RenderConstructStatus" action="#{semmcp001Action.onRenderConstructStatus}" reRender="pnlShowNoticeTOT,txtOutRemar,txtTotRemarkNotAllow,pnlShowApproveConstruct,ddlConstructType,constructGrid,seGrid,pnlShowApproveConstruct,pnlShowDetailConstruct,pnlReject,totRq"/>
														</td>
														<td align="right" width="25%">
														</td>
														<td width="25%">
															
														</td>
												  </tr>
												  <tr id="totRemark" >
														<td align="right"  valign="top">
															<h:outputText id="txtOutRemark" value="#{jspMsg['label.tot_remark_not_allow']}" styleClass="ms7" rendered="#{semmcp001Bean.disablePnlRemarkNotAllow}"/>
													    </td>
														<td colspan="3">
															<h:inputTextarea  id="txtTotRemarkNotAllow" value="#{semmcp001Bean.constructionPermissionSearchSP.tot_remark_not_allow}" cols="80" rows="3" rendered="#{semmcp001Bean.disablePnlRemarkNotAllow}" disabled="#{semmcp001Bean.viewMode}"/>
														</td>
														<td align="right" width="25%">
														</td>
														<td width="25%">
														</td>
												 </tr>
												  <tr id="totRefDocDt" >
														<td align="right"  valign="top">
															<h:graphicImage value="images/icon_required.gif" id="totRqDt" rendered="#{semmcp001Bean.constructionPermissionSearchSP.tot_result_status == '01'}"/>
															<rich:spacer width="5"/>
															<h:outputText id="txtTotRefDocDt" value="#{jspMsg['label.tot_ref_doc_dt']} :" styleClass="ms7" />
													    </td>
														<td>
															<rich:calendar id="cldTOTRefDocDate" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmcp001Bean.constructionPermissionSearchSP.tot_ref_doc_dt}" 
															   disabled="#{semmcp001Bean.viewMode}"
															   showWeeksBar="false" 
															   inputSize="13" 
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
															   cellWidth="20px" cellHeight="20px"
															   label="#{jspMsg['label.tot_ref_doc_dt']}"
															   ></rich:calendar>
														</td>
														<td align="right" width="25%">
															<h:graphicImage value="images/icon_required.gif" id="totRq" rendered="#{semmcp001Bean.constructionPermissionSearchSP.tot_result_status == '01'}"/>
															<rich:spacer width="5"/>
														 	<h:outputText value="#{jspMsg['label.tot_ref_doc_no']}" styleClass="ms7"/>
														</td>
														<td width="25%">
															<h:inputText id="txtTOTRefDocNo"  value="#{semmcp001Bean.constructionPermissionSearchSP.tot_ref_doc_no}" size="20" maxlength="23" disabled="#{semmcp001Bean.viewMode}"/>
														</td>
												 </tr>
												 <tr>
														<td align="right" width="25%">
															<h:outputText value="#{jspMsg['label.tot_send_sup_dt']}" styleClass="ms7"/>
													    </td>
														<td width="25%">
															<rich:calendar id="cldTOTSendSupDate" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmcp001Bean.constructionPermissionSearchSP.tot_send_sup_dt}" 
															   disabled="#{semmcp001Bean.viewMode}"
															   showWeeksBar="false" 
															   inputSize="13" 
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
															   cellWidth="20px" cellHeight="20px"
															   oninputblur="totStackProcess();"
											   			  	   oncollapse="totStackProcess();"
															   label="#{jspMsg['column.header.TOTSendSupDate']}"
															   ></rich:calendar>
														</td>
														<td align="right" width="25%">
														</td>
														<td width="25%">
														</td>
											 </tr>
											 <tr>
											 			<td align="right" width="25%">
															<h:outputText value="#{jspMsg['lebel.totSubReceiveDt']}" styleClass="ms7"/>
													    </td>
														<td width="25%">
															<rich:calendar id="cldTOTSupReceiveDate" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmcp001Bean.constructionPermissionSearchSP.totSubReceiveDt}" 
															   disabled="#{semmcp001Bean.viewMode}"
															   showWeeksBar="false" 
															   inputSize="13" 
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
															   cellWidth="20px" cellHeight="20px"
															   oninputblur="totStackProcess();"
											   			  	   oncollapse="totStackProcess();"
															   label="#{jspMsg['column.header.TotSubReceiveDt']}"
															   ></rich:calendar>
														</td>
														<td align="right" width="25%">
														</td>
														<td width="25%">
														</td>
											 </tr>
									 </table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
				</h:panelGrid>
				<!-- End TOT -->				
						
				<!-- Begin Panel Notice ConStruct Request อนุญาตก่อสร้าง-->
				<h:panelGrid width="90%">
					<rich:panel id="pnlShowConstructRequest" rendered="#{semmcp001Bean.constructionPermissionSearchSP.checkExpandPanelCon and semmcp001Bean.constructionPermissionSearchSP.checkExpandPanel}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.constructReq']}"/>
						</f:facet>
					<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
					<table width="100%"  border="0">
								<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.con_sup_req_dt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldConSupReqDate" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmcp001Bean.constructionPermissionSearchSP.con_sup_req_dt}" 
												   showWeeksBar="false" 
												   inputSize="13" 
												   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												   oninputblur="suppStackProcess();"
											   	   oncollapse="suppStackProcess();"
												   cellWidth="20px" cellHeight="20px"
												   label="#{jspMsg['column.header.conSupReqDate']}"
												   >
												   </rich:calendar>
										</td>
										<td align="right" width="25%">
										</td>
										<td width="25%">
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.con_permission_doc_dt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldConPermissionDocDate" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmcp001Bean.constructionPermissionSearchSP.con_permission_doc_dt}" 
												   showWeeksBar="false" 
												   inputSize="13" 
												   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												   cellWidth="20px" cellHeight="20px"
												   label="#{jspMsg['column.header.conPermissionDocDate']}"
												   >
												   </rich:calendar>
										</td>
										
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.conPermissionDocNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText id="txtConPermissionDocNo" value="#{semmcp001Bean.constructionPermissionSearchSP.con_permission_doc_no}" size="23" maxlength="20" disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"/>
										</td>
									</tr>
									<tr>								
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.con_send_sup_dt']}" styleClass="ms7"/>
										</td>
										<td width="25%" align="left">
											<rich:calendar id="cldConSendSupDate" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmcp001Bean.constructionPermissionSearchSP.con_send_sup_dt}" 
											   showWeeksBar="false" 
											   inputSize="13" 
											   disabled="#{semmcp001Bean.viewMode or not semmcp001Bean.editable}"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.conSendSupDate']}"
											   oninputblur="suppStackProcess();"
											   oncollapse="suppStackProcess();"
											   >
											   </rich:calendar>
										</td>
										<td align="right" width="25%">
										</td>
										<td width="25%" align="left">
										</td>
								</tr>							
								<tr>									
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.con_result_status']}" styleClass="ms7"/>	
									</td>
									<td width="25%" align="left">
										<h:selectOneMenu id="ddlConResultStatus" value="#{semmcp001Bean.constructionPermissionSearchSP.con_result_status}" onchange="RenderConstructStatus();suppStackProcess();" disabled="#{semmcp001Bean.viewMode or semmcp001Bean.payable or semmcp001Bean.conPayable}">
											<f:selectItems value="#{semmcp001Bean.conResultStatusList}" />
										</h:selectOneMenu>	
										<a4j:jsFunction name="RenderConstructStatus" action="#{semmcp001Action.onRenderConstructStatus}" reRender="pnlShowConstructRequest,txtConRemark,ddlConstructType,constructGrid,seGrid,pnlShowApproveConstruct,pnlShowDetailConstruct,pnlReject,conRq"/>
									</td>
									<td align="right" width="25%">
									</td>
									<td width="25%" align="left">
									</td>
								</tr>
								
								<tr>									
									<td align="right" width="25%">
										
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.con_build_doc_dt']} :" styleClass="ms7"/>	
									</td>
									<td width="25%" align="left">
										<rich:calendar id="cldConBuildDocDate" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmcp001Bean.constructionPermissionSearchSP.con_build_doc_dt}" 
											   showWeeksBar="false" 
											   inputSize="13" 
											   disabled="#{semmcp001Bean.viewMode}"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.con_build_doc_dt']}"
											   >
										</rich:calendar>
									</td>
									<td align="right" width="25%">
										
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.con_build_doc_no']}" styleClass="ms7"/>
									</td>
									<td width="25%" align="left">
										<h:inputText id="txtConBuidDocNo"  value="#{semmcp001Bean.constructionPermissionSearchSP.con_build_doc_no}" size="30" disabled="#{semmcp001Bean.viewMode}"/>
									</td>
								</tr>
								<tr id="conRemark">
											<td align="right" width="25%" valign="top">
												<h:outputText id="labelConRemark" value="#{jspMsg['label.tot_remark_not_allow']}" styleClass="ms7"  rendered="#{semmcp001Bean.disablePnlConRemarkNotAllow}"/>
											</td>
											<td width="50%" colspan="3" align="left">
												<h:inputTextarea id="txtConRemark" value="#{semmcp001Bean.constructionPermissionSearchSP.con_remark_not_allow}"  cols="80" rows="3" rendered="#{semmcp001Bean.disablePnlConRemarkNotAllow}" disabled="#{semmcp001Bean.viewMode}"/>
											</td>
										</tr>
								
							</table>
						</h:panelGroup>
					</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- End Panel Notice ConStruct Request อนุญาตก่อสร้าง -->
				
				<!-- Begin Detail construct Request -->
					
				<h:panelGrid width="90%" id="constructGrid" >
					<rich:panel id="pnlShowDetailConstruct" rendered="#{semmcp001Bean.constructionPermissionSearchSP.checkExpandPanelCon and semmcp001Bean.constructionPermissionSearchSP.checkExpandPanel and semmcp001Bean.checkResultChange}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.pnlDetail']}"/>
						</f:facet>
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
					<div align="left">
						<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmcp001Bean.renderedMsgFormMiddle}"/>
					</div>
					<table width="100%"  border="0">
								<tr>
									<td>
										<u><h:outputText value="#{jspMsg['header.pnlDetail']}" styleClass="ms7"/></u>
									</td>
								</tr>
								<tr>									
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.conBillNo']} " styleClass="ms7"/>	
									</td>
									<td width="25%" align="left">
										<h:inputText id="txtConBillNo" value="#{semmcp001Bean.construct.conBillNo}" size="30" disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}"/>
									</td>
									<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.conBillDt']}" styleClass="ms7"/>
									</td>
									<td width="25%">
										<rich:calendar id="cldConBillDt" locale="th" enableManualInput="true" 
										 disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}"
										 datePattern="dd/MM/yyyy" 
										 value="#{semmcp001Bean.construct.conBillDt}" 
										 showWeeksBar="false" 
										 inputSize="13" 
										 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.TotSubReceiveDt']}"
										 >
											<a4j:support event="onchanged" reRender="ddlConstructStatus" action="#{semmcp001Action.onRenderConstructStatus}" />
										</rich:calendar>
									</td>
							  </tr>
							  <tr>
							  		<td align="right" width="25%">
							  			<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.con_bill_amt']}" styleClass="ms7" />
									</td>
									<td width="25%" align="left">
										<h:inputText id="txtConBillAmt" value="#{semmcp001Bean.construct.conBillAmt}"
												 disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}"
		                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                						 onblur="return numberformat.moneyFormat(this);"
		                						 onfocus="return numberformat.setCursorPosToEnd(this);"
		                						 maxlength="16" 
		                						 styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00"/>
				                				</h:inputText>
									</td>
									<td align="right" width="25%">
												<h:graphicImage value="images/icon_required.gif" rendered="false"/>
												<rich:spacer width="5"/>
												<h:outputText value="#{jspMsg['label.con_wbs']}" styleClass="ms7" rendered="false"/>	
											</td>
											<td width="25%" align="left">
												<h:inputText id="txtConWBS" 
												value="#{semmcp001Bean.constructionPermissionSearchSP.con_wbs}" 
												size="30" maxlength="23" rendered="false"
												disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}"/>
											</td>
							  </tr>
							  <tr>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7" rendered="false"/>
												</td>
												<td colspan="3" width="75%">
													<h:selectOneRadio id="optVatType" value="#{semmcp001Bean.construct.conVatType}" styleClass="ms7" onclick="ChangeAmount();" rendered="false">
														<f:selectItem id="vt1" itemLabel="#{jspMsg['label.vatType2']}" itemValue="01" />
														<f:selectItem id="vt2" itemLabel="#{jspMsg['label.vatType3']}" itemValue="02" />
														<f:selectItem id="vt3" itemLabel="#{jspMsg['label.vatType4']}" itemValue="03" />
													</h:selectOneRadio>
													<a4j:jsFunction name="ChangeAmount" action="#{semmcp001Action.onRenderAmount}"  
													 reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt">
													</a4j:jsFunction>
												</td>
										</tr>
										<tr>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
													
																<h:selectOneRadio id="optWhtType" value="#{semmcp001Bean.construct.conWhtType}" styleClass="ms7" rendered="false">
																<f:selectItem id="wht1" itemLabel="#{jspMsg['label.whtType2']}" itemValue="01" />
																<f:selectItem id="wht2" itemLabel="#{jspMsg['label.whtType3']}" itemValue="02" />
																<f:selectItem id="wht3" itemLabel="#{jspMsg['label.whtType4']}" itemValue="03" />
																<a4j:support event="onclick" action="#{semmcp001Action.onRenderAmount}"  
																 reRender="pnlShowDetailConstruct,ddlWhtRate,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt">
																</a4j:support>
																</h:selectOneRadio>	
																	
												</td>
												<td align="right" width="25%">
														<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7" rendered="false"/>		
												</td>
												<td width="25%">
			                						 <h:selectOneMenu id="ddlWhtRate" value="#{semmcp001Bean.construct.conWhtRate}" disabled="#{semmcp001Bean.disableWhtRate}" rendered="false"
			                						  onchange="ChangeAmount();">
														<f:selectItems value="#{semmcp001Bean.whtRateList}"/>
													</h:selectOneMenu>
													<h:outputText value="#{jspMsg['lebel.percecnt']}" styleClass="ms7" rendered="false"/>
													<a4j:jsFunction name="ChangeAmount" action="#{semmcp001Action.onRenderAmount}"  
													 reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt">
													</a4j:jsFunction>
												</td>
										</tr>
										<tr>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.excAmt']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
													<h:inputText id="txtExcAmt" value="#{semmcp001Bean.construct.conExcAmt}" rendered="false"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
			                						 <a4j:support event="onchange" action="#{semmcp001Action.onRenderIncludeAmt}" reRender="txtExcAmt,txtIncAmt,txtChqAmt"></a4j:support>
													<f:convertNumber pattern="#,##0.00"/>
			                						</h:inputText>
												</td>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
													<h:inputText id="txtVatAmt" value="#{semmcp001Bean.construct.conVatAmt}" rendered="false"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
			                						 <a4j:support event="onchange" action="#{semmcp001Action.onRenderIncludeAmt}" reRender="txtExcAmt,txtIncAmt,txtVatAmt"></a4j:support>
													<f:convertNumber pattern="#,##0.00" />
				                					</h:inputText>
												</td>
										</tr>
										<tr>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.incAmt']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
													<h:inputText id="txtIncAmt" value="#{semmcp001Bean.construct.conIncAmt}" disabled="true" rendered="false"
				                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                						 onblur="return numberformat.moneyFormat(this);"
				                						 onfocus="return numberformat.setCursorPosToEnd(this);"
				                						 maxlength="16" 
				                						 styleClass="inputRight">
													<f:convertNumber pattern="#,##0.00"/>
				                					</h:inputText>
												</td>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.whtAmt']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
													<h:inputText id="txtWhtAmt" value="#{semmcp001Bean.construct.conWhtAmt}" rendered="false"
				                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                						 onblur="return numberformat.moneyFormat(this);"
				                						 onfocus="return numberformat.setCursorPosToEnd(this);"
				                						 maxlength="16" 
				                						 styleClass="inputRight">
				                					<a4j:support event="onchange" action="#{semmcp001Action.onRenderTotalAmt}" reRender="txtWhtAmt"></a4j:support>
													<f:convertNumber pattern="#,##0.00"/>
				                					</h:inputText>
												</td>
										</tr>
										<tr>
												<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.chqAmt']}" styleClass="ms7" rendered="false"/>
												</td>
												<td width="25%">
														<h:inputText id="txtChqAmt" value="#{semmcp001Bean.mpt004Cal.chqAmt}" disabled="true" rendered="false"
					                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
					                						 onblur="return numberformat.moneyFormat(this);"
					                						 onfocus="return numberformat.setCursorPosToEnd(this);"
					                						 maxlength="16" 
					                						 styleClass="inputRight">
														<f:convertNumber pattern="#,##0.00"/>
					                					</h:inputText>
												</td>
										</tr>
										<tr>
										</tr>
										<tr>
										</tr>
										<tr>
												<td>
													<u><h:outputText value="#{jspMsg['header.info']}" styleClass="ms7"/></u>
												</td>
										</tr>
										<tr>
											<td align="right" width="25%">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="25%">
					                				<h:selectOneMenu id="ddlPaymentType2" value="#{semmcp001Bean.construct.conPaymentType}" onchange="ChangeDatePaymentType();" disabled="true">
															<f:selectItems value="#{semmcp001Bean.paymentTypeList}"/>
													</h:selectOneMenu>
													<a4j:jsFunction name="ChangeDatePaymentType" action="#{semmcp001Action.onrenderPaymentType}"  
													 reRender="cldChqDt,cldChqReceiveDt,cldTransferDt,ddlPaymentMethod">
															
													</a4j:jsFunction>
							                	</td>
							                	<td align="right" width="25%">
							                		<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="Payment Type :" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<h:selectOneMenu id="ddlPaymentMethod" value="#{semmcp001Bean.construct.conPaymentMethod}" disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}">
														<f:selectItems value="#{semmcp001Bean.paymentMethodList}"/>
													</h:selectOneMenu>
												</td>
										</tr>
										<tr>
							                	<td align="right" width="25%">
								                	<h:panelGroup>
														<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" rendered="false"/>
													</h:panelGroup>
												</td>
					                			<td width="25%">
					                				<h:inputText id="txtBankName" value="" size="18" maxlength="15" rendered="false"
		                							 disabled="true"/>
							                	</td>
							                	<td align="right" width="25%">
							                		<h:panelGroup>
														<h:outputText value="#{jspMsg['label.bankAccNo']}" styleClass="ms7" rendered="false"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<h:inputText id="txtBankAccNo" value="" size="18" maxlength="15" rendered="false"
		                							 disabled="true"/>
												</td>
										</tr>
										<tr>
							                	<td align="right" width="25%">
								                	<h:panelGroup>
														<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="25%">
					                				<rich:calendar id="cldChqDt" 
					                				 showWeeksBar="false" locale="th/TH" 
					                				 enableManualInput="true" datePattern="dd/MM/yyyy" 
		                							 value="#{semmcp001Bean.construct.conChqDt}" 
		                							 inputSize="13" 
		                							 disabled="#{(semmcp001Bean.renderCldChqDt or semmcp001Bean.disablePnlShowDetailConstruct) or semmcp001Bean.viewMode}"
		                			 				 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
		                			 				 oninputblur="if(document.getElementById('incContent:frmSaveData:ddlPaymentMethod').value == '03')
		                			 				 validateRichCalendarFromTo('frmSaveData','cldChqDt','cldChqReceiveDt');"
											   		 oncollapse="if(document.getElementById('incContent:frmSaveData:ddlPaymentMethod').value == '03')
											   		 validateRichCalendarFromTo('frmSaveData','cldChqDt','cldChqReceiveDt');"
													 cellWidth="20px" cellHeight="20px" 
													 label="#{jspMsg['column.header.chqDt']}"
													 > 	
		                			 				 </rich:calendar>		                			 											                			 					
							                	</td>
							                	<td align="right" width="25%">
							                		<h:panelGroup>
														<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<rich:calendar id="cldChqReceiveDt" 
													 showWeeksBar="false" locale="th/TH" 
													 enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmcp001Bean.construct.conChqReceiveDt}" 
						                			 inputSize="13" 
						                			 disabled="#{(semmcp001Bean.renderCldChqDt or semmcp001Bean.disablePnlShowDetailConstruct) or semmcp001Bean.viewMode}"
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			 oninputblur="if(document.getElementById('incContent:frmSaveData:ddlPaymentMethod').value == '03')
						                			 validateRichCalendarFromTo('frmSaveData','cldChqReceiveDtInputDate','cldChqDtInputDate');"
											   		 oncollapse="if(document.getElementById('incContent:frmSaveData:ddlPaymentMethod').value == '03')
											   		 validateRichCalendarFromTo('frmSaveData','cldChqReceiveDtInputDate','cldChqDtInputDate');"
													 cellWidth="20px" cellHeight="20px" 
													 label="#{jspMsg['column.header.chqReceiveDt']}"
													>
														
													</rich:calendar>
												</td>
										</tr>
										<tr>
							                	<td align="right" width="25%">
								                	<h:panelGroup>
														<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7" rendered="false"/>
													</h:panelGroup>
												</td>
					                			<td width="25%" valign="top">
					                				<rich:calendar id="cldTransferDt" 
					                				 showWeeksBar="false" locale="th/TH" 
					                				 enableManualInput="true" 
					                				 datePattern="dd/MM/yyyy" 
						                			 value="#{semmcp001Bean.construct.conTransferDt}" 
						                			 inputSize="13" 
						                			 disabled="#{semmcp001Bean.renderCldTransferDt or semmcp001Bean.viewMode}"
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													 cellWidth="20px" cellHeight="20px" 
													 rendered="false"
													 label="#{jspMsg['column.header.transferDt']}"
													 >
													 	
													 </rich:calendar>
							                	</td>
							            </tr>
										<tr>
											<td align="right" width="25%" valign="top">
							                		<h:panelGroup>
														<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td colspan="3" width="75%">
													<h:inputTextarea id="txtRemark" value="#{semmcp001Bean.construct.conPayRemark}"
													 disabled="#{semmcp001Bean.disablePnlShowDetailConstruct or semmcp001Bean.viewMode}"
		                							 cols="80" rows="3"/>	
												</td>
										</tr>
										<tr>
											<td align="right" width="25%">
													<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
											</td>
											<td width="25%">
													<h:selectOneMenu id="ddlPaymentStatus" value="#{semmcp001Bean.construct.conPaymentStatus}" onchange="paymentChange();" disabled="true">
															<f:selectItems value="#{semmcp001Bean.paymentStatusList}"/>
															<a4j:jsFunction name="paymentChange" action="#{semmcp001Action.paymentChange}" reRender="ddlConResultStatus,ddlTOTResultStatus"></a4j:jsFunction>
													</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td colspan="4" width="100%">
												<a4j:commandButton
													id="btnSavePay" 
													action="#{navAction.navi}"
													value="#{jspMsg['btn.savePay']}"
													disabled="#{semmcp001Bean.disabelBtnSavePay}"
													rendered="#{not semmcp001Bean.viewMode}"
													reRender="frmError2,frmSaveData,pnlLog,pnlShowDetailConstruct,btnSavePay,btnCancleSavePay,ddlPaymentStatus"
													styleClass="rich-button">
														<a4j:actionparam name="navModule" value="cp" />
														<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
														<a4j:actionparam name="moduleWithNavi" value="cp" />
														<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
														<a4j:actionparam name="methodWithNavi" value="doUpdatePay" />
												</a4j:commandButton>
												<rich:spacer width="5"/>
												<a4j:commandButton
													id="btnCancleSavePay" 
													value="#{jspMsg['btn.cancleSavePay']}"
													action="#{navAction.navi}"
													disabled="#{semmcp001Bean.disableBtnCanclePay}"
													reRender="frmError2,frmSaveData,pnlLog,btnSavePay,btnCancleSavePay,ddlPaymentStatus"
													rendered="#{not semmcp001Bean.viewMode}"
													styleClass="rich-button">
														<a4j:actionparam name="navModule" value="cp" />
														<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
														<a4j:actionparam name="moduleWithNavi" value="cp" />
														<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
														<a4j:actionparam name="methodWithNavi" value="doCanclePay" />
												</a4j:commandButton>
											</td>
										</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
				<!-- End -->
				
				<!-- Begin Panel Notice Reject แจ้งระงับ -->
					<rich:spacer height="3"></rich:spacer>
					 <h:panelGrid width="90%" id="pnlReject">
					 <rich:panel id="pnlShowNoticeReject" rendered="#{((not semmcp001Bean.editable) and semmcp001Bean.constructionPermissionSearchSP.checkExpandPanelNoticeReject and semmcp001Bean.constructionPermissionSearchSP.checkExpandPanel) or semmcp001Bean.checkReject}">	
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.noticreject']}"/>
						</f:facet>				
					 <h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
					 <h:panelGroup>
							<table width="100%">
										<tr>
											<td align="right" width="25%">
												<h:outputText value="#{jspMsg['label.rejectDate']}" styleClass="ms7"/>
											</td>
											<td width="25%">
												<rich:calendar id="cldRejectDate" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmcp001Bean.constructionPermissionSearchSP.reject_dt}" 
												   showWeeksBar="false" 
												   disabled="#{semmcp001Bean.viewMode}"
												   inputSize="13" 
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   cellWidth="20px" cellHeight="20px"
												   label="#{jspMsg['column.header.rejectDate']}"
												   oninputblur="changeRejectCase();"
											   	   oncollapse="changeRejectCase();"
												   />
											</td>
											<td align="right" width="25%">
											</td>
											<td width="25%">
											</td>
										</tr>
	
										<tr>
											<td align="right" width="25%">
												<h:outputText value="#{jspMsg['label.rejectOwner']}" styleClass="ms7"/>
											</td>
											<td width="25%">
												<h:inputText id="txtRejectOwner" value="#{semmcp001Bean.constructionPermissionSearchSP.reject_by}" size="30" maxlength="50" disabled="#{semmcp001Bean.viewMode}"/>
											</td>
											
											<td align="right" width="25%">
											</td>
											<td width="25%">
											</td>
										</tr>
	
										<tr>
											<td align="right" width="25%" valign="top">
												<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
											</td>
											<td width="50%" colspan="2">
												<h:inputTextarea  value="#{semmcp001Bean.constructionPermissionSearchSP.reject_remark}" cols="80" rows="3"  disabled="#{semmcp001Bean.viewMode}"/>
											</td>
										</tr>
										<tr>
											<td align="right" width="25%">
												<h:outputText value="#{jspMsg['label.clearRejectDate']}" styleClass="ms7"/>
										    </td>
											<td width="25%">
												<rich:calendar id="cldClearRejectDate" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmcp001Bean.constructionPermissionSearchSP.reject_clear_dt}" 
												   showWeeksBar="false" 
												   disabled="#{semmcp001Bean.viewMode}"
												   inputSize="13" 
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   cellWidth="20px" cellHeight="20px"
												   oninputblur="changeClearRejectCase();"
											   	   oncollapse="changeClearRejectCase();"
												   label="#{jspMsg['column.header.clearRejectDate']}"
												   />
											</td>
											<td align="right" width="25%">
											</td>
											<td width="25%">
											</td>
									 </tr>
									 <tr>
											<td align="right" width="25%" valign="top">
												<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
											</td>
											<td width="50%" colspan="2">
												<h:inputTextarea  value="#{semmcp001Bean.constructionPermissionSearchSP.reject_clear_remark}" cols="80" rows="3"  disabled="#{semmcp001Bean.viewMode}"/>
											</td>
										</tr>									
						 </table>
					</h:panelGroup>
					</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			<!-- End Panel Notice Reject แจ้งระงับ -->
			
			<!-- Buttom -->
				<rich:spacer height="5"></rich:spacer>
				<h:panelGrid width="90%">
					<rich:panel id="pnlLog" >
 					<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
 					  <h:panelGroup>
							<table width="100%" >
			                	 <tr valign="bottom">
									<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%" align="left">
		                				<h:inputText id="txtCreateBy" value="#{semmcp001Bean.constructionPermissionSearchSP.create_by}" 
		                			readonly="true" disabled="true" />
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%" align="left">
										<rich:calendar id="cldCreateDate" locale="th" 
										 datePattern="dd/MM/yyyy HH:mm:ss" 
										 value="#{semmcp001Bean.constructionPermissionSearchSP.create_dt}" 
										 showWeeksBar="false"
										 inputSize="20" 
									     cellWidth="20px" cellHeight="20px" 
									     buttonIcon="/images/hide-button.png"
									     buttonIconDisabled="/images/hide-button.png"
										 disabled="true"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr valign="bottom">
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td>
		                			<td align="left" width="25%">
		                				<h:inputText id="txtUpdateBy" value="#{semmcp001Bean.constructionPermissionSearchSP.update_by}" 
		                			readonly="true" disabled="true" />
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td>
		                			<td  align="left" width="25%">
		                			 <rich:calendar id="cldUpdateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="#{semmcp001Bean.constructionPermissionSearchSP.update_dt}" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
				                	</td>
			                	 </tr>
							</table>						
						 
						</h:panelGroup>
					</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%" >
						<h:panelGroup>
							<table align="right">
						<tr>
							<td>
							<table>
								<tr>
									<td></td>
									<td></td>
									
								<td align="right" valign="bottom">
										<a4j:commandButton
											id="btnBack2" 
											value="#{jspMsg['btn.back']}"
											styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="oppContent">
											<a4j:actionparam name="navModule" value="cp" />
											<a4j:actionparam name="navProgram" value="SEMMCP001-1" />
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
											<a4j:actionparam name="methodWithNavi" value="doClearSession" />
										</a4j:commandButton>
								</td>
								<td align="right" valign="bottom">
									<a4j:commandButton
										id="btnSave2" 
										rendered="#{not semmcp001Bean.viewMode}"
										value="#{jspMsg['btn.save']}"
										styleClass="rich-button" 
										action="#{navAction.navi}" oncomplete="onTopPage()" 
										reRender="frmError2,frmSaveData,pnlLog">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP001-2" />
										<a4j:actionparam name="moduleWithNavi" value="cp" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
										<a4j:actionparam name="methodWithNavi" value="doUpdate" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							</td>
						</tr>
					</table>
						</h:panelGroup>
					</h:panelGrid>
		</a4j:form>	<!--	End frmSaveData -->
		</h:panelGrid>
	<!-- xxx -->	
	</rich:panel>
	<jsp:include page="../../pages/cp/semmcp001-popupDocContract.jsp"/>
	
</h:panelGrid>
<a4j:include id="popUpTransfer"  viewId="../../pages/cp/semmcp001-popupTransfer.jsp" />
