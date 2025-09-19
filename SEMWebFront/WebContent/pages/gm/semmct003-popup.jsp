<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.gm.semmct003" var="jspMsg"/>
	<rich:modalPanel id="popupApproveBookBank" width="470" minWidth="250" height="250">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupApproveBookBank" style="cursor:pointer"/>
					<rich:componentControl for="popupApproveBookBank" attachTo="hidePopupApproveBookBank" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupApproveSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAct">
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpApprove']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										
										<td align="right" valign="top" colspan="3" width="50%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
			                			</td>
			                			<td width="25%">
			                				<h:inputTextarea id="txtremark" value="#{semmct003Bean.remark}" rows="3" cols="60"/>
					                	</td>
					                	<td>
					                	</td>
				               		</tr>
				                	 
				                	<tr>
					                	<td width="20%">
			                			</td>
			                			<td colspan="3">
					                	</td>
					                	
				                	 </tr>
				                	 <tr>
				                	 	<td colspan="3" width="50%"></td>
				                	 	<td width="25%">
				                	 		<a4j:commandButton id="btnPopupApproveSave" value="Save" styleClass="rich-button"
											action="#{navAction.navi}" reRender="frmError,frmSearchResult,dtbApproveBookBankSrch" 
											oncomplete="if(#{semmct003Bean.popupClose == 'true'})#{rich:component('popupApproveBookBank')}.hide();">
												<a4j:actionparam name="navModule" value="gm" />
												<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
												<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
											
											<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
											 reRender="frmErrorPopupApproveSave,dtbApproveBookBankSrch,frmError">
											 	<a4j:actionparam name="navModule" value="gm" />
												<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
												<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
												<rich:componentControl for="popupApproveBookBank" operation="hide" event="onclick" />
											</a4j:commandButton>
				                	 	</td>
				                	</tr>			                	
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	<!-- Checker Finance -->
	<rich:modalPanel id="popupCheckerBookBank" width="470" minWidth="250" height="250">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupChecker']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupCheckerBookBank" style="cursor:pointer"/>
					<rich:componentControl for="popupCheckerBookBank" attachTo="hidePopupCheckerBookBank" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupCheckerSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupCheckerFrm">
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupChecker']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" valign="top" colspan="3" width="50%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtremark" value="#{semmct003Bean.remark}" rows="3" cols="60"/>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td colspan="3" width="50%"></td>
			                	 	<td width="25%">
			                	 		<a4j:commandButton id="btnPopupChecker" value="Save" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmError,frmSearchResult,dtbApproveBookBankSrch" 
									oncomplete="if(#{semmct003Bean.popupClose == 'true'})#{rich:component('popupCheckerBookBank')}.hide();">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
										<a4j:actionparam name="methodWithNavi" value="doCheckFinance" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,dtbApproveBookBankSrch,frmError">
									 	<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
										<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
										<rich:componentControl for="popupCheckerBookBank" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	<!-- SAP Checker Finance -->
	<rich:modalPanel id="popupSapCheckerBookBank" width="670" minWidth="250" height="250">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupChecker']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupSapCheckerBookBank" style="cursor:pointer"/>
					<rich:componentControl for="popupSapCheckerBookBank" attachTo="hidePopupSapCheckerBookBank" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupSapCheckerSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmct003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupSapCheckerFrm">
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupChecker']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" valign="top" colspan="3" width="50%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtremark" value="#{semmct003Bean.remark}" rows="3" cols="60"/>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td colspan="3" width="50%"></td>
			                	 	<td width="25%">
			                	 		<a4j:commandButton id="btnPopupChecker" value="Save" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmError,frmSearchResult,dtbApproveBookBankSrch,oppContent" 
									oncomplete="if(#{semmct003Bean.popupClose == 'true'})#{rich:component('popupSapCheckerBookBank')}.hide();">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
										<a4j:actionparam name="methodWithNavi" value="doCheckerFinanceApprove" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,dtbApproveBookBankSrch,frmError">
									 	<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT003-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT003" />
										<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
										<rich:componentControl for="popupSapCheckerBookBank" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	