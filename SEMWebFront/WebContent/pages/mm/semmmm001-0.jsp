<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.todolist']} Staff"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<!-- criteriaToDoList panel -->
		<a4j:form id="frmCriteriaSearch">
		
			<table>
				<tr>
					<td align="left" valign="top">
						<!-- left content panel -->
							<rich:panel id="panelWrapper_tree" style="width:300px;height:100%;border:1 e0e0e0 solid; height:100%;vertical-align:top;" headerClass="headerCenter">
								<!-- >> header left content -->
									<f:facet name="header">
											<h:outputText value="#{jspMsg['label.toDoList']} Staff" />
									</f:facet>
								<!-- << header left content -->
								
									<rich:simpleTogglePanel id="pnlSubVendor"  switchType="client" label="#{jspMsg['label.vendor']}      (#{semmmm001Bean.totalSumVendor})" 
							        opened="#{semmmm001Bean.togPnlVD}" style="width:100%;margin:0 auto; padding:0px;align:top;">
										<h:dataTable id="vendor" border="0"
											var="obj" value="#{semmmm001Bean.menuTreeVendorList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" >
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" /> 
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="VD" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<rich:simpleTogglePanel id="pnlSubVendorBookbank"  switchType="client" label="#{jspMsg['label.vendorbookbank']}      (#{semmmm001Bean.totalSumVendorBookbank})" 
							        opened="#{semmmm001Bean.togPnlVB}" style="width:100%;margin:0 auto; padding-top:2px;align:top;">
										<h:dataTable id="vendorBookbank" border="0"
											var="obj" value="#{semmmm001Bean.menuTreeVendorBookbankList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="VB" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<rich:simpleTogglePanel id="pnlSubPayee"  switchType="client" label="#{jspMsg['label.payee']}      (#{semmmm001Bean.totalSumPayee})" 
							        opened="#{semmmm001Bean.togPnlPY}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="payee" border="0"
											var="obj" value="#{semmmm001Bean.menuTreePayeeList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="PY" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<rich:simpleTogglePanel id="pnlSubPayeeBookbank"  switchType="client" label="#{jspMsg['label.payeebookbank']}      (#{semmmm001Bean.totalSumPayeeBookbank})" 
							        opened="#{semmmm001Bean.togPnlPB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="payeeBookbank" border="0"
											var="obj" value="#{semmmm001Bean.menuTreePayeeBookbankList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="PB" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<rich:simpleTogglePanel id="pnlSubAbnormal"  switchType="client" label="#{jspMsg['label.abnormal']}      (#{semmmm001Bean.totalSumAbnormal})" 
							        opened="#{semmmm001Bean.togPnlAB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="abnormal" border="0"
											var="obj" value="#{semmmm001Bean.menuTreeAbnormalList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="AB" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<rich:simpleTogglePanel id="pnlSubCreateBy"  switchType="client" label="#{jspMsg['label.createby']}      (#{semmmm001Bean.totalSumCreateBy})" 
							        opened="#{semmmm001Bean.togPnlCB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="createBy" border="0"
											var="obj" value="#{semmmm001Bean.menuTreeCreateByList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm001Action.processSelectedMenu}"
													          reRender="panelWrapper_tree,panelWrapper_content" >
													          	<a4j:actionparam name="rowId" value="#{obj.dataObj.rowId}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="mainId" value="#{obj.dataObj.mainId}" />
																	<a4j:actionparam name="menuLevel" value="#{obj.dataObj.menuLevel}" />
																	<a4j:actionparam name="refId" value="#{obj.dataObj.refId}" />
																	<a4j:actionparam name="renderedFlag" value="#{obj.dataObj.renderedFlag}" />
																	<a4j:actionparam name="actionFlag" value="#{obj.dataObj.disableFlag}" />
																	<a4j:actionparam name="menuGroup" value="#{obj.dataObj.menuGroup}" />
																	<a4j:actionparam name="strParam" value="#{obj.dataObj.strParam}" />
																	<a4j:actionparam name="headerFlag" value="#{obj.dataObj.headerFlag}" />
																	<a4j:actionparam name="type" value="CB" />
													          </a4j:commandLink>
													     </span>
													     <span style="width:50px; white-space:nowrap; text-align:right;">
													     	<h:outputText value="(" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     	<h:outputText value="#{obj.dataObj.recordCount}" styleClass="ms7" />
													     	<h:outputText value=")" rendered="#{obj.dataObj.recordCount == null ? false : true}" styleClass="ms7" />
													     </span>
													</div>
													<div style="clear:both;"></div>
												</h:panelGroup>
												
											</h:column>
										</h:dataTable>
									</rich:simpleTogglePanel>
									
									<!-- ShowReport Panel -->
								</rich:panel>
						<!-- END left panel -->
					</td>
					<td align="left" valign="top">
						<rich:panel id="pnlSearchCriteria">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.criteria.name']}"/></f:facet>
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.company']}"/>
											</td>
											<td style="width:30%;" >
												<h:selectOneMenu id="searchCompany" value="#{semmmm001Bean.vendorMasterCriteria.company}" style="width:160px;">
				                					<f:selectItems value="#{semmmm001Bean.companyList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												
											</td>
											<td style="width:30%;" >
												
											</td>
										</tr>
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.region']}"/>
											</td>
											<td style="width:35%;" >
												<h:selectManyCheckbox value="#{semmmm001Bean.vendorMasterCriteria.arrRegion}" styleClass="ms7">
										   			<f:selectItems value="#{semmmm001Bean.regionList}" />
										   		</h:selectManyCheckbox>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.type']}"/>
											</td>
											<td width="30%;">
												<rich:spacer width="3"></rich:spacer>
												<h:selectBooleanCheckbox id="chkPicoType" value="#{semmmm001Bean.chkPicoType}" style="vertical-align:bottom;" />
						                		<h:outputText value="PICO" styleClass="ms7" style="margin-left:2px;" />
											</td>
										</tr>
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.code']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchVendorCode" value="#{semmmm001Bean.vendorMasterCriteria.vendorCode}" style="width:70%;" />
												
												<a4j:commandButton id="btnCnvrtVendor" value="..." styleClass="rich-button" 
									            action="#{semmmm001Action.initConvertVendor}" reRender="searchVendorCode, mmm001PopUpCommon_convertVendorCode" 
									            style="margin: 0 0 0 5px; height:22px; vertical-align:top;"
									            oncomplete="#{rich:component('mmm001PopUpCommon_convertVendorCode')}.show();">
									            	<a4j:actionparam name="todoFlag" value="T"></a4j:actionparam>
												</a4j:commandButton>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.or.payee.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchPayeeName" value="#{semmmm001Bean.vendorMasterCriteria.payeeName}" style="width:70%;" />
											</td>
										</tr>
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchIdCard" value="#{semmmm001Bean.vendorMasterCriteria.idCard}" style="width:70%;" 
												onkeypress="return numberformat.keyPressDecimalAsterisk(this, event);" maxlength="13"/>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchTaxId" value="#{semmmm001Bean.vendorMasterCriteria.taxId}" style="width:70%;" 
												onkeypress="return numberformat.keyPressDecimalAsterisk(this, event);" maxlength="13"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.contract.number']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchContractNo" value="#{semmmm001Bean.vendorMasterCriteria.contractNo}" style="width:50%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.site.name']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchSiteName" value="#{semmmm001Bean.vendorMasterCriteria.siteName}" style="width:70%;"/>
											</td>
										</tr>
										
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.number']} Vendor/Payee" styleClass="ms7"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchAccountNo" value="#{semmmm001Bean.vendorMasterCriteria.accountNo}" style="width:70%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.account.name']} Vendor/Payee"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchAccountName" value="#{semmmm001Bean.vendorMasterCriteria.accountName}" style="width:70%;"/>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.batch.no']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchBatchNo" value="#{semmmm001Bean.vendorMasterCriteria.batchNo}" style="width:50%;" />
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.create.by']}"/>
											</td>
											<td style="width:30%;">
												<h:inputText id="searchCreateBy" value="#{semmmm001Bean.vendorMasterCriteria.createBy}" style="width:70%;" />
											</td>
										</tr>
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="searchVendorFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.vendorFlowStatus}" style="width:160px;">
								                	<f:selectItems value="#{semmmm001Bean.vendorFlowStatusList}" />
								                </h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="searchBookbankFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankFlowStatus}" style="width:160px;">
								                	<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
								                </h:selectOneMenu>
											</td>
										</tr>
										
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.payee.flow.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="searchPayeeFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.payeeFlowStatus}" style="width:160px;">
								                	<f:selectItems value="#{semmmm001Bean.payeeFlowStatusList}" />
								                </h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.bookbank.payee.flow.status']}"/>
											</td>
											<td style="width:30%;">
												<h:selectOneMenu id="searchBookbankPayeeFlowStatus" value="#{semmmm001Bean.vendorMasterCriteria.bookbankPayeeFlowStatus}" style="width:160px;">
								                	<f:selectItems value="#{semmmm001Bean.bookbankPayeeFlowStatusList}" />
								                </h:selectOneMenu>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							
							<!-- button search + clear -->
							<h:panelGrid columns="2" id="groupSearchButton" >
								<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
								action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult,panelWrapper_tree,panelWrapper_content,oppContent,pnlSubVendor" >
									<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="searchTodoList" />
								</a4j:commandButton>
								
								<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           	 	action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult,panelWrapper_tree,panelWrapper_content,oppContent">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
				           		</a4j:commandButton>
							</h:panelGrid>
					</rich:panel>
					
					<h:panelGrid id="panelWrapper_content" style="width:100%;height:100%; border:1 #ececec solid;margin:0 auto; padding:0px; vertical-align:top;align:top;">
				<!-- button other -->
				<!-- div style="clear:both; height:10px;"></div -->
				<h:panelGroup style="height:100%; margin:0 auto; padding:0px; vertical-align:top;align:top;">
						
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco002Bean.renderedMsgFormSearch}">
						<f:facet name="header">
							<h:outputText value="Entered Data Status:"></h:outputText>
						</f:facet>
						<f:facet name="errorMarker">
							<h:graphicImage value="images/error.gif" />  
						</f:facet>
					</rich:messages>
				        
				
				<!-- button other -->
					<h:panelGrid id="groupResultButton">
						<h:panelGrid columns="8" id="groupResultButton1">
							<a4j:commandButton id="btnNewVendor" value="New Vendor" styleClass="rich-button" 
			           		disabled="#{semmmm001Bean.disableBtnNewVendor}" style="padding-left: 5px; width:77px;"
							action="#{navAction.navi}" reRender="oppContent, txtNavProgram">
							    <a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doNewVendorClearContent" />
								<a4j:actionparam name="mode" value="New" />
								<a4j:actionparam name="headType" value="Vendor" />
								<a4j:actionparam name="contractNoParam" value="" />
								<a4j:actionparam name="vendorIdParam" value="" />
								<a4j:actionparam name="actionId" value="PAGE_TODO_STF_NEW" />
							</a4j:commandButton>
							
							
							<a4j:commandButton id="btnExpBtchVD" value="Export Vendor" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchVD}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, dtbResultList, pnlShowReportVendorExcel,groupResultButton,panelWrapper_tree,panelWrapper_content"
			           	 	style="padding-left: 5px; width:85px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VD" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngVD" value="Send Vendor to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerVD}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="oppContent, frmResultSearch, dtbResultList,groupResultButton,panelWrapper_tree,panelWrapper_content"
							oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
							style="padding-left: 5px; width:135px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_VD" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpBtchVB" value="Export Bookbank" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchVB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="frmResultSearch, dtbResultList, pnlShowReportVendorBookbankExcel,groupResultButton,panelWrapper_tree,panelWrapper_content"
			           	 	style="padding-left: 5px; width:95px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VB" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngVB" value="Send  Bookbank to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerVB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
			           	 	reRender="oppContent, frmResultSearch, dtbResultList,groupResultButton,panelWrapper_tree,panelWrapper_content" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:149px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_VB" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		
			           		<a4j:commandButton id="btnExpBtchPY" value="Export Payee" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchPY}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, dtbResultList, pnlShowReportPayeeToLeaderExcel,groupResultButton,panelWrapper_tree,panelWrapper_content"
			           	 	style="padding-left: 5px; width:78px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PY" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnSndMngPY" value="Send Payee to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerPY}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, dtbResultList,groupResultButton,panelWrapper_tree,panelWrapper_content" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:129px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_PY" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnExpBtchPB" value="Export BookBank Payee" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnExportBatchPB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="frmResultSearch, dtbResultList, pnlShowReportPayeeBookbankToLeaderExcel,groupResultButton,panelWrapper_tree,panelWrapper_content"
			           	 	style="padding-left: 5px; width:128px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PB" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           	</h:panelGrid>
			           	<h:panelGrid columns="5" id="groupResultButton2">
		           			
			           		<a4j:commandButton id="btnSndMngPB" value="Send BookBank Payee to Manager" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSendManagerPB}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, dtbResultList,groupResultButton2,panelWrapper_tree,panelWrapper_content" 
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
			           	 	style="padding-left: 5px; width:179px;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="SEND_MANAGER_PB" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnDelete" value="#{jspMsg['btn.delete']}" styleClass="rich-button" 
			           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnDelete}" 
			           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			           	 	reRender="oppContent, frmResultSearch, dtbResultList,groupResultButton2,panelWrapper_tree,panelWrapper_content"
			           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
				           		<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
								<a4j:actionparam name="btnEvent" value="DELETE" />
								<a4j:actionparam name="todoFlag" value="Y" />
			           		</a4j:commandButton>
			           	</h:panelGrid>
					</h:panelGrid>
					
						
						
						<!-- select Team -->
						
						<rich:spacer height="18px"></rich:spacer>
						<!-- data Table -->
						<h:panelGrid  width="30%">
		                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbarIn80" >
		                    	<f:facet name="header"><h:outputText value="#{jspMsg['header.result.name']}"/></f:facet>
							
								<div align="center">
			                    	<h:outputLabel style="color:red;size:20px" value="#{semmmm001Bean.msgDataNotFound}" rendered="#{semmmm001Bean.renderedMsgDataNotFound}" />
			                    </div>
			                    
			                    
		                        <rich:dataTable id="dtbResultList" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.vendorMasterResultList}" var="resultObj"
								reRender="dtbResultList" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column style="vertical-align:middle;">
										<f:facet name="header">
											<h:selectBooleanCheckbox value="#{semmmm001Bean.chkSelAll}" id="vendorMasterSelectedAll" style="width: 20px">
												<a4j:support event="onclick" 
												action="#{semmmm001Action.selectAllRow}" 
												reRender="dtbResultList, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
														  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete" />
											</h:selectBooleanCheckbox>
										</f:facet>
										
										<div align="center" style="">
											<h:selectBooleanCheckbox id="vendorMasterSelected" value="#{resultObj.checkBox}"
											rendered="#{resultObj.dataObj.renderColumn}">
												<a4j:support event="onclick" action="#{semmmm001Action.selectRow}" 
												reRender="dtbResultList, btnNewVendor, btnExpBtchVD, btnSndMngVD, btnExpBtchVB, btnSndMngVB, 
														  btnExpBtchPY, btnSndMngPY, btnExpBtchPB, btnSndMngPB, btnDelete" />
											</h:selectBooleanCheckbox>
										</div>
									</rich:column>
									
									<rich:column style="" title="" sortBy="#{resultObj.dataObj.actionTypeDisplay}" rendered="true">
													<f:facet name="header">
														<h:outputText value="Action" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.actionTypeDisplay}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.otherStatus}" rendered="true">
													<f:facet name="header">
														<h:outputText value="Status" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.otherStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.allStatus}" rendered="false">
													<f:facet name="header">
														<h:outputText value="All Status" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.allStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.vendorStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorFlowStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width: 180px;">
														<h:outputText value="#{resultObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column title="#{resultObj.dataObj.vendorCode}" sortBy="#{resultObj.dataObj.vendorCode}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<a4j:commandLink id="hlkVendorCode" value="#{resultObj.dataObj.vendorCode}" 
														action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
															<a4j:actionparam name="navModule" value="mm" />
															<a4j:actionparam name="navProgram" value="#{resultObj.dataObj.menuUrl}" />
															<a4j:actionparam name="moduleWithNavi" value="mm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
															<a4j:actionparam name="methodWithNavi" value="doForwardFromTodoPage" />
															<a4j:actionparam name="mode" value="Edit" />
															<a4j:actionparam name="headType" value="Vendor" />
															<a4j:actionparam name="contractNoParam" value="#{resultObj.dataObj.contractNo}" />
															<a4j:actionparam name="vendorIdParam" value="#{resultObj.dataObj.vendorId}" />
															<a4j:actionparam name="bookbankIdParam" value="#{resultObj.dataObj.bookbankId}" />
															<a4j:actionparam name="vendorBookbankIdParam" value="#{resultObj.dataObj.bookbankId}" />
															<a4j:actionparam name="payeeIdParam" value="#{resultObj.dataObj.payeeId}" />
															<a4j:actionparam name="payeeBookbankIdParam" value="#{resultObj.dataObj.payeeBookbankId}" />
															<a4j:actionparam name="bookbankPayeeIdParam" value="#{resultObj.dataObj.payeeBookbankId}" />
															<a4j:actionparam name="actionType" value="#{resultObj.dataObj.actionType}" />
															<a4j:actionparam name="vendorMapPayeeIdParam" value="#{resultObj.dataObj.vendorMapPayeeId}" />
															<a4j:actionparam name="navProgramBack" value="SEMMMM001-0" />
															<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
															<a4j:actionparam name="methodWithNaviBack" value="doBackwardFromTodoPage" />
															<a4j:actionparam name="navModuleBack" value="mm" />
															<a4j:actionparam name="backOtherPageFlag" value="Y" />
															<a4j:actionparam name="todoManagerFlag" value="N" />
															<a4j:actionparam name="actionId" value="PAGE_TODO_STF_VIEW" />
														</a4j:commandLink>
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:150px;">
														<h:outputText value="#{resultObj.dataObj.vendorName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.idCard}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.citizen.id.and.taxid']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.idCard}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.taxId}" rendered="false">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.taxId}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBranchNo}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.branch']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.vendorBranchNo}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractType}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.type']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width:100px;">
														<h:outputText value="#{resultObj.dataObj.contractType}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractNo}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{resultObj.dataObj.contractNo}" 
															oncomplete="showViewSiteInfoPopup()"
															action="#{navAction.navi}" >
															<a4j:actionparam name="navModule" value="mm" />
															<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
															<a4j:actionparam name="moduleWithNavi" value="common" />
															<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
															<a4j:actionparam name="methodWithNavi" value="initPopup" />
															<a4j:actionparam name="rowId" value="#{resultObj.dataObj.siteInfoId}" />
														</a4j:commandLink>
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractOldNo}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.contractOldNo}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.expenseType}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.expenseType}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.contractStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.networkStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.networkStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractEffectiveDt}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.contracteffectivedt']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.contractEffectiveDtStr}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.contractExpireDt}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.contractexpiredt']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.contractExpireDtStr}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationId}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.locationId}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationCode}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.locationCode}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.locationName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.location.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:120px;">
														<h:outputText value="#{resultObj.dataObj.locationName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBlockStatus}"  rendered="false">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorBatch}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.vendor.batch']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.vendorBatch}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column title="" sortBy="#{resultObj.dataObj.bankName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:150px;">
														<h:outputText value="#{resultObj.dataObj.bankName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.accountNo}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.accountNo}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.accountName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:120px;">
														<h:outputText value="#{resultObj.dataObj.accountName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.bookbankStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankFlowStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width: 180px;">
														<h:outputText value="#{resultObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankBatch}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.batch']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.bookbankBatch}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeId}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.payeeId}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:120px;">
														<h:outputText value="#{resultObj.dataObj.payeeName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="">
														<h:outputText value="#{resultObj.dataObj.payeeStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeFlowStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width: 180px;">
														<h:outputText value="#{resultObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBatch}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.batch']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.payeeBatch}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBankName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:120px;">
														<h:outputText value="#{resultObj.dataObj.payeeBankName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeAccountNo}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeAccountName}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="left" style="width:120px;">
														<h:outputText value="#{resultObj.dataObj.payeeAccountName}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankPayeeStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.payeeBookbankFlowStatus}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width: 180px;">
														<h:outputText value="#{resultObj.dataObj.payeeBookbankFlowStatus}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.bookbankPayeeBatch}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.bookbank.payee.batch']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.bookbankPayeeBatch}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.lotNo}"   rendered="false">
													<f:facet name="header">
														<h:outputText value="Lot No" styleClass="contentform"/>
													</f:facet>
													
													<div align="center">
														<h:outputText value="#{resultObj.dataObj.lotNo}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.remark}">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width:580px;"/>
													</f:facet>
													
													<div align="left" style="width:580px;">
														<h:outputText value="#{resultObj.dataObj.remark}" styleClass="contentform"  />
													</div>
												</rich:column>
												
												<rich:column style="" title="" sortBy="#{resultObj.dataObj.vendorEffectiveDt}" rendered="false">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.effective']}" styleClass="contentform"/>
													</f:facet>
													
													<div align="center" style="width:100px;">
														<h:outputText value="#{resultObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
													</div>
												</rich:column>
									
									<!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmmm001Bean.vendorMasterResultList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="39">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbResultList"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllResultList" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbResultList"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
									
								</rich:dataTable>
		                	</rich:panel>
		                </h:panelGrid>
					</h:panelGroup>
					
					
					
			
				<!--END  rigth panel -->
			</h:panelGrid>	
					</td>
				</tr>
			</table>
			
		</a4j:form>
	
	</rich:panel>
	
	<a4j:form id="frmShowReportExcel_">
	
					<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportExcel}" />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
							
					<h:panelGrid id="pnlShowReportVendorExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorToLeader}" />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorBookbankExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportVendorBookbankExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportPayeeToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeBookbankToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcel_:bthShowReportPayeeBookbankToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
		
	</a4j:form>
</h:panelGrid>
<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>