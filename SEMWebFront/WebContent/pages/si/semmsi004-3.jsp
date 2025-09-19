<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<!-- 
<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
 -->
	<h:panelGrid columnClasses="gridContent" width="95%">
		           <rich:panel id="pnlContract">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.contract']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNo" value="#{semmsi004Bean.siteContract.contractNo}"  
		                			size="23" maxlength="20" style="FONT-SIZE: large;"/>
				                	</td>
				                	<td align="left" colspan="2">
									<h:selectBooleanCheckbox id="chkDummyContract" value="#{semmsi004Bean.chkDummyFlag}" styleClass="ms7"/>
				                		<h:outputText value="#{jspMsg['label.dummyContract']}" styleClass="ms7" />
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['labe.firstEffDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldFirstEffDate" locale="th" enableManualInput="true" 
		                			datePattern="dd/MM/yyyy" 
		                			value="#{semmsi004Bean.siteContract.firstEffectiveDt}" 
		                			showWeeksBar="false" 
		                			inputSize="13"
		                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									oninputblur="return dateformat.submitFomatDate(this);" 
									cellWidth="20px" cellHeight="20px"/>
				                	</td>
				                	<td align="left" colspan="2">
									<h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmsi004Bean.chkNoExpireFlag}" styleClass="ms7"/>
				                		<h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
		                			</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldEffDate" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004Bean.siteContract.effectiveDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									oninputblur="return dateformat.submitFomatDate(this);" 
									cellWidth="20px" cellHeight="20px"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<rich:calendar id="cldExpDate" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004Bean.siteContract.expireDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									oninputblur="return dateformat.submitFomatDate(this);" 
									cellWidth="20px" cellHeight="20px"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.ageContract']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                				<table width="60%">
		                				 <tr>
		                				 	<td width="20%">
		                				 	<h:inputText id="txtAgeYear" value="#{semmsi004Bean.siteContract.ageYear}" size="10"/>
		                				 	<rich:spacer width="5"></rich:spacer>
		                					 <h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
		                				 	</td>
		                				 	<td width="20%">
		                				 	<h:inputText id="txtAgeMonth" value="#{semmsi004Bean.siteContract.ageMonth}" size="10"/>
		                				 	<rich:spacer width="5"></rich:spacer>
		                			 		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
		                				 	</td>
		                				 	<td width="20%">
		                				 	 <h:inputText id="txtAgeDay" value="#{semmsi004Bean.siteContract.ageDay}" size="10"/>
		                				 	 <rich:spacer width="5"></rich:spacer>
		                					 <h:outputText value="#{jspMsg['label.day']}" styleClass="ms7"/>
		                				 	</td>
		                				 </tr>
		                				</table>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.promiseRenewTime']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                				<table width="60%">
		                				 <tr>
		                				 	<td width="20%">
		                				 	 <h:inputText id="txtPromiseRenewTime" value="#{semmsi004Bean.siteContract.promiseRenewTime}" size="10"/>
		                				 	 <rich:spacer width="5"></rich:spacer>
		                					 <h:outputText value="#{jspMsg['label.time']}" styleClass="ms7"/>
		                				 	</td>
		                				 	<td colspan="2">
		                				 	<h:outputText value="#{jspMsg['label.promiseRenewPeriod']}" styleClass="ms7"/>
		                				 	<rich:spacer width="10"></rich:spacer>
		                					<h:inputText id="txtPromiseRenewPeriod" value="#{semmsi004Bean.siteContract.promiseRenewPeriod}" size="10"/>
		                					<rich:spacer width="2"></rich:spacer>
		                					<h:selectOneMenu id="ddlPromiseRenewUnitType" value="#{semmsi004Bean.siteContract.promiseRenewPeriodType}"> 
											<f:selectItems value="#{semmsi004Bean.periodTypeList}"/>
											</h:selectOneMenu>
		                				 	</td>
		                				 </tr>
		                				</table>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtRemark" value="#{semmsi004Bean.siteContract.remark}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.contractDocType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlContractDocType" value="#{semmsi004Bean.siteContract.contractDocType}"> 
									<f:selectItems value="#{semmsi004Bean.contractDocTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.ownerGroup']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlOwnerGroup" value="#{semmsi004Bean.siteContract.ownerGroup}"> 
									<f:selectItems value="#{semmsi004Bean.ownerGroupList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.owner']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.ownerName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtOwnerName" value="#{semmsi004Bean.siteContract.ownerName}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4">
									<a4j:commandButton id="btnCopyFromOwnerName" value="#{jspMsg['btn.copyFromOwnerName']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="txtContractLessorName" style="width:120">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-3" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
									<a4j:actionparam name="methodWithNavi" value="doCopyOwnerName" />
					           		</a4j:commandButton>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.lessorName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtContractLessorName" value="#{semmsi004Bean.siteContract.lessorName}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4" >
									<a4j:commandButton id="btnCopyFromSiteInfo" value="#{jspMsg['btn.copyFromSiteInfo']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="oppContent" style="width:120">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-3" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
									<a4j:actionparam name="methodWithNavi" value="doCopySiteInfoAddressToContractLessorAddress" />
					           		</a4j:commandButton>
		                			</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.addressNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtContractLessorHouserNo" value="#{semmsi004Bean.siteContract.lessorHouseNo}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractLessorStreet" value="#{semmsi004Bean.siteContract.lessorStreet}"
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteTambon']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractLessorTambon" value="#{semmsi004Bean.siteContract.lessorTambon}"
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlContractLessorAmphurId" value="#{semmsi004Bean.siteContract.lessorAmphurId}">
									<f:selectItems value="#{semmsi004Bean.contractLessorAmphurList}"/>
							 		</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteProvince']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlContractLessorProvinceId" value="#{semmsi004Bean.siteContract.lessorProvinceId}" onchange="GetContractLessorAmphurListJS();">
									<f:selectItems value="#{semmsi004Bean.provinceList}"/>
							 		</h:selectOneMenu>
							 		<a4j:jsFunction name="GetContractLessorAmphurListJS" reRender="ddlContractLessorAmphurId" action="#{semmsi004Action.getContractLessorAmphurList}"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.telephone']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtContractLessorTel" value="#{semmsi004Bean.siteContract.lessorTel}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractLessorFax" value="#{semmsi004Bean.siteContract.lessorFax}"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="left" colspan="4" >
									<a4j:commandButton id="btnCopyLessorName" value="#{jspMsg['btn.copyLessorName']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="oppContent" style="width:160">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-3" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
									<a4j:actionparam name="methodWithNavi" value="doUpdateContractLessor" />
					           		</a4j:commandButton>
					           		<rich:spacer width="10"></rich:spacer>
					           		<a4j:commandButton id="btnAddLessorName" value="#{jspMsg['btn.addLessorName']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="popupAddLessor,frmPopupAddLessor,frmAddSiteInfo" style="width:100"
					           		 oncomplete="#{rich:component('popupAddLessor')}.show(); return false">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-4" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
									<a4j:actionparam name="methodWithNavi" value="initAddLessorName" />
					           		</a4j:commandButton>
		                			</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<rich:spacer height="10"></rich:spacer>
							<rich:panel id="pnlLessorName">
							<f:facet name="header" >
								<h:outputText value="#{jspMsg['header.panel.lessorName']}" />
							</f:facet>
							<rich:dataTable width="90%" id="dtbLessor" cellpadding="1" cellspacing="0" border="0"
							var="siteLessorSP" value="#{semmsi004Bean.lessorSPList}" reRender="dtbLessor" 
							rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbLessor">
								<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" reRender="oppContent"
	            					image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004-3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateContractLessor" />
										<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelLessorDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004-3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContractLessor" />
										<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteLessorSP.lessorName}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.lessorName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteLessorSP.lessorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLessorSP.address}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.address']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteLessorSP.address}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{siteLessorSP.tel}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.telephone']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{siteLessorSP.tel}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteLessorSP.fax}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.fax']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteLessorSP.fax}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbLessor" 
									maxPages="#{semmsi004Bean.maxPage}" id="dstLessor" selectedStyleClass="selectScroll" 
									page="#{semmsi004Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
						</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
					<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.contract']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	<tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.contractName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtContractName" value="#{semmsi004Bean.siteContract.contactName}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	  <tr>
									<td align="left" colspan="4" style="text-decoration: underline">
									<h:outputText value="#{jspMsg['label.contactAddress']}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	   <tr>
									<td align="left" colspan="4" >
									<a4j:commandButton id="btnCopyContact" value="#{jspMsg['btn.copyContact']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="oppContent" style="width:170">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004-3" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
									<a4j:actionparam name="methodWithNavi" value="doCopyContactAddress" />
					           		</a4j:commandButton>
		                			</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.addressNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtContractHouserNo" value="#{semmsi004Bean.siteContract.contactHouseNo}" cols="50" rows="3"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractStreet" value="#{semmsi004Bean.siteContract.contactStreet}"
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteTambon']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractTambon" value="#{semmsi004Bean.siteContract.contactTambon}"
		                			size="30" maxlength="100"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlContractAmphurId" value="#{semmsi004Bean.siteContract.contactAmphurId}">
									<f:selectItems value="#{semmsi004Bean.contactAmphurList}"/>
							 		</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.siteProvince']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlContractProvinceId" value="#{semmsi004Bean.siteContract.contactProvinceId}" onchange="GetContactAmphurListJS();">
									<f:selectItems value="#{semmsi004Bean.provinceList}"/>
							 		</h:selectOneMenu>
							 		<a4j:jsFunction name="GetContactAmphurListJS" reRender="ddlContractAmphurId" action="#{semmsi004Action.getContactAmphurList}"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.sitePostcode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtContractPostcode" value="#{semmsi004Bean.siteContract.contactPostcode}" 
		                			size="8" maxlength="5"/>
				                	</td>
			                	 </tr>
			               
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					
		</h:panelGrid>
		
