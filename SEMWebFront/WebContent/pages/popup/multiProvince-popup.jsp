<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.province" var="jspMsgPro" />
<rich:modalPanel id="popupMultiProvince" width="800" height="650" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgPro['header.searchProvince']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupProvince" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupMultiProvince" attachTo="hidePopupProvince" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupMultiProvinceFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupMultiProvinceFrmSearch">
		<h:panelGrid id="pnlGirdpopupMultiProvinceSearch" width="100%">
			<rich:panel id="pnlpopupMultiProvinceSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgPro['header.criteriaProvince']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgPro['label.region']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupProvinceRegion" value="#{popupMultiProvinceBean.region}" size="30" maxlength="50" />
								</td>
								<td width="50%">
									<h:outputText value="#{jspMsgPro['label.provinceName']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupProvinceName" value="#{popupMultiProvinceBean.provinceName}" size="30" maxlength="50" />
								</td>
							</tr>

							<tr>
								<td/>
								<td/>
							</tr>
							
							<tr>
								<td colspan="4">
									<h:panelGroup>
										<a4j:commandButton id="btnpopupMultiProvinceSearch"
											value="#{jspMsgPro['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"							
											reRender="btnpopupMultiProvinceSave, dtbpopupMultiProvince, pnlGirdpopupMultiProvinceSearch, popupMultiProvinceFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="multiProvince-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnpopupMultiProvinceClear"
											value="#{jspMsgPro['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlpopupMultiProvinceSearch, popupMultiProvinceFrmError,popupMultiProvinceFrmResult">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="multiProvince-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
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
	
	<a4j:form id="popupMultiProvinceFrmResult">
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="#{jspMsgPro['header.result']}" />
			</f:facet>
			<rich:dataTable id="dtbpopupMultiProvince" 
							cellpadding="1" cellspacing="0" border="0"
							var="objSiteLocation" value="#{popupMultiProvinceBean.provinceList}"
							rowKeyVar="RegInd" rows="#{popupMultiProvinceBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" width="92%"
							styleClass="contentform">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<a4j:region>
							<h:selectBooleanCheckbox value="#{popupMultiProvinceBean.selectedAll}">
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="popupMultiProvinceFrmResult">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="multiProvince-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<a4j:region>
						<h:selectBooleanCheckbox value="#{objSiteLocation.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnpopupMultiProvinceSelect">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="multiProvince-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</a4j:region>
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.region}" width="180">
					<f:facet name="header">
						<h:outputText value="#{jspMsgPro['column.region']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.samRegion}" />
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteLocation.region}" width="600">
					<f:facet name="header">
						<h:outputText value="#{jspMsgPro['column.provinceName']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteLocation.thaiName}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							<h:outputFormat value="#{msg['message.totalRecords']}">
								<f:param value="#{fn:length(popupMultiProvinceBean.provinceList)}"></f:param>
							</h:outputFormat>
						</rich:column>
						<rich:column >
							<rich:datascroller immediate="true" rendered="true" align="left" for="dtbpopupMultiProvince"
								maxPages="#{popupMultiProvinceBean.rowPerPage}"  selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto" 
								style="background-color: #cccccc;" 
								page="#{popupMultiProvinceBean.scrollerPage}" 
							/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnpopupMultiProvinceSelect" styleClass="rich-button"
							   value="#{jspMsgPro['btn.select']}" action="#{navAction.navi}" 
							   reRender="criMultiProvince, popupMultiProvinceFrmError, btnDelPolicyMultiProvince"
							   disabled="#{popupMultiProvinceBean.disableBtnGetProvice}"   
							   oncomplete="#{rich:component('popupMultiProvince')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="multiProvince-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnpopupMultiProvinceCancel" styleClass="rich-button" 
							   value="#{jspMsgPro['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupMultiProvince')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="multiProvince-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

