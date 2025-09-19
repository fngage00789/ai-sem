<!-- css3-mediaqueries.js for IE less than 9 -->
<!--[if lt IE 9]>
<script src="//css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

	<f:loadBundle basename="resources.gm.semmct009" var="jspMsg" />
	<!-- >> wrapper panel -->
	<h:panelGrid style="width:100%;">
	
		<!-- >> content panel -->
		<rich:panel style="width:100%;">
			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.header.semmct009-1']}" />
			</f:facet>
			<!-- << header content -->

				<!-- >> error msg content -->
				<a4j:form id="frmError">
					<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct009Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
	                       	<h:outputText value="Entered Data Status:"></h:outputText>
	                   	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
		            </rich:messages>
	            </a4j:form>
	            <!-- << error msg content -->
	            
	            <!-- >> content 1 (search criteria) -->
	            <a4j:form id="frmSearchCriteria">
					<rich:panel id="panel_searchCriteria" style="width:100%;">
					
						<!-- >> header content 1 -->
						<f:facet name="header">
							<h:panelGroup>
								<h:outputText style="" value="#{jspMsg['label.header.searchCriteria']}" />
							</h:panelGroup>
						</f:facet>
						<!-- >> header content 1 -->
					
						<center>	
						<h:panelGrid id="panel_searchCriteria_body" style="width:95%;">
							<h:panelGroup>
								<table style="width:80%;" align="center">
					                <tr>
					                	<td align="right" style="width:20%;">
					                		<h:outputText value="#{jspMsg['label.bankCode']} :" styleClass="ms7" />
					                	</td>
					                	<td style="width:10%;">
					                		<h:selectOneMenu id="txt_bankCode" value="#{semmct009Bean.bankSearchSelected}" converter="bankMasterSPConverter">
				                				<f:selectItems value="#{semmct009Bean.bankSelectionSearchList}"/>
		                                    </h:selectOneMenu>
		                                    
						                </td>
					                	<td align="right" style="width:20%;">
					                	</td>
					                	<td style="width:50%;">
					                	</td>
				                	</tr>
				                	
				                	<tr>
					                	<td align="right" style="width:20%;">
					                		<h:outputText value="#{jspMsg['label.bankBranchCode']} :" styleClass="ms7" />
					                	</td>
					                	<td style="width:10%;">
					                		<h:inputText id="txt_bankBranchCode" value="#{semmct009Bean.criteriaBankMasterSP.bankBranchCode}" maxlength="5" style="width:100%;"></h:inputText>
						                </td>
					                	<td align="right" style="width:20%;">
					                		<h:outputText value="#{jspMsg['label.bankBranchName']} :" styleClass="ms7" />
					                	</td>
					                	<td style="width:50%;">
					                		<h:inputText id="txt_bankBranchName" value="#{semmct009Bean.criteriaBankMasterSP.bankBranch}" maxlength="300" style="width:75%;"></h:inputText>
					                	</td>
				                	</tr>
				                </table>
							</h:panelGroup>
						
							<h:panelGroup style="float:left;">
								<!-- >> event button panel -->
								<h:panelGrid columns="2" id="grdSearchCommand">
									<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button"
									 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT009" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
										<a4j:actionparam name="mode" value="SEARCH" />
									</a4j:commandButton>
									
						           	<a4j:commandButton type="reset" id="btnClear" value="Clear" styleClass="rich-button"  
						           	 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult,   txt_bankCode, txt_bankName, txt_bankBranchCode, txt_bankBranchName">
						           		<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT009" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
										<a4j:actionparam name="methodWithNavi" value="doClear" />
						           	</a4j:commandButton>
						       	</h:panelGrid>
					       		<!-- << event button panel -->
				       		</h:panelGroup>
						
						</h:panelGrid>
						</center>
					</rich:panel>
					
					<div style="clear:both; height:0px;"></div>
					
					<!-- >> button NEW -->
					<h:panelGroup style="float:left;">
						<h:panelGrid columns="1" id="grdBtnNew">
							<a4j:commandButton id="btnNew" value="New" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, panel_popupNewOrUpdateBankMaster" 
							 oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false; ">
							 	<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT009" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
								<a4j:actionparam name="methodWithNavi" value="doInitNewOrUpdate" />
								<a4j:actionparam name="mode" value="NEW" />
							</a4j:commandButton>
						</h:panelGrid>
					</h:panelGroup>
					<!-- << button NEW -->
					
				</a4j:form>
				<!-- << content 1 (search criteria) -->
				
				<div style="clear:both;"></div>
				
				<!-- >> content 2 -->
				<rich:panel id="pnlSearchResult" style="width:100%;">
					<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.header.searchResult']}" />
					</f:facet>
					<!-- >> header content 2 -->
					
					<!-- >> table result -->
					<center>
					<div id="tabResult" style="width:100%; overflow:auto; position:relative;"> 
						<a4j:form id="frmSearchResult">
							<rich:dataTable style="width:100%; border-top:1px solid;" id="dTabBankMasterSrch" cellpadding="0" cellspacing="0" border="0"
										var="bankItemLst" value="#{semmct009Bean.bankMasterList}" reRender="dstBankMaster" 
										rows="#{semmct009Bean.rowPerPage}"
										onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
										onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
										rowClasses="cur" styleClass="contentform">
								
								<!-- >> column -->
								<rich:column rendered="false" style="width:20px; height:40px;" styleClass="tableFirstCol, #{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}">
									<f:facet name="header">
										<h:selectBooleanCheckbox style="" value="#{semmct009Bean.chkSelAll}">
											<a4j:support event="onclick" action="#{semmct009Action.selectAllRow}" reRender="dTabBankMasterSrch"/>
										</h:selectBooleanCheckbox>
									</f:facet>
									<div align="center">
									<h:selectBooleanCheckbox id="chkSelect" value="#{bankItemLst.checkBox}">
										<a4j:support event="onclick" reRender="dTabBankMasterSrch">
											<a4j:actionparam name="rowId" value="#{bankItemLst.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
									</div>	
								</rich:column>
								
								<rich:column width="20" styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}">
									<f:facet name="header">
										<h:outputText value="Edit" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<a4j:commandButton id="btnEdit" action="#{navAction.navi}" image="images/edit.png" style="height:15px; width:15px;" 
										reRender="oppContent" oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false;">
				            				<a4j:actionparam name="rowId" value="#{bankItemLst.dataObj.rowId}"/>
				            				<a4j:actionparam name="navModule" value="gm" />
				           					<a4j:actionparam name="navProgram" value="SEMMCT009" />	
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
											<a4j:actionparam name="methodWithNavi" value="doInitNewOrUpdate" />
											<a4j:actionparam name="mode" value="UPDATE" />
											
											<a4j:actionparam name="paramBankGroupCode" value="#{bankItemLst.dataObj.bankGroupCode}" />
											<a4j:actionparam name="paramBankName" value="#{bankItemLst.dataObj.bankName}" />
											<a4j:actionparam name="paramBankBranchCode" value="#{bankItemLst.dataObj.bankBranchCode}" />
											<a4j:actionparam name="paramBankBranch" value="#{bankItemLst.dataObj.bankBranch}" />
											<a4j:actionparam name="paramProvince" value="#{bankItemLst.dataObj.provinceId}" />
				            			</a4j:commandButton>
									</div> 
								</rich:column>
								
								<rich:column rendered="false" width="40" styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}">
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<a4j:commandButton id="btnDelete" action="#{navAction.navi}" image="images/delete.png" style="height:15px; width:15px;" 
										oncomplete="#{rich:component('panel_popupConfirm')}.show(); return false;" reRender="oppContent">
				            				<a4j:actionparam name="rowId" value="#{bankItemLst.dataObj.rowId}"/>
				            				<a4j:actionparam name="navModule" value="gm" />
				           					<a4j:actionparam name="navProgram" value="SEMMCT009" />	
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
											<a4j:actionparam name="methodWithNavi" value="doInitNewOrUpdate" />
											<a4j:actionparam name="mode" value="DELETE" />
				            			</a4j:commandButton>
									</div> 
								</rich:column>
								
								<rich:column width="70" styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.bankGroupCode}"  title="#{bankItemLst.dataObj.bankGroupCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.bankCode']}" styleClass="contentform"  style="width:40px;"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankItemLst.dataObj.bankGroupCode}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column width="80" styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.bankBranchCode}"  title="#{bankItemLst.dataObj.bankBranchCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.bankBranchCode']}" styleClass="contentform"  style="width:70px;"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankItemLst.dataObj.bankBranchCode}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column width="80" styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.bankCode}"  title="#{bankItemLst.dataObj.bankCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.bankCode.En']}" styleClass="contentform"  style="width:70px;"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankItemLst.dataObj.bankCode}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.bankName}"  title="#{bankItemLst.dataObj.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style=""/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankItemLst.dataObj.bankName}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.bankBranch}"  title="#{bankItemLst.dataObj.bankBranch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.bankBranchName']}" styleClass="contentform"  style=""/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankItemLst.dataObj.bankBranch}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.provinceTh}"  title="#{bankItemLst.dataObj.provinceTh}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.province']}" styleClass="contentform"  style=""/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankItemLst.dataObj.provinceTh}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.createBy}"  title="#{bankItemLst.dataObj.createBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.createBy']}" styleClass="contentform"  style=""/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankItemLst.dataObj.createBy}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.createDt}"  title="#{bankItemLst.dataObj.createDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.createDt']}" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankItemLst.dataObj.createDtStr}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.updateBy}"  title="#{bankItemLst.dataObj.updateBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform"  style=""/>
									</f:facet>
									<div align="left">
										<h:outputText value="#{bankItemLst.dataObj.updateBy}" styleClass="contentform" />
									</div>
								</rich:column>
								
								<rich:column styleClass="#{(semmct009Bean.tmpRowId == bankItemLst.dataObj.rowId) ? 'onClick' : 'unClick'}"
								sortBy="#{bankItemLst.dataObj.updateDt}"  title="#{bankItemLst.dataObj.updateDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{bankItemLst.dataObj.updateDtStr}" styleClass="contentform" />
									</div>
								</rich:column>
								<!-- << column -->
								
								<!-- >> footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmct009Bean.bankMasterList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="9">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dTabBankMasterSrch"
												maxPages="#{semmct009Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dScrllBankMasterSrch" style="background-color: #cccccc;"
												page="#{semmct009Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmSearchResult"></a4j:support>
											</rich:datascroller>
												
										</rich:column>
									</rich:columnGroup>				
								</f:facet>
								<!-- << footer -->
							</rich:dataTable>
						</a4j:form>
					</div>
					</center>
					<!-- << table result -->
				</rich:panel>
				<!-- << content 2 -->
				
				<div style="clear:both;"></div>
	
		</rich:panel>
		<!-- << content panel -->
		
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
	
	
	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  -->
	<!-- >>>> all popup dialog in used >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> -->
	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  -->

	<!-- popupNewOrUpdateBankMaster -->
	<rich:modalPanel id="panel_popupNewOrUpdateBankMaster" width="800" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Bank Master"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-panel_popupNewOrUpdateBankMaster" style="cursor:pointer" />
					<rich:componentControl for="panel_popupNewOrUpdateBankMaster" attachTo="hide-panel_popupNewOrUpdateBankMaster" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid>
			<a4j:form id="frmError-newOrUpdateBankMasterForm">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct009Bean.renderedDailog}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="newOrUpdateBankMasterForm"> 
			<rich:panel id="panel_newOrUpdateBankMaster">
				<center>
				<h:panelGrid width="90%">
				<h:panelGroup>
					<table  style="width:100%;">
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankCode']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:10%;" colspan="3">
								<a4j:region> 
									<h:selectOneMenu id="dlgTxtBankGroupCode" value="#{semmct009Bean.itemBankMasterSP}" 
										disabled="#{semmct009Bean.disbledDialogField}"
										converter="bankMasterSPConverter"> 
                                        <f:selectItems value="#{semmct009Bean.bankSelectionSearchList}"/>
                                        <a4j:support event="onchange" action="#{semmct009Action.doSemiLiveSearch}" reRender="dlgTxtBankName,  dlgTxtBankBranchCode, dlgTxtBankBranch, dlgSlctProvinceList,   chkForEdit">
											<a4j:actionparam name="methodWithNavi" value="doSemiLiveSearch" />
											<a4j:actionparam name="paramLiveMode" value="GROUP_CODE" />
										</a4j:support>
                                    </h:selectOneMenu>  
								</a4j:region>
							</td>
						</tr>
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankBranchCode']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:10%;">
					            <a4j:region> 
					            	<h:inputText id="dlgTxtBankBranchCode" value="#{semmct009Bean.itemBankMasterSP.bankBranchCode}" 
					            	styleClass="contentform" maxlength="5" style="width:100%;">
					            	
						            	<a4j:support event="onkeyup" action="#{semmct009Action.doSemiLiveSearch}" reRender="dlgTxtBankBranch, dlgSlctProvinceList">
											<a4j:actionparam name="methodWithNavi" value="doSemiLiveSearch" />
											<a4j:actionparam name="paramLiveMode" value="BRANCH_CODE" />
										</a4j:support>
					            	
					            	</h:inputText>
					            </a4j:region>
							</td>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.bankBranchName']} :" styleClass="ms7"/>
				            </td>
				            <td style="width:50%;">
				            	<h:inputText id="dlgTxtBankBranch" value="#{semmct009Bean.itemBankMasterSP.bankBranch}" 
				            	styleClass="contentform" maxlength="300" style="width:90%;" />
							</td>
						</tr>
						<tr>
							<td align="right" style="width:20%;">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.province']} :" styleClass="ms7"/>
				            </td>
							<td colspan="3">
								<h:selectOneMenu id="dlgSlctProvinceList" value="#{semmct009Bean.itemBankMasterSP.provinceId}">
									<f:selectItems value="#{semmct009Bean.provinceList}" />
								</h:selectOneMenu> 
					        </td>
					     </tr> 
					</table>
				</h:panelGroup>
				</h:panelGrid>
				</center>
			</rich:panel>	
			
			<div style="clear:both; height:0px;"></div>
			
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
			<h:panelGroup style="float:right;">
				<a4j:commandButton id="saveBtn" value="Save" styleClass="rich-button" action="#{navAction.navi}" 
				reRender="pnlSearchResult, frmError-newOrUpdateBankMasterForm, dTabBankMasterSrch"
				process="newOrUpdateBankMasterForm"
				oncomplete="if(#{semmct009Bean.popupClose == 'true'}) {#{rich:component('panel_popupNewOrUpdateBankMaster')}.hide();}" >
						<a4j:actionparam name="navModule" value="gm" />
          				<a4j:actionparam name="navProgram" value="SEMMCT009" />	
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
						<a4j:actionparam name="mode" value="#{semmct009Bean.doMode}" />
				</a4j:commandButton>
				
				<rich:spacer width="5px" />

				<a4j:commandButton value="Cancel" styleClass="rich-button" reRender="newOrUpdateBankMasterForm">
					<rich:componentControl for="panel_popupNewOrUpdateBankMaster" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGroup>
			</h:panelGrid>
		</a4j:form>	
	</rich:modalPanel>
	<!-- popupNewOrUpdateBankMaster -->
	
	
	<!-- popupModalConfirm -->
	<rich:modalPanel id="panel_popupConfirm" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Delete"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-panel_popupConfirm" style="cursor:pointer" />
					<rich:componentControl for="panel_popupConfirm" attachTo="hide-panel_popupConfirm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="frmConfirmDelDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<h:outputText value="#{jspMsg['label.confirm']}" styleClass="ms7" />
			</h:panelGrid>

			<div style="clear:both; height:0px;"></div>
			
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
					immediate="true" reRender="dTabBankMasterSrch" >
						<a4j:actionparam name="rowId" value="#{semmct009Bean.itemBankMasterSP.rowId}"/>
						<a4j:actionparam name="navModule" value="gm" />
	         			<a4j:actionparam name="navProgram" value="SEMMCT009" />	
						<a4j:actionparam name="moduleWithNavi" value="gm" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCT009" />
						<a4j:actionparam name="methodWithNavi" value="doDelete" />
						<rich:componentControl for="panel_popupConfirm" operation="hide" event="onclick"  />
					</a4j:commandButton>
					
					<rich:spacer width="5px" />
					
					<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="panel_popupConfirm" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- popupModalConfirm -->
	

	<!-- not use -->
	<!-- popupModalRetStatus -->
	<rich:modalPanel id="panel_popupModalRetStatus" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Process Status"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-panel_popupModalRetStatus" style="cursor:pointer" />
					<rich:componentControl for="panel_popupModalRetStatus" attachTo="hide-panel_popupModalRetStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="panel_popupModalRetStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- popupModalRetStatus -->