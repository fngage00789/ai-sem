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
				  	<h:panelGrid columns="2">
				  			<h:panelGroup>
				  				<div align="right">
						    		<h:outputText value="Company :" styleClass="ms7"/>
						    	</div>
						    </h:panelGroup>
						    <h:selectOneMenu id="somCompany" value="#{semir004Bean.editDedutible.company}">
			                		<f:selectItems value="#{semir004Bean.companyList}" />
			                </h:selectOneMenu>
			                <h:panelGroup>
				  				<div align="right">
									<h:outputText value="ประเภท :" styleClass="ms7"/>		
								</div>
							</h:panelGroup>
							<h:selectOneMenu id="somNetworkType" value="#{semir004Bean.editDedutible.networkType}">
		                				<f:selectItems value="#{semir004Bean.networkTypeList}" />
		                	</h:selectOneMenu>
		                	<h:panelGroup>
				  				<div align="right">
									<h:outputText value="Transfer Type :" styleClass="ms7"/>	
								</div>
							</h:panelGroup>	
							<h:selectOneMenu id="transferType" value="#{semir004Bean.editDedutible.transferType}">
			                			<f:selectItems value="#{semir004Bean.transferTypeList}" />
			                </h:selectOneMenu>
			                <h:panelGroup>
				  				<div align="right">	
									<h:outputText value="ประเภทความเสียหาย :" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<h:selectOneMenu id="lossType" value="#{semir004Bean.editDedutible.lossType}">
			                			<f:selectItems value="#{semir004Bean.lossTypeList}" />
			                </h:selectOneMenu>	
			                <h:panelGroup>
				  				<div align="right">
									<h:outputText value="Deductible :" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<h:inputText id="txtDeduct_VAL" value="#{semir004Bean.editDedutible.deductAmt}"/>
							<h:panelGroup>
				  				<div align="right">
									<h:outputText value="Effective Date :" styleClass="ms7"/>
								</div>
							</h:panelGroup>	
							<rich:calendar id="date"  datePattern="dd/MM/yyyy" value="#{semir004Bean.editDedutible.effDt}"/> 
					</h:panelGrid>	
					<h:panelGrid columns="3">
						  <a4j:commandButton  id="hidePopUpEdit" styleClass="rich-button" action="#{navAction.navi}" value="Save" 
							reRender="panSearchResult,dtbDeductible,frmSearch">
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMIR004" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMIR004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdate" />	
						  </a4j:commandButton>
						  <rich:componentControl for="popupFrmEdit" attachTo="hidePopUpEdit" operation="hide" event="onclick" />	
						</h:panelGrid>
				  </table>
		</rich:panel>
	 </h:form>
</rich:modalPanel>


