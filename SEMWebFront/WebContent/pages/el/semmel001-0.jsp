
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



    <f:loadBundle basename="resources.construction.semmcp001" var="jspMsg"/>
    <h:panelGrid>
            <a4j:form id="frmError">
                <h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
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
                                    <td align="right" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                    </td>
                                    <td valign="bottom">
                                        <h:selectOneMenu id="ddlCompany" value="#{semmel001Bean.treeUtilBean.company}">
                                        <f:selectItems value="#{semmel001Bean.companyList}"/>
                                        </h:selectOneMenu>
                                    </td>
                                    <td align="right" valign="bottom">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
                                    </td>
                                    <td valign="bottom">
                                    <h:selectOneMenu id="ddlRegion" value="#{semmel001Bean.treeUtilBean.region}"> 
                                        <f:selectItems value="#{semmel001Bean.regionList}"/>
                                    </h:selectOneMenu>
                                    </td>
                              
                                    <td width="10%" align="right" valign="bottom">
                                        <h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
                                    </td>
                                    <td valign="bottom">
                                        <h:selectOneMenu id="ddlType" value="#{semmel001Bean.searchCriteria.electricUseType}"> 
                                            <f:selectItems value="#{semmel001Bean.electricUseTypeList}" />
                                            <a4j:support event="onchange" action="#{semmel001Action.doChangeElectricUseType}" reRender="searchELAction, searchProcessStatus" />
                                        </h:selectOneMenu>
                                    </td>
                                    
                                    <td  width="10%" align="right" valign="bottom">
                                        <h:outputText value="#{jspMsg['label.processStatusName']}" styleClass="ms7"/>
                                    </td>
                                    <td valign="bottom">
                                        <a4j:region>
                                            <h:selectOneMenu id="searchELAction" value="#{semmel001Bean.searchCriteria.elAction}" 
                                            style="width : 100px">
                                                <f:selectItems value="#{semmel001Bean.elActionList}" />
                                                <a4j:support event="onchange" action="#{semmel001Action.doChangeElAction}" reRender="searchProcessStatus" />
                                            </h:selectOneMenu>
                                         </a4j:region>
                                         <rich:spacer width="5"/>
                                    </td>
                                    
                                    <td width="10%">
                                        <a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
                                        action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult,dtbSiteInfo,frmTree" >
                                            <a4j:actionparam name="navModule" value="el" />
                                            <a4j:actionparam name="navProgram" value="SEMMEl001-0" />
                                            <a4j:actionparam name="moduleWithNavi" value="el" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
                                            <a4j:actionparam name="methodWithNavi" value="getTreeNode" />
                                            <a4j:actionparam name="searchFlag" value="Y"></a4j:actionparam>
                                        </a4j:commandButton>
                                        <rich:spacer width="5"/>
                                        <a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
                                        action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteInfo,btnExport,btnRun,frmTree">
                                            <a4j:actionparam name="navModule" value="el" />
                                            <a4j:actionparam name="navProgram" value="SEMMEL001-0" />
                                            <a4j:actionparam name="moduleWithNavi" value="el" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
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
                            <h:outputText value="Electrical [TO DO LIST]" />
                    </f:facet>
                <!-- << header left content -->
                <div style="width:330px;">
                
                    <!-- >> tree menu -->
                    <h:form id="frmTree">
                                        
                    <!-- >> Macro -->
						<rich:simpleTogglePanel id="semmel001_pnlSubMacro"  switchType="client" label="#{semmel001Bean.headerTreeMacro}" 
					        opened="true" style="width:100%;margin:0 auto; padding:0px;"
					        rendered="#{semmel001Bean.treeMacroFlag}">
								<h:dataTable id="semmel001_macro" border="0"
									var="obj" value="#{semmel001Bean.menuTreeMacroList}" 
									
									style="margin:0 auto; padding:0px;">
									<h:column>
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span style="width:195px; white-space:nowrap;">  
										          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{navAction.navi}"
										          reRender="oppContent,txtNavProgram,panelWrapper_tree,panelWrapper_content" >
										          	<a4j:actionparam name="navModule" value="el" />
			                                        <a4j:actionparam name="navProgram" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="moduleWithNavi" value="el" />
			                                        <a4j:actionparam name="actionWithNavi" value="#{obj.dataObj.menuAction}" />
			                                        <a4j:actionparam name="methodWithNavi" value="doInitialForSearchElectrical" />
			                                        
			                                        <a4j:actionparam name="paramUrl" value="#{obj.dataObj.menuUrl}" />
			                                        <a4j:actionparam name="paramMenuGroup" value="#{obj.dataObj.menuGroup}" />
			                                        <a4j:actionparam name="paramMenuSubGroup" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="paramParameter" value="#{obj.dataObj.strParam}" />
			                                        <a4j:actionparam name="company" value="#{obj.dataObj.company}" />
			                                        <a4j:actionparam name="region" value="#{obj.dataObj.region}" />
			                                        <a4j:actionparam name="elType" value="#{obj.dataObj.menuSubGroup}" />
			                                        <a4j:actionparam name="elStatusName" value="#{obj.dataObj.elType}" />
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
                    </h:form>
                    <!-- << tree menu -->

                </div>
            </rich:panel>
            <!-- left content panel -->
        
        </rich:panel>

    </h:panelGrid>
    <!-- << wrapper panel -->

    
    
    
    