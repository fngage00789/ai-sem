<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemulticontract-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultilocation-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt015" var="jspMsg"/>
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
											<h:selectOneMenu id="ddlCompany" value="#{semrrt015Bean.company}" >
												<a4j:support event="onchange" reRender="pnlGridSearchCriteria" action="#{semrrt015Action.clearSessionNotUsed}"/>
												<f:selectItems value="#{semrrt015Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right">
						               		<h:outputText id="labelSiteContract" value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
						             	</td>
										<td align="left" colspan="3">
											<rich:spacer width="7px"></rich:spacer>
											<h:panelGrid id="criSiteContractMultiZone" 
														 columns="2" columnClasses="ms7">
													<a4j:region>
													<h:selectManyListbox id="criSiteContract" 
																	 size="#{popupSiteMultiContractBean.delListSize/7}" 
																	 value="#{popupSiteMultiContractBean.delList}"
																	 onchange="renderContract();"
																	 disabled="#{semrrt015Bean.company eq null}">
													<a4j:jsFunction name="renderContract" reRender="criSiteContract"/>
									        		<f:selectItems value="#{popupSiteMultiContractBean.selectedList}"/>
									    			</h:selectManyListbox>
									    			</a4j:region>
												<h:panelGroup>
													<a4j:commandButton id="btnAddSiteContractMultiZone" styleClass="rich-button"
																	   value="..." action="#{navAction.navi}"
																	   reRender="popupSiteContract" 
																	   oncomplete="#{rich:component('popupSiteContract')}.show(); return false" 
																	   disabled="#{semrrt015Bean.company eq null}">
									            		
									            		<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
														<a4j:actionparam name="company" value="#{semrrt015Bean.company}" />
												    </a4j:commandButton>&nbsp;
													<a4j:commandButton id="btnDelSiteContractMultiZone" styleClass="rich-button"
																	   value=" - " action="#{navAction.navi}"
																	   reRender="criSiteContractMultiZone, btnDelSiteContractMultiZone" 
																	   disabled="#{popupSiteMultiContractBean.disabledDeleteSiteContractMulti && semrrt015Bean.company eq null}" >
													  	
													  	<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
														<a4j:actionparam name="methodWithNavi" value="doUpdateList" />
													</a4j:commandButton>
												</h:panelGroup>
											</h:panelGrid>
										</td>
										<td/>
										<td/>
										<td/>
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right">										
						               		<h:outputText id="labelSiteLocation" value="#{jspMsg['label.locationId']} :" styleClass="ms7"/>
						             	</td>
										<td align="left" colspan="3">
											<rich:spacer width="7px"></rich:spacer>			
											<h:panelGrid id="criSiteLocationMultiZone" 
														 columns="2" columnClasses="ms7">
												<a4j:region>
												<h:selectManyListbox id="criSiteLocation" 
																	 size="#{popupSiteMultiLocationBean.delListSize/7}" 
																	 value="#{popupSiteMultiLocationBean.delList}" onchange="renderLocation();">
																	 
									        		<f:selectItems value="#{popupSiteMultiLocationBean.selectedList}"/>
									        		<a4j:jsFunction name="renderLocation" reRender="criSiteLocation"/>
									    		</h:selectManyListbox>
									    		</a4j:region>
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
												    </a4j:commandButton>&nbsp;
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
										<td/>
										<td/>
										<td/>
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right">
						               		<h:outputText id="labelSiteRegion" value="#{jspMsg['label.region']} :" styleClass="ms7"/>
						             	</td>
										<td align="left" colspan="3">
											<rich:spacer width="7px"></rich:spacer>
											<h:panelGrid id="criSiteRegionMultiZone" 
														 columns="2" columnClasses="ms7">
													<a4j:region>
													<h:selectManyListbox id="criSiteRegion" 
																	 size="#{popupSiteMultiRegionBean.delListSize/7}" 
																	 value="#{popupSiteMultiRegionBean.delList}" onchange="renderRegion();">
													<a4j:jsFunction name="renderRegion" reRender="criSiteRegion"/>				 
									        		<f:selectItems value="#{popupSiteMultiRegionBean.selectedList}"/>
									    			</h:selectManyListbox>
									    			</a4j:region>
												<h:panelGroup>
													<a4j:commandButton id="btnAddSiteRegionMultiZone" styleClass="rich-button"
																	   value="..." action="#{navAction.navi}"
																	   reRender="popupSiteRegion" 
																	   oncomplete="#{rich:component('popupSiteRegion')}.show(); return false" >
									            		
									            		<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
												    </a4j:commandButton>&nbsp;
													<a4j:commandButton id="btnDelSiteRegionMultiZone" styleClass="rich-button"
																	   value=" - " action="#{navAction.navi}"
																	   reRender="criSiteRegionMultiZone, btnDelSiteRegionMultiZone" 
																	   disabled="#{popupSiteMultiRegionBean.disabledDeleteSiteRegionMulti}" >
													  	
													  	<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
														<a4j:actionparam name="methodWithNavi" value="doUpdateList" />
													</a4j:commandButton>
												</h:panelGroup>
											</h:panelGrid>
										</td>
										<td/>
										<td/>
										<td/>
									</tr>
									
									<tr>
						               	<td align="right">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.asOf']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" colspan="3">
					             			<rich:spacer width="5px"></rich:spacer>
											<rich:calendar id="cldAsOf" locale="th" enableManualInput="true" 
												   value="#{semrrt015Bean.asOf}" datePattern="dd/MM/yyyy" 
												   showWeeksBar="false" showWeekDaysBar="false" showFooter="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   oninputkeyup="this.value = this.value.substring(0, 10);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.asOf']}">
											</rich:calendar>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.runReport']}" 
											   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT015-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT015" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt015Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT015-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT015" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt015Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt015Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
