<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.insurance.semmir004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSrchAcquisition">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
						rendered="#{semmir004Bean.renderedMsgFormSearch}">
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
						<h:panelGrid width="65%" border="0" cellpadding="0" cellspacing="1">
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
			                			<td width="80%" valign="bottom" colspan="3">
										<h:selectOneMenu id="ddlCompany" value="#{semmir004Bean.criteria.company}" onchange="GetCompany2JS();">
											<f:selectItems value="#{semmir004Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompany2JS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmir004Bean.criteria.company}" styleClass="ms28"/>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlNetworkType" value="#{semmir004Bean.criteria.networkType}">
												<f:selectItems value="#{semmir004Bean.networkTypeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlTransferType" value="#{semmir004Bean.criteria.transferType}">
												<f:selectItems value="#{semmir004Bean.transferTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.effectiveDate']}" styleClass="ms7"/>
										</td><td width="80%" colspan="3">
											<rich:calendar id="effDateFrom" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmir004Bean.criteria.effDateFrom}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','effDateFrom','effDateTo');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','effDateFrom','effDateTo');" >
											</rich:calendar>
											<rich:spacer width="1"></rich:spacer> -
											<rich:calendar id="effDateTo" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmir004Bean.criteria.effDateTo}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','effDateTo','effDateFrom');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','effDateTo','effDateFrom');" >
											</rich:calendar>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="frmError,frmSearch,frmResult">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR004-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,frmSearch,frmResult">
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR004-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			<a4j:form id="frmResult">
				<h:panelGrid id="grdActionCommand">
					<a4j:commandButton value="#{jspMsg['btn.addNew']}" styleClass="rich-button" 
						oncomplete="#{rich:component('popupFrmEdit')}.show(); return false" 
						action="#{navAction.navi}" reRender="popupFrmEdit">
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMMIR004-1" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
						<a4j:actionparam name="methodWithNavi" value="initPopup" />
						<a4j:actionparam name="mode" value="ADD"/>
					</a4j:commandButton>
				</h:panelGrid>
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1000"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir004Bean.msgDataNotFound}" rendered="#{semmir004Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbMda" cellpadding="1" cellspacing="0" border="0" 
							var="MasterDeduc"  value="#{semmir004Bean.resultList}" reRender="dtbMda" 
							rows="#{semmir004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmir004Action.getRowIdOnClick}" reRender="dtbMda">
								<a4j:actionparam name="rowId" value="#{MasterDeduc.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" >
						
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.edit']}" style="width: 40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										oncomplete="#{rich:component('popupFrmEdit')}.show(); return false" 
										action="#{navAction.navi}" reRender="popupFrmEdit" title="edit" 
										id="btnEdit">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR004-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="mode" value="EDIT"/>
										<a4j:actionparam name="rowId" value="#{MasterDeduc.rowId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.delete']}" style="width: 40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDel')}.show(); return false" 
     									   action="#{navAction.navi}"  image="images/delete.png" style="height: 15; width: 15;" 
     									   title="delete" id="btnDelete">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMMIR004-1" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{MasterDeduc.rowId}"/>
									</a4j:commandButton>
									
									
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" 
								sortBy="#{MasterDeduc.networkTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkType']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.networkTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" 
								sortBy="#{MasterDeduc.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.company}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" 
								sortBy="#{MasterDeduc.transferTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferType']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.transferTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" sortBy="#{MasterDeduc.damage}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.damage']}" style="width: 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{MasterDeduc.lossTypeDesc}"></h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" sortBy="#{MasterDeduc.deductible}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.deductible']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{MasterDeduc.deductAmt}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="15" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" sortBy="#{MasterDeduc.effDate}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effectiveDate']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.effDateStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}"  sortBy="#{MasterDeduc.updateBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.updateBy']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.updateBy}"></h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir004Bean.tmpRowId==MasterDeduc.rowId)?'onClick':'unClick'}" sortBy="#{MasterDeduc.updateDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.updateDate']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{MasterDeduc.updateDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir004Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="8">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMda"
											maxPages="#{semmir004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											style="background-color: #cccccc;" 
											page="#{semmir004Bean.scrollerPage}" 
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
	</rich:panel>
	<jsp:include page="../../pages/ir/semmir004-edit.jsp" />
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDel" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmir004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="dtbMda,frmError" >
							<a4j:actionparam name="navModule" value="ir" />
		            		<a4j:actionparam name="navProgram" value="SEMMIR004-1" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />							
							<rich:componentControl for="mdpConfirmDel" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDel" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>