<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script>
	jQuery(document).ready(function(){
	    //alert("test");
	    //alert div
	   // document.getElementById('incContent:frmConfirmSiteInfo:btnUploadPicture').click();
	});
</script>
 
<f:loadBundle basename="resources.sa.semmsa003" var="jspMsg"/>
<h:panelGrid width="100%">

    <rich:panel>
        
            <h:panelGrid>
            <a4j:form id="frmError">
                
            </a4j:form>
        </h:panelGrid>  
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="96%">
                <a4j:form id="frmSearchCriteria">
                    <rich:panel id="pnlSearchCriteria">
                        
                        <!-- begin content criteria -->
                      
                <!-- end content layout criteria -->
                
     </rich:panel>
     </a4j:form>
     </h:panelGrid>
     </h:panelGrid>
     </rich:panel>
           </h:panelGrid>  
        
<!-- Confirm alert  -->
<rich:modalPanel id="mdpConfirmSiteinfo" autosized="true">  
    
    <a4j:form id="frmConfirmSiteInfo">
        <table width="270px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    </td></tr><tr><td>
                    <div align="center">
                   
                <h:panelGrid id="show_popup" style="height:50px;width:50px;" width="500" columns="1">
                    
                    
                    <h:panelGroup id="show_tab" rendered="true" style="height:0px;width:0px;" >
                        <a4j:commandButton id="btnUpload2" value="btnCon2" action="#{navAction.navi}" reRender="oppContent,show_popup,btnUploadFile">
                            <a4j:actionparam name="navModule" value="sa" />
                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
                                    
                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
                            <a4j:actionparam name="methodWithNavi" value="doByPass" />
                            
                         <script>document.getElementById('incContent:frmConfirmSiteInfo:btnUpload2').click();</script>
                        </a4j:commandButton>
                    </h:panelGroup>                           
                </h:panelGrid>
                
                       
                    
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>

<!--<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>-->
