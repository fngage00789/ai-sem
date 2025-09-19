<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Acqisition Cost" />
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
							<h:outputText value="เงื่อนไขการค้นหา" />
						</f:facet>
						<!-- Begin Content Criteria -->
		                <h:panelGrid><h:panelGroup>
		                <table width="100%">
		                  <tr>
		                    <td align="right">
		                      <h:graphicImage value="images/icon_required.gif" />
		                	  <h:outputText value="Company :" styleClass="ms7" />
		                    </td>
		                    <td>
		                      <h:selectOneMenu id="somCompany" value="#{semir002Bean.acqCostDetail.company}" 
			                		disabled="true">
			                		<f:selectItems value="#{semir002Bean.companyList}" />
			                  </h:selectOneMenu>
		                	  <h:message for="somCompany" styleClass="ms7red" />
		                    </td>
		                    <td></td><td></td>
		                  </tr>
		                  <tr>
		                    <td align="right"><h:outputText value="ประเภท :" styleClass="ms7" /></td>
		                    <td>
		                      <h:selectOneMenu id="networkType" value="#{semir002Bean.acqCostDetail.networkType}" 
		                		disabled="true">
		                		<f:selectItems value="#{semir002Bean.networkTypeList}" />
		                	  </h:selectOneMenu>
		                    </td>
		                    <td align="right"><h:outputText value="Transfer Type :" styleClass="ms7" /></td>
		                    <td>
		                      <h:selectOneMenu id="transferType" value="#{semir002Bean.acqCostDetail.transferType}" 
		                		disabled="true">
			                	<f:selectItems value="#{semir002Bean.transferTypeList}" />
			                  </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText value="Region :" styleClass="ms7" /></td>
		                    <td>
		                      <h:selectManyMenu id="lstRegion" value="#{popupRegionBean.selDels}" style="width: 100px; height: 50px; " >
			                	<f:selectItems value="#{popupRegionBean.regionsAdded}"  />
			                  </h:selectManyMenu>
							</td>
							<td valign="top">
		                      <a4j:commandButton id="btnAddRegion" oncomplete="#{rich:component('popupFrmAdd')}.show(); return false"
	            					action="#{navAction.navi}" 
	            					value="เพิ่ม" styleClass="rich-button">
									<a4j:actionparam name="navModule" value="ir" />
		            				<a4j:actionparam name="navProgram" value="SEMIR002" />
		            				<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
									<a4j:actionparam name="methodWithNavi" value="" />		
	            			  </a4j:commandButton>
		                	  <rich:spacer width="5" />
		                	  <a4j:commandButton id="btnDelRegion" styleClass="rich-button" 
									action="#{navAction.navi}" value="ลบ" reRender="lstRegion">
									<a4j:actionparam name="navModule" value="ir" />
				            		<a4j:actionparam name="navProgram" value="SEMIR002" />	
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
									<a4j:actionparam name="methodWithNavi" value="deleteRegion" />	
							  </a4j:commandButton>
		                    </td>
		                    <td></td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText value="Province :" styleClass="ms7" /></td>
		                    <td>
		                      <h:selectManyMenu id="lstProvince" value="#{popupProvinceBean.selProvinceDels}" style="width: 100px; height: 50px; " >
			                	<f:selectItems value="#{popupProvinceBean.provinceAdded}" />
			                  </h:selectManyMenu>
							</td>
							<td valign="top">
		                      <a4j:commandButton id="btnAddProvince" oncomplete="#{rich:component('popupProvinceFrmAdd')}.show(); return false"
	            					action="#{navAction.navi}" value="เพิ่ม" styleClass="rich-button">
									<a4j:actionparam name="navModule" value="ir" />
		            				<a4j:actionparam name="navProgram" value="SEMIR002" />
		            				<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
									<a4j:actionparam name="methodWithNavi" value="" />		
	            			  </a4j:commandButton>
		                	  <rich:spacer width="5" />
		                	  <a4j:commandButton  id="btnDelProvince" styleClass="rich-button" 
									action="#{navAction.navi}" value="ลบ" reRender="lstProvince">
									<a4j:actionparam name="navModule" value="ir" />
				            		<a4j:actionparam name="navProgram" value="SEMIR002" />	
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
									<a4j:actionparam name="methodWithNavi" value="deleteProvince" />	
							  </a4j:commandButton>
		                    </td>
		                    <td></td>
		                  </tr>
		                  <tr>
		                    <td align="right"><h:outputText value="Location ID :" styleClass="ms7" /></td>
		                    <td><h:inputText size="15" value="#{semir002Bean.acqCostDetail.locationId}"/></td>
		                    <td align="right"><h:outputText value="Location Name :" styleClass="ms7" /></td>
		                    <td>
		                      <h:inputText size="15" value="#{semir002Bean.acqCostDetail.locationName}" readonly="true"/>
		                	  <rich:spacer width="5" />
		                	  <a4j:commandButton id="btnSearchLocation" oncomplete="#{rich:component('popupLocationFrmAdd')}.show(); return false"
	            					action="#{navAction.navi}" value="ค้นหา Location" styleClass="rich-button">
									<a4j:actionparam name="navModule" value="ir" />
		            				<a4j:actionparam name="navProgram" value="SEMIR002" />
		            				<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
									<a4j:actionparam name="methodWithNavi" value="" />		
	            			  </a4j:commandButton>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right"><h:outputText value="เดือน / ปี :" styleClass="ms7" /></td>
		                    <td>
		                      <h:inputText id="txtWithMonth" maxlength="2" size="1" value="#{semir001Bean.month}" />
		                	  <rich:spacer width="2" />
		                	  <h:outputLabel value="/"/>
		                	  <rich:spacer width="2" />
		                	  <h:inputText id="txtWithYear" maxlength="4" size="2" value="#{semir001Bean.year}" />
		                    </td>
		                  </tr>
		                </table>
		                </h:panelGroup></h:panelGrid>
		                <!-- End Content Criteria -->
		            </rich:panel>
				</h:panelGrid>
				
	            <h:panelGrid columns="5" id="grdSearchCommand">
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,panSearchCriteria,panSearchResult" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR002" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
	            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,panSearchResult">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR002" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR002" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />
	            	</a4j:commandButton>
	            	<a4j:commandButton id="btnBackPage" value="Back" styleClass="rich-button" 
	            	 	action="#{navAction.navi}" reRender="oppContent">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR001" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR001" />
						<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	            	</a4j:commandButton>
	            	<rich:spacer width="25" />
	            	<a4j:commandButton id="btnExport" value="Export Excel" styleClass="rich-button"
	            	 reRender="frmError,panSearchCriteria,panSearchResult">	
	            	</a4j:commandButton>
	            </h:panelGrid>
             	<h:panelGrid width="1000">
					<rich:panel id="panSearchResult"  >
						<f:facet name="header">
							<h:outputText value="ผลการค้นหา" />
						</f:facet>
						<rich:dataTable width="95%" id="dtbAcqCostDetail" cellpadding="1" cellspacing="0" border="0"
							var="acqCostDetail" value="#{semir002Bean.acqCostDetailList}" reRender="dstAcqCostDetail" 
							rows="#{semir002Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ประเภท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.networkType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Company" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Transfer Type" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.transferType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Region" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.regionName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Province" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.provinceName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Location" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Acqisition Cost" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.acqAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="As of Month" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqCostDetail.asOfMonth}" styleClass="contentform"  />
								</div>
							</rich:column>						
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbAcqCostDetail" 
									maxPages="10" id="dstAcqCostDetail" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
        
        <jsp:include page="../../pages/ir/semir002-popup.jsp"/>
        	
    </rich:panel>
</h:panelGrid>