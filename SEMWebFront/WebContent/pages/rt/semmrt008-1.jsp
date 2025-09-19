<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt008" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchPettyCash">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmSearch']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt008Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="20%" valign="baseline">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
			                		</td>
			                		<td colspan="3">
			                			<h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlCompanyBK" value="#{semmrt008Bean.tmpPettyCash.company}" onchange="GetCompanyJS();">
			                				<f:selectItems value="#{semmrt008Bean.companyList}"/>
			                				<f:selectItem itemValue="AWN2" itemLabel="AWN2"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmrt008Bean.tmpPettyCash.company}" styleClass="ms28"/>
										
				                	</td>
				                	
			                	 </tr> 
			                	 
			                	  <tr>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.getDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td>
	                					<rich:calendar id="cldReceiveDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008Bean.tmpPettyCash.receiveDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldReceiveDtFrom','cldReceiveDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldReceiveDtFrom','cldReceiveDtTo');"
											   label="#{jspMsg['label.getDate']}"
											   >
										</rich:calendar> 
										<rich:spacer width="2"></rich:spacer> 
										<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
										<rich:spacer width="2"></rich:spacer>
	                					<rich:calendar id="cldReceiveDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt008Bean.tmpPettyCash.receiveDtTo}"
											   showWeeksBar="false"
											   inputSize="13"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldReceiveDtTo','cldReceiveDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldReceiveDtTo','cldReceiveDtFrom');"
											   label="#{jspMsg['label.getDate']}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right">
									<h:outputText value="#{jspMsg['label.clearDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td>
		                			<rich:calendar id="cldClearDtFrom" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt008Bean.tmpPettyCash.clearDtFrom}"
												   showWeeksBar="false"
												   inputSize="13"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldClearDtFrom','cldClearDtTo');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','cldClearDtFrom','cldClearDtTo');"
											   	   label="#{jspMsg['label.clearDate']}">
									</rich:calendar>
									<rich:spacer width="2"></rich:spacer> 
									<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									<rich:spacer width="2"></rich:spacer>
									<rich:calendar id="cldClearDtTo" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt008Bean.tmpPettyCash.clearDtTo}"
												   showWeeksBar="false"
												   inputSize="13"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldClearDtTo','cldClearDtFrom');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','cldClearDtTo','cldClearDtFrom');"
											   	   label="#{jspMsg['label.clearDate']}">
									</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right">
		                			</td>
		                			<td>
		                				<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
										<a4j:actionparam name="mode" value="SEARCH" />
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
						           		<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
										<a4j:actionparam name="methodWithNavi" value="doClear" />
						           		</a4j:commandButton>
				                	</td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
				
				<!-- end content layout criteria -->
				<a4j:form id="frmButton">
				<!-- begin content button -->
				<h:panelGrid  width="96%"  border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
					<table width="100%" border="0">
					<tr>
					<td align="right">
					<a4j:commandButton id="btnNewPettyCash" 
					oncomplete="#{rich:component('popupFrmRT008Save')}.show(); return false" 
					styleClass="rich-button" 
	            	action="#{navAction.navi}" value="Add Petty Cash"  
	            	reRender="oppContent" style="width:100"
	            	rendered="#{semmct002Bean.renderer['btnNewPettyCash']}">
	            		<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="popupLoad" />
						<a4j:actionparam name="mode" value="INSERT" />
						<a4j:actionparam name="eventType" value="Add" />
					</a4j:commandButton>
					<rich:spacer width="5"></rich:spacer>
					<a4j:commandButton  id="btnClearPettyCash" oncomplete="#{rich:component('popupFrmRT008Clear')}.show(); return false" 
										styleClass="rich-button" 
									    action="#{navAction.navi}" value="Clear Petty Cash"  
									    reRender="oppContent" style="width:100"
									    rendered="#{semmct002Bean.rendererSSO['btnSMBCL001']}">
						<a4j:actionparam name="navModule" value="rt" />
	         			<a4j:actionparam name="navProgram" value="SEMMRT008-1" />	
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="popupLoad" />
						<a4j:actionparam name="mode" value="INSERT" />
						<a4j:actionparam name="eventType" value="Clear" />
					</a4j:commandButton>
					</td>
					</tr>
					</table>
					</h:panelGroup>
				</h:panelGrid>
				<!-- end content button -->
				</a4j:form>
				<a4j:form id="frmSearchResult">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1280"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt008Bean.msgDataNotFound}" rendered="#{semmrt008Bean.renderedMsgDataNotFound}" />
						</div>
						<div align="left">
							<h:message for="pnlSearchResult" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						</div>
						
						<rich:dataTable width="100%" id="dtbPettyCash" cellpadding="1" cellspacing="0" border="0"
							var="pettyCash" value="#{semmrt008Bean.pettyCashList}" 
							rows="#{semmrt008Bean.rowPerPage}"
							rowClasses="cur" 
							styleClass="dataTable" >
							
							<rich:column  styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}" style="width: 40"
										  rendered="#{semmct002Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" 
	            									   reRender="oppContent" 
	            									   image="images/edit.png" 
	            									   style="FONT-SIZE: xx-small; height: 15; width : 15px;"
	            									   oncomplete="#{rich:component(semmrt008Bean.popupFormName)}.show(); return false"
	            									   rendered="#{pettyCash.dataObj.editFlag eq 'Y'}"
	            									   id="btnEdit">
					            		<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
										<a4j:actionparam name="methodWithNavi" value="popupLoad" />
										<a4j:actionparam name="rowId" value="#{pettyCash.dataObj.rowId}"/>
										<a4j:actionparam name="bfAmt" value="#{pettyCash.dataObj.bfAmt}"/>
										<a4j:actionparam name="pettyCashType" value="#{pettyCash.dataObj.pettyCashType}"/>
										<a4j:actionparam name="mode" value="UPDATE" />
										<a4j:actionparam name="eventType" value="Edit" />
	            					</a4j:commandButton>
	            					                 							
								</div>
							</rich:column>
							<rich:column  styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}" style="width: 40"
										  rendered="#{semmct002Bean.renderer['btnDelete']}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   			   action="#{navAction.navi}" 
     									   			   image="images/delete.png" 
     									   			   style="height: 15; width: 15"
     									   			   id="btnDelete"
     									   			   rendered="#{pettyCash.dataObj.editFlag eq 'Y'}"
     									   			   >
     									   <a4j:actionparam name="navModule" value="rt" />
				           				   <a4j:actionparam name="navProgram" value="SEMMRT008-1" />	
										   <a4j:actionparam name="moduleWithNavi" value="rt" />
										   <a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
										   <a4j:actionparam name="methodWithNavi" value="initDelPettyCash" />
										   <a4j:actionparam name="rowId" value="#{pettyCash.dataObj.rowId}"/>	
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							
							
							<rich:column  style="width: 90" sortBy="#{pettyCash.dataObj.receiveDt}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.getDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCash.dataObj.receiveDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pettyCash.dataObj.pettyCashAmt}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.amount']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCash.dataObj.pettyCashAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 90" sortBy="#{pettyCash.dataObj.clearDt}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clearDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCash.dataObj.clearDt}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pettyCash.dataObj.refClrBatchNo}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Ref. Batch Clear" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{pettyCash.dataObj.refClrBatchNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  style="width: 140" sortBy="#{pettyCash.dataObj.clearAmt}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.clearTotalAmount']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCash.dataObj.clearAmt}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column style="width: 140" sortBy="#{pettyCash.dataObj.balanceAmt}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.balance']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{pettyCash.dataObj.balanceAmt}" styleClass="contentform" >
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{pettyCash.dataObj.remark}" styleClass="#{(semmrt008Bean.tmpRowId==pettyCash.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{pettyCash.dataObj.remark}" styleClass="contentform" />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt008Bean.pettyCashList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="10">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPettyCash"
											maxPages="#{semmrt008Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmrt008Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/rt/semmrt008-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmrt008Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmSearchResult,dtbPettyCash" >
							<a4j:actionparam name="navModule" value="rt" />
           					<a4j:actionparam name="navProgram" value="SEMMRT008-1" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
							<a4j:actionparam name="methodWithNavi" value="doDelPettyCash" />
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


