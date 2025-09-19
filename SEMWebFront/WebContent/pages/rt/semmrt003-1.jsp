<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		
		<h:panelGroup style="width:100%;">
		
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormTop}">
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
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mrt003_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmrt003Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
                              <a4j:actionparam name="navModule" value="rt" />
                              <a4j:actionparam name="navProgram" value="SEMMRT001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="rt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                        
                          </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
        </h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						
						<!-- begin content criteria -->
						<center>
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
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
	                				<td colspan="3" valign="bottom" align="left">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmrt003Bean.rentalPayNormalSearchSP.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmrt003Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmrt003Bean.rentalPayNormalSearchSP.company}" styleClass="ms28"/>
				                	</td>
								</tr>
								<tr>
									<td align="right" width="20%">
									<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.jobType']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:selectOneMenu id="ddlJobType" value="#{semmrt003Bean.rentalPayNormalSearchSP.jobType}">
											<f:selectItems value="#{semmrt003Bean.jobTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</h:panelGroup>
									</td>
		                			<td width="30%" align="left">
		                				<h:selectOneMenu id="ddlRegion" value="#{semmrt003Bean.rentalPayNormalSearchSP.region}">
											<f:selectItems value="#{semmrt003Bean.regionList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:selectOneMenu id="ddlPaymentStatus" value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentStatus}"
		                				onchange="reRenderRcptPayChkBox();">
											<f:selectItems value="#{semmrt003Bean.paymentStatusList}"/>
										</h:selectOneMenu>
										
										<!-- fixed by.. YUT 2014/09/16 >> -->
										<a4j:jsFunction name="reRenderRcptPayChkBox" reRender="rcptPayChkBox" oncomplete="rcptChk();"></a4j:jsFunction>
										<script type="text/javascript">
											function rcptChk(){
												jQuery(function($) {
													var payStat = $('#incContent\\:frmSearch\\:ddlPaymentStatus');
													var payChk = $('#incContent\\:frmSearch\\:rcptPayChkBox');
		
													if(payStat.val() != '13') {
														payChk.attr('checked', false);
													} 
												});
											}
										</script>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="rcptPayChkBox" value="#{semmrt003Bean.rentalPayNormalSearchSP.chkRcptPay}"   
										disabled="#{semmrt003Bean.rentalPayNormalSearchSP.paymentStatus == '13' ? false : true}"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paySome']}" styleClass="ms7"/>
										<!-- fixed by.. YUT 2014/09/16 << -->
		                			</td>
		                			<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentType}">
											<f:selectItems value="#{semmrt003Bean.paymentTypeList}"/>
										</h:selectOneMenu>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="20%" align="left">
		                				<rich:calendar id="cldDueDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt003Bean.rentalPayNormalSearchSP.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.dueDtFrom']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   >
										</rich:calendar>
			                			<rich:spacer width="5"/>
			                			<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
			                			<rich:spacer width="5"/>
			                			<rich:calendar id="cldDueDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt003Bean.rentalPayNormalSearchSP.dueDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.dueDtTo']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   >
										</rich:calendar>
				                	</td>
				                	<td align="right">
		                				<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
		                			</td>
		                			<td align="left">
		                				<a4j:region>
			                				<h:inputText id="txtBatchNo" value="#{semmrt003Bean.rentalPayNormalSearchSP.batchNo}"/>			                				
		                				</a4j:region>
		                			</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtContractNo" value="#{semmrt003Bean.rentalPayNormalSearchSP.contractNo}"
		                			 	size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtSiteName" value="#{semmrt003Bean.rentalPayNormalSearchSP.siteName}" size="30" maxlength="200"/>	
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.locationid']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtLocationId" value="#{semmrt003Bean.rentalPayNormalSearchSP.locationId}"
		                			 	size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.locationcode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtLocationCode" value="#{semmrt003Bean.rentalPayNormalSearchSP.locationCode}" size="30" maxlength="200"/>	
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.sitecode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtSiteCode" value="#{semmrt003Bean.rentalPayNormalSearchSP.siteCode}"
		                			 	size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.createby']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:inputText id="txtCreateBy" value="#{semmrt003Bean.rentalPayNormalSearchSP.createBy}" size="30" maxlength="200"/>	
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
		                				<h:selectOneMenu id="ddlSiteType" value="#{semmrt003Bean.rentalPayNormalSearchSP.siteType}">
											<f:selectItems value="#{semmrt003Bean.siteTypeList}"/>
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="picoSelect" value="#{semmrt003Bean.rentalPayNormalSearchSP.chkPico}"/>
										<rich:spacer width="5"/>
										<h:outputText value="PICO" styleClass="ms7"/>
									</td>
									<td width="20%">
										<h:outputText value="" styleClass="ms7"/>
									</td>
									<td width="30%" align="left">
										<h:selectOneRadio id="selectPAction" value= "#{semmrt003Bean.rentalPayNormalSearchSP.pAction}" styleClass="ms7" >
										<f:selectItem itemValue="1" itemLabel="#{jspMsg['label.send']}"/>							
										<f:selectItem itemValue="2" itemLabel="#{jspMsg['label.exportCheq']}"/>
										<a4j:support event="onclick" action="#{semmrt003Action.onRerenderExportChq}" reRender="idExportCheck"></a4j:support>
										</h:selectOneRadio>
									
										<h:selectBooleanCheckbox id="idExportCheck" value= "#{semmrt003Bean.rentalPayNormalSearchSP.pExportChq}" disabled="#{semmrt003Bean.disableExportChq}"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.notExport']}" styleClass="ms7" />
									</td>
				                </tr>
				                <tr>
				                	<td width="20%">
										<h:outputText value="" styleClass="ms7"/>
									</td>
				                	<td colspan="3" align="left">
										 <h:selectBooleanCheckbox id="chkHistoryFlag" value="#{semmrt003Bean.rentalPayNormalSearchSP.historyFlag}" 
		                				styleClass="ms7"/>
				                		<h:outputText value="#{jspMsg['label.history']}" styleClass="ms7" />
									 </td>
				                </tr>
				                <tr>
				                	<td colspan="4" align="left">
				                		<rich:simpleTogglePanel id="pnlSubSearch"  switchType="client" label="#{jspMsg['header.criteria.name2']}" 
				                		opened="false" width="100%">
				                			<table align="center">
				                				<tr>
							                	 	<td align="right" width="20%">
														<h:outputText value="#{jspMsg['label.expensivtType']}" styleClass="ms7"/>
						                			</td>
						                			<td colspan="3" align="left">
						                				<h:selectOneMenu id="semmrt003_ddlExpenseType" value="#{semmrt003Bean.rentalPayNormalSearchSP.expenseTypeSch}">
															<f:selectItems value="#{semmrt003Bean.rentalPayExpenseTypeList}"/>
														</h:selectOneMenu>
						                			</td>
												</tr>
							                	<tr>
							                	 	<td align="right" width="20%">
							                	 		<h:outputText value="#{jspMsg['lebal.vendorId']}" styleClass="ms7"/>
							                	 	</td>
							                	 	<td width="30%" align="left">
							                	 		<h:inputText id="txtvendorId" value="#{semmrt003Bean.rentalPayNormalSearchSP.vendorId}" 
							                	 		style="margin-right:5px;" size="23" maxlength="20"/>
							                	 		
							                	 		<!-- >> fixed by.. YUT 2015/10/18 -->
							                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
											            action="#{semmrt003Action.initAddVendor}" reRender="oppContent"
											            oncomplete="#{rich:component('mrt003PopUp_addVendor')}.show(); return false">
														</a4j:commandButton>
							                			<!-- << -->	
							                	 	</td>
							                	  	<td align="right" width="20%">
							                	  		<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
							                	  		<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
							                	  	</td>
							                	  	<td width="30%" align="left">
							                	  		<h:inputText id="txtvendorName" value="#{semmrt003Bean.rentalPayNormalSearchSP.vendorNameSch}" size="30" maxlength="200"/>
							                	  	</td>
												 </tr>
												 <tr>
												 <td align="right" width="20%">
												 <h:outputText value="#{jspMsg['label.bank']}" styleClass="ms7"/>
												 </td>
												 <td width="30%" align="left">
												 	<h:selectOneMenu id="ddlPaymentMethod" value="#{semmrt003Bean.rentalPayNormalSearchSP.bank}">
															<f:selectItems value="#{semmrt003Bean.paymentList}"/>
														</h:selectOneMenu>
												 </td>
												 <td align="right" width="20%">
												 	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
							                	  	<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
							                	  </td>
							                	  <td width="30%" align="left">
							                	  <h:inputText id="txtDocNo" value="#{semmrt003Bean.rentalPayNormalSearchSP.docNo}" size="30" maxlength="200"/>
							                	  </td>
												 </tr>
												 <tr>
												 <td align="right" width="20%">
												 <h:outputText value="#{jspMsg['label.paymentDt']}" styleClass="ms7"/>
												 </td>
												 <td width="30%" align="left">
												 	<rich:calendar id="cldPaymentDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentDt}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			  label="#{jspMsg['column.header.chqDt']}">
						            
						                			 </rich:calendar>
						                			 
						                			 <rich:spacer width="5"/>
						                			 <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
						                			 <rich:spacer width="5"/>
						                			 <rich:calendar id="cldPaymentToDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentToDt}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			  label="#{jspMsg['column.header.chqDt']}">
						            
						                			 </rich:calendar>
												 	
												 </td>	
												 <td align="right" width="20%">
												 	<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
												 </td>
												 <td width="30%" align="left">
												 	<rich:calendar id="cldChqReceiveDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.chqReceiveDtSch}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			 label="#{jspMsg['column.header.chqReceiveDt']}">
						                			</rich:calendar>
						                			<rich:spacer width="5"/>
						                			 <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
						                			 <rich:spacer width="5"/>
						                			 <rich:calendar id="cldChqReceiveToDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.chqReceiveToDtSch}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			 label="#{jspMsg['column.header.chqReceiveDt']}">
						                			</rich:calendar>
												</td>					 
											</tr>
						                	<tr>
							           			<td align="right" width="20%">
												 	<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
												</td>
												<td width="30%" align="left">
												 	<h:selectOneMenu id="ddlSiteStatus" value="#{semmrt003Bean.rentalPayNormalSearchSP.siteStatusSch}">
														<f:selectItems value="#{semmrt003Bean.siteStatusList}"/>
													</h:selectOneMenu>
												</td>
												<td align="right" width="20%">
												  	<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="ms7"/>
												</td>	
												<td width="30%" align="left">
												 	<h:selectOneMenu id="ddlNetworkStatus" value="#{semmrt003Bean.rentalPayNormalSearchSP.networkStatusSch}">
														<f:selectItems value="#{semmrt003Bean.networkStatusList}"/>
													</h:selectOneMenu>
												</td>
											</tr>
											<tr>
						                	 	<td align="right" width="20%">
						                	 		<h:outputText value="" styleClass="ms7"/>
						                	 	</td>
						                	 	<td width="30%" align="left">
												 	<h:selectBooleanCheckbox value= "#{semmrt003Bean.rentalPayNormalSearchSP.pendingStatus}"/><rich:spacer width="5"/>
													<h:outputText value="#{jspMsg['label.pending']}" styleClass="ms7" />
													<h:selectBooleanCheckbox value= "#{semmrt003Bean.rentalPayNormalSearchSP.expireStatus}"/><rich:spacer width="5"/>
													<h:outputText value="#{jspMsg['label.expire']}" styleClass="ms7" />
											 	</td>
											 	<td align="right" width="20%">
						                	 		<h:outputText value="" styleClass="ms7"/>
						                	 	</td>
											 	<td align="left">
											 		<h:selectBooleanCheckbox id="idNoPayuCheck" value= "#{semmrt003Bean.rentalPayNormalSearchSP.noPayFlag}" />
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsg['label.noPay']}" styleClass="ms7" />
											 	</td>
						                	 </tr>
											 <tr>
											 	<td align="right" width="20%">
							                		<h:outputText value="#{jspMsg['label.paymentRequestDt']}" styleClass="ms7"/>
							                	</td>
							                	<td align="left" colspan="3" align="left">
													<rich:calendar id="cldPaymentRequestDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentRequestDtSch}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			 label="#{jspMsg['column.header.paymentRequestDt']}">
						                			</rich:calendar>
						                			<rich:spacer width="5"/>
						                			 <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
						                			 <rich:spacer width="5"/>
						                			 <rich:calendar id="cldPaymentRequestToDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentRequestToDtSch}" inputSize="13" 
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
						                			 label="#{jspMsg['column.header.paymentRequestDt']}">
						                			</rich:calendar>
							                	</td>
											</tr>
				                		</table>
				                		</rich:simpleTogglePanel>
				                	</td>
				                </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						</center>
						<!-- end content criteria -->
						
						<div style="clear:both; height:10px;"></div>
						
						<center>
						<h:panelGroup id="grdSearchCommand" style="width:96%;">
		           			<table width="100%">
		           				<tr>
		           					<td>
										<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlInitSearchResult">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
											</a4j:commandButton>
										<rich:spacer width="5" />
										<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="pnlSearchResult,pnlSearchCriteria,btnExport,
													btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
													btnApprove,btnReject,btnExport,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt">
						           			<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
											<a4j:actionparam name="methodWithNavi" value="doClearSession" />
						           		</a4j:commandButton>
					           		</td>
		           					<td align="right">
							        	<a4j:commandButton id ="btnExportReport" 
						           		 styleClass="rich-button" value="#{jspMsg['btn.exportReport']}"
						           		 action="#{semmrt003Action.initExportExcelReport}"
						           		 style="width:130" 							           		 
						           		 reRender="frmError">
						           		 <a4j:support event="oncomplete" reRender="frmError,pnlShowExcelReport" rendered="#{semmrt003Bean.displayShowExcelReport}"/>
				            			</a4j:commandButton>
							        	
							        	<h:panelGrid id="pnlShowExcelReport" style="height:0px;width:0px;" width="0px" columns="0" >
											<h:panelGroup id="pnlInShowExcelReport" rendered="#{semmrt003Bean.displayShowExcelReport}" style="height:0px;width:0px;" >
												<h:commandButton value="Report" id ="btnExcelReport" action="#{semrrt024Action.runReport}"
								           		 style="height:0px;width:0px;display:none;" rendered="#{semmrt003Bean.displayShowExcelReport}">
						            			</h:commandButton>								
												<script>document.getElementById('incContent:frmSearch:btnExcelReport').click();</script>
											</h:panelGroup>							
										</h:panelGrid>
							        </td>
					        	</tr>
				        	</table>
		           		</h:panelGroup>
						</center>
						
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<h:panelGrid width="100%">
				<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormBottom}"/>
				</div>
				
				<table style="vertical-align: bottom;">
							<tr>
								<td>
								</td>
								<td>
								</td>
								<td>
									<a4j:commandButton id ="btnExport" 
					           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
					           		 action="#{semmrt003Action.initExportExcel}"
					           		 disabled="#{semmrt003Bean.disabledBtnExport}"
					           		 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] and semmrt003Bean.renderedBtnHExport or semmrt003Bean.renderedOnToDoList}"
					           		 reRender="frmError" style=" width : 70px;">
					           		 <a4j:support event="oncomplete" reRender="frmError,pnlShowExcel" rendered="#{semmrt003Bean.displayShowExcel}"/>
			            			</a4j:commandButton>
			            			
			            			<a4j:commandButton id ="btnExport3" 
					           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
					           		 action="#{navAction.navi}"
					           		 disabled="#{semmrt003Bean.disabledBtnExport}"
					           		 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] and semmrt003Bean.renderedBtnExportShowError}"
					           		 reRender="frmError" style=" width : 70px;">
					           		 <a4j:actionparam name="navModule" value="rt" />
									 <a4j:actionparam name="navProgram" value="SEMMRT003-1" />
									 <a4j:actionparam name="moduleWithNavi" value="rt" />
									 <a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
									 <a4j:actionparam name="methodWithNavi" value="onRenderMsgErrorExoprt" />
			            			</a4j:commandButton>
			            			
					           		<a4j:commandButton id ="btnExpor2" action="#{navAction.navi}"
					           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
					           		 rendered="#{semmrt003Bean.renderedBtnA4JExport}"
					           		 reRender="frmError" style=" width : 70px;">
					           		 <a4j:support reRender="txtError"></a4j:support>
		          		 			 <a4j:actionparam name="navModule" value="rt" />
									 <a4j:actionparam name="navProgram" value="SEMMRT003-1" />
									 <a4j:actionparam name="moduleWithNavi" value="rt" />
									 <a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
									 <a4j:actionparam name="methodWithNavi" value="onRenderMsgExoprt" />
			            			</a4j:commandButton>
			            			
			            			<rich:spacer width="5"/>
			            			
			            			<a4j:commandButton id ="btnExportRemark" 
					           		 styleClass="rich-button" value="#{jspMsg['btn.exportRemark']}"
					           		 action="#{semmrt003Action.initExportRemarkExcel}"
					           		 disabled="#{semmrt003Bean.disabledBtnExport}"
                                     rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedBtnHExport or semmrt003Bean.renderedOnToDoList}"
					           		 reRender="frmError" style=" width : 100px;">
					           		 <a4j:support event="oncomplete" reRender="frmError,pnlShowExcel" rendered="#{semmrt003Bean.displayShowExcel}"/>
			            			</a4j:commandButton>
			            			
			            			<rich:spacer width="5"/>
			            			
			            			<a4j:commandButton id="btnExportLetterId" value="Export Letter" styleClass="rich-button" 
			            			 disabled="#{semmrt003Bean.disabledBtnExport}"
                                     rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedBtnHExport or semmrt003Bean.renderedOnToDoList}"
                                     action="#{navAction.navi}" reRender="frmError,pnlShowReportEpt"
                                     style=" width : 100px;">
	                                  <a4j:actionparam name="navModule" value="rt" />
	                                  <a4j:actionparam name="navProgram" value="SEMMRT003-1" />
	                                  <a4j:actionparam name="moduleWithNavi" value="rt" />
	                                  <a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
	                                  <a4j:actionparam name="methodWithNavi" value="doExportLetter" />
                                    </a4j:commandButton>
								</td>
							</tr>
							<tr style="vertical-align: bottom;">
								<td>
									<a4j:commandButton id="btnTotalAmt" value="#{jspMsg['btn.totalDisbursement']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
									 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:72"
									 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="AG" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnCancleTotalAmt" value="#{jspMsg['btn.cancleTotalDisbursement']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
									 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
									 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="CG" />
					           		</a4j:commandButton>
					           		<rich:spacer width="15"/>
					           		
					           		<a4j:commandButton id="btnSendReam" value="#{jspMsg['btn.sendReam']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
					           		 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:62"
					           		 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="AP" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnCancleSendReam" value="#{jspMsg['btn.cancleSendReam']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
									 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
									 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
										<a4j:actionparam name="btnStatus" value="CP" />
					           		</a4j:commandButton>
					           		<rich:spacer width="15"/>
					           		
					           		<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
					           		 oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
					           		  action="#{navAction.navi}" reRender="popupApproveRentalPayNormal" 
					           		  rendered="#{semmrt003Bean.rendererSSO['btnSMBAP001'] or semmrt003Bean.renderedOnToDoList}">
					           		  	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="initApprove" />
										<a4j:actionparam name="btnApproveStatus" value="AA" />			           		 
									</a4j:commandButton>
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
									 style="width:75px;" oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
					           		  action="#{navAction.navi}" reRender="popupApproveRentalPayNormal" 
					           		  rendered="#{semmrt003Bean.rendererSSO['btnSMBAP001'] or semmrt003Bean.renderedOnToDoList}">
					           		  	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="initApprove" />
										<a4j:actionparam name="btnApproveStatus" value="CA" />	
					           		</a4j:commandButton>
					           		<rich:spacer width="15"/>
					           		
					           		<a4j:commandButton id="btnCopyDate" value="#{jspMsg['btn.copyDate']}" styleClass="rich-button"  style="width:125" action="#{navAction.navi}"
					           		 reRender="frmConfirmCoppyDateDialog,mdpConfirmCoppyDateDialog1,mdpConfirmCoppyDateDialog2"
					           		 rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}"
					           		 oncomplete="if(#{semmrt003Bean.popupClose == 'true' && semmrt003Bean.popupName == 'mdpConfirmCoppyDateDialog1'}){
					           		 				#{rich:component('mdpConfirmCoppyDateDialog1')}.show(); return false}
					           		 			 if(#{semmrt003Bean.popupClose == 'true' && semmrt003Bean.popupName == 'mdpConfirmCoppyDateDialog2'}){
					           		 				#{rich:component('mdpConfirmCoppyDateDialog2')}.show(); return false}">
					           		 				
					           		 				<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
													<a4j:actionparam name="methodWithNavi" value="initCoppyDate" />
					           		</a4j:commandButton>
			           			</td>
			           			<td>
									<rich:spacer width="10"/>
								</td>
			           			<td>
			           				<a4j:commandButton id="btnPrint" styleClass="rich-button"
	           						   reRender="frmError, frmSearchResult"
	           						   disabled="#{semmrt003Bean.disabledBtnExport}"
	           						   value="#{jspMsg['btn.print']}" 
	           						   action="#{navAction.navi}"
	           						   rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}" style=" width : 70px;">
							
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT003RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport" rendered="#{semmrt003RPTBean.displayShowReport}"/>
							</a4j:commandButton>
							<rich:spacer width="5"/>
			           		
			           		<h:commandButton value="#{jspMsg['btn.exportchq']}" 
					           	styleClass="rich-button"  style=" width : 100px;" action="#{semmrt003Action.doExportCheq}" 
					           	disabled="#{semmrt003Bean.disabledBtnExport}" rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001'] or semmrt003Bean.renderedOnToDoList}">
					        </h:commandButton>
					        
					        <rich:spacer width="5"/>
					        
	            			<a4j:commandButton id="btnSMS" value="#{jspMsg['btn.sms']}" styleClass="rich-button"
							style="width:80px" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
							rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001']}"
							disabled="#{semmrt003Bean.disableSMSBtn}">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
								<a4j:actionparam name="methodWithNavi" value="doSendSMS" />
							</a4j:commandButton>
							<rich:spacer width="5"/>
							<a4j:commandButton id="btnEMAIL" value="#{jspMsg['btn.email']}" styleClass="rich-button"
							style="width:85px;" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
							rendered="#{semmrt003Bean.rendererSSO['btnSMBPY001']}"
							disabled="#{semmrt003Bean.disableSMSBtn}">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
								<a4j:actionparam name="methodWithNavi" value="doSendEmail" />
							</a4j:commandButton>
			           			</td>
			           		</tr>
						</table>
				
				<!-- ShowReport Panel -->
					<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReport" rendered="#{semmrt003RPTBean.displayShowReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmrt003RPTAction.showReport}"  />								
							<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
				
				    <h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExcel" rendered="#{semmrt003Bean.displayShowExcel}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id ="btnExcel" action="#{semmrt003Action.doExportExcel}"
			           		 style="height:0px;width:0px;display:none;" rendered="#{semmrt003Bean.displayShowExcel}">
	            			</h:commandButton>								
							<script>document.getElementById('incContent:frmSearchResult:btnExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
					    <h:panelGroup id="pnlInShowReportEpt" rendered="#{semmrt003Bean.displayReportFlag}" style="height:0px;width:0px;" >
					        <h:commandButton value="Report" id="bthShowReportEpt" style="height:0px;width:0px;display:none;" action="#{semmrt003Action.doExportExcelLetter}"  />                              
					        <script>document.getElementById('incContent:frmSearchResult:bthShowReportEpt').click();</script>
					    </h:panelGroup>                         
					</h:panelGrid>
				<!-- End Code -->					
				
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="100%" style="margin: 0 auto;padding: 0px;">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" style="margin: 0 auto;padding: 0px;">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" />
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="margin: 0 auto;padding: 0px;color:red;size:20px" value="#{semmrt003Bean.msgDataNotFound}" rendered="#{semmrt003Bean.renderedMsgDataNotFound}" />
						</div>
												
						 <rich:dataTable id="dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
							var="rentalPayNormalSP" value="#{semmrt003Bean.rentalPayNormalSearchSPList}" reRender="dstRentalPayNormalSrch" 
							rows="#{semmrt003Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							
							<rich:column styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<a4j:region>
									<h:selectBooleanCheckbox style="width: 20" value="#{semmrt003Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmrt003Action.selectAllRow}" reRender="frmSearchResult,dtbRentalPayNormalSrch,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
										btnApprove,btnReject,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnExpor2"/>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<div align="center">
									<a4j:region>
									<h:selectBooleanCheckbox id="chkSelect"  value="#{rentalPayNormalSP.checkBox}" rendered="#{rentalPayNormalSP.dataObj.renderColumn}">
										<a4j:support event="onclick" action="#{semmrt003Action.onRenderExportButton}" reRender="btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
										btnApprove,btnReject,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnExpor2,frmSearchResult">
											<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</div>
							</rich:column>
							<rich:column id="hlkSavePay" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt003Bean.renderer['btnEdit'] or semmrt003Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:75px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkInitSavePay" value="#{jspMsg['label.cLink']}" oncomplete="#{rich:component('popupRentalPayNormal')}.show(); return false"
									 reRender="popupFrmSave" action="#{navAction.navi}" >
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>	
										<a4j:actionparam name="paymentGroupNo" value="#{rentalPayNormalSP.dataObj.paymentGroupNo}"/>
										<a4j:actionparam name="statusEdit" value="savePay"/>	
										<a4j:actionparam name="vendorMasterId" value="#{rentalPayNormalSP.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="payeeId" value="#{rentalPayNormalSP.dataObj.payeeId}"/>
										<a4j:actionparam name="expenseType" value="#{rentalPayNormalSP.dataObj.expenseType}"/>
										<a4j:actionparam name="contractNo" value="#{rentalPayNormalSP.dataObj.contractNo}"/>
										<a4j:actionparam name="periodNo" value="#{rentalPayNormalSP.dataObj.periodNo}"/>										
										<a4j:actionparam name="pageStatus" value="SavePay"/>
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="pay" sortBy="#{rentalPayNormalSP.dataObj.statusPay}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="" styleClass="ms7" />
								</f:facet>
								<div align="center" style="width:25">
									<h:outputText value="#{rentalPayNormalSP.dataObj.statusPay}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="btnEdit" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt003Bean.renderer['btnEdit'] or semmrt003Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;" oncomplete="#{rich:component('popupEditRentalPayNormal')}.show(); return false"
									 action="#{navAction.navi}" reRender="popupFrmEdit" >
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>
										<a4j:actionparam name="vendorCode" value="#{rentalPayNormalSP.dataObj.vendorCode}"/>
										<a4j:actionparam name="vendorName" value="#{rentalPayNormalSP.dataObj.vendorName}"/>
										<a4j:actionparam name="payeeIdPop" value="#{rentalPayNormalSP.dataObj.payeeId}"/>
										<a4j:actionparam name="payeeName" value="#{rentalPayNormalSP.dataObj.payeeName}"/>
										<a4j:actionparam name="expenseTypePop" value="#{rentalPayNormalSP.dataObj.expenseType}"/>
										<a4j:actionparam name="rentalDetailId" value="#{rentalPayNormalSP.dataObj.rentalDetailId}"/>
										<a4j:actionparam name="pageStatus" value="initEdit"/>	
										<a4j:actionparam name="expenseDesc" value="#{rentalPayNormalSP.dataObj.expenseDesc}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.contractNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt003Bean.renderer['hlkSavePay'] or semmrt003Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:50px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{rentalPayNormalSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.oldContractNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.oldContractNo']}" styleClass="contentform" style="width:60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView2" value= "#{rentalPayNormalSP.dataObj.oldContractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentBatchNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.batchNo']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentBatchNo}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="210" sortBy="#{rentalPayNormalSP.dataObj.siteName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<a4j:commandLink id="hypRentalPayPopup" value="#{rentalPayNormalSP.dataObj.siteName}" 
										oncomplete="#{rich:component('popupfrmRentalPay')}.show(); return false"
										action="#{navAction.navi}" reRender="frmRentPayPopup">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="rentalPay-popup" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupRentalPay" />
										<a4j:actionparam name="methodWithNavi" value="initPopupRental" />
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
									</a4j:commandLink>
										
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.effDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDtNew']}"   styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.effDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDtnew']}" styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueDtNew']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expenseTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseDesc']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expenseDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.serviceName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.service']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.serviceName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allowtype']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypPopApproveType" value= "#{rentalPayNormalSP.dataObj.reqType}" 
										oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
										 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="sIdHistory" value="#{rentalPayNormalSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>			
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.verdorId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodY}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriod']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payPeriod}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform"  style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentRequestDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentRequestDt']}" styleClass="contentform"  style="width:100px"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentRequestDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankName}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="PaymentType" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqDtDisplayStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqReceiveDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqReceiveDtDisplayStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.transferDt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.transferDtDisplayStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.depositAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.depositAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.depositAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pettyAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colEditRemark" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnEditRemark" image="images/edit.png" style="height: 15; width: 15;" oncomplete="#{rich:component('popupEditRentalPayNormalRemark')}.show(); return false"
									 action="#{navAction.navi}" reRender="popupFrmRemark,pnlPopupRentalPayNormalRemark,pnlPopupRentalPayNormalRemarkOther" >
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doInitEditRemark" />	
										<a4j:actionparam name="remark" value="#{rentalPayNormalSP.dataObj.remark}"/>
										<a4j:actionparam name="remarkOther" value="#{rentalPayNormalSP.dataObj.remarkOther}"/>
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>	
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remarkVerify}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkVerify']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remarkVerify}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remarkPending}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkPending']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remarkPending}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remark}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remarkOther}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remarkOther']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remarkOther}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.docSettingDebt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCreate']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.docSettingDebt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.docCuttingDebt}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCut']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									
									<!-- fixed by.. YUT 2014/09/16 >> -->
									<a4j:commandLink id="hlkCutting" value="#{rentalPayNormalSP.dataObj.docCuttingDebt}" action="#{navAction.navi}" 
										reRender="common_popupCuttingFormSave, frmError-common_popupCutting"
									 	oncomplete="#{rich:component('common_popupCuttingForm')}.show(); return false" >

											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="paramPaymentId" value="#{rentalPayNormalSP.dataObj.rowId}" />
											<a4j:actionparam name="paramPaymentStatus" value="#{rentalPayNormalSP.dataObj.paymentStatus}" />
											<a4j:actionparam name="paramPaymentRemark" value="#{rentalPayNormalSP.dataObj.remark}" />
											<a4j:actionparam name="paramRcptPayCutAmount" value="#{rentalPayNormalSP.dataObj.rcptPayCutAmount}" />
											
											<a4j:actionparam name="paramFwdNavModule" value="rt" />
											<a4j:actionparam name="paramFwdNavAction" value="SEMMRT003" />
											<a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
									</a4j:commandLink>
									<!-- fixed by.. YUT 2014/09/16 << -->
									
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.docCancel}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCancel']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.docCancel}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.receiptNo}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.receiptno']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.receiptNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.contFlowStatus}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contflowstatus']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.contFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>

							<!-- fixed by.. YUT 2014/09/30 >> -->
							<rich:column  styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform"  style="width:100px;"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.sendInfoStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<!-- fixed by.. YUT 2014/09/30 << -->
							
							<!-- fixed by.. YUT 2014/09/16 >> -->
							<rich:column  styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.notDisbursed']}" styleClass="contentform"  style="width:100px;"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="notDisbursedBtn"
										disabled="#{!(semmrt003Bean.rentalPayNormalSearchSP.paymentStatus eq '01' or semmrt003Bean.rentalPayNormalSearchSP.paymentStatus eq '14')}"
										action="#{navAction.navi}" 
										reRender="ddlDisbursedStatusList,    common_popupFrmNotDisbursed, frmError-common_popupNotDisbursed,
										pnlReloadAfterUpdStatusNDisb"
										value="#{jspMsg['btn.notDisbursed']}" styleClass="rich-button" style="width:110px;"
										oncomplete="#{rich:component('common_popupNotDisbursedForm')}.show(); return false" >
										
					           		  		<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
											<a4j:actionparam name="methodWithNavi" value="initPopupNotDisbursed" />
											<a4j:actionparam name="paramPaymentId" value="#{rentalPayNormalSP.dataObj.rowId}" />
											<a4j:actionparam name="paramPaymentStatus" value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentStatus}" />
											<a4j:actionparam name="paramPaymentRemark" value="#{rentalPayNormalSP.dataObj.remark}" />
											
											<a4j:actionparam name="paramFwdNavModule" value="rt" />
											<a4j:actionparam name="paramFwdNavAction" value="SEMMRT003" />
											<a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<!-- fixed by.. YUT 2014/09/16 << -->
							
							<rich:column  styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnUploadPicture"
										action="#{navAction.navi}"
										reRender="oppContent,popupUploadPictureCriteria"
										value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
										oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
										<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value="RTP"/>
										<a4j:actionparam name="contractNo" value="#{rentalPayNormalSP.dataObj.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							
							<f:facet name="footer">
							
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt003Bean.rentalPayNormalSearchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="46">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPayNormalSrch"
											maxPages="#{semmrt003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentalPayNormalSrch" 
											style="background-color: #cccccc;"
											page="#{semmrt003Bean.scrollerPage}">
										<a4j:support event="onclick"  reRender="frmSearchResult"></a4j:support>
										</rich:datascroller>
										
									</rich:column>
								</rich:columnGroup>		
										
							</f:facet>
						</rich:dataTable>
						
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout data grid -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="96%" style="display:none;">
					<rich:panel id="pnlInitSearchResult">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
							 <!--<rich:messages id="errorMsgMid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt002Bean.renderedMsgFormMiddle}">
							 		<f:facet name="header">
			                        	<h:outputText value="Entered Data Status:"></h:outputText>
			                    	</f:facet>
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:messages>
						
						 -->
						 <div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt003Bean.msgDataNotFound}" rendered="#{semmrt003Bean.renderedMsgDataNotFound2}" />
						</div>
						 <rich:dataTable id="dtbRentalPaySSrch" cellpadding="1" cellspacing="0" border="0"
						    reRender="dstRentalPaySSrch" rows="5"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						    var="rentalPaySSP" value="#{semmrt003Bean.rentalPaySSearchSpList}">
							<rich:column  sortBy="#{rentalPaySSP.jobType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.jobType']}" style="width:72px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySSP.jobType}" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySSP.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySSP.company}" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySSP.regionName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.regionName']}" style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySSP.regionName}"/>
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{rentalPaySSP.payTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paytotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.payTotal}"  />
								</div>
							</rich:column>			 	
							<rich:column  sortBy="#{rentalPaySSP.noPayTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.nonPayTotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.noPayTotal}" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySSP.grandTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.grandTotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.grandTotal}" />
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt003Bean.rentalPaySSearchSpList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPaySSrch"
											maxPages="#{semmrt003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentalPaySSrch" 
											style="background-color: #cccccc;"
											page="#{semmrt003Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
			</h:panelGrid>
			
			<jsp:include page="../../pages/rt/semmrt003-popupSavePay.jsp"/>
			<jsp:include page="../../pages/popup/rentalPay-popup.jsp"/>
		</h:panelGrid>
		
		</h:panelGroup>
		
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmConfirmCoppyDateDialog">
<rich:modalPanel id="mdpConfirmCoppyDateDialog1" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmrt003Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch,pnlSearchResult,frmSearchResult">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />
							<rich:componentControl for="mdpConfirmCoppyDateDialog1" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" >
						    <rich:componentControl for="mdpConfirmCoppyDateDialog1" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmCoppyDateDialog2" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmrt003Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="5" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch,pnlSearchResult,frmSearchResult">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="N" />						
							<rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>	
						<rich:spacer width="5"/>											
						<a4j:commandButton value="Copy All" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch,pnlSearchResult">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
							
						
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
</a4j:form>


<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
<jsp:include page="../../pages/rt/semmrt003-popupCutting.jsp" />
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>
<jsp:include page="../../pages/rt/semmrt003-popup.jsp"/>


<jsp:include page="../../pages/popup/common-popupCutting.jsp"/>