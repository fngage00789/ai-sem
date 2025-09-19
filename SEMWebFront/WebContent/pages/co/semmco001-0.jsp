
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.co.semmco001" var="jspMsg"/>
    <h:panelGrid>
            <a4j:form id="frmError">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco001Bean.renderedMsgFormSearch}">
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
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                            <tr>
                                    <td width="10%" align="right" width="15%" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                    </td>
                                    <td width="15%" valign="bottom">
                                        <h:selectOneMenu id="ddlCompany" value="#{semmco001Bean.treeUtilBean.company}">
                                        <f:selectItems value="#{semmco001Bean.companyList}"/>
                                        </h:selectOneMenu>
                                    </td>
                                    <td width="10%" align="right" width="15%" valign="bottom">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
                                    </td>
                                    <td width="15%" valign="bottom">
                                    <h:selectOneMenu id="ddlRegion" value="#{semmco001Bean.treeUtilBean.region}"> 
                                        <f:selectItems value="#{semmco001Bean.regionList}"/>
                                    </h:selectOneMenu>
                                    </td>
                              
                                    <td width="10%" align="right" valign="bottom">
                                    
                                        <h:outputText value="#{jspMsg['label.type']}" styleClass="ms7"/>
                                    </td>
                                    <td width="10%" valign="bottom">
                                        <h:selectOneMenu id="ddlType" value="#{semmco001Bean.treeUtilBean.menuSubGroup}"> 
                                            <f:selectItems value="#{semmco001Bean.todoReqTypeList}"/>
                                        </h:selectOneMenu>
                                    </td>
                                    
                                    <td width="30%">
                                        <a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
                                        action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult,dtbSiteInfo,frmTree" >
                                            <a4j:actionparam name="navModule" value="co" />
                                            <a4j:actionparam name="navProgram" value="SEMMCO001-0" />
                                            <a4j:actionparam name="moduleWithNavi" value="co" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
                                            <a4j:actionparam name="methodWithNavi" value="getTreeNode" />
                                            <a4j:actionparam name="searchFlag" value="Y"></a4j:actionparam>
                                        </a4j:commandButton>
                                        <rich:spacer width="5"/>
                                        <a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
                                        action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteInfo,btnExport,btnRun,frmTree">
                                            <a4j:actionparam name="navModule" value="co" />
                                            <a4j:actionparam name="navProgram" value="SEMMCO001-0" />
                                            <a4j:actionparam name="moduleWithNavi" value="co" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMCO001" />
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
							<h:outputText value="Contract [TO DO LIST]" />
					</f:facet>
				<!-- << header left content -->
				<div style="width:280px;">
				
					<!-- >> tree menu -->
					<h:form id="frmTree">
								
					<!-- >> Macro -->
						<rich:simpleTogglePanel id="semmco001_pnlSubMacro"  switchType="client" label="#{semmco001Bean.headerTreeMacro}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmco001Bean.treeMacroFlag}">
								<h:dataTable id="semmco001_macro" border="0"
									var="obj" value="#{semmco001Bean.menuTreeMacroList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="co" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="co" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchContract" />
			                                        
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
							<rich:simpleTogglePanel id="semmco001_pnlSubPico"  switchType="client" label="#{semmco001Bean.headerTreePico}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="false">
								<h:dataTable id="semmco001_pico" border="0"
									var="obj" value="#{semmco001Bean.menuTreePicoList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="co" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="co" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchContract" />
			                                        
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

	
	
	
	