
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab8" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_jobOnOtherRole']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 1 -->
				<rich:panel>
					<h:panelGroup style="width:100%; text-align:center;">
						<table style="width:905px;">
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_name']}#{jspMsg['label.th_site']} : " styleClass="ms7" />
								</td>
								<td style="width:20%; white-space:nowrap;">
									<h:outputText value="xxxx" styleClass="ms7" />
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
								</td>
								<td style="width:20%; white-space:nowrap;">
									<h:outputText value="xxxx" styleClass="ms7" />
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_name']}#{jspMsg['label.th_contract_party']} : " styleClass="ms7" />
								</td>
								<td style="width:30%; white-space:nowrap;">
									<h:outputText value="xxxx" styleClass="ms7" />
								</td>
							</tr>
							<tr>
								<td colspan="6">
									<!-- dataGrid >> -->
									<h:panelGroup style="width:100%;">
										<!-- >> table result -->
										<center>
										<!-- a4j:form id="frmSemmsa002tab8Result" -->
										<div id="semmsa002tab8Result" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
											
												<rich:dataTable style="width:100%;" id="dataTabSemmsa002tab8" cellpadding="1" cellspacing="0" border="0" 
												var="tab1"  value="" reRender="dataTabSemmsa002tab8" 
												rows="" rowClasses="cur" styleClass="dataTable">
												
													<!-- header -->
													<f:facet name="header">
										                <rich:columnGroup>
											                <rich:column colspan="9" style="text-align:left;">
											                	<h:outputText value="#{jspMsg['column.header.siteApprove']}"/>
											                </rich:column>
										                    <rich:column breakBefore="true" style="width:20px;"> 
										                    	<f:facet name="header">
																	<h:outputText value="#{jspMsg['column.header.th_add']}#{jspMsg['column.header.th_new']}#{jspMsg['column.header.th_new']}" styleClass="contentform" />
																</f:facet>
																<div align="center">
																	<a4j:commandButton id="semmsa002tab8BtnAdd" action="#{navAction.navi}" image="images/edit.png"  
																	style="height:15px; width:15px;" reRender="oppContent" oncomplete="">
																	
											            			</a4j:commandButton>
																</div>
										                    </rich:column>  
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_storyNumber']}"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_storyExtra']}"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_storySummary']}"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_detail']}"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_status']}"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_date']} (#{jspMsg['column.header.th_status']})"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="#{jspMsg['column.header.th_time']} (#{jspMsg['column.header.th_status']})"/>
										                    </rich:column>
										                    <rich:column>
										                        <h:outputText value="User"/>
										                    </rich:column>
										                </rich:columnGroup>
										            </f:facet>
										            <!-- header -->
											
													<!-- data -->
													<rich:column>
								                        <h:outputText value="a"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
								                    <rich:column>
								                        <h:outputText value="aaaa"/>
								                    </rich:column>
										            <!-- data -->
										            
										    	</rich:dataTable>
										</div>
										<!-- /a4j:form -->
										</center>
									</h:panelGroup>
									<!-- dataGrid << -->
									
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
