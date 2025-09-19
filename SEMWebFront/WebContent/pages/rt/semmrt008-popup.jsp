<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt008" var="jspMsg"/>
	<rich:modalPanel id="popupFrmRT008Save" width="600" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:outputFormat value="#{jspMsg['header.frmAdd']}">
				<f:param value="#{semmrt008Bean.actModeDisplay}"></f:param>
			</h:outputFormat>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpSave" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmRT008Save" attachTo="hidePopUpSave" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmRT008Save">
		<table width="100%" border="0">
		<tr><td></td>
		<td>
	    <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
	 		<f:facet name="header">
                <h:outputText value="Entered Data Status:"></h:outputText>
            </f:facet>
 			<f:facet name="errorMarker">
 				 <h:graphicImage value="images/error.gif" />  
            </f:facet>
        </rich:messages>
        </td></tr>
        </table>
		<!-- begin content layout criteria -->
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.save.detail']}"/>
		</f:facet>
		<!-- begin content criteria -->
		<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
			<h:panelGroup>
			<table border="0">
				<tr>
					<td align="right" width="20%">
					<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		            </td>
		            <td colspan="3" >
		            <!--
		            <h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlPopupCompanyBK" 
		            				 value="#{semmrt008Bean.pettyCash.company}" 
		            				 onchange="displayCompany();"
		            				 disabled="#{semmrt008Bean.mode ne 'INSERT'}"> 
						<f:selectItems value="#{semmrt008Bean.companyList}"/>
					</h:selectOneMenu>
					<a4j:jsFunction name="displayCompany" reRender="companyDisplay">
					</a4j:jsFunction>
					-->
					<a4j:region>
					<h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlPopupCompany" 
									 value="#{semmrt008Bean.pettyCash.company}" 
									 disabled="#{semmrt008Bean.mode ne 'INSERT'}">
		                		
								<f:selectItems value="#{semmrt008Bean.companyList}"/>
								<f:selectItem itemValue="AWN2" itemLabel="AWN2"/>
								<a4j:support event="onchange"  reRender="companyDisplay">
				                </a4j:support>
					</h:selectOneMenu>
					</a4j:region>
					<rich:spacer width="10"></rich:spacer>
					<h:outputText id="companyDisplay" value="#{semmrt008Bean.pettyCash.company}" styleClass="ms28"/>
		           </td>
             	</tr>
             	<tr>
	               	<td align="right">
	               	<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.getDate']}" styleClass="ms7"/>
	             	</td>
	             	<td colspan="3">
	            	<rich:calendar id="cldReceiveDt" locale="th" enableManualInput="true" 
							   datePattern="dd/MM/yyyy" 
							   value="#{semmrt008Bean.pettyCash.receiveDt}"
							   showWeeksBar="false" 
							   inputSize="13" 
							   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
							   oninputkeyup="this.value = this.value.substring(0, 10);"
							   cellWidth="20px" cellHeight="20px"
							   label="#{jspMsg['column.header.startDt']}"
							   disabled="#{semmrt008Bean.mode ne 'INSERT'}"
							   >
							  
					</rich:calendar> 
	               	</td>
	             </tr>
	             <tr>
	               	<td align="right" width="20%">
	               	<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.getTotalAmount']}" styleClass="ms7"/>
	             	</td>
	             	<td>
	            	<h:inputText id="txtGetTotalAmount" value="#{semmrt008Bean.pettyCash.pettyCashAmt}"  
		                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                		 onblur="return numberformat.moneyFormat(this);"
		                		 onfocus="return numberformat.setCursorPosToEnd(this);"
		                		 maxlength="16" 
		                		 styleClass="inputRight">
		            <a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" reRender="txtGetBalance">
				   		<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="getReceiveBalance" />
				     </a4j:support> 
					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					
		            </h:inputText>
	            	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
	               	</td>
	               	<td align="right" width="20%">
					<h:outputText value="#{jspMsg['label.balance']}" styleClass="ms7"/>
	             	</td>
	             	<td>
	            	<h:inputText id="txtGetBalance" value="#{semmrt008Bean.pettyCash.balanceAmt}" 
	            	styleClass="inputRight" size="16" disabled="true">
	            	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	            	
	            	</h:inputText>
	            	<rich:spacer width="5"></rich:spacer>
	            	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>  
	               	</td>
	             </tr>
	             
	             <tr>
					<td align="right" valign="top">
					<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
              		</td>
              		<td colspan="3">
              			<h:inputTextarea id="txtRemark" value="#{semmrt008Bean.pettyCash.remark}"
              							 rows="3" cols="80"></h:inputTextarea>
                	</td> 
                  </tr>
                  
                  <tr>
					<td align="right">
              		</td>
              		<td colspan="3">
              			<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
						action="#{navAction.navi}"  
						oncomplete="if(#{semmrt008Bean.popupClose == 'true'})#{rich:component('popupFrmRT008Save')}.hide();"
						reRender="dtbPettyCash,frmSearchResult,frmRT008Save,frmError">
						<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
						<a4j:actionparam name="mode" value="#{semmrt008Bean.mode}" />
						<a4j:actionparam name="eventType" value="Add" />
						</a4j:commandButton>
						<rich:spacer width="5"></rich:spacer>
						<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmRT008Save" operation="hide" event="onclick" />
						</a4j:commandButton>
                	</td> 
                  </tr>
			</table>
			</h:panelGroup>
		</h:panelGrid>
		<!-- end content criteria -->
		</a4j:form>
</rich:modalPanel>


<rich:modalPanel id="popupFrmRT008Clear" width="600" autosized="true" minWidth="220">

		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmClear']}"/></f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpClear" style="cursor:pointer"/>
				<rich:componentControl for="popupFrmRT008Clear" attachTo="hidePopUpClear" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmRT008Clear">
		<table width="100%" border="0">
		<tr><td></td>
		<td>
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
	 		<f:facet name="header">
                <h:outputText value="Entered Data Status:"></h:outputText>
            </f:facet>
 			<f:facet name="errorMarker">
 				 <h:graphicImage value="images/error.gif" />  
            </f:facet>
        </rich:messages>
        </td></tr>
		</table>
		<!-- begin content layout criteria -->
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.save.detail']}"/>
		</f:facet>
		<!-- begin content criteria -->
		<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
			<h:panelGroup>
			<table border="0">
				<tr>
					<td align="right" width="20%">
					<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		            </td>
		            <td colspan="3" >
		            <!--
		            <h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlPopupCompanyBK" 
		            				 value="#{semmrt008Bean.pettyCash.company}" 
		            				 onchange="displayCompanyClear();"
		            				 disabled="#{semmrt008Bean.mode ne 'INSERT'}"> 
						<f:selectItems value="#{semmrt008Bean.companyList}"/>
					</h:selectOneMenu>
					<a4j:jsFunction name="displayCompanyClear" reRender="companyDisplayClear">
					</a4j:jsFunction>
					-->
					<a4j:region>
					<h:selectOneMenu label="#{jspMsg['column.header.companyName']}" id="ddlPopupCompany" 
									 value="#{semmrt008Bean.pettyCash.company}" 
									 disabled="#{semmrt008Bean.mode ne 'INSERT'}">
		                		
								<f:selectItems value="#{semmrt008Bean.companyList}"/>
								<f:selectItem itemValue="AWN2" itemLabel="AWN2"/>
								<a4j:support event="onchange"  action="#{navAction.navi}" reRender="companyDisplayClear, frmRT008Clear">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
									<a4j:actionparam name="methodWithNavi" value="validateCompany" />
				                </a4j:support>
				                
					</h:selectOneMenu>
					</a4j:region>
					<rich:spacer width="10"></rich:spacer>
					<h:outputText id="companyDisplayClear" value="#{semmrt008Bean.pettyCash.company}" styleClass="ms28"/>
		           </td>
             	</tr>
             	
             	<tr>
	               	<td align="right" width="20%">
	               	<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="Ref. Batch Clear" styleClass="ms7"/>
	             	</td>
	             	<td>
	             	<a4j:region>
	            	<h:inputText id="txtRefClearBatch" value="#{semmrt008Bean.pettyCash.refClrBatchNo}"  
		                		 maxlength="20" 
		                		 disabled="#{semmrt008Bean.mode ne 'INSERT'}">
		                <a4j:support event="onblur" action="#{navAction.navi}" ajaxSingle="true" reRender="frmRT008Clear">
				   		<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="validateCompany" />
				     </a4j:support>   		 
		            </h:inputText>
		            </a4j:region>
	               	</td>
	               	<td align="right" width="20%">
					<h:graphicImage value="images/icon_required.gif"/>
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.clearDate']}" styleClass="ms7"/>
	             	</td>
	             	<td>
	            	 <rich:calendar id="cldClearDt" locale="th" enableManualInput="true" 
								    datePattern="dd/MM/yyyy" 
								    value="#{semmrt008Bean.pettyCash.clearDt}"
								    showWeeksBar="false" 
								    inputSize="13" 
								    oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								    oninputkeyup="this.value = this.value.substring(0, 10);"
								    cellWidth="20px" cellHeight="20px"
								    label="#{jspMsg['column.header.startDt']}"
								    >
					</rich:calendar> 
	               	</td>
	             </tr>
             	
	             <tr>
	               	<td align="right" width="20%">
	               	<!--<h:graphicImage value="images/icon_required.gif"/>-->
					<rich:spacer width="5"></rich:spacer>
					<h:outputText value="#{jspMsg['label.clearTotalAmount']}" styleClass="ms7"/>
	             	</td>
	             	<td>
	            	<h:inputText id="txtClearTotalAmount" value="#{semmrt008Bean.pettyCash.clearAmt}"  
	            				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                		 onblur="return numberformat.moneyFormat(this);"
		                		 onfocus="return numberformat.setCursorPosToEnd(this);"
		                		 maxlength="16" 
		                		 styleClass="inputRight" 
		                		 disabled="true"
		                		 >
		              <!-- 
		             <a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" reRender="txtClearBalance">
				   		<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="getClearBalance" />
				     </a4j:support>    -->		 
		            <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		            
		            </h:inputText>
	            	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
	               	</td>
	               	<td align="right" width="20%">
					<h:outputText value="#{jspMsg['label.balance']}" styleClass="ms7" />
	             	</td>
	             	<td>
	            	<h:inputText id="txtClearBalance" value="#{semmrt008Bean.pettyCash.balanceAmt}" 
	            	styleClass="inputRight" size="16" disabled="true">
	            	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	            	
	            	</h:inputText>
	            	<rich:spacer width="5"></rich:spacer>
	            	<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>  
	               	</td>
	             </tr>
	             
	             <tr>
					<td align="right" valign="top">
					<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
              		</td>
              		<td colspan="3">
              			<h:inputTextarea id="txtRemark" value="#{semmrt008Bean.pettyCash.remark}"
              							 rows="3" cols="80"></h:inputTextarea>
                	</td> 
                  </tr>
                  
                  <tr>
					<td align="right">
              		</td>
              		<td colspan="3">
              			<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
						action="#{navAction.navi}"  
						oncomplete="if(#{semmrt008Bean.popupClose == 'true'})#{rich:component('popupFrmRT008Clear')}.hide();"
						disabled="#{semmrt008Bean.disabledBtnSaveClear}"
						reRender="dtbPettyCash,frmSearchResult,frmRT008Clear,frmError">
						<a4j:actionparam name="navModule" value="rt" />
						<a4j:actionparam name="navProgram" value="SEMMRT008-1" />
						<a4j:actionparam name="moduleWithNavi" value="rt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMRT008" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
						<a4j:actionparam name="mode" value="#{semmrt008Bean.mode}" />
						<a4j:actionparam name="eventType" value="Clear" />
						</a4j:commandButton>
						<rich:spacer width="5"></rich:spacer>
						<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupFrmRT008Clear" operation="hide" event="onclick" />
						</a4j:commandButton>
                	</td> 
                  </tr>
			</table>
			</h:panelGroup>
		</h:panelGrid>
		<!-- end content criteria -->
		</a4j:form>
</rich:modalPanel>





		 
