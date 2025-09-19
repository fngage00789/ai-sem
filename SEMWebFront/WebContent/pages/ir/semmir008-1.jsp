<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir008" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir008Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchIR008">
				<h:panelGrid width="96%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
		                  <tr>
		                  	<td align="right" width="20%" >
		                  		
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlCompanyIR008" value="#{semmir008Bean.policySP.company}">
			                		<f:selectItems value="#{semmir008Bean.companyList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right"></td>
		                    <td>
		                      
		                    </td>
		                  </tr>
		                  
		                  <tr>
		                    <td align="right" width="10%"><h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlNetworkType" value="#{semmir008Bean.policySP.networkType}">
		                				<f:selectItems value="#{semmir008Bean.networkTypeList}"/>
		                			</h:selectOneMenu>
		                    </td>
		                    <td align="right" width="10%"><h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="transferType" value="#{semmir008Bean.policySP.tfType}">
			                		<f:selectItems value="#{semmir008Bean.transferTypeList}"/>
			                  </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" valign="top"><h:outputText id="lblPolicyType" value="#{jspMsg['label.policyType']}" styleClass="ms7"/></td>
		                    <td>
		                     	<h:selectOneMenu id="ddlPolicy" value="#{semmir008Bean.policySP.ptType}">
		                				<f:selectItems value="#{semmir008Bean.policyTypeList}"/>
		                		</h:selectOneMenu>	
							</td>
							<td align="right">
								<h:outputText id="lblDraftID" value="#{jspMsg['label.draftID']}" styleClass="ms7"/>
							</td>
							<td>
								<h:inputText id="txtDraftID" value="#{semmir008Bean.policySP.draftNo}"/>
								<rich:spacer width="5"/> 	
								<a4j:commandButton id="btnSearchDraft" value="#{jspMsg['btn.searchDraft']}" styleClass="rich-button"
								oncomplete="#{rich:component('popupSearchDraft')}.show(); return false"  
            					action="#{navAction.navi}" reRender="oppContent" >	
	            			    	<a4j:actionparam name="navModule" value="ir" />
	            					<a4j:actionparam name="navProgram" value="SEMMIR008-1" />	
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIRPopup" />
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="pageFrom" value="SEMMIR008-1" />
	            			    </a4j:commandButton>	
							</td>			
							
		                  </tr>
		                  <tr>
		                 	 <td align="right">		                            	  
		                		<h:outputText id="lblDraftStatus" value="#{jspMsg['label.draftStatus']}" styleClass="ms7"/>  
		                    </td>		                    
		                    <td>
		                    	<h:selectOneMenu id="ddldraftStatus" value="#{semmir008Bean.policySP.draftStatus}">
		                				<f:selectItems value="#{semmir008Bean.draftStatusList}"/>
		                		</h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                    	<h:outputText id="lblPolicy" value="#{jspMsg['label.policy']}" styleClass="ms7"/> 		                    	
		                    </td>
		                    <td>
		                    	<h:inputText id="txtPolicy" value="#{semmir008Bean.policySP.policyNo}" />
		                    </td>
		                  </tr>		                  
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmSearchIR008" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="panelError,frmError,panSearchCriteria,panSearchResult">
				            		<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			<a4j:form id="frmResult">
            
				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult" styleClass="sem_autoScrollbar" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1260"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir008Bean.msgDataNotFound}" rendered="#{semmir008Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="policyValueSP" value="#{semmir008Bean.policySPList}" reRender="dstPolicy" 
							rows="#{semmir008Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.draftID']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkEdit" value="#{policyValueSP.dataObj.draftNo}" action="#{navAction.navi}" reRender="oppContent"> 
											<a4j:actionparam name="navModule" value="ir" />
											<a4j:actionparam name="navProgram" value="SEMMIR008-2" />
											<a4j:actionparam name="moduleWithNavi" value="ir" />
											<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
											<a4j:actionparam name="methodWithNavi" value="initPlocyInfo" />
											<a4j:actionparam name="draftNo" value="#{policyValueSP.dataObj.draftNo}" />
										</a4j:commandLink>
									</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style = "width :70px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.networkTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>    
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{policyValueSP.dataObj.company}" styleClass="contentform"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.tfTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyType']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.ptTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalLocation']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.totalLocation}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.insuredAmt']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.insuredAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.deductible']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.deductAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.premiumAmt']}" styleClass="contentform"  style = "width : 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.premiumAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>			
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.status']}" styleClass="contentform" style=" width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.draftStatusDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.policyNo}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.updateDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir008Bean.policySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmir008Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmir008Bean.scrollerPage}" 
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
<jsp:include page="../../pages/ir/semmir007-popup.jsp" />
