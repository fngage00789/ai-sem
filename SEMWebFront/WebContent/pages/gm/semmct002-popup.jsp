<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct002" var="jspMsg"/>
<rich:modalPanel id="popupFrmSaveBG" width="650" autosized="true" minWidth="220">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.master.save']}"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpSaveBG" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSaveBG" attachTo="hidePopUpSaveBG" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmSaveBG">
		<table width="100%"> 
			<tr>
		     <td align="left">
		     	<rich:spacer width="2"></rich:spacer>
		        <h:message for="txtBgNo" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
			 </td>
		   </tr>
		   <tr>
		     <td align="left">
		     	<rich:spacer width="2"></rich:spacer>
		        <h:message for="ddlBank" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
			 </td>
		   </tr>
	    </table>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<rich:panel>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.save.detail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table border="0">
								<tr>
									<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtBgNo" value="#{semmct002Bean.bgMaster.bgNo}"/>
				                	</td>
				                	<td align="right">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlBank" value="#{semmct002Bean.bgMaster.bgBank}"> 
										<f:selectItems value="#{semmct002Bean.bankNameList}"/>
									</h:selectOneMenu>
				                	</td>
			                	</tr>
								<tr>
									<td align="right">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtRemark" value="#{semmct002Bean.bgMaster.bgRemark}"
		                							 rows="3" cols="50"></h:inputTextarea>
				                	</td> 
			                   </tr>
			                   
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}"  
							oncomplete="if(#{semmct002Bean.popupClose == 'true'})#{rich:component('popupFrmSaveBG')}.hide();"
							reRender="dtbBGMaster,frmSearchResult,frmSaveBG,frmError">
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT002-1" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="userRole" value="finance" />
							<a4j:actionparam name="event" value="save" />
							<a4j:actionparam name="mode" value="INSERT" />
							<a4j:actionparam name="formType" value="popup" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
								<rich:componentControl for="popupFrmSaveBG" operation="hide" event="onclick" />
							</a4j:commandButton>
			           		
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
		</h:panelGrid>
		</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupFrmRejectBG" width="600" autosized="true" minWidth="220">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.save.reject']}"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpEdit" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmRejectBG" attachTo="hidePopUpEdit" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="rejFrmSave">
		<table width="100%"> 
			<tr>
		     <td align="left">
		     	<rich:spacer width="5"></rich:spacer>
		        <h:message for="txtRejectReason" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
			 </td>
		   </tr>
	    </table>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.save.detail.finance']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td valign="top" align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.rejectReason']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtRejectReason" value="#{semmct002Bean.txtRejectReason}"
		                							 rows="6" cols="50"></h:inputTextarea>
				                	</td>
			                   </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}"   
							oncomplete="if(#{semmct002Bean.popupClose == 'true'})#{rich:component('popupFrmRejectBG')}.hide();"
							reRender="dtbBGMaster,frmSearchResult,rejFrmSave,frmError,frmButton">
							<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doReject" />
							<a4j:actionparam name="userRole" value="finance" />
							<a4j:actionparam name="event" value="reject" />
							<a4j:actionparam name="mode" value="UPDATE" />
							<a4j:actionparam name="formType" value="popup" />
							<a4j:actionparam name="bgStatus" value="R" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
								<rich:componentControl for="popupFrmRejectBG" operation="hide" event="onclick" />
							</a4j:commandButton>
			           		
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
		</h:panelGrid>
		</a4j:form>
</rich:modalPanel>



<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mct002PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct002PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mct002PopUp_addVendor" attachTo="hide-mct002PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMct002PopUp_addVendor">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="เงื่อนไขการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmct002Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmct002Bean.vendorMasterPopupObjParam.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmct002Action.doSearchPopupAddVendor}"
					reRender="frmMct002PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmct002Action.doClearPopupAddVendor}"
					reRender="frmMct002PopUp_addVendor, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="ผลการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmct002Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmct002Action.doSelectPopupAddVendor}"
											reRender="oppContent">
												<a4j:actionparam name="paramVendorCode" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="paramVendorName" value="#{vendorLst.dataObj.vendorName}" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code ใหม่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mct002_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mct002_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mct002_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mct002_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmct002Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmct002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmct002Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMct002PopUp_addVendor"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mct002PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->		 
