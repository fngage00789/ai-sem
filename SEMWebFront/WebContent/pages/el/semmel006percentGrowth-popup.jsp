<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<f:loadBundle basename="resources.el.semmel006" var="jspMsgPercentGrowth" />

<rich:modalPanel id="popupPercentGrowth" width="550" autosized="true" minWidth="400" height="600">
	<f:facet name="header">
		<h:outputText value="#{jspMsgPercentGrowth['header.popup.percentGrowth']}" />
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidePopupPercentGrowth" style="cursor:pointer" /> 
				<rich:componentControl for="popupPercentGrowth" attachTo="hidePopupPercentGrowth" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		
	<h:panelGrid>
		<a4j:form id="frmErrorPopupPercentGrowth">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="frmPopupPercentGrowth">
		<h:panelGrid width="100%">
					<rich:panel id="pnlPercentGrowthHead" header="#{jspMsgPercentGrowth['label.header.percenGrowth']}"
					
						style="height:100px;width:800px;padding-bottom:0px;padding-left:0px;padding-right:0px;padding-top:0px;">
						<table width="95%">
							<tr>
								<td align="right" width="20%">
									<h:outputText value="#{jspMsgPercentGrowth['label.fromTermOfPaymentDt']}" styleClass="ms7"/>
								</td>
								<td align="left" colspan="7">
									<h:outputText value="#{semmel006Bean.elGroupSP.termPayDtStr}" styleClass="ms7">
									<f:convertDateTime pattern="dd/MM/yyyy"/>
									</h:outputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="20%">
									<h:outputText value="#{jspMsgPercentGrowth['label.kwh']}" styleClass="ms7"/>
								</td>
								<td align="left" width="10%">
									<h:outputText value="#{semmel006Bean.elGroupSP.percentKwhNewDouble}" styleClass="ms7">
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</td>
								<td align="right" width="10%">
									<h:outputText value="#{jspMsgPercentGrowth['label.payAmt']}" styleClass="ms7"/>
								</td>
								<td align="left" width="10%">
									<h:outputText value="#{semmel006Bean.elGroupSP.percentAmtNewDouble}" styleClass="ms7">
									<f:convertNumber pattern="#,##0.00" />
									</h:outputText>
								</td>
								<td align="right" width="10%">
									<h:outputText value="#{jspMsgPercentGrowth['label.unitPrice']}" styleClass="ms7" rendered="#{semmel006Bean.elGroupSP.typeFlag}"></h:outputText>
								</td>
								<td align="left" width="40%">
									<h:outputText value="#{semmel006Bean.elGroupSP.percentUnitNewDouble}" styleClass="ms7" rendered="#{semmel006Bean.elGroupSP.typeFlag}">
									<f:convertNumber pattern="#,##0.00" />
									</h:outputText>
								</td>
							</tr>
						</table>
					</rich:panel>	
					<rich:panel id="pnlPercentGrowth" 
						style="height:380px;width:800px;overflow:auto;padding-bottom:0px;padding-left:0px;padding-right:0px;padding-top:0px;">

							<!-- begin dataTable -->
							<rich:dataTable id="dtbPercentGrowth" width="95%"
								rows="10"
								var="PercentGrowth"
								value="#{semmel006Bean.elGroupSPList}"
								rowKeyVar="rowIndex"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform">
								<!-- begin column -->
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['column.header.percentGrowth.month']}" style="width: 20" />
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.month}" style="width: 20" /></div>
								</rich:column>
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.kwh']}" style="width: 35" />
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.kwh}" style="width: 35" /></div>
								</rich:column>

								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.cost']}" style="width: 80"  >
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText	value="#{PercentGrowth.cost}" style="width: 80" >						
										</h:outputText>
									</div> 
								</rich:column>

								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.rate']}" style="width: 30px" >
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.rate}" style="width: 30px"  />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.percentKwh']}" style="width: 90px" >
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.percentKwh}" style="width: 90px" />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.percentCost']}" style="width: 80px" >
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.percentCost}" style="width: 80px"  />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgPercentGrowth['label.percentGrowth.percentRate']}" style="width: 40px" >
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{PercentGrowth.percentRate}" style="width: 40px"  />
									</div>
								</rich:column>
								<!-- end column -->
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true"
										align="center" for="dtbPercentGrowth" maxPages="10"
										id="dstPercentGrowth" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
							<!-- end dataTable -->
					</rich:panel>
					<table width="95%">
								<tr>
									<td>
										<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
											<rich:componentControl for="popupPercentGrowth" operation="hide" event="onclick" />
										</a4j:commandButton>
									</td>
								</tr>
							
					</table>
			</h:panelGrid>
		</a4j:form>
</rich:modalPanel>
		
	