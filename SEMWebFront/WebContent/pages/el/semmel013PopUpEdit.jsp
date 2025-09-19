<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<jsp:include page="../../pages/popup/vendorSupplier-popup.jsp" />
<jsp:include page="../../pages/el/semmel006_popupAddVendor.jsp" />

<f:loadBundle basename="resources.el.semmel013-2" var="jspMsg"/>
    <rich:modalPanel id="popupProxyEditPermission" width="900" autosized="true" minWidth="250" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg['label.popup.editMeter']}"></h:outputText>
        </f:facet>
       <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupProxyEditPermission" style="cursor:pointer"/>
                    <rich:componentControl for="popupProxyEditPermission" attachTo="hidePopupProxyEditPermission" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupSave">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel013Bean.renderedMsgFormPopup}">
                            <f:facet name="header">
                                <h:outputText value="Entered Data Status:"></h:outputText>
                            </f:facet>
                            <f:facet name="errorMarker">
                                 <h:graphicImage value="images/error.gif" />  
                            </f:facet>
                    </rich:messages>
            </a4j:form>
        </h:panelGrid>
       <a4j:form id="popupFrmSave"> 
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                 <rich:panel id="popupPnlFrmSave" styleClass="sem_autoScrollbar"  >
                <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            	<table width="100%">
                                <tr>
                                   	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.areaName']}" styleClass="ms7" />
									</td>
									<td >
										<h:inputText id="txtAreaName" value="#{semmel013Bean.permistionWarrant.siteName}" style="width:180px;" maxlength="15" />
									</td>
									
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7" />
									</td>
									<td >
										<h:inputTextarea id="txtAddress"  value="#{semmel013Bean.permistionWarrant.address}" rows="3" cols="60" style="width:600px;"  />
									</td>
								</tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.tumbon']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtTumbon"  value="#{semmel013Bean.permistionWarrant.tumbon}" style="width:180px;" maxlength="15"  />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlPopAmphur" value="#{semmel013Bean.permistionWarrant.amphur}" >
												<f:selectItems value="#{semmel013Bean.amphurList}"/>
										 </h:selectOneMenu>
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.city']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlPopProvince" value="#{semmel013Bean.permistionWarrant.province}" onchange="GetSiteAmphurListJS();" >
												<f:selectItems value="#{semmel013Bean.provinceList}"/>
										 </h:selectOneMenu>
										<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlPopAmphur" action="#{semmel013Action.getSiteAmphurList}"/>
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.postCode']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtPostCode" value="#{semmel013Bean.permistionWarrant.postCode}" style="width:180px;" maxlength="15"  />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.line']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtLine" value="#{semmel013Bean.permistionWarrant.phase}" style="width:180px;" maxlength="100" />
									</td>
                                </tr>
                                 <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.typeElectric']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlTypeElectric" value="#{semmel013Bean.permistionWarrant.electricType}"  style="width:180px;">
												<f:selectItems value="#{semmel013Bean.typeUseElectricList}" />
										</h:selectOneMenu>
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['lable.supplier']}" styleClass="ms7" />
									</td>
									<td>
										
										<h:panelGroup id="pnlDisplayVendorCode">
								                			<h:inputText id="txtVendorCode" 
								                			value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorCode} "	
								                			readonly="true" disabled="true"	style="width : 160px" maxlength="255"/>	
								                			
								                			<a4j:jsFunction name="GetLocationListJS" 
								                			reRender="pnlDisplayVendorCode, pnlDisplayVendorName" />
								                			<rich:spacer width="2"></rich:spacer>
								            				
								            				<a4j:commandButton id="btnPopupSearchSupplier"  
								            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
															value="..." disabled="#{semmel001Bean.viewMode}"
															reRender="popupVendorSupplier" 
										            		action="#{navAction.navi}">
											            		<a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL013PopUpEdit" />
																<a4j:actionparam name="moduleWithNavi" value="common" />
																<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																<a4j:actionparam name="popupType" value="SUPPLIER" />
																<a4j:actionparam name="page" value="semmel013" />
																<a4j:actionparam name="contractNo" value="#{semmel013Bean.permistionWarrant.contractNo}"/>
								            				</a4j:commandButton>
								            				
								            				<rich:spacer width="5"></rich:spacer>
								            				
								            				<a4j:commandButton id="btnVendorMaster" value="#{jspMsg['label.vendorMaster']}" 
															styleClass="rich-button" 
															disabled="#{semmel001Bean.viewMode}"
															rendered="false"
										            		action="#{navAction.navi}" reRender="oppContent" style="width:100">
															    <a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
																<a4j:actionparam name="moduleWithNavi" value="el" />
																<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
																<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
																<a4j:actionparam name="contractNo" value="#{semmel001Bean.manageWrapper.electricManage.contractNo}" />
																
																<a4j:actionparam name="navModuleFrom" value="el" />
																<a4j:actionparam name="navProgramFrom" value="SEMMEL001-12" />
																<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL006" />
															</a4j:commandButton>
								            				
						                				</h:panelGroup>
						                				
						                				<h:panelGroup id="pnlDisplayVendorName">
								                			<h:inputText id="txtVendorName" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorName} "	readonly="true" disabled="true" style="width : 160px"	maxlength="255"/>
						                				</h:panelGroup>
						                				
						                				
						                				
						                				
						                				
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
									</td>
									<td colspan="3">
										<h:inputTextarea id="txtRemark" value="#{semmel013Bean.permistionWarrant.remark}" rows="3" cols="60" style="width:300px;"/>
									</td>
								</tr>
								<tr>
                                	<td align="left" width="20%" colspan="4">
										<a4j:commandButton id="btnSavePage0" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupProxyEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmel013Bean.renderedSavePage0Button}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL013-0" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopupFirstPage" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnSavePage2" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupProxyEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmel013Bean.renderedSavePage2Button}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL013-2" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopup" />
									</a4j:commandButton>&nbsp;
									<a4j:commandButton id="btnUpdateStatus" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
										action="#{navAction.navi}" oncomplete="#{rich:component('popupProxyEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent"  rendered="#{semmel013Bean.renderer['btnSave']}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL013-2" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
										<a4j:actionparam name="methodWithNavi" value="doCancelPopup" />
									</a4j:commandButton>&nbsp;
									</td>
								</tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                <!-- end content criteria -->
        </rich:panel>
        </a4j:form>
    </rich:modalPanel>