<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel005-4" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.textFileFail']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columns="4" id="grdSearchCommand2" width="95%">
			<a4j:form id="frmBack">
			<div align="right">
			<a4j:commandButton id="btnSearch2" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent">
				<a4j:actionparam name="navModule" value="el" />
				<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
				<a4j:actionparam name="moduleWithNavi" value="el" />
				<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
				<a4j:actionparam name="methodWithNavi" value="doBack" />
			</a4j:commandButton>
			</div>
			</a4j:form>
		</h:panelGrid>	
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.fileData']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtCompany" value="#{semmel005Bean.importTransaction.company}" disabled="true" style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">&nbsp;</td>
										<td width="30%">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileType']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtFileType" value="#{semmel005Bean.importTransaction.fileTypeDisplay}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtFileName" value="#{semmel005Bean.importTransaction.fileName}" disabled="true"
												style="width:180px;" maxlength="15"/></td>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.refDocId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtRefDocId" value="#{semmel005Bean.importTransaction.refDocId}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadDt']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtUploadDt" value="#{semmel005Bean.importTransaction.uploadDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">												
													<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtProcessDt" value="#{semmel005Bean.importTransaction.processDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
																								
													<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
											</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.validateFailed']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtValidateSuccess" value="#{semmel005Bean.importTransaction.validateFailed}" disabled="true"
												style="width:180px;" maxlength="15">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.failedPaid']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtSuccessPaid" value="#{semmel005Bean.importTransaction.failedPaid}" disabled="true"
												style="width:180px;" maxlength="15">
												<f:convertNumber pattern="#,##0"/>
												</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.failedNoPaid']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtSuccessNoPaid" value="#{semmel005Bean.importTransaction.failedNoPaid}" disabled="true"
												style="width:180px;" maxlength="15">
											<f:convertNumber pattern="#,##0"/>	
											</h:inputText>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="95%">
					<rich:panel id="pnlSumError">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.errorCode']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup id="new_validate_failed">
								
								<rich:dataTable id="dtbFailedList" width="100%" cellpadding="0" cellspacing="0" border="0" 
								var="obj" value="#{semmel005Bean.validateFailList}" reRender="dtbFailedList">
																
									<rich:column styleClass="#{obj.styleClassName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.errorCode']}" />
										</f:facet>
										<div align="left" >
											<h:outputText value="#{obj.errMsgDesc}" styleClass="contentform"/>
										</div>								
									</rich:column>
									
									<rich:column styleClass="#{obj.styleClassName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['label.all']} #{jspMsg['header.list']}" styleClass="ms7"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{obj.countAll}"/>
										</div>								
									</rich:column>
									
									<rich:column styleClass="#{obj.styleClassName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['label.close']} #{jspMsg['header.list']}" styleClass="ms7"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{obj.countClose}"/>
										</div>								
									</rich:column>
									
									<rich:column styleClass="#{obj.styleClassName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['label.unClose']} #{jspMsg['header.list']}" styleClass="ms7"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{obj.countNonClose}"/>
										</div>								
									</rich:column>
									
								</rich:dataTable>
								
								<table width="100%" style="display:none;">	
									<tr>
										<td width="20%">&nbsp;</td>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.all']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/>
										</td>
										<td align="center" width="20%"><h:outputText value="#{jspMsg['label.close']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
										<td align="center" width="30%"><h:outputText value="#{jspMsg['label.unClose']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e1']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay12Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay12PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay12NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>							
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e2']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay01Size}"  styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay01PaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay01NoPaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e3']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText id="txtELPay02SizeNew" value="#{semmel005Bean.elPay02Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay02PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay02NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ne4']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay03Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay03PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay03NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e5']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay04Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay04PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay04NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ne6']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay04Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay04PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay04NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>		
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ne7']}" styleClass="ms7"/>
											
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay11Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%">
										<h:outputText value="#{semmel005Bean.elPay11PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText>
										
										</td>
										<td width="30%" align="center">
										<h:outputText value="#{semmel005Bean.elPay11NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ne8']}" styleClass="ms7"/>
											
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay11Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%">
										<h:outputText value="#{semmel005Bean.elPay11PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText>
										
										</td>
										<td width="30%" align="center">
										<h:outputText value="#{semmel005Bean.elPay11NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e7']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay05Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
											
										</td>
										<td align="center" width="20%">
											<h:outputText value="#{semmel005Bean.elPay05PaidSize}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay05NoPaidSize}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e8']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay06Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay06PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay06NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e9']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e10']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e11']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									
									
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.sum']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.sumFail}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.sumFailPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.sumFailNoPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>								
								</table>
							</h:panelGroup>
						
						
							<h:panelGroup rendered="false">
								<table width="100%">	
									<tr>
										<td width="20%">&nbsp;</td>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.all']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/>
										</td>
										<td align="center" width="20%"><h:outputText value="#{jspMsg['label.close']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
										<td align="center" width="30%"><h:outputText value="#{jspMsg['label.unClose']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e1']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay12Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay12PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay12NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>							
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e2']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay01Size}"  styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay01PaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay01NoPaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e3']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText id="txtELPay02Size" value="#{semmel005Bean.elPay02Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay02PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay02NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e4']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay03Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay03PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay03NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e5']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay04Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay04PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay04NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e6']}" styleClass="ms7"/>
											
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay11Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%">
										<h:outputText value="#{semmel005Bean.elPay11PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText>
										
										</td>
										<td width="30%" align="center">
										<h:outputText value="#{semmel005Bean.elPay11NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e7']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay05Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
											
										</td>
										<td align="center" width="20%">
											<h:outputText value="#{semmel005Bean.elPay05PaidSize}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay05NoPaidSize}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e8']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay06Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay06PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay06NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e9']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e10']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.e11']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay07Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay07PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay07NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>
									
									
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.sum']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.sumFail}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.sumFailPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.sumFailNoPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
											</h:outputText></td>
									</tr>								
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="95%">
					<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.searchCriteria']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlRegion" value="#{semmel005Bean.region}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.regionList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.paidFlag']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlPaidFlag" value="#{semmel005Bean.paidFlag}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.paidFlagList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.invNo']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtInvNo" value="#{semmel005Bean.invNo}" 
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtMeterId" value="#{semmel005Bean.meterId}" 
												style="width:180px;" maxlength="15"/>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.errorCode']}" styleClass="ms7"/>
										</td>
										<td>
											<h:selectOneMenu id="ddlErrorCode" value="#{semmel005Bean.errorCode}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.errorCodeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.jobStatus']}" styleClass="ms7"/></td>
										<td width="30%"><h:selectOneMenu id="ddlClearingFlag" value="#{semmel005Bean.clearingFlag}" style="width:120px;">
															<f:selectItem itemLabel="-- Select --" itemValue=""/>
															<f:selectItem itemLabel="#{jspMsg['item.closeJob']}" itemValue="Y"/>
															<f:selectItem itemLabel="#{jspMsg['item.noneCloseJob']}" itemValue="N"/>
														</h:selectOneMenu></td>
									</tr>									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchSiteApprove,frmError">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch4" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doClear4" />
								<a4j:actionparam name="rowId" value="#{semmel005Bean.importTransaction.rowId}" />
			            	</a4j:commandButton>			            	
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
				
				<a4j:form id="frmUploadText">
				<h:panelGrid columns="13" id="grdActionCommand">
					<h:commandButton id ="btnExport" action="#{semmel005Action.exportError}"  
	            					 styleClass="rich-button" value="#{jspMsg['btn.export']}"/>	
	            					 
	            	<a4j:commandButton id="btnExpForupload" value="#{jspMsg['btn.export']} For Upload Meter" 
					            styleClass="rich-button" rendered="false"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="reValidate" />
					</a4j:commandButton>		
	            	<a4j:commandButton id="btnCloseJob" value="#{jspMsg['btn.closeJob']}" 
								oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
								styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn}"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
					</a4j:commandButton>
					<rich:spacer width="5"/>
					<a4j:commandButton id="btnUnpaid" value="#{jspMsg['btn.unpaid']}" 
								oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
								styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn}"
								rendered="flase"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
					</a4j:commandButton>			
					
					<a4j:commandButton id="btnRevalidate" value="#{jspMsg['btn.reValidate']}" 
					            styleClass="rich-button"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="reValidate" />
					</a4j:commandButton>			
					<rich:spacer width="5"/>
					<a4j:commandButton id="btnTruth" value="#{jspMsg['btn.truth']}" 
								styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn}"
								rendered="true"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="alreadyTrue" />
					</a4j:commandButton>
					
					<rich:spacer width="5"/>
						
					<a4j:commandButton id="btnExportMeterPt" value="#{jspMsg['btn.exportmeter']}" styleClass="rich-button" 
			        action="#{navAction.navi}" disabled="#{semmel005Bean.disableBtnExportMeter}" 
			        onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			        reRender="pnlShowExportMeterExcel">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-4pt" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initExportMeter" />
						<a4j:actionparam name="rowId" value="#{semmel005Bean.importTransaction.rowId}" />
			        </a4j:commandButton>
					
					<rich:spacer width="5"/>
					
					<a4j:commandButton id="btnExportTextPt" value="#{jspMsg['btn.exporterror']}" styleClass="rich-button" 
			        action="#{navAction.navi}"
			        onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
			        reRender="pnlShowExportTextExcel">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-4pt" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initExportText" />
						<a4j:actionparam name="rowId" value="#{semmel005Bean.importTransaction.rowId}" />
						<a4j:actionparam name="processId" value="#{semmel005Bean.importTransaction.processId.rowId}" />
			        </a4j:commandButton>
			     
				
				</h:panelGrid>
				<h:panelGrid id="errorMiddle">
				<rich:spacer height="15"></rich:spacer>
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel005Bean.renderedMsgFormMiddle}">
									<f:facet name="header">
										<h:outputText value="Entered Data Status:"></h:outputText>
									</f:facet>
									<f:facet name="errorMarker">
										<h:graphicImage value="images/error.gif" />  
									</f:facet>
								</rich:messages>
				</h:panelGrid>
				<a4j:jsFunction name="onRenderButton" action="#{semmel005Action.renderDependOnChkValidate}" 
				reRender="btnCloseJob,btnUnpaid,btnTruth">
				</a4j:jsFunction>
				
				<jsp:include page="../../pages/el/semmel005-4table.jsp"></jsp:include>
				
				</a4j:form>
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<a4j:form id="frmUpdateStatusDialog">
<rich:modalPanel id="mdpUpdate10001" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="Data Update"></h:outputText>
    </f:facet>

	<h:panelGrid>
		</h:panelGrid>
	
		<table width="500px" border="0" cellspacing="" cellpadding="2">			
			
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.invAmt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.invAmt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.invVatAmt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.invVatAmt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.unit']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.unit}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.electOnpeak']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.electOnpeak}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.electOffpeak']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.electOffpeak}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.electDemandOn']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.electDemandOn}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.electDemandPart']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.electDemandPart}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.electDemandOff']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.electDemandOff}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.reactive']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.reactive}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.kwhTotal']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.kwhTotal}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.kwhOn']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.kwhOn}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.kwhOff']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.kwhOff}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>			
			<tr>
				<td align="left" colspan="2">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="doUpdateELPAY07" />
						<rich:componentControl for="mdpUpdate10001" operation="hide" event="onclick" />
					</a4j:commandButton>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" >
					    <rich:componentControl for="mdpUpdate10001" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	
	
</rich:modalPanel>
</a4j:form>

<rich:modalPanel id="mdpConfirmCloseJobDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirmed Message"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCloseJobDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">						
						<h:outputText value="#{semmel005Bean.confirmCloseJobValidateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
						reRender="pnlSearchResult, frmError" 	>
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL005-4" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
							<a4j:actionparam name="methodWithNavi" value="closeJobValidate" />							
							<rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>
		
		<h:panelGrid id="pnlShowExportMeterExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExportMeterExcel" rendered="#{semmel005Bean.displayExportMeter}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowExportMeterExcel" style="height:0px;width:0px;display:none;" action="#{semmel005Action.doExportMeter}" />								
							<script>document.getElementById('incContent:frmConfirmCloseJobDialog:bthShowExportMeterExcel').click();</script>
						</h:panelGroup>							
		</h:panelGrid>	
		<h:panelGrid id="pnlShowExportTextExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExportTextExcel" rendered="#{semmel005Bean.displayExportUptFormat}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowExportTextExcel" style="height:0px;width:0px;display:none;" action="#{semmel005Action.doExportTextNew}" />								
							<script>document.getElementById('incContent:frmConfirmCloseJobDialog:bthShowExportTextExcel').click();</script>
						</h:panelGroup>							
		</h:panelGrid>	
	</a4j:form>
	
	
</rich:modalPanel>
<jsp:include page="../../pages/el/semmel005_popup.jsp"/>
