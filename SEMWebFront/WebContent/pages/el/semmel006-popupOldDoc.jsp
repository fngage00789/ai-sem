<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<rich:modalPanel id="popupSearchOldDoc" width="400" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.OldDoc.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchOldDoc" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchOldDoc" attachTo="hidepopupSearchOldDoc" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupOldDocFrmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		
		
	<h:form id="popupOldDocFrmSearch"> 	
		<rich:panel>
							<table width="100%">							
							<tr>
							
									<td align="right"  colspan="1">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['header.popup.OldDoc.docNo']}" styleClass="ms7"/>
		                			</td>
		                			<td  colspan="3">
		                				<h:inputText  value="#{semmel006Bean.popupOldDocCriteria.docNo}" style="width:120px;"/>
				                	</td>
				            </tr>
				            <tr>
				              	
				                	<td align="right"   colspan="1">
				                		<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['header.popup.OldDoc.fromDocDt']}" styleClass="ms7"/>
		                			</td>
		                			<td   colspan="3">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.popupOldDocCriteria.fromDocDt}"  inputSize="18" id="docDateFrom"
				                			 oninputblur="validateRichCalendarFromTo('popupOldDocFrmSearch','docDateFrom','docDateTo');"
											 oncollapse="validateRichCalendarFromTo('popupOldDocFrmSearch','docDateFrom','docDateTo');"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
				                	</td>
				                	
			                </tr>
				            <tr>
				              	
				                	<td align="right"   colspan="1">
				                		<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['header.popup.OldDoc.toDocDt']}" styleClass="ms7"/>
		                			</td>
		                			<td   colspan="3">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.popupOldDocCriteria.toDocDt}" inputSize="18" id="docDateTo"
				                			 oninputblur="validateRichCalendarFromTo('popupOldDocFrmSearch','docDateTo','docDateFrom');"
											 oncollapse="validateRichCalendarFromTo('popupOldDocFrmSearch','docDateTo','docDateFrom');"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
				                	</td>
				                	
			                </tr>			                
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupOldDocSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="popupOldDocFrmSearch,dtbPopupOldDoc,pnlPopupOldDocSearchResult,popupOldDocFrmError" >
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHOLDDOC" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doSearchPopupOldDoc" />
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnOldDocClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="popupOldDocFrmSearch,dtbPopupOldDoc,pnlPopupOldDocSearchResult,pnlPopupSearchCriteria,popupOldDocFrmError">
					           		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL006-POPUPSEARCHOLDDOC" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi" value="doClearSearchOldDoc" />
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
						<rich:dataTable id="dtbPopupOldDoc" width="95%"
						value="#{semmel006Bean.popupOldDocList}" rows="5" 
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
							<sem:radioButton id="rdBtSel"
			  							name="rdCol"
			  							overrideName="true"
			  							value="#{semmel006Bean.selectedRadio}"
			  							itemValue="#{oldDoc.docNo}"/>
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
								<h:outputText value="#{oldDoc.docDtTH}" styleClass="contentform"  />
							</div>
						</rich:column>


						</rich:dataTable>
					</rich:panel>

				<h:panelGrid columns="2">
					<a4j:commandButton  id="btnOldDocAddBySelect" styleClass="rich-button" 
										action="#{navAction.navi}" 										 
										value="Save" 
										reRender="paymentPostpaidInfo,popupOldDocFrmSearch" disabled="#{semmel006Bean.savePopupOldDocDisable}">
						<a4j:actionparam name="navModule" value="el" />
            			<a4j:actionparam name="navProgram" value="SEMMEL006-3" />	
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doAddOldDoc" />	
				
						
					</a4j:commandButton>
					<a4j:commandButton id="btnSearchOldDocCancel" styleClass="rich-button" value="Cancel"/>
					<rich:componentControl for="popupSearchOldDoc" attachTo="btnOldDocAddBySelect,btnSearchOldDocCancel" operation="hide" event="onclick" />
				</h:panelGrid>

				
					
				</h:panelGrid>
			
				</h:form>
</rich:modalPanel>

