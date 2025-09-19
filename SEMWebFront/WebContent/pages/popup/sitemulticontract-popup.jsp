<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:loadBundle basename="resources.popup.contract" var="jspMsgCO" />
<rich:modalPanel id="popupSiteContract" width="500" height="800" autosized="true" styleClass="ms7">
				 
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgCO['header.searchContract']}"/>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png"
								id="hidePopupSiteContract" 
								style="cursor:pointer" /> 
									
				<rich:componentControl for="popupSiteContract" attachTo="hidePopupSiteContract" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<h:panelGrid>
		<a4j:form id="popupSiteContractFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="popupSiteContractFrmSearch">
		<h:panelGrid id="pnlGirdPopupSiteContractSearch" width="100%">
			<rich:panel id="pnlPopupSiteContractSearch">
				<f:facet name="header">
					<h:outputText value="#{jspMsgCO['header.criteriaContract']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid columns="5" border="0" cellpadding="1" cellspacing="0">
					<h:panelGroup>
						<table>
							<tr>
								<td width="20%">
									<h:outputText value="#{jspMsgCO['label.type']}" styleClass="ms7" />
								</td>
								<td>
									<h:outputText value="#{jspMsgCO['label.keyword']}" styleClass="ms7" />
								</td>
							</tr>
							
							<tr>
								<td>
									<h:selectOneMenu id="criPopupSiteContract" value="#{popupSiteMultiContractBean.siteContractCatSelect}">
										<f:selectItem itemLabel="#{jspMsgCO['label.contractNo']}" itemValue="CODE" />
									</h:selectOneMenu>
								</td>
								<td>
									<h:inputText id="txtPopupSiteContract" value="#{popupSiteMultiContractBean.siteContractKeyWord}" 
												 size="30" maxlength="50" 
												 onkeydown="if(event.keyCode==13){document.getElementById('incContent:popupSiteContractFrmSearch:btnPopupSiteContractSearch').click();}">
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
										<a4j:commandButton id="btnPopupSiteContractSearch"
											value="#{jspMsgCO['btn.search']}" styleClass="rich-button" 
											action="#{navAction.navi}"
											reRender="btnPopupSiteContractSave, dtbPopupSiteContract, pnlPopupSiteContractSearchResult, popupSiteContractFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton>
										<rich:spacer width="10"></rich:spacer>
										<a4j:commandButton id="btnPopupSiteContractClear"
											value="#{jspMsgCO['btn.clear']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlPopupSiteContractSearch, popupSiteContractFrmError">
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
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
	
	<a4j:form id="popupSiteContractFrmResult">
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="#{jspMsgCO['header.resultContract']}" />
			</f:facet>
			<rich:dataTable id="dtbPopupSiteContract" 
							cellpadding="1" cellspacing="0" border="0"
							var="objSiteContract" value="#{popupSiteMultiContractBean.contractList}"
							rowKeyVar="RegInd" rows="#{popupSiteMultiContractBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" width="92%"
							styleClass="contentform">
				
				<rich:column id="select">
					<div align="center">
						<f:facet name="header">
							<a4j:region>
							<h:selectBooleanCheckbox disabled="#{popupSiteMultiContractBean.disabledBtnSelectedAll}">
								<a4j:support event="onclick" 
											 action="#{navAction.navi}" 
											 reRender="dtbPopupSiteContract, btnPopupSiteContractSave">
										
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
									<a4j:actionparam name="methodWithNavi" value="doSelectAll" />
								</a4j:support>
							</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<a4j:region>
						<h:selectBooleanCheckbox value="#{objSiteContract.selected}">
							<a4j:support event="onclick" 
										 action="#{navAction.navi}" 
										 reRender="btnPopupSiteContractSave">
								
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
								<a4j:actionparam name="methodWithNavi" value="doSelect" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</a4j:region>
					</div>
				</rich:column>
				<rich:column sortBy="#{objSiteContract.contractNo}" width="480">
					<f:facet name="header">
						<h:outputText value="#{jspMsgCO['column.contractNo']}" />
					</f:facet>
					<div align="left">
						<h:outputText value="#{objSiteContract.contractNo}" />
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:datascroller id="dsbPopupSiteContract" for="dtbPopupSiteContract"
									   immediate="true" rendered="true" align="left" 
									   maxPages="5" selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
			
			<rich:spacer height="3" style="display:block"></rich:spacer>
							
			<a4j:commandButton id="btnPopupSiteContractSave" styleClass="rich-button"
							   value="#{jspMsgCO['btn.save']}" action="#{navAction.navi}" 
							   reRender="criSiteContractMultiZone, btnSiteContractMultiZone, popupSiteContractFrmError"
							   disabled="#{popupSiteMultiContractBean.disableBtnGetSiteContract}"   
							   oncomplete="#{rich:component('popupSiteContract')}.hide(); return false">
							   
				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
				<a4j:actionparam name="methodWithNavi" value="doSelectList" />
			</a4j:commandButton>
			<rich:spacer width="10"></rich:spacer>
			<a4j:commandButton id="btnPopupSiteContractCancel" styleClass="rich-button" 
							   value="#{jspMsgCO['btn.cancel']}"  action="#{navAction.navi}"
							   oncomplete="#{rich:component('popupSiteContract')}.hide(); return false">

				<a4j:actionparam name="navModule" value="common" />
				<a4j:actionparam name="navProgram" value="sitemulticontract-popup" />
				<a4j:actionparam name="moduleWithNavi" value="common" />
				<a4j:actionparam name="actionWithNavi" value="PopupSiteMultiContract" />
				<a4j:actionparam name="methodWithNavi" value="doCancel" />
			</a4j:commandButton>
							
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

