<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<f:loadBundle basename="resources.co.semmco007" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco006Bean.renderedMsgFormSearch}">
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
											<h:outputText value="#{jspMsg['label.name']} :" styleClass="ms7"/>
										</h:panelGroup>
		                			</td>
		                			<td width="40%"  valign="bottom">
										<h:inputText id="mco007_contNameParam" value="#{semmco007Bean.masterContractSP.contractFormName}" size="50"/> 
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%" valign="baseline">
				                		<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.status']} :" styleClass="ms7"/>
										</h:panelGroup>
				                	</td>
				                	<td width="40%"  valign="bottom">
										<h:selectOneRadio id="mco007_statusFlagParam" value="#{semmco007Bean.masterContractSP.recordStatus}"  styleClass="ms7" rendered="true" >
			                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.active']} " />
			                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.inActive']}"/>
			                			</h:selectOneRadio>
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
							<a4j:actionparam name="navProgram" value="SEMMCO007-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
			           		<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO007-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<h:panelGrid style="width: 100%">
					<a4j:form id="frmBtn">
						<h:panelGrid  width="96%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%" border="0">
									<tr>
										<td align="left">
											<a4j:commandButton id="btnAdd" 											 
											styleClass="rich-button" 
							            	action="#{navAction.navi}" value="Add"  
							            	reRender="oppContent, txtNavProgram" style="width:100">
							            		<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="initAddMasterContract" />
												<a4j:actionparam name="paramMode" value="A" />
												<a4j:actionparam name="eventType" value="Add" />
											</a4j:commandButton>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</a4j:form>
				</h:panelGrid>
				<a4j:form id="frmResult">
					<h:panelGrid width="90%">
						<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 105	 %"/>
							</f:facet>
							<div align="center">
	                            <h:outputLabel style="color:red;size:20px" value="#{semmco007Bean.msgDataNotFound}" rendered="#{semmco007Bean.renderedMsgDataNotFound}" />
	                        </div>
							<rich:dataTable id="tblMasterContract" value="#{semmco007Bean.masterContractWrapList}"
							cellpadding="1" cellspacing="0" border="0" var="obj" rows="#{semmrt007Bean.rowPerPage}"
							rowClasses="cur" styleClass="dataTable" >
							
								<rich:column >
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform" style="width: 30" />
									</f:facet>
									<div align="center">
										<a4j:commandButton id="btnDelete"  action="#{navAction.navi}" 
										image="images/delete.png" 
										style="height: 15; width : 15px;" 
			                            reRender="pnlSearchCriteria, pnlSearchResult" rendered="#{obj.dataObj.recordStatus == 'Y'}"
			                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
				                            <a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO007-1" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
											<a4j:actionparam name="methodWithNavi" value="doDelContractTitle" />
				                                        
				                            <a4j:actionparam name="contractFormId" value="#{obj.dataObj.contractFormId}" />
											<a4j:actionparam name="contractFormName" value="#{obj.dataObj.contractFormName}" />
											<a4j:actionparam name="contractFormTitle" value="#{obj.dataObj.contractFormTitle}" />
			                            </a4j:commandButton>
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="Edit" styleClass="contentform" style="width: 40" />
									</f:facet>
									<div align="center">
										<a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" 
										style="height: 15; width : 15px;"
			                            reRender="oppContent,txtNavProgram">
			                                <a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
											<a4j:actionparam name="methodWithNavi" value="initAddMasterContract" />
											<a4j:actionparam name="paramMode" value="E" />
											<a4j:actionparam name="contractFormId" value="#{obj.dataObj.contractFormId}" />
											<a4j:actionparam name="contractFormName" value="#{obj.dataObj.contractFormName}" />
											<a4j:actionparam name="contractFormTitle" value="#{obj.dataObj.contractFormTitle}" />
											<a4j:actionparam name="contractFormEnding" value="#{obj.dataObj.contEndingFlag}" />
			                            </a4j:commandButton>
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.contractFormName}">
									<f:facet name="header">
										<h:outputText value="Name" styleClass="contentform" style="width: 800"/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{obj.dataObj.contractFormName}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.recordStatus}">
									<f:facet name="header">
										<h:outputText value="Status" styleClass="contentform" style="width: 10"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{obj.dataObj.recordStatus}" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.createBy}">
									<f:facet name="header">
										<h:outputText value="Create By" styleClass="contentform" style="width: 70"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{obj.dataObj.createBy}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.createDt}">
									<f:facet name="header">
										<h:outputText value="Create Date" styleClass="contentform" style="width: 70"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{obj.dataObj.createDtStr}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.updateBy}">
									<f:facet name="header">
										<h:outputText value="Update By" styleClass="contentform" style="width: 70"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{obj.dataObj.updateBy}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{obj.dataObj.updateDt}">
									<f:facet name="header">
										<h:outputText value="Update Date" styleClass="contentform" style="width: 70"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{obj.dataObj.updateDtStr}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<f:facet name="footer">
	                                <rich:columnGroup>
	                                    <rich:column colspan="3">
	                                        <h:outputFormat value="#{msg['message.totalRecords']}">
	                                        	<f:param value="#{fn:length(semmco007Bean.masterContractWrapList)}"></f:param>
	                                        </h:outputFormat>
	                                    </rich:column>
	                                    <rich:column colspan="5">
	                                        <rich:datascroller immediate="true" rendered="true" align="left" for="tblMasterContract"
	                                            maxPages="#{semmco007Bean.rowPerPage}"  selectedStyleClass="selectScroll"
	                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
	                                            id="dstTblMasterContract" 
	                                            style="background-color: #cccccc;"
	                                            page="#{semmco007Bean.scrollerPage}" 
	                                        />
	                                    </rich:column>
	                                </rich:columnGroup>
	                            </f:facet>
							</rich:dataTable>
						</rich:panel>
					</h:panelGrid>
				</a4j:form>
			
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>

