<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:loadBundle basename="resources.popup.vendor" var="jspMsgVendor" />
<rich:modalPanel id="popupVendor" width="500" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgVendor['header.searchVendor']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupVendor" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupVendor" attachTo="hidePopupVendor" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupVendorFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupVendorFrmSearch">
		<h:panelGrid id="pnlGirdPopupVendorSearch" width="100%">
			<rich:panel id="pnlPopupVendorSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgVendor['header.criteriaVendor']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgVendor['label.type']}" styleClass="ms7" />
								</td>
								<td>
									<h:outputText value="#{jspMsgVendor['label.keyword']}" styleClass="ms7" />
								</td>
							</tr>
							
							<tr>
								<td>
									<h:selectOneMenu id="criPopupVendor" value="#{popupMultiVendorBean.vendorCatSelect}">
										<f:selectItem itemLabel="#{jspMsgVendor['label.vendorName']}" itemValue="NAME" />
										<f:selectItem itemLabel="#{jspMsgVendor['label.vendorCode']}" itemValue="CODE" />
									</h:selectOneMenu>
								</td>
								<td>
									<h:inputText id="txtPopupVendor" value="#{popupMultiVendorBean.vendorKeyWord}" 
												 size="30" maxlength="50" 
												 onkeydown="if(event.keyCode==13){document.getElementById('incContent:popupVendorFrmSearch:btnPopupVendorSearch').click();}">
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
										<a4j:commandButton id="btnPopupVendorSearch"
											value="#{jspMsgVendor['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"
											reRender="btnPopupVendorSave, dtbPopupVendor, pnlPopupVendorSearchResult, popupVendorFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnPopupVendorClear"
											value="#{jspMsgVendor['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlPopupVendorSearch, popupVendorFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
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
	
	<a4j:form id="popupVendorFrmResult">
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="#{jspMsgVendor['header.resultVendor']}" />
			</f:facet>
			<rich:dataTable id="dtbPopupVendor" 
							cellpadding="1" cellspacing="0" border="0"
							var="objVendor" value="#{popupMultiVendorBean.vendorList}"
							rowKeyVar="RegInd" rows="#{popupMultiVendorBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" width="92%"
							styleClass="contentform">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<h:selectBooleanCheckbox disabled="#{popupMultiVendorBean.disabledBtnSelectedAll}">
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="dtbPopupVendor, btnPopupVendorSave">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
						</f:facet>
						<h:selectBooleanCheckbox value="#{objVendor.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnPopupVendorSave">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
					</div>
				</rich:column>
				<rich:column sortBy="#{objVendor.vendorCode}" width="180">
					<f:facet name="header">
						<h:outputText value="#{jspMsgVendor['column.vendorCode']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objVendor.vendorCode}" />
					</div>
				</rich:column>
				<rich:column sortBy="#{objVendor.vendorName}" width="300">
					<f:facet name="header">
						<h:outputText value="#{jspMsgVendor['column.vendorName']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objVendor.vendorName}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:datascroller id="dsbPopupVendor" for="dtbPopupVendor"
									   immediate="true" rendered="true" align="left" 
									   maxPages="10" selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnPopupVendorSave" styleClass="rich-button"
							   value="#{jspMsgVendor['btn.save']}" action="#{navAction.navi}" 
							   reRender="criVendorMultiZone, btnVendorMultiZone, popupVendorFrmError"
							   disabled="#{popupMultiVendorBean.disableBtnGetVendor}"   
							   oncomplete="#{rich:component('popupVendor')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnPopupVendorCancel" styleClass="rich-button" 
							   value="#{jspMsgVendor['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupVendor')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultivendor-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupMultiVendor" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

