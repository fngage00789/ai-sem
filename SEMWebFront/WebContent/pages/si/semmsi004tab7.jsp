<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid width="95%" id="pnlTab7">
					 <rich:panel id="pnlSubRent" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.rent']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab7Bean.renderedMsgFormTop}"/>
						</div>
						<h:panelGrid id="pnlSubRentCriteria" width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="35%" valign="top">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
		                			</td>
		                			<td width="65%" colspan="3">
			                			<h:inputText id="txtContractNoDisplay2Tab7" value="#{semmsi004tab2Bean.siteContract.contractNo}" 
			                			 size="16"  readonly="true" styleClass="ms28Blue"/>
				                	</td>
		                		 </tr>
			                	 <tr>
									<td align="right" width="15%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.subCompany']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                				<h:selectOneMenu id="ddlSubCompany" value="#{semmsi004tab7Bean.subRent.subCompany}"
		                				disabled="#{semmsi004Bean.disabledModeView}">
										<f:selectItems value="#{semmsi004tab7Bean.companyList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="15%">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.subContractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:inputText id="txtSubContractNo" value="#{semmsi004tab7Bean.subRent.subContractNo}" 
		                			size="23" maxlength="20" disabled="#{semmsi004Bean.disabledModeView}" onblur="setFormatContractNo(this)"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="13%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
	                				<rich:calendar id="cldSubEffDate" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004tab7Bean.subRent.effectiveDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.effDate']}"
									disabled="#{semmsi004Bean.disabledModeView}">
									</rich:calendar>
				                	</td>
				                	<td align="right" width="18%">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="34%">
		                			<rich:calendar id="cldSubExpDate" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004tab7Bean.subRent.expireDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.expDate']}"
									disabled="#{semmsi004Bean.disabledModeView}">
									</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="13%">
									<h:outputText value="#{jspMsg['label.rentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="35%">
		                			<h:selectOneRadio id="rbtRentType" value="#{semmsi004tab7Bean.subRent.rentType}"  
		                			styleClass="ms7" rendered="true" disabled="#{semmsi004Bean.disabledModeView}">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.rentType01']} " />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.rentType02']}"/>
	                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.rentType03']} " />
	                			   </h:selectOneRadio>
				                	</td>
				                	<td align="right" width="18%">
									<h:outputText value="#{jspMsg['label.rent']}" styleClass="ms7"/>
		                			</td>
		                			<td width="34%">
		                			<h:inputText id="txtSubRentAmt" value="#{semmsi004tab7Bean.subRent.rentAmt}" size="15" 
              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
              						 onblur="return numberformat.moneyFormat(this);"
              						 onfocus="return numberformat.setCursorPosToEnd(this);"
              						 maxlength="16" 
              						 styleClass="inputRight"
              						 disabled="#{semmsi004Bean.disabledModeView}">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                		</h:inputText>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:outputText value="/" styleClass="ms7"/>
		                			<rich:spacer width="2"></rich:spacer>
	               					<h:selectOneMenu id="ddlSubRentAmtPeriodType" value="#{semmsi004tab7Bean.subRent.rentPeriodType}"
	               					disabled="#{semmsi004Bean.disabledModeView}"> 
									<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
		                	   <tr>
								<td align="right" width="13%" valign="top">
								<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
	                			</td>
	                			<td width="87%" colspan="3">
	                			<h:inputTextarea id="txtSubRentDetail" value="#{semmsi004tab7Bean.subRent.detail}" 
	                			cols="100" rows="3" disabled="#{semmsi004Bean.disabledModeView}"/>
			                	</td>
		                	 </tr>
		                	   <tr>
								<td align="left" colspan="4">
								<h:panelGrid columns="3" id="grdSearchSubRentCommand">
								<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
									<a4j:commandButton id="btnAddSubRent" value="#{jspMsg['btn.add']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="pnlSubRent,pnlResultSubRent,frmSiteInfoError" 
									disabled="#{semmsi004tab7Bean.disabledBtnAdd}">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
									<a4j:actionparam name="methodWithNavi" value="doAddSubRent" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnSaveSubRent" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="pnlSubRent,pnlResultSubRent,frmSiteInfoError" 
									disabled="#{semmsi004tab7Bean.disabledBtnSave}">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
									<a4j:actionparam name="methodWithNavi" value="doUpdateSubRent,frmSiteInfoError" />
									</a4j:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton id="btnClearSubRent" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="pnlSubRent,pnlResultSubRent">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
									<a4j:actionparam name="methodWithNavi" value="doClearSubRent" />
					           		</a4j:commandButton>
					           		</h:panelGroup>
									</h:panelGrid>
	                			</td>
		                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						</rich:panel>
					
				</h:panelGrid>
			
				<h:panelGrid  width="95%">
					<rich:panel  id="pnlResultSubRent" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.panel.subRent']}" style="width:1100"/>
						</f:facet>
						 <rich:dataTable  id="dtbSubRent" cellpadding="1" cellspacing="0" border="0"
							var="subRentSP" value="#{semmsi004tab7Bean.subRentSPList}" reRender="dtbSubRent" 
							rows="#{semmsi004tab7Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSubRent">
								<a4j:actionparam name="rowId" value="#{subRentSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlSubRent"
	            					image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateSubRent" />
										<a4j:actionparam name="rowId" value="#{subRentSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialogSubRent')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteSubRent" />
										<a4j:actionparam name="rowId" value="#{subRentSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.subCompany}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.subCompany']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.subCompany}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.subContractNo}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.subContractNo']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.subContractNo}" styleClass="contentform" ></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.effDate}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" styleClass="contentform" style="width:80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.effDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.expDate}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" styleClass="contentform" style="width:80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.expDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.rentTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.rentTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.rentAmt}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rent']}" styleClass="contentform" style="width:100"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{subRentSP.rentAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.rentPeriodTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentPeriodTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{subRentSP.rentPeriodTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{subRentSP.detail}" styleClass="#{(semmsi004Bean.tmpRowId==subRentSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.detail']}" styleClass="contentform" style="width:200"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{subRentSP.detail}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi004tab7Bean.subRentSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="12">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSubRent"
											maxPages="#{semmsi004tab7Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstSubRent" 
											style="background-color: #cccccc;"
											page="#{semmsi004tab7Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				</h:panelGrid>