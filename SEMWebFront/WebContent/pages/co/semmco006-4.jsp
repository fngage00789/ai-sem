<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.co.semmco006" var="jspMsg"/>
<rich:modalPanel id="popupEditDuty" width="800" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.panel.editDuty']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupEditDuty" style="cursor:pointer"/>
				<rich:componentControl for="popupEditDuty" attachTo="hidePopupEditDuty" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError004">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco006Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="popupFrmEditDuty"> 
		<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
				<rich:panel id="pnlDuty">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.dutyAmt']}"/>
						</f:facet>
							<table width="95%">
							<tr>
							<td align="right" width="20%">
							<h:graphicImage id="reqAmt" value="images/icon_required.gif"  styleClass="ms7" style="#{semmco006Bean.contract.dutyPayStatus eq '00' ? 'display:none;':''}"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.dutyAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="25%">
                			 <h:inputText id="txtDutyAmt" value="#{semmco006Bean.contract.dutyAmt}" 
       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
       						 onblur="return numberformat.moneyFormat(this);"
       						 onfocus="return numberformat.setCursorPosToEnd(this);"
       						 maxlength="16" 
       						 disabled="#{not semmco006Bean.renderedUpdateHistory}"
       						 styleClass="inputRight"
       						 size="18">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
                			 <rich:spacer width="2"></rich:spacer>
                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
		                	<td align="right" width="20%" >
		                	<h:outputText value="#{jspMsg['label.copyDutyFlag']}" styleClass="ms7"/>
                			</td>
                			<td width="25%">
		                			<table width="100%">
		                			<tr>
		                			<td>
		                			<h:inputText id="txtCopyDutyFlag" value="#{semmco006Bean.contract.copyDuty}"  size="5"  disabled="#{not semmco006Bean.renderedUpdateHistory}"/>
		                			</td>
		                			<td>
		                			<h:outputText value="#{jspMsg['label.copy']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<h:inputText id="txtCoppyDutyAmt" value="#{semmco006Bean.contract.copyDutyAmt}" 
		       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		       						 onblur="return numberformat.moneyFormat(this);"
		       						 onfocus="return numberformat.setCursorPosToEnd(this);"
		       						 maxlength="16" 
		       						 styleClass="inputRight"
		       						 disabled="#{not semmco006Bean.renderedUpdateHistory}"
		       						 size="18">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                			</h:inputText>
	                			</td>
	                			<td align="left">
	                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			</td>
	                			</tr>
	                			</table>
	                		</td>
                			</tr>
                			<tr>
							<td align="right" width="25%">
							<h:graphicImage id="reqDt" value="images/icon_required.gif" style="#{semmco006Bean.contract.dutyPayStatus eq '00' ? 'display:none;':''}"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.dutyPayDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="35%">
							<rich:calendar id="cldDutyPayDate" locale="th" enableManualInput="true"  
							datePattern="dd/MM/yyyy" 
							disabled="#{not semmco006Bean.renderedUpdateHistory}"
							value="#{semmco006Bean.contract.dutyPayDt}" 
							showWeeksBar="false" 
							inputSize="13"
							oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.dutyPayDate']}">
							</rich:calendar> 
		                	</td>
		                	<td align="right" width="25%" >
		                		<h:outputText value="#{jspMsg['label.otherDutyFlag']}" styleClass="ms7"/>
                			</td>
                			<td width="20%"> 
                			<h:inputText id="txtOtherDutyAmt" value="#{semmco006Bean.contract.otherDutyAmt}" 
       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
       						 onblur="return numberformat.moneyFormat(this);"
       						 onfocus="return numberformat.setCursorPosToEnd(this);"
       						 maxlength="16" 
       						 disabled="#{not semmco006Bean.renderedUpdateHistory}"
       						 styleClass="inputRight"
       						 size="18">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
                			 <rich:spacer width="2"></rich:spacer>
                			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			</td>
	                		</tr>
	                		<tr>
							<td align="right" width="25%">
							<h:outputText value="#{jspMsg['label.dutyPayStatus']}" styleClass="ms7"/>
                			</td>
                			<td width="75%" colspan="3">
                			<h:selectOneRadio id="rbtDutyPayStatus" value="#{semmco006Bean.contract.dutyPayStatus}"  styleClass="ms7" rendered="true"  
                				disabled="#{not semmco006Bean.renderedUpdateHistory}" 
                				onclick="checkDutyPay(this.value);">
                				<f:selectItem itemValue="00" itemLabel="#{jspMsg['label.dutyPayStatus00']} " />
                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.dutyPayStatus01']}"/>
                			</h:selectOneRadio>
                			<script>
                				function checkDutyPay(val){
									if(val == "01"){
										document.getElementById("incContent:popupFrmEditDuty:reqAmt").style.display = '';
										document.getElementById("incContent:popupFrmEditDuty:reqDt").style.display = '';
									}else{
										document.getElementById("incContent:popupFrmEditDuty:reqAmt").style.display = 'none';
										document.getElementById("incContent:popupFrmEditDuty:reqDt").style.display = 'none';
									}
                    			}
                			</script>
		                	</td>
	                		</tr>
	                		<tr>
	                		<td colspan="4">
	                		<h:panelGrid columns="2" id="grdPopupCommand">
							<a4j:commandButton id="btnUpdateDuty" value="#{jspMsg['btn.save']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError004,dtbContractStatus" 
							disabled="#{not semmco006Bean.renderedUpdateHistory}"
							oncomplete="if(#{semmco006Bean.popupClose == 'true'})#{rich:component('popupEditDuty')}.hide();">
							<a4j:actionparam name="navModule" value="co" />
							<a4j:actionparam name="navProgram" value="SEMMCO006" />
							<a4j:actionparam name="moduleWithNavi" value="co" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateDutyContract" />
							</a4j:commandButton>
							<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true" disabled="#{not semmco006Bean.renderedUpdateHistory}">
								<rich:componentControl for="popupEditDuty" operation="hide" event="onclick" />
							</a4j:commandButton>
							</h:panelGrid>
	                		</td>
	                		</tr>
							</table>
				</rich:panel>
				</h:panelGrid>
				</a4j:form>
</rich:modalPanel>

