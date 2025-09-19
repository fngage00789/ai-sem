<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.rental.semmrt008" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmAddPay']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="editFrmError">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmPettyCashSave">
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
		            		<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT008PAY-4" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="eventType" value="Search" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent">
				            <a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="#{semmrt008PayBean.mode}" />
							<a4j:actionparam name="eventType" value="Add" />
							</a4j:commandButton>
			           		</td>
			           		
			           		<td>
			           		<a4j:commandButton id="btnApprove" 
			           						   oncomplete="#{rich:component('mdpConfirmApproveDialog')}.show(); return false" styleClass="rich-button" 
								               action="#{navAction.navi}" value="Approve"  
								               reRender="oppContent" style="width:70"
								               disabled="#{semmrt008PayBean.pettyCashPay.pettyCashPayStatus ne '01'}"
								               rendered="#{semmrt008PayBean.renderer['btnApprove'] && semmrt008PayBean.mode ne 'INSERT'}">
								<a4j:actionparam name="navModule" value="rt" />
			         			<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />	
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
								<a4j:actionparam name="methodWithNavi" value="pageLoad" />
								<a4j:actionparam name="mode" value="UPDATE" />
								<a4j:actionparam name="eventType" value="Approve" />
							</a4j:commandButton>
			           		</td>
			           		
			           		<td>
			           		<a4j:commandButton id="btnCancel" 
			           						   oncomplete="#{rich:component('mdpConfirmCancelDialog')}.show(); return false" styleClass="rich-button" 
								               action="#{navAction.navi}" value="Cancel"  
								    		   reRender="oppContent" style="width:60"
								    		   disabled="#{semmrt008PayBean.pettyCashPay.pettyCashPayStatus ne '01'}"
								    		   rendered="#{semmrt008PayBean.renderer['btnCancel'] && semmrt008PayBean.mode ne 'INSERT'}">
								<a4j:actionparam name="navModule" value="rt" />
			         			<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />	
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
								<a4j:actionparam name="methodWithNavi" value="pageLoad" />
								<a4j:actionparam name="mode" value="UPDATE" />
								<a4j:actionparam name="eventType" value="Cancel" />
							</a4j:commandButton>
			           		</td>
			           		</tr>
			           		</table>
		           		</td>
		           		</tr>
						</table>
					</h:panelGroup>
				
					
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.pay']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" >
		                			<a4j:region>
		                			<h:selectOneMenu id="ddlCompany" value="#{semmrt008PayBean.pettyCashPay.company}" readonly="#{semmrt008PayBean.readOnlyCompany}">
		                				
										<f:selectItems value="#{semmrt008PayBean.companyList}"/>
										<f:selectItem itemValue="AWN2" itemLabel="AWN2"/>
										<a4j:support event="onchange"  reRender="companyDisplay">
				                		</a4j:support>
									</h:selectOneMenu>
									</a4j:region>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmrt008PayBean.pettyCashPay.company}" styleClass="ms28"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.payNo']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPayNo"  value="#{semmrt008PayBean.pettyCashPay.pettyCashPayNo}" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<!--<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                			--></td>
		                			<td width="30%">
		                			<!--<h:selectOneMenu id="ddlSaveRegion" 
		                							 value="#{semmrt008PayBean.pettyCashPay.region}" > 
										<f:selectItems value="#{semmrt008PayBean.regionList}"/>
									</h:selectOneMenu>
									
				                	--></td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.requestName']} :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtRequestName" value="#{semmrt008PayBean.pettyCashPay.requestName}"/>
				                	</td>
				                	<td align="right">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.requestDt']} :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldReqDt" locale="th" enableManualInput="true" 
								    datePattern="dd/MM/yyyy" 
								    value="#{semmrt008PayBean.pettyCashPay.requestDt}"
								    showWeeksBar="false"
								    inputSize="13"
								    oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								    cellWidth="20px" cellHeight="20px"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.requestSubject']} :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneMenu label="#{jspMsg['label.requestSubject']}" id="ddlReqSubj5" value="#{semmrt008PayBean.pettyCashPay.requestSubject}"> 
										<f:selectItems value="#{semmrt008PayBean.requestSubjList}"/>
									</h:selectOneMenu> 
		                			</td>
		                			<td align="right">
		                			<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.requestAmt']} :" styleClass="ms7"/>
									</td>
		                			<td>
		                			<a4j:region>
		                			<h:inputText id="txtReqAmt" value="#{semmrt008PayBean.pettyCashPay.requestAmt}" 
		                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                						 onblur="return numberformat.moneyFormat(this);"
		                						 onfocus="return numberformat.setCursorPosToEnd(this);"
		                						 maxlength="16" 
		                						 styleClass="inputRight">
		                					<a4j:support event="onchange" action="#{semmrt008PayAction.calIncRequestAmount}" reRender="txtIncReqAmt"></a4j:support>
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
		                			</a4j:region>
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="Vat :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3"> 
		                			<a4j:region>
			                		<h:selectOneRadio id="rbtVat" value="#{semmrt008PayBean.pettyCashPay.vatType}" styleClass="ms7">
										<f:selectItem itemLabel="#{jspMsg['label.incVat']}" itemValue="01" />
										<f:selectItem itemLabel="#{jspMsg['label.excVat']}"  itemValue="02" />
										<f:selectItem itemLabel="#{jspMsg['label.exceptVat']}" itemValue="03" />
										<a4j:support event="onclick" action="#{navAction.navi}" reRender="txtIncReqAmt">
					                		<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
											<a4j:actionparam name="methodWithNavi" value="calIncRequestAmount" />
				                		</a4j:support>
									</h:selectOneRadio>
									</a4j:region>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" valign="top">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.incRequestAmt']} :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:inputText id="txtIncReqAmt" value="#{semmrt008PayBean.pettyCashPay.incRequestAmt}" 
		                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                						 onblur="return numberformat.moneyFormat(this);"
		                						 onfocus="return numberformat.setCursorPosToEnd(this);"
		                						 maxlength="16" 
		                						 styleClass="inputRight"
		                						 disabled="true">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" valign="top">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="ใบเสร็จ/ใบกำกับ :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:selectOneRadio id="rbtReceiptTaxFlag" value="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag}" 
		                							  styleClass="ms7" >
										<f:selectItem itemLabel="#{jspMsg['label.have']}" itemValue="Y" />
										<f:selectItem itemLabel="#{jspMsg['label.noHave']}"  itemValue="N" />
										<a4j:support event="onclick" reRender="frmPettyCashSave"></a4j:support>
									</h:selectOneRadio>
									
				                	</td>
				                	<td align="right">
									<!--<h:outputText value="#{jspMsg['label.clrReceiptTaxFlag']} :" styleClass="ms7"/>
		                			--></td>
		                			<td>
		                			<!--<h:selectOneRadio id="rbtClrReceiptTaxFlag" value="#{semmrt008PayBean.pettyCashPay.clrReceiptTaxFlag}" styleClass="ms7">
										<f:selectItem itemLabel="#{jspMsg['label.have']}" itemValue="Y" />
										<f:selectItem itemLabel="#{jspMsg['label.noHave']}"  itemValue="N" />
									</h:selectOneRadio>
				                	--></td>
			                	 </tr>
			                	 <tr>
									<td align="right" valign="top">
									<rich:spacer width="5"></rich:spacer>
									<h:outputText id= "outTaxInvoiceNo" value="เลขที่ใบเสร็จ/ใบกำกับ :" styleClass="ms7"
											 	  rendered="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag eq 'Y'}"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtTaxInvoiceNo" value="#{semmrt008PayBean.pettyCashPay.taxInvoiceNo}" 
		                						 rendered="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag eq 'Y'}">
		                			</h:inputText>
				                	</td>
				                	<td align="right">
									<h:outputText id="outTaxInvoiceDt" value="วันที่ใบเสร็จ/ใบกำกับ :" styleClass="ms7"
												  rendered="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag eq 'Y'}"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldTaxInvoiceDt" locale="th" enableManualInput="true" 
								    datePattern="dd/MM/yyyy" 
								    value="#{semmrt008PayBean.pettyCashPay.taxInvoiceDt}"
								    showWeeksBar="false"
								    inputSize="13"
								    oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								    cellWidth="20px" cellHeight="20px"
								    rendered="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag eq 'Y'}"
								    />
				                	</td>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td valign="top" align="right">
									<h:graphicImage value="images/icon_required.gif" rendered="#{semmrt008PayBean.pettyCashPay.receiptTaxFlag eq 'Y'}"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.payStatus']} :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu label="#{jspMsg['label.payStatus']}" id="ddlSaveReqType" 
		                							 value="#{semmrt008PayBean.pettyCashPay.pettyCashPayStatus}"
		                							 disabled="true"> 
										<f:selectItems value="#{semmrt008PayBean.payStatusList}"/>
									</h:selectOneMenu>
				                	</td>
			                	</tr>
			                	
			                	 <tr>
									<td valign="top" align="right">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
		                			</td>
		                			<td colspan="3">
		                			<h:inputTextarea id="txtAreRemarkEdit" 
		                							 value="#{semmrt008PayBean.pettyCashPay.remark}"
		                							 onkeyup="this.value = this.value.substring(0, 250);"
		                							 rows="3" cols="130"
		                							 ></h:inputTextarea>
				                	</td>
			                    </tr> 	
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				<h:panelGrid width="100%">
				<h:form id="frmPayRentInfo">
					
					<rich:panel id="panSearchCriteria"  rendered="#{semmrt008PayBean.renderedPanelPaymentInfo}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.rentInfo']}"/>
						</f:facet>
				     <h:panelGrid columns="2" columnClasses="top,top">
				     <rich:dataTable id="dtbPettyCashPayEdit" cellpadding="1" cellspacing="0" border="0"
									var="pttCashPayMap" value="#{semmrt008PayBean.pettyCashMapPaySPList}" 
									rows="#{semmrt008PayBean.rowPerPage}"
									onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
									styleClass="contentform" style="height : 79px; width : 900px;">
							<rich:column  style="width: 90" sortBy="#{pttCashPayMap.contractNo}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.contractNo}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pttCashPayMap.siteName}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.siteName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  style="width: 90" sortBy="#{pttCashPayMap.effectiveDt}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.effDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.effectiveDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pttCashPayMap.expireDt}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expireDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.expireDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column style="width: 140" sortBy="#{pttCashPayMap.expenseTypeName}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.expenseTypeName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{pttCashPayMap.dueDt}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.dueDt']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.dueDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column style="width: 140" sortBy="#{pttCashPayMap.vendorId}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.vendorId}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<rich:column style="width: 140" sortBy="#{pttCashPayMap.vendorName}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.vendorName}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<rich:column style="width: 140" sortBy="#{pttCashPayMap.payeeName}" styleClass="#{(semmrt008Bean.tmpRowId==pttCashPayMap.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Alternative Payee" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pttCashPayMap.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPettyCashPayEdit" 
									maxPages="10" id="dstPettyCashPay" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						</h:panelGrid>
				    </rich:panel>
				    
					<!--<rich:panel id="pnlLog">
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
		                				<h:inputText id="txtCreateBy" value="#{semmrt008PayBean.pettyCashPay.createBy}" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy hh:mm:ss" 
									    value="#{semmrt008PayBean.pettyCashPay.createDt}"
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
			                			<h:inputText id="txtUpdateBy" value="#{semmrt008PayBean.pettyCashPay.updateBy}" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy hh:mm:ss" 
									    value="#{semmrt008PayBean.pettyCashPay.updateDt}"
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
					
				--></h:form>
				</h:panelGrid>
		</h:panelGrid>
			
			
	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="mdpConfirmApproveDialog" autosized="true" rendered="#{semmrt008PayBean.renderedDailog}" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Approve"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmApproveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="3" styleClass="contentlabelform" width="230px">
						<h:outputText value="#{semmrt008PayBean.msgDoApprove}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="oppContent" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="UPDATE" />
							<a4j:actionparam name="eventType" value="Approve" />
							<rich:componentControl for="mdpConfirmApproveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmApproveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmCancelDialog" autosized="true" rendered="#{semmrt008PayBean.renderedDailog}">	
	<f:facet name="header">
    	<h:outputText value="Confirm Cancel"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCancelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="3" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmrt008PayBean.msgDoCancel}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="oppContent" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008PAY-5" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008Pay" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="UPDATE" />
							<a4j:actionparam name="eventType" value="Cancel" />
							<rich:componentControl for="mdpConfirmCancelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCancelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
