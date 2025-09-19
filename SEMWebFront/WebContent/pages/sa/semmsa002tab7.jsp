
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<script type="text/javascript">
		jQuery(function($){
			var text_remarkDocuments = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkDocuments');
			var text_remarkContract = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkContract');
			var text_remarkAqm = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkAqm');
			var text_remarkRisk = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkRisk');
			var text_remarkLegal = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkLegal');
			var text_remarkOther = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkOther');
			var text_remarkAfterApprove = $('#incContent\\:frmAllInitTab\\:incTab5\\:remarkAfterApprove');

			text_remarkDocuments.bind("keypress", function(e) {
				var lines = text_remarkDocuments.val().split("\n");
				if(lines.length > 2){ return false; } 
			});

			text_remarkContract.bind("keypress", function(e) {
				var lines = text_remarkContract.val().split("\n");
				if(lines.length > 2){ return false; } 
			});

			text_remarkAqm.bind("keypress", function(e) {
				var lines = text_remarkAqm.val().split("\n");
				if(lines.length > 2){ return false; } 
			});

			text_remarkRisk.bind("keypress", function(e) {
				var lines = text_remarkRisk.val().split("\n");
				if(lines.length > 4){ return false; } 
			});

			text_remarkLegal.bind("keypress", function(e) {
				var lines = text_remarkLegal.val().split("\n");
				if(lines.length > 4){ return false; } 
			});

			text_remarkOther.bind("keypress", function(e) {
				var lines = text_remarkOther.val().split("\n");
				if(lines.length > 4){ return false; } 
			});

			text_remarkAfterApprove.bind("keypress", function(e) {
				var lines = text_remarkAfterApprove.val().split("\n");
				if(lines.length > 15){ return false; } 
			});


			/* uncomplete must be fix using SSO */
			if(true) {
				text_remarkLegal.attr('disabled', true);
			} else {
				text_remarkLegal.attr('disabled', false);
			}
			
		});
	</script>

	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab7" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_doc_and_agree']}" />
			</f:facet>
			<!-- << header content -->

				<!-- >> group 1 -->
				<rich:panel rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
				<h:panelGroup style="width:100%;"> 
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractNo}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.contract_status']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractStatus}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.pnextcont']} : " styleClass="ms7" ></h:outputText>
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.pNextContract}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_firstStartContractDate']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar  locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.firstEffDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.effDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.expireDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
                            	<rich:spacer width="20"></rich:spacer>
                            	<h:selectBooleanCheckbox label="#{jspMsg['label.th_contractNeverExpireDt']}" 
								value="#{semmsa002Bean.noExpFlag}" disabled="true"></h:selectBooleanCheckbox>
								<h:outputText value="#{jspMsg['label.th_contractNeverExpireDt']}" styleClass="ms7" />
							</td>
							
						</tr>
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.locationId']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.locationId}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['column.header.locationName']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText style="width:300px;" disabled="true" value="#{semmsa002Bean.siteContInfo.locationThName}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.status}"></h:inputText>
							</td>
						</tr>
					</table>
				</h:panelGroup>				
				</rich:panel>
				<!-- >> group 1 -->
				
				<div style="clear:both; height:5px;"></div>
				<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.docList']}  (Existing)" style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbPTHist" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppdocExtList}" reRender="dtbPTHist" 
				                        rows="5" rowClasses="cur" styleClass="dataTable">
				                            
				                            
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.contractNo}" />
				                                </div>
				                      		</rich:column>
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.effectiveDtStr}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocEffectiveDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.rentalPlaceType']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalPlaceType}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.ownerType']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalPartiesType}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.doclist']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.legalDocType}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.docOthlist']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocTypeOth}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.legalDocHaveOrNot']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocHaveOrNot}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.updateBy}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.createby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.createBy}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppdocExtList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                    <rich:column colspan="11">
				                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbPTHist"
				                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
				                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
				                                            id="dstRentalServOtherinfo" 
				                                            style="background-color: #cccccc;"
				                                            page="#{semmsa002Bean.scrollerPage}" 
				                                        />
				                                    </rich:column>
				                                </rich:columnGroup>
				                            </f:facet>
				                            
				                   		</rich:dataTable>
									
									</h:panelGroup>
								</rich:panel>
								
								<div style="clear:both; height:10px;"></div>
				
				<h:panelGroup>
					
					<div style="width:100%; border:solid 1px fff;padding:5px;">
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"></h:outputText>
											
											<rich:calendar locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" 
												value="#{semmsa002Bean.siteAppObjParam.legalDocEffectiveDt}"
												showWeeksBar="false"
												inputSize="10"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												cellWidth="15px" cellHeight="20px"
												label=""
												styleClass="ms7"
												rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"
												disabled="#{semmsa002Bean.disabledModeViewOnly }">
											</rich:calendar>
										</h:panelGroup>
										
									</div>
						
						<rich:spacer height="10"></rich:spacer>			
					
	                	<div>
	                		
	                		<a4j:commandButton id="msa002tab7_BtnUndoContractDoc" value="#{jspMsg['label.th_undo']}#{jspMsg['label.changedoclist']}" 
							disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab7_changeContractDocComfirm();"
							styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:180px;">
							</a4j:commandButton>
	                		
	                		<a4j:jsFunction name="fnMsa002tab7_changeContractDocComfirm"
	                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsa002Action.doSetParamConfirmNotChangeContDoc}"
	                		reRender="panelTab7,msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
	                		
	                		<a4j:jsFunction name="reRenderTab7" reRender="oppContent"></a4j:jsFunction>
	                	</div>
	            </h:panelGroup>
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 3 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<table style="width:100%;">
							<tr>
								<td style="border:solid ececec 1px; white-space:nowrap; vertical-align:top;">
									<h:panelGrid style="width:100%;" columns="2" columnClasses="leftColumn, rightColumn">
										<!-- panel left -->
										<h:panelGroup id="msa002tab5_left" style="width:370px; height:100%; white-space:nowrap; padding:10px 0 0 50px;">
			                                 <!-- dropdown 1 [legal place type] -->
			                                 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			                                     <tr>
			                                         <td width="40%" valign="top" align="right">
			                                              <h:outputText value="#{jspMsg['label.th_placeType']} : " style="" styleClass="ms7" />
			                                         </td>
			                                     	<td width="60%" align="left">
			                                     		
														<h:selectOneMenu id="msa002tab5_placeType" value="#{semmsa002Bean.siteAppObjParam.placeType}" styleClass="ms7"
														onchange="func_sendPlaceType();" style="width:120px;" 
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
															<f:selectItems value="#{semmsa002Bean.legalPlaceTypeList}"/>
														</h:selectOneMenu>
														<a4j:jsFunction name="func_sendPlaceType" action="#{semmsa002Action.doGetLegalDoc}" reRender="msa002tab5_left,msa002tab5_right">
														</a4j:jsFunction>
                                                                   
			                                         </td>
			                                     </tr>
			                                     <tr>
			                                         <td colspan="2">
			                                             <div style="clear:both; height:2px;"></div>
                                                        	<h:inputTextarea id="txtPlaceTypeRemark" value="#{semmsa002Bean.siteAppObjParam.placeTypeRemark}" style="width:300px;" 
                                                        	cols="20" rows="3" 
                                                        	disabled="#{semmsa002Bean.disabledModeViewOnly }"
                                                        	rendered="#{semmsa002Bean.siteAppObjParam.placeType == '99'}"/>
                                                         <div style="clear:both; height:2px;"></div>
			                                         </td>
			                                     </tr>
			                                     <tr>
                                                     <td valign="top" align="right">
                                                         <h:outputText value="#{jspMsg['label.th_partiesType']} : " style="padding-left:9px;" styleClass="ms7" />
                                                     </td>
                                                     <td align="left">
                                                          
														<h:selectOneMenu id="msa002tab5_partiesType" value="#{semmsa002Bean.siteAppObjParam.partiesType}" styleClass="ms7"
														onchange="func_sendPartiesType();" style="width:120px;" 
														disabled="#{semmsa002Bean.disabledModeViewOnly }">
															<f:selectItems value="#{semmsa002Bean.legalPartiesTypeList}"/>
														</h:selectOneMenu>
														<a4j:jsFunction name="func_sendPartiesType" action="#{semmsa002Action.doGetLegalDoc}" 
														reRender="msa002tab5_left,msa002tab5_right,msa002tab5_ddlLegalVatType,msa002tab5_txtLegalVatType">
														</a4j:jsFunction>
		                                                        
                                                     </td>
                                                  </tr>
                                                  <tr>
                                                      <td colspan="2">
                                                          <div style="clear:both; height:2px;"></div>
                                                          <table>
	                                                          <tr>
			                                                     <td valign="top" align="right" width="120">
			                                                         <h:outputText id="msa002tab5_txtLegalVatType" value="#{jspMsg['label.th_vatLabel']} : " style="padding-left:9px;" styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.partiesType == '02'}"/>
			                                                     </td>
			                                                     <td align="left">
			                                                        <h:selectOneMenu id="msa002tab5_ddlLegalVatType" value="#{semmsa002Bean.siteAppObjParam.legalVatType}" styleClass="ms7"
																	  style="width:120px;"
																	  disabled="#{semmsa002Bean.disabledModeViewOnly }"
																	  rendered="#{semmsa002Bean.siteAppObjParam.partiesType == '02'}">
																			<f:selectItem itemLabel="-- select --" itemValue=""/>
																			<f:selectItem itemLabel="#{jspMsg['label.th_haveVat']}" itemValue="01"/>
																			<f:selectItem itemLabel="#{jspMsg['label.th_noHaveVat']}" itemValue="02"/>
																	</h:selectOneMenu>																			                                                        
			                                                     </td>
			                                                  </tr>
                                                          </table>
                                                          
                                                          <h:inputTextarea id="txtPartiesTypeRemark" value="#{semmsa002Bean.siteAppObjParam.partiesTypeRemark}" 
                                                          style="width:300px;" cols="20" rows="3" rendered="#{semmsa002Bean.siteAppObjParam.partiesType == '99'}"/>
                                                      </td>
                                                   </tr>
			                                 </table>
			                          </h:panelGroup>
			                                        
			                          <!-- panel right -->
			                          <h:panelGroup id="msa002tab5_right" style="width:auto; height:100%; vertical-align:top;">
			                              <a4j:outputPanel id="msa002tab5_right_table" >
			                              
			                              <h:outputText value="#{jspMsg['label.doclist']} #{jspMsg['label.nondoclist']}" styleClass="ms7" style="text-decoration:underline;" />              
			                              
			                              	<rich:dataTable width="750px;" id="right_table" cellpadding="0" cellspacing="0" border="0"
                                            	var="item_" value="#{semmsa002Bean.legalDocList}" reRender="dstLegalApproveSrchByAppv" 
                                                styleClass="" rowClasses="" style="background:none;border-style:none;"> 
                                                            
                                                            <rich:column id="itemNumber" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
                                                                <div align="center">
                                                                    <h:inputHidden  value="#{item_.dataObj.itemCode}" />
                                                                    <h:outputText value="#{item_.dataObj.itemNumber}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:column id="itemDesc" style="background:none;border-style:none;" width="400px;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
                                                                <div align="left">
                                                                    <h:outputText value="#{item_.dataObj.itemDesc}" style="" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:column id="chkHaveFlag" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
                                                                <div align="center" style="background:none;border-style:none;">
                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkHaveFlag" value="#{item_.dataObj.chkHaveFlag}" 
                                                                    disabled="#{semmsa002Bean.disabledModeViewOnly}">
                                                                        <a4j:support event="onclick" action="#{semmsa002Action.doChangeChkBoxLegalDoc}" reRender="msa002tab5_right_table">
                                                                              <f:param name="paramChkStts" value="Y"></f:param>
                                                                              <f:param name="paramItemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                              <f:param name="paramItemType" value="M"></f:param>
                                                                         </a4j:support>
                                                                    </h:selectBooleanCheckbox>
                                                                    <h:outputText value="#{jspMsg['label.th_have']}" style="padding-right:10px;" styleClass="ms7" />
                                                                    
                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkNotHaveFlag" value="#{item_.dataObj.chkNotHaveFlag}"
                                                                    disabled="#{semmsa002Bean.disabledModeViewOnly }">
                                                                        <a4j:support event="onclick" action="#{semmsa002Action.doChangeChkBoxLegalDoc}" reRender="msa002tab5_right_table">
                                                                              <f:param name="paramChkStts" value="N"></f:param>
                                                                              <f:param name="paramItemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                              <f:param name="paramItemType" value="M"></f:param>
                                                                         </a4j:support>
                                                                    </h:selectBooleanCheckbox>
                                                                    <h:outputText value="#{jspMsg['label.th_notHave']}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            
                                                           
												<rich:columnGroup rendered="#{item_.dataObj.licenseDocument eq'Y'}">
	                                            	<rich:column colspan="4" style="border:0px;">
			                                        	<div style="background:none;border-style:none;">
			                                                <h:outputText value="#{jspMsg['label.th_specify']}.." rendered="false"
			                                                style="padding:0 5 0 40px;" styleClass="ms7" />
			                                                            
			                                                <h:inputTextarea id="txtTypeRemark" value="#{item_.dataObj.itemRemark}" styleClass="ms7" 
			                                                style="width:620px;" cols="20" rows="3" rendered="false"
			                                            	disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
			                                        	</div>
			                                    	</rich:column>
			                                	</rich:columnGroup>
                                                        
                                            </rich:dataTable>
			                                            
			                                            </a4j:outputPanel>
			                                            
			                                            <a4j:outputPanel id="msa002tab5_right_oth_table" >
			                              					<h:outputText value="#{jspMsg['label.docOthlist']}" styleClass="ms7" style="text-decoration:underline;" />              
							                              	<rich:dataTable width="750px;" id="right_oth_table" cellpadding="0" cellspacing="0" border="0"
				                                                        var="item_" value="#{semmsa002Bean.legalDocList}" reRender="dstLegalApproveSrchByAppv" 
				                                                         styleClass="" rowClasses="" style="background:none;border-style:none;"> 
				                                                            
				                                                            <rich:column id="itemOthNumber" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
				                                                                <div align="center">
				                                                                    <h:inputHidden  value="#{item_.dataObj.itemCode}" />
				                                                                    <h:outputText value="#{item_.dataObj.itemNumber}" styleClass="ms7" />
				                                                                </div>
				                                                            </rich:column>
				                                                            <rich:column id="itemOthDesc" style="background:none;border-style:none;" width="400px;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
				                                                                <div align="left">
				                                                                    <h:outputText value="#{item_.dataObj.itemDesc}" style="" styleClass="ms7" />
				                                                                </div>
				                                                            </rich:column>
				                                                            <rich:column id="chkOthHaveFlag" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
				                                                                <div align="center" style="background:none;border-style:none;">
				                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkOthHaveFlag" value="#{item_.dataObj.chkHaveFlag}" 
				                                                                    disabled="#{semmsa002Bean.disabledModeViewOnly }">
				                                                                        <a4j:support event="onclick" action="#{semmsa002Action.doChangeChkBoxLegalDoc}" reRender="msa002tab5_right_oth_table">
				                                                                              <f:param name="paramChkStts" value="Y"></f:param>
				                                                                              <f:param name="paramItemCode" value="#{item_.dataObj.itemCode}"></f:param>
				                                                                              <f:param name="paramItemType" value="S"></f:param>
				                                                                         </a4j:support>
				                                                                    </h:selectBooleanCheckbox>
				                                                                    <h:outputText value="#{jspMsg['label.th_have']}" style="padding-right:10px;" styleClass="ms7" />
				                                                                    
				                                                                    <h:selectBooleanCheckbox id="msa002tab5_chkOthNotHaveFlag" value="#{item_.dataObj.chkNotHaveFlag}"
				                                                                    disabled="#{semmsa002Bean.disabledModeViewOnly}">
				                                                                        <a4j:support event="onclick" action="#{semmsa002Action.doChangeChkBoxLegalDoc}" reRender="msa002tab5_right_oth_table">
				                                                                              <f:param name="paramChkStts" value="N"></f:param>
				                                                                              <f:param name="paramItemCode" value="#{item_.dataObj.itemCode}"></f:param>
				                                                                              <f:param name="paramItemType" value="S"></f:param>
				                                                                         </a4j:support>
				                                                                    </h:selectBooleanCheckbox>
				                                                                    <h:outputText value="#{jspMsg['label.th_notHave']}" styleClass="ms7" />
				                                                                </div>
				                                                            </rich:column>
				                                                            
																			<rich:columnGroup rendered="#{item_.dataObj.licenseDocument != 'Y'}">
					                                                        	<rich:column colspan="4" style="border:0px;">
							                                                        <div style="background:none;border-style:none;">
							                                                            <h:outputText value="#{jspMsg['label.th_specify']}.." rendered="#{item_.dataObj.itemDispRemark == 'Y'}"
							                                                            style="padding:0 5 0 40px;" styleClass="ms7" />
							                                                            
							                                                            <h:inputTextarea id="txtOthTypeRemark" value="#{item_.dataObj.itemRemark}" styleClass="ms7" 
							                                                            style="width:60%" cols="10" rows="3" rendered="#{item_.dataObj.itemDispRemark == 'Y'}"
							                                                            disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
							                                                        </div>
							                                                    </rich:column>
							                                                </rich:columnGroup>
				                                                        
				                                            </rich:dataTable>
			                                            
			                                            </a4j:outputPanel>
			                                        </h:panelGroup>
									</h:panelGrid>
								</td>
							</tr>
							
							
							<tr>
								<td style="white-space:nowrap; vertical-align:top; border:solid ececec 1px;" colspan="2">
									<table style="width:100%;">
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark01']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkDocuments}" id="remarkDocuments" 
												rows="7" cols="50" style="width:900px;height:70px; " styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark02']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkContract}" id="remarkContract"
												rows="7" cols="50" style="width:900px;height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark03']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkAqm}" id="remarkAqm"
												rows="7" cols="50" style="width:900px; height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark04']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkRisk}" id="remarkRisk"
												rows="7" cols="50" style="width:900px;height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark05']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkLegal}" id="remarkLegal"
												rows="7" cols="50" style="width:900px;height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_other']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkOther}" id="remarkOther"
												rows="7" cols="50" style="width:900px;height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td>
												<h:outputText value="#{jspMsg['label.th_contDoc_remark06']}" styleClass="ms7" rendered="true"/>
											</td>
										</tr>
										<tr>
											<td style="white-space:nowrap;">
												<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkAfterApprove}" id="remarkAfterApprove"
												rows="7" cols="50" style="width:900px;height:70px;" styleClass="ms7"
												disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="true">
												</h:inputTextarea>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				<div style="clear:both; height:10px;"></div>
			           			
				<div style="clear:both; height:10px;"></div>
				
				<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.docHist']} " style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbDocHist" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppdocHistList}" reRender="dtbDocHist" 
				                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				                            
				                            
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.contractNo}" />
				                                </div>
				                      		</rich:column>
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.effectiveDtStr}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocEffectiveDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.rentalPlaceType']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalPlaceType}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.ownerType']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalPartiesType}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.doclist']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.legalDocType}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.docOthlist']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocTypeOth}"   />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.legalDocHaveOrNot']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.legalDocHaveOrNot}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.updateBy}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.createby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.createBy}"   />
				                                </div>
				                      		</rich:column>
				                      		
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppdocHistList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                    <rich:column colspan="11">
				                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbDocHist"
				                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
				                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
				                                            id="dstRentalServOtherinfo" 
				                                            style="background-color: #cccccc;"
				                                            page="#{semmsa002Bean.scrollerPage}" 
				                                        />
				                                    </rich:column>
				                                </rich:columnGroup>
				                            </f:facet>
				                            
				                   		</rich:dataTable>
									
									</h:panelGroup>
								</rich:panel>
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
