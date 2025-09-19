<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.siteinfo.semmsi001" var="jspMsg1"/>
<rich:modalPanel id="popupSearchSiteLocation" width="500" autosized="true" 
	minWidth="220" height="600">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg1['header.popupLocation.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchLocation" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchSiteLocation" attachTo="hidepopupSearchLocation" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:panelGrid>
		<a4j:form id="popupSiteLocationFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
		</a4j:form>
	</h:panelGrid>
	<h:form id="popupSiteLocationFrmSearch"> 
		<h:panelGrid width="800" id="grdPopupSearchCriteria">
			<rich:panel id="pnlPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsg1['header.criteria.name']}"/>
					</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"><h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg1['label.locationId']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupLocationId" value="#{popupSiteLocationBean.siteLocationCriteria.locationId}"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg1['label.locationCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupLocationCode" value="#{popupSiteLocationBean.siteLocationCriteria.locationCode}"/>
				                	</td>
			                	</tr>
			                	<tr>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg1['label.locationName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
										<h:inputText id="txtPopupLocationName" 
											value="#{popupSiteLocationBean.siteLocationCriteria.locationName}" 
											size="30"/>
				                	</td>
				                	<td align="right" width="10%" style="white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_name']}#{jspMsg['label.th_site']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="tab1AddSite_siteName" value="#{popupSiteLocationBean.siteLocationCriteria.siteName}" 
		                				size="30" maxlength="20"/>
				                	</td>
			                	</tr>
			                	<tr>
									<td align="right" width="10%">
										<h:outputText value="Site ID :" styleClass="ms7"/>
		                			</td>
		                			<td width="20%">
		                				<h:inputText id="tab1AddSite_txtSiteId" value="#{popupSiteLocationBean.siteLocationCriteria.siteId}" 
		                				size="20" maxlength="20"/>
				                	</td>
				                	<td align="right" width="10%">
										<h:outputText value="Site Code :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                				<h:inputText id="tab1AddSite_txtSiteCode" value="#{popupSiteLocationBean.siteLocationCriteria.siteCode}" 
		                				size="20" maxlength="20"/>
				                	</td>
								</tr>
			            	</table>
						</h:panelGroup></h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdPopupSearchCommand">
							<a4j:commandButton id="btnPopupSiteLocationSearch" value="#{jspMsg1['btn.search']}" styleClass="rich-button"
								action="#{navAction.navi}" reRender="dtbPopupLocation,pnlPopupLocationResult,popupSiteLocationFrmError" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="PopupSiteLocation" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
								<a4j:actionparam name="methodWithNavi" value="doSearchSiteLocation" />
							</a4j:commandButton>
							<a4j:commandButton id="btnPopupSiteLocationClear" value="#{jspMsg1['btn.clear']}" styleClass="rich-button"
								action="#{navAction.navi}" reRender="dtbPopupLocation,pnlPopupLocationResult,popupSiteLocationFrmSearch" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="PopupSiteLocation" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
								<a4j:actionparam name="methodWithNavi" value="doClearSiteLocation" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="800" id="grdPopupLocationResult">
					<rich:panel id="pnlPopupLocationResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg1['header.popupLocation.resultTable.name']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupLocation" width="95%"
							value="#{popupSiteLocationBean.siteLocationList}" 
							rows="10" 
							rowKeyVar="RegInd" var="siteLocation" 
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
							rowClasses="cur" 
							styleClass="contentform">
							<rich:column id="ContractNoSelect" width="50">
								<f:facet name="header">
									<h:outputText value="" />
								</f:facet>
								<div align="center">
									<a4j:commandLink id="cmlSelect" value="select" action="#{navAction.navi}" 
													 rendered="#{empty popupSiteLocationBean.moduleWithNaviFrom
													 				or empty popupSiteLocationBean.actionWithNaviFrom
													 				or empty popupSiteLocationBean.methodWithNaviFrom}"
													 reRender="popupSearchSiteLocation,pnlSiteApproveMapLoc,pnlSearchLocationCriteria,pnlSiteApprove">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="PopupSiteLocation" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
										<a4j:actionparam name="methodWithNavi" value="doSelectSiteLocation" />
										
										<a4j:actionparam name="rowId" value="#{siteLocation.rowId}"/>
										<a4j:actionparam name="locationId" value="#{siteLocation.locationId}"/>
										<a4j:actionparam name="locationCode" value="#{siteLocation.locationCode}"/>
										<a4j:actionparam name="locationName" value="#{siteLocation.locationName}"/>
										<a4j:actionparam name="region" value="#{siteLocation.region}"/>
										<a4j:actionparam name="contractNo" value="#{siteLocation.contractNo}"/>
										<a4j:actionparam name="stationType" value="#{siteLocation.stationType}"/>
										<a4j:actionparam name="networkStatus" value="#{siteLocation.networkStatus}"/>
										<rich:componentControl for="popupSearchSiteLocation" operation="hide" event="onclick" />
									</a4j:commandLink>
									
									<a4j:commandLink value="select" action="#{navAction.navi}" 
													 rendered="#{not empty popupSiteLocationBean.moduleWithNaviFrom
													 				and not empty popupSiteLocationBean.actionWithNaviFrom
													 				and not empty popupSiteLocationBean.methodWithNaviFrom}"
													 reRender="frmSave">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="PopupSiteLocation" />
										<a4j:actionparam name="moduleWithNavi" value="#{popupSiteLocationBean.moduleWithNaviFrom}" />
										<a4j:actionparam name="actionWithNavi" value="#{popupSiteLocationBean.actionWithNaviFrom}" />
										<a4j:actionparam name="methodWithNavi" value="#{popupSiteLocationBean.methodWithNaviFrom}" />
										<a4j:actionparam name="locationId" value="#{siteLocation.locationId}"/>
										<a4j:actionparam name="locationCode" value="#{siteLocation.locationCode}"/>
										<a4j:actionparam name="locationName" value="#{siteLocation.locationName}"/>
										<a4j:actionparam name="region" value="#{siteLocation.region}"/>
										<a4j:actionparam name="province" value="#{siteLocation.province}"/>
										<a4j:actionparam name="address" value="#{siteLocation.address}"/>
										<a4j:actionparam name="contractNo" value="#{siteLocation.contractNo}"/>
										<a4j:actionparam name="networkStatus" value="#{siteLocation.networkStatus}"/>
										<rich:componentControl for="popupSearchSiteLocation" operation="hide" event="onclick" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.locationId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.locationId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLocation.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.locationCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.locationCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLocation.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.locationName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteLocation.locationName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.siteCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.siteCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLocation.siteCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteLocation.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.region}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.region']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLocation.region}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLocation.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg1['column.header.contractNo2']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLocation.contractNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupLocation" 
									maxPages="10" id="dstPopuplocation" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
	</h:form>
</rich:modalPanel>