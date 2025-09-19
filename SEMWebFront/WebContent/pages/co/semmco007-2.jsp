<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<f:loadBundle basename="resources.co.semmco007" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco007Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<a4j:form id="frmContractAddDetailCommand">
				<table width="98%">
					<tr>
						<td align="right">
							<a4j:commandButton id="btnBackTodoInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
							action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
								<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO007-1" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO007"/>
								<a4j:actionparam name="methodWithNavi" value="doBack" />
							</a4j:commandButton>
						</td>
					</tr>
				</table>
				
			</a4j:form>
			
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="98%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.conttitle']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="10%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.name']} :" styleClass="ms7"/>
										</h:panelGroup>
		                			</td>
		                			<td width="90%"  valign="bottom">
										<h:inputText value="#{semmco007Bean.masterContractTitleSP.contractFormName}" size="100" style="width:100%"/>
				                	</td>
				                </tr>
				                <tr>
									<td align="right" width="10%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.title']} :" styleClass="ms7"/>
										</h:panelGroup>
		                			</td>
		                			<td width="90%"  valign="bottom">
										<h:inputText value="#{semmco007Bean.masterContractTitleSP.contractFormTitle}" size="100" style="width:100%" />
				                	</td>
				                </tr>
				                <tr>
									<td align="right" width="10%" valign="baseline">
										
		                			</td>
		                			<td width="90%"  valign="bottom">
										<h:selectBooleanCheckbox value="#{semmco007Bean.chkContEndingFlag}"> </h:selectBooleanCheckbox>
										<h:outputText value="#{jspMsg['label.lastPageFlag']}" styleClass="ms7"></h:outputText>
				                	</td>
				                </tr>
				                <h:panelGroup rendered="false">
					                <tr>
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.beforeContractName']} :" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="100%"  valign="bottom">
											<h:inputText value="#{semmco007Bean.contract.value3}" size="100" />
					                	</td>
					                </tr>
					                <tr>
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.afterContractName']} :" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="100%"  valign="bottom">
											<h:inputTextarea id="afterContractName" value="#{semmco007Bean.contract.value4}" rows="3" cols="75" ></h:inputTextarea>
											
					                	</td>
					                </tr>
					                <tr>
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.beforeSiteRent']} :" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="100%"  valign="bottom">
											<h:inputText value="#{semmco007Bean.contract.value5}" size="100" />
					                	</td>
					                </tr>
					                <tr>
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.afterSiteRent']} :" styleClass="ms7"/>
											</h:panelGroup>
			                			</td>
			                			<td width="100%"  valign="bottom">
											<h:inputTextarea id="afterContractRent" value="#{semmco007Bean.contract.value6}" rows="3" cols="75" />
					                	</td>
					                </tr>
					                <tr>
					                	<td align="right" width="20%" valign="baseline">
					                		<h:panelGroup>
												<h:outputText value="#{jspMsg['label.status']} :" styleClass="ms7"/>
											</h:panelGroup>
					                	</td>
					                	<td width="40%"  valign="bottom">
											<h:selectOneRadio id="statusFlag" value="Y"  styleClass="ms7" rendered="true" >
				                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.active']} " />
				                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.inActive']}"/>
				                			</h:selectOneRadio>
					                	</td>
					                </tr>
				                </h:panelGroup>
				                <tr>
				                	<td></td>
				                	<td>
				                		<h:panelGrid columns="3" id="grdResultCommand">
											<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.add']}" styleClass="rich-button"
											action="#{navAction.navi}" 
											rendered="#{semmco007Bean.masterContractTitleSP.contractFormId == null || 
											semmco007Bean.masterContractTitleSP.contractFormId == ''}"
											reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch, pnlDetail" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doAddContractTitle" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
											action="#{navAction.navi}" 
											rendered="#{semmco007Bean.masterContractTitleSP.contractFormId != null && 
											semmco007Bean.masterContractTitleSP.contractFormId != ''}"
											reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch, pnlDetail" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doSaveContractTitle" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doClearContTitle" />
											</a4j:commandButton>
										
										</h:panelGrid>
				                	</td>
				                </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand" rendered="false">
							<a4j:commandButton id="btnAddDetail" value="#{jspMsg['btn.addDetail']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearch" 
							oncomplete="#{rich:component('popupAddDetail')}.show();">
							</a4j:commandButton>
							
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				
				<h:panelGrid id="pnlDetail" width="98%" >
					<a4j:form id="frmResult">
					
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco007Bean.renderedMsgFormSearch}">
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
					
					<rich:panel id="pnlDetailParam" 
					rendered="#{semmco007Bean.masterContractTitleSP.contractFormId != null && semmco007Bean.masterContractTitleSP.contractFormId != ''}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contdetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.header']} :" styleClass="ms7" rendered="false"/>
					           			</td>
					           			<td width="90%">
					           				<h:inputText size="80" style="width:100%" rendered="false"/>
					              		</td>
					               	</tr>
					               	<tr>
					                	<td align="right" valign="top" width="10%">
					                		<h:graphicImage value="images/icon_required.gif"/>
					                		<h:outputText value="#{jspMsg['label.detail']} :" styleClass="ms7" />
					              		</td>
					              		<td width="90%">
					              			<h:inputTextarea id="mco007_contDetail" 
					              			value="#{semmco007Bean.masterContractDetailSP.contractFormDetail}" 
					              			rows="30" cols="80" style="width:100%"/>
					                	</td>
					               	</tr>
					               	<tr>
					               	 	<td align="right" width="10%">
					               	 		<h:graphicImage value="images/icon_required.gif"/>
					               	 		<h:outputText value="#{jspMsg['label.orderBy']} :" styleClass="ms7"/>
					               	 	</td>
					               	 	<td width="90%">
					               	 		<h:inputText value="#{semmco007Bean.masterContractDetailSP.contractFormOrder}" size="80" style="width:20%"
					               	 		onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="ms7"
              								onfocus="return numberformat.setCursorPosToEnd(this);">
					               	 		
					               	 		</h:inputText>               	 	
					               	 	</td>
					               	</tr>
					               	<tr>
					               	 	<td align="right" width="10%">
					               	 		
					               	 	</td>
					               	 	<td width="90%">
					               	 	
					               	 		<h:selectBooleanCheckbox id="mco007_newLine" value="#{semmco007Bean.chkContractNewline}" ></h:selectBooleanCheckbox>
					               	 		<rich:spacer width="5"></rich:spacer>
					               	 		<h:outputText value="#{jspMsg['label.th_newLine']}" styleClass="ms7"/>
					               	 	
					               	 		<rich:spacer width="50"></rich:spacer>
					               	 		
					               	 		<h:selectBooleanCheckbox id="mco007_bold" value="#{semmco007Bean.chkContractBold}" ></h:selectBooleanCheckbox>
					               	 		<rich:spacer width="5"></rich:spacer>
					               	 		<h:outputText value="#{jspMsg['label.th_bold']}" styleClass="ms7"/>
					               	 		
					               	 		<rich:spacer width="50"></rich:spacer>
					               	 		
					               	 		<h:selectBooleanCheckbox id="mco007_underline" value="#{semmco007Bean.chkContractUnderline}" ></h:selectBooleanCheckbox>
					               	 		<rich:spacer width="5"></rich:spacer>
					               	 		<h:outputText value="#{jspMsg['label.th_underline']}" styleClass="ms7"/>            	 	
					               	 	</td>
					               	</tr>
					               	<tr>
					               		<td>
					               		</td>
					               		<td align="left" width="100%" >
					               			<a4j:commandButton id="btnAddDetail" value="#{jspMsg['btn.add']}" styleClass="rich-button"
											action="#{navAction.navi}" 
											rendered="#{semmco007Bean.masterContractDetailSP.contractFormDetailId == null || 
											semmco007Bean.masterContractDetailSP.contractFormDetailId == ''}"
											reRender="frmError, frmResult, pnlDetailParam, pnlCDResult" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doAddContractDetail" />
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
											
											<a4j:commandButton id="btnSaveDetail" value="#{jspMsg['btn.save']}" styleClass="rich-button"
											action="#{navAction.navi}" 
											rendered="#{semmco007Bean.masterContractDetailSP.contractFormDetailId != null && 
											semmco007Bean.masterContractDetailSP.contractFormDetailId != ''}"
											reRender="frmError, frmResult, pnlDetailParam, pnlCDResult" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doSaveContractDetail" />
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
											
											<a4j:commandButton id="btnCancelDetail" value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="frmError, frmResult, pnlDetailParam, pnlCDResult" >
												<a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doClearContDetail" />
											</a4j:commandButton>
					               		</td>
					               	</tr>			                	
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
						
					</rich:panel>
				
					<rich:spacer height="5" rendered="#{semmco007Bean.totalList > 0}"></rich:spacer>
					
					<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1" 
					rendered="#{semmco007Bean.totalList > 0 && (semmco007Bean.masterContractTitleSP.contractFormId != null && semmco007Bean.masterContractTitleSP.contractFormId != '')}">
							
						<rich:simpleTogglePanel id="pnlSubNew"  switchType="client" label="#{jspMsg['label.th_nameofparam']}" 
				        opened="true" style="width:100%;margin:0 auto; padding:0px;vertical-align:top;">
				        		
							<rich:dataGrid id="dglParamName" 
							value="#{semmco007Bean.paramNameObjList}" var="contract" columns="#{semmco007Bean.totalColumn}" elements="#{semmco007Bean.totalList}"  first="0" >
									<h:column rendered="#{contract.dataObj.paramCode != null && contract.dataObj.paramCode != ''}">
										<div align="left" onmouseover="this.style.backgroundColor='#FFE4E1'" onmouseout="this.style.backgroundColor='transparent'">									
											<span>  
										          <a4j:commandLink value="#{contract.dataObj.paramCode} = #{contract.dataObj.paramName}" styleClass="ms7" action="#{semmco007Action.doSelectParamToCont}"
										          reRender="mco007_contDetail" >
										          	<a4j:actionparam name="paramCode" value="#{contract.dataObj.paramCode}" />
										          </a4j:commandLink>
										     </span>
										     <span>
										     </span>
										</div>
									</h:column>
				        	</rich:dataGrid>
				    	</rich:simpleTogglePanel>
				  	</h:panelGrid>
				  	
				  	<rich:spacer height="5"></rich:spacer>
					
					<h:panelGrid width="90%">
							<rich:panel id="pnlCDResult" styleClass="sem_autoScrollbar" 
							rendered="#{semmco007Bean.masterContractTitleSP.contractFormId != null && semmco007Bean.masterContractTitleSP.contractFormId != ''}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.contdetailresult']}" style="width: 1280"/>
								</f:facet>
								<div align="center">
		                            <h:outputLabel style="color:red;size:20px" value="#{semmco007Bean.msgDataNotFound}" rendered="#{semmco007Bean.renderedMsgDataNotFound}" />
		                        </div>
		                       <rich:dataTable id="tblMasterContractDetail" cellpadding="1" cellspacing="0" border="0"
									var="contract" value="#{semmco007Bean.masterContractDetailList}" 
									rows="#{semmrt007Bean.rowPerPage}"
									rowClasses="cur" 
									styleClass="dataTable" >
								
									<rich:column  >
										<f:facet name="header">
											<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
											
	     									<a4j:commandButton id="btnDeleteDetail"  action="#{navAction.navi}" 
											image="images/delete.png" 
											style="height: 15; width : 15px;" 
				                            reRender="frmError, frmResult, pnlDetailParam, pnlCDResult" rendered="#{contract.dataObj.recordStatus == 'Y'}"
				                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
					                            <a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doDelContractDetail" />
					                                        
					                            <a4j:actionparam name="contractFormId" value="#{contract.dataObj.contractFormId}" />
												<a4j:actionparam name="contractFormDetailId" value="#{contract.dataObj.contractFormDetailId}" />
												<a4j:actionparam name="contractFormTitle" value="#{contract.dataObj.contractFormTitle}" />
				                            </a4j:commandButton>
										</div>
									</rich:column>
									
									<rich:column >
										<f:facet name="header">	
											<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
											
											<a4j:commandButton id="btnEditDetail"  action="#{navAction.navi}" 
											image="images/edit.png" 
											style="height: 15; width : 15px;" 
				                            reRender="frmError, frmResult, pnlDetailParam, pnlCDResult" rendered="#{contract.dataObj.recordStatus == 'Y'}"
				                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;">
					                            <a4j:actionparam name="navModule" value="co" />
												<a4j:actionparam name="navProgram" value="SEMMCO007-2" />
												<a4j:actionparam name="moduleWithNavi" value="co" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCO007" />
												<a4j:actionparam name="methodWithNavi" value="doInitEditContDetail" />
					                                        
					                            <a4j:actionparam name="contractFormId" value="#{contract.dataObj.contractFormId}" />
												<a4j:actionparam name="contractFormDetailId" value="#{contract.dataObj.contractFormDetailId}" />
												<a4j:actionparam name="contractFormDetail" value="#{contract.dataObj.contractFormDetail}" />
												<a4j:actionparam name="contractFormOrder" value="#{contract.dataObj.contractFormOrder}" />
												<a4j:actionparam name="contractBold" value="#{contract.dataObj.contractBold}" />
												<a4j:actionparam name="contractUnderline" value="#{contract.dataObj.contractUnderline}" />
												<a4j:actionparam name="contractNewline" value="#{contract.dataObj.contractNewline}" />
				                            </a4j:commandButton>
										</div>
									</rich:column>
									
									<rich:column rendered="false">
										<f:facet name="header">
											<h:outputText value="Header" styleClass="contentform" style="width: 90" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{contract.dataObj.contractFormDetail}"  />
										</div>
									</rich:column>
									
									<rich:column sortBy="#{contract.dataObj.contractFormDetail}">
										<f:facet name="header">
											<h:outputText value="Detail" styleClass="contentform" style="width: 800"/>
										</f:facet>
										<div align="left">
											<h:outputText value="#{contract.dataObj.contractFormDetail}" />
										</div>
									</rich:column>
									
									<rich:column sortBy="#{contract.dataObj.contractFormOrder}">
										<f:facet name="header">
											<h:outputText value="Order By" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{contract.dataObj.contractFormOrder}"  />
										</div>
									</rich:column>
									
									<f:facet name="footer">
		                                <rich:columnGroup>
		                                    <rich:column colspan="3">
		                                        <h:outputFormat value="#{msg['message.totalRecords']}">
		                                        	<f:param value="#{fn:length(semmco007Bean.masterContractDetailList)}"></f:param>
		                                        </h:outputFormat>
		                                    </rich:column>
		                                    <rich:column colspan="2">
		                                        <rich:datascroller immediate="true" rendered="true" align="left" for="tblMasterContractDetail"
		                                            maxPages="#{semmco007Bean.rowPerPage}"  selectedStyleClass="selectScroll"
		                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
		                                            id="dstTblMasterContractDetail" 
		                                            style="background-color: #cccccc;"
		                                            page="#{semmco007Bean.scrollerPage}" 
		                                        />
		                                    </rich:column>
		                                </rich:columnGroup>
		                            </f:facet>
								</rich:dataTable>
							</rich:panel>
						</h:panelGrid>
						
					</a4j:form>
				</h:panelGrid>
				
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>

<rich:modalPanel id="popupAddDetail" width="750" minWidth="400" height="300" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popUpAddDetail']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupAddDetail" style="cursor:pointer"/>
				<rich:componentControl for="popupAddDetail" attachTo="hidepopupAddDetail" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="popupFrmAdd">
		<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
			<h:panelGroup>
			<table width="100%">
				<tr>
					<td align="right" width="40%">
						<h:outputText value="#{jspMsg['label.header']} :" styleClass="ms7"/>
           			</td>
           			<td width="60%">
           				<h:inputText size="80"/>
              		</td>
               	</tr>
               	<tr>
                	<td align="right" width="40%">
                		<h:outputText value="#{jspMsg['label.detail']} :" styleClass="ms7"/>
              		</td>
              		<td width="60%">
              			<h:inputTextarea value=" " rows="5" cols="80" />
                	</td>
               	</tr>
               	<tr>
               	 	<td align="right" width="40%">
               	 		<h:outputText value="#{jspMsg['label.orderBy']} :" styleClass="ms7"/>
               	 	</td>
               	 	<td width="60%">
               	 		<h:inputText size="80"/>               	 	
               	 	</td>
               	</tr>
               	<tr>
               		<td align="left" width="100%" colspan="2">
               			<a4j:commandButton id="btnPopupAddDetailSave" value="Save" styleClass="rich-button"
						action="#{navAction.navi}" reRender="frmErrorPopupPropertyTax,dtbMpt001Srch,frmError" 
						>
						</a4j:commandButton>
						<rich:spacer width="5"/>
						<a4j:commandButton id="btnPopupAddDetailCancel" value="Cancel" styleClass="rich-button"
						action="#{navAction.navi}" reRender="frmErrorPopupPropertyTax,dtbMpt001Srch,frmError"
						oncomplete="#{rich:component('popupAddDetail')}.hide();">
						</a4j:commandButton>
               		</td>
               	</tr>			                	
			</table>
			</h:panelGroup>
		</h:panelGrid>
		</a4j:form>
</rich:modalPanel>

