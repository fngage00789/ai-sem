<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi003" var="jspMsg2"/>
<rich:modalPanel id="popupSearchContractNo" width="500"  height="600" autosized="true" minWidth="220" moveable="false">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg2['header.popup.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<a4j:form>
					<div align="left">
					    <h:graphicImage value="images/ico_close.png" id="hidePopupSearchContractNo" style="cursor:pointer">
							<a4j:support event="onclick"   reRender="pnlAddSiteApprove" oncomplete="#{rich:component('popupSearchContractNo')}.hide(); return false"/>
					    </h:graphicImage>
					</div>
				</a4j:form>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupSiteContractBean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
				<h:form id="popupFrmSearch"> 
				<h:panelGrid width="1000" id="grdPopupSearchCriteria">
					<rich:panel id="pnlPopupSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg2['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg2['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupContractNo" value="#{popupSiteContractBean.popupCriteriaPsi005.contractNo}"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg2['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupSiteName" value="#{popupSiteContractBean.popupCriteriaPsi005.siteName}"
		                			size="30"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg2['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlPopupCompany" value="#{popupSiteContractBean.popupCriteriaPsi005.company}">
										<f:selectItems value="#{popupSiteContractBean.companyList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg2['column.header.locationId']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtLocationId" value="#{popupSiteContractBean.popupCriteriaPsi005.locationId}" />
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSearch" value="#{jspMsg2['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,popupFrmError" >
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="PopupSiteContract" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="doSearchContractNoPsi005" />
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnClear" value="#{jspMsg2['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError">
					           		<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="PopupSiteContract" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="doClearPopupContractNoPsi005" />
					           		</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
				
					</rich:panel>
				</h:panelGrid>
				
				<div style="overflow:auto; height:400px">
					<rich:panel id="pnlPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg2['header.popup.resultTable.name']}" />
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi001Bean.msgDataNotFound}" rendered="#{popupSiteContractBean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable id="dtbPopupContractNo" width="97%"
						value="#{popupSiteContractBean.contractPsi005List}" 
						rowKeyVar="RegInd" var="contractSP" 
						rows="#{popupSiteContractBean.rowPerPage}"
						rowClasses="cur" styleClass="dataTable">
						<a4j:support event="onRowClick"  action="#{popupSiteContractAction.getRowIdOnClick}" reRender="dtbPopupContractNo">
								<a4j:actionparam name="rowId" value="#{contractSP.contractId}" />
						</a4j:support>
				
						<rich:column id="ContractNoSelect" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="" />
							</f:facet>
							<div align="center">
							<a4j:commandLink id="cmlSelect" value="Select" action="#{navAction.navi}" 
							reRender="popupSearchContractNo,pnlSiteInfoContract,txtContractNo,txtSiteName,
							panSearchCriteria,pnlTab5,pnlContractInfo,cldStrEffDt,cldEndExpireDt,cldEffDt,txtSiteContract" oncomplete="getCompany();">
							<a4j:actionparam name="navModule" value="common" />
							<a4j:actionparam name="navProgram" value="PopupSiteContract" />
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
							<a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
							<a4j:actionparam name="siteInfoId" value="#{contractSP.siteInfoId}"/>
							<a4j:actionparam name="siteName" value="#{contractSP.siteName}"/>
							<a4j:actionparam name="contractNo" value="#{contractSP.contractNo}"/>
							<a4j:actionparam name="region" value="#{contractSP.region}"/>
							<a4j:actionparam name="sendRenewId" value="#{contractSP.sendRenewId}" />
							<a4j:actionparam name="companyId" value="#{contractSP.company}" />
							<a4j:actionparam name="effDt" value="#{contractSP.effDateStr}" />
							<a4j:actionparam name="expDt" value="#{contractSP.expDateStr}" />
							<a4j:actionparam name="contractId" value="#{contractSP.contractId}" />
							<a4j:jsFunction name="getCompany"
											reRender="frmAddSiteApprove,txtContractNo"
											action="#{semmsi001Action.getCompany}" />
							</a4j:commandLink>
							</div>
						</rich:column>
						<rich:column id="colContractNo" sortBy="#{contractSP.contractNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.contractNo']}" styleClass="contentform" style="width: 100"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.contractNo}" styleClass="contentform"   />
							</div>
						</rich:column>
						
						<rich:column id="colSiteName" sortBy="#{contractSP.siteName}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg2['column.popup.header.siteName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
						
						<rich:column id="colCycleNo" sortBy="#{contractSP.cycleNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.cycleNo']}" styleClass="contentform" style="width: 40"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.cycleNo}" styleClass="contentform"   />
							</div>
						</rich:column>
						
						<rich:column id="colSeqNo" sortBy="#{contractSP.seqNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.seqNo']}" styleClass="contentform" style="width: 40"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.seqNo}" styleClass="contentform"   />
							</div>
						</rich:column>
						
						<rich:column id="colDocNo" sortBy="#{contractSP.docNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.docNo']}" styleClass="contentform" style="width: 80"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.docNo}" styleClass="contentform"   />
							</div>
						</rich:column>
						
						<rich:column id="colDocDt" sortBy="#{contractSP.docDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.docDate']}" styleClass="contentform" style="width: 50"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.docDate}" styleClass="contentform">
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column id="colReqType" sortBy="#{contractSP.reqType}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg2['column.popup.header.reqType']}" styleClass="contentform" style="width: 50"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{contractSP.reqType}" styleClass="contentform"   />
							</div>
						</rich:column>
						
							<rich:column id="colEffDate" sortBy="#{contractSP.effDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg2['column.header.popup.effDate']}" styleClass="contentform"  style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.effDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
									<h:inputHidden value="#{contractSP.effDateStr}"></h:inputHidden>
								</div>
							</rich:column>
							<rich:column id="colExpDate" sortBy="#{contractSP.expDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg2['column.header.popup.expDate']}" styleClass="contentform"  style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.expDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
									<h:inputHidden value="#{contractSP.expDateStr}"></h:inputHidden>
								</div>
							</rich:column>
							
							<rich:column id="colLocationId" sortBy="#{contractSP.expDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg2['column.header.locationId']}" styleClass="contentform"  style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.locationId}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPopupContractNo" 
									maxPages="10" id="dstPopupContractNo" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</div>
				</h:form>
</rich:modalPanel>

