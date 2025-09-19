<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi003" var="jspMsg"/>
<rich:modalPanel id="popupSearchContractNo" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
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
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
				<h:form id="popupFrmSearch"> 
				<h:panelGrid width="800" id="grdPopupSearchCriteria">
					<rich:panel id="pnlPopupSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupContractNo" value="#{semmsi003Bean.popupContractCriteria.contractNo}"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupSiteName" value="#{semmsi003Bean.popupContractCriteria.siteName}"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu id="ddlPopupCompany" value="#{semmsi003Bean.popupContractCriteria.company}">
										<f:selectItems value="#{semmsi003Bean.companyList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneRadio id="rbtCurrentFlag" value="#{semmsi003Bean.popupContractCriteria.currentFlag}"  styleClass="ms7" rendered="true">
		                				<f:selectItem itemValue="Y" itemLabel="ข้อมูลปัจจุบัน " />
		                				<f:selectItem itemValue="N" itemLabel="ข้อมูลประวัติ "/>
		                			</h:selectOneRadio>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,popupFrmError" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI003-POPUP" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
									<a4j:actionparam name="methodWithNavi" value="doSearchPopupContractNo" />
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI003-POPUP" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
									<a4j:actionparam name="methodWithNavi" value="doClearPopupContractNo" />
					           		</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
				
					</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid width="800" id="grdPopupSearchResult">
					<rich:panel id="pnlPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.resultTable.name']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupContractNo" width="95%"
						value="#{semmsi003Bean.contractList}" rows="5" 
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
							reRender="frmAddSiteTerminate, pnlAddSiteTerminate, popupSearchContractNo">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI003-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI003" />
							<a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
							<a4j:actionparam name="siteInfoId" value="#{contractSP.siteInfoId}"/>
							<a4j:actionparam name="contractNo" value="#{contractSP.contractNo}"/>
							<a4j:actionparam name="region" value="#{contractSP.region}"/>
							</a4j:commandLink>
							</div>
						</rich:column>
						<rich:column id="colContractNo">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.popup.header.contractNo']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.contractNo}" styleClass="contentform"  />
							</div>
						</rich:column>
						
						<rich:column id="colSiteName">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.header.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colEffDate">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.popup.effDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.effDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colExpDate">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.popup.expDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.expDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
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

