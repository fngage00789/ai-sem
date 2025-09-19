<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<jsp:include page="../../pages/popup/multiZone-popup.jsp" />

<f:loadBundle basename="resources.insurance.semmir011" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir011Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchIR011">
				<h:panelGrid width="96%">
					<rich:panel id="panSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
		                  <tr>
		                  	<td align="right" width="20%" >
		                		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/></td>
		                    <td width="30%">
		                      <h:selectOneMenu id="ddlCompany" value="#{semmir011Bean.insurancePaySP.company}">
			                		<f:selectItems value="#{semmir011Bean.companyList}"/>
			                </h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/></td>
		                    <td>
		                      <h:selectOneMenu id="ddlNetworkType" value="#{semmir011Bean.insurancePaySP.networkType}">
			                		<f:selectItems value="#{semmir011Bean.networkTypeList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lbltfType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:selectOneMenu id="ddltfType" value="#{semmir011Bean.insurancePaySP.transferType}">
			                		<f:selectItems value="#{semmir011Bean.transferTypeList}"/>
			                	</h:selectOneMenu>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblPolicyType" value="#{jspMsg['label.policyType']}" styleClass="ms7"/></td>
		                    <td>
		                      <h:selectOneMenu id="ddlPolicyType" value="#{semmir011Bean.insurancePaySP.policyType}">
			                		<f:selectItems value="#{semmir011Bean.policyTypeList}"/>
			                </h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblPolicyNo" value="#{jspMsg['label.policyNo']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtPolicyNo" value="#{semmir011Bean.insurancePaySP.policyNo}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:inputText id="txtContractNo" value="#{semmir011Bean.insurancePaySP.contractNo}"/>
							</td>
							<td align="right">
		                		<h:outputText id="lblBatchNo" value="#{jspMsg['label.batchNo']}" styleClass="ms7"/></td>
		                    <td>
		                    	<h:inputText id="txtBatchNo" value="#{semmir011Bean.insurancePaySP.batchNo}"/>
							</td>
		                  </tr>
		                  <tr >
								<td align="right">										
				               		<h:outputText id="lblPaymentStatus" value="#{jspMsg['label.paymentStatus']} :" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:selectOneMenu id="ddlPaymentStatus" value="#{semmir011Bean.insurancePaySP.paymentStatus}">
			                			<f:selectItems value="#{semmir011Bean.paymentStatusList}"/>
			                		</h:selectOneMenu>
								</td>
								<td align="right">										
				               		<h:outputText id="lblInvoiceNo" value="#{jspMsg['label.invoiceNo']} :" styleClass="ms7"/>
				             	</td>
								<td align="left" >
									<h:inputText id="txtInvoiceNo" value="#{semmir011Bean.insurancePaySP.invoiceNo}"/>
								</td>
							</tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblDoc92" value="#{jspMsg['label.doc92']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:inputText id="txtDoc92" value="#{semmir011Bean.insurancePaySP.doc_92}"/>
		                    </td>
		                  </tr>
		                  <tr>
		                  	<td align="right">
		                		<h:outputText id="lblDateType" value="#{jspMsg['label.dateType']}" styleClass="ms7"/></td>
		                    <td>
		                      	<h:selectOneMenu id="ddlDateType" value="#{semmir011Bean.insurancePaySP.dateType}">
		                			<f:selectItems value="#{semmir011Bean.dateTypeList}"/>
		                		</h:selectOneMenu>
		                    </td>
		                    <td align="right">
		                		<h:outputText id="lblDate" value="#{jspMsg['label.date']}" styleClass="ms7"/></td>
		                    <td>
		                      	<rich:calendar id="cldDateFrom" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir011Bean.insurancePaySP.fromDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.date']}"
								disabled="false">
								</rich:calendar>
								<rich:spacer width="10" />
								<rich:calendar id="cldDateTo" locale="th" enableManualInput="true" 
	                			datePattern="dd/MM/yyyy" 
								value="#{semmir011Bean.insurancePaySP.toDt}"
	                			showWeeksBar="false" 
	                			inputSize="13"
	                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="20px" cellHeight="20px"
								label="#{jspMsg['label.date']}"
								disabled="false">
								</rich:calendar>
		                    </td>
		                  </tr>
		                                   
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                  <h:panelGrid columns="5" id="grdSearchCommand">
		                  	<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
									reRender="frmResult,panelError,frmSearchIR011" >
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR011-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR011" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
				            	<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="frmResult,panelError,frmError,panSearchCriteria,frmResult">
				            		<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR011-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR011" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
				            	</a4j:commandButton>
				            </h:panelGrid>
		            </rich:panel>
				</h:panelGrid>
			</a4j:form>
			<a4j:form id="frmResult">
				<h:panelGrid style="width: 90%">
				 	<rich:panel id="panSearchResult"  styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir011Bean.msgDataNotFound}" rendered="#{semmir011Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="95%" id="dtbPolicy" cellpadding="1" cellspacing="0" border="0"
							var="insurancePayValueSP" value="#{semmir011Bean.insurancePaySPList}" reRender="dstPolicy" 
							rows="#{semmir011Bean.rowPerPage}"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
									<div align="center">
										<h:outputText value="#{insurancePayValueSP.dataObj.networkTypeDesc}" styleClass="contentform"  />
									</div>
							</rich:column>
							<rich:column>    
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform"  style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{insurancePayValueSP.dataObj.company}" styleClass="contentform"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}" styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.transferTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyType']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.policyTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkPolicyNo" value="#{insurancePayValueSP.dataObj.policyNo}" 
									 reRender="oppContent" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR009-2" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR009" />
										<a4j:actionparam name="methodWithNavi" value="initPlocyInfo" />
										<a4j:actionparam name="policyNo" value="#{insurancePayValueSP.dataObj.policyNo}" />
										<a4j:actionparam name="navModuleFrom" value="ir" />
										<a4j:actionparam name="navProgramFrom" value="SEMMIR011-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR011" />	
										<a4j:actionparam name="isPageFrom" value="true" />	
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform" style = "width : 80px " />
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkVendorCode" value="#{insurancePayValueSP.dataObj.vendorCode}" action="#{navAction.navi}" reRender="oppContent"> 
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR011-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR011" />
										<a4j:actionparam name="methodWithNavi" value="initPlocyInfo" />
										<a4j:actionparam name="policyNo" value="#{insurancePayValueSP.dataObj.policyNo}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{insurancePayValueSP.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeCode']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.payeeCode}" styleClass="contentform"  />
								</div>
							</rich:column>			
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform" style = "width : 100px " />
								</f:facet>
								<div align="left">
									<h:outputText value="#{insurancePayValueSP.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amt']}" styleClass="contentform" style = "width : 90px "/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.excAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vat']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.vatAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.WHT']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.whtAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.duty']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.dutyAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform" style = "width : 90px "/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.totalPayAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invoiceNo']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.invoiceNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalSystem']}" styleClass="contentform" style = "width : 90px " />
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.totalAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diff']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="right">
									<h:outputText value="#{insurancePayValueSP.dataObj.diffAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.doc_68}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.doc_92}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentDt']}" styleClass="contentform" style = "width : 80px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.paymentDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.paymentTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentMethod']}" styleClass="contentform" style = "width : 150px "/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{insurancePayValueSP.dataObj.paymentMethodDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform" style = "width : 80px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.chqDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.chqReceiveDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.transferDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.updateBy}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insurancePayValueSP.dataObj.updateDt}" styleClass="contentform"  >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir011Bean.insurancePaySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="24">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPolicy"
											maxPages="#{semmir011Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmir011Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>				
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>
