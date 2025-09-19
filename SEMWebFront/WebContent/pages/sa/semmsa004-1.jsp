<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.sa.semmsa004" var="jspMsg"/>
	
	<!-- >> wrapper panel -->
	<h:panelGrid id="panelWrapperAll" style="width:100%; vertical-align:top;" columns="2">
		<rich:panel id="panelWrapper" style="height:100%; border:1 ececec solid; top:0px; vertical-align:top;">
	
			<!-- content panel -->
			<rich:panel style="border:1 e0e0e0 solid; height:100%; vertical-align:top;">
				<!-- >> header content -->
					<f:facet name="header">
						<h:outputText value="Executive Approve" />
					</f:facet>
				<!-- << header content -->
				
				<rich:panel  style="width:100%; overflow:auto;" styleClass="sem_autoScrollbar">
				
					<!-- when data is null -->
					<h:panelGroup style="width:100%;" rendered="#{semmsa004Bean.exctApproveList == null}">
						<div align="center">
							<!-- top >> -->
							<table style="width:100%; background-color:cada30; border:2px solid e0e0e0;">
								<tr>
									<td style="width:25%; text-align:center;">
										<h:outputText value="Location : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.th_dataNotFound']}" styleClass="ms7" />
									</td>
									<td style="width:25%; text-align:center;">
										<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.th_dataNotFound']}" styleClass="ms7" />
									</td>
									<td style="width:25%; text-align:center;">
										<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_docNo']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.th_dataNotFound']}" styleClass="ms7" />
									</td>
								</tr>
								<tr>
									<td style=" height:30px; text-align:center; border:solid #faf 1px; vertical-align:middle; background-color:#fff;" colspan="3">
										<h:outputLabel style="color:red; size:20px;" value="#{jspMsg['label.th_dataNotFound']}" styleClass="ms7" />
									</td>
								</tr>
							</table>
							<!-- top << -->
						</div>
					</h:panelGroup>
					
					<!-- when data is not null -->
					<h:panelGroup style="width:100%;" rendered="#{semmsa004Bean.exctApproveList != null}">
						<a4j:form id="frmExctApproveList">
		            	<rich:dataTable style="width:100%;" cellpadding="1" cellspacing="0" border="0" 
		            	var="item_"  value="#{semmsa004Bean.exctApproveList}" id="dataTableExctApproveList" 
		            	rows="" rowClasses="cur" styleClass="dataTable">
			                <rich:column style="padding:5px;">
			                    <div align="center">
									<!-- top >> -->
									<table style="width:100%; background-color:cada30; border:2px solid e0e0e0;">
										<tr>
											<td style="width:25%; text-align:center;">
												<h:outputText value="Location : " style="font-weight:bold;" styleClass="ms7" />
												<h:outputText value="#{item_.dataObj.locationId}" style="font-style: italic;" styleClass="ms7" />
											</td>
											<td style="width:25%; text-align:center;">
												<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} : " style="font-weight:bold;" styleClass="ms7" />
												<h:outputText value="#{item_.dataObj.contractNo}" style="font-style: italic;" styleClass="ms7" />
											</td>
											<td style="width:25%; text-align:center;">
												<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_docNo']} : " style="font-weight:bold;" styleClass="ms7" />
												<h:outputText value="#{item_.dataObj.docNo}" style="font-style: italic;" styleClass="ms7" />
											</td>
										</tr>
									</table>
									<!-- top << -->
								
									<!-- detail >> -->
									<table style="width:100%; border:1px solid e0e0e0;" border="0">
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_type']}#{jspMsg['label.th_docNo']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.reqTypeText}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_effectiveDate']} #{jspMsg['label.th_contract']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.effectiveDtStr}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_expireDate']} #{jspMsg['label.th_contract']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.expireDtStr}" style="width:70px;" styleClass="ms7" />
											</td>
											<td style="white-space:nowrap;" colspan="2">
												<a4j:commandButton id="msa004_BtnMoreInfo" value="#{jspMsg['label.th_more_information']}" 
												action="#{navAction.navi}" reRender="oppContent" styleClass="rich-button">
													<a4j:actionparam name="navModule" value="sa" />
													<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
													
													<a4j:actionparam name="moduleWithNavi" value="sa" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
													<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
													
													
													<a4j:actionparam name="rowId" value="#{item_.dataObj.siteAppId}" />
													<a4j:actionparam name="paramMode" value="V" />
													
													<a4j:actionparam name="paramBackToMe" value="Y" />
					                                <a4j:actionparam name="paramNavModuleFrom" value="sa" />
					                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSA004-1" />
					                                <a4j:actionparam name="paramModuleWithNaviFrom" value="sa" />
					                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSA004" />
					                                <a4j:actionparam name="paramMethodWithNaviFrom" value="doInitialExctApprove" />
												</a4j:commandButton>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="Location Name :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.locationName}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_company']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.company}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_region']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.region}" styleClass="ms7" />
											</td>
											<td style="white-space:nowrap;" colspan="2">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="Site Code :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.siteCode}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="Site Type :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.siteType}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="Station :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.stationType}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="Network Status :" styleClass="ms7" />
											</td>
											<td style="text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.networkStatus}" styleClass="ms7" />
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_rent']}#{jspMsg['label.th_per']}#{jspMsg['label.th_year']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.costPerYear}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="Revenue per Site :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.revenuePerSite}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="Max Rent :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.maxRent}" styleClass="ms7" />
											</td>
											<td style="white-space:nowrap;" colspan="2">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_rent']}#{jspMsg['label.th_old']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.prevCost}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_rent']}#{jspMsg['label.th_increase']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.increasePerc}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_expensive']} Site #{jspMsg['label.th_near']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.maxRent}" styleClass="ms7" />
											</td>
											<td style="white-space:nowrap;" colspan="2">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7" />
											</td>
											<td style="text-align:left; white-space:nowrap;" colspan="3">
												<h:outputText value="#{item_.dataObj.remark}" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_personal_approve']} :" styleClass="ms7" />
											</td>
											<td style="width:10%; text-align:left; white-space:nowrap;">
												<h:outputText value="#{item_.dataObj.avpApproveBy}" styleClass="ms7" />
											</td>
											<td style="white-space:nowrap;" colspan="2">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;">
												&nbsp;
											</td>
											<td style="white-space:nowrap;" colspan="5">
												<a4j:commandButton id="msa004_BtnApprve" value="Approve" styleClass="rich-button"
												action="#{semmsa004Action.doPrepareCallPopup}" reRender="popUpCommon"
												oncomplete="#{rich:component('msa004PopUpCommon_confirmApprove')}.show();">
													<a4j:actionparam name="paramSiteAppId" value="#{item_.dataObj.siteAppId}" />
												</a4j:commandButton>
											</td>
											<td style="text-align:left; white-space:nowrap;" colspan="2">
												<a4j:commandButton id="msa004_BtnReject" value="Reject" styleClass="rich-button"
												action="#{semmsa004Action.doPrepareCallPopup}" reRender="popUpCommon"
												oncomplete="#{rich:component('msa004PopUpCommon_confirmReject')}.show();">
													<a4j:actionparam name="paramSiteAppId" value="#{item_.dataObj.siteAppId}" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
									<!-- detail << -->
								</div>
								
	            			</rich:column>
	                     
	                	</rich:dataTable>
	                	</a4j:form>
	        		</h:panelGroup>  
            	</rich:panel>
			</rich:panel>
		</rich:panel>
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	<a4j:include id="popUpCommon"  viewId="../../pages/sa/semmsa004PopUpCommon.jsp" />
