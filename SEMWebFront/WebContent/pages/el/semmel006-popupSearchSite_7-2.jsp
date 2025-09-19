<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchSite7" width="850" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.updateInstallment.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
		    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchSite" style="cursor:pointer"/>
			<rich:componentControl for="popupSearchSite7" attachTo="hidepopupSearchSite" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError7">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>	
		
	<h:form id="popupFrmSearch7"> 	
		<rich:panel>
				<table>	
					<tr>
						<td align="right">
							<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
						</td>
						<td>
							<h:selectOneMenu id="searchCompany" value="#{semmel006Bean.popupSiteSearch7.company}" style="width : 130px">
               					<f:selectItems value="#{semmel006Bean.companyList}" />
               				</h:selectOneMenu>
						</td>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
               			</td>
               			<td>
               				<h:selectOneMenu id="searchRegion" value="#{semmel006Bean.popupSiteSearch7.region}" style="width : 130px">
               					<f:selectItems value="#{semmel006Bean.regionList}" />
               				</h:selectOneMenu>
	                	</td>
					</tr>				
					<tr>				
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['header.popup.searchSite.contractNo']}" styleClass="ms7"/>
               			</td>
               			<td width="30%">
               				<h:inputText  value="#{semmel006Bean.popupSiteSearch7.contractNo}"/>
	                	</td>
	                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['popup.label.siteName']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteSearch7.siteName}" style="width:250px"/>
	                	</td>
	           	 	</tr>
	           	 	<tr>				
						
	                	<td align="right">
							<h:outputText value="#{jspMsg['popup.lable.meterId']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteSearch7.meterId}" style="width:250px"/>
	                	</td>
	                	<td></td>
	                	<td></td>
	           	 	</tr>
                	 <tr>
                	 <td colspan="4">
                	 		<!-- end content criteria -->
					<h:panelGroup>					
						<a4j:commandButton id="btnPopupSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
					action="#{navAction.navi}" reRender="popupFrmSearch7,dtbPopupSite,pnlPopupSearchResult,popupFrmError7" >
					<a4j:actionparam name="navModule" value="el" />
					<a4j:actionparam name="navProgram" value="SEMMEL006-popupSearchSite7" />
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doSearchPopupSite7" />
					</a4j:commandButton>
					<rich:spacer width="10"></rich:spacer>
					<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
	           	 	action="#{navAction.navi}" reRender="popupFrmSearch7,dtbPopupSite,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError7">
	           		<a4j:actionparam name="navModule" value="el" />
					<a4j:actionparam name="navProgram" value="SEMMEL006-popupSearchSite7" />
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doClearSearchSite7" />
	           		</a4j:commandButton>
					</h:panelGroup>
                	 </td>
                	 </tr>			                	
				</table>
			</rich:panel>
				<table width="100%"><tr><td colspan="4">				
				<h:panelGrid  id="grdPopupSearchResult" width="100%">
					<rich:panel id="pnlPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.tableheadername']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupSite7" width="95%"
						value="#{semmel006Bean.popupSite7List}" rows="5" 
						var="popupSite" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						rowKeyVar="RegInd"
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
			  							itemValue="#{popupSite.electricId}"/>
							</div>
						</rich:column>							
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.contractNo}" styleClass="contentform"  />
							</div>
						</rich:column>	
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.company}" styleClass="contentform"  />
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
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupSite7" 
									maxPages="10" id="dstdtbPopupSite7" selectedStyleClass="selectScroll" />
							</f:facet>		
						</rich:dataTable>
					</rich:panel>
				<h:panelGrid columns="2">
				<a4j:commandButton  id="btnSiteAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 
										value="Save" 
										reRender="frmError,contractInfo7,payment7Info,meterDetail">
						<a4j:actionparam name="navModule" value="el" />
            			<a4j:actionparam name="navProgram" value="SEMMEL006-7" />	
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doAddSite7" />				
						
					</a4j:commandButton>
					<a4j:commandButton id="btnSearchSiteCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupSearchSite7" attachTo="btnSearchSiteCancel" operation="hide" event="onclick" />
					<rich:componentControl for="popupSearchSite7" attachTo="btnSiteAddBySelect" operation="hide" event="onclick" />
			</h:panelGrid>							
		</h:panelGrid>	
		</td></tr></table>			
	</h:form>
</rich:modalPanel>

