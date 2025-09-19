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
		                <h:panelGrid columns="5">
		                	<h:panelGroup><div align="right">
		                		<h:graphicImage value="images/icon_required.gif" />
		                		<h:outputText value="Company :" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:panelGroup>
			                <h:selectOneMenu id="somCompany" value="#{semir005Bean.insuredCriteria.company}">
			                	<f:selectItems value="#{semir005Bean.companyList}" />
			                </h:selectOneMenu>
			                <h:message for="somCompany" styleClass="ms7red"/>
			                </h:panelGroup>
			                
		                	<rich:spacer width="5" />
		                	<rich:spacer width="2" />
		                	<rich:spacer width="2" />
		                	<h:panelGroup><div align="right">
		                		<h:outputText value="ประเภท :" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:selectOneMenu id="networkType" value="#{semir005Bean.insuredCriteria.networkType}">
		                		<f:selectItems value="#{semir005Bean.networkTypeList}" />
		                	</h:selectOneMenu>
		                	<rich:spacer width="5" />
		                	<rich:spacer width="2" />
		                	<rich:spacer width="2" />
		                	<h:panelGroup><div align="right">
		                		<h:outputText value="Location ID :" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:inputText id="txtLocationId" size="15" value="#{semir005Bean.insuredCriteria.locationId}"/>
		                	<rich:spacer width="5" />
		                	<h:panelGroup><div align="right">
		                		<h:outputText value="Location Name :" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<h:panelGroup>
		                	<h:inputText id="txtLocationName" size="15" value="#{semir005Bean.insuredCriteria.locationName}"/>
		                		<a4j:commandButton id="btnSearchLocation" action="#{navAction.navi}" 
		                			oncomplete="#{rich:component('popupLocationFrmAdd')}.show(); return false"
	            					value="ค้นหา Location" styleClass="rich-button">
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMIR005" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
									<a4j:actionparam name="methodWithNavi" value="initLocation" />	
									<a4j:actionparam name="btnCheck" value="search" />
	            				</a4j:commandButton>
	            			</h:panelGroup>
	            			<h:panelGroup><div align="right">
		                		<h:outputText value="Effective Date :" styleClass="ms7" />
		                	</div></h:panelGroup>
		                	<rich:calendar id="effectiveDate" locale="en/US" datePattern="dd/MM/yyyy" value="#{semir005Bean.insuredCriteria.effDt}" />
		                </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
				
	            <h:panelGrid columns="4" id="grdSearchCommand">
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,panSearchCriteria,panSearchResult">
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR005" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
	            	 	action="#{navAction.navi}" reRender="frmError,panSearchCriteria,panSearchResult">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR005" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />
	            	</a4j:commandButton>
	            	<rich:spacer width="25" />
	            	<a4j:commandButton id="btnNew" value="Add New" styleClass="rich-button" action="#{navAction.navi}"
						oncomplete="#{rich:component('popupFrmEdit')}.show(); return false" reRender="frmEdit">
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR005" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
						<a4j:actionparam name="methodWithNavi" value="initAdd" />
					</a4j:commandButton>
	            </h:panelGrid>
             
				<h:panelGrid width="1000">
					<rich:panel id="panSearchResult">
						<f:facet name="header">
							<h:outputText value="ผลการค้นหา" />
						</f:facet>
						<rich:dataTable width="95%" id="dtbInsured" cellpadding="1" cellspacing="0" border="0"
							var="insured" value="#{semir005Bean.insuredList}" reRender="dstInsured" 
							rows="#{semir005Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/delete.png" style="height: 15; width: 15;" 
													   oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
													   action="#{navAction.navi}">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMIR005" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="insuredId" value="#{insured.insuredId}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										oncomplete="#{rich:component('popupFrmEdit')}.show(); return false" 
										action="#{navAction.navi}" reRender="frmEdit">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMIR005" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="insuredId" value="#{insured.insuredId}"/>
										<a4j:actionparam name="insuredNetworkType" value="#{insured.networkType}"/>
										<a4j:actionparam name="insuredCompany" value="#{insured.company}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ประเภท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.networkType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Company" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.company}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Location" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="ทุนประกันภัย" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.insuredAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Effective Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.effDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Update Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insured.updateDt}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbInsured" 
									maxPages="10" id="dstInsured" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
        <jsp:include page="../../pages/ir/semir005-edit.jsp" />
        <jsp:include page="../../pages/ir/semir005-popup.jsp"/>
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
							action="#{navAction.navi}" reRender="panSearchResult" >
							<a4j:actionparam name="navModule" value="ir" />
		            		<a4j:actionparam name="navProgram" value="SEMIR005" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />
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