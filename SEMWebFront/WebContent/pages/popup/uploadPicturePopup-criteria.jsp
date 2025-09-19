<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.gm.semmct002" var="jspMsgUploadPic"/>
<rich:modalPanel id="popupUploadPictureCriteria" width="300"  height="400" autosized="true" minWidth="220" moveable="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Upload file"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupUploadPicture" style="cursor:pointer"/>
				<rich:componentControl for="popupUploadPictureCriteria" attachTo="hidePopupUploadPicture" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	
	<h:panelGrid width="100%">
		<a4j:form id="frmUploadPictureFile">
			<rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
				<f:facet name="errorMarker">
		 		   <h:graphicImage value="images/error.gif" />  
                </f:facet>
			 </rich:messages>
			 
			<rich:panel id="pnlBrowseFile" rendered="#{!popupUploadFilePictureBean.viewMode}">
				<f:facet name="header">
					<h:outputText value="Browse File"/>
				</f:facet>
			 
			  <h:panelGrid width="95%">
			  	<h:panelGroup>
			  	 <table width="100%">
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
				  	 		<h:selectOneMenu id="ddlModule" value="#{popupUploadFilePictureBean.module}">
				  	 			<a4j:support event="onchange" action="#{popupUploadFilePictureAction.getSubModule}" reRender="ddlSubModule">
				  	 			</a4j:support>
		                		<f:selectItems value="#{popupUploadFilePictureBean.moduleList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 		<td width="20%" align="right"><h:outputText value="Sub Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu id="ddlSubModule" value="#{popupUploadFilePictureBean.subModule}">
		                		<f:selectItems value="#{popupUploadFilePictureBean.subModuleList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 	</tr>
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Public : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu value="#{popupUploadFilePictureBean.publicString}" styleClass="ms7">
			  	 				<f:selectItem itemValue="PR" itemLabel="Private"/>
			  	 				<f:selectItem itemValue="PB" itemLabel="Public"/>
			  	 				<f:selectItem itemValue="EX" itemLabel="External"/>
			  	 			</h:selectOneMenu>
			  	 		</td>
			  	 		<td colspan="2">
			  	 	</tr>
			  	 	<tr style="width=100%">
			  	 		<td colspan="4"></td>
			  	 	</tr>
			  	 </table>
			  	</h:panelGroup>
			  </h:panelGrid>
		     <h:panelGrid columns="2" columnClasses="top,top" rendered="#{!popupUploadFilePictureBean.viewMode}">
		         <rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listener}"
					              listHeight="58"
								  listWidth="800px"
					              addControlLabel="Browse..."
					              autoclear="true">
					              
					 	<a4j:support event="onuploadcomplete"  reRender="frmUploadPicFile,dtbPicFileUpload,txtPicFileUpload" action="#{navAction.navi}" >
					 	<a4j:actionparam name="navModule" value="common" />
          				<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
						<a4j:actionparam name="moduleWithNavi" value="common" />
						<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
						<a4j:actionparam name="methodWithNavi" value="doCreateAttachment" />
						<a4j:actionparam name="attachModule" value="#{popupUploadFilePictureBean.attachModule}"/>
	 								
					 </a4j:support>
					
		             <f:facet name="label">
						<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
					 </f:facet>
		         </rich:fileUpload>
		     </h:panelGrid>
		     </rich:panel>
		     <br/>
		     <rich:panel>
		     	<f:facet name="header">
					<h:outputText value="Search File"/>
				</f:facet>
			     <table width="100%">
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
				  	 		<h:selectOneMenu id="ddlModuleSrch" value="#{popupUploadFilePictureBean.attachCri.attachmentModule}">
				  	 			<a4j:support event="onchange" action="#{popupUploadFilePictureAction.getSubModule}" reRender="ddlSubModuleSrch">
				  	 			</a4j:support>
		                		<f:selectItems value="#{popupUploadFilePictureBean.moduleSrchList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 		<td width="20%" align="right"><h:outputText value="Sub Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu id="ddlSubModuleSrch" value="#{popupUploadFilePictureBean.attachCri.attachmentSubModule}">
		                		<f:selectItems value="#{popupUploadFilePictureBean.subModuleSrchList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 	</tr>
			  	 	<tr style="width=100%">
			  	 		<td colspan="4"></td>
			  	 	</tr>
			  	 	<tr>
			  	 		<td colspan="4">
			  	 			<a4j:commandButton id="btnSearch" value="#{jspMsgUploadPic['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
								reRender="dtbPicFileUpload" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
								<a4j:actionparam name="methodWithNavi" value="doSearchAttachment" />
							</a4j:commandButton>
							<rich:spacer width="5px"/>
							<a4j:commandButton id="btnClear" value="#{jspMsgUploadPic['btn.clear']}" styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmUploadPictureFile,dtbPicFileUpload" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
			  	 		</td>
			  	 	</tr>
			  	 	<tr>
			     		<td colspan="4">
					     	<rich:dataTable id="dtbPicFileUpload" cellpadding="1" cellspacing="0" border="0"
										var="attachment" value="#{popupUploadFilePictureBean.attachmentList}" 
										rows="#{popupUploadFilePictureBean.rowPerPage}"
										onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
										onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
										styleClass="contentform" style="height : 79px; width : 600px;">
								<rich:column  >
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform" style= " width : 50px" />
									</f:facet>
									<div align="center">
				         					<a4j:commandButton oncomplete="if(#{popupUploadFilePictureBean.renderPopUpDel == 'true'})#{rich:component('mdpConfirmDelAttachmentDialog')}.show(); return false" 
				 									   		   action="#{navAction.navi}"  
				 									   		   image="images/delete.png" style="height: 15; width: 15">
												<a4j:actionparam name="navModule" value="common" />
				            					<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
												<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
				 								<a4j:actionparam name="rowId" value="#{attachment.rowId}"/>
				 								<a4j:actionparam name="user" value="#{attachment.createBy}"/>		
					         				</a4j:commandButton>          							
									</div>
								</rich:column>
							
								<rich:column sortBy="#{attachment.fileName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.fileName']}" styleClass="contentform" style= " width : 300px" />
									</f:facet>
									<div align="left">
										<h:commandLink action="#{navAction.doDownload}" value="#{attachment.fileName}">
			 								<f:param name="pathName" value="#{attachment.attachmentPath}"/>	
			 								<f:param name="fileName" value="#{attachment.fileName}"/>
					         			</h:commandLink>     
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentModule}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.module']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentModule}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentSubModule}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.subModule']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentSubModule}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentPublic}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.public']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentPublic}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.createBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.createBy']}" styleClass="contentform" style= " width : 100px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.createBy}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.createDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.createDt']}" styleClass="contentform" style= " width : 150px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.createThDt}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="th" />
										</h:outputText>
									</div>
								</rich:column>
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(popupUploadFilePictureBean.attachmentList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="5">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPicFileUpload"
												maxPages="#{popupUploadFilePictureBean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstPicFileUpload" 
												style="background-color: #cccccc;"
												page="#{semmir008Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
							</rich:dataTable>
						</td>
					</tr>
				</table>
		    </rich:panel>
		    <br/>
		    <a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
		    <rich:componentControl for="popupUploadPictureCriteria" operation="hide" event="onclick" />
			</a4j:commandButton>
		</a4j:form>
		</h:panelGrid>
		
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelAttachmentDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelAttachmentDialog">
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
										   immediate="true" reRender="dtbPicFileUpload,txtPicFileUpload" >
							<a4j:actionparam name="navModule" value="common" />
	          				<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<rich:componentControl for="mdpConfirmDelAttachmentDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelAttachmentDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="popupUploadPictureCriteriaCT" width="300"  height="400" autosized="true" minWidth="220" moveable="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Upload file"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupUploadPictureCT" style="cursor:pointer"/>
				<rich:componentControl for="popupUploadPictureCriteriaCT" attachTo="hidePopupUploadPictureCT" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	
	<h:panelGrid width="100%">
		<a4j:form id="frmUploadPictureFileCT">
			<rich:messages  errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
				<f:facet name="errorMarker">
		 		   <h:graphicImage value="images/error.gif" />  
                </f:facet>
			 </rich:messages>
			 
			<rich:panel id="pnlBrowseFileCT" rendered="#{!popupUploadFilePictureBean.viewMode}">
				<f:facet name="header">
					<h:outputText value="Browse File"/>
				</f:facet>
			 
			  <h:panelGrid width="95%">
			  	<h:panelGroup>
			  	 <table width="100%">
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
				  	 		<h:selectOneMenu id="ddlModule" value="#{popupUploadFilePictureBean.module}">
				  	 			<a4j:support event="onchange" action="#{popupUploadFilePictureAction.getSubModuleList}" reRender="ddlSubModule">
				  	 			</a4j:support>
		                		<f:selectItems value="#{popupUploadFilePictureBean.moduleList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 		<td width="20%" align="right"><h:outputText value="Sub Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu id="ddlSubModule" value="#{popupUploadFilePictureBean.subModule}">
		                		<f:selectItems value="#{popupUploadFilePictureBean.subModuleList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 	</tr>
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Public : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu value="#{popupUploadFilePictureBean.publicString}" styleClass="ms7">
			  	 				<f:selectItem itemValue="PR" itemLabel="Private"/>
			  	 				<f:selectItem itemValue="PB" itemLabel="Public"/>
			  	 				<f:selectItem itemValue="EX" itemLabel="External"/>
			  	 			</h:selectOneMenu>
			  	 		</td>
			  	 		<td width="20%" align="right"><h:outputText value="Contract No : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:inputText id="contractNoTxt" value="#{popupUploadFilePictureBean.contractNo}"></h:inputText>
			  	 			
			  	 		</td>
			  	 	</tr>
			  	 </table>
			  	</h:panelGroup>
			  </h:panelGrid>
		     <h:panelGrid columns="2" columnClasses="top,top" rendered="#{!popupUploadFilePictureBean.viewMode}">
		         <rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listener}"
					              listHeight="58"
								  listWidth="800px"
					              addControlLabel="Browse..."
					              autoclear="true">
					              
					 	<a4j:support event="onuploadcomplete"  reRender="frmUploadPicFileCT,dtbPicFileUpload,txtPicFileUpload" action="#{navAction.navi}" >
					 	<a4j:actionparam name="navModule" value="common" />
          				<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
						<a4j:actionparam name="moduleWithNavi" value="common" />
						<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
						<a4j:actionparam name="methodWithNavi" value="doCreateAttachment" />
						<a4j:actionparam name="attachModule" value="#{popupUploadFilePictureBean.attachModule}"/>
	 								
					 </a4j:support>
					
		             <f:facet name="label">
						<h:outputText value="{_KB}KB from {KB}KB uploaded - {mm}:{ss}" />
					 </f:facet>
		         </rich:fileUpload>
		     </h:panelGrid>
		     </rich:panel>
		     <br/>
		     <rich:panel>
		     	<f:facet name="header">
					<h:outputText value="Search File"/>
				</f:facet>
			     <table width="100%">
			  	 	<tr style="width=100%">
			  	 		<td width="20%" align="right"><h:outputText value="Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
				  	 		<h:selectOneMenu id="ddlModuleSrch" value="#{popupUploadFilePictureBean.attachCri.attachmentModule}">
				  	 			<a4j:support event="onchange" action="#{popupUploadFilePictureAction.getSubModule}" reRender="ddlSubModuleSrch">
				  	 			</a4j:support>
		                		<f:selectItems value="#{popupUploadFilePictureBean.moduleSrchList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 		<td width="20%" align="right"><h:outputText value="Sub Module : " styleClass="ms7"/></td>
			  	 		<td width="30%" align="left">
			  	 			<h:selectOneMenu id="ddlSubModuleSrch" value="#{popupUploadFilePictureBean.attachCri.attachmentSubModule}">
		                		<f:selectItems value="#{popupUploadFilePictureBean.subModuleSrchList}"/>
		                	</h:selectOneMenu>
			  	 		</td>
			  	 	</tr>
			  	 	<tr style="width=100%">
			  	 		<td colspan="4"></td>
			  	 	</tr>
			  	 	<tr>
			  	 		<td colspan="4">
			  	 			<a4j:commandButton id="btnSearch" value="#{jspMsgUploadPic['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
								reRender="dtbPicFileUploadCT" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
								<a4j:actionparam name="methodWithNavi" value="doSearchAttachment" />
							</a4j:commandButton>
							<rich:spacer width="5px"/>
							<a4j:commandButton id="btnClear" value="#{jspMsgUploadPic['btn.clear']}" styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmUploadPictureFileCT,dtbPicFileUploadCT" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
			  	 		</td>
			  	 	</tr>
			  	 	<tr>
			     		<td colspan="4">
					     	<rich:dataTable id="dtbPicFileUploadCT" cellpadding="1" cellspacing="0" border="0"
										var="attachment" value="#{popupUploadFilePictureBean.attachmentList}" 
										rows="#{popupUploadFilePictureBean.rowPerPage}"
										onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
										onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
										styleClass="contentform" style="height : 79px; width : 600px;">
								<rich:column  >
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform" style= " width : 50px" />
									</f:facet>
									<div align="center">
				         					<a4j:commandButton oncomplete="if(#{popupUploadFilePictureBean.renderPopUpDel == 'true'})#{rich:component('mdpConfirmDelAttachmentDialog')}.show(); return false" 
				 									   		   action="#{navAction.navi}"  
				 									   		   image="images/delete.png" style="height: 15; width: 15">
												<a4j:actionparam name="navModule" value="common" />
				            					<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
												<a4j:actionparam name="methodWithNavi" value="initDelAttachment" />
				 								<a4j:actionparam name="rowId" value="#{attachment.rowId}"/>
				 								<a4j:actionparam name="user" value="#{attachment.createBy}"/>		
					         				</a4j:commandButton>          							
									</div>
								</rich:column>
							
								<rich:column sortBy="#{attachment.fileName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.fileName']}" styleClass="contentform" style= " width : 300px" />
									</f:facet>
									<div align="left">
										<h:commandLink action="#{navAction.doDownload}" value="#{attachment.fileName}">
			 								<f:param name="pathName" value="#{attachment.attachmentPath}"/>	
			 								<f:param name="fileName" value="#{attachment.fileName}"/>
					         			</h:commandLink>     
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentModule}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.module']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentModule}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentSubModule}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.subModule']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentSubModule}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.attachmentPublic}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.public']}" styleClass="contentform" style= " width : 30px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.attachmentPublic}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.createBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.createBy']}" styleClass="contentform" style= " width : 100px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.createBy}" styleClass="contentform" />
									</div>
								</rich:column>
								<rich:column sortBy="#{attachment.createDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgUploadPic['column.header.createDt']}" styleClass="contentform" style= " width : 150px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{attachment.createThDt}" styleClass="contentform" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="th" />
										</h:outputText>
									</div>
								</rich:column>
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(popupUploadFilePictureBean.attachmentList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="5">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPicFileUpload"
												maxPages="#{popupUploadFilePictureBean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstPicFileUpload" 
												style="background-color: #cccccc;"
												page="#{semmir008Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
							</rich:dataTable>
						</td>
					</tr>
				</table>
		    </rich:panel>
		    <br/>
		    <a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
		    <rich:componentControl for="popupUploadPictureCriteriaCT" operation="hide" event="onclick" />
			</a4j:commandButton>
		</a4j:form>
		</h:panelGrid>
		
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmDelAttachmentDialogCT" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelAttachmentDialogCT">
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
										   immediate="true" reRender="dtbPicFileUpload,txtPicFileUpload" oncomplete="autoSrch();">
							<a4j:actionparam name="navModule" value="common" />
	          				<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />	
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
							<a4j:actionparam name="methodWithNavi" value="doDelAttachment" />
							<rich:componentControl for="mdpConfirmDelAttachmentDialogCT" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelAttachmentDialogCT" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

