<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.el.semmel003-2" var="jspMsg"/>
    <rich:modalPanel id="popupEditMeterData" width="900" autosized="true" minWidth="250" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg['label.popup.editMeter']}"></h:outputText>
        </f:facet>
       <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupEditMeterData" style="cursor:pointer"/>
                    <rich:componentControl for="popupEditMeterData" attachTo="hidePopupEditMeterData" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupSave">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel003Bean.renderedMsgFormPopup}">
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
                <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                   	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.areaCodeElectric']}" styleClass="ms7" />
									</td>
									<td colspan="3">
										<h:inputText id="txtAreaCodeElectric" value="#{semmel003Bean.areaCodeElectric}" style="width:180px;" maxlength="15" />
									</td>
									
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.areaElectric']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtAreaElectric" value="#{semmel003Bean.areaElectric}" style="width:180px;" maxlength="15" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.memberWithArea']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtMemberWithArea" value="#{semmel003Bean.memberWithArea}" style="width:180px;" maxlength="15" />
									</td>
                                </tr>
                                 <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.numberMeter']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtNumberMeter" value="#{semmel003Bean.numberMeter}" style="width:180px;" maxlength="15" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.meterType']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtMeterType" value="#{semmel003Bean.meterType}" style="width:180px;" maxlength="15" />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.meterSize']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtMeterSize" value="#{semmel003Bean.meterSize}" style="width:180px;" maxlength="15" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.rateOfElectric']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtRateOfElectric" value="#{semmel003Bean.rateOfElectric}" style="width:180px;" maxlength="15" />
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.elActiveDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldElActiveDt" locale="th/TH" enableManualInput="true" 
														datePattern="dd/MM/yyyy" value="#{semmel003Bean.elActiveDt}"
														oninputblur="validateRichCalendarFromTo('cldElActiveDt');"
														oncollapse="validateRichCalendarFromTo('cldElActiveDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.line']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtLine" value="#{semmel003Bean.line}" style="width:180px;" maxlength="15" />
									</td>
                                </tr>
                            	<tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.elTransformersBrand']}" styleClass="ms7" />
									</td>
									<td colspan="2">
										<h:inputText id="txtElTransformersBrand" value="#{semmel003Bean.elTransformersBrand}" style="width:180px;" maxlength="15" />
										&nbsp;
										<h:selectOneRadio id="slElLevel" value="#{semmel003Bean.elLevel}" styleClass="ms7" >
					                        <f:selectItem itemLabel="#{jspMsg['label.highVolt']}" itemValue="H" />
					                        <f:selectItem itemLabel="#{jspMsg['label.lowVolt']}" itemValue="L" />
					                    </h:selectOneRadio>
									
									</td>
                                </tr>
                                <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.elTransformersNumber']}" styleClass="ms7" />
									</td>
									<td colspan="3">
										<h:inputText id="txtElTransformersNumber" value="#{semmel003Bean.elTransformersNumber}" style="width:180px;" maxlength="15" />
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.elTransformersSize']}" styleClass="ms7" />
									</td>
									<td>
										<h:inputText id="txtElTransformersSize" value="#{semmel003Bean.elTransformersSize}" style="width:180px;" maxlength="15" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.elTransformersInstallDt']}" styleClass="ms7" />
									</td>
									<td><rich:calendar id="cldelTransformersInstallDt" locale="th/TH" enableManualInput="true"
														datePattern="dd/MM/yyyy" value="#{semmel003Bean.elTransformersInstallDt}"
														oninputblur="validateRichCalendarFromTo('cldelTransformersInstallDt');"
														oncollapse="validateRichCalendarFromTo('cldelTransformersInstallDt');"
														showWeeksBar="false" inputStyle="width:160px;" />
									</td>
                                </tr>
                                 <tr>
                                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
									</td>
									<td colspan="3">
										<h:inputTextarea id="txtremark" value="#{semmel003Bean.remark}" rows="3" cols="60" style="width:200px;"/>
									</td>
								</tr>
								<tr>
                                	<td align="left" width="20%" colspan="4">
										<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										action="#{navAction.navi}"  oncomplete="#{rich:component('popupEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent" rendered="#{semmel003Bean.renderer['btnSave']}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL003-2" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
										<a4j:actionparam name="methodWithNavi" value="doSavePopup" />
									</a4j:commandButton>&nbsp;
									<a4j:commandButton id="btnUpdateStatus" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
										action="#{navAction.navi}" oncomplete="#{rich:component('popupEditPermission')}.hide();" style="width: 70px"
										 reRender="oppContent"  rendered="#{semmel003Bean.renderer['btnUpdateStatus']}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL003-2" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
										<a4j:actionparam name="methodWithNavi" value="doCancelPopup" />
									</a4j:commandButton>&nbsp;
								</tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                <!-- end content criteria -->
        </a4j:form>
    </rich:modalPanel>