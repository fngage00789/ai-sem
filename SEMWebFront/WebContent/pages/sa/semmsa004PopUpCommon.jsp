
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa004" var="jspMsg" />
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->	
		
	<!-- >> [POPUP_00] -->
	<!-- msa004PopUpCommon_retStatus -->
	<rich:modalPanel id="msa004PopUpCommon_retStatus" autosized="true" rendered="#{semmsa004Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa004PopUpCommon_retStatus" style="cursor:pointer" />
					<rich:componentControl for="msa004PopUpCommon_retStatus" attachTo="hide-msa004PopUpCommon_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa004_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="300">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue_custom" infoClass="ms7green" rendered="#{semmsa004Bean.renderedMsgAlert}">
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
					    <rich:componentControl for="msa004PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- msa004PopUpCommon_retStatus -->
	<!-- << [POPUP_00] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_01] -->
	<rich:modalPanel id="msa004PopUpCommon_confirmApprove" width="300" autosized="true">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Approve"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa004PopUpCommon_confirmApprove" style="cursor:pointer" />
					<rich:componentControl for="msa004PopUpCommon_confirmApprove" attachTo="hide-msa004PopUpCommon_confirmApprove" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa004PopUpCommon_confirmApprove">
		<!-- >> group detail -->
		<center>
			<h:outputText value="#{jspMsg['label.th_confirm_approve']}" styleClass="ms7" />
		</center>
		<!-- << group detail -->

		<div style="clear:both; height:10px;"></div>

		<!-- >> additional button close -->
		<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
			<h:panelGroup style="float:right;">
				<a4j:commandButton value="Ok" styleClass="rich-button" style="margin-right:5px;"
				action="#{semmsa004Action.doSaveAvpApprove}" reRender="oppContent, dataTableExctApproveList"
				oncomplete="#{rich:component('msa004PopUpCommon_retStatus')}.show();">
					<a4j:actionparam name="paramSiteAppId" value="#{semmsa004Bean.siteAppObjParam.siteAppId}" />
				</a4j:commandButton>
				
				<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
				    <rich:componentControl for="msa004PopUpCommon_confirmApprove" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGroup>
		</h:panelGrid>
		<!-- << additional button close -->
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_01] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_02] -->
	<rich:modalPanel id="msa004PopUpCommon_confirmReject" width="700" autosized="true">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_rejectReason']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa004PopUpCommon_confirmReject" style="cursor:pointer" />
					<rich:componentControl for="msa004PopUpCommon_confirmReject" attachTo="hide-msa004PopUpCommon_confirmReject" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa004PopUpCommon_confirmReject">
		<!-- >> group detail -->
		
		<h:inputTextarea id="rejectRemark" value="#{semmsa004Bean.siteAppObjParam.remark}" 
		rows="7" cols="30" style="width:100%;" styleClass="ms7"></h:inputTextarea>
		
		<!-- << group detail -->

		<div style="clear:both; height:10px;"></div>

		<!-- >> additional button close -->
		<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
			<h:panelGroup style="float:right;">
				<a4j:commandButton value="Ok" styleClass="rich-button" style="margin-right:5px;"
				action="#{semmsa004Action.doSaveReject}" reRender="oppContent, frmExctApproveList, dataTableExctApproveList"
				oncomplete="#{rich:component('msa004PopUpCommon_retStatus')}.show();">
					<a4j:actionparam name="paramSiteAppId" value="#{semmsa004Bean.siteAppObjParam.siteAppId}" />
				</a4j:commandButton>
				
				<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
				    <rich:componentControl for="msa004PopUpCommon_confirmReject" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGroup>
		</h:panelGrid>
		<!-- << additional button close -->
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_02] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	
	<!-- << [POPUP_03] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->
