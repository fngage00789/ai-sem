<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel001-vmp-add" var="jspMsg" />
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlVendorMaster">
		<f:facet name="header">
			<h:outputText id="outTxtDisplayMode" value="Vendor Master - #{semmel001Bean.actModeDisplay}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorTop">
				<rich:messages errorClass="ms7red" warnClass="ms7blue"
						    infoClass="ms7green" 
							rendered="#{semmel001Bean.renderedMsgFormTop}" >
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
							<h:commandButton id ="btnExport" action="#{semmct001Action.doExportExcel}"  
         					styleClass="rich-button" value="Export" rendered="#{!semmel001Bean.viewMode}">
         					<a4j:support event="onclick" oncomplete="test();" />
         					<a4j:jsFunction name="test" reRender="btnBack"></a4j:jsFunction>
         					</h:commandButton>
           					</td>
							<td>
							<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent" >
		            		<a4j:actionparam name="navModule" value="#{semmel001Bean.navModuleFrom}" />
							<a4j:actionparam name="navProgram" value="#{semmel001Bean.navProgramFrom}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmel001Bean.navModuleFrom}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmel001Bean.actionWithNaviFrom}" />
							<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
							<a4j:actionparam name="mode" value="SELECT" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent,btnSave,pnlVendorMaster" rendered="#{!semmel001Bean.viewMode}">
				            <a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSaveVendorMaster" />
							<a4j:actionparam name="mode" value="#{semmel001Bean.mode}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent" 
				            rendered="#{!semmel001Bean.viewMode}">
				            <a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
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
								<h:outputText value="ข้อมูล Vendor" />
							</f:facet>
						
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
									<h:panelGroup>
		                			<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="Vendor Type :" styleClass="ms7" />
		                			</h:panelGroup>
		                			</td>
		                			<td colspan="3" width="75%">
		                			<!-- ddlVendorType -->
				                	 <h:selectOneMenu id="ddlVendorType" value="#{semmel001Bean.vendorMaster.vendorType}" 
				                	 				  disabled="#{semmel001Bean.viewMode}">
			                			<f:selectItems value="#{semmel001Bean.vendorTypeStatus}"/>
			                			<a4j:support event="onchange" action="#{navAction.navi}" reRender="panDataVendor">
					                		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="checkRequired" />
				                		</a4j:support>
			                		</h:selectOneMenu>
				                	 </td>
			                	 </tr>
								
								<tr>
									<td align="right">
									<h:panelGroup>
		                			<h:outputText value="Vendor Code :" styleClass="ms7" />
		                			</h:panelGroup>
		                			</td>
		                			<td colspan="3">
									<h:inputText id="txtVendorCode" value="#{semmel001Bean.vendorMaster.vendorCode}" readonly="true" disabled="#{semmel001Bean.viewMode}"></h:inputText>
									</td>
								</tr>
								
								<tr>
									<td align="right" width="25%">
									<h:panelGroup>
			                		<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="ชื่อ Vendor1 :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%"><h:inputText id="txtVendorName1" value="#{semmel001Bean.vendorMaster.vendorName1}"
			                									 disabled="#{semmel001Bean.viewMode}" 
			                									 size="35"  maxlength="35"/></td>
									<td align="right" width="25%"><h:outputText value="ชื่อ Vendor2 :" styleClass="ms7" /></td>
			                		<td width="25%"><h:inputText id="txtVendorName2" value="#{semmel001Bean.vendorMaster.vendorName2}" 
			                									 disabled="#{semmel001Bean.viewMode}"
			                									 size="35" maxlength="35"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="25%">
			                		<h:outputText value="ชื่อ Vendor3 :" styleClass="ms7" />
			                		</td>
			                		<td width="25%"><h:inputText id="txtVendorName3" value="#{semmel001Bean.vendorMaster.vendorName3}"
			                									 disabled="#{semmel001Bean.viewMode}" 
			                									 size="35" maxlength="35"/></td>
									<td align="right" width="25%"><h:outputText value="ชื่อ Vendor4 :" styleClass="ms7" /></td>
			                		<td width="25%"><h:inputText id="txtVendorName4" value="#{semmel001Bean.vendorMaster.vendorName4}" 
			                									 disabled="#{semmel001Bean.viewMode}"
			                									 size="35" maxlength="35"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right">
				                	<h:panelGroup id="panelIdCard">
			                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.renderedRequireIdCard}"/>
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="เลขประจำตัวประชาชน :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td><h:inputText id="txtIdCard" 
			                						 value="#{semmel001Bean.vendorMaster.idCard}" 
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 maxlength="13"
			                						 disabled="#{semmel001Bean.viewMode}"/></td>
			                		<td align="right">
			                		<h:panelGroup id="panelTaxId">
			                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.renderedRequireTaxId}" />
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="เลขประจำตัวผู้เสียภาษี :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td><h:inputText id="txtTaxId" 
			                						 value="#{semmel001Bean.vendorMaster.taxId}" 
			                						 maxlength="15"
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 disabled="#{semmel001Bean.viewMode}"></h:inputText></td>
		                		</tr>
		                		<tr>
		                		<td></td>
		                		<td colspan="3">
		                		<a4j:commandButton id="btnCheckVendor"
			                	action="#{navAction.navi}"	  
			                	reRender="oppContent"
			                	value="#{jspMsg['btn.checkVendor']}" styleClass="rich-button"  
			                	style="width:110"
			                	oncomplete="if(#{semmel001Bean.renderedSelectVendorPopup == 'true'})#{rich:component('popupFrmSelectVendor')}.show(); return false" 
			                	disabled="#{semmel001Bean.viewMode}">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doCheckVendor" />
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
		                		<td><h:inputText id="txtAddress1" value="#{semmel001Bean.vendorMaster.address1}" size="36" 
		                							 disabled="#{semmel001Bean.viewMode}"
		                							 maxlength="35"/></td>
		                		<td align="right" valign="top">
		                		<h:panelGroup>
		                		<h:outputText value="ที่อยู่ 2:" styleClass="ms7" />
		                		</h:panelGroup>
		                		</td>
		                		<td><h:inputText id="txtAddress2" value="#{semmel001Bean.vendorMaster.address2}" size="36"
		                							 disabled="#{semmel001Bean.viewMode}"
		                							 maxlength="35"/></td>
		                		</tr>		                		
		                			                		
		                		<tr>
								<td align="right">
								<!--<h:graphicImage value="images/icon_required.gif" />
		                		<rich:spacer width="5"></rich:spacer>
								<h:outputText value="City :" styleClass="ms7" />
		                		-->
		                		<h:panelGroup>
		                		<h:graphicImage value="images/icon_required.gif" />
		                		<rich:spacer width="5"></rich:spacer>
		                		<h:outputText value="จังหวัด :" styleClass="ms7" />
		                		</h:panelGroup>
								</td>
								<td>
								<h:inputText id="txtProvinceVendorInfo" value="#{semmel001Bean.vendorMaster.city}" 
											 disabled="#{semmel001Bean.viewMode}"
											 rendered="#{semmel001Bean.pTaxFlag==false}"
											 maxlength="35"/>
		                		<!-- ddlProvince -->
			                	<h:selectOneMenu id="ddlProvinceVendorInfo" value="#{semmel001Bean.vendorMaster.province}"
			                					 disabled="#{semmel001Bean.viewMode}"
			                	                 rendered="#{semmel001Bean.pTaxFlag}" >
			                		<f:selectItems value="#{semmel001Bean.provinceSelList}"/>
			                	</h:selectOneMenu>
			                	<rich:spacer width="5"></rich:spacer>
			                	<h:selectBooleanCheckbox id="chkPTaxFlag"  value="#{semmel001Bean.pTaxFlag}" disabled="#{semmel001Bean.viewMode}">
									<a4j:support event="onclick"  reRender="frmSave">
									</a4j:support>
									
								</h:selectBooleanCheckbox>
								<rich:spacer width="5"></rich:spacer>
								<h:outputLabel value="หน่วยงานท้องถิ่น" styleClass="ms7"></h:outputLabel>
								</td>
		                		<td align="right">
		                		<!--<h:graphicImage value="images/icon_required.gif" />
		                		<rich:spacer width="5"></rich:spacer>
		                		--><h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" /></td>
		                		<td><h:inputText id="txtPostcode" value="#{semmel001Bean.vendorMaster.postCode}"
		                						 disabled="#{semmel001Bean.viewMode}"
		                						 maxlength="5"></h:inputText></td>
								</tr>
		                		
		                		<tr>
								<td align="right"><h:outputText value="Contact Name :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtContactName" value="#{semmel001Bean.vendorMaster.contactName}"
				                				 disabled="#{semmel001Bean.viewMode}"
				                				 maxlength="35"/></td>
				                <td align="right"> <h:outputText value="โทรศัพท์ :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtTelNo" value="#{semmel001Bean.vendorMaster.telephone}" 
				                				 disabled="#{semmel001Bean.viewMode}"
				                				 maxlength="15"/></td>
				                </tr>
		                		
		                		<tr>
								<td align="right"><h:outputText value="Mobile :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtMobileNo" value="#{semmel001Bean.vendorMaster.mobileNo}" 
				                				 disabled="#{semmel001Bean.viewMode}"
				                				 maxlength="35"/></td>
				                <td align="right"> <h:outputText value="Fax :" styleClass="ms7" /></td>
				                <td><h:inputText id="txtFaxNo" value="#{semmel001Bean.vendorMaster.fax}" 
				                				 disabled="#{semmel001Bean.viewMode}"
				                				 maxlength="35"/></td>
				                </tr>
								
								<tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td><h:inputTextarea id="txtVendorRemark" value="#{semmel001Bean.vendorMaster.remark}" rows="3" cols="72"
																 disabled="#{semmel001Bean.viewMode}" 
																 label="หมายเหตุ" >
		                							<f:validateLength maximum="255" ></f:validateLength>
		                						</h:inputTextarea>
		                		</td>
		                		<td align="right"> <h:outputText value="สถานะ :" styleClass="ms7" /></td>
				                <td>
				                 <h:selectOneMenu id="rbtStatus" value="#{semmel001Bean.vendorMaster.vendorStatus}" 
			                					  disabled="true" >
									<f:selectItems value="#{semmel001Bean.vendorStatusSelList}"/>
								</h:selectOneMenu>
				                 </td>
				                </tr>
		                	</table>
								</h:panelGroup>
							</h:panelGrid>
						
		            </rich:panel>
		            
		             <rich:panel id="panAccountVendor">
						<f:facet name="header">
							<h:outputText value="ข้อมูลค่าใช้จ่าย (Vendor)" />
						</f:facet>
						<h:panelGrid>
						<h:messages errorClass="ms7red" warnClass="ms7blue"
								    infoClass="ms7green" globalOnly="true"
									rendered="#{semmel001Bean.renderedMsgFormMiddle}" />
						</h:panelGrid>
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
				            	action="#{navAction.navi}" rendered="#{!semmel001Bean.viewMode}">
				            	<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
								<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
								<a4j:actionparam name="page" value="semmct001-2" />   
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
			                	<h:selectOneMenu id="ddlExpenseType" value="#{semmel001Bean.vendorMapPayee.expenseType}" 
			                					 disabled="#{semmel001Bean.viewMode}">
			                		<f:selectItems value="#{semmel001Bean.expenseTypeSelList}"/>
			                		<a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" reRender="cldStrEffDt,cldEndExpireDt">
							   		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="doGetVendorMapPayeeInfo" />
							     </a4j:support>
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
											   disabled="#{semmel001Bean.viewMode}">
											   
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
			                		<h:selectOneRadio id="rbtVat" value="#{semmel001Bean.vendorMapPayee.paymentType}" 
			                						  disabled="#{semmel001Bean.viewMode}" styleClass="ms7">
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
				                	<h:selectOneMenu id="ddlBankAccType" value="#{semmel001Bean.vendorBookBank.bankAccType}" 
				                					 disabled="#{semmel001Bean.viewMode}">
				                		<f:selectItems value="#{semmel001Bean.bankAccountSelList}"/>
				                	</h:selectOneMenu>
									</td>
				                 </tr>
				                 
				                 <tr>
		                			<td align="right" width="20%"><h:outputText value="Bank Code :" styleClass="ms7" /></td>
									<td>
									<h:inputText id="txtBankCode_2"  value="#{semmel001Bean.vendorBookBank.bankCode}"
												 disabled="#{semmel001Bean.viewMode}"
												 maxlength="10">
									<a4j:support event="onblur" action="#{navAction.navi}" reRender="panAccountVendor">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="queryBankByCode" />
									</a4j:support>
									
									</h:inputText>
									<rich:spacer width="2"></rich:spacer>
		                			<a4j:commandButton id="btnPopupSearchBankCode"  oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
									value="..."   
				            		action="#{navAction.navi}"
				            		reRender="popupFrmSelectBank,frmSelectBank" 
				            		disabled="#{semmel001Bean.viewMode}">
				            		<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
		            				</a4j:commandButton>
									</td>
									<td align="right"><h:outputText value="ธนาคาร :" styleClass="ms7" /></td>
				                	<td><h:inputText id="txtBankName_2"  value="#{semmel001Bean.ct001SrchMSP.bankName}" 
				                					 style="width:200"
				                					 maxlength="50"
				                					 disabled="#{semmel001Bean.viewMode}"/></td>
				                 </tr>
			                	 
			                	 <tr>
		                			<td align="right" width="20%"><h:outputText value="สาขา :" styleClass="ms7" /></td>
									<td><h:inputText id="txtBankBranch_2"  value="#{semmel001Bean.ct001SrchMSP.bankBranch}" 
													 style="width:200"
													 maxlength="50"
													 disabled="#{semmel001Bean.viewMode}"/></td>
									<td align="right"><h:outputText value="จังหวัด :" styleClass="ms7" /></td>
				                	<td>
				                	<!-- ddlProvince -->
				                	<h:selectOneMenu id="ddlBankProvince_2" value="#{semmel001Bean.ct001SrchMSP.bankProvince}" 
				                					 disabled="#{semmel001Bean.viewMode}">
				                		<f:selectItems value="#{semmel001Bean.provinceSelList}"/>
				                	</h:selectOneMenu>
				                	</td>
				                 </tr>
				                 
				                  <tr>
		                			<td align="right" width="20%"><h:outputText value="เลขที่บัญชี :" styleClass="ms7" /></td>
									<td><h:inputText id="txtBankAccNo"  value="#{semmel001Bean.vendorBookBank.bankAccNo}" 
													 disabled="#{semmel001Bean.viewMode}"
													 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													 maxlength="25"/></td>
									<td align="right"><h:outputText value="ชื่อบัญชี :" styleClass="ms7" /></td>
				                	<td><h:inputText id="txtBankAccName"  value="#{semmel001Bean.vendorBookBank.bankAccName}"
				                					 disabled="#{semmel001Bean.viewMode}" 
				                					 maxlength="255"/></td>
				                  </tr>
				                 
				                <tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td colspan="3"><h:inputTextarea id="txtBookBankRemark" value="#{semmel001Bean.vendorBookBank.remark}" rows="3" cols="72"
				                								 disabled="#{semmel001Bean.viewMode}" 
				                								  label="หมายเหตุ" >
		                							<f:validateLength maximum="255" ></f:validateLength>
		                						</h:inputTextarea>
		                		</td>
				                </tr>
				                
				                <tr>
								<td colspan="4">
									<a4j:commandButton id="btnSaveVendorMaster" value="Save" styleClass="rich-button" 
						            action="#{navAction.navi}" reRender="oppContent" rendered="#{!semmel001Bean.viewMode}">
						            <a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="doSaveVendorMaster" />
									<a4j:actionparam name="mode" value="#{semmel001Bean.mode}" />
									</a4j:commandButton>
									<rich:spacer width="2"></rich:spacer>
									<a4j:commandButton id="btnClearExpenseInfo" value="Clear" styleClass="rich-button" 
						            action="#{navAction.navi}" reRender="oppContent" rendered="#{!semmel001Bean.viewMode}">
						            <a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="doClearClearExpenseInfo" />
									</a4j:commandButton>
								</td>
				                </tr>
								</table>
							</h:panelGroup>
							</h:panelGrid>
		            </rich:panel>
		            
					<rich:panel id="panAccountList">
					<f:facet name="header">
						<h:outputText value="รายการเลขที่บัญชี" />
					</f:facet>
					<h:panelGrid  width="90%"  border="0" cellpadding="0" cellspacing="0">
						<h:panelGroup>
						<table width="100%" border="0">
						<tr>
						<td align="left">
							<a4j:commandButton id="btnAddAlterNative"  styleClass="rich-button" 
						    action="#{navAction.navi}" value="Add Alternative Payee"  
						    reRender="oppContent" style="width:135"
						    disabled="#{semmel001Bean.disabledButtonAddAlter}"
						    rendered="#{!semmel001Bean.viewMode}">
								<a4j:actionparam name="navModule" value="el" />
				        		<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />	
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
								<a4j:actionparam name="mode" value="INSERT" />
								<a4j:actionparam name="eventType" value="Add" />
							</a4j:commandButton>
							<rich:spacer width="5"></rich:spacer>
							<a4j:commandButton id="btnAgree"  styleClass="rich-button" 
						    action="#{navAction.navi}" value="ส่งรายการ อนุมัติ"  reRender="dtbPayee,frmSave" style="width:100"
						    rendered="#{!semmel001Bean.viewMode}">
								<a4j:actionparam name="navModule" value="el" />
				        		<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doApprove" />
							</a4j:commandButton>
						</td>
						</tr>
						<tr>
						<td align="left">
							<h:messages errorClass="ms7red" warnClass="ms7blue"
										infoClass="ms7green" globalOnly="true"
										rendered="#{semmel001Bean.renderedMsgFormBottom}" />
						</td>
						</tr>
						<tr>
						<td align="left">
							<rich:dataTable width="99%" id="dtbPayee" cellpadding="0" 
									cellspacing="0" border="0" var="payee" 
									value="#{semmel001Bean.ct001SrchMSPList}" reRender="dstPayee" 
									rows="#{semmel001Bean.rowPerPage}" onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
									rowClasses="cur" 
									styleClass="contentform">
								<rich:column rendered="#{!semmel001Bean.viewMode}">
									<f:facet name="header">
										<h:selectBooleanCheckbox value="#{semmel001Bean.chkSelAll}">
											<a4j:support event="onclick" action="#{semmel001Action.selectAllRow}" reRender="dtbPayee"/>
										</h:selectBooleanCheckbox>
									</f:facet>
									<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{payee.checkBox}">
										<a4j:support event="onclick" action="#{semmel001Action.onRender}" reRender="dtbPayee">
											<a4j:actionparam name="rowId" value="#{payee.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
									</div>
								</rich:column>
								
								<rich:column rendered="#{!semmel001Bean.viewMode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.edit']}" styleClass="contentform" />
									</f:facet>
									<div align="center">
					       				<a4j:commandButton action="#{navAction.navi}" 
					       								   reRender="frmSave"
					       								   image="images/edit.png" 
					       								   style="height: 15; width: 15"
					       								   rendered="#{payee.dataObj.payeeMasterId eq null}">
										<a4j:actionparam name="navModule" value="el" />
					         			<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
										<a4j:actionparam name="moduleWithNavi" value="el"/>
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="modePanelInfo" value="UPDATE" />
										<a4j:actionparam name="rowId" value="#{payee.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
										<a4j:actionparam name="eventType" value="Edit" />
										<a4j:actionparam name="isQueryContract" value="true"></a4j:actionparam>
					       				</a4j:commandButton>  
					       				
					       				<a4j:commandButton action="#{navAction.navi}" 
					       								   reRender="oppContent"
					       								   image="images/edit.png" 
					       								   style="height: 15; width: 15"
					       								   rendered="#{payee.dataObj.payeeMasterId ne null}">
										<a4j:actionparam name="navModule" value="el" />
				        				<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD-PAYEE" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
										<a4j:actionparam name="payeeMasterId" value="#{payee.dataObj.payeeMasterId}"/>
										<a4j:actionparam name="vendorMasterId" value="#{payee.dataObj.vendorMasterId}"/>
					       				</a4j:commandButton>      
									</div>
								</rich:column>
								
								<rich:column rendered="#{!semmel001Bean.viewMode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.delete']}" styleClass="contentform" />
									</f:facet>
									<div align="center">
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelVendorDialog')}.show(); return false" 
					     							   action="#{navAction.navi}" 
					     							   image="images/delete.png" style="height: 15; width: 15"
					     							   rendered="#{payee.dataObj.payeeMasterId eq null}">
										<a4j:actionparam name="navModule" value="el" />
					         			<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="initDelVendorMap" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
					         		</a4j:commandButton>
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelPayeeDialog')}.show(); return false" 
					     							   action="#{navAction.navi}" 
					     							   image="images/delete.png" style="height: 15; width: 15"
					     							   rendered="#{payee.dataObj.payeeMasterId ne null}">
										<a4j:actionparam name="navModule" value="el" />
					         			<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
										<a4j:actionparam name="rowId" value="#{payee.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="eventType" value="Delete" />
					         		</a4j:commandButton>      
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="เลขที่สัญญา" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.contractNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="ประเภทค่าใช้จ่าย" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.expenseTypeDesc}" styleClass="contentform"  />
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="Vendor" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.vendorName}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="สถานะ Vendor" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.vendorStatusDesc}" styleClass="contentform"  />
									</div>
								</rich:column>	
								<rich:column>
									<f:facet name="header">
										<h:outputText value="Alternative Payee" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.payeeName}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="สถานะ Payee" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.payeeStatusDesc}" styleClass="contentform"  />
									</div>
								</rich:column>	
								<rich:column>
									<f:facet name="header">
										<h:outputText value="วิธีชำระ" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.paymentTypeDesc}" styleClass="contentform"  />
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="เริ่มมีผล วันที่" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.paymentEffDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="เลขที่บัญชี" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.bankAccNo}" styleClass="contentform"  />
									</div>
								</rich:column>	
								<rich:column>
									<f:facet name="header">
										<h:outputText value="สถานะ BookBank" styleClass="contentform" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{payee.dataObj.bookBankStatusDesc}" styleClass="contentform"  />
									</div>
								</rich:column>	
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel001Bean.ct001SrchMSPList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="9">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPayee"
												maxPages="#{semmel001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstVendor" 
												style="background-color: #cccccc;"
												page="#{semmel001Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>					
								</f:facet>					
							</rich:dataTable>
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


<rich:modalPanel id="mdpConfirmDelVendorDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelVendorDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmel001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbPayee,frmSave" >
							<a4j:actionparam name="navModule" value="el" />
           					<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doDelVendorMap" />
							<a4j:actionparam name="mode" value="DELETE" />
							<rich:componentControl for="mdpConfirmDelVendorDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelVendorDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelPayeeDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelPayeeDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmel001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbPayee,frmSave" >
							<a4j:actionparam name="navModule" value="el" />
           					<a4j:actionparam name="navProgram" value="SEMMEL001-VMP-ADD" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSavePayeeMaster" />
							<a4j:actionparam name="mode" value="DELETE" />
							<rich:componentControl for="mdpConfirmDelPayeeDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelPayeeDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>



