<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:modalPanel id="popupFrmEdit" width="330" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']} - #{semmir006Bean.actModeDisplay}"></h:outputText>
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
				rendered="#{semmir006Bean.renderedMsgFormTop}">
		 		<f:facet name="header">
                     <h:outputText value="Entered Data Status:"></h:outputText>
                </f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                </f:facet>
		</rich:messages>
		<rich:panel>
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				  	<h:panelGrid>
				  		<h:panelGroup>
				  		<table width="100%">
				  			<tr>
				  				<td align="right">
						    		<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
						    	</td>
						    	<td>	
						    		<h:selectOneMenu id="somCompany" value="#{semmir006Bean.tmpSave.company}">
										<f:selectItems value="#{semmir006Bean.companyList}" />
			               			 </h:selectOneMenu>
			               		</td>
			           		</tr>
			                <tr>
			                	<td align="right">
				                	<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>		
								</td>
								<td>	
									<h:selectOneMenu id="somNetworkType" value="#{semmir006Bean.tmpSave.networkType}">
				                		<f:selectItems value="#{semmir006Bean.networkTypeList}" />
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
		                	<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
								</td>
								<td colspan="2">
									<h:inputText id="txtContractNo" value="#{popupSiteContractBean.contractNo}"  
						    			disabled="#{semmir006Bean.viewMode}" size="10">
										<a4j:support event="onblur" action="#{popupSiteContractAction.getSiteInfoId}"  
								              reRender="txtContractNo" />						    		
						    		</h:inputText>
						    		<rich:spacer width="2" />
						    		<a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
										value="..."  reRender="popupSearchContractNo,popupFrmSearch" 
						            	action="#{navAction.navi}" rendered="#{!semmir006Bean.viewMode}">
						            	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR006-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
										<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNoMir006" />
										<a4j:actionparam name="page" value="semmct001-2" />   
			            			</a4j:commandButton>
								</td>
							</tr>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.insured']}" styleClass="ms7"/>
								</td>
								<td colspan="2">
									<h:inputText id="txtInsuredAmt" value="#{semmir006Bean.tmpSave.insuredAmt}" 
										onkeypress="return numberformat.keyPressDecimalCustomize(15, this, event);" 
										onblur="return numberformat.moneyFormat(this);" 
				                		onfocus="return numberformat.setCursorPosToEnd(this);" 
				                		maxlength="18" styleClass="inputRight" size="18">
				                		<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="15" maxFractionDigits="2" />
				                	</h:inputText>
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.effectiveDate']}" styleClass="ms7"/>
								</td>
								<td colspan="2">	
									<rich:calendar id="effDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmir006Bean.tmpSave.effDate}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px">
									</rich:calendar>
								</td>
							</tr>
						</table>
						</h:panelGroup>
					</h:panelGrid>
						<h:panelGrid columns="3">
						  <a4j:commandButton  id="hidePopUpEdit" styleClass="rich-button" action="#{navAction.navi}" value="Save" 
						  	oncomplete="if(#{semmir006Bean.popupClose == 'true'})#{rich:component('popupFrmEdit')}.hide();"
							reRender="frmEdit,frmError,pnlSearchResult,dtbInsured">
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR006-1" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR006" />
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


