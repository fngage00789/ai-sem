<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchSite7" width="850" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.searchSite7.name']}"></h:outputText>			
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
			<table width="100%">							
			<tr>			
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['header.popup.searchSite.company']}" styleClass="ms7"/>
             	</td>
             	<td width="30%">
					<h:selectOneMenu id="ddlCompany" value="#{semmel006Bean.popupSiteSearch7.company}" onchange="GetCompanyJS();" style="width:120px;">
						<f:selectItems value="#{semmel006Bean.companyList}"/>
					</h:selectOneMenu>
					<a4j:jsFunction name="GetCompanyJS" reRender="popupFrmSearch7"/>
					<rich:spacer width="10"></rich:spacer>
					<h:outputText   value="#{semmel006Bean.popupSiteSearch7.company}" styleClass="ms28"/>	             		
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
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.contractNo']}" styleClass="ms7" />
				</td>
				<td width="30%">
				<h:inputText   value="#{semmel006Bean.popupSiteSearch7.contractNo}"  style="width:120px;"></h:inputText>
				</td>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.siteName']}" styleClass="ms7"/>
				</td>
				<td width="40%">
					<h:inputText   value="#{semmel006Bean.popupSiteSearch7.siteName}" style="width:200px;"></h:inputText>
				</td>
			</tr>	
			
			<tr>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.vendorId']}" styleClass="ms7" />
				</td>
				<td width="30%">
				<h:inputText   value="#{semmel006Bean.popupSiteSearch7.vendorId}"  style="width:120px;"></h:inputText>
				</td>
			<td align="right" width="15%">
					
				</td>
				<td width="40%">
					 
				</td>
			</tr>	

			<tr>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.vendorName']}" styleClass="ms7" />
				</td>
				<td width="30%">
				<h:inputText   value="#{semmel006Bean.popupSiteSearch7.vendorName}"  style="width:120px;"></h:inputText>
				</td>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.vendorAddress']}" styleClass="ms7"/>
				</td>
				<td width="40%">
					<h:inputText   value="#{semmel006Bean.popupSiteSearch7.vendorAddress}" style="width:200px;"></h:inputText>
				</td>
			</tr>	
			<tr>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.payeeName']}" styleClass="ms7" />
				</td>
				<td width="30%">
				<h:inputText   value="#{semmel006Bean.popupSiteSearch7.payeeName}"  style="width:120px;"></h:inputText>
				</td>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.payeeAddress']}" styleClass="ms7"/>
				</td>
				<td width="40%">
					<h:inputText   value="#{semmel006Bean.popupSiteSearch7.payeeAddress}" style="width:200px;"></h:inputText>
				</td>
			</tr>
			<tr>
				<td align="right" width="15%">
					<h:outputText value="#{jspMsg['label.popup.meterId']}" styleClass="ms7" />
				</td>
				<td width="30%">
				<h:inputText   value="#{semmel006Bean.popupSiteSearch7.meterId}"  style="width:120px;"></h:inputText>
				</td>
				<td align="right" width="15%">
					 
				</td>
				<td width="40%">
					 
				</td>
			</tr>			
																            
			<tr>
			<td colspan="4"></td>
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
					
				<h:panelGrid  id="grdPopupSearchResult">
					<rich:panel id="pnlPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.tableheadername']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupSite7" width="95%"
						value="#{semmel006Bean.popupSite7List}" rows="5" 
						rowKeyVar="RegInd" var="popupSite" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
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
								<h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.company}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.searchSite.meterId']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.meterId}" styleClass="contentform"  />
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
										reRender="frmError,contractInfo7,payment7Info">
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
				
				
				</h:form>
</rich:modalPanel>

