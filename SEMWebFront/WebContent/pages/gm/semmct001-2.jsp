<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid width="100%">
<script>
	jQuery(document).ready(function() {
	    jQuery("#incContent\\:frmSave\\:panDataVendor div.rich-stglpanel-marker").css("display", "none");
	    jQuery("#incContent\\:frmSave\\:panVendorPayment div.rich-stglpanel-marker").css("display", "none");
	    jQuery("#incContent\\:frmSave\\:panAccountVendor div.rich-stglpanel-marker").css("display", "none");
	    jQuery("#incContent\\:frmSave\\:panAccountList div.rich-stglpanel-marker").css("display", "none");
	    jQuery("#incContent\\:frmSave\\:panDataVendorRnt div.rich-stglpanel-marker").css("display", "none");
	    jQuery("#incContent\\:frmSave\\:panDataBank div.rich-stglpanel-marker").css("display", "none");
	});
</script>

	<rich:panel id="pnlVendorMaster">
		<f:facet name="header">
			<h:outputText id="outTxtDisplayMode" value="Vendor Master - #{semmct001Bean.actModeDisplay}" />
		</f:facet>
		<%-- message group >> --%>
		<h:panelGroup>
			<a4j:form id="frmErrorTop">
				<rich:messages errorClass="ms7red" warnClass="ms7blue"
					infoClass="ms7green" rendered="#{semmct001Bean.renderedMsgFormTop}" >
					<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
                    </f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGroup>
		<%-- message group << --%>
		
		<%-- content group all >> --%>
		<h:panelGroup  style="width:100%;"> 
			<a4j:form id="frmSave">
				<center>
					<!-- >> group 00 -->
					<h:panelGroup style="width:100%;">
						<table style="width:100%; border:solid ececec 1px; text-align:right;">
							<tr>
								<td>
									<%-- 
									<h:commandButton id ="btnExport" action="#{semmct001Action.doExportExcel}"  
		         					styleClass="rich-button" value="Export" rendered="#{!semmct001Bean.viewMode}">
			         					<a4j:support event="onclick" oncomplete="test();" />
			         					<a4j:jsFunction name="test" reRender="btnBack"></a4j:jsFunction>
		         					</h:commandButton>
		         					<rich:spacer width="5"></rich:spacer>
		         					--%>
		         					<a4j:commandButton id="btnHistory" value="ดูข้อมูลประวัติ" styleClass="rich-button"
										action="#{semmct001Action.doShowPopupHistory}" reRender="oppContent"
										disabled="#{semmct001Bean.disabledButtonHistory}"
										oncomplete="#{rich:component('mct001_popupHistory_02')}.show(); return false;">
									</a4j:commandButton>
		         					<rich:spacer width="5"></rich:spacer>
		         					
		         					<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
						            action="#{navAction.navi}" reRender="oppContent" >
					            		<a4j:actionparam name="navModule" value="#{semmct001Bean.navModuleFrom}" />
										<a4j:actionparam name="navProgram" value="#{semmct001Bean.navProgramFrom}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmct001Bean.navModuleFrom}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmct001Bean.actionWithNaviFrom}" />
										<a4j:actionparam name="methodWithNavi" value="doBackPage" />
										<a4j:actionparam name="mode" value="SELECT" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
						            action="#{navAction.navi}" 
						            reRender="oppContent,btnSave,pnlVendorMaster,ddlVendor,rbtStatus" 
						            rendered="#{!semmct001Bean.viewMode}"
						            disabled="#{semmct001Bean.disableSaveBtn}">
							            <a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doSaveVendorMaster" />
										<a4j:actionparam name="mode" value="#{semmct001Bean.mode}" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<%-- 
									<a4j:commandButton id="btnSendAppr" value="Send Approve [n]" styleClass="rich-button" 
						            action="#{navAction.navi}" reRender="oppContent" >
							            <a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									--%>
									<a4j:commandButton id="btnNew" value="New" styleClass="rich-button" 
						            action="#{navAction.navi}" reRender="oppContent" 
						            rendered="#{!semmct001Bean.viewMode}">
							            <a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="INSERT" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					<!-- << group 00 -->
					
					<div style="clear:both; height:10px;"></div>
					
					<!-- >> group 01 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendor" switchType="client" label="ข้อมูล Vendor" 
						width="100%" opened="true" style="text-align:left;">
							<table width="100%" style="white-space:nowrap;">
								<tr>
									<td align="right" width="15%">
									
		                				<h:outputText value="Duplicate :" styleClass="ms7" rendered="#{semmct001Bean.vendorMaster.vendorStatus == '05'}"/>
		                			
		                			</td>
		                			
		                			<td colspan="3">
										<h:selectOneMenu id="ddlDupStatus" value="#{semmct001Bean.dupStatus}" 
				                	 	disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.vendorMaster.vendorStatus == '05'}">
				                			<f:selectItems value="#{semmct001Bean.dupStatusSelList}"/>
				                		</h:selectOneMenu>
									</td>
								</tr>
								
								<tr>
									<td align="right" width="15%">
										<h:panelGroup>
				                			<h:graphicImage value="images/icon_required.gif" />
				                			<rich:spacer width="5"></rich:spacer>
				                			<h:outputText value="Vendor Type :" styleClass="ms7" />
			                			</h:panelGroup>
		                			</td>
		                			<td width="25%">
		                			<!-- ddlVendorType -->
				                	 <h:selectOneMenu id="ddlVendorType" value="#{semmct001Bean.vendorMaster.vendorType}" 
				                	 				  disabled="#{semmct001Bean.viewMode}">
			                			<f:selectItems value="#{semmct001Bean.vendorTypeStatus}"/>
			                			<a4j:support event="onchange" action="#{navAction.navi}" reRender="panDataVendor">
					                		<a4j:actionparam name="navModule" value="gm" />
											<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
											<a4j:actionparam name="methodWithNavi" value="checkRequired" />
				                		</a4j:support>
			                		</h:selectOneMenu>
				                	 </td>
				                	 	
				                	 <td width="25%" align="right">
				                	 	<h:outputText value="Block Flag :" styleClass="ms7" />
				                	 </td>
				                	 <td>
				                	 	<h:selectOneMenu id="ddlBlockFlag" value="#{semmct001Bean.vendorMaster.blockFlag}" 
				                	 	disabled="#{semmct001Bean.viewMode}">
				                			<f:selectItems value="#{semmct001Bean.blockFlagSelList}"/>
				                		</h:selectOneMenu>
				                	 </td>
			                	 </tr>
								
								<tr>
									<td align="right" width="15%">
									<h:panelGroup>
		                			<h:outputText value="Vendor Code :" styleClass="ms7" />
		                			</h:panelGroup>
		                			</td>
		                			<td colspan="3">
									<h:inputText id="txtVendorCode" maxlength="50" value="#{semmct001Bean.vendorMaster.vendorCode}" readonly="true"></h:inputText>
									</td>
								</tr>
								
								<tr>
									<td align="right" width="15%">
									<h:panelGroup>
			                		<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="ชื่อ Vendor1 :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%">
			                						<a4j:region>
			                						<h:inputText id="txtVendorName1" value="#{semmct001Bean.vendorMaster.vendorName1}"
			                									 disabled="#{semmct001Bean.viewMode}" 
			                									 size="35"  maxlength="35">
				                					</h:inputText>
				                					</a4j:region>
			                		</td>
									<td align="right" width="25%"><h:outputText value="ชื่อ Vendor2 :" styleClass="ms7" /></td>
			                		<td><h:inputText id="txtVendorName2" value="#{semmct001Bean.vendorMaster.vendorName2}" 
			                									 disabled="#{semmct001Bean.viewMode}"
			                									 size="35" maxlength="35"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="15%">
			                		<h:outputText value="ชื่อ Vendor3 :" styleClass="ms7" />
			                		</td>
			                		<td width="25%"><h:inputText id="txtVendorName3" value="#{semmct001Bean.vendorMaster.vendorName3}"
			                									 disabled="#{semmct001Bean.viewMode}" 
			                									 size="35" maxlength="35"/></td>
									<td align="right" width="25%"><h:outputText value="ชื่อ Vendor4 :" styleClass="ms7" /></td>
			                		<td><h:inputText id="txtVendorName4" value="#{semmct001Bean.vendorMaster.vendorName4}" 
			                									 disabled="#{semmct001Bean.viewMode}"
			                									 size="35" maxlength="35"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="15%">
					                	<h:panelGroup id="panelIdCard">
				                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmct001Bean.renderedRequireIdCard}"/>
				                		<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="เลขประจำตัวประชาชน :" styleClass="ms7" />
				                		</h:panelGroup>
			                		</td>
			                		<td>
			                			<h:inputText id="txtIdCard" 
			                						 value="#{semmct001Bean.vendorMaster.idCard}" 
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 onblur="numberformat.formatInteger(this);"
			                						 maxlength="13"
			                						 disabled="#{semmct001Bean.viewMode}"/>
			                		</td>
			                		<%-- 
			                		<td align="right">
				                		<h:panelGroup id="panelTaxId">
				                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmct001Bean.renderedRequireTaxId}" />
				                		<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="เลขประจำตัวผู้เสียภาษี :" styleClass="ms7" />
				                		</h:panelGroup>
			                		</td>
			                		<td>
			                			<h:inputText id="txtTaxId" 
			                						 value="#{semmct001Bean.vendorMaster.taxId}" 
			                						 maxlength="10"
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 disabled="#{semmct001Bean.viewMode}"></h:inputText>
			                		</td>
			                		--%>
			                		<td align="right">
				                		<h:panelGroup id="panelTax13">
					                		<h:graphicImage value="images/icon_required.gif" rendered="#{semmct001Bean.renderedRequireTaxId}" />
					                		<rich:spacer width="5"></rich:spacer>
					                		<h:outputText value="เลขประจำตัวผู้เสียภาษี :" styleClass="ms7" />
				                		</h:panelGroup>
			                		</td>
			                		<td>
			                			<h:inputText id="txtTax13" 
			                						 value="#{semmct001Bean.vendorMaster.tax13}" 
			                						 maxlength="13"
			                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
			                						 disabled="#{semmct001Bean.viewMode}">
			                			</h:inputText>
			                		</td>
		                		</tr>
		                		<tr>
			                		<td></td>
			                		<td>
				                		<a4j:commandButton id="btnCheckVendor"
					                	action="#{navAction.navi}"	  
					                	reRender="oppContent"
					                	value="Check Vendor" styleClass="rich-button"  
					                	style="width:110"
					                	oncomplete="if(#{semmct001Bean.renderedSelectVendorPopup == 'true'})#{rich:component('popupFrmSelectVendor')}.show(); return false" 
					                	disabled="#{semmct001Bean.viewMode}">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
										<a4j:actionparam name="methodWithNavi" value="doCheckVendor" />
										</a4j:commandButton>
									</td>
									<td align="right">
										<h:outputText value="HQ/สาขา :" styleClass="ms7" />								
									</td>
									<td>
										<h:selectOneMenu id="hqBranch" value="#{semmct001Bean.vendorMaster.hqFlag}" onchange="changeHQBrance();" style="width:80px" disabled="#{semmct001Bean.viewMode}">
											<f:selectItems value="#{semmct001Bean.hqList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="changeHQBrance" reRender="hqBranch,txtBranch,panDataVendor" action="#{semmct001Action.doChangeHQBranch}"></a4j:jsFunction>
										<rich:spacer width="10"></rich:spacer>
										<h:graphicImage id="redStar" value="images/icon_required.gif" rendered="#{semmct001Bean.vendorMaster.hqFlag eq '02'}" />
										<h:outputText value="รหัสสาขา : " styleClass="ms7" />
										<h:inputText id="txtBranch" value="#{semmct001Bean.vendorMaster.branchNo}" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
										style="width:70" maxlength="5" disabled="#{semmct001Bean.hqDisable or semmct001Bean.viewMode}"/>
									</td>
								</tr>
								
								<tr>
			                		<td></td>
			                		<td>
				                		
									</td>
									<td align="right">
										<h:outputText value="สถานะ Vendor :" styleClass="ms7" />								
									</td>
									<td>
										<h:selectOneMenu id="ddlVendor" value="#{semmct001Bean.vendorMaster.vendorStatus}" disabled="true">
											<f:selectItems value="#{semmct001Bean.vendorStatusSelList}"/>
										</h:selectOneMenu>
										
									</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 01 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 03 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendorSAP" switchType="client" label="ข้อมูลที่อยู่ Vendor" 
						width="100%" opened="true" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ที่อยู่ 1 :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorAddr1" value="#{semmct001Bean.vendorMaster.address1}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="35"/> 
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="ที่อยู่ 2 :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorAddr2" value="#{semmct001Bean.vendorMaster.address2}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="35"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="ที่อยู่ 3 :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorAddr3" value="#{semmct001Bean.vendorMaster.address3}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="35"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="ที่อยู่ 4 :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorAddr4" value="#{semmct001Bean.vendorMaster.address4}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="35"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ตำบล :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<!-- >> -->
			                			<h:panelGroup id="mstDistrict1">
				                			<h:selectOneMenu id="ddlVendorDistrict" value="#{semmct001Bean.vendorMaster.districtCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderMstDistrictFreeFill}" onchange="mst_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtVendorSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="mst_getDistrictNameJS" reRender="txtVendorPostCode" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="VENDOR" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="mstDistrict2">
			                				<h:inputText id="txtVendorDistrictFreeFill" value="#{semmct001Bean.vendorMaster.district}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderMstDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="mst_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderMstDistrictFreeFill}"
											onclick="mst_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderMstAmphurFreeFill}"/>
											<a4j:jsFunction name="mst_renderDistrictFreeFillJS" reRender="mstDistrict1, mstDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="VENDOR" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
										<h:outputText value="อำเภอ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<!-- >> -->
			                			<h:panelGroup id="mstAmphur1">
				                			<h:selectOneMenu id="ddlVendorAmphur" value="#{semmct001Bean.vendorMaster.amphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderMstAmphurFreeFill}" onchange="mst_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.amphurVendorSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="mst_getDistrictListJS" reRender="ddlVendorDistrict" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="VENDOR" />
		                                    </a4j:jsFunction>
	                                    </h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="mstAmphur2">
		                                    <h:inputText id="txtVendorAmphurFreeFill" value="#{semmct001Bean.vendorMaster.amphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderMstAmphurFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="mst_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderMstAmphurFreeFill}"
											onclick="mst_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											<a4j:jsFunction name="mst_renderAmphurFreeFillJS" reRender="mstAmphur1, mstAmphur2, mstDistrict1, mstDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="VENDOR" />
											</a4j:jsFunction>
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
										<!-- << -->
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="จังหวัด :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:selectOneMenu id="ddlVendorProvince" value="#{semmct001Bean.vendorMaster.cityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="mst_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provinceSelList}"/>
	                                    </h:selectOneMenu> 
	                                    <a4j:jsFunction name="mst_getAmphurListJS" reRender="ddlVendorAmphur, ddlVendorDistrict, txtVendorPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="VENDOR" />
	                                    </a4j:jsFunction>
	                                    
	                                     <%-- // --%>
	                                    <h:selectBooleanCheckbox id="rnt_chkPTaxFlag" value="#{semmct001Bean.pRtTaxFlag}"
										onclick="rnt_setPTaxFlag();" style="margin:0 0 0 10px;"/>
										<a4j:jsFunction name="rnt_setPTaxFlag" reRender="tax_chkPTaxFlag" action="#{semmct001Action.managePTax}">
											<a4j:actionparam name="paramPTaxTab" value="RNT" />
										</a4j:jsFunction>
										<h:outputText value="หน่วยงานท้องถิ่น" style="vertical-align:top;" styleClass="ms7" />
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorPostCode" value="#{semmct001Bean.vendorMaster.postCode}" 
			                			disabled="#{semmct001Bean.viewMode}" size="7" maxlength="5"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Contact Name :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorContactName" value="#{semmct001Bean.vendorMaster.contactName}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="โทรศัพท์ :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorPhone" value="#{semmct001Bean.vendorMaster.telephone}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="Mobile :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorMobile" value="#{semmct001Bean.vendorMaster.mobileNo}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Fax :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorFax" value="#{semmct001Bean.vendorMaster.fax}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="E-Mail :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorEmail" value="#{semmct001Bean.vendorMaster.email}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 03 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 04 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendorRnt" switchType="client" label="ข้อมูลที่อยู่ Vendor (ค่าเช่า)" 
						width="100%" opened="false" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
		            			<%--
		            			<tr>
									<td align="right" width="25%">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<a4j:commandButton id="btnCopyVendorRntAddr" value="Copy จากข้อมูลที่อยู่" styleClass="rich-button" 
							            action="#{navAction.navi}" reRender="oppContent" >
								            <a4j:actionparam name="navModule" value="gm" />
											<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
											<a4j:actionparam name="methodWithNavi" value="" />
											<a4j:actionparam name="mode" value="" />
										</a4j:commandButton> 
			                		</td>
			                	</tr>
			                	--%>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ที่อยู่ 1+2 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorRntAddr1" value="#{semmct001Bean.vendorMaster.rtAddress1}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/> 
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="ที่อยู่ 3+4 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorRntAddr2" value="#{semmct001Bean.vendorMaster.rtAddress2}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ตำบล :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
	                                    <!-- >> -->
			                			<h:panelGroup id="rntDistrict1">
				                			<h:selectOneMenu id="ddlVendorRntDistrict" value="#{semmct001Bean.vendorMaster.rtDistrictCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderRntDistrictFreeFill}" onchange="rnt_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtRntSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="rnt_getDistrictNameJS" reRender="txtVendorRntPostCode" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="RNT" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="rntDistrict2">
			                				<h:inputText id="txtVendorRntDistrictFreeFill" value="#{semmct001Bean.vendorMaster.rtDistrict}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderRntDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="rnt_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderRntDistrictFreeFill}"
											onclick="rnt_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderRntAmphurFreeFill}"/>
											<a4j:jsFunction name="rnt_renderDistrictFreeFillJS" reRender="rntDistrict1, rntDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="RNT" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
										<h:outputText value="อำเภอ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<!-- >> -->
			                			<h:panelGroup id="rntAmphur1">
				                			<h:selectOneMenu id="ddlVendorRntAmphur" value="#{semmct001Bean.vendorMaster.rtAmphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderRntAmphurFreeFill}" onchange="rnt_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.amphurRntSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="rnt_getDistrictListJS" reRender="ddlVendorRntDistrict" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="RNT" />
		                                    </a4j:jsFunction>
	                                    </h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="rntAmphur2">
		                                    <h:inputText id="txtRntAmphurFreeFill" value="#{semmct001Bean.vendorMaster.rtAmphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderRntAmphurFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="rnt_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderRntAmphurFreeFill}"
											onclick="rnt_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											<a4j:jsFunction name="rnt_renderAmphurFreeFillJS" reRender="rntAmphur1, rntAmphur2, rntDistrict1, rntDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="RNT" />
											</a4j:jsFunction>
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
										<!-- << -->
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="จังหวัด :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:selectOneMenu id="ddlVendorRntProvince" value="#{semmct001Bean.vendorMaster.rtCityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="rnt_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provinceSelList}"/>
	                                    </h:selectOneMenu>
	                                    <a4j:jsFunction name="rnt_getAmphurListJS" reRender="ddlVendorRntAmphur, ddlVendorRntDistrict, txtVendorRntPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="RNT" />
	                                    </a4j:jsFunction>
	                                    
	                                   
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorRntPostCode" value="#{semmct001Bean.vendorMaster.rtPostCode}" 
			                			disabled="#{semmct001Bean.viewMode}" size="7" maxlength="5"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Contact Name :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorRntContactName" value="#{semmct001Bean.vendorMaster.rtContactName}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="150"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="โทรศัพท์ :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorRntPhone" value="#{semmct001Bean.vendorMaster.rtTelephone}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="Mobile :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorRntMobile" value="#{semmct001Bean.vendorMaster.rtMobileNo}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Fax :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorRntFax" value="#{semmct001Bean.vendorMaster.rtFax}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="E-Mail :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorRntEmail" value="#{semmct001Bean.vendorMaster.rtEmail}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 04 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 05 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendorElc" switchType="client" label="ข้อมูลที่อยู่ Vendor (ไฟฟ้า)" 
						width="100%" opened="false" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
		            			<%-- 
		            			<tr>
									<td align="right" width="25%">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<a4j:commandButton id="btnCopyVendorElcAddr" value="Copy จากข้อมูลที่อยู่" styleClass="rich-button" 
							            action="#{navAction.navi}" reRender="oppContent" >
								            <a4j:actionparam name="navModule" value="gm" />
											<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
											<a4j:actionparam name="methodWithNavi" value="" />
											<a4j:actionparam name="mode" value="" />
										</a4j:commandButton>
			                		</td>
			                	</tr>
			                	--%>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ที่อยู่ 1+2 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorElcAddr1" value="#{semmct001Bean.vendorMaster.elAddress1}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="ที่อยู่ 3+4 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorElcAddr2" value="#{semmct001Bean.vendorMaster.elAddress2}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/> 
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ตำบล :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<!-- >> -->
			                			<h:panelGroup id="elcDistrict1">
				                			<h:selectOneMenu id="ddlVendorElcDistrict" value="#{semmct001Bean.vendorMaster.elDistrictCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderElcDistrictFreeFill}" onchange="elc_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtElcSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="elc_getDistrictNameJS" reRender="txtVendorElcPostCode" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="ELC" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="elcDistrict2">
			                				<h:inputText id="txtVendorElcDistrictFreeFill" value="#{semmct001Bean.vendorMaster.elDistrict}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderElcDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="elc_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderElcDistrictFreeFill}"
											onclick="elc_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderElcAmphurFreeFill}"/>
											<a4j:jsFunction name="elc_renderDistrictFreeFillJS" reRender="elcDistrict1, elcDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="ELC" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
										<h:outputText value="อำเภอ :" styleClass="ms7" />
									</td>
			                		<td>
	                                    <!-- >> -->
			                			<h:panelGroup id="elcAmphur1">
				                			<h:selectOneMenu id="ddlVendorElcAmphur" value="#{semmct001Bean.vendorMaster.elAmphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderElcAmphurFreeFill}" onchange="elc_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.amphurElcSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="elc_getDistrictListJS" reRender="ddlVendorElcDistrict" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="ELC" />
		                                    </a4j:jsFunction>
	                                    </h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="elcAmphur2">
		                                    <h:inputText id="txtElcAmphurFreeFill" value="#{semmct001Bean.vendorMaster.elAmphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderElcAmphurFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="elc_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderElcAmphurFreeFill}"
											onclick="elc_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											<a4j:jsFunction name="elc_renderAmphurFreeFillJS" reRender="elcAmphur1, elcAmphur2, elcDistrict1, elcDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="ELC" />
											</a4j:jsFunction>
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
										<!-- << -->
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="จังหวัด :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:selectOneMenu id="ddlVendorElcProvince" value="#{semmct001Bean.vendorMaster.elCityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="elc_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provinceSelList}"/>
	                                    </h:selectOneMenu>
	                                    <a4j:jsFunction name="elc_getAmphurListJS" reRender="ddlVendorElcAmphur, ddlVendorElcDistrict, txtVendorElcPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="ELC" />
	                                    </a4j:jsFunction>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorElcPostCode" value="#{semmct001Bean.vendorMaster.elPostCode}" 
			                			disabled="#{semmct001Bean.viewMode}" size="7" maxlength="5"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Contact Name :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorElcContactName" value="#{semmct001Bean.vendorMaster.elContactName}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="150"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="โทรศัพท์ :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorElcPhone" value="#{semmct001Bean.vendorMaster.elTelephone}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="Mobile :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorElcMobile" value="#{semmct001Bean.vendorMaster.elMobileNo}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Fax :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorElcFax" value="#{semmct001Bean.vendorMaster.elFax}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="E-Mail :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorElcEmail" value="#{semmct001Bean.vendorMaster.elEmail}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 05 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 06 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendorTax" switchType="client" label="ข้อมูลที่อยู่ Vendor (ภาษีโรงเรือน)" 
						width="100%" opened="false" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
		            			<%-- 
		            			<tr>
									<td align="right" width="25%">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<a4j:commandButton id="btnCopyVendorTaxAddr" value="Copy จากข้อมูลที่อยู่" styleClass="rich-button" 
							            action="#{navAction.navi}" reRender="oppContent" >
								            <a4j:actionparam name="navModule" value="gm" />
											<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
											<a4j:actionparam name="methodWithNavi" value="" />
											<a4j:actionparam name="mode" value="" />
										</a4j:commandButton>
			                		</td>
			                	</tr>
			                	--%>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ที่อยู่ 1+2 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorTaxAddr1" value="#{semmct001Bean.vendorMaster.ptAddress1}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="ที่อยู่ 3+4 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorTaxAddr2" value="#{semmct001Bean.vendorMaster.ptAddress2}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ตำบล :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
	                                    <!-- >> -->
			                			<h:panelGroup id="taxDistrict1">
				                			<h:selectOneMenu id="ddlVendorTaxDistrict" value="#{semmct001Bean.vendorMaster.ptDistrictCode}"  
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderTaxDistrictFreeFill}" onchange="tax_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtTaxSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="tax_getDistrictNameJS" reRender="txtVendorTaxPostCode" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="TAX" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="taxDistrict2">
			                				<h:inputText id="txtVendorTaxDistrictFreeFill" value="#{semmct001Bean.vendorMaster.ptDistrict}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderTaxDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="tax_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderTaxDistrictFreeFill}"
											onclick="tax_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderTaxAmphurFreeFill}"/>
											<a4j:jsFunction name="tax_renderDistrictFreeFillJS" reRender="taxDistrict1, taxDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="TAX" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
										<h:outputText value="อำเภอ :" styleClass="ms7" />
									</td>
			                		<td>
	                                    <!-- >> -->
			                			<h:panelGroup id="taxAmphur1">
				                			<h:selectOneMenu id="ddlVendorTaxAmphur" value="#{semmct001Bean.vendorMaster.ptAmphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderTaxAmphurFreeFill}" onchange="tax_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.amphurTaxSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="tax_getDistrictListJS" reRender="ddlVendorTaxDistrict" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="TAX" />
		                                    </a4j:jsFunction>
	                                    </h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="taxAmphur2">
		                                    <h:inputText id="txtTaxAmphurFreeFill" value="#{semmct001Bean.vendorMaster.ptAmphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderTaxAmphurFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="tax_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderTaxAmphurFreeFill}"
											onclick="tax_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											<a4j:jsFunction name="tax_renderAmphurFreeFillJS" reRender="taxAmphur1, taxAmphur2, taxDistrict1, taxDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="TAX" />
											</a4j:jsFunction>
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
										<!-- << -->
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="จังหวัด :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:selectOneMenu id="ddlVendorTaxProvince" value="#{semmct001Bean.vendorMaster.ptCityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="tax_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provinceSelList}"/>
	                                    </h:selectOneMenu>
	                                    <a4j:jsFunction name="tax_getAmphurListJS" reRender="ddlVendorTaxAmphur, ddlVendorTaxDistrict, txtVendorTaxPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="TAX" />
	                                    </a4j:jsFunction>
	                                    
	                                    <%-- // --%>
	                                    <h:selectBooleanCheckbox id="tax_chkPTaxFlag" value="#{semmct001Bean.pPtTaxFlag}"
										onclick="tax_setPTaxFlag();" style="margin:0 0 0 10px;"/>
										<a4j:jsFunction name="tax_setPTaxFlag" reRender="rnt_chkPTaxFlag" action="#{semmct001Action.managePTax}">
											<a4j:actionparam name="paramPTaxTab" value="TAX" />
										</a4j:jsFunction>
										<h:outputText value="หน่วยงานท้องถิ่น" style="vertical-align:top;" styleClass="ms7" />
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorTaxPostCode" value="#{semmct001Bean.vendorMaster.ptPostCode}" 
			                			disabled="#{semmct001Bean.viewMode}" size="7" maxlength="5"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Contact Name :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorTaxContactName" value="#{semmct001Bean.vendorMaster.ptContactName}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="150"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="โทรศัพท์ :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorTaxPhone" value="#{semmct001Bean.vendorMaster.ptTelephone}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="Mobile :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorTaxMobile" value="#{semmct001Bean.vendorMaster.ptMobileNo}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Fax :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorTaxFax" value="#{semmct001Bean.vendorMaster.ptFax}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="E-Mail :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorTaxEmail" value="#{semmct001Bean.vendorMaster.ptEmail}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 06 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 07 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataVendorIns" switchType="client" label="ข้อมูลที่อยู่ Vendor (ประกันภัย)" 
						width="100%" opened="false" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
		            			<%-- 
		            			<tr>
									<td align="right" width="25%">
										&nbsp;
			                		</td>
			                		<td colspan="3">
			                			<a4j:commandButton id="btnCopyVendorInsAddr" value="Copy จากข้อมูลที่อยู่" styleClass="rich-button" 
							            action="#{navAction.navi}" reRender="oppContent" >
								            <a4j:actionparam name="navModule" value="gm" />
											<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
											<a4j:actionparam name="moduleWithNavi" value="gm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
											<a4j:actionparam name="methodWithNavi" value="" />
											<a4j:actionparam name="mode" value="" />
										</a4j:commandButton>
			                		</td>
			                	</tr>
			                	--%>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ที่อยู่ 1+2 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorInsAddr1" value="#{semmct001Bean.vendorMaster.irAddress1}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/> 
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="ที่อยู่ 3+4 :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorInsAddr2" value="#{semmct001Bean.vendorMaster.irAddress2}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="70"/> 
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="ตำบล :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<!-- >> -->
			                			<h:panelGroup id="insDistrict1">
				                			<h:selectOneMenu id="ddlVendorInsDistrict" value="#{semmct001Bean.vendorMaster.irDistrictCode}"  
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderInsDistrictFreeFill}" onchange="ins_getDistrictNameJS();">
		                                        <f:selectItems value="#{semmct001Bean.districtInsSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="ins_getDistrictNameJS" reRender="txtVendorInsPostCode" action="#{semmct001Action.getDistrictName}">
		                                    	<a4j:actionparam name="paramTab" value="INS" />
		                                    </a4j:jsFunction>
		                            	</h:panelGroup>
		                            	<!-- << -->
		                            	
		                            	<!-- >> -->
			                			<h:panelGroup id="insDistrict2">
			                				<h:inputText id="txtVendorInsDistrictFreeFill" value="#{semmct001Bean.vendorMaster.irDistrict}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderInsDistrictFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="ins_chkDistrictFreeFill" value="#{semmct001Bean.chkRenderInsDistrictFreeFill}"
											onclick="ins_renderDistrictFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode or semmct001Bean.chkRenderInsAmphurFreeFill}"/>
											<a4j:jsFunction name="ins_renderDistrictFreeFillJS" reRender="insDistrict1, insDistrict2" 
											action="#{semmct001Action.doChkDistrictFreeFill}">
												<a4j:actionparam name="paramTab" value="INS" />
											</a4j:jsFunction>
											<h:outputText value="ตำบลอื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
			                			</h:panelGroup>
		                            	<!-- << -->
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
										<h:outputText value="อำเภอ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<!-- >> -->
			                			<h:panelGroup id="insAmphur1">
				                			<h:selectOneMenu id="ddlVendorInsAmphur" value="#{semmct001Bean.vendorMaster.irAmphurCode}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{!semmct001Bean.chkRenderInsAmphurFreeFill}" onchange="ins_getDistrictListJS();">
		                                        <f:selectItems value="#{semmct001Bean.amphurInsSelList}"/>
		                                    </h:selectOneMenu>
		                                    <a4j:jsFunction name="ins_getDistrictListJS" reRender="ddlVendorInsDistrict" action="#{semmct001Action.getDistrictList}">
		                                    	<a4j:actionparam name="paramTab" value="INS" />
		                                    </a4j:jsFunction>
	                                    </h:panelGroup>
	                                    <!-- << -->
	                                    
	                                    <!-- >> -->
	                                    <h:panelGroup id="insAmphur2">
		                                    <h:inputText id="txtInsAmphurFreeFill" value="#{semmct001Bean.vendorMaster.irAmphur}" 
				                			disabled="#{semmct001Bean.viewMode}" rendered="#{semmct001Bean.chkRenderInsAmphurFreeFill}" size="20" maxlength="255"/>
		                                    <h:selectBooleanCheckbox id="ins_chkAmphurFreeFill" value="#{semmct001Bean.chkRenderInsAmphurFreeFill}"
											onclick="ins_renderAmphurFreeFillJS();" style="margin:0 0 0 10px;" disabled="#{semmct001Bean.viewMode}"/>
											<a4j:jsFunction name="ins_renderAmphurFreeFillJS" reRender="insAmphur1, insAmphur2, insDistrict1, insDistrict2" 
											action="#{semmct001Action.doChkAmphurFreeFill}">
												<a4j:actionparam name="paramTab" value="INS" />
											</a4j:jsFunction>
											<h:outputText value="อำเภออื่นๆ.." style="vertical-align:top;" styleClass="ms7" />
										</h:panelGroup>
										<!-- << -->
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
										<h:outputText value="* " style="color:blue; font-weight:bold;"/>
			                			<h:outputText value="จังหวัด :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:selectOneMenu id="ddlVendorInsProvince" value="#{semmct001Bean.vendorMaster.irCityCode}" 
			                			disabled="#{semmct001Bean.viewMode}" onchange="ins_getAmphurListJS();">
	                                        <f:selectItems value="#{semmct001Bean.provinceSelList}"/>
	                                    </h:selectOneMenu>
	                                    <a4j:jsFunction name="ins_getAmphurListJS" reRender="ddlVendorInsAmphur, ddlVendorInsDistrict, txtVendorInsPostCode" action="#{semmct001Action.getAmphurList}">
	                                    	<a4j:actionparam name="paramTab" value="INS" />
	                                    </a4j:jsFunction>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="รหัสไปรษณีย์ :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorInsPostCode" value="#{semmct001Bean.vendorMaster.irPostCode}" 
			                			disabled="#{semmct001Bean.viewMode}" size="7" maxlength="5"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Contact Name :" styleClass="ms7" />
			                		</td>
			                		<td colspan="3">
			                			<h:inputText id="txtVendorInsContactName" value="#{semmct001Bean.vendorMaster.irContactName}" 
			                			disabled="#{semmct001Bean.viewMode}" size="100" maxlength="150"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="โทรศัพท์ :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorInsPhone" value="#{semmct001Bean.vendorMaster.irTelephone}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="Mobile :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorInsMobile" value="#{semmct001Bean.vendorMaster.irMobileNo}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
								<tr>
									<td align="right" width="15%">
			                			<h:outputText value="Fax :" styleClass="ms7" />
			                		</td>
			                		<td width="25%">
			                			<h:inputText id="txtVendorInsFax" value="#{semmct001Bean.vendorMaster.irFax}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
									<td align="right" width="25%">
										<h:outputText value="E-Mail :" styleClass="ms7" />
									</td>
			                		<td>
			                			<h:inputText id="txtVendorInsEmail" value="#{semmct001Bean.vendorMaster.irEmail}" 
			                			disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255"/>
			                		</td>
								</tr>
							</table>
		            	</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 07 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 02 -->
					<h:panelGroup style="width:100%;">
						<rich:simpleTogglePanel id="panDataBank" switchType="client" label="ข้อมูลธนาคาร" 
						width="100%" opened="true" style="text-align:left;" >
		            		<table width="100%" style="white-space:nowrap;">
		                		<tr>
		                		    <td align="right">
                                        <h:outputText value="ประเภทบัญชี :" styleClass="ms7" />
                                    </td>
		                		    <td >
                                    <!-- ddlBankAccountType -->
                                    <h:selectOneMenu id="ddlBankAccType" value="#{semmct001Bean.vendorBookBank.bankAccType}" 
                                                     disabled="#{semmct001Bean.viewMode}" onchange="changeBankSel();">
                                        <f:selectItems value="#{semmct001Bean.bankAccountSelList}"/>
                                    </h:selectOneMenu>
                                    <a4j:jsFunction name="changeBankSel" reRender="panAccountVendor"></a4j:jsFunction>
                                    </td>
		                		</tr>
		                		<tr>
                                    <td align="right" width="20%">
                                    <h:graphicImage value="images/icon_required.gif" rendered="#{not empty (semmct001Bean.vendorBookBank.bankAccType)}"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="Bank Code :" styleClass="ms7" /></td>
                                    <td>
                                    <h:inputText id="txtBankCode_2"  value="#{semmct001Bean.vendorBookBank.bankCode}"
                                                 disabled="#{semmct001Bean.viewMode}"
                                                 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
                                                 maxlength="7" onchange="changeBankSel();">
                                    <a4j:support event="onblur" action="#{navAction.navi}" reRender="ddlBankProvince_2,txtBankBranch_2,txtBankName_2,panAccountVendor">
                                        <a4j:actionparam name="navModule" value="gm" />
                                        <a4j:actionparam name="navProgram" value="SEMMCT001-2" />
                                        <a4j:actionparam name="moduleWithNavi" value="gm" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
                                        <a4j:actionparam name="methodWithNavi" value="queryBankByCode" />
                                    </a4j:support>
                                    
                                    </h:inputText>
                                    <rich:spacer width="2"></rich:spacer>
                                    <a4j:commandButton id="btnPopupSearchBankCode"  oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
                                    value="..."   
                                    action="#{navAction.navi}"
                                    reRender="popupFrmSelectBank,frmSelectBank" 
                                    disabled="#{semmct001Bean.viewMode}">
                                    <a4j:actionparam name="navModule" value="gm" />
                                    <a4j:actionparam name="navProgram" value="SEMMCT001-2" />
                                    <a4j:actionparam name="moduleWithNavi" value="gm" />
                                    <a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
                                    <a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
                                    </a4j:commandButton>
                                    </td>
                                    <td align="right">
                                    <h:graphicImage value="images/icon_required.gif" rendered="#{not empty (semmct001Bean.vendorBookBank.bankAccType)}"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="ธนาคาร :" styleClass="ms7" /></td>
                                    <td><h:inputText id="txtBankName_2"  value="#{semmct001Bean.ct001SrchMSP.bankName}" 
                                                     style="width:200"
                                                     maxlength="100"
                                                     disabled="#{semmct001Bean.viewMode or semmct001Bean.disabledBankInfo}"/></td>
                                 </tr>
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:graphicImage value="images/icon_required.gif" rendered="#{not empty (semmct001Bean.vendorBookBank.bankAccType)}"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="สาขา :" styleClass="ms7" /></td>
                                    <td>            
                                        <h:inputTextarea id="txtBankBranch_2" value="#{semmct001Bean.ct001SrchMSP.bankBranch}" rows="3" cols="50"
                                              disabled="#{semmct001Bean.viewMode or semmct001Bean.disabledBankInfo}">
                                              <f:validateLength maximum="100" ></f:validateLength>
                                        </h:inputTextarea>
                                    </td>
                                    <td align="right"><h:outputText value="จังหวัด :" styleClass="ms7" /></td>
                                    <td>
                                    <!-- ddlProvince -->
                                    <h:selectOneMenu id="ddlBankProvince_2" value="#{semmct001Bean.ct001SrchMSP.bankProvince}" 
                                                     disabled="#{semmct001Bean.viewMode}">
                                        <f:selectItems value="#{semmct001Bean.bankProvinceSelList}"/>
                                    </h:selectOneMenu>
                                    </td>
								</tr>
								<tr>
                                    <td align="right" width="20%">
	                                    <h:graphicImage value="images/icon_required.gif" rendered="#{not empty (semmct001Bean.vendorBookBank.bankCode)}"/>
	                                    <rich:spacer width="5"></rich:spacer>
	                                    <h:outputText value="เลขที่บัญชี :" styleClass="ms7" />
									</td>
                                    <td>
                                        <h:inputText id="txtBankAccNo"  value="#{semmct001Bean.vendorBookBank.bankAccNo}" 
                                         disabled="#{semmct001Bean.viewMode}"
                                         onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
                                         maxlength="15">
                                            <a4j:support event="onblur" action="#{semmct001Action.copyVendorName1ToVendorBookBankAccName}"
                                            reRender="txtBankAccName"/>
                                        </h:inputText>                                               
                                    </td>
                                    <td align="right">
                                    	<h:outputText value="ชื่อบัญชี :" styleClass="ms7" />
                                    </td>
                                    <td>
                                        <h:inputText id="txtBankAccName"  value="#{semmct001Bean.vendorBookBank.bankAccName}" 
                                        disabled="#{semmct001Bean.viewMode}" size="35" maxlength="255" >
                                        </h:inputText>
                                    </td>
								</tr>
								<tr>
                                    <h:panelGroup rendered="#{semmct001Bean.renderSapLabel}" >
                                    <td align="right" width="20%">
                                    	<h:outputText value="เลขที่บัญชี  SAP:" styleClass="ms7" />
                                    </td>
									<td >
										<h:inputText id="txtSapBankAccNo"  value="#{semmct001Bean.vendorBookBank.sapBankAccNo}" 
										disabled="true" maxlength="15">
										</h:inputText>                                               
									</td>
									<td align="right" >
										<h:outputText value="ชื่อบัญชี SAP :" styleClass="ms7" />
									</td>
                                    <td >
										<h:inputText id="txtSapBankAccName"  value="#{semmct001Bean.vendorBookBank.sapBankAccName}" 
										disabled="true" size="35">
                                        </h:inputText>
                                        <rich:spacer width="5"></rich:spacer>
                                        <a4j:commandButton id="btnConfirm"  styleClass="rich-button" value="Confirm"  reRender="oppContent" 
                                        disabled="#{semmct001Bean.vendorBookBank.sapBankAccNo == '' or semmct001Bean.vendorBookBank.sapBankAccNo == null}"
                                        action="#{navAction.navi}" rendered="#{!semmct001Bean.viewMode}">
                                            <a4j:actionparam name="navModule" value="gm" />
                                            <a4j:actionparam name="navProgram" value="SEMMCT001-2" />
                                            <a4j:actionparam name="moduleWithNavi" value="gm" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
                                            <a4j:actionparam name="methodWithNavi" value="doConfirmSap" />
                                        </a4j:commandButton>
                                    </td>
                                    </h:panelGroup>
								</tr>
								<tr>
									<td align="right" valign="top">
										<h:outputText value="หมายเหตุ :" styleClass="ms7" />
									</td>
				                	<td>
				                		<h:inputTextarea id="txtVendorRemark" value="#{semmct001Bean.vendorBookBank.remark}" rows="3" cols="50" 
				                		disabled="#{semmct001Bean.viewMode}" label="หมายเหตุ" >
		                					<f:validateLength maximum="255" ></f:validateLength>
		                				</h:inputTextarea>
									</td>
		                			<td align="right">
		                				<h:outputText value="สถานะ Book Bank :" styleClass="ms7" />
		                			</td>
				                	<td>
				                 		<h:selectOneMenu id="rbtStatus" value="#{semmct001Bean.vendorBookBank.vendorBookbankStatus}" disabled="true" >
											<f:selectItems value="#{semmct001Bean.bookbankStatusSelList}"/>
										</h:selectOneMenu>
				                 	</td>
								</tr>
								<tr>
		                			<td colspan="3" align="right">
		                				&nbsp;
		                			</td>
				                	<td>
				                 		<a4j:commandButton id="btnDeleteBookBank" value="Delete BookBank" styleClass="rich-button" 
										style="width:120"
							            action="#{navAction.navi}" reRender="oppContent"
							            oncomplete="#{rich:component('mdpConfirmDelBookBankDialog')}.show(); return false" 
							            rendered="#{!semmct001Bean.viewMode}" disabled="#{(semmct001Bean.vendorMapPayee.paymentType eq '02') or (semmct001Bean.vendorBookBank.bankCode eq null)}">
										</a4j:commandButton>
				                 	</td>
								</tr>
		                	</table>
						</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 02 -->
					
					<div style="clear:both; height:5px;"></div>
					
					<!-- >> group 08 -->
					<h:panelGroup style="width:100%;">
					<rich:simpleTogglePanel id="panVendorPayment" switchType="client" label="ข้อมูลค่าใช้จ่าย (Vendor)" 
						width="100%" opened="true" style="text-align:left;" >

						<rich:simpleTogglePanel id="panAccountVendor" switchType="client" label="เพิ่มข้อมูลค่าใช้จ่าย" 
						width="100%" opened="true" style="text-align:left;" >
							<h:panelGrid>
								<h:messages errorClass="ms7red" warnClass="ms7blue"
								infoClass="ms7green" globalOnly="true"
								rendered="#{semmct001Bean.renderedMsgFormMiddle}" />
							</h:panelGrid>
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
				                			<td align="right" width="25%">
					                			<h:graphicImage value="images/icon_required.gif" />
					                			<rich:spacer width="5"></rich:spacer>
					                			<h:outputText value="เลขที่สัญญา :" styleClass="ms7" />
				                			</td>
										    <td width="25%">
												<h:inputText id="txtContractNo" maxlength="20" value="#{popupSiteContractBean.contractNo}"
												disabled="#{semmct001Bean.viewMode}">
													<a4j:support event="onblur" action="#{popupSiteContractAction.getSiteInfoId}"  
													reRender="cldEffDt,cldStrEffDt,cldEndExpireDt,txtContractNo">
												    </a4j:support>
												</h:inputText>
										        <rich:spacer width="2"></rich:spacer>
												<a4j:commandButton id="btnPopupSearchContractNo" 
												oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
												value="..."  reRender="popupSearchContractNo,popupFrmSearch" 
								            	action="#{navAction.navi}" rendered="#{!semmct001Bean.viewMode}">
									            	<a4j:actionparam name="navModule" value="common" />
													<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
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
							                	<h:selectOneMenu id="ddlExpenseType" value="#{semmct001Bean.vendorMapPayee.expenseType}" 
							                	disabled="#{semmct001Bean.viewMode}">
							                		<f:selectItems value="#{semmct001Bean.expenseTypeSelList}"/>
							                		<a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" reRender="cldStrEffDt,cldEndExpireDt">
												   		<a4j:actionparam name="navModule" value="gm" />
														<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
														<a4j:actionparam name="moduleWithNavi" value="gm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
														<a4j:actionparam name="methodWithNavi" value="doGetVendorMapPayeeInfo" />
										     		</a4j:support>
					                			</h:selectOneMenu>
					                			<rich:spacer width="5"></rich:spacer>
												<a4j:commandButton id="btnOwnerDetail"  styleClass="rich-button"  
												value="ข้อมูลเจ้าของสถานที่"  reRender="oppContent" 
								            	action="#{navAction.navi}" rendered="#{!semmct001Bean.viewMode}">
								            		<a4j:actionparam name="navModule" value="gm" />
													<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="gm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="INSERT" />
													<a4j:actionparam name="eventType" value="Add" />
													<a4j:actionparam name="navModuleFrom" value="rt" />
													<a4j:actionparam name="navProgramFrom" value="SEMMRT001-1" />
													<a4j:actionparam name="actionWithNaviFrom" value="SEMMRT001" />
													<a4j:actionparam name="lessorId" value="#{semmct001Bean.tmpLessorId}" />
													<a4j:actionparam name="contractNo" value="#{semmct001Bean.tmpContractNo}" />
													<a4j:actionparam name="expenseType" value="#{semmct001Bean.tmpExpenseType}" />
													<a4j:actionparam name="isPageFrom" value="true" />  
						            			</a4j:commandButton>
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
				                			<td> 
					                			<a4j:region>
							                		<h:selectOneRadio id="rbtVat" value="#{semmct001Bean.vendorMapPayee.paymentType}" 
							                		disabled="#{semmct001Bean.viewMode}" styleClass="ms7" onclick="defaultBankName();" >
														<f:selectItem itemLabel="เช็ค" itemValue="01" />
														<f:selectItem itemLabel="โอน"  itemValue="02" />
													</h:selectOneRadio>
													<a4j:jsFunction name="defaultBankName" action="#{semmct001Action.copyVendorName1ToVendorBookBankAccName}"
													reRender="frmSave, btnDeleteBookBank"></a4j:jsFunction>
												</a4j:region>
				                			</td>
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
											   	disabled="#{semmct001Bean.viewMode}">
												</rich:calendar> 
											</td>
										</tr>
						                <tr>
											<td align="right" valign="top">
												<h:outputText value="หมายเหตุ :" styleClass="ms7" />
											</td>
						                	<td colspan="3">
						                		<h:inputTextarea id="txtBookBankRemark" value="#{semmct001Bean.vendorMaster.remark}" rows="3" cols="72"
												disabled="#{semmct001Bean.viewMode}" label="หมายเหตุ" >
				                					<f:validateLength maximum="255" ></f:validateLength>
				                				</h:inputTextarea>
					                		</td>
						                </tr>
						                <tr>
											<td colspan="3">
												<a4j:commandButton id="btnSaveVendorMaster" value="#{semmct001Bean.mode}" styleClass="rich-button" 
									            action="#{navAction.navi}" reRender="oppContent,panAccountVendor" rendered="#{!semmct001Bean.viewMode}"
									            disabled="#{semmct001Bean.disableSaveBtn}">
										            <a4j:actionparam name="navModule" value="gm" />
													<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="gm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
													<a4j:actionparam name="methodWithNavi" value="doSaveVendorMaster" />
													<a4j:actionparam name="mode" value="#{semmct001Bean.mode}" />
												</a4j:commandButton>
												<rich:spacer width="2"></rich:spacer>
												<a4j:commandButton id="btnClearExpenseInfo" value="Clear" styleClass="rich-button" 
									            action="#{navAction.navi}" reRender="oppContent" rendered="#{!semmct001Bean.viewMode}">
										            <a4j:actionparam name="navModule" value="gm" />
													<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="gm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
													<a4j:actionparam name="methodWithNavi" value="doClearClearExpenseInfo" />
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnChangePermission" value="เปลี่ยนแปลงเจ้าของสิทธิ์" styleClass="rich-button" 
									            action="#{navAction.navi}" reRender="oppContent" rendered="#{!semmct001Bean.viewMode}"
									            oncomplete="#{rich:component('mdpSrchVendor')}.show(); return false">
										            <a4j:actionparam name="navModule" value="gm" />
													<a4j:actionparam name="navProgram" value="SEMMCT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="gm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
													<a4j:actionparam name="methodWithNavi" value="doPopupSearchVendor" />
												</a4j:commandButton>
											</td>
						                </tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:simpleTogglePanel>
					
						<div style="clear:both; height:5px;"></div>
					
						<rich:simpleTogglePanel id="panAccountList" switchType="client" label="รายการเลขที่บัญชี" 
						width="100%" opened="true" style="text-align:left;" >
							<h:panelGrid  width="100%"  border="0" cellpadding="0" cellspacing="0">
								<h:panelGroup>
									<table width="100%" border="0">
										<tr>
											<td align="left">
												
													<div align="left" style="width:950px;">
														<a4j:commandButton id="btnAddAlterNative"  styleClass="rich-button" 
													    action="#{navAction.navi}" value="Add Alternative Payee"  
													    reRender="oppContent" style="width:135"
													    disabled="#{semmct001Bean.disabledButtonAddPayee}">
															<a4j:actionparam name="navModule" value="gm" />
											        		<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
															<a4j:actionparam name="moduleWithNavi" value="gm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
															<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
															<a4j:actionparam name="mode" value="INSERT" />
															<a4j:actionparam name="eventType" value="Add" />
														</a4j:commandButton>
														<rich:spacer width="5"></rich:spacer>
														<a4j:commandButton id="btnApprove"  styleClass="rich-button" 
													    action="#{navAction.navi}" value="ส่งอนุมัติ Payee"  reRender="dtbPayee,frmSave" style="width:140"
													    rendered="#{!semmct001Bean.viewMode}"
													    disabled="#{semmct001Bean.disabledButtonApprove}">
															<a4j:actionparam name="navModule" value="gm" />
											        		<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
															<a4j:actionparam name="moduleWithNavi" value="gm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
															<a4j:actionparam name="methodWithNavi" value="doApprove" />
														</a4j:commandButton>
														
														<rich:spacer width="5"></rich:spacer>
														<a4j:commandButton id="btnDeleteVendor"  styleClass="rich-button" 
													    action="#{navAction.navi}" value="Delete Vendor"  reRender="dtbPayee,frmSave,frmConfirmDelete" style="width:140"
													    rendered="#{!semmct001Bean.viewMode}"
													    oncomplete="#{rich:component('mdpConfirmDeleteDialog')}.show(); return false"
													    disabled="#{semmct001Bean.disabledButtonDelVendor}">
															<a4j:actionparam name="navModule" value="gm" />
											        		<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
															<a4j:actionparam name="moduleWithNavi" value="gm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
															<a4j:actionparam name="methodWithNavi" value="initDelete" />
															<a4j:actionparam name="deleteMode" value="DV" />
														</a4j:commandButton>
														<rich:spacer width="5"></rich:spacer>
														<a4j:commandButton id="btnDeletePayee"  styleClass="rich-button" 
													    action="#{navAction.navi}" value="Delete Payee"  reRender="dtbPayee,frmSave,frmConfirmDelete" style="width:140"
													    rendered="#{!semmct001Bean.viewMode}"
													    oncomplete="#{rich:component('mdpConfirmDeleteDialog')}.show(); return false"
													    disabled="#{semmct001Bean.disabledButtonDelPayee}">
													    	<a4j:actionparam name="navModule" value="gm" />
											        		<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
															<a4j:actionparam name="moduleWithNavi" value="gm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
															<a4j:actionparam name="methodWithNavi" value="initDelete" />
															<a4j:actionparam name="deleteMode" value="DP" />
														</a4j:commandButton>
													</div>
												
											</td>
										</tr>
										<tr>
											<td align="left">
												
													<div align="left" style="width:950px;">
														<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"
														rendered="#{semmct001Bean.renderedMsgFormBottom}" />
													</div>
												
											</td>
										</tr>
										<tr>
											<td>
												<center>
													<div id="tabResult_AccountList" style="width:100%; overflow:scroll; border:1px solid e0e0e0;">
														<rich:dataTable width="100%" id="dtbPayee" cellpadding="0" 
														cellspacing="0" border="0" var="payee" 
														value="#{semmct001Bean.ct001SrchMSPList}" reRender="dstPayee" 
														rows="#{semmct001Bean.rowPerPage}" onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
														onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
														rowClasses="cur" styleClass="contentform">
															<rich:column rendered="#{!semmct001Bean.viewMode}">
																<f:facet name="header">
																	<h:selectBooleanCheckbox value="#{semmct001Bean.chkSelAll}">
																		<a4j:support event="onclick" action="#{semmct001Action.selectAllRow}" reRender="dtbPayee,btnApprove,btnAddAlterNative"/>
																	</h:selectBooleanCheckbox>
																</f:facet>
																<div align="center">
																	<h:selectBooleanCheckbox id="chkSelect"  value="#{payee.checkBox}">
																		<a4j:support event="onclick" action="#{semmct001Action.onRenderApproveButton}" reRender="frmSave,dtbPayee,btnApprove,btnDeleteVendor,btnDeletePayee,btnAddAlterNative">
																			<a4j:actionparam name="rowId" value="#{payee.dataObj.rowId}" />
																			<a4j:actionparam name="mode" value="UPDATE" />
																			<a4j:actionparam name="modePanelInfo" value="UPDATE" />
																			<a4j:actionparam name="rowId" value="#{payee.dataObj.vendorMasterId}"/>
																			<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																			<a4j:actionparam name="eventType" value="Edit" />
																			<a4j:actionparam name="isQueryContract" value="true"/>
																			<a4j:actionparam name="contractNo" value="#{payee.dataObj.contractNo}"/>
																			<a4j:actionparam name="expenseType" value="#{payee.dataObj.expenseType}"/>
																		</a4j:support>
																	</h:selectBooleanCheckbox>
																</div>
															</rich:column>
															<rich:column rendered="#{!semmct001Bean.viewMode}">
																<f:facet name="header">
																	<h:outputText value="Edit" styleClass="contentform" />
																</f:facet>
																<div align="center">
												       				<a4j:commandButton action="#{navAction.navi}" 
						       								   		reRender="frmSave" image="images/edit.png" 
						       								   		style="height: 15; width: 15"
						       								   		rendered="#{payee.dataObj.payeeMasterId eq null}">
																		<a4j:actionparam name="navModule" value="gm" />
													         			<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm"/>
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
																		<a4j:actionparam name="methodWithNavi" value="pageLoad" />
																		<a4j:actionparam name="mode" value="UPDATE" />
																		<a4j:actionparam name="modePanelInfo" value="UPDATE" />
																		<a4j:actionparam name="rowId" value="#{payee.dataObj.vendorMasterId}"/>
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																		<a4j:actionparam name="eventType" value="Edit" />
																		<a4j:actionparam name="isQueryContract" value="true"></a4j:actionparam>
																		<a4j:actionparam name="expenseType" value="#{payee.dataObj.expenseType}"/>
												       				</a4j:commandButton>  
												       				
												       				<a4j:commandButton action="#{navAction.navi}" 
							       								   	reRender="oppContent" image="images/edit.png" 
							       								   	style="height: 15; width: 15"
							       								   	rendered="#{payee.dataObj.payeeMasterId ne null}">
																		<a4j:actionparam name="navModule" value="gm" />
												        				<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
																		<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
																		<a4j:actionparam name="mode" value="UPDATE" />
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																		<a4j:actionparam name="payeeMasterId" value="#{payee.dataObj.payeeMasterId}"/>
																		<a4j:actionparam name="vendorMasterId" value="#{payee.dataObj.vendorMasterId}"/>
																		<a4j:actionparam name="expenseType" value="#{payee.dataObj.expenseType}"/>
												       				</a4j:commandButton>      
																</div>
															</rich:column>
															<rich:column rendered="#{!semmct001Bean.viewMode}">
																<f:facet name="header">
																	<h:outputText value="Delete" styleClass="contentform" />
																</f:facet>
																<div align="center">
																	<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelVendorDialog')}.show(); return false" 
													     			action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
													     			rendered="#{payee.dataObj.payeeMasterId eq null}">
																		<a4j:actionparam name="navModule" value="gm" />
													         			<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
																		<a4j:actionparam name="methodWithNavi" value="initDelVendorMap" />
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
													         		</a4j:commandButton>
																	<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelPayeeDialog')}.show(); return false" 
													     			action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
													     			rendered="#{payee.dataObj.payeeMasterId ne null}">
																		<a4j:actionparam name="navModule" value="gm" />
													         			<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
																		<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
																		<a4j:actionparam name="mode" value="UPDATE" />
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																		<a4j:actionparam name="rowId" value="#{payee.dataObj.vendorMasterId}"/>
																		<a4j:actionparam name="eventType" value="Delete" />
													         		</a4j:commandButton>      
																</div>
															</rich:column>
															<rich:column rendered="#{semmct001Bean.viewMode}">
																<f:facet name="header">
																	<h:outputText value="View" styleClass="contentform" />
																</f:facet>
																<div align="center">
									            					<a4j:commandButton id="view" action="#{navAction.navi}" 
													       			reRender="oppContent" image="images/view.png" 
													       			style="height: 15; width: 15"
													       			rendered="#{semmct001Bean.renderedBackBtn}">
																		<a4j:actionparam name="navModule" value="gm" />
												        				<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
																		<a4j:actionparam name="methodWithNavi" value="pageIIILoad" />
																		<a4j:actionparam name="mode" value="SELECT" />
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																		<a4j:actionparam name="payeeMasterId" value="#{payee.dataObj.payeeMasterId}"/>
																		<a4j:actionparam name="vendorMasterId" value="#{payee.dataObj.vendorMasterId}"/>
													       			</a4j:commandButton>  
													       			
													       			<a4j:commandButton id="viewCrossPage" action="#{navAction.navi}" 
													       			reRender="oppContent" image="images/view.png" 
													       			style="height: 15; width: 15"
													       			rendered="#{semmct001Bean.renderedViewCrossPageBtn}">
																		<a4j:actionparam name="navModule" value="gm" />
												        				<a4j:actionparam name="navProgram" value="SEMMCT001-3" />	
																		<a4j:actionparam name="moduleWithNavi" value="gm" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMCT010" />
																		<a4j:actionparam name="methodWithNavi" value="pageCrossIIILoad" />
																		<a4j:actionparam name="mode" value="SELECT" />
																		<a4j:actionparam name="vendorMapPayeeId" value="#{payee.dataObj.rowId}"/>
																		<a4j:actionparam name="payeeMasterId" value="#{payee.dataObj.payeeMasterId}"/>
																		<a4j:actionparam name="vendorMasterId" value="#{payee.dataObj.vendorMasterId}"/>
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
																	<h:outputText value="ค่าใช้จ่าย" styleClass="contentform" />
																</f:facet>
																<div align="center">
																	<h:outputText value="#{payee.dataObj.expenseTypeDesc}" styleClass="contentform"  />
																</div>
															</rich:column>
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="Vendor Name" styleClass="contentform" style = "width : 150px" />
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
																	<h:outputText value="#{payee.dataObj.bookBankStatusDesc}" styleClass="contentform" style="color:#{payee.dataObj.color} !important" />
																</div>
															</rich:column>
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="Alternative Payee" styleClass="contentform" style = "width : 150px" />
																</f:facet>
																<div align="center">
																	<h:outputText value="#{payee.dataObj.payeeName}" styleClass="contentform" >
																		<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
																	</h:outputText>
																</div>
															</rich:column>
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="สถานะ Payee" styleClass="contentform" style = "width : 100px"/>
																</f:facet>
																<div align="center">
																	<h:outputText value="#{payee.dataObj.payeeStatusDesc}" styleClass="contentform"  />
																</div>
															</rich:column>
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="เลขที่บัญชี Payee" styleClass="contentform" />
																</f:facet>
																<div align="center">
																	<h:outputText value="#{payee.dataObj.payeeBankAccNo}" styleClass="contentform"  />
																</div>
															</rich:column>	
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="สถานะ BookBank Payee" styleClass="contentform" />
																</f:facet>
																<div align="center">
																	<h:outputText value="#{payee.dataObj.payeeBookBankStatusDesc}" styleClass="contentform"  />
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
																
															<f:facet name="footer">
																<rich:columnGroup>
																	<rich:column colspan="4">
																		<h:outputFormat value="#{msg['message.totalRecords']}">
																			<f:param value="#{fn:length(semmct001Bean.ct001SrchMSPList)}"></f:param>
																		</h:outputFormat>
																	</rich:column>
																	<rich:column colspan="12">
																		<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPayee"
																			maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																			stepControls="hide" fastControls="auto" boundaryControls="auto" 
																			id="dstVendor" 
																			style="background-color: #cccccc;"
																			page="#{semmct001Bean.scrollerPage}" 
																		/>
																	</rich:column>
																</rich:columnGroup>					
															</f:facet>					
														</rich:dataTable>
													</div>
												</center>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:simpleTogglePanel>
					</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- << group 09 -->
					
					
				</center>
			</a4j:form>		
        </h:panelGroup>
        <%-- content group all << --%>

	</rich:panel>
	
	<!-- pop up -->
	<jsp:include page="../../pages/popup/sitecontract-popup.jsp"/>
	<jsp:include page="../../pages/gm/semmct001-popup.jsp"/>
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
						<h:outputText value="#{semmct001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbPayee,frmSave" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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
						<h:outputText value="#{semmct001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" 
										   action="#{navAction.navi}" immediate="true" 
										   reRender="dtbPayee,frmSave" >
							<a4j:actionparam name="navModule" value="gm" />
           					<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
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

<rich:modalPanel id="mdpConfirmDelBookBankDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelBookBankDialog">
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
           					<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteVendorBookBank" />
							<a4j:actionparam name="mode" value="DELETE" />
							<rich:componentControl for="mdpConfirmDelBookBankDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelBookBankDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpSrchVendor" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="เปลี่ยนแปลงเจ้าของสิทธิ์"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupMdpSrchVendor" style="cursor:pointer"/>
				<rich:componentControl for="mdpSrchVendor" attachTo="hidePopupMdpSrchVendor" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmSrchVendor">
		<h:panelGrid width="450">
			<rich:panel>
				<h:panelGroup>
					<h:messages errorClass="ms7red" warnClass="ms7blue"
										infoClass="ms7green" globalOnly="true"
										rendered="#{semmct001Bean.renderPopupVendorMsg}" />
					<table width="95%">
						<tr>
							<td>
								<rich:dataTable width="100%" id="dtbSrchVendor" cellpadding="1" cellspacing="0" border="0"
													var="obj" value="#{semmct001Bean.popupVendorList}" 
													rows="#{semmir012Bean.rowPerPage}"
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
													rowClasses="cur" styleClass="dataTable">
							
									<rich:column>
										<f:facet name="header">
											<h:outputText value="Delete" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<a4j:commandButton action="#{navAction.navi}" 
							     							   image="images/delete.png" style="height: 15; width: 15"
							     							   reRender="frmSrchVendor">
												<a4j:actionparam name="navModule" value="gm" />
							         			<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
												<a4j:actionparam name="methodWithNavi" value="doPopupDeleteVendor" />
												<a4j:actionparam name="vendorMapPayeeId" value="#{obj.rowId}"/>
							         		</a4j:commandButton>
						         		</div>
									</rich:column>
										
										<rich:column sortBy="#{obj.contractNo}">
											<f:facet name="header">
												<h:outputText value="Contract No" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.contractNo}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.vendorCode}" width="15%">
											<f:facet name="header">
												<h:outputText value="Vendor Code" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.vendorCode}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.vendorName}" width="15%">
											<f:facet name="header">
												<h:outputText value="Vendor Name" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.vendorName}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.payeeName}" width="15%">
											<f:facet name="header">
												<h:outputText value="Payee Name" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.payeeName}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.expenseTypeDesc}" width="15%">
											<f:facet name="header">
												<h:outputText value="Expense Type" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.expenseTypeDesc}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="3">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmct001Bean.popupVendorList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<rich:column colspan="3">		
													<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSrchVendor"
												   	maxPages="#{semmct001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												   	id="dstSrchIrClaims" style="background-color: #cccccc;"
												   	page="#{semmct001Bean.scrollerPage}"/>						   
												</rich:column>
											</rich:columnGroup>					
										</f:facet>
									</rich:dataTable>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>
		<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
			<rich:componentControl for="mdpSrchVendor" operation="hide" event="onclick" />
	  	</a4j:commandButton>
	</a4j:form>
</rich:modalPanel>

<a4j:form id="frmConfirmDelete">
	<rich:modalPanel id="mdpConfirmDeleteDialog" autosized="true" >	
		<f:facet name="header">
	    	<h:outputText value="Confirm Delete"></h:outputText>
	    </f:facet>
			<table width="200px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
							<h:outputText value="#{semmct001Bean.msgDoDelete}" styleClass="ms7" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="5" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
							 reRender="frmError,panAccountList,frmConfirmDelete">						
								<a4j:actionparam name="navModule" value="gm" />
				        		<a4j:actionparam name="navProgram" value="SEMMCT001-2" />	
								<a4j:actionparam name="moduleWithNavi" value="gm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
								<a4j:actionparam name="methodWithNavi" value="doDelete" />
								<a4j:actionparam name="deleteMode" value="#{semmct001Bean.deleteMode}" />
											
								<rich:componentControl for="mdpConfirmDeleteDialog" operation="hide" event="oncomplete"  />
							</a4j:commandButton>
							<rich:spacer width="5"/>												
							<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="mdpConfirmDeleteDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
</rich:modalPanel>
</a4j:form>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>

<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_00] -->
	<!-- popupHistory -->
	<rich:modalPanel id="mct001_popupHistory_02" width="1100" height="500" top="20">	
	   	<f:facet name="header">
        	<h:outputText value="ประวัติการแก้ไขข้อมูล (Vendor)" style="width: 100%"/>
       	</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mct001_popupHistory_02" style="cursor:pointer" />
					<rich:componentControl for="mct001_popupHistory_02" attachTo="hide-mct001_popupHistory_02" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="frmVendorHistory">
	     	<h:panelGroup style="width:100%;" styleClass="sem_autoScrollbar">
				<!-- >> group repeat -->
	         	<div align="center">
	                 <h:outputLabel style="color:red;size:20px" value="#{semmct001Bean.msgDataNotFound}" rendered="#{semmct001Bean.renderedMsgDataNotFound}" />
	         	</div>
	         
	         	<div style="position:relative; overflow:hidden; width:100%; height:140px;">
	         	<!-- top >> -->
                <table style="width:100%; height:40px; border-bottom:#97a822 solid 1px; vertical-align:top;">
                    <tr>
                        <td style="width:25%;">
                        	<h:panelGrid columns="2">
	                            <h:outputText value="Vendor Code : " style="font-weight:bold; white-space:nowrap;" styleClass="ms7" />
	                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.vendorCode}" style="font-style:italic;" styleClass="ms7" />
	                    	</h:panelGrid>
                        </td>
                        <td style="width:30%;">
                        	<h:panelGrid columns="2">
	                            <h:outputText value="ชื่อ-นามสกุล : " style="font-weight:bold; white-space:nowrap;" styleClass="ms7" />
	                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.vendorName}" style="font-style:italic;" styleClass="ms7" />
                            </h:panelGrid>
                        </td>
                        <td style="width:25%;">
                        	<h:panelGrid columns="2">
	                            <h:outputText value="TAX ID : " style="font-weight:bold; white-space:nowrap;" styleClass="ms7" />
	                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.tax13}" style="font-style:italic;" styleClass="ms7" />
	                        </h:panelGrid>
                        </td>
                        <td>
                        	<h:panelGrid columns="2">
	                            <h:outputText value="วันที่แก้ไขล่าสุด : " style="font-weight:bold; white-space:nowrap;" styleClass="ms7" />
	                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.strUpdateDt}" style="font-style:italic;" styleClass="ms7" />
	                        </h:panelGrid>
                        </td>
                    </tr>
                </table>
                <!-- top << -->
                
                <!-- summary >> -->
                <table style="width:100%; border-bottom:#97a822 solid 1px; vertical-align:middle;">
                    <tr>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="ที่อยู่ : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.address}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="ตำบล/แขวง : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.district}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="อำเภอ/เขต : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td style="text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.amphur}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="จังหวัด : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.city}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="รหัสไปรษณีย์ : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td colspan="3" style="text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.postCode}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="Tel. : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.telephone}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="Mobile : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td colspan="3" style="text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.mobileNo}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width:15%; text-align:right;">
                            <h:outputText value="สัญญาเลขที่ : " style="font-weight:bold;" styleClass="ms7" />
                        </td>
                        <td colspan="5" style="text-align:left;">
                            <h:outputText value="#{semmct001Bean.vendorMasterHistorySummary.contractNo}" style="font-style: italic;" styleClass="ms7" />
                        </td>
                    </tr>
                </table>
                <!-- summary << -->
            	</div>   
            	 
                <div style="clear:both; height:5px;"></div>
	         	
	         	<!-- scrollable overflow >> -->
	         	<div style="position:relative; overflow-x:hidden; overflow-y:auto; width:100%; height:260px;">

		         	<!-- >> vendor info >> -->
		         	<rich:panel id="pnlVendorHistoryInfo">
						<f:facet name="header">
							<h:outputText value="ข้อมูล Vendor"  styleClass="ms7" />
						</f:facet>
						
						<rich:dataTable id="dataTableVendorHistory" style="width:98%;" cellpadding="1" cellspacing="0" border="1"
			         	var="item_"  value="#{semmct001Bean.vendorMasterHistoryList}" reRender="dataTableVendorHistory, dataScrollVendorHistory" 
			         	rows="#{semmct001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
		                 	<div align="center">
		                        
			                  	<!-- detail >> -->
			                  	<rich:column style="text-align:left;" width="180">
			                    	<f:facet name="header">
				                    	<h:outputText value="ชื่อ-นามสกุล" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.vendorName}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:left;" width="180">
			                    	<f:facet name="header">
				                    	<h:outputText value="ที่อยู่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.address}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="100">
			                    	<f:facet name="header">
				                    	<h:outputText value="ตำบล" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.district}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="80">
			                    	<f:facet name="header">
				                    	<h:outputText value="อำเภอ" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.amphur}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="80">
			                    	<f:facet name="header">
				                    	<h:outputText value="จังหวัด" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.city}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="50">
			                    	<f:facet name="header">
				                    	<h:outputText value="Tel." styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.telephone}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="50">
			                    	<f:facet name="header">
				                    	<h:outputText value="Mobile" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.mobileNo}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="40">
			                    	<f:facet name="header">
				                    	<h:outputText value="เลขที่สัญญา" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.contractNo}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="70">
			                    	<f:facet name="header">
				                    	<h:outputText value="Payee" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="70">
			                    	<f:facet name="header">
				                    	<h:outputText value="วันที่เปลี่ยนแปลง" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.strCreateDt}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;">
			                    	<f:facet name="header">
				                    	<h:outputText value="Update By" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.createBy}" styleClass="contentform" />
			                    </rich:column>
			                  	<!-- detail << -->
			                  	
			                  	<!-- footer >> -->
			                  	<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmct001Bean.vendorMasterHistoryList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="9">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTableVendorHistory" 
											maxPages="10" id="dataScrollVendorHistory" selectedStyleClass="selectScroll" 
											page="#{semmct001Bean.scrollerPage}"/>
										</rich:column>
									</rich:columnGroup>		
								</f:facet>
								<!-- footer << -->
			                  	
							</div>
			        	</rich:dataTable>
			        </rich:panel>
			        <!-- << vendor info << -->
			        
			        <div style="clear:both; height:5px;"></div>
			        
			        <!-- >> bookbank info >> -->
		         	<rich:panel id="pnlBookbankHistoryInfo">
						<f:facet name="header">
							<h:outputText value="ข้อมูล Bookbank" styleClass="ms7" />
						</f:facet>
						
						<rich:dataTable id="dataTableBookbankHistory" style="width:98%;" cellpadding="1" cellspacing="0" border="1"
			         	var="item_"  value="#{semmct001Bean.bookbankHistoryList}" reRender="dataTableBookbankHistory, dataScrollBookbankHistory" 
			         	rows="#{semmct001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
		                 	<div align="center">
		                        
			                  	<!-- detail >> -->
			                  	<rich:column style="text-align:left;" width="200">
			                    	<f:facet name="header">
				                    	<h:outputText value="ชื่อธนาคาร" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.bankName}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:left;" width="200">
			                    	<f:facet name="header">
				                    	<h:outputText value="สาขา" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.bankBranch}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="100">
			                    	<f:facet name="header">
				                    	<h:outputText value="จังหวัด" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.province}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="120">
			                    	<f:facet name="header">
				                    	<h:outputText value="เลขที่บัญชี" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.bankAccNo}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="170">
			                    	<f:facet name="header">
				                    	<h:outputText value="ชื่อบัญชี" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.bankAccName}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" width="70">
			                    	<f:facet name="header">
				                    	<h:outputText value="วันที่เปลี่ยนแปลง" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.strUpdateDt}" styleClass="contentform" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;">
			                    	<f:facet name="header">
				                    	<h:outputText value="Update By" styleClass="contentform" style="white-space:nowrap" />
									</f:facet>
		                        	<h:outputText value="#{item_.dataObj.updateBy}" styleClass="contentform" />
			                    </rich:column>
			                  	<!-- detail << -->
			                  	
			                  	<!-- footer >> -->
			                  	<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmct001Bean.bookbankHistoryList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="6">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTableBookbankHistory" 
											maxPages="10" id="dataScrollBookbankHistory" selectedStyleClass="selectScroll" 
											page="#{semmct001Bean.scrollerPage}"/>
										</rich:column>
									</rich:columnGroup>		
								</f:facet>
								<!-- footer << -->
			                  	
							</div>
			        	</rich:dataTable>
			        </rich:panel>
			        <!-- << bookbank info << -->

			    </div>
			    <!-- scrollable overflow << -->
			    
	        </h:panelGroup>
	        
	        <div style="clear:both; height:10px;"></div>
	        
	        <!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mct001_popupHistory_02" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
	    </a4j:form>  
	</rich:modalPanel>
	<!-- popupHistory -->
	<!-- << [POPUP_00] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->


