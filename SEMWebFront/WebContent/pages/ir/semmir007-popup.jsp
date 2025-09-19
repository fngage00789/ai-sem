<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmirpopup" var="jspMsgPop"/>
<rich:modalPanel id="popupSearchDraft" height="500" autosized="true" >	
	<f:facet name="header">
		<h:outputText value="#{jspMsgPop['header.popup.name']}" />
	</f:facet>
	
	<h:panelGrid columnClasses="gridContent">
	<a4j:form id="frmSearchDraft">
		<rich:panel id="panSearchDraftCriteria">
			<f:facet name="header">
				<h:outputText value="#{jspMsgPop['header.criteria.name']}" />
			</f:facet>
			<h:panelGrid id="panelErrorPop">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmirPopupBean.renderedMsgFormSearch}">
			 		<f:facet name="header">
	                      	<h:outputText value="Entered Data Status:"></h:outputText>
	                  	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
	                   </f:facet>
	            </rich:messages>
			</h:panelGrid>
			 <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
			 <table width="100%">
	               <tr>
	                  	<td align="right" width="20%">
	                  		<h:graphicImage value="images/icon_required.gif"/>
	                		<h:outputText id="lblCompany" value="#{jspMsgPop['label.company']}" styleClass="ms7"/></td>
	                    <td width="30%">
	                      <h:selectOneMenu id="ddlCompany" value="#{semmirPopupBean.policySP.company}">
		                		<f:selectItems value="#{semmirPopupBean.companyList}"/>
		                	</h:selectOneMenu>
	                    </td>
	                     <td align="right" width="10%"><h:outputText id="lblNetworkType" value="#{jspMsgPop['label.networkType']}" styleClass="ms7"/></td>
	                    <td width="30%">
	                      <h:selectOneMenu id="ddlNetworkType" value="#{semmirPopupBean.policySP.networkType}">
	                				<f:selectItems value="#{semmirPopupBean.networkTypeList}"/>
	                			</h:selectOneMenu>
	                    </td>
	                  </tr>
	                  
	                  <tr>
	                   
	                    <td align="right"><h:outputText id="lblTransferType" value="#{jspMsgPop['label.transferType']}" styleClass="ms7"/></td>
	                    <td>
	                      <h:selectOneMenu id="transferType" value="#{semmirPopupBean.policySP.tfType}">
		                		<f:selectItems value="#{semmirPopupBean.transferTypeList}"/>
		                  </h:selectOneMenu>
	                    </td>
	                     <td align="right" valign="top"><h:outputText id="lblPolicyType" value="#{jspMsgPop['label.policyType']}" styleClass="ms7"/></td>
	                    <td>
	                     	<h:selectOneMenu id="ddlPolicy" value="#{semmirPopupBean.policySP.ptType}">
	                				<f:selectItems value="#{semmirPopupBean.policyTypeList}"/>
	                		</h:selectOneMenu>	
						</td>						
	                  </tr>
             </table>
			 </h:panelGroup></h:panelGrid>
			  <h:panelGrid columns="5" id="grdSearchCommandDF">
			  	<a4j:commandButton id="btnSearch" value="#{jspMsgPop['btn.search']}" styleClass="rich-button" action="#{navAction.navi}" reRender="frmSearchDraft,panelErrorPop" >
					<a4j:actionparam name="navModule" value="ir" />
					<a4j:actionparam name="navProgram" value="#{semmirPopupBean.currentPage}" />
					<a4j:actionparam name="moduleWithNavi" value="ir" />
					<a4j:actionparam name="actionWithNavi" value="SEMMIRPopup" />
					<a4j:actionparam name="methodWithNavi" value="doSearch" />
				</a4j:commandButton>
            	<a4j:commandButton id="btnClear" value="#{jspMsgPop['btn.clear']}" styleClass="rich-button" 
            	action="#{navAction.navi}"  reRender="frmSearchDraft,panSearchDraftCriteria">
	            	<a4j:actionparam name="navModule" value="ir" />
					<a4j:actionparam name="navProgram" value="#{semmirPopupBean.currentPage}" />
					<a4j:actionparam name="moduleWithNavi" value="ir" />
					<a4j:actionparam name="actionWithNavi" value="SEMMIRPopup" />
					<a4j:actionparam name="methodWithNavi" value="doClear" />	
            	</a4j:commandButton>
            	</h:panelGrid>
		</rich:panel>	
		 <h:panelGrid width="1000">
		 	<rich:panel id="panSearchResultDraft"  >
				<f:facet name="header">
					<h:outputText value="#{jspMsgPop['header.resultTable.name']}"/>
				</f:facet>
				<div align="center">
					<h:outputLabel style="color:red;size:20px" value="#{semmirPopupBean.msgDataNotFound}" rendered="#{semmirPopupBean.renderedMsgDataNotFound}" />
				</div>
				<rich:dataTable width="95%" id="dtbPolicyDF" cellpadding="1" cellspacing="0" border="0"
				var="policyValueSPPop" value="#{semmirPopupBean.policySPList}" reRender="dtbPolicyDF" 
				rows="#{semmirPopupBean.rowPerPage}"
				onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
				onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
				styleClass="contentform">
					<rich:column id="policyCheckDF">
						<f:facet name="header">
							<h:outputText value="" styleClass="contentform" />
						</f:facet>
						<div align="center">
						<h:selectBooleanCheckbox id="policyHeadeCheckDF" value="#{policyValueSPPop.checkBox}" >
							<a4j:support event="onclick" action="#{semmirPopupAction.checkPopupBox}" reRender="policyHeadeCheckDF,panSearchResultDraft,btnSelect">	
								<a4j:actionparam name="draftNo" value="#{policyValueSPPop.dataObj.draftNo}" />
							</a4j:support>
						</h:selectBooleanCheckbox>
						</div>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{jspMsgPop['column.draftID']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{policyValueSPPop.dataObj.draftNo}" styleClass="contentform"  />
						</div>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{jspMsgPop['column.networkType']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{policyValueSPPop.dataObj.networkTypeDesc}" styleClass="contentform"  />
						</div>
					</rich:column>
					<rich:column >    
						<f:facet name="header" >
							<h:outputText value="#{jspMsgPop['column.company']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="" styleClass="contentform" >         
								<h:outputText value="#{policyValueSPPop.dataObj.company}" styleClass="contentform"  />
							</h:outputText>
						</div>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{jspMsgPop['column.transferType']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{policyValueSPPop.dataObj.tfTypeDesc}" styleClass="contentform"  />
						</div>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{jspMsgPop['column.policyType']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{policyValueSPPop.dataObj.ptTypeDesc}" styleClass="contentform"  />
						</div>
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPolicyDF" 
							maxPages="10" id="dtbPolicyDF" selectedStyleClass="selectScroll" />
					</f:facet>
				</rich:dataTable>
			</rich:panel>
		</h:panelGrid>
		<h:panelGrid columns="5" id="grdSearchDraftCommand">
			<a4j:commandButton id="btnSelect" value="#{jspMsgPop['btn.select']}" styleClass="rich-button" 
           	action="#{semmirPopupAction.selectItem}" reRender="txtDraftID" disabled="#{semmirPopupBean.disableBtnSelect}">
           		 <rich:componentControl for="popupSearchDraft" operation="hide" event="onclick" />
           	</a4j:commandButton>
           	<a4j:commandButton value="#{jspMsgPop['btn.cancel']}" styleClass="rich-button" immediate="true" action="#{semmirPopupAction.cancelPopup}">           		
			    <rich:componentControl for="popupSearchDraft" operation="hide" event="onclick" />
			</a4j:commandButton>
		</h:panelGrid>
	</a4j:form>
	</h:panelGrid>
</rich:modalPanel>
