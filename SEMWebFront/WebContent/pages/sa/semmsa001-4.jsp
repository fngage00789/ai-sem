
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-4" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa06'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_waitingForManagerApprove']} [semmsa001-4]"/>
					</f:facet>
				<!-- << header content 2 -->

				<rich:panel styleClass="sem_autoScrollbarInTodoSA">
					<!-- >> tab panel -->
					<h:panelGrid style="width:100%;">
						<rich:tabPanel id="panelTab_managerApprove" selectedTab="#{semmsa001Bean.selectedTab}" switchType="client" style="width:100%;">
							<rich:tab label="#{jspMsg['label.th_waitingForManagerApprove']} Batch" id="managerApproveTab0" onlabelclick="setManagerAppTabNo0();">
								<a4j:jsFunction name="setManagerAppTabNo0" action="#{navAction.navi}" 
						         reRender="panelTab_managerApprove, panelWrapper001-4">
				        			<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA001-4" />
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA001" />
									<a4j:actionparam name="methodWithNavi" value="doInitManagerAppChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="0"/>
						        </a4j:jsFunction>
					           	<a4j:include id="msa001-4_incTab0"  viewId="../../pages/sa/semmsa001-4tab0.jsp" />
					       	</rich:tab>
							<rich:tab label="#{jspMsg['label.th_waitingForManagerApprove']} All Record" id="managerApproveTab1" onlabelclick="setManagerAppTabNo1();">
								<a4j:jsFunction name="setManagerAppTabNo1" action="#{navAction.navi}"
						         reRender="panelTab_managerApprove, panelWrapper001-4tab1">
				        			<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA001-4" />
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA001" />
									<a4j:actionparam name="methodWithNavi" value="doInitManagerAppChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="1"/>
						        </a4j:jsFunction>
					           	<a4j:include id="msa001-4_incTab1"  viewId="../../pages/sa/semmsa001-4tab1.jsp" />
					       	</rich:tab>
					  	</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->
	
	
	<!-- >> [POPUP_00] -->
	<!-- popUpMsa001-4_retStatus -->
	<rich:modalPanel id="popUpMsa001-4_retStatus" autosized="true" rendered="#{semmsa001Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-popUpMsa001-4_retStatus" style="cursor:pointer" />
					<rich:componentControl for="popUpMsa001-4_retStatus" attachTo="hide-popUpMsa001-4_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa001-4_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa001Bean.renderedMsgAlert}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" style="margin-right:5px;" />  
                    </f:facet>
	            </rich:messages>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="popUpMsa001-4_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- popUpMsa001-4_retStatus -->
	<!-- << [POPUP_00] -->