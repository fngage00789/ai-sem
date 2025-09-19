<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid width="100%">
	<rich:panel id="pnlPayeeMaster">
		<f:facet name="header">
			<h:outputText  id="outTxtDisplayMode" value="บันทึกผู้รับเงิน  - #{semmct001Bean.actModeDisplay}" />
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
				            action="#{navAction.navi}" reRender="oppContent" immediate="true"
				            rendered="#{semmct001Bean.renderedBackBtn}" >
		            		<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="mode" value="#{(semmct001Bean.mode == 'INSERT')?'UPDATE':semmct001Bean.mode}" />
							<a4j:actionparam name="rowId" value="#{semmct001Bean.vendorMaster.rowId}" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnBackCrossPage" value="Back" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent" immediate="true" 
				            rendered="#{semmct001Bean.renderedBackCrossPageBtn}">
		            		<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
							<a4j:actionparam name="methodWithNavi" value="pageLoadCrossBean" />
							<a4j:actionparam name="mode" value="SELECT" />
							<a4j:actionparam name="rowId" value="#{semmct001Bean.vendorMaster.rowId}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent,btnSave,pnlPayeeMaster"
				            rendered="#{!semmct001Bean.viewMode}"
				            disabled="#{semmct001Bean.disableSavePayeeBtn}">
				            <a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doSavePayeeMaster" />
							<a4j:actionparam name="mode" value="#{semmct001Bean.mode}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent"
				            rendered="#{!semmct001Bean.viewMode}">
				            <a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
			                		<td width="25%"><a4j:region>
			                						<h:inputText id="txtPayeeName" value="#{semmct001Bean.payeeMaster.payeeName}" 
			                									 size="50" 
			                									 maxlength="150" disabled="#{semmct001Bean.viewMode}">
			                						</h:inputText>
			                						</a4j:region>
			                		</td>
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
			                		<td><h:inputText id="txtIdCard" value="#{semmct001Bean.payeeMaster.idCard}" 
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 maxlength="13" disabled="#{semmct001Bean.viewMode}"/></td>
			                		<td align="right">
			                		<h:panelGroup>
			                		<h:outputText value="เลขประจำตัวผู้เสียภาษี :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td>
			                			<h:inputText id="txtTaxId13" value="#{semmct001Bean.payeeMaster.taxId13}"
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 maxlength="13" disabled="#{semmct001Bean.viewMode}" ></h:inputText>
			                			<h:inputHidden id="txtTaxId" value="#{semmct001Bean.payeeMaster.taxId}"></h:inputHidden></td>
		                		</tr>
		                		<tr>
		                		<td align="right" colspan="3">
			                		
			                		</td>
			                		<td></td>
		                		</tr>
		                		<tr>
		                		<td></td>
		                		<td colspan="3">
		                		<a4j:commandButton id="btnCheckPayee"
			                	action="#{navAction.navi}"	  
			                	reRender="oppContent"
			                	value="Check Payee" styleClass="rich-button"  
			                	style="width:110"
			                	oncomplete="if(#{semmct001Bean.renderedSelectPayeePopup == 'true'})#{rich:component('popupFrmSelectPayee')}.show(); return false" 
			                	rendered="#{!semmct001Bean.viewMode}">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
								<a4j:actionparam name="methodWithNavi" value="doCheckPayee" />
								</a4j:commandButton>
								</td>
								</tr>
								
								<tr>
		                		<td></td>
		                		<td colspan="3">
		                		<a4j:commandButton id="btnCopyVendorAddress"
			                	action="#{navAction.navi}"	  
			                	reRender="oppContent,panDataVendor"
			                	value="Copy Vendor Address" styleClass="rich-button"  
			                	style="width:145" rendered="#{!semmct001Bean.viewMode}">
								<a4j:actionparam name="navModule" value="gm" />
								<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
		                		<td><h:inputText id="txtAddress1" value="#{semmct001Bean.payeeMaster.address1}" 
		                						 size="35" 
		                						 maxlength="35" disabled="#{semmct001Bean.viewMode}"/></td>
		                		<td align="right" valign="top">
		                		<h:panelGroup>
		                		<h:outputText value="ที่อยู่ 2:" styleClass="ms7" />
		                		</h:panelGroup>
		                		</td>
		                		<td><h:inputText id="txtAddress2" value="#{semmct001Bean.payeeMaster.address2}"
		                		                 size="35" 
		                		                 maxlength="35" disabled="#{semmct001Bean.viewMode}"/></td>
		                		</tr>
		                		
		                		<tr>
								<td align="right">
									
									<h:outputText value="ตำบล :" styleClass="ms7" />
								</td>
								<td>
												                	
				                	<!-- >> -->
			                			<h:panelGroup id="mstDistrict1">
				                			<h:selectOneMenu id="ddlVendorDistrict" value="#{semmct001Bean.payeeMaster.districtCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderPayeeDistrictFreeFill}" onchange="mst_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="mst_getDistrictNameJS" reRender="txtVendorPostCode,txtVendorDistrictFreeFill,mstAmphur2" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="PAYEE" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="mstDistrict2">
			                				<h:inputText id="txtVendorDistrictFreeFill" value="#{semmct001Bean.payeeMaster.district}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderPayeeDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="mst_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderPayeeDistrictFreeFill}"
											onclick="mst_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderMstAmphurFreeFill}"/>
											
											<a4j:jsFunction name="mst_renderDistrictFreeFillJS" reRender="mstDistrict1, mstDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="PAYEE" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
								</td>
		                		<td align="right">
		                			<!--<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			--><h:outputText value="อำเภอ :" styleClass="ms7" />
		                		</td>
		                		<td>
		                			
				                		<h:panelGroup id="mstAmphur1">
				                			<h:selectOneMenu id="ddlPayeeAmphur" value="#{semmct001Bean.payeeMaster.amphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderPayeeAmphurFreeFill}" onchange="payee_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.ampSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="payee_getDistrictListJS" reRender="ddlVendorDistrict,txtPayeeAmphurFreeFill,mstAmphur2" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="PAYEE" />
		                                    </a4j:jsFunction>
	                               		</h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="mstAmphur2">
		                                    <h:inputText id="txtPayeeAmphurFreeFill" value="#{semmct001Bean.payeeMaster.amphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderPayeeAmphurFreeFill}" size="18" maxlength="255" />
		                                   
		                                    <h:selectBooleanCheckbox id="mst_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderPayeeAmphurFreeFill}"
											onclick="mst_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											
											<a4j:jsFunction name="mst_renderAmphurFreeFillJS" reRender="mstAmphur1, mstAmphur2, mstDistrict1, mstDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="PAYEE" />
											</a4j:jsFunction>
											
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
		                		</td>
								</tr>		                		
		                		<tr>
								<td align="right">
									<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
									<h:outputText value="จังหวัด :" styleClass="ms7" />
								</td>
								<td>
									<h:selectOneMenu id="ddlVendorProvince" value="#{semmct001Bean.payeeMaster.cityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="mst_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provSelList}"/>
	                                    </h:selectOneMenu> 
	                                    <a4j:jsFunction name="mst_getAmphurListJS" reRender="ddlPayeeAmphur, ddlVendorDistrict, txtVendorPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="PAYEE" />
	                                    </a4j:jsFunction>
								</td>
		                		<td align="right">
		                			<!--<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			--><h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
		                		</td>
		                		<td>
		                			<h:inputText id="txtVendorPostCode" value="#{semmct001Bean.payeeMaster.postCode}"
		                						 maxlength="5" disabled="#{semmct001Bean.viewMode}"/>
		                		</td>
								</tr>
								
		                		<tr>
								<td align="right"><h:outputText value="Contact Name :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtContactName" value="#{semmct001Bean.payeeMaster.contractName}"
				                				 maxlength="35" disabled="#{semmct001Bean.viewMode}"/></td>
				                <td align="right"> <h:outputText value="โทรศัพท์ :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtTelNo" value="#{semmct001Bean.payeeMaster.telephone}"
				                				 maxlength="255" disabled="#{semmct001Bean.viewMode}" /></td>
				                </tr>
		                		
		                		<tr>
								<td align="right"><h:outputText value="Mobile :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtMobileNo" value="#{semmct001Bean.payeeMaster.mobileNo}" 
				                				 maxlength="255" disabled="#{semmct001Bean.viewMode}"/></td>
				                <td align="right"> <h:outputText value="Fax :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtFaxNo" value="#{semmct001Bean.payeeMaster.fax}" 
				                				 maxlength="255" disabled="#{semmct001Bean.viewMode}"/></td>
				                </tr>
								<tr>
                                <td align="right" valign="top"></td>
                                <td>
                                </td>
                                <td align="right"> <h:outputText value="E-Mail :" styleClass="ms7" /></td>
                                <td>
                                <h:inputText id="txtEmail2" value="#{semmct001Bean.payeeMaster.email}" 
                                                             disabled="#{semmct001Bean.viewMode}"
                                                             maxlength="255"/>
                                
                                </tr>
								<tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td><h:inputTextarea id="txtVendorRemark" value="#{semmct001Bean.payeeMaster.remark}" 
				                								 rows="3" cols="50" disabled="#{semmct001Bean.viewMode}">
				                					<f:validateLength maximum="255" ></f:validateLength>
		                					   </h:inputTextarea>
		                		</td>
		                		<td align="right"> <h:outputText value="สถานะ :" styleClass="ms7" /></td>
				                <td>
				                <h:selectOneMenu id="rbtStatus" value="#{semmct001Bean.payeeMaster.payeeStatus}" styleClass="ms7" 
				                				 disabled="true">
									<f:selectItems value="#{semmct001Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
				                
				                </tr>
		                	</table>
								</h:panelGroup>
							</h:panelGrid>
						
		            </rich:panel>
		            
		             <rich:panel id="panAccountPayee">
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
											 disabled="#{semmct001Bean.viewMode}" >
								 <a4j:support event="onblur" action="#{popupSiteContractAction.getSiteInfoId}"  
								              reRender="cldEffDt,cldStrEffDt,cldEndExpireDt,txtContractNo">
							     </a4j:support>
							     </h:inputText>
								<rich:spacer width="2"></rich:spacer>
								<a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
								value="..."  reRender="popupSearchContractNo,popupFrmSearch" 
				            	action="#{navAction.navi}" rendered="#{!semmct001Bean.viewMode}" >
				            	<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
								<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
								<a4j:actionparam name="page" value="semmct001-3" />
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
			                	<h:selectOneMenu id="ddlExpenseType" value="#{semmct001Bean.vendorMapPayee.expenseType}" disabled="#{semmct001Bean.viewMode}">
			                		<f:selectItems value="#{semmct001Bean.expenseTypeSelList}"/>
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
											   disabled="#{semmct001Bean.viewMode}"
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
		                			<a4j:region>
			                		<h:selectOneRadio id="rbtVat" value="#{semmct001Bean.vendorMapPayee.paymentType}" styleClass="ms7"
			                						  onclick="defaultPayeeBankName();" disabled="#{semmct001Bean.viewMode}">
										<f:selectItem itemLabel="เช็ค" itemValue="01" />
										<f:selectItem itemLabel="โอน"  itemValue="02" />
									</h:selectOneRadio>
									<a4j:jsFunction name="defaultPayeeBankName" action="#{semmct001Action.copyPayeeNameToPayeeBookBankAccName}"
													reRender="panAccountPayee"></a4j:jsFunction>
									</a4j:region>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
		                			<td align="right">
		                			<h:outputText value="ประเภทบัญชี :" styleClass="ms7" />
		                			</td>
									<td colspan="3">
									<!-- ddlBankAccountType -->
				                	<h:selectOneMenu id="ddlBankAccType" value="#{semmct001Bean.payeeBookBank.bankAccType}" disabled="#{semmct001Bean.viewMode}" >
				                		<f:selectItems value="#{semmct001Bean.bankAccountSelList}"/>
				                	</h:selectOneMenu>
									</td>
				                 </tr>
				                 
				                 <tr>
		                			<td align="right" width="20%"><h:outputText value="Bank Code :" styleClass="ms7" /></td>
									<td>
									<h:inputText id="txtBankCode"  value="#{semmct001Bean.payeeBookBank.bankCode}"
												 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
												 maxlength="7" disabled="#{semmct001Bean.viewMode}">
									<a4j:support event="onblur" action="#{navAction.navi}" reRender="panAccountPayee">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="queryBankByCode" />
									</a4j:support>
									</h:inputText>
									<rich:spacer width="2"></rich:spacer>
		                			<a4j:commandButton id="btnPopupSearchBankCode"  oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
									value="..."   
				            		action="#{navAction.navi}"
				            		reRender="dtbBankSel" rendered="#{!semmct001Bean.viewMode}">
				            		<a4j:actionparam name="navModule" value="gm" />
									<a4j:actionparam name="navProgram" value="SEMMCT001-3" />
									<a4j:actionparam name="moduleWithNavi" value="gm" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
									<a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
		            				</a4j:commandButton>
									</td>
									<td align="right"><h:outputText value="ธนาคาร :" styleClass="ms7" /></td>
				                	<td><h:inputText id="txtBankName"  value="#{semmct001Bean.ct001SrchMSP.bankName}" 
				                					 maxlength="100" style="width:200" disabled="#{semmct001Bean.disabledBankInfo || semmct001Bean.viewMode}" /></td>
				                 </tr>
			                	 
			                	 <tr>
		                			<td align="right" width="20%"><h:outputText value="สาขา :" styleClass="ms7" /></td>
									<td>
									   <h:inputTextarea id="txtBankBranch" value="#{semmct001Bean.ct001SrchMSP.bankBranch}" rows="3" cols="50"
                                              disabled="#{semmct001Bean.disabledBankInfo || semmct001Bean.viewMode}" 
                                              >
                                              <f:validateLength maximum="255" ></f:validateLength>
                                        </h:inputTextarea>
									</td>
									<td align="right"><h:outputText value="จังหวัด :" styleClass="ms7" /></td>
				                	<td>
				                	<!-- ddlProvince -->
				                	<h:selectOneMenu id="ddlBankProvince" value="#{semmct001Bean.ct001SrchMSP.bankProvince}" disabled="#{semmct001Bean.viewMode}" >
				                		<f:selectItems value="#{semmct001Bean.provinceSelList}"/>
				                	</h:selectOneMenu>
				                	</td>
				                 </tr>
				                 
				                 <tr>
		                			<td align="right" width="20%"><h:outputText value="เลขที่บัญชี :" styleClass="ms7" /></td>
									<td>
										<h:inputText id="txtBankAccNo"  value="#{semmct001Bean.payeeBookBank.bankAccNo}" 
										 maxlength="15"
										 onkeypress="return numberformat.keyPressIntegerOnly(this, event);" disabled="#{semmct001Bean.viewMode}">
										 	<a4j:support event="onblur" action="#{semmct001Action.copyPayeeNameToPayeeBookBankAccName}"
              									 reRender="txtBankAccName"/>
										 </h:inputText>
									</td>
									<td align="right"><h:outputText value="ชื่อบัญชี :" styleClass="ms7" /></td>
				                	<td>
				                		<a4j:region>
				                		<h:inputText id="txtBankAccName"  value="#{semmct001Bean.payeeBookBank.bankAccName}" 
				                					 maxlength="50" disabled="#{semmct001Bean.viewMode}">
				                		</h:inputText>
				                		</a4j:region>
				                	</td>
				                 </tr>
				                 
				                <tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td colspan="3"><h:inputTextarea id="txtBookBankRemark" value="#{semmct001Bean.payeeBookBank.remark}" 
				                								 rows="3" cols="72" disabled="#{semmct001Bean.viewMode}">
				                								 <f:validateLength maximum="255" ></f:validateLength>
		                						</h:inputTextarea>
		                		</td>
				                </tr>
				                
				                 <tr>
								<td colspan="4">
									<a4j:commandButton id="btnDeleteBookBank" value="Delete BookBank" styleClass="rich-button" 
									style="width:120"
						            action="#{navAction.navi}" reRender="oppContent"
						            oncomplete="#{rich:component('mdpConfirmDelBookBankDialog0013')}.show(); return false"
						            rendered="#{!semmct001Bean.viewMode}">
									</a4j:commandButton>
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
    	<jsp:include page="../../pages/gm/semmct001-popup.jsp"/>
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
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
<rich:modalPanel id="mdpConfirmDelBookBankDialog0013" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelBookBankDialog0013">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="185px">
						<h:outputText value="#{semmct001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="frmSave" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doDeletePayeeBookBank" />
							<a4j:actionparam name="mode" value="DELETE" />
							<rich:componentControl for="mdpConfirmDelBookBankDialog0013" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelBookBankDialog0013" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

