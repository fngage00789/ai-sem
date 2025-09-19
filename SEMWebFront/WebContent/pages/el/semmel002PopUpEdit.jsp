<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.el.semmel002-3" var="jspMsg"/>
    <rich:modalPanel id="popupEditPermission" width="1200" autosized="true" minWidth="250" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg['label.popup.editMeter']}"></h:outputText>
        </f:facet>
       <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupEditPermission" style="cursor:pointer"/>
                    <rich:componentControl for="popupEditPermission" attachTo="hidePopupEditPermission" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupSave">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel002Bean.renderedMsgFormPopup}">
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
                 <rich:panel id="popupPnlFrmSave"   >
                
							<rich:panel id="pnlEditElWarrant" >
							<center>
								<rich:dataTable id="dtbEditElWarrant"  cellpadding="0" cellspacing="0" border="3"  
								var="uploadPopup"  value="#{semmel002Bean.uploadElPerListForPopup}" 
								reRender="dtbEditElWarrant" 
								rowKeyVar="rowIndex"
								rows="#{semmel002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contractNo']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.contractNo}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.siteName']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.siteName}"/>
									</div>
								</rich:column>	
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.docType']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.docType}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.reqDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.reqDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.responeDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.responeDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendDocDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.sentDocDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contracCopyDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.contractCopyDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendSamDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadPopup.sentSamDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbEditElWarrant" 
										maxPages="10" id="dstEditElWarrant" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
							</center>
						</rich:panel>
                
                <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                   	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.reqDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelReqDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel002Bean.permistionWarrant.reqDt}"
														oninputblur="validateRichCalendarFromTo('cldelReqDt');"
														oncollapse="validateRichCalendarFromTo('cldelReqDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.responeDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelResponeDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel002Bean.permistionWarrant.responeDt}"
														oninputblur="validateRichCalendarFromTo('cldelResponeDt');"
														oncollapse="validateRichCalendarFromTo('cldelResponeDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
								</tr>
                                
                                
                                <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.sendDocDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelSendDocDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel002Bean.permistionWarrant.sentDocDt}"
														oninputblur="validateRichCalendarFromTo('cldelSendDocDt');"
														oncollapse="validateRichCalendarFromTo('cldelSendDocDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
                                
                                   	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.contracCopyDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelContracCopyDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel002Bean.permistionWarrant.contractCopyDt}"
														oninputblur="validateRichCalendarFromTo('cldelContracCopyDt');"
														oncollapse="validateRichCalendarFromTo('cldelContracCopyDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
								</tr>
                                
                                
                                <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.sendSamDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelSendSamDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel002Bean.permistionWarrant.sentSamDt}"
														oninputblur="validateRichCalendarFromTo('cldelSendSamDt');"
														oncollapse="validateRichCalendarFromTo('cldelSendSamDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.sendSamUser']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtSendSamUser" value="#{semmel002Bean.permistionWarrant.sentSamUser}" style="width:180px;" maxlength="15" />
									</td>
								</tr>
                                
                                
                                <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popup.sendSamTel']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtSendSamTel" value="#{semmel002Bean.permistionWarrant.sentSamTel}" style="width:180px;" maxlength="15" />
									</td>
								</tr>
								<tr>
                                	<td align="left" width="20%" colspan="4">
										<a4j:commandButton id="btnSave001" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmel002Bean.renderedSavePage1Button}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopupFirstPage" />
										<a4j:actionparam name="rowIndex" value="#{semmel002Bean.permistionWarrant.rowId}"/>
									</a4j:commandButton>
									<a4j:commandButton id="btnSave003" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmel002Bean.renderedSavePage3Button}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL002-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopup" />
										<a4j:actionparam name="rowIndex" value="#{semmel002Bean.permistionWarrant.rowId}"/>
									</a4j:commandButton>
									
									&nbsp;
									<a4j:commandButton id="btnUpdateStatus" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
										action="#{navAction.navi}" oncomplete="#{rich:component('popupEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent"  rendered="#{semmel002Bean.renderer['btnUpdateStatus']}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL002-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
										<a4j:actionparam name="methodWithNavi" value="doCancelPopup" />
									</a4j:commandButton>&nbsp;
								</tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                <!-- end content criteria -->
        </rich:panel>
        </a4j:form>
    </rich:modalPanel>