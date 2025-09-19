<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<jsp:include page="../../pages/popup/multiZone-popup.jsp" />

<f:loadBundle basename="resources.insurance.semmir009" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir009Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchIR009" ajaxSubmit="true">
				<h:panelGrid width="96%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
		                  <tr>
		                  	<td align="right" width="20%" >
		                  		<h:graphicImage value="images/icon_required.gif"/>
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlCompanyIR009" value="#{semmir009Bean.policySP.company}">
			                		<f:selectItems value="#{semmir009Bean.companyList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right" width="20%"><h:outputText id="lblDocType" value="#{jspMsg['label.docType']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                     	<h:selectOneMenu id="ddlDocType" value="#{semmir009Bean.policySP.docType}">
		                				<f:selectItems value="#{semmir009Bean.docTypeList}"/>
		                		</h:selectOneMenu>	
							</td>
		                      
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/></td>
		                    <td>
		                      <h:selectOneMenu id="ddlNetworkType" value="#{semmir009Bean.policySP.networkType}">
			                		<f:selectItems value="#{semmir009Bean.networkTypeList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lbltfType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/></td>
		                    <td>
		                      <h:selectOneMenu id="ddltfType" value="#{semmir009Bean.policySP.tfType}">
			                		<f:selectItems value="#{semmir009Bean.transferTypeList}"/>
			                </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblPolicyType" value="#{jspMsg['label.policyType']}" styleClass="ms7"/></td>
		                    <td>
		                      <h:selectOneMenu id="ddlPolicyType" value="#{semmir009Bean.policySP.ptType}">
			                		<f:selectItems value="#{semmir009Bean.policyTypeList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblPolicyID" value="#{jspMsg['label.policyID']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtPolicyID" value="#{semmir009Bean.policySP.policyId}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblEffectiveDt" value="#{jspMsg['label.effectiveDt']}" styleClass="ms7"/></td>
		                    <td>
			                  	<rich:calendar id="cldEffectiveFromDt" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir009Bean.policySP.effFromDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.effFromDt']}"
								disabled="false">
								</rich:calendar>
								<rich:spacer width="10" />
								<rich:calendar id="cldEffectiveToDt" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir009Bean.policySP.effToDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.effToDt']}"
								disabled="false">
								</rich:calendar>
							</td>
							<td align="right">
		                		<h:outputText id="lblExpireDt" value="#{jspMsg['label.expireDt']}" styleClass="ms7"/></td>
		                    <td>
			                  	<rich:calendar id="cldExpireFromDt" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir009Bean.policySP.expFromDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.expFromDt']}"
								disabled="false">
								</rich:calendar>
								<rich:spacer width="10" />
								<rich:calendar id="cldExpireToDt" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir009Bean.policySP.expToDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.expToDt']}"
								disabled="false">
								</rich:calendar>
							</td>
		                  </tr>
		                  <tr style="vertical-align:text-top;">
										<td align="right">										
						               		<h:outputText id="lblRegion" value="#{jspMsg['label.region']}" styleClass="ms7"/>
						             	</td>
						             	<td align="left">										
						               		<h:inputText id="txtRegion" value="#{popupMultiZoneBean.region}"/>
						             	</td>
										<td align="right">										
						               		<h:outputText id="lblZone" value="#{jspMsg['label.zone']}" styleClass="ms7"/>
						             	</td>
										<td align="left" colspan="3" >
											<rich:spacer width="7px"></rich:spacer>			
											<h:panelGrid id="criMultiZone" 
														 columns="2" columnClasses="ms7" >
												<a4j:region>
												<h:selectManyListbox id="criPolicyZone" 
																	 size="#{popupMultiZoneBean.delListSize/7}" styleClass="ms7"
																	 value="#{popupMultiZoneBean.delList}" onchange="renderZone();">
																	 
									        		<f:selectItems value="#{popupMultiZoneBean.selectedList}"/>
									        		<a4j:jsFunction name="renderZone" reRender="criPolicyZone"/>
									    		</h:selectManyListbox>
									    		</a4j:region>
												<h:panelGroup >
													<a4j:commandButton id="btnAddPolicyMultiZone" styleClass="rich-button"
																	   value="..." action="#{navAction.navi}"
																	   reRender="popupMultiZone,popupMultiZoneFrmSearch" 
																	   oncomplete="#{rich:component('popupMultiZone')}.show(); return false" >
									            		
									            		<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="multiZone-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
												    </a4j:commandButton>&nbsp;
													<a4j:commandButton id="btnDelPolicyMultiZone" styleClass="rich-button"
																	   value=" - " action="#{navAction.navi}"
																	   reRender="criMultiZone, btnDelPolicyMultiZone" 
																	   disabled="#{popupMultiZoneBean.disabledDeleteZoneMulti}" >
													  	
													  	<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="multiZone-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
														<a4j:actionparam name="methodWithNavi" value="doUpdateList" />
													</a4j:commandButton>
												</h:panelGroup>
											</h:panelGrid>
										</td>
										<td/>
										<td/>
										<td/>
									</tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtContract" value="#{semmir009Bean.policySP.contractNo}"/>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblLocationCode" value="#{jspMsg['label.locationCode']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtLocationCode" value="#{semmir009Bean.policySP.locationCode}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblLocationID" value="#{jspMsg['label.locationID']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtLocationID" value="#{semmir009Bean.policySP.locationId}"/>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblLocationName" value="#{jspMsg['label.locationName']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtLocationName" value="#{semmir009Bean.policySP.locationName}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  <td></td>
		                  <td colspan="2" align="right">
                   				<h:selectOneRadio id="rbtMode" value="#{semmir009Bean.policySP.viewType}" layout="lineDirection" styleClass="ms7" rendered="true" >
                   					<f:selectItem itemValue="P" itemLabel="#{jspMsg['label.viewTypeP']}"/><rich:spacer width="50"/>
                   					<f:selectItem itemValue="L" itemLabel="#{jspMsg['label.viewTypeL']}"/><rich:spacer width="50"/>
                   					<f:selectItem itemValue="D" itemLabel="#{jspMsg['label.viewTypeD']}"/>
                   					<a4j:support event="onclick" action="#{semmir009Action.setViewType}" reRender="txtdiffAmt"/>
                   				</h:selectOneRadio>
		                    </td> 
		                    <td>
		                    	<h:inputText id="txtdiffAmt" value="#{semmir009Bean.policySP.diffAmt}" size="5"
		                    	onkeypress="return numberformat.keyPressDecimalCustomize(3, this, event);" 
								onblur="return numberformat.moneyFormat(this);"
								onfocus="return numberformat.setCursorPosToEnd(this);"
								maxlength="6"
								>
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="3" maxFractionDigits="2" />
								</h:inputText>
								<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
		                    </td>
		                  </tr>
		                                   
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmSearchIR009" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR009-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR009" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="panelError,frmError,panSearchCriteria,frmResult">
				            		<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR009-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR009" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			<a4j:form id="frmResult">
				<h:panelGrid id="grdActionCommand" width="96%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td colspan="1" align="right">
									<h:commandButton id ="btnExport" action="#{semmir009Action.doExportExcelSch}" value="#{jspMsg['btn.export']}"
									styleClass="rich-button"  >
									</h:commandButton>
								</td>
							</tr>
						</table>	
					</h:panelGroup>
				</h:panelGrid>	
				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult"  styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir009Bean.msgDataNotFound}" rendered="#{semmir009Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="policyValueSP" value="#{semmir009Bean.policySPList}" reRender="dstPolicy" 
							rows="#{semmir009Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column id="policyCheck">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" />
								</f:facet>
								<div align="center">
								<h:selectBooleanCheckbox id="policyHeadeCheck" value="#{policyValueSP.checkBox}" onclick="PolicyHeaderCheckJS();">
									<a4j:jsFunction name="PolicyHeaderCheckJS" reRender="policyCheck"></a4j:jsFunction>
								</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policy']}" styleClass="contentform" style= " width : 70px"/>
								</f:facet>
									<div align="center">
										<h:outputText value="#{policyValueSP.dataObj.docTypeDesc}" styleClass="contentform"  />
									</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style= " width : 60px"/>
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
									<h:outputText value="#{jspMsg['column.transferType']}" styleClass="contentform" style= " width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.tfTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="contentform" style= " width : 70px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.docTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalLocation']}" styleClass="contentform" style= " width : 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.totalLocation}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationID']}" styleClass="contentform" style= " width : 60px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.locationId}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyID']}" styleClass="contentform" style= " width : 100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkEdit" value="#{policyValueSP.dataObj.policyNo}" action="#{navAction.navi}" reRender="oppContent"> 
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR009-2" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR009" />
										<a4j:actionparam name="methodWithNavi" value="initPlocyInfo" />
										<a4j:actionparam name="policyNo" value="#{policyValueSP.dataObj.policyNo}" />
										<a4j:actionparam name="navModuleFrom" value="ir" />
										<a4j:actionparam name="navProgramFrom" value="SEMMIR009-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR009" />	
										<a4j:actionparam name="isPageFrom" value="true" />
									</a4j:commandLink>
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
									<h:outputText value="#{jspMsg['column.deductible']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.deductAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.premiumAmtEst']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.premiumAmtEst}" styleClass="contentform"  >
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
									<h:outputText value="#{jspMsg['column.premiumAmtDiff']}" styleClass="contentform" style= " width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{policyValueSP.dataObj.premiumAmtDiff}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effectiveDt']}" styleClass="contentform" style= " width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.effDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style= " width : 80px" />
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
								<div align="center">
									<h:outputText value="#{policyValueSP.dataObj.updateBy}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style= " width : 80px"/>
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
											<f:param value="#{fn:length(semmir009Bean.policySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="14">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmir009Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmir009Bean.scrollerPage}" 
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
