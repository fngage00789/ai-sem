<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt016" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages globalOnly="true" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green"/>
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
											<h:selectOneMenu id="ddlCompany" value="#{semrrt016Bean.company}" >
												<f:selectItems value="#{semrrt016Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.year']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlYear" value="#{semrrt016Bean.year}" >
												<f:selectItems value="#{semrrt016Bean.yearList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:outputText value="#{jspMsg['label.month']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlMonth" value="#{semrrt016Bean.month}" >
												<f:selectItems value="#{semrrt016Bean.monthList}"/>
											</h:selectOneMenu>
					               		</td>
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
												
													<h:selectManyListbox id="criSiteRegion" 
																	 size="7" styleClass="ms7"
																	 value="#{popupSiteMultiRegionBean.delList}" >
																	 
									        		<f:selectItems value="#{popupSiteMultiRegionBean.selectedList}"/>
									    		</h:selectManyListbox>
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
						               	<td align="right" width="25%" valign="baseline">
											<h:outputText value="#{jspMsg['label.costCenter']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtCostCenter" value="#{semrrt016Bean.costCenter}" ></h:inputText>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:outputText value="#{jspMsg['label.glCode']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtGlCode" value="#{semrrt016Bean.glCode}" ></h:inputText>
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
								<a4j:actionparam name="navProgram" value="SEMRRT016-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT016" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt016Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT016-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT016" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt016Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt016Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
