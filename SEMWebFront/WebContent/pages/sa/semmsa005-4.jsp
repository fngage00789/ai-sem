<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.sa.semmsa005" var="jspMsg"/>

<rich:modalPanel id="popupBorrowContract" width="670" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupBorrowContract" style="cursor:pointer"/>
				<rich:componentControl for="popupBorrowContract" attachTo="hidePopupBorrowContract" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmBorrowError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
				<a4j:form id="popupFrmEditBorrowContract"> 
				<rich:panel id="pnlAddContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.borrow']}"/>
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
											<h:outputText value="#{jspMsg['label.borrowName']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td width="30%" valign="bottom">
			                			<h:selectOneMenu id="ddlBorrowName"
											value="#{semmsa005Bean.borrowContract.borrowName}"
											disabled="#{semmsa005Bean.mode == 'VIEW'}"
											onchange="ChkTxtBorrowName();">
											<a4j:jsFunction name="ChkTxtBorrowName"
												action="#{navAction.navi}"
												reRender="pnlAddContractStatus" >
												<a4j:actionparam name="navModule" value="sa" />
												<a4j:actionparam name="navProgram" value="SEMMSA005-6" />
												<a4j:actionparam name="moduleWithNavi" value="sa" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
												<a4j:actionparam name="methodWithNavi" value="chkTxtBorrowName" />
											</a4j:jsFunction>
											<f:selectItems value="#{semmsa005Bean.borrowNameList}" />
										</h:selectOneMenu>
					                </td>
					                <td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.borrowDt']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td valign="bottom" width="30%">
			                			<rich:calendar id="cldBorrowDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmsa005Bean.borrowContract.borrowDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}">
										</rich:calendar> 
					                </td>
			                	</tr>
			                	
			                	<tr>
									<td align="right"  valign="baseline">
									</td>
									<td colspan="3" valign="bottom">
										<h:inputText label="#{jspMsg['label.borrowName']}" id="txtBorrowName" 
			                				value="#{semmsa005Bean.otherBorrowName}" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}" 
			                				rendered="#{semmsa005Bean.disTxtBorrowName}"/>
									</td>
								</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										<h:panelGroup>
											
											<h:outputText value="#{jspMsg['label.borrowOfficer']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">
			                			<h:selectOneMenu id="ddlOffcer" value="#{semmsa005Bean.borrowContract.borrowOfficer}" 
			                				disabled="true">
											<f:selectItems value="#{semmsa005Bean.borrowOfficerList}"/>
										</h:selectOneMenu>
					                </td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="top">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.borrowForType']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td valign="top">
			                			<h:selectOneMenu id="ddlborrowForType" value="#{semmsa005Bean.borrowContract.borrowForType}" 
			                				disabled="#{semmsa005Bean.mode == 'VIEW'}">
											<f:selectItems value="#{semmsa005Bean.borrowForList}"/>
										</h:selectOneMenu>
					                </td>
					                <td align="right" valign="bottom" colspan="2">
										
			                					
			                					<h:inputTextarea label="#{jspMsg['label.radio.other']}"
			                					id="txtRemarkBorrowFor"
			                					value="#{semmsa005Bean.borrowContract.remarkBorrowFor}" 
			                					disabled="#{semmsa005Bean.mode == 'VIEW'}"
			                					style="width:90%;" rows="3"></h:inputTextarea>
			                		</td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.document']}" styleClass="ms7" style="text-decoration: underline;"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">&nbsp;</td>
			                	</tr>
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="bottom">
			                			<h:panelGrid columns="2">
				                			<h:selectBooleanCheckbox value="#{semmsa005Bean.docApproveFlagBoolean}" 
			                					disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
				                			<h:outputText value="#{jspMsg['label.cbx.docApproveFlag']}" styleClass="ms7"/>
			                			</h:panelGrid>
			                		</td>
			                	</tr>
			                	

			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="top" colspan="3">
			                			
			                			<table width="100%">
			                				<tr>
			                					<td width="20%" align="left" valign="top">
			                						<h:selectBooleanCheckbox id="cbxDocContractFlag" 
						                				value="#{semmsa005Bean.docContractFlagBoolean}" 
					                					disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
						                			<h:outputText value="#{jspMsg['label.cbx.docContractFlag']}" styleClass="ms7"/>
						                			
			                					</td>
			                					<td width="25%" align="right" valign="top">
						                			
														<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
													
						                		</td>
						                		<td width="55%" valign="top" rowspan="2">
						                			
														<h:inputTextarea id="txtDocContractDetail" 
															value="#{semmsa005Bean.borrowContract.docContractDetail}" 
															style="width:100%;" rows="3" 
						                					disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
												
						                		</td>
			                				</tr>
			                				<tr>
			                					<td colspan="2">
			                						<h:selectOneRadio id="contractType" value="#{semmsa005Bean.borrowContract.contractType}"
						                			disabled="#{semmsa005Bean.mode == 'VIEW'}" styleClass="ms7">
						                				<f:selectItem itemLabel="#{jspMsg['label.softFile']}" itemValue="01"/>
						                				<f:selectItem itemLabel="#{jspMsg['label.hardCopy']}" itemValue="02"/>
						                			</h:selectOneRadio>
			                					</td>
			                				</tr>
			                			</table>
			                		</td>
			                		
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="top" colspan="3">
			                		
			                		<table width="100%">
			                			<tr>
			                				<td width="20%" align="left" valign="top">
												<h:selectBooleanCheckbox id="cbxDocOtherFlag" 
					                				value="#{semmsa005Bean.docOtherFlagBoolean}" 
				                					disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
					                			<h:outputText value="#{jspMsg['label.cbx.docOtherFlag']}" styleClass="ms7"/>
												
					                		</td>
			                				<td width="25%" align="right" valign="top">
					                			
													<h:outputText value="#{jspMsg['label.otherDetail']}" styleClass="ms7"/>
												
					                		</td>
					                		<td width="55%" valign="top">
					                			
													<h:inputTextarea id="txtRemarkDocOther" 
														value="#{semmsa005Bean.borrowContract.remarkDocOther}" 
														style="width:100%;" rows="3" 
					                					disabled="#{semmsa005Bean.mode == 'VIEW'}"/>
												
					                		</td>
			                			</tr>
			                		</table>
			                		</td>
			                		
			                	</tr>
			                	
								<tr>
			                		<td align="right" valign="baseline">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.notBorrow']}" styleClass="ms7" style="text-decoration: underline;"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">&nbsp;</td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="top" colspan="3">
			                			
			                		<table width="100%">
			                			<tr>
			                				<td width="20%" align="left" valign="top">
			                					<h:selectBooleanCheckbox id="cbxCannotBorrowFlag" 
				                				value="#{semmsa005Bean.cannotBorrowFlagBoolean}" 
				                				onclick="GetChkCbxNotBorrowFlagJS();" 
			                					disabled="true">
			                						<a4j:jsFunction name="GetChkCbxNotBorrowFlagJS" reRender="popupFrmEditBorrowContract"/>
				                				</h:selectBooleanCheckbox>
					                			<h:outputText value="#{jspMsg['label.cbx.cannotBorrowFlag']}" styleClass="ms7"/>
			                				</td>
			                				<td width="25%" align="right" valign="top">
			                					<h:graphicImage value="images/icon_required.gif" rendered="#{semmsa005Bean.borrowContract.cannotBorrowFlag == 'true'}"/>
												<rich:spacer width="5" rendered="#{semmsa005Bean.borrowContract.cannotBorrowFlag == 'true'}"/>
												<h:outputText value="#{jspMsg['label.remarkCannotBorrow']}" styleClass="ms7"/>
			                				</td>
			                				<td width="55%">
			                					<h:inputTextarea id="txtRemarkCannotBorrow" 
												value="#{semmsa005Bean.borrowContract.remarkCannotBorrow}" 
												style="width:100%;" rows="3" 
			                					disabled="true"/>
			                				</td>
			                			</tr>
			                		</table>
			                			
			                		</td>
			                	</tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdPopupCommand">
						<a4j:commandButton id="btnSaveBorrowCtr" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="pnlBorrowContract,frmSearchResult,pnlSearchResult,dtbBorrowRequest,popupFrmBorrowError,
							btnExport,frmButton,grdAddCommand" 
							oncomplete="if(#{semmsa005Bean.popupClose == 'true'})#{rich:component('popupBorrowContract')}.hide();" 
							rendered="#{semmsa005Bean.mode == 'EDIT' || semmsa005Bean.mode == 'MULTIADD'}">	
							<a4j:actionparam name="navModule" value="sa" />
							<a4j:actionparam name="navProgram" value="SEMMSA005-6" />
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA005" />
							<a4j:actionparam name="methodWithNavi" value="doSaveContractDetail" />
							<a4j:actionparam name="rowId" value="#{semmsa005Bean.borrowContract.rowId}" />
							<a4j:actionparam name="mode" value="EDIT" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupBorrowContract" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
						</rich:panel>
				</a4j:form>
</rich:modalPanel>

