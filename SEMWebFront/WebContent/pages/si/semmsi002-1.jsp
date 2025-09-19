<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi002" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi002Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="msi002_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmsi002Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
                              <a4j:actionparam name="navModule" value="si" />
                              <a4j:actionparam name="navProgram" value="SEMMSI002-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="si" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                      
                          </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
        </h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<h:panelGrid width="96%">
				
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
		                <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%" valign="baseline">
									<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										
									</td>
									<td width="30%" valign="bottom">
										<h:selectOneMenu id="ddlCompany" value="#{semmsi002Bean.legalApproveDisplaySP.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmsi002Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmsi002Bean.legalApproveDisplaySP.company}" styleClass="ms28"/>
									</td>
									<td align="right" width="20%" valign="baseline">
										<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
									</td>
									<td width="30%" valign="bottom">
										<h:selectOneMenu id="ddlRegion" value="#{semmsi002Bean.legalApproveDisplaySP.regionName}">
											<f:selectItems value="#{semmsi002Bean.regionList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtDocNo" value="#{semmsi002Bean.legalApproveDisplaySP.docNo}" size="20"/>
										
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldDocDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.docDateFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDocDateFrom','cldDocDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDocDateFrom','cldDocDateTo');"
											   label="#{jspMsg['column.header.docDtFrom']}">
											   
										</rich:calendar>
										<rich:spacer width="5"/>
									 	<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldDocDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.docDateTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDocDateTo','cldDocDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDocDateTo','cldDocDateFrom');"
											   label="#{jspMsg['column.header.docDtTo']}">
											   
										</rich:calendar>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtReqOfficer" value="#{semmsi002Bean.legalApproveDisplaySP.reqOfficer}" size="30"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
											<h:selectOneMenu id="ddlReqType" value="#{semmsi002Bean.legalApproveDisplaySP.reqTypeName}">
											<f:selectItems value="#{semmsi002Bean.reqTypeList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtTitle" value="#{semmsi002Bean.legalApproveDisplaySP.title}" size="30"/>
									</td>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmsi002Bean.legalApproveDisplaySP.contractNo}" size="15" maxlength="12"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.outDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
									    <rich:calendar id="cldInDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.inDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldInDateFrom','cldInDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldInDateFrom','cldInDateTo');"
											   label="#{jspMsg['column.header.inDtFrom']}">
											   
										</rich:calendar>
									    <rich:spacer width="5"/>
									 	<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldInDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.inDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldInDateTo','cldInDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldInDateTo','cldInDateFrom');"
											   label="#{jspMsg['column.header.inDtTo']}">
											   
										</rich:calendar>
									</td>
									<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.inDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
									    <rich:calendar id="cldOutDateFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.outDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldOutDateFrom','cldOutDateTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldOutDateFrom','cldOutDateTo');"
											   label="#{jspMsg['column.header.outDtFrom']}">
											   
										</rich:calendar>
									    <rich:spacer width="5"/>
									    <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									    <rich:spacer width="5"/>
									    <rich:calendar id="cldOutDateTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsi002Bean.legalApproveDisplaySP.outDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldOutDateTo','cldOutDateFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldOutDateTo','cldOutDateFrom');"
											   label="#{jspMsg['column.header.outDtTo']}">
											   
										</rich:calendar>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
									<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtLocationId" value="#{semmsi002Bean.legalApproveDisplaySP.locationId}" size="18" maxlength="15"/>
									</td>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtLocationName" value="#{semmsi002Bean.legalApproveDisplaySP.locationName}" size="30"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.legalApproveStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlLegalApprove" value="#{semmsi002Bean.legalApproveDisplaySP.legalApproveStatusName}" onchange="legalAppChange();">
											<f:selectItems value="#{semmsi002Bean.legalApproveList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="legalAppChange" action="#{semmsi002Action.doLegalChange}" reRender="pnlSearchCriteria">
										</a4j:jsFunction>
										<rich:spacer width="5"/>
										<h:selectOneMenu id="ddlDocStatus" value="#{semmsi002Bean.legalApproveDisplaySP.docStatus}" rendered="#{semmsi002Bean.renderDocStatus}">
											<f:selectItems value="#{semmsi002Bean.docStatusList}"/>
										</h:selectOneMenu>
									</td>
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
										</td>
									<td width="30%">
										<h:inputText id="txtBatchNo" value="#{semmsi002Bean.legalApproveDisplaySP.batchNo}" size="30"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
									
									</td>
									<td width="30%" style="display:none">
										<h:selectOneRadio id="rbtCurrentFlag" value="#{semmsi002Bean.legalApproveDisplaySP.currentFlag}"  styleClass="ms7" rendered="true">
			                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.currentFlagY']}" />
			                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.currentFlagN']}"/>
				                		</h:selectOneRadio>
									</td>
								</tr>
							</table>
							</h:panelGroup>	
						</h:panelGrid>
						<h:panelGrid columns="4" id="grdSearchCommand">
	            	
					<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmError,pnlSearchResult,btnExport" >
						<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI002-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
						<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
	            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
	            	 reRender="frmError,pnlSearchCriteria,pnlSearchResult" >	
	            	 <a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI002-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
						<a4j:actionparam name="methodWithNavi" value="doClear" />
	            	</a4j:commandButton>
	            	
	            </h:panelGrid>
		      </rich:panel>
			</h:panelGrid>			
		</a4j:form>	
	             
            <a4j:form id="frmLegalApproveSearchResult">	
            <!-- begin content button -->
				<h:panelGrid id="grdAddCommand" columns="3">
					<h:commandButton id ="btnExport" value="#{jspMsg['btn.export']}" 
					action="#{semmsi002Action.doExportExcel}" 
					disabled="#{semmsi002Bean.disabledBtnExport}"
					styleClass="rich-button" >
					</h:commandButton>
				</h:panelGrid>
			<!-- end content button -->
            
            <!-- ShowReport Panel -->
				
				<!-- End Code -->
            
		    	<h:panelGrid width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable']}" style="width: 2020"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi002Bean.msgDataNotFound}" rendered="#{semmsi002Bean.renderedMsgDataNotFound}" />
						</div>
						<rich:dataTable width="100%" id="dtbLegalApprove" cellpadding="1" cellspacing="0" border="0"
							var="legalApproveValueSP" value="#{semmsi002Bean.legalApproveDisplaySPList}" rowClasses="cur" reRender="dstLegalApprove" 
							rows="#{semmsi002Bean.rowPerPage}" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi002Action.getRowIdOnClick}" reRender="dtbLegalApprove">
								<a4j:actionparam name="rowId" value="#{legalApproveValueSP.dataObj.rowId}" />
								<a4j:actionparam name="onclickPage" value="1" />
							</a4j:support>
							
							<rich:column styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox style="width: 20" value="#{semmsi002Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmsi002Action.selectAllRow}" reRender="dtbLegalApprove,btnExport"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="chkSelect"  value="#{legalApproveValueSP.checkBox}" rendered="#{legalApproveValueSP.dataObj.renderCheckBox}">
										<a4j:support event="onclick" action="#{semmsi002Action.onRenderExportButton}" reRender="dtbLegalApprove,btnExport">
											<a4j:actionparam name="rowId" value="#{legalApproveValueSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>  							
								</div>
							</rich:column>
							<rich:column id="hlkEdit" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmsi002Bean.renderer['hlkEdit'] or semmsi002Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width: 85"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="btnAdd" value="#{jspMsg['label.chkDoc']}" action="#{navAction.navi}"
									reRender="oppContent" rendered="#{legalApproveValueSP.dataObj.flagLinkEdit}">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="siteApproveId" value="#{legalApproveValueSP.dataObj.rowId}" />
										<a4j:actionparam name="legalApproveId" value="#{legalApproveValueSP.dataObj.legalApproveId}" />
										<a4j:actionparam name="reqType" value="#{legalApproveValueSP.dataObj.reqType}" />
										<a4j:actionparam name="rentType" value="#{legalApproveValueSP.dataObj.rentType}" />
										<a4j:actionparam name="siteAppId" value="#{legalApproveValueSP.dataObj.siteAppId}" />
										<a4j:actionparam name="placeType" value="#{legalApproveValueSP.dataObj.placeType}" />
										<a4j:actionparam name="partiesType" value="#{legalApproveValueSP.dataObj.partiesType}" />
										<a4j:actionparam name="placeTypeRemark" value="#{legalApproveValueSP.dataObj.placeTypeRemark}" />
                                        <a4j:actionparam name="partiesTypeRemark" value="#{legalApproveValueSP.dataObj.partiesTypeRemark}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="btnView" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmsi002Bean.renderer['btnView'] or semmsi002Bean.renderedOnToDoList}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView2" image="images/view.png" style="height: 15; width: 15;" value="View" action="#{navAction.navi}"
									reRender="oppContent">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="doShow" />
										<a4j:actionparam name="siteApproveId" value="#{legalApproveValueSP.dataObj.rowId}" />
										<a4j:actionparam name="legalApproveId" value="#{legalApproveValueSP.dataObj.legalApproveId}" />
										<a4j:actionparam name="reqType" value="#{legalApproveValueSP.dataObj.reqType}" />
										<a4j:actionparam name="rentType" value="#{legalApproveValueSP.dataObj.rentType}" />
										<a4j:actionparam name="pageMode" value="VIEW" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column id="colRegion" sortBy="#{legalApproveValueSP.dataObj.regionName}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" styleClass="contentform" style="width: 20"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.regionName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colDocNo" sortBy="#{legalApproveValueSP.dataObj.docNo}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docNo']}" styleClass="contentform" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.docNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column id="colContractNo" sortBy="#{legalApproveValueSP.dataObj.contractNo}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width: 60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{legalApproveValueSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{legalApproveValueSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="colLocationName" sortBy="#{legalApproveValueSP.dataObj.locationName}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationName']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{legalApproveValueSP.dataObj.locationName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colLocationId" sortBy="#{legalApproveValueSP.dataObj.locationId}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="contentform" style="width: 55"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.locationId}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colDocDate" sortBy="#{legalApproveValueSP.dataObj.docDate}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docDate']}" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="" styleClass="contentform" >         
										<h:outputText value="#{legalApproveValueSP.dataObj.docDateStr}" styleClass="contentform" >
										</h:outputText>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colReqTypeName" sortBy="#{legalApproveValueSP.dataObj.reqTypeName}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.reqType']}" styleClass="contentform" style="width: 120"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.reqTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colReqOfficer" sortBy="#{legalApproveValueSP.dataObj.reqOfficer}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.reqOfficer']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{legalApproveValueSP.dataObj.reqOfficer}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colTitle" sortBy="#{legalApproveValueSP.dataObj.title}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.title']}" styleClass="contentform" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{legalApproveValueSP.dataObj.title}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column id="colOutDt" sortBy="#{legalApproveValueSP.dataObj.outDt}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.outDt']}" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.inDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colInDt" sortBy="#{legalApproveValueSP.dataObj.inDt}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.inDt']}" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.outDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column id="colLegalApproveStatus" sortBy="#{legalApproveValueSP.dataObj.legalApproveStatusName}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.legalApproveStatus']}" styleClass="contentform" style="width: 55"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.legalApproveStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column id="colSiteStatus" sortBy="#{legalApproveValueSP.dataObj.siteStatus}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>										
							<rich:column id="colStatusProgress" sortBy="#{legalApproveValueSP.dataObj.flowStatus}" styleClass="#{(semmsi002Bean.tmpRowId==legalApproveValueSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{legalApproveValueSP.dataObj.contractNo} #{legalApproveValueSP.dataObj.locationName}">  
								<f:facet name="header">
									<h:outputText value="Flow Status" styleClass="contentform" style="width:200px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveValueSP.dataObj.flowStatus}" styleClass="contentform"  style="width:200px"/>
								</div>
							</rich:column>						
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi002Bean.legalApproveDisplaySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLegalApprove"
											maxPages="#{semmsi002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstLegalApprove" 
											style="background-color: #cccccc;"
											page="#{semmsi002Bean.scrollerPage}" 
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
