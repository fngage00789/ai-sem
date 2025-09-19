
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab1" style="width:100%;" columns="1">
	
		<rich:panel id="inner_panelTab1" style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_info_station']}" />
			</f:facet>
			<!-- << header content -->

				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
							   <a4j:commandButton id="btnUpload"
			                    action="#{navAction.navi}"
			                        reRender="oppContent"
			                        rendered="false"
			                        value="#{jspMsg['btn.attachFile']} 1" styleClass="rich-button" style="width:110">
			                             <a4j:actionparam name="navModule" value="sa" />
			                            <a4j:actionparam name="navProgram" value="SEMMSA002-2" />
			                                    
			                            <a4j:actionparam name="moduleWithNavi" value="sa" />
			                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
			                            <a4j:actionparam name="methodWithNavi" value="doUploadFile" />
				                         <a4j:actionparam name="contractNo" value="#{semmsa002Bean.siteAppObjParam.contractId}"/>
				                         <a4j:actionparam name="popupFlag" value="N" />
			                    </a4j:commandButton>
			                    
			                    <a4j:commandButton id="btnUploadFile"
			                            action="#{navAction.navi}"
			                            reRender="btnUploadFile,popupUploadPictureCriteria"
			                            rendered="#{semmsa002Bean.siteAppObjParam.contractId != ''}"
			                            value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
			                            oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false">
			                                <a4j:actionparam name="navModule" value="common" />
			                                 <a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
			                                 <a4j:actionparam name="moduleWithNavi" value="common" />
			                                 <a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
			                                 <a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
			                                 <a4j:actionparam name="refId" value="" />
			                                 <a4j:actionparam name="module" value="SA"/>
			                                 <a4j:actionparam name="contractNo" value="#{semmsa002Bean.siteAppObjParam.contractId}"/>
			                                 <a4j:actionparam name="viewMode" value="N" />
			                            </a4j:commandButton>
			                     <a4j:jsFunction name="clearUpload" action="#{semmsa002Action.doClearUpload}" reRender="oppContent,btnUpload,btnUploadFile" />
			                    <rich:spacer width="5"/>
								
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab1_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_station']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="tab1_panel_popupModalRetStatus,popupDisplay1"
								oncomplete="#{rich:component('tab1_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="1"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab1"  viewId="../../pages/sa/semmsa002PopUpTab1.jsp" />
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- << group 0 -->

				<div style="clear:both; height:10px;"></div>
				<h:panelGrid id="msgTopTab1">
					<rich:messages id="msgPnlTab1" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormSearch}">
                        
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
				</h:panelGrid>
				<!-- >> group 1 -->
				<rich:panel>
				<h:panelGroup style="width:100%;">
					<!-- table column: 10:20, 10:20, 40 -->
					<table style="width:100%; border:solid 1px;">
                    	<tr>
                        	<td align="right" width="20%" valign="baseline">
                            	<h:outputText value="#{jspMsg['label.th_type_approve']} : " styleClass="ms7" />
							</td>
                            <td width="30%" valign="bottom">
                            	<h:inputText id="msa002tab1_docTypeText" value="#{semmsa002Bean.siteAppObjParam.docTypeText}" 
								disabled="true" maxlength="200" styleClass="ms7" />
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            	<h:outputText value="#{jspMsg['label.th_subject']} : " styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"/>
                            </td>
                            <td width="30%" valign="bottom">
                            	<h:selectOneMenu id="msa002tab1_title" value="#{semmsa002Bean.siteAppObjParam.title}"
                            	disabled="#{semmsa002Bean.disabledModeViewOnly}"
                            	rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}">
                            		<f:selectItems value="#{semmsa002Bean.reqTitleList}"/>
                            	</h:selectOneMenu>
                            
                            </td>
                     	</tr>
                     	
						<tr>
                        	<td align="right" width="20%" valign="baseline">
                        		<h:outputText value="* " style="font-style:bold; color:red;" />
                            	<h:outputText value="#{jspMsg['label.th_company']} : " styleClass="ms7" />
							</td>
                            <td width="30%" valign="bottom">
                            	<h:selectOneMenu id="msa002tab1_company" value="#{semmsa002Bean.siteAppObjParam.company}" 
                            	styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.siteAppObjParam.reqType != '01'}">
									<f:selectItems value="#{semmsa002Bean.companyList}"/>
								</h:selectOneMenu>
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            
                            				<h:selectBooleanCheckbox id="msa002tab1_chkRegionManual" value="#{semmsa002Bean.chkRegion}"
											onclick="msa002tab1_doChkRegionJS();"  disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
                            			
                            				<a4j:jsFunction name="msa002tab1_doChkRegionJS" reRender="msa002tab1_region"></a4j:jsFunction>
                            			
                            				<h:outputText value="#{jspMsg['label.th_location']} : " style="vertical-align:middle;" styleClass="ms7" />
                            			
                            </td>
                            <td width="30%" valign="bottom">
                            	<h:selectOneMenu id="msa002tab1_region" value="#{semmsa002Bean.siteAppObjParam.region}" styleClass="ms7" 
                            	disabled="#{!semmsa002Bean.chkRegion || semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.regionList}"/>
								</h:selectOneMenu>
                            </td>
                     	</tr>
                     	
                     	<tr>
                        	<td align="right" width="20%" valign="baseline">
							</td>
                            <td width="30%" valign="bottom" colspan="2">
                            	
								<h:inputHidden value="#{semmsa002Bean.siteAppLocalObjParam.mainLocalSiteType}"></h:inputHidden>
                            </td>
                            
                            <td width="30%" valign="bottom">
                            
                            </td>
                     	</tr>
                     	
                     	<tr>
                        	<td align="right" width="20%" valign="baseline">
                            	<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_sa_request']} : " styleClass="ms7" />
							</td>
                            <td width="30%" valign="bottom">
                            	<a4j:region>
									<h:selectOneMenu style="" id="msa002tab1_reqOfficer" value="#{semmsa002Bean.siteAppObjParam.reqOfficer}" 
									disabled="#{semmsa002Bean.chkReqOfficerManual || semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
										<f:selectItems value="#{semmsa002Bean.reqOfficerList}"/>
									</h:selectOneMenu>
								</a4j:region>
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            	
                            				<h:selectBooleanCheckbox id="msa002tab1_chkReqOfficerManual" value="#{semmsa002Bean.chkReqOfficerManual}"
											onclick="msa002tab1_doChkReqOfficerJS();"  disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
											<a4j:jsFunction name="msa002tab1_doChkReqOfficerJS" reRender="msa002tab1_reqOfficer, msa002tab1_reqOfficerManual" 
											action="#{semmsa002Action.doChkReqOfficer}"/>
                            			
                            				<h:outputText value=" #{jspMsg['label.th_specify_by_owner']} : " style="vertical-align:middle;" styleClass="ms7" />	
                            			
									
                            </td>
                            <td width="30%" valign="bottom">
                            	<h:inputText id="msa002tab1_reqOfficerManual" value="#{semmsa002Bean.siteAppObjParam.reqOfficerManual}"  
                            	disabled="#{!semmsa002Bean.chkReqOfficerManual || semmsa002Bean.disabledModeViewOnly}"
								maxlength="200" styleClass="ms7" style="width:100%;" />
                            </td>
                     	</tr>
                     	<tr>
                        	<td align="right" width="20%" valign="baseline">
                            	<h:outputText value="#{jspMsg['lable.th_acquistion_creator']} : " styleClass="ms7" />
							</td>
                            <td width="30%" valign="bottom">
                            	<h:inputText id="msa002tab1_acqCreator" value="#{semmsa002Bean.siteAppObjParam.reqKey}" 
									disabled="true"
									maxlength="200" styleClass="ms7" style="width:100%;" />
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            	<h:outputText value="#{jspMsg['label.th_come']}#{jspMsg['label.th_from']}#{jspMsg['label.th_contract']}#{jspMsg['label.th_old_2']}#{jspMsg['label.th_number']} : "
								 styleClass="ms7" />
								
                            </td>
                            <td width="30%" valign="bottom">
                            	<h:inputText id="msa002tab1_contractNo_old" value="#{semmsa002Bean.siteAppObjParam.contractNoOld}" 
								disabled="#{semmsa002Bean.siteAppObjParam.showContractNoOldFlag == 'N' || semmsa002Bean.disabledModeViewOnly}" maxlength="20" styleClass="ms7" />
							
								<rich:spacer width="5"></rich:spacer>
								
								<a4j:commandButton id="btnmsa002tab1_contractNo_old"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
								disabled="#{semmsa002Bean.siteAppObjParam.showContractNoOldFlag == 'N' || semmsa002Bean.disabledModeViewOnly}"
								value="..."  reRender="popupSearchContractNo,popupFrmSearch"
			            		action="#{navAction.navi}" styleClass="rich-button">
			            		
			            		<a4j:actionparam name="navModule" value="sa" />
								<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
								<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
	            				</a4j:commandButton>
                            </td>
                     	</tr>
                     	<tr>
                        	<td align="right" width="20%" valign="baseline">
                            	<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['lable.th_site_acq_createdt']} : " styleClass="ms7" />
							
							</td>
                            <td width="30%" valign="bottom">
                            	
								<rich:calendar id="msa002tab1_createDate" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semmsa002Bean.siteAppObjParam.docDt}"
									   showWeeksBar="false"
									   inputSize="10"
									   disabled="#{semmsa002Bean.disabledModeViewOnly}"
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   oninputblur="return dateformat.submitFomatDate(this);"
								   	   cellWidth="15px" cellHeight="20px"
								   	   label=""
								   	   styleClass="ms7">
								</rich:calendar>
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            	<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_approveNumber']} : " styleClass="ms7" />
							
								
                            </td>
                            <td width="30%" valign="bottom">
                            	<%-- disabled="#{semmsa002Bean.disabledGenDocNoBtn}" --%>
								<h:inputText id="msa002tab1_docNo" value="#{semmsa002Bean.siteAppObjParam.docNo}" maxlength="50" 
								onblur="msa002tab1_doChkDupDocNoJS();"  styleClass="ms7" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
								<a4j:jsFunction name="msa002tab1_doChkDupDocNoJS" reRender="msa002-1_docNo, msa002tab1_docNo, msa002tab1_BtnGenAppr" 
								action="#{semmsa002Action.doChkDupDocNo}" oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();">
								</a4j:jsFunction>
								
								
								<%-- disabled="#{semmsa002Bean.disabledGenDocNoBtn}" --%>
								<a4j:commandButton style="margin-left:5px;" id="msa002tab1_BtnGenAppr" styleClass="rich-button"
								action="#{semmsa002Action.doGenDocNo}" oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
								value="#{jspMsg['label.th_gen_approveNumber']}" reRender="msa002-1_docNo, msa002tab1_docNo, msa002tab1_BtnGenAppr"
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
								</a4j:commandButton>
                            </td>
                     	</tr>
                     	<tr>
                        	<td align="right" width="20%" valign="baseline">
                            	<h:outputText value="Co-Operator : " styleClass="ms7" />
						
							</td>
                            <td width="30%" valign="bottom">
						
								<h:selectOneMenu value="#{semmsa002Bean.siteAppObjParam.coCompany}" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.coOperatorList}"/>
								</h:selectOneMenu>
                            </td>
                            <td align="right" width="20%" valign="bottom">
                            	<h:outputText value="Operator : " styleClass="ms7" />
							
								
							</td>
                            <td width="30%" valign="bottom">
                            	<h:inputText value="#{semmsa002Bean.siteAppObjParam.coOperator}" 
								maxlength="50" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
                            
                            	<a4j:commandButton style="margin-left:5px;" id="msa002tab1_BtnOperator" styleClass="rich-button"
								oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();" rendered="false"
								value="..." reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
								</a4j:commandButton>
                            </td>
                     	</tr>
                     	<tr>
                        	<td align="right" width="20%" >
                            	<h:outputText value="#{jspMsg['label.th_status_approve']} : " styleClass="ms7" />
							
							</td>
                            <td width="30%" valign="bottom" >
                            	<h:inputText value="#{semmsa002Bean.siteAppObjParam.docStatusText}" 
								disabled="true" maxlength="100" styleClass="ms7" />
                            
								<rich:spacer width="20"></rich:spacer>
	                            
                            	<h:selectBooleanCheckbox id="msa002tab1_chkNotLegal" value="#{semmsa002Bean.chkNeedLegalApprove}" rendered="#{semmsa002Bean.disabledChkNoLegal}"
								disabled="#{semmsa002Bean.disabledModeViewOnly or true}"/>
								<h:outputText style="white-space:nowrap; padding-right:5px;" value="#{jspMsg['label.th_not_apprveByLegal']}" styleClass="ms7" rendered="#{semmsa002Bean.disabledChkNoLegal}"/>
								
								<h:selectBooleanCheckbox id="msa002tab1_chkNotAVP" value="#{semmsa002Bean.chkNeedAvpApprove}" rendered="#{semmsa002Bean.disabledChkNoLegal}"
								disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
								<h:outputText style="white-space:nowrap;padding-right:5px;" value="#{jspMsg['label.th_not_apprveByAVP']}" styleClass="ms7" rendered="#{semmsa002Bean.disabledChkNoLegal}"/>
								
								<h:selectBooleanCheckbox id="msa002tab1_chkNotConstruction" value="#{semmsa002Bean.chkNeedConstruction}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
								<h:outputText style="white-space:nowrap; padding-right:5px;" value="#{jspMsg['label.th_not_construction']}" styleClass="ms7" />
								
                            </td>
                            <td >
                            </td>
                            <td align="left">
                            	<a4j:commandLink action="#{semmsa002Action.doGetOutstandingWork}" 
                            	reRender="msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr, msa002PopUpCommon_tab1ChangeRequestName"
								disabled="#{semmsa002Bean.disabledModeViewOnly}"
                            	oncomplete="#{rich:component('msa002PopUpCommon_tab1ChangeRequestName')}.show();">
                            		<h:outputText value="#{jspMsg['lable.th_remain_doc']}"></h:outputText> 
                            	</a4j:commandLink>
                            </td>
                     	</tr>
                     	
                     	
                	</table>
				</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 2 -->
				<rich:panel id="msa001LocationPanel">
				<h:panelGroup style="width:100%;">
					<!-- table column: 10:20, 10:20, 10:30 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="LOCATION ID : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locationId}" 
								disabled="true" maxlength="50" styleClass="ms7" />
								
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="LOCATION CODE : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locationCode}" 
								disabled="true" maxlength="50" styleClass="ms7"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="ZONE : " styleClass="ms7" />
							</td>
							<td style="width:30%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locationZone}" 
								disabled="true" maxlength="50" styleClass="ms7"/>
							</td>
						</tr>
						
						
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:selectBooleanCheckbox rendered="false">  </h:selectBooleanCheckbox>
							
								<h:outputText value="#{jspMsg['label.th_name']} Location : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locationName}" 
								 maxlength="200" styleClass="ms7" disabled="true" style="width:100%;"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="Re-Locate : " styleClass="ms7" />
								
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.reLocateContractNo}" id="msa002tab1_reLocateContractNo"
								onblur="msa002tab1_doChkContractNoJS();" maxlength="200" styleClass="ms7" disabled="true"/>
								<a4j:jsFunction name="msa002tab1_doChkContractNoJS" reRender="oppContent, msa002tab1_reLocateContractNo" 
								action="#{semmsa002Action.doChkContractNo}" oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();">
								</a4j:jsFunction>
								
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
							</td>
							<td style="width:30%; width:20%; text-align:left;">
								
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locationStatus}" 
								maxlength="20" styleClass="ms7" disabled="true"/>
								
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							
								<h:outputText value="#{jspMsg['lable.th_mainlocation']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.mainLocation}" 
								 maxlength="200" styleClass="ms7" disabled="true"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_networkstatus']}" styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.networkStatus}" 
								 maxlength="200" styleClass="ms7" disabled="true"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_livenetwork']}" styleClass="ms7" />
							</td>
							<td style="width:30%; width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.liveNetwork}" 
								 maxlength="200" styleClass="ms7" disabled="true"/>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							
								<h:outputText value="#{jspMsg['lable.placeType']} : " styleClass="ms7" rendered="false" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:selectOneMenu id="msa002tab1_locationType" value="#{semmsa002Bean.siteAppLocalObjParam.locationType}" 
								rendered="false" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.locationList}"/>
								</h:selectOneMenu>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="width:20%; text-align:left;">
								
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
							</td>
							<td style="width:30%; width:20%; text-align:left;">
							
								
							</td>
						</tr>
						
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
								<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
							</td>
							<td style="text-align:left;" colspan="5">
								<h:inputTextarea rows="6" cols="100" value="#{semmsa002Bean.siteAppLocalObjParam.locAddressNo}" disabled="true"></h:inputTextarea>
							</td>
						</tr>
						
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locBuilding}" 
								style="width:100%;" maxlength="200" styleClass="ms7" disabled="true"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; white-space:nowrap; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locFloor}" 
								style="width:150px;"  maxlength="10" styleClass="ms7" disabled="true"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
							</td>
							<td style="width:30%; white-space:nowrap; text-align:left;">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locRoomNo}" 
								style="width:100px;" maxlength="10" styleClass="ms7" disabled="true"/>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;" >
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locStreet}" 
								 maxlength="100" style="width:100%;" styleClass="ms7" disabled="true"/>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
							</td>
							<td colspan="3">
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locTumbol}" 
								 maxlength="100" style="width:40%;" styleClass="ms7" disabled="true"/>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;">
								<h:selectOneMenu id="msa002tab1_slimAmphur" value="#{semmsa002Bean.siteAppLocalObjParam.locAmphur}" styleClass="ms7"
								disabled="true">
									<f:selectItems value="#{semmsa002Bean.amphurList}"/>
								</h:selectOneMenu>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
							</td>
							<td style="width:20%; text-align:left;" >
								<a4j:region>
									<h:selectOneMenu id="msa002tab1_slimProvince" value="#{semmsa002Bean.siteAppLocalObjParam.locProvince}" 
									disabled="true" styleClass="ms7">
										<f:selectItems value="#{semmsa002Bean.provinceList}"/>
									</h:selectOneMenu>
								</a4j:region>
							</td>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
							</td>
							<td style="width:30%;" >
								<h:inputText value="#{semmsa002Bean.siteAppLocalObjParam.locZipCode}" 
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
								style="width:100px; text-align:right;" maxlength="5" styleClass="ms7" 
								disabled="true"/>
							</td>
						</tr>
						
						<tr>
							<td></td>
							<td colspan="5">
								<a4j:commandButton style="margin-left:5px;" id="msa002tab1_saveLo" styleClass="rich-button"
								oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
								value="save" reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
								disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="false">
									<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
								</a4j:commandButton>
								
								<rich:spacer width="5"></rich:spacer>
								
								<a4j:commandButton style="margin-left:5px;" id="msa002tab1_cancelLo" styleClass="rich-button"
								oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
								value="cancel" reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
								disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="false">
									<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
								</a4j:commandButton>
							</td>
						</tr>
					</table>
					
				</h:panelGroup>
				</rich:panel>
				<!-- << group 2 -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 3 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<!-- >> table result -->
						<center>
						
						<table style="width:900px; border:solid ececec 1px;">
							<tr>
								<td style="background-color:ececec; border:solid dcdcdc 1px;">
									<a4j:commandButton id="msa002tab1_searchSiteFromOtherLocation" styleClass="rich-button" 
									value="#{jspMsg['label.th_searchSiteFromOtherLocation']}"
									action="#{semmsa002Action.tab1AddSite_doClearSiteLocation}"
									reRender="dataTabMsa002tab1, msa002PopUpCommon_tab1AddSiteLocation"
									oncomplete="#{rich:component('msa002PopUpCommon_tab1AddSiteLocation')}.show();"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									</a4j:commandButton>
								</td>
							</tr>
						</table>
						
						<div style="clear:both; height:0px;"></div>
						
						<h:panelGrid  width="90%">
		                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbarInSATab1" >
		                        <f:facet name="header">
		                            <h:outputText value="#{jspMsg['column.header.siteAppr']}" style="width: 2000"/>
		                        </f:facet>
		                        
		                        <rich:dataTable style="width:100%;" id="dataTabMsa002tab1" cellpadding="1" cellspacing="0" border="0" 
								var="appSiteLst"  value="#{semmsa002Bean.siteAppSiteList}" reRender="dataTabMsa002tab1" 
								rows="5" rowClasses="cur" styleClass="dataTable">
									
									<rich:column title="#{appSiteLst.dataObj.locationId}">
		                            
		                                <f:facet name="header">
		                                    <h:outputText value="Select" styleClass="contentform" style="width: 30"/>
		                                </f:facet>
		                                <div align="center">
		                                    <a4j:commandLink value="Select" action="#{semmsa002Action.msa002Tab1_doAddLocationSite}"
											oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
											disabled="#{semmsa002Bean.disabledModeViewOnly}"
											reRender="oppContent, dataTabMsa002tab1">
		                                    	<a4j:actionparam name="paramSiteMode" value="I" />
												<a4j:actionparam name="paramSiteAppId" value="#{appSiteLst.dataObj.siteAppId}" />
												<a4j:actionparam name="paramSiteAppSiteId" value="#{appSiteLst.dataObj.siteAppSiteId}" />
												<a4j:actionparam name="paramLocationId" value="#{appSiteLst.dataObj.locationId}" />
												<a4j:actionparam name="paramSiteId" value="#{appSiteLst.dataObj.siteId}" />
												<a4j:actionparam name="paramSiteCode" value="#{appSiteLst.dataObj.siteCode}" />
												<a4j:actionparam name="paramLocationCode" value="#{appSiteLst.dataObj.locationCode}" />
												<a4j:actionparam name="paramLocationName" value="#{appSiteLst.dataObj.locationName}" />
												<a4j:actionparam name="paramTowerType" value="#{appSiteLst.dataObj.towerType}" />
												<a4j:actionparam name="paramTowerLocation" value="#{appSiteLst.dataObj.towerLocation}" />
												<a4j:actionparam name="paramTowerHeight" value="#{appSiteLst.dataObj.towerHeight}" />
												<a4j:actionparam name="paramServiceId" value="#{appSiteLst.dataObj.serviceId}" />
												
												<%-- parameter for reload --%>
												<a4j:actionparam name="rowId" value="#{appSiteLst.dataObj.siteAppId}" />
		                                    </a4j:commandLink>
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.locationId}" title="#{appSiteLst.dataObj.locationId}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.locationId}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteDetail}" title="#{appSiteLst.dataObj.siteDetail}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.siteDetail']}" styleClass="contentform" style="width: 150"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteDetail}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteCode}" title="#{appSiteLst.dataObj.siteCode}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Code" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteCode}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteGroup}" title="#{appSiteLst.dataObj.siteGroup}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.siteGroup']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteGroup}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.system}" title="#{appSiteLst.dataObj.system}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.system']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.system}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteType}" title="#{appSiteLst.dataObj.siteType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.stationType}" title="#{appSiteLst.dataObj.stationType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Station Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.stationType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteName}" title="#{appSiteLst.dataObj.siteName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Name" styleClass="contentform" style="width: 200"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteNameTh}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.locationStatus}" title="#{appSiteLst.dataObj.locationStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['lable.th_locationstatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.locationStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.slimStatus}" title="#{appSiteLst.dataObj.slimStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.slimsstatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.slimStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.liveNetwork}" title="#{appSiteLst.dataObj.liveNetwork}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.liveNetwork']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.liveNetwork}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.contractInfo}" title="#{appSiteLst.dataObj.contractInfo}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.th_info_contract']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.contractInfo}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.contractStatus}" title="#{appSiteLst.dataObj.contractStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.contractStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.company}" title="#{appSiteLst.dataObj.company}">
		                                <f:facet name="header">
		                                    <h:outputText value="Company" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.company}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.siteActivity}" title="#{appSiteLst.dataObj.siteActivity}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Activity" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.siteActivity}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.towerType}" title="#{appSiteLst.dataObj.towerType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.towerType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.towerLocation}" title="#{appSiteLst.dataObj.towerLocation}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Location" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.towerLocation}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst.dataObj.towerHeight}" title="#{appSiteLst.dataObj.towerHeight}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Height" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst.dataObj.towerHeight}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            
		                            <!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmsa002Bean.siteAppSiteList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="15">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabMsa002tab1"
														maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dataScrllMsa002tab1" style="background-color: #cccccc;"
														page="#{semmsa002Bean.scrollerPage}">
													<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
													</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->
								</rich:dataTable>
		                        
							</rich:panel>
						</h:panelGrid>
						
						<div style="clear:both; height:0px;"></div>
						
						<h:panelGrid  width="90%">
		                    <rich:panel id="pnlMsa002tab1Result2" styleClass="sem_autoScrollbarInSATab1" >
		                    	<f:facet name="header">
		                            <h:outputText value="#{jspMsg['column.header.siteApprForSaDoc']}" style="width: 2000"/>
		                        </f:facet>
		                     
		                     	<rich:dataTable style="width:100%;" id="msa002tab1" cellpadding="1" cellspacing="0" border="0" 
								var="appSiteLst2"  value="#{semmsa002Bean.siteAppSiteInuseList}" reRender="msa002tab1" 
								rows="5" rowClasses="cur" styleClass="dataTable">
									
									<rich:column title="#{appSiteLst2.dataObj.locationId}">
		                            
		                                <f:facet name="header">
		                                    <h:outputText value="Delete" styleClass="contentform" style="width: 30"/>
		                                </f:facet>
		                                <div align="center">
		                                    
		                                    <a4j:commandButton action="#{semmsa002Action.msa002Tab1_doAddLocationSite}"
		                                    image="images/delete.png"  style="height: 15; width : 15px;"
		                                    disabled="#{semmsa002Bean.disabledModeViewOnly}"
											oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
											onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
											reRender="oppContent, dataTabMsa002tab1">
				                                <a4j:actionparam name="paramSiteMode" value="D" />
												<a4j:actionparam name="paramSiteAppId" value="#{appSiteLst2.dataObj.siteAppId}" />
												<a4j:actionparam name="paramSiteAppSiteId" value="#{appSiteLst2.dataObj.siteAppSiteId}" />
												<a4j:actionparam name="paramLocationId" value="#{appSiteLst2.dataObj.locationId}" />
												<a4j:actionparam name="paramSiteId" value="#{appSiteLst2.dataObj.siteId}" />
												<a4j:actionparam name="paramSiteCode" value="#{appSiteLst2.dataObj.siteCode}" />
												<a4j:actionparam name="paramLocationCode" value="#{appSiteLst2.dataObj.locationCode}" />
												<a4j:actionparam name="paramLocationName" value="#{appSiteLst2.dataObj.locationName}" />
												<a4j:actionparam name="paramTowerType" value="#{appSiteLst2.dataObj.towerType}" />
												<a4j:actionparam name="paramTowerLocation" value="#{appSiteLst2.dataObj.towerLocation}" />
												<a4j:actionparam name="paramTowerHeight" value="#{appSiteLst2.dataObj.towerHeight}" />
												<a4j:actionparam name="paramServiceId" value="#{appSiteLst2.dataObj.serviceId}" />
												
												<%-- parameter for reload --%>
												<a4j:actionparam name="rowId" value="#{appSiteLst2.dataObj.siteAppId}" />
				                            </a4j:commandButton>
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column title="Select Main Location">
		                            
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.heander.mainLoc']}" styleClass="contentform" style="width: 30"/>
		                                </f:facet>
		                                <div align="center">
		                                	<a4j:commandButton id="btnSelMainLoc"  
		                                	image="images/metBlack.png" style="height: 20; width: 20"
		                                	onmouseover="this.src='images/metGreenSel.png'"
				                            onmouseout="this.src='images/metBlack.png'" 
				                            action="#{semmsa002Action.msa002Tab1_doAddLocationSite}"
				                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
				                            oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
				                            reRender="oppContent, dataTabMsa002tab1, msa001LocationPanel"
											disabled="#{semmsa002Bean.disabledModeViewOnly}" 
		                                    rendered="#{appSiteLst2.dataObj.mainLocalFlag != 'Y'}">
		                                    	<a4j:actionparam name="paramSiteMode" value="C" />
												<a4j:actionparam name="paramSiteAppId" value="#{appSiteLst2.dataObj.siteAppId}" />
												<a4j:actionparam name="paramSiteAppSiteId" value="#{appSiteLst2.dataObj.siteAppSiteId}" />
												<a4j:actionparam name="paramLocationId" value="#{appSiteLst2.dataObj.locationId}" />
												<a4j:actionparam name="paramSiteId" value="#{appSiteLst2.dataObj.siteId}" />
												<a4j:actionparam name="paramSiteCode" value="#{appSiteLst2.dataObj.siteCode}" />
												<a4j:actionparam name="paramLocationCode" value="#{appSiteLst2.dataObj.locationCode}" />
												<a4j:actionparam name="paramLocationName" value="#{appSiteLst2.dataObj.locationName}" />
												<a4j:actionparam name="paramTowerType" value="#{appSiteLst2.dataObj.towerType}" />
												<a4j:actionparam name="paramTowerLocation" value="#{appSiteLst2.dataObj.towerLocation}" />
												<a4j:actionparam name="paramTowerHeight" value="#{appSiteLst2.dataObj.towerHeight}" />
												<a4j:actionparam name="paramServiceId" value="#{appSiteLst2.dataObj.serviceId}" />
												<a4j:actionparam name="paramSiteGroup" value="#{appSiteLst2.dataObj.siteGroup}" />
												<a4j:actionparam name="paramStationType" value="#{appSiteLst2.dataObj.stationType}" />
												<a4j:actionparam name="paramSystem" value="#{appSiteLst2.dataObj.system}" />
												
												<a4j:actionparam name="rowId" value="#{appSiteLst2.dataObj.siteAppId}" />
				                            </a4j:commandButton>
				                            
				                            <h:commandButton value="Report" id="btnMainLoc" disabled="true" image="images/metGreen01.png" 
				                            style="height: 20; width: 20"
				                            rendered="#{appSiteLst2.dataObj.mainLocalFlag eq 'Y'}"
				                            > </h:commandButton>
		                                   
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.action}" title="#{appSiteLst2.dataObj.action}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.action']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.action}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.locationId}" title="#{appSiteLst2.dataObj.locationId}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.locationId}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.siteDetail}" title="#{appSiteLst2.dataObj.siteDetail}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.siteDetail']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteDetail}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                             <rich:column sortBy="#{appSiteLst2.dataObj.siteCode}" title="#{appSiteLst2.dataObj.siteCode}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Code" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteCode}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.siteGroup}" title="#{appSiteLst2.dataObj.siteGroup}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Group" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteGroup}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.system}" title="#{appSiteLst2.dataObj.system}">
		                                <f:facet name="header">
		                                    <h:outputText value="System" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.system}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.siteType}" title="#{appSiteLst2.dataObj.siteType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.stationType}" title="#{appSiteLst2.dataObj.stationType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Station Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.stationType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.siteNameTh}" title="#{appSiteLst2.dataObj.siteName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Name" styleClass="contentform" style="width: 200"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteNameTh}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.locationStatus}" title="#{appSiteLst2.dataObj.locationStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['lable.th_locationstatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.locationStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.locationSlims}" title="#{appSiteLst2.dataObj.locationSlims}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.locationslims']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.locationSlims}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.slimStatus}" title="#{appSiteLst2.dataObj.slimStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.slimsstatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.slimStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.liveNetwork}" title="#{appSiteLst2.dataObj.liveNetwork}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.liveNetwork']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.liveNetwork}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.contractInfo}" title="#{appSiteLst2.dataObj.contractInfo}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.th_info_contract']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.contractInfo}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                           	<rich:column sortBy="#{appSiteLst2.dataObj.contractStatus}" title="#{appSiteLst2.dataObj.contractStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.contractStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.company}" title="#{appSiteLst2.dataObj.company}">
		                                <f:facet name="header">
		                                    <h:outputText value="Company" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.company}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.siteActivity}" title="#{appSiteLst2.dataObj.siteActivity}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Activity" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.siteActivity}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.towerType}" title="#{appSiteLst2.dataObj.towerType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Type" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.towerType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.towerLocation}" title="#{appSiteLst2.dataObj.towerLocation}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Location" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.towerLocation}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{appSiteLst2.dataObj.towerHeight}" title="#{appSiteLst2.dataObj.towerHeight}">
		                                <f:facet name="header">
		                                    <h:outputText value="Tower Height" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{appSiteLst2.dataObj.towerHeight}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
						            
						            <!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmsa002Bean.siteAppSiteInuseList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="17">
													<rich:datascroller immediate="true" rendered="true" align="left" for="msa002tab1"
														maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="scrllMsa002tab1" style="background-color: #cccccc;"
														page="#{semmsa002Bean.scrollerPage}">
													<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
													</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->     
								</rich:dataTable>
		                     	
							</rich:panel>
						</h:panelGrid>
							
						</center>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 3 -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 3 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<table style="width:100%; border:solid 1px;">
							<tr>
								<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.serviceType']}" styleClass="ms7" style="text-decoration:underline;" />
								</td>
								<td style="width:90%; text-align:left;">
								
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								</td>
								<td style="width:90%; text-align:left;">
									<div id="msa002tab1Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService1tab1" cellpadding="1" cellspacing="0" border="0" 
										var="servObj"  value="#{semmsa002Bean.siteAppExtServList}" reRender="dataService1tab1" 
										rows="5" rowClasses="cur" styleClass="dataTable">
										
											<!-- header -->
											<f:facet name="header">
								                <rich:columnGroup>
									                <rich:column colspan="3" style="text-align:left;">
									                	<h:outputText value="#{jspMsg['column.header.existservice']}"/>
									                </rich:column>
								                    <rich:column breakBefore="true" > 
														<h:outputText value="Service"/>
								                    </rich:column>  
								                    <rich:column style="white-space:nowrap;width:120px;">
			                                            <h:outputText value="Action"/>
			                                        </rich:column>
								                    <rich:column style="white-space:nowrap;width:70px;">
								                        <h:outputText value="Seq"/>
								                    </rich:column>
								                </rich:columnGroup>
								            </f:facet>
								            <!-- header -->
									
											<!-- data -->
											
						                    <rich:column style="text-align:center;">
			                                    <h:outputText value="#{servObj.dataObj.servName}" />
			                                </rich:column>
						                    <rich:column>
						                        <h:outputText value="#{servObj.dataObj.action}" />
						                    </rich:column>
						                    <rich:column style="text-align:center">
						                        <h:outputText value="#{servObj.dataObj.seq}" />
						                    </rich:column>
								            <!-- data -->
								            
								            <!-- footer -->
											
											<!-- footer -->
								            <f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													
													<!-- > 2 -->
													<rich:column colspan="3">
															<rich:datascroller immediate="true" rendered="true" align="left" for="dataService1tab1"
																maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																stepControls="hide" fastControls="auto" boundaryControls="auto" 
																id="scrllDataService1tab1" style="background-color: #cccccc;"
																page="#{semmsa002Bean.scrollerPage}">
															<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
															</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
								    	</rich:dataTable>
								    	
									</div> 
									
									<div style="clear:both; height:10px;"></div>
									
									<div id="msa002tab1Service2" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService2tab1" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService2"  value="#{semmsa002Bean.siteAppCurrServList}" reRender="dataService2tab1" 
										rows="5" rowClasses="cur" styleClass="dataTable">
										
											<!-- header -->
											<f:facet name="header">
								                <rich:columnGroup>
									                <rich:column colspan="6" style="text-align:left;">
									                	<h:outputText value="#{jspMsg['column.header.th_service_period']}"/>
									                </rich:column>
								                    <rich:column breakBefore="true" > 
														<h:outputText value="Service"/>
								                    </rich:column>  
								                    <rich:column style="white-space:nowrap;">
			                                            <h:outputText value="Action"/>
			                                        </rich:column>
			                                        <rich:column style="white-space:nowrap;">
			                                            <h:outputText value="Create By"/>
			                                        </rich:column>
			                                        <rich:column style="white-space:nowrap;">
			                                            <h:outputText value="Create Date"/>
			                                        </rich:column>
			                                        <rich:column style="white-space:nowrap;">
			                                            <h:outputText value="Update By"/>
			                                        </rich:column>
			                                        <rich:column style="white-space:nowrap;">
			                                            <h:outputText value="Update Date"/>
			                                        </rich:column>
								                </rich:columnGroup>
								            </f:facet>
								            <!-- header -->
									
											<!-- data -->
											
						                    <rich:column style="text-align:center;" >
			                                    <h:outputText value="#{appSiteService2.dataObj.servName}" />
			                                </rich:column>
						                    <rich:column >
						                        <h:outputText value="#{appSiteService2.dataObj.action}" />
						                    </rich:column>
						                    <rich:column style="text-align:center" >
						                        <h:outputText value="#{appSiteService2.dataObj.createBy}" />
						                    </rich:column>
						                    <rich:column style="text-align:center;" >
			                                    <h:outputText value="#{appSiteService2.dataObj.createDtStr}" />
			                                </rich:column>
						                    <rich:column >
						                        <h:outputText value="#{appSiteService2.dataObj.updateBy}" />
						                    </rich:column>
						                    <rich:column style="text-align:center" >
						                        <h:outputText value="#{appSiteService2.dataObj.updateDtStr}" />
						                    </rich:column>
								            <!-- data -->
								            
								            <!-- footer -->
								            <f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													
													<!-- > 2 -->
													<rich:column colspan="6">
															<rich:datascroller immediate="true" rendered="true" align="left" for="dataService2tab1"
																maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																stepControls="hide" fastControls="auto" boundaryControls="auto" 
																id="scrllDataService2tab1" style="background-color: #cccccc;"
																page="#{semmsa002Bean.scrollerPage}">
															<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
															</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
								    	</rich:dataTable>
								    	
									</div> 
									
									<div style="clear:both; height:10px;"></div>
									
									<div id="msa002tab1Service3" style="width:600px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService3tab1" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService3"  value="#{semmsa002Bean.siteAppServList}" reRender="dataService3tab1" 
										rows="5" rowClasses="cur" styleClass="dataTable">
										
											<!-- header -->
											<f:facet name="header">
								                <rich:columnGroup>
									                <rich:column colspan="3" style="text-align:left;">
									                	<h:outputText value="#{jspMsg['column.header.serviceList']}"/>
									                </rich:column>
								                    <rich:column breakBefore="true" > 
														<h:outputText value="Service"/>
								                    </rich:column>  
								                    <rich:column style="white-space:nowrap;width:120px;">
			                                            <h:outputText value="Action"/>
			                                        </rich:column>
								                    <rich:column style="white-space:nowrap;width:70px;">
								                        <h:outputText value="Seq"/>
								                    </rich:column>
								                </rich:columnGroup>
								            </f:facet>
								            <!-- header -->
									
											<!-- data -->
											
						                    <rich:column style="text-align:center;">
			                                    <h:outputText value="#{appSiteService3.dataObj.servName}" />
			                                </rich:column>
						                    <rich:column>
						                        <h:outputText value="#{appSiteService3.dataObj.action}" />
						                    </rich:column>
						                    <rich:column style="text-align:center">
						                        <h:outputText value="#{appSiteService3.dataObj.seq}" />
						                    </rich:column>
								            <!-- data -->
								            
								            <!-- footer -->
								            <f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													
													<!-- > 2 -->
													<rich:column colspan="6">
															<rich:datascroller immediate="true" rendered="true" align="left" for="dataService3tab1"
																maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																stepControls="hide" fastControls="auto" boundaryControls="auto" 
																id="scrllDataService3tab1" style="background-color: #cccccc;"
																page="#{semmsa002Bean.scrollerPage}">
															<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
															</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
								    	</rich:dataTable>
								    	
									</div> 
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
				
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 5 -->
				<rich:panel id="panelTab1_local" style="height:100%; border:1 ececec solid;">
				<h:panelGroup style="width:100%;">
					<!-- table column: 10:20, 10:20, 10:30 -->
					<table style="width:100%; border:solid ececec 1px; text-align:right;" border="0">
						
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_terraceArea']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; text-align:left;" colspan="3">
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.deckAreaType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.deckAreaTypeList}"/>
								</h:selectOneMenu>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:inputText  value="#{semmsa002Bean.siteAppObjParam.deckArea}" maxlength="17" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.deckAreaUnitType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.areaUnitTypeList}"/>
								</h:selectOneMenu>
							
								<rich:spacer width="50"></rich:spacer>
								<h:outputText value="#{jspMsg['lable.th_Width']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.deckAreaWidth}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_Length']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.deckAreaLength}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.deckAreaOther}" 
								style="width:40%;" styleClass="ms7"
              					disabled="#{semmsa002Bean.disabledModeViewOnly}" >
								</h:inputText>
							</td>
						</tr>
						
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_buildingArea']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap;  text-align:left;" colspan="3">
								<h:selectOneMenu value="#{semmsa002Bean.siteAppObjParam.buildingAreaType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.buildingAreaTypeList}"/>
								</h:selectOneMenu>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:inputText  value="#{semmsa002Bean.siteAppObjParam.buildingArea}" maxlength="17" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.buildingAreaUnitType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.areaUnitTypeList}"/>
								</h:selectOneMenu>
								
							<rich:spacer width="50"></rich:spacer>
							
								<h:outputText value="#{jspMsg['lable.th_Width']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.buildingAreaWidth}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_Length']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.buildingAreaLength}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.buildingAreaOther}"
								style="width:40%;" styleClass="ms7"
              					disabled="#{semmsa002Bean.disabledModeViewOnly}">
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_roomNumber']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; text-align:left;" colspan="3">
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.locationRoomNo}" maxlength="17" 
									style="text-align:right;" styleClass="ms7"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_roomArea']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;" colspan="3">
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.roomAreaType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.roomAreaTypeList}"/>
								</h:selectOneMenu>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:inputText  value="#{semmsa002Bean.siteAppObjParam.roomArea}" maxlength="17" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.roomAreaUnitType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.areaUnitTypeList}"/>
								</h:selectOneMenu>
							
							<rich:spacer width="50"></rich:spacer>
							
								<h:outputText value="#{jspMsg['lable.th_Width']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.roomAreaWidth}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_Length']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.roomAreaLength}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.roomAreaOther}" 
								style="width:40%;" styleClass="ms7"
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_landArea']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; text-align:left;" colspan="3">
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.landAreaType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.landAreaTypeList}"/>
								</h:selectOneMenu>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.landArea}" maxlength="17" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
								
								<rich:spacer width="5"></rich:spacer>
							
								<h:selectOneMenu  value="#{semmsa002Bean.siteAppObjParam.landAreaUnitType}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.areaUnitTypeList}"/>
								</h:selectOneMenu>
							
							<rich:spacer width="50"></rich:spacer>
							
								<h:outputText value="#{jspMsg['lable.th_Width']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.landAreaWidth}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
									style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_Length']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.landAreaLength}" maxlength="10" 
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;width:110px;" styleClass="ms7"
              						onblur="return numberformat.moneyFormat(this);"
              						onfocus="return numberformat.setCursorPosToEnd(this);"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
								</h:inputText>
									
								<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
							
								<h:inputText value="#{semmsa002Bean.siteAppObjParam.landAreaOther}"
								style="width:40%;" styleClass="ms7"
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_placeType']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:selectOneMenu id="msatab1_placeType" style="width:300" value="#{semmsa002Bean.siteAppObjParam.locationType}" 
								 disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.placeTypeList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa002Tab1_getDocType" action="#{semmsa002Action.doGetDocTypeSelectItem}"
								reRender="msa002tab1_docType"></a4j:jsFunction>
								
								<a4j:jsFunction name="msa002Tab1_setPlaceType" action="#{semmsa002Action.doSetPlaceType}" reRender="oppContent">
									<a4j:actionparam name="tabNo" value="1"></a4j:actionparam>
								</a4j:jsFunction>
							</td>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:80%" value="#{semmsa002Bean.siteAppObjParam.placeTypeOther}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
						</tr>
						
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;" valign="top">
								<h:outputText value="#{jspMsg['lable.th_address']} : " styleClass="ms7" />
							</td>
							<td align="left" colspan="3">
								
								<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.locationAddressNo}"
								disabled="#{semmsa002Bean.disabledModeViewOnly}"
								styleClass="ms7" cols="100" rows="8" style="width:90%;">
								    <f:validateLength maximum="500"></f:validateLength>
								</h:inputTextarea>
							</td>
						</tr>
						
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_buildingName']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:100%;" value="#{semmsa002Bean.siteAppObjParam.locationBuilding}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.locationStreet}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.locationFloor}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.locationTambon}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								
							</td>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap;width:45%; text-align:left;">
								
								<h:selectOneMenu id="msa002tab1_locAmphur" value="#{semmsa002Bean.siteAppObjParam.locationAmphurId}" styleClass="ms7"
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.amphurLocalList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								
							</td>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								
								<h:selectOneMenu id="msa002tab1_locProvince" value="#{semmsa002Bean.siteAppObjParam.locationProvinceId}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" onchange="msa002tab1_GetSiteAmphurListJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="msa002tab1_GetSiteAmphurListJS" reRender="msa002tab1_locAmphur" action="#{semmsa002Action.getAmphurList}"/>
							</td>
						</tr>
						<tr>
							<td style="width:5%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								
							</td>
							<td style="width:3%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:45%; text-align:left;">
								<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.locationPostCode}"
								 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
							</td>
						</tr>
						
						
					</table>
				</h:panelGroup>
				</rich:panel>
				<!-- << group 5 -->
				
				<!-- >> additional -->
				<div style="clear:both; height:10px;"></div>
				<a4j:commandButton style="" styleClass="rich-button" id="msa002tab1_BtnSave" value="SAVE" rendered="false">
				</a4j:commandButton>
				<!-- << additional -->
			<rich:panel id="inner_panelTab2" style="height:100%; border:1 ececec solid;">
	
				<!-- >> header content -->
				<f:facet name="header">
					<h:outputText value="#{jspMsg['label.th_addressDoc']}" />
				</f:facet>
				<!-- << header content -->
	
					<!-- >> group 0 -->
					<h:panelGroup style="width:100%;">
						<a4j:commandButton style="" value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_station_address']}" 
												disabled="#{semmsa002Bean.disabledModeViewOnly}"
												styleClass="rich-button" action="#{semmsa002Action.doCopyLocation}" reRender="inner_panelTab2" rendered="true">
													<a4j:actionparam  name="paramLocateFrom" value="tab1_siteLocal"/>
													<a4j:actionparam  name="paramLocateTo" value="tab1_reqDocLocal"/>
												</a4j:commandButton>
						
						<table style="width:100%; border:solid ececec 1px; text-align:right;">
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;" valign="top">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['lable.th_address']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; text-align:left;" colspan="3">
									
									<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.docLocAddrNo}"
									disabled="#{semmsa002Bean.disabledModeViewOnly}"
									styleClass="ms7" cols="100" rows="8" style="width:90%;">
									    <f:validateLength maximum="500"></f:validateLength>
									</h:inputTextarea>
								</td>
							</tr>
							
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_buildingName']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									<h:inputText style="width:100%;" value="#{semmsa002Bean.siteAppObjParam.docLocBuilding}"
									 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
								</td>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.docLocStreet}"
									 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.docLocFloor}"
									 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
								</td>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.docLocTambon}"
									 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									
								</td>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									
									<h:selectOneMenu id="msa002tab1_contAmphur" value="#{semmsa002Bean.siteAppObjParam.docLocAmphurId}" styleClass="ms7"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
										<f:selectItems value="#{semmsa002Bean.amphurReqDocList}"/>
									</h:selectOneMenu>
								</td>
							</tr>
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									
								</td>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									
									<h:selectOneMenu id="msa002tab1_docProvince" value="#{semmsa002Bean.siteAppObjParam.docLocProvinceId}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly}" onchange="msa002tab1_GetContAmphurListJS();" styleClass="ms7">
										<f:selectItems value="#{semmsa002Bean.provinceList}"/>
									</h:selectOneMenu>
									
									<a4j:jsFunction name="msa002tab1_GetContAmphurListJS" reRender="msa002tab1_contAmphur" action="#{semmsa002Action.getContAmphurList}"/>
								</td>
							</tr>
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									
								</td>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:45%; text-align:left;">
									<h:inputText style="width:200" value="#{semmsa002Bean.siteAppObjParam.docLocPostCode}"
									 disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputText>
								</td>
							</tr>
							
							<tr>
								<td style="width:5%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; text-align:left;" colspan="3">
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
									value="Add" reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
									disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="false">
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
									value="save" reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
									disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="false">
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
									value="cancel" reRender="oppContent, msa002tab1_docNo, msa002-1_docNo, msa002tab1_BtnGenAppr"
									disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="false">
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
									</a4j:commandButton>
								</td>
								
							</tr>
						</table>
					</h:panelGroup>
			</rich:panel>
		
		</rich:panel>
		
			
	
	</h:panelGrid>
	<!-- << wrapper panel -->
	


	
	
	
