<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.co.semmco003" var="jspMsg"/>

<h:panelGrid width="100%">
	<rich:panel id="pnlBorrowRequest">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco003Bean.renderedMsgFormSearch}">
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
				<h:panelGrid width="96%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
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
		                			<td width="80%" colspan="3" valign="bottom">
									<h:selectOneMenu id="ddlCompany" value="#{semmco003Bean.criteria.company}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmco003Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmco003Bean.criteria.company}" styleClass="ms28"/>
				                	</td>
			                	 </tr>
								 <tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                				<h:inputText label="#{jspMsg['label.docNo']}" id="txtDocNo" value="#{semmco003Bean.criteria.docNo}" />
	                				</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                				<h:inputText label="#{jspMsg['label.contractNo']}" id="txtContractNo" value="#{semmco003Bean.criteria.contractNo}" />
	                				</td>
			                	 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch" >
							<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	  action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchRS">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<h:panelGrid id="grdAddCommand">
				<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="40%">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.newDocNo']}" styleClass="rich-button"
					oncomplete="#{rich:component('popupAddBorrowContract')}.show(); return false"  
	            	action="#{navAction.navi}" reRender="popupAddBorrowContract,popupFrmAddContractStatus" 
	            	style="width:120" rendered="#{semmco003Bean.renderer['btnNew']}">
	            		<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO003-1" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
						<a4j:actionparam name="methodWithNavi" value="initAddBorrowContract" />

					</a4j:commandButton>
	            	
					</td>
					<td align="left" width="60%">
				
					</td>
					</tr>
					</table>
				</h:panelGroup>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				<h:panelGrid  width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1080"/>
						</f:facet>
 						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco003Bean.msgDataNotFound}" rendered="#{semmco003Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbBorrowRequest" cellpadding="1" cellspacing="0" border="0"
							var="borrowSP" value="#{semmco003Bean.borrowRequestSPList}" reRender="dtbBorrowRequest" 
							rows="#{semmco003Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<rich:column styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmco003Bean.renderer['btnEdit']}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
						            <a4j:commandButton id="btnEdit"
										image="images/edit.png" style="height: 15; width: 15"
										oncomplete="#{rich:component('popupAddBorrowContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupAddBorrowContract,popupFrmAddContractStatus,popupFrmError">	
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-2" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="editBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.rowId}"/>
										<a4j:actionparam name="docNo" value="#{borrowSP.dataObj.docNo}"/>
										<a4j:actionparam name="company" value="#{borrowSP.dataObj.company}"/>
										<a4j:actionparam name="mode" value="EDIT" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmco003Bean.renderer['btnDelete']}">
								<f:facet name="header" >
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDelete" 
	            						oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false"
	            						image="images/delete.png" style="height: 15; width: 15"
	            						action="#{navAction.navi}" >
	            						<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-1" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteRequest" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmco003Bean.renderer['btnView']}">
								<f:facet name="header" >
									<h:outputText value="View" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView" 
										image="images/view.png" style="height: 15; width: 15"
										oncomplete="#{rich:component('popupAddBorrowContract')}.show(); return false"  
						            	action="#{navAction.navi}" reRender="popupAddBorrowContract">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-2" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="editBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.rowId}"/>
										<a4j:actionparam name="docNo" value="#{borrowSP.dataObj.docNo}"/>
										<a4j:actionparam name="company" value="#{borrowSP.dataObj.company}"/>
										<a4j:actionparam name="mode" value="VIEW" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="" styleClass="contentform" style="width: 60"/>
								</f:facet>
								<div align="center">
	            				<a4j:commandLink id="btnBorrow" value="#{jspMsg['btn.borrow']}"
	            					action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="doInitBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.rowId}"/>
										<a4j:actionparam name="docNo" value="#{borrowSP.dataObj.docNo}"/>
										<a4j:actionparam name="company" value="#{borrowSP.dataObj.company}"/>
										<a4j:actionparam name="siteNum" value="#{borrowSP.dataObj.siteNum}"/>
										<a4j:actionparam name="mode" value="EDIT"/>
	            				</a4j:commandLink>		
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="#{jspMsg['btn.borrow']}" styleClass="contentform" style="width: 60"/>
								</f:facet>
								<div align="center">
	            				<a4j:commandButton id="btnViewBorrow" image="images/view.png" 
	            					style="height: 15; width: 15" action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO003-6" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
										<a4j:actionparam name="methodWithNavi" value="doInitBorrowContract" />
										<a4j:actionparam name="rowId" value="#{borrowSP.dataObj.rowId}"/>
										<a4j:actionparam name="docNo" value="#{borrowSP.dataObj.docNo}"/>
										<a4j:actionparam name="company" value="#{borrowSP.dataObj.company}"/>
										<a4j:actionparam name="siteNum" value="#{borrowSP.dataObj.siteNum}"/>
										<a4j:actionparam name="mode" value="VIEW"/>
	            				</a4j:commandButton>		
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{borrowSP.dataObj.docNo}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.docNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{borrowSP.dataObj.receiveDtStr}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.receiveDt']}" styleClass="contentform" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.receiveDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{borrowSP.dataObj.samSendDtStr}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.samSendDt']}" styleClass="contentform" style="width: 80">
									</h:outputText>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.samSendDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{borrowSP.dataObj.samAssignSendDtStr}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.samAssignSendDt']}" styleClass="contentform" style="width: 80">
									</h:outputText>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.samAssignSendDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{borrowSP.dataObj.remark}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{borrowSP.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{borrowSP.dataObj.siteNum}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteNum']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteNum}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{borrowSP.dataObj.siteBorrowNum}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteBorrowNum']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteBorrowNum}" styleClass="contentform">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{borrowSP.dataObj.siteRemainNum}" styleClass="#{(semmco003Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteRemainNum']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteRemainNum}" styleClass="contentform">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>	
							
							
							<rich:column  sortBy="#{borrowSP.dataObj.siteApproveNum}" styleClass="#{(semmsa005Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteApproveNum']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteApproveNum}" styleClass="contentform">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{borrowSP.dataObj.siteRejectNum}" styleClass="#{(semmsa005Bean.tmpRowId==borrowSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteRejectNum']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{borrowSP.dataObj.siteRejectNum}" styleClass="contentform">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
								
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco003Bean.borrowRequestSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBorrowRequest"
											maxPages="#{semmco003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVendor" 
											style="background-color: #cccccc;"
											page="#{semmco003Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
					  
		</h:panelGrid>
	</rich:panel>
	<jsp:include page="../../pages/co/semmco003-2.jsp" />
	
</h:panelGrid>
<jsp:include page="../../pages/co/semmco003-popup.jsp" />
<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="oppContent,pnlLog" >
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO003-1" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
							<a4j:actionparam name="methodWithNavi" value="deleteRequest" />						
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
