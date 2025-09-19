<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt005" var="jspMsg"/>
<rich:modalPanel id="popupRentalPlan" width="450" autosized="true" minWidth="220">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupRentalPlan" style="cursor:pointer"/>
				<rich:componentControl for="popupRentalPlan" attachTo="hidePopupRentalPlan" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="popupFrmSave"> 
		<h:panelGrid id="grdPopupRentalPlan">
			<h:messages id="errorPopup" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>	
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['header.popup.name']}"/>
					</f:facet>
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table width="100%" border="0">
							<tr>
								<td align="right" width="30%" valign="baseline">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
								</td>
								<td width="70%" valign="bottom">
									<h:selectOneMenu id="ddlPopupCompany" value="#{semmrt005Bean.rp.company}" 
									 	onchange="GetCompanyJS();">
										<f:selectItems value="#{semmrt005Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="popupCompanyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="popupCompanyDisplay" value="#{semmrt005Bean.rp.company}" styleClass="ms28"/>
								</td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.planType']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:selectOneRadio id="rbtPopupPlanType" styleClass="ms7"
										value="#{semmrt005Bean.rp.planType}" onclick="checkPlanType()">
										<f:selectItem itemValue="New" itemLabel="#{jspMsg['label.new']}"/>
										<f:selectItem itemValue="Renew" itemLabel="#{jspMsg['label.reNew']}"/>
										<a4j:jsFunction name="checkPlanType" 
											reRender="popupFrmSave,grdPopupRentalPlan"></a4j:jsFunction>
									</h:selectOneRadio> 
								</td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:selectOneMenu id="ddlYear" value="#{semmrt005Bean.rp.planYear}">
										<f:selectItems value="#{semmrt005Bean.yearList}"/>
									</h:selectOneMenu>
								</td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:selectOneMenu id="ddlPopupRegion" value="#{semmrt005Bean.rp.region}">
										<f:selectItems value="#{semmrt005Bean.regionList}"/>
									</h:selectOneMenu>
								</td>
							</tr>
							<h:panelGroup rendered="#{semmrt005Bean.rp.planType == 'New'}">
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.siteTotal']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:inputText id="txtPopupSiteTotal" value="#{semmrt005Bean.rp.siteTotal}" 
										size="18" maxlength="15" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
									</h:inputText>
								</td>
							</tr>
							</h:panelGroup>
							<h:panelGroup rendered="#{semmrt005Bean.rp.planType == 'New'}">
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.amount']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:inputText id="txtPopupAmount" value="#{semmrt005Bean.rp.planAmt}" 
										size="18" rendered="#{semmrt005Bean.rp.planType == 'New'}" 
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                				onblur="return numberformat.moneyFormat(this);"
		                				onfocus="return numberformat.setCursorPosToEnd(this);"
		                				maxlength="16" 
		                				styleClass="inputRight">
										<f:convertNumber integerOnly="true" type="number" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
								</td>
							</tr>
							</h:panelGroup>
							<h:panelGroup rendered="#{semmrt005Bean.rp.planType == 'Renew'}">
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.growth']}" styleClass="ms7"/>
								</td>
								<td width="70%">
									<h:inputText id="txtPopupGrowth" value="#{semmrt005Bean.rp.percentGrowth}" 
										rendered="#{semmrt005Bean.rp.planType == 'Renew'}" 
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                				onblur="return numberformat.moneyFormat(this);"
		                				onfocus="return numberformat.setCursorPosToEnd(this);"
		                				maxlength="16" 
		                				styleClass="inputRight">
										<f:convertNumber integerOnly="true" type="number" maxFractionDigits="2" 
											pattern="#,##0.00"/>
										<f:converter converterId="javax.faces.Double"/>
									</h:inputText>
								</td>
							</tr>
							</h:panelGroup>
						</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				
			</h:panelGrid>
			<!-- end content criteria -->
			<h:panelGrid columns="2" id="grdPopupCommand">
				<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button"
					action="#{navAction.navi}" reRender="popupFrmSave,frmError,pnlSearchResult" 
					oncomplete="if(#{semmrt005Bean.popupClose == 'true'})#{rich:component('popupRentalPlan')}.hide();">
					<a4j:actionparam name="navModule" value="rt" />
					<a4j:actionparam name="navProgram" value="SEMMRT005-1" />
					<a4j:actionparam name="moduleWithNavi" value="rt" />
					<a4j:actionparam name="actionWithNavi" value="SEMMRT005" />
					<a4j:actionparam name="methodWithNavi" value="doSave" />
					<a4j:jsFunction name="reRenderPopup" 
						reRender="pnlSearchResult,#{semmrt005Bean.validatePopup}"></a4j:jsFunction>
				</a4j:commandButton>
				<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
					<rich:componentControl for="popupRentalPlan" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>