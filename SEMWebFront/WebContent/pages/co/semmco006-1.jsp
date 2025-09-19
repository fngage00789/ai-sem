<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<f:loadBundle basename="resources.co.semmco006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco006Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%" valign="baseline">
									<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="40%"  valign="bottom">
		                			<a4j:region>
									<h:selectOneMenu id="ddlCompany" value="#{semmco006Bean.criteria.company}" onchange="GetCompanyJS();">
										<f:selectItems value="#{semmco006Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay,contractStatus" action="#{semmco006Action.renderCompany}"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmco006Bean.criteria.company}" styleClass="ms28"/>
									</a4j:region>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
				                	</td>
				                	<td width="20%">
				                		<h:selectOneMenu id="region" value="#{semmco006Bean.criteria.region}">
				                			<f:selectItems value="#{semmco006Bean.regionList}"/>
				                		</h:selectOneMenu>
				                		<rich:spacer width="5"></rich:spacer>
				                		<a4j:region>
				                		<h:selectBooleanCheckbox id="chkPico"  value="#{semmco006Bean.criteria.pico}">
											<a4j:support event="onclick" reRender="chkPico,outLa">
											</a4j:support>
										</h:selectBooleanCheckbox>
										</a4j:region>
										<h:outputLabel value="Pico" styleClass="ms7"></h:outputLabel>
				                	</td>
			                	 </tr>
			                	 <a4j:region>
								<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="40%">
	                				<h:selectOneMenu id="contractStatus" value="#{semmco006Bean.criteria.contractStatus}">
				                			<f:selectItems value="#{semmco006Bean.contractStatList}"/>
				                		</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
				                	<a4j:jsFunction name="RenderTerminateFlagJS" action="#{semmco006Action.renderTerminateFlag}"
									reRender="pnlSearchCriteria"/>
				                	<h:selectBooleanCheckbox id="chkTerminateFlag" value="#{semmco006Bean.chkTerminateFlag}" 
									styleClass="ms7" rendered="#{semmco006Bean.renderedTerminateFlag}" />
					                <h:outputText id="txtTerminateFlag" value="#{jspMsg['label.terminateFlag']}" styleClass="ms7" 
					                rendered="#{semmco006Bean.renderedTerminateFlag}"/>
				                	</td>
				                	<td width="20%">
				                		
				                	</td>
			                	 </tr>
			                	 </a4j:region>
			                	 <tr>
									<td align="right" width="20%">
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.receiveDt']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3" align="left">
		                			<rich:calendar id="cldReceiveDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco006Bean.criteria.receiveDateFrom}"
									   showWeeksBar="false" 
									   inputSize="13" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   oninputblur="validateRichCalendarFromTo('frmSearch','cldReceiveDateFrom','cldReceiveDateTo');"
									   oncollapse="validateRichCalendarFromTo('frmSearch','cldReceiveDateFrom','cldReceiveDateTo');"
									   label="#{jspMsg['label.receiveDt']}">
									</rich:calendar> 
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									<rich:spacer width="5"></rich:spacer>
									 <rich:calendar id="cldReceiveDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmco006Bean.criteria.receiveDateTo}"
									   showWeeksBar="false"
									   inputSize="13"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   oninputblur="validateRichCalendarFromTo('frmSearch','cldReceiveDateTo','cldReceiveDateFrom');"
									   oncollapse="validateRichCalendarFromTo('frmSearch','cldReceiveDateTo','cldReceiveDateFrom');"
									   label="#{jspMsg['label.receiveDt']}">
									</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%" valign="top">
									<!-- 
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									 -->
									 <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									 <rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['column.header.contractNo']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                			<h:inputTextarea id="txtContractNo" value="#{semmco006Bean.criteria.contractNo}" 
		                			cols="100" rows="3" onblur="setFormatContractNo(this)"/>
				                	</td>
			                	 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch" >
							<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO006-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
			           		<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO006-1" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<h:panelGrid id="grdAddCommand">
				<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="40%">
					<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.saveContractStatus']}" styleClass="rich-button"
					oncomplete="#{rich:component('popupAddContractStatus')}.show(); return false"  
	            	action="#{navAction.navi}" reRender="popupAddContractStatus,popupFrmAddContractStatus,pnlAddContractStatus" 
	            	style="width:120" disabled="#{semmco006Bean.disabledBtnAdd}">
	            		<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO006-2" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
						<a4j:actionparam name="methodWithNavi" value="initAddContractStatus" />
					</a4j:commandButton>
					</td>
					<td align="left" width="60%">
					<h:commandButton id="btnExport" value="#{jspMsg['btn.export']}" 
	            	action="#{semmco006Action.doExportExcel}"  
	            	disabled="#{semmco006Bean.disabledBtnExport}"
	            	style="width:150" styleClass="rich-button" >
					</h:commandButton>
					<rich:spacer width="5"></rich:spacer>
					<h:commandButton id="btnExportDuty" value="#{jspMsg['btn.exportDuty']}" styleClass="rich-button" 
	            	action="#{semmco006Action.doExportDutyExcel}"  style="width:150" 
	            	disabled="#{semmco006Bean.disabledBtnExportDuty}">
					</h:commandButton>
					</td>
					</tr>
					</table>
				</h:panelGroup>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				<h:panelGrid  width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2700"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmco006Bean.msgDataNotFound}" rendered="#{semmco006Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbContractStatus" cellpadding="1" cellspacing="0" border="0"
							var="contractSP" value="#{semmco006Bean.contractStatusSPList}" reRender="dtbContractStatus" 
							rows="10" rowClasses="cur"	 styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmco006Action.getRowIdOnClick}" reRender="dtbContractStatus">
								<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
								<h:selectBooleanCheckbox id="chkBoxAll" value="#{semmco006Bean.chkSelAll}" disabled="#{semmco006Bean.disableSelectAll}">
										<a4j:support event="onclick" action="#{semmco006Action.selectAllRow}" 
											reRender="btnAdd,btnExport,btnExportDuty,dtbContractStatus,chkBoxAll"/>
								</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="contractStatusSelected" value="#{contractSP.checkBox}" 
										rendered="#{contractSP.dataObj.rowId != null and contractSP.disableCheckBox}">
										<a4j:support event="onclick" action="#{semmco006Action.onRenderButton}" reRender="btnAdd,btnExport,btnExportDuty,dtbContractStatus,contractStatusSelected,chkBoxAll">
										<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}" />
										<a4j:actionparam name="status" value="#{contractSP.dataObj.contractStatusName}" />
										<a4j:actionparam name="checked" value="#{contractSP.checkBox}" />
									</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText value="" styleClass="contentform" style="width: 80"/>
								</f:facet>
								<div align="center">
            					<a4j:commandLink id="hlkEdit" value="#{jspMsg['btn.edit']}"
            					oncomplete="#{rich:component('popupEditContractStatus')}.show(); return false"  
            					action="#{navAction.navi}" reRender="popupEditContractStatus">
									<a4j:actionparam name="navModule" value="co" />
	            					<a4j:actionparam name="navProgram" value="SEMMCO006-1" />	
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateContractStatus" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
									<a4j:actionparam name="company" value="#{contractSP.dataObj.company}"/>
									
            					</a4j:commandLink>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header" >
									<h:outputText value="" styleClass="contentform" style="width: 80"/>
								</f:facet>
								<div align="center">
            					<a4j:commandLink id="hlkEditDuty" value="#{jspMsg['header.panel.editDuty']}"
            					oncomplete="#{rich:component('popupEditDuty')}.show(); return false"  
            					action="#{navAction.navi}" reRender="popupEditDuty" >
									<a4j:actionparam name="navModule" value="co" />
	            					<a4j:actionparam name="navProgram" value="SEMMCO006-1" />	
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
									<a4j:actionparam name="methodWithNavi" value="initUpdateDuty" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.rowId}"/>
									<a4j:actionparam name="siteInfoId" value="#{contractSP.dataObj.siteInfoId}"/>
									
            					</a4j:commandLink>          							
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractSP.dataObj.locationId}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.contractNo}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{contractSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.oldContractNo}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.oldContractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{contractSP.dataObj.oldContractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMCO001-1" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="initPopup" />
									<a4j:actionparam name="rowId" value="#{contractSP.dataObj.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.siteName}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.effDate}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.effDtStr}" styleClass="contentform" > 
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.expDate}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.expDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{contractSP.dataObj.dutyAmt}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dutyAmt']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{contractSP.dataObj.dutyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.contractStatusName}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatusName']}" styleClass="contentform" style = "width : 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.contractStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{contractSP.dataObj.borrowStatus}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.borrowStatus']}" styleClass="contentform" style = "width : 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.borrowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractSP.dataObj.receivePersonCode}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.receivePersonCode} #{contractSP.dataObj.receivePersonCode}">
								<f:facet name="header">
									<h:outputText value="ผู้รับ" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.receivePersonCode}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.createPersonCode}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.createPersonCode} #{contractSP.dataObj.createPersonCode}">
								<f:facet name="header">
									<h:outputText value="ผู้จัดทำ" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.createPersonCode}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.siteApprovePersonName}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.siteApprovePersonName} #{contractSP.dataObj.siteApprovePersonName}">
								<f:facet name="header">
									<h:outputText value="ผู้ดูแล" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteApprovePersonName}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.d1}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d1']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d1Str1}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.d2}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d2']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d2Str}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{contractSP.dataObj.d4}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d4']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d4Str}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.d5}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d5']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d5Str}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.d6}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d6']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d6Str}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.d7}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.d7']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.d7Str}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{contractSP.dataObj.remark}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width:150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{contractSP.dataObj.siteStatusName}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteStatus']}" styleClass="contentform" style="width:100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.siteStatusName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractSP.dataObj.flowStatus}" styleClass="#{(semmco006Bean.tmpRowId==contractSP.dataObj.rowId)?'onClick':'unClick'}"
							title="#{contractSP.dataObj.contractNo} #{contractSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width:150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.dataObj.flowStatus}" styleClass="contentform"/>
								</div>
							</rich:column>									
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco006Bean.contractStatusSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="23">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractStatus"
											maxPages="#{semmco006Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractStatus" 
											style="background-color: #cccccc;"
											page="#{semmco006Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/co/semmco006-4.jsp" />
			<jsp:include page="../../pages/co/semmco006-2.jsp" />	  
			<jsp:include page="../../pages/co/semmco006-3.jsp" />
			
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>
<!-- Delete ContractStatus History -->
<rich:modalPanel id="mdpConfirmDelDialogContractStatusHistory" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialogContractStatusHistory">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmco006Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlContractStatusHistory,dtbContractStatusHistory,pnlEditContractStatus,pnlSearchResult,dtbContractStatus" >
							<a4j:actionparam name="navModule" value="co" />
		            		<a4j:actionparam name="navProgram" value="SEMMCO006-3" />	
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteContractStatusHistory" />							
							<rich:componentControl for="mdpConfirmDelDialogContractStatusHistory" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialogContractStatusHistory" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

