<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.rentService" var="jspMsgRentService" />
<rich:modalPanel id="popupRentServiceDetail" height="600" width="800" resizeable="false" moveable="false" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgRentService['header.label.rentDetail']}" ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="/images/ico_close.png"
				id="hidePopupRentServiceDetail" style="cursor:pointer" /> 
				<rich:componentControl for="popupRentServiceDetail" attachTo="hidePopupRentServiceDetail" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:panelGrid>
			<a4j:form id="frmError">
			 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupViewSiteInfoBean.renderedMsgDataNotFound}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>	
	
<a4j:form id="frmPopupRentServiceDetail">	
	<h:panelGrid id="pnlResultRentServiceDetail" width="90%">
					<h:panelGroup rendered="true">
					<rich:panel style="width:770px; overflow:auto;" rendered="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.renderRentCond}">
					<f:facet name="header">
						<h:outputText value="#{jspMsgRentService['column.header.rentNormalDetail']}" style="width:1460"/>
					</f:facet>
					<!-- datatable -->
					<rich:dataTable id="dtbRentCondDetail" width="95%"  cellpadding="1" cellspacing="0" border="0"
						var="rentCondSP"  value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentCondNormList}" reRender="dtbRentCondDetail" 
						rows="10"	rowClasses="cur" styleClass="dataTable">
						<a4j:support event="onRowClick"   reRender="dtbRentCondDetail">
							<a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />
						</a4j:support>
						<rich:column sortBy="#{rentCondSP.expenseTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.type']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{rentCondSP.expenseTypeName}" styleClass="contentform" style="width:70px"></h:outputText>
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.placeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.placeName']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{rentCondSP.placeName}" styleClass="contentform" style="width:70px"></h:outputText>
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.detail}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.detail']}" styleClass="contentform" style="width:180px"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{rentCondSP.detail}" styleClass="contentform" style="width:180px" />
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.rentOldAmt}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.rentOldAmt']}" styleClass="contentform" style="width:70px" />
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSP.rentOldAmt}" styleClass="contentform" style="width:70px">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.rentAddPercent}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.rentAddPercent']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSP.rentAddPercent}" styleClass="contentform" style="width:70px" />
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.rentAddAmt}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.rentAddAmt']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSP.rentAddAmt}" styleClass="contentform" style="width:70px">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>		
						<rich:column sortBy="#{rentCondSP.rentAmt}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.rentAmt']}" styleClass="contentform" style="width:70px" />
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSP.rentAmt}" styleClass="contentform" style="width:70px">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>	
						<rich:column sortBy="#{rentCondSP.rentPeriodTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.rentPeriodTypeName']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSP.rentPeriodTypeName}" styleClass="contentform" style="width:70px" />
							</div>
						</rich:column>		
						<rich:column sortBy="#{rentCondSP.whtTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.whtTypeName']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSP.whtTypeName}" styleClass="contentform" style="width:70px" />
							</div>
						</rich:column>	
						<rich:column sortBy="#{rentCondSP.whtRate}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.whtRate']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSP.whtRate}" styleClass="contentform" style="width:70px" />
							</div>
						</rich:column>	
						<rich:column sortBy="#{rentCondSP.vatTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="VAT(#{semmsi004tab3Bean.columnVatRate}%)" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSP.vatTypeName}" styleClass="contentform"  style="width:70px"/>
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.payPeriodTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.payPeriodTypeName']}" styleClass="contentform"style="width:70px" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSP.payPeriodTypeName}" styleClass="contentform" style="width:70px" />
							</div>
						</rich:column>
						<rich:column sortBy="#{rentCondSP.effDate}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.effDate']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSP.effDateStr}" styleClass="contentform" style="width:70px">
								</h:outputText>
							</div>
						</rich:column>
						
						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
									<h:outputFormat value="#{msg['message.totalRecords']}">
										<f:param value="#{fn:length(popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentCondNormList)}"></f:param>
									</h:outputFormat>
								</rich:column>
								<rich:column colspan="14">
									<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCondDetail"
										selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" 
										id="dstRentCondDetail" 
										style="background-color: #cccccc;"
									/>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable>
					</rich:panel>
					<rich:spacer height="20px"></rich:spacer>
					
					<rich:panel style="width:770px;" rendered="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.renderRentCond2}">
					<f:facet name="header">
						<h:outputText value="#{jspMsgRentService['column.header.rentSpecialDetail']}" style="width:750px"/>
					</f:facet>
					<!-- datatable -->
					<rich:dataTable id="dtbRentCondSpecDetail" width="95%"  cellpadding="1" cellspacing="0" border="0"
						var="rentCondSpecial"  value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentCondSpecList}" reRender="dtbRentCondSpecDetail" 
						rows="10"	rowClasses="cur" styleClass="dataTable">
						<a4j:support event="onRowClick"   reRender="dtbRentCondSpecDetail">
							<a4j:actionparam name="rowId" value="#{rentCondSpecial.rowId}" />
						</a4j:support>
						
						<rich:column sortBy="#{rentCondSpecial.expenseTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSpecial.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.type']}" styleClass="contentform" style="width:70px"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{rentCondSpecial.expenseTypeName}" styleClass="contentform" style="width:70px"></h:outputText>
							</div>
						</rich:column>
						
						<rich:column sortBy="#{rentCondSpecial.detail}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSpecial.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.detail']}" styleClass="contentform" style="width:300px"/>
							</f:facet>
							<div align="left">
								<h:outputText value="#{rentCondSpecial.detail}" styleClass="contentform"  style="width:300px"/>
							</div>
						</rich:column>

						<rich:column sortBy="#{rentCondSpecial.whtTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSpecial.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.whtTypeName']}" styleClass="contentform" style="width:60px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSpecial.whtTypeName}" styleClass="contentform" style="width:60px" />
							</div>
						</rich:column>	
						<rich:column sortBy="#{rentCondSpecial.whtRate}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSpecial.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsgRentService['header.column.whtRate']}" styleClass="contentform" style="width:60px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentCondSpecial.whtRate}" styleClass="contentform" style="width:60px" />
							</div>
						</rich:column>	
						<rich:column sortBy="#{rentCondSpecial.vatTypeName}" styleClass="#{(popupViewSiteInfoBean.tmpRowId==rentCondSpecial.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="VAT(#{semmsi004tab3Bean.columnVatRate}%)" styleClass="contentform" style="width:60px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentCondSpecial.vatTypeName}" styleClass="contentform" style="width:60px" />
							</div>
						</rich:column>
						
						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
									<h:outputFormat value="#{msg['message.totalRecords']}">
										<f:param value="#{fn:length(popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentCondSpecList)}"></f:param>
									</h:outputFormat>
								</rich:column>
								<rich:column colspan="0">
									<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCondSpecDetail"
										selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" 
										id="dstRentCondSpecDetail" 
										style="background-color: #cccccc;"
									/>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable>
					</rich:panel>
					
					
					<table width="95%">
								<tr>
									<td>
										<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
											<rich:componentControl for="popupRentServiceDetail" operation="hide" event="onclick" />
										</a4j:commandButton>
									</td>
								</tr>
							
					</table>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
</rich:modalPanel>