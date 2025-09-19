<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.zone" var="jspMsgLO" />
<rich:modalPanel id="popupMultiZone" width="800" height="650" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgLO['header.searchZone']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupZone" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupMultiZone" attachTo="hidePopupZone" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupMultiZoneFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupMultiZoneFrmSearch" ajaxSubmit="true">
		<h:panelGrid id="pnlGirdpopupMultiZoneSearch" width="100%">
			<rich:panel id="pnlpopupMultiZoneSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgLO['header.criteriaZone']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgLO['label.region']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtpopupMultiZone" value="#{popupMultiZoneBean.region}" size="30" maxlength="50" />
								</td>
							</tr>

							<tr>
								<td/>
								<td/>
							</tr>
							
							<tr>
								<td colspan="4">
									<h:panelGroup>
										<a4j:commandButton id="btnpopupMultiZoneSearch"
											value="#{jspMsgLO['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"							
											reRender="btnpopupMultiZoneSave, dtbpopupMultiZone, pnlGirdpopupMultiZoneSearch, popupMultiZoneFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="multiZone-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnpopupMultiZoneClear"
											value="#{jspMsgLO['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlpopupMultiZoneSearch, popupMultiZoneFrmError,popupMultiZoneFrmResult">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="multiZone-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
											<a4j:actionparam name="methodWithNavi" value="doClear" />
										</a4j:commandButton>
									</h:panelGroup>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>	
	
	<a4j:form id="popupMultiZoneFrmResult">
		<rich:panel>
			<f:facet name="header" >
				<h:outputText value="#{jspMsgLO['header.result']}" />
			</f:facet>
			
			<rich:dataTable id="dtbpopupMultiZone" cellpadding="1" cellspacing="0" border="0" 
							var="objSiteLocation" value="#{popupMultiZoneBean.zoneList}"
							rowKeyVar="RegInd" rows="#{popupMultiZoneBean.rowPerPage}" reRender="dtbpopupMultiZone"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" styleClass="contentform" width="92%">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<a4j:region>
							<h:selectBooleanCheckbox value="#{popupMultiZoneBean.selectedAll}" >
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="popupMultiZoneFrmResult">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="multiZone-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<a4j:region>
						<h:selectBooleanCheckbox value="#{objSiteLocation.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnpopupMultiZoneSelect">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="multiZone-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</a4j:region>
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.region}" width="180">
					<f:facet name="header">
						<h:outputText value="#{jspMsgLO['column.region']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.region}" />
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.region}" width="600">
					<f:facet name="header">
						<h:outputText value="#{jspMsgLO['column.zoneName']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.description}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							<h:outputFormat value="#{msg['message.totalRecords']}">
								<f:param value="#{fn:length(popupMultiZoneBean.zoneList)}"></f:param>
							</h:outputFormat>
						</rich:column>
						<rich:column >
							<rich:datascroller immediate="true" rendered="true" align="left" for="dtbpopupMultiZone"
								maxPages="#{popupMultiZoneBean.rowPerPage}"  selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto" 
								style="background-color: #cccccc;" 
								page="#{popupMultiZoneBean.scrollerPage}" 
							/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnpopupMultiZoneSelect" styleClass="rich-button"
							   value="#{jspMsgLO['btn.select']}" action="#{navAction.navi}" 
							   reRender="criMultiZone, popupMultiZoneFrmError, btnDelPolicyMultiZone"
							   disabled="#{popupMultiZoneBean.disableBtnGetZone}"   
							   oncomplete="#{rich:component('popupMultiZone')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="multiZone-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnpopupMultiZoneCancel" styleClass="rich-button" 
							   value="#{jspMsgLO['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupMultiZone')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="multiZone-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

