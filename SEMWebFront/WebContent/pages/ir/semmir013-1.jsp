<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<jsp:include page="../../pages/popup/multiZone-popup.jsp" />


<f:loadBundle basename="resources.insurance.semmir013" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchIR013">
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
		                      	<h:selectOneMenu id="ddlCompany" value="#{semmir013Bean.mir013Sch.company}">
			                		<f:selectItems value="#{semmir013Bean.companyList}"/>
			                	</h:selectOneMenu>
		                    </td>
		                     <td align="right">
		                		<h:outputText id="lblRegion" value="#{jspMsg['label.region']}" styleClass="ms7"/></td>
		                    <td>
		                     	<h:inputText id="txtRegion" value="#{popupMultiZoneBean.region}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right" style="vertical-align:text-top;">										
			               		<h:outputText id="lblZone" value="#{jspMsg['label.zone']} " styleClass="ms7"/>
			             	</td>
							<td align="left" >
								<rich:spacer width="7px"></rich:spacer>			
								<h:panelGrid id="criMultiZone" 
											 columns="2" columnClasses="ms7">
									<a4j:region>
									<h:selectManyListbox id="criPolicyZone" 
														 size="#{popupMultiZoneBean.delListSize/7}" styleClass="ms7"
														 value="#{popupMultiZoneBean.delList}" onchange="renderZone();">
														 
						        		<f:selectItems value="#{popupMultiZoneBean.selectedList}"/>
						        		<a4j:jsFunction name="renderZone" reRender="criPolicyZone"/>
						    		</h:selectManyListbox>
						    		</a4j:region>
									<h:panelGroup>
										<a4j:commandButton id="btnAddPolicyMultiZone" styleClass="rich-button"
														   value="..." action="#{navAction.navi}"
														   reRender="popupMultiZone" 
														   oncomplete="#{rich:component('popupMultiZone')}.show(); return false" >
						            		
						            		<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="multiZone-popup" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupMultiZone" />
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="moduleWithNaviFrom" value="ir" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR013" />
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
		                    <td align="right">
		                		<h:outputText id="lblLocationCode" value="#{jspMsg['label.locationCode']}" styleClass="ms7"/></td>
		                    <td>
		                     	<h:inputText id="txtLocationCode" value="#{semmir013Bean.mir013Sch.locationCode}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblLocationId" value="#{jspMsg['label.locationId']}" styleClass="ms7"/></td>
		                    <td>
		                     	<h:inputText id="txtLocationId" value="#{semmir013Bean.mir013Sch.locationId}"/>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblLocationName" value="#{jspMsg['label.locationName']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtLocationName" value="#{semmir013Bean.mir013Sch.locationName}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:selectOneMenu id="ddlNetworkType" value="#{semmir013Bean.mir013Sch.networkType}">
			                		<f:selectItems value="#{semmir013Bean.networkTypeList}"/>
			                	</h:selectOneMenu>
							</td>
							<td align="right">
		                		<h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:selectOneMenu id="ddlTransferType" value="#{semmir013Bean.mir013Sch.transferType}">
			                		<f:selectItems value="#{semmir013Bean.transferTypeList}"/>
			                	</h:selectOneMenu>
							</td>
		                  </tr>
		                  <tr >
								<td align="right">										
				               		<h:outputText id="lblPolicyType" value="#{jspMsg['label.policyType']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:selectOneMenu id="ddlPolicyType" value="#{semmir013Bean.mir013Sch.policyType}">
			                			<f:selectItems value="#{semmir013Bean.policyTypeList}"/>
			                		</h:selectOneMenu>
								</td>
								<td align="right">										
				               		<h:outputText id="lblPolicyNo" value="#{jspMsg['label.policyNo']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:inputText id="txtPolicyNo" value="#{semmir013Bean.mir013Sch.policyNo}"/>
								</td>
						</tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtContractNo" value="#{semmir013Bean.mir013Sch.contractNo}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="labelClaimDtFrom" value="#{jspMsg['label.claimDT']}" styleClass="ms7"/></td>
		                    <td colspan="3">
		                      	<rich:calendar id="cldClaimDtFrom" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir013Bean.mir013Sch.claimDtFrom}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.claimDT']}"
								disabled="false">
								</rich:calendar>
								<rich:spacer width="10"></rich:spacer>
								<h:outputText value="-"/>
								<rich:spacer width="10"></rich:spacer>
		                      	<rich:calendar id="cldClaimDtTo" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir013Bean.mir013Sch.claimDtTo}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.claimDtTo']}"
								disabled="false">
								</rich:calendar>								
		                    </td>
		                  </tr>
		                  <tr >
								<td align="right">										
				               		<h:outputText id="lblCliamNo" value="#{jspMsg['label.claimNo']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:inputText id="txtClaimNo" value="#{semmir013Bean.mir013Sch.claimNo}"/>
								</td>
								<td align="right">										
				               		<h:outputText id="lblClaimStatus" value="#{jspMsg['label.claimStatus']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:selectOneMenu id="ddlClaimStatus" value="#{semmir013Bean.mir013Sch.claimStatus}">
			                			<f:selectItems value="#{semmir013Bean.claimStatusList}"/>
			                		</h:selectOneMenu>
								</td>
						</tr>
						<tr >
								<td align="right">										
				               		<h:outputText id="lblLossDt" value="#{jspMsg['label.lossDt']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<rich:calendar id="cldLossDt" locale="th" enableManualInput="true" 
		                			datePattern="dd/MM/yyyy" 
									value="#{semmir013Bean.mir013Sch.lossDtFrom}"
		                			showWeeksBar="false" 
		                			inputSize="13"
		                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.lossDt']}"
									disabled="false">
									</rich:calendar>
									<rich:spacer width="10"></rich:spacer>
								<h:outputText value="-"/>
								<rich:spacer width="10"></rich:spacer>
		                      	<rich:calendar id="cldLossDtTo" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir013Bean.mir013Sch.lossDtTo}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.lossDt']}"
								disabled="false">
								</rich:calendar>
								</td>
								<td align="right">										
				               		<h:outputText id="lblLossType" value="#{jspMsg['label.lossType']}" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:selectOneMenu id="ddlLossType" value="#{semmir013Bean.mir013Sch.lossType}">
			                			<f:selectItems value="#{semmir013Bean.lossTypeList}"/>
			                		</h:selectOneMenu>
								</td>
						</tr>
						
		                                   
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmSearchIR013" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR013-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="panelError,frmError,panSearchCriteria,frmResult">
				            		<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR013-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            	
				            	<a4j:commandButton id="btnImportFile"
								reRender="oppContent"
								value="#{jspMsg['btn.importFile']}" styleClass="rich-button"
								style="width:110"
								oncomplete="#{rich:component('popupImportFile')}.show(); return false" 
								rendered="#{semmir013Bean.renderer['btnImport']}"
								action="#{navAction.navi}">
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR013-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
									<a4j:actionparam name="methodWithNavi" value="initPopupLoadExcel" />
								</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			
			<a4j:form id="frmResult">
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult"  styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir013Bean.msgDataNotFound}" rendered="#{semmir013Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="mir013ValueSP" value="#{semmir013Bean.mir013SchList}" reRender="dstPolicy" 
							rows="#{semmir013Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.update']}" styleClass="contentform" style="width: 60" />
								</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkInitSavePay" value="Update" oncomplete="#{rich:component('popupEditClaim')}.show(); return false"
									 reRender="popupEditClaim,popupFrmEdit,pnlEditClaim" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR013-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
										<a4j:actionparam name="methodWithNavi" value="initUpdate" />	
										<a4j:actionparam name="cliamId" value="#{mir013ValueSP.dataObj.claimId}"/>	
										<a4j:actionparam name="draftNo" value="#{mir013ValueSP.dataObj.draftNo}"/>
										</a4j:commandLink>
									</div>
							</rich:column>
							<rich:column>    
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.network']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{mir013ValueSP.dataObj.networkTypeDesc}" styleClass="contentform" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style="width: 60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.company}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}" styleClass="contentform" style="width: 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.transferTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkPolicyNo" value="#{mir013ValueSP.dataObj.policyNo}" 
									 reRender="frmSearchIR013,popupEditClaim,popupFrmEdit,pnlEditClaim,oppContent" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR009-2" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR009" />
										<a4j:actionparam name="methodWithNavi" value="initPlocyInfo" />
										<a4j:actionparam name="policyNo" value="#{mir013ValueSP.dataObj.policyNo}" />
										<a4j:actionparam name="navModuleFrom" value="ir" />
										<a4j:actionparam name="navProgramFrom" value="SEMMIR013-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR013" />	
										<a4j:actionparam name="isPageFrom" value="true" />	
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" styleClass="contentform" style = "width : 60px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationName']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mir013ValueSP.dataObj.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>			
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.claimNo']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkClaimNo" value="#{mir013ValueSP.dataObj.claimNo}" 
									 reRender="oppContent" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR012-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR012" />
										<a4j:actionparam name="methodWithNavi" value="doSelectIrClaim" />	
										<a4j:actionparam name="irClaimId" value="#{mir013ValueSP.dataObj.claimId}"/>
										<a4j:actionparam name="viewMode" value="N"/>		
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.claimDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.claimDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.claimStatus']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.claimStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lossType']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{mir013ValueSP.dataObj.lossTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.estimateAmt']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mir013ValueSP.dataObj.estimateAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.deductAmt']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mir013ValueSP.dataObj.deductAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.claimAmt']}" styleClass="contentform" style = "width : 90px" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{mir013ValueSP.dataObj.claimAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.litigantFlg']}" styleClass="contentform" style = "width : 40px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.litigantFlg}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.litigantAmt']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mir013ValueSP.dataObj.litigantAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.updateBy}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mir013ValueSP.dataObj.updateDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir013Bean.mir013SchList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmir013Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmir013Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>		
			<jsp:include page="../../pages/ir/semmir013-popup.jsp"/>		
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

<rich:modalPanel id="popupImportFile" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Upload Info"></h:outputText>
    </f:facet>
	<a4j:form id="frmUploadInfo">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listenerNotChangeName}"
								listHeight="50" listWidth="300"
								addControlLabel="Browse..."
								immediate="true"
								immediateUpload="true" uploadButtonClassDisabled="true" cleanButtonClassDisabled="true"
								autoclear="true" acceptedTypes="xls,xlsx" >
									<a4j:support event="onuploadcomplete" reRender="frmSearchIR013,frmConfirmDialog,frmUploadInfo" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
										<a4j:actionparam name="methodWithNavi" value="initloadExcel" />
									</a4j:support>
									<a4j:support event="oncomplete" reRender="frmConfirmDialog,frmSearchIR013"/>
									<rich:componentControl for="pnlConfirmDialog" operation="show" event="oncomplete" rendered="#{semmir013Bean.renderConfirm}"/>
										
					</rich:fileUpload>
					
				</td>
			</tr>
			<tr>
				<td align="left">
					<h:panelGrid columns="1" styleClass="contentlabelform">
						<a4j:commandButton id="btnPopupBack" value="Close" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="popupImportFile" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<a4j:form id="frmConfirmDialog">
<rich:modalPanel id="pnlConfirmDialog" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmir013Bean.confirmLoadExcelMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton id="btnImportYes" value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,frmSearchIR008"
						 oncomplete="#{rich:component('pnlConfirmDialog')}.hide();
						 				#{rich:component('popupImportFile')}.hide(); return false">						
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR013" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
								<a4j:actionparam name="methodWithNavi" value="loadExcel" />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" action="#{navAction.navi}" reRender="frmConfirmDialog,txtPicFileUpload">
							<a4j:actionparam name="navModule" value="ir" />
	            			<a4j:actionparam name="navProgram" value="SEMMIR013" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
							<a4j:actionparam name="methodWithNavi" value="doCancelExport" />
						    <rich:componentControl for="pnlConfirmDialog" operation="hide" event="onclick" rendered="txtPicFileUpload"/>
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
<h:panelGrid id="pnlLoadExcel" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlgLoadSave" rendered="#{semmir013Bean.renderLoadExcel}" style="height:0px;width:0px;" >
			<a4j:commandButton id="btnLoadExcel" style="height:0px;width:0px;display:none;" action="#{navAction.navi}" reRender="frmError,frmSearchIR008" 
			oncomplete="#{rich:component('popupImportFile')}.hide(); return false"
			immediate="true">
				<a4j:actionparam name="navModule" value="ir" />
       			<a4j:actionparam name="navProgram" value="SEMMIR013" />	
				<a4j:actionparam name="moduleWithNavi" value="ir" />
				<a4j:actionparam name="actionWithNavi" value="SEMMIR013" />
				<a4j:actionparam name="methodWithNavi" value="doEndExport" />
			</a4j:commandButton>
		<script>document.getElementById('incContent:frmConfirmDialog:btnLoadExcel').click();</script>
	</h:panelGroup>
	<h:panelGroup id="pnlShowConfirm" rendered="#{semmir013Bean.renderConfirm}" style="height:0px;width:0px;" >
		<a4j:commandButton id="btnShowConfirm" style="height:0px;width:0px;display:none;" reRender="frmSearchIR008" 
		oncomplete="#{rich:component('pnlConfirmDialog')}.show(); return false"
		immediate="true">
		</a4j:commandButton>
		<script>document.getElementById('incContent:frmConfirmDialog:btnShowConfirm').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>