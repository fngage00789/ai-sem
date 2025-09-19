<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchOldDoc7" width="800" autosized="true" minWidth="220" >
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.OldDoc.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchOldDoc7" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchOldDoc7" attachTo="hidepopupSearchOldDoc7" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupOldDocFrmError7">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		
		
	<h:form id="popupOldDocFrmSearch7"> 	
		<rich:panel>
		<table width="100%">							

           
		<tr>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.company']}" styleClass="ms7" />
			</td>
			<td >
			<h:outputLabel   value="#{semmel006Bean.popupOldDocCriteria7.company}" /> 
			</td>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.electricUseType']}" styleClass="ms7"/>
			</td>
			<td >
				<h:outputText   value="#{semmel006Bean.popupOldDocCriteria7.electricUseTypeDisplay}" style="width:120px;"/>
			</td>
		</tr>				            
  
  		<tr>
			<td align="right" >				 	
				<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7" rendered="flase"/>
			</td>
			<td >
				<h:selectOneMenu   value="#{semmel006Bean.popupOldDocCriteria7.expenseType}" style="width:120px;" rendered="flase">
					<f:selectItems value="#{semmel006Bean.elExpenseTypeList}"/>
				</h:selectOneMenu>
			</td>	
			<td></td>
			</tr>
			<tr>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.docNo']}" styleClass="ms7"/>
			</td>
			<td >
				<h:inputText   value="#{semmel006Bean.popupOldDocCriteria7.docNo}" style="width:120px;"></h:inputText>
			</td>
			
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.meterId']}" styleClass="ms7" />
			</td>
			<td >
			<h:inputText   value="#{semmel006Bean.popupOldDocCriteria7.meterId}" /> 
			</td>
			<td align="right" >
				 
			</td>
			<td >
				 
			</td>
		</tr>	
		
 
 		<tr>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.fromDocDt']}" styleClass="ms7" />
			</td>
			<td >
				<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
             			 value="#{semmel006Bean.popupOldDocCriteria7.fromDocDt}"  inputSize="18"/>
			</td>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.toDocDt']}" styleClass="ms7"/>
			</td>
			<td >
				<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
             			 value="#{semmel006Bean.popupOldDocCriteria7.toDocDt}"  inputSize="18"/>
			</td>
		</tr>	
 
          
		
 		<tr>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.fromTermOfPaymentDt']}" styleClass="ms7" />
			</td>
			<td >
				<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
             	value="#{semmel006Bean.popupOldDocCriteria7.fromTermOfPaymentDt}"  inputSize="18"/>
			</td>
			<td align="right" >
				<h:outputText value="#{jspMsg['label.popup.toTermOfPaymentDt']}" styleClass="ms7"/>
			</td>
			<td >
				<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
             		value="#{semmel006Bean.popupOldDocCriteria7.toTermOfPaymentDt}"  inputSize="18"/>
			</td>
		</tr>		
			
	                
              	 <tr>
              	 <td colspan="4">
              	 		<!-- end content criteria -->
			<h:panelGroup>
				<a4j:commandButton id="btnPopupOldDocSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
				action="#{navAction.navi}" reRender="popupOldDocFrmSearch7,dtbPopupOldDoc7,pnlPopupOldDocSearchResult,popupOldDocFrmError7" >
				<a4j:actionparam name="navModule" value="el" />
				<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHOLDDOC7" />
				<a4j:actionparam name="moduleWithNavi" value="el" />
				<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
				<a4j:actionparam name="methodWithNavi" value="doSearchPopupOldDoc7" />
				</a4j:commandButton>
				<rich:spacer width="10"></rich:spacer>
				<a4j:commandButton id="btnOldDocClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
           	 	action="#{navAction.navi}" reRender="popupOldDocFrmSearch7,dtbPopupOldDoc7,pnlPopupOldDocSearchResult,pnlPopupSearchCriteria,popupOldDocFrmError">
           		<a4j:actionparam name="navModule" value="el" />
				<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHOLDDOC7" />
				<a4j:actionparam name="moduleWithNavi" value="el" />
				<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
				<a4j:actionparam name="methodWithNavi" value="doClearSearchOldDoc7" />
           		</a4j:commandButton>
			</h:panelGroup>
              	 </td>
              	 </tr>
              	
		</table>
			</rich:panel>
				
				<h:panelGrid  id="grdPopupOldDocSearchResult">
					<rich:panel id="pnlPopupOldDocSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.OldDoc.docDetail']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupOldDoc7" width="95%"
						value="#{semmel006Bean.popupOldDoc7List}" rows="5" 
						rowKeyVar="RegInd" var="oldDoc" 
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
						rowClasses="cur" 
						styleClass="contentform">						
						<rich:column id="siteCheck" width="50">
							<f:facet name="header">
								<h:outputText value="Select" />
							</f:facet>
							<div align="center">
							<h:selectBooleanCheckbox id="checkBoxOldDoc7" 
			  							value="#{oldDoc.checkBoxSelected}"
			  				/>
							</div>
						</rich:column>		
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.OldDoc.docNoColumn']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{oldDoc.docNo}" styleClass="contentform"  />

							</div>
						</rich:column>

						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.OldDoc.docDt']}" styleClass="contentform" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{oldDoc.docDt}" styleClass="contentform"  />

							</div>
						</rich:column>
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.meterId']}" styleClass="contentform" />
							</f:facet>
							<div align="center">								
								<h:outputText value="#{oldDoc.meterId}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.refMeterId']}" styleClass="contentform" />
							</f:facet>
							<div align="center">								
                               <h:outputText value="#{oldDoc.refMeterId}" styleClass="contentform"  />
							</div>
						</rich:column>						
						
						<rich:column  rendered="flase">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.termOfPayment']}" styleClass="contentform" />
							</f:facet>
							<div align="center">								
								<h:outputText value="#{oldDoc.termOfPaymentDtTH}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column  rendered="true">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.fromTermOfPayment']}" styleClass="contentform" />
							</f:facet>
							<div align="center">								
								<h:outputText value="#{oldDoc.outFromTermOfPaymentDtTH}" styleClass="contentform"  />
							</div>
						</rich:column>
						<rich:column  rendered="true">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.popup.installment.toTermOfPayment']}" styleClass="contentform" />
							</f:facet>
							<div align="center">								
								<h:outputText value="#{oldDoc.outToTermOfPaymentDtTH}" styleClass="contentform"  />
							</div>
						</rich:column>
                         <f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupSite7" 
									maxPages="10" id="dstdtbPopupSite7" selectedStyleClass="selectScroll" />
							</f:facet>		
						</rich:dataTable>
					</rich:panel>

				<h:panelGrid columns="4" border="0">
					
					<a4j:commandButton  id="btnOldDocAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 										 
										value="Save" 
										reRender="payment7Info,payinInfo,pnlPaymentList,popupOldDocFrmError7" 
										disabled="false"
										oncomplete="#{semmel006Bean.hidePopup?'hideGroupReceivePopup();' : ''}" >
						<a4j:actionparam name="navModule" value="el" />
            			<a4j:actionparam name="navProgram" value="SEMMEL006-7" />	
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doAddOldDoc7" />	
				
						
					</a4j:commandButton>
					<a4j:jsFunction name="hideGroupReceivePopup" oncomplete="#{rich:component('popupSearchOldDoc7')}.hide(); return false"/>
					<a4j:commandButton id="btnSearchOldDocCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupSearchOldDoc7" attachTo="btnSearchOldDocCancel" operation="hide" event="onclick" />
				</h:panelGrid>

				
					
				</h:panelGrid>
			
				</h:form>
</rich:modalPanel>

