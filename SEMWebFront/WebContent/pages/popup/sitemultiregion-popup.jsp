<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:loadBundle basename="resources.popup.region" var="jspMsgRE" />
<rich:modalPanel id="popupSiteRegion" width="500" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgRE['header.searchRegion']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupSiteRegion" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupSiteRegion" attachTo="hidePopupSiteRegion" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupSiteRegionFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupSiteRegionFrmSearch" rendered="false">
		<h:panelGrid id="pnlGirdPopupSiteRegionSearch" width="100%">
			<rich:panel id="pnlPopupSiteRegionSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgRE['header.criteriaRegion']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgRE['label.type']}" styleClass="ms7" />
								</td>
								<td>
									<h:outputText value="#{jspMsgRE['label.keyword']}" styleClass="ms7" />
								</td>
							</tr>
							
							<tr>
								<td>
									<h:selectOneMenu id="criPopupSiteRegion" value="#{popupSiteMultiRegionBean.siteRegionCatSelect}">
										<f:selectItem itemLabel="#{jspMsgRE['label.thaiDescription']}" itemValue="NAME" />
										<f:selectItem itemLabel="#{jspMsgRE['label.rowId']}" itemValue="CODE" />
									</h:selectOneMenu>
								</td>
								<td>
									<h:inputText id="txtPopupSiteRegion" value="#{popupSiteMultiRegionBean.siteRegionKeyWord}" 
												 size="30" maxlength="50" 
												 onkeydown="if(event.keyCode==13){document.getElementById('incContent:popupSiteRegionFrmSearch:btnPopupSiteRegionSearch').click();}">
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
										<a4j:commandButton id="btnPopupSiteRegionSearch"
											value="#{jspMsgRE['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"
											reRender="btnPopupSiteRegionSave, dtbPopupSiteRegion, pnlPopupSiteRegionSearchResult, popupSiteRegionFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnPopupSiteRegionClear"
											value="#{jspMsgRE['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlPopupSiteRegionSearch, popupSiteRegionFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
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
	
	<a4j:form id="popupSiteRegionFrmResult">
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="#{jspMsgRE['header.resultRegion']}" />
			</f:facet>
			<rich:dataTable id="dtbPopupSiteRegion" 
							cellpadding="1" cellspacing="0" border="0"
							var="objSiteRegion" value="#{popupSiteMultiRegionBean.regionList}"
							rowKeyVar="RegInd" rows="#{popupSiteMultiRegionBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" width="92%"
							styleClass="contentform">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<a4j:region>
							<h:selectBooleanCheckbox disabled="#{popupSiteMultiRegionBean.disabledBtnSelectedAll}">
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="dtbPopupSiteRegion, btnPopupSiteRegionSave">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<a4j:region>
						<h:selectBooleanCheckbox value="#{objSiteRegion.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnPopupSiteRegionSave">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</a4j:region>
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteRegion.rowId}" width="80">
					<f:facet name="header">
						<h:outputText value="#{jspMsgRE['column.region']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteRegion.rowId}" />
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteRegion.thaiDescription}" width="400">
					<f:facet name="header">
						<h:outputText value="#{jspMsgRE['column.thaiDescription']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteRegion.thaiDescription}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:datascroller id="dsbPopupSiteRegion" for="dtbPopupSiteRegion"
									   immediate="true" rendered="true" align="left" 
									   maxPages="10" selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnPopupSiteRegionSave" styleClass="rich-button"
							   value="#{jspMsgRE['btn.save']}" action="#{navAction.navi}" 
							   reRender="criSiteRegionMultiZone, btnSiteRegionMultiZone, popupSiteRegionFrmError"
							   disabled="#{popupSiteMultiRegionBean.disableBtnGetSiteRegion}"   
							   oncomplete="#{rich:component('popupSiteRegion')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnPopupSiteRegionCancel" styleClass="rich-button" 
							   value="#{jspMsgRE['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupSiteRegion')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemultiregion-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiRegion" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

