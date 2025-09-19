<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../../pages/popup/sitelocationForIR-popup.jsp" />
<jsp:include page="../../pages/popup/uploadpic-popup.jsp"/>

<f:loadBundle basename="resources.insurance.semmir012" var="jspMsg"/>

<h:panelGrid width="100%" >
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<a4j:form id="frmError">
			<h:panelGrid id="pnlError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir012Bean.renderedMsgFormSearch}">
			 		<f:facet name="header">
	                      	<h:outputText value="Entered Data Status:"></h:outputText>
	                  	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
	                   </f:facet>
	            </rich:messages>
			</h:panelGrid>
			<table width="96%">
					<tr>
						<td width="10%" align="right">
							<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmSave,frmError" style="width:72">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
								<a4j:actionparam name="methodWithNavi" value="doNew" />
							</a4j:commandButton>
						</td>
					</tr>
			</table>
		</a4j:form>
			
		
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSave">
				<h:panelGrid width="96%">
					<rich:panel id="pnlSave">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['title.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
		                	<h:panelGroup>
				                <table width="100%">
				                	<tr>
					                  	<td align="right">
					                		<h:outputText id="lblIrClaimNo" value="#{jspMsg['label.irClaimNo']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="2">
					                    	<h:inputText id="txtIrClaimNo" value="#{semmir012Bean.irClaim.claimNo}" styleClass="ms7"
					                    				 size="35" disabled="true"/>
					                    	<rich:spacer width="5"></rich:spacer>
					                    	<a4j:commandButton id="btnSearchClaim" value="#{jspMsg['btn.searchClaim']}"
					                    					   styleClass="rich-button"
					                    					   oncomplete="#{rich:component('mdpSrchIrClaims')}.show(); return false"
					                						   action="#{navAction.navi}"
															   reRender="frmError, mdpSrchIrClaims,hlkUpload" >
												<a4j:actionparam name="navModule" value="ir" />
												<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
												<a4j:actionparam name="moduleWithNavi" value="ir" />
												<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
												<a4j:actionparam name="methodWithNavi" value="doSearchIrClaimList" />
											</a4j:commandButton>
					                    </td>
					                    <td colspan="2">
					                    	<table width="100%">
					                    		<tr>
					                    			<td align="right" width="30%">
								                    	<h:panelGroup>
															<h:outputText value="#{jspMsg['label.claimDt']} :" styleClass="ms7"/>
															<rich:spacer width="5"></rich:spacer>
								                    		<h:outputText id="lblClaimDt" value="#{semmir012Bean.irClaim.claimDt}" styleClass="ms7">
								                    			<f:convertDateTime pattern="dd/MM/yyyy" locale="th" type="date"/>
								                    		</h:outputText>
								                    	</h:panelGroup>
					                    			</td>
					                    		</tr>
					                    	</table>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblReqBy" value="#{jspMsg['label.reqBy']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtReqBy" value="#{semmir012Bean.irClaim.reqBy}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblReqDepBy" value="#{jspMsg['label.reqDepBy']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtReqDepBy" value="#{semmir012Bean.irClaim.reqDepBy}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblReqTel" value="#{jspMsg['label.reqTel']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtReqTel" value="#{semmir012Bean.irClaim.reqTel}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblReqEmail" value="#{jspMsg['label.reqEmail']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtReqEmail" value="#{semmir012Bean.irClaim.reqEmail}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" width="20%">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLocationId" value="#{jspMsg['label.locationId']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td width="30%">
					                    	<h:inputText id="txtLocationId" value="#{semmir012Bean.irClaim.locationId}" styleClass="ms7"
					                    				 disabled="true" size="30"/>
					                    </td>
					                    <td align="right" align="right" width="20%">
						                	<h:outputText id="lblLocationName" value="#{jspMsg['label.locationName']} :" styleClass="ms7"/>
					                	</td>
					                    <td width="30%">
					                    	<h:panelGroup>
					                    		<h:inputText id="txtLocationName" value="#{semmir012Bean.irClaim.locationName}" styleClass="ms7"
					                    				 	 disabled="true" size="30"/>
						                    	<rich:spacer width="5"></rich:spacer>	 
						                    	<a4j:commandButton id="btnSrchLocation" value="#{jspMsg['btn.searchLocation']}"
						                    					   styleClass="rich-button"
						                    					   action="#{navAction.navi}"
						                    					   oncomplete="#{rich:component('popupSearchSiteLocation')}.show(); return false"
						                    					   reRender="popupSearchSiteLocation,pnlSave" 
																   disabled="#{semmir012Bean.viewMode}">
													<a4j:actionparam name="navModule" value="ir" />
													<a4j:actionparam name="navProgram" value="SEMMIR012-2" />
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
													<a4j:actionparam name="methodWithNavi" value="initPopupSiteLocation" />
													
													<a4j:actionparam name="toModule" value="ir" />
													<a4j:actionparam name="toAction" value="SEMMIR012" />
													<a4j:actionparam name="toMethod" value="doRenderSelLocation" />
			            						</a4j:commandButton>
					                    	</h:panelGroup>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblLocationCode" value="#{jspMsg['label.locationCode']} :" styleClass="ms7"/>
					                	</td>
					                    <td>
					                    	<h:inputText id="txtLocationCode" value="#{semmir012Bean.irClaim.locationCode}" styleClass="ms7"
					                    				 disabled="true"
					                    				 size="30"/>
					                    </td>
					                    <td align="right">
						                	<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtContractNo" value="#{semmir012Bean.irClaim.contractNo}" styleClass="ms7"
					                    				 size="30" disabled="true"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
						                	<h:outputText id="lblLossPlaceName" value="#{jspMsg['label.lossPlaceName']} :" styleClass="ms7"/>
					                	</td>
					                    <td>
					                    	<h:inputText id="txtLossPlaceName" value="#{semmir012Bean.irClaim.lossPlaceName}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30"/>
					                    </td>
					                    <td colspan="2" >
						                    <a4j:region>
						                    	<rich:spacer width="80" />
							                	<h:selectBooleanCheckbox id="chkSameLocationFlg"
							                							 value="#{semmir012Bean.irClaim.locationFlg}" 
							                							 disabled="#{semmir012Bean.viewMode}"
							                							 styleClass="ms7">
							                		<a4j:support event="onclick" action="#{semmir012Action.onRenderSameLoation}" 
							                					 reRender="ddlLossRegion,ddlLossProvinceId,txaLossAddress,txtLossPlaceName"></a4j:support>
							                	</h:selectBooleanCheckbox>
							                	<rich:spacer width="5"></rich:spacer>
							                	<h:outputText value="#{jspMsg['label.sameLocationFlg']}" styleClass="ms7"></h:outputText>
						                	</a4j:region>
					                	</td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossRegion" value="#{jspMsg['label.lossRegion']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td>
						                    <a4j:region>
							                    <a4j:outputPanel id="ddlLossRegion">
							                    	<h:selectOneMenu value="#{semmir012Bean.irClaim.lossRegion}" styleClass="ms7"
							                    					 disabled="#{semmir012Bean.viewMode}">
							                    		<f:selectItems value="#{semmir012Bean.regionSelList}"/>
							                    		<a4j:support event="onchange" action="#{semmir012Action.onRenderSelProvince}" 
							                    					 reRender="ddlLossProvinceId"></a4j:support>
							                    	</h:selectOneMenu>
							                    </a4j:outputPanel>
						                    </a4j:region>
					                    </td>
					                    <td align="right">
					                    	<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossProvinceId" value="#{jspMsg['label.lossProvinceId']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td>
					                   		<a4j:outputPanel id="ddlLossProvinceId">
					                   			<h:selectOneMenu value="#{semmir012Bean.irClaim.lossProvinceId}" styleClass="ms7"
					                   							 disabled="#{semmir012Bean.viewMode}">
					                    			<f:selectItems value="#{semmir012Bean.provinceSelList}"/>
					                    		</h:selectOneMenu>
						                    </a4j:outputPanel>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:selectOneMenu id="ddlTransferType" value="#{semmir012Bean.irClaim.transferType}" styleClass="ms7"
					                    					 disabled="#{semmir012Bean.viewMode}">
					                    		<f:selectItems value="#{semmir012Bean.transferSelList}"/>
					                    	</h:selectOneMenu>
					                    </td>
				                	</tr>
				                	
				                	<tr>
				                		<td colspan="4">&nbsp;</td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" valign="top">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossAddress" value="#{jspMsg['label.lossAddress']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<a4j:outputPanel id="txaLossAddress">
						                    	<h:inputTextarea value="#{semmir012Bean.irClaim.lossAddress}"
						                    					 disabled="#{semmir012Bean.viewMode}" styleClass="ms7"
						                    					 rows="4" cols="100"/>
					                    	 </a4j:outputPanel>				 
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossDt" value="#{jspMsg['label.lossDt']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td>
					                    	<rich:calendar id="cldLossDt" value="#{semmir012Bean.irClaim.lossDt}"
					                    				   datePattern="dd/MM/yyyy" locale="th" enableManualInput="true"
					                    				   disabled="#{semmir012Bean.viewMode}"
					                    				   showWeeksBar="false"
					                    				   inputSize="13"
					                    				   cellWidth="20px" cellHeight="20px"
					                    				   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                    				   >
											</rich:calendar>
					                    </td>
					                    <td align="right">
						                	<h:outputText id="lblLossTime" value="#{jspMsg['label.lossTime']} :" styleClass="ms7"/>
					                	</td>
					                    <td>
					                    	<h:inputText id="txtLossTime" value="#{semmir012Bean.irClaim.lossTime}" 
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 styleClass="ms7"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossType" value="#{jspMsg['label.lossType']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td>
					                    	<a4j:region>
					                    		<h:selectOneMenu id="ddlLossType" value="#{semmir012Bean.irClaim.lossType}" styleClass="ms7"
					                    						 disabled="#{semmir012Bean.viewMode}">
					                    			<f:selectItems value="#{semmir012Bean.lossTypeSelList}"/>
					                    			<a4j:support event="onchange" action="#{semmir012Action.onRenderSelLossSubType}" reRender="ddlLossSubType"></a4j:support>
					                    		</h:selectOneMenu>
					                    	</a4j:region>
					                    	<rich:spacer width="5"></rich:spacer>
					                    	<a4j:outputPanel id="ddlLossSubType">
					                    		<h:selectOneMenu  value="#{semmir012Bean.irClaim.lossSubType}" styleClass="ms7"
					                    						  disabled="#{semmir012Bean.viewMode}">
					                    			<f:selectItems value="#{semmir012Bean.lossSubTypeSelList}"/>
					                    		</h:selectOneMenu>
					                    	</a4j:outputPanel>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" valign="top">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblLossDesc" value="#{jspMsg['label.lossDesc']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputTextarea id="txaLossDesc" value="#{semmir012Bean.irClaim.lossDesc}"
					                    					 disabled="#{semmir012Bean.viewMode}" styleClass="ms7"
					                    					 rows="4" cols="100"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
				                		<td colspan="4">&nbsp;</td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblLossDetail" value="#{jspMsg['label.lossDetail']} :" styleClass="ms7"/>
					                	</td>
					                	<td colspan="3"></td>
					                </tr>
					                
					                <tr>
					                  	<td colspan="4">
						                	<h:panelGroup id="pnlIrClaimDetail">
						                		<table width="95%" align="center">
						                			<tr valign="top">
						                				<td width="90%">
						                					<rich:dataTable width="100%" id="dtbIrClaimDetail" cellpadding="1" cellspacing="0" border="0"
																			var="key" value="#{semmir012Bean.irClaimDetailKeySet}" 
																			rows="#{semmir012Bean.rowPerPage}"
																			onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
																			onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
																			rowClasses="cur" styleClass="dataTable">
													
																<rich:column width="5%">
																	<div align="center">
										            					<a4j:commandButton id="btnEdit"
										            									 image="images/view.png" 
						            													 style="height: 15; width: 15"
										            									 action="#{navAction.navi}"
										            									 disabled="#{semmir012Bean.viewMode}"
										            									 oncomplete="#{rich:component('mdpAddIrClaimDetail')}.show(); return false"
										            									 reRender="pnlIrClaimDetail,mdpAddIrClaimDetail">
														            		<a4j:actionparam name="navModule" value="ir" />
																			<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
																			<a4j:actionparam name="moduleWithNavi" value="ir" />
																			<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
																			<a4j:actionparam name="methodWithNavi" value="doEditIrClaimDetail" />
																			<a4j:actionparam name="rowId" value="#{semmir012Bean.irClaimDetailList[key].mapRowId}"/>
										            					</a4j:commandButton>                    							
																	</div>
																</rich:column>
																
																<rich:column width="5%">
																	<div align="center">
										            					<a4j:commandButton id="btnDelete"
										            									 image="images/delete.png" 
						            													 style="height: 15; width: 15"
										            									 action="#{navAction.navi}"
										            									 disabled="#{semmir012Bean.viewMode}"
										            									 reRender="pnlIrClaimDetail">
														            		<a4j:actionparam name="navModule" value="ir" />
																			<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
																			<a4j:actionparam name="moduleWithNavi" value="ir" />
																			<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
																			<a4j:actionparam name="methodWithNavi" value="doDeleteIrClaimDetail" />
																			<a4j:actionparam name="rowId" value="#{semmir012Bean.irClaimDetailList[key].mapRowId}"/>
										            					</a4j:commandButton>
										            					
										            					
										            					              							
																	</div>
																</rich:column>
																
																<rich:column sortBy="#{semmir012Bean.irClaimDetailList[key].dataObj.claimAsset}">
																	<f:facet name="header">
																		<h:outputText value="#{jspMsg['column.claimAsset']}" styleClass="contentform" />
																	</f:facet>
																	<div align="left">
																		<h:outputText value="#{semmir012Bean.irClaimDetailList[key].dataObj.claimAsset}" styleClass="contentform">
																		</h:outputText>
																	</div>
																</rich:column>
																
																<rich:column sortBy="#{semmir012Bean.irClaimDetailList[key].dataObj.claimAmt}" width="15%">
																	<f:facet name="header">
																		<h:outputText value="#{jspMsg['column.claimAmt']}" styleClass="contentform" />
																	</f:facet>
																	<div align="right">
																		<h:outputText value="#{semmir012Bean.irClaimDetailList[key].dataObj.claimAmt}" styleClass="contentform">
																			<f:convertNumber pattern="#,##0.000;(#,##0.000)" maxFractionDigits="2"/>
																		</h:outputText>
																	</div>
																</rich:column>
																
																<rich:column sortBy="#{semmir012Bean.irClaimDetailList[key].dataObj.serialNo}" width="15%">
																	<f:facet name="header">
																		<h:outputText value="#{jspMsg['column.serialNo']}" styleClass="contentform" />
																	</f:facet>
																	<div align="center">
																		<h:outputText value="#{semmir012Bean.irClaimDetailList[key].dataObj.serialNo}" styleClass="contentform">
																		</h:outputText>
																	</div>
																</rich:column>
																
																<rich:column sortBy="#{semmir012Bean.irClaimDetailList[key].dataObj.articleNo}" width="15%">
																	<f:facet name="header">
																		<h:outputText value="#{jspMsg['column.articleNo']}" styleClass="contentform" />
																	</f:facet>
																	<div align="center">
																		<h:outputText value="#{semmir012Bean.irClaimDetailList[key].dataObj.articleNo}" styleClass="contentform">
																		</h:outputText>
																	</div>
																</rich:column>

																<f:facet name="footer">
																	<rich:columnGroup>
																		<rich:column colspan="3">
																				<h:outputFormat value="#{msg['message.totalRecords']}">
																					<f:param value="#{fn:length(semmir012Bean.irClaimDetailList)}"></f:param>
																				</h:outputFormat>
																		</rich:column>
																		<rich:column colspan="3">		
																				<rich:datascroller immediate="true" rendered="true" align="center" for="dtbIrClaimDetail"
																									   maxPages="#{semmir012Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																									   id="dstIrClaimDetail" 
																									   style="background-color: #cccccc;"
																									   page="#{semmir012Bean.scrollerPage}"/>						   
																		</rich:column>
																	</rich:columnGroup>					
																</f:facet>
															</rich:dataTable>
						                				</td>
						                				<td>
						                					<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.add']}"
			            													   styleClass="rich-button"
			            													   disabled="#{semmir012Bean.viewMode}"
			            													   oncomplete="#{rich:component('mdpAddIrClaimDetail')}.show(); return false"
			            													   reRender="pnlIrClaimDetail,mdpAddIrClaimDetail">
											            	
							            					</a4j:commandButton>
						                				</td>
						                			</tr>
						                		</table>
						                	</h:panelGroup>
					                	</td>
					                </tr>
					                
					                <tr>
				                		<td colspan="4">&nbsp;</td>
				                	</tr>
				                	
					                <tr>
					                  	<td align="right">
					                  		<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
						                		<h:outputText id="lblEstimateAmt" value="#{jspMsg['label.estimateAmt']} :" styleClass="ms7"/>
					                		</h:panelGroup>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtEstimateAmt" value="#{semmir012Bean.irClaim.estimateAmt}" styleClass="inputRight"
					                    				 disabled="#{semmir012Bean.viewMode}"
					                    				 size="30" maxlength="12">
					                    		<f:convertNumber pattern="#,##0.000;(#,##0.000)" maxFractionDigits="2"/>		 
					                    	</h:inputText>			 
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" valign="top">
						                	<h:outputText id="lblPreAct" value="#{jspMsg['label.preAct']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputTextarea id="txaPreAct" value="#{semmir012Bean.irClaim.preAct}"
					                    					 disabled="#{semmir012Bean.viewMode}" styleClass="ms7"
					                    					 rows="4" cols="100"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblLitigantFlg" value="#{jspMsg['label.litigantFlg']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="3">
						                    <a4j:region>
						                    	<h:panelGrid columns="3">
							                    	<h:panelGroup>
							                    		<h:selectOneRadio id="rdbLitigantFlg" value="#{semmir012Bean.irClaim.litigantFlg}"
							                    					  	  disabled="#{semmir012Bean.viewMode}" styleClass="ms7">
							                    		<f:selectItem itemLabel="#{jspMsg['label.notHaveLitigant']}" itemValue="N"/>
							                    		<f:selectItem itemLabel="#{jspMsg['label.haveLitigant']}" itemValue="Y"/>
							                    		<a4j:support event="onclick" action="#{semmir012Action.onRenderLitigantName}" 
							                    					 reRender="txtLitigantName"></a4j:support>
							                    		</h:selectOneRadio>
							                    	</h:panelGroup>
							                    	
							                    	<rich:spacer width="5"></rich:spacer>
							                    	<a4j:outputPanel id="txtLitigantName">
							                    		<h:inputText value="#{semmir012Bean.irClaim.litigantName}" styleClass="ms7"
							                    				 	 disabled="#{semmir012Bean.viewMode}" size="30"
							                    				 	 rendered="#{semmir012Bean.irClaim.litigantFlg eq 'Y'}"/>
						                    		</a4j:outputPanel>
					                    		</h:panelGrid>
						                    </a4j:region>				 
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" valign="top">
						                	<h:outputText id="lblLitigantAddress" value="#{jspMsg['label.litigantAddress']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputTextarea id="txaLitigantAddress" value="#{semmir012Bean.irClaim.litigantAddress}"
					                    					 disabled="#{semmir012Bean.viewMode}" styleClass="ms7"
					                    					 rows="4" cols="100"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblLitigantTel" value="#{jspMsg['label.litigantTel']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="3">
					                    	<h:inputText id="txtLitigantTel" value="#{semmir012Bean.irClaim.litigantTel}" styleClass="ms7"
					                    				 disabled="#{semmir012Bean.viewMode}" size="30"/>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblDocDetail" value="#{jspMsg['label.docDetail']} :" styleClass="ms7"/>
					                	</td>
					                	<td colspan="3"></td>
					                </tr>
					                
					                <tr>
					                	<td>&nbsp;</td>
					                    <td colspan="3">
					                    	<h:panelGroup>
					                    		<table width="100%">
					                    			<tr>
					                    				<td>
					                    					<h:selectBooleanCheckbox id="chkDoc01Flg"
						                							 value="#{semmir012Bean.irClaim.doc01Flg}" 
						                							 disabled="#{semmir012Bean.viewMode}"
						                							 styleClass="ms7"/>
						                					<rich:spacer width="5"></rich:spacer>
						                					<h:outputText value="#{jspMsg['label.doc01Flg']}" styleClass="ms7"/>		 
					                    				</td>
					                    			</tr>
					                    			<tr>	
					                    				<td>
					                    					<h:selectBooleanCheckbox id="chkDoc02Flg"
						                							 value="#{semmir012Bean.irClaim.doc02Flg}" 
						                							 disabled="#{semmir012Bean.viewMode}"
						                							 styleClass="ms7"/>
						                					<rich:spacer width="5"></rich:spacer>
						                					<h:outputText value="#{jspMsg['label.doc02Flg']}" styleClass="ms7"/>
					                    				</td>
					                    			</tr>
					                    			<tr>	
					                    				<td>
					                    					<h:selectBooleanCheckbox id="chkDoc03Flg"
						                							 value="#{semmir012Bean.irClaim.doc03Flg}" 
						                							 disabled="#{semmir012Bean.viewMode}"
						                							 styleClass="ms7"/>
						                					<rich:spacer width="5"></rich:spacer>
						                					<h:outputText value="#{jspMsg['label.doc03Flg']}" styleClass="ms7"/>
					                    				</td>
					                    			</tr>
					                    			<tr>
					                    				<td>
					                    					<h:selectBooleanCheckbox id="chkDoc04Flg" 
						                							 value="#{semmir012Bean.irClaim.doc04Flg}" 
						                							 disabled="#{semmir012Bean.viewMode}"
						                							 styleClass="ms7"/>
						                					<rich:spacer width="5"></rich:spacer>
						                					<h:outputText value="#{jspMsg['label.doc04Flg']}" styleClass="ms7"/>		 
					                    				</td>
					                    			</tr>
					                    			<tr>	
					                    				<td>
						                    				<a4j:region>
						                    					<h:selectBooleanCheckbox id="chkDoc05Flg"
							                							 value="#{semmir012Bean.irClaim.doc05Flg}" 
							                							 disabled="#{semmir012Bean.viewMode}"
							                							 styleClass="ms7">
							                						<a4j:support event="onclick" action="#{semmir012Action.onRenderDoc05Desc}" 
							                									 reRender="txtDoc05Desc"></a4j:support>
							                					</h:selectBooleanCheckbox>
							                					<rich:spacer width="5"></rich:spacer>
							                					<h:outputText value="#{jspMsg['label.doc05Flg']}" styleClass="ms7"/>
							                					
							                					<rich:spacer width="15"></rich:spacer>
							                					<a4j:outputPanel id="txtDoc05Desc">
								                					<h:inputText value="#{semmir012Bean.irClaim.doc05Desc}" styleClass="ms7"
							                    				 				 disabled="#{semmir012Bean.viewMode}" size="30"
							                    				 				 rendered="#{semmir012Bean.irClaim.doc05Flg eq 'true'}"/>
							                					</a4j:outputPanel>
						                    				</a4j:region> 				 
					                    				</td>
					                    			</tr>
					                    		</table>
					                    	</h:panelGroup>
					                	</td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right">
						                	<h:outputText id="lblClaimStatus" value="#{jspMsg['label.claimStatus']} :" styleClass="ms7"/>
					                	</td>
					                    <td colspan="2">
					                    	<h:selectOneMenu id="ddlClaimStatus" value="#{semmir012Bean.irClaim.claimStatus}" styleClass="ms7"
					                    					 disabled="true">
					                    		<f:selectItems value="#{semmir012Bean.claimStatusSelList}"/>
					                    	</h:selectOneMenu>
					                    </td>
					                    <td align="right">
					                    	<a4j:commandLink id="hlkUpload" value="#{jspMsg['hlk.upload']}"
					                						 action="#{navAction.navi}"
					                						 disabled="#{semmir012Bean.viewMode}"
															 reRender="frmError, frmSave,popupUploadPic" 
															 oncomplete="#{rich:component('popupUploadPic')}.show(); return false">
												<a4j:actionparam name="navModule" value="common" />
												<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
												<a4j:actionparam name="methodWithNavi" value="init" />
												<a4j:actionparam name="refId" value="#{semmir012Bean.irClaim.claimNo}" />
												<a4j:actionparam name="attachModule" value="IR_CLAIM"/>
											</a4j:commandLink>
					                    </td>
				                	</tr>
				                	
				                	<tr>
					                  	<td align="right" colspan="4">
						                	<h:outputText value="#{jspMsg['hint.footer']} : #{semmir012Bean.hintFooter}" styleClass="ms7"/>
					                	</td>
					                </tr>
				                </table>
			        		</h:panelGroup>
			        		
			        		<rich:spacer height="20"></rich:spacer>
			        		
			        		<h:panelGroup>
			        			<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}"
		                						   action="#{navAction.navi}"
		                						   styleClass="rich-button"
												   reRender="frmError, frmSave" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
									<a4j:actionparam name="methodWithNavi" value="doSave" />
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}"
		                						   action="#{navAction.navi}"
		                						   styleClass="rich-button"
												   reRender="frmError, frmSave" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnExport" value="#{jspMsg['btn.export']}"
		                						   action="#{navAction.navi}"
		                						   styleClass="rich-button"
												   reRender="frmError, frmSave" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
									<a4j:actionparam name="methodWithNavi" value="doExport" />
									
									<a4j:support event="oncomplete" reRender="frmError, frmSave, pnlShowReport" rendered="#{semmir012Bean.displayShowReport}"/>
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnSend" value="#{jspMsg['btn.send']}"
		                						   action="#{navAction.navi}"
		                						   disabled="#{semmir012Bean.viewMode}"
		                						   styleClass="rich-button"
												   reRender="frmError, frmSave" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
									<a4j:actionparam name="methodWithNavi" value="doSend" />
								</a4j:commandButton>
								<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
					            action="#{navAction.navi}" reRender="oppContent" rendered="#{semmir012Bean.renderBackBtn}">
				            		<a4j:actionparam name="navModule" value="#{semmir012Bean.navModuleFrom}" />
									<a4j:actionparam name="navProgram" value="#{semmir012Bean.navProgramFrom}" />
									<a4j:actionparam name="moduleWithNavi" value="#{semmir012Bean.navModuleFrom}" />
									<a4j:actionparam name="actionWithNavi" value="#{semmir012Bean.actionWithNaviFrom}" />
									<a4j:actionparam name="methodWithNavi" value="doBackPage" />
								</a4j:commandButton>
			        		</h:panelGroup>
			        	</h:panelGrid>
			        	
			        	<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semmir012Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmir012Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSave:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
						
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpAddIrClaimDetail" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['title.popup.name']}"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupMdpAddIrClaimDetail" style="cursor:pointer"/>
				<rich:componentControl for="mdpAddIrClaimDetail" attachTo="hidePopupMdpAddIrClaimDetail" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmMdpError">
		<h:panelGrid>
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green"/>
		</h:panelGrid>
	</a4j:form>
	
	<a4j:form id="frmAddIrClaimDetail">
		<h:panelGrid width="350">
			<rich:panel>
				<h:panelGroup>
					<table width="95%">
						<tr>
							<td align="right" width="25%">
								<h:outputText value="#{jspMsg['label.claimAsset']}" styleClass="ms7"></h:outputText>
							</td>
							
							<td>
								<h:inputText id="txtClaimAsset" value="#{semmir012Bean.irClaimDetail.claimAsset}" styleClass="ms7"/>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['label.claimAmt']}" styleClass="ms7"></h:outputText>
							</td>
							
							<td>
								<h:inputText id="txtClaimAmt" value="#{semmir012Bean.irClaimDetail.claimAmt}" styleClass="ms7"/>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['label.serialNo']}" styleClass="ms7"></h:outputText>
							</td>
							
							<td>
								<h:inputText id="txtSerialNo" value="#{semmir012Bean.irClaimDetail.serialNo}" styleClass="ms7"/>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['label.articleNo']}" styleClass="ms7"></h:outputText>
							</td>
							
							<td>
								<h:inputText id="txtArticleNo" value="#{semmir012Bean.irClaimDetail.articleNo}" styleClass="ms7"/>
							</td>
						</tr>
						
						<tr>
							<td></td>
						</tr>
						
						<tr>
							<td align="center" colspan="2">
								<h:panelGrid columns="2" styleClass="contentlabelform">
									<a4j:commandButton value="Save" 
													   styleClass="rich-button"
													   oncomplete="if(#{facesContext.maximumSeverity==null}) #{rich:component('mdpAddIrClaimDetail')}.hide(); return false"
													   action="#{navAction.navi}"
													   reRender="frmMdpError,pnlIrClaimDetail">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
										<a4j:actionparam name="methodWithNavi" value="doAddIrClaimDetail" />
										<a4j:actionparam name="rowId" value="#{semmir012Bean.tmpRowId}" />
										<a4j:actionparam name="modeCRUD" value="#{empty semmir012Bean.tmpRowId ? 'INSERT' : 'UPDATE'}" />
									</a4j:commandButton>											
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
									    <rich:componentControl for="mdpAddIrClaimDetail" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGrid>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpSrchIrClaims" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['title.popup.name']}"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupMdpSrchIrClaims" style="cursor:pointer"/>
				<rich:componentControl for="mdpSrchIrClaims" attachTo="hidePopupMdpSrchIrClaims" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmSrchIrClaims">
		<h:panelGrid width="450">
			<rich:panel>
				<h:panelGroup>
					<table width="95%">
						<tr>
							<td>
								<rich:dataTable width="100%" id="dtbSrchIrClaims" cellpadding="1" cellspacing="0" border="0"
													var="obj" value="#{semmir012Bean.irClaimListSrch}" 
													rows="#{semmir012Bean.rowPerPage}"
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
													rowClasses="cur" styleClass="dataTable">
							
										<rich:column width="5%">
											<div align="center">
				            					<a4j:commandLink id="hlkSelect" value="Select"
				            									 action="#{navAction.navi}"
				            									 oncomplete="#{rich:component('mdpSrchIrClaims')}.hide(); return false"
				            									 reRender="frmError,frmSave">
								            		<a4j:actionparam name="navModule" value="ir" />
													<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
													<a4j:actionparam name="moduleWithNavi" value="ir" />
													<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
													<a4j:actionparam name="methodWithNavi" value="doSelectIrClaim" />
													<a4j:actionparam name="irClaimId" value="#{obj.rowId}"/>
				            					</a4j:commandLink>                 							
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.locationId}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.locationId}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.lossPlaceName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.lossPlaceName']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.lossPlaceName}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.lossDt}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.lossDt']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.lossDt}" styleClass="contentform">
													<f:convertDateTime pattern="dd/MM/yyyy" locale="th" type="date"/>
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.createDt}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.createDt']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.createDt}" styleClass="contentform">
													<f:convertDateTime pattern="dd/MM/yyyy" locale="th" type="date"/>
												</h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="3">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmir012Bean.irClaimListSrch)}"></f:param>
														</h:outputFormat>
												</rich:column>
												<rich:column colspan="2">		
														<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSrchIrClaims"
																			   maxPages="#{semmir012Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																			   id="dstSrchIrClaims" 
																			   style="background-color: #cccccc;"
																			   page="#{semmir012Bean.scrollerPage}"/>						   
												</rich:column>
											</rich:columnGroup>					
										</f:facet>
									</rich:dataTable>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>
