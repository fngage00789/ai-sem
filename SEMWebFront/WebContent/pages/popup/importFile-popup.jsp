<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<f:loadBundle basename="resources.gm.semmct002" var="jspMsgUploadPic"/>
<rich:modalPanel id="popupImportFile" width="500"  height="600" autosized="true" minWidth="220" moveable="false">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Upload picture file"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupImportFile" style="cursor:pointer"/>
				<rich:componentControl for="popupImportFile" attachTo="hidepopupImportFile" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	
	<h:panelGrid width="100%">
		<h:form id="frmImportFile">
			
			<rich:panel id="panBrowseImportFile">
				<f:facet name="header">
					<h:outputText value="Browse File"/>
				</f:facet>
			 <rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
				<f:facet name="errorMarker">
		 		   <h:graphicImage value="images/error.gif" />  
                </f:facet>
			 </rich:messages>
		     <h:panelGrid columns="2" columnClasses="top,top">
		         <rich:fileUpload id="txtImportFile" fileUploadListener="#{fileUploadBean.listener}"
					              listHeight="58"
								  listWidth="900px"
					              addControlLabel="Browse..."
					              autoclear="true"
					              immediateUpload="true" uploadButtonClassDisabled="true" cleanButtonClassDisabled="true"
								autoclear="true" acceptedTypes="xls,xlsx">>
					              
					 	<a4j:support event="onuploadcomplete"  reRender="frmImportFile" action="#{navAction.navi}" >
					 	<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
						<a4j:actionparam name="methodWithNavi" value="doUploadInfo" />
						<script>document.getElementById('popupImportFile').hide();</script>	 								
					 </a4j:support>
					
		             <f:facet name="label">
						<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
					 </f:facet>
		         </rich:fileUpload>
		     </h:panelGrid>
		     <h:panelGrid columns="2" columnClasses="top,top">
		     <rich:dataTable id="dtbImportFile" cellpadding="1" cellspacing="0" border="0"
							var="attachment" value="#{popupUploadFilePictureBean.attachmentList}" 
							rows="#{popupUploadFilePictureBean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform" style="height : 79px; width : 900px;">
					<rich:column width="5%" rendered="#{popupUploadFilePictureBean.renderedColDel}">
						<f:facet name="header">
							<h:outputText value="Delete" styleClass="contentform" />
						</f:facet>
						<div align="center">
	         					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	 									   		   action="#{navAction.navi}"  
	 									   		   image="images/delete.png" style="height: 15; width: 15">
									<a4j:actionparam name="navModule" value="common" />
	            					<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
									<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
	 								<a4j:actionparam name="rowId" value="#{attachment.rowId}"/>	
		         				</a4j:commandButton>          							
						</div>
					</rich:column>
				
					<rich:column sortBy="#{attachment.fileName}">
						<f:facet name="header">
							<h:outputText value="#{jspMsgUploadPic['column.header.fileName']}" styleClass="contentform" />
						</f:facet>
						<div align="left">
							<h:commandLink action="#{navAction.doDownload}" value="#{attachment.fileName}">
 								<f:param name="pathName" value="#{attachment.attachmentPath}"/>	
 								<f:param name="fileName" value="#{attachment.fileName}"/>
		         			</h:commandLink>     
						</div>
					</rich:column>
					<rich:column sortBy="#{attachment.createBy}">
						<f:facet name="header">
							<h:outputText value="#{jspMsgUploadPic['column.header.createBy']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{attachment.createBy}" styleClass="contentform" />
						</div>
					</rich:column>
					<rich:column sortBy="#{attachment.createDt}">
						<f:facet name="header">
							<h:outputText value="#{jspMsgUploadPic['column.header.createDt']}" styleClass="contentform" />
						</f:facet>
						<div align="center">
							<h:outputText value="#{attachment.createThDt}" styleClass="contentform" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="th" />
							</h:outputText>
						</div>
					</rich:column>
					
					<f:facet name="footer">
						<rich:datascroller immediate="true" rendered="true" align="left" for="dtbImportFile" 
							maxPages="10" id="dstPicFileUpload" selectedStyleClass="selectScroll" />
					</f:facet>
				</rich:dataTable>
				</h:panelGrid>
		    </rich:panel>
		</h:form>
		</h:panelGrid>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{popupUploadFilePictureBean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
			<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
										   immediate="true" reRender="dtbImportFile,txtImportFile" >
							<a4j:actionparam name="navModule" value="common" />
	          				<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

