<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm002" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.todolist']} Manager"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm002Bean.renderedMsgFormSearch}">
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
											<h:outputText value="#{jspMsg['label.toDoList']} Manager" />
									</f:facet>
								<!-- << header left content -->
								
									<rich:simpleTogglePanel id="pnlSubVendor"  switchType="client" label="#{jspMsg['label.vendor']}      (#{semmmm002Bean.totalSumVendor})" 
							        opened="#{semmmm002Bean.togPnlVD}" style="width:100%;margin:0 auto; padding:0px;align:top;">
							        	
										<h:dataTable id="vendor" border="0"
											var="obj" value="#{semmmm002Bean.menuTreeVendorList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" >
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm002Action.processSelectedMenu}"
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
									
									<rich:simpleTogglePanel id="pnlSubVendorBookbank"  switchType="client" label="#{jspMsg['label.vendorbookbank']}      (#{semmmm002Bean.totalSumVendorBookbank})" 
							        opened="#{semmmm002Bean.togPnlVB}" style="width:100%;margin:0 auto; padding-top:2px;align:top;">
										<h:dataTable id="vendorBookbank" border="0"
											var="obj" value="#{semmmm002Bean.menuTreeVendorBookbankList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm002Action.processSelectedMenu}"
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
									
									<rich:simpleTogglePanel id="pnlSubPayee"  switchType="client" label="#{jspMsg['label.payee']}      (#{semmmm002Bean.totalSumPayee})" 
							        opened="#{semmmm002Bean.togPnlPY}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="payee" border="0"
											var="obj" value="#{semmmm002Bean.menuTreePayeeList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm002Action.processSelectedMenu}"
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
									
									<rich:simpleTogglePanel id="pnlSubPayeeBookbank"  switchType="client" label="#{jspMsg['label.payeebookbank']}      (#{semmmm002Bean.totalSumPayeeBookbank})" 
							        opened="#{semmmm002Bean.togPnlPB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="payeeBookbank" border="0"
											var="obj" value="#{semmmm002Bean.menuTreePayeeBookbankList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm002Action.processSelectedMenu}"
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
									
									<rich:simpleTogglePanel id="pnlSubAbnormal"  switchType="client" label="#{jspMsg['label.abnormal']}      (#{semmmm002Bean.totalSumAbnormal})" 
							        opened="#{semmmm002Bean.togPnlAB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="abnormal" border="0"
											var="obj" value="#{semmmm002Bean.menuTreeAbnormalList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7 #{obj.dataObj.styleClass}" action="#{semmmm002Action.processSelectedMenu}"
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
									
									
									<rich:simpleTogglePanel id="pnlSubCreateBy"  switchType="client" label="#{jspMsg['label.createby']}      (#{semmmm002Bean.totalSumCreateBy})" 
							        opened="#{semmmm002Bean.togPnlCB}" style="width:100%;margin:0 auto;  padding-top:2px;align:top;">
										<h:dataTable id="CreateBy" border="0"
											var="obj" value="#{semmmm002Bean.menuTreeCreateByList}" 
											cellpadding="0" cellspacing="0" 
											style="margin:0 auto; padding:0px;">
											<h:column>
												<h:panelGroup layout="block" rendered="#{obj.dataObj.renderedFlag}" style="display: table-cell;">
													<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
														<span style="width:195px; white-space:nowrap;">  
													          <a4j:commandLink value="#{obj.dataObj.menuLabel}" styleClass="ms7" action="#{semmmm002Action.processSelectedMenu}"
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
					<td>
						<rich:panel id="pnlSearchCriteria">
							<f:facet name="header"><h:outputText value="#{jspMsg['header.criteria.name']}"/></f:facet>
								<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
									<h:panelGroup>
										<table width="95%">
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.vendor.company']}"/>
												</td>
												<td style="width:30%;">
													<h:selectOneMenu id="searchCompany" value="#{semmmm002Bean.criteriaToDoList.company}" style="width:160px;" onchange="GetCompanyJS();">
					                					<f:selectItems value="#{semmmm002Bean.companyList}" />
					                				</h:selectOneMenu>
					                				
					                				<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
			                                        <rich:spacer width="10"></rich:spacer>
			                                        <h:outputText id="companyDisplay" value="#{semmmm002Bean.criteriaToDoList.company}" styleClass="ms28"/>
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
												<td style="width:30%;">
													<h:selectManyCheckbox value="#{semmmm002Bean.criteriaToDoList.arrRegion}" styleClass="ms7">
											   			<f:selectItems value="#{semmmm002Bean.regionList}" />
											   		</h:selectManyCheckbox>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.type']}"/>
												</td>
												<td width="30%;">
													<rich:spacer width="3"></rich:spacer>
													<h:selectBooleanCheckbox id="chkPicoType" value="#{semmmm002Bean.chkPicoType}" style="vertical-align:bottom;" />
							                		<h:outputText value="PICO" styleClass="ms7" style="margin-left:2px;" />
												</td>
											</tr>
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.vendor.code']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchVendorCode" value="#{semmmm002Bean.criteriaToDoList.vendorCode}" style="width:70%;" />
													
													<a4j:commandButton id="btnCnvrtVendor" value="..." styleClass="rich-button" 
										            action="#{semmmm002Action.initConvertVendor}" reRender="searchVendorCode, mmm002PopUpCommon_convertVendorCode" 
										            style="margin: 0 0 0 5px; height:22px; vertical-align:top;"
										            oncomplete="#{rich:component('mmm002PopUpCommon_convertVendorCode')}.show();">
										            	<a4j:actionparam name="todoFlag" value="T"></a4j:actionparam>
													</a4j:commandButton>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.vendor.or.payee.name']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchPayeeName" value="#{semmmm002Bean.criteriaToDoList.payeeName}" style="width:70%;" />
												</td>
											</tr>
											
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.citizen.id']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchIdCard" value="#{semmmm002Bean.criteriaToDoList.idCard}" size="30" 
													onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="13"/>
													
													<a4j:jsFunction name="checkIdCard" action="#{semmmm002Action.doCheckIdCard}"
														reRender="incContent">
														<a4j:actionparam name="todoFlag" value="T"></a4j:actionparam>
													</a4j:jsFunction>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchTaxId" value="#{semmmm002Bean.criteriaToDoList.taxId}" size="30" 
													onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="13"/>
													
													<a4j:jsFunction name="checkTaxId" action="#{semmmm002Action.doCheckTaxId}"
														reRender="incContent">
														<a4j:actionparam name="todoFlag" value="T"></a4j:actionparam>
													</a4j:jsFunction>
												</td>
											</tr>
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.contract.number']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchContractNo" value="#{semmmm002Bean.criteriaToDoList.contractNo}" size="30" maxlength="30"/>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.site.name']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchSiteName" value="#{semmmm002Bean.criteriaToDoList.siteName}" style="width:70%;"/>
												</td>
											</tr>
											
											
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.account.number']}" styleClass="ms7"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchAccountNo" value="#{semmmm002Bean.criteriaToDoList.accountNo}" size="30" maxlength="30"/>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.account.name']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchAccountName" value="#{semmmm002Bean.criteriaToDoList.accountName}" style="width:70%;" />
												</td>
											</tr>
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.batch.no']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchBatchNo" value="#{semmmm002Bean.criteriaToDoList.batchNo}" size="20" maxlength="30" />
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.create.by']}"/>
												</td>
												<td style="width:30%;">
													<h:inputText id="searchCreateBy" value="#{semmmm002Bean.criteriaToDoList.createBy}" style="width:70%;" />
												</td>
											</tr>
											
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
												</td>
												<td style="width:30%;">
													<h:selectOneMenu id="searchVendorFlowStatus" value="#{semmmm002Bean.criteriaToDoList.vendorFlowStatus}" style="width:160px;">
									                	<f:selectItems value="#{semmmm002Bean.vendorFlowStatusList}" />
									                </h:selectOneMenu>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
												</td>
												<td style="width:30%;">
													<h:selectOneMenu id="searchBookbankFlowStatus" value="#{semmmm002Bean.criteriaToDoList.bookbankFlowStatus}" style="width:160px;">
									                	<f:selectItems value="#{semmmm002Bean.bookbankFlowStatusList}" />
									                </h:selectOneMenu>
												</td>
											</tr>
											
											<tr>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.payee.flow.status']}"/>
												</td>
												<td style="width:30%;">
													<h:selectOneMenu id="searchPayeeFlowStatus" value="#{semmmm002Bean.criteriaToDoList.payeeFlowStatus}" style="width:160px;">
									                	<f:selectItems value="#{semmmm002Bean.payeeFlowStatusList}" />
									                </h:selectOneMenu>
												</td>
												<td style="width:20%; text-align:right;" class="ms7">
													<h:outputText value="#{jspMsg['label.bookbank.payee.flow.status']}"/>
												</td>
												<td style="width:30%;">
													<h:selectOneMenu id="searchBookbankPayeeFlowStatus" value="#{semmmm002Bean.criteriaToDoList.bookbankPayeeFlowStatus}" style="width:160px;">
									                	<f:selectItems value="#{semmmm002Bean.bookbankPayeeFlowStatusList}" />
									                </h:selectOneMenu>
												</td>
											</tr>
										</table>
									</h:panelGroup>
								</h:panelGrid>
								
								<!-- button search + clear -->
								<h:panelGrid columns="2" id="groupSearchButton">
									<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult,panelWrapper_tree,panelWrapper_content,oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="searchTodoList" />
										<a4j:actionparam name="searchFlag" value="Y" ></a4j:actionparam>
										<a4j:actionparam name="searchType" value="SR" ></a4j:actionparam>
									</a4j:commandButton>
									
									<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult,panelWrapper_tree,panelWrapper_content,oppContent">
					           		<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
					           		</a4j:commandButton>
								</h:panelGrid>
						</rich:panel>
						
						<h:panelGrid id="panelWrapper_content" style="height:95%; border:1 #ececec solid;margin:0 auto; padding:0px; vertical-align:top;align:top;">
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
							        
									     <h:panelGrid>
											<!-- button other -->
											<h:panelGrid columns="11" id="groupResultButton1">
												<a4j:commandButton id="btnApproveVendor" value="Approve Vendor" styleClass="rich-button"
												action="#{navAction.navi}" style="padding-left: 0px; width:85px;"
												rendered="#{semmmm002Bean.renderedBtnApproveVendor}"
												disabled="#{semmmm002Bean.disableBtnApproveVendor}" 
												oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;"
												reRender="txtNavProgram, oppContent">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
													<a4j:actionparam name="actionBtnType" value="APPROVE_VENDOR" />
													<a4j:actionparam name="actionType" value="MA" />
													<a4j:actionparam name="btnType" value="VD" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectVendor" value="Reject Vendor" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectVendor}"
								           	 	rendered="#{semmmm002Bean.renderedBtnRejectVendor}" 
								           	 	reRender="oppContent,txtNavProgram" style="padding-left: 0px;width:75px;"
								           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="REJECT_VENDOR" />
													<a4j:actionparam name="actionType" value="MR" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
												
												<a4j:commandButton id="btnSndVendorToMng2" value="Send Vendor To Manager2" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendVendorToMNG2}" 
								           	 	rendered="#{semmmm002Bean.renderedBtnSendVendorToMNG2}" 
								           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
								           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px;width:135px;">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="SEND_VENDOR_TO_MANAGER2" />
													<a4j:actionparam name="reqManager2" value="Y" />
								           		</a4j:commandButton>
								           		
								           		<a4j:commandButton id="btnApproveM2Vendor" value="Manager2 Approve Vendor" styleClass="rich-button"
												action="#{navAction.navi}" style="padding-left: 0px;width:137px;"
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
												disabled="#{semmmm002Bean.disableBtnMNG2ApproveVendor}" 
												rendered="#{semmmm002Bean.renderedBtnMNG2ApproveVendor}" reRender="txtNavProgram, oppContent">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_VENDOR" />
													<a4j:actionparam name="actionType" value="M2A" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectM2Vendor" value="Manager2 Reject Vendor" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnMNG2RejectVendor}" reRender="oppContent,txtNavProgram"
								           	 	rendered="#{semmmm002Bean.renderedBtnMNG2RejectVendor}" style="padding-left: 0px;width:125px;"
								           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_VENDOR" />
													<a4j:actionparam name="actionType" value="M2R" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
								           		
								           		<rich:spacer width="10px"></rich:spacer>
								           		
								           		<a4j:commandButton id="btnApproveBookbank" value="Approve Bookbank" styleClass="rich-button"
												action="#{navAction.navi}" style="padding-left: 0px;width:98px;"
												disabled="#{semmmm002Bean.disableBtnApproveBookbank}" 
												rendered="#{semmmm002Bean.renderedBtnApproveBookbank}" 
												oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;"
												reRender="txtNavProgram, oppContent">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
													<a4j:actionparam name="actionBtnType" value="APPROVE_BOOKBANK" />
													<a4j:actionparam name="actionType" value="MA" />
													<a4j:actionparam name="btnType" value="VB" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectBookbank" value="Reject Bookbank" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectBookbank}" 
								           	 	rendered="#{semmmm002Bean.renderedBtnRejectBookbank}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px;width:85px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="REJECT_BOOKBANK" />
													<a4j:actionparam name="actionType" value="MR" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
												
												<a4j:commandButton id="btnSndBookbankToMng2" value="Send Bookbank To Manager2" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendBookbankToMNG2}" 
								           	 	rendered="#{semmmm002Bean.renderedBtnSendBookbankToMNG2}"
								           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
								           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px;width:147px;">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="SEND_BOOKBANK_TO_MANAGER2" />
													<a4j:actionparam name="reqManager2" value="Y" />
								           		</a4j:commandButton>
								           		
								           		<a4j:commandButton id="btnApproveM2Bookbank" value="Manager2 Approve Bookbank" styleClass="rich-button"
												action="#{navAction.navi}" 
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
												disabled="#{semmmm002Bean.disableBtnMNG2ApproveBookbank}" reRender="txtNavProgram, oppContent"
												style="padding-left: 0px;width:148px;"
												rendered="#{semmmm002Bean.renderedBtnMNG2ApproveBookbank}" >
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_BOOKBANK" />
													<a4j:actionparam name="actionType" value="M2A" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectM2Bookbank" value="Manager2 Reject Bookbank" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnMNG2RejectBookbank}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px;width:137px;" rendered="#{semmmm002Bean.renderedBtnMNG2RejectBookbank}" 
								           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_BOOKBANK" />
													<a4j:actionparam name="actionType" value="M2R" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
											</h:panelGrid>
											
											<h:panelGrid columns="10" id="groupResultButton2">
												<a4j:commandButton id="btnApprovePayee" value="Approve Payee" styleClass="rich-button"
												action="#{navAction.navi}" 
												disabled="#{semmmm002Bean.disableBtnApprovePayee}" reRender="txtNavProgram, oppContent"
												rendered="#{semmmm002Bean.renderedBtnApprovePayee}" style="padding-left: 0px; width:80px;"
												oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
													<a4j:actionparam name="actionBtnType" value="APPROVE_PAYEE" />
													<a4j:actionparam name="actionType" value="MA" />
													<a4j:actionparam name="btnType" value="PY" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectPayee" value="Reject Payee" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectPayee}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px; width:67px;" rendered="#{semmmm002Bean.renderedBtnRejectPayee}" 
								           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="REJECT_PAYEE" />
													<a4j:actionparam name="actionType" value="MR" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
												
												<a4j:commandButton id="btnSndPayeeToMng2" value="Send Payee To Manager2" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendPayeeToMNG2}" 
								           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
								           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px; width:130px;"
								           	 	rendered="#{semmmm002Bean.renderedBtnSendPayeeToMNG2}">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="SEND_PAYEE_TO_MANAGER2" />
													<a4j:actionparam name="reqManager2" value="Y" />
								           		</a4j:commandButton>
								           		
								           		<a4j:commandButton id="btnApproveM2Payee" value="Manager2 Approve Payee" styleClass="rich-button"
												action="#{navAction.navi}" 
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
												disabled="#{semmmm002Bean.disableBtnMNG2ApprovePayee}" reRender="txtNavProgram, oppContent"
												style="padding-left: 0px; width:130px;"
												rendered="#{semmmm002Bean.renderedBtnMNG2ApprovePayee}" >
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_PAYEE" />
													<a4j:actionparam name="actionType" value="M2A" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectM2Payee" value="Manager2 Reject Payee" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnMNG2RejectPayee}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px; width:120px;" 
								           	 	rendered="#{semmmm002Bean.renderedBtnMNG2RejectPayee}" 
								           	 	oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_PAYEE" />
													<a4j:actionparam name="actionType" value="M2R" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
								           		
								           		<a4j:commandButton id="btnApprovePayeeBookbank" value="Approve BookBank Payee" styleClass="rich-button"
												action="#{navAction.navi}" 
												disabled="#{semmmm002Bean.disableBtnApprovePayeeBookbank}" reRender="txtNavProgram, oppContent"
												style="padding-left: 0px; width:130px;"
												rendered="#{semmmm002Bean.renderedBtnApprovePayeeBookbank}" 
												oncomplete="#{rich:component('mmm002PopUpCommon_controllerBtnSave')}.show(); return false;">
													<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
											<a4j:actionparam name="methodWithNavi" value="doValidateApprove" />
											<a4j:actionparam name="actionBtnType" value="APPROVE_PAYEE_BOOKBANK" />
											<a4j:actionparam name="actionType" value="MA" />
											<a4j:actionparam name="btnType" value="PB" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectPayeeBookbank" value="Reject BookBank Payee" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnRejectPayeeBookbank}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px; width:120px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();"
								           	 	rendered="#{semmmm002Bean.renderedBtnRejectPayeeBookbank}">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="REJECT_PAYEE_BOOKBANK" />
													<a4j:actionparam name="actionType" value="MR" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
												
												<a4j:commandButton id="btnSndPayeeBookbankToMng2" value="Send BookBank Payee To Manager2" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnSendPayeeBookbankToMNG2}" 
								           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
								           	 	reRender="txtNavProgram, oppContent" style="padding-left: 0px; width:180px;"
								           	 	rendered="#{semmmm002Bean.renderedBtnSendPayeeBookbankToMNG2}">
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="SEND_PAYEE_BOOKBANK_TO_MANAGER2" />
													<a4j:actionparam name="reqManager2" value="Y" />
								           		</a4j:commandButton>
								           		
								           		<a4j:commandButton id="btnApproveM2PayeeBookbank" value="Manager2 Approve BookBank Payee" styleClass="rich-button"
												action="#{navAction.navi}" 
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
												disabled="#{semmmm002Bean.disableBtnMNG2ApprovePayeeBookbank}" reRender="txtNavProgram, oppContent"
												style="padding-left: 0px; width:180px;"
												rendered="#{semmmm002Bean.renderedBtnMNG2ApprovePayeeBookbank}" >
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
													<a4j:actionparam name="actionBtnType" value="MNG2_APPROVE_PAYEE_BOOKBANK" />
													<a4j:actionparam name="actionType" value="M2A" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnRejectM2PayeeBookbank" value="Manager2 Reject BookBank Payee" styleClass="rich-button" 
								           	 	action="#{navAction.navi}" disabled="#{semmmm002Bean.disableBtnMNG2RejectPayeeBookbank}" reRender="oppContent,txtNavProgram"
								           	 	style="padding-left: 0px; width:170px;" oncomplete="#{rich:component('mmm002PopUpCommon_RejectTodolist')}.show();"
								           	 	rendered="#{semmmm002Bean.renderedBtnMNG2RejectPayeeBookbank}" >
									           		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
													<a4j:actionparam name="methodWithNavi" value="initReject" />
													<a4j:actionparam name="actionBtnType" value="MNG2_REJECT_PAYEE_BOOKBANK" />
													<a4j:actionparam name="actionType" value="M2R" />
													<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
								           		</a4j:commandButton>
											</h:panelGrid>
										</h:panelGrid>
								
									
									
									<!-- select Team -->
									<h:panelGrid id="selectTeamPanel" style="width:95%;border:1 #ececec solid;">
									
									<rich:panel id="pnlSelectTeam" style=" width:95%; border:1 ececec solid;margin:0 auto; padding:0px;background-color:d0d0d0;" rendered="false">
										
										<h:outputText value="#{jspMsg['label.team']} : " styleClass="ms7" />
										
											<h:selectOneMenu id="mmm0020_teamName" value="#{semmmm002Bean.criteriaToDoList.teamId}" styleClass="ms7">
												<f:selectItems value="#{semmmm002Bean.teamList}" />
											</h:selectOneMenu>
											
											<rich:spacer width="10"></rich:spacer>
											
											<a4j:commandButton id="mmmm0020_btnSelectTeam" value="Submit" styleClass="rich-button"
											action="#{semmmm002Action.doSelectTeam}" disabled="#{semmsa001Bean.disabledChecked}" reRender="selectTeamPanel">
												<a4j:actionparam name="paramPage" value="msa001-2" />
											</a4j:commandButton>
									</rich:panel>
									
									<rich:spacer height="18px"></rich:spacer>
									<!-- data Table -->
									<h:panelGrid  width="30%">
					                    <rich:panel id="pnlSearchTeamResult" styleClass="sem_autoScrollbarIn80" >
					                    	<f:facet name="header"><h:outputText value="#{jspMsg['header.result.team']}"/></f:facet>
											
											<rich:dataTable id="dtbTeamResultList" width="100%" 
												cellpadding="0" cellspacing="0" border="0" 
												value="#{semmmm002Bean.vendorSelectedTeamList}" var="resultObj"
												reRender="dtbResultList" rows="#{semmmm002Bean.rowPerPage}"
												rowClasses="cur" styleClass="contentform" rowKeyVar="row">
													<rich:column title="#{resultObj.dataObj.teamName}" sortBy="#{resultObj.dataObj.teamName}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.team']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<h:outputText value="#{resultObj.dataObj.teamName}" styleClass="contentform"  />
															</div>
													</rich:column>
													
													<rich:column title="#{resultObj.dataObj.createBy}" sortBy="#{resultObj.dataObj.createBy}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.user']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<h:outputText value="#{resultObj.dataObj.createBy}" styleClass="contentform"  />
															</div>
													</rich:column>
													
													<rich:column title="#{resultObj.dataObj.vendorTotal}" sortBy="#{resultObj.dataObj.vendorTotal}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.vendor']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																
																<a4j:commandLink value="#{resultObj.dataObj.vendorTotal}" styleClass="contentform" 
																action="#{semmmm002Action.selectedTeamController}"
															          reRender="selectTeamPanel,pnlSearchResult" rendered="#{resultObj.dataObj.vendorTotal != '0'}">
															          	<a4j:actionparam name="createById" value="#{resultObj.dataObj.createById}" />
																			
																		<a4j:actionparam name="type" value="VD" />
															    </a4j:commandLink>
																
																<h:outputText value="#{resultObj.dataObj.vendorTotal}" styleClass="contentform" rendered="#{resultObj.dataObj.vendorTotal == '0'}" />
															</div>
													</rich:column>	
													
													<rich:column title="#{resultObj.dataObj.bookbankTotal}" sortBy="#{resultObj.dataObj.bookbankTotal}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.bookbank']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<a4j:commandLink value="#{resultObj.dataObj.bookbankTotal}" styleClass="contentform" 
																action="#{semmmm002Action.selectedTeamController}"
															          reRender="selectTeamPanel,pnlSearchResult" rendered="#{resultObj.dataObj.bookbankTotal != '0'}">
															          	<a4j:actionparam name="createById" value="#{resultObj.dataObj.createById}" />
																			
																		<a4j:actionparam name="type" value="VB" />
															          </a4j:commandLink>
																
																<h:outputText value="#{resultObj.dataObj.bookbankTotal}" styleClass="contentform" rendered="#{resultObj.dataObj.bookbankTotal == '0'}" />
																
															</div>
													</rich:column>
													<rich:column title="#{resultObj.dataObj.payeeTotal}" sortBy="#{resultObj.dataObj.payeeTotal}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.payee']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<a4j:commandLink value="#{resultObj.dataObj.payeeTotal}" styleClass="contentform" 
																action="#{semmmm002Action.selectedTeamController}"
															          reRender="selectTeamPanel,pnlSearchResult" rendered="#{resultObj.dataObj.payeeTotal != '0'}">
															          	<a4j:actionparam name="createById" value="#{resultObj.dataObj.createById}" />
																			
																		<a4j:actionparam name="type" value="PY" />
															          </a4j:commandLink>
																
																<h:outputText value="#{resultObj.dataObj.payeeTotal}" styleClass="contentform" rendered="#{resultObj.dataObj.payeeTotal == '0'}" />
																
															</div>
													</rich:column>
													<rich:column title="#{resultObj.dataObj.bookbankPayeeTotal}" sortBy="#{resultObj.dataObj.bookbankPayeeTotal}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.bookbankpayee']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<a4j:commandLink value="#{resultObj.dataObj.bookbankPayeeTotal}" styleClass="contentform" 
																action="#{semmmm002Action.selectedTeamController}"
															          reRender="selectTeamPanel,pnlSearchResult" rendered="#{resultObj.dataObj.bookbankPayeeTotal != '0'}">
															          	<a4j:actionparam name="createById" value="#{resultObj.dataObj.createById}" />
																			
																		<a4j:actionparam name="type" value="PB" />
															          </a4j:commandLink>
																
																<h:outputText value="#{resultObj.dataObj.bookbankPayeeTotal}" styleClass="contentform" rendered="#{resultObj.dataObj.bookbankPayeeTotal == '0'}" />
																
															</div>
													</rich:column>
													<rich:column title="#{resultObj.dataObj.allTotal}" sortBy="#{resultObj.dataObj.allTotal}">
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.result']}" styleClass="contentform"/>
															</f:facet>
															
															<div align="center">
																<a4j:commandLink value="#{resultObj.dataObj.allTotal}" styleClass="contentform" 
																action="#{semmmm002Action.selectedTeamController}"
															          reRender="selectTeamPanel,pnlSearchResult" rendered="#{resultObj.dataObj.allTotal != '0'}">
															          	<a4j:actionparam name="createById" value="#{resultObj.dataObj.createById}" />
																			
																		<a4j:actionparam name="type" value="ALL" />
															          </a4j:commandLink>
																
																<h:outputText value="#{resultObj.dataObj.allTotal}" styleClass="contentform" rendered="#{resultObj.dataObj.allTotal == '0'}" />
															</div>
													</rich:column>	
													
													<!-- footer -->
														<f:facet name="footer">
															<rich:columnGroup>
																<!-- > 1 -->
																<rich:column colspan="3">
																	<h:outputFormat value="#{msg['message.totalRecords']}">
																		<f:param value="#{fn:length(semmmm002Bean.vendorSelectedTeamList)}"></f:param>
																	</h:outputFormat>
																</rich:column>
																<!-- > 2 -->
																<rich:column colspan="4">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dtbTeamResultList"
																		maxPages="#{semmmm002Bean.rowPerPage}" selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="dataScrllTeamResultList" style="background-color: #cccccc;"
																		page="#{semmmm002Bean.scrollerPage}">
																	<a4j:support event="onclick" reRender="dtbTeamResultList"></a4j:support>
																	</rich:datascroller>
																</rich:column>
															</rich:columnGroup>
														</f:facet>
														<!-- footer -->						
												</rich:dataTable>
						           		</rich:panel>
						           	</h:panelGrid>
									
									</h:panelGrid>
									<rich:spacer height="18px"></rich:spacer>
									<!-- data Table -->
									<h:panelGrid  width="30%">
					                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbarIn80" >
					                    	<f:facet name="header"><h:outputText value="#{jspMsg['header.result.name']}"/></f:facet>
										
											<div align="center">
						                    	<h:outputLabel style="color:red;size:20px" value="#{semmmm002Bean.msgDataNotFound}" rendered="#{semmmm002Bean.renderedMsgDataNotFound}" />
						                    </div>
						                    
						                    <rich:dataTable id="dtbResultList" width="100%" 
											cellpadding="0" cellspacing="0" border="0" 
											value="#{semmmm002Bean.vendorMasterResultList}" var="resultObj"
											reRender="dtbResultList" rows="#{semmmm002Bean.rowPerPage}"
											rowClasses="cur" styleClass="contentform" rowKeyVar="row">
												
												<rich:column style="" title="">
													<f:facet name="header">
														<h:selectBooleanCheckbox value="#{semmmm002Bean.chkSelAll}" style="width: 20px">
															<a4j:support event="onclick" 
															action="#{semmmm002Action.selectAllRow}" 
															reRender="dtbResultList,btnApproveVendor,btnSndVendorToMng2,btnRejectVendor,btnApproveM2Vendor,btnRejectM2Vendor,
															btnApproveBookbank,btnSndBookbankToMng2,btnRejectBookbank,btnApproveM2Bookbank,btnRejectM2Bookbank,
															btnApprovePayee,btnSndPayeeToMng2,btnRejectPayee,btnApproveM2Payee,btnRejectM2Payee,
															btnApprovePayeeBookbank,btnSndPayeeBookbankToMng2,btnRejectPayeeBookbank,
															btnApproveM2PayeeBookbank,btnRejectM2PayeeBookbank" />
														</h:selectBooleanCheckbox>
													</f:facet>
													
													<div align="center" style="">
														<h:selectBooleanCheckbox id="dtbResultSelected" value="#{resultObj.checkBox}"
														rendered="#{resultObj.dataObj.renderColumn}">
															<a4j:support event="onclick" action="#{semmmm002Action.selectRow}" 
															reRender="dtbResultList,btnApproveVendor,btnSndVendorToMng2,btnRejectVendor,btnApproveM2Vendor,btnRejectM2Vendor,
															btnApproveBookbank,btnSndBookbankToMng2,btnRejectBookbank,btnApproveM2Bookbank,btnRejectM2Bookbank,
															btnApprovePayee,btnSndPayeeToMng2,btnRejectPayee,btnApproveM2Payee,btnRejectM2Payee,
															btnApprovePayeeBookbank,btnSndPayeeBookbankToMng2,btnRejectPayeeBookbank,
															btnApproveM2PayeeBookbank,btnRejectM2PayeeBookbank,oppContent" />
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
															<a4j:actionparam name="navProgramBack" value="SEMMMM002-0" />
															<a4j:actionparam name="actionWithNaviBack" value="SEMMMM001"/>
															<a4j:actionparam name="methodWithNaviBack" value="doBackwardFromTodoPage" />
															<a4j:actionparam name="navModuleBack" value="mm" />
															<a4j:actionparam name="backOtherPageFlag" value="Y" />
															<a4j:actionparam name="todoManagerFlag" value="Y" />
															<a4j:actionparam name="actionId" value="PAGE_TODO_MNG_VIEW" />
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
															action="#{navAction.navi}" 
															title="#{resultObj.dataObj.siteInfoId}">
															<a4j:actionparam name="navModule" value="mm" />
															<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
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
																<f:param value="#{fn:length(semmmm002Bean.vendorMasterResultList)}"></f:param>
															</h:outputFormat>
														</rich:column>
														<!-- > 2 -->
														<rich:column colspan="39">
															<rich:datascroller immediate="true" rendered="true" align="left" for="dtbResultList"
																maxPages="#{semmmm002Bean.rowPerPage}" selectedStyleClass="selectScroll"
																stepControls="hide" fastControls="auto" boundaryControls="auto" 
																id="dataScrllResultList" style="background-color: #cccccc;"
																page="#{semmmm002Bean.scrollerPage}">
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
</h:panelGrid>
<a4j:include viewId="../../pages/mm/semmmm002PopupCommon.jsp"/>