<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir007" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir007Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<h:panelGrid width="96%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
		                  <tr>
		                    <td align="right" width="20%">  		                	  
		                    </td>
		                    <td colspan="2" >
		                    				<h:selectOneRadio id="rbtMode" value="#{semmir007Bean.policySP.genType}" layout="lineDirection" styleClass="ms7" rendered="true">
		                    					<f:selectItem  itemValue="A" itemLabel="#{jspMsg['label.genTypeA']}"/>
		                    					<f:selectItem itemValue="U" itemLabel="#{jspMsg['label.genTypeD']}"/>
		                    				</h:selectOneRadio>
		                    					
		                    </td>                 
		                  </tr>
		                  <tr>
		                  	<td align="right" width="10%" >
		                  		
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlCompany" value="#{semmir007Bean.policySP.company}">
			                		<f:selectItems value="#{semmir007Bean.companyList}"/>
			                	</h:selectOneMenu>
		                    </td>
		                    <td align="right"></td>
		                    <td>
		                      
		                    </td>
		                  </tr>
		                  
		                  <tr>
		                    <td align="right" width="10%"><h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlNetworkType" value="#{semmir007Bean.policySP.networkType}">
		                				<f:selectItems value="#{semmir007Bean.networkTypeList}"/>
		                			</h:selectOneMenu>
		                    </td>
		                    <td align="right" width="10%"><h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="transferType" value="#{semmir007Bean.policySP.tfType}">
			                		<f:selectItems value="#{semmir007Bean.transferTypeList}"/>
			                  </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText id="lblPolicyType" value="#{jspMsg['label.policyType']}" styleClass="ms7"/></td>
		                    <td>
		                     	<h:selectOneMenu id="ddlPolicy" value="#{semmir007Bean.policySP.ptType}">
		                				<f:selectItems value="#{semmir007Bean.policyTypeList}"/>
		                		</h:selectOneMenu>	
							</td>
							<td align="right">
								<h:outputText id="lblDraftID" value="#{jspMsg['label.draftID']}" styleClass="ms7"/>
							</td>
							<td>
								<h:inputText id="txtDraftID" value="#{semmir007Bean.policySP.draftNo}" disabled="false"/>
								<rich:spacer width="5"/> 	
								<a4j:commandButton id="btnSearchDraft" value="#{jspMsg['btn.searchDraft']}" styleClass="rich-button"
								oncomplete="#{rich:component('popupSearchDraft')}.show(); return false"  
            					action="#{navAction.navi}" reRender="oppContent" >	
	            			    	<a4j:actionparam name="navModule" value="ir" />
	            					<a4j:actionparam name="navProgram" value="SEMMIR007-1" />	
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIRPopup" />
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="pageFrom" value="SEMMIR007-1" />
	            			    </a4j:commandButton>	
							</td>			
							
		                  </tr>
		                  <tr>
		                 	 <td align="right">		                            	  
		                		<h:outputText id="lblDraftStatus" value="#{jspMsg['label.draftStatus']}" styleClass="ms7"/>  
		                    </td>		                    
		                    <td>
		                    	<h:selectOneMenu id="ddldraftStatus" value="#{semmir007Bean.policySP.draftStatus}">
		                				<f:selectItems value="#{semmir007Bean.draftStatusList}"/>
		                		</h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:inputText id="txtContractNo" value="#{semmir007Bean.policySP.contractNo}" />  
							</td>
							<td align="right">
		                    	<h:outputText id="lblLocationCode" value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>        	  
		                	</td>
		                    <td colspan="2">
								<h:inputText id="txtLocationCode" value="#{semmir007Bean.policySP.locationCode}"/>								
		                   </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText id="lblLocationId" value="#{jspMsg['label.locationId']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:inputText id="txtLocationID" value="#{semmir007Bean.policySP.locationId}"/>  
							</td>
							<td align="right">
		                    	<h:outputText id="lblLocationName" value="#{jspMsg['label.locationName']}" styleClass="ms7"/>        	  
		                	</td>
		                    <td colspan="2">
								<h:inputText id="txtLocationName" value="#{semmir007Bean.policySP.locationName}" />								
		                   </td>
		                  </tr>
		                  <tr>
		                    <td align="right"></td>
		                    <td colspan="3">
		                    	<h:selectOneRadio id="rbtCondition" value="#{semmir007Bean.policySP.deductType}" layout="lineDirection" styleClass="ms7" rendered="true">
                    					<f:selectItem  itemValue="M" itemLabel="#{jspMsg['label.deductTypeM']}"/>
                    					<f:selectItem itemValue="L" itemLabel="#{jspMsg['label.deductTypeL']}"/>
                    					<f:selectItem itemValue="A" itemLabel="#{jspMsg['label.deductTypeAll']}"/>
                    				</h:selectOneRadio>			                    		
		                    </td>
		                    
		                       
		                	  
		                	  
		                   
		                  </tr>
		                  <tr>		                    
		                   <td></td>
		                   <td colspan="2">
		                 			<h:selectBooleanCheckbox id="chkInsuredUpdateFlag" value="#{semmir007Bean.policySP.insuredFlgBoolean}" >
		                 				<a4j:support event="onclick" reRender="txtWithMonth" action="#{semmir007Action.disableTxtBox}" />
									</h:selectBooleanCheckbox>
									<h:outputText id="lblInsuredFlg" value="#{jspMsg['label.insuredFlg']}" styleClass="ms7" />
									<rich:spacer width="5"/>
									<h:inputText id="txtWithMonth" value="#{semmir007Bean.policySP.insuredAmt}"
									disabled="#{semmir007Bean.insuredFlg}"
									onkeypress="return numberformat.keyPressDecimalCustomize(3, this, event);" 
									onblur="return numberformat.moneyFormat(this);"
									onfocus="return numberformat.setCursorPosToEnd(this);"
									maxlength="6"
									size="3"
									>
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="3" maxFractionDigits="2" />
									</h:inputText>
									<rich:spacer width="5"/>
									<h:outputText value="%" styleClass="ms7" />
		                   </td> 
		                  </tr>
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="panelError,frmError,panSearchCriteria,panSearchResult,btnSave,btnRemove" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR007-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="panelError,frmError,panSearchCriteria,panSearchResult">
				            		<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR007-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			<a4j:form id="frmResult"><!--
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormBottom}"/>
				</div>
	            	
				--><table width="96%">
					<tr>
						<td width="10%">
			            	<a4j:commandButton id="btnSave" value="#{jspMsg['btn.saveGenList']}" styleClass="rich-button" 
			            	oncomplete="#{rich:component('mdpConfirmSaveDialog')}.show(); return false" 
			            	action="#{navAction.navi}" reRender="frmConfirmSaveDialog,mdpConfirmSaveDialog" disabled="#{semmir007Bean.disBtnSave}">
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR007-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
								<a4j:actionparam name="methodWithNavi" value="doSave" />
			            	</a4j:commandButton><rich:spacer width="10"/>
			            	
			            	<a4j:commandButton id="btnRemove" value="#{jspMsg['btn.removeList']}" styleClass="rich-button" 
			            	oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
			            	action="#{navAction.navi}" reRender="frmConfirmDelDialog,mdpConfirmDelDialog" disabled="#{semmir007Bean.disBtnRemove}">	
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR007-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
								<a4j:actionparam name="methodWithNavi" value="initDelete" />
			            	</a4j:commandButton>
		            	</td>		         
		            	<td width="86%" align="right">
			            	<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.addNew']}" styleClass="rich-button" 
			            	oncomplete="#{rich:component('popupfrmAddDraft')}.show(); return false" 
			            	action="#{navAction.navi}" reRender="popupfrmAddDraft" >	
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR007-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR007" />
								<a4j:actionparam name="methodWithNavi" value="initPopupAdd" />
			            	</a4j:commandButton>
		            	</td>
	            	</tr>
	            </table>
            
				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult"  styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1780"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir007Bean.msgDataNotFound}" rendered="#{semmir007Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="policyValueSP" value="#{semmir007Bean.policySPList}" reRender="dstPolicy" 
							rows="#{semmir007Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column id="policyCheck">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmir007Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmir007Action.selectAllRow}" reRender="frmResult,btnSave,btnRemove"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="policyHeadeCheck" value="#{policyValueSP.checkBox}" >
									<a4j:support event="onclick" action="#{semmir007Action.onRenderExportButton}" reRender="btnSave,btnRemove">
											<a4j:actionparam name="rowId" value="#{policyValueSP.dataObj.rowId}" />
										</a4j:support>
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.draftID']}" styleClass="contentform" style= " width : 60px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.draftNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style= " width : 60px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.networkTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>    
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style= " width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{policyValueSP.dataObj.company}" styleClass="contentform"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}" styleClass="contentform" style= " width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.tfTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyType']}" styleClass="contentform" style= " width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.ptTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style= " width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationcode']}" styleClass="contentform" style= " width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationName']}" styleClass="contentform" style= " width : 150px" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{policyValueSP.dataObj.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationStatus']}" styleClass="contentform" style= " width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.locationStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.status']}" styleClass="contentform" style= " width : 70px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.draftStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>			
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.insuredAmtOld']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.insuredAmtOld}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.insuredAmt']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.insuredAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffInsuredAmt']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.insuredAmtDiff}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>			
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.deductible']}" styleClass="contentform" style= " width : 90px" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.deductAmt}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.premiumAmtOld']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.premiumAmtOld}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.premiumAmt']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.premiumAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform" style= " width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.policyNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style= " width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.expDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style= " width : 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{policyValueSP.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style= " width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.updateDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir007Bean.policySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmir007Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmir007Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/ir/semmir007-AddNew.jsp" />
<jsp:include page="../../pages/ir/semmir007-popup.jsp" />


<rich:modalPanel id="mdpConfirmSaveDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmSaveDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
						<h:outputText value="#{semmir007Bean.msCount}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button"  immediate="true" reRender="panelError,frmError,panSearchResult,mdpConfirmSaveDialog" action="#{semmir007Action.saveGenList}" >						
							<a4j:actionparam name="btnAction" value="A" />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
						<h:outputText value="#{semmir007Bean.msCount}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" reRender="panelError,frmError,panSearchResult,mdpConfirmDelDialog" action="#{semmir007Action.saveGenList}" >						
							<a4j:actionparam name="btnAction" value="D" />
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