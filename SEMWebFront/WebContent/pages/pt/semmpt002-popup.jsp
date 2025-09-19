<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt002" var="jspMsgPopup1"/>
	<rich:modalPanel id="popupViewPropertyTax" width="930" minWidth="480" height="480" autosized="true" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup1['header.popUpViewPropertyTax']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupViewPropertyTax" style="cursor:pointer"/>
					<rich:componentControl for="popupViewPropertyTax" attachTo="hidePopupViewPropertyTax" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupResult">
			<h:panelGrid  width="90%">
					<rich:panel id="pnlPopupSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsgPopup1['header.popUpViewPropertyTax']}" style="width:2220"/>
						</f:facet>
						 <rich:dataTable id="dtbMpt002SrchHist" cellpadding="1" cellspacing="0" border="0"
							var="mpt002SrchHistSP" value="#{semmpt002Bean.mpt002SrchHistList}" reRender="dstMpt002SrchHist" 
							rows="#{semmpt002Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<rich:column sortBy="#{mpt002SrchHistSP.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.contractNo']}" styleClass="contentform" style="width: 120"/>
								</f:facet>
								<div align="center">
									 <h:outputText value="#{mpt002SrchHistSP.contractNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.pTaxYear}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.pTaxYear']}" styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.pTaxYear}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.estimateBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.estimateBy']}" styleClass="ms7" style="width: 120"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt002SrchHistSP.estimateBy}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.estimateDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.estimateDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.estimateDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt002SrchHistSP.payGovtFlag}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.payGovtFlag']}"   styleClass="contentform" style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.payGovtFlag}"   styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.paymentStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.paymentStatus']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.paymentStatus}"   styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.periodNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.periodNo']}" styleClass="contentform"  style="width:12px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.periodNo}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.expenseType']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.expenseType}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.paymentType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.paymentType}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.excAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.excAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt002SrchHistSP.excAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.whtAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt002SrchHistSP.whtAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.vatAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt002SrchHistSP.vatAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.totalAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.totalAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt002SrchHistSP.totalAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.paymentBy}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.paymentBy']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.paymentBy}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.paymentDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.paymentDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.paymentDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.paymentDocNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.paymentDocNO']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.paymentDocNo}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.doc68}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.doc68']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.doc68}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt002SrchHistSP.doc92}">
								<f:facet name="header">
									<h:outputText value="#{jspMsgPopup1['column.doc92']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt002SrchHistSP.doc92}" styleClass="contentform"/>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt002SrchHist" 
									maxPages="10" id="dstMpt002SrchHist" selectedStyleClass="selectScroll" 
									page="1"/>
							</f:facet>
						</rich:dataTable>
						<br/>
						<a4j:commandButton value="Close" styleClass="rich-button">
							<rich:componentControl for="popupViewPropertyTax" operation="hide" event="onclick" />
						</a4j:commandButton>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
	</rich:modalPanel>