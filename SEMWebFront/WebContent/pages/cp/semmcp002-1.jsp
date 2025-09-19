<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.construction.semmcp002-1" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" >
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columns="4" id="grdSearchCommand2" width="98%">
			<a4j:form id="frmBack">
			<div align="right">
						<a4j:commandButton id="btnImport"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmcp002Bean.renderer['btnImport']}">
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-0" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="dobackToFirstPage" />
						</a4j:commandButton>
			
			</div>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<!-- +++++++++++++++++ begin content layout criteria +++++++++++++++++ -->
			<h:panelGrid width="100%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="bottom">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td  valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmcp002Bean.companyPage2}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmcp002Bean.companyListPage2}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmcp002Bean.companyPage2}" styleClass="ms28" />
										</td>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchRegion" value="#{semmcp002Bean.regionPage2}" style="width : 180px">
		                						<f:selectItems value="#{semmcp002Bean.regionListPage2}" />
		                					</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadFileDt']}" styleClass="ms7" />
										</td>
										<td align="left" width="20%"><rich:calendar id="cldDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmcp002Bean.uploadFileDtFromPage2}"
					                                       showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}"
															 />
															&nbsp;	
											<h:outputText value="#{jspMsg['label.dtTo']}" styleClass="ms7" />
											&nbsp;					
											<rich:calendar id="cldDtTo" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmcp002Bean.uploadFileDtToPage2}"
															 showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText id="txtFileName" value="#{semmcp002Bean.fileNamePage2}" style="width:300px;" maxlength="150" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,dtbSiteApprove">
								<a4j:actionparam name="navModule" value="cp" />
								<a4j:actionparam name="navProgram" value="SEMMCP002-1" />
								<a4j:actionparam name="moduleWithNavi" value="cp" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
								<a4j:actionparam name="methodWithNavi" value="doSearchUploadFile" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="cp" />
								<a4j:actionparam name="navProgram" value="SEMMCP002-1" />
								<a4j:actionparam name="moduleWithNavi" value="cp" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
								<a4j:actionparam name="methodWithNavi" value="doClearPage2" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					<h:panelGrid columns="2" id="grdRedirectCommand" width="95%">
						<h:panelGroup>
						
						
						</h:panelGroup>
					</h:panelGrid>
				</a4j:form>
			</h:panelGrid>
			<!-- +++++++++++++++++ end content layout criteria +++++++++++++++++ -->
			
			<!-- +++++++++++++++++ start search result +++++++++++++++++ -->
			<a4j:form id="frmResult">
				<h:panelGrid width="100%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmcp002Bean.msgDataNotFoundSecondPage}" rendered="#{semmcp002Bean.renderedMsgDataNotFoundSecondPage}" />
                        </div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="warrantDetail" value="#{semmcp002Bean.uploadFileList}"
							reRender="dtbSiteApprove" rows="#{semmcp002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.edit']}" />
									</f:facet>
									<div align="center">
		            					
										<a4j:commandButton id="btnEdit"   action="#{navAction.navi}"   reRender="oppContent" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doView" />
											<a4j:actionparam name="rowIndex" value="#{warrantDetail.rowId}"/>
										</a4j:commandButton>
									</div>
							</rich:column>
							<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.delete']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnDelete"   action="#{navAction.navi}"   reRender="oppContent" 
	            									   image="images/delete.png" style="height: 15; width: 15" 
	            									   rendered="#{warrantDetail.recordTotal!=warrantDetail.recordSuccess}"
	            									     oncomplete="#{rich:component('mdpConfirmDelDataDialogPage2')}.show(); return false"
	            									   >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-1" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="initDelData" />
											<a4j:actionparam name="rowLogIdForDel" value="#{warrantDetail.rowId}"/>
		            					</a4j:commandButton> 
									</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.company}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.company}" /></div>
							</rich:column>				
							<rich:column sortBy="#{warrantDetail.fileName}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.fileName']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.fileName}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordTotal}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allRecord']}" style="width: 10" />
								</f:facet>
								<div align="center">
								
								
								
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent" value="#{warrantDetail.recordTotal}" >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											<a4j:actionparam name="type" value="A" />
											</a4j:commandLink>
								
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordSuccess}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allSuccess']}" style="width: 10" />
								</f:facet>
								<div align="center">
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent" value="#{warrantDetail.recordSuccess}">
										<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="type" value="S" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordfail}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allFailed']}" style="width: 10" />
								</f:facet>
								<div align="center">
								
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent"  value="#{warrantDetail.recordfail}">
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="type" value="E" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.print}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.print']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.print}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.waitPrint}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.waitPrint']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.waitPrint}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.uploadBy}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.uploadBy']}" style="width: 10" />
								</f:facet>
								<div align="left"><h:outputText value="#{warrantDetail.uploadBy}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.uploadDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.uploadDate']}" style="width: 10" />
								</f:facet>
								<div align="center">
										<h:outputText value="#{warrantDetail.uploadDtStr}">
										</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmcp002Bean.uploadFileList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="8">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
                                            maxPages="#{semmcp002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteApprove" 
                                            style="background-color: #cccccc;"
                                            page="#{semmcp002Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpUpdateStatus" autosized="true" >	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['popup.header.updateStatusWarrant']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmGroupReceiveDialog">
		
		
	
	</a4j:form>
	
</rich:modalPanel>



<rich:modalPanel id="mdpConfirmDelDataDialogPage2" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDataDialogPage2">
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
                                           immediate="true" reRender="oppContent" >
                            					<a4j:actionparam name="navModule" value="cp" />
				            					<a4j:actionparam name="navProgram" value="SEMMCP002-1" />	
												<a4j:actionparam name="moduleWithNavi" value="cp" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
					                            <a4j:actionparam name="methodWithNavi" value="doDelete" />
												<a4j:actionparam name="rowIndex" value="#{semmcp002Bean.rowIdFordelete}"/>
					         <rich:componentControl for="mdpConfirmDelDataDialogPage2" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDataDialogPage2" operation="hide" event="onclick" />
                        </a4j:commandButton>
                    </h:panelGrid>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>