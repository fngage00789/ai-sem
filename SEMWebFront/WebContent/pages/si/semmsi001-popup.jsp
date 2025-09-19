<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi001" var="jspMsg"/>
<rich:modalPanel id="popupSearchContractNo" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popupContract.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSearchContractNo" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchContractNo" attachTo="hidePopupSearchContractNo" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:form id="popupFrmSearch"> 
		<h:panelGrid width="800" id="grdPopupSearchCriteria">
			<rich:panel id="panPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.popup.resultTable.name']}"/>
					</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupContractNo" value="#{semmsi001Bean.popupContractCriteria.contractNo}"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupSiteName" value="#{semmsi001Bean.popupContractCriteria.siteName}"/>
				                	</td>
			                	</tr>
			                	<tr>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                				<h:selectOneMenu id="ddlPopupCompany" value="#{semmsi001Bean.popupContractCriteria.company}">
											<f:selectItems value="#{semmsi001Bean.companyList}"/>
										</h:selectOneMenu>
				                	</td>
			                	</tr>
			                	<tr>
				                	<td width="20%"></td>
		                			<td colspan="3">
		                				<h:selectOneRadio id="rbtCurrentFlag" value="#{semmsi001Bean.popupContractCriteria.currentFlag}"  styleClass="ms7">
		                					<f:selectItem itemValue="Y" itemLabel="ข้อมูลปัจจุบัน "/>
		                					<f:selectItem itemValue="N" itemLabel="ข้อมูลประวัติ "/>
		                				</h:selectOneRadio>
				                	</td>
			                	</tr>
			            	</table>
						</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdPopupSearchCommand">
							<a4j:commandButton id="btnPopupSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="dtbPopupContractNo,panPopupSearchResult" >
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
								<a4j:actionparam name="methodWithNavi" value="doSearchContractNo" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="800" id="grdPopupSearchResult">
					<rich:panel id="panPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.resultTable.name']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupContractNo" width="95%"
							value="#{semmsi001Bean.contractList}" rows="5" 
							rowKeyVar="RegInd" var="contractSP" 
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
									reRender="pnlSiteApprove,popupSearchContractNo">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
									<a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
									<a4j:actionparam name="siteInfoId" value="#{contractSP.siteInfoId}"/>
									<a4j:actionparam name="contractNo" value="#{contractSP.contractNo}"/>
									<a4j:actionparam name="siteName" value="#{contractSP.siteName}"/>
									<a4j:actionparam name="region" value="#{contractSP.region}"/>
									<a4j:actionparam name="company" value="#{contractSP.company}"/>
								</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.header.contractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.header.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.region']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.region}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.header.company']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupContractNo" 
									maxPages="10" id="dstPopupContractNo" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
	</h:form>
</rich:modalPanel>

<rich:modalPanel id="popupAlert" width="500" autosized="true" minWidth="220">
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAlert" style="cursor:pointer"/>
				<rich:componentControl for="popupAlert" attachTo="hidePopupAlert" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:form id="popupAlertContent">
		<h:panelGrid>
			<h:outputText value="บันทึกข้อมูลเรียบร้อยแล้ว" />
			<a4j:commandButton id="btnClosePopup" styleClass="rich-button" value="Cancel"/>
			<rich:componentControl for="popupAlert" attachTo="btnClosePopup" operation="hide" event="onclick" />
		</h:panelGrid>
	</h:form>
</rich:modalPanel>