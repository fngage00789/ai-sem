<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
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
							<h:inputText id="txtLocationId" value="#{semir005Bean.location.locationId}" />
						</h:panelGrid></td>
					</tr><tr>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Code :" />
							<h:inputText id="txtLocationCode" value="#{semir005Bean.location.locationCode}" />
						</h:panelGrid></td>
					</tr><tr>
						<td><h:panelGrid styleClass="ms7">
							<h:outputText value="Name :" />
							<h:inputText id="txtLocationName" value="#{semir005Bean.location.locationName}" />
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
				            			<a4j:actionparam name="navProgram" value="SEMIR005" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
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
						value="#{semir005Bean.locations}" rows="5" 
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
							<!-- <h:selectBooleanCheckbox id="LocationHeaderCheck" value="#{serviceRec.selected}" onclick="LocationHeaderCheckJS();">
								<a4j:jsFunction name="LocationHeaderCheckJS" reRender="LocationCheck"></a4j:jsFunction>
							</h:selectBooleanCheckbox>-->
							<sem:radioButton id="rdBtSel"
			  							name="rdCol"
			  							overrideName="true"
			  							value="#{semir005Bean.selectedRadio}"
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
										reRender="popupLocationFrmSearch,frmSearch,frmEdit">
						<a4j:actionparam name="navModule" value="ir" />
            			<a4j:actionparam name="navProgram" value="SEMIR005" />	
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
						<a4j:actionparam name="methodWithNavi" value="addLocation" />	
					</a4j:commandButton>
					<a4j:commandButton id="BtnLocationCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupLocationFrmAdd" attachTo="btnLocationAddBySelect" operation="hide" event="onclick" />
				</h:panelGrid>
				</h:form>
</rich:modalPanel>