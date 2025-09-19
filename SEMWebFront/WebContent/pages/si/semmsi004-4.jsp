<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<rich:modalPanel id="popupAddLessor" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.lessor']}"/>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddLessor" style="cursor:pointer"/>
				<rich:componentControl for="popupAddLessor" attachTo="hidePopupAddLessor" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorLessor">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab2Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:region id="rgnPopupAddLessor">
				<h:form id="frmPopupAddLessor"> 
				<h:panelGrid width="800" id="grdPopupAddLessor">
					<rich:panel id="pnlPopupAddLessor">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.addLessor']}"/>
						</f:facet>
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right" width="25%" valign="top">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
			                			<h:inputTextarea id="txtLessorName" value="#{semmsi004tab2Bean.siteLessor.lessorName}" 
			                			cols="100" rows="3"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4">
					           		<a4j:commandButton id="btnCopy" value="#{jspMsg['btn.copyFromSiteInfo']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" 
					           		reRender="txtLessorHouserNo,txtLessorStreet,txtLessorTambon,ddlLessorAmphurId,ddlLessorProvinceId,txtLessorPostcode" 
					           		style="width:170">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-4" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2"/>
									<a4j:actionparam name="methodWithNavi" value="doCopySiteInfoAddressToLessorAddress" />
					           		</a4j:commandButton>
		                			</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.addressNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" >
		                			<h:inputTextarea id="txtLessorHouserNo" value="#{semmsi004tab2Bean.siteLessor.houseNo}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
		                			<h:inputText id="txtLessorStreet" value="#{semmsi004tab2Bean.siteLessor.street}"
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteTambon']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" >
		                			<h:inputText id="txtLessorTambon" value="#{semmsi004tab2Bean.siteLessor.tambon}" 
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
		                			<h:selectOneMenu id="ddlLessorAmphurId" value="#{semmsi004tab2Bean.siteLessor.amphurId}">
									<f:selectItems value="#{semmsi004tab2Bean.lessorAmphurList}"/>
							 		</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteProvince']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
		                			<h:selectOneMenu id="ddlLessorProvinceId" value="#{semmsi004tab2Bean.siteLessor.provinceId}" onchange="GetLessorAmphurListJS();">
									<f:selectItems value="#{semmsi004Bean.provinceList}"/>
									<a4j:jsFunction name="GetLessorAmphurListJS" reRender="ddlLessorAmphurId" action="#{semmsi004tab2Action.getLessorAmphurList}"/>
							 		</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.sitePostcode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtLessorPostcode" value="#{semmsi004tab2Bean.siteLessor.postcode}"  
                					size="8" maxlength="10"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.telephone']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
		                			<h:inputTextarea id="txtLessorTel" value="#{semmsi004tab2Bean.siteLessor.tel}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" >
		                			<h:inputText id="txtLessorFax" value="#{semmsi004tab2Bean.siteLessor.fax}"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
		                			</td>
		                			<td width="75%" >
		                			<h:selectBooleanCheckbox id="chkOverFlag" value="#{semmsi004tab2Bean.chkOverFlag}" styleClass="ms7"/>
						             <h:outputText value="#{jspMsg['label.overFlag']}" styleClass="ms7" />
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
		                			</td>
		                			<td width="75%" >
		                			<h:panelGrid columns="2" id="grdPopupCommand">
									<a4j:commandButton id="btnSaveLessor" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorLessor,dtbLessor,pnlLessorName" 
									oncomplete="if(#{semmsi004tab2Bean.popupClose == 'true'})#{rich:component('popupAddLessor')}.hide();">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
									<a4j:actionparam name="methodWithNavi" value="doSaveLessor" />
									</a4j:commandButton>
									<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
										<rich:componentControl for="popupAddLessor" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGrid>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				</h:form>
				</a4j:region>
</rich:modalPanel>

<rich:modalPanel id="popupAddLessor_popup" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.lessor']}"/>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddLessor_popup" style="cursor:pointer"/>
				<rich:componentControl for="popupAddLessor_popup" attachTo="hidePopupAddLessor_popup" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorLessor_popup">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab2Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:region id="rgnPopupAddLessor_popup">
				<h:form id="frmPopupAddLessor_popup"> 
				<h:panelGrid width="800" id="grdPopupAddLessor_popup">
					<rich:panel id="pnlPopupAddLessor_popup">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.addLessor']}"/>
						</f:facet>
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
									</td>
									<td style="width:90%; text-align:left;">
										<h:selectOneMenu>
											<f:selectItems value="#{semmsi004tab2Bean.titleList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
			                	<tr>
									<td align="right" width="25%" valign="top">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
			                			<h:inputTextarea id="txtLessorName_popup" value="#{semmsi004tab2Bean.siteLessor.lessorName}" 
			                			cols="100" rows="3"/>
				                	</td>
			                	 </tr>
			                	 <tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.th_taxId']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputText style="width:400px;"></h:inputText>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.th_personalId']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputText style="width:400px;"></h:inputText>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<rich:calendar locale="th" enableManualInput="true" 
														   datePattern="dd/MM/yyyy" 
														   value=""
														   showWeeksBar="false"
														   inputSize="10"
														   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													   	   cellWidth="15px" cellHeight="20px"
													   	   label=""
													   	   styleClass="ms7">
												</rich:calendar>
											</td>
										</tr>
			                	 
			                	 
			                	 <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4">
					           		<a4j:commandButton id="btnCopy_popup" value="#{jspMsg['btn.copyFromSiteInfo']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" 
					           		reRender="txtLessorHouserNo_popup,txtLessorStreet_popup,txtLessorTambon_popup,
					           		ddlLessorAmphurId_popup,ddlLessorProvinceId_popup,txtLessorPostcode_popup" 
					           		style="width:170">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-4" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2"/>
									<a4j:actionparam name="methodWithNavi" value="doCopySiteInfoAddressToLessorAddress" />
					           		</a4j:commandButton>
		                			</td>
			                	</tr>
			                	 
			                	<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
															<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
														</td>
														<td colspan="5">
															<h:inputTextarea id="txtLessorHouserNo_popup" value="#{semmsi004tab2Bean.siteLessor.houseNo}"
				                               	 			rows="3" style="width:80%;" styleClass="ms7"></h:inputTextarea>
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:inputText id="msi004tab2_lessorBuilding_popup" value="" maxlength="500" style="width:80%;" styleClass="ms7" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
														</td>
														<td style="white-space:nowrap;">
															<h:inputText id="msi004tab2_lessorFloor_popup" value="" style="text-align:right; width:150px;" styleClass="ms7" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
														</td>
														<td style="width:30%; white-space:nowrap;">
															<h:inputText id="msi004tab2_lessorRoomNo_popup" value="" style="text-align:right;" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<h:inputText id="txtLessorStreet_popup" value="#{semmsi004tab2Bean.siteLessor.street}"
															 style="width:80%;" styleClass="ms7" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
														</td>
														<td colspan="3">
															<h:inputText id="txtLessorTambon_popup" value="#{semmsi004tab2Bean.siteLessor.tambon}" style="width:40%;" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:selectOneMenu id="ddlLessorAmphurId_popup" value="#{semmsi004tab2Bean.siteLessor.amphurId}">
																<f:selectItems value="#{semmsi004tab2Bean.lessorAmphurList}"/>
													 		</h:selectOneMenu>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<h:selectOneMenu id="ddlLessorProvinceId_popup" value="#{semmsi004tab2Bean.siteLessor.provinceId}" onchange="GetLessorAmphurListJS();">
																<f:selectItems value="#{semmsi004Bean.provinceList}"/>
																<a4j:jsFunction name="GetLessorAmphurListJS" reRender="ddlLessorAmphurId" action="#{semmsi004tab2Action.getLessorAmphurList}"/>
													 		</h:selectOneMenu>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
														</td>
														<td style="width:30%;" >
															<h:inputText id="txtLessorPostcode_popup" value="#{semmsi004tab2Bean.siteLessor.postcode}" 
															style="text-align:right;" maxlength="5" styleClass="ms7" 
															onkeypress="return numberformat.keyPressIntegerOnly(this, event);" />
														</td>
													</tr>
													
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="txtLessorTel_popup" value="#{semmsi004tab2Bean.siteLessor.tel}"  
															style="width:300px;" styleClass="ms7"/>
														
															<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_lessorMobile_popup" value="" 
															style="width:300px;" styleClass="ms7" />
														</td>
														<td colspan="2"></td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="txtLessorFax_popup" value="#{semmsi004tab2Bean.siteLessor.fax}"
															style="width:300px;" styleClass="ms7" />
														
															<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_lessorEmail_popup" value="" 
															style="width:300px;" styleClass="ms7" />
														</td>
														<td colspan="2"></td>
													</tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
		                			</td>
		                			<td width="75%" >
		                			<h:selectBooleanCheckbox id="chkOverFlag_popup" value="#{semmsi004tab2Bean.chkOverFlag}" styleClass="ms7"/>
						             <h:outputText value="#{jspMsg['label.overFlag']}" styleClass="ms7" />
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
		                			</td>
		                			<td width="75%" >
		                			<h:panelGrid columns="2" id="grdPopupCommand_popup">
									<a4j:commandButton id="btnSaveLessor_popup" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorLessor_popup,dtbLessor_popup,pnlLessorName_popup" 
									oncomplete="if(#{semmsi004tab2Bean.popupClose == 'true'})#{rich:component('popupAddLessor')}.hide();">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
									<a4j:actionparam name="methodWithNavi" value="doSaveLessor" />
									</a4j:commandButton>
									<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
										<rich:componentControl for="popupAddLessor_popup" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGrid>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				</h:form>
				</a4j:region>
</rich:modalPanel>


<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_05] -->
	<rich:modalPanel id="msi004PopUpCommon_tab4AddContractElUse" width="900" autosized="true" top="70">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Add Contract"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msi004PopUpCommon_tab4AddContractElUse" style="cursor:pointer" />
					<rich:componentControl for="msi004PopUpCommon_tab4AddContractElUse" attachTo="hide-msi004PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsi004PopUpCommon_tab4AddContractElUse">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchCriteria']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
		                	<td align="right" width="25%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab4AddContractElUse_txtContractNo" value="#{semmsi004tab5Bean.contractElUseObjParam.contractNo}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="20%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_name']} Site :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="tab4AddContractElUse_txtLocationName" value="#{semmsi004tab5Bean.contractElUseObjParam.locationName}" 
                				size="30" maxlength="20"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_company']} :" styleClass="ms7"/>
                			</td>
                			<td colspan="3">
                				<h:selectOneMenu id="tab4AddContractElUse_drpCompany" value="#{semmsi004tab5Bean.contractElUseObjParam.company}" styleClass="ms7">
									<f:selectItems value="#{semmsi004Bean.companyList}"/>
								</h:selectOneMenu>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmsi004tab5Action.tab4AddContractElUse_doSearchContractElUse}"
					reRender="frmMsi004PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmsi004tab5Action.tab4AddContractElUse_doClearContractElUse}"
					reRender="frmMsi004PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchResult']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchContractElUse" cellpadding="1" cellspacing="0" border="0" 
							var="contractElUseLst"  value="#{semmsi004tab5Bean.contractElUseList}" reRender="dataTable_searchContractElUse, dataScrll_searchContractElUse" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								<!-- header -->
								<f:facet name="header">
					                <rich:columnGroup>
					                    <rich:column style="width:80px; text-align:center;"> 
											<h:outputText value="Select"/>
					                    </rich:column>  
					                    <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']}"/>
                                        </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_name']} Site"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_startDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_endDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                </rich:columnGroup>
					            </f:facet>
					            <!-- header -->
						
								<!-- data -->
								<rich:column>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
										action="#{semmsi004tab5Action.tab4AddContractElUse_doAddContractElUse}"
										reRender="msi004tab5_elUseOthSiteContractNo">
											<a4j:actionparam name="paramContractNo" value="#{contractElUseLst.dataObj.contractNo}" />
											
											<rich:componentControl for="msi004PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick" />
										</a4j:commandLink>
			                        </div>
			                    </rich:column>
			                    <rich:column style="text-align:center;">
                                    <h:outputText value="#{contractElUseLst.dataObj.contractNo}" />
                                </rich:column>
			                    <rich:column>
			                        <h:outputText value="#{contractElUseLst.dataObj.locationName}" />
			                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.effectiveDtStr}" />
			                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.expireDtStr}" />
			                    </rich:column>
					            <!-- data -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsi004tab5Bean.contractElUseList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchContractElUse"
													maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchContractElUse" style="background-color: #cccccc;"
													page="#{semmsi004tab5Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsi004PopUpCommon_tab4AddContractElUse"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msi004PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_05] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->
