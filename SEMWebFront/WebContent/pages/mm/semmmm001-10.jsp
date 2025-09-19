<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.sap.name']}"/></f:facet>	
	
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
		
		<a4j:form id="frmContractInfo">
			<!-- group[1] >> -->
			
			<!-- group[1] << -->
			
			<rich:spacer rendered="#{semmmm001Bean.visiblePnlContractInfo}" />
			
			<!-- group[2] >> -->
			<!-- info data table panel vendor from sap -->
			<h:panelGrid id="pnlChangeVendorInfo" width="98%" style="border:solid 1px gray;">
			
				<rich:panel id="vendorChangeInfoSapSap">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']} (#{jspMsg['header.vendor.sap']})"/></f:facet>
				
					<!-- vendor info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.expense.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="vendorInfoSapExpenseType" value="#{semmmm001Bean.vendorInfoSap.expenseType}" 
										disabled="#{semmmm001Bean.disableContent}" style="">
		                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSapVendorType" value="#{semmmm001Bean.vendorInfoSap.vendorType}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;">
		                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.block.flag']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSapVendorBlockStatus" value="#{semmmm001Bean.vendorInfoSap.vendorBlockStatus}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:80px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.code']}"/>
									</td>
									<td colspan="3">
										<h:inputText id="vendorInfoSapVendorCode" value="#{semmmm001Bean.vendorInfoSap.vendorCode}" 
										disabled="#{semmmm001Bean.disableContent}" style="width:50%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="vendorInfoSapVendorName1" value="#{semmmm001Bean.vendorInfoSap.vendorName1}" 
		                				disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSapVendorName2" value="#{semmmm001Bean.vendorInfoSap.vendorName2}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSapVendorName3" value="#{semmmm001Bean.vendorInfoSap.vendorName3}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSapVendorName4" value="#{semmmm001Bean.vendorInfoSap.vendorName4}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSapIdCard" value="#{semmmm001Bean.vendorInfoSap.idCard}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
										style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSapTaxId" value="#{semmmm001Bean.vendorInfoSap.taxId}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.hq.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSapHqBranch" value="#{semmmm001Bean.vendorInfoSap.hqFlag}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" style="width:40%;">
		                					<f:selectItems value="#{semmmm001Bean.bankBranchList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" />
		                				<h:inputText id="vendorInfoSapBankbranchNo" value="#{semmmm001Bean.vendorInfoSap.branchNo}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"  
										maxlength="20" style="width:40px;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSapVendorStatus" value="#{semmmm001Bean.vendorInfoSap.vendorStatus}" 
										disabled="#{semmmm001Bean.disableContent}" style="">
		                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button history -->
					<h:panelGrid id="groupHistoryChangeSapButton" width="100%">
						<h:panelGroup>
							<table width="98%">
								<tr>
									<td style="width:100%; text-align:right;">
										<a4j:commandButton id="btnVendorHistory" value="Vendor History" 
										styleClass="rich-button" rendered="false"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doVendorHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoSap.vendorId}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				
				
					<!-- >> tab panel -->
					<h:panelGrid style="width:98%;">
						<rich:tabPanel id="panelChangeSapTab" selectedTab="#{semmmm001Bean.selectedSapTab}" switchType="client" style="width:100%;">
							<rich:tab label="#{jspMsg['header.vendor.address']}" id="sapTab0" onlabelclick="setTabSapNo0();">
								<a4j:jsFunction name="setTabSapNo0" action="#{navAction.navi}" 
						         reRender="panelSapTab, sapTab0, frmContractInfo">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="sapTab0"/>
				        			<a4j:actionparam  name="sapFlag" value="Y"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_Sap_incTab0"  viewId="../../pages/mm/semmmm001tab0sap.jsp" />
							</rich:tab>
							
							<rich:tab label="#{jspMsg['header.withholder.address']}" id="sapTab6" onlabelclick="setTabSapNo6();">
								<a4j:jsFunction name="setTabSapNo6" action="#{navAction.navi}" 
						         reRender="panelSapTab, sapTab6, frmContractInfo">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="sapTab6"/>
				        			<a4j:actionparam  name="sapFlag" value="Y"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_Sap_incTab6" viewId="../../pages/mm/semmmm001tab6sap.jsp" />
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
				
				
				<!-- vendor info panel (compare content)from sem >> -->
				<rich:panel id="vendorChangeInfoSem">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']} (#{jspMsg['header.vendor.sem']})"/></f:facet>
				
					<!-- vendor info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.expense.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="vendorInfoSemExpenseType" value="#{semmmm001Bean.vendorInfoSem.expenseType}" 
										disabled="#{semmmm001Bean.viewMode}" style="">
		                					<f:selectItems value="#{semmmm001Bean.expenseTypeSemList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSemVendorType" value="#{semmmm001Bean.vendorInfoSem.vendorType}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;">
		                					<f:selectItems value="#{semmmm001Bean.vendorTypeSemList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.block.flag']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSemVendorBlockStatus" value="#{semmmm001Bean.vendorInfoSem.vendorBlockStatus}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:80px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusSemList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.code']}"/>
									</td>
									<td colspan="3">
										<h:inputText id="vendorInfoSemVendorCode" value="#{semmmm001Bean.vendorInfoSem.vendorCode}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:50%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="vendorInfoSemVendorName1" value="#{semmmm001Bean.vendorInfoSem.vendorName1}" 
		                				disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSemVendorName2" value="#{semmmm001Bean.vendorInfoSem.vendorName2}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSemVendorName3" value="#{semmmm001Bean.vendorInfoSem.vendorName3}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSemVendorName4" value="#{semmmm001Bean.vendorInfoSem.vendorName4}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSemIdCard" value="#{semmmm001Bean.vendorInfoSem.idCard}" 
										disabled="#{semmmm001Bean.viewMode}" 
										style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoSemTaxId" value="#{semmmm001Bean.vendorInfoSem.taxId}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.hq.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSemHqBranch" value="#{semmmm001Bean.vendorInfoSem.hqFlag}" 
										disabled="#{semmmm001Bean.viewMode}" style="width:40%;">
		                					<f:selectItems value="#{semmmm001Bean.bankBranchSemList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" />
		                				<h:inputText id="vendorInfoSemBankbranchNo" value="#{semmmm001Bean.vendorInfoSem.branchNo}" 
										disabled="#{semmmm001Bean.viewMode}"  
										maxlength="20" style="width:40px;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoSemVendorStatus" value="#{semmmm001Bean.vendorInfoSem.vendorStatus}" 
										disabled="#{semmmm001Bean.viewMode}" style="">
		                					<f:selectItems value="#{semmmm001Bean.vendorStatusSemList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button history -->
					<h:panelGrid id="groupHistorySemButton" width="100%">
						<h:panelGroup>
							<table width="98%" style="padding-right: 3px;">
								<tr>
									<td style="width:50%; text-align:left;margin-left: 5px;">
										<a4j:commandButton id="btnCopySapToSem" value="#{jspMsg['btn.label.copysap']}" 
										styleClass="rich-button" disabled="#{semmmm001Bean.viewMode}"
										action="#{navAction.navi}" reRender="frmContractInfo" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doCopySapToSem" />
											<a4j:actionparam name="actionParam" value="VD" />
										</a4j:commandButton>
									</td>
									<td style="width:50%; text-align:right;">
										<a4j:commandButton id="btnVendorSemHistory" value="Vendor History" 
										styleClass="rich-button" disabled="#{semmmm001Bean.disableBtnHistory}"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doVendorHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfoSem.vendorId}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				
				
					<!-- >> tab panel -->
					<h:panelGrid style="width:98%;">
						<rich:tabPanel id="panelChangeSemTab" selectedTab="#{semmmm001Bean.selectedSemTab}" switchType="client" style="width:100%;">
							<rich:tab label="#{jspMsg['header.vendor.address']}" id="semTab0" onlabelclick="setTabSemNo0();">
								<a4j:jsFunction name="setTabSemNo0" action="#{navAction.navi}" 
						         reRender="panelSemTab, semTab0, frmContractInfo">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="semTab0"/>
				        			<a4j:actionparam  name="sapFlag" value="N"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_Sem_incTab0"  viewId="../../pages/mm/semmmm001tab0sem.jsp" />
							</rich:tab>
							
							<rich:tab label="#{jspMsg['header.withholder.address']}" id="semTab6" onlabelclick="setTabSemNo6();">
								<a4j:jsFunction name="setTabSemNo6" action="#{navAction.navi}" 
						         reRender="panelSemTab, semTab6, frmContractInfo">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="semTab6"/>
				        			<a4j:actionparam  name="sapFlag" value="N"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_Sem_incTab6" viewId="../../pages/mm/semmmm001tab6sem.jsp" />
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
				<!-- vendor info panel (compare content)from sem << -->
				
				
				<!-- button vedor detail -->
				<h:panelGrid id="groupVendorDetailButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:100%;">
									<a4j:commandButton id="btnSaveVendorDetail" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSaveVendor}" 
									rendered="#{semmmm001Bean.viewMode eq 'false'}"
									onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 	reRender="oppContent,txtNavProgram" oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-10" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSaveChangeVendorInfo" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnBackVendorDetail" value="#{jspMsg['btn.back']}" styleClass="rich-button"
									rendered="#{semmmm001Bean.viewMode eq 'false'}"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-0" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackManagerTodo" value="#{jspMsg['btn.back']}T" styleClass="rich-button"
									rendered="#{semmmm001Bean.viewMode}"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM002-0" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</h:panelGrid>
			<!-- group[2] << -->
			
			<rich:spacer />
			
			<!-- group[5] >> -->
			<h:panelGrid id="contractInfo" width="98%" style="border:solid 1px gray;">
				<!-- contact list panel >> -->
				<rich:panel  styleClass="sem_autoScrollbar">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.list']}"/></f:facet>
					
					<center>
					
						
						<rich:dataTable id="dtbContactList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractList}" var="contractObj"
						reRender="dtbContactList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
						
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.view']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center" style="">
									view
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number.old']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractOldNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.region}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.site.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.siteType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.location.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.location.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.locationCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.network.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.first.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.firstEffectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.expireDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.pending.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.pendingStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.owner.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.ownerName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contact.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contactName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.telephone']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.telephone}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.accountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeEffectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.contractList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContactList"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllContactList" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbContactList"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
					
					</center>
				</rich:panel>
				<!-- contact list panel << -->
			</h:panelGrid>
			<!-- group[5] << -->
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>