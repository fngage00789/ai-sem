<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.co.semmco003" var="jspMsg"/>

<rich:modalPanel id="popupReturnContract"
	height="500" minWidth="670" autosized="true">
	
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddContractReturn" style="cursor:pointer"/>
				<rich:componentControl for="popupReturnContract" attachTo="hidePopupAddContractReturn" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	<div id="container" style="overflow:auto;width: 100%; height:470px;">
		<h:panelGrid cellpadding="0" cellspacing="0" border="0">
			<a4j:form id="popupFrmReturn">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
				<a4j:form id="popupFrmAddContractReturn"> 
				<rich:panel id="pnlAddContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.popup.return']}"/>
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
											<h:outputText value="#{jspMsg['label.returnName']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td width="30%" valign="bottom">
			                		<a4j:region>
			                			<h:selectOneMenu id="ddlReturnName"
											value="#{semmco003Bean.returnContract.returnName}"
											disabled="#{semmco003Bean.mode == 'VIEW'}"
											onchange="ChkTxtReturnName();">
											<a4j:jsFunction name="ChkTxtReturnName"
												action="#{semmco003Action.chkTxtReturnName}"
												reRender="pnlAddContractStatus" />
											<f:selectItems value="#{semmco003Bean.borrowNameList}" />
										</h:selectOneMenu>
									</a4j:region>
			                			
					                </td>
					                
					                <td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.returnDt']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td valign="bottom" width="30%">
			                			<rich:calendar id="cldreturnDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmco003Bean.returnContract.returnDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											oninputkeyup="this.value = this.value.substring(0, 10);" 
											cellWidth="20px" cellHeight="20px"
			                				disabled="#{semmco003Bean.mode == 'VIEW'}">
										</rich:calendar>
					                </td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" width="20%" valign="baseline">
			                		</td>
			                		<td width="30%" valign="bottom">
			                			<h:inputText label="#{jspMsg['label.returnName']}" id="txtReturnName" 
			                				value="#{semmco003Bean.otherReturnName}"
			                				disabled="#{semmco003Bean.mode == 'VIEW'}" 
			                				rendered="#{semmco003Bean.disTxtReturnName}"/>
			                		</td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.returnOfficer']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">
			                			<h:selectOneMenu id="ddlOffcer" value="#{semmco003Bean.returnContract.returnOfficer}"
			                				disabled="#{semmco003Bean.mode == 'VIEW'}">
											<f:selectItems value="#{semmco003Bean.borrowOfficerList}"/>
										</h:selectOneMenu>
					                </td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="top">
			                			<%-- <h:panelGrid columns="2">
				                			<h:selectBooleanCheckbox id="cbxReturnNotAllFlag" 	
				                			     value="#{semmco003Bean.returnNotAllFlagBoolean}" 			                			    
				                				onclick="GetChkCbxReturnFlagJS();"
			                					disabled="#{semmco003Bean.mode=='VIEW'}">
				                				<a4j:jsFunction name="GetChkCbxReturnFlagJS" reRender="cbxDocReturnContractFlag,cbxDocContractFlag,cbxDocOtherFlag,cbxDocOtherAddFlag"/>
				                			</h:selectBooleanCheckbox>
				                			<h:outputText value="#{jspMsg['label.cbx.returnNotAllFlag']}" styleClass="ms7"/>
			                			</h:panelGrid> --%>
			                			<h:panelGrid columns="2">
				                			<h:selectBooleanCheckbox id="cbxReturnNotAllFlag" 	
				                			     value="#{semmco003Bean.returnNotAllFlagBoolean}" 	
			                					 disabled="#{semmco003Bean.mode=='VIEW'}">
			                					<a4j:support event="onclick" action="#{semmco003Action.selectReturnNotAllFlag}" reRender="cbxDocReturnContractFlag,cbxDocContractFlag,cbxDocOtherFlag,cbxDocOtherAddFlag"/>				                				
				                			</h:selectBooleanCheckbox>
				                			<h:outputText value="#{jspMsg['label.cbx.returnNotAllFlag']}" styleClass="ms7"/>
			                			</h:panelGrid>
			                			
			                			
			                		</td>
			                		<td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.cbx.returnNotAllDt']}" styleClass="ms7"/>
										</h:panelGroup>
			                		</td>
			                		<td valign="bottom">
			                			<rich:calendar id="cldReturnNotAllDt" locale="th" enableManualInput="true"  
											datePattern="dd/MM/yyyy" 
											value="#{semmco003Bean.returnContract.returnNotAllDt}" 
											showWeeksBar="false" 
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											oninputkeyup="this.value = this.value.substring(0, 10);" 
											cellWidth="20px" cellHeight="20px"
			                				disabled="#{semmco003Bean.mode == 'VIEW'}">
										</rich:calendar> 
					                </td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.documentReturn']}" styleClass="ms7" style="text-decoration: underline;"/>
										</h:panelGroup>
			                		</td>
			                		<td colspan="3" valign="bottom">&nbsp;</td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td valign="top">
			                			<h:panelGrid columns="2">
				                			<h:selectBooleanCheckbox id="cbxDocReturnContractFlag" 
				                				value="#{semmco003Bean.returnDocApproveFlagBoolean}" 
				                				disabled="#{semmco003Bean.mode=='VIEW'||semmco003Bean.disabledCheckBox}"/>
				                			<h:outputText value="#{jspMsg['label.cbx.docApproveFlag']}" styleClass="ms7"/>
			                			</h:panelGrid>
			                		</td>
			                	</tr>
			                	
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<table width="100%">
			                				<tr>
			                					<td valign="top" width="20%">
						                			
							                			<h:selectBooleanCheckbox id="cbxDocContractFlag" 
							                				value="#{semmco003Bean.returnDocContractFlagBoolean}" 
							                				disabled="#{semmco003Bean.mode=='VIEW'||semmco003Bean.disabledCheckBox}"/>
							                			<h:outputText value="#{jspMsg['label.cbx.docContractFlag']}" styleClass="ms7"/>
						                		
						                		</td>
						                		<td align="right" valign="top" width="20%">
						                			<h:panelGroup>
														<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
													</h:panelGroup>
						                		</td>
						                		<td align="right" valign="top" width="60%">
						                			<h:panelGroup>
														<h:inputTextarea id="txtDocContractDetail" value="#{semmco003Bean.returnContract.docContractDetail}" 
															style="width:100%;" rows="3" 
															disabled="#{semmco003Bean.mode == 'VIEW'}"/>
													</h:panelGroup>
						                		</td>
			                				</tr>
			                			</table>
			                		</td>
			                		
			                	</tr>
			                	<tr>
			                		<td align="right" valign="baseline">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<table width="100%">
			                				<tr>
			                				
					                		<td valign="top" width="25%">
					                			<h:panelGrid columns="2">
						                			<h:selectBooleanCheckbox id="cbxDocOtherFlag" 
						                				value="#{semmco003Bean.returnDocOtherFlagBoolean}" 
						                				disabled="#{semmco003Bean.mode=='VIEW'||semmco003Bean.disabledCheckBox}"/>
						                			<h:outputText value="#{jspMsg['label.cbx.docOtherFlag']}" styleClass="ms7"/>
					                			</h:panelGrid>
					                		</td>
					                		<td align="right" valign="top" width="15%">
					                			<h:panelGroup>
													<h:outputText value="#{jspMsg['label.otherDetail']}" styleClass="ms7"/>
												</h:panelGroup>
					                		</td>
					                		<td align="right" valign="top" width="60%">
					                			<h:panelGroup>
													<h:inputTextarea id="txtRemarkDocOther" value="#{semmco003Bean.returnContract.remarkDocOther}" 
														style="width:100%;" rows="3" 
														disabled="#{semmco003Bean.mode == 'VIEW'}"/>
												</h:panelGroup>
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
			                				
					                		<td valign="top" width="30%">
					                			<h:panelGrid columns="2">
						                			<h:selectBooleanCheckbox id="cbxDocOtherAddFlag" 
						                				value="#{semmco003Bean.docOtherAddFlagBoolean}" 
						                				disabled="#{semmco003Bean.mode == 'VIEW'||semmco003Bean.disabledCheckBox}">
						                				<a4j:support event="onclick" reRender="popupFrmAddContractReturn" action="#{semmco003Action.doShowRentType}"></a4j:support>
						                			</h:selectBooleanCheckbox>
						                			<h:outputText value="#{jspMsg['label.cbx.docOtherAddFlag']}" styleClass="ms7"/>
					                			</h:panelGrid>
					                		</td>
					                		<td align="right" valign="top" width="10%">
					                			<h:panelGroup>
													<h:outputText value="#{jspMsg['label.otherDetail']}" styleClass="ms7"/>
												</h:panelGroup>
					                		</td>
					                		<td align="right" valign="top" width="60%">
					                			<h:panelGroup>
													<h:inputTextarea  value="#{semmco003Bean.returnContract.docRemark}"
														style="width:100%;" rows="3" ></h:inputTextarea>
												</h:panelGroup>
					                		</td>
					               		</tr>
					               	</table>
			                		</td>
			                	</tr>
							</table>
							</h:panelGroup>
							
							<!-- NEW DOC USE THIS -->
							<h:panelGrid style="width:98%;" id="pnlRentalType" rendered="false">
                                <h:panelGroup style="width:98%;">
                                    <table style="width:98%;">
                                        <tr>
                                            <td style="border:solid ececec 1px; white-space:nowrap; vertical-align:top;">
                                                <h:panelGrid style="width:98%;" columns="2" columnClasses="leftColumn, rightColumn">
                                                    
                                                    <!-- panel left -->
                                                    <h:panelGroup id="msi002_left" style="width:350px; height:100%; white-space:nowrap; padding:10px 0 0 50px;">
                                                        <!-- dropdown 1 [legal place type] -->
                                                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                         <tr>
                                                             <td width="40%" valign="top" align="right">
                                                                  <h:outputText value="#{jspMsg['label.placeType']} : " styleClass="ms7" />
                                                             </td>
                                                             <td width="60%" align="left">
                                                                 <h:selectOneMenu id="txtPlaceType" value="#{semmco003Bean.siteAppObjParam.placeType}" styleClass="ms7"
                                                                    onchange="func_sendPlaceType();" style="width:120px;">
                                                                        <f:selectItems value="#{semmco003Bean.legalPlaceTypeList}"/>
                                                                  </h:selectOneMenu>
                                                                  
                                                                  <a4j:jsFunction name="func_sendPlaceType" action="#{semmco003Action.doGetLegalDoc}" reRender="msi002_left,msi002_right">
                                                                  </a4j:jsFunction>
                                                                   <div style="clear:both; height:2px;"></div>
                                                        
                                                                  <h:inputTextarea id="txtPlaceTypeRemark" value="#{semmco003Bean.siteAppObjParam.placeTypeRemark}" cols="20" rows="3" rendered="#{semmco003Bean.siteAppObjParam.placeType == '99'}"/>
                                                                  <div style="clear:both; height:2px;"></div>
                                                             </td>
                                                         </tr>
                                                         <tr>
                                                             <td valign="top" align="right">
                                                                  <h:outputText value="#{jspMsg['label.partiesType']} : " styleClass="ms7" />
                                                             </td>
                                                             <td align="left">
                                                                 <h:selectOneMenu id="txtPartiesType" value="#{semmco003Bean.siteAppObjParam.partiesType}" styleClass="ms7"
                                                                 onchange="func_sendPartiesType();" style="width:120px;">
                                                                    <f:selectItems value="#{semmco003Bean.legalPartiesTypeList}"/>
                                                                 </h:selectOneMenu>
                                                                 <a4j:jsFunction name="func_sendPartiesType" action="#{semmco003Action.doGetLegalDoc}" reRender="msi002_left,msi002_right">
                                                                 </a4j:jsFunction>
                                                                
                                                                 <div style="clear:both; height:2px;"></div>
                                                                 <h:inputTextarea id="txtPartiesTypeRemark" value="#{semmco003Bean.siteAppObjParam.partiesTypeRemark}" cols="20" rows="3" rendered="#{semmco003Bean.siteAppObjParam.partiesType == '99'}"/>
                                                        
                                                             </td>
                                                         </tr>
                                                        </table>
                                                    </h:panelGroup>
                                                    
                                                    <!-- panel right -->
                                                    <h:panelGroup id="msi002_right" style="width:auto; height:100%; vertical-align:top;">
                                                        <a4j:outputPanel id="msa002tab5_right_table">
                                                        
                                                        <rich:dataTable width="500px;" id="right_table" cellpadding="0" cellspacing="0" border="0"
                                                        var="item_" value="#{semmco003Bean.legalDocList}" reRender="dstLegalApproveSrchByAppv" 
                                                         styleClass="" rowClasses="" style="background:none;border-style:none;"> 
                                                            
                                                            <rich:column id="itemNumber" sortBy="" styleClass="" style="background:none;border-style:none;">
                                                                <div align="center">
                                                                    <h:inputHidden  value="#{item_.dataObj.itemCode}" />
                                                                    <h:outputText value="#{item_.dataObj.itemNumber}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:column id="itemDesc" sortBy="" style="background:none;border-style:none;" width="300px;">
                                                                <div align="left">
                                                                    <h:outputText value="#{item_.dataObj.itemDesc}" style="" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:column id="chkHaveFlag" sortBy="" style="background:none;border-style:none;">
                                                                <div align="center" style="background:none;border-style:none;">
                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkHaveFlag" value="#{item_.dataObj.chkHaveFlag}" >
                                                                       <a4j:support event="onclick" action="#{semmco003Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
                                                                            <f:param name="checkBoxStatus" value="Y"></f:param>
                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                       </a4j:support>
                                                                    </h:selectBooleanCheckbox>
                                                                    <h:outputText value="#{jspMsg['label.th_have']}" style="padding-right:10px;" styleClass="ms7" />
                                                                    
                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkNotHaveFlag" value="#{item_.dataObj.chkNotHaveFlag}">
                                                                       <a4j:support event="onclick" action="#{semmco003Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
                                                                            <f:param name="checkBoxStatus" value="N"></f:param>
                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                       </a4j:support>         
                                                                    </h:selectBooleanCheckbox>
                                                                    <h:outputText value="#{jspMsg['label.th_notHave']}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:columnGroup>
	                                                        	<rich:column colspan="4" style="border:0px;">
			                                                        <div style="background:none;border-style:none;">
			                                                            <h:outputText value="#{jspMsg['label.th_specify']}.." rendered="#{item_.dataObj.itemDispRemark == 'Y'}"
			                                                            style="padding:0 5 0 40px;" styleClass="ms7" />
			                                                            
			                                                            <h:inputTextarea id="txtTypeRemark" value="#{item_.dataObj.itemRemark}" styleClass="ms7" 
			                                                            style="width:620px;" cols="20" rows="3" rendered="#{item_.dataObj.itemDispRemark == 'Y'}"/>
			                                                        </div>
			                                                    </rich:column>
			                                                </rich:columnGroup>
                                                            
                                                        
                                                        </rich:dataTable>
                                                        
                                                        </a4j:outputPanel>
                                                    </h:panelGroup>
                                                </h:panelGrid>
                                            </td>
                                        </tr>        
                                    </table>
                                </h:panelGroup>     
                          </h:panelGrid>
								
								<!-- Old Doc did'n use -->
								<rich:panel rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.documentType']}" />
									</f:facet>
									<h:panelGrid width="99%">
										<h:panelGroup>
										 
											<table width="98%"> 
												
												<tr>
													<td width="55%" valign="top">
														<table>
															<tr>
																<td>
																 	<h:selectOneRadio id="rbtRentType1" value="#{semmco003Bean.returnContract.rentType}"  layout="pageDirection" 
																 	 styleClass="ms7" rendered="true" onclick="rentTypeShow()" disabled="#{semmco003Bean.pageMode || semmco003Bean.mode == 'VIEW'}">
										                						<a4j:jsFunction name="rentTypeShow" action="#{semmco003Action.doShowRentType}"
										                						 reRender="frmAdd,pnlRentalType" oncomplete="checkUnSelect();"/>
												                				<f:selectItem itemValue="01" itemLabel="ที่ดิน" />
												                				<f:selectItem itemValue="02" itemLabel="อาคารพาณิชย์" />
												                				<f:selectItem itemValue="03" itemLabel="บริษัท/ห้างร้าน" />
												                				<f:selectItem itemValue="04" itemLabel="นิติบุคคลอาคารชุด" />
												                				<f:selectItem itemValue="05" itemLabel="ปักเสา" />
												                				<f:selectItem itemValue="06" itemLabel="ป้ายโฆษณา" />
												                				<f:selectItem itemValue="07" itemLabel="สถานที่ราชการ" />
												                				<f:selectItem itemValue="99" itemLabel="อื่นๆ" />
										                			</h:selectOneRadio>
									                			</td>
									                			<td valign="bottom">
						                							<h:inputText value="#{semmco003Bean.returnContract.rentTypeOtherRemark}" size="13"></h:inputText>
																</td>
								                			</tr>
								                		</table>
													</td>
													<td width="60%" valign="top">
														<h:panelGroup id="pnlRentalType1" rendered="#{semmco003Bean.disableChk1}">
															<table width="90%" cellpadding="0" cellspacing="0" border="0">
																<tr>
																	<h:outputText value="เอกสารที่ขาด-ที่ดิน" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																			<tr>
																				<td>
																					<h:selectManyCheckbox id="chkDoc011" disabled="#{semmco003Bean.pageMode || semmco003Bean.mode == 'VIEW'}"
																			  			value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																						<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																					 </h:selectManyCheckbox>
																				</td>
																			</tr>
																		</table>
																			
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc012" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>	
																			 			<h:selectManyCheckbox id="chkDoc013" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc014" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc015" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc016" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc017" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc018" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																		 
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther1" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>	 
																						 <h:inputText id="txtDocOtherRemark1" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						 size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table> 
																		</td>
																		
																	</tr>	 
															</table>
														</h:panelGroup>	
														
														<h:panelGroup id="pnlRentalType2" rendered="#{semmco003Bean.disableChk2}">
															<table>
																<tr>
																	<h:outputText value="เอกสารที่ขาด-อาคารพาณิชย์" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						<h:selectManyCheckbox id="chkDoc021" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																						   	<f:selectItem itemLabel="สำเนาบัตรประชาชน" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																		</table> 
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc022" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																		</table> 
																		</td>	 
																	</tr>
																	<tr>
																		<td>	
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc023" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารเช่า" itemValue="Y" />
																						 </h:selectManyCheckbox>
																				    </td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc024" disabled="#{semmco003Bean.pageMode}"
																			 				 value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																						 </h:selectManyCheckbox>
																						 <rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" /><br/><br/>
																						 <rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" /><br/><br/>
																						 <rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" /><br/><br/>
																						 <rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" />
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc025" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc026" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc027" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDocOther2" disabled="#{semmco003Bean.pageMode}"
																			 				 value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>
																						<h:inputText id="txtDocOtherRemark2" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table>	 
																		 </td>
																	</tr>	 
															</table>
														</h:panelGroup>
														
														<h:panelGroup id="pnlRentalType3" rendered="#{semmco003Bean.disableChk3}">
															<table>
																<tr>
																	<h:outputText value="เอกสารที่ขาด-บริษัท/ห้างร้าน" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						<h:selectManyCheckbox id="chkDoc031" disabled="#{semmco003Bean.pageMode}"
																		 					 value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนกรรมการ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																		</table>
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc032" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้านกรรมการ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																		</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>	
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc033" disabled="#{semmco003Bean.pageMode}"
																			 				 value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือรับรองนิติบุคคล" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>	
																						 <h:selectManyCheckbox id="chkDoc034" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																								<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารที่เช่า" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>	 
																		</td>
																	</tr>
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc035" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 			<rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" />
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc036" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc037" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc038" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDocOther3" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>
																						<h:inputText id="txtDocOtherRemark3" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						  size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table>																			
																		 </td>
																	</tr>	 
															</table>
														</h:panelGroup>
														
														<h:panelGroup id="pnlRentalType4" rendered="#{semmco003Bean.disableChk4}">
															<table>
																<tr>
																	<h:outputText value="เอกสารที่ขาด-นิติบุคคลอาคารชุด" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						<h:selectManyCheckbox id="chkDoc041"  disabled="#{semmco003Bean.pageMode}"
																						  value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																						<f:selectItem itemLabel="สำเนาทะเบียนบ้านของอาคาร" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																		</table>
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc042" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้านผู้จัดการ ฯ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>	
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc043" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนผู้จัดการ ฯ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td>	
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc044" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รายาการจดทะเีบียนนิิติบุคคลอาคารชุด" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc045" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รายงานการประชุมนิติบุคคลอาคารชุด" itemValue="Y" />
																						 </h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc046" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รายการจดทะเบียนนิติบุคคลอาคารชุด ระบุ ชื่อ-ที่อยู่ ผู้จัดการ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc047" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc048" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc049" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc9List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:outputText value="**ในกรณีนิติบุคคลเป็นผู้จัดการขอหลักฐานหนังสือรับรอง" styleClass="ms7" />
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther4" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>
																						<h:inputText id="txtDocOtherRemark4" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						 size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>	 
															</table>
														</h:panelGroup>
														
														<h:panelGroup id="pnlRentalType5" rendered="#{semmco003Bean.disableChk5}">
															<table width="90%">
																<tr>
																	<h:outputText value="เอกสารที่ขาด-ปักเสา" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																			<tr>
																				<td>
																					<h:selectManyCheckbox id="chkDoc051" disabled="#{semmco003Bean.pageMode}"
																			  			value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																						<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y"/>
																					 </h:selectManyCheckbox>
																				</td>
																			</tr>
																		</table>
																			
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc052" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>	
																			 			<h:selectManyCheckbox id="chkDoc053" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc054" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc055" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc056" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc057" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc058" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																		 
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther5" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>	 
																						 <h:inputText id="txtDocOtherRemark5" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						  size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table> 
																		</td>
																		
																	</tr>	 
															</table>
														</h:panelGroup>	
														
														<h:panelGroup id="pnlRentalType6" rendered="#{semmco003Bean.disableChk6}">
															<table width="90%">
																<tr>
																	<h:outputText value="เอกสารที่ขาด-ป้ายโฆษณา" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																			<tr>
																				<td>
																					<h:selectManyCheckbox id="chkDoc061" disabled="#{semmco003Bean.pageMode}"
																			  			value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																						<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																					 </h:selectManyCheckbox>
																				</td>
																			</tr>
																		</table>
																			
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc062" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>	
																			 			<h:selectManyCheckbox id="chkDoc063" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc064" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc065" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>	 
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc066" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc067" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc068" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther6" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>	 
																						 <h:inputText id="txtDocOtherRemark6" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						  size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table> 
																		</td>
																		
																	</tr>	 
															</table>
														</h:panelGroup>	
														
														<h:panelGroup id="pnlRentalType7" rendered="#{semmco003Bean.disableChk7}">
															<table width="90%">
																<tr>
																	<h:outputText value="เอกสารที่ขาด-อื่นๆ" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																			<tr>
																				<td>
																					<h:selectManyCheckbox id="chkDoc991" disabled="#{semmco003Bean.pageMode}"
																			  			value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																						<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																					 </h:selectManyCheckbox>
																				</td>
																			</tr>
																		</table>
																			
																	</td>
																</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc992" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>	 
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>	
																			 			<h:selectManyCheckbox id="chkDoc993" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		</td>
																	</tr>	
																	<tr>
																		<td> 
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc994" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7" onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 		</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc995" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc5List}" layout="lineDirection" styleClass="ms7"  onclick="checkUnSelect();"> 
																							<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>	 
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc996" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารเช่า" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDoc997" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																			 			</h:selectManyCheckbox>
																			 			<rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" /><br/><br/>
																			 			<rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" />
																			 		</td>
																				</tr>
																		</table>
																		</td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc098" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc099" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc9List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc0910" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc10List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther7" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>
																						 <h:inputText id="txtDocOtherRemark7" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						  size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table> 
																		</td>
																		
																	</tr>	 
															</table>
														</h:panelGroup>
														
														<h:panelGroup id="pnlRentalType8" rendered="#{semmco003Bean.disableChk8}">
															<table width="90%">
																<tr>
																	<h:outputText value="เอกสารที่ขาด-สถานที่ราชการ" styleClass="ms7" style="text-decoration:underline;"/>
																</tr>
																<tr>
																	<td>
																		<table cellpadding="0" cellspacing="0" border="0">
																			<tr>
																				<td>
																					<h:selectManyCheckbox id="chkDoc071" disabled="#{semmco003Bean.pageMode}"
																			  			value="#{semmco003Bean.doc1List}" layout="lineDirection" styleClass="ms7" > 
																						<f:selectItem itemLabel="ใบอนุญาตให้เข้าดำเนินการติดตั้ง" itemValue="Y" />
																					 </h:selectManyCheckbox>
																				</td>
																			</tr>
																		</table>
																			
																	</td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc072" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc073" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																						 <h:selectManyCheckbox id="chkDoc074" disabled="#{semmco003Bean.pageMode}"
																							  value="#{semmco003Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																				</tr>
																			</table>
																		 </td>
																	</tr>
																	
																	<tr>
																		<td>
																			<table cellpadding="0" cellspacing="0" border="0">
																				<tr>
																					<td>
																			 			<h:selectManyCheckbox id="chkDocOther8" disabled="#{semmco003Bean.pageMode}"
																			  				value="#{semmco003Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																							<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																						 </h:selectManyCheckbox>
																					</td>
																					<td>	 
																						 <h:inputText id="txtDocOtherRemark8" value="#{semmco003Bean.returnContract.docOtherRemark}" 
																						  size="17" maxlength="300" disabled="#{semmco003Bean.pageMode}"/>
																					</td>
																				</tr>
																			</table> 
																		</td>
																		
																	</tr>	 
															</table>
														</h:panelGroup>	
														&nbsp;
													</td>
												</tr>
											</table>
											<!-- end content criteria -->
										</h:panelGroup>
									</h:panelGrid>
								</rich:panel>
							
						</h:panelGrid>
						
					</rich:panel>
						
						
					<h:panelGrid columns="2" id="grdReturnCommand">
										<a4j:commandButton id="btnSaveReturn" value="#{jspMsg['btn.save']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="frmSearchResult,pnlSearchResult,dtbBorrowRequest,popupFrmReturn,frmBorrowError,
											btnExport,frmButton,grdAddCommand" 
											oncomplete="if(#{semmco003Bean.popupClose == 'true'})#{rich:component('popupReturnContract')}.hide();" 
											rendered="#{semmco003Bean.mode != 'VIEW'}">	
											<a4j:actionparam name="navModule" value="co" />
											<a4j:actionparam name="navProgram" value="SEMMCO003-6" />
											<a4j:actionparam name="moduleWithNavi" value="co" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCO003" />
											<a4j:actionparam name="methodWithNavi" value="doSaveContractReturn" />
										</a4j:commandButton>
										<a4j:commandButton id="btnCancelReturn" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
											<rich:componentControl for="popupReturnContract" operation="hide" event="onclick" />
										</a4j:commandButton>
					</h:panelGrid>
				</a4j:form>
		</div>		
</rich:modalPanel>

