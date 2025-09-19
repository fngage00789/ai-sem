<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac002" var="jspMsg"/>
	<%--rich:modalPanel id="popupApproveForm" width="600" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupApproveForm" style="cursor:pointer"/>
					<rich:componentControl for="popupApproveForm" attachTo="hidePopupApproveForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupSave">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmSave"> 
			<rich:panel id="pnlApproveForm">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupApprove']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                				<a4j:commandButton value="..."></a4j:commandButton>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="Vendor Name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
					                	
		                			</td>
		                			<td width="30%">
		                				<h:inputText /><a4j:commandButton value="..."></a4j:commandButton>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="Payee Name :
										" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText />
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td colspan="3" align="right" width="75%">
				                		<h:outputText value="#{jspMsg['label.popupAmount']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText></h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
				                		
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
		                			<td align="right" width="20%">
				                		<h:outputText value="Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
		                			<td align="right" width="20%">
				                		<h:outputText value="WHT :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
		                			<td align="right" width="20%">
				                		<h:outputText value="Total Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText></h:inputText>
		                			</td>
				                <tr >
				                	<td colspan = 4>
				                	<hr>
				                	</td>
				                </tr>
			                	<tr>
				                	<td align="right" width="20%">
											
		                			</td>
		                			<td width="30%">
		                			
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText></h:inputText>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
											
		                			</td>
		                			<td width="30%">
		                			
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText></h:inputText>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
											<h:outputText value="" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText></h:inputText>
				                	</td>
				                </tr>
			                	<tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupEdtSave" value="Save" styleClass="rich-button">
									 
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" reRender="frmError">
										<rich:componentControl for="popupApproveForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel--%>
	
	<rich:modalPanel id="popupInterfaceSAP" width="950" minWidth="700" height="500" minHeight="500">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupInterfaceSAP']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidepopupInterfaceSAP" style="cursor:pointer"/>
					<rich:componentControl for="popupInterfaceSAP" attachTo="hidepopupInterfaceSAP" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupInterfaceSAP">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAct">
			<h:panelGrid width="90%">
				<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
					<f:facet name="header" >
						<h:outputText value="SAP_TRX_HDR" style="width: 800"/>
					</f:facet>
					 <rich:dataTable width="100%" id="dtbSapTrxHdrs" cellpadding="1" cellspacing="0" border="0"
						var="sapTrxHdr" value="#{semmac002Bean.sapTrxLogSelected.sapTrxHdrs}" reRender="dstSapTrxHdrs" 
						rows="#{semmac002Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
						
						<f:facet name="header">
	                        <rich:columnGroup>		                            
	                            <rich:column >
	                            	<h:outputText value="HEARUN" />
	                            </rich:column>
	                            <rich:column >
	                            	<h:outputText value="REFSEM" />
	                            </rich:column>
	                            <rich:column label="COMCOD" >
	                            	<h:outputText value="COMCOD" />
	                            </rich:column>
	                            <rich:column label="DOCTYP" >
	                            	<h:outputText value="DOCTYP" />
	                            </rich:column>
	                            <rich:column label="REFDOC" >
	                            	<h:outputText value="REFDOC" />
	                            </rich:column>
	                            <rich:column label="DOCHEA">
	                            	<h:outputText value="DOCHEA" />
	                            </rich:column>
	                            <rich:column label="DOCDAT" >
	                            	<h:outputText value="DOCDAT" />
	                            </rich:column>
	                            <rich:column label="POSDAT" >
	                            	<h:outputText value="POSDAT" />
	                            </rich:column>	                            
	                            <rich:column label="BRACOD" >
	                            	<h:outputText value="BRACOD" />
	                            </rich:column>
	                            <rich:column label="CURCOD" >
	                            	<h:outputText value="CURCOD" />
	                            </rich:column>
	                            
	                            <rich:column breakBefore="true" width="20px" >
	                            	
	                            </rich:column>
	                            <rich:column label="LINITM" >
	                            	<h:outputText value="LINITM" />
	                            </rich:column>
	                            <rich:column label="AMTTYP" >
	                            	<h:outputText value="AMTTYP" />
	                            </rich:column>
	                            <rich:column label="ACCTYP" >
	                            	<h:outputText value="ACCTYP" />
	                            </rich:column>
	                            <rich:column label="ACCNUM" >
	                            	<h:outputText value="ACCNUM" />
	                            </rich:column>
	                            <rich:column label="SPEGLI" >
	                            	<h:outputText value="SPEGLI" />
	                            </rich:column>
	                            <rich:column label="AMTLOC" >
	                            	<h:outputText value="AMTLOC" />
	                            </rich:column>
	                            <rich:column label="AMTDOC" >
	                            	<h:outputText value="AMTDOC" />
	                            </rich:column>
	                            <rich:column label="COSCEN" >
	                            	<h:outputText value="COSCEN" />
	                            </rich:column>		                            
	                            <rich:column label="WBSELE" >
	                            	<h:outputText value="WBSELE" />
	                            </rich:column>
	                            <rich:column label="INTORD" >
	                            	<h:outputText value="INTORD" />
	                            </rich:column>
	                            
	                            <rich:column label="PURDOC" >
	                            	<h:outputText value="PURDOC" />
	                            </rich:column>
	                            <rich:column label="PURITE" >
	                            	<h:outputText value="PURITE" />
	                            </rich:column>
	                        </rich:columnGroup>
	                    </f:facet>
                   
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.id.hearun}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.refsem}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.comcod}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.doctyp}" styleClass="contentform" />								
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.refdoc}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.dochea}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.docdat}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.posdat}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.bracod}" styleClass="contentform" />
						</rich:column>
						<rich:column style="text-align: center" >
							<h:outputText value="#{sapTrxHdr.curcod}" styleClass="contentform" />
						</rich:column>


						<rich:subTable var="sapTrxDtl" value="#{sapTrxHdr.sapTrxDtls}" rendered="#{sapTrxHdr.sapTrxDtls != null}">
							<rich:column width="20px" style="text-align: center">
								
							</rich:column>
					      	<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.id.linitm}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.amttyp}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.acctyp}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.accnum}" styleClass="contentform" />								
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.spegli}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.amtloc}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.amtdoc}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.coscen}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.wbsele}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.intord}" styleClass="contentform" />
							</rich:column>
							
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.purdoc}" styleClass="contentform" />
							</rich:column>
							<rich:column style="text-align: center" >
								<h:outputText value="#{sapTrxDtl.purite}" styleClass="contentform" />
							</rich:column>
					    </rich:subTable>
					    
						<f:facet name="footer">
							<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSapTrxHdrs" 
								maxPages="10" id="dstSapTrxHdrs" selectedStyleClass="selectScroll" page="#{semmac002Bean.scrollerPage}"/>
						</f:facet>
					</rich:dataTable>
				</rich:panel>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>