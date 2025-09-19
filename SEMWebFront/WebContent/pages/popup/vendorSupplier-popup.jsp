<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.popup.vendorSupplier" var="jspMsg2" />
<rich:modalPanel id="popupVendorSupplier" height="600" width="820" autosized="false">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg2['header.popup']} #{popupVendorSupplierBean.popupType}"></h:outputText>
		</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidePopupVendorSupplier" style="cursor:pointer" /> 
				<rich:componentControl for="popupVendorSupplier" attachTo="hidePopupVendorSupplier" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<div id="container" style="overflow:auto;width: 100%; height:550px;">
	<h:panelGrid>
		<a4j:form id="popupFrmError">
			<h:messages errorClass="ms7red" warnClass="ms7green"
				infoClass="ms7blue" globalOnly="true" />
		</a4j:form>
	</h:panelGrid>
	<h:form id="popupFrmSearch">
		<h:panelGrid width="800" id="grdPopupSearchCriteria">
			<rich:panel id="pnlPopupSearchCriteria">
				<f:facet name="header">
					<h:outputText value="#{jspMsg2['header.criteria.name']}" />
				</f:facet>
				<!-- begin content criteria -->
				<h:panelGrid width="87%" columns="5" border="0" cellpadding="0"
					cellspacing="1">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td align="right" width="20%"><h:outputText
									value="#{jspMsg2['label.vendorCode']}" styleClass="ms7" /></td>
								<td width="30%"><h:inputText id="txtvendorCode"
									value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorCodeCri}" size="30" maxlength="50" />
									
									<!-- >> fixed by.. NEW 2015/10/18 -->
				                	<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
								    	action="#{semmel006Action.initAddVendor}" reRender="mel006PopUp_addVendor"
								        oncomplete="#{rich:component('mel006PopUp_addVendor')}.show();">
									</a4j:commandButton>
				                	<!-- << -->
								</td>
								<td align="right" width="20%"><h:outputText
									value="#{jspMsg2['label.name']}" styleClass="ms7" /></td>
								<td width="30%"><h:inputText id="txtName"
									value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.nameCri}"  size="30" maxlength="255"  />
								</td>
							</tr>

							<tr>
								<td align="right" width="20%"><h:outputText
									value="#{jspMsg2['label.identityId']}" styleClass="ms7" /></td>
								<td width="30%"><h:inputText id="txtIdentityId"
									value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.identityIdCri}"  size="23" maxlength="20"  />
								</td>
								<td align="right" width="20%"><h:outputText
									value="#{jspMsg2['label.taxId']}" styleClass="ms7" /></td>
								<td width="30%"><h:inputText id="txtTaxId"
									value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.taxIdCri}"  size="23" maxlength="20" />
								</td>
							</tr>
							
							<tr>
								<td align="right" width="20%"><h:outputText
									value="#{jspMsg2['label.province']}" styleClass="ms7" /></td>
								<td width="30%">
									<h:selectOneMenu id="txtProvince" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.provinceCri}" >
										<f:selectItems value="#{popupVendorSupplierBean.provinceList}"/>
									</h:selectOneMenu>
								</td>
								<td/></td>
								<td width="30%">
								</td>
							</tr>

							<tr>
								<td width="20%"></td>
								<td colspan="3"></td>
							</tr>
							<tr>
								<td colspan="4"><!-- end content criteria -->
								 <h:panelGroup>
									<a4j:commandButton id="btnPopupSearch"
										value="#{jspMsg2['btn.search']}" styleClass="rich-button" action="#{navAction.navi}"
										reRender="dtbPopupContractNo,pnlPopupSearchResult,popupFrmError">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="PopupVendorSupplier" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
										<a4j:actionparam name="methodWithNavi" value="doSearchVendorSupplier" />
									</a4j:commandButton> 
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnClear"
										value="#{jspMsg2['btn.clear']}" styleClass="rich-button"
										action="#{navAction.navi}"
										reRender="dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError">
										<a4j:actionparam name="navModule" value="cp" />
										<a4j:actionparam name="navProgram" value="PopupVendorSupplier" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
										<a4j:actionparam name="methodWithNavi" value="doClearPopupVendorSupplier" />
									</a4j:commandButton>
								</h:panelGroup></td>
							</tr>

						</table>
					</h:panelGroup>
				</h:panelGrid>

			</rich:panel>
		</h:panelGrid>
	
		<rich:panel id="pnlPopupSearchResult">
			<f:facet name="header">
				<h:outputText value="#{jspMsg2['header.popup.resultTable.name']}  #{popupVendorSupplierBean.popupType} " />
			</f:facet>
			<rich:dataTable id="dtbVendorSupplier" width="90%"
				value="#{popupVendorSupplierBean.popupVendorSupplierSearchSPList}"
				rowKeyVar="RegInd" var="vendorSupplierSP"
				onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
				onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
				rowClasses="cur" rows="#{popupVendorSupplierBean.rowPerPage}"
				styleClass="contentform">

				<rich:column id="ContractNoSelect">
					<f:facet name="header">
						<h:outputText value="" style="width:50px" />
					</f:facet>
					
					<div align="center">
						<a4j:commandLink id="cmlSelect"
							value="Select" action="#{navAction.navi}"
							reRender="pnlShowApproveConstruct, pnlDisplayVendorCode, pnlDisplayVendorName, paymentELtmpInfo,txtVendorId,panelGridVendor,detailPaymentMethod,paymentELtmpInfo"
							oncomplete="#{rich:component('popupVendorSupplier')}.hide(); return false">
							
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="PopupVendorSupplier" />
							<a4j:actionparam name="moduleWithNavi" value="common" />
							<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
							<a4j:actionparam name="methodWithNavi" value="doSelectVendorSupplier" />
							<a4j:actionparam name="vendorMasterId" value="#{vendorSupplierSP.vendorMasterId}" />
							<a4j:actionparam name="vendorCode" value="#{vendorSupplierSP.vendorCode}" />
							<a4j:actionparam name="vendorFullName" value="#{vendorSupplierSP.vendorFullName}" />
							<a4j:actionparam name="contactName" value="#{vendorSupplierSP.contactName}" />
							<a4j:actionparam name="vendorName" value="#{vendorSupplierSP.vendorName}" />
							<a4j:actionparam name="identityId" value="#{vendorSupplierSP.identityId}" />
							<a4j:actionparam name="taxId" value="#{vendorSupplierSP.taxId}" />
							<a4j:actionparam name="fullAddress" value="#{vendorSupplierSP.fullAddresss}" />
							<a4j:actionparam name="address" value="#{vendorSupplierSP.addresss}" />
							<a4j:actionparam name="district" value="#{vendorSupplierSP.district}" />
							<a4j:actionparam name="amphur" value="#{vendorSupplierSP.amphur}" />
							<a4j:actionparam name="province" value="#{vendorSupplierSP.province}" />
							<a4j:actionparam name="postCode" value="#{vendorSupplierSP.postCode}" />
							<a4j:actionparam name="telephone" value="#{vendorSupplierSP.telephone}" />
							<a4j:actionparam name="mobileNo" value="#{vendorSupplierSP.mobileNo}" />
							<a4j:actionparam name="fax" value="#{vendorSupplierSP.fax}" />
							<a4j:actionparam name="popupTypeParam" value="#{popupVendorSupplierBean.popupType}"/>
							
							<a4j:actionparam name="address1" value="#{vendorSupplierSP.address1}"/>
							<a4j:actionparam name="address2" value="#{vendorSupplierSP.address2}"/>
							<a4j:actionparam name="city" value="#{vendorSupplierSP.city}"/>
						</a4j:commandLink>
					</div>
				</rich:column>

				<rich:column id="colVendorCode">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.header.vendorCode']}"
							styleClass="contentform" style="width:50px" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{vendorSupplierSP.vendorCode}" styleClass="contentform"
						style="width:50px" /></div>
				</rich:column>

				<rich:column id="colName">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.header.name']}"
							styleClass="contentform" style="width:120px" /> 
					</f:facet>
					<div align="left"><h:outputText
						value="#{vendorSupplierSP.vendorFullName}" styleClass="contentform"
						style="width:120px" /></div>
				</rich:column>
				<rich:column id="colIdentityId">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.header.identityId']}"
							styleClass="contentform" style="width:120px" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{vendorSupplierSP.identityId}" styleClass="contentform"
						style="width:120px" /></div>
				</rich:column>
				<rich:column id="colTaxId">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.header.taxId']}"
							styleClass="contentform" style="width:50px" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{vendorSupplierSP.taxId}" styleClass="contentform">
						<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
					</h:outputText></div>
				</rich:column>

				<rich:column id="colAddress">
					<f:facet name="header">
						<h:outputText value="#{jspMsg2['column.header.address']}"
							styleClass="contentform" style="width:230px" />
					</f:facet>
					<div align="left"><h:outputText
						value="#{vendorSupplierSP.fullAddresss}" styleClass="contentform" style="width:230px" />
						
					</div>
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:datascroller immediate="true" rendered="true" align="left" 
						for="dtbVendorSupplier" maxPages="10" id="dstPopupContractNo"
						selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
		</rich:panel>
		
	</h:form>
	</div>
</rich:modalPanel>


