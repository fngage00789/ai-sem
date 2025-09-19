<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid id="pnlTab4" width="95%">
		<rich:panel id="pnlPropertyTax" >
			<f:facet name="header">
				<h:outputText value="#{jspMsg['header.panel.conditionPropertyTax']}"/>
			</f:facet>
			
			<h:panelGrid id="pnlConditionPropertyTax" width="90%" border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table width="100%">
						<tr>
							<td align="right" width="100%" valign="top" colspan="4">
								<a4j:commandButton style="" styleClass="rich-button" id="msi004tab4_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info']}#{jspMsg['label.th_tax']}#{jspMsg['label.th_property']}"
				                action="#{semmsi004Action.doShowPopupHistory}" reRender="popupDisplay6"
				                oncomplete="#{rich:component('tab6_panel_popupModalRetStatus')}.show(); return false;">
				                <f:param name="tabNo" value="6"/>
			                    </a4j:commandButton>
			                	<a4j:include id="popUpTab6"  viewId="../../pages/sa/semmsa002PopUpTab6.jsp" />
							</td>
						</tr>
					</table>
					
					<rich:spacer height="10"></rich:spacer>		
					
					<table width="100%">
						<tr>
							<td align="right" style="width:20%">
								<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
							</td>
							<td align="left">
								<h:inputText value="#{semmsi004tab1Bean.siteInfo.company}" size="16"  readonly="true" styleClass="ms7"/>
							</td>
							<td align="right" style="width:25%">
								<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
							</td>
							<td align="left">
								<h:inputText value="#{semmsi004tab2Bean.siteContract.contractNo}" 
	                			size="16"  readonly="true" styleClass="ms28Blue"/>
							</td>
						</tr>
					</table>
					
					<rich:spacer height="10"></rich:spacer>
					
					<!-- << group 2 -->
					<rich:panel style="height:100%; border:1 ececec solid;" rendered="false">
			
						<!-- >> header content -->
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.propertyTaxNewcond']}" />
						</f:facet>
						<!-- << header content -->
				
							<!-- >> group 0 -->
							<h:panelGroup style="width:100%;">
								<table style="width:100%; border:solid 1px;">
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsi004tab4Bean.siteAppPTObj.contractNo}">  </h:outputText>
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsi004tab4Bean.siteAppPTObj.effectiveDtStr}"></h:outputText>
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsi004tab4Bean.siteAppPTObj.expireDtStr}"></h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.ptpayer']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsi004tab4Bean.siteAppPTObj.ptTaxPayTypeName}"></h:outputText>
										</td>
										<td align="right">
											
											
										</td>
										<td align="left" >
										
										</td>
										<td align="right">
											
										</td>
										<td align="left" >
											
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
										</td>
										<td align="left">
											<h:outputText styleClass="ms7" value="#{semmsi004tab4Bean.siteAppPTObj.ptRemark}"></h:outputText>
										</td>
										<td align="right">
											
										</td>
										<td align="left" >
											
										</td>
										<td align="right">
											
										</td>
										<td align="left" >
											
										</td>
									</tr>
								</table>
							</h:panelGroup>
					</rich:panel>
					<!-- >> group 2 -->
					
					<rich:spacer height="10"></rich:spacer>
					
					<!-- << group 3 -->
					<h:panelGroup>
	                	<div>
	                		<h:selectBooleanCheckbox value="#{semmsi004tab4Bean.chkEditPt}" rendered="false"></h:selectBooleanCheckbox>
	                		<h:outputText value="#{jspMsg['label.th_changeptinfo']}" styleClass="ms7" rendered="false"/>
	                	</div>
	            	</h:panelGroup>
					<!-- >> group 3 -->
					
					<rich:spacer height="10"></rich:spacer>
					
					<!-- << group 4 -->
					<h:panelGroup>
			           		<h:outputText value="#{jspMsg['label.th_changeptinfo']}" styleClass="ms7" 
			           		rendered="#{semmsi004Bean.reqTypeParam != '01'}"/>
							
								<h:selectOneRadio id="rbtMsi004tab4_changePT" value="#{semmsi004tab4Bean.propertyTaxEditFlag}" styleClass="ms7" 
								rendered="#{semmsi004Bean.reqTypeParam != '01'}"
								disabled="" onclick="fnMsi004tab4_changePTComfirm();">
		                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_notEdit']}" />
		                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_edit']}"/>
		                		</h:selectOneRadio>
		                		
		                		<a4j:jsFunction name="fnMsi004tab4_changePTComfirm"
		                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
		                		action="#{semmsi004tab4Action.doSetParamConfirmNotChangePT}"
		                		reRender="pnlPropertyTax,msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
			      	</h:panelGroup>
			           	
					<rich:panel>
				
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_ptCond']}" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup style="width:100%;">
							<h:panelGroup>
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
			                		<table style="width:100%;">
			                			<tr>
			                				<td align="right" width="20%">
			                					<h:outputText value="#{jspMsg['label.ptpayer']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:selectOneMenu  id="rbtPropertyTaxPayTypeTab4" value="#{semmsi004tab4Bean.propertyTax.propertyTaxPayType}">
									       				<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
									       				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.propertyTaxPayType02']}"/>
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.propertyTaxPayType01']} " />
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.propertyTaxPayType03']} " />
						                				<f:selectItem itemValue="00" itemLabel="#{jspMsg['label.propertyTaxPayType00']}"/>
									       		</h:selectOneMenu>
			                				</td>
			                			</tr>
			                			<tr>
			                				<td align="right" >
			                					<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:inputTextarea id="txtPropertyTaxRemark" value="#{semmsi004tab4Bean.propertyTax.remark}"  rows="5" style="width:80%;"></h:inputTextarea>
			                				</td>
			                			</tr>
			                		</table>
			                	</div>
			                	
			                	<div style="clear:both; height:10px;"></div>
			                	
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
										<h:panelGroup>
											<table width="100%">
												<tr>
													<td width="20%" align="right">
														<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7"
														rendered="#{semmsi004Bean.reqTypeParam != '01'}"></h:outputText>
													</td>
													<td align="left">
														<rich:calendar locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value=""
															   showWeeksBar="false"
															   inputSize="10"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														   	   cellWidth="15px" cellHeight="20px"
														   	   label=""
														   	   rendered="#{semmsi004Bean.reqTypeParam != '01'}"
														   	   styleClass="ms7">
														</rich:calendar>
													</td>
												</tr>
											</table>
											
										
										</h:panelGroup>
										
									</div>
									
									
			               	</h:panelGroup>
			               		<rich:panel id="pnlPropertyTaxHistory">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.panel.propertyTaxHistory']}" />
									</f:facet>
										<rich:dataTable id="dtbPropertyTaxHistory" width="70%" cellpadding="1" cellspacing="0" border="0"
										var="propertyTaxHistorySP" value="#{semmsi004tab4Bean.propertyTaxHistSPList}" reRender="dtbPropertyTaxHistory" 
										rows="#{semmsi004tab4Bean.rowPerPage}"  rowClasses="cur" styleClass="dataTable">
										<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbPropertyTaxHistory">
											<a4j:actionparam name="rowId" value="#{propertyTaxHistorySP.rowId}" />
										</a4j:support>
										<rich:column sortBy="#{propertyTaxHistorySP.ptYear}" styleClass="#{(semmsi004Bean.tmpRowId==propertyTaxHistorySP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.ptYear']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{propertyTaxHistorySP.ptYear}" styleClass="contentform"  />
											</div>
										</rich:column>
										<rich:column sortBy="#{propertyTaxHistorySP.ptAmt}" styleClass="#{(semmsi004Bean.tmpRowId==propertyTaxHistorySP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.ptAmt']}" styleClass="contentform" style="width:100"/>
											</f:facet>
											<div align="right">
												<h:outputText value="#{propertyTaxHistorySP.ptAmt}" styleClass="contentform" >
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>
										<rich:column sortBy="#{propertyTaxHistorySP.ptPayTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==propertyTaxHistorySP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.ptPayTypeName']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{propertyTaxHistorySP.ptPayTypeName}" styleClass="contentform"  />
											</div>
										</rich:column>
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsi004tab4Bean.propertyTaxHistSPList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<rich:column>
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPropertyTaxHistory"
														maxPages="#{semmsi004tab4Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dstPropertyTaxHistory" 
														style="background-color: #cccccc;"
														page="#{semmsi004tab4Bean.scrollerPage}" 
													/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>
								</rich:panel>
			               	<h:panelGroup>
			               		
			               	</h:panelGroup>
			            </h:panelGroup>
			        </rich:panel>
					<!-- >> group 4 -->
					
					<div style="clear:both; height:50px;"></div>
					
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>			
	</h:panelGrid>
</h:panelGrid>