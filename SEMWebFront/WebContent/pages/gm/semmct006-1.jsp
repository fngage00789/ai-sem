<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct006" var="jspMsg"/>
<h:panelGrid width="100%">
    <script>
        function myFunction() {
           
            var element = document.getElementById("incContent:frmSearchCriteria");
            element.parentNode.removeChild(element);
        
         // alert('test');
        }
    </script>
    <rich:panel>
        <f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>   
            <h:panelGrid>
            <a4j:form id="frmError">
                
            </a4j:form>
        </h:panelGrid>  
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="96%">
                <a4j:form id="frmSearchCriteria">
                    <rich:panel id="pnlSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.criteria.name']}"/>
                        </f:facet>
                        <!-- begin content criteria -->
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                            <tr>
                                    <td align="right" width="20%" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.module']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%" valign="bottom">
                                       
                                        <h:selectOneMenu id="mct006_ddlModule" value="#{semmct006Bean.mct006SrchSP.attModule}">
			                                <a4j:support event="onchange" action="#{semmct006Action.getSubModule}" reRender="mct006_ddlSubModule">
			                                </a4j:support>
			                                <f:selectItems value="#{semmct006Bean.moduleSrchList}"/>
			                            </h:selectOneMenu>
                                        
                                        <a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay,btnGenDummy"/>
                                        <rich:spacer width="10"></rich:spacer>
                                        <h:outputText id="companyDisplay" value="#{semmct006Bean.mct006SrchSP.attModule}" styleClass="ms28" rendered="false"/>
                                    </td>
                                    <td align="right" width="20%" valign="bottom">
                                    <h:outputText value="#{jspMsg['label.subModule']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%" valign="bottom">
	                                    <h:selectOneMenu id="mct006_ddlSubModule" value="#{semmct006Bean.mct006SrchSP.attSubModule}">
			                                <f:selectItems value="#{semmct006Bean.subModuleSrchList}"/>
			                            </h:selectOneMenu>
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.public']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
	                                    <h:selectOneMenu value="#{semmct006Bean.mct006SrchSP.attaPublic}">
	                                    	 <f:selectItem itemValue="" itemLabel=" -- Select -- "/>
			                                <f:selectItem itemValue="PR" itemLabel="Private"/>
			                                <f:selectItem itemValue="PB" itemLabel="Public"/>
			                                <f:selectItem itemValue="EX" itemLabel="External"/>
			                            </h:selectOneMenu>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:panelGroup>
                                        <h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
                                    </h:panelGroup>
                                    </td>
                                    <td width="30%">
	                                     <h:inputText id="mct006_txtCreateBy" value="#{semmct006Bean.mct006SrchSP.contractNo}"
	                                      size="30" maxlength="255"/>
                                    
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    	<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    	<h:inputText id="txtTitle" value="#{semmct006Bean.mct006SrchSP.createBy}" size="30" maxlength="35"/>
                                    </td>
                                    <td align="right" width="20%">
	                                    
                                    </td>
                                    <td width="30%">
	                                    
                                    </td>
                                 </tr>
                           </table>
                          </h:panelGroup>
                        </h:panelGrid>
                        <!-- end content criteria -->
                        <h:panelGrid columns="2" id="grdSearchCommand">
                            <a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult" >
                            <a4j:actionparam name="navModule" value="gm" />
                            <a4j:actionparam name="navProgram" value="SEMMCT006-1" />
                            <a4j:actionparam name="moduleWithNavi" value="gm" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMCT006" />
                            <a4j:actionparam name="methodWithNavi" value="doSearch" />
                            </a4j:commandButton>
                            <a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
                            <a4j:actionparam name="navModule" value="gm" />
                            <a4j:actionparam name="navProgram" value="SEMMCT006-1" />
                            <a4j:actionparam name="moduleWithNavi" value="gm" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMCT006" />
                            <a4j:actionparam name="methodWithNavi" value="doClear" />
                            </a4j:commandButton>
                            
                            <a4j:jsFunction name="autoSrch" action="#{navAction.navi}" 
                            reRender="frmError,pnlSearchCriteria,pnlSearchResult,mdpConfirmDelAttachmentDialogCT,popupUploadPictureCriteriaCT">
								<a4j:actionparam name="navModule" value="gm" />
	                            <a4j:actionparam name="navProgram" value="SEMMCT006-1" />
	                            <a4j:actionparam name="moduleWithNavi" value="gm" />
	                            <a4j:actionparam name="actionWithNavi" value="SEMMCT006" />
	                            <a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:jsFunction>
                        </h:panelGrid>
                    </rich:panel>
                    <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct006Bean.renderedMsgFormSearch}">
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
                    
                    </a4j:form>
                </h:panelGrid>
            
                <!-- end content layout criteria -->
                
                <a4j:form id="frmSearchResult"> 
               
                <!-- begin content layout data grid -->
                <h:panelGrid  width="90%">
                	<h:panelGrid>
                        <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td>
                                        <a4j:commandButton id="btnUploadPicture"
										action="#{navAction.navi}"
										reRender="oppContent,popupUploadPictureCriteriaCT"
										value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
										oncomplete="#{rich:component('popupUploadPictureCriteriaCT')}.show(); return false" >
											<a4j:actionparam name="navModule" value="common" />
											<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
											<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
											<a4j:actionparam name="module" value="ALL"/>
											<a4j:actionparam name="viewMode" value="N"/>
										</a4j:commandButton>
                                    </td>
                                </tr>
                            </table>
                        </h:panelGroup>
                    </h:panelGrid>
                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 100%"/>
                        </f:facet>
                        <div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmct006Bean.msgDataNotFound}" rendered="#{semmct006Bean.renderedMsgDataNotFound}" />
                        </div>
                          <rich:dataTable id="dtbAttaFileSrch" cellpadding="1" cellspacing="0" border="0"
                             var="attachment" value="#{semmct006Bean.mct006SrchList}" 
                                        rows="#{semmct006Bean.rowPerPage}"
                                        onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
                                        styleClass="contentform" style="height : 79px; width : 600px;">
                                <rich:column  >
                                    <f:facet name="header">
                                        <h:outputText value="Delete" styleClass="contentform" style= " width : 50px" />
                                    </f:facet>
                                    <div align="center">
                                            <a4j:commandButton oncomplete="if(#{popupUploadFilePictureBean.renderPopUpDel == 'true'})#{rich:component('mdpConfirmDelAttachmentDialogCT')}.show(); return false" 
				 									   		   action="#{navAction.navi}"  
				 									   		   image="images/delete.png" style="height : 15px; width : 15px;">
												<a4j:actionparam name="navModule" value="common" />
				            					<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
												<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
				 								<a4j:actionparam name="rowId" value="#{attachment.dataObj.rowId}"/>
				 								<a4j:actionparam name="user" value="#{attachment.dataObj.createBy}"/>		
					         				</a4j:commandButton>                             
                                    </div>
                                </rich:column>
                            
                                <rich:column sortBy="#{attachment.dataObj.fileName}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.fileName']}" styleClass="contentform" style= " width : 300px" />
                                    </f:facet>
                                    <div align="left">
                                        <h:commandLink action="#{navAction.doDownload}" value="#{attachment.dataObj.fileName}">
                                            <f:param name="pathName" value="#{attachment.dataObj.attaPath}"/> 
                                            <f:param name="fileName" value="#{attachment.dataObj.fileName}"/>
                                        </h:commandLink>     
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.attModule}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.module']}" styleClass="contentform" style= " width : 150px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.attModule}" styleClass="contentform" />
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.attSubModule}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.subModule']}" styleClass="contentform" style= " width : 50px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.attSubModule}" styleClass="contentform" />
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.attaPublic}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.public']}" styleClass="contentform" style= " width : 30px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.attaPublicName}" styleClass="contentform" />
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.contractNo}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style= " width : 30px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.contractNo}" styleClass="contentform" />
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.createBy}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.createBy']}" styleClass="contentform" style= " width : 100px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.createBy}" styleClass="contentform" />
                                    </div>
                                </rich:column>
                                <rich:column sortBy="#{attachment.dataObj.createDt}">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['column.header.createDt']}" styleClass="contentform" style= " width : 150px" />
                                    </f:facet>
                                    <div align="center">
                                        <h:outputText value="#{attachment.dataObj.createDtStr}" styleClass="contentform" >
                                            <f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="th" />
                                        </h:outputText>
                                    </div>
                                </rich:column>
                                
                                <f:facet name="footer">
                                    <rich:columnGroup>
                                        <rich:column colspan="2">
                                            <h:outputFormat value="#{msg['message.totalRecords']}">
                                                <f:param value="#{fn:length(semmct006Bean.mct006SrchList)}"></f:param>
                                            </h:outputFormat>
                                        </rich:column>
                                        <rich:column colspan="6">
                                            <rich:datascroller immediate="true" rendered="true" align="left" for="dtbAttaFileSrch"
                                                maxPages="#{semmct006Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                                stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                                id="dstAttaFileSrch"
                                                style="background-color: #cccccc;"
                                                page="#{semmct006Bean.scrollerPage}" 
                                            />
                                        </rich:column>
                                    </rich:columnGroup>
                                </f:facet>
                            </rich:dataTable>
                    </rich:panel>
                </h:panelGrid>
                <!-- end content layout data grid -->
                </a4j:form>
                </h:panelGrid>
            </rich:panel>
        </h:panelGrid>
        <jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
        
        