<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.popup.editDetail" var="jspMsgEditDetail"/>
	<rich:modalPanel id="popupEditDetailHistory" width="900" minWidth="300" moveable="true" height="550" minHeight="550" autosized="false" style="overflow:auto;" >
		<f:facet name="header">
				<h:outputText value="#{jspMsgEditDetail['header.popup.hisotryEditPeriod']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditDetailHistory" style="cursor:pointer"/>
					<rich:componentControl for="popupEditDetailHistory" attachTo="hidePopupEditDetailHistory" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmEditPeriod"> 
				<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1" >
							<h:panelGroup>
					<rich:panel id="pnlModelList" style="width:100%">
						<f:facet name="header" >
							<h:outputText value="#{jspMsgEditDetail['header.popup.hisotryEditPeriod']}"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{popupEditHistoryBean.msgDataNotFound}" rendered="#{popupEditHistoryBean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="95%" id="dtbModelDetail" cellpadding="1" cellspacing="0" border="0"
							var="modelSP" value="#{popupEditHistoryBean.historyDetailSPList}"
							rows="10" styleClass="dataTable" rowClasses="cur">
							
							<rich:column width="10%" >
								<f:facet name="header">
									<h:outputText value="#{jspMsgEditDetail['label.approveNo']}" styleClass="contentform" style="width:60px; font:bold;"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{modelSP.docNo}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  width="35%" >
								<f:facet name="header">
									<h:outputText value="#{jspMsgEditDetail['label.topic']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{modelSP.siteChangeDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsgEditDetail['label.detail']}" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{modelSP.detail}" styleClass="contentform" escape="false">
									</h:outputText>
								</div>
							</rich:column>
							
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbModelDetail"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstElDetail" 
											style="background-color: #cccccc;"
											page="10" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							</rich:dataTable>
							</rich:panel>
							</h:panelGroup>
						</h:panelGrid>
				<!-- end content criteria -->
		</a4j:form>
	</rich:modalPanel>