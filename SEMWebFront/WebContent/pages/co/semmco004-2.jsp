<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.co.semmco004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco004Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmInfo">
				<table width="96%">
					<tr>
						<td align="right">
							<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" action="#{navAction.navi}"
								reRender="oppContent" >
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
								<a4j:actionparam name="methodWithNavi" value="doBack" />
							</a4j:commandButton>
							<rich:spacer width="10"/>
			            	<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
			            		action="#{navAction.navi}" reRender="panelError,frmInfo">
			            		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO004-2" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
								<a4j:actionparam name="methodWithNavi" value="doSave" />
			            	</a4j:commandButton>
						</td>
					</tr>
				</table>
				<h:panelGrid width="96%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
		                	<tr>
			                  	<td align="right" width="20%" >
			                		<h:outputText id="lblLessorContractNo" value="#{jspMsg['label.lessorContractNo']} :" styleClass="ms7"/>
			                	</td>
			                    <td width="30%">
				                    <h:inputText id="txtLessorContractNo" value="#{semmco004Bean.subRentInfo.lessorContractNo}" disabled="true"/>
			                    </td>
			                    <td align="right" width="20%" >
			                		<h:outputText id="lbllesseeContractNo" value="#{jspMsg['label.lesseeContractNo']} :" styleClass="ms7"/>
			                	</td>
			                    <td width="30%">
			                      	<h:inputText id="txtLesseeContractNo" value="#{semmco004Bean.subRentInfo.lesseeContractNo}" disabled="true"/>
			                      	<rich:spacer width="10"/>
			                      	<a4j:commandButton id="btnNewContractNo" value="#{jspMsg['btn.newContractNo']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmInfo,frmCreateContractNo" 
									rendered="#{semmco004Bean.subRentInfo.subRentType != '01'}"
									oncomplete="#{rich:component('mdpCreateContractNo')}.show(); return false">
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO004-1" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
										<a4j:actionparam name="methodWithNavi" value="initNewContractNo" />
									</a4j:commandButton>
			                      
			                    </td>
		                  	</tr>
		                 	 <tr>
			                  	<td align="right">
			                    	<h:outputText id="lblsiteName" value="#{jspMsg['label.siteName']} :" styleClass="ms7"/> 		                    	
			                    </td>
			                    <td>
			                    	<h:inputText id="txtSiteName" value="#{semmco004Bean.subRentInfo.siteName}" size="30" disabled="true"/>
			                    </td>
			                    <td align="right">
			                    	<h:outputText id="lblLocationId" value="#{jspMsg['label.locationId']} :" styleClass="ms7"/> 		                    	
			                    </td>
			                    <td>
			                    	<h:inputText id="txtLocationId" value="#{semmco004Bean.subRentInfo.locationId}" disabled="true" />
			                    </td>
		                 	 </tr>
		                 	 <tr>
			                  	<td align="right">
			                  		<h:outputText id="lblEffectiveDt" value="#{jspMsg['label.effectiveDt']} :" styleClass="ms7"/>
			                  	</td>
			                  	<td>
			                  		<rich:calendar id="cldEffectiveDt" locale="th" enableManualInput="true" 
		                			datePattern="dd/MM/yyyy" 
									value="#{semmco004Bean.subRentInfo.effectiveDt}"
		                			showWeeksBar="false" 
		                			inputSize="13"
		                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.effectiveDt']}"
									disabled="false">
									</rich:calendar>
			                  	</td>
			                  	<td align="right">
			                  		<h:outputText id="lblExpDt" value="#{jspMsg['label.expireDt']} :" styleClass="ms7"/>
			                  	</td>
			                  	<td>
			                  		<rich:calendar id="cldExpDt" locale="th" enableManualInput="true" 
		                			datePattern="dd/MM/yyyy" 
									value="#{semmco004Bean.subRentInfo.expireDt}"
		                			showWeeksBar="false" 
		                			inputSize="13"
		                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.expireDt']}"
									disabled="false">
									</rich:calendar>
			                  	</td>
		                  	</tr>
		                  	<tr>
			                  	<td align="right">
			                    	<h:outputText id="lblRentAmt" value="#{jspMsg['label.rentAmt']} :" styleClass="ms7"/> 		                    	
			                    </td>
			                    <td>
			                    	<h:inputText id="txtRentAmt" value="#{semmco004Bean.subRentInfo.rentAmt}" styleClass="inputRight">
			                    		<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                    	</h:inputText>
			                    	<rich:spacer width="10" />
			                    	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
			                    </td>
		                  	</tr>
		                  	<tr>
			                  	<td align="right">
			                    	<h:outputText id="lblserviceAmt" value="#{jspMsg['label.serviceAmt']} :" styleClass="ms7"/> 		                    	
			                    </td>
			                    <td>
			                    	<h:inputText id="txtServiceAmt" value="#{semmco004Bean.subRentInfo.serviceAmt}" styleClass="inputRight">
			                    		<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                    	</h:inputText>
			                    	<rich:spacer width="10" />
			                    	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
			                    </td>
		                  	</tr>
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpCreateContractNo" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['title.popup.name']}"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupMdpCreateContractNo" style="cursor:pointer"/>
				<rich:componentControl for="mdpCreateContractNo" attachTo="hidePopupMdpCreateContractNo" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmCreateContractNo">
		<h:panelGrid width="450">
			<rich:panel>
				<h:panelGroup>
					<table width="95%">
						<tr>
							<td align="right" width="40%">
								<h:graphicImage value="images/icon_required.gif"/>
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="60%">
		                      	<h:selectOneMenu id="ddlCompany" value="#{semmco004Bean.popupContractNo.lesseeCompany}">
			                		<f:selectItems value="#{semmco004Bean.companyList}"/>
			                		<a4j:support event="onchange" action="#{semmco004Action.getContractNo}" reRender="frmCreateContractNo" />
			                	</h:selectOneMenu>
		                    </td>
						</tr>
						<tr>
							<td align="right" width="40%">
								<h:graphicImage value="images/icon_required.gif"/>
		                		<h:outputText id="lblRegion" value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="60%">
		                      	<h:selectOneMenu id="ddlRegion" value="#{semmco004Bean.popupContractNo.lesseeRegion}" disabled="true">
			                		<f:selectItems value="#{semmco004Bean.regionList}"/>
			                	</h:selectOneMenu>
		                    </td>
						</tr>
						<tr>
							<td align="right" width="40%">
								<h:graphicImage value="images/icon_required.gif"/>
		                		<h:outputText id="lblSiteType" value="#{jspMsg['label.siteType']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="60%">
		                      	<h:selectOneMenu id="ddlSiteType" value="#{semmco004Bean.popupContractNo.lesseeSiteType}">
			                		<f:selectItems value="#{semmco004Bean.siteTypeList}"/>
			                		<a4j:support event="onchange" action="#{semmco004Action.getContractNo}" reRender="frmCreateContractNo" />
			                	</h:selectOneMenu>
		                    </td>
						</tr>
						<tr>
							<td align="right" width="40%">
		                		<h:outputText id="lblContractNo" value="#{jspMsg['label.no']} :" styleClass="ms7"/>
		                	</td>
		                    <td width="60%">
		                    	<h:inputText id="txtContractNo1" value="#{semmco004Bean.popupContractNo.contractNo1}" size="7" disabled="true"/>
		                    	<rich:spacer width="5" />
		                    	<h:inputText id="txtContractNo2" value="#{semmco004Bean.popupContractNo.contractNo2}" size="5" maxlength="5" 
		                    	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                    	<h:outputText id="lblDot" value="." styleClass="ms7"/>
		                    	<h:inputText id="txtContractNo3" value="#{semmco004Bean.popupContractNo.contractNo3}" size="2" maxlength="2"
		                    	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                    </td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<a4j:commandButton id="btnOk" value="#{jspMsg['btn.ok']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmCreateContractNo,frmInfo" >
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO004-2" />
									<a4j:actionparam name="moduleWithNavi" value="co" />
									<a4j:actionparam name="actionWithNavi" value="SEMMCO004" />
									<a4j:actionparam name="methodWithNavi" value="doOk" />
									<rich:componentControl for="mdpCreateContractNo" operation="hide" event="oncomplete" />
								</a4j:commandButton>
								<rich:spacer width="10"></rich:spacer>
				            	<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button">
				            		<rich:componentControl for="mdpCreateContractNo" operation="hide" event="onclick" />
				            	</a4j:commandButton>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>