<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{msg['SEMS001.label.siteapproveno']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent">
			<a4j:form id="frmSearch">
				<h:panelGrid width="650">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="เงื่อนไขการค้นหา" />
						</f:facet>
		                <h:panelGrid columns="5">
		                	<h:outputText value="เลขที่ใบอนุมัติ :" styleClass="ms7" />                	
		                	<h:inputText id="txtSiteApproveNo" maxlength="10" size="15" value="#{sems001Bean.siteApprove.siteApproveNo}" />
		                	<rich:spacer width="5" />
		                	<h:outputText value="วันที่เอกสาร :" styleClass="ms7" />
		                	<rich:calendar id="cldDocDate" locale="en/US" datePattern="dd/MM/yyyy" value="#{sems001Bean.siteApprove.docDate}" />
		                	<h:outputText value="จาก :" styleClass="ms7" />                	
		                	<h:inputText id="txtFrom" maxlength="10" size="15" value="#{sems001Bean.siteApprove.siteApproveFrom}" />
		                	<rich:spacer width="5" />
		                	<h:panelGroup>
		                		<h:graphicImage value="images/icon_required.gif" />
		                		<h:outputText value="บริษัท :" styleClass="ms7" />
		                	</h:panelGroup>
		                	<h:panelGroup>
			                	<h:selectOneMenu id="ddlCompany" value="#{sems001Bean.siteApprove.company}">
			                		<f:selectItems value="#{sems001Bean.companyList}" />
			                	</h:selectOneMenu>
		                		<h:message for="ddlCompany" styleClass="ms7red" />
		                	</h:panelGroup>
		                	<h:outputText value="ประเภทขออนุมัติ :" styleClass="ms7" />
		                	<h:selectOneMenu id="ddlApproveType" value="#{sems001Bean.siteApprove.approveType}">
		                		<f:selectItems value="#{sems001Bean.approveTypeList}" />
		                	</h:selectOneMenu>
		                	<rich:spacer width="5" />
		                	<h:outputText value="เรื่อง :" styleClass="ms7" />
		                	<h:inputText id="txtSubject" maxlength="10" size="15" value="#{sems001Bean.siteApprove.subject}" />
		                	<h:outputText value="ดำเนินการกับเลขที่สัญญา :" styleClass="ms7" />
		                	<h:inputText id="txtWithContractNo" maxlength="10" size="15" value="#{sems001Bean.siteApprove.withContractNo}" />
		                	<rich:spacer width="5" />
		                	<h:outputText value="สถานะใบอนุญาติ :" styleClass="ms7" />
		                	<h:selectOneMenu id="ddlDocStatus" value="#{sems001Bean.siteApprove.docStatus}">
		                		<f:selectItems value="#{sems001Bean.siteApproveStatusList}" />
		                	</h:selectOneMenu>
		                	<h:outputText value="Location ID :" styleClass="ms7" />
		                	<h:inputText id="txtLocationId" maxlength="10" size="15" value="#{sems001Bean.siteApprove.locationId}" />
		                	<rich:spacer width="5" />
		                	<h:outputText value="ชื่อสถานีฐาน :" styleClass="ms7" />
		                	<h:inputText id="txtCellName" maxlength="10" size="15" value="#{sems001Bean.siteApprove.cellSiteName}" />
		                	<h:outputText value="ภูมิภาค :" styleClass="ms7" />
		                	<h:selectOneMenu id="ddlRegion" value="#{sems001Bean.siteApprove.region}">
		                		<f:selectItems value="#{sems001Bean.regionList}" />
		                	</h:selectOneMenu>
		                </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
				
	            <h:panelGrid columns="2" id="grdSearchCommand">
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{sems001Action.search}" 
						reRender="frmError,pnlSearchCriteria,pnlSearchResult" />
	            	<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
	            		<f:param name="navModule" value="site" />
		            	<f:param name="navProgram" value="SEMS002" />
	            	</a4j:commandButton>
	            </h:panelGrid>
            
				<h:panelGrid width="1000">
					<rich:panel id="pnlSearchResult"  >
						<f:facet name="header">
							<h:outputText value="รายการใบอนุมัติเช่าสถานีฐาน" />
						</f:facet>
						<rich:dataTable width="95%" id="tblSiteApprove" cellpadding="1" cellspacing="0" border="0"
							var="siteApprove" value="#{sems001Bean.siteApproveList}" reRender="dstSiteApprove" 
							rows="#{sems001Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Action" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnDel" value="Delete" 
										image="images/delete.png" style="height: 15; width: 15"
										action="#{sems001Action.updateValueBeforeDelete}"
										oncomplete="#{rich:component('mdpConfirmDelDialog')}.show();">
										<a4j:actionparam name="rowId" value="#{siteApprove.siteApproveNo}"/>
	          						</a4j:commandButton>
									<a4j:commandButton id="btnEdit" value="Edit" 
										image="images/edit.png" style="height: 15; width: 15" action="#{navAction.navi}">
										<a4j:actionparam name="navModule" value="site" />
		            					<a4j:actionparam name="navProgram" value="SEMS002" />	
										<a4j:actionparam name="moduleWithNavi" value="site" />
										<a4j:actionparam name="actionWithNavi" value="SEMS002" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="rowId" value="#{siteApprove.siteApproveNo}"/>
	          						</a4j:commandButton>	          							
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.siteApproveNo}">
								<f:facet name="header">
									<h:outputText value="เลขที่ใบอนุมัติ" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.siteApproveNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="วันที่เอกสาร" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.docDate}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="จาก" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.siteApproveFrom}" styleClass="contentform"  >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ประเภทขออนุมัติ" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.approveType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="เรื่อง" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.subject}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ดำเนินการกับเลขที่สัญญา" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.withContractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="สถานะใบอนุมัติ" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.docStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Location ID" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ชื่อสถานีฐาน" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.cellSiteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ภูมิภาค" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.region}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="tblSiteApprove" 
									maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
						<h:outputText value="Do you want to delete this record?" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
							action="#{sems001Action.delete}" reRender="pnlSearchResult" >
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>