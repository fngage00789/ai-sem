<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<h:panelGrid columnClasses="gridContent" width="100%">
		 <h:panelGrid id="pnlTab1" width="98%">
		 		<rich:panel id="pnlSiteInfoContract">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.siteInfo']}"/>
						</f:facet>
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td colspan="4" align="right">
									<a4j:commandButton id="btnUploadPicture"
										action="#{navAction.navi}"
										reRender="oppContent,popupUploadPictureCriteria"
										rendered="#{semmsi004tab2Bean.siteContract.contractNo != null}"
										value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
										oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
										<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value="SI"/>
										<a4j:actionparam name="contractNo" value="#{semmsi004tab2Bean.siteContract.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									
									<a4j:commandButton style="" styleClass="rich-button" id="msi004tab1_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_station']}"
		                                action="#{semmsi004Action.doShowPopupHistory}" reRender="oppContent,tab1_panel_popupModalRetStatus,popupDisplay1"
		                                oncomplete="#{rich:component('tab1_panel_popupModalRetStatus')}.show(); return false;">
		                                <f:param name="tabNo" value="1"/>
	                                </a4j:commandButton>
	                                <a4j:include id="popUpTab1"  viewId="../../pages/sa/semmsa002PopUpTab1.jsp" />
								</td>
							</tr>
							<tr>
								<td align="right" width="35%" valign="top">
								<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
	                			</td>
	                			<td width="65%" colspan="3">
	                			<h:inputText id="txtContractNoDisplay2" value="#{semmsi004tab2Bean.siteContract.contractNo}" 
	                			 size="16"  readonly="true" styleClass="ms28Blue"/>
	                			 <rich:spacer width="5"/>
                				
                			
			                	</td>
		                	 </tr>
		                	 
		                	 <tr>
		                	 <td colspan="4">
		                	  <table width="100%">
		                	  <tr>
							<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                			</td>
                			<td width="40%">
                			<h:inputText id="txtCompany" value="#{semmsi004tab1Bean.siteInfo.company}" 
                			size="23" maxlength="20" readonly="true" disabled="true"/>
                			
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
                			</td>
                			<td width="20%">
                			<h:inputText id="txtRegion2" value="#{semmsi004tab1Bean.siteInfo.region}"  
                			readonly="true" disabled="true" size="13" maxlength="10"/> 
                			
		                	</td>
	                		 </tr>
	                		 
	                		<tr>
							<td align="right" width="20%">
							<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
                			</td>
                			<td width="40%">
	                			<h:inputText id="txtSiteName" value="#{semmsi004tab1Bean.siteInfo.siteName}" 
	                			size="30"  maxlength="200" disabled="#{semmsi004tab1Bean.disabledSiteName}"/>
	                			<rich:spacer width="10"></rich:spacer>
	                			<h:selectBooleanCheckbox id="chkEditSite"  styleClass="ms7" onclick="onCheckSiteNameJS();" 
	                			value="#{semmsi004tab1Bean.chkEditSite}" 
	                			disabled="#{semmsi004tab1Bean.disabledSite}">
	                				<a4j:jsFunction name="onCheckSiteNameJS" reRender="txtSiteName" 
										action="#{semmsi004tab1Action.renderedSiteName}"/>
	                			</h:selectBooleanCheckbox>
	                			<h:outputText value="#{jspMsg['label.editSite']}"  styleClass="ms7"/>
	                			<script type="text/javascript">
									function renderedSiteName(){
										var chkEditSite = document.getElementById("incContent:frmAddSiteInfo:incTab1:chkEditSite").checked;
										var siteName = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtSiteName");
										if(chkEditSite){
											siteName.disabled = false;
										}else{
											siteName.disabled = true;
										}
									}
								</script>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                			<a4j:region>
                			<h:panelGroup>
                			<h:inputText id="txtOldContractNo" value="#{popupSiteContractBean.oldContractNo}"
							readonly="#{semmsi004Bean.disabledModeView}" 
							disabled="#{semmsi004Bean.disabledModeView}"
							size="10" maxlength="20" onchange="GetOldContractNoJS();"
							onblur="setFormatContractNo(this)">
							<a4j:jsFunction name="GetOldContractNoJS" reRender="txtOldContractNo" 
                			action="#{popupSiteContractAction.getSiteInfoId}">
                			<a4j:actionparam  name="fromButton" value="oldContractNo"></a4j:actionparam>
                			</a4j:jsFunction>
							</h:inputText>
                			<rich:spacer width="2"></rich:spacer>
                			<a4j:commandButton id="btnPopupSearchContractNo"  
                			disabled="#{semmsi004Bean.disabledModeView}"
                			oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
							value="..."  reRender="popupSearchContractNo,popupFrmSearch"
		            		action="#{navAction.navi}" >
		            		
		            		<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
							<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
							<a4j:actionparam name="fromButton" value="oldContractNo" />
            				</a4j:commandButton>
            				 <rich:spacer width="5"></rich:spacer>
            				 
            				<a4j:commandButton id="btnCopyOldSiteInfo" value="#{jspMsg['btn.copyOldSiteInfo']}" 
            				disabled="#{semmsi004Bean.disabledModeView}"
            				oncomplete="if(#{semmsi004tab1Bean.popupClose == 'false'})#{rich:component('mdpConfirmCopyOldSiteInfo')}.show();" 
   							action="#{navAction.navi}" styleClass="rich-button" style="width:170" immediate="true"
   							reRender="frmSiteInfoError,btnCopyOldSiteInfo,pnlSiteInfo,frmAddSiteInfo,frmConfirmCopyOldSiteInfoDialog,pnlSiteInfoContract,cldEffDate,rgnSiteInfoContract,oppContent">
   							<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="chkCopyOldSiteInfo" />
           					</a4j:commandButton>  
           					
           					<a4j:status onstart="#{rich:component('mdpWait')}.show(); doTimer()"
								onstop="pageOnLoad(); doClearTimer(); #{rich:component('mdpWait')}.hide()" />
							
							<rich:modalPanel id="mdpWait" autosized="true" width="180" height="70" 
								moveable="false" resizeable="false">
								<f:facet name="header">
									<h:outputText value="Processing" />
								</f:facet>
								<f:facet name="controls">
									<h:panelGroup>
										<h:graphicImage value="images/ico_close.png"
											id="gpiHidePopUpProgress" style="cursor:pointer" />
										<rich:componentControl for="mdpWait" attachTo="gpiHidePopUpProgress"
											operation="hide" event="onclick" />
									</h:panelGroup>
								</f:facet>
								
								<div align="center">
									<table width="100%" border="0" cellpadding="1" cellspacing="0">
										<tr>
											<td align="right"><h:graphicImage value="images/loading.gif"/></td>
											<td><h:outputText styleClass="ms7" value="Wait Please..." /></td>
										</tr>
									</table>
								</div>
							</rich:modalPanel>
           					
                			</h:panelGroup>
                			</a4j:region>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
							<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
                			</td>
                			<td width="40%" >
                			<h:selectOneMenu id="ddlSiteType" value="#{semmsi004tab1Bean.siteInfo.siteType}" 
                			disabled="#{semmsi004Bean.disabledSiteType}"> 
								<f:selectItems value="#{semmsi004Bean.siteTypeList}"/>
							</h:selectOneMenu>
		                	</td>
		                	<td align="right" width="20%" >
							<h:outputText value="#{jspMsg['label.groupRent']}" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                			<h:selectOneMenu id="ddlGroupRent" value="#{semmsi004tab1Bean.siteInfo.groupRent}" 
                			disabled="#{semmsi004Bean.disabledSiteType}"> 
								<f:selectItems value="#{semmsi004Bean.groupRentList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
		                	  <tr>
								<td align="right" width="20%">
								<h:graphicImage  value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
	                			</td>
	                			<td width="80%" colspan="3">
	                			<table width="100%">
	                			<tr>
	                			<td align="left" width="60%">
	                			<h:panelGroup id="contractNo3"  rendered="#{semmsi004tab1Bean.renderContractNo}">
	                			<h:panelGrid columns="4">
		                			<h:inputText id="txtContractNo1" value="#{semmsi004tab2Bean.contractNo1}" size="10"
		                				disabled="true" maxlength="7"
		                				onchange="RenderDisplayContractNoJS();">
		                			</h:inputText>
		                			<h:inputText id="txtContractNo2" value="#{semmsi004tab2Bean.contractNo2}" size="10" 
	           						 	onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	           						 	onchange="RenderDisplayContractNoJS();"
	           							 maxlength="6" 
	           						 	disabled="#{not(semmsi004Bean.reqTypeParam eq '01') or semmsi004tab2Bean.disabledContractNo}">
		                			</h:inputText>
	                				<h:panelGroup>
		                				<h:outputText value="." styleClass="ms7" />
		                				<rich:spacer width="2"></rich:spacer>
		                				<h:inputText id="txtContractNo3" value="#{semmsi004tab2Bean.contractNo3}" size="5" 
			             					onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			             					onchange="RenderDisplayContractNoJS();"
			             					maxlength="1" 
			             					disabled="#{not(semmsi004Bean.reqTypeParam eq '01') or semmsi004tab2Bean.disabledContractNo }">
	             						</h:inputText>
		             					<a4j:jsFunction name="RenderDisplayContractNoJS" reRender="txtContractNoDisplay2" 
				                			action="#{semmsi004tab2Action.renderedDisplayContractNo}"/>
	                				</h:panelGroup>
		                			<a4j:commandButton id="btnGenContractNo" value="#{jspMsg['label.genContractNo']}" 
		    							action="#{navAction.navi}" rendered="#{semmsi004tab1Bean.renderedBtnGenContractNo}"
		    							styleClass="rich-button" style="width:100"
		    							disabled="#{semmsi004tab1Bean.editableSiteFlag == 'N'}" 
		    							reRender="txtContractNoDisplay2,txtContractNo1,txtContractNo2,txtContractNo3, mdpConfirmGenContractNo">
		    							<a4j:actionparam name="navModule" value="si" />
					            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
										<a4j:actionparam name="methodWithNavi" value="doGenContractNo" />
	            					</a4j:commandButton>  
	                			</h:panelGrid>
	                			</h:panelGroup>
	                			<h:panelGroup id="dummyContractNo" rendered="#{semmsi004tab1Bean.renderDummyContractNo}">
		                			<h:inputText id="txtDummyContractNo" value="#{semmsi004tab1Bean.dummyContractNo}" size="18" 
	            						maxlength="16" 
	            						onblur="this.value= this.value.toUpperCase()"
	            						onchange="RenderDisplayContractNoJS2();"
	            						disabled="#{semmsi004tab2Bean.disabledContractNo}">
	             					</h:inputText>
	             					<a4j:jsFunction name="RenderDisplayContractNoJS2" reRender="txtContractNoDisplay2" 
			                			action="#{semmsi004tab2Action.renderedDisplayContractNo}"/>
	                			</h:panelGroup>
	                			<h:panelGroup id="noFormatContractNo" rendered="#{semmsi004tab1Bean.renderNoFormatContractNo}">
	                				<h:inputText id="txtNoFormatContractNo" value="#{semmsi004tab2Bean.contractNoFormat}" size="18" 
	            						maxlength="16" 
	            						onblur="this.value= this.value.toUpperCase()"
	            						onchange="RenderDisplayContractNoJS2();"
	            						disabled="#{semmsi004tab2Bean.disabledContractNo}">
	             					</h:inputText>
	             					<a4j:jsFunction name="RenderDisplayContractNoJS2" reRender="txtContractNoDisplay2" 
			                			action="#{semmsi004tab2Action.renderedDisplayContractNo}"/>
	                			</h:panelGroup>
	                			</td>
	                			<td align="left" width="40%">
            					<h:selectBooleanCheckbox id="chkDummyContract" value="#{semmsi004tab2Bean.chkDummyFlag}" styleClass="ms7"
								disabled="true" 
								onclick="RenderDummyContractNoJS();"/>
			                		<h:outputText value="#{jspMsg['label.dummyContract']}" styleClass="ms7" />
			                	<a4j:jsFunction name="RenderDummyContractNoJS" reRender="pnlSiteInfoContract,dummyContractNo,contractNo3" 
			                	action="#{semmsi004tab1Action.renderedContractNo}"/>
			                	<rich:spacer width="5"></rich:spacer>
			                	<h:selectBooleanCheckbox id="chkOwnerContract" value="#{semmsi004tab2Bean.chkOwnerContractFlag}" styleClass="ms7"
								disabled="#{semmsi004Bean.viewMode}" />
			                	<h:outputText value="#{jspMsg['label.ownerContractFlag']}" styleClass="ms7" />
	                			</td>
	                			</tr>
	                			</table>
	                			
			                	</td>
	                			</tr>
	                			 <tr>
								<td align="right" width="20%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['labe.firstEffDate']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="80%" colspan="3">
	                			<table width="100%">
	                			<tr>
	                			<td align="left" width="60%">
	                			<rich:calendar id="cldFirstEffDate" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
	                			value="#{semmsi004tab2Bean.siteContract.firstEffectiveDt}" 
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['labe.firstEffDate']}"
								disabled="#{semmsi004Bean.disabledModeView || (semmsi004Bean.reqTypeParam eq '02'
								|| semmsi004Bean.reqTypeParam eq '03')}">
								</rich:calendar>
	                			</td>
	                			<td align="left" width="40%">
            					<h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmsi004tab2Bean.chkNoExpireFlag}" 
								onclick="RenderAgeJS();" styleClass="ms7" 
								disabled="#{semmsi004tab2Bean.disabledNoExpireFlag}"/>
			                	<h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
			                	<a4j:jsFunction name="RenderAgeJS" reRender="txtAgeYear,txtAgeMonth,txtAgeDay,cldExpDate,imgStarExpDate" 
		                		action="#{semmsi004tab2Action.renderAge}"/>
	                			</td>
	                			</tr>
	                			</table>
	                			</td>
			                 </tr>
			                 <tr>
							<td align="right" width="20%">
							<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="40%">
							<rich:calendar id="cldEffDate" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
	                			value="#{semmsi004tab2Bean.siteContract.effectiveDt}" 
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['labe.firstEffDate']}"
								disabled="#{semmsi004tab2Bean.disabledEffDate}"
								oninputblur="setFirstEffDate(#{semmsi004Bean.reqTypeParam});"
								oncollapse="setFirstEffDate(#{semmsi004Bean.reqTypeParam});"
								oninputchange="reRenderDate();"
								>
							</rich:calendar>
							<a4j:jsFunction name="reRenderDate" reRender="cldEffDate"></a4j:jsFunction>
							
							<a4j:jsFunction name="calAge" action="#{semmsi004tab2Action.calAge}"
							reRender="frmSiteInfoError,txtAgeYear,txtAgeMonth,txtAgeDay,cldFirstEffDate, txtTotalAgeRentAmt, txtTotalAgeServiceAmt, txtTotalAgeRentServiceAmtTab1">
							</a4j:jsFunction>
							<script type="text/javascript" >
							function setFirstEffDate(reqType){
								var cldEffDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldEffDateInputDate").value;
								var cldExpDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldExpDateInputDate").value;
								var cldFirstEffDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldFirstEffDateInputDate");
								var txtOldContractNo = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtOldContractNo").value;
								
								if(cldEffDate != ''){
									if (reqType == '01') {
										cldFirstEffDate.value = cldEffDate;
									}
									// calAge();
								}else if(cldEffDate == '' && txtOldContractNo == ''){
									cldFirstEffDate.value = '';
								}
								
								if(cldEffDate != '' && cldExpDate != ''){
									calAge();
								}else{
									var ageYear = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeYear");
									var ageMonth = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeMonth");
									var ageDay = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeDay");
									ageYear.value = '';
									ageMonth.value = '';
									ageDay.value = '';
								}
								reRenderDate();
							}
							</script>
		                	</td>
		                	<td align="right" width="20%">
							<h:graphicImage id="imgStarExpDate" value="images/icon_required.gif" 
							rendered="#{semmsi004tab2Bean.renderStarImage}"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
							</td>
							<td width="20%">
							<rich:calendar id="cldExpDate" locale="th" enableManualInput="true" 
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab2Bean.siteContract.expireDt}" 
							showWeeksBar="false" 
							inputSize="13"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.expDate']}"
							disabled="#{semmsi004tab2Bean.disabledExpDate}"
							oninputblur="checkCalAge();"
							oncollapse="checkCalAge();">
							</rich:calendar>
							<script type="text/javascript">
							function checkCalAge(){
								var cldEffDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldEffDateInputDate").value;
								var cldExpDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldExpDateInputDate").value;
								
								if(cldEffDate != '' && cldExpDate != ''){
									calAge();
								}else{
									var ageYear = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeYear");
									var ageMonth = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeMonth");
									var ageDay = document.getElementById("incContent:frmAddSiteInfo:incTab1:txtAgeDay");
									ageYear.value = '';
									ageMonth.value = '';
									ageDay.value = '';
								}
								
							}
							</script>
                			</td>
	                	 </tr>
	                	 <tr>
							<td align="right" width="20%">
							<h:panelGroup id="pnlImgStar" rendered="#{semmsi004tab2Bean.renderStarImage}">
							<h:graphicImage id="imgStar" value="images/icon_required.gif" />
							</h:panelGroup>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.ageContract']}" styleClass="ms7"/>
                			</td>
                			<td width="80%" colspan="3">
                			 <table>
                			 <tr>
                			 	<td>
                					<h:inputText id="txtAgeYear"  value="#{semmsi004tab2Bean.siteContract.ageYearInt}" size="3"
              				 		styleClass="inputTextRight" disabled="true"/>
              				 		<rich:spacer width="2" />
              						<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
              						<rich:spacer width="2" />
              						</td>
              						<td>
              						<h:inputText id="txtAgeMonth"  value="#{semmsi004tab2Bean.siteContract.ageMonthInt}" size="3"
               				 	styleClass="inputTextRight" disabled="true"/>
               				 	<rich:spacer width="2"></rich:spacer>
               			 		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
               			 		<rich:spacer width="2" />
              						</td>
              						<td>
              						 <h:inputText id="txtAgeDay"  value="#{semmsi004tab2Bean.siteContract.ageDayInt}" size="3"
               				 	 styleClass="inputTextRight" disabled="true"/>
               				 	 <rich:spacer width="2"></rich:spacer>
               					 <h:outputText value="#{jspMsg['label.day']}" styleClass="ms7" />
               					 <rich:spacer width="2" />
              						</td>
              						</tr>
              					</table>
		                	</td>
	                	 </tr>
							
	                		
	                		<tr>
							<td align="right" width="20%">
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
                			</td>
                			<td width="40%">
                			<h:inputText id="txtSiteStatus" value="#{semmsi004tab1Bean.si004SrchSiteStatusSP.siteStatus}" 
                						 size="60" 
	            						 maxlength="60" 
	            						 disabled="true">
	             			</h:inputText>
                			<!--<h:selectOneMenu id="ddlSiteStatus" value="#{semmsi004tab1Bean.siteInfo.siteStatus}" disabled="true"> 
								<f:selectItems value="#{semmsi004Bean.siteStatusList}"/>
							</h:selectOneMenu>
		                	-->
		                	</td>
		                	<td align="right" width="20%">
		                	<h:panelGroup rendered="#{semmsi004Bean.reqTypeParam eq '99'}">
		                	<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							</h:panelGroup>
							<h:outputText value="#{jspMsg['label.terminateDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                			<rich:calendar id="cldTerminateDate" locale="th" enableManualInput="true"  
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab1Bean.siteInfo.terminateDt}" 
							showWeeksBar="false" 
							inputSize="13"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.terminateDate']}"
							disabled="#{semmsi004tab1Bean.disabledTerminateDate}">
							</rich:calendar> 
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.pendingStatus']}" styleClass="ms7"/>
                			</td>
                			<td  width="40%">
                			<h:selectBooleanCheckbox id="chkPendingStatus" value="#{semmsi004tab1Bean.chkPendingStatus}" 
                			disabled="#{semmsi004Bean.disabledModeView}"
                			onclick="renderedPendingDate();"/>
                			<h:outputText value="#{jspMsg['column.header.pending']}"  styleClass="ms7"/>
                			<rich:spacer width="5"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.pendingDate']} :" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<rich:calendar id="cldPendingDate" locale="th" enableManualInput="true"  
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab1Bean.siteInfo.pendingDt}" 
							showWeeksBar="false" 
							inputSize="13"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.pendingDate']}"
							disabled="#{semmsi004Bean.disabledModeView}">
							</rich:calendar> 
							<script type="text/javascript">
									function renderedPendingDate(){
										var chkPendingStatus = document.getElementById("incContent:frmAddSiteInfo:incTab1:chkPendingStatus").checked;
										var pendingDate = document.getElementById("incContent:frmAddSiteInfo:incTab1:cldPendingDateInputDate");
										if(chkPendingStatus){
											pendingDate.disabled = false;
										}else{
											pendingDate.disabled = true;
										}
									}
							</script>
							</td>
							<td align="right" width="20%">
		                	<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.siteInfoStatus']}" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                			<h:selectOneMenu id="ddlSiteInfoStatus" value="#{semmsi004tab1Bean.siteInfo.siteInfoStatus}" 
                			disabled="#{semmsi004tab1Bean.disabledSiteInfoStatus}"> 
								<f:selectItems value="#{semmsi004Bean.siteInfoStatusList}"/>
							</h:selectOneMenu> 
		                	</td>
	                		</tr>
	                		 <tr>
							<td align="right" width="20%" valign="top">
							<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
                			</td>
                			<td width="80%" colspan="3">
                			<h:inputTextarea id="txtRemark" value="#{semmsi004tab2Bean.siteContract.remark}" 
                			cols="100" rows="8" disabled="#{semmsi004Bean.disabledModeView}"/>
                			
		                	</td>
	                	 </tr>
		                	 	
	                		</table>
		                	 </td>
		                	 </tr>
		                	 </table>
						</h:panelGroup>
						</h:panelGrid>
						
						<rich:spacer height="10"></rich:spacer>
						
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				<rich:spacer height="10"></rich:spacer>
				<!-- panel search location criteria -->
				<a4j:region>
		          <rich:panel id="pnlLocation" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.location']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab1Bean.renderedMsgLocation}"/>
						</div>
						<h:panelGrid id="pnlSearchLocationCriteria" width="98%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table style="width:100%; border:solid 1px;">
									<tr>
										<td style="width:15%; text-align:right; white-space:nowrap;">
											<h:outputText value="LOCATION ID : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText id="txtLocationId" value="#{popupSiteLocationBean.locationId}" onchange="getLocationJS();" 
				                			size="18" maxlength="15" disabled="#{semmsi004Bean.disabledModeView}">
				                			<a4j:jsFunction name="getLocationJS" reRender="pnlSearchLocationCriteria" action="#{popupSiteLocationAction.getSiteLocation}"/>
				                			</h:inputText>
				                			<rich:spacer width="2"></rich:spacer>
				                			<a4j:commandButton id="btnSrchLocation" value="..." action="#{navAction.navi}"
											oncomplete="#{rich:component('popupSearchSiteLocation')}.show(); return false" 
											reRender="popupSearchSiteLocation,pnlSearchLocationCriteria" 
											disabled="#{semmsi004Bean.disabledModeView}" styleClass="rich-button">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
											<a4j:actionparam name="methodWithNavi" value="initPopupSiteLocation" />
				            				</a4j:commandButton>
										</td>
										<td style="width:15%; text-align:right; white-space:nowrap;">
											<h:outputText value="LOCATION CODE : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText id="txtLocationCode" value="#{popupSiteLocationBean.locationCode}" readonly="true" disabled="true" 
		                			size="13" maxlength="10"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="ZONE : " styleClass="ms7" />
										</td>
										<td style="width:30%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.locationZone}" 
											maxlength="50" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
									</tr>
									
									<%-- commented by.. YUT 2015/03/10 --%>
									<%--
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="TOWER TYPE : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.towerType}" 
											readonly="true" maxlength="50" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="TOWER LOCATION : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.towerLocation}" 
											readonly="true" maxlength="50" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="TOWER HEIGHT : " styleClass="ms7" />
										</td>
										<td style="width:30%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.towerHeight}" 
											readonly="true" maxlength="50" style="text-align:right;" styleClass="ms7" />
										</td>
									</tr>
									--%>
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:selectBooleanCheckbox id="msi004tab1_chkEditLocalName" 
											value="#{semmsi004tab1Bean.chkEditLocalName}" disabled="#{semmsi004Bean.disabledModeView}"
											onclick="editLocationName();">  </h:selectBooleanCheckbox>
										
											<h:outputText value="#{jspMsg['label.th_name']} Location : " styleClass="ms7" />
											<a4j:jsFunction name="editLocationName" reRender="txtLocationName"></a4j:jsFunction>
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText id="txtLocationName" value="#{popupSiteLocationBean.locationName}" 
		                			size="30" maxlength="255"  disabled="#{semmsi004tab1Bean.chkEditLocalName}"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="Re-Locate : " styleClass="ms7" />
											<%-- 
											<h:outputText value="Co-Locate #{jspMsg['label.th_with']} #{jspMsg['label.th_company']} : " styleClass="ms7" />
											--%>
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.reLocate}"
											disabled="#{semmsi004Bean.disabledModeView}" 
											maxlength="50" styleClass="ms7"/>
											<%-- 
											<h:inputText value="#{popupSiteLocationBean.coLocateCompany}" id="msi004tab1_coLocateCompany"
											readonly="true" maxlength="200" styleClass="ms7" />
											--%>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
										</td>
										<td style="width:30%; width:20%; text-align:left;">
											
											<h:inputText value="#{popupSiteLocationBean.locationStatus}" 
											maxlength="20" styleClass="ms7" readonly="true" disabled="true"/>
											
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										
											<h:outputText value="#{jspMsg['label.th_phase']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.phase}" 
											maxlength="50" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['lable.th_mainlocation']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.locationName}" 
											maxlength="50" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										</td>
										<td style="width:30%; width:20%; text-align:left;">
											
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										
											<h:outputText value="#{jspMsg['lable.placeType']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:selectOneMenu  value="#{popupSiteLocationBean.locationType}" styleClass="ms7" readonly="true" disabled="true">
												<f:selectItems value="#{semmsi004tab1Bean.locationList}"/>
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
											<h:inputTextarea rows="6" cols="100" readonly="true" disabled="true"
											value="#{popupSiteLocationBean.locAddressNo}"></h:inputTextarea>
										</td>
									</tr>
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.locBuilding}" style="width:80%;" maxlength="200" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; white-space:nowrap; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.locFloor}" style="width:150px;"  maxlength="10" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
										</td>
										<td style="width:30%; white-space:nowrap; text-align:left;">
											<h:inputText value="#{popupSiteLocationBean.locRoomNo}" style="width:150px;"  
											maxlength="10" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;" >
											<h:inputText value="#{popupSiteLocationBean.locStreet}" style="width:150px;"  maxlength="10" styleClass="ms7" readonly="true" disabled="true" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputText value="#{popupSiteLocationBean.tumbol}" style="width:150px;"  maxlength="10" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;">
											<h:selectOneMenu id="msi004tab1_locAmphur" value="#{popupSiteLocationBean.amphur}" styleClass="ms7" readonly="true" disabled="true">
												<f:selectItems value="#{popupSiteLocationBean.amphurList}"/>
											</h:selectOneMenu>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:left;" >
											<a4j:region>
												<h:selectOneMenu id="msi004tab1_locProvince" value="#{popupSiteLocationBean.province}" 
												styleClass="ms7" readonly="true" disabled="true" onchange="GetLocationAmphurListJS();">
													<f:selectItems value="#{semmsi004tab1Bean.provinceList}"/>
												</h:selectOneMenu>
											</a4j:region>
											<a4j:jsFunction name="GetLocationAmphurListJS" reRender="ddlSiteAmphur" action="#{semmsi004tab1Action.getLocationAmphurList}"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
										</td>
										<td style="width:30%;" >
											<h:inputText value="#{popupSiteLocationBean.zipCode}" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											style="width:100px; text-align:right;" maxlength="5" styleClass="ms7" readonly="true" disabled="true"/>
										</td>
									</tr>
									
									<tr>
									<td align="left" colspan="2" width="58%">
									<h:panelGrid columns="3" id="grdSearchCommand">
									<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
	            					<a4j:commandButton id="btnAddLocation" value="#{jspMsg['btn.add']}" styleClass="rich-button"
									action="#{navAction.navi}"   
									reRender="pnlSiteInfoContract, pnlLocation,grdSearchCommand,pnlSearchLocationCriteria
									,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError"
									oncomplete="if(#{semmsi004tab1Bean.popupConfirmAdd == 'true'})#{rich:component('mdpConfirmAddDialogLocation')}.show();"
									disabled="#{semmsi004tab1Bean.disableBtnAddLocation}">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
									<a4j:actionparam name="methodWithNavi" value="initAddLocation" />
									<a4j:actionparam name="mode" value="ADD" />
									</a4j:commandButton>  
									</h:panelGroup>
									<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
									<a4j:commandButton id="btnSaveLocation" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" 
									reRender="pnlSiteInfoContract, pnlLocation,grdSearchCommand,pnlSearchLocationCriteria,
									pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError"  
									oncomplete="if(#{semmsi004tab1Bean.popupConfirmAdd == 'true'})#{rich:component('mdpConfirmUpdateDialogLocation')}.show();"
									disabled="#{semmsi004tab1Bean.disableBtnSaveLocation}">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
									<a4j:actionparam name="methodWithNavi" value="initAddLocation" />
									<a4j:actionparam name="mode" value="EDIT" />
									</a4j:commandButton>  
									</h:panelGroup>
									<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
									<a4j:commandButton id="btnClearLocation" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" 
					           	 	reRender="pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,frmSiteInfoError"
					           	 	>
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
									<a4j:actionparam name="methodWithNavi" value="doClearLocation" />
					           		</a4j:commandButton>
					           		</h:panelGroup>
									</h:panelGrid>
		                			</td>
				                	<td  width="20%">
		                			</td>
		                			<td width="22%">
		                			<h:selectBooleanCheckbox id="chkMainLocation" value="#{semmsi004tab1Bean.chkMainLocFlag}" 
		                			styleClass="ms7" disabled="#{semmsi004Bean.disabledModeView}"/>
				                		<h:outputText value="#{jspMsg['label.mainLocation']}" styleClass="ms7" />
				                	</td>
			                	 </tr>
									
									<tr>
										<td></td>
										<td colspan="5">
											<a4j:commandButton style="margin-left:5px;" id="msi004tab1_saveLo" styleClass="rich-button"
											value="save" rendered="false">
											</a4j:commandButton>
											
											<rich:spacer width="5"></rich:spacer>
											
											<a4j:commandButton style="margin-left:5px;" id="msi004tab1_cancelLo" styleClass="rich-button"
											value="cancel" rendered="false">
											</a4j:commandButton>
										</td>
									</tr>
								</table>
							</h:panelGroup>
							<rich:spacer height="10"></rich:spacer>
							<h:panelGroup>
								<rich:panel id="pnlResultSearchLocation" styleClass="sem_autoScrollbarInSATab1">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.panel.location']}" />
									</f:facet>
										<rich:dataTable id="dtbLocation" width="97%" cellpadding="1" cellspacing="0" border="0"
										var="siteInfoMapLocSP" value="#{semmsi004tab1Bean.siteInfoMapLocSPList}" reRender="dtbLocation" 
										rows="#{semmsi004tab1Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
										<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbLocation">
											<a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
										</a4j:support>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}" 
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header" >
												<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlLocation"
				            					image="images/edit.png" style="height: 15; width : 15px;"
				            					rendered="true">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
													<a4j:actionparam name="methodWithNavi" value="initUpdateLocation" />
													<a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
													<a4j:actionparam name="locationId" value="#{siteInfoMapLocSP.locationId}" />
													<a4j:actionparam name="locationCode" value="#{siteInfoMapLocSP.locationCode}" />
													<a4j:actionparam name="locationName" value="#{siteInfoMapLocSP.locationName}" />
													<a4j:actionparam name="region" value="#{siteInfoMapLocSP.region}" />
													<a4j:actionparam name="stationType" value="#{siteInfoMapLocSP.stationType}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}"
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialogLocation')}.show(); return false" 
			     								action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
			     								rendered="true" reRender="mdpConfirmDelDialogLocation">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
													<a4j:actionparam name="methodWithNavi" value="initDeleteLocation" />
													<a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.mainLocFlag}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.mainLocation']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{siteInfoMapLocSP.mainLocFlag}" styleClass="contentform"  />
											</div>
										</rich:column>
										<rich:column sortBy="" title="#{siteInfoMapLocSP.action}" rendered="false">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.action']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.locationId}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{siteInfoMapLocSP.locationId}" styleClass="contentform"  />
											</div>
										</rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.locationStatus}" title="#{siteInfoMapLocSP.locationStatus}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['lable.th_locationstatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.locationStatus}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.slimsstatus}" title="#{siteInfoMapLocSP.slimsstatus}" rendered="false">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.slimsstatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.slimsstatus}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.liveNetwork}" title="#{siteInfoMapLocSP.liveNetwork}" rendered="false">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.liveNetwork']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.liveNetwork}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.contractInfo}" title="#{siteInfoMapLocSP.contractInfo}" rendered="false">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.th_info_contract']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.contractInfo}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                           	<rich:column sortBy="#{siteInfoMapLocSP.contractStatus}" title="#{siteInfoMapLocSP.contractStatus}" rendered="false">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.contractStatus}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.siteGroup}" title="#{siteInfoMapLocSP.siteGroup}">
			                                <f:facet name="header">
			                                    <h:outputText value="Site Group" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.siteGroup}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.system}" title="#{siteInfoMapLocSP.system}">
			                                <f:facet name="header">
			                                    <h:outputText value="System" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.system}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.siteType}" title="#{siteInfoMapLocSP.siteType}">
			                                <f:facet name="header">
			                                    <h:outputText value="Site Type" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.siteType}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.stationType}" rendered="false" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.stationType']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{siteInfoMapLocSP.stationType}" styleClass="contentform"  />
											</div>
										</rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.companySiteCode}" title="#{siteInfoMapLocSP.company}">
			                                <f:facet name="header">
			                                    <h:outputText value="Company" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.companySiteCode}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.siteCode}" title="#{siteInfoMapLocSP.siteCode}">
			                                <f:facet name="header">
			                                    <h:outputText value="Site Code" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.siteCode}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.siteName}" title="#{siteInfoMapLocSP.siteName}">
			                                <f:facet name="header">
			                                    <h:outputText value="Site Name" styleClass="contentform" style="width: 250"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.siteName}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.siteActivity}" title="#{siteInfoMapLocSP.siteActivity}">
			                                <f:facet name="header">
			                                    <h:outputText value="Site Activity" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.siteActivity}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.towerType}" title="#{siteInfoMapLocSP.towerType}">
			                                <f:facet name="header">
			                                    <h:outputText value="Tower Type" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.towerType}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.towerLocation}" title="#{siteInfoMapLocSP.towerLocation}">
			                                <f:facet name="header">
			                                    <h:outputText value="Tower Location" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.towerLocation}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.towerHeight}" title="#{siteInfoMapLocSP.towerHeight}">
			                                <f:facet name="header">
			                                    <h:outputText value="Tower Height" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="#{siteInfoMapLocSP.towerHeight}" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column sortBy="#{siteInfoMapLocSP.locationCode}" rendered="false" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.locationCode']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{siteInfoMapLocSP.locationCode}" styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.locationName}" rendered="false" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.locationName']}" styleClass="contentform" />
											</f:facet>
											<div align="left">
												<h:outputText value="#{siteInfoMapLocSP.locationName}" styleClass="contentform"  />
											</div>
										</rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.region}" rendered="false" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{siteInfoMapLocSP.region}" styleClass="contentform"  />
											</div>
										</rich:column>
										<rich:column sortBy="#{siteInfoMapLocSP.rentAmt}" rendered="false" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.rent']}" styleClass="contentform" />
											</f:facet>
											<div align="right">
												<h:outputText value="#{siteInfoMapLocSP.rentAmt}" styleClass="contentform" >
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>		
																		
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsi004tab1Bean.siteInfoMapLocSPList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<rich:column colspan="12">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLocation"
														maxPages="#{semmsi004tab1Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dstLocation" 
														style="background-color: #cccccc;"
														page="#{semmsi004tab1Bean.scrollerPage}" 
													/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>
								</rich:panel>
							</h:panelGroup>
						</h:panelGrid>
						</rich:panel>

						<rich:spacer height="10"></rich:spacer>
						<!-- Result Search Location -->
						<rich:panel id="pnlResultServiceType">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['label.serviceType']}" />
						</f:facet>
							
						<table style="width:90%; border:solid 1px;">
							<tr>
								<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="width:90%; text-align:left;">
								
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								</td>
								<td style="width:90%; text-align:left;">
									<div id="msi004tab1Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService1tab1" cellpadding="1" cellspacing="0" border="0" 
										var="servObj"  value="#{semmsi004tab1Bean.siteAppExtServList}" reRender="dataService1tab1" 
										rows="" rowClasses="cur" styleClass="dataTable">
										
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
								            
								    	</rich:dataTable>
								    	
									</div> 
									
									<div style="clear:both; height:10px;"></div>
									
									<div id="msi004tab1Service2" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService2tab1" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService2"  value="#{semmsi004tab1Bean.siteAppCurrServList}" reRender="dataService2tab1" 
										rows="" rowClasses="cur" styleClass="dataTable">
										
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
								            
								    	</rich:dataTable>
								    	
									</div> 
									
									<div style="clear:both; height:10px;"></div>
									
									<div id="msi004tab1Service3" style="width:600px; overflow:scroll; border:1px solid e0e0e0;"> 
						
										<rich:dataTable style="width:100%;" id="dataService3tab1" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService3"  value="#{semmsi004tab1Bean.siteAppServList}" reRender="dataService3tab1" 
										rows="" rowClasses="cur" styleClass="dataTable">
										
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
								    	</rich:dataTable>
								    	
									</div> 
								</td>
							</tr>
						</table>
					</rich:panel>
				
					<rich:spacer height="10"></rich:spacer>
						<!-- station address -->
					<rich:panel id="pnlStationAddress">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['label.th_stationaddress']}" />
						</f:facet>
						
						<table width="95%" border="0">
							
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_terraceArea']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:panelGroup>
										<h:selectOneMenu id="ddlSiteDeckAreaType" value="#{semmsi004tab1Bean.siteInfo.deckAreaType}"
			                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.deckAreaTypeList}"/>
										 </h:selectOneMenu>
										
										<rich:spacer width="5"></rich:spacer>
									
										<h:inputText id="txtSiteDeckArea" value="#{semmsi004tab1Bean.siteInfo.deckArea}" size="18"
	              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	              						 onblur="return numberformat.moneyFormat(this);"
	              						 onfocus="return numberformat.setCursorPosToEnd(this);"
	              						 maxlength="16" 
	              						 styleClass="inputTextRight"
	              						 disabled="#{semmsi004Bean.disabledModeView}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
										
										<rich:spacer width="5"></rich:spacer>
									
										<h:selectOneMenu  value="#{semmsi004tab1Bean.siteInfo.deckAreaUnitType}" 
			                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.areaUnitTypeList}"/>
										</h:selectOneMenu>
									</h:panelGroup>
									
								</td>
								<td style="text-align:left; white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['lable.th_wide']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.deckAreaWidth}" maxlength="10" 
									disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;"
										 styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_long']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.deckAreaLong}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.deckAreaOther}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
								</td>
							</tr>
							
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_buildingArea']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu id="ddlSiteBuildingAreaType" value="#{semmsi004tab1Bean.siteInfo.buildingAreaType}"
		                			 disabled="#{semmsi004Bean.disabledModeView}">
										<f:selectItems value="#{semmsi004tab1Bean.buildingAreaTypeList}"/>
									 </h:selectOneMenu>
									
									<rich:spacer width="5"></rich:spacer>
								
									<h:inputText id="txtSiteBuildingArea" value="#{semmsi004tab1Bean.siteInfo.buildingArea}" size="18"  
	              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	              						 onblur="return numberformat.moneyFormat(this);"
	              						 onfocus="return numberformat.setCursorPosToEnd(this);"
	              						 maxlength="16" 
	              						 styleClass="inputTextRight"
	              						 disabled="#{semmsi004Bean.disabledModeView}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
									
									<rich:spacer width="5"></rich:spacer>
								
									<h:selectOneMenu  value="#{semmsi004tab1Bean.siteInfo.buildingAreaUnitType}"
			                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.areaUnitTypeList}"/>
									</h:selectOneMenu>
								</td>
								<td style="width:10%; text-align:left; white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['lable.th_wide']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.buildingAreaWidth}" maxlength="10" 
									disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_long']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.buildingAreaLong}" maxlength="10" 
									disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.buildingAreaOther}" maxlength="10" 
									disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_roomNumber']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSiteRoomNo" value="#{semmsi004tab1Bean.siteInfo.siteRoomNo}" 
                			 		size="13" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['lable.th_roomArea']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu id="ddlRoomAreaType" value="#{semmsi004tab1Bean.siteInfo.roomAreaType}"
		                			disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.roomAreaTypeList}"/>
									</h:selectOneMenu>
									
									<rich:spacer width="5"></rich:spacer>
								
									<h:inputText id="txtSiteRoomArea" value="#{semmsi004tab1Bean.siteInfo.roomArea}" size="18"  
        						 	onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
        						 	onblur="return numberformat.moneyFormat(this);"
        						 	onfocus="return numberformat.setCursorPosToEnd(this);"
        						 	maxlength="16" 
        						 	styleClass="inputTextRight"
        						 	disabled="#{semmsi004Bean.disabledModeView}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                				</h:inputText>
	                				
									<rich:spacer width="5"></rich:spacer>
								
									<h:selectOneMenu  value="#{semmsi004tab1Bean.siteInfo.roomAreaUnitType}"
			                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.areaUnitTypeList}"/>
									</h:selectOneMenu>
								</td>
								<td style="width:10%; text-align:left; white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['lable.th_wide']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.roomAreaWidth}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
											
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_long']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.roomAreaLong}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
									</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.roomAreaOther}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
									</h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_landArea']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu id="ddlLandAreaType" value="#{semmsi004tab1Bean.siteInfo.landAreaType}"
		                			 disabled="#{semmsi004Bean.disabledModeView}">
										<f:selectItems value="#{semmsi004tab1Bean.landAreaTypeList}"/>
									 </h:selectOneMenu>
									
									<rich:spacer width="5"></rich:spacer>
								
									<h:inputText id="txtSiteLandArea" value="#{semmsi004tab1Bean.siteInfo.landArea}" size="18" 
	        						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	        						 onblur="return numberformat.moneyFormat(this);"
	        						 onfocus="return numberformat.setCursorPosToEnd(this);"
	        						 maxlength="16" 
	        						 styleClass="inputTextRight"
	        						 disabled="#{semmsi004Bean.disabledModeView}">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
									
									<rich:spacer width="5"></rich:spacer>
								
									<h:selectOneMenu id="ddlSiteLandAreaType" value="#{semmsi004tab1Bean.siteInfo.landAreaUnitType}"
			                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.areaUnitTypeList}"/>
										</h:selectOneMenu>
								</td>
								<td style="width:10%; text-align:left; white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['lable.th_wide']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.landAreaWidth}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_long']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.landAreaLong}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
										
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
								
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.landAreaOther}" maxlength="10" 
										disabled="#{semmsi004Bean.disabledModeView}"
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="ms7"
	              						onblur="return numberformat.moneyFormat(this);"
	              						onfocus="return numberformat.setCursorPosToEnd(this);">
										</h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['lable.th_placeType']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu id="ddlPlaceType" value="#{semmsi004tab1Bean.siteInfo.placeType}" 
		                			disabled="#{semmsi004Bean.disabledModeView}"> 
										<f:selectItems value="#{semmsi004tab1Bean.placeTypeList}"/>
									</h:selectOneMenu>
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText value="#{semmsi004tab1Bean.siteInfo.placeTypeOth}" style="width:300"
									disabled="#{semmsi004Bean.disabledModeView}"></h:inputText>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" rendered="false"/>
									<h:outputText value="#{jspMsg['lable.th_docType']} : " styleClass="ms7" rendered="false"/>
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu style="width:300" rendered="false">
										<f:selectItem itemLabel=" -- Select --"/>
									</h:selectOneMenu>
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['lable.th_other']} : " styleClass="ms7" rendered="false"/>
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;" >
									<h:inputText style="width:300" rendered="false"></h:inputText>
								</td>
							</tr>
							
							
							
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
									<h:outputText value="#{jspMsg['lable.th_address']} : " styleClass="ms7" />
								</td>
								<td style="" colspan="3">
									
									<h:inputTextarea id="txtSiteHouseNo" value="#{semmsi004tab1Bean.siteInfo.siteHouseNo}" 
                			 		cols="100" rows="8" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
							</tr>
							
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_buildingName']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSiteBuilding" value="#{semmsi004tab1Bean.siteInfo.siteBuilding}" 
                				 	size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}" style="width:400"/>
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSiteStreet" value="#{semmsi004tab1Bean.siteInfo.siteStreet}" 
                					size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSiteFloor" value="#{semmsi004tab1Bean.siteInfo.siteFloor}" 
                			 size="13" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSiteTambon" value="#{semmsi004tab1Bean.siteInfo.siteTambon}" 
                			size="30" maxlength="50" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:selectOneMenu id="ddlSiteAmphur" value="#{semmsi004tab1Bean.siteInfo.siteAmphurId}"
		                			 disabled="#{semmsi004Bean.disabledModeView}">
											<f:selectItems value="#{semmsi004tab1Bean.siteAmphurList}"/>
									 </h:selectOneMenu>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<a4j:region>
			                			 <h:selectOneMenu id="ddlSiteProvince" value="#{semmsi004tab1Bean.siteInfo.siteProvinceId}" onchange="GetSiteAmphurListJS();"
			                			 disabled="#{semmsi004Bean.disabledModeView}">
												<f:selectItems value="#{semmsi004Bean.provinceList}"/>
										 </h:selectOneMenu>
										 <a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlSiteAmphur" action="#{semmsi004tab1Action.getSiteAmphurList}"/>
									</a4j:region>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									
								</td>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;">
									<h:inputText id="txtSitePostcode" value="#{semmsi004tab1Bean.siteInfo.sitePostcode}"  
                					size="8" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
								</td>
							</tr>
							
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap; width:20%; text-align:left;" colspan="3">
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									value="Add"  rendered="false">
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									value="save" rendered="false">
									</a4j:commandButton>
									
									<rich:spacer width="5"></rich:spacer>
									
									<a4j:commandButton style="margin-left:5px;" styleClass="rich-button"
									oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
									value="cancel" rendered="false">
									</a4j:commandButton>
								</td>
								
							</tr>
						</table>
						
						
					</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
						<!-- address Doc -->
					<rich:panel id="pnlAddressDoc">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['label.th_addressDoc']}" />
						</f:facet>
						
						<h:panelGroup style="width:100%;">
							<a4j:commandButton value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_station_address']}" styleClass="rich-button">
							</a4j:commandButton>
							<table style="width:100%; border:solid ececec 1px; text-align:right;">
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['lable.th_address']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;" colspan="3">
										
										<h:inputTextarea id="txtRightHouseNo" value="#{semmsi004tab1Bean.siteInfo.rightHouseNo}"  styleClass="ms7" cols="100" rows="8">
										    
										</h:inputTextarea>
									</td>
								</tr>
								
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_buildingName']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightBuilding" value="#{semmsi004tab1Bean.siteInfo.rightBuilding}" style="width:400"></h:inputText>
									</td>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightStreet" value="#{semmsi004tab1Bean.siteInfo.rightStreet}"  style="width:200"></h:inputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightFloor" value="#{semmsi004tab1Bean.siteInfo.rightFloor}" style="width:200"></h:inputText>
									</td>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightTambon" value="#{semmsi004tab1Bean.siteInfo.rightTambon}" style="width:200"></h:inputText>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										
									</td>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightAmphur" value="#{semmsi004tab1Bean.siteInfo.rightAmphur}" size="30" 
										disabled="#{semmsi004Bean.disabledModeView}"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										
									</td>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightProvince" value="#{semmsi004tab1Bean.siteInfo.rightProvince}" 
							  size="30" disabled="#{semmsi004Bean.disabledModeView}"/>
									</td>
								</tr>
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										
									</td>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;">
										<h:inputText id="txtRightPostcode" value="#{semmsi004tab1Bean.siteInfo.rightPostcode}"  
                			size="8" maxlength="5" disabled="#{semmsi004Bean.disabledModeView}"/>
								</tr>
								
								<tr>
									<td style="width:10%; text-align:right; white-space:nowrap;">
										
									</td>
									<td style="white-space:nowrap; width:20%; text-align:left;" colspan="3">
										<a4j:commandButton style="margin-left:5px;" styleClass="rich-button" value="Add" rendered="false">
										</a4j:commandButton>
										
										<rich:spacer width="5"></rich:spacer>
										
										<a4j:commandButton style="margin-left:5px;" styleClass="rich-button" value="save" rendered="false" >
										</a4j:commandButton>
										
										<rich:spacer width="5"></rich:spacer>
										
										<a4j:commandButton style="margin-left:5px;" styleClass="rich-button" value="cancel" rendered="false" >
										</a4j:commandButton>
									</td>
									
								</tr>
							</table>
						</h:panelGroup>
					</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
						<!-- Rental Service -->
					<rich:panel id="pnlSiteInfo4">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.rentAndService']}"/>
						</f:facet>
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
	                		<tr>
							<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentAddAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="33%">
                			 <h:inputText id="txtRentAddAmt" value="#{semmsi004Bean.siteRent.totalRentAddAmt}" 
        						 styleClass="ms10Black"
        						 size="18"
        						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
              				<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				 <h:selectOneMenu id="ddlTotalRentAddPeriodTypeTab1" value="#{semmsi004Bean.siteRent.totalRentAddPeriodType}"
	               				disabled="true"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.serviceAddAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtServiceAddAmt" value="#{semmsi004Bean.siteRent.totalServiceAddAmt}" 
        						 maxlength="16" 
        						 styleClass="ms10Black"
        						 size="18"
        						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalServiceAddPeriodTypeTab1" value="#{semmsi004Bean.siteRent.totalServiceAddPeriodType}"
	               				disabled="true"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="33%">
                			 <h:inputText id="txtRentAmt" value="#{semmsi004Bean.siteRent.totalRentAmt}" 
        						 maxlength="16" 
        						 styleClass="ms12Blue"
        						 size="13"
        						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalRentPeriodTypeTab1" value="#{semmsi004Bean.siteRent.totalRentPeriodType}"
	               				disabled="true" > 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}" />
							</h:selectOneMenu>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.serviceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtServiceAmt" value="#{semmsi004Bean.siteRent.totalServiceAmt}" 
       						 maxlength="16" 
       						 styleClass="ms12Blue"
       						 size="13"
       						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				 <h:selectOneMenu id="ddlTotalServicePeriodTypeTab1" value="#{semmsi004Bean.siteRent.totalServicePeriodType}"
	               				disabled="true"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		
	                		<tr>
	                		<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentServiceAmt']}" styleClass="ms7BlueBold"/>
                			</td>
                			<td width="85%" colspan="3">
                			 <h:inputText id="txtRentServiceAmt" value="#{semmsi004Bean.siteRent.totalRentServiceAmt}" 
       						 maxlength="16" 
       						 styleClass="ms14Magenta"
       						 size="11"
       						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				 <h:selectOneMenu id="ddlTotalRentServicePeriodTypeTab1" value="#{semmsi004Bean.siteRent.totalRentServicePeriodType}"
	               				disabled="true"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.totalAgeRentAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			  <h:inputText id="txtTotalAgeRentAmt" value="#{semmsi004Bean.siteRent.totalAgeRentAmt}" 
        						 maxlength="16" 
        						 styleClass="ms10Black"
        						 size="18"
        						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.totalAgeServiceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			  <h:inputText id="txtTotalAgeServiceAmt" value="#{semmsi004Bean.siteRent.totalAgeServiceAmt}" 
       						 maxlength="16" 
       						 styleClass="ms10Black"
       						 size="18"
       						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
                			</td>                			
		                	<td align="right" colspan="2" width="53%">
							<h:outputText value="#{jspMsg['label.totalAgeDonateAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			  <h:inputText id="txtTotalAgeDonateAmt" value="#{semmsi004Bean.siteRent.totalAgeDonateAmt}" 
       						 maxlength="16" 
       						 styleClass="ms10Black"
       						 size="18"
       						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.totalAgeRentServiceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			<h:inputText id="txtTotalAgeRentServiceAmtTab1" value="#{semmsi004Bean.siteRent.totalAgeRentServiceAmt}" 
	   						 maxlength="16" 
	   						 styleClass="ms10Black"
	   						 size="18"
	   						 readonly="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		<tr>
	                		<td align="right" width="15%">
                			</td>
                			<td>
	                			<h:selectBooleanCheckbox id="chkNoRentTab1" value="#{semmsi004Bean.chkNoRent}" styleClass="ms7"
								disabled="true" />
			                	<h:outputText value="#{jspMsg['label.noRent']}" styleClass="ms7" />
                			</td>
                			<td align="left">
                				<h:outputText value="Fix" styleClass="ms7" rendered="false"/>
				                	
				                	<rich:spacer width="5"></rich:spacer>
								<h:selectOneMenu id="ddFix5Percent_tab1" value="#{semmsi004Bean.siteRent.fix5Percent}" styleClass="ms7" 
			              			disabled="true" rendered="false">
				                		<f:selectItems value="#{semmsi004tab3Bean.fix5PercentList}"/>
				                	</h:selectOneMenu>
			                	<rich:spacer width="5"></rich:spacer>
				                	
				                	<h:outputText value="%" styleClass="ms7" rendered="false"/>
                			</td>
                			<td>
                			
                			</td>
	                		</tr>
							</table>
						</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
						<!-- Rental Service Deposit -->
					<rich:panel id="pnlRentalServDep">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['label.rentalserviceDep']}" />
						</f:facet>
						
						<table style="width:95%; border:solid 0px;">
					    	<tr>
					       		<td align="right" style="width:20%;">
					       			<h:outputText value="#{jspMsg['label.totalbg']}" styleClass="ms7"></h:outputText>
					       		</td>
					       		<td align="left">
					       			<h:inputText id="txtDepositBgAmt" value="#{semmsi004Bean.siteRent.totalDepositBgAmt}" 
		       						 maxlength="16" 
		       						 styleClass="ms10Black"
		       						 size="18"
		       						 readonly="true">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
					       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
					       		</td>
					       		<td align="right" style="width:20%;">
					       			<h:outputText value="#{jspMsg['label.totalcash']}" styleClass="ms7"></h:outputText>
					       		</td>
					       		<td align="left">
					       			<h:inputText id="txtDepositCashAmt" value="#{semmsi004Bean.siteRent.totalDepositCashAmt}" 
		       						 maxlength="16" 
		       						 styleClass="ms10Black"
		       						 size="18"
		       						 readonly="true">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
					       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
					       		</td>
					       	</tr>
					       	<tr>
					       		<td align="right">
					       			
					       		</td>
					       		<td align="left">
					       			<h:selectBooleanCheckbox id="chkNoDepositTab1" value="#{semmsi004Bean.chkNoDeposit}" styleClass="ms7"
									disabled="true" />
								           
								    <h:outputText value="#{jspMsg['label.nodeposit']}" styleClass="ms7"></h:outputText>
					       		</td>
					       		<td align="right">
					       		</td>
					       		<td align="left">
					       		
					       		</td>
					       	</tr>
					    </table>
					</rich:panel>
				</a4j:region>
				
				<!-- panel property tax -->
				<rich:spacer height="10"></rich:spacer>
				<rich:panel id="pnlSiteInfo6">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.propertyTax']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
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
										<td align="left" colspan="5">
											
											<h:inputTextarea id="msi004tab1_optPtremark" value="#{semmsi004tab4Bean.siteAppPTObj.ptRemark}"
											style="width:800px;" disabled="true" rows="5"></h:inputTextarea>
										</td>
										
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>

				<!-- panel electric -->
				<rich:spacer height="10"></rich:spacer>
				<a4j:region id="rgnSiteInfoElectric">
					<rich:panel >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_electricInfoList']} (#{jspMsg['label.th.datafromsiteacq']})" style="width: 100%;"/>
						</f:facet>
							
						<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
								
							<rich:dataTable id="dtbElContInfo" cellpadding="1" cellspacing="0" border="0"
	                        var="obj" value="#{semmsi004tab5Bean.siteInfoELCondAllList}" reRender="dtbSiteInfo,dtbElContInfo" 
	                        rows="#{semmsi004tab5Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable" >
	                            
		                    	<rich:column sortBy="#{obj.dataObj.status}" width="2%">
	                                <f:facet name="header">
	                                    <h:outputText value="Status" styleClass="contentform" style="width: 40"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.status}" styleClass="contentform"  />
	                                </div>
	                      		</rich:column>
	                            
	                            <rich:column sortBy="#{obj.dataObj.effectiveDt}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.effectiveDtStr}" styleClass="contentform"  >
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column  sortBy="#{obj.dataObj.expireDt}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.expireDtStr}" styleClass="contentform"  >
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column sortBy="#{obj.dataObj.chgEffectiveDt}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.chgEffectiveDtStr}" styleClass="contentform"  >
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column sortBy="#{obj.dataObj.periodStartDt}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.periodStartDtStr}" styleClass="contentform"  >
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column sortBy="#{obj.dataObj.periodEndDt}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.periodEndDtStr}" styleClass="contentform">
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column  sortBy="#{obj.dataObj.electricTypeName}">
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.electricType']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.electricTypeName}" styleClass="contentform"  />
	                                </div>
	                      		</rich:column>
	                      		<rich:column>
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.sitecontractNo']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.contractNo}" styleClass="contentform"  />
	                                </div>
	                      		</rich:column>
	                      		
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.calElectric']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricCondSubtypeName}" />
	                                </div>
	                      		</rich:column>
	                      		
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="right">
	                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricAmt}" >
	                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                                    </h:outputText>
	                                </div>
	                      		</rich:column>
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['lable.th_service']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText value="#{obj.dataObj.serviceName}" styleClass="contentform"  />
	                                </div>
	                      		</rich:column>
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricPeriodTypeName}" />
	                                </div>
	                      		</rich:column>
	                      			
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="Detail" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.detail}"/>
	                                </div>
	                      		</rich:column>
	                      		
	                      		<rich:column>
	                                <f:facet name="header">
	                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.elVatTypeName}" />
	                                </div>
	                      		</rich:column>
	                      		<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.pay']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.payPeriodTypeName}"/>
	                                </div>
	                      		</rich:column>
	                      		
	                      		<f:facet name="footer">
	                                <rich:columnGroup>
	                                    <rich:column colspan="4">
	                                        <h:outputFormat value="#{msg['message.totalRecords']}">
	                                        	<f:param value="#{fn:length(semmsi004tab5Bean.siteInfoELCondAllList)}"></f:param>
	                                        </h:outputFormat>
	                                    </rich:column>
	                                    <rich:column colspan="11">
	                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
	                                            maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
	                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
	                                            id="dstSiteElDetailInfo" 
	                                            style="background-color: #cccccc;"
	                                            page="#{semmsa001Bean.scrollerPage}" />
	                                    </rich:column>
	                                </rich:columnGroup>
	                            </f:facet>
	                            
	                   		</rich:dataTable>
								
						</h:panelGroup>
					</rich:panel>
				</a4j:region>
				<rich:spacer height="10"></rich:spacer>
					<h:panelGrid  width="100%" border="0" cellpadding="0" cellspacing="1">
					<table id="tblSave" align="right">
					<tr>
	           		<td align="right">
	           		<a4j:commandButton id="btnSaveTab1" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError" 
	           		oncomplete="onTopPage()"  
	           		rendered="#{semmsi004Bean.renderBtnSave}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
					<a4j:actionparam name="methodWithNavi" value="doUpdateTab" />
	           		</a4j:commandButton>
	           		</td>
	           		</tr>
	           		</table>
					</h:panelGrid>
				</h:panelGrid>
					
		</h:panelGrid>
		
