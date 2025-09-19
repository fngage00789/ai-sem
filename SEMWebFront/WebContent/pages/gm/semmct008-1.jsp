<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid width="100%">
	<rich:panel id="pnlSearchParamMaster">
		<f:facet name="header">
			<h:outputText value="บันทึกค่าคงที่สำหรับออกเอกสาร"/>
		</f:facet>
		<a4j:form id="frmTypeGroup">
					<!-- begin radio custom -->
               		<table width="100%" cellpadding="0" cellspacing="0">
               			<tr>
               				<td width="100px">
               					<h:selectOneRadio id="rdoGroup1" styleClass="ms7" 
               									  value="#{semmct008Bean.type1}"
               									  onclick="selTypeGroupJS();" 
               									   rendered="#{semmct008Bean.renderer['rdoGroup1']}"
               									 >
               						<a4j:jsFunction name="selTypeGroupJS" reRender="frmTypeGroup,frmSearch,ddlLovCode" 
               							           action="#{semmct008Action.selectTypeGroup}" >
               							<a4j:actionparam name="type" value="CONTRACT" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="CONTRACT" itemLabel="CONTRACT" />
								</h:selectOneRadio>
								</td>
								<td width="100px">
								<h:selectOneRadio id="rdoGroup2" styleClass="ms7" 
               									  value="#{semmct008Bean.type2}" 
               									  onclick="selTypeGroupJS2();" 
               									   rendered="#{semmct008Bean.renderer['rdoGroup2']}"
               									  >
               						<a4j:jsFunction name="selTypeGroupJS2" reRender="frmTypeGroup,frmSearch,ddlLovCode" 
               							          action="#{semmct008Action.selectTypeGroup}"  >
               							<a4j:actionparam name="type" value="CONSTRUCT" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="CONSTRUCT" itemLabel="CONSTRUCT" />
								</h:selectOneRadio>
               				</td>
               				<td width="80%"></td>
               	</tr>
         </table>
         </a4j:form>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="เงื่อนไขค้นหา"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%" border="0">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="ประเภท  :" styleClass="ms7"/>
			                			</td>
			                			<td colspan="3">
			                			<h:selectOneMenu id="ddlLovCode" value="#{semmct008Bean.paramMasterCriteria.type}"> 
											<f:selectItems value="#{semmct008Bean.lovTypeSelCrtList}"/>
										</h:selectOneMenu>
					                	</td>
				                	 </tr> 
	
				                	 <tr>
					                	<td align="right">
			                				<a4j:commandButton id="btnSearch" value="Search"
			                								   styleClass="rich-button" 
			                								   action="#{navAction.navi}" 
			                								   reRender="pnlSearchCriteria,pnlSearchResult">
												<a4j:actionparam name="navModule" value="gm" />
												<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
												<a4j:actionparam name="methodWithNavi" value="doSearch" />
												<a4j:actionparam name="mode" value="SELECT" />
											</a4j:commandButton>
											<rich:spacer width="5"></rich:spacer>
											
											<a4j:commandButton id="btnClear" value="Clear" 
															   styleClass="rich-button" 
															   action="#{navAction.navi}" 
															   reRender="pnlSearchCriteria,pnlSearchResult,frmSearch">
								           		<a4j:actionparam name="navModule" value="gm" />
												<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
												<a4j:actionparam name="methodWithNavi" value="doClear" />
							           		</a4j:commandButton>
					                	</td>
					                	<td/>
				                	 </tr>
				                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<h:panelGrid  width="90%"  border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%" border="0">
							<tr>
								<td align="left">
									<a4j:commandButton id="btnNewParamMaster" value="New"
													   styleClass="rich-button"
													   action="#{navAction.navi}" 
													   oncomplete="#{rich:component('mdpParameterMasterDialog')}.show(); return false"
													   reRender="oppContent">
					            		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="INSERT" />
										<a4j:actionparam name="eventType" value="Add" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				<!-- end content button -->
				</a4j:form>
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" >
						<f:facet name="header">
							<h:outputText value="บันทึกค่าคงที่สำหรับออกเอกสาร"  style="width:1024"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct008Bean.msgDataNotFound}" rendered="#{semmct008Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:message for="dtbParamMaster" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" style=" height : 18px; width : 314px;">
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:message>
						</div>
						
						<rich:dataTable width="95%" id="dtbParamMaster" cellpadding="1" cellspacing="0" border="0"
										var="paramMaster" value="#{semmct008Bean.paramMasterList}" 
										rows="#{semmct008Bean.rowPerPage}"
										rowClasses="cur" 
										styleClass="dataTable" >
							<a4j:support event="onRowClick" action="#{semmct008Action.getRowIdOnClick}" reRender="dtbParamMaster">
								<a4j:actionparam name="rowId" value="#{paramMaster.rowId}" />
							</a4j:support>
							
							<rich:column  styleClass="#{(semmct008Bean.tmpRowId==paramMaster.type)?'onClick':'unClick'}" style="width: 40">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" 
	            									   reRender="oppContent" 
	            									   image="images/edit.png" 
	            									   style="FONT-SIZE: xx-small; height: 15; width: 15"
	            									   id="btnEdit"
	            									   oncomplete="#{rich:component('mdpParameterMasterDialog')}.show(); return false">
					            		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{paramMaster.rowId}"/>
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Edit" />
	            					</a4j:commandButton>
	            					                 							
								</div>
							</rich:column>
							<rich:column  style="width: 40" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   			   action="#{navAction.navi}" 
     									   			   image="images/delete.png" 
     									   			   style="height: 15; width: 15"
     									   			   id="btnDelete">
     									   <a4j:actionparam name="navModule" value="gm" />
				           				   <a4j:actionparam name="navProgram" value="SEMMCT008-1" />	
										   <a4j:actionparam name="moduleWithNavi" value="gm" />
										   <a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
										   <a4j:actionparam name="methodWithNavi" value="initDelete" />
										   <a4j:actionparam name="rowId" value="#{paramMaster.rowId}"/>	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column  styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}" style="width: 40">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton  id="btnView" action="#{navAction.navi}" 
						            					image="images/view.png" 
						            					style="height: 15; width: 15"
						            					reRender="oppContent"
						            					oncomplete="#{rich:component('mdpParameterMasterDialog')}.show(); return false">
	            						
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="SELECT"/>
										<a4j:actionparam name="rowId" value="#{paramMaster.rowId}"/>
	            					</a4j:commandButton>      		
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{paramMaster.type}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="ประเภท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paramMaster.typeName}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paramMaster.name}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ชื่อ" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{paramMaster.name}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paramMaster.company}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="บริษัท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paramMaster.company}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paramMaster.code}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="CODE" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{paramMaster.code}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paramMaster.value}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ค่า" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{paramMaster.value}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{paramMaster.remark}" styleClass="#{(semmct008Bean.tmpRowId==paramMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="หมายเหตุ" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{paramMaster.remark}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct008Bean.paramMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="5">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbParamMaster"
											maxPages="#{semmct008Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstLovMaster" 
											style="background-color: #cccccc;"
											page="#{semmct008Bean.scrollerPage}"/>
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
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct008Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbLovMaster,frmSearchResult" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT008-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
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

<rich:modalPanel id="mdpParameterMasterDialog" width="500" autosized="true" styleClass="ms7">	
	<f:facet name="header">
    	<h:outputText value="บันทึกค่าคงที่สำหรับออกเอกสาร- #{semmct008Bean.actModeDisplay}"></h:outputText>
    </f:facet>
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			   <h:graphicImage value="images/ico_close.png" id="hideMdpParameterMasterDialog" style="cursor:pointer"/>
               <rich:componentControl for="mdpParameterMasterDialog" attachTo="hideMdpParameterMasterDialog" operation="hide" event="onclick"/>
			</div>
		</h:panelGroup>
	</f:facet>
   	<a4j:form id="frmErrorDialog">
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
 			<f:facet name="header">
        		<h:outputText value="Entered Data Status:"></h:outputText>
            </f:facet>
			<f:facet name="errorMarker">
		 		<h:graphicImage value="images/error.gif" />  
            </f:facet>
    	</rich:messages>
	</a4j:form>
	<a4j:form id="frmParameterMasterDialog">
		<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
			<h:panelGroup>
				<table width="100%">
					<tr>
						<td align="right" width="25%">
							<h:panelGroup>
	                			<h:graphicImage value="images/icon_required.gif" />
	                			<rich:spacer width="5"></rich:spacer>
	                			<h:outputText value="ประเภท  :" styleClass="ms7" />
	                		</h:panelGroup>
	                	</td>
	                	<td colspan="3">
			                <h:selectOneMenu id="ddlLovType" value="#{semmct008Bean.paramMaster.type}"
			                				 disabled="#{semmct008Bean.viewMode}" style="width:100%">
		                		<f:selectItems value="#{semmct008Bean.lovTypeSelCrtList}"/>
		                	</h:selectOneMenu>
			            </td>
			     	</tr>
			     	
			     	<tr>
						<td align="right" width="25%">
							<h:panelGroup>
                				<h:graphicImage value="images/icon_required.gif" />
                				<rich:spacer width="5"></rich:spacer>
                				<h:outputText value="ชื่อ :" styleClass="ms7" />
                			</h:panelGroup>
                		</td>
                		<td><h:inputText id="txtName" value="#{semmct008Bean.paramMaster.name}"
                									 disabled="#{semmct008Bean.viewMode}"
                									 style="width:100%"
                									 maxlength="250"/></td>
                	</tr>
                	
			     	<tr>
						<td align="right" width="25%">
	                		<h:outputText value="บริษัท  :" styleClass="ms7" />
	                	</td>
	                	<td>
			                <h:selectOneMenu id="ddlCompany" value="#{semmct008Bean.paramMaster.company}"
			                				 disabled="#{semmct008Bean.viewMode}">
		                		<f:selectItems value="#{semmct008Bean.companyList}"/>
		                	</h:selectOneMenu>
			            </td>
			     	</tr>
			     	
					<tr>
						<td align="right" width="25%">
							<h:panelGroup>
                				<h:graphicImage value="images/icon_required.gif" />
                				<rich:spacer width="5"></rich:spacer>
                				<h:outputText value="CODE :" styleClass="ms7" />
                			</h:panelGroup>
                		</td>
                		<td><h:inputText id="txtCode" value="#{semmct008Bean.paramMaster.code}"
                									 disabled="#{semmct008Bean.viewMode}"
                									 style="width:100%"
                									 maxlength="250"/></td>
                	</tr>
                	
		            <tr>
						<td align="right" valign="top" width="25%">
							<h:panelGroup>
	                			<h:graphicImage value="images/icon_required.gif" />
	                			<rich:spacer width="5"></rich:spacer>
								<h:outputText value="ค่า :" styleClass="ms7" />
							</h:panelGroup></td>
		                <td>
		                	<h:inputTextarea id="txtValue" value="#{semmct008Bean.paramMaster.value}"
		                					 rows="3" cols="72"
		                					 label="ค่า" disabled="#{semmct008Bean.viewMode}"  >
                				<f:validateLength maximum="2000" ></f:validateLength>
                			</h:inputTextarea>
                		</td>
			       	</tr>
			       	
			       	<tr>
						<td align="right" valign="top" width="25%"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
		                <td>
		                	<h:inputTextarea id="txtRemark" value="#{semmct008Bean.paramMaster.remark}"
		                					 rows="3" cols="72"
		                					 label="หมายเหตุ" disabled="#{semmct008Bean.viewMode}"  >
                				<f:validateLength maximum="2000" ></f:validateLength>
                			</h:inputTextarea>
                		</td>
			       	</tr>
			       	
			       	<tr>
			       		<td/>
               			<td>
               				<a4j:commandButton id="btnSave" value="Save"
               								   styleClass="rich-button" 
               								   action="#{navAction.navi}"
               								   rendered="#{!semmct008Bean.viewMode}"
               								   reRender="frmErrorDialog,frmParameterMasterDialog">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
								<a4j:actionparam name="methodWithNavi" value="doSave" />
								<a4j:actionparam name="mode" value="#{semmct008Bean.mode}" />
								
								<a4j:support event="oncomplete" action="#{navAction.navi}" reRender="pnlSearchResult" rendered="#{semmct008Bean.renderedMsgFormTop}">
									<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT008-1" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT008" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
									<a4j:actionparam name="mode" value="SELECT" />
									<rich:componentControl event="oncomplete" operation="hide" for="mdpParameterMasterDialog"/>			
								</a4j:support>
							</a4j:commandButton>
							<rich:spacer width="5"></rich:spacer>
							
							<a4j:commandButton id="btnClear" value="Cancel" 
											   styleClass="rich-button"
											   rendered="#{!semmct008Bean.viewMode}">
								
								<rich:componentControl for="mdpParameterMasterDialog" operation="hide" event="onclick"/>
			           		</a4j:commandButton>
	                	</td>
                	 </tr>             
				</table>
			</h:panelGroup>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

