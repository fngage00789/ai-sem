<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchSite" width="350" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.searchSitePrepaid.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
		    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchSite" style="cursor:pointer"/>
			<rich:componentControl for="popupSearchSite" attachTo="hidepopupSearchSite" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>	
		
	<h:form id="popupFrmSearch"> 	
		<rich:panel>
				<table width="100%">							
					<tr>				
						<td align="right"  colspan="1">
							<h:outputText value="#{jspMsg['header.popup.searchSite.contractNo']}" styleClass="ms7"/>
               			</td>
               			<td  colspan="3">
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.contractNo}"/>
	                	</td>
	           	 	</tr>
                	 <tr>
                	 <td colspan="4">
                	 		<!-- end content criteria -->
					<h:panelGroup>					
						<a4j:commandButton id="btnPopupSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
						action="#{navAction.navi}" reRender="popupFrmSearch,btnSiteAddBySelect,dtbPopupSite,pnlPopupSearchPostpaidResult,pnlPopupSearchCriteria,popupFrmError,dstdtbPopupSite" >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHSITE" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSearchSitePRPrepaid" />
						</a4j:commandButton>						
						<rich:spacer width="10"></rich:spacer>
						<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="popupFrmSearch,btnSiteAddBySelect,dtbPopupSite,pnlPopupSearchPostpaidResult,pnlPopupSearchCriteria,popupFrmError,dstdtbPopupSite">
		           		<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHSITE" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doClearSearchSitePRPrepaid" />
		           		</a4j:commandButton>
					</h:panelGroup>
                	 </td>
                	 </tr>			                	
				</table>
			</rich:panel>				
				<h:panelGrid  id="grdPopupSearchResult">
					<rich:panel id="pnlPopupSearchPostpaidResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.tableheadername']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupSite" width="95%"
						value="#{semmel006Bean.popupSiteList}" rows="5" 
						var="popupSite" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						rowKeyVar="rowIndex"
						styleClass="contentform">						
						<rich:column id="siteCheck" width="50">
							<f:facet name="header">
								<h:outputText value="Select" />
							</f:facet>
							<div align="center">
							<sem:radioButton id="rdBtSel" 
								name="rdCol"	
								overrideName="true"	
			  							value="#{semmel006Bean.selectedRadio}"
			  							itemValue="#{popupSite.rowNumber}"/>
							</div>
						</rich:column>							
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.contractNo}" styleClass="contentform"  />
							</div>
						</rich:column>											
						<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.invSiteName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{popupSite.siteName}" styleClass="contentform"  />
								</div>
						</rich:column>
						
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupSite" 
									maxPages="10" id="dstdtbPopupSite" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				<h:panelGrid columns="2">
				<a4j:commandButton  id="btnSiteAddBySelect" styleClass="rich-button" 
									action="#{navAction.navi}" 
									value="Save" 
									reRender="contractInfo,popupFrmSearch,popupFrmError,paymentPostpaidInfo,prepaidInfo" disabled="#{semmel006Bean.savePopupSiteDisable}">
					<a4j:actionparam name="navModule" value="el" />
           			<a4j:actionparam name="navProgram" value="SEMMEL006-6" />	
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doAddSitePRPrepaid" />	
					
				</a4j:commandButton>
				<a4j:commandButton id="btnSearchSiteCancel" styleClass="rich-button" value="Cancel"/>
				<rich:componentControl for="popupSearchSite" attachTo="btnSearchSiteCancel,btnSiteAddBySelect" operation="hide" event="onclick" />
			</h:panelGrid>							
		</h:panelGrid>			
	</h:form>
</rich:modalPanel>

