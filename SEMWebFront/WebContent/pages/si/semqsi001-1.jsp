<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>


<f:loadBundle basename="resources.siteinfo.semqsi001" var="jspMsg"/>
<h:panelGrid width="100%">
<rich:panel>
	<f:facet name="header" >
		<h:outputText value="#{jspMsg['header.name']}"/>
	</f:facet>
	<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semqsi001Bean.renderedMsgFormSearch}">
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
		</h:panelGrid><h:panelGrid columnClasses="gridContent" width="100%">
	<!-- begin content layout criteria -->
					<h:panelGrid width="96%" >
					<a4j:form id="frmSearch">
						<rich:panel id="pnlSearchCriteria">
							<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" >
							<tr>
									<td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</h:panelGroup>
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semqsi001Bean.queryRenewSAMSearchSP.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semqsi001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semqsi001Bean.queryRenewSAMSearchSP.company}" styleClass="ms28"/>
				                	</td>
				                	<td align="right" width="20%" valign="bottom">
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="bottom">
		                			<h:selectOneMenu id="ddlRegion" value="#{semqsi001Bean.queryRenewSAMSearchSP.region}">
											<f:selectItems value="#{semqsi001Bean.regionList}"/>
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
			                				<h:inputText id="txtcontractNo" value="#{semqsi001Bean.queryRenewSAMSearchSP.contractNo}" size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
			                			<h:selectOneMenu id="ddlSiteType" value="#{semqsi001Bean.queryRenewSAMSearchSP.siteType}">
											<f:selectItems value="#{semqsi001Bean.siteTypeList}"/>
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
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.contractStartDt}" 
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.contractStartDt']}"/>

				                	</td>
				                	<td align="right" width="20%">
					                	
		                			<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7" /></td>
		                			<td width="30%">
		                				<rich:calendar id="cldContractEndDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.contractEndDt}" 
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.contractEndDt']}"/>
				                	</td>
				                	
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				<h:selectBooleanCheckbox id="chkcontractNoEndFlag" styleClass="ms7" value="#{semqsi001Bean.queryRenewSAMSearchSP.select}"/>
		                				<h:outputText value="#{jspMsg['label.contractNoEndFlag']}" styleClass="ms7"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expireDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldExpireDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.expireDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.expireDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldExpireDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultExpireDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldExpireDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultExpireDtFrom" />
											   </a4j:support>
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldExpireDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.expireDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.expireDtTo']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldExpireDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultExpireDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldExpireDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultExpireDtTo" />
											   </a4j:support>
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
			                		 <h:inputText id="txtLocationId" value="#{semqsi001Bean.queryRenewSAMSearchSP.locationId}" size="18" maxlength="15"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="Location Code:" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
			                		 <h:inputText id="txtLocationCode" value="#{semqsi001Bean.queryRenewSAMSearchSP.locationCode}" size="18" maxlength="15"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.samDtFrom']}" styleClass="ms7" />
		                			</td>
		                			<td width="30%">
											   <rich:calendar id="cldSamDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.samDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.samDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldSamDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultSamDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldSamDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultSamDtFrom" />
											   </a4j:support>
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldSamDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.samDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.expireDtTo']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldSamDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultSamDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldSamDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultSamDtTo" />
											   </a4j:support>
										</rich:calendar>
				                	</td>
				                	<td align="right" width="20%"><h:outputText value="#{jspMsg['label.invalidDate']}" styleClass="ms7" />
				                	
				                	
									
		                			</td>
		                			<td width="30%">										   
										   <rich:calendar id="cldInvalidDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.invalidDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.samDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldInvalidDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultInvalidDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldInvalidDtTo">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultInvalidDtFrom" />
											   </a4j:support>
										</rich:calendar>	
										<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldInvalidDtTo" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semqsi001Bean.queryRenewSAMSearchSP.invalidDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.invalidDtTo']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldInvalidDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultInvalidDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldInvalidDtFrom">
											   		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultInvalidDtTo" />
											   </a4j:support>
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                			                			
			                	 </tr>
			                	 <tr>
			                	 
								 </tr>
								 <tr>
								 <td align="right" width="20%">
									 <h:outputText value="#{jspMsg['label.approveStatus']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
		                			<h:selectOneMenu id="ddlApproveStatus" value="#{semqsi001Bean.queryRenewSAMSearchSP.approveStatus}">
											<f:selectItems value="#{semqsi001Bean.approveStatusList}"/>
									</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%"><h:outputText value="#{jspMsg['label.sendRenewType']}" styleClass="ms7" />						
										
		                			</td>
		                			<td width="30%">
		                				 <h:selectOneMenu id="ddlSendRenewType" value="#{semqsi001Bean.queryRenewSAMSearchSP.sendRenewType}">
											<f:selectItems value="#{semqsi001Bean.sendRenewTypeList}"/>
										</h:selectOneMenu>
		                				
				                	</td>
							 
								 </tr>
								 <tr>
								 <td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
								 </td>
								 <td>
								 <h:selectOneMenu id="ddlSiteStatus" value="#{semqsi001Bean.queryRenewSAMSearchSP.siteStatus}">
									<f:selectItems value="#{semqsi001Bean.siteStatusList}"/>
								</h:selectOneMenu>
								 </td>
								 <td align="right" width="20%">
								 
								 </td>
								 <td>
							 		
								 </td>
								 </tr>
								 
							</table>
									</h:panelGroup>
								</h:panelGrid>
								
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			           		<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMQSI001" />
							<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
							</rich:panel>
						</a4j:form>
					</h:panelGrid>
					<a4j:form id="frmSearchResult">	
						<!-- begin content layout data grid-->
						<h:panelGrid  width="90%">
							<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
							<f:facet name="header"  >
								<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width:1700px"  />
							</f:facet>
							
							 <rich:dataTable id="dtbQueryRenewSrch" width="90%" cellpadding="1" cellspacing="0" border="0"
							var="queryRenewSAMSearchSP" value="#{semqsi001Bean.queryRenewSAMSearchSPList}" reRender="dstQueryRenewSrch" 
							rows="#{semqsi001Bean.rowPerPage}" 
							rowClasses="cur" 
							styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semqsi001Action.getRowIdOnClick}" reRender="dtbQueryRenewSrch">
								<a4j:actionparam name="rowId" value="#{queryRenewSAMSearchSP.rowId}" />
							</a4j:support>
							<rich:column sortBy="#{queryRenewSAMSearchSP.contractNo}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{queryRenewSAMSearchSP.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMQSI001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{queryRenewSAMSearchSP.contractNo}" />
									</a4j:commandLink>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.siteName}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform" style="width:210px"/>
								</f:facet>
								<div align="left" >
									<h:outputText value="#{queryRenewSAMSearchSP.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.locationId}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.locationId}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.locationCode}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Location Code" styleClass="contentform"  style="width:72px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.locationCode}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.address}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.address']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.address}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.effDt}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.effDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.expDt}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.expDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.networkStatus}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.networkStatus}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{queryRenewSAMSearchSP.sendRenewType}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendRenewType']}" styleClass="contentform" style="width:90px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.sendRenewType}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.approveStatus}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.approveStatus']}" styleClass="contentform"  style="width:90px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.approveStatus}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{queryRenewSAMSearchSP.samDt}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.samDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.samDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{queryRenewSAMSearchSP.siteStatus}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.siteStatus}" styleClass="contentform">
									</h:outputText>
									
								</div>
							</rich:column>
							<rich:column  sortBy="#{queryRenewSAMSearchSP.invalidDt}" styleClass="#{(semqsi001Bean.tmpRowId==queryRenewSAMSearchSP.rowId)?'onClick':'unClick'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invalidDate']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{queryRenewSAMSearchSP.invalidDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbQueryRenewSrch" 
									maxPages="10" id="dstQueryRenewSrch" selectedStyleClass="selectScroll" />
							</f:facet>
							
							</rich:dataTable>
							</rich:panel>
						</h:panelGrid>	
						<!-- End  -->
						</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>



