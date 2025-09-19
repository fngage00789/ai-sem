<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Deductible" />
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
		                	<h:panelGroup>
		                		<div align="right">
			                		<h:graphicImage value="images/icon_required.gif" />
			                		<h:outputText value="Company :" styleClass="ms7" />
		                		</div>
		                	</h:panelGroup>
		                	<h:panelGroup>
			                	<h:selectOneMenu id="somCompany" value="#{semir004Bean.deductibleSP.company}" required="true" requiredMessage="Company is required">
			                		<f:selectItems value="#{semir004Bean.companyList}" />
			                	</h:selectOneMenu>
			                	<h:message for="somCompany" styleClass="ms7red" />
		                	</h:panelGroup>
		                	<rich:spacer width="5" />
		                	<rich:spacer width="2" />
		                	<rich:spacer width="2" />
		                	<h:panelGroup>
		                		<div align="right">
		                			<h:outputText value="ประเภท :" styleClass="ms7" />
		                		</div>
		                	</h:panelGroup>
		                			<h:selectOneMenu id="somNetworkType" value="#{semir004Bean.deductibleSP.networkType}">
		                				<f:selectItems value="#{semir004Bean.networkTypeList}" />
		                			</h:selectOneMenu>
		                			<rich:spacer width="5" />
		                			<h:outputText value="Transfer Type :" styleClass="ms7" />
									<h:selectOneMenu id="transferType" value="#{semir004Bean.deductibleSP.tfType}">
			                			<f:selectItems value="#{semir004Bean.transferTypeList}" />
			                		</h:selectOneMenu>
		                	<h:outputText value="Effective Date :" styleClass="ms7" />
		                	<rich:calendar id="effectiveDate" locale="en/US" datePattern="dd/MM/yyyy" value="" />
		                </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
				
	             <h:panelGrid columns="4" id="grdSearchCommand">
	            	
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,panSearchCriteria,panSearchResult" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR004" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
	            	reRender="frmError,frmSearch,panSearchCriteria,panSearchResult">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR004" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />	
	            	</a4j:commandButton>
	            	<rich:spacer width="25" />
	            	<a4j:commandButton id="btnNew" value="Add New" styleClass="rich-button" action="#{navAction.navi}"
						oncomplete="#{rich:component('popupFrmEdit')}.show(); return false" reRender="frmEdit">
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR004" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
						<a4j:actionparam name="methodWithNavi" value="initAdd" />
					</a4j:commandButton>
	            </h:panelGrid>
            
		    	<h:panelGrid width="1000">
					<rich:panel id="panSearchResult"  >
						<f:facet name="header">
							<h:outputText value="ผลการค้นหา" />
						</f:facet>
						<rich:dataTable width="95%" id="dtbDeductible" cellpadding="1" cellspacing="0" border="0"
							var="deductibleValueSP" value="#{semir004Bean.deductibleSPList}" reRender="dstDeductible" 
							rows="#{semir004Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
						<rich:column>
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('popupFrmEdit')}.show(); return false"
	            									   action="#{navAction.navi}" 
	            									   reRender="frmEdit"
	            									   image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMIR004" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="rowId" value="#{deductibleValueSP.deductId}"/>
										<a4j:actionparam name="deductCompany" value="#{deductibleValueSP.company}"/>
										<a4j:actionparam name="deductNtType" value="#{deductibleValueSP.networkType}"/>
										<a4j:actionparam name="deductTfType" value="#{deductibleValueSP.tfType}"/>
										<a4j:actionparam name="deductLsType" value="#{deductibleValueSP.lsType}"/>
										<a4j:actionparam name="deductVal" value="#{deductibleValueSP.deductAmt}"/>
										<a4j:actionparam name="deductEffDt" value="#{deductibleValueSP.effDt}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            									   action="#{navAction.navi}" 
	            									   image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="ir" />
		            					<a4j:actionparam name="navProgram" value="SEMIR004" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{deductibleValueSP.deductId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column id="colNetworkType" sortBy="#{deductibleValueSP.networkType}">
								<f:facet name="header">
									<h:outputText value="ประเภท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.networkType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colCompany" sortBy="#{deductibleValueSP.company}">  
								<f:facet name="header">
									<h:outputText value="Company" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{deductibleValueSP.company}" styleClass="contentform"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colTransferType" sortBy="#{deductibleValueSP.tfType}">  
								<f:facet name="header">
									<h:outputText value="Transfer Type" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.tfType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colLossType" sortBy="#{deductibleValueSP.lsType}">  
								<f:facet name="header">
									<h:outputText value="ความเสียหาย" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.lsType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colDeuctibleAmt" sortBy="#{deductibleValueSP.deductAmt}">  
								<f:facet name="header">
									<h:outputText value="Dedutible" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.deductAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colEffDt" sortBy="#{deductibleValueSP.effDt}">  
								<f:facet name="header">
									<h:outputText value="Effective Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.effDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colUpdateBy" sortBy="#{deductibleValueSP.updateBy}">  
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colUpdateDt" sortBy="#{deductibleValueSP.updateDt}">  
								<f:facet name="header">
									<h:outputText value="Update Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{deductibleValueSP.updateDt}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbDeductible" 
									maxPages="10" id="dstDeductible" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid> 
				
			</a4j:form>				
        </h:panelGrid>
        <jsp:include page="../../pages/ir/semir004-edit.jsp"/>
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
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" reRender="dtbDeductible" >
							<a4j:actionparam name="navModule" value="ir" />
		            		<a4j:actionparam name="navProgram" value="SEMIR004" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
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