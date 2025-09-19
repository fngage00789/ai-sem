<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid width="100%">

	<rich:panel id="pnlSiteInfo">
	<f:facet name="header">
	<h:outputText style="color:#000000;" id="txtHeader" value="#{jspMsg['tab.header']} #{semmsi004Bean.tabHeader}"/>
	</f:facet>
	<h:panelGrid>
	<a4j:form id="frmSiteInfoError">
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab1Bean.renderedMsgFormSearch}">
 		<f:facet name="header">
            	<h:outputText value="Entered Data Status:"></h:outputText>
        </f:facet>
		<f:facet name="errorMarker">
			 <h:graphicImage value="images/error.gif" />  
        </f:facet>
       </rich:messages>
	</a4j:form>
	</h:panelGrid>
	
	<h:panelGrid columnClasses="gridContent" width="93%">
			<a4j:form id="frmAddSiteInfo">
			<h:panelGroup id="pnlButton">
				<table width="100%">
				<tr>
				<td width="50%" align="left">
					
				</td>
				<td width="50%" align="right" valign="bottom">
					<table id="tblButton">
					<tr>
					<td>
	           		<a4j:commandButton id="btnBackSiteInfo" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent,frmSearchResult" rendered="#{semmsi004Bean.renderedBtnBackSiteInfo}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-1" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		<a4j:commandButton id="btnBackContract" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent" rendered="#{semmsi004Bean.renderedBtnBackContract}">
	           		<a4j:actionparam name="navModule" value="co" />
					<a4j:actionparam name="navProgram" value="SEMMCO001-2" />
					<a4j:actionparam name="moduleWithNavi" value="co" />
					<a4j:actionparam name="actionWithNavi" value="SEMMCO001"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		<a4j:commandButton id="btnBackContract02" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent" rendered="#{semmsi004Bean.renderedBtnBackInternalContract}">
	           		<a4j:actionparam name="navModule" value="co" />
					<a4j:actionparam name="navProgram" value="SEMMCO005-2" />
					<a4j:actionparam name="moduleWithNavi" value="co" />
					<a4j:actionparam name="actionWithNavi" value="SEMMCO005"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		<a4j:commandButton id="btnBackContract03" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="oppContent" rendered="#{semmsi004Bean.renderedBtnBackContractSubRent}">
	           		<a4j:actionparam name="navModule" value="co" />
					<a4j:actionparam name="navProgram" value="SEMMCO004-3" />
					<a4j:actionparam name="moduleWithNavi" value="co" />
					<a4j:actionparam name="actionWithNavi" value="SEMMCO004"/>
					<a4j:actionparam name="methodWithNavi" value="doClearSession" />
	           		</a4j:commandButton>
	           		</td>
					<td>
					<a4j:commandButton id="btnView" value="#{jspMsg['btn.view']}" styleClass="rich-button"
					oncomplete="showViewSiteInfoPopup()"
	           		action="#{navAction.navi}" style="width:100">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="common" />
					<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
					<a4j:actionparam name="methodWithNavi" value="initPopup" />
					<a4j:actionparam name="rowId" value="#{semmsi004Bean.siteInfoId}" />
	           		</a4j:commandButton>
	           		</td>
	           		<td>
	           		<a4j:commandButton id="btnApprove" value="Approve" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,btnApprove" style="width:70"
	           		rendered="#{semmsi004Bean.renderedBtnApprove}" disabled="#{semmsi004Bean.disabledBtnApprove}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
					<a4j:actionparam name="methodWithNavi" value="doApprove" />
	           		</a4j:commandButton>
	           		</td>
	           		<td>
	           		<a4j:commandButton id="btnCancelapprove" value="Cancel Approve" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,pnlSiteInfo" style="width:100"
	           		rendered="#{semmsi004Bean.renderedBtnCancelApprove}" disabled="#{semmsi004Bean.disabledBtnCancelApprove}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
					<a4j:actionparam name="methodWithNavi" value="doCancelApprove" />
	           		</a4j:commandButton>
	           		</td>
	           		<td>
	           		<a4j:commandButton id="btnAdd" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,txtOldContractNo" 
	           		rendered="#{semmsi004Bean.renderBtnSave}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
					<a4j:actionparam name="methodWithNavi" value="doUpdateTab" />
	           		</a4j:commandButton>
	           		</td>
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
				<!-- start panel tab -->
				<rich:tabPanel id="pnlTab" selectedTab="#{semmsi004Bean.selectedTab}"  switchType="client">
				<!-- tab1 -->
		        <rich:tab label="#{jspMsg['label.tab.site']}" id="tab1" onlabelclick="setTabNo1();" >
		        	<a4j:jsFunction name="setTabNo1" action="#{navAction.navi}"
		        	oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"
		        	reRender="pnlTab,txtHeader,pnlTab1,pnlSiteInfoContract,frmSiteInfoError,pnlButton,tblButton,pnlLog,mdpConfirmChangeTab">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        			<a4j:actionparam  name="tabNo" value="1"/>
		        	</a4j:jsFunction>
		        		<a4j:include id="incTab1" viewId="../../pages/si/semmsi004tab1.jsp" rendered="#{semmsi004Bean.selectedTab eq 'tab1'}"/>	
		        </rich:tab>
		        
		        <!-- tab2 -->
		        <rich:tab label="#{jspMsg['label.tab.contract']}" id="tab2" onlabelclick="setTabNo2();" >
		        <a4j:jsFunction name="setTabNo2" action="#{navAction.navi}"
		        oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"
		        	reRender="pnlTab,txtHeader,pnlTab2,pnlContract,pnlLessorName,dtbLessor,frmSiteInfoError,pnlButton,pnlBtnDepositNormal,pnlLog,mdpConfirmChangeTab">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        			<a4j:actionparam  name="tabNo" value="2"/>
		        	</a4j:jsFunction>
						<a4j:include id="incTab2" viewId="../../pages/si/semmsi004tab2.jsp" rendered="#{semmsi004Bean.selectedTab eq 'tab2'}" />	 
		        </rich:tab>
		        <!-- tab3 -->
		        <rich:tab label="#{jspMsg['label.tab.rentAndService']}" id="tab3" onlabelclick="setTabNo3();" >
		        <a4j:jsFunction name="setTabNo3" action="#{navAction.navi}"
		        oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"  
		        reRender="pnlTab,txtHeader,pnlRent, pnlRentCond,pnlRentDeposit,pnlSumRent,pnlRentCond,pnlResultSearchRentCond,frmSiteInfoError,pnlDeposit,pnlAddDeposit,pnlButton,pnlLog,mdpConfirmChangeTab">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        		<a4j:actionparam  name="tabNo" value="3"/>
		        </a4j:jsFunction>
		          	<a4j:include id="incTab3" viewId="../../pages/si/semmsi004tab3.jsp"  rendered="#{semmsi004Bean.selectedTab eq 'tab3'}"/>
		        </rich:tab>
		        <!-- tab4 -->
		         <rich:tab label="#{jspMsg['lable.tab.tax']}" id="tab4" onlabelclick="setTabNo4();">
		         <a4j:jsFunction name="setTabNo4" action="#{navAction.navi}" 
		         oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"  
		         reRender="pnlTab,txtHeader,pnlTab4,frmSiteInfoError,pnlButton,pnlLog,mdpConfirmChangeTab">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        		<a4j:actionparam  name="tabNo" value="4"/>
		        </a4j:jsFunction>
		          	 <a4j:include id="incTab4" viewId="../../pages/si/semmsi004tab4.jsp"  rendered="#{semmsi004Bean.selectedTab eq 'tab4'}"/>
		        </rich:tab>
		        <!-- tab5 -->
		         <rich:tab label="#{jspMsg['label.tab.electric']}" id="tab5" onlabelclick="setTabNo5();" >
		         <a4j:jsFunction name="setTabNo5" action="#{navAction.navi}"
		         oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"  
		         reRender="pnlTab,txtHeader,pnlTab5,frmSiteInfoError,pnlButton,tblButton,pnlDepositElectrricNormal,pnlLog,mdpConfirmChangeTab,pnlDepositElectric">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        		<a4j:actionparam  name="tabNo" value="5"/>
		        </a4j:jsFunction>
		            	<a4j:include id="incTab5" viewId="../../pages/si/semmsi004tab5.jsp"  rendered="#{semmsi004Bean.selectedTab eq 'tab5'}"/>
		        </rich:tab>
		        <!-- tab6 -->
		         <rich:tab label="#{jspMsg['label.tab.insurance']}" id="tab6" onlabelclick="setTabNo6();" >
		         <a4j:jsFunction name="setTabNo6" action="#{navAction.navi}"
		         oncomplete="if(#{semmsi004Bean.valueChange == 'true'})#{rich:component('mdpConfirmChangeTab')}.show();"  
		         reRender="pnlTab,txtHeader,pnlTab6,frmSiteInfoError,pnlButton,pnlLog,mdpConfirmChangeTab">
		        			<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="initChangeTab" />
		        		<a4j:actionparam  name="tabNo" value="6"/>
		        </a4j:jsFunction>
		            	<a4j:include id="incTab6" viewId="../../pages/si/semmsi004tab6.jsp"  rendered="#{semmsi004Bean.selectedTab eq 'tab6'}"/>
		        </rich:tab>
		        <!-- tab7 -->
		        
		    </rich:tabPanel>
			<!-- end panel tab -->
						<h:panelGrid  id="pnlLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
							<h:panelGroup rendered="#{semmsi004Bean.renderPanelLog}">
							<table width="100%">
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtCreateBy" value="#{semmsi004Bean.createBy}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldCreateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="#{semmsi004Bean.createDate}" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtUpdateBy" value="#{semmsi004Bean.updateBy}" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			  <rich:calendar id="cldUpdateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="#{semmsi004Bean.updateDate}" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					
			</a4j:form>
		</h:panelGrid>
		</rich:panel>
		<jsp:include page="../../pages/popup/sitelocation-popup.jsp" />
		<jsp:include page="../../pages/popup/sitecontract-popup.jsp" />
		<jsp:include page="../../pages/popup/closelySite-popup.jsp" />
		<jsp:include page="../../pages/si/semmsi004-4.jsp" />
		
</h:panelGrid>

<!-- Delete Location (tab1) -->
<rich:modalPanel id="mdpConfirmDelDialogLocation" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialogLocation">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmsi004tab1Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td>
					</tr>
					<tr>
					<td>
					<div align="center">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation" 
						rendered="#{semmsi004tab1Bean.modeDelPopup == 'DEL'}">
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteLocation" />							
							<rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick"  />
						</a4j:commandButton>		
						<rich:spacer width="5"></rich:spacer>	
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true"
						rendered="#{semmsi004tab1Bean.modeDelPopup == 'DEL'}">
						    <rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick" />
						</a4j:commandButton>									
						<a4j:commandButton value="OK" styleClass="rich-button" immediate="true" 
							rendered="#{semmsi004tab1Bean.modeDelPopup == 'ALERT'}">
						    <rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick" />
						</a4j:commandButton>	
						</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- Add Location (tab1) -->
<rich:modalPanel id="mdpConfirmAddDialogLocation" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Add"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmAddDialogLocation">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmsi004tab1Bean.confirmAddMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,
						pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doAddLocation" />	
							<a4j:actionparam name="flag" value="Y" />						
							<rich:componentControl for="mdpConfirmAddDialogLocation" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,
						pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doAddLocation" />
							<a4j:actionparam name="flag" value="N" />							
							<rich:componentControl for="mdpConfirmAddDialogLocation" operation="hide" event="onclick"  />
						</a4j:commandButton>	
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- Update Location (tab1) -->
<rich:modalPanel id="mdpConfirmUpdateDialogLocation" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Update"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmUpdateDialogLocation">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmsi004tab1Bean.confirmAddMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateLocation" />	
							<a4j:actionparam name="flag" value="Y" />						
							<rich:componentControl for="mdpConfirmUpdateDialogLocation" operation="hide" event="onclick"  />
						</a4j:commandButton>
						<a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateLocation" />
							<a4j:actionparam name="flag" value="N" />								
							<rich:componentControl for="mdpConfirmUpdateDialogLocation" operation="hide" event="onclick"  />
						</a4j:commandButton>													
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- Delete Lessor (tab2) -->
<rich:modalPanel id="mdpConfirmDelLessorDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelLessorDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlLessorName,dtbLessor, frmSiteInfoError, mdpConfirmDelLessorDialog" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteContractLessor" />							
							<rich:componentControl for="mdpConfirmDelLessorDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelLessorDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- delete RentCond (tab3)  -->
<rich:modalPanel id="mdpConfirmDelRentCondDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelRentCondDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlRentCond, dtbRentCond, mdpConfirmDelRentCondDialog,pnlSumRent,ddlRentDepositExpenseType" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteRentCond" />							
							<rich:componentControl for="mdpConfirmDelRentCondDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelRentCondDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<!-- delete deposit rent BG (tab3)  -->
<rich:modalPanel id="mdpConfirmDelDepositRentBgDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDepositRentBgDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlRentDeposit,dtbDepositRentBG, mdpConfirmDelDepositRentBgDialog,pnlDeposit,pnlTotalDepositRent,chkNoRentDeposit" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDepositNormal" />							
							<rich:componentControl for="mdpConfirmDelDepositRentBgDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDepositRentBgDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- delete deposit rent Cash (tab3)  -->
<rich:modalPanel id="mdpConfirmDelDepositRentCashDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDepositRentCashDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbDepositRentCash, frmSiteInfoError, mdpConfirmDelDepositRentCashDialog,pnlTotalDepositRent,chkNoRentDeposit" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDepositNormal" />							
							<rich:componentControl for="mdpConfirmDelDepositRentCashDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDepositRentCashDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- delete deposit electric BG (tab5)  -->
<rich:modalPanel id="mdpConfirmDelDepositElectricBgDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDepositElectricBgDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlDepositElectric, dtbDepositElectricBG,pnlAddDepositElectric, 
						mdpConfirmDelDepositElectricBgDialog,pnlResultDepositElectricNormal,pnlSumDepositElectric" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDepositElectricNormal" />							
							<rich:componentControl for="mdpConfirmDelDepositElectricBgDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDepositElectricBgDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- delete deposit electric Cash (tab5)  -->
<rich:modalPanel id="mdpConfirmDelDepositElectricCashDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDepositElectricCashDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbDepositElectricCash, frmSiteInfoError, mdpConfirmDelDepositElectricCashDialog,pnlResultDepositElectricNormal" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDepositElectricNormal" />							
							<rich:componentControl for="mdpConfirmDelDepositElectricCashDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDepositElectricCashDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
<!-- delete subRent (tab7)  -->
<rich:modalPanel id="mdpConfirmDelDialogSubRent" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDepositSubRentDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="dtbSubRent, pnlSubRentCriteria, mdpConfirmDelDialogSubRent" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB7" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteSubRent" />							
							<rich:componentControl for="mdpConfirmDelDialogSubRent" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialogSubRent" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<!-- copy old siteInfo (tab1)  -->
<rich:modalPanel id="mdpConfirmCopyOldSiteInfo" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy SiteInfo"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCopyOldSiteInfoDialog">
		<table width="270px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="270px">
						<h:outputText value="#{semmsi004tab1Bean.confirmCopyOldSiteInfo}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="pnlSiteInfo,frmAddSiteInfo" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
							<a4j:actionparam name="methodWithNavi" value="doCopyOldSiteInfo" />							
							<rich:componentControl for="mdpConfirmCopyOldSiteInfo" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCopyOldSiteInfo" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<!-- change tab  -->
<rich:modalPanel id="mdpConfirmChangeTab" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Change Tab"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmChangeTab">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="250px">
						<h:outputText value="#{semmsi004tab1Bean.confirmChangeTab}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<div align="center">
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004-2" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="setTabNo" />	
							<a4j:actionparam name="clickButton" value="Yes" />
							<a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" />							
							<rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick"  />
						</a4j:commandButton>
						<a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
						immediate="true" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004-2" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="setTabNo" />	
							<a4j:actionparam name="clickButton" value="No" />		
							<a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" />					
							<rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
						action="#{navAction.navi}" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError">
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI004-2" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
							<a4j:actionparam name="methodWithNavi" value="setTabNo" />	
							<a4j:actionparam name="clickButton" value="Cancel" />	
							<a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" />	
						    <rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick" />
						</a4j:commandButton>
						</h:panelGrid>
					</div>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
<a4j:include id="msi004-2_popCom" viewId="../../pages/si/semmsi004PopupCommon.jsp"/>
