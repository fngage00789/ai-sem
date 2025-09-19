<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.history.name']}"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<!-- criteria panel -->
		<a4j:form id="frmCriteriaSearch">
			<rich:panel id="pnlSearchCriteria">
				<f:facet name="header"><h:outputText value="#{jspMsg['header.criteria.name']}"/></f:facet>
		
			</rich:panel>
		</a4j:form>
		
		<div style="clear:both; height:10px;"></div>
		
		<!-- result panel -->
		<a4j:form id="frmResultSearch">
			<rich:panel>
				<f:facet name="header"><h:outputText value="#{jspMsg['header.result.name']}"/></f:facet>
				
			</rich:panel>
		</a4j:form>
	
	</rich:panel>
</h:panelGrid>