<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:loadBundle basename="resources.popup.location" var="jspMsgLO" />
<rich:modalPanel id="popupSiteLocation" width="800" height="850" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgLO['header.searchLocation']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupSiteLocation" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupSiteLocation" attachTo="hidePopupSiteLocation" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupSiteLocationFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupSiteLocationFrmSearch">
		<h:panelGrid id="pnlGirdPopupSiteLocationSearch" width="100%">
			<rich:panel id="pnlPopupSiteLocationSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgLO['header.criteriaLocation']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgLO['label.type']}" styleClass="ms7" />
								</td>
								<td>
									<h:outputText value="#{jspMsgLO['label.keyword']}" styleClass="ms7" />
								</td>
							</tr>
							
							<tr>
								<td>
									<h:selectOneMenu id="criPopupSiteLocation" value="#{popupSiteMultiLocationBean.siteLocationCatSelect}">
										<f:selectItem itemLabel="#{jspMsgLO['label.locationName']}" itemValue="NAME" />
										<f:selectItem itemLabel="#{jspMsgLO['label.locationCode']}" itemValue="CODE" />
									</h:selectOneMenu>
								</td>
								<td>
									<h:inputText id="txtPopupSiteLocation" value="#{popupSiteMultiLocationBean.siteLocationKeyWord}" 
												 size="30" maxlength="50" 
												 onkeydown="if(event.keyCode==13){document.getElementById('incContent:popupSiteLocationFrmSearch:btnPopupSiteLocationSearch').click();}">
									</h:inputText>
								</td>
							</tr>

							<tr>
								<td/>
								<td/>
							</tr>
							
							<tr>
								<td colspan="4">
									<h:panelGroup>
										<a4j:commandButton id="btnPopupSiteLocationSearch"
											value="#{jspMsgLO['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"
											reRender="btnPopupSiteLocationSave, dtbPopupSiteLocation, pnlPopupSiteLocationSearchResult, popupSiteLocationFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnPopupSiteLocationClear"
											value="#{jspMsgLO['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlPopupSiteLocationSearch, popupSiteLocationFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
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
	
	<a4j:form id="popupSiteLocationFrmResult">
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="#{jspMsgLO['header.resultLocation']}" />
			</f:facet>
			<rich:dataTable id="dtbPopupSiteLocation" 
							cellpadding="1" cellspacing="0" border="0"
							var="objSiteLocation" value="#{popupSiteMultiLocationBean.locationList}"
							rowKeyVar="RegInd" rows="#{popupSiteMultiLocationBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" width="92%"
							styleClass="contentform">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<a4j:region>
							<h:selectBooleanCheckbox disabled="#{popupSiteMultiLocationBean.disabledBtnSelectedAll}">
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="dtbPopupSiteLocation, btnPopupSiteLocationSave">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<a4j:region>
						<h:selectBooleanCheckbox value="#{objSiteLocation.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnPopupSiteLocationSave">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</a4j:region>
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.locationId}" width="180">
					<f:facet name="header">
						<h:outputText value="#{jspMsgLO['column.locationId']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.locationId}" />
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.locationName}" width="600">
					<f:facet name="header">
						<h:outputText value="#{jspMsgLO['column.locationName']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.locationName}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:datascroller id="dsbPopupSiteLocation" for="dtbPopupSiteLocation"
									   immediate="true" rendered="true" align="left" 
									   maxPages="10" selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnPopupSiteLocationSave" styleClass="rich-button"
							   value="#{jspMsgLO['btn.save']}" action="#{navAction.navi}" 
							   reRender="criSiteLocationMultiZone, btnSiteLocationMultiZone, popupSiteLocationFrmError"
							   disabled="#{popupSiteMultiLocationBean.disableBtnGetSiteLocation}"   
							   oncomplete="#{rich:component('popupSiteLocation')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnPopupSiteLocationCancel" styleClass="rich-button" 
							   value="#{jspMsgLO['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupSiteLocation')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultilocation-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiLocation" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

