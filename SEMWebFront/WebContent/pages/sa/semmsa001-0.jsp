
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelWrapperAll" style="width:100%; height:1500px;vertical-align:top;" columns="2">

		<rich:panel id="panelWrapper_tree" style="height:100%;border:1 ececec solid;vertical-align:top;" styleClass="classWrapperAll">
	
			<!-- left content panel -->
			<rich:panel style="width:100%;height:100%;border:1 e0e0e0 solid; height:100%;vertical-align:top;" headerClass="headerCenter">
				<!-- >> header left content -->
					<f:facet name="header">
							<h:outputText value="#{jspMsg['label.toDoList']}" />
					</f:facet>
				<!-- << header left content -->
				
				
					<!-- >> tree menu -->
					<h:form id="frmTree">
						
						<rich:simpleTogglePanel id="pnlSubNew"  switchType="client" label="#{jspMsg['label.newLocation']}" 
				        opened="true" style="width:100%;margin:0 auto; padding:0px;vertical-align:top;">
							<h:dataTable id="new" border="0" var="obj" value="#{semmsa001Bean.menuTreeNewList}" 
							style="margin:0 auto; padding:0px;" width="94%">
								<h:column>
									<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													 <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
											          reRender="panelWrapper_tree,panelWrapper_content" >
											          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
														<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
														<a4j:actionparam name="paramMenuType" value="N" />
											          </a4j:commandLink>
												</td>
												<td align="right">
													<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
											     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
											     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
												</td>
											</tr>
										</table>
										
									</div>
								</h:column>
							</h:dataTable>
						</rich:simpleTogglePanel>
						
						<rich:simpleTogglePanel id="pnlSubRenew"  switchType="client" label="#{jspMsg['label.renewContract']}" 
				        opened="true" style="width:100%;margin:0 auto; padding:0px;align:top;">
							<h:dataTable id="renew" border="0"  width="94%"
								var="obj" value="#{semmsa001Bean.menuTreeReNewList}" 
								
								style="margin:0 auto; padding:0px;">
								<h:column>
									<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													 <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
											          reRender="panelWrapper_tree,panelWrapper_content" >
											          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
														<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
														<a4j:actionparam name="paramMenuType" value="R" />
											          </a4j:commandLink>
												</td>
												<td align="right">
													<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
											     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
											     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
												</td>
											</tr>
										</table>
										
									</div>
								</h:column>
							</h:dataTable>
						</rich:simpleTogglePanel>
						
						<rich:simpleTogglePanel id="pnlSubWaiting"  switchType="client" label="#{jspMsg['label.changeContract']}" 
				        opened="true" style="width:100%;margin:0 auto; padding:0px;align:top;">
							<h:dataTable id="waiting" border="0"  width="94%"
								var="obj" value="#{semmsa001Bean.menuTreeWaitingList}" 
								
								style="margin:0 auto; padding:0px;">
								<h:column>
									<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
											        reRender="panelWrapper_tree,panelWrapper_content" >
											          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
														<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
														<a4j:actionparam name="paramMenuType" value="E" />
											        </a4j:commandLink>
												</td>
												<td align="right">
													<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
									     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
									     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
												</td>
											</tr>
										</table>
										
									
									</div>
								</h:column>
							</h:dataTable>
						</rich:simpleTogglePanel>
						
						<rich:simpleTogglePanel id="pnlSubTerminate"  switchType="client" label="#{jspMsg['label.terminate']}" 
				        opened="true" style="width:100%;margin:0 auto; padding:0px;align:top;">
							<h:dataTable id="terminate" border="0"  width="94%"
								var="obj" value="#{semmsa001Bean.menuTreeTerminateList}" 
								
								style="margin:0 auto; padding:0px;">
								<h:column>
									<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
											          reRender="panelWrapper_tree,panelWrapper_content" >
											          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
														<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
														<a4j:actionparam name="paramMenuType" value="T" />
											          </a4j:commandLink>
												</td>
												<td align="right">
													<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
											     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
											     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
												</td>
											</tr>
										</table>
										
									</div>
								</h:column>
							</h:dataTable>
						</rich:simpleTogglePanel>
						<!-- ShowReport Panel -->
		                <h:panelGrid id="show_report" style="height:50px;width:50px;" width="0" columns="0">
		                    <h:panelGroup id="show_report_in" rendered="#{semmsa001Bean.displayBtn}" style="height:0px;width:0px;" >
		                        <h:commandButton value="Export" id="btnExportExcel" style="height:0px;width:0px;display:none;" action="#{semmsa001Action.doExportExcel}">
		                         <script>document.getElementById('incContent:frmTree:btnExportExcel').click();</script>
		                        </h:commandButton>
		                    </h:panelGroup>                         
		                </h:panelGrid>
		                <!-- End Code -->
					</h:form>
					<!-- << tree menu -->

			</rich:panel>
			<!-- left content panel -->
		
		</rich:panel>

		<rich:panel id="panelWrapper_content" style="height:100%; border:1 ececec solid; vertical-align:top;">
			
			<!-- >> content panel 1 -->
			<!-- msa001SearchNewSite -->
			<a4j:include id="inc001-1"  viewId="../../pages/sa/semmsa001-1.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa02'}" />
			<!-- << content panel 1 -->
			
			<!-- >> content panel 2 -->
			<!--  -->
			<a4j:include id="inc001-2"  viewId="../../pages/sa/semmsa001-2.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa14'}" />
			<!-- << content panel 2 -->
			
			<!-- >> content panel 3 -->
			<a4j:include id="inc001-3"  viewId="../../pages/sa/semmsa001-3.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa05'}" />
			<!-- << content panel 3 -->
			
			<!-- >> content panel 4 -->
			<a4j:include id="inc001-4"  viewId="../../pages/sa/semmsa001-4.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa06'}" />
			<!-- << content panel 4 -->
			
			<!-- >> content panel 5 -->
			<a4j:include id="inc001-5"  viewId="../../pages/sa/semmsa001-5.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa07'}" />
			<!-- << content panel 5 -->
			
			<!-- >> content panel 6 -->
			<a4j:include id="inc001-6"  viewId="../../pages/sa/semmsa001-6.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa08'}" />
			<!-- << content panel 6 -->

			<!-- >> content panel 7 -->
			<a4j:include id="inc001-7"  viewId="../../pages/sa/semmsa001-7.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa09'}" />
			<!-- << content panel 7 -->
			
			<!-- >> content panel 8 -->
			<a4j:include id="inc001-8"  viewId="../../pages/sa/semmsa001-8.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa10'}" />
			<!-- << content panel 8 -->
			
			<!-- >> content panel 9 -->
			<a4j:include id="inc001-9"  viewId="../../pages/sa/semmsa001-9.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa11'}" />
			<!-- << content panel 9 -->
			
			<!-- >> content panel 10 -->
			<a4j:include id="inc001-10"  viewId="../../pages/sa/semmsa001-10.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa12'}" />
			<!-- << content panel 10 -->
			
			<!-- >> content panel 11 -->
			<a4j:include id="inc001-11"  viewId="../../pages/sa/semmsa001-11.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa13'}" />
			<!-- << content panel 11 -->
			
			<!-- >> content panel 11 -->
			<a4j:include id="inc001-12"  viewId="../../pages/sa/semmsa001-12.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa03'}" />
			<!-- << content panel 11 -->
			
			<!-- >> content panel 12 -->
			<a4j:include id="inc001-13"  viewId="../../pages/sa/semmsa001-13.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa16'}" />
			<!-- << content panel 12 -->

			<!-- >> content panel 15 -->
			<a4j:include id="inc001-15"  viewId="../../pages/sa/semmsa001-15.jsp" rendered="#{semmsa001Bean.panelDisplay == 'semmsa15'}" />
			<!-- << content panel 15 -->		
			
			<!-- >> anding page -->
			<a4j:include id="inc001-home" viewId="../../pages/sa/sem_home.jsp" rendered="#{semmsa001Bean.panelDisplay == 'sem_home'}" />
			<!-- << landing page -->
			
			
			<a4j:include id="msa001_popupCom" viewId="../../pages/sa/semmsa001PopUpCommon.jsp"/>
			<a4j:include id="msa001_popupRentSpecial" viewId="../../pages/popup/rentSpecial-popup.jsp"/>
		</rich:panel>
		
	</h:panelGrid>
	<!-- << wrapper panel -->

	
	
	
	