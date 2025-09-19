<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semqsi004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header">
	<h:outputText value="#{jspMsg['header.name']}"/>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semqsi001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
<!-- begin content layout criteria -->
		<h:panelGrid width="96%">
			<a4j:form id="frmSearch">
			<rich:panel id="pnlSearchCriteria">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['header.criteria.name']}"/>
			</f:facet>
			<!-- begin content criteria -->
			<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table width="100%" border="0">
			                	  <tr>
									<td align="right" width="20%"  valign="bottom">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
										<rich:spacer width="2px" />
		                			</td>
		                			<td width="30%"  valign="bottom">
		                			 <h:selectOneMenu id="ddlCompany"  value="#{semqsi004Bean.querySiteInfoSearchSP.company}">
				                	 <f:selectItems value = "#{semqsi004Bean.companyList}"/>
				                	 </h:selectOneMenu>
				                	</td>
				                	<td  width="20%" align="right"  valign="bottom">
				                	<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
				                	<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
				                	<rich:spacer width="2px" />
		                			</td>
		                			<td width="30%"  >
		                			 <h:selectOneMenu id="ddlRegion" value = "#{semqsi004Bean.querySiteInfoSearchSP.region}" >
		                			 	<a4j:support event="onchange" action="#{semqsi004Action.regionChange}"  reRender="ddlZone,ddlProvince"> </a4j:support>
		                			 	<f:selectItems value = "#{semqsi004Bean.regionList}"/>	
		                			 </h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.docNo']} : " styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
									<h:inputText id="txtDocNo" value="#{semqsi004Bean.docNo}" size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:panelGroup>
										<h:outputText value="#{jspMsg['label.reqType']} :" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu id="ddlReqType" value="#{semqsi004Bean.querySiteInfoSearchSP.reqType}"> 
										<f:selectItems value="#{semqsi004Bean.reqTypeList}"/>
									</h:selectOneMenu>
									
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.title']} : " styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                			<h:inputText id="txtTitle" value="#{semqsi004Bean.querySiteInfoSearchSP.title}" size="30" maxlength="35"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationId" value="#{semqsi004Bean.querySiteInfoSearchSP.locationId}" size="18" maxlength="15"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationCode" value="#{semqsi004Bean.querySiteInfoSearchSP.locationCode}" size="13" maxlength="10"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 	<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.siteName']} : " styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtLocationName" value="#{semqsi004Bean.querySiteInfoSearchSP.siteName}" size="30" maxlength="255"/>
				                	</td>
				                	<td align="right" width="20%">
									
									<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu id="ddlSiteType" value="#{semqsi004Bean.querySiteInfoSearchSP.siteType}">
			                	  	<f:selectItems value="#{semqsi004Bean.siteTypeList}"/>
			                	  	</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteInfoStatus']} : " styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu id="ddlSiteInfoStatus" value="#{semqsi004Bean.querySiteInfoSearchSP.siteInfoStatus}"> 
										<f:selectItems value="#{semqsi004Bean.siteInfoStatusList}"/>
									</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:selectOneMenu id="ddlSiteStatus" value="#{semqsi004Bean.querySiteInfoSearchSP.siteStatus}">
			                	 <f:selectItems value="#{semqsi004Bean.siteStatusList}"/>
			                	 </h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%" valign="top">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputTextarea id="txtContractNo" value="#{semqsi004Bean.querySiteInfoSearchSP.contractNo}" 
		                			rows="2" onblur="setFormatContractNo(this)"/>
				                	</td>
				                	<td align="right" width="20%">
		                			</td>
		                			<td width="30%" align="left">
		                			<h:selectBooleanCheckbox id="chkPendingStatus" value="#{semqsi004Bean.querySiteInfoSearchSP.pendingBoolean}" 
		                				styleClass="ms7"/>
				                		<h:outputText value="#{jspMsg['label.pending']}" styleClass="ms7" />
				                		<rich:spacer width="5"></rich:spacer>
				                		<h:selectBooleanCheckbox id="chkExpireStatus" value="#{semqsi004Bean.querySiteInfoSearchSP.expireBoolean}" 
		                				styleClass="ms7"/>
				                		<h:outputText value="#{jspMsg['label.expire']}" styleClass="ms7" />
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 <td align="right" valign="bottom">
			                	 <h:outputText value="#{jspMsg['label.startDate']} : " styleClass="ms7"/>
			                	 <rich:spacer width="2px" />
			                	 </td>
			                	 <td valign="bottom">
				                	 <rich:calendar id="cldEffDtFrom" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semqsi004Bean.querySiteInfoSearchSP.fromEffectDt}"
										   showWeeksBar="false" 
										   inputSize="13" 
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   cellWidth="20px" cellHeight="20px"
										   label="#{jspMsg['label.startDate']}"
										   >
									  </rich:calendar>
				                	 <rich:spacer width="20"/>
				                	 <h:outputText value="#{jspMsg['label.to']} : " styleClass="ms7"/>
				                	 <rich:calendar id="cldEffDtTo" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semqsi004Bean.querySiteInfoSearchSP.toEffectDt}"
										   showWeeksBar="false" 
										   inputSize="13" 
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   cellWidth="20px" cellHeight="20px"
										   label="#{jspMsg['label.startDate']}"
										   >
									  </rich:calendar>
			                	 
			                	 </td>
			                	 <td align="right" valign="bottom">
			                	 <h:outputText value="#{jspMsg['label.endDate']} : " styleClass="ms7"></h:outputText>
			                	 <rich:spacer width="2px" />
			                	 </td>
			                	 <td valign="bottom">
				                	 <rich:calendar id="cldExpDtFrom" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semqsi004Bean.querySiteInfoSearchSP.fromExpireDt}"
										   showWeeksBar="false" 
										   inputSize="13" 
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   cellWidth="20px" cellHeight="20px"
										   label="#{jspMsg['label.endDate']}"
										   >
									  </rich:calendar>
				                	 <rich:spacer width="20"/>
				                	 <h:outputText value="#{jspMsg['label.to']} : " styleClass="ms7"/>
			                		 <rich:calendar id="cldExpDtTo" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semqsi004Bean.querySiteInfoSearchSP.toExpireDt}"
										   showWeeksBar="false" 
										   inputSize="13" 
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   cellWidth="20px" cellHeight="20px"
										   label="#{jspMsg['label.endDate']}"
										   >
									  </rich:calendar>
			                	 </td> 
			                	 </tr>
			                	 
			                	 	 <tr>
								<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.lessorName2']} : " styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                			<h:inputText id="txtLessorName" value="#{semqsi004Bean.querySiteInfoSearchSP.lessorName}" size="30" maxlength="100"/>
			                	</td>
			                	<td width="20%"></td>
			                	<td width="30%">
			                	<h:selectBooleanCheckbox id="chkNoExpDate" value="#{semqsi004Bean.querySiteInfoSearchSP.noExpireBoolean}"/>
			                	 <rich:spacer width="3px"/>
			                	 <h:outputText value="#{jspMsg['label.noEndDate']}" styleClass="ms7"/>
			                	</td>
		                	 </tr>
			                 
			                 <tr>
								<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.address']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtLocation" value="#{semqsi004Bean.querySiteInfoSearchSP.address}" size="30" maxlength="100"/>
			                	</td>
			                	<td align="right" width="20%">
			                		<h:outputText value="#{jspMsg['label.siteTambon']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtSiteTambon" value="#{semqsi004Bean.querySiteInfoSearchSP.tambolLocation}" size="30" maxlength="100"/>
			                	</td>
	                	 	</tr>
		                	 
		                	<tr>
								<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteAmphur']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:selectOneMenu id="ddlAmphur" value="#{semqsi004Bean.querySiteInfoSearchSP.amphur}"> 
										<f:selectItems value="#{semqsi004Bean.amphurList}"/>
									</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
			                		<h:outputText value="#{jspMsg['label.siteProvince']} :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:selectOneMenu id="ddlProvince" value="#{semqsi004Bean.querySiteInfoSearchSP.province}" onchange="GetSiteAmphurListJS()"> 
										<f:selectItems value="#{semqsi004Bean.provinceList}"/>
									</h:selectOneMenu>
									
									 <a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlAmphur" 
									 action="#{semqsi004Action.getSiteAmphurList}"/>
			                	</td>
	                	 	</tr>
		                	 
	                	    <tr>
							<td align="right" width="20%">
                			</td>
                			<td width="30%">
		                		<h:selectBooleanCheckbox id="chkCurrentFlag" value="#{semqsi004Bean.chkCurrentFlag}" 
                				styleClass="ms7"/>
		                		<h:outputText value="#{jspMsg['label.currentFlagN']}" styleClass="ms7" />
		                	</td>
	                	 	</tr>
	                	 </table>
				</h:panelGroup>
			</h:panelGrid>
			<h:panelGrid columns="2" id="grdSearchCommand">
			<a4j:commandButton id="schBtn" value="#{jspMsg['btn.search']}" 
			styleClass="rich-button" action="#{navAction.navi}" reRender="FrmError,pnlSearchCriteria,pnlSearchResult">
			<a4j:actionparam name="navModule" value="si"/>
			<a4j:actionparam name="navProgram" value="SEMQSI004-1"/>
			<a4j:actionparam name="moduleWithNavi" value="si"/>
			<a4j:actionparam name="actionWithNavi" value="SEMQSI004"/>
			<a4j:actionparam name="methodWithNavi" value="doSearch"/>
			</a4j:commandButton>
			
			<a4j:commandButton id="clrButton" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			action="#{navAction.navi}" reRender="FrmError,pnlSearchCriteria,pnlSearchResult">
			<a4j:actionparam name="navModule" value="si"/>
			<a4j:actionparam name="navProgram" value="SEMQSI004-1"/>
			<a4j:actionparam name="moduleWithNavi" value="si"/>
			<a4j:actionparam name="actionWithNavi" value="SEMQSI004"/>
			<a4j:actionparam name="methodWithNavi" value="doClear"/>
			</a4j:commandButton>
			
			</h:panelGrid>
			</rich:panel>
			</a4j:form>
		</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="90%">
		<a4j:form id="FrmSearchResult">
			<h:panelGrid columns="1" id="grdSearchCommand">
				<h:commandButton id="btnExport" action="#{semqsi004Action.doExport}"
							styleClass="rich-button" value="#{jspMsg['btn.export']}" 
							 style="width: 120px"
							 rendered="#{semqsi004Bean.rendererSSO['scrSMMSI001']}">
							<a4j:support event="onclick"  reRender="FrmSearchResult"/>  	
					</h:commandButton>
			</h:panelGrid>
		
		<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
		<rich:spacer height="10"></rich:spacer>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.searchResult']}" style="width:2790px"/>
		</f:facet>
		
		<rich:dataTable width="95%" id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
			var="querySiteInfoSearch" value="#{semqsi004Bean.querySiteInfoSearchSPList}" reRender="dstPolicy" 
			rows="#{semqsi004Bean.rowPerPage}"
			onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
			onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
			styleClass="contentform">
			
			<rich:column sortBy="#{querySiteInfoSearch.company}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['label.company']}" styleClass="contentform" style="width:50px"/>
				</f:facet>
				<div align="center"> 
					<h:outputText value= "#{querySiteInfoSearch.company}" styleClass="contentform"></h:outputText>
				</div>
			</rich:column>
			<rich:column sortBy="#{querySiteInfoSearch.region}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['label.region']}" styleClass="contentform" style="width:50px" />
				</f:facet>
				<div align="center">
					<h:outputText value="#{querySiteInfoSearch.region}"/>
				</div>
			</rich:column>					
			<rich:column sortBy="#{querySiteInfoSearch.zone}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['label.zone']}" styleClass="contentform" style="width : 120px"/>
				</f:facet>
				<div align="center">
					<h:outputText value="#{querySiteInfoSearch.zone}"/>
				</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.contractNo}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="contentform" style="width : 80px" />
			</f:facet>
			<div align="center">
			
			<a4j:commandLink id="hypView" value="#{querySiteInfoSearch.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMQSI004-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{querySiteInfoSearch.siteInfoId}" />
										
									</a4j:commandLink>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.oldContractNo}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.oldnewContract']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.oldContractNo}"/>
			</div>
			</rich:column>
			<rich:column sortBy="#{querySiteInfoSearch.siteName}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.siteName']}" styleClass="contentform" style="width : 80px" />
			</f:facet>
			<div align="left">
			<h:outputText value="#{querySiteInfoSearch.siteName}"/>
			</div>
			</rich:column>
			<rich:column sortBy="#{querySiteInfoSearch.locationId}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.locationId']}" styleClass="contentform" style="width : 60px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.locationId}"/>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.locationCode}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="contentform" style="width : 60px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.locationCode}"/>
			</div>
			</rich:column>	
			
			<rich:column sortBy="#{querySiteInfoSearch.siteTypeName}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.siteType']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.siteTypeName}"/>
			</div>
			</rich:column>		
			<rich:column sortBy="#{querySiteInfoSearch.address}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.address']}" styleClass="contentform" style="width : 300px" />
			</f:facet>
			<div align="left">
			<h:outputText value="#{querySiteInfoSearch.address}"/>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.effectDate}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.startDate']}" styleClass="contentform" style="width : 80px"/>
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.effectDate}">
			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
			</h:outputText>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.expireDate}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.endDate']}" styleClass="contentform" style="width : 80px"/>
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.expireDate}">
			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
			</h:outputText>
			</div>
			</rich:column>
			<rich:column sortBy="#{querySiteInfoSearch.ownerName}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.ownerName']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.ownerName}"/>
			</div>
			</rich:column>
			<rich:column sortBy="#{querySiteInfoSearch.lessorName}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.contractMakerName']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.lessorName}"/>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.rentAmt}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.loanperyear']}" styleClass="contentform" style="width : 70px"/>
			</f:facet>
			<div align="right">
			<h:outputText value="#{querySiteInfoSearch.rentAmt}">
			<f:convertNumber pattern="#,##0.00"/>
			</h:outputText>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.serviceAmt}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.serviceperyear']}" styleClass="contentform" style="width : 70px" />
			</f:facet>
			<div align="right">
			<h:outputText value="#{querySiteInfoSearch.serviceAmt}">
			<f:convertNumber pattern="#,##0.00"/>
			</h:outputText>
			</div>
			</rich:column>
			
			<rich:column width="100" sortBy="#{querySiteInfoSearch.serviceAmt}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.averagerentperyear']}" styleClass="contentform" style="width : 70px" />
			</f:facet>
			<div align="right">
			<h:outputText value="">
			<rich:spacer width="120"></rich:spacer>
			<f:convertNumber pattern="#,##0.00"/>
			</h:outputText>
			</div>
			</rich:column>
			
			<rich:column width="100" sortBy="#{querySiteInfoSearch.serviceAmt}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.averageserviceperyear']}" styleClass="contentform" style="width : 70px" />
			</f:facet>
			<div align="right">
			<h:outputText value="">
			<rich:spacer width="120"></rich:spacer>
			<f:convertNumber pattern="#,##0.00"/>
			</h:outputText>
			</div>
			</rich:column>
				
			<rich:column sortBy="#{querySiteInfoSearch.electrictType}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.fireType']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.electrictType}"/>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.electrictOwner}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.privateFire']}" styleClass="contentform" style="width : 80px" />
			</f:facet>
			<div align="right">
			<h:outputText value="#{querySiteInfoSearch.electrictOwner}">
			<f:convertNumber pattern="#,##0.00"/>
			</h:outputText>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.siteStatusName}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.siteStatusName}"/>
			</div>
			</rich:column>	
			<rich:column sortBy="#{querySiteInfoSearch.networkStatus}" styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
			<f:facet name="header">
			<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="contentform" style="width : 100px" />
			</f:facet>
			<div align="center">
			<h:outputText value="#{querySiteInfoSearch.networkStatus}"/>
			</div>
			</rich:column>
			<rich:column styleClass="#{(semqsi004Bean.tmpRowId == querySiteInfoSearch.rowID)? 'onclick' : 'unclick'}" title="#{querySiteInfoSearch.contractNo} #{querySiteInfoSearch.siteName}">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform" style="width : 100px" />
				</f:facet>
				<div align="center">
					<a4j:commandButton id="btnUploadPicture"
						action="#{navAction.navi}"
						reRender="oppContent,popupUploadPictureCriteria"
						value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
						oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
						<a4j:actionparam name="navModule" value="common" />
						<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
						<a4j:actionparam name="moduleWithNavi" value="common" />
						<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
						<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
						<a4j:actionparam name="refId" value="" />
						<a4j:actionparam name="module" value=""/>
						<a4j:actionparam name="contractNo" value="#{querySiteInfoSearch.contractNo}"/>
						<a4j:actionparam name="viewMode" value="Y"/>
					</a4j:commandButton>
				</div>
			</rich:column>
			<f:facet name="footer">
				<rich:columnGroup>
					<rich:column colspan="4">
						<h:outputFormat value="#{msg['message.totalRecords']}">
							<f:param value="#{fn:length(semqsi004Bean.querySiteInfoSearchSPList)}"></f:param>
						</h:outputFormat>
					</rich:column>
					<rich:column colspan="24">
						<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
							maxPages="#{semqsi004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
							stepControls="hide" fastControls="auto" boundaryControls="auto" 
							id="dstBGMaster" 
							style="background-color: #cccccc;"
							page="#{semqsi004Bean.scrollerPage}" 
						/>
					</rich:column>
				</rich:columnGroup>
			</f:facet>
		</rich:dataTable>
	</rich:panel>
	<h:panelGrid id="show_report" style="height:50px;width:50px;" width="0" columns="0">
					<h:panelGroup id="show_report_in" rendered="#{semqsi004Bean.displayShowExcel}" style="height:50px;width:50px;" >							
						<script type="text/javascript">
							
						</script>
					</h:panelGroup>							
				</h:panelGrid>
	</a4j:form>
</h:panelGrid>
</rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>