<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir007" var="jspMsg"/>
<rich:modalPanel id="popupfrmAddDraft" width="600" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.addPopup.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpAdd" style="cursor:pointer"/>
				<rich:componentControl for="popupfrmAddDraft" attachTo="hidePopUpAdd" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	<a4j:form id="frmAddDraft"> 
		<h:panelGrid id="messageHeader">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
				rendered="#{semmir007Bean.renderedMsgFormSearchPopup}">
		 		<f:facet name="header">
                     <h:outputText value="Entered Data Status:"></h:outputText>
                </f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                </f:facet>
		</rich:messages>
		</h:panelGrid>
		
		<rich:panel>
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				  	<h:panelGrid>
				  		<h:panelGroup>
				  		<table width="100%">
				  			<tr>
				  				<td colspan="4" align="center" >
                    				<h:selectOneRadio id="rbtMode" value="#{semmir007Bean.policySPPopAdd.genType}" layout="lineDirection" styleClass="ms7" rendered="true">
                    					<f:selectItem  itemValue="A" itemLabel="#{jspMsg['label.genTypeA']}"/>
                    					<f:selectItem itemValue="U" itemLabel="#{jspMsg['label.genTypeD']}"/>
                    					<a4j:support event="onclick" action="#{semmir007Action.chkGenType}" reRender="frmAddDraft"/>
                    				</h:selectOneRadio>
		                    	</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
						    		<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
						    	</td>
						    	<td>	
						    		<h:selectOneMenu id="ddlPopAddCompany" value="#{semmir007Bean.policySPPopAdd.company}">
										<f:selectItems value="#{semmir007Bean.companyList}" />
										<a4j:support event="onchange" action="#{semmir007Action.selectRefPolicyNo}" reRender="frmAddDraft"/>
			               			 </h:selectOneMenu>
			               		</td>
			           		</tr>
			                <tr>
			                	<td align="right">
			                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmir007Bean.renderReqTransferType}"/>
				                	<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>		
								</td>
								<td>	
									<h:selectOneMenu id="ddlPopAddNetworkType" value="#{semmir007Bean.policySPPopAdd.networkType}">
				                		<f:selectItems value="#{semmir007Bean.networkTypeList}" />
				                		<a4j:support event="onchange" action="#{semmir007Action.selectRefPolicyNo}" reRender="frmAddDraft"/>
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
		                	<tr>
			                	<td align="right">
			                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmir007Bean.renderReqTransferType}"/>
				                	<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>		
								</td>
								<td>
									<h:selectOneMenu id="ddlPopAddTransferType" value="#{semmir007Bean.policySPPopAdd.transferType}">
				                		<f:selectItems value="#{semmir007Bean.transferTypeList}" />
				                		<a4j:support event="onchange" action="#{semmir007Action.selectRefPolicyNo}" reRender="frmAddDraft"/>
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
		                	<tr>
			                	<td align="right">
				                	<h:outputText value="#{jspMsg['label.policyType']}" styleClass="ms7"/>		
								</td>
								<td>	
									<h:selectOneMenu id="ddlPopAddPolicyType" value="#{semmir007Bean.policySPPopAdd.policyType}">
				                		<f:selectItems value="#{semmir007Bean.policyTypeList}" />
				                		<a4j:support event="onchange" action="#{semmir007Action.selectRefPolicyNo}" reRender="frmAddDraft"/>
				                	</h:selectOneMenu>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopContractNo" value="#{jspMsg['label.contractNo']}" styleClass="ms7" rendered="#{semmir007Bean.renderContractNo}"/>
								</td>
								<td>
									<h:inputText id="txtPopAddContractNo" value="#{semmir007Bean.policySPPopAdd.contractNo}" rendered="#{semmir007Bean.renderContractNo}" >
										<a4j:support event="onblur" action="#{semmir007Action.searchContract}"  
								              reRender="frmAddDraft">
								        </a4j:support>
								    </h:inputText>	
		                		</td>
		                	</tr>
		                	<tr>
		                		<td align="right">
			                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmir007Bean.renderReqRefPolicy}"/>
				                	<h:outputText value="#{jspMsg['label.refPolicy']}" styleClass="ms7"/>		
								</td>
								<td>	
									<h:selectOneMenu id="ddlPopAddRefPolicy" value="#{semmir007Bean.policySPPopAdd.refPolicyNo}" >
				                		<f:selectItems value="#{semmir007Bean.refPolicyList}" />
				                		<a4j:support event="onchange" action="#{semmir007Action.getEffExpDate}" reRender="frmAddDraft"/>
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
		                	<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7"/>
								</td>
								<td>
						    		<rich:calendar id="cldPopAddEffDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmir007Bean.policySPPopAdd.effDt}"
										   showWeeksBar="false"
										   inputSize="10" 
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px" 
									   	   disabled="true">
									</rich:calendar>
								</td>
								<td align="right">
									<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
								</td>
								<td>
						    		<rich:calendar id="cldPopAddExpDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmir007Bean.policySPPopAdd.expDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px" 
									   	   disabled="true">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.newPolicyStartDt']}" styleClass="ms7"/>
								</td>
								<td>
						    		<rich:calendar id="cldPopAddNewEffDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmir007Bean.policySPPopAdd.newEffDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px" >
									   	   <a4j:support event="onchanged" action="#{semmir007Action.getPremium}" reRender="frmAddDraft"/>
									   	   <a4j:support event="oninputblur" action="#{semmir007Action.getPremium}" reRender="frmAddDraft"/>
									</rich:calendar>
								</td>
								<td align="right">
									<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
								</td>
								<td>
						    		<rich:calendar id="cldPopAddNewExpDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmir007Bean.policySPPopAdd.newExpDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px" >
									   	   <a4j:support event="onchanged" action="#{semmir007Action.getPremium}" reRender="frmAddDraft"/>
									   	   <a4j:support event="oninputblur" action="#{semmir007Action.getPremium}" reRender="frmAddDraft"/>
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.dataAsOf']}" styleClass="ms7"/>
								</td>
								<td colspan="2">	
									<h:inputText id="txtDataAsOf" value="#{semmir007Bean.policySPPopAdd.dataAsOf}"
									onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
									onkeyup="addSlashForDate(this)"
									onblur="autoAddYear(this)"
									maxlength="7"/>
								</td>
							</tr>
							<tr>
			                	<td align="right">
				                	<h:outputText value="#{jspMsg['label.premium']}" styleClass="ms7"/>		
								</td>
								<td>
									<h:selectOneMenu id="ddlPremium" value="#{semmir007Bean.policySPPopAdd.premiumId}">
				                		<f:selectItems value="#{semmir007Bean.premiumList}" />
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
						</table>
						</h:panelGroup>
					</h:panelGrid>
						<h:panelGrid columns="3">
						  <a4j:commandButton  id="hidePopUpAdd" styleClass="rich-button" action="#{navAction.navi}" value="Save" 
							reRender="messageHeader"
							oncomplete="if(#{semmir007Bean.popupCloseValidAdd == 'true'}){
			           		 				#{rich:component('mdpConfirmPopupAddDialog')}.show();}
			           		 			else if(#{semmir007Bean.renderedMsgFormSearchPopup == 'true'}){
			           		 				}else{
			           		 				#{rich:component('popupfrmAddDraft')}.hide();}">
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR007" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
								<a4j:actionparam name="methodWithNavi" value="initAdd" />	
						  </a4j:commandButton>
						  
						  <a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupfrmAddDraft" operation="hide" event="onclick" />
						  </a4j:commandButton>		
						</h:panelGrid>
				  </table>
		</rich:panel>
	  </a4j:form>
</rich:modalPanel>

<a4j:form id="frmConfirmPopupAddDialog">
<rich:modalPanel id="mdpConfirmPopupAddDialog" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmir007Bean.confirmPopupAddMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch,frmSearch"
						 oncomplete="#{rich:component('popupfrmAddDraft')}.hide();
						 			#{rich:component('mdpConfirmPopupAddDialog')}.hide(); return false">						
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR007" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
								<a4j:actionparam name="methodWithNavi" value="doAdd" />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" >
						    <rich:componentControl for="mdpConfirmPopupAddDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>

</a4j:form>


