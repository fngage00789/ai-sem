<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.history.vendor.info']}"/></f:facet>	
	
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
		
		<a4j:form id="frmContractInfo" >
			<h:panelGroup id="pnlButton">
				<table width="100%">
					<tr class="ms7">
						<td width="50%" align="left">
					
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
								<tr class="ms7">
									<td>
						           		<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();" rendered="false">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfoHist.siteInfoId}" />
										</a4j:commandButton>
										
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						           	 	oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoadHist" />
											<a4j:actionparam name="backDetailFlag" value="Y" />
											<a4j:actionparam name="detailPageFlag" value="VD" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
						           		</a4j:commandButton>
					           		</td>
			           			</tr>
			           		</table>
           				</td>
           			</tr>
				</table>
			</h:panelGroup>
			
			<!-- group[2] >> -->
			<h:panelGrid id="vendorInfoHist" width="98%" style="border:solid 1px gray;">
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
					
					<!-- vendor info panel -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="80%" align="center" >
								<tr>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendor.codeTxt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoVendorCode" value="#{semmmm001Bean.vendorInfoHist.vendorCode}" styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.typeTxt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoVendorType" value="#{semmmm001Bean.vendorInfoHist.vendorTypeTxt}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendor.name1Txt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoVendorName1" value="#{semmmm001Bean.vendorInfoHist.vendorName1}" 
										styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendor.name2Txt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoVendorName2" value="#{semmmm001Bean.vendorInfoHist.vendorName2}" 
		                				styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendor.name3Txt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoVendorName3" value="#{semmmm001Bean.vendorInfoHist.vendorName3}" 
										styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendor.name4Txt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoVendorName4" value="#{semmmm001Bean.vendorInfoHist.vendorName4}" 
		                				styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.citizen.id']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoIdCard" value="#{semmmm001Bean.vendorInfoHist.idCard}" 
										styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.personl.tax.idTxt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoTaxId" value="#{semmmm001Bean.vendorInfoHist.taxId}"
		                				styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.hq.branchTxt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoHqBranch" value="#{semmmm001Bean.vendorInfoHist.hqFlagTxt}" 
										styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.branch.codeTxt']}" styleClass="ms7" />
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfoHist.branchNo}"
		                				styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr class="ms7">
									<td style="width:10%; text-align:left;" class="ms7">
										
									</td>
									<td style="width:80%;" colspan="5">
										<h:selectBooleanCheckbox id="chkVAT" 
										value="#{semmmm001Bean.vendorInfoHist.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"/>
				                		<h:outputText value="#{jspMsg['label.vat']} " styleClass="ms7" style="padding-left:2px;" />
										<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatus" 
										value="#{semmmm001Bean.vendorBlockStatus}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"/>
				                		<h:outputText value="Block " styleClass="ms7" style="padding-left:2px;" />
									
										<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlag" 
										value="#{semmmm001Bean.notPayeeFlag}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"/>
				                		<h:outputText value="#{jspMsg['label.vendor.notpayee']} " styleClass="ms7" style="padding-left:2px;" />
				                		
				                		<h:selectBooleanCheckbox id="vendorInfOtherExpenseFlag" 
										value="#{semmmm001Bean.otherExpenseFlag}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"/>
				                		<h:outputText value="#{jspMsg['label.vendor.vendornocontract']} " styleClass="ms7" style="padding-left:2px;" />
										
										<h:selectBooleanCheckbox id="vendorInfoBlackListStatus" 
										value="#{semmmm001Bean.vendorBlackListStatus}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"/>
				                		<h:outputText value="Black List" styleClass="ms7" style="padding-left:2px;" />
				                		
				                		<h:selectBooleanCheckbox id="mmm001tab0_chkLocalDepartment" 
										value="#{semmmm001Bean.vendorAddrObj.chkLocalDepartment}"
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"
										onclick="" style="margin:0px 5px 0px 5px;" />
										<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
										
									</td>
								</tr>
								<tr class="ms7">
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.remarkTxt']}" styleClass="ms7"
										style="vertical-align:top;"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7" />
									</td>
									<td style="width:28%;" >
										<h:outputText id="vendorInfoRemark" value="#{semmmm001Bean.vendorInfoHist.vendorRemark}" styleClass="ms7"></h:outputText>
									</td>
									<td style="width:10%; text-align:left;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.flow.statusTxt']}" styleClass="ms7"/>
									</td>
									<td style="width:1%;">
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;">
		                				<h:outputText id="vendorInfoVendorFlowStatus" value="#{semmmm001Bean.vendorInfoHist.vendorFlowStatusTxt}"
		                				styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr class="ms7">
									<td style="width:10%; text-align:left;">
										<h:outputText value="#{jspMsg['label.vendorbatchTxt']}" styleClass="ms7"
										style="vertical-align:top;"/>
									</td>
									<td style="width:1%;" >
										<h:outputText value=":" styleClass="ms7"/>
									</td>
									<td style="width:28%;" >
										<h:outputText value="#{semmmm001Bean.vendorInfoHist.vendorBatch}"
										style="vertical-align:top;" styleClass="ms7"/>
									</td>
									<td style="width:10%; text-align:left;" class="ms7">
										
									</td>
									<td style="width:1%;">
										
									</td>
									<td style="width:28%;">
		                				
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				
				<div style="clear:both; height:5px;"></div>
				
				<!-- panel vendor info -->
				<rich:panel rendered="false">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendorhistory']}" style="text-align:left;"/></f:facet>
					
					<center>
					<div id="tabVendorHistory" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
						<rich:dataTable id="dtbVendorHistoryList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.vendorInfoHistSummaryList}" var="historyObj"
						reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
							<rich:column title="#{historyObj.dataObj.effectiveDtStr}" sortBy="#{historyObj.dataObj.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effectivedt']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contractNo}" sortBy="#{historyObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{historyObj.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{historyObj.dataObj.viewSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.oldContractNo}" sortBy="#{historyObj.dataObj.oldContractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.oldContractNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.expenseType}" sortBy="#{historyObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contractEffectiveDtStr}" sortBy="#{historyObj.dataObj.contractEffectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.start.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contractEffectiveDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.contractExpireDtStr}" sortBy="#{historyObj.dataObj.contractExpireDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.expire.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.contractExpireDtStr}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorCode}" sortBy="#{historyObj.dataObj.vendorCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<a4j:commandLink id="hlkVendorCode" value="#{historyObj.dataObj.vendorCode}" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
									oncomplete="onTopPage();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="mode" value="View" />
										<a4j:actionparam name="headType" value="Vendor" />
										<a4j:actionparam name="contractNoParam" value="#{historyObj.dataObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{historyObj.dataObj.vendorId}" />
										
										<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{historyObj.dataObj.vendorEffectiveDtStr}" />
										<a4j:actionparam name="effectiveDtStrParam" value="#{historyObj.dataObj.effectiveDtStr}" />
										<a4j:actionparam name="expireDtStrParam" value="#{historyObj.dataObj.expireDtStr}" />
										<a4j:actionparam name="expenseTypeIdParam" value="#{historyObj.dataObj.expenseTypeId}" />
										<a4j:actionparam name="payTypeIdParam" value="#{historyObj.dataObj.payTypeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{historyObj.dataObj.vendorMapPayeeId}" />
										<a4j:actionparam name="historyFlag" value="Y"></a4j:actionparam>
									</a4j:commandLink>
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorName}" sortBy="#{historyObj.dataObj.vendorName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:150px;">
									<h:outputText value="#{historyObj.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.idCard}" sortBy="#{historyObj.dataObj.idCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.idCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.taxId}" sortBy="#{historyObj.dataObj.taxId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.taxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vat}" sortBy="#{historyObj.dataObj.vat}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vat}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorBlock}" sortBy="#{historyObj.dataObj.vendorBlock}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.block']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vendorBlock}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.notPayee}" sortBy="#{historyObj.dataObj.notPayee}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.notpayee']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.notPayee}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorBlackList}" sortBy="#{historyObj.dataObj.vendorBlackList}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.blacklist']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vendorBlackList}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorAddress}" sortBy="#{historyObj.dataObj.vendorAddress}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['comlumn.header.vendoraddress']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vendorAddress}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorAccountNo}" sortBy="#{historyObj.dataObj.vendorAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bookbankaccountno']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vendorAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorAccountNo}" sortBy="#{historyObj.dataObj.vendorAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{historyObj.dataObj.vendorAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorAccountName}" sortBy="#{historyObj.dataObj.vendorAccountName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.vendorAccountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorAccountType}" sortBy="#{historyObj.dataObj.vendorAccountType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.vendorAccountType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.vendorBankName}" sortBy="#{historyObj.dataObj.vendorBankName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.bankname']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.vendorBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeCode}" sortBy="#{historyObj.dataObj.payeeCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeecode']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeType}" sortBy="#{historyObj.dataObj.payeeType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payeetype']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeName}" sortBy="#{historyObj.dataObj.payeeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeIdCard}" sortBy="#{historyObj.dataObj.payeeIdCard}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.idcard']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeIdCard}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeTaxId}" sortBy="#{historyObj.dataObj.payeeTaxId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.taxid']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeTaxId}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeAddress}" sortBy="#{historyObj.dataObj.payeeAddress}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.address']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeAddress}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeAccountNo}" sortBy="#{historyObj.dataObj.payeeAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeAccountName}" sortBy="#{historyObj.dataObj.payeeAccountName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeAccountName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeAccountType}" sortBy="#{historyObj.dataObj.payeeAccountType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeAccountType}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.payeeBankName}" sortBy="#{historyObj.dataObj.payeeBankName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.bankname']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.payeeBankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column title="#{historyObj.dataObj.activeStatus}" sortBy="#{historyObj.dataObj.activeStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.active.status']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="left" style="width:120px;">
									<h:outputText value="#{historyObj.dataObj.activeStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="3">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendorHistoryList"
											maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllVendorHistoryList" style="background-color: #cccccc;"
											page="#{semmmm001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="dtbVendorHistoryList"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
						</rich:dataTable>
					</div>
					</center>
				</rich:panel>
				<!-- end panel vendor info -->
				
				<div style="clear:both; height:5px;"></div>
			
				
			</h:panelGrid>
			<div style="clear:both; height:5px;"></div>
			<!-- >> tab panel -->
				<h:panelGrid style="width:97%;">
						<rich:tabPanel id="panelTab" selectedTab="#{semmmm001Bean.selectedTab}" switchType="client" style="width:100%;">
							<rich:tab label="#{jspMsg['header.vendor.address']}" id="tab0" onlabelclick="setTabNo0();">
								<a4j:jsFunction name="setTabNo0" action="#{navAction.navi}" 
						         reRender="panelTab, tab0">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab0"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab0"  viewId="../../pages/mm/semmmm001tab0hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.rentor.address']}" id="tab1" onlabelclick="setTabNo1();">
								<a4j:jsFunction name="setTabNo1" action="#{navAction.navi}" 
						         reRender="panelTab, tab1">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab1"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab1"  viewId="../../pages/mm/semmmm001tab1hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.elector.address']}" id="tab2" onlabelclick="setTabNo2();">
								<a4j:jsFunction name="setTabNo2" action="#{navAction.navi}" 
						         reRender="panelTab, tab2">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab2"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab2"  viewId="../../pages/mm/semmmm001tab2hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.property.address']}" id="tab3" onlabelclick="setTabNo3();">
								<a4j:jsFunction name="setTabNo3" action="#{navAction.navi}" 
						         reRender="panelTab, tab3">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab3"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab3" viewId="../../pages/mm/semmmm001tab3hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.insure.address']}" id="tab4" onlabelclick="setTabNo4();">
								<a4j:jsFunction name="setTabNo4" action="#{navAction.navi}" 
						         reRender="panelTab, tab4">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab4"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab4" viewId="../../pages/mm/semmmm001tab4hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.construct.address']}" id="tab5" onlabelclick="setTabNo5();">
								<a4j:jsFunction name="setTabNo5" action="#{navAction.navi}" 
						         reRender="panelTab, tab5">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab5"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab5" viewId="../../pages/mm/semmmm001tab5hist.jsp" />
							</rich:tab>
							<rich:tab label="#{jspMsg['header.withholder.address']}" id="tab6" onlabelclick="setTabNo6();">
								<a4j:jsFunction name="setTabNo6" action="#{navAction.navi}" 
						         reRender="panelTab, tab6">
				        			<a4j:actionparam name="navModule" value="mm" />
									<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2DETAIL" />
									<a4j:actionparam name="moduleWithNavi" value="mm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="tab6"/>
						        </a4j:jsFunction>
					           	<a4j:include id="mmm001_incTab6" viewId="../../pages/mm/semmmm001tab6hist.jsp" />
							</rich:tab>
						</rich:tabPanel>
						
						<!-- hide panel changed vendor history -->
						<rich:panel rendered="true">
							<f:facet name="header"><h:outputText value="#{jspMsg['header.history.of.vendor']}" style="text-align:left;"/></f:facet>
							
							<div id="tabVendorHistoryChange" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
								<rich:dataTable id="dtbHistoryList" width="100%" 
								cellpadding="0" cellspacing="0" border="0" 
								value="#{semmmm001Bean.historyResultList}" var="historyObj"
								reRender="dtbHistoryList" rows="#{semmmm001Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
									
									<rich:column title="#{historyObj.dataObj.lastUpdateDtStr}" sortBy="#{historyObj.dataObj.lastUpdateDt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.date']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center"  style="width:80px;">
											<h:outputText value="#{historyObj.dataObj.lastUpdateDtStr}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentChange}" sortBy="#{historyObj.dataObj.contentChange}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.change.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{historyObj.dataObj.contentChange}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentOld}" sortBy="#{historyObj.dataObj.contentOld}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.old.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{historyObj.dataObj.contentOld}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.contentNew}" sortBy="#{historyObj.dataObj.contentNew}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.new.info']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{historyObj.dataObj.contentNew}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<rich:column title="#{historyObj.dataObj.updateBy}" sortBy="#{historyObj.dataObj.updateBy}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.update.by']}" styleClass="contentform"/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{historyObj.dataObj.updateBy}" styleClass="contentform"  />
										</div>
									</rich:column>
									
									<!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="2">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmmm001Bean.historyResultList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbHistoryList"
													maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrllHistoryList" style="background-color: #cccccc;"
													page="#{semmmm001Bean.scrollerPage}">
												<a4j:support event="onclick" reRender="dtbHistoryList"></a4j:support>
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
								</rich:dataTable>
							</div>
							
						</rich:panel>
						<!-- hide panel changed vendor history -->
					
					</h:panelGrid>
			<!-- group[2] << -->
			
			<div style="clear:both; height:5px;"></div>
			
			
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>