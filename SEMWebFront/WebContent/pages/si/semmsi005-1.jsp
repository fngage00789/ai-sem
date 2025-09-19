<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi005" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi005Bean.renderedMsgFormTop}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
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
		                			<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmsi005Bean.sendRenewSrchSP.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmsi005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmsi005Bean.sendRenewSrchSP.company}" styleClass="ms28"/>
				                	</td>
				                	<td align="right" width="20%" valign="bottom">
				                		<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
				                	</td>
				                	<td width="35%" valign="bottom">
				                		<h:selectOneMenu id="ddlRegion" value="#{semmsi005Bean.sendRenewSrchSP.region}">
											<f:selectItems value="#{semmsi005Bean.regionList}"/>
										</h:selectOneMenu>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:inputText id="txtcontractNo" value="#{semmsi005Bean.sendRenewSrchSP.contractNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
			                			<h:selectOneMenu id="ddlSiteType" value="#{semmsi005Bean.sendRenewSrchSP.siteType}">
											<f:selectItems value="#{semmsi005Bean.siteTypeList}"/>
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="picoSelect" value="#{semmsi005Bean.chkPico}"/>
										<rich:spacer width="5"/>
										<h:outputText value="PICO" styleClass="ms7"/>
				                	</td>
							</tr>
			                	 
			                 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<rich:calendar id="cldContractStartDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" 
		                			 datePattern="dd/MM/yyyy" 
		                			 value="#{semmsi005Bean.sendRenewSrchSP.contractStartDt}" 
		                			 inputSize="13" 
									 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									 cellWidth="20px" cellHeight="20px"
									 label="#{jspMsg['column.header.contractStartDt']}"
									 >
									 	<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmError" />
										<a4j:support event="onchanged" ajaxSingle="true" reRender="frmError" />
		                			 </rich:calendar>
				                	</td>
				                	<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<rich:calendar id="cldContractEndDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" 
		                			 datePattern="dd/MM/yyyy" 
		                			 value="#{semmsi005Bean.sendRenewSrchSP.contractEndDt}" 
		                			 inputSize="13" 
									 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									 cellWidth="20px" cellHeight="20px"
									 label="#{jspMsg['column.header.contractEndDt']}"
									 >
									 	<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmError" />
										<a4j:support event="onchanged" ajaxSingle="true" reRender="frmError" />
		                			 </rich:calendar>		                										
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				<h:selectBooleanCheckbox id="chkcontractNoEndFlag" value="#{semmsi005Bean.sendRenewSrchSP.selected}"/>
		                				<h:outputText value="#{jspMsg['label.contractNoEndFlag']}" styleClass="ms7"/>
				                	</td>
				                	<td align="right" width="20%">
				                		
										<h:outputText value="#{jspMsg['label.expireDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                				<rich:calendar id="cldExpireDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.expireDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpireDtFrom','cldExpireDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpireDtFrom','cldExpireDtTo');"
											   label="#{jspMsg['column.header.expireDtFrom']}"
											   >
											   
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldExpireDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.expireDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpireDtTo','cldExpireDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpireDtTo','cldExpireDtFrom');"
											   label="#{jspMsg['column.header.expireDtTo']}"
											   >
											   
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semmsi005Bean.sendRenewSrchSP.locationId}"
		                			size="18" maxlength="15"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
				                	<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationName" value="#{semmsi005Bean.sendRenewSrchSP.locationCode}"
		                			size="18" maxlength="15"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteName" value="#{semmsi005Bean.sendRenewSrchSP.siteName}"
		                			 size="30" maxlength="200"/>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 		<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.approveDtFrom']}" styleClass="ms7" rendered="false"/>
									
		                			</td>
		                			<td colspan="3"  width="80%">
		                			<rich:calendar id="cldApproveDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.approveDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveDateFrom','cldApproveDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveDateFrom','cldApproveDateTo');"
											   label="#{jspMsg['column.header.approveDateFrom']}" rendered="false">
											   
										</rich:calendar>
										 <rich:spacer width="5" rendered="false"/>
										 	<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" rendered="false"/>
										  <rich:spacer width="5" rendered="false"/>
									<rich:calendar id="cldApproveDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.approveDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveDateTo','cldApproveDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveDateTo','cldApproveDateFrom');"
											   label="#{jspMsg['column.header.approveDateTo']}" rendered="false">
											   
										</rich:calendar>
				                	</td>
				                	
				                			                			
			                	 </tr>
			                	 <tr>
			                	 <td align="right" width="25%">
			                	 <h:outputText value="#{jspMsg['label.approveBackDtFrom']}" styleClass="ms7" rendered="false"/>
			                	 </td>
			                	 <td colspan="3" width="75%">
			                	 <rich:calendar id="cldApproveBackDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.approveBackDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveBackDateFrom','cldApproveBackDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveBackDateFrom','cldApproveBackDtTo');"
											   label="#{jspMsg['column.header.approveBackDateFrom']}" rendered="false">
											   
										</rich:calendar>
								 <rich:spacer width="5" rendered="false"/>	
								 	<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" rendered="false"/>
								 <rich:spacer width="5" rendered="false"/>	
								 <rich:calendar id="cldApproveBackDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.approveBackDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldApproveBackDtTo','cldApproveBackDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldApproveBackDtTo','cldApproveBackDateFrom');"
											   label="#{jspMsg['column.header.approveBackDateTo']}" rendered="false">
											  
										</rich:calendar>
			                	 </td>
			                	 
			                	 
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.samDtFrom']}" styleClass="ms7" rendered="false"/>
								 </td>
								 <td colspan="3" width="80%">
								 <rich:calendar id="cldSamDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.samDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldSamDtFrom','cldSamDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSamDtFrom','cldSamDtTo');"
											   label="#{jspMsg['column.header.SamDateFrom']}" rendered="false">
											   
										</rich:calendar>
								 <rich:spacer width="5" rendered="false"/>
								 <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" rendered="false"/>
								 <rich:spacer width="5" rendered="false"/>	
								  <rich:calendar id="cldSamDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewSrchSP.samDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldSamDtTo','cldSamDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldSamDtTo','cldSamDtFrom');"
											   label="#{jspMsg['column.header.SamDateTo']}" rendered="false">
											  
										</rich:calendar>
								 </td>
								 
								 
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.status']} :" styleClass="ms7"/>
								 </td>
								 <td>
								 		<h:selectOneMenu id="ddlApproveStatus" value="#{semmsi005Bean.sendRenewSrchSP.approveStatus}">
											<f:selectItems value="#{semmsi005Bean.sendRenewapproveStatusList}"/>
										</h:selectOneMenu>
								 </td>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.sendRenewType']}" styleClass="ms7"/>
								 </td>
								 <td>
								 		<h:selectOneMenu id="ddlSendRenewType" value="#{semmsi005Bean.sendRenewSrchSP.sendRenewType}">
											<f:selectItems value="#{semmsi005Bean.sendRenewTypeList}"/>
										</h:selectOneMenu>
								 </td>
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 		<h:graphicImage value="images/icon_required.gif" rendered="false"/>
										<rich:spacer width="5" rendered="false"></rich:spacer>
								 		<h:outputText value="#{jspMsg['label.sendRenewStatus']}" styleClass="ms7" rendered="false"/>
								 </td>
								 <td>
								 		<h:selectOneMenu id="ddlSendRenewStatus" value="#{semmsi005Bean.sendRenewSrchSP.sendRenewStatus}" rendered="false">
											<f:selectItems value="#{semmsi005Bean.sendRenewStatusList}"/>
										</h:selectOneMenu>
								 </td>
								 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			           		<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi005Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid id="grdAddCommand" columns="5">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" reRender="oppContent" style="width:60" 
	            	rendered="false">
	            		<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI005-2" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
					</a4j:commandButton>
					<h:commandButton id ="btnExport" action="#{semmsi005Action.doExportExcel}" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}" disabled="#{semmsi005Bean.disabledBtnExport}">
	            	</h:commandButton>
					<a4j:commandButton id="btnApproveplanOld" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmsi005Bean.disableBtnApprove}" 
					 action="#{navAction.navi}" reRender="frmError,frmSearchResult,popupFrmAdd,popupSendRenewBackDt" rendered="false"
					 oncomplete="if(#{semmsi005Bean.popupClose == 'true'})#{rich:component('popupSendRenewBackDt')}.show(); return false">
					 	<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						<a4j:actionparam name="methodWithNavi" value="doValidateAPopup" />		 
					</a4j:commandButton>
					
					<a4j:commandButton id="btnSamOld" value="#{jspMsg['btn.sam']}" styleClass="rich-button" style="width:70"
	            	action="#{navAction.navi}" reRender="frmError,frmSearchResult,pnlSearchResult" disabled="#{semmsi005Bean.disableBtnSam}"
	            	rendered="false">
	            		<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						<a4j:actionparam name="methodWithNavi" value="doUpdateSam" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnApproveplan" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmsi005Bean.disableBtnApprove}" 
					 action="#{navAction.navi}" reRender="frmError,frmSearchResult,popupFrmAdd" 
					 onclick="if(!confirm('#{jspMsg['label.process_confirm']} #{jspMsg['btn.approve']}')) return false;">
					 	<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						<a4j:actionparam name="methodWithNavi" value="doSendRenew" />
						<a4j:actionparam name="actionType" value="Y" />				 
					</a4j:commandButton>
					
					<a4j:commandButton id="btnSam" value="#{jspMsg['btn.sam']}" styleClass="rich-button" style="width:70"
	            	action="#{navAction.navi}" reRender="frmError,frmSearchResult,pnlSearchResult" disabled="#{semmsi005Bean.disableBtnApprove}"
	            	onclick="if(!confirm('#{jspMsg['label.process_confirm']} #{jspMsg['btn.sam']}')) return false;">
	            		<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						<a4j:actionparam name="methodWithNavi" value="doSendRenew" />
						<a4j:actionparam name="actionType" value="N" />	
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2615"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi005Bean.msgDataNotFound}" rendered="#{semmsi005Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi005Bean.renderedMsgFormMiddle}"/>
						</div>
						 <rich:dataTable id="dtbSendRenewSrch" cellpadding="1" cellspacing="0" border="0" width="2500px"
							var="sendRenewSP" value="#{semmsi005Bean.sendRenewSrchSPList}" reRender="dstSendRenewSrch" 
							rows="#{semmsi005Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur" >
							<a4j:support event="onRowClick"   action="#{semmsi005Action.getRowIdOnClick}" reRender="dtbSendRenewSrch">
								<a4j:actionparam name="rowId" value="#{sendRenewSP.dataObj.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:selectBooleanCheckbox style="width: 20" value="#{semmsi005Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmsi005Action.selectAllRow}" reRender="dtbSendRenewSrch,btnApproveplan,btnSam,btnExport"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{sendRenewSP.checkBox}">
										<a4j:support event="onclick" action="#{semmsi005Action.onRenderExportButton}" reRender="dtbSendRenewSrch,btnApproveplan,btnSam,btnExport">
											<a4j:actionparam name="rowId" value="#{sendRenewSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>      							
								</div>
							</rich:column>
							<rich:column id="btnDelete" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmsi005Bean.renderer['btnDelete']}">
								<f:facet name="header" >
									<h:outputText value="Delete" styleClass="contentform"   style="width:36px"/>
								</f:facet>
								<div align="center" style="width:36px;"> 	
									<a4j:commandButton id="btnInitDelete" oncomplete="#{rich:component('mdpConfirmDelDialogSI005')}.show(); return false"
									styleClass="ms7" action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15;" 
									rendered="#{(sendRenewSP.dataObj.sendRenewStatusCd eq '01') or (sendRenewSP.dataObj.sendRenewStatusCd eq '02')}"
									reRender="frmConfirmDelDialogSI005,frmError,pnlSearchResult,mdpConfirmDelDialogSI005">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{sendRenewSP.dataObj.rowId}" />
										<a4j:actionparam name="sendRenewStatusCd" value="#{sendRenewSP.dataObj.sendRenewStatusCd}" />
									</a4j:commandButton>						
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.contractNo}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px;">
									<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{sendRenewSP.dataObj.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{sendRenewSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{sendRenewSP.dataObj.siteName}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:210px"/>
								</f:facet>
								<div align="left" style="width:210px;">
									<h:outputText value="#{sendRenewSP.dataObj.siteName}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.locationId}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style="width:72px"/>
								</f:facet>
								<div align="center" style="width:72px;">
									<h:outputText value="#{sendRenewSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.locationCode}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" styleClass="contentform" style="width:72px"/>
								</f:facet>
								<div align="center" style="width:72px;">
									<h:outputText value="#{sendRenewSP.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.approveStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.approveStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px;">
									<h:outputText value="#{sendRenewSP.dataObj.approveStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.renewAgeDesc}" styleClass="#{(semmsi006Bean.tmpRowId==approveRenewSP.dataObj.rowId)?'onClick':'unClick'}" 
							rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.renewAgeDesc']}" styleClass="contentform" style="width:36px"/>
								</f:facet>
								<div align="center" style="width:36px;">
									<h:outputText value="#{sendRenewSP.dataObj.renewAgeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.effDt}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.effDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.expDt}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="200px"  sortBy="#{sendRenewSP.dataObj.address}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.address']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left" style="width:200px;">
									<h:outputText value="#{sendRenewSP.dataObj.address} #{sendRenewSP.dataObj.district} #{sendRenewSP.dataObj.amphur} #{sendRenewSP.dataObj.province}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.rentAmt}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.rentAmt']}" styleClass="contentform" style="width:72px"/>
								</f:facet>
								<div align="right" style="width:72px;">
									<h:outputText value="#{sendRenewSP.dataObj.rentAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column  sortBy="#{sendRenewSP.dataObj.networkStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center" style="width:90px;">
									<h:outputText value="#{sendRenewSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.sendRenewType}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewType']}" styleClass="contentform" style="width:110px"/>
								</f:facet>
								<div align="center" style="width:110px;">
									<h:outputText value="#{sendRenewSP.dataObj.sendRenewType}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.sendRenewStatus}" 
							styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewStatus']}" styleClass="contentform" style="width:150px"/>
								</f:facet>
								<div align="center" style="width:150px;">
									<h:outputText value="#{sendRenewSP.dataObj.sendRenewStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.sendRenewDt}" 
							styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.sendRenewDt}" styleClass="contentform" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.sendRenewBackDt}" 
							styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewBackDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.sendRenewBackDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.approvebackDt}" 
							styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.approveBackDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.approvebackDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.remark}" 
							styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform" style="width:240px"/>
								</f:facet>
								<div align="center" style="width:240px;">
									<h:outputText value="#{sendRenewSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewSP.dataObj.samDt}"
							 styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}"  rendered="false"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.samDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.samDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.siteStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewSP.dataObj.flowStatus}" styleClass="#{(semmsi005Bean.tmpRowId==sendRenewSP.dataObj.rowId)?'onClick':'unClick'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.flowStatus']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center" style="width:100px;">
									<h:outputText value="#{sendRenewSP.dataObj.flowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>			
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi005Bean.sendRenewSrchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="18">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSendRenewSrch"
											maxPages="#{semmsi005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstSendRenewSrch" 
											style="background-color: #cccccc;"
											page="#{semmsi005Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/si/semmsi005-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmConfirmDelDialogSI005">
<rich:modalPanel id="mdpConfirmDelDialogSI005" autosized="true" rendered="#{semmsi005Bean.validateDelete}">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi005Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbSendRenewSrch,pnlSearchResult">						
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />	
							<rich:componentControl for="mdpConfirmDelDialogSI005" operation="hide" event="onclick"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialogSI005" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
</a4j:form>