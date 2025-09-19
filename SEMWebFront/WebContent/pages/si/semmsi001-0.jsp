
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.siteinfo.semmsi001" var="jspMsg"/>

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelWrapperAll" style="width:100%; vertical-align:top;" columns="2">

		<rich:panel id="panelWrapper_tree" style="height:100%; border:1 ececec solid; top:0px; vertical-align:top;">
	
			<!-- left content panel -->
			<rich:panel style="border:1 e0e0e0 solid; height:100%; vertical-align:top;">
				<!-- >> header left content -->
					<f:facet name="header">
							<h:outputText value="Site Info [TO DO LIST]" />
					</f:facet>
				<!-- << header left content -->
				<div style="width:200px;">
				
					<!-- >> tree menu -->
					<h:form id="frmTree">
								
					<rich:tree style="width:300px;" nodeSelectListener="#{semmsi001Action.processSelection}" 
					ajaxSubmitSelection="true" switchType="client" onselected="navFwd" styleClass="ms7"
					value="#{semmsi001Action.treeNode}" var="item" ajaxKeys="#{null}">
					
					<rich:treeNode>  
					     <span style="width:180px; white-space:nowrap;">  
					             <a4j:commandLink value="#{item.menuLabel}" action="#{navAction.navi}" 
					             reRender="oppContent, panelWrapper_tree, panelWrapper_content" styleClass="ms7"
					             oncomplete="">
					             	
					             	<%--
						             	<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI001-0" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
										<a4j:actionparam name="methodWithNavi" value="doInitialSiteInfoToDoList" />
										
										<a4j:actionparam name="paramUrl" value="#{item.menuUrl}" />
										<a4j:actionparam name="paramMenuGroup" value="#{item.menuGroup}" />
										<a4j:actionparam name="paramMenuSubGroup" value="#{item.menuSubGroup}" />
										<a4j:actionparam name="paramParameter" value="#{item.strParam}" />
						         	--%>
						         		
						         		<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
										<a4j:actionparam name="methodWithNavi" value="doInitialForSearchSiteInfo" />
										
										<a4j:actionparam name="paramUrl" value="#{item.menuUrl}" />
										<a4j:actionparam name="paramMenuGroup" value="#{item.menuGroup}" />
										<a4j:actionparam name="paramMenuSubGroup" value="#{item.menuSubGroup}" />
										<a4j:actionparam name="paramParameter" value="#{item.strParam}" />
						         	
					             </a4j:commandLink> 
					     </span>
					     <span style="width:50px; white-space:nowrap; text-align:right;">
					     	<h:outputText value="(" rendered="#{item.recordCount == null ? false : true}" styleClass="ms7" />
					     	<h:outputText value="#{item.recordCount}" styleClass="ms7" />
					     	<h:outputText value=")" rendered="#{item.recordCount == null ? false : true}" styleClass="ms7" />
					     </span>
					</rich:treeNode> 
					
					</rich:tree>
					</h:form>
					<!-- << tree menu -->

				</div>
			</rich:panel>
			<!-- left content panel -->
		
		</rich:panel>

		
		
	</h:panelGrid>
	<!-- << wrapper panel -->

	
	
	
	