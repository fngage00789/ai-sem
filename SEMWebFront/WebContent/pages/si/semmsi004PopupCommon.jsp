<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg" />
	
	<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->		
		
	<!-- >> [POPUP_01] -->
	<!-- msi004PopUpCommon_commonConfirm -->
	<rich:modalPanel id="msi004PopUpCommon_commonConfirm" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Popup"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msi004PopUpCommon_commonConfirm" style="cursor:pointer" rendered="#{!semmsi004Bean.retResultObj.resultType eq '01'}" />
					<rich:componentControl for="msi004PopUpCommon_commonConfirm" attachTo="hide-msi004PopUpCommon_commonConfirm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsi004PopUpCommon_commonConfirm">
		
			<rich:panel id="pnlCommonConfirm">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		
			                		<h:outputText value="#{semmsi004Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmsi004Bean.renderedMsgPopup}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmsi004Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmsi004Bean.renderedMsgPopup == false}" styleClass="ms7"></h:outputText>
			         			</td>
			         		</tr>
			         	</table>
			         </h:panelGroup>
                    
                </h:panelGrid>        	
			
				<div style="clear:both; height:10px;"></div>
	
				<!-- >> button search/clear -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									<a4j:commandButton value="#{semmsi004Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									reRender="oppContent,frmMsi004PopUpCommon_commonConfirm" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="#{semmsi004Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="#{semmsi004Bean.retResultObj.actionWithNavi}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmsi004Bean.retResultObj.methodWithNavi}" />
										<a4j:actionparam name="val1" value="#{semmsi004Bean.retResultObj.val1}" />
										<a4j:actionparam name="val2" value="#{semmsi004Bean.retResultObj.val2}" />
									</a4j:commandButton>
									
									<rich:spacer width="5" />
									
									<a4j:commandButton value="#{semmsi004Bean.retResultObj.cancelBtnLabel}" action="#{navAction.navi}"
									rendered="#{semmsi004Bean.retResultObj.resultType eq '01'}"
									reRender="oppContent,frmMsi004PopUpCommon_commonConfirm" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="#{semmsi004Bean.retResultObj.navProgramCancel}" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="#{semmsi004Bean.retResultObj.actionWithNaviCancel}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmsi004Bean.retResultObj.methodWithNaviCancel}" />
										<a4j:actionparam name="val1" value="#{semmsi004Bean.retResultObj.val3}" />
										<a4j:actionparam name="val2" value="#{semmsi004Bean.retResultObj.val4}" />
									</a4j:commandButton>
									
									<a4j:commandButton value="#{semmsi004Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" 
									rendered="#{semmsi004Bean.retResultObj.resultType eq '02'}"
									immediate="true" >
								    	<rich:componentControl for="msa002PopUpCommon_commonConfirm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button search/clear -->
			</rich:panel>
		</a4j:form>
	
	</rich:modalPanel>
	<!-- frmMsa002PopUpCommon_commonConfirm -->
	<!-- << [POPUP_01] -->
	
	
<rich:modalPanel id="msi004PopUpCommon_tab5AddContractElUse" width="900" autosized="true" top="70">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Add Contract"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msi004PopUpCommon_tab5AddContractElUse" style="cursor:pointer" />
					<rich:componentControl for="msi004PopUpCommon_tab5AddContractElUse" attachTo="hide-msi004PopUpCommon_tab5AddContractElUse" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsi004PopUpCommon_tab5AddContractElUse">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchCriteria']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
						<td align="right" width="25%" >
								<h:outputText value="#{jspMsg['label.th_company']} :" styleClass="ms7"/>
                			</td>           		
					<td colspan="2">
                				<h:selectOneMenu id="tab4AddContractElUse_drpCompany" value="#{semmsi004tab5Bean.contractElUseObjParam.company}" rendered="#{semmsi004tab5Bean.companyList != null}" styleClass="ms7">
									<f:selectItems value="#{semmsi004tab5Bean.companyList}"/>
								</h:selectOneMenu>
								
				<rich:spacer width="10"></rich:spacer>				
				<h:outputText value="#{jspMsg['label.warning.company']}" styleClass="ms7Red" rendered="#{semmsi004tab5Bean.msgReqcompanyPopup != null}"/>
		                	</td>
		               </tr>
		               <tr>
		                	<td align="right" width="25%" style="white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:blue;" />
								<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab4AddContractElUse_txtContractNo" value="#{semmsi004tab5Bean.contractElUseObjParam.contractNo}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="20%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_name']} Site :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="tab4AddContractElUse_txtLocationName" value="#{semmsi004tab5Bean.contractElUseObjParam.locationName}" 
                				size="30" maxlength="20"/>
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
					<a4j:commandButton value="Search" action="#{semmsi004tab5Action.tab5AddContractElUse_doSearchContractElUse}"
					reRender="frmMsi004PopUpCommon_tab5AddContractElUse, dataTable_searchContractElUse" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmsi004tab5Action.tab5AddContractElUse_doClearContractElUse}"
					reRender="frmMsi004PopUpCommon_tab5AddContractElUse, dataTable_searchContractElUse"
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
						<h:outputText value="#{jspMsg['label.th_searchResult']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchContractElUse" cellpadding="1" cellspacing="0" border="0" 
							var="contractElUseLst"  value="#{semmsi004tab5Bean.contractElUseList}" reRender="dataTable_searchContractElUse, dataScrll_searchContractElUse" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								<!-- header -->
								<f:facet name="header">
					                <rich:columnGroup>
					                    <rich:column style="width:80px; text-align:center;"> 
											<h:outputText value="Select"/>
					                    </rich:column>  
					                    <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']}"/>
                                        </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_name']} Site"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.contstatus']}"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_startDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_endDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                </rich:columnGroup>
					            </f:facet>
					            <!-- header -->
						
								<!-- data -->
								<rich:column>
									<div align="center">
					<a4j:commandLink id="selectLink" value="select" style="height:15px; width:15px;" 
										rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag != 'T'}"									 
										action="#{semmsi004tab5Action.tab5AddContractElUse_doAddContractElUse}"
										reRender="msi004tab5_elUseOthSiteContractNo">
											<a4j:actionparam name="paramContractNo" value="#{contractElUseLst.dataObj.contractNo}" />
											
											<rich:componentControl for="msi004PopUpCommon_tab5AddContractElUse" operation="hide" event="onclick" />
										</a4j:commandLink>
			                        </div>
			                    </rich:column>
			                    <rich:column style="text-align:center;">
                                    <h:outputText value="#{contractElUseLst.dataObj.contractNo}" />
                                </rich:column>
			                    <rich:column>
			                        <h:outputText value="#{contractElUseLst.dataObj.locationName}" />
			                    </rich:column>	                   			                   
			                   <rich:column style="text-align:center">
				                        <h:outputText value="#{contractElUseLst.dataObj.contractStatusName}" rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag != 'T'}"/>					                        
				                        
				                         <h:outputText value="#{contractElUseLst.dataObj.contractStatusName}" rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag == 'T'}" 		
				                         styleClass="ms7Red"/>			       		
				                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.effectiveDtStr}" />
			                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.expireDtStr}" />
			                    </rich:column>
					            <!-- data -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsi004tab5Bean.contractElUseList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchContractElUse"
													maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchContractElUse" style="background-color: #cccccc;"
													page="#{semmsi004tab5Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsi004PopUpCommon_tab5AddContractElUse"></a4j:support>
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
					    <rich:componentControl for="msi004PopUpCommon_tab5AddContractElUse" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	