<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.insurance.semmir001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent">
			<a4j:form id="frmSearch">
				<h:panelGrid width="650">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
		                <h:panelGrid columns="5">
		                	<h:panelGroup><div align="right">
		                		<h:graphicImage value="images/icon_required.gif" />
		                		<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                	</div></h:panelGroup>
		                	<h:panelGroup>
			                	<h:selectOneMenu id="ddlCompany" value="#{semir001Bean.acquisitionCost.company}">
			                		<f:selectItems value="#{semir001Bean.companyList}" />
			                	</h:selectOneMenu>
		                		<h:message for="ddlCompany" styleClass="ms7red" />
		                	</h:panelGroup>
		                	<rich:spacer width="5" />
		                	<rich:spacer width="2" />
		                	<rich:spacer width="2" />
		                	<h:panelGroup><div align="right">
		                		<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:selectOneMenu id="ddlNetworkType" value="#{semir001Bean.acquisitionCost.networkType}">
		                		<f:selectItems value="#{semir001Bean.networkTypeList}" />
		                	</h:selectOneMenu>
		                	<rich:spacer width="5" />
		                	<h:panelGroup><div align="right">
		                		<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:selectOneMenu id="ddlTransferType" value="#{semir001Bean.acquisitionCost.tfType}">
			                	<f:selectItems value="#{semir001Bean.transferTypeList}" />
			                </h:selectOneMenu>
			                <h:panelGroup><div align="right">	
		                		<h:outputText value="#{jspMsg['label.asOfMonth']}" styleClass="ms7"/>
		                	</div></h:panelGroup>
		                	<h:panelGroup>
		                		<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
		                			<h:inputText id="txtMonth" maxlength="2" size="1" value="#{semir001Bean.month}" />
		                			<rich:spacer width="2" />
		                			<h:outputLabel value="#{jspMsg['label.slash']}"/>
		                			<rich:spacer width="2" />
		                			<h:inputText id="txtYear" maxlength="4" size="2" value="#{semir001Bean.year}" />
		                		</h:panelGrid>
		                	</h:panelGroup>
		                </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
				
	            <h:panelGrid columns="2" id="grdSearchCommand">
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,panSearchCriteria,panSearchResult" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR001" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR001" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
	            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,panSearchResult">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR001" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR001" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />
	            	</a4j:commandButton>
	            </h:panelGrid>
             
				<h:panelGrid width="1000">
					<rich:panel id="panSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" />
						</f:facet>
						<rich:dataTable width="95%" id="dtbAcqCost" cellpadding="1" cellspacing="0" border="0"
							var="acquisitionCost" value="#{semir001Bean.acquisitionCostList}" reRender="dstAcqCost" 
							rows="#{semir001Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column sortBy="#{acquisitionCost.networkType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acquisitionCost.networkType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{acquisitionCost.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acquisitionCost.company}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{acquisitionCost.tfType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferType']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{acquisitionCost.tfType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{acquisitionCost.totLocation}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.totalLocation']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{acquisitionCost.totLocation}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{acquisitionCost.acqAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.totalAcquisition']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{acquisitionCost.acqAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{acquisitionCost.asOfMonth}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.asOfMonth']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acquisitionCost.asOfMonth}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.viewDetail']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<!-- <h:outputText value="View Detail" styleClass="contentform" style="text-decoration:underline;" /> -->
									<a4j:commandLink value="View Detail" action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMIR002" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
										<a4j:actionparam name="methodWithNavi" value="initView" />
										<a4j:actionparam name="networkType" value="#{acquisitionCost.networkCode}"/>
										<a4j:actionparam name="company" value="#{acquisitionCost.companyCode}"/>
										<a4j:actionparam name="transferType" value="#{acquisitionCost.tfCode}"/>
									</a4j:commandLink>
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbAcqCost" 
									maxPages="10" id="dstAcqCost" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>