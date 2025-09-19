<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt001" var="jspMsg"/>
	<rich:modalPanel id="popupPropertyTax" width="400" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidepopupPropertyTax" style="cursor:pointer"/>
					<rich:componentControl for="popupPropertyTax" attachTo="hidepopupPropertyTax" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupPropertyTax">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAdd">
			<rich:panel id="pnlEditPropertyTax">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpApprove']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" width="50%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="20%">
		                				<h:selectOneMenu id="ddlPTaxPayTypePopup" value="#{semmpt001Bean.mpt001Edt.pTaxPayType}">
											<f:selectItems value="#{semmpt001Bean.propertyTaxTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="50%">
		                			</td>
		                			<td width="20%">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="50%"></td>
			                	 	<td width="20%">
			                	 		<a4j:commandButton id="btnPopupPropertyTax" value="Save" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupPropertyTax,dtbMpt001Srch,frmError" 
									oncomplete="if(#{semmpt001Bean.popupClose == 'true'})#{rich:component('popupPropertyTax')}.hide();">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
										<a4j:actionparam name="methodWithNavi" value="doSavePropertyTax" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" 
									 reRender="frmErrorPopupPropertyTax,dtbMpt001Srch,frmError" >
										<rich:componentControl for="popupPropertyTax" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	<rich:modalPanel id="popupViewPropertyTax" width="960" height="400">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpViewApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidepopupViewPropertyTax" style="cursor:pointer"/>
					<rich:componentControl for="popupViewPropertyTax" attachTo="hidepopupViewPropertyTax" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupResult">
			<h:panelGrid  width="90%">
					<rich:panel id="pnlPopupSearchResult" >
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['headerPopUp.resultTable.name']}"/>
						</f:facet>
						 <rich:dataTable id="dtbMpt001SrchHist" cellpadding="1" cellspacing="0" border="0"
							var="mpt001SrchHistSP" value="#{semmpt001Bean.mpt001SrchHistList}" reRender="dstMpt001SrchHist" 
							rows="#{semmpt001Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<rich:column sortBy="#{mpt001SrchHistSP.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 120"/>
								</f:facet>
								<div align="center">
									 <h:outputText value="#{mpt001SrchHistSP.contractNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxPayDescHist']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt001SrchHistSP.pTaxPayDescHist}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxPayDesc2']}" styleClass="ms7" style="width: 90"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt001SrchHistSP.pTaxPayDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payGovtFlagHist']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchHistSP.payGovtFlagHist}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payGovtFlag2']}"   styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchHistSP.payGovtFlag}"   styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchHistSP.createBy}"   styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt001SrchHistSP.createDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt001SrchHist" 
									maxPages="10" id="dstMpt001SrchHist" selectedStyleClass="selectScroll" 
									page="1"/>
							</f:facet>
						</rich:dataTable>
						<br/>
						<a4j:commandButton value="Close" styleClass="rich-button">
							<rich:componentControl for="popupViewPropertyTax" operation="hide" event="onclick" />
						</a4j:commandButton>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>