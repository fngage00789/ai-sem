<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemulticontract-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultilocation-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />
<jsp:include page="../../pages/popup/multivendor-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt012" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" >
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
            	</rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%" border="0">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						
						<h:panelGrid id="pnlGridSearchCriteria" border="0" 
									 cellpadding="0" cellspacing="1"
									 width="90%" >
							<h:panelGroup>
								<table id="dtbSearchCriteria" border="0" 
									   cellpadding="1" cellspacing="1" 
									   width="100%" >
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrrt012Bean.company}" >				
												<f:selectItems value="#{semrrt012Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr>
						               	<td align="right" valign="baseline" style="vertical-align: middle;">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.depositType']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" colspan="3">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneRadio id="ddlDepositType" value="#{semrrt012Bean.depositType}" styleClass="ms7"  >
												<a4j:support event="onclick" action="#{semrrt012Action.checkRadioBtn}" reRender="txtBgNo,ddlBank"/>
												<f:selectItem itemLabel="All" itemValue="01,02"/>
												<f:selectItem itemLabel="BG" itemValue="01"/>
												<f:selectItem itemLabel="Cash" itemValue="02"/>
											</h:selectOneRadio>
					               		</td>
					               		
									</tr>
									
									<tr>
										<td align="right" valign="baseline">
											<h:outputText value="#{jspMsg['label.BGNo']} :" styleClass="ms7"></h:outputText>
										</td>
										<td align="left">
											<h:inputText id="txtBgNo" value="#{semrrt012Bean.bgNumber}" disabled="#{semrrt012Bean.disableBgNo}" />
										</td>
										<td align="right" valign="baseline">
											<h:outputText value="#{jspMsg['label.bank']} :" styleClass="ms7"></h:outputText>
										</td>
										<td align="left">
											<h:selectOneMenu id="ddlBank" value="#{semrrt012Bean.bankCode}" disabled="#{semrrt012Bean.disableBank}">
												<f:selectItems value="#{semrrt012Bean.bankCodeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right" style="vertical-align: top">
						               		<h:outputText id="labelSiteContract" value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
						             	</td>
										<td align="left">
											<h:inputTextarea id="criSiteContractTxtArea" cols="30" rows="4"  value="#{semrrt012Bean.multiContract}"></h:inputTextarea>
										</td>
										<td align="right" style="vertical-align: top">
						               		<h:outputText id="labelVendor" value="#{jspMsg['label.vendor']} :" styleClass="ms7"/>
						             	</td>
										<td align="left">
											<h:inputTextarea id="criVendorMultiZoneTxtArea" cols="30" rows="4" value="#{semrrt012Bean.multiVendor}"></h:inputTextarea>
											
										</td>
										
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right">										
						               		<h:outputText id="labelSiteLocation" value="#{jspMsg['label.locationId']} :" styleClass="ms7"/>
						             	</td>
										<td align="left" >
											<rich:spacer width="7px"></rich:spacer>			
											<h:panelGrid id="criSiteLocationMultiZone" 
														 columns="2" columnClasses="ms7">
												
												<h:selectManyListbox id="criSiteLocation" 
																	  size="#{popupSiteMultiLocationBean.delListSize/7}" styleClass="ms7"
																	 value="#{popupSiteMultiLocationBean.delList}" onchange="renderLocation();">
																	 
									        		<f:selectItems value="#{popupSiteMultiLocationBean.selectedList}"/>
									        		<a4j:jsFunction name="renderLocation" reRender="criSiteLocation"/>
									    		</h:selectManyListbox>
												<h:panelGroup>
													<a4j:commandButton id="btnAddSiteLocationMultiZone" styleClass="rich-button"
																	   value="..." action="#{navAction.navi}"
																	   reRender="popupSiteLocation" 
																	   oncomplete="#{rich:component('popupSiteLocation')}.show(); return false" >
									            		
									            		<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
												    </a4j:commandButton><br/>
													<a4j:commandButton id="btnDelSiteLocationMultiZone" styleClass="rich-button"
																	   value=" - " action="#{navAction.navi}"
																	   reRender="criSiteLocationMultiZone, btnDelSiteLocationMultiZone" 
																	   disabled="#{popupSiteMultiLocationBean.disabledDeleteSiteLocationMulti}" >
													  	
													  	<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
														<a4j:actionparam name="methodWithNavi" value="doUpdateList" />
													</a4j:commandButton>
												</h:panelGroup>
											</h:panelGrid>
										</td>
										<td align="right" style="vertical-align: top">
						               		<h:outputText id="labelSiteRegion" value="#{jspMsg['label.region']} :" styleClass="ms7"/>
						             	</td>
										<td align="left" > 
											<h:inputTextarea id="criSiteRegionMultiZoneTxtArea" cols="30" rows="4" value="#{semrrt012Bean.multiRegion}"></h:inputTextarea>
											
										</td>
									</tr>
									
									<tr>
										<td align="right" valign="baseline">
											<h:outputText styleClass="ms7" value="#{jspMsg['label.expenseType']} :"></h:outputText>
										</td>
										<td align="left" colspan="3">
											<h:selectOneMenu value="#{semrrt012Bean.expenseType}">
												<f:selectItems value="#{semrrt012Bean.expenseTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
										<td align="right" valign="baseline">
											<h:outputText styleClass="ms7" value="#{jspMsg['label.contactStatus']} :"></h:outputText>
										</td>
										<td align="left">
											<h:selectOneMenu value="#{semrrt012Bean.contactStatus}">
												<f:selectItems value="#{semrrt012Bean.contactStatusList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" valign="baseline">
											<h:outputText styleClass="ms7" value="#{jspMsg['label.networkStatus']} :"></h:outputText>
										</td>
										<td align="left" >
											<h:selectOneMenu value="#{semrrt012Bean.networkStatus}">
												<f:selectItems value="#{semrrt012Bean.networkStatusList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
						               	<td align="right">
											<h:outputText value="#{jspMsg['label.depositDateFrom']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" colspan="3">
					             			<rich:spacer width="5px"></rich:spacer>
											<rich:calendar id="payDate" locale="th" enableManualInput="true" 
												   value="#{semrrt012Bean.depositDtFrom}" datePattern="dd/MM/yyyy" 
												   showWeeksBar="false" showWeekDaysBar="false" showFooter="false"
												   inputSize="7"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   oninputkeyup="this.value = this.value.substring(0, 7);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.depositDateFrom']}">
											</rich:calendar> 
											
											<rich:spacer width="100"></rich:spacer>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.depositDateTo']} :" styleClass="ms7"/>
											
											<rich:spacer width="5px"></rich:spacer>
											<rich:calendar id="asOfDate" locale="th" enableManualInput="true" 
												   value="#{semrrt012Bean.depositDtTo}" datePattern="dd/MM/yyyy" 
												   showWeeksBar="false" showWeekDaysBar="false"
												   inputSize="10" 
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   oninputkeyup="this.value = this.value.substring(0, 10);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.depositDateFrom']}">
											</rich:calendar>
					               		</td>
									</tr>
									<tr>
										<td align="right" valign="baseline" style="vertical-align: middle">
											<h:outputText value="#{jspMsg['label.depositStatus']} :" styleClass="ms7" />
										</td>
										<td align="left" colspan="3">
											<h:selectOneRadio value="#{semrrt012Bean.depositStatus}" styleClass="ms7">
												<f:selectItem itemLabel="All"  itemValue="ALL"/>
												<f:selectItem itemLabel="Remain" itemValue="REMAIN"/>
												<f:selectItem itemLabel="Close" itemValue="CLOSE"/>
											</h:selectOneRadio>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.runReport']}" 
											   action="#{navAction.navi}" >
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT012-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT012" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt012Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT012-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT012" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt012Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt012Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
