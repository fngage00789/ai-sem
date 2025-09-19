<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:modalPanel id="popupFrmEdit" width="500" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Edit"></h:outputText>
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
		<rich:panel>
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				  	<h:panelGrid width="450">
				  		<h:panelGroup>
				  		<table width="100%">
				  			<tr>
				  				<td>
						    		<h:outputText value="Company :" styleClass="ms7"/>
						    	</td>
						    	<td colspan="2">	
						    		<h:selectOneMenu id="somCompany" value="#{semir005Bean.insured.company}">
										<f:selectItems value="#{semir005Bean.companyList}" />
			               			 </h:selectOneMenu>
			               		</td>
			           		</tr>
			                <tr>
			                	<td>
				                	<h:outputText value="ประเภท :" styleClass="ms7"/>		
								</td>
								<td colspan="2">	
									<h:selectOneMenu id="networkType" value="#{semir005Bean.insured.networkType}">
				                		<f:selectItems value="#{semir005Bean.networkTypeList}" />
				                	</h:selectOneMenu>
		                		</td>
		                	</tr>
		                	<tr>
		                		<td>
									<h:outputText value="Location ID :" styleClass="ms7"/>		
								</td>
								<td colspan="2">	
									<h:inputText id="txtLocationId" value="#{semir005Bean.insured.locationId}"/>		
									<rich:spacer width="5"/>						
									<a4j:commandButton id="btnSearchLocation" oncomplete="#{rich:component('popupLocationFrmAdd')}.show(); return false" action="#{navAction.navi}" value="ค้นหา Location" styleClass="rich-button">
											<a4j:actionparam name="navModule" value="ir"/>
				            				<a4j:actionparam name="navProgram" value="SEMIR005"/>
				            				<a4j:actionparam name="moduleWithNavi" value="ir"/>
											<a4j:actionparam name="actionWithNavi" value="SEMIR005"/>
											<a4j:actionparam name="methodWithNavi" value="initLocation"/>	
											<a4j:actionparam name="btnCheck" value="edit" />	
			            			</a4j:commandButton>
	            				</td>
	            			</tr>
	            			<tr>	
	            				<td>
									<h:outputText value="Location Name :" styleClass="ms7"/>
								</td>
								<td colspan="2">	
									<h:inputText id="txtLocationName" value="#{semir005Bean.tempCompanyName}" readonly="true"/>
								</td>
							</tr>
							<tr>
								<td>
									<h:outputText value="ทุนประกันภัย :" styleClass="ms7"/>
								</td>
								<td colspan="2">
									<h:inputText id="txtInsure" value="#{semir005Bean.insured.insuredAmt}"/>
								</td>
							</tr>
							<tr>
								<td>
									<h:outputText value="Effective Date :" styleClass="ms7"/>
								</td>
								<td colspan="2">	
									<rich:calendar id="date"  datePattern="dd/MM/yyyy" value="#{semir005Bean.insured.effDt}"/> 
								</td>
							</tr>
						</table>
						</h:panelGroup>
					</h:panelGrid>
						
						<h:panelGrid columns="3">
						  <a4j:commandButton  id="hidePopUpEdit" styleClass="rich-button" action="#{navAction.navi}" value="Save" 
							reRender="panSearchResult,dtbReplacement,frmSearch">
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMIR005" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMIR005" />
								<a4j:actionparam name="methodWithNavi" value="doUpdate" />	
						  </a4j:commandButton>
						  <rich:componentControl for="popupFrmEdit" attachTo="hidePopUpEdit" operation="hide" event="onclick" />	
						</h:panelGrid>
				  </table>
		</rich:panel>
	  </h:form>
</rich:modalPanel>


