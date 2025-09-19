<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt021" var="jspMsg"/>
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
											<h:selectOneMenu id="ddlCompany" value="#{semrrt021Bean.company}" >
												<f:selectItems value="#{semrrt021Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.month']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtCMonthYear" value="#{semrrt021Bean.monthYear}"
											onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											/>
					               		</td>
					               		
									</tr>		
									<tr>
										<td align="right" width="25%" valign="top">
<!--						               		<h:graphicImage value="images/icon_required.gif"/>-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea id="ddlRegion" value="#{semrrt021Bean.region}" cols="30" rows="5"/>
					               		</td>
					               		<td align="right" width="25%" valign="top">
<!--						               		<h:graphicImage value="images/icon_required.gif"/>-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea id="ddlContractNo" value="#{semrrt021Bean.contractNo}" cols="30" rows="5"/>
					               		</td>
									</tr>							
									
									
									<tr>
						               	<td align="right" width="25%" valign="top">
<!--						               		<h:graphicImage value="images/icon_required.gif"/>-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlContractStatus" value="#{semrrt021Bean.contractStatus}">
												<f:selectItems value="#{semrrt021Bean.contractStatusList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>	
									
									<tr>
						               	<td align="right" width="25%" valign="top">
						               		<h:selectBooleanCheckbox id="chDiff1" value="#{semrrt021Bean.checkDiff1}" >
				                				<a4j:support event="onclick" reRender="rbtDiff1"/>
											</h:selectBooleanCheckbox>
		                				</td>
					             		<td align="left" width="25%">
					             			<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.diff1']}" styleClass="ms7"/>
					               		</td>
					               		<td align="right" width="25%" valign="top" style="display: none">
						               		<h:selectBooleanCheckbox id="chDiff2" value="#{semrrt021Bean.checkDiff2}" >
				                				<a4j:support event="onclick" reRender="rbtDiff2"/>
											</h:selectBooleanCheckbox>
		                				</td>
					             		<td align="left" width="25%" style="display: none">
					             			<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.diff2']}" styleClass="ms7"/>
					               		</td>
									</tr>
									<tr>
										<td/>
										<td align="left" width="25%">
											<h:selectOneRadio id="rbtDiff1" value="#{semrrt021Bean.diff1}" layout="pageDirection" styleClass="ms7" rendered="true" disabled="#{!semrrt021Bean.checkDiff1}">
		                    					<f:selectItem  itemValue="ALL" itemLabel="#{jspMsg['label.all']}"/>
		                    					<f:selectItem itemValue="NODIFF" itemLabel="#{jspMsg['label.noDiff']}"/>
		                    					<f:selectItem itemValue="DIFF" itemLabel="#{jspMsg['label.diff']}"/>
		                    				</h:selectOneRadio>	
										</td>
										<td/>
										<td align="left" width="25%" style="display: none">
											<h:selectOneRadio id="rbtDiff2" value="#{semrrt021Bean.diff2}" layout="pageDirection" styleClass="ms7" rendered="true" disabled="#{!semrrt021Bean.checkDiff2}">
		                    					<f:selectItem  itemValue="ALL" itemLabel="#{jspMsg['label.all']}"/>
		                    					<f:selectItem itemValue="NODIFF" itemLabel="#{jspMsg['label.noDiff']}"/>
		                    					<f:selectItem itemValue="DIFF" itemLabel="#{jspMsg['label.diff']}"/>
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
											   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT021-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT021" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt021Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT021-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT021" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt021Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt021Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
