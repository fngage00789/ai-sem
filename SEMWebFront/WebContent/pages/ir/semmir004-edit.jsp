<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:modalPanel id="popupFrmEdit" width="350" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']} - #{semmir004Bean.actModeDisplay}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpEdit" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmEdit" attachTo="hidePopUpEdit" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	<h:form id="frmEdit"> 
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
				rendered="#{semmir004Bean.renderedMsgFormTop}">
		 		<f:facet name="header">
                     <h:outputText value="Entered Data Status:"></h:outputText>
                </f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                </f:facet>
		</rich:messages>
		<rich:panel>
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				  	<h:panelGrid columns="2">
				  			<h:panelGroup>
				  				<div align="right">
						    		<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
						    	</div>
						    </h:panelGroup>
						    <h:selectOneMenu id="somCompany" value="#{semmir004Bean.tmpSave.company}" 
						    	disabled="#{semmir004Bean.viewMode}">
			                		<f:selectItems value="#{semmir004Bean.companyList}" />
			                </h:selectOneMenu>
			                <h:panelGroup>
				  				<div align="right">
									<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>		
								</div>
							</h:panelGroup>
							<h:selectOneMenu id="somNetworkType" value="#{semmir004Bean.tmpSave.networkType}" 
								disabled="#{semmir004Bean.viewMode}">
		                				<f:selectItems value="#{semmir004Bean.networkTypeList}" />
		                	</h:selectOneMenu>
		                	<h:panelGroup>
				  				<div align="right">
									<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>	
								</div>
							</h:panelGroup>	
							<h:selectOneMenu id="somTransferType" value="#{semmir004Bean.tmpSave.transferType}" 
								disabled="#{semmir004Bean.viewMode}">
			                			<f:selectItems value="#{semmir004Bean.transferTypeList}" />
			                </h:selectOneMenu>
			                <h:panelGroup>
				  				<div align="right">	
									<h:outputText value="#{jspMsg['label.lossType']}" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<h:selectOneMenu id="lossType" value="#{semmir004Bean.tmpSave.lossType}" 
								disabled="#{semmir004Bean.viewMode}">
			                			<f:selectItems value="#{semmir004Bean.lossTypeList}" />
			                </h:selectOneMenu>	
			                <h:panelGroup>
				  				<div align="right">
									<h:outputText value="#{jspMsg['label.deductible']}" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<h:inputText id="txtDeduct_VAL" value="#{semmir004Bean.tmpSave.deductAmt}" 
								onkeypress="return numberformat.keyPressDecimalCustomize(15, this, event);" 
								onblur="return numberformat.moneyFormat(this);" 
				                onfocus="return numberformat.setCursorPosToEnd(this);" 
				                maxlength="18" styleClass="inputRight" size="18">
				                <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="15" maxFractionDigits="2" />
				            </h:inputText>
							<h:panelGroup>
				  				<div align="right">
									<h:outputText value="#{jspMsg['label.effectiveDate']}" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<rich:calendar id="effDate" locale="th" enableManualInput="true" 
								   datePattern="dd/MM/yyyy" 
								   value="#{semmir004Bean.tmpSave.effDate}"
								   showWeeksBar="false"
								   inputSize="10"
								   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							   	   cellWidth="15px" cellHeight="20px">
							</rich:calendar>
					</h:panelGrid>	
					<h:panelGrid columns="3">
						  <a4j:commandButton styleClass="rich-button" action="#{navAction.navi}" value="Save" 
						  		oncomplete="if(#{semmir004Bean.popupClose == 'true'})#{rich:component('popupFrmEdit')}.hide();"
								reRender="frmEdit,frmError,pnlSearchResult,dtbMda">
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR004-1" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR004" />
								<a4j:actionparam name="methodWithNavi" value="doSave" />	
						  </a4j:commandButton>
						  <a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmEdit" operation="hide" event="onclick" />
						  </a4j:commandButton>
						</h:panelGrid>
				  </table>
		</rich:panel>
	 </h:form>
</rich:modalPanel>


