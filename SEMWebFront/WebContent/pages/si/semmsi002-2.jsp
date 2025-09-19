<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.siteinfo.semmsi002" var="jspMsg"/>
<h:panelGrid width="100%">
	<script>
	
	/*function findSelectedRentel(){
		for(var i =0;i<8;i++){
			var a = document.getElementById("incContent:frmAdd:rbtRentType1:"+i);
			if(a.checked == true){
				return a;
			}
		}
		return null;
	}*/
	
	function myFunction() {
        //document.getElementById("incContent:frmAdd").hide();

        var element = document.getElementById("incContent:frmAdd");
        element.parentNode.removeChild(element);
        
    //  alert('test');
        }
	</script>
	<rich:panel  id="pnlLegalApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name2']} #{semmsi002Bean.pageStatus}" /></f:facet>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
		<a4j:form id="frmAdd">
		<h:panelGrid width="90%">
		<h:panelGroup>
				<table width="100%">
					<tr>
						<td align="right" valign="bottom">
							<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI002-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI002"/>
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />
							</a4j:commandButton>
							
						</td>
					</tr>
				</table>
				</h:panelGroup>
				</h:panelGrid>
			<h:panelGrid width="90%">	
			<rich:simpleTogglePanel switchType="client" label="#{jspMsg['label.panelShow']}" width="100%" opened="disable" >			
			<rich:panel id="pnlShowSiteApprove" >						
		                <h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlCompany" value="#{semmsi002Bean.siteApprove.company}" disabled="true">
											<f:selectItems value="#{semmsi002Bean.companyList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtDocNo" value="#{semmsi002Bean.siteApprove.docNo}" size="23" maxlength="20" disabled="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldDocDt" locale="th" 
										datePattern="dd/MM/yyyy" 
									    value="#{semmsi002Bean.siteApprove.docDt}"
									    showWeeksBar="false" 
									    inputSize="13" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
										
									</td>
								</tr>
								<tr>								
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtReqOfficer" value="#{semmsi002Bean.siteApprove.reqOfficer}" size="30" disabled="true"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlReqDocType" value="#{semmsi002Bean.siteApprove.reqType}" disabled="true">
											<f:selectItems value="#{semmsi002Bean.reqTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.reqDocType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlReqType" value="#{semmsi002Bean.siteApprove.reqDocType}" disabled="true">
											<f:selectItems value="#{semmsi002Bean.reqDocTypeList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>								
									
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtTitle"  value="#{semmsi002Bean.siteApprove.title}" size="30" disabled="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmsi002Bean.siteApprove.contractNo}" size="15" maxlength="12" disabled="true"/>
										
									</td>
								</tr>
								<tr>
									<td align="right" valign="top" width="20%">
										<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
									</td>
									<td colspan="4">
										<h:inputTextarea  value="#{semmsi002Bean.siteApprove.detail}" cols="100" rows="10"  disabled="true"/>
									</td>
								</tr>
								<tr>
									<td align="right" valign="top" width="20%">
										<h:outputText value="#{jspMsg['label.recDt']} :" styleClass="ms7"/>
									</td>
									<td>
										<rich:calendar id="inDt" locale="th" 
										datePattern="dd/MM/yyyy" 
									    value="#{semmsi002Bean.siteApprove.inDt}"
									    showWeeksBar="false" 
									    inputSize="13" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.siteApproveStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlSiteApproveStatus" value="#{semmsi002Bean.siteApprove.siteApproveStatus}" disabled="true">
											<f:selectItems value="#{semmsi002Bean.siteApproveStatusList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
		            </rich:panel>          
            
		    	<br/>
		    	<rich:panel id="pnlSearchResult" style="width: 620">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable2']}" style="width: 630"/>
						</f:facet>
						<rich:dataTable width="100%" id="dtbSiteApproveMapLoc" cellpadding="1" cellspacing="0" border="0"
							var="siteApproveMapLocValueSP" value="#{semmsi002Bean.siteApproveMapLocSPList}" reRender="dstSiteApproveMapLoc" 
							rows="#{semir004Bean.rowPerPage}" rowClasses="cur" styleClass="ms7">
							<a4j:support event="onRowClick"   action="#{semmsi002Action.getRowIdOnClick}" reRender="dtbSiteApproveMapLoc">
								<a4j:actionparam name="rowId" value="#{siteApproveMapLocValueSP.siteApproveId}" />
								<a4j:actionparam name="onclickPage" value="2" />
							</a4j:support>
							<rich:column id="colLocationId" sortBy="#{siteApproveMapLocValueSP.locationId}" styleClass="#{(semmsi002Bean.tmpRowId2==siteApproveMapLocValueSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApproveMapLocValueSP.locationId}" styleClass="ms7"  />
								</div>
							</rich:column>
							<rich:column id="colLocationName" sortBy="#{siteApproveMapLocValueSP.locationName}" styleClass="#{(semmsi002Bean.tmpRowId2==siteApproveMapLocValueSP.rowId)?'onClick':'unClick'}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationName']}" styleClass="ms7" />
								</f:facet>
								<div align="left">
									<h:outputText value="" styleClass="ms7" >         
										<h:outputText value="#{siteApproveMapLocValueSP.locationName}" styleClass="ms7"  />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colRegion" sortBy="#{siteApproveMapLocValueSP.region}" styleClass="#{(semmsi002Bean.tmpRowId2==siteApproveMapLocValueSP.rowId)?'onClick':'unClick'}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApproveMapLocValueSP.region}" styleClass="ms7"  />
								</div>
							</rich:column>
							<rich:column id="colStationType" sortBy="#{siteApproveMapLocValueSP.stationType}" styleClass="#{(semmsi002Bean.tmpRowId2==siteApproveMapLocValueSP.rowId)?'onClick':'unClick'}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.stationType']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApproveMapLocValueSP.stationType}" styleClass="ms7"  />
								</div>
							</rich:column>				
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApproveMapLoc" 
									maxPages="10" id="dstSiteApproveMapLoc" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						</rich:panel>
				</rich:simpleTogglePanel>  
				</h:panelGrid>
				
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchLegalApproveResult" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.name3']}" />
						</f:facet>
						<rich:dataTable width="60%" id="dtbLegalApproveSrchByAppv" cellpadding="1" cellspacing="0" border="0"
							var="legalApproveSrchValueSP" value="#{semmsi002Bean.legalApproveSrchByAppvSPList}" reRender="dstLegalApproveSrchByAppv" 
							rows="#{semir004Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur"> 
							<a4j:support event="onRowClick"   action="#{semmsi002Action.getRowIdOnClick}" reRender="dtbLegalApproveSrchByAppv">
								<a4j:actionparam name="rowId" value="#{legalApproveSrchValueSP.rowId}" />
								<a4j:actionparam name="onclickPage" value="3" />
							</a4j:support> 
							
							<rich:column id="Edit" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}" rendered="#{semmsi002Bean.renderedColumn}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="ms7" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnEdit" image="images/edit.png" style="height: 15; width: 15;" action="#{navAction.navi}" 
									 reRender="btnAdd,btnSave,pnlCheckLegalApprove,pnlRiskType,pnlSearchLegalApproveResult,pnlLog,msi002_right" disabled="#{semmsi002Bean.pageMode}" 
									 rendered="#{legalApproveSrchValueSP.chkFlagEditable}">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="rowId" value="#{legalApproveSrchValueSP.rowId}" />
										<a4j:actionparam name="cRound" value="#{legalApproveSrchValueSP.cRound}" />
										<a4j:actionparam name="mode" value="EDIT" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column id="Delete" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}" rendered="#{semmsi002Bean.renderedColumn}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.delete']}" styleClass="ms7" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnDelete" oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false;" 
									 action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15;" disabled="#{semmsi002Bean.pageMode}"
									 reRender="btnAdd,btnSave,btnClear,pnlSearchLegalApproveResult,pnlLog"  rendered="#{legalApproveSrchValueSP.renderedDeletetable}">											
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowId" value="#{legalApproveSrchValueSP.rowId}" />
										<a4j:actionparam name="action" value="DEL" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column id="View" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="ms7" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnView" image="images/view.png" style="height: 15; width: 15;" action="#{navAction.navi}" 
									 reRender="btnAdd,btnSave,pnlCheckLegalApprove,pnlRiskType,pnlSearchLegalApproveResult,pnlLog,msi002_right">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="rowId" value="#{legalApproveSrchValueSP.rowId}" />
										<a4j:actionparam name="cRound" value="#{legalApproveSrchValueSP.cRound}" />
										<a4j:actionparam name="mode" value="VIEW" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column id="colCRound" sortBy="#{legalApproveSrchValueSP.cRound}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.cRound']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveSrchValueSP.cRound}" styleClass="ms7"  />
								</div>
							</rich:column>
							<rich:column id="colReceiveDt" sortBy="#{legalApproveSrchValueSP.receiveDt}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['colomn.receiveDt']}" styleClass="ms7" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{legalApproveSrchValueSP.receiveDt}" styleClass="ms7">
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
                                    </h:outputText>
                                </div>
                            </rich:column>
							<rich:column id="colCheckDt" sortBy="#{legalApproveSrchValueSP.chkDt}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.checkDt']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{legalApproveSrchValueSP.chkDt}" styleClass="ms7">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colLegalApproveStatus" sortBy="#{legalApproveSrchValueSP.legalApproveStatusName}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.legalApproveStatus']}" styleClass="ms7" />
								</f:facet>
								<div align="center">        
										<h:outputText value="#{legalApproveSrchValueSP.legalApproveStatusName}" styleClass="ms7"  />
								</div>
							</rich:column>
							<rich:column id="colLegalDocNotComplete" sortBy="#{legalApproveSrchValueSP.docNotComplete}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">  
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.docNotComplete']}" styleClass="ms7" />
                                </f:facet>
                                <div align="center">        
                                        <h:outputText value="#{legalApproveSrchValueSP.docNotComplete}" styleClass="ms7"  />
                                </div>
                            </rich:column>
							<rich:column id="colRemark" sortBy="#{legalApproveSrchValueSP.remark}" styleClass="#{(semmsi002Bean.tmpId==legalApproveSrchValueSP.rowId)?'onClick':'unClick'}">  
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="ms7" style="width: 150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{legalApproveSrchValueSP.remark}" styleClass="ms7"  />
								</div>
							</rich:column>				
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLegalApproveSrchByAppv" 
									maxPages="10" id="dstLegalApproveSrchByAppv" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>  
				
				<h:panelGrid width="90%">
				<rich:panel id="pnlCheckLegalApprove" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.name7']}" />
						</f:facet>
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<h:messages id="pnlLegalAp" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true" />
							<table width="100%">
								<tr>
									<td align="right" width="21%">
										<h:outputText value="#{jspMsg['label.round']}" styleClass="ms7" />
									</td>
									<td width="24%">
										<h:inputText id="txtRound" value="#{semmsi002Bean.cRound}" disabled="true" size="4"/>
									</td>
									<td align="right" width="21%">
										<h:outputText value="#{jspMsg['label.checkDt']}" styleClass="ms7" />
									</td>
									<td width="29%">
										<rich:calendar id="cldCheckDt" locale="th" 
										datePattern="dd/MM/yyyy" 
									    value="#{semmsi002Bean.legalApprove.checkDt}"
									    inputSize="13" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td align="right">
										<h:graphicImage value="images/icon_required.gif"/>
									<h:outputText value="#{jspMsg['label.legalApproveStatus']}" styleClass="ms7" />
									</td>
									<td>
										<h:selectOneMenu id="ddlLegalApproveStatus" value="#{semmsi002Bean.legalApprove.legalApproveStatus}" disabled="#{semmsi002Bean.pageMode}" onchange="legalApproveChange();">
											<f:selectItems value="#{semmsi002Bean.legalApproveList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction  name="legalApproveChange" reRender="frmAdd,pnlCheckLegalApprove,pnlLegalApprove,msi002_right" action="#{semmsi002Action.legalApproveChange}"></a4j:jsFunction>
									</td>
									<td align="right">
                                        <h:outputText value="#{jspMsg['label.receiveDt']}" styleClass="ms7" />
                                    </td>
                                    <td>
                                        <rich:calendar id="cldReceiveDt" locale="th" enableManualInput="true"
                                        datePattern="dd/MM/yyyy" 
                                        value="#{semmsi002Bean.legalApprove.receiveDt}"
                                        showWeeksBar="false" 
                                        inputSize="13" 
                                        cellWidth="20px" cellHeight="20px"/>
                                    </td>
                                    <td></td>									
								</tr>
								<tr>
									<td align="right"  valign="top" width="21%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
									</td>
									<td colspan="4" width="79%">
										<h:inputTextarea id="txtRemark" value="#{semmsi002Bean.legalApprove.remark}" cols="100" rows="3" disabled="#{semmsi002Bean.pageMode}"/>
									</td>								
								</tr>
							</table>
								
							<table>
								<tr>
									<td align="right" valign="bottom">
										<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.add']}" styleClass="rich-button" disabled="#{semmsi002Bean.validateBtnSave or semmsi002Bean.renderedCancletable}"
									 	 action="#{navAction.navi}" reRender="oppContent,pnlSearchLegalApproveResult,pnlCheckLegalApprove,pnlLegalApprove,pnlRiskType,pnlLog,btnAdd,btnSave,btnClear,msi002_right,
									 	 pnlLog"
									 	 rendered="#{semmsi002Bean.renderedColumn and semmsi002Bean.renderedEditable}">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002"/>
										<a4j:actionparam name="methodWithNavi" value="doSave" />
										<a4j:actionparam name="action" value="ADD" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" disabled="#{semmsi002Bean.validateBtn}"
									 action="#{navAction.navi}" reRender="oppContent,pnlSearchLegalApproveResult,pnlCheckLegalApprove,pnlRiskType,pnlLog,msi002_right,pnlLog"
									 rendered="#{semmsi002Bean.renderedColumn and semmsi002Bean.renderedEditable}">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002"/>
										<a4j:actionparam name="methodWithNavi" value="doUpdate" />
										<a4j:actionparam name="action" value="UPD" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="pnlSearchLegalApproveResult,pnlCheckLegalApprove,pnlRiskType,pnlLog,msi002_right" 
									rendered="#{semmsi002Bean.renderedColumn and semmsi002Bean.renderedEditable}">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002"/>
										<a4j:actionparam name="methodWithNavi" value="doClear2" />
									</a4j:commandButton>
									</td>
								</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				</h:panelGrid>
					
				<h:panelGrid width="90%" rendered="#{semmsi002Bean.renderLegalDetail}">
				<rich:panel id="pnlRiskType" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.name4']}" />
						</f:facet>
				<h:panelGrid>
					<h:panelGroup>
						<table width="900">
						    <tr>
                                <td width="40%">
                                    <h:selectManyCheckbox id="legal_chkContractWanted" disabled="true"
                                      value="#{semmsi002Bean.chkContractWanted}" layout="lineDirection" styleClass="ms7" > 
                                        <f:selectItem itemLabel="#{jspMsg['label.th_contractNotMustBe']} #{jspMsg['label.th_because']}" itemValue="Y" />
                                    </h:selectManyCheckbox>  
                                </td>
                                <td width="60%">
                                    <rich:spacer width="50"/>
                                    <h:inputTextarea value="#{semmsi002Bean.siteAppObjParam.contractWantedRemark}" id="legal_contractWantedRemark"
	                                rows="3" cols="50" style="width:100%;" styleClass="ms7"  disabled="true">
	                                </h:inputTextarea>
                                </td>
                            </tr>
							<tr>
								<td width="40%">									
									<h:selectManyCheckbox id="chkRiskType1" disabled="#{semmsi002Bean.pageMode}"
									  value="#{semmsi002Bean.riskType1List}" layout="lineDirection" styleClass="ms7" > 
										<f:selectItem itemLabel="#{jspMsg['label.riskType1']}" itemValue="Y" />
									</h:selectManyCheckbox>
								</td>
								<td width="60%">
									<rich:spacer width="50"/>
									
								    <h:inputTextarea id="txtRiskType1" value="#{semmsi002Bean.legalApprove.riskType1Remark}"
                                    rows="3" cols="50" style="width:100%;" styleClass="ms7"  disabled="#{semmsi002Bean.pageMode}">
                                    </h:inputTextarea>
								</td>
							</tr>
							<tr>								
								<td width="40%">
									<h:selectManyCheckbox id="chkRiskType2" disabled="#{semmsi002Bean.pageMode}"
									  value="#{semmsi002Bean.riskType2List}" layout="lineDirection" styleClass="ms7"> 
										<f:selectItem itemLabel="#{jspMsg['label.riskType2']}" itemValue="Y" />
									 </h:selectManyCheckbox>
									 <rich:spacer width="25" /><h:outputText value="#{jspMsg['label.riskType21']}" styleClass="ms7" />
								</td>
								<td width="60%" >
									<rich:spacer width="50"/>
									 <h:inputTextarea id="txtRiskType2" value="#{semmsi002Bean.legalApprove.riskType2Remark}"
                                    rows="3" cols="50" style="width:100%;" styleClass="ms7"  disabled="#{semmsi002Bean.pageMode}">
                                    </h:inputTextarea>
								</td>
							</tr>
							<tr>
								<td width="40%">
									<h:selectManyCheckbox id="chkRiskType3" disabled="#{semmsi002Bean.pageMode}"
									  value="#{semmsi002Bean.riskType3List}" layout="lineDirection" styleClass="ms7"> 
										<f:selectItem itemLabel="#{jspMsg['label.riskType3']}" itemValue="Y" />
									 </h:selectManyCheckbox>
								</td>
								<td width="60%">
									<rich:spacer width="50"/>
									  <h:inputTextarea id="txtRiskType3" value="#{semmsi002Bean.legalApprove.riskType3Remark}"
                                    rows="3" cols="50" style="width:100%;" styleClass="ms7"  disabled="#{semmsi002Bean.pageMode}">
                                    </h:inputTextarea>
								</td>
							</tr>
							<tr>
								<td width="40%">
									<h:selectManyCheckbox id="chkRiskTypeOther" disabled="#{semmsi002Bean.pageMode}"
									  value="#{semmsi002Bean.riskTypeOtherList}"  layout="lineDirection" styleClass="ms7"> 
										<f:selectItem itemLabel="#{jspMsg['label.riskTypeOther']}" itemValue="Y" />
									 </h:selectManyCheckbox>
								</td>							
								<td width="60%"> 
									<rich:spacer width="50"/>
									 <h:inputTextarea id="txtRiskTypeOther" value="#{semmsi002Bean.legalApprove.riskTypeOtherRemark}"
                                    rows="3" cols="50" style="width:100%;" styleClass="ms7"  disabled="#{semmsi002Bean.pageMode}">
                                    </h:inputTextarea>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid width="90%" rendered="true">
					<rich:panel id="pnlRentalType" >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.name5']}" />
							</f:facet>
							<h:panelGrid width="0px" rendered="false">
								<h:panelGroup>
									<table width="100%" border="0"> 
										<tr>
											<td width="40%" valign="top">
												<table><tr style=" height : 2px;"><td>
													 	<h:selectOneRadio id="rbtRentType1" value="#{semmsi002Bean.legalApprove.rentType}"  layout="pageDirection" 
													 	 styleClass="ms7" rendered="false" onclick="rentTypeShow();" disabled="#{semmsi002Bean.pageMode}">
							                						<a4j:jsFunction name="rentTypeShow" action="#{semmsi002Action.doShowRentType}" 
							                						 reRender="frmAdd,pnlRentalType"/>
									                				<f:selectItem itemValue="01" itemLabel="ที่ดิน" />
									                				<f:selectItem itemValue="02" itemLabel="อาคารพาณิชย์" />
									                				<f:selectItem itemValue="03" itemLabel="บริษัท/ห้างร้าน" />
									                				<f:selectItem itemValue="04" itemLabel="นิติบุคคลอาคารชุด" />
									                				<f:selectItem itemValue="05" itemLabel="ปักเสา" />
									                				<f:selectItem itemValue="06" itemLabel="ป้ายโฆษณา" />
									                				<f:selectItem itemValue="07" itemLabel="สถานที่ราชการ" />
									                				<f:selectItem itemValue="99" itemLabel="อื่นๆ" />
							                			</h:selectOneRadio>
						                			</td><td valign="bottom" style=" width : 0px;height:0px">
						                				<h:inputText value="#{semmsi002Bean.legalApprove.rentTypeOtherRemark}" size="25" rendered="false" disabled="#{semmsi002Bean.pageMode}"></h:inputText>
													</td>
												</tr></table>
											</td>
											<td width="60%" valign="top">
												<h:panelGroup id="pnlRentalType1" rendered="false" >
													<table width="90%">
														<tr>
															<h:outputText value="เอกสารที่ขาด-ที่ดิน" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<td>
																			<h:selectManyCheckbox id="chkDoc011" disabled="#{semmsi002Bean.pageMode}"
																	  			rendered="false" value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																			 </h:selectManyCheckbox>
																		</td>
																	</tr>
																</table>
																	
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc012" disabled="#{semmsi002Bean.pageMode}"
																	  				 rendered="false" value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>	 
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>	
																	 			<h:selectManyCheckbox id="chkDoc013" disabled="#{semmsi002Bean.pageMode}"
																	  				rendered="false" value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc014" disabled="#{semmsi002Bean.pageMode}"
																	  				rendered="false" value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc015" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc016" disabled="#{semmsi002Bean.pageMode}"
																					 rendered="false"  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc017" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc018" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>		 
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther1" disabled="#{semmsi002Bean.pageMode}"
																	  				rendered="false" value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>	 
																				 <h:inputText id="txtDocOtherRemark1" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				 rendered="false" size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table> 
																</td>
																
															</tr>	 
													</table>
												</h:panelGroup>	
												
												<h:panelGroup id="pnlRentalType2" rendered="#{semmsi002Bean.disableChk2}">
													<table>
														<tr>
															<h:outputText value="เอกสารที่ขาด-อาคารพาณิชย์" styleClass="ms7" style="text-decoration:underline;" rendered="false" />
														</tr>
														<tr>
															<td>
																<table>
																		<tr>
																			<td>
																				<h:selectManyCheckbox id="chkDoc021" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				   	<f:selectItem itemLabel="สำเนาบัตรประชาชน" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																</table> 
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc022" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																</table> 
																</td>	 
															</tr>
															<tr>
																<td>	
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc023" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารเช่า" itemValue="Y" />
																				 </h:selectManyCheckbox>
																		    </td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc024" disabled="#{semmsi002Bean.pageMode}"
																	 				 rendered="false" value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																				 </h:selectManyCheckbox>
																				 <rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" rendered="false" /><br/><br/>
																				 <rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" rendered="false" /><br/><br/>
																				 <rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" rendered="false" /><br/><br/>
																				 <rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" rendered="false" />
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc025" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7" > 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc026" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc027" disabled="#{semmsi002Bean.pageMode}"
																					  rendered="false" value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDocOther2" disabled="#{semmsi002Bean.pageMode}"
																	 				 rendered="false" value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๅ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>
																				<h:inputText id="txtDocOtherRemark2" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				rendered="false" size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table>	 
																 </td>
															</tr>	 
													</table>
												</h:panelGroup>
												
												<h:panelGroup id="pnlRentalType3" rendered="false" >
													<table>
														<tr>
															<h:outputText value="เอกสารที่ขาด-บริษัท/ห้างร้าน" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																		<tr>
																			<td>
																				<h:selectManyCheckbox id="chkDoc031" disabled="#{semmsi002Bean.pageMode}"
																 					 value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนกรรมการ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																</table>
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc032" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้านกรรมการ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																</table>
																</td>	 
															</tr>
															<tr>
																<td>	
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc033" disabled="#{semmsi002Bean.pageMode}"
																	 				 value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือรับรองนิติบุคคล" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>	
																				 <h:selectManyCheckbox id="chkDoc034" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																						<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารที่เช่า" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>	 
																</td>
															</tr>
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc035" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 			<rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" />
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc036" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc037" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc038" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDocOther3" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๅ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>
																				<h:inputText id="txtDocOtherRemark3" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				  size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table>																			
																 </td>
															</tr>	 
													</table>
												</h:panelGroup>
												
												<h:panelGroup id="pnlRentalType4" rendered="false" >
													<table>
														<tr>
															<h:outputText value="เอกสารที่ขาด-นิติบุคคลอาคารชุด" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																		<tr>
																			<td>
																				<h:selectManyCheckbox id="chkDoc041"  disabled="#{semmsi002Bean.pageMode}"
																				  value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="สำเนาทะเบียนบ้านของอาคาร" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																</table>
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc042" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้านผู้จัดการ ฯ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																</td>	 
															</tr>
															<tr>
																<td>	
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc043" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนผู้จัดการ ฯ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td>	
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc044" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รายการจดทะเบียนนิติบุคคลอาคารชุด" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc045" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รายงานการประชุมนิดิบุคคลอาคารชุด" itemValue="Y" />
																				 </h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																				  <h:selectManyCheckbox id="chkDoc046" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รายการจดทะเบียนนิติบุคคลอาคารชุด ระบุ ชื่อ-ที่อยู่ ผู้จัดการ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc047" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc048" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc049" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc9List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																				 <rich:spacer width="25" /><h:outputText value="**ในกรณีนิติบุคคลเป็นผู้จัดการขอหลักฐานหนังสือรับรอง" styleClass="ms7" />
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther4" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๅ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>
																				<h:inputText id="txtDocOtherRemark4" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				 size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
													</table>
												</h:panelGroup>
												
												<h:panelGroup id="pnlRentalType5" rendered="false" >
													<table width="90%">
														<tr>
															<h:outputText value="เอกสารที่ขาด-ปักเสา" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<td>
																			<h:selectManyCheckbox id="chkDoc051" disabled="#{semmsi002Bean.pageMode}"
																	  			value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																			 </h:selectManyCheckbox>
																		</td>
																	</tr>
																</table>
																	
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc052" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>	 
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>	
																	 			<h:selectManyCheckbox id="chkDoc053" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc054" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc055" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc056" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc057" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc058" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther5" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>	 
																				 <h:inputText id="txtDocOtherRemark5" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				  size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table> 
																</td>
																
															</tr>	 
													</table>
												</h:panelGroup>	
												
												<h:panelGroup id="pnlRentalType6" rendered="false" >
													<table width="90%">
														<tr>
															<h:outputText value="เอกสารที่ขาด-ป้ายโฆษณา" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<td>
																			<h:selectManyCheckbox id="chkDoc061" disabled="#{semmsi002Bean.pageMode}"
																	  			value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																			 </h:selectManyCheckbox>
																		</td>
																	</tr>
																</table>
																	
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc062" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>	 
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>	
																	 			<h:selectManyCheckbox id="chkDoc063" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc064" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc065" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc066" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc067" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc068" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther6" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>	 
																				 <h:inputText id="txtDocOtherRemark6" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				  size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table> 
																</td>
																
															</tr>	 
													</table>
												</h:panelGroup>	
												
												<h:panelGroup id="pnlRentalType7" rendered="false">
													<table width="90%">
														<tr>
															<h:outputText value="เอกสารที่ขาด-อื่นๆ" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<td>
																			<h:selectManyCheckbox id="chkDoc991" disabled="#{semmsi002Bean.pageMode}"
																	  			value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="โฉนดที่ดินหน้า/หลัง" itemValue="Y" />
																			 </h:selectManyCheckbox>
																		</td>
																	</tr>
																</table>
																	
															</td>
														</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc992" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้าน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>	 
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>	
																	 			<h:selectManyCheckbox id="chkDoc993" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาบัตรประชาชนเจ้าของที่ดิน" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																</td>
															</tr>	
															<tr>
																<td> 
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc994" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="นส.3ก. หน้า/หลัง" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 		</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc995" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc5List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="ภบท. 5" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc996" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc6List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="สำเนาทะเบียนบ้านอาคารเช่า" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>
															<tr>
																<td>
																<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDoc997" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.doc7List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="(อย่างใดอย่าหนึ่ง)" itemValue="Y" />
																	 			</h:selectManyCheckbox>
																	 			<rich:spacer width="25" /><h:outputText value="หนังสือสัญญาจะซื้อจะขาย" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="ใบขอเลขหมายประจำบ้าน" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="ใบขออนุญาติปลูกสร้าง" styleClass="ms7" /><br/><br/>
																	 			<rich:spacer width="25" /><h:outputText value="โฉนดที่ดินหน้า-หลัง/หนังสือยืนยันกรรมสิทธิ์" styleClass="ms7" />
																	 		</td>
																		</tr>
																</table>
																</td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc998" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc8List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc999" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc9List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc1000" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc10List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther7" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>
																				 <h:inputText id="txtDocOtherRemark7" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				  size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table> 
																</td>
																
															</tr>	 
													</table>
												</h:panelGroup>
												
												<h:panelGroup id="pnlRentalType8" rendered="false" >
													<table width="90%">
														<tr>
															<h:outputText value="เอกสารที่ขาด-สถานที่ราชการ" styleClass="ms7" style="text-decoration:underline;"/>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<td>
																			<h:selectManyCheckbox id="chkDoc081" disabled="#{semmsi002Bean.pageMode}"
																	  			value="#{semmsi002Bean.doc1List}" layout="lineDirection" styleClass="ms7"> 
																				<f:selectItem itemLabel="ใบอนุญาตให้เข้าดำเนินการติดตั้ง" itemValue="Y" />
																			 </h:selectManyCheckbox>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc082" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc2List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="รับรองสำเนาถูกต้อง เอกสารประกอบ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc083" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc3List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือบอกกล่าวสิ้นสุดสัญญาเดิม" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																				 <h:selectManyCheckbox id="chkDoc084" disabled="#{semmsi002Bean.pageMode}"
																					  value="#{semmsi002Bean.doc4List}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="หนังสือมอบอำนาจ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																		</tr>
																	</table>
																 </td>
															</tr>	 
														<tr>
																<td>
																	<table>
																		<tr>
																			<td>
																	 			<h:selectManyCheckbox id="chkDocOther8" disabled="#{semmsi002Bean.pageMode}"
																	  				value="#{semmsi002Bean.docOtherList}" layout="lineDirection" styleClass="ms7"> 
																					<f:selectItem itemLabel="อื่นๆ" itemValue="Y" />
																				 </h:selectManyCheckbox>
																			</td>
																			<td>
																				 <h:inputText id="txtDocOtherRemark8" value="#{semmsi002Bean.legalApprove.docOtherRemark}" 
																				  size="60" maxlength="300" disabled="#{semmsi002Bean.pageMode}"/>
																			</td>
																		</tr>
																	</table> 
																</td>
																
															</tr>	 
													</table>
												</h:panelGroup>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							
							
							<!-- update by new 20141217  -->
							<h:panelGrid style="width:98%;">
                                <h:panelGroup style="width:98%;">
                                    <table style="width:98%;">
                                        <tr>      
                                            <td style="border:solid ececec 0px; white-space:nowrap; vertical-align:top;" align="right">
                                                <a4j:commandButton id="btnView2" value="#{jspMsg['btn.view']}" styleClass="rich-button"
					                             action="#{navAction.navi}" onclick="myFunction();" reRender="oppContent">
					                                <a4j:actionparam name="navModule" value="sa" />
					                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                                                    
					                                <a4j:actionparam name="moduleWithNavi" value="sa" />
					                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
					                                                    
					                                <a4j:actionparam name="rowId" value="#{semmsi002Bean.siteAppObjParam.siteAppId}" />
					                                <a4j:actionparam name="paramUrl" value="SEMMSI002-2" />
					                                <a4j:actionparam name="paramMode" value="ELG" />
					                                       
					                                <a4j:actionparam name="mode" value="VIEW" />
					                                       
					                                <a4j:actionparam name="paramBackToMe" value="Y" />
					                                <a4j:actionparam name="paramNavModuleFrom" value="si" />
					                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSI002-2" />
					                                <a4j:actionparam name="paramModuleWithNaviFrom" value="si" />
					                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSI002" />
					                                <a4j:actionparam name="paramMethodWithNaviFrom" value="doShow" />
					                            </a4j:commandButton>
                                            </td>
                                        </tr>
                                    </table>
                                </h:panelGroup>
                            </h:panelGrid>
                            
							<h:panelGrid style="width:98%;">
                                <h:panelGroup style="width:98%;">
                                    <table style="width:98%;">
			                            <tr>
			                                <td style="border:solid ececec 1px; white-space:nowrap; vertical-align:top;">
			                                    <h:panelGrid style="width:98%;" columns="2" columnClasses="leftColumn, rightColumn">
			                                        
			                                        <!-- panel left -->
			                                        <h:panelGroup id="msi002_left" style="width:350px; height:100%; white-space:nowrap; padding:10px 0 0 30px;">
			                                            <!-- dropdown 1 [legal place type] -->
			                                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
			                                             <tr>
			                                                 <td width="40%" valign="top" align="right">
			                                                      <h:outputText value="#{jspMsg['label.placeType']} : " styleClass="ms7" />
			                                                 </td>
			                                                 <td width="60%" align="left">
			                                                     <h:selectOneMenu id="txtPlaceType" value="#{semmsi002Bean.siteAppObjParam.placeType}" styleClass="ms7"
			                                                        onchange="func_sendPlaceType();" style="width:120px;">
			                                                            <f:selectItems value="#{semmsi002Bean.legalPlaceTypeList}"/>
			                                                      </h:selectOneMenu>
			                                                      
			                                                      <a4j:jsFunction name="func_sendPlaceType" action="#{semmsi002Action.doGetLegalDoc}" reRender="msi002_left,msi002_right">
                                                                  </a4j:jsFunction>
                                                                   
			                                                 </td>
			                                             </tr>
			                                             <tr>
			                                                 <td colspan="2">
			                                                 <div style="clear:both; height:2px;"></div>
                                                        
                                                                  <h:inputTextarea id="txtPlaceTypeRemark" value="#{semmsi002Bean.siteAppObjParam.placeTypeRemark}" style="width:80%" cols="20" rows="3" rendered="#{semmsi002Bean.siteAppObjParam.placeType == '99'}"/>
                                                                  <div style="clear:both; height:2px;"></div>
			                                                 </td>
			                                             </tr>
			                                             <tr>
                                                             <td valign="top" align="right">
                                                                  <h:outputText value="#{jspMsg['label.partiesType']} : " styleClass="ms7" />
                                                             </td>
                                                             <td align="left">
                                                                 <h:selectOneMenu id="txtPartiesType" value="#{semmsi002Bean.siteAppObjParam.partiesType}" styleClass="ms7"
		                                                         onchange="func_sendPartiesType();" style="width:120px;">
		                                                            <f:selectItems value="#{semmsi002Bean.legalPartiesTypeList}"/>
		                                                         </h:selectOneMenu>
		                                                         <a4j:jsFunction name="func_sendPartiesType" action="#{semmsi002Action.doGetLegalDoc}" reRender="msi002_left,msi002_right">
		                                                         </a4j:jsFunction>
		                                                        
                                                             </td>
                                                         </tr>
                                                         <tr>
                                                            <td colspan="2">
                                                                <div style="clear:both; height:2px;"></div>
                                                                 <h:inputTextarea id="txtPartiesTypeRemark" value="#{semmsi002Bean.siteAppObjParam.partiesTypeRemark}" style="width:80%;" cols="20" rows="3" rendered="#{semmsi002Bean.siteAppObjParam.partiesType == '99'}"/>
                                                            </td>
                                                         </tr>
			                                            </table>
			                                        </h:panelGroup>
			                                        
			                                        <!-- panel right -->
			                                        <h:panelGroup id="msi002_right" style="width:auto; height:100%; vertical-align:top;">
			                                        	<a4j:outputPanel id="msa002tab5_right_table">
			                                           
			                                        	<h:outputText value="#{jspMsg['label.doclist']}" styleClass="ms7" style="text-decoration:underline;" />  
			                                            
			                                            <rich:dataTable width="750px;" id="right_table" cellpadding="0" cellspacing="0" border="0"
                                                        var="item_" value="#{semmsi002Bean.legalDocList}" reRender="dstLegalApproveSrchByAppv" 
								                        style="background:none;border-style:none;"> 
								                            
								                            <rich:column id="itemNumber" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
                                                                <div align="center">
                                                                    <h:inputHidden  value="#{item_.dataObj.itemCode}" />
                                                                    <h:outputText value="#{item_.dataObj.itemNumber}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
                                                            <rich:column id="itemDesc" style="background:none;border-style:none;" width="300px;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
                                                                <div align="left">
                                                                    <h:outputText value="#{item_.dataObj.itemDesc}" styleClass="ms7" />
                                                                </div>
                                                            </rich:column>
								                            <rich:column id="chkHaveFlag" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
								                                <div align="center" style="background:none;border-style:none;">
								                                    <h:selectBooleanCheckbox id="msa002tab5_chkHaveFlag" value="#{item_.dataObj.chkHaveFlag}" >
								                                       <a4j:support event="onclick" action="#{semmsi002Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
                                                                            <f:param name="checkBoxStatus" value="Y"></f:param>
                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                       </a4j:support>
                                                                    </h:selectBooleanCheckbox>
								                                    <h:outputText value="#{jspMsg['label.th_have']}" style="padding-right:10px;" styleClass="ms7" />
								                                    
								                                    <h:selectBooleanCheckbox id="msa002tab5_chkNotHaveFlag" value="#{item_.dataObj.chkNotHaveFlag}">
                                                                       <a4j:support event="onclick" action="#{semmsi002Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
                                                                            <f:param name="checkBoxStatus" value="N"></f:param>
                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
                                                                       </a4j:support>         
                                                                    </h:selectBooleanCheckbox>
								                                    <h:outputText value="#{jspMsg['label.th_notHave']}" styleClass="ms7" />
								                                </div>
								                            </rich:column>
								                            
								                            <rich:columnGroup rendered="#{item_.dataObj.licenseDocument eq 'Y'}">
								                            	<rich:column colspan="3" style="border:0px;">
								                            		 <h:outputText value="#{jspMsg['label.th_legalDoc']}.." rendered="false"
                                                                    	style="padding-right:5px;" styleClass="ms7" />
                                                                    	
                                                                    <h:inputText value="#{item_.dataObj.itemDocAmount}" rendered="false"
	                                                                    onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
	                                                                    style="width:30px;" styleClass="ms7" />
                                                                        
                                                                    <h:outputText value="#{jspMsg['label.th_specify']}.." rendered="#{item_.dataObj.itemDispRemark == 'Y'}"
                                                                    	style="padding-right:5px;" styleClass="ms7" />
                                                                    
                                                                    <h:inputTextarea id="txtTypeRemark" value="#{item_.dataObj.itemRemark}" styleClass="ms7" 
                                                                        style="width:80%;" cols="60" rows="3" rendered="#{item_.dataObj.itemDispRemark == 'Y'}"/>
								                            	</rich:column>
								                            </rich:columnGroup>
								                        </rich:dataTable>
			                                            
			                                            </a4j:outputPanel>
			                                            
			                                            
			                                            <a4j:outputPanel id="msi002_right_oth_table">
			                                           
			                                        		<h:outputText value="#{jspMsg['label.docOthlist']}" styleClass="ms7" style="text-decoration:underline;" />  
			                                            
				                                            <rich:dataTable width="750px;" id="right_oth_table" cellpadding="0" cellspacing="0" border="0"
	                                                        var="item_" value="#{semmsi002Bean.legalDocList}" reRender="dstLegalApproveSrchByAppv" 
									                        style="background:none;border-style:none;"> 
									                            
									                            <rich:column id="itemNumberOth" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
	                                                                <div align="center">
	                                                                    <h:inputHidden  value="#{item_.dataObj.itemCode}" />
	                                                                    <h:outputText value="#{item_.dataObj.itemNumber}" styleClass="ms7" />
	                                                                </div>
	                                                            </rich:column>
	                                                            <rich:column id="itemDescOth" style="background:none;border-style:none;" width="300px;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
	                                                                <div align="left">
	                                                                    <h:outputText value="#{item_.dataObj.itemDesc}" styleClass="ms7" />
	                                                                </div>
	                                                            </rich:column>
									                            <rich:column id="chkHaveFlagOth" style="background:none;border-style:none;" rendered="#{item_.dataObj.licenseDocument != 'Y'}">
									                                <div align="center" style="background:none;border-style:none;">
									                                    <h:selectBooleanCheckbox id="msa002tab5_chkHaveFlagOth" value="#{item_.dataObj.chkHaveFlag}" >
									                                       <a4j:support event="onclick" action="#{semmsi002Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
	                                                                            <f:param name="checkBoxStatus" value="Y"></f:param>
	                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
	                                                                       </a4j:support>
	                                                                    </h:selectBooleanCheckbox>
									                                    <h:outputText value="#{jspMsg['label.th_have']}" style="padding-right:10px;" styleClass="ms7" />
									                                    
									                                    <h:selectBooleanCheckbox id="msa002tab5_chkNotHaveFlagOth" value="#{item_.dataObj.chkNotHaveFlag}">
	                                                                       <a4j:support event="onclick" action="#{semmsi002Action.doChangeChkBoxLegalDoc}" reRender="msi002_right">
	                                                                            <f:param name="checkBoxStatus" value="N"></f:param>
	                                                                            <f:param name="itemCode" value="#{item_.dataObj.itemCode}"></f:param>
	                                                                       </a4j:support>         
	                                                                    </h:selectBooleanCheckbox>
									                                    <h:outputText value="#{jspMsg['label.th_notHave']}" styleClass="ms7" />
									                                </div>
									                            </rich:column>
									                            
									                            <rich:columnGroup rendered="#{item_.dataObj.licenseDocument != 'Y'}">
									                            	<rich:column colspan="3" style="border:0px;">
									                            		 <h:outputText value="#{jspMsg['label.th_legalDoc']}.." rendered="false"
	                                                                    	style="padding-right:5px;" styleClass="ms7" />
	                                                                    	
	                                                                    <h:inputText value="#{item_.dataObj.itemDocAmount}" rendered="false"
		                                                                    onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
		                                                                    style="width:30px;" styleClass="ms7" />
	                                                                        
	                                                                    <h:outputText value="#{jspMsg['label.th_specify']}.." rendered="#{item_.dataObj.itemDispRemark == 'Y'}"
	                                                                    	style="padding-right:5px;" styleClass="ms7" />
	                                                                    
	                                                                    <h:inputTextarea id="txtTypeRemarkOth" value="#{item_.dataObj.itemRemark}" styleClass="ms7" 
	                                                                        style="width:80%;" cols="60" rows="3" rendered="#{item_.dataObj.itemDispRemark == 'Y'}"/>
									                            	</rich:column>
									                            </rich:columnGroup>
									                        </rich:dataTable>
			                                            
			                                            </a4j:outputPanel>
			                                        </h:panelGroup>
			                                    </h:panelGrid>
			                                </td>
			                            </tr>        
                                    </table>
                                </h:panelGroup>     
                          </h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
				<rich:spacer height="10"></rich:spacer>
				<h:panelGrid width="90%">
				<rich:panel id="pnlLog">				
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtCreateBy" value="#{semmsi002Bean.legalApprove.createBy}" 
		                			readonly="true" disabled="true" />
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
									    value="#{semmsi002Bean.legalApprove.createDt}"
									    inputSize="20" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtUpdateBy" value="#{semmsi002Bean.legalApprove.updateBy}" 
		                			readonly="true" disabled="true" />
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
									    value="#{semmsi002Bean.legalApprove.updateDt}"
									    showWeeksBar="false" 
									    inputSize="20" 
									    cellWidth="20px" cellHeight="20px" 
									    buttonIcon="/images/hide-button.png"
									    buttonIconDisabled="/images/hide-button.png"
									    disabled="true" />
				                	</td>
				                	
			                	 </tr>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>	
				</h:panelGrid>		
			</a4j:form>	
			</h:panelGrid>
			</rich:panel>			
        </h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmsi002Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true"  
						  reRender="pnlCheckLegalApprove,pnlSearchLegalApproveResult,pnlRiskType,btnAdd,btnSave,btnClear,msi002_right" >
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI002-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI002" />
										<a4j:actionparam name="methodWithNavi" value="doDelete" />							
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>