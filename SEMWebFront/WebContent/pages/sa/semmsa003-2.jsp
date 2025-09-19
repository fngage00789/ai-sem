<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.sa.semmsa003" var="jspMsg"/>
<h:panelGrid width="100%">

    <rich:panel>
        <f:facet name="header"><h:outputText value="test"/></f:facet>   
            <h:panelGrid>
            <a4j:form id="frmError">
                
            </a4j:form>
        </h:panelGrid>  
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="96%">
                
                </h:panelGrid>
            
                <!-- end content layout criteria -->
                
                
                </h:panelGrid>
            </rich:panel>
        </h:panelGrid>
        
<!-- Confirm alert  -->
<rich:modalPanel id="mdpConfirmSiteinfo" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm SiteInfo"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmSiteInfo">
        <table width="270px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    </td></tr><tr><td>
                    <div align="center">
                    
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<a4j:include id="msa003-2_popUpNew"  viewId="../../pages/sa/semmsa003PopUpNew.jsp" />
<!--<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>-->
