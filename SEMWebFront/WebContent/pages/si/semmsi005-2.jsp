<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi005" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name2']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorAdd">
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
				<a4j:form id="frmSearch">
				
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
					<h:panelGroup>
				<table width="100%">
				<tr>
				
				<td width="50%" align="right" valign="bottom">
					<table id="tblButton">
					<tr>
					<td align="right">
					<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI005-1" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI005"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		</td>
	           		
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">						
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
		                				<h:selectOneMenu id="ddlCompany" value="#{semmsi005Bean.sendRenewExpSrchSP.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmsi005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmsi005Bean.sendRenewExpSrchSP.company}" styleClass="ms28"/>
				                	</td>
				                	<td align="right" width="20%" valign="bottom">
				                		<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
				                	</td>
				                	<td width="30%" valign="bottom">
				                		<h:selectOneMenu id="ddlRegionPage2" value="#{semmsi005Bean.sendRenewExpSrchSP.region}">
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
		                			<td width="30%">
		                			<h:inputText id="txtcontractNo" value="#{semmsi005Bean.sendRenewExpSrchSP.contractNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
			                			<h:selectOneMenu id="ddlSiteTypePage2" value="#{semmsi005Bean.sendRenewExpSrchSP.siteType}">
											<f:selectItems value="#{semmsi005Bean.siteTypeList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldContractStartDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewExpSrchSP.contractStartDt}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['message.constartDt']}">
											   <a4j:support event="oninputblur" ajaxSingle="true" reRender="frmErrorAdd" />
											   <a4j:support event="onchanged" ajaxSingle="true" reRender="frmErrorAdd" />
										</rich:calendar>
				                	</td>
				                	<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldContractEndDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewExpSrchSP.contractEndDt}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputkeyup="this.value = this.value.substring(0, 10);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['message.conEndDt']}">
											   <a4j:support event="oninputblur" ajaxSingle="true" reRender="frmErrorAdd" />
											   <a4j:support event="onchanged" ajaxSingle="true" reRender="frmErrorAdd" />
										</rich:calendar>
		                										
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				<h:selectBooleanCheckbox id="chkcontractNoEndFlag" styleClass="ms7" value="#{semmsi005Bean.chkFlag}" onclick="doDisable(this);"/>
		                				<script type="text/javascript">
		                					function doDisable(val){
			                					if(!val.checked){
		                							document.getElementById('incContent:frmSearch:cldExpireDtFromPage2InputDate').disabled = false;
		                							document.getElementById('incContent:frmSearch:cldExpireDtToPage2InputDate').disabled = false;
		                							document.getElementById('incContent:frmSearch:cldExpireDtFromPage2PopupButton').disabled = false;
		                							document.getElementById('incContent:frmSearch:cldExpireDtToPage2PopupButton').disabled = false;
		                							document.getElementById('incContent:frmSearch:cldExpireDtFromPage2PopupButton').src = 
				                						'/SEMWebFront/a4j/g/3_3_3.Finalorg.richfaces.renderkit.html.iconimages.CalendarIcon/DATB/eAHbWurFMOs5AAnQAvY_.jsf';
				                					document.getElementById('incContent:frmSearch:cldExpireDtToPage2PopupButton').src =
				                						'/SEMWebFront/a4j/g/3_3_3.Finalorg.richfaces.renderkit.html.iconimages.CalendarIcon/DATB/eAHbWurFMOs5AAnQAvY_.jsf';	
				                					document.getElementById('incContent:frmSearch:reqCon').style.display = '';
		                						}else{
		                							document.getElementById('incContent:frmSearch:cldExpireDtFromPage2InputDate').disabled = true;
			                						document.getElementById('incContent:frmSearch:cldExpireDtToPage2InputDate').disabled = true;
		                							document.getElementById('incContent:frmSearch:cldExpireDtFromPage2PopupButton').disabled = true;
		                							document.getElementById('incContent:frmSearch:cldExpireDtToPage2PopupButton').disabled = true;
			                						document.getElementById('incContent:frmSearch:cldExpireDtFromPage2PopupButton').src = 
				                						'/SEMWebFront/a4j/g/3_3_3.Finalorg.richfaces.renderkit.html.iconimages.DisabledCalendarIcon/DATB/eAHbWurFMOs5AAnQAvY_.jsf';
				                					document.getElementById('incContent:frmSearch:cldExpireDtToPage2PopupButton').src =
				                						'/SEMWebFront/a4j/g/3_3_3.Finalorg.richfaces.renderkit.html.iconimages.DisabledCalendarIcon/DATB/eAHbWurFMOs5AAnQAvY_.jsf';	
			                						document.getElementById('incContent:frmSearch:reqCon').style.display = 'none';
			                					}
			                				}
		                				</script>
		                				<h:outputText value="#{jspMsg['label.contractNoEndFlag']}" styleClass="ms7"/>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif" id="reqCon" style="display:none"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.expireDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                					<rich:calendar id="cldExpireDtFromPage2" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewExpSrchSP.expireDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpireDtFromPage2','cldExpireDtToPage2');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpireDtFromPage2','cldExpireDtToPage2');"
											   label="#{jspMsg['column.header.expireDtFrom']}"
											   >
											   
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldExpireDtToPage2" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi005Bean.sendRenewExpSrchSP.expireDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldExpireDtToPage2','cldExpireDtFromPage2');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldExpireDtToPage2','cldExpireDtFromPage2');"
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
		                			<h:inputText id="txtLocationId" value="#{semmsi005Bean.sendRenewExpSrchSP.locationId}"
		                			size="18" maxlength="15"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
				                	<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationName" value="#{semmsi005Bean.sendRenewExpSrchSP.locationCode}"
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
		                			<h:inputText id="txtSiteName" value="#{semmsi005Bean.sendRenewExpSrchSP.siteName}"
		                			 size="30" maxlength="200"/>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">
			                	 	<h:graphicImage value="images/icon_required.gif"/>
			                	 	<rich:spacer width="5"/>	
									<h:outputText value="#{jspMsg['label.sendRenewType']}" styleClass="ms7"/>
									
		                			</td>
		                			<td colspan="3"  width="80%">
		                				<h:selectOneMenu id="ddlSendRenewType" value="#{semmsi005Bean.sendRenewExpSrchSP.sendRenewType}" onchange="doRenewTypeChange(this.value);">
											<f:selectItems value="#{semmsi005Bean.sendRenewTypeList}"/>
										</h:selectOneMenu>
										<script>
											doRenewTypeChange('01');
											function doRenewTypeChange(val){
												if(val == '02' || val == '03' || val == '04'){
													document.getElementById('incContent:frmSearch:reqCon').style.display = 'none';
												}else{
													document.getElementById('incContent:frmSearch:reqCon').style.display = '';
												}
											} 
										</script>
				                	</td>
				                </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult" oncomplete="doRenewTypeChange(document.getElementById('incContent:frmSearch:ddlSendRenewType').value);">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI005-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
							<a4j:actionparam name="methodWithNavi" value="doSearchExp" />
							</a4j:commandButton>     
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI005-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
							<a4j:actionparam name="methodWithNavi" value="doClearSrchExp" />
							</a4j:commandButton>  
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi005Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid id="grdAddCommand">
					<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" disabled="#{semmsi005Bean.disabledBtnExport2}"  styleClass="rich-button" style="width:100"
					 action="#{navAction.navi}" reRender="frmErrorAdd,pnlSearchResult">
						 <a4j:actionparam name="navModule" value="si" />
						 <a4j:actionparam name="navProgram" value="SEMMSI005-2" />
						 <a4j:actionparam name="moduleWithNavi" value="si" />
						 <a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
						 <a4j:actionparam name="methodWithNavi" value="doSave2" />
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1500"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi005Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi005Bean.msgDataNotFound}" rendered="#{semmsi005Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="1400px" id="dtbSendRenewExpSrch" cellpadding="1" cellspacing="0" border="0"
							var="sendRenewExpSP" value="#{semmsi005Bean.sendRenewExpSrchSPList}" reRender="dstSendRenewExpSrch" 
							rows="#{semmsi005Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmsi005Action.getRowIdOnClick}" reRender="dtbSendRenewExpSrch">
								<a4j:actionparam name="rowId" value="#{sendRenewExpSP.dataObj.rowId}" />
								<a4j:actionparam name="dtbPage2" value="Y" />
							</a4j:support> 
							<rich:column styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:selectBooleanCheckbox style="width: 20" value="#{semmsi005Bean.chkSelAll2}">
										<a4j:support event="onclick" action="#{semmsi005Action.selectAllRowPage2}" reRender="dtbSendRenewExpSrch,btnSave"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect2"  value="#{sendRenewExpSP.checkBox}">
										<a4j:support event="onclick" action="#{semmsi005Action.onRenderExportButtonPage2}" reRender="dtbSendRenewExpSrch,btnSave">
											<a4j:actionparam name="rowId" value="#{sendRenewExpSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>   							
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.contractNo}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.siteName}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{sendRenewExpSP.dataObj.siteName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.locationId}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style="width:72px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.locationCode}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" styleClass="contentform" style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.effDt}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}" styleClass="contentform" style="width:110px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.effDt}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.expDt}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:110px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.expDt}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column width="200px" sortBy="#{sendRenewExpSP.dataObj.siteAds}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteAds']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.siteAds}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.rentAmt}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.rentAmt']}" styleClass="contentform" style="width:80px">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</f:facet>
								<div align="right">
									<h:outputText value="#{sendRenewExpSP.dataObj.rentAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.networkStatus}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.siteStatus}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.flowStatus}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.flowStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.flowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{sendRenewExpSP.dataObj.sendRenewType}" styleClass="#{(semmsi005Bean.tmpRowId2==sendRenewExpSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewType']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{sendRenewExpSP.dataObj.sendRenewType}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi005Bean.sendRenewExpSrchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="12">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSendRenewExpSrch"
											maxPages="#{semmsi005Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstSendRenewExpSrch" 
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
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog2">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button"
						immediate="true" >						
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
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