<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt005" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchRentalPlan">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												rendered="#{semmrt005Bean.renderedMsgFormSearch}">
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
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
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
			                			<td width="80%" valign="bottom">
										<h:selectOneMenu id="ddlCompany" value="#{semmrt005Bean.rpCriteria.company}" onchange="GetCompany2JS();">
											<f:selectItems value="#{semmrt005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompany2JS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmrt005Bean.rpCriteria.company}" styleClass="ms28"/>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.planType']}" styleClass="ms7"/>
										</td><td width="80%">
											<h:selectOneRadio id="rbtPlanType" styleClass="ms7" 
												value="#{semmrt005Bean.rpCriteria.planType}">
												<f:selectItem itemValue="New" itemLabel="#{jspMsg['label.new']}"/>
												<f:selectItem itemValue="Renew" itemLabel="#{jspMsg['label.reNew']}"/>
											</h:selectOneRadio>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
										</td><td width="80%">
											<h:selectOneMenu id="ddlYear" value="#{semmrt005Bean.rpCriteria.planYear}">
												<f:selectItems value="#{semmrt005Bean.yearList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="80%">
											<h:selectOneMenu id="ddlRegion" value="#{semmrt005Bean.rpCriteria.region}">
												<f:selectItems value="#{semmrt005Bean.regionList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchRentalPlan,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbrentalPlan">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
			            	
			            	
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			
			
				<!-- begin content button -->
				<h:panelGrid columns="2" id="grdActionCommand">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" 
						styleClass="rich-button" style="width: 100px" action="#{navAction.navi}"
						oncomplete="#{rich:component('popupRentalPlan')}.show(); return false" 
						reRender="popupRentalPlan,frmSearch,popupFrmSave,frmResult" rendered="#{semmrt005Bean.renderer['btnNew']}">
						<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT005-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
						<a4j:actionparam name="methodWithNavi" value="initPopup" />
						<a4j:actionparam name="mode" value="ADD" />
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
			</a4j:form>
			
			<a4j:form id="frmResult">
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1000"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt005Bean.msgDataNotFound}" rendered="#{semmrt005Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbrentalPlan" cellpadding="1" cellspacing="0" border="0" 
							var="rentalPlan"  value="#{semmrt005Bean.rpList}" reRender="dtbrentalPlan" 
							rows="#{semmrt005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmrt005Action.getRowIdOnClick}" reRender="dtbrentalPlan">
								<a4j:actionparam name="rowId" value="#{rentalPlan.rowId}" />
							</a4j:support>
							<!-- begin column -->
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" width="5%" 
								rendered="#{semmrt005Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="Edit" style="width: 40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										action="#{navAction.navi}" title="edit" 
										oncomplete="#{rich:component('popupRentalPlan')}.show(); return false" 
										reRender="popupRentalPlan" id="btnEdit">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT005-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPlan.rowId}"/>
										<a4j:actionparam name="mode" value="EDIT"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" width="5%" 
								rendered="#{semmrt005Bean.renderer['btnDelete']}">
								<f:facet name="header">
									<h:outputText value="Delete" style="width: 40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   action="#{navAction.navi}"  image="images/delete.png" style="height: 15; width: 15;" 
     									   title="delete" id="btnDelete">
										<a4j:actionparam name="navModule" value="rt" />
		            					<a4j:actionparam name="navProgram" value="SEMMRT005-1" />	
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{rentalPlan.rowId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" 
								sortBy="#{rentalPlan.planYear}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.year']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPlan.planYear}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" 
								sortBy="#{rentalPlan.region}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPlan.region}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" 
								sortBy="#{rentalPlan.siteTotal}" 
								rendered="#{semmrt005Bean.rpCriteria.planType == 'New'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteTotal']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPlan.siteTotal}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" 
								sortBy="#{rentalPlan.planAmt}" 
								rendered="#{semmrt005Bean.rpCriteria.planType == 'New'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.amount']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPlan.planAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt005Bean.tmpRowId==rentalPlan.rowId)?'onClick':'unClick'}" 
								sortBy="#{rentalPlan.percentGrowth}" 
								rendered="#{semmrt005Bean.rpCriteria.planType == 'Renew'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.growth']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPlan.percentGrowth}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt005Bean.rpList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="3">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbrentalPlan"
											maxPages="#{semmrt005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstrentalPlan" 
											style="background-color: #cccccc;"
											page="#{semmrt005Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
		<jsp:include page="../../pages/rt/semmrt005-popup.jsp" />
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmrt005Bean.txtContent}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="dtbrentalPlan,frmError" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />							
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