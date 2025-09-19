<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt006" var="jspMsg2"/>
<rich:modalPanel id="popupFrmSaveReDpst" width="650" autosized="true" minWidth="250">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmAdd']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSaveReDpst" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmSaveReDpst" attachTo="hidePopupSaveReDpst" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="frmSaveReDpst">
		<h:panelGrid>
			<h:messages id="errorReDpst" errorClass="ms7red" warnClass="ms7green" globalOnly="false"></h:messages>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="gridContent">
			<h:panelGrid width="100%">
				<rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['header.frmAdd']}"/>
					</f:facet>
					<!-- begin content criteria -->
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table border="0">
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.depositType']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:selectOneMenu id="ddlDepositType" value="#{semmrt006Bean.returnDpst.depositType}" 
		                				disabled="true"> 
										<f:selectItems value="#{semmrt006Bean.depositTypeList}"/>
									</h:selectOneMenu>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.contractNo']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:inputText id="txtContractNo" value="#{semmrt006Bean.reDpstContractNo}" 
		                				disabled="true"/>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.depositIncAmt']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:inputText id="txtDepositIncAmt" value="#{semmrt006Bean.reDpstAmt}" 
		                				disabled="true" 
				                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                				onblur="return numberformat.moneyFormat(this);"
		                				onfocus="return numberformat.setCursorPosToEnd(this);"
		                				maxlength="16" 
		                				styleClass="inputRight">
		                				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
				                </td>
							</tr>
							
							<h:panelGroup rendered="#{semmrt006Bean.returnDpst.depositType == '02'}">
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.depositRentAmt']}" styleClass="ms7" />
									</td>
									<td colspan="3">
										<h:inputText id="txtDepositRentAmt" value="#{semmrt006Bean.reDpstRentAmt}" 
			                				disabled="true" 
					                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                				onblur="return numberformat.moneyFormat(this);"
			                				onfocus="return numberformat.setCursorPosToEnd(this);"
			                				maxlength="16" 
			                				styleClass="inputRight">
			                				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.depositRentRetAmt']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<h:inputText id="txtDepositRentRetAmt" value="#{semmrt006Bean.reDpstRentRetAmt}" 
			                				disabled="true" 
					                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                				onblur="return numberformat.moneyFormat(this);"
			                				onfocus="return numberformat.setCursorPosToEnd(this);"
			                				maxlength="16" 
			                				styleClass="inputRight">
			                				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:graphicImage value="images/icon_required.gif" rendered="#{semmrt006Bean.returnDpst.returnDepositStatus == '06'}"/>
										<rich:spacer width="5" />
										<h:outputText value="#{jspMsg2['label.returnAmt']}" styleClass="ms7" />
									</td>
									<td>
			                			<h:inputText id="txtDepositReturnAmt" value="#{semmrt006Bean.returnDpst.depositReturnAmt}" 
			                				disabled="#{semmrt006Bean.popupRole != 'SM'}" 
					                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                				onblur="return numberformat.moneyFormat(this);"
			                				onfocus="return numberformat.setCursorPosToEnd(this);"
			                				maxlength="16" 
			                				styleClass="inputRight" 
			                				onchange="onChangeDpsReturnJS();">
			                				<a4j:jsFunction name="onChangeDpsReturnJS" action="#{semmrt006Action.chkDpstReturnAmt}" 
			                					reRender="txtDepositReBalanceAmt,grdPopupCommand,frmSaveReDpst"/>
			                				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
			                		</td>
			                		<td align="right">
										<h:outputText value="#{jspMsg2['label.returnBalanceAmt']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtDepositReBalanceAmt" 
											value="#{semmrt006Bean.reDpstRentRetAmt - semmrt006Bean.returnDpst.depositReturnAmt}" 
			                				disabled="true" 
					                		onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                				onblur="return numberformat.moneyFormat(this);"
			                				onfocus="return numberformat.setCursorPosToEnd(this);"
			                				maxlength="16" 
			                				styleClass="inputRight">
			                				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.receiptNo']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<h:inputText id="txtReceiptNo" value="#{semmrt006Bean.reDpstReceiptNo}" 
			                				disabled="true"/>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.taxInvoiceNo']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<h:inputText id="txtTaxInvoiceNo" value="#{semmrt006Bean.reDpstTaxInvoiceNo}" 
			                				disabled="true"/>
					                </td>
								</tr>
							</h:panelGroup>
							<h:panelGroup rendered="#{semmrt006Bean.returnDpst.depositType == '01'}">
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.bgNo']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<h:inputText id="txtBgNo" value="#{semmrt006Bean.bgNo}"  
			                				disabled="true"/>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.bgBank']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<h:inputText id="txtBgBank" value="#{semmrt006Bean.bgBank}"  
			                				disabled="true"/>
					                </td>
								</tr>
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.bgStartDt']}" styleClass="ms7" />
									</td>
									<td>
			                			<h:inputText id="txtBgStartDt" value="#{semmrt006Bean.bgStartDt}"  
			                				disabled="true">
			                				<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
			                			</h:inputText>
					                </td>
					                <td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.bgEndDt']}" styleClass="ms7" />
									</td>
									<td>
			                			<h:inputText id="txtBgEndDt" value="#{semmrt006Bean.bgEndDt}"  
			                				disabled="true">
			                				<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
			                			</h:inputText>
					                </td>
								</tr>
							</h:panelGroup>
							<h:panelGroup rendered="#{semmrt006Bean.returnDpst.depositType == '01' && semmrt006Bean.popupRole == 'FN'}">
								<tr>
									<td align="right" width="30%">
										<h:outputText value="#{jspMsg2['label.bgReturnDt']}" styleClass="ms7" />
									</td>
									<td colspan="3">
			                			<rich:calendar id="cldBgReturnDt" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" 
												value="#{semmrt006Bean.returnDpst.bgReturnDt}" 
												showWeeksBar="false" 
												inputSize="13" 
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												oninputkeyup="this.value = this.value.substring(0, 10);" 
												cellWidth="20px" cellHeight="20px" 
												label="#{jspMsg2['column.header.bgReturnDt']}">
												<a4j:support event="oninputblur" ajaxSingle="true" reRender="errorReDpst" />
												<a4j:support event="onchanged" ajaxSingle="true" reRender="errorReDpst" />
										</rich:calendar>
					                </td>
								</tr>
							</h:panelGroup>
							<tr>
								<td align="right" width="30%">
									<h:outputText value="#{jspMsg2['label.remark']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:inputTextarea id="txtRemark" value="#{semmrt006Bean.returnDpst.remark}"
		                				rows="3" cols="50" disabled="#{semmrt006Bean.popupRole != 'SM'}"></h:inputTextarea>
				                </td>
							</tr>
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5" />
									<h:outputText value="#{jspMsg2['label.returnDpsStatus']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:selectOneMenu id="ddlReDpstStatus" value="#{semmrt006Bean.returnDpst.returnDepositStatus}" 
										onchange="onChangeReDpsStatusJS();" 
										disabled="#{semmrt006Bean.disReturnDpstStatus}">
		                				<a4j:jsFunction name="onChangeReDpsStatusJS" reRender="frmSaveReDpst"/>
										<f:selectItems value="#{semmrt006Bean.returnDpsStatusList}"/>
									</h:selectOneMenu>
				                </td>
							</tr>
							<h:panelGroup rendered="#{semmrt006Bean.popupRole == 'AC' && semmrt006Bean.returnDpst.returnDepositStatus == '07'}">
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5" />
									<h:outputText value="#{jspMsg2['label.docClrNo']}" styleClass="ms7" />
								</td>
								<td>
		                			<h:inputText id="txtDocClrNo" value="#{semmrt006Bean.returnDpst.docClear}">
		                			</h:inputText>
		                		<td align="right">
		                			<h:panelGroup>
			                			<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5" />
										<h:outputText value="#{jspMsg2['label.docClrDt']}" styleClass="ms7" />
									</h:panelGroup>
								</td>
								<td>
									<rich:calendar id="cldDocClrDt" locale="th" enableManualInput="true" 
												datePattern="dd/MM/yyyy" 
												value="#{semmrt006Bean.returnDpst.docClearDt}" 
												showWeeksBar="false" 
												inputSize="13" 
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												oninputkeyup="this.value = this.value.substring(0, 10);" 
												cellWidth="20px" cellHeight="20px" 
												label="Doc. Clear Date">
												<a4j:support event="oninputblur" ajaxSingle="true" reRender="errorReDpst" />
												<a4j:support event="onchanged" ajaxSingle="true" reRender="errorReDpst" />
									</rich:calendar>
				                </td>
							</tr>
							</h:panelGroup>
							<h:panelGroup rendered="#{semmrt006Bean.popupRole == 'FN' || semmrt006Bean.popupRole == 'AC'}">
							<tr>
								<td align="right" width="30%">
									<h:graphicImage value="images/icon_required.gif" 
										rendered="#{(semmrt006Bean.returnDpst.returnDepositStatus =='05' && semmrt006Bean.popupRole == 'FN') || 
										(semmrt006Bean.returnDpst.returnDepositStatus =='08' && semmrt006Bean.popupRole == 'AC')}"/>
									<rich:spacer width="5" />
									<h:outputText value="#{jspMsg2['label.reason']}" styleClass="ms7" />
								</td>
								<td colspan="3">
		                			<h:inputTextarea id="txtReason" value="#{semmrt006Bean.returnDpst.reason}"
		                				rows="3" cols="50"></h:inputTextarea>
				                </td>
							</tr>
							</h:panelGroup>
						</table>
						</h:panelGroup>
					</h:panelGrid>
					<!-- end content criteria -->
					<h:panelGrid columns="2" id="grdPopupCommand">
						<a4j:commandButton value="#{jspMsg2['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" 
							disabled="#{semmrt006Bean.disBtnSave}"
							oncomplete="if(#{semmrt006Bean.popupClose == 'true'})#{rich:component('popupFrmSaveReDpst')}.hide();"
							reRender="frmSaveReDpst,pnlSearchResult,dtbReturnDeposit,frmSearch,frmError">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT006-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg2['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmSaveReDpst" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupFrmUpload" width="650" autosized="true" minWidth="220">
	<f:facet name="header"><h:outputText value="#{jspMsg2['header.frmUpload']}" /></f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupUpload" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmUpload" attachTo="hidePopupUpload" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:form id="frmUploadFile">
		<rich:panel id="panSearchCriteria">
			<f:facet name="header">
				<h:outputText value="Browse File"/>
			</f:facet>
			<h:message for="txtFileUpload" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
			<h:panelGrid columns="2" columnClasses="top,top">
				         <rich:fileUpload id="txtFileUpload" fileUploadListener="#{fileUploadBean.listener}"
							              maxFilesQuantity="#{fileUploadBean.uploadsAvailable}"
							              listHeight="58"
										  listWidth="650px"
							              immediateUpload="#{fileUploadBean.autoUpload}"
							              allowFlash="#{fileUploadBean.useFlash}"
							              addControlLabel="Browse..."
							              autoclear="true" 
							              disabled="#{semmrt006Bean.mode == 'DOWNLOAD'}">
							              
							 <a4j:support event="onuploadcomplete" reRender="dtbFileUpload,frmUploadFile,panSearchCriteria" action="#{navAction.navi}">
							 	<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT006" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
								<a4j:actionparam name="methodWithNavi" value="doCreateAttachment" />
								<a4j:actionparam name="refId" value="#{semmrt006Bean.refId}"/>
							 </a4j:support>
							
				             <f:facet name="label">
								<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
							 </f:facet>
				         </rich:fileUpload>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="top,top">
				<rich:dataTable id="dtbFileUpload" cellpadding="1" cellspacing="0" border="0"
					var="attachment" value="#{semmrt006Bean.attachmentList}" 
					rows="#{semmrt006Bean.rowPerPage}"
					onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
					onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
					styleClass="contentform" style="height : 79px; width : 650px;">
					<rich:column width="5%" rendered="#{semmrt006Bean.mode == 'UPLOAD'}">
						<f:facet name="header">
							<h:outputText value="Delete" styleClass="contentform" />
						</f:facet>
						<div align="center">
			         		<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog2')}.show(); return false" 
			 					action="#{navAction.navi}" reRender="dtbFileUpload,txtFileUpload,panSearchCriteria"
			 					image="images/delete.png" style="height: 15; width: 15">
								<a4j:actionparam name="navModule" value="rt" />
			            		<a4j:actionparam name="navProgram" value="SEMMRT006" />	
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
								<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
			 					<a4j:actionparam name="rowId" value="#{attachment.rowId}"/>	
				         	</a4j:commandButton>          							
						</div>
					</rich:column>
					<rich:column sortBy="#{attachment.fileName}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg2['column.header.fileName']}" styleClass="contentform" />
						</f:facet>
						<div align="left">
							<h:commandLink action="#{semmct002Action.doDownload}"  
			 					value="#{attachment.fileName}" 
			 					disabled="#{!semmct002Bean.renderedColDel}">
		 						<f:param name="pathName" value="#{attachment.attachmentPath}"></f:param>	
		 						<f:param name="fileName" value="#{attachment.fileName}"></f:param>
				         	</h:commandLink>     
						</div>
					</rich:column>
					<rich:column sortBy="#{attachment.createBy}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg2['column.header.createBy']}" styleClass="contentform" />
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
							<h:outputText value="#{attachment.createDt}" styleClass="contentform" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
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
	</h:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelDialog2" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog2">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmrt006Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
			<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
										   immediate="true" reRender="dtbFileUpload,frmUploadFile,panSearchCriteria" >
							<a4j:actionparam name="navModule" value="rt" />
	          				<a4j:actionparam name="navProgram" value="SEMMRT006" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT006" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<a4j:actionparam name="refId" value="#{semmrt006Bean.refId}"/>	
							<rich:componentControl for="mdpConfirmDelDialog2" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>