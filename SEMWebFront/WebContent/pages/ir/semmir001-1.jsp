<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.insurance.semmir001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSrchAcquisition">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
						rendered="#{semmir001Bean.renderedMsgFormSearch}">
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
			<a4j:form id="frmSearch" ajaxSubmit="true">
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
			                			<a4j:region>
											<h:selectOneMenu id="ddlCompany" value="#{semmir001Bean.criteria.company}" onchange="GetCompany2JS();">
												<f:selectItems value="#{semmir001Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompany2JS" reRender="companyDisplay" />
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmir001Bean.criteria.company}" styleClass="ms28"/>
										</a4j:region>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlNetworkType" value="#{semmir001Bean.criteria.networkType}">
												<f:selectItems value="#{semmir001Bean.networkTypeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlTransferType" value="#{semmir001Bean.criteria.transferType}">
												<f:selectItems value="#{semmir001Bean.transferTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.asOfMonth']}" styleClass="ms7"/>
										</td><td width="80%" colspan="3">
											<h:inputText value="#{semmir001Bean.effMY}" onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
												onkeyup="addSlashForDate(this)" onblur="autoAddYear(this)" maxlength="7" size="7" />
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
								<a4j:actionparam name="navProgram" value="SEMMIR001-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,frmSearch,frmResult">
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR001-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			<a4j:form id="frmResult">
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1000"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir001Bean.msgDataNotFound}" rendered="#{semmir001Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbAcq" cellpadding="1" cellspacing="0" border="0" 
							var="Acquisition"  value="#{semmir001Bean.resultList}" reRender="dtbAcq" 
							rows="#{semmir001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmir001Action.getRowIdOnClick}" reRender="dtbAcq">
								<a4j:actionparam name="rowId" value="#{rentalPlan.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.networkTypeDesc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkType']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{Acquisition.networkTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{Acquisition.company}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.transferTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferType']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{Acquisition.transferTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.totalLocation}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.totalLocation']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{Acquisition.totalLocation}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.totalAcq}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.totalAcquisition']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{Acquisition.totalAcq}">
										<f:convertNumber pattern="#,##0.000"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="#{Acquisition.asOfMonth}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.asOfMonth']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{Acquisition.asOfMonth}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir001Bean.tmpRowId==Acquisition.rowId)?'onClick':'unClick'}" 
								sortBy="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.viewDetail']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.header.viewDetail']}" 
										action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR002-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="company" value="#{Acquisition.company}" />
										<a4j:actionparam name="networkType" value="#{Acquisition.networkType}" />
										<a4j:actionparam name="transferType" value="#{Acquisition.transferType}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir001Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="5">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbAcq"
											maxPages="#{semmir001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											style="background-color: #cccccc;" 
											page="#{semmir001Bean.scrollerPage}" 
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
</h:panelGrid>