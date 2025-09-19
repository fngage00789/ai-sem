<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg" />
<rich:modalPanel id="popupNotExpenseSite" width="900" autosized="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidepopupNotExpenseSite" style="cursor:pointer" /> <rich:componentControl
				for="popupNotExpenseSite" attachTo="hidepopupNotExpenseSite"
				operation="hide" event="onclick" /></div>
		</h:panelGroup>
	</f:facet>
	<h:panelGrid>
		<a4j:form id="popupFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green"
				infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	<h:form id="popupFrmSearch">
		<rich:panel id="pnlPopupSearchCriteria">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<h:panelGrid>
					<h:panelGroup>
						<!-- begin content criteria -->
						<table width="900" border="0">
							<tr>
								<td align="right" width="25%">
								 <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
						      </td>
						        <td align="leeft" width="27%"> 
						         <h:outputText value="#{semmel006Bean.payment.company}" styleClass="ms7"/>
						         </td>
						        <td  align="right" width="18%">
								<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
								</td>
								
							     <td align="leeft" width="30%">
							     <h:outputText value="#{semmel006Bean.payment.electricUseTypeTxt}" styleClass="ms7"/>
							     </td>
							</tr>
							<tr>
								<td align="right" >
								<h:graphicImage
									value="images/icon_required.gif" /><rich:spacer width="5" /> <h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invMeterId']}"
									styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmel006Bean.notExpenseSite.meterId}">
								</h:inputText></td>
								<td align="right" ><h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invAreaCode']}"
									styleClass="ms7" /></td>

								<td ><h:inputText
									value="#{semmel006Bean.notExpenseSite.invAreaCode}">
								</h:inputText> <rich:spacer width="5" /> <a4j:commandButton id="btndoCheck"
									styleClass="rich-button" action="#{navAction.navi}"
									value="#{jspMsg['btn.btnCheckSite']}"
									reRender="popupAddNotExpenseSite,popupFrmSearch,popupFrmError"
									disabled="#{semmel006Bean.addNewSiteDisable}"
									style="width:80px;">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram"
										value="SEMMEL006-POPUPNOTEXPENSE" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi"
										value="doCheckMeterExist" />
								</a4j:commandButton></td>
								

							</tr>

							<tr>
								<td align="right" ><h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invAreaName']}"
									styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmel006Bean.notExpenseSite.invAreaName}">
								</h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invSiteName']}"
									styleClass="ms7" /></td>

								<td><h:inputText
									value="#{semmel006Bean.notExpenseSite.invSiteName}"></h:inputText>

								</td>
								

							</tr>

							<tr>
								<td align="right">
									<h:graphicImage
									value="images/icon_required.gif" /><rich:spacer width="5" />
									<h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invNo']}"
									styleClass="ms7" /></td>
								<td align="left"><h:inputText
									value="#{semmel006Bean.notExpenseSite.invNo}"
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
									style="width:40px;" styleClass="inputRight">
								</h:inputText> 
								
								<h:outputText
									value="#{jspMsg['header.popup.invoiceNumber']}"
									styleClass="ms7" /> <h:inputText
									value="#{semmel006Bean.notExpenseSite.invDocNo}"
									style="width:60px;">
								</h:inputText></td>

								<td align="right"><h:graphicImage
									value="images/icon_required.gif" /><rich:spacer width="5" /> <h:outputText
									value="#{jspMsg['label.popup.notExpenseSite.invTermOfPaymentDt']}"
									styleClass="ms7" /></td>

								<td align="left"><h:outputText
									value="#{jspMsg['label.month']}" styleClass="ms7" /><rich:spacer width="3" /> 
									<h:selectOneMenu
									value="#{semmel006Bean.notExpenseSite.termOfPaymentDtMonth}"
									style="width:80px;">
									<f:selectItems value="#{semmel006Bean.monthList}" 
									/>
								</h:selectOneMenu><rich:spacer width="3" /> 
								<h:outputText
									value="#{jspMsg['label.year']}" styleClass="ms7" /><rich:spacer
									width="3" /> <h:selectOneMenu
									value="#{semmel006Bean.notExpenseSite.termOfPaymentDtYear}"
									style="width:80px;">
									<f:selectItems value="#{semmel006Bean.yearList}" />
								</h:selectOneMenu></td>
								

							</tr>
							<tr>
								<td align="right"><h:graphicImage
									value="images/icon_required.gif" /> <rich:spacer width="5" />
								<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7" />
								</td>
								<td><h:inputText id="txtPayAmt"
									value="#{semmel006Bean.notExpenseSite.payAmt}"
									disabled="#{semmel006Bean.viewMode}"
									onchange="doRecalCulateVATELTempPage62Popup();"
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
									onblur="return numberformat.moneyFormat(this);"
									onfocus="return numberformat.setCursorPosToEnd(this);"
									size="18" maxlength="18" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
										maxFractionDigits="2" />
								</h:inputText> <rich:spacer width="5" /> <h:outputText
									value="#{jspMsg['label.baht']}" styleClass="ms7" /> <a4j:jsFunction
									name="doRecalCulateVATELTempPage62Popup" reRender="popupFrmSearch"
									action="#{semmel006Action.doRecalCulateVATELTempPage62Popup}" /></td>
                                
								<td align="right"><h:graphicImage
									value="images/icon_required.gif" /> <rich:spacer width="5" />
								<h:outputText value="#{jspMsg['label.vatType']}"
									styleClass="ms7" /></td>
								<td>
											<h:selectOneRadio value="#{semmel006Bean.notExpenseSite.vatType}" disabled="#{semmel006Bean.viewMode}"
												 styleClass="ms7" rendered="true"
												 onclick="doChangeVATTypeELTempPage62Popup();"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}"  />		
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />			                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>		
					                	<a4j:jsFunction name="doChangeVATTypeELTempPage62Popup" reRender="popupFrmSearch" action="#{semmel006Action.doChangeVATTypeELTempPage62Popup}"/>
							   </td>
								
							</tr>
                            
							<tr>
								<td align="right"><h:graphicImage
									value="images/icon_required.gif" /><rich:spacer width="5" /> <h:outputText
									value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7" />
								</td>
								<td width="25%"><h:inputText id="txtInvTotalExcludeVat"
									value="#{semmel006Bean.notExpenseSite.invExcludeVatAmt}"
									disabled="#{semmel006Bean.disableMode}"
									onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
									onblur="return numberformat.moneyFormat(this);"
									onfocus="return numberformat.setCursorPosToEnd(this);"
									size="18" maxlength="18" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
										maxFractionDigits="2" />
								</h:inputText> <rich:spacer width="5" /> <h:outputText
									value="#{jspMsg['label.baht']}" styleClass="ms7" /></td>

								<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td >
											<h:inputText id="txtInvTotalVat" value="#{semmel006Bean.notExpenseSite.invVatAmt}" disabled="#{semmel006Bean.viewMode || semmel006Bean.disableInvTotalVat}"
 											onchange="doChangeVatAmtPage62Popup();" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	 
											<a4j:jsFunction name="doChangeVatAmtPage62Popup" reRender="popupFrmError,popupFrmSearch" action="#{semmel006Action.doChangeVatAmtPage62Popup}"/>  
                                        	
                                        							
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
								
							</tr>
                            <tr>
								<td align="right">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td>
  	
                                           <h:inputText id="txtInvTotalIncludeVat" value="#{semmel006Bean.notExpenseSite.invIncludeVatAmt}" 
  												disabled="#{semmel006Bean.disableMode}"
  												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="18" 
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	                                        	
                                        											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
 											
										</td>

								<td align="right">
									   </td>
										<td >
											
										</td>
								
							</tr>
                            <tr>
								<td colspan="6"><a4j:commandButton id="btndoAdd"
									styleClass="rich-button" action="#{navAction.navi}" value="Add"
									oncomplete="#{!semmel006Bean.displayPopupNotExpenseSite?'hidePopupNotExpenseSite();' : ''}"
									reRender="companyDetail, paymentDetail,pnlNoPaymentSite,btnExport,popupFrmError,btnAddNewSite"
									disabled="#{semmel006Bean.addNewSiteDisable}">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram"
										value="SEMMEL006-POPUPNOTEXPENSE" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi"
										value="doAddNotExpenseSite" />
								</a4j:commandButton><rich:spacer width="5" /> <a4j:commandButton id="btnClear"
									value="Clear" styleClass="rich-button"
									action="#{navAction.navi}"
									reRender="popupAddNotExpenseSite,popupFrmSearch,popupFrmError"
									disabled="#{semmel006Bean.addNewSiteDisable}">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram"
										value="SEMMEL006-POPUPNOTEXPENSE" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
									<a4j:actionparam name="methodWithNavi"
										value="doClearNotExpenseSite" />
								</a4j:commandButton><rich:spacer width="5" /> 
								<a4j:commandButton id="btnPopupCancel"
									value="Close" styleClass="rich-button" /> <rich:componentControl
									for="popupNotExpenseSite" attachTo="btnPopupCancel"
									operation="hide" event="onclick" /> <a4j:jsFunction
									name="hidePopupNotExpenseSite"
									oncomplete="#{rich:component('popupNotExpenseSite')}.hide(); return false" />


								</td>

							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</table>

			
		</rich:panel>
	</h:form>
</rich:modalPanel>
