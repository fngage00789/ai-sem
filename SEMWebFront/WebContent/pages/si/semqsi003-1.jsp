<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
	
<f:loadBundle basename="resources.siteinfo.semqsi003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
		<h:outputText value="#{jspMsg['header.name']}"/>
	</f:facet>
	<h:panelGrid>
		<a4j:form id="frmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
		</a4j:form>
	</h:panelGrid>
<h:panelGrid columnClasses="gridContent" width="100%">
<!-- begin content layout criteria -->
	<h:panelGrid width="96%">
	<a4j:form id="frmSearch" ajaxSubmit="true">
		<rich:panel id="pnlSearchCriteria">
			<f:facet name="header">
				<h:outputText value="#{jspMsg['header.criteria.name']}"/>
			</f:facet>
			<!-- begin content criteria -->
			<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table width="100%" border="0">
			                	  <tr>
									<td align="right" width="20%" style="width:209px">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
			                		 <h:inputText id="txtcontractNo"  value="#{semqsi003Bean.querySiteManagementSearchSP.contractNo}"size="23" maxlength="20"/>
				                	</td>
				                	<td  width="20%">
		                			</td>
		                			<td >
		                				
				                	</td>
			                	 </tr>
			                	  <tr>
			                	  </tr>
			                	  <tr>				                			                			
			                	  </tr>
			                	  <tr>			                	 
								  </tr>
								  <tr>
								 </tr>
								 <tr>
								 </tr>
							</table>
				</h:panelGroup>
			</h:panelGrid>
			
			<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMQSI003-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMQSI003" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							 
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			           		<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMQSI003-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMQSI003" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
			           		
						</h:panelGrid>
							</rich:panel>
						</a4j:form>
					</h:panelGrid>
					
						<a4j:form id="frmSearchResult">	
							<!-- begin content layout data grid-->
							<h:panelGrid  width="90%">
							<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
								<f:facet name="header" >
									<h:outputText value="#{jspMsg['header.resultTable.name']}"  style="width:400px"/>
								</f:facet>
							
							 <rich:dataTable id="dtbQuerySiteManagementSrch"    cellpadding="1" cellspacing="0" border="0"
								var="querySiteManagementSearchSP" value="#{semqsi003Bean.querySiteManagementSearchSPList}" reRender="dstQuerySiteManagemantSrch" 
								rows="#{semqsi003Bean.rowPerPage}"
								styleClass="dataTable">
								
								<rich:column  sortBy="#{querySiteManagementSearchSP.taskName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.taskName']}" styleClass="contentform" style="width:150px"/>
									</f:facet>
									<div align="center">
											<h:outputText value="#{querySiteManagementSearchSP.taskName}" styleClass="contentform"  style="width:150px"  />
									</div>
								</rich:column>
								<rich:column  sortBy="#{querySiteManagementSearchSP.recordStatus}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.recordStatus']}" styleClass="contentform"  style="width:150px" />
									</f:facet>
									<div align="center">
											<h:outputText value="#{querySiteManagementSearchSP.recordStatus}" styleClass="contentform"  style="width:150px"  />
									</div>
								</rich:column>
								
								<rich:column  sortBy="#{querySiteManagementSearchSP.recordStatusDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.recordStatusDt']}" styleClass="contentform" style="width:100px"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{querySiteManagementSearchSP.recordStatusDt}" styleClass="contentform" style="width:100px" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
								<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbQuerySiteManagementSrch" 
									maxPages="10" id="dstQuerySiteManagemantSrch" selectedStyleClass="selectScroll" />
							</f:facet>
							
							</rich:dataTable>
							</rich:panel>
						</h:panelGrid>	
						<!-- End  -->
						</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
