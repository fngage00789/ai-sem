<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.el.semmel005-5" var="jspMsg"/>
<a4j:form id="frm5-5">
<h:panelGrid width="100%">
	<rich:panel id="pnlEditFtRate">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.updateFtRate']}"/></f:facet>
		<h:panelGrid>
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			
		</h:panelGrid>
			
			<h:panelGrid width="90%">
				
					<h:panelGroup id="pnlBtHead">
						<table width="100%">
							<tr>
								<td width="50%" align="left">
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td align="right">
												
												<a4j:commandButton id="btnBack"
													value="#{jspMsg['btn.back']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													>
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-8-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doClear8" />												
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnSave"
													value="#{jspMsg['btn.save']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													>
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-8-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doUpdateFtRate" />
												</a4j:commandButton>
												
											</td>
											<td align="right">
												
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					
				</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.updateFtData']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									
									<tr>
										<td align="right" width="28%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											 value="#{semmel005Bean.ftStartDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											
										    <rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											 value="#{semmel005Bean.ftEndDt}" inputSize="18" 
											 disabled="#{semmel005Bean.updateFtRate.recordStatus == 'ACTIVE'}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
									</tr>									
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.ftType']}" styleClass="ms7"/>
										</td><td >
											<h:selectOneRadio value="#{semmel005Bean.ftRateType}"  
											styleClass="ms7"
							                layout="lineDirection">
					                				<f:selectItem itemValue="Y" itemLabel="(+)" />
					                				<f:selectItem itemValue="N" itemLabel="(-)" />					                				
					                		</h:selectOneRadio>		
										</td>
										<td align="right" >
										</td>
										<td>
											
										</td>
									</tr>
									
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
		
					
				</h:panelGrid>
	</rich:panel>
</h:panelGrid>
</a4j:form>
