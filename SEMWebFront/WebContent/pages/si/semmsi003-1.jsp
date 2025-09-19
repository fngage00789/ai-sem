<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.siteinfo.semmsi003" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi003Bean.renderedMsgFormSearch}">
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
				<h:panelGrid width="90%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
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
									<h:selectOneMenu id="ddlCompany" value="#{semmsi003Bean.siteTerminateSP.company}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmsi003Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmsi003Bean.siteTerminateSP.company}" styleClass="ms28"/>
				                	</td>
			                	 </tr>
								<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtDocNo" value="#{semmsi003Bean.siteTerminateSP.docNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNo" value="#{semmsi003Bean.siteTerminateSP.contractNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                			<h:inputText id="txtReqOfficer" value="#{semmsi003Bean.siteTerminateSP.reqOfficer}" 
		                			size="30" maxlength="35"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtTitle" value="#{semmsi003Bean.siteTerminateSP.title}"
		                			size="30" maxlength="35"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.docDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
									<rich:calendar id="cldDocDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmsi003Bean.siteTerminateSP.docDateFrom}"
									   showWeeksBar="false" 
									   inputSize="13" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputkeyup="this.value = this.value.substring(0, 10);"
									   cellWidth="20px" cellHeight="20px"
									   label="#{jspMsg['label.docDate']}"
									   >
									   <a4j:support event="oninputblur" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldDocDateTo">
									   		<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
											<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
									   </a4j:support>
									   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldDocDateTo">
									   		<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
											<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
									   </a4j:support>
									</rich:calendar> 
									<rich:spacer width="2"></rich:spacer>
									<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									<rich:spacer width="2"></rich:spacer>
									<rich:calendar id="cldDocDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmsi003Bean.siteTerminateSP.docDateTo}"
									   showWeeksBar="false"
									   inputSize="13"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputkeyup="this.value = this.value.substring(0, 10);"
									   cellWidth="20px" cellHeight="20px"
									   label="#{jspMsg['label.docDate']}">
										<a4j:support event="oninputblur" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldDocDateTo">
									   		<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
											<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
									   </a4j:support>
									   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldDocDateTo">
									   		<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
											<a4j:actionparam name="methodWithNavi" value="doDefaultDate" />
										</a4j:support>
								</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputText value="Location ID :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semmsi003Bean.siteTerminateSP.locationId}"
		                			size="15" maxlength="12"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationName" value="#{semmsi003Bean.siteTerminateSP.locationName}"
		                			size="30" maxlength="35"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="80%">
		                			<h:selectOneMenu id="ddlRegion" value="#{semmsi003Bean.siteTerminateSP.region}"> 
										<f:selectItems value="#{semmsi003Bean.regionList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,frmConfirmDelDialog" >
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
			           		<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI003-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<h:panelGrid id="grdAddCommand">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" reRender="oppContent" style="width:60">
	            		<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI003-2" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="ADD" />
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1300"/>
						</f:facet>
						 <rich:dataTable width="100%" id="dtbSiteTerminate" cellpadding="1" cellspacing="0" border="0"
							var="siteTerminateSP" value="#{semmsi003Bean.siteTerminateSPList}" reRender="dtbSiteTerminate" 
							rows="#{semmsi003Bean.rowPerPage}" rowClasses="cur"	 styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi003Action.getRowIdOnClick}" reRender="dtbSiteTerminate">
								<a4j:actionparam name="rowId" value="#{siteTerminateSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnEdit" action="#{navAction.navi}" reRender="oppContent,pnlLog"
	            					image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI003-2" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{siteTerminateSP.rowId}"/>
										<a4j:actionparam name="contractNo" value="#{siteTerminateSP.contractNo}"/>
										<a4j:actionparam name="mode" value="EDIT" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDelete" oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI003-1" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{siteTerminateSP.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnView"  action="#{navAction.navi}" image="images/view.png" style="height: 15; width: 15"
	            					reRender="oppContent,pnlLog">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI003-2" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{siteTerminateSP.rowId}"/>
										<a4j:actionparam name="mode" value="VIEW"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.docNo}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column width="5%" sortBy="#{siteTerminateSP.docDate}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docDate']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.docDate}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.reqOfficer}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqOfficer']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteTerminateSP.reqOfficer}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.title}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteTerminateSP.title}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.contractNo}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.locationId}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteTerminateSP.locationName}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteTerminateSP.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{siteTerminateSP.region}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.region}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{siteTerminateSP.networkStatus}" styleClass="#{(semmsi003Bean.tmpRowId==siteTerminateSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteTerminateSP.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>								
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteTerminate" 
									maxPages="10" id="dstSiteTerminate" selectedStyleClass="selectScroll" 
									page="#{semmsi003Bean.scrollerPage}" />
							</f:facet>
						</rich:dataTable>
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
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi003Bean.confirmDeleteMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbSiteTerminate, frmError,mdpConfirmDelDialog" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI003-1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
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