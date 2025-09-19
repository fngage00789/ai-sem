
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />
	
	<!-- >> wrapper panel -->
	<rich:panel style="height:100%; border:1 ececec solid;">
		<rich:panel id="panelMsa001-16_editCoStatus" style="border:1 e0e0e0 solid; height:100%;">
			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_sendContractToLessor']} [semmsa001-editCoStatus]"/>
			</f:facet>
			<!-- << header content -->
			
			<h:panelGroup style="width:100%;">
			<a4j:form id="frmMsa001-16_editCoStatus">
				<table align="center" style="width:900px; background-color:d0d0d0; border:2px solid e0e0e0; text-align:right;">
					<tr>
						<td>
							<a4j:commandButton id="msa001EditCotatus_BtnBack" value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="sa" />
								<a4j:actionparam name="navProgram" value="SEMMSA001-0" />
								
								<a4j:actionparam name="moduleWithNavi" value="sa" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSA001" />
								<a4j:actionparam name="methodWithNavi" value="treeSwapPage" />
								
								<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
								<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
							</a4j:commandButton>
						</td>
					</tr>
				</table>
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group detail -->
				<center>
				<div id="tabEditCoStatus" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
				
					<rich:dataTable style="width:100%;" id="dataTableCoStatusList" cellpadding="1" cellspacing="0" border="0" 
					var="coStatusLst"  value="#{semmsa001Bean.coStatusList}" reRender="dataTableCoStatusList" 
					rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				
						<!-- header -->
						<f:facet name="header">
			                <rich:columnGroup>
			                	<rich:column colspan="6" style="text-align:left;">
				                	<h:outputText value="#{jspMsg['label.th_edit']}#{jspMsg['label.th_status']}"/>
				                </rich:column>
			                    <rich:column breakBefore="true" style="width:20px; text-align:center;">
			                    	<div align="center">
			                        	<h:outputText value="Edit"/>
			                        </div>
			                    </rich:column>
			                    <rich:column style="width:20px; text-align:center;">
			                    	<div align="center">
			                        	<h:outputText value="Delete"/>
			                        </div>
			                    </rich:column>
			                    <rich:column style="white-space:nowrap;">
			                        <h:outputText value="#{jspMsg['column.header.th_status']}"/>
			                    </rich:column>
			                    <rich:column style="white-space:nowrap;">
			                        <h:outputText value="#{jspMsg['column.header.th_date']}"/>
			                    </rich:column>
			                    <rich:column style="white-space:nowrap;">
			                        <h:outputText value="#{jspMsg['column.header.th_remark']}"/>
			                    </rich:column>
			                    <rich:column style="white-space:nowrap;">
			                        <h:outputText value="#{jspMsg['column.header.th_userLogin']}"/>
			                    </rich:column>
							</rich:columnGroup>
						</f:facet>
						<!-- header -->
						
						<!-- >> group detail -->
						<rich:column>
							<div align="center">
			                    <a4j:commandButton id="coStatus_btnEdit" action="#{semmsa001Action.doAddOrEditCoStatusDetail}" image="images/edit.png" style="height:15px; width:15px;" 
								oncomplete="#{rich:component('msa001-16_saveCoStatus')}.show();" 
								reRender="msa001-16_saveCoStatus, frmMsa001-16_saveCoStatus"
								rendered="#{coStatusLst.dataObj.renderedDisplay}">
									<a4j:actionparam name="paramSiteAppId" value="#{coStatusLst.dataObj.siteAppId}" />
									<a4j:actionparam name="paramSiteContractStatusId" value="#{coStatusLst.dataObj.siteContractStatusId}" />
									<a4j:actionparam name="paramMode" value="U" />
								</a4j:commandButton>
							</div>
		                </rich:column>
						<rich:column>
							<div align="center">
			                    <a4j:commandButton id="coStatus_btnDelete" action="#{semmsa001Action.doAddOrEditCoStatusDetail}" image="images/delete.png" style="height:15px; width:15px;" 
								oncomplete="#{rich:component('msa001-16_confirmDelete')}.show();" reRender="msa001-16_confirmDelete, frmMsa001-16_confirmDelete"
								rendered="#{coStatusLst.dataObj.renderedDisplay}">
									<a4j:actionparam name="paramSiteAppId" value="#{coStatusLst.dataObj.siteAppId}" />
									<a4j:actionparam name="paramSiteContractStatusId" value="#{coStatusLst.dataObj.siteContractStatusId}" />
									<a4j:actionparam name="paramMode" value="D" />
								</a4j:commandButton>
							</div>
		                </rich:column>
		                <rich:column>
		                    <h:outputText value="#{coStatusLst.dataObj.contractStatusText}" />
		                </rich:column>
		                <rich:column style="text-align:center;" >
		                    <h:outputText value="#{coStatusLst.dataObj.updateDtStr}">
		                    	<f:convertDateTime pattern="dd/MM/yyyy"/>
		                    </h:outputText>
		                </rich:column>
		                <rich:column>
		                    <h:outputText value="#{coStatusLst.dataObj.remark}" />
		                </rich:column>
		                <rich:column>
		                    <h:outputText value="#{coStatusLst.dataObj.updateBy}" />
		                </rich:column>
						<!-- detail -->
						
						<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsa001Bean.coStatusList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="3">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dataTableCoStatusList"
											maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllCoStatusList" style="background-color: #cccccc;"
											page="#{semmsa001Bean.scrollerPage}">
										<a4j:support event="onclick"  reRender="frmMsa001-16_editCoStatus"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
						
					</rich:dataTable>
				
				</div>
				
				<div style="clear:both; height:10px;"></div>
				
				<table align="center" style="width:900px;">
					<tr>
						<td>
							<a4j:commandButton id="msa001EditCotatus_BtnAdd" value="Add" styleClass="rich-button"
							oncomplete="#{rich:component('msa001-16_saveCoStatus')}.show();"
							action="#{semmsa001Action.doAddOrEditCoStatusDetail}" reRender="msa001-16_saveCoStatus, frmMsa001-16_saveCoStatus">
								<a4j:actionparam name="paramSiteAppId" value="#{semmsa001Bean.siteCntrctSttsObjParam.siteAppId}" />
								<a4j:actionparam name="paramSiteContractStatusId" value="" />
								<a4j:actionparam name="paramMode" value="I" />
							</a4j:commandButton>
						</td>
					</tr>
				</table>
				
				</center>
				<!-- << group detail -->
			</a4j:form>
			</h:panelGroup>
			
		</rich:panel>
	</rich:panel>
	<!-- << wrapper panel -->
	
	
	
	<!-- >> [POPUP_00] -->
	<!-- msa001-16_retStatus -->
	<rich:modalPanel id="msa001-16_retStatus" autosized="true" rendered="#{semmsa001Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa001-16_retStatus" style="cursor:pointer" />
					<rich:componentControl for="msa001-16_retStatus" attachTo="hide-msa001-16_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa001-16_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa001Bean.renderedMsgAlert}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" style="margin-right:5px;" />  
                    </f:facet>
	            </rich:messages>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa001-16_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- msa001-16_retStatus -->
	<!-- << [POPUP_00] -->
	
	
	<!-- >> [POPUP_01] -->
	<!-- msa001-16_saveCoStatus -->
	<rich:modalPanel id="msa001-16_saveCoStatus" width="800" autosized="true">
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_edit']}#{jspMsg['label.th_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa001-16_saveCoStatus" style="cursor:pointer" />
					<rich:componentControl for="msa001-16_saveCoStatus" attachTo="hide-msa001-16_saveCoStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa001-16_saveCoStatus">
		
			<!-- >> group edit detail -->
			<rich:panel style="width:900px;">
				<h:panelGroup style="width:100%; border:1px solid e0e0e0;">
					<!-- top >> -->
					<table style="width:100%; background-color:cada30; border:1px solid e0e0e0;">
						<tr>
							<td style="" colspan="2">
								<h:outputText value="#{jspMsg['label.th_save']}#{jspMsg['label.th_status']}" styleClass="ms7" />
							</td>
						</tr>
					</table>
					<!-- top << -->
					
					<!-- detail >> -->
					<table style="width:100%; border:0px solid e0e0e0;">
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_status']}#{jspMsg['label.th_contract']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;">
								<h:selectOneMenu id="editCoStatus_contractStatus" value="#{semmsa001Bean.siteCntrctSttsObjParam.contractStatus}" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.contractStatusList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_date']} : " styleClass="ms7" />
							</td>
							<td style="width:70%">
								<rich:calendar id="editCoStatus_date" locale="th" enableManualInput="true" 
								   datePattern="dd/MM/yyyy" 
								   value="#{semmsa001Bean.siteCntrctSttsObjParam.updateDt}"
								   showWeeksBar="false"
								   inputSize="10"
								   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								   oninputblur="return dateformat.submitFomatDate(this);"
							   	   cellWidth="15px" cellHeight="20px"
							   	   label=""
							   	   styleClass="ms7">
								</rich:calendar>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right; vertical-align:top;">
								<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;">
								<h:inputTextarea value="#{semmsa001Bean.siteCntrctSttsObjParam.remark}" rows="4" cols="50" style="width:70%;" styleClass="ms7">
								</h:inputTextarea>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
			<!-- << group edit detail -->
			
			<div style="clear:both; height:0px;"></div>

			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Save" styleClass="rich-button" style="margin-right:5px;"
					action="#{semmsa001Action.doSaveCoStatusDetail}" oncomplete="#{rich:component('msa001-16_retStatus')}.show();"
					reRender="oppContent, panelMsa001-16_editCoStatus, dataTableCoStatusList">
						<a4j:actionparam name="paramMode" value="#{semmsa001Bean.paramMode}" />
						
						<a4j:actionparam name="paramReload" value="Y" />
						<a4j:actionparam name="rowId" value="#{semmsa001Bean.siteAppObjParam.siteAppId}" />
						<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
						<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
					</a4j:commandButton>

					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa001-16_saveCoStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		</a4j:form>
	</rich:modalPanel>
	<!-- msa001-16_saveCoStatus -->
	<!-- << [POPUP_01] -->
	
	
	
	<!-- >> [POPUP_02] -->
	<rich:modalPanel id="msa001-16_confirmDelete" width="300" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Delete"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa001-16_confirmDelete" style="cursor:pointer" />
					<rich:componentControl for="msa001-16_confirmDelete" attachTo="hide-msa001-16_confirmDelete" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa001-16_confirmDelete">
		<!-- >> group detail -->
		<center>
			<h:outputText value="#{jspMsg['label.th_confirm_delete']}" styleClass="ms7" />
		</center>
		<!-- << group detail -->

		<div style="clear:both; height:10px;"></div>

		<!-- >> additional button close -->
		<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
			<h:panelGroup style="float:right;">
				<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true" style="margin-right:5px;"
				action="#{semmsa001Action.doSaveCoStatusDetail}" oncomplete="#{rich:component('msa001-16_retStatus')}.show(); return false;" 
				reRender="oppContent, panelMsa001-16_editCoStatus, dataTableCoStatusList">
					<a4j:actionparam name="paramMode" value="D" />

					<a4j:actionparam name="paramReload" value="Y" />
					<a4j:actionparam name="rowId" value="#{semmsa001Bean.siteAppObjParam.siteAppId}" />
					<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
					<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
				</a4j:commandButton>
				
				<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
				    <rich:componentControl for="msa001-16_confirmDelete" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGroup>
		</h:panelGrid>
		<!-- << additional button close -->
		</a4j:form>
	</rich:modalPanel>
	<!-- << [POPUP_02] -->