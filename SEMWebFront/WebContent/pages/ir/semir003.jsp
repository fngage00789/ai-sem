<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Replacement Value" />
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
			                	<h:selectOneMenu id="ddlCompany" value="#{semir003Bean.replacementValueSP.company}">
			                		<f:selectItems value="#{semir003Bean.companyList}" />
			                	</h:selectOneMenu>
		                		<h:message for="ddlCompany" styleClass="ms7red" />
		                	</h:panelGroup>
		                	<rich:spacer width="5" />
		                	<rich:spacer width="2" />
		                	<rich:spacer width="2" />
		                	<h:panelGroup>
		                		<div align="right">
		                			<h:outputText value="ประเภท :" styleClass="ms7" />
		                		</div>
		                	</h:panelGroup>
		                			<h:selectOneMenu id="somNetworkType" value="#{semir003Bean.replacementValueSP.networkType}">
		                				<f:selectItems value="#{semir003Bean.networkTypeList}" />
		                			</h:selectOneMenu>
		                			<rich:spacer width="5" />
		                			<h:outputText value="Transfer Type :" styleClass="ms7" />
									<h:selectOneMenu id="transferType" value="#{semir003Bean.replacementValueSP.tfType}">
			                			<f:selectItems value="#{semir003Bean.transferTypeList}" />
			                		</h:selectOneMenu>
		                	<h:panelGroup>
		                		<div align="right">
		                			<h:outputText value="Effective Date :" styleClass="ms7" />
		                		</div>
		                	</h:panelGroup>
		                	<rich:calendar id="effectiveDate" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" value="#{semir003Bean.replacementValueSP.effDt}" />
		                </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
				
	            <h:panelGrid columns="3" id="grdSearchCommand">
	            	
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,panSearchCriteria,panSearchResult" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR003" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR003" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
					<h:commandButton id ="btnExport" action="#{semir003Action.doExportExcel}"  
	            					 styleClass="rich-button" value="Excel Report" disabled="#{semir003Bean.disabledBtnExport}">
	            	</h:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
	            	reRender="frmError,frmSearch,panSearchCriteria,panSearchResult">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMIR003" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMIR003" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />	
	            	</a4j:commandButton>
	            </h:panelGrid>
            
				<h:panelGrid width="1000">
					<rich:panel id="panSearchResult"  >
						<f:facet name="header">
							<h:outputText value="ผลการค้นหา" />
						</f:facet>
						<rich:dataTable width="95%" id="dtbReplacement" cellpadding="1" cellspacing="0" border="0"
							var="replacementValueSP" value="#{semir003Bean.replacementValueSPList}" reRender="dstReplacement" 
							rows="#{semir003Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column style="text-align: center;">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semir003Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semir003Action.selectAllRow}" reRender="dtbReplacement,btnExport"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox id="chkSelect" onclick="onRenderButton()" value="#{replacementValueSP.checkBox}">
									<a4j:jsFunction name="onRenderButton" 
													action="#{semir003Action.onRenderExportButton}"
													reRender="btnExport">
									</a4j:jsFunction>
								</h:selectBooleanCheckbox>
							</rich:column>
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
		            					<a4j:actionparam name="navProgram" value="SEMIR003" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR003" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="replRowId" value="#{replacementValueSP.dataObj.replRowId}"/>
										<a4j:actionparam name="replCompany" value="#{replacementValueSP.dataObj.company}"/>
										<a4j:actionparam name="replNtType" value="#{replacementValueSP.dataObj.networkCode}"/>
										<a4j:actionparam name="replTfType" value="#{replacementValueSP.dataObj.tfCode}"/>
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
		            					<a4j:actionparam name="navProgram" value="SEMIR003" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMIR003" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="replRowId" value="#{replacementValueSP.dataObj.replRowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column id="colNetworkCode" sortBy="#{replacementValueSP.dataObj.networkCode}">
								<f:facet name="header">
									<h:outputText value="ประเภท" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{replacementValueSP.dataObj.networkCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colCompany" sortBy="#{replacementValueSP.dataObj.company}">  
								<f:facet name="header">
									<h:outputText value="Company" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{replacementValueSP.dataObj.company}" styleClass="contentform"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colTransferType" sortBy="#{replacementValueSP.dataObj.tfType}"> 
								<f:facet name="header">
									<h:outputText value="Transfer Type" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{replacementValueSP.dataObj.tfType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colReplRate" sortBy="#{replacementValueSP.dataObj.replRate}"> 
								<f:facet name="header">
									<h:outputText value="%Replacement" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{replacementValueSP.dataObj.replRate}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colEffectDate" sortBy="#{replacementValueSP.dataObj.effDt}"> 
								<f:facet name="header">
									<h:outputText value="Effective Date" styleClass="contentform" />
								</f:facet>
								<div align="center"> 
									<h:outputText value="#{replacementValueSP.dataObj.effDt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colUpdateBy" sortBy="#{replacementValueSP.dataObj.updateBy}"> 
								<f:facet name="header">
									<h:outputText value="Update By" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{replacementValueSP.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colUpdateDate" sortBy="#{replacementValueSP.updateDt}"> 
								<f:facet name="header">
									<h:outputText value="Update Date" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{replacementValueSP.dataObj.updateDt}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbReplacement" 
									maxPages="10" id="dstReplacement" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
        <jsp:include page="../../pages/ir/semir003-edit.jsp"/>
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
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" reRender="dtbReplacement" >
							<a4j:actionparam name="navModule" value="ir" />
		            		<a4j:actionparam name="navProgram" value="SEMIR003" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMIR003" />
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