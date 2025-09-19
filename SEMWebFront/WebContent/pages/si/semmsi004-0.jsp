
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
    <h:panelGrid>
            <a4j:form id="frmError">
                <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004Bean.renderedMsgFormSearch}">
                        <f:facet name="header">
                            <h:outputText value="Entered Data Status:"></h:outputText>
                        </f:facet>
                        <f:facet name="errorMarker">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
            </a4j:form>
        </h:panelGrid>
	<!-- >> wrapper panel -->
	<h:panelGrid id="panelWrapperAll" style="width:100%; vertical-align:top;" columns="2">

		<rich:panel id="panelWrapper_tree" style="height:100%; border:1 ececec solid; top:0px; vertical-align:top;">
	       <!-- search panel -->    
	       <h:form id="frmSearch">
	       <rich:panel id="pnlSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.criteria.name']}"/>
                        </f:facet>
                        <!-- begin content criteria -->
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0">
                            <h:panelGroup>
                            <table width="100%" align="left">
                            <tr>
                                    <td width="10%" align="right" width="15%" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                    </td>
                                    <td width="15%" valign="bottom">
                                        <h:selectOneMenu id="ddlCompany" value="#{semmsi004Bean.treeUtilBean.company}">
                                        <f:selectItems value="#{semmsi004Bean.companyList}"/>
                                        </h:selectOneMenu>
                                    </td>
                                    <td width="10%" align="right" width="15%" valign="bottom">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
                                    </td>
                                    <td width="15%" valign="bottom">
                                    <h:selectOneMenu id="ddlRegion" value="#{semmsi004Bean.treeUtilBean.region}"> 
                                        <f:selectItems value="#{semmsi004Bean.regionList}"/>
                                    </h:selectOneMenu>
                                    </td>
                              
                                    <td width="10%" align="right" valign="bottom">
                                    
                                        <h:outputText value="#{jspMsg['label.type']}" styleClass="ms7"/>
                                    </td>
                                    <td width="10%" valign="bottom">
                                        <h:selectOneMenu id="ddlType" value="#{semmsi004Bean.treeUtilBean.menuSubGroup}"> 
                                            <f:selectItems value="#{semmsi004Bean.todoReqTypeList}"/>
	                                    </h:selectOneMenu>
                                    </td>
                                    
                                    <td width="30%" align="center">
                                        <a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
			                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult,dtbSiteInfo,frmTree" >
				                            <a4j:actionparam name="navModule" value="si" />
				                            <a4j:actionparam name="navProgram" value="SEMMSI004-0" />
				                            <a4j:actionparam name="moduleWithNavi" value="si" />
				                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
				                            <a4j:actionparam name="methodWithNavi" value="getTreeNode" />
				                            <a4j:actionparam name="searchFlag" value="Y"></a4j:actionparam>
			                            </a4j:commandButton>
			                            <rich:spacer width="5"/>
			                            <a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteInfo,btnExport,btnRun,frmTree">
				                            <a4j:actionparam name="navModule" value="si" />
				                            <a4j:actionparam name="navProgram" value="SEMMSI004-0" />
				                            <a4j:actionparam name="moduleWithNavi" value="si" />
				                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
				                            <a4j:actionparam name="methodWithNavi" value="doClear" />
			                            </a4j:commandButton>
                                    </td>
                                 </tr>
                                 
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                        <!-- end content criteria -->
                        <h:panelGrid columns="2" id="grdSearchCommand">
                            
                        </h:panelGrid>
                    </rich:panel>
                 </h:form>
            <!-- END Search Panel -->
	           
			<!-- left content panel -->
			<rich:panel style="border:1 e0e0e0 solid; height:100%; vertical-align:top;">
				<!-- >> header left content -->
					<f:facet name="header">
							<h:outputText value="Site Info [TO DO LIST]" />
					</f:facet>
				<!-- << header left content -->
				<div style="width:280px;">
				
					<!-- >> tree menu -->
					<h:form id="frmTree">
						<!-- >> Macro -->
						<rich:simpleTogglePanel id="semmsi004_pnlSubMacro"  switchType="client" label="#{semmsi004Bean.headerTreeMacro}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmsi004Bean.treeMacroFlag}">
								<h:dataTable id="semmsi004_macro" border="0"
									var="obj" value="#{semmsi004Bean.menuTreeMacroList}" 
									
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
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchSiteInfo" />
			                                        
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
							<!-- >>END Macro -->
							
							<!-- Pico -->
							<rich:simpleTogglePanel id="semmsi004_pnlSubPico"  switchType="client" label="#{semmsi004Bean.headerTreePico}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="false">
								<h:dataTable id="semmsi004_pico" border="0"
									var="obj" value="#{semmsi004Bean.menuTreePicoList}" 
									
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
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchSiteInfo" />
			                                        
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
							<!-- END Pico -->
						</h:form>
					<!-- << tree menu -->

				</div>
			</rich:panel>
			<!-- left content panel -->
		
		</rich:panel>

		
		
	</h:panelGrid>
	<!-- << wrapper panel -->

	
	
	
	