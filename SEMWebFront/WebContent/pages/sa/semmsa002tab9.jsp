
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab9" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_addrForCourier']}" />
			</f:facet>
			<!-- << header content -->
	

				<div style="clear:both; height:10px;"></div>

				<!-- >> group 1 -->
				<!-- >> group 1 -->
				<rich:panel rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
				<h:panelGroup style="width:100%;"> 
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractNo}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.contract_status']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractStatus}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.pnextcont']} : " styleClass="ms7" ></h:outputText>
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.pNextContract}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_firstStartContractDate']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar  locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.firstEffDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.effDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.expireDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
                            	<rich:spacer width="20"></rich:spacer>
                            	<h:selectBooleanCheckbox label="#{jspMsg['label.th_contractNeverExpireDt']}" 
								value="#{semmsa002Bean.noExpFlag}" disabled="true"></h:selectBooleanCheckbox>
								<h:outputText value="#{jspMsg['label.th_contractNeverExpireDt']}" styleClass="ms7" />
							</td>
							
						</tr>
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.locationId']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.locationId}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['column.header.locationName']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText style="width:300px;" disabled="true" value="#{semmsa002Bean.siteContInfo.locationThName}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.status}"></h:inputText>
							</td>
						</tr>
					</table>
				</h:panelGroup>				
				</rich:panel>
				<!-- >> group 1 -->
				
				<div style="clear:both; height:5px;"></div>
				
				<rich:panel id="msa002tab7_pnlNailAddr">
					<h:panelGroup style="width:100%;">
						<center>
						<div id="msa002tab7_mailAddr" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							
							<rich:dataTable style="width:100%;" id="dataTabMsa002tab7_mailAddr" cellpadding="1" cellspacing="0" border="0" 
							var="appMailLst"  value="#{semmsa002Bean.siteAppMailList}" reRender="dataTabMsa002tab7_mailAddr" 
							rows="" rowClasses="cur" styleClass="dataTable">
							
								<!-- header -->
								<f:facet name="header">
					                <rich:columnGroup>
					                	<rich:column style="width:20px;"> 
											<h:outputText value=""/>
					                    </rich:column>  
					                    <rich:column style="width:20px;"> 
											<h:outputText value="Edit"/>
					                    </rich:column>  
					                    <rich:column style="width:20px;"> 
											<h:outputText value="Delete"/>
					                    </rich:column>
					                    
					                    <rich:column style="text-align:center; width:300px;">
					                        <h:outputText value="Name"/>
					                    </rich:column>
					                    <rich:column style="text-align:center; width:760px;">
					                        <h:outputText value="Address"/>
					                    </rich:column>
					                </rich:columnGroup>
					            </f:facet>
					            <!-- header -->
						
								<!-- data -->
								<rich:column style="text-align:center;">
			                        
			                        
			                        <h:selectBooleanCheckbox id="siteAcqSelected" value="#{appMailLst.checkBox}" 
                                        rendered="true">
                                        <a4j:support event="onclick" action="#{semmsa002Action.onRenderButton_tab9Address}" 
                                        reRender="siteAcqSelected,msa002tab9_expAddress,msa002tab7_pnlNailAddr">
                                        	<a4j:actionparam name="rowId" value="#{appMailLst.dataObj.mailAddrId}" />
                                    	</a4j:support>
                                    </h:selectBooleanCheckbox>
                                   
			                    </rich:column>
								<rich:column style="text-align:center;">
			                        <a4j:commandButton id="msa002tab7_btnEdit" image="images/edit.png" style="height:15px; width:15px;" 
									action="#{semmsa002Action.msa002Tab7_doExplainIUD}"  
									reRender="dataTabMsa002tab7_mailAddr, msa002tab7_addrDetail"
									oncomplete="#{rich:component('msa002PopUpCommon_addrDetailIU')}.show(); return false">
									
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppTab7ObjParam.siteAppId}" />
										<a4j:actionparam name="paramMailAddrId" value="#{appMailLst.dataObj.mailAddrId}" />
										<a4j:actionparam name="paramMode" value="U" />
										
									</a4j:commandButton>
			                    </rich:column>
			                    <rich:column style="text-align:center;">
			                        <a4j:commandButton id="msa002tab7_btnDelete" image="images/delete.png" style="height:15px; width:15px;" 
									action="#{semmsa002Action.msa002Tab7_doExplainIUD}" reRender="dataTabMsa002tab7_mailAddr" 
									oncomplete="#{rich:component('msa002PopUpCommon_tab7ConfirmDelete')}.show(); return false">
									
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppTab7ObjParam.siteAppId}" />
										<a4j:actionparam name="paramMailAddrId" value="#{appMailLst.dataObj.mailAddrId}" />
										<a4j:actionparam name="paramMode" value="D" />
										
									</a4j:commandButton>
			                    </rich:column>
			                   
			                    <rich:column>
			                        <h:outputText id="msa002tab7_mailName" value="#{appMailLst.dataObj.mailName}" styleClass="contentform" />
			                    </rich:column>
			                    <rich:column>
			                        <h:outputText id="msa002tab7_fullAddr" value="#{appMailLst.dataObj.fullAddress}" styleClass="contentform"/>
			                    </rich:column>
					            <!-- data -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="5" style="white-space:nowrap;">
										
											<!-- > 1 -->
											<h:outputFormat style="width:25%;" value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa002Bean.siteAppMailList)}"></f:param>
											</h:outputFormat>
										
											<!-- > 2 -->
											<a4j:region>
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabMsa002tab7_mailAddr"
													maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllMsa002tab7_mailAddr" style="background-color: #cccccc; width:50%;"
													page="#{semmsa002Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
												</rich:datascroller>
											</a4j:region>
											
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
					            
					    	</rich:dataTable>
						</div>
						</center>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				<div style="clear:both; height:10px;"></div>
				
				 <rich:messages id="msgMid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgExpMail}">
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
				<!-- >> group added -->
				<h:panelGroup style="width:100%; text-align:left;">
					<a4j:commandButton style="" id="msa002tab7_newAddress" 
					action="#{semmsa002Action.msa002Tab7_doExplainIUD}" value="NEW" styleClass="rich-button"
					reRender="panelTab, panelTab7, dataTabMsa002tab7_mailAddr, msa002tab7_addrDetail"
					oncomplete="#{rich:component('msa002PopUpCommon_addrDetailIU')}.show(); return false">
					
						<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppTab7ObjParam.siteAppId}" />
						<a4j:actionparam name="paramMailAddrId" value="#{appMailLst.dataObj.mailAddrId}" />
						<a4j:actionparam name="paramMode" value="I" />
						
					</a4j:commandButton>
					
					<rich:spacer width="10"></rich:spacer>
					
					<h:commandButton id="msa002tab9_expAddress" value="Export" styleClass="rich-button"
					disabled="#{semmsa002Bean.disabledBtnExportAddr}"
					action="#{semmsa002Action.doExportAddress}" onclick="displayMsg();">
					</h:commandButton>
					
					<a4j:jsFunction name="displayMsg" reRender="msgMid" ></a4j:jsFunction>
				</h:panelGroup>
				<!-- << group added -->
				
				<div style="clear:both; height:10px;"></div>
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->


	
