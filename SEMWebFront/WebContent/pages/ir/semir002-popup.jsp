<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:modalPanel id="popupFrmAdd" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Search Region"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpAdd" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmAdd" attachTo="hidePopUpAdd" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	<h:form id="popupFrmSearch"> 
			<rich:panel>
			  <rich:dataTable id="dtbRegion" width="95%"
						value="#{popupRegionBean.regions}" rows="5" 
						rowKeyVar="RegInd" var="serviceRec" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						styleClass="contentform">
				
						<rich:column id="RegionCheck" width="50">
							<f:facet name="header">
								<h:outputText value="Select" />
							</f:facet>
							<div align="center">
							<h:selectBooleanCheckbox id="RegionHeaderCheck" value="#{serviceRec.selected}" onclick="RegionHeaderCheckJS();">
								<a4j:jsFunction name="RegionHeaderCheckJS" reRender="RegionCheck"></a4j:jsFunction>
							</h:selectBooleanCheckbox>
							<!-- 
							<sem:radioButton id="rdBtSel"
			  							name="rdCol"
			  							overrideName="true"
			  							value="#{semir002Bean.selectedRadio}"
			  							itemValue="#{serviceRec.rowId}"/>
				  							
							<a4j:jsFunction name="LovHeaderCheckJS" action="#{applyValueNewRegistrationAction.renderBtnDealerAdd}" />
							 -->
							</div>
						</rich:column>
		
						<rich:column id="colRegionCode" sortBy="#{serviceRec.rowId}">
							<f:facet name="header">
								<h:outputText value="Region" />
							</f:facet>
							<h:outputText value="#{serviceRec.rowId}" />
						</rich:column>
		
						<rich:column id="colRegionName" sortBy="#{serviceRec.engDescription}">
							<f:facet name="header">
								<h:outputText value="Region Name" />
							</f:facet>
							<h:outputText value="#{serviceRec.engDescription}" />
						</rich:column>
						
						<rich:column id="colRegionNameTh" sortBy="#{serviceRec.thaiDescription}">
							<f:facet name="header">
								<h:outputText value="Region Name Thai" />
							</f:facet>
							<h:outputText value="#{serviceRec.thaiDescription}" />
						</rich:column>
		
						<f:facet name="footer">
							<rich:datascroller id="ds" for="dtbRegion" selectedStyleClass="selectScroll"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</rich:panel>	
				<rich:spacer height="10" style="display:block"></rich:spacer>
				<h:panelGrid columns="2">
					<a4j:commandButton  id="btnRegionAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 
										value="Add" 
										reRender="popupFrmSearch,frmSearch">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMIR002" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
						<a4j:actionparam name="methodWithNavi" value="addRegion" />	
					</a4j:commandButton>
					<a4j:commandButton id="BtnAccountCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupFrmAdd" attachTo="btnRegionAddBySelect" operation="hide" event="onclick" />
				</h:panelGrid>
				</h:form>
</rich:modalPanel>

<rich:modalPanel id="popupProvinceFrmAdd" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Search Province"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpProvinceAdd" style="cursor:pointer"/>
				<rich:componentControl for="popupProvinceFrmAdd" attachTo="hidePopUpProvinceAdd" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	<h:form id="popupProvinceFrmSearch"> 
		<rich:panel>
				<table width="60%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Code :" />
							<h:inputText id="txtProvinceCode" value="#{popupProvinceBean.province.provinceCode}" />
						</h:panelGrid></td>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Name :" />
							<h:inputText id="txtProvinceName" value="#{popupProvinceBean.province.thaiName}" />
						</h:panelGrid></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
							<h:panelGrid columns="2">
								<a4j:commandButton  id="btnProvinceSearch" styleClass="rich-button" 
													action="#{navAction.navi}" 
													value="Search" 
													reRender="dtbProvince">
										<a4j:actionparam name="navModule" value="ir" />
				            			<a4j:actionparam name="navProgram" value="SEMIR002" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
										<a4j:actionparam name="methodWithNavi" value="doSearchProvince" />	
								 </a4j:commandButton>
								<a4j:commandButton id="btnProvinceReset" value="Reset" 
									action="#{navAction.navi}" reRender="popupProvinceFrmSearch" styleClass="rich-button" />
							</h:panelGrid>
						</td>
					</tr>
				</table>
			</rich:panel>
			<rich:panel>
			  <rich:dataTable id="dtbProvince" width="95%"
						value="#{popupProvinceBean.provinces}" rows="5" 
						rowKeyVar="RegInd" var="serviceRec" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						styleClass="contentform">
				
						<rich:column id="ProvinceCheck" width="50">
							<f:facet name="header">
								<h:outputText value="Select" />
							</f:facet>
							<div align="center">
							<h:selectBooleanCheckbox id="ProvinceHeaderCheck" value="#{serviceRec.selected}" onclick="ProvinceHeaderCheckJS();">
								<a4j:jsFunction name="ProvinceHeaderCheckJS" reRender="ProvinceCheck"></a4j:jsFunction>
							</h:selectBooleanCheckbox>
							
							</div>
						</rich:column>
		
						<rich:column id="colProvinceCode" sortBy="#{serviceRec.rowId}">
							<f:facet name="header">
								<h:outputText value="Province Code" />
							</f:facet>
							<h:outputText value="#{serviceRec.rowId}" />
						</rich:column>
		
						<rich:column id="colProvinceName" sortBy="#{serviceRec.thaiName}">
							<f:facet name="header">
								<h:outputText value="Province Name" />
							</f:facet>
							<h:outputText value="#{serviceRec.thaiName}" />
						</rich:column>
		
						<f:facet name="footer">
							<rich:datascroller id="dsProvince" for="dtbProvince" selectedStyleClass="selectScroll"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</rich:panel>	
				<rich:spacer height="10" style="display:block"></rich:spacer>
				<h:panelGrid columns="2">
					<a4j:commandButton  id="btnProvinceAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 
										value="Add" 
										reRender="popupProvinceFrmSearch,frmSearch">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMIR002" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
						<a4j:actionparam name="methodWithNavi" value="addProvince" />	
					</a4j:commandButton>
					<a4j:commandButton id="BtnProvinceCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupProvinceFrmAdd" attachTo="btnProvinceAddBySelect" operation="hide" event="onclick" />
				</h:panelGrid>
				</h:form>
</rich:modalPanel>
<rich:modalPanel id="popupLocationFrmAdd" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Search Location"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpLocationAdd" style="cursor:pointer"/>
				<rich:componentControl for="popupLocationFrmAdd" attachTo="hidePopUpLocationAdd" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	<h:form id="popupLocationFrmSearch"> 
		<rich:panel>
				<table width="60%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Id :" />
							<h:inputText id="txtLocationId" value="#{semir002Bean.location.locationId}" />
						</h:panelGrid></td>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Code :" />
							<h:inputText id="txtLocationCode" value="#{semir002Bean.location.locationCode}" />
						</h:panelGrid></td>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Name :" />
							<h:inputText id="txtLocationName" value="#{semir002Bean.location.locationName}" />
						</h:panelGrid></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
							<h:panelGrid columns="2">
								<a4j:commandButton  id="btnLocationSearch" styleClass="rich-button" 
													action="#{navAction.navi}" 
													value="Search" 
													reRender="dtbLocation">
										<a4j:actionparam name="navModule" value="ir" />
				            			<a4j:actionparam name="navProgram" value="SEMIR002" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
										<a4j:actionparam name="methodWithNavi" value="doSearchLocation" />	
								 </a4j:commandButton>
								<a4j:commandButton id="btnLocationReset" value="Reset" 
									action="#{navAction.navi}" reRender="popupLocationFrmSearch" styleClass="rich-button" />
							</h:panelGrid>
						</td>
					</tr>
				</table>
			</rich:panel>
			<rich:panel>
			  <rich:dataTable id="dtbLocation" width="95%"
						value="#{semir002Bean.locations}" rows="5" 
						rowKeyVar="RegInd" var="serviceRec" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						styleClass="contentform">
				
						<rich:column id="LocationCheck" width="50">
							<f:facet name="header">
								<h:outputText value="Select" />
							</f:facet>
							<div align="center">
							<sem:radioButton id="rdBtSel"
			  							name="rdCol"
			  							overrideName="true"
			  							value="#{semir002Bean.selectedRadio}"
			  							itemValue="#{serviceRec.rowId}"/>
							
							</div>
						</rich:column>

						<rich:column id="colLocationId" sortBy="#{serviceRec.locationId}">
							<f:facet name="header">
								<h:outputText value="Location Id" />
							</f:facet>
							<h:outputText value="#{serviceRec.locationId}" />
						</rich:column>
		
						<rich:column id="colLocationCode" sortBy="#{serviceRec.locationCode}">
							<f:facet name="header">
								<h:outputText value="Location Code" />
							</f:facet>
							<h:outputText value="#{serviceRec.locationCode}" />
						</rich:column>
		
						<rich:column id="colLocationName" sortBy="#{serviceRec.locationName}">
							<f:facet name="header">
								<h:outputText value="Location Name" />
							</f:facet>
							<h:outputText value="#{serviceRec.locationName}" />
						</rich:column>
		
						<f:facet name="footer">
							<rich:datascroller id="ds" for="dtbLocation" selectedStyleClass="selectScroll"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</rich:panel>	
				<rich:spacer height="10" style="display:block"></rich:spacer>
				<h:panelGrid columns="2">
					<a4j:commandButton  id="btnLocationAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 
										value="Add" 
										reRender="popupLocationFrmSearch,frmSearch">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMIR002" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
						<a4j:actionparam name="methodWithNavi" value="addLocation" />	
					</a4j:commandButton>
					<a4j:commandButton id="BtnLocationCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupLocationFrmAdd" attachTo="btnLocationAddBySelect" operation="hide" event="onclick" />
				</h:panelGrid>
				</h:form>
</rich:modalPanel>