<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<f:loadBundle basename="resources.gm.semmct002" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.master.save']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="bgEditFrmError">
				<rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct002Bean.renderedMsgFormTop}">
					<f:facet name="errorMarker">
			 		   <h:graphicImage value="images/error.gif" />  
	                </f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<jsp:include page="../../pages/popup/sitecontractPct002-popup.jsp"/>
			<a4j:form id="frmSaveBG002_2">
				<!-- begin content layout criteria -->
					<h:panelGrid width="100%">
						<h:panelGroup>
						<table width="100%" border="0">
						<tr>
						<td width="50%" align="left">
							
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
							<tr>
							<td>
							<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent">
		            		<a4j:actionparam name="navModule" value="#{semmct002Bean.navModuleFrom}" />
							<a4j:actionparam name="navProgram" value="#{semmct002Bean.navProgramFrom}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmct002Bean.navModuleFrom}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmct002Bean.actionWithNaviFrom}" />
							<a4j:actionparam name="methodWithNavi" value="doBackPage" />
							<a4j:actionparam name="mode" value="SEARCH" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSaveReject" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent,bgEditFrmError,txtAreAddressContr"
				            onclick="#{rich:component('mdpConfirmSaveDialog')}.show(); return false"
				            rendered="#{!semmct002Bean.disabled && semmct002Bean.bgMaster.bgStatus == 'R'}">
							</a4j:commandButton>
							
			           		<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent,bgEditFrmError,txtAreAddressContr,panSearchCriteria"
				            rendered="#{!semmct002Bean.disabled && semmct002Bean.bgMaster.bgStatus != 'R'}">
				            <a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="INSERT" />
							<a4j:actionparam name="formType" value="page" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<h:commandButton id ="btnExport" action="#{semmct002Action.doExportExcel}"  
	            					 styleClass="rich-button" value="#{jspMsg['btn.exportExcel']}"
	            					 rendered="#{!semmct002Bean.disabled}">
	            			</h:commandButton>
			           		</td>
			           		</tr>
			           		</table>
		           		</td>
		           		</tr>
						</table>
					</h:panelGroup>
				
					
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.save.detail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr valign="baseline">
									<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.companyName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" valign="baseline">
		                		
		                			<h:selectOneMenu id="ddlCompany" value="#{semmct002Bean.bgMaster.company}"
		                							 disabled="#{semmct002Bean.disabledCompany}"
		                							 onchange="GetCompanyJS();"> 
										<f:selectItems value="#{semmct002Bean.companyList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
		                			
		                			<h:outputText id="companyDisplay" value="#{semmct002Bean.bgMaster.company}" styleClass="ms28"/>
		                			
				                	</td>
									
				                	<td align="right" width="20%">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.expensesType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" >
		                			<h:selectOneMenu id="ddlExpenses" value="#{semmct002Bean.bgMaster.expenseType}"
		                							 disabled="#{semmct002Bean.disabled}"> 
										<f:selectItems value="#{semmct002Bean.expenseTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" >
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtContractNo" disabled="true" value="#{popupSiteContractBean.contractNo}"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="if(#{popupSiteContractBean.openPopup})#{rich:component('popupSearchContractNo')}.show(); return false"
									value="..."  reRender="popupSearchContractNo,popupFrmSearch,txtAreSiteAddress,txtAreAddressContr" 
				            		action="#{navAction.navi}" 
				            		disabled="#{semmct002Bean.disabled || semmct002Bean.navProgramFrom != 'SEMMCT002-1' }">
				            		<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNoPct002" />
		            				</a4j:commandButton>
				                	</td>
				                	<td align="right">
									<h:outputText value="#{jspMsg['lebel.sitename']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtSiteName" disabled="true" value="#{popupSiteContractBean.siteName}" size="40"/>
									<rich:spacer width="5"/>
									
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldStartDt" locale="th" enableManualInput="true" 
								  	 datePattern="dd/MM/yyyy" 
								   	 value="#{popupSiteContractBean.effDate}"
								   	 showWeeksBar="false" 
								   	 disabled="#{semmct002Bean.disabled}"
								   	 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								   	 inputSize="13" 
								   	 oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
									 oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
								   	 cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.startDt']}">
									</rich:calendar>
				                	</td>
				                	<td align="right">
				                	<!--<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									-->
									<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldEndDt" locale="th" enableManualInput="true" 
								  	 datePattern="dd/MM/yyyy" 
								   	 value="#{popupSiteContractBean.expDate}"
								   	 showWeeksBar="false" 
								   	 disabled="#{semmct002Bean.disabled}"
								   	 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								   	 inputSize="13" 
								   	 oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldEndDt','cldStartDt');"
									 oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldEndDt','cldStartDt');"
								   	 cellWidth="20px" cellHeight="20px" label="#{jspMsg['column.header.endDt']}">
									</rich:calendar> 
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.amount']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputText id="txtAmount" value="#{semmct002Bean.bgMaster.bgAmt}" 
		                						 disabled="#{semmct002Bean.disabled}" 
		                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                		 				 onblur="return numberformat.moneyFormat(this);"
		                		 				 onfocus="return numberformat.setCursorPosToEnd(this);"
		                						 maxlength="16" 
		                						 styleClass="inputRight">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td valign="top" align="right">
									<h:outputText value="#{jspMsg['label.address.contractor']} :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreAddressContr" value="#{popupSiteContractBean.lessorAddr}"
		                							 rows="5" cols="145" disabled="#{semmct002Bean.disabled}"
		                							 label="#{jspMsg['label.address.contractor']}" >
		                				<f:validateLength maximum="1000" ></f:validateLength>
		                			</h:inputTextarea>
		                			
				                	</td>
			                	  </tr>
			                	  
			                	  <tr>
									<td valign="top" align="right">
									<h:outputText value="#{jspMsg['label.address.location']} :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreSiteAddress" value="#{popupSiteContractBean.siteAddr}"
		                							 rows="5" cols="145" disabled="#{semmct002Bean.disabled}"
		                							 label="#{jspMsg['label.address.location']}">
		                							 <f:validateLength maximum="1000" ></f:validateLength>
		                			</h:inputTextarea>
				                	</td>
			                	  </tr>
			                	  
			                	  <tr>
									<td align="right" valign="top">
									<h:outputText value="#{jspMsg['label.remark']} :" styleClass="ms7" />
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreRemarkEdit" 
		                							 value="#{semmct002Bean.bgMaster.remark}"
		                							 disabled="#{semmct002Bean.disabled}"
		                							 rows="5" cols="145"
		                							 label="#{jspMsg['label.remark']}">
		                							 <f:validateLength maximum="1000" ></f:validateLength>
		                			</h:inputTextarea>
				                	</td>
			                    </tr>
			                	  <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.status.bg']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="1">
		                			<h:selectOneMenu id="ddlStatusBG" value="#{semmct002Bean.bgMaster.bgStatus}"
		                							 disabled="false" >
										<f:selectItems value="#{semmct002Bean.bgStatusList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="left">
				                	<rich:spacer width="5"></rich:spacer>
				                	<h:selectBooleanCheckbox id="chkSM"  value="#{semmct002Bean.checkSM}"
				                							  rendered="#{semmct002Bean.bgMaster.bgStatus eq 'F'}">
									</h:selectBooleanCheckbox>
									<rich:spacer width="5"></rich:spacer>
				                	<h:outputText value="ได้รับ BG" rendered="#{semmct002Bean.bgMaster.bgStatus eq 'F'}" 
				                				  styleClass="ms7"/>
		                			</td>
		                			<td align="right">
		                			</td>
			                	  </tr>
			                	  <tr>
									<td valign="top" align="right">
									<h:outputText value="#{jspMsg['label.rejectReason']}" styleClass="ms7" rendered="#{semmct002Bean.renderedTxtAreaReason}"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreRejectReason"
		                				 value="#{semmct002Bean.bgMaster.rejectReason}"
		                				 rows="3" cols="104" disabled="#{semmct002Bean.disabled}"
		                				 onkeyup="this.value = this.value.substring(0, 250);" 
		                				 rendered="#{semmct002Bean.renderedTxtAreaReason}"></h:inputTextarea>
				                	</td>
			                	  </tr>
			                	  
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
					
					<rich:panel id="panBGInfo" rendered="#{semmct002Bean.renderedPanelBGInfo}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.save.bgInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtBgNo" value="#{semmct002Bean.bgMaster.bgNo}" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu id="ddlBank" value="#{semmct002Bean.bgMaster.bgBank}" disabled="true"> 
										<f:selectItems value="#{semmct002Bean.bankNameList}" />
									</h:selectOneMenu>
				                	</td>
			                	</tr>
								<tr>
									<td align="right">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreRemark" 
		                							 value="#{semmct002Bean.bgMaster.bgRemark}"
		                							 disabled="true"
		                							 onkeyup="this.value = this.value.substring(0, 250);"
		                							 rows="3" cols="104"
		                							 ></h:inputTextarea>
				                	</td>
			                   </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
				</a4j:form>
			
					
				
					
						
				<h:panelGrid width="100%">
				<h:form id="frmUploadFile">
					
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="Browse File"/>
						</f:facet>
					 <rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct002Bean.renderedMsgFormBottom}">
						<f:facet name="errorMarker">
				 		   <h:graphicImage value="images/error.gif" />  
		                </f:facet>
					 </rich:messages>
				     <h:panelGrid columns="2" columnClasses="top,top">
				         <rich:fileUpload id="txtFileUpload" fileUploadListener="#{fileUploadBean.listener}"
							              listHeight="58"
										  listWidth="900px"
							              immediateUpload="#{fileUploadBean.autoUpload}"
							              allowFlash="#{fileUploadBean.useFlash}"
							              addControlLabel="Browse..."
							              autoclear="true"
							              disabled="#{!semmct002Bean.renderedColDel}" 
							              >
							              
							 <a4j:support event="onuploadcomplete" reRender="oppContent" action="#{navAction.navi}" >
							 	<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
								<a4j:actionparam name="methodWithNavi" value="doCreateAttachment" />
								<a4j:actionparam name="refId" value="#{semmct002Bean.bgMaster.rowId}"/>	
									
								
							 </a4j:support>
							
				             <f:facet name="label">
								<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
							 </f:facet>
				         </rich:fileUpload>
				     </h:panelGrid>
				     <h:panelGrid columns="2" columnClasses="top,top">
				     <rich:dataTable id="dtbFileUpload" cellpadding="1" cellspacing="0" border="0"
									var="attachment" value="#{semmct002Bean.attachmentList}" 
									rows="#{semmct002Bean.rowPerPage}"
									onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
									styleClass="contentform" style="height : 79px; width : 900px;">
							<rich:column width="5%" rendered="#{semmct002Bean.renderedColDel}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
			         					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
			 									   		   action="#{navAction.navi}"  
			 									   		   image="images/delete.png" style="height: 15; width: 15">
											<a4j:actionparam name="navModule" value="gm" />
			            					<a4j:actionparam name="navProgram" value="SEMMCT002-1" />	
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
											<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
			 								<a4j:actionparam name="rowId" value="#{attachment.rowId}"/>	
				         				</a4j:commandButton>          							
								</div>
							</rich:column>
						
							<rich:column sortBy="#{attachment.fileName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.fileName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:commandLink action="#{navAction.doDownload}"  
			 									   value="#{attachment.fileName}" 
			 									   >
		 								<f:param name="pathName" value="#{attachment.attachmentPath}"/>	
		 								<f:param name="fileName" value="#{attachment.fileName}"/>
				         			</h:commandLink>     
								</div>
							</rich:column>
							<rich:column sortBy="#{attachment.createBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.createBy']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{attachment.createBy}" styleClass="contentform" />
	
								</div>
							</rich:column>
							<rich:column sortBy="#{attachment.createDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.createDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{attachment.createThDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="th" />
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbFileUpload" 
									maxPages="10" id="dstFileUpload" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						</h:panelGrid>
				    </rich:panel>
				    
					<rich:panel id="pnlLog">
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
		                				<h:inputText id="txtCreateBy" value="#{semmct002Bean.bgMaster.createBy}" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy hh:mm:ss" 
									    value="#{semmct002Bean.bgMaster.createDt}"
									    inputSize="20" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
									</td>
			                	 </tr><tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
			                			<h:inputText id="txtUpdateBy" value="#{semmct002Bean.bgMaster.updateBy}" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy hh:mm:ss" 
									    value="#{semmct002Bean.bgMaster.updateDt}"
									    showWeeksBar="false" 
									    inputSize="20" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" 
									    />
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					
				</h:form>
				</h:panelGrid>
		</h:panelGrid>
			
			
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct002Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
			<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
										   immediate="true" reRender="dtbFileUpload,txtFileUpload" >
							<a4j:actionparam name="navModule" value="gm" />
	          				<a4j:actionparam name="navProgram" value="SEMMCT002-2" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<a4j:actionparam name="rowId" value=""/>	
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmSaveDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmSaveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmct002Bean.msgDoConfirmResendFin}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
			<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
										   immediate="true" reRender="oppContent,bgEditFrmError,frmSaveBG002_2" >
							<a4j:actionparam name="navModule" value="gm" />
	          				<a4j:actionparam name="navProgram" value="SEMMCT002-2" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="bgStatus" value="R" />
							<a4j:actionparam name="rowId" value=""/>	
							<rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

		 
