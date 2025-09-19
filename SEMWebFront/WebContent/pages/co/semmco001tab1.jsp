<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<f:loadBundle basename="resources.co.semmco001" var="jspMsg"/>
	<h:panelGrid columnClasses="gridContent" width="100%">
		 <h:panelGrid id="pnlTab1" width="95%">
				<!-- panel search location criteria -->
		          <rich:panel id="pnlContractTab1" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.contract']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNoDisplay" value="#{semmco001Bean.contractNoParam}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteNameDisplay" value="#{semmco001Bean.siteNameParam}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtEffDate" value="#{semmco001Bean.effDateParamStr}" readonly="true" disabled="true" size="13" >
		                			</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			  <h:inputText id="txtExpDate" value="#{semmco001Bean.expDateParamStr}" readonly="true" disabled="true" size="13" >
		                			  </h:inputText>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						</rich:panel>

						<rich:spacer height="10"></rich:spacer>
						<!-- panel contract status history -->
						<rich:panel id="pnlContractStatusHistory">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.history']}"/>
						</f:facet>
						<rich:dataTable width="97%" id="dtbContractStatusHistory" cellpadding="1" cellspacing="0" border="0"
							var="contractStatusHistorySP" value="#{semmco001tab1Bean.contractStatusHistoryList}" reRender="dtbContractStatusHistory" 
							rows="10" rowClasses="cur"	 styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmco001tab1Action.getRowIdOnClick}" reRender="dtbContractStatusHistory">
								<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnEditHistory" action="#{navAction.navi}" reRender="pnlEditContractStatus,pnlBorrowOfficer"
	            					image="images/edit.png" style="height: 15; width: 15"
	            					rendered="#{contractStatusHistorySP.lastRecord and semmco001tab1Bean.renderedUpdateHistory}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateContractStatusHistory" />
										<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDeleteHistory" oncomplete="#{rich:component('mdpConfirmDelDialogContractStatusHistory')}.show(); return false" 
     								action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
     								rendered="#{contractStatusHistorySP.lastRecord and semmco001tab1Bean.renderedDeleteHistory}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContractStatusHistory" />
										<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.changeStatusDate}" styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.changeStatusDate']}" styleClass="contentform" style="width:100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractStatusHistorySP.changeStatusDateStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.contractStatusName}" styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractStatusHistorySP.contractStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.remark}" styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" style="width: 120"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractStatusHistorySP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.updateBy}" styleClass="#{(semmco001tab1Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.updateBy']}" styleClass="contentform" style="width: 80"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractStatusHistorySP.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco001tab1Bean.contractStatusHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractStatusHistory"
											maxPages="#{semmco001tab1Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractStatusHistory" 
											style="background-color: #cccccc;"
											page="#{semmco001tab1Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
				</rich:panel>
	            <!-- panel add contract status history -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlEditContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.contractStatus']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco001tab1Bean.renderedMsgFormMiddle}"/>
						</div>
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
							<td align="right" width="10%">
							<h:panelGroup>
							<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.changeStatusDate']} :" styleClass="ms7"/>
							</h:panelGroup>
                			</td>
                			<td width="20%">
							<rich:calendar id="cldChangeStatusDateTab1" locale="th" enableManualInput="true"  
							datePattern="dd/MM/yyyy" 
							value="#{semmco001tab1Bean.contractStatus.changeStatusDt}" 
							showWeeksBar="false" 
							inputSize="13"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.changeStatusDate']}">
							</rich:calendar> 
		                	</td>
		                	<td align="right" width="10%">
							<h:panelGroup>
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['labe.contractStatus']}" styleClass="ms7"/>
							</h:panelGroup>
                			</td>
                			<td width="60%">
                			<h:selectOneMenu id="ddlContractStatusTab1" value="#{semmco001tab1Bean.contractStatus.contractStatus}" 
                				rendered="#{!semmco001Bean.chkContractLost}">
								<f:selectItems value="#{semmco001Bean.contractStatusTab1List}"/>
							</h:selectOneMenu>
							<h:selectOneMenu id="ddlContractLostStatusTab1" value="#{semmco001tab1Bean.contractStatus.contractStatus}" 
								rendered="#{semmco001Bean.chkContractLost}">
								<f:selectItems value="#{semmco001Bean.contractLostStatusList}"/>
							</h:selectOneMenu>
							<rich:spacer width="5"/>
							<h:selectBooleanCheckbox id="selContractLost" value="#{semmco001Bean.chkContractLost}" 
								onclick="reRenderContractLost()" />
							<a4j:jsFunction name="reRenderContractLost" reRender="pnlEditContractStatus"/>
							<rich:spacer width="5"/>
							<h:outputText value="#{jspMsg['label.contractLost']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		<tr>
							<td align="right" width="10%" valign="top">
							<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
                			</td>
                			<td width="90%" colspan="3">
                			<h:inputTextarea id="txtRemark2" value="#{semmco001tab1Bean.contractStatus.remark}" 
                			cols="100" rows="3"/>
		                	</td>
	                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid  id="grdPopupEditCommand" >
						<h:panelGroup rendered="#{semmco001tab1Bean.renderedAddHistory}">
								<a4j:commandButton id="btnAddContractStatusHistory" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus,dtbContractStatusHistory,pnlDuty" 
				           		disabled="#{semmco001tab1Bean.disabledBtnAddContractStatusHistory}">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
								<a4j:actionparam name="methodWithNavi" value="doAddContractStatusHistory" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnSaveContractStatusHistory" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus,dtbContractStatusHistory" 
				           		disabled="#{semmco001tab1Bean.disabledBtnUpdateContractStatusHistory}">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateContractStatusHistory" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
			                	 <a4j:commandButton id="btnClearContractStatusHistory" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus" >
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO001TAB1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO001Tab1" />
								<a4j:actionparam name="methodWithNavi" value="doClearContractStatusHistory" />
				           		</a4j:commandButton>
				        </h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlBorrowOfficer" rendered="#{semmco001Bean.renderedDataTab1}">
						
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right" width="20%" valign="top">
								<h:outputText value="ผู้รับ :" styleClass="ms7"/>
	                			</td>
	                			<td>
	                			<h:selectOneMenu id="ddlRecipient" value="#{semmco001tab1Bean.contract.receivePersonCode}">
									<f:selectItems value="#{semmco001tab1Bean.borrowOfficerList}"/>
								</h:selectOneMenu>
			                	</td>
			                	
			                	<td align="right" width="20%" valign="top">
								<h:outputText value="ผู้จัดทำ :" styleClass="ms7"/>
	                			</td>
	                			<td>
	                			<h:selectOneMenu id="ddlOrganizer" value="#{semmco001tab1Bean.contract.createPersonCode}">
									<f:selectItems value="#{semmco001tab1Bean.borrowOfficerList}"/>
								</h:selectOneMenu>
			                	</td>
		                	 </tr>
							<tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>				
				</rich:panel>

				<!-- panel Address contract -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlAddressContract" rendered="#{semmco001Bean.renderedDataTab1}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.rightAddress']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
	                		<tr>
							<td align="right" width="20%" valign="top">
							<h:outputText value="#{jspMsg['label.rightHouseNo']}" styleClass="ms7"/>
                			</td>
                			<td width="30%" colspan="3">
                			 <h:inputTextarea id="txtRightHouseNo" value="#{semmco001tab1Bean.siteInfo.rightHouseNo}" 
                			 rows="3" cols="100" />
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightBuilding']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			 <h:inputText id="txtRightBuilding" value="#{semmco001tab1Bean.siteInfo.rightBuilding}"  
                			 size="30" maxlength="100"/>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightStreet']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			<h:inputText id="txtRightStreet" value="#{semmco001tab1Bean.siteInfo.rightStreet}" 
                			size="30" maxlength="100"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightFloor']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			 <h:inputText id="txtRightFloor" value="#{semmco001tab1Bean.siteInfo.rightFloor}"  />
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightTambon']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			<h:inputText id="txtRightTambon" value="#{semmco001tab1Bean.siteInfo.rightTambon}" 
                			size="30" maxlength="50"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
	                		<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightRoomNo']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			 <h:inputText id="txtRightRoomNo" value="#{semmco001tab1Bean.siteInfo.rightRoomNo}"  
                			 size="13" maxlength="10"/>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightAmphur']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
							 <h:inputText id="txtRightAmphur" value="#{semmco001tab1Bean.siteInfo.rightAmphur}" size="30"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
                			</td>
                			<td width="30%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightProvince']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			<h:inputText id="txtRightProvince" value="#{semmco001tab1Bean.siteInfo.rightProvince}" 
							  size="30"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
                			</td>
                			<td width="30%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.rightPostcode']}" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                			<h:inputText id="txtRightPostcode" value="#{semmco001tab1Bean.siteInfo.rightPostcode}"  
                			size="8" maxlength="5"/>
		                	</td>
	                		</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
				</rich:panel>

				<!-- panel duty -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlDuty" rendered="#{semmco001Bean.renderedDataTab1}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.duty']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
	                		<tr>
							<td align="right" width="25%">
							<h:graphicImage value="images/icon_required.gif" id="dutyRq" rendered="#{semmco001tab1Bean.contract.dutyPayStatus=='01'?true:false}" />
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.dutyAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                			 <h:inputText id="txtDutyAmt" value="#{semmco001tab1Bean.contract.dutyAmt}" 
       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
       						 onblur="return numberformat.moneyFormat(this);"
       						 onfocus="return numberformat.setCursorPosToEnd(this);"
       						 disabled="#{not semmco001tab1Bean.renderedEditDuty}"
       						 maxlength="16" 
       						 styleClass="inputRight"
       						 size="18">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
                			 <rich:spacer width="2"></rich:spacer>
                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
		                	<td align="right" width="25%" >
		                	<h:outputText value="#{jspMsg['label.copyDutyFlag']}" styleClass="ms7"/>
                			</td>
                			<td width="20%">
	                			<table width="100%">
	                			<tr>
	                			<td>
	                			<h:inputText id="txtCopyDutyFlag" value="#{semmco001tab1Bean.contract.copyDuty}"  size="5" 
	                			disabled="#{not semmco001tab1Bean.renderedEditDuty}"/>
	                			</td>
	                			<td>
	                			<h:outputText value="#{jspMsg['label.copy']}" styleClass="ms7"/>
	                			</td>
	                			<td>
	                			<h:inputText id="txtCoppyDutyAmt" value="#{semmco001tab1Bean.contract.copyDutyAmt}" 
	       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	       						 onblur="return numberformat.moneyFormat(this);"
	       						 onfocus="return numberformat.setCursorPosToEnd(this);"
	       						 disabled="#{not semmco001tab1Bean.renderedEditDuty}"
	       						 maxlength="16" 
	       						 styleClass="inputRight"
	       						 size="18">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                			</h:inputText>
                			</td>
                			<td align="left">
                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			</td>
                			</tr>
                			</table>
                			</td>
	                		</tr>
	                		<tr>
							<td align="right" width="25%">
							<h:graphicImage value="images/icon_required.gif" id="dateRq" rendered="#{semmco001tab1Bean.contract.dutyPayStatus=='01'?true:false}"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.dutyPayDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="35%">
							<rich:calendar id="cldDutyPayDate" locale="th" enableManualInput="true"  
							datePattern="dd/MM/yyyy" 
							value="#{semmco001tab1Bean.contract.dutyPayDt}" 
							showWeeksBar="false" 
							inputSize="13"
							disabled="#{not semmco001tab1Bean.renderedEditDuty}"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.dutyPayDate']}">
							</rich:calendar> 
		                	</td>
		                	<td align="right" width="25%" >
		                		<h:outputText value="#{jspMsg['label.otherDutyFlag']}" styleClass="ms7"/>
                			</td>
                			<td width="20%"> 
                			<h:inputText id="txtOtherDutyAmt" value="#{semmco001tab1Bean.contract.otherDutyAmt}" 
       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
       						 onblur="return numberformat.moneyFormat(this);"
       						 onfocus="return numberformat.setCursorPosToEnd(this);"
       						 maxlength="16" 
       						 styleClass="inputRight"
       						 disabled="#{not semmco001tab1Bean.renderedEditDuty}"
       						 size="18">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
                			 <rich:spacer width="2"></rich:spacer>
                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="25%">
							<h:outputText value="#{jspMsg['label.dutyPayStatus']}" styleClass="ms7"/>
                			</td>
                			<td width="75%" colspan="3">
                			<h:selectOneRadio id="rbtDutyPayStatus" value="#{semmco001tab1Bean.contract.dutyPayStatus}" disabled="#{not semmco001tab1Bean.renderedEditDuty}" styleClass="ms7" rendered="true" 
                			onclick="clickDutyPay();">
                				<f:selectItem itemValue="00" itemLabel="#{jspMsg['label.dutyPayStatus00']} " />
                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.dutyPayStatus01']}"/>
                			</h:selectOneRadio>
                			<a4j:jsFunction name="clickDutyPay" action="#{semmco001tab1Action.clickDutyPay}" reRender="dateRq,dutyRq,cldDutyPayDate,pnlDuty"></a4j:jsFunction>
                			<script>
                				function changeDutyPay(status){
									if(status == '01'){
										document.getElementById("incContent:frmContract:dutyRq").style.display = '';
										document.getElementById("incContent:frmContract:dateRq").style.display = '';
									}else{
										document.getElementById("incContent:frmContract:dutyRq").style.display = 'none';
										document.getElementById("incContent:frmContract:dateRq").style.display = 'none';
									}
                    			}
                			</script>
		                	</td>
	                		</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				<!-- panel property tax -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlContractLocation" rendered="#{semmco001Bean.renderedDataTab1}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.contractLocation']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
	                		<tr>
	                		<td width="20%" align="right">
	                		 <h:outputText value="#{jspMsg['label.contractRoom']}" styleClass="ms7"/>
	                		</td>
							<td width="30%">
							<h:inputText id="txtContractRoom" value="#{semmco001tab1Bean.contract.contractRoom}" size="23" maxlength="20"/>
		                	</td>
		                	<td width="20%" align="right">
							 <h:outputText value="#{jspMsg['label.contractShelf']}" styleClass="ms7"/>
		                	</td>
		                	<td width="30%">
							<h:inputText id="txtContractShelf" value="#{semmco001tab1Bean.contract.contractShelf}" size="23" maxlength="20"/>
		                	</td>
	                		</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
				</rich:panel>

	</h:panelGrid>
</h:panelGrid>
		
