<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchSite" width="850" autosized="true">
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
				<table>	
					<tr>
						<td align="right">
							<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
						</td>
						<td>
							<h:selectOneMenu id="searchCompany" value="#{semmel006Bean.popupSiteCriteria.company}" style="width : 130px">
               					<f:selectItems value="#{semmel006Bean.companyList}" />
               				</h:selectOneMenu>
						</td>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
               			</td>
               			<td>
               				<h:selectOneMenu id="searchRegion" value="#{semmel006Bean.popupSiteCriteria.region}" style="width : 130px">
               					<f:selectItems value="#{semmel006Bean.regionList}" />
               				</h:selectOneMenu>
	                	</td>
					</tr>						
					<tr>				
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['header.popup.searchSite.contractNo']}" styleClass="ms7"/>
               			</td>
               			<td width="30%">
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.contractNo}"/>
	                	</td>
	                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['popup.label.siteName']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.siteName}" style="width:250px"/>
	                	</td>
	           	 	</tr>
	           	 	<tr>				
						<td align="right">
							<h:outputText value="#{jspMsg['popup.label.vendorId']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText id="mel006_vendorId" value="#{semmel006Bean.popupSiteCriteria.vendorId}"/>
               				
               				<!-- >> fixed by.. NEW 2015/10/18 -->
		                	<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
						    	action="#{semmel006Action.initAddVendor}" reRender="mel006PopUp_addVendor"
						        oncomplete="#{rich:component('mel006PopUp_addVendor')}.show();">
							</a4j:commandButton>
		                	<!-- << -->
	                	</td>
	                	<td align="right">&nbsp;</td>
               			<td>&nbsp;</td>
	           	 	</tr>
	           	 	<tr>				
						<td align="right">
							<h:outputText value="#{jspMsg['popup.label.vendorName']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText id="mel006_vendorName" value="#{semmel006Bean.popupSiteCriteria.vendorName}"/>
	                	</td>
	                	<td align="right">
							<h:outputText value="#{jspMsg['popup.label.vendorAddress']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.vendorAddress}" style="width:250px"/>
	                	</td>
	           	 	</tr>
	           	 	<tr>				
						<td align="right">
							<h:outputText value="#{jspMsg['popup.label.payeeName']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.payeeName}"/>
	                	</td>
	                	<td align="right">
							<h:outputText value="#{jspMsg['popup.label.payeeAddress']}" styleClass="ms7"/>
               			</td>
               			<td>
               				<h:inputText  value="#{semmel006Bean.popupSiteCriteria.payeeAddress}" style="width:250px"/>
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
						<a4j:actionparam name="methodWithNavi" value="doSearchSitePRPrepaidByPL" />
						</a4j:commandButton>						
						<rich:spacer width="10"></rich:spacer>
						<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="popupFrmSearch,btnSiteAddBySelect,dtbPopupSite,pnlPopupSearchPostpaidResult,pnlPopupSearchCriteria,popupFrmError,dstdtbPopupSite">
		           		<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHSITE" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doClearSearchSitePR" />
		           		</a4j:commandButton>
					</h:panelGroup>
                	 </td>
                	 </tr>			                	
				</table>
			</rich:panel>
				<table width="100%"><tr><td colspan="4">				
				<h:panelGrid  id="grdPopupSearchResult" width="100%">
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
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.region}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.vendorName']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.vendor}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.PayeeName']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{popupSite.payee}" styleClass="contentform"  />
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
									reRender="oppContent,contractInfo,frmError,paymentInfo,meterDetail,popupFrmSearch,popupFrmError,paymentPostpaidInfo,prepaidInfo,pnlElDetailResult,dtbElDetail" disabled="#{semmel006Bean.savePopupSiteDisable}">
					<a4j:actionparam name="navModule" value="el" />
           			<a4j:actionparam name="navProgram" value="SEMMEL006-6" />	
					<a4j:actionparam name="moduleWithNavi" value="el" />
					<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
					<a4j:actionparam name="methodWithNavi" value="doAddSite4PRPrepaid" />	
					
				</a4j:commandButton>
				<a4j:commandButton id="btnSearchSiteCancel" styleClass="rich-button" value="Cancel"/>
				<rich:componentControl for="popupSearchSite" attachTo="btnSearchSiteCancel,btnSiteAddBySelect" 
				operation="hide" event="onclick" />
			</h:panelGrid>							
		</h:panelGrid>	
		</td></tr></table>			
	</h:form>
</rich:modalPanel>
<jsp:include page="../../pages/el/semmel006_popupAddVendor.jsp" />
