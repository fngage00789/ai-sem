
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.siteinfo.semmsi002" var="jspMsg"/>

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelWrapperAll" style="width:100%; vertical-align:top;" columns="2">

		<rich:panel id="panelWrapper_tree" style="height:100%; border:1 ececec solid; top:0px; vertical-align:top;">
	
			<!-- left content panel -->
			<rich:panel style="border:1 e0e0e0 solid; height:100%; vertical-align:top;">
				<!-- >> header left content -->
					<f:facet name="header">
							<h:outputText value="Legal [TO DO LIST]" />
					</f:facet>
				<!-- << header left content -->
				<div style="width:280px;">
				
					<!-- >> tree menu -->
					<h:form id="frmTree">
					
					<!-- >> NEW -->
						<rich:simpleTogglePanel id="semmsi002_pnlSubNew"  switchType="client" label="#{semmsi002Bean.headerTreeNew}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmsi002Bean.treeNewFlag}">
								<h:dataTable id="semmsi002_New" border="0"
									var="obj" value="#{semmsi002Bean.menuTreeNewList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="si" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="si" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchLegal" />
			                                        
			                                        <a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
			                                        <a4j:actionparam name="paramMenuSubGroup" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="paramParameter" value="#{obj.dataObj.strParam}" />
			                                        <a4j:actionparam name="searchFlag" value="Y" />
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
							<!-- >>END NEW -->
							
							<!-- RENEW -->
							<rich:simpleTogglePanel id="semmsi002_pnlSubRenew"  switchType="client" label="#{semmsi002Bean.headerTreeRenew}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmsi002Bean.treeRenewFlag}">
								<h:dataTable id="semmsi002_Renew" border="0"
									var="obj" value="#{semmsi002Bean.menuTreeRenewList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="si" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="si" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchLegal" />
			                                        
			                                        <a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
			                                        <a4j:actionparam name="paramMenuSubGroup" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="paramParameter" value="#{obj.dataObj.strParam}" />
			                                        <a4j:actionparam name="searchFlag" value="Y" />
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
							<!-- END RENEW -->
							
							<!-- >> EDIT -->
						<rich:simpleTogglePanel id="semmsi002_pnlSubEdit"  switchType="client" label="#{semmsi002Bean.headerTreeEdit}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmsi002Bean.treeEditFlag}">
								<h:dataTable id="semmsi002_Edit" border="0"
									var="obj" value="#{semmsi002Bean.menuTreeEditList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="si" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="si" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchLegal" />
			                                        
			                                        <a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
			                                        <a4j:actionparam name="paramMenuSubGroup" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="paramParameter" value="#{obj.dataObj.strParam}" />
			                                        <a4j:actionparam name="searchFlag" value="Y" />
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
							<!-- >>END NEW -->
							
							<!-- RENEW -->
							<rich:simpleTogglePanel id="semmsi002_pnlSubTerminate"  switchType="client" label="#{semmsi002Bean.headerTreeTerminate}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmsi002Bean.treeTerminateFlag}">
								<h:dataTable id="semmsi002_Terminate" border="0"
									var="obj" value="#{semmsi002Bean.menuTreeTerminateList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="si" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="si" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchLegal" />
			                                        
			                                        <a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
			                                        <a4j:actionparam name="paramMenuSubGroup" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="paramParameter" value="#{obj.dataObj.strParam}" />
			                                        <a4j:actionparam name="searchFlag" value="Y" />
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
							<!-- END RENEW -->
					</h:form>
					<!-- << tree menu -->

				</div>
			</rich:panel>
			<!-- left content panel -->
		
		</rich:panel>

		
		
	</h:panelGrid>
	<!-- << wrapper panel -->

	
	
	
	