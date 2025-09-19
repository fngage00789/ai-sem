<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="ใบอนุมัติเช่าสถานีฐาน (Site Approve) - New ใบอนุมัติเช่าสถานีฐาน" />
		</f:facet>
		<h:panelGrid columnClasses="gridContent">
			<a4j:form id="frmSearch">
	            
	            <h:panelGrid columns="2">
					<a4j:commandButton id="btnNew" value="#{sems002Bean.siteApproveNo}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
	            		<f:param name="navModule" value="site" />
		            	<f:param name="navProgram" value="SEMS001" />
	            	</a4j:commandButton>
	            </h:panelGrid>
	            
			</a4j:form>
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>

