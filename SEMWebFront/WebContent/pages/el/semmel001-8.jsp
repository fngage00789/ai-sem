<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel001-8" var="jspMsg" />
<h:panelGrid width="100%">

	<rich:panel id="pnlBGPrivate">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid columnClasses="gridContent" width="90%">

			<!-- begin content layout -->

			<h:panelGrid width="100%">

				<a4j:form id="frmBGPrivate">

					<h:panelGroup>

						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<table id="tblMessage">
										<tr>
											<td>
												<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
												<h:message errorClass="ms7red" for="dtStartDt" />
												<h:message errorClass="ms7red" for="dtEndDt" />
												<h:message errorClass="ms7red" for="txtCoverageMoney" />
											</td>
										</tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td>
												<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
													<a4j:actionparam name="page" value="8" />
												</a4j:commandButton> 
											</td>
											<td>
												<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="8" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<rich:panel id="pnlCoverageMoneyInfo">
					
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td>
											<h:outputText value="#{jspMsg['label.coverageMoneyList']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td>
											<rich:dataTable id="dtbCoverageMoney" width="95%" cellpadding="1" cellspacing="0" border="0" 
												var="coverageMoney" value="#{semmel001Bean.wrapper.privateDepositList}" reRender="dtbCoverageMoney" 
												onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
												onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
												styleClass="contentform" >
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.action']}" />
													</f:facet>
													<div align="center">
														<h:selectBooleanCheckbox title="chkAction" value="#{coverageMoney.selected}" disabled="#{!coverageMoney.newFlagBoolean}">
															<a4j:support event="onclick" action="#{semmel001Action.doCalculateTotalSelectedPrivateDeposit}" reRender="txtCoverageMoney"/>
														</h:selectBooleanCheckbox>
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.coverageMoneyType']}" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{semmel001Bean.wrapper.bgTypeLabel}" styleClass="ms7" />
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.coverageMoneyValue']}" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{coverageMoney.depositAmt}" styleClass="ms7">
															<f:convertNumber type="currency" currencySymbol=""/>
														</h:outputText>
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.coverageMoneyStatus']}" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{jspMsg['label.old']}" rendered="#{!coverageMoney.newFlagBoolean}" styleClass="ms7" />
														<h:outputText value="#{jspMsg['label.new']}" rendered="#{coverageMoney.newFlagBoolean}" styleClass="ms7" />
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.header.remark']}" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{coverageMoney.remark}" styleClass="ms7" />
													</div>
												</rich:column>
											</rich:dataTable>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlBGDetailInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.bgDetail']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>  
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteName}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<rich:calendar id="dtStartDt"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.startDt']}"
												value="#{semmel001Bean.wrapper.bgMaster.bgStartDt}"
												oninputblur="validateRichCalendarFromTo('frmBGPrivate','dtStartDt','dtEndDt');"
											    oncollapse="validateRichCalendarFromTo('frmBGPrivate','dtStartDt','dtEndDt');"
												showWeeksBar="false" inputSize="18"/>
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="dtEndDt"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.endDt']}"
												value="#{semmel001Bean.wrapper.bgMaster.bgEndDt}"
												oninputblur="validateRichCalendarFromTo('frmBGPrivate','dtEndDt','dtStartDt');"
											    oncollapse="validateRichCalendarFromTo('frmBGPrivate','dtEndDt','dtStartDt');"
												showWeeksBar="false" inputSize="18"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.coverageMoney']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputText id="txtCoverageMoney" value="#{semmel001Bean.wrapper.bgMaster.bgAmt}" readonly="true"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												maxlength="16" style="text-align:right"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractAddress']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputTextarea id="txtContractAddress" rows="5" cols="50" value="#{semmel001Bean.wrapper.bgMaster.contractAddress}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteLocation']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputTextarea id="txtSiteLocation" rows="5" cols="50" value="#{semmel001Bean.wrapper.bgMaster.siteAddress}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputTextarea id="txtRemark" rows="5" cols="50" value="#{semmel001Bean.wrapper.bgMaster.remark}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" />  
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.bgStatus']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:selectOneMenu id="dstBGStatus" value="#{semmel001Bean.wrapper.bgMaster.bgStatus}" style="width : 120px">
			                					<f:selectItems value="#{semmel001Bean.bgStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td colspan="4" align="left">
											<h:outputText value="#{jspMsg['label.bgReceiveInfo']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<%--h:inputText id="txtBGNo" value="" size="30" style="width: 120px" disabled="true"/--%>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<%--h:selectOneMenu id="dstBankName" value="" style="width : 120px" disabled="true"/--%>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<%--h:inputTextarea id="txtBGRemark" rows="5" cols="50" value="" disabled="true"/--%>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlFileUpload">
						
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.saveFile']}" />
							</f:facet>
							
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
									
									<h:panelGroup>
									
										<table width="100%">
											<tr>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7" />
												</td>
												<td>
													<rich:fileUpload fileUploadListener="#{semmel001Action.uploadFileListener}" id="uplFileName" maxFilesQuantity="5" listHeight="150px" autoclear="true" uploadControlLabel="#{jspMsg['btn.addFile']}">
														<a4j:support event="onuploadcomplete" reRender="dtbFileList" />
													</rich:fileUpload>
												</td>
											</tr>
										</table>
										
									</h:panelGroup>
									
									<rich:panel id="pnlFileList">
									
										<table width="100%">
											<tr>
												<td>
													<h:outputText value="#{jspMsg['label.files']}" styleClass="ms7" />
												</td>
											</tr>
											<tr>
												<td>
													<rich:dataTable id="dtbFileList" width="95%" cellpadding="1" cellspacing="0" border="0" 
														var="fileInfo" value="#{semmel001Bean.meterFileList}" reRender="dtbFileList" 
														rows="0" rowKeyVar="row"
														onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
														onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
														styleClass="contentform" >
														<rich:column>
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.action']}" />
															</f:facet>
															<div align="center">
																<a4j:commandLink value="#{jspMsg['label.delete']}" action="#{navAction.navi}" reRender="pnlFileList">
																	<a4j:actionparam name="navModule" value="el" />
									            					<a4j:actionparam name="navProgram" value="SEMMEL001-8" />	
																	<a4j:actionparam name="moduleWithNavi" value="el" />
																	<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
																	<a4j:actionparam name="methodWithNavi" value="doDeleteFile" />
																	<a4j:actionparam name="deleteIndex" value="#{row}" />
																</a4j:commandLink>
															</div>
														</rich:column>
														<rich:column>
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.fileName']}" />
															</f:facet>
															<div align="left">
																<h:outputText value="#{fileInfo.fileName}" styleClass="ms7" />
															</div>
														</rich:column>
														<rich:column>
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.saveName']}" />
															</f:facet>
															<div align="left">
																<h:outputText value="#{fileInfo.createBy}" styleClass="ms7" />
															</div>
														</rich:column>
														<rich:column>
															<f:facet name="header">
																<h:outputText value="#{jspMsg['column.header.saveDt']}" />
															</f:facet>
															<div align="center">
																<h:outputText value="#{fileInfo.createDt}" styleClass="ms7" />
															</div>
														</rich:column>
													</rich:dataTable>
												</td>
											</tr>
										</table>
										
									</rich:panel>
									
								</h:panelGrid>
							
						</rich:panel>
						
					<rich:panel id="pnlLog">
					
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText id="txtCreateBy" value="#{semmel001Bean.wrapper.bgMaster.createBy}" styleClass="ms7"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText id="txtCreateDate" value="#{semmel001Bean.wrapper.createDt}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
				
				</a4j:form>
				
			</h:panelGrid>
						
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>