<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid width="100%">
	<rich:panel id="pnlSearchLovMaster">
		<f:facet name="header"><h:outputText value="บันทึกค่าคงที่ในระบบ"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr>
			<td>	<a4j:form id="frmTypeGroup">
					<!-- begin radio custom -->
               		<table width="100%" cellpadding="0" cellspacing="0">
               			<tr>
               				<td>
               					<h:selectOneRadio id="rdoGroup1" styleClass="ms7" 
               									  value="#{semmct007Bean.type1}"
               									  onclick="selTypeGroupJS();" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup1']}">
               						<a4j:jsFunction name="selTypeGroupJS" reRender="frmSearch,rdoGroup2,rdoGroup3,rdoGroup4,rdoGroup5,rdoGroup6,frmSearchResult" 
               							            action="#{semmct007Action.selectTypeGroup}">
               							<a4j:actionparam name="type" value="CONTRACT" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="CONTRACT" itemLabel="CONTRACT" />
								</h:selectOneRadio>
               				</td>
               				<td>
               					<h:selectOneRadio id="rdoGroup2" styleClass="ms7" 
               									  value="#{semmct007Bean.type2}" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup2']}">
               									  
             						<a4j:support event="onclick" reRender="frmSearch,rdoGroup1,rdoGroup3,rdoGroup4,rdoGroup5,rdoGroup6,frmSearchResult"  
             									 action="#{semmct007Action.selectTypeGroup}">
             							<a4j:actionparam name="type" value="LEGAL" />
             						</a4j:support>
									<f:selectItem itemValue="LEGAL" itemLabel="LEGAL" />
								</h:selectOneRadio>
               				</td>
               				<td>
               					<h:selectOneRadio id="rdoGroup3" styleClass="ms7" 
               									  value="#{semmct007Bean.type3}" 
               									  onclick="selTypeGroupJS3();" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup3']}">
               						<a4j:jsFunction name="selTypeGroupJS3" reRender="frmSearch,rdoGroup1,rdoGroup2,rdoGroup4,rdoGroup5,rdoGroup6,frmSearchResult" 
               							            action="#{semmct007Action.selectTypeGroup}">
               							<a4j:actionparam name="type" value="ELECTRIC" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="ELECTRIC" itemLabel="ELECTRIC" />
								</h:selectOneRadio>
               				</td>
               				<td>
               					<h:selectOneRadio id="rdoGroup4" styleClass="ms7" 
               									  value="#{semmct007Bean.type4}" 
               									  onclick="selTypeGroupJS4();" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup4']}">
               						<a4j:jsFunction name="selTypeGroupJS4" reRender="frmSearch,rdoGroup1,rdoGroup2,rdoGroup3,rdoGroup5,rdoGroup6,frmSearchResult" 
               							            action="#{semmct007Action.selectTypeGroup}">
               							<a4j:actionparam name="type" value="OTHER" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="OTHER" itemLabel="OTHER" />
								</h:selectOneRadio>
               				</td>
               				<td>
               					<h:selectOneRadio id="rdoGroup5" styleClass="ms7" 
               									  value="#{semmct007Bean.type5}"  
               									  onclick="selTypeGroupJS5();" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup5']}">
               						<a4j:jsFunction name="selTypeGroupJS5" reRender="frmSearch,rdoGroup1,rdoGroup2,rdoGroup3,rdoGroup4,rdoGroup6,frmSearchResult" 
               							            action="#{semmct007Action.selectTypeGroup}">
               							<a4j:actionparam name="type" value="FND" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="FND" itemLabel="FND" />
								</h:selectOneRadio>
               				</td>
               				<td>
               					<h:selectOneRadio id="rdoGroup6" styleClass="ms7" 
               									  value="#{semmct007Bean.type6}"
               									  onclick="selTypeGroupJS6();" 
               									  rendered="#{semmct007Bean.renderer['rdoGroup6']}">
               						<a4j:jsFunction name="selTypeGroupJS6" reRender="frmSearch,rdoGroup1,rdoGroup2,rdoGroup3,rdoGroup4,rdoGroup5,frmSearchResult" 
               							            action="#{semmct007Action.selectTypeGroup}">
               							<a4j:actionparam name="type" value="ACD" />
             						</a4j:jsFunction>
									<f:selectItem itemValue="ACD" itemLabel="ACD" />
								</h:selectOneRadio>
               				</td>
               			</tr>
               		</table>
				                		
					<!--<a4j:commandButton id="btnType1" value="Type1" styleClass="rich-button"
					action="#{navAction.navi}" reRender="frmSearch" rendered="#{semmct007Bean.renderer['btnType1']}">
					<a4j:actionparam name="navModule" value="gm" />
					<a4j:actionparam name="navProgram" value="SEMMCT007-1" />
					<a4j:actionparam name="moduleWithNavi" value="gm" />
					<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
					<a4j:actionparam name="methodWithNavi" value="getLovTypeByGroup" />
					<a4j:actionparam name="groupType" value="CONTRACT" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnType2" value="Type2" styleClass="rich-button"
					action="#{navAction.navi}" reRender="frmSearch" rendered="#{semmct007Bean.renderer['btnType2']}">
					<a4j:actionparam name="navModule" value="gm" />
					<a4j:actionparam name="navProgram" value="SEMMCT007-1" />
					<a4j:actionparam name="moduleWithNavi" value="gm" />
					<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
					<a4j:actionparam name="methodWithNavi" value="getLovTypeByGroup" />
					<a4j:actionparam name="groupType" value="OTHER" />
					</a4j:commandButton>
					
					-->
					</a4j:form>
			</td>
			</tr>
			<tr>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct007Bean.renderedMsgFormSearch}" style=" width : 241px; height : 64px;">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td>
			</tr>
			</table>
		</h:panelGrid>
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
									<!--<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									--><h:outputText value="ประเภทค่าคงที่  :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu id="ddlLovCode" value="#{semmct007Bean.lovMasterCriteria.lovType}"> 
										<f:selectItems value="#{semmct007Bean.lovTypeSelCrtList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr> 
			                	 
			                	 <tr>
				                	<td align="right"><h:outputText value="Name :" styleClass="ms7"/></td>
		                			<td><h:inputText id="txtName" value="#{semmct007Bean.lovMasterCriteria.lovName}" /></td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right">
									<h:outputText value="Record Status :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneRadio id="rbtRecStatus" value="#{semmct007Bean.lovMasterCriteria.recordStatus}" styleClass="ms7">
		                			    <f:selectItem itemLabel="ทั้งหมด" itemValue="" />
										<f:selectItem itemLabel="ปรกติ" itemValue="Y" />
										<f:selectItem itemLabel="ยกเลิก"  itemValue="N" />
									</h:selectOneRadio>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="left">
				                		<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT007-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
										<a4j:actionparam name="mode" value="SELECT" />
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
						           		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT007-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
										<a4j:actionparam name="methodWithNavi" value="doClear" />
						           		</a4j:commandButton>
		                			</td>
		                			<td>
				                	</td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				<a4j:form id="frmButton">
				<!-- begin content button -->
				<h:panelGrid >
					
					<a4j:commandButton id="btnNewLovMaster"  styleClass="rich-button" 
	            	action="#{navAction.navi}" value="Add"  reRender="oppContent">
	            		<a4j:actionparam name="navModule" value="gm" />
						<a4j:actionparam name="navProgram" value="SEMMCT007-2" />
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="INSERT" />
						<a4j:actionparam name="eventType" value="Add" />
					</a4j:commandButton>
					
				</h:panelGrid>
				<!-- end content button -->
				</a4j:form>
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" >
						<f:facet name="header">
							<h:outputText value="ค่าคงที่ในระบบ"  style="width:1024"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmct007Bean.msgDataNotFound}" rendered="#{semmct007Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" style=" height : 18px; width : 314px;">
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:messages>
						</div>
						
						<rich:dataTable width="95%" id="dtbLovMaster" cellpadding="1" cellspacing="0" border="0"
							var="lovMaster" value="#{semmct007Bean.lovMasterList}" 
							rows="#{semmct007Bean.rowPerPage}"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column  styleClass="#{(semmct007Bean.tmpRowId==lovMaster.lovType)?'onClick':'unClick'}" style="width: 40">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" 
	            									   reRender="oppContent" 
	            									   image="images/edit.png" 
	            									   style="FONT-SIZE: xx-small; height: 15; width: 15"
	            									   id="btnEdit"
	            									   rendered="#{lovMaster.updateFlag == 'Y'}">
					            		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT007-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="rowId" value="#{lovMaster.rowId}"/>
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Edit" />
										<a4j:actionparam name="lovType" value="#{lovMaster.lovType}"/>
	            					</a4j:commandButton>
	            					                 							
								</div>
							</rich:column>
							<rich:column  style="width: 40">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   			   action="#{navAction.navi}" 
     									   			   image="images/delete.png" 
     									   			   style="height: 15; width: 15"
     									   			   id="btnDelete"
     									   			   rendered="#{lovMaster.insertFlag == 'Y'}"
     									   			   >
     									   <a4j:actionparam name="navModule" value="gm" />
				           				   <a4j:actionparam name="navProgram" value="SEMMCT007-1" />	
										   <a4j:actionparam name="moduleWithNavi" value="gm" />
										   <a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
										   <a4j:actionparam name="methodWithNavi" value="initDelete" />
										   <a4j:actionparam name="rowId" value="#{lovMaster.rowId}"/>	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column  styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}" style="width: 40">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton  id="btnView" action="#{navAction.navi}" 
						            					image="images/view.png" 
						            					style="height: 15; width: 15"
						            					reRender="oppContent">
	            						<a4j:actionparam name="rowId" value="#{lovMaster.rowId}"/>
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT007-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="SELECT"/>
										<a4j:actionparam name="lovType" value="#{lovMaster.lovType}"/>
	            					</a4j:commandButton>      
	            					
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{lovMaster.lovType}" styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="ประเภทค่าคงที่" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{lovMaster.lovType}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{lovMaster.lovCode}" styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="รหัสค่าคงที่" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{lovMaster.lovCode}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column   sortBy="#{lovMaster.lovName}" styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="Name" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{lovMaster.lovName}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{lovMaster.lovOrder}" styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="ลำดับที่แสดงผล" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{lovMaster.lovOrder}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{lovMaster.recordStatus}" styleClass="#{(semmct007Bean.tmpRowId==lovMaster.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Record Status" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="ปรกติ" styleClass="contentform" rendered="#{lovMaster.recordStatus == 'Y'}">
									</h:outputText>
									<h:outputText value="ยกเลิก" styleClass="contentform" rendered="#{lovMaster.recordStatus == 'N'}">
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmct007Bean.lovMasterList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLovMaster"
											maxPages="#{semmct007Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstLovMaster" 
											style="background-color: #cccccc;"
											page="#{semmct007Bean.scrollerPage}" 
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
						<h:outputText value="#{semmct007Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbLovMaster,frmSearchResult" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT007-1" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
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


