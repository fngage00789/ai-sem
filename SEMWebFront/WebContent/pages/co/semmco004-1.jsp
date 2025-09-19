<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.co.semmco004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco004Bean.renderedMsgFormSearch}">
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
		                  	<td align="right" width="20%" >
		                		<h:outputText id="lblMonth" value="#{jspMsg['label.dateFrom']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="30%">
		                      	<rich:calendar id="EffDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco004Bean.criteriaSrch.effDateFrom}"
									   showWeeksBar="false" 
									   inputSize="13" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label = "#{jspMsg['label.dateFrom']}">
									   </rich:calendar>
			                	<rich:spacer width="5"/>
			                	<h:outputText id="dateTo" value="#{jspMsg['label.dateTo']}" styleClass="ms7" />
			                	<rich:spacer width="5"/>
			                	<rich:calendar id="expDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco004Bean.criteriaSrch.expDateTo}"
									   showWeeksBar="false" 
									   inputSize="13" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label="#{jspMsg['label.dateTo']}"
									   >
									   </rich:calendar>
		                    </td>
		                    <td align="right" width="20%" >
		                		<h:outputText id="lblRegion" value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="30%">
		                      	<h:selectOneMenu id="ddlRegion" value="#{semmco004Bean.criteriaSrch.region}">
			                		<f:selectItems value="#{semmco004Bean.regionList}"/>
			                	</h:selectOneMenu>
		                    <td>
		                      
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right" width="20%" >
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']} :" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlCompany" value="#{semmco004Bean.criteriaSrch.company}">
			                		<f:selectItems value="#{semmco004Bean.companyList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right"></td>
		                    <td>
		                      
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right" valign="top">
		                    	<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/> 		                    	
		                    </td>
		                    <td>
		                    	<h:inputTextarea id="txtContract" value="#{semmco004Bean.criteriaSrch.contractNo}" cols="30" rows="3" />
		                    </td>
		                    <td align="right">
		                    	<h:outputText id="lblsiteName" value="#{jspMsg['label.siteName']} :" styleClass="ms7"/> 		                    	
		                    </td>
		                    <td>
		                    	<h:inputText id="txtSiteName" value="#{semmco004Bean.criteriaSrch.siteName}" />
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                    	<h:outputText id="lblLocationId" value="#{jspMsg['label.locationId']} :" styleClass="ms7"/> 		                    	
		                    </td>
		                    <td>
		                    	<h:inputText id="txtLocationId" value="#{semmco004Bean.criteriaSrch.locationId}" />
		                    </td>
		                     <td align="right" width="10%">
		                    	<h:outputText id="groupNo" value="#{jspMsg['label.groupNo']} :" styleClass="ms7"/>
		                    </td>
		                    <td>
		                    <h:inputText id="txtGroupNo" value="#{semmco004Bean.criteriaSrch.groupNo}" />
		                    </td>
		                  </tr>
		                  <tr>
		                    <td align="right" width="10%">
		                    	<h:outputText id="lblSubRentType" value="#{jspMsg['label.subRentType']} :" styleClass="ms7"/>
		                    </td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlSubRentType" value="#{semmco004Bean.criteriaSrch.subRentType}">
	                				<f:selectItems value="#{semmco004Bean.subRentTypeList}"/>
	                			</h:selectOneMenu>
		                    </td>
		                    <td align="right" width="10%">
		                    	<h:outputText id="lblSubRentStatus" value="#{jspMsg['label.subRentStatus']} :" styleClass="ms7"/>
		                    </td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlSubRentStatus" value="#{semmco004Bean.criteriaSrch.subRentStatus}">
			                		<f:selectItems value="#{semmco004Bean.subRentStatusList}"/>
			                  </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
                            <td align="right" width="10%">
                               
                            </td>
                            <td colspan="3">
                              <a4j:region>
                                 <h:selectBooleanCheckbox id="chkPico"  value="#{semmco004Bean.criteriaSrch.pico}">
                                    <a4j:support event="onclick" reRender="chkPico,outLa">
                                    </a4j:support>
                                 </h:selectBooleanCheckbox>
                              </a4j:region>
                              <h:outputLabel value="Pico" styleClass="ms7"></h:outputLabel>
                            </td>
                          </tr>
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmSearch,panSearchResult" >
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="panelError,frmError,panSearchCriteria,panSearchResult">
				            		<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			<a4j:form id="frmResult">
            	<table width="96%">
            		<tr>
            			<td>
            			<a4j:commandButton id="btnConStatus" value="#{jspMsg['label.saveContract']}" styleClass="rich-button"
						oncomplete="#{rich:component('popupAddContractStatus')}.show(); return false"  
		            	action="#{navAction.navi}" reRender="popupAddContractStatus,popupFrmAddContractStatus,pnlAddContractStatus" 
		            	style="width:120" disabled="#{semmco004Bean.disableExport}">
		            		<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
							<a4j:actionparam name="methodWithNavi" value="initAddContractStatus" />
						</a4j:commandButton>
            				<a4j:commandButton id="btnSummary" value="#{jspMsg['btn.summry']}" styleClass="rich-button" action="#{navAction.navi}"
							reRender="frmSrchSummary" 
							oncomplete="#{rich:component('mdpSrchSummary')}.show(); return false">
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO004-2" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
								<a4j:actionparam name="methodWithNavi" value="initPopUpSummary" />
							</a4j:commandButton>
							
							
							
				<h:commandButton id="btnExport" value="#{jspMsg['btn.Export']}" styleClass="rich-button" 
            		action="#{semmco004Action.doExportExcel}"  style="width:100" 
            		disabled="#{semmco004Bean.disableExport}">
            		
				</h:commandButton>
				
				<a4j:commandButton id="btnGroup" value="#{jspMsg['btn.group']}" styleClass="rich-button" action="#{navAction.navi}"
							reRender="panSearchResult,frmResult" disabled="#{semmco004Bean.disableExport}"> 
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
								<a4j:actionparam name="methodWithNavi" value="doCheckGroup" />
								<a4j:actionparam name="actionType" value="A" />
							</a4j:commandButton>  
				<a4j:commandButton id="btnUnGroup" value="#{jspMsg['btn.unGroup']}" styleClass="rich-button" action="#{navAction.navi}"
							reRender="panSearchResult,frmResult" disabled="#{semmco004Bean.disableExport}"> 
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
								<a4j:actionparam name="methodWithNavi" value="doCheckGroup" />
								<a4j:actionparam name="actionType" value="D" />
							</a4j:commandButton>	
									      
				<a4j:commandButton id="btnPrint" value="#{jspMsg['btn.print']}" styleClass="rich-button" action="#{navAction.navi}"
							reRender="panSearchResult,frmResult" disabled="#{semmco004Bean.disableExport}"> 
								<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
										<a4j:actionparam name="moduleWithNavi" value="report" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO004RPT" />
										<a4j:actionparam name="methodWithNavi" value="doPrint" />
										<a4j:support event="oncomplete" reRender="frmError, frmSearch,frmResult, pnlShowReport" rendered="#{semmco004RPTBean.displayShowReport}"/>
							</a4j:commandButton>
							
							<h:commandButton id="btnExportDuty" value="#{jspMsg['btn.exportDuty']}" styleClass="rich-button" 
			            	action="#{semmco004Action.doExportDutyExcel}"  style="width:150" 
			            	disabled="#{semmco004Bean.disableExport}">
							</h:commandButton>
							
				</td>
            	</tr>
            	</table>

				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult" styleClass="sem_autoScrollbar" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1940"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt004Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco004Bean.msgDataNotFound}" rendered="#{semmco004Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="mco004Srch" value="#{semmco004Bean.mco004SrchSPList}" reRender="dstMco004Srch" 
							rows="#{semmco004Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="dataTable">
							<rich:column styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
							<f:facet name="header">
								<h:selectBooleanCheckbox id="chkBoxAll" value="#{semmco004Bean.chkSelAll}" disabled="#{semmco004Bean.disableSelectAll}">
										<a4j:support event="onclick" action="#{semmco004Action.selectAllRow}" 
											reRender="frmResult,dtbPolicy"/>
								</h:selectBooleanCheckbox>
							</f:facet>
							<div align="center">
									<h:selectBooleanCheckbox id="contractSelected" value="#{mco004Srch.checkBox}" 
										rendered="#{mco004Srch.dataObj.rowId != null and mco004Srch.disableCheckBox}">
										<a4j:support event="onclick" action="#{semmco004Action.onRenderButton}" reRender="btnConStatus,btnExport,btnGroup,btnUnGroup,btnPrint,dtbPolicy,contractSelected,chkBoxAll,btnExportDuty,dtbPolicy">
										<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.rowId}" />
										<a4j:actionparam name="lesseeContractId" value="#{mco004Srch.dataObj.lesseeContractId}" />
										<a4j:actionparam name="status" value="#{mco004Srch.dataObj.subRentStatus}" />
										<a4j:actionparam name="checked" value="#{mco004Srch.checkBox}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
							</div>
							</rich:column>
							
							<rich:column rendered="#{semmco004Bean.renderer['hlkEdit']}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkSaveContract" value="#{jspMsg['label.saveContract']}" rendered="#{mco004Srch.dataObj.lesseeContractNo != null}"
		            						action="#{navAction.navi}" reRender="oppContent" onclick="changeTab();">
											<a4j:actionparam name="navModule" value="co" />
			            					<a4j:actionparam name="navProgram" value="SEMMCO004-3" />	
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
											<a4j:actionparam name="methodWithNavi" value="initUpdateContract" />
											<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.rowId}"/>
											<a4j:actionparam name="lesseeId" value="#{mco004Srch.dataObj.lesseeContractId}"/>
											<a4j:actionparam name="siteName" value="#{mco004Srch.dataObj.siteName}"/>
											<a4j:actionparam name="company" value="#{mco004Srch.dataObj.lesseeCompany}"/>
											<a4j:actionparam name="siteInfoId" value="#{mco004Srch.dataObj.lessorSiteInfoId}" />
											<a4j:actionparam name="groupNumber" value="#{mco004Srch.dataObj.groupNo}" />
											<a4j:actionparam name="fromInitPage" value="init" />
            							</a4j:commandLink>
            							<a4j:jsFunction name="changeTab" action="#{semmco004Action.setTabNo}">
            						<a4j:actionparam name="tabNo" value="2"/>
            					</a4j:jsFunction>
									</div>
							</rich:column>
							
							<rich:column rendered="true" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style = "width : 40px"/>
								</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkEditDuty" value="#{jspMsg['header.panel.editDuty']}"
			            					oncomplete="#{rich:component('popupEditDuty')}.show(); return false"  
			            					action="#{navAction.navi}" reRender="popupEditDuty" >
												<a4j:actionparam name="navModule" value="co" />
				            					<a4j:actionparam name="navProgram" value="SEMMCO004-1" />	
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
												<a4j:actionparam name="methodWithNavi" value="initUpdateDuty" />
												<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.lesseeContractId}"/>
												<a4j:actionparam name="siteInfoId" value="#{mco004Srch.dataObj.lesseeSiteInfoId}"/>
												<a4j:actionparam name="groupNumber" value="#{mco004Srch.dataObj.groupNo}" />
			            					</a4j:commandLink>
									</div>
							</rich:column>
							
							<rich:column rendered="#{semmco004Bean.renderer['hlkEdit']}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style = "width : 40px"/>
								</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkEdit" value="Edit" action="#{navAction.navi}" reRender="oppContent"> 
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO004-2" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
											<a4j:actionparam name="methodWithNavi" value="initSubRentInfo" />
											<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.rowId}" />
										</a4j:commandLink>
									</div>
							</rich:column>
							<rich:column styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style = "width :100px "/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkCreateFile" value="#{jspMsg['label.createFile']}" action="#{navAction.navi}" reRender="oppContent"
									rendered="#{mco004Srch.dataObj.lesseeContractNo != null}"> 
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
										<a4j:actionparam name="moduleWithNavi" value="report" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO004RPT" />
										<a4j:actionparam name="methodWithNavi" value="doCreateFile" />
										<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.rowId}" />
										
										<a4j:support event="oncomplete" reRender="frmError, frmSearch,frmResult, pnlShowReport" rendered="#{semmco004RPTBean.displayShowReport}"/>
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.lesseeContractNo}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lesseeContractNo']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{mco004Srch.dataObj.lesseeContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.lesseeSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.lessorContractNo}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">    
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.lessorContractNo']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo1" value="#{mco004Srch.dataObj.lessorContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mco004Srch.dataObj.lessorSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.groupNo}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.groupNo']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mco004Srch.dataObj.groupNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.locationId}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mco004Srch.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.siteName}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style = "width : 150px" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{mco004Srch.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.effectiveDt}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effectiveDt']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{mco004Srch.dataObj.effectiveDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.expireDt}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expireDt']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mco004Srch.dataObj.expireDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.dutyAmt}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dutyAmt']}" styleClass="contentform" style = "width : 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mco004Srch.dataObj.dutyAmt}" styleClass="contentform"  >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{mco004Srch.dataObj.contractAge}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractAge']}" styleClass="contentform"  style = "width : 80px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mco004Srch.dataObj.contractAge}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.rentAmt}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.rentAmt']}" styleClass="contentform"  style = "width : 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mco004Srch.dataObj.rentAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>			
							<rich:column sortBy="#{mco004Srch.dataObj.serviceAmt}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.serviceAmt']}" styleClass="contentform" style=" width : 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mco004Srch.dataObj.serviceAmt}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.subRentStatus}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header" >
									<h:outputText value="#{jspMsg['label.subRentStatus']}" styleClass="contentform" style=" width : 90px"/>
								</f:facet>
								<div align="right" >
									<h:outputText value="#{mco004Srch.dataObj.subRentStatus}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mco004Srch.dataObj.borrowStatus}" styleClass="#{(mco004Srch.checkBox)?'select':'unSelect'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.borrowStatus']}" styleClass="contentform" style=" width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mco004Srch.dataObj.borrowStatus}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco004Bean.mco004SrchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmco004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmco004Bean.scrollerPage}" 
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

<rich:modalPanel id="mdpSrchSummary" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['title.popup.name']}"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupMdpSrchSummary" style="cursor:pointer"/>
				<rich:componentControl for="mdpSrchSummary" attachTo="hidePopupMdpSrchSummary" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmSrchSummary">
		<h:panelGrid>
			<rich:panel styleClass="sem_autoScrollbar_Popup">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco004Bean.renderedMsgSummaryPopup}">
			 		<f:facet name="header">
	                      	<h:outputText value="Entered Data Status:"></h:outputText>
	                  	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
	                   </f:facet>
	            </rich:messages>
				<h:panelGroup>
					<table width="95%">
						<tr>
							<td align="right" width="20%">
		                		<h:outputText id="lblSearch" value="#{jspMsg['label.search']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="30%">
		                      	<h:selectOneMenu id="ddlShearc" value="#{semmco004Bean.criteriaSummarySrch.subRentSummaryType}">
			                		<f:selectItems value="#{semmco004Bean.subRentSummaryTypeList}"/>
			                	</h:selectOneMenu>
		                    </td>
		                    <td align="right" width="20%">
		                		<h:outputText id="labelMonth" value="#{jspMsg['label.month']} :" styleClass="ms7"/>
		                	</td>
		                	<td width="30%">
		                      	<h:selectOneMenu id="ddlMonth" value="#{semmco004Bean.criteriaSummarySrch.month}">
			                		<f:selectItems value="#{semmco004Bean.monthPopupList}"/>
			                	</h:selectOneMenu>
		                    </td>
		                    <td align="right" width="20%">
		                		<h:outputText id="labelYear" value="#{jspMsg['label.year']} :" styleClass="ms7"/>
		                	</td>
		                	<td width="30%">
		                		<h:inputText id="ddlYear" value="#{semmco004Bean.criteriaSummarySrch.year}" size="5"></h:inputText>
		                    </td>
		                    
		                    <td align="right" width="20%">
		                		<h:outputText id="labelRegion" value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                	</td>
		                	<td width="30%">
		                      	<h:selectOneMenu id="ddlRegion" value="#{semmco004Bean.criteriaSummarySrch.region}">
			                		<f:selectItems value="#{semmco004Bean.regionList}"/>
			                	</h:selectOneMenu>
		                    </td>
						</tr>
						<tr>
							<td colspan="10" align="center">
								<a4j:commandButton id="btnSearchSummary" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmSrchSummary" >
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
									<a4j:actionparam name="methodWithNavi" value="doSearchSummary" />
								</a4j:commandButton>
								<rich:spacer width="10"></rich:spacer>
				            	<a4j:commandButton id="btnClearSummary" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="frmSrchSummary">
				            		<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
									<a4j:actionparam name="methodWithNavi" value="doClearSummary" />
				            	</a4j:commandButton>
							</td>
						</tr>
						<tr>
							<td><br/></td>
						</tr>
						<tr>
							<td colspan="10">
								
								<rich:dataTable width="100%" id="dtbSrchSummary" cellpadding="1" cellspacing="0" border="0"
													var="obj" value="#{semmco004Bean.summaryList}" 
													rows="#{semmco004Bean.rowPerPage}"
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
													rowClasses="cur" styleClass="dataTable">
							
										<rich:column sortBy="#{obj.locationId}" width="10%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.monthYear']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.monthYear}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.region}" >
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.region']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.region}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.totalAmt}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.total']}" styleClass="contentform" />
											</f:facet>
											<div align="right">
												<h:outputText value="#{obj.totalAmt}" styleClass="contentform">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.createAmt}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.createAmt']}" styleClass="contentform" />
											</f:facet>
											<div align="right">
												<h:outputText value="#{obj.createAmt}" styleClass="contentform">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.remainAmt}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.remainAmt']}" styleClass="contentform" />
											</f:facet>
											<div align="right">
												<h:outputText value="#{obj.remainAmt}" styleClass="contentform">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
												</h:outputText>
											</div>
										</rich:column>
										
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmco004Bean.summaryList)}"></f:param>
														</h:outputFormat>
												</rich:column>
												<rich:column colspan="3">		
														<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSrchSummary"
																			   maxPages="#{semmco004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																			   id="dstSrchIrClaims" 
																			   style="background-color: #cccccc;"
																			   page="#{semmco004Bean.scrollerPage}"/>						   
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
	<jsp:include page="../../pages/co/semmco004-popupSaveContract.jsp" />
	<jsp:include page="../../pages/co/semmco004-popupDutyAmt.jsp" />		
</rich:modalPanel>


<a4j:form id="frmShowReport">
<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReport" rendered="#{semmco004RPTBean.displayShowReport}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmco004RPTAction.showReport}"  />								
		<script>document.getElementById('incContent:frmShowReport:bthShowReport').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>