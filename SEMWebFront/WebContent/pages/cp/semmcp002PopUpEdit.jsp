<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<jsp:include page="../../pages/popup/vendorSupplier-popup.jsp" />
<jsp:include page="../../pages/el/semmel006_popupAddVendor.jsp" />

<f:loadBundle basename="resources.construction.semmcp002-2" var="jspMsg"/>
    <rich:modalPanel id="popupEditImportWarrantConStruc" width="900" autosized="true" minWidth="250" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg['label.popup.editMeter']}"></h:outputText>
        </f:facet>
       <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupEditImportWarrantConStruc" style="cursor:pointer"/>
                    <rich:componentControl for="popupEditImportWarrantConStruc" attachTo="hidePopupEditImportWarrantConStruc" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupSave">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmcp002Bean.renderedMsgFormPopup}">
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
										<h:inputText id="txtAreaName" value="#{semmcp002Bean.permistionWarrant.siteName}"  style="width:180px;" maxlength="50" />
									</td>
									
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7" />
									</td>
									<td >
										<h:inputTextarea id="txtAddress" value="#{semmcp002Bean.permistionWarrant.address}" rows="3" cols="60" style="width:600px;" />
									</td>
								</tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.tumbon']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtTumbon" value="#{semmcp002Bean.permistionWarrant.tumbon}" style="width:180px;" maxlength="15"  />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlPopAmphur" value="#{semmcp002Bean.permistionWarrant.amphur}" >
												<f:selectItems value="#{semmcp002Bean.amphurList}"/>
										 </h:selectOneMenu>
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.city']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlPopProvince" value="#{semmcp002Bean.permistionWarrant.province}" onchange="GetSiteAmphurListJS();" >
												<f:selectItems value="#{semmcp002Bean.provinceList}"/>
										 </h:selectOneMenu>
										<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlPopAmphur" action="#{semmcp002Action.getSiteAmphurList}"/>
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.postCode']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtPostCode" value="#{semmcp002Bean.permistionWarrant.postCode}" style="width:180px;" maxlength="15"  />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.typeAttenna']}" styleClass="ms7" />
									</td>
									<td>
									<h:selectOneMenu id="ddlPopTypeAttenna" value="#{semmcp002Bean.permistionWarrant.typeAttenna}"  >
												<f:selectItems value="#{semmcp002Bean.typeAttennaList}"/>
									</h:selectOneMenu>
									</td>
                                </tr>
                                
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.hightAttenna']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtLine" value="#{semmcp002Bean.permistionWarrant.hightAttenna}" style="width:180px;" maxlength="100" />
									</td>
                                </tr>
                                
                                
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['lable.supplier']}" styleClass="ms7" />
									</td>
									<td>
										<h:panelGroup id="pnlDisplayVendorCode">
								                			<h:inputText id="txtSupplier" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorFullName} " onchange="GetLocationListJS();"	readonly="true" disabled="true"	size="30" maxlength="255"/>
								                			<a4j:jsFunction name="GetLocationListJS" reRender="frmSaveData,pnlShowApproveConstruct" />
								                			<rich:spacer width="2"></rich:spacer>
								            				<a4j:commandButton id="btnPopupSearchSupplier"  
								            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
															value="..." 
															reRender="popupVendorSupplier" 
										            		action="#{navAction.navi}">
											            		<a4j:actionparam name="navModule" value="cp" />
																<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
																<a4j:actionparam name="moduleWithNavi" value="common" />
																<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																<a4j:actionparam name="popupType" value="SUPPLIER" />
																<a4j:actionparam name="page" value="semmcp002" />
								            				</a4j:commandButton>
						                				</h:panelGroup>
						                				
									</td>
                                </tr>
                                
                                 <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['lable.department']}" styleClass="ms7" />
									</td>
									<td>
										
										<h:panelGroup id="pnlDisplayVendorName">
						                					<h:inputText id="txtLocalName"  value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorFullNameLocal}" onchange="GetLocationListJS();" 	readonly="true" disabled="true"	 size="30" maxlength="255" /> 
									                			<a4j:jsFunction name="GetLocationListJS" reRender="frmSaveData,pnlShowApproveConstruct" />
									                			<rich:spacer width="2"></rich:spacer>
									            				<a4j:commandButton id="btnPopupLocalName"  
									            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
																value="..." 
																reRender="popupVendorSupplier"
											            		action="#{navAction.navi}" >
												            		<a4j:actionparam name="navModule" value="cp" />
																	<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
																	<a4j:actionparam name="moduleWithNavi" value="common" />
																	<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																	<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																	<a4j:actionparam name="popupType" value="LOCAL_DEPART" />
																	<a4j:actionparam name="page" value="semmcp002" />
																	<a4j:actionparam name="provinceId" value="#{semmcp001Bean.constructionPermissionSearchSP.tokenProvince}"/>
									            				</a4j:commandButton>
					                					</h:panelGroup>
						                				
									</td>
                                </tr>
                                
                                
								<tr>
                                	<td align="left" width="20%" colspan="4">
										<a4j:commandButton id="btnSave0020" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupEditImportWarrantConStruc')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmcp002Bean.renderedSavePage0Button}">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP002-0" />
										<a4j:actionparam name="moduleWithNavi" value="cp" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopupFirstPage" />
									</a4j:commandButton>
									<a4j:commandButton id="btnSave0022" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupEditImportWarrantConStruc')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmcp002Bean.renderedSavePage2Button}">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
										<a4j:actionparam name="moduleWithNavi" value="cp" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopup" />
									</a4j:commandButton>
									&nbsp;
									<a4j:commandButton id="btnUpdateStatus" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
										action="#{navAction.navi}" oncomplete="#{rich:component('popupEditImportWarrantConStruc')}.hide();" style="width: 70px"
										 reRender="oppContent"  rendered="#{semmcp002Bean.renderer['btnUpdateStatus']}">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
										<a4j:actionparam name="moduleWithNavi" value="cp" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
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