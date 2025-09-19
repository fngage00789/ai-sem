<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel001-vmp-add-payee" var="jspMsg" />

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlPayeeMaster">
		<f:facet name="header">
			<h:outputText  id="outTxtDisplayMode" value="#{jspMsg['header.addPayee']} - #{semmel001Bean.actModeDisplay}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorTop">
				<rich:messages errorClass="ms7red" warnClass="ms7blue"
						    infoClass="ms7green" >
						<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
				</rich:messages>
						 
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="90%"> 
			<a4j:form id="frmSave">
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
							<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent" immediate="true" >
		            		<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="mode" value="UPDATE" />
							<a4j:actionparam name="rowId" value="#{semmel001Bean.vendorMaster.rowId}" />
							<a4j:actionparam name="isQueryContract" value="true"></a4j:actionparam>
							<a4j:actionparam name="vendorMapPayeeId" value="#{semmel001Bean.vendorMapPayee.rowId}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent">
				            <a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSavePayeeMaster" />
							<a4j:actionparam name="mode" value="#{semmel001Bean.mode}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent">
				            <a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
							<a4j:actionparam name="mode" value="INSERT" />
							</a4j:commandButton>
			           		</td>
			           		</tr>
			           		</table>
		           		</td>
		           		</tr>
						</table>
					</h:panelGroup>
				
				<rich:panel id="panDataVendor">
							<f:facet name="header">
								<h:outputText value="ข้อมูล Payee" />
							</f:facet>
						
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
									<h:panelGroup>
			                		<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="ชื่อผู้รับเงิน :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%"><h:inputText id="txtPayeeName" value="#{semmel001Bean.payeeMaster.payeeName}" 
			                									 size="35" 
			                									 maxlength="35"/></td>
									<td align="right" width="25%"></td>
			                		<td width="25%"></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="25%"></td>
				                	<td width="25%"></td>
			                		<td align="right" width="25%"></td>
				                	<td width="25%"></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right">
				                	<h:panelGroup>
			                		<h:outputText value="เลขประจำตัวประชาชน :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td><h:inputText id="txtIdCard" value="#{semmel001Bean.payeeMaster.idCard}" 
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 maxlength="13"/></td>
			                		<td align="right">
			                		<h:panelGroup>
			                		<h:outputText value="เลขประจำตัวผู้เสียภาษี :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td><h:inputText id="txtTaxId" value="#{semmel001Bean.payeeMaster.taxId}"
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 maxlength="15" ></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td></td>
		                		<td colspan="3">
		                		<a4j:commandButton id="btnCheckPayee"
			                	action="#{navAction.navi}"	  
			                	reRender="oppContent"
			                	value="#{jspMsg['btn.checkPayee']}" styleClass="rich-button"  
			                	style="width:110"
			                	oncomplete="if(#{semmel001Bean.renderedSelectPayeePopup == 'true'})#{rich:component('popupFrmSelectPayee')}.show(); return false" >
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doCheckPayee" />
								</a4j:commandButton>
								</td>
								</tr>
								
								<tr>
		                		<td></td>
		                		<td colspan="3">
		                		<a4j:commandButton id="btnCopyVendorAddress"
			                	action="#{navAction.navi}"	  
			                	reRender="panDataVendor"
			                	value="Copy Vendor Address" styleClass="rich-button"  
			                	style="width:145">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doCopyVendorAddress" />
								</a4j:commandButton>
								</td>
								</tr>
		                		<tr>
								<td align="right" valign="top">
		                		<h:panelGroup>
		                		<h:graphicImage value="images/icon_required.gif" />
		                		<rich:spacer width="5"></rich:spacer>
		                		<h:outputText value="ที่อยู่ 1 :" styleClass="ms7" />
		                		</h:panelGroup>
		                		</td>
		                		<td><h:inputText id="txtAddress1" value="#{semmel001Bean.payeeMaster.address1}" 
		                						 size="35" 
		                						 maxlength="35" /></td>
		                		<td align="right" valign="top">
		                		<h:panelGroup>
		                		<h:outputText value="ที่อยู่ 2:" styleClass="ms7" />
		                		</h:panelGroup>
		                		</td>
		                		<td><h:inputText id="txtAddress2" value="#{semmel001Bean.payeeMaster.address2}"
		                		                 size="35" 
		                		                 maxlength="35"/></td>
		                		</tr>
		                				                		
		                		<tr>
								<td align="right">
								<h:graphicImage value="images/icon_required.gif" />
		                		<rich:spacer width="5"></rich:spacer>
								<h:outputText value="City :" styleClass="ms7" />
								</td>
								<td><h:inputText id="txtCity" value="#{semmel001Bean.payeeMaster.city}"
												 maxlength="35"/></td>
		                		<td align="right">
		                			<!--<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			--><h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
		                		</td>
		                		<td><h:inputText id="txtPostcode" value="#{semmel001Bean.payeeMaster.postCode}"
		                						 maxlength="5"/></td>
								</tr>
								
		                		<tr>
								<td align="right"><h:outputText value="Contact Name :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtContactName" value="#{semmel001Bean.payeeMaster.contractName}"
				                				 maxlength="35"/></td>
				                <td align="right"> <h:outputText value="โทรศัพท์ :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtTelNo" value="#{semmel001Bean.payeeMaster.telephone}"
				                				 maxlength="15" /></td>
				                </tr>
		                		
		                		<tr>
								<td align="right"><h:outputText value="Mobile :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtMobileNo" value="#{semmel001Bean.payeeMaster.mobileNo}" 
				                				 maxlength="35"/></td>
				                <td align="right"> <h:outputText value="Fax :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtFaxNo" value="#{semmel001Bean.payeeMaster.fax}" 
				                				 maxlength="35"/></td>
				                </tr>
								
								<tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td><h:inputTextarea id="txtVendorRemark" value="#{semmel001Bean.payeeMaster.remark}" 
				                								 rows="3" cols="72">
				                					<f:validateLength maximum="255" ></f:validateLength>
		                					   </h:inputTextarea>
		                		</td>
		                		<td align="right"> <h:outputText value="สถานะ :" styleClass="ms7" /></td>
				                <td>
				                <h:selectOneMenu id="rbtStatus" value="#{semmel001Bean.payeeMaster.payeeStatus}" styleClass="ms7" 
				                				 disabled="true">
									<f:selectItems value="#{semmel001Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
				                
				                </tr>
		                	</table>
								</h:panelGroup>
							</h:panelGrid>
						
		            </rich:panel>
		            
		             <rich:panel id="panAccountVendor">
						<f:facet name="header">
							<h:outputText value="ข้อมูลค่าใช้จ่าย" />
						</f:facet>
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
								<tr>
	                			<td align="right" width="25%">
	                			<h:graphicImage value="images/icon_required.gif" />
	                			<rich:spacer width="5"></rich:spacer>
	                			<h:outputText value="เลขที่สัญญา:" styleClass="ms7" />
	                			</td>
								<td width="25%">
								<h:inputText id="txtContractNo"  value="#{popupSiteContractBean.contractNo}"
											 disabled="#{semmel001Bean.viewMode}">
								 <a4j:support event="onblur" action="#{popupSiteContractAction.getSiteInfoId}"  
								              reRender="cldEffDt,cldStrEffDt,cldEndExpireDt">
							     </a4j:support>
							     </h:inputText>
								<rich:spacer width="2"></rich:spacer>
								<a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
								value="..."  reRender="popupSearchContractNo,popupFrmSearch" 
				            	action="#{navAction.navi}" >
				            	<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
								<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
								<a4j:actionparam name="page" value="SEMMEL001-VMP-ADD-PAYEE" />
		            			</a4j:commandButton>
								</td>
								<td align="right" width="25%">
								<!-- ddlBankAccType -->
								<h:graphicImage value="images/icon_required.gif" />
								<rich:spacer width="5"></rich:spacer>
	                			<h:outputText value="ประเภทค่าใช้จ่าย :" styleClass="ms7" />
								</td>
			                	<td width="25%">
			                	<!-- ddlExpenseType -->
			                	<h:selectOneMenu id="ddlExpenseType" value="#{semmel001Bean.vendorMapPayee.expenseType}">
			                		<f:selectItems value="#{semmel001Bean.expenseTypeSelList}"/>
			                	</h:selectOneMenu>
								</td>
			                	</tr>
								
								<tr>
	                			<td align="right" width="20%">
	                			<h:graphicImage value="images/icon_required.gif" />
	                			<rich:spacer width="5"></rich:spacer>
	                			<h:outputText value="Effective Date:" styleClass="ms7" />
	                			</td>
								<td width="25%">
								<rich:calendar id="cldEffDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{popupSiteContractBean.defEffDate}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="Effective Date"
											   >
								</rich:calendar> 
								</td>
								<td align="right" width="20%">
								</td>
			                	<td width="35%">
								</td>
			                	</tr>
			                	
			                	<tr>
				                	<td align="right">
									<h:outputText value="วันที่เริ่มต้นสัญญา :" styleClass="ms7"/>
		                			</td>
		                			<td>
	                					<h:inputText id="cldStrEffDt" value="#{popupSiteContractBean.effDate}" disabled="true">
											<f:convertDateTime pattern="dd/MM/yyyy"/>
										</h:inputText> 
				                	</td>
				                	<td align="right">
									<h:outputText value="วันที่สิ้นสุดสัญญา :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                				<h:inputText id="cldEndExpireDt" value="#{popupSiteContractBean.expDate}" disabled="true">
											<f:convertDateTime pattern="dd/MM/yyyy"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right">
									<h:outputText value="วิธีชำระ :" styleClass="ms7" />
		                			</td>
		                			<td colspan="3"> 
			                		<h:selectOneRadio id="rbtVat" value="#{semmel001Bean.vendorMapPayee.paymentType}" styleClass="ms7">
										<f:selectItem itemLabel="เช็ค" itemValue="01" />
										<f:selectItem itemLabel="โอน"  itemValue="02" />
									</h:selectOneRadio>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
		                			<td align="right">
		                			<h:outputText value="ประเภทบัญชี :" styleClass="ms7" />
		                			</td>
									<td colspan="3">
									<!-- ddlBankAccountType -->
				                	<h:selectOneMenu id="ddlBankAccType" value="#{semmel001Bean.payeeBookBank.bankAccType}" >
				                		<f:selectItems value="#{semmel001Bean.bankAccountSelList}"/>
				                	</h:selectOneMenu>
									</td>
				                 </tr>
				                 
				                 <tr>
		                			<td align="right" width="20%"><h:outputText value="Bank Code :" styleClass="ms7" /></td>
									<td>
									<h:inputText id="txtBankCode"  value="#{semmel001Bean.payeeBookBank.bankCode}"
												 maxlength="10">
									<a4j:support event="onblur" action="#{navAction.navi}" reRender="panAccountVendor">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="queryBankByCode" />
									</a4j:support>
									</h:inputText>
									<rich:spacer width="2"></rich:spacer>
		                			<a4j:commandButton id="btnPopupSearchBankCode"  oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
									value="..."   
				            		action="#{navAction.navi}"
				            		reRender="dtbBankSel" >
				            		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
		            				</a4j:commandButton>
									</td>
									<td align="right"><h:outputText value="ธนาคาร :" styleClass="ms7" /></td>
				                	<td><h:inputText id="txtBankName"  value="#{semmel001Bean.ct001SrchMSP.bankName}" 
				                					 maxlength="20" style="width:200" /></td>
				                 </tr>
			                	 
			                	 <tr>
		                			<td align="right" width="20%"><h:outputText value="สาขา :" styleClass="ms7" /></td>
									<td><h:inputText id="txtBankBranch"  value="#{semmel001Bean.ct001SrchMSP.bankBranch}" 
													 maxlength="50" style="width:200"/></td>
									<td align="right"><h:outputText value="จังหวัด :" styleClass="ms7" /></td>
				                	<td>
				                	<!-- ddlProvince -->
				                	<h:selectOneMenu id="ddlBankProvince" value="#{semmel001Bean.ct001SrchMSP.bankProvince}" >
				                		<f:selectItems value="#{semmel001Bean.provinceSelList}"/>
				                	</h:selectOneMenu>
				                	</td>
				                 </tr>
				                 
				                 <tr>
		                			<td align="right" width="20%"><h:outputText value="เลขที่บัญชี :" styleClass="ms7" /></td>
									<td><h:inputText id="txtBankAccNo"  value="#{semmel001Bean.payeeBookBank.bankAccNo}" 
													 maxlength="50"
													 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/></td>
									<td align="right"><h:outputText value="ชื่อบัญชี :" styleClass="ms7" /></td>
				                	<td><h:inputText id="txtBankAccName"  value="#{semmel001Bean.payeeBookBank.bankAccName}" 
				                					 maxlength="50"/></td>
				                 </tr>
				                 
				                <tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td colspan="3"><h:inputTextarea id="txtBookBankRemark" value="#{semmel001Bean.payeeBookBank.remark}" 
				                								 rows="3" cols="72">
				                								 <f:validateLength maximum="255" ></f:validateLength>
		                						</h:inputTextarea>
		                		</td>
				                </tr>
				                
								</table>
							</h:panelGroup>
							</h:panelGrid>
		            </rich:panel>
		             
					
				</h:panelGrid>
			</a4j:form>		
        </h:panelGrid>
        </rich:panel>
        <!-- pop up -->
    	<jsp:include page="../../pages/popup/sitecontract-popup.jsp"/>
    	<jsp:include page="../../pages/el/semmel001-vmp-add-popup.jsp"/>
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
						<h:outputText value="#{semmrt008Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbPayee" >
							<a4j:actionparam name="navModule" value="el" />
           					<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSavePayeeInfo" />
							<a4j:actionparam name="modePanelInfo" value="DELETE" />
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


