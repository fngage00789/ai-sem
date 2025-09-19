<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm004" var="jspMsg" />

<h:panelGrid width="100%">
	<!-- left content panel -->
	<rich:panel style="width:300px;height:100%;border:1 e0e0e0 solid; height:100%;vertical-align:top;" headerClass="headerCenter">
		<!-- >> header -->
		<f:facet name="header"><h:outputText value="#{jspMsg['header.todo.list']}" /></f:facet>
		<!-- << header -->
		
		<!-- >> tree menu -->
		<h:form id="frmTree">
			
			<rich:simpleTogglePanel id="pnlSubVendor"  switchType="client" label="#{jspMsg['header.vendor']}" 
	        opened="true" style="width:100%; margin:0 auto; padding:0px; vertical-align:top;">
				<h:dataTable id="vendorList" border="0" var="obj" 
				value="#{semmsa001Bean.menuTreeNewList}" 
				style="margin:0 auto; padding:0px;">
					<h:column>
						<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
							<span style="width:195px; white-space:nowrap;">  
						          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
						          reRender="panelWrapper_tree,panelWrapper_content" >
						          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
									<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
									<a4j:actionparam name="paramMenuType" value="N" />
						          </a4j:commandLink>
						     </span>
						     <span style="width:50px; white-space:nowrap; text-align:right;">
						     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
						     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     </span>
						</div>
					</h:column>
				</h:dataTable>
			</rich:simpleTogglePanel>
			
			<rich:simpleTogglePanel id="pnlBookbankVendor"  switchType="client" label="#{jspMsg['header.bookbank.vendor']}" 
	        opened="true" style="width:100%; margin:0 auto; padding:0px; align:top;">
				<h:dataTable id="renew" border="0"
				var="obj" value="#{semmsa001Bean.menuTreeReNewList}" 
				style="margin:0 auto; padding:0px;">
					<h:column>
						<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
							<span style="width:195px; white-space:nowrap;">  
						          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
						          reRender="panelWrapper_tree,panelWrapper_content" >
						          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
									<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
									<a4j:actionparam name="paramMenuType" value="R" />
						          </a4j:commandLink>
						     </span>
						     <span style="width:50px; white-space:nowrap; text-align:right;">
						     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
						     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     </span>
						</div>
					</h:column>
				</h:dataTable>
			</rich:simpleTogglePanel>
			
			<rich:simpleTogglePanel id="pnlSubWaiting"  switchType="client" label="#{jspMsg['header.payee']}" 
	        opened="true" style="width:100%;margin:0 auto; padding:0px;align:top;">
				<h:dataTable id="waiting" border="0"
					var="obj" value="#{semmsa001Bean.menuTreeWaitingList}" 
					
					style="margin:0 auto; padding:0px;">
					<h:column>
						<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
							<span style="width:195px; white-space:nowrap;">  
						          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
						          reRender="panelWrapper_tree,panelWrapper_content" >
						          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
									<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
									<a4j:actionparam name="paramMenuType" value="E" />
						          </a4j:commandLink>
						     </span>
						     <span style="width:50px; white-space:nowrap; text-align:right;">
						     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
						     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     </span>
						</div>
					</h:column>
				</h:dataTable>
			</rich:simpleTogglePanel>
			
			<rich:simpleTogglePanel id="pnlSubTerminate"  switchType="client" label="#{jspMsg['header.bookbank.payee']}" 
	        opened="true" style="width:100%;margin:0 auto; padding:0px;align:top;">
				<h:dataTable id="terminate" border="0"
					var="obj" value="#{semmsa001Bean.menuTreeTerminateList}" 
					
					style="margin:0 auto; padding:0px;">
					<h:column>
						<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
							<span style="width:195px; white-space:nowrap;">  
						          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmsa001Action.treeSwapPage}"
						          reRender="panelWrapper_tree,panelWrapper_content" >
						          	<a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
									<a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
									<a4j:actionparam name="paramMenuType" value="T" />
						          </a4j:commandLink>
						     </span>
						     <span style="width:50px; white-space:nowrap; text-align:right;">
						     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
						     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
						     </span>
						</div>
					</h:column>
				</h:dataTable>
			</rich:simpleTogglePanel>
			<!-- ShowReport Panel -->
               <h:panelGrid id="show_report" style="height:50px;width:50px;" width="0" columns="0">
                   <h:panelGroup id="show_report_in" rendered="#{semmsa001Bean.displayBtn}" style="height:0px;width:0px;" >
                       <h:commandButton value="Report" id="btnExportExcel" style="height:0px;width:0px;display:none;" action="#{semmsa001Action.doExportExcel}">
                        <script>document.getElementById('incContent:frmTree:btnExportExcel').click();</script>
                       </h:commandButton>
                   </h:panelGroup>                         
               </h:panelGrid>
               <!-- End Code -->
		</h:form>
		<!-- << tree menu -->
		
	</rich:panel>
	<!-- left content panel -->
</h:panelGrid>