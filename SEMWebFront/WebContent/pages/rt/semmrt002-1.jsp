<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.rental.semmrt002" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
				
				 <rich:messages id="errHeaderMsg" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt002Bean.renderedMsgFormMiddle}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			
			</td></tr>
			</table>
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
							<table width="100%">
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmrt002Bean.rentalPaySearchSP.company}"
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmrt002Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmrt002Bean.rentalPaySearchSP.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['label.jobType']} :" styleClass="ms7"></h:outputText>
								</td>
								<td width="30%">
		                				<h:selectOneMenu id="ddlJobType" value="#{semmrt002Bean.rentalPaySearchSP.jobType}">
											<f:selectItems value="#{semmrt002Bean.jobTypeList}"/>
										</h:selectOneMenu>
				                </td>
								<td>
								</td>
							</tr>
							<tr>
									<td align="right" width="20%">
				                	<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>						
										<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlRegion" value="#{semmrt002Bean.rentalPaySearchSP.region}">
											<f:selectItems value="#{semmrt002Bean.regionList}"/>
										</h:selectOneMenu>		                										
				                	</td>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNo" value="#{semmrt002Bean.rentalPaySearchSP.contractNo}" 
		                			size="23" maxlength="20"/>
				                	</td>
		                		</tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtsiteName" value="#{semmrt002Bean.rentalPaySearchSP.siteName}"
		                			 size="30" maxlength="200"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
									
		                			</td>
		                			<td colspan="3" width="80%">
		                			<h:selectOneMenu id="ddlSiteType" value="#{semmrt002Bean.rentalPaySearchSP.siteType}">
											<f:selectItems value="#{semmrt002Bean.siteTypeList}"/>
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="picoSelect" value="#{semmrt002Bean.rentalPaySearchSP.chkPico}"/>
										<rich:spacer width="5"/>
										<h:outputText value="PICO" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldDueDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt002Bean.rentalPaySearchSP.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   label="#{jspMsg['column.header.dueDtFrom']}">
										</rich:calendar>	
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
									<rich:spacer width="5"/>
		                			 <rich:calendar id="cldDueDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmrt002Bean.rentalPaySearchSP.dueDtTo}" inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									 cellWidth="20px" cellHeight="20px"
									 oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
									 oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
									 label="#{jspMsg['column.header.dueDtTo']}"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputText value="#{jspMsg['label.periodNo']}" styleClass="ms7" rendered="false"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtperiodNo" value="#{semmrt002Bean.rentalPaySearchSP.periodNo}" size="3" maxlength="2" rendered="false"/>	
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.expensivtType']}" styleClass="ms7"/>
									
		                			</td>
		                			<td  width="25%">
		                				<h:selectOneMenu id="ddlExpenseType" value="#{semmrt002Bean.rentalPaySearchSP.expenseType}">
											<f:selectItems value="#{semmrt002Bean.rentalPayExpenseTypeList}"/>
										</h:selectOneMenu>
		                			</td>
		                			<td align="right">
		                				<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
		                				<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
		                			</td>
		                			<td>
		                				<h:inputText id="txtBatchNo" value="#{semmrt002Bean.rentalPaySearchSP.batchNo}"/>
		                			</td>
								</tr>
			                	 <tr>
			                	 <td align="right" width="25%">
			                	 <h:outputText value="#{jspMsg['lebal.vendorId']}" styleClass="ms7"/>
			                	 </td>
			                	 <td width="30%">
			                	 	<h:inputText id="txtvendorId" value="#{semmrt002Bean.rentalPaySearchSP.vendorId}" size="23" maxlength="20"/>
			                	 </td>
			                	  <td align="right" width="20%">
			                	  	<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
			                	  </td>
			                	  <td width="30%">
			                	  <h:inputText id="txtvendorName" value="#{semmrt002Bean.rentalPaySearchSP.vendorName}" size="30" maxlength="200"/>
			                	  </td>
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.bank']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	<h:selectOneMenu id="ddlPaymentMethod" value="#{semmrt002Bean.rentalPaySearchSP.paymentMethod}">
											<f:selectItems value="#{semmrt002Bean.paymentMethodList}"/>
										</h:selectOneMenu>
								 </td>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	 <h:selectOneMenu id="ddlPaymentType" value="#{semmrt002Bean.rentalPaySearchSP.paymentType}">
											<f:selectItems value="#{semmrt002Bean.paymentTypeList}"/>
										</h:selectOneMenu>
								 </td>
								 </tr>
								 <tr>
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.paymentDt']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	<rich:calendar id="cldPaymentDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmrt002Bean.rentalPaySearchSP.paymentDt}" inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
		                			  label="#{jspMsg['column.header.chqDt']}">
		            
		                			 </rich:calendar>
								 	
								 </td>	
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
								 </td>	
								 <td width="30%">
								 	<rich:calendar id="cldChqReceiveDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmrt002Bean.rentalPaySearchSP.chqReceiveDt}" inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
		                			 label="#{jspMsg['column.header.chqReceiveDt']}">
		                			</rich:calendar>
								 </td>						 
								 </tr>
			                	 <tr>
			                	  <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.siteStatus']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 <h:selectOneMenu id="ddlSiteStatus" value="#{semmrt002Bean.rentalPaySearchSP.siteStatus}">
											<f:selectItems value="#{semmrt002Bean.siteStatusList}"/>
										</h:selectOneMenu>
								 </td>	
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="ms7"/>
								 </td>	
								 <td width="30%">
								 <h:selectOneMenu id="ddlNetworkStatus" value="#{semmrt002Bean.rentalPaySearchSP.networkStatus}">
											<f:selectItems value="#{semmrt002Bean.networkStatusList}"/>
										</h:selectOneMenu>
								 </td>					
			                	 </tr>
			                	 <tr>
			                	  <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.paymentRequestDt']}" styleClass="ms7"/>
								 </td>
								 <td width="30%">
								 	<rich:calendar id="cldPaymentRequestDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmrt002Bean.rentalPaySearchSP.paymentRequestDt}" inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
		                			 label="#{jspMsg['column.header.paymentRequestDt']}">
		                			 
		                			 </rich:calendar>
								 </td>	
								 <td align="right" width="20%">
								 <h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
								 </td>	
								 <td width="30%">
								 <h:selectOneMenu id="ddlPaymentStatus" value="#{semmrt002Bean.rentalPaySearchSP.paymentStatus}">
											<f:selectItems value="#{semmrt002Bean.paymentStatusList}"/>
										</h:selectOneMenu>
								 </td>					
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" 
					 		 action="#{navAction.navi}" reRender="errHeaderMsg,dtbRentalPaySSrch,pnlSearchResult,pnlSearchCriteria,errorMsgMid,frmMid2Error,pnlInitSearchResult">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT002" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
					 		 action="#{navAction.navi}" reRender="errHeaderMsg,pnlSearchResult,pnlSearchCriteria,errorHeaderMsg,pnlInitSearchResult">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT002-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT002" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
				<h:panelGrid columns="3" id="grdAddNewCommand">
					
				</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="96%">
					<rich:panel id="pnlInitSearchResult">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
							 <!--<rich:messages id="errorMsgMid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt002Bean.renderedMsgFormMiddle}">
							 		<f:facet name="header">
			                        	<h:outputText value="Entered Data Status:"></h:outputText>
			                    	</f:facet>
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:messages>
						
						 -->
						 <div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt002Bean.msgDataNotFound}" rendered="#{semmrt002Bean.renderedMsgDataNotFound2}" />
						</div>
						 <rich:dataTable id="dtbRentalPaySSrch" cellpadding="1" cellspacing="0" border="0"
						    reRender="dstRentalPaySSrch" rows="5"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						    var="rentalPaySSP" value="#{semmrt002Bean.rentalPaySSearchSpList}">
							<rich:column  sortBy="#{rentalPaySSP.jobType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.jobType']}" style="width:72px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySSP.jobType}" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySSP.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySSP.company}" />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySSP.regionName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.regionName']}" style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySSP.regionName}"/>
								</div>
							</rich:column>	
							
							<rich:column  sortBy="#{rentalPaySSP.payTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paytotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.payTotal}"  />
								</div>
							</rich:column>			 	
							<rich:column  sortBy="#{rentalPaySSP.noPayTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.nonPayTotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.noPayTotal}" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySSP.grandTotal}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.grandTotal']}" style="width:36px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySSP.grandTotal}" />
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt002Bean.rentalPaySSearchSpList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPaySSrch"
											maxPages="#{semmrt002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentalPaySSrch" 
											style="background-color: #cccccc;"
											page="#{semmrt002Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
							</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 5130"/>
						</f:facet><!--
							 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt002Bean.renderedMsgFormMiddle}">
							 		<f:facet name="header">
			                        	<h:outputText value="Entered Data Status:"></h:outputText>
			                    	</f:facet>
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:messages>
						--><div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt002Bean.msgDataNotFound}" rendered="#{semmrt002Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbRentalPaySrch" cellpadding="1" cellspacing="0" border="0"
							var="rentalPaySP" value="#{semmrt002Bean.rentalPaySearchSPList}" reRender="dstRentalPaySrch" 
							rows="#{semmrt002Bean.rowPerPage}" rowClasses="cur" styleClass="contentform">
							<a4j:support event="onRowClick"   action="#{semmrt002Action.getRowIdOnClick}" reRender="dtbRentalPaySrch">
								<a4j:actionparam name="rowId" value="#{rentalPaySP.rowId}" />
							</a4j:support>
							<rich:column  sortBy="#{rentalPaySP.contractNo}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{rentalPaySP.contractNo}" 
										oncomplete="showViewSiteInfoPopup()" immediate="true"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT002-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPaySP.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.oldContract}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" style="width: 100"/>
								</f:facet>
								<div align="center">
								<a4j:commandLink id="hypView2" value="#{rentalPaySP.oldContractNo}" 
										oncomplete="showViewSiteInfoPopup()" immediate="true"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT002-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPaySP.oldSiteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentalPaySP.siteName}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="center">
									
									<a4j:commandLink id="hypRentalPayPopup" value="#{rentalPaySP.siteName}" 
										oncomplete="#{rich:component('popupfrmRentalPay')}.show(); return false"
										action="#{navAction.navi}" reRender="frmRentPayPopup" immediate="false">
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="rentalPay-popup" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupRentalPay" />
										<a4j:actionparam name="methodWithNavi" value="initPopupRental" />
										<a4j:actionparam name="rowId" value="#{rentalPaySP.rowId}" />
									</a4j:commandLink>
										
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.efftDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}"   styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.efftThDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.expDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.expThDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.dueDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.dueThDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.periodNo}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.periodNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.expenseType}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.expenseType}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{rentalPaySP.vendorId}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.verdorId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.vendorId}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.vendorName}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPaySP.payeeName}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.payPeriodType}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.periodY}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodY']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.periodY}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.periodM}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodM']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.periodM}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.periodD}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodD']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.periodD}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.dueAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.dueAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.vatAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.whtRate}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.whtAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.chqAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.chqAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.siteStatus}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<div align="center">
									<h:outputText value="#{jspMsg['column.siteStatus']}" styleClass="contentform"  style="width:132px"/>
									</div>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPaySP.networkStatus}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.expStatus}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.expStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.expApprove}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expApprove']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.expApprove}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.paymentRequestDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentRequestDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.paymentRequestThDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.paymentStatus}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.paymentStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.paymentType}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.paymentType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.bankName}"styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.chqDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.chqThDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.chqReceiveDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.chqReceiveThDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.transferDt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPaySP.transferThDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.depositAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.depositAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.depositAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.pettyAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pettyAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.pettyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.totalAmt}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPaySP.totalAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.bankAccNo}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.remark}" styleClass="#{(semmrt002Bean.tmpRowId==rentalPaySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPaySP.doc68}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.doc68}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.doc92}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform"  style="width:120px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPaySP.doc92}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt002Bean.rentalPaySearchSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="33">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPaySrch"
											maxPages="#{semmrt002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentalPaySrch" 
											style="background-color: #cccccc;"
											page="#{semmrt002Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>					
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/popup/rentalPay-popup.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
