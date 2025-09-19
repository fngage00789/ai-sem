<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.construction.semmcp001" var="jspMsg"/>
<script>
		renderChkBox();

		function findSelectedRentel(){
			for(var i =0;i<7;i++){
				var a = document.getElementById("incContent:frmContract:rbtRentType1:"+i);
				if(a.checked == true){
					return a;
				}
			}
			return null;
		}

		function renderChkBox(module,index){
			useChk = document.getElementById("incContent:frmContract:chkUse"+module+""+index);
			missChk = document.getElementById("incContent:frmContract:chkMiss"+module+""+index);
			if(useChk.checked == false){
				missChk.disabled = true;
			}else{
				missChk.disabled = false;
			}
			if(missChk.checked == true){
				useChk.disabled = true;
			}else{
				useChk.disabled = false;
			}
			checkUnSelect();
		}
		
		function renderChkBox(){
			var type = findSelectedRentel();
			var other = document.getElementById("incContent:frmContract:rbtRentType99:0");
			if(other.checked == false && type != null){
				var i = 0;
				do{	
					var useChk = document.getElementById("incContent:frmContract:chkUse"+type.value+""+i);
					var missChk = document.getElementById("incContent:frmContract:chkMiss"+type.value+""+i);
					if(useChk == null && missChk == null){
						break;
					}
					if(useChk.checked == false){
						missChk.disabled = true;
					}else{
						missChk.disabled = false;
					}
					if(missChk.checked == true){
						useChk.disabled = true;
					}else{
						useChk.disabled = false;
					}
					++i;
				}while(true);
			}else{
				var i = 0;
				do{
					var useChk = document.getElementById("incContent:frmContract:chkUse99"+i);
					var missChk = document.getElementById("incContent:frmContract:chkMiss99"+i);
					if(useChk == null && missChk == null){
						break;
					}
						if(useChk.checked == false){
							missChk.disabled = true;
						}else{
							missChk.disabled = false;
						}
						if(missChk.checked == true){
							useChk.disabled = true;
						}else{
							useChk.disabled = false;
						}
					++i;
				}while(true);
			}
			checkUnSelect();
		}

		function checkUnSelect(){
			var t = findSelectedRentel();
			var other = document.getElementById("incContent:frmContract:rbtRentType99:0");
			if(t != null){
				if(t.value == '01' ||t.value  == '05' ||t.value  == '06'){
					if(document.getElementById("incContent:frmContract:chkMiss"+t.value+"0").checked != true && 
					   document.getElementById("incContent:frmContract:chkMiss"+t.value+"3").checked != true &&
					   document.getElementById("incContent:frmContract:chkMiss"+t.value+"4").checked != true ){
					 document.getElementById("incContent:frmContract:chkUse"+t.value+"0").disabled = false;
					 document.getElementById("incContent:frmContract:chkUse"+t.value+"3").disabled = false;
					 document.getElementById("incContent:frmContract:chkUse"+t.value+"4").disabled = false;}
					 if(document.getElementById("incContent:frmContract:chkUse"+t.value+"0").checked == true){
						document.getElementById("incContent:frmContract:chkUse"+t.value+"3").disabled = true;
						document.getElementById("incContent:frmContract:chkUse"+t.value+"4").disabled = true;
					 }else{
						 if(document.getElementById("incContent:frmContract:chkUse"+t.value+"3").checked == true){
							 document.getElementById("incContent:frmContract:chkUse"+t.value+"0").disabled = true;
							 document.getElementById("incContent:frmContract:chkUse"+t.value+"4").disabled = true;
						 }else{
							 if(document.getElementById("incContent:frmContract:chkUse"+t.value+"4").checked == true){
								 document.getElementById("incContent:frmContract:chkUse"+t.value+"0").disabled = true;
								 document.getElementById("incContent:frmContract:chkUse"+t.value+"3").disabled = true;
							 }
						 }
				   }
				}
			}else{
				if(document.getElementById("incContent:frmContract:chkMiss"+other.value+"0").checked != true && 
				   document.getElementById("incContent:frmContract:chkMiss"+other.value+"3").checked != true &&
				   document.getElementById("incContent:frmContract:chkMiss"+other.value+"4").checked != true ){
					 document.getElementById("incContent:frmContract:chkUse"+other.value+"0").disabled = false;
					 document.getElementById("incContent:frmContract:chkUse"+other.value+"3").disabled = false;
					 document.getElementById("incContent:frmContract:chkUse"+other.value+"4").disabled = false;}
					 if(document.getElementById("incContent:frmContract:chkUse"+other.value+"0").checked == true){
						document.getElementById("incContent:frmContract:chkUse"+other.value+"3").disabled = true;
						document.getElementById("incContent:frmContract:chkUse"+other.value+"4").disabled = true;
					 }else{
						 if(document.getElementById("incContent:frmContract:chkUse"+other.value+"3").checked == true){
							 document.getElementById("incContent:frmContract:chkUse"+other.value+"0").disabled = true;
							 document.getElementById("incContent:frmContract:chkUse"+other.value+"4").disabled = true;
						 }else{
							 if(document.getElementById("incContent:frmContract:chkUse"+other.value+"4").checked == true){
								 document.getElementById("incContent:frmContract:chkUse"+other.value+"0").disabled = true;
								 document.getElementById("incContent:frmContract:chkUse"+other.value+"3").disabled = true;
							 }
						 }
					}
			}
		}
	</script>
	<rich:modalPanel id="popupDocContract" width="850" autosized="true" minWidth="220" moveable="true">
		<f:facet name="header">
				<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupDocContract" style="cursor:pointer"/>
					<rich:componentControl for="popupDocContract" attachTo="hidePopupDocContract" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
		<table width="100%" border="0">
			<a4j:form id="frmErrorPopupDocContract">
			<tr>
				<td>
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmcp001Bean.renderedMsgFormPopup}">
					 		<f:facet name="header">
	                        	<h:outputText value="Entered Data Status:"></h:outputText>
	                    	</f:facet>
				 			<f:facet name="errorMarker">
				 				 <h:graphicImage value="images/error.gif" />  
		                    </f:facet>
	                </rich:messages>
				</td>
			</tr>
			</a4j:form>
			</table>
		</h:panelGrid>
		<a4j:form id="popupDocContractFrm"> 
				<rich:panel id="pnlRentalType" >
			<f:facet name="header">
				<h:outputText value="#{jspMsg['header.panel.rentalType']}" />
			</f:facet>
				<h:panelGrid width="97%">
					<h:panelGroup>
						<table width="100%" border="1" cellspacing="0" cellpadding="0"> 
							<tr>
								<td width="40%" valign="top">
							 		<table width="100%">
								 		<tr>
									 		<td colspan="2">
										 		<h:selectOneRadio id="rbtRentType1"  value="#{semmcp001Bean.contractCheckDoc.rentalType}" layout="pageDirection" 
											 	 styleClass="ms7" rendered="true" disabled="true">
							                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.rentalType01']}" />
							                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.rentalType02']}" />
							                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.rentalType03']}" />
							                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.rentalType04']}" />
							                				<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.rentalType05']}" />
							                				<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.rentalType06']}" />
							                				<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.rentalType07']}" />
					                			</h:selectOneRadio>
									 		</td>
								 		</tr>
								 		<tr>
									 		<td>
										 		<h:selectOneRadio id="rbtRentType99"  value="#{semmcp001Bean.rentalType99}"  
											 	 styleClass="ms7" rendered="true" onclick="rentTypeShow99();"  disabled="true">
							                				<f:selectItem itemValue="99" itemLabel="#{jspMsg['label.rentalType99']}" />
					                			</h:selectOneRadio>
									 		</td>
									 		<td>
									 			<h:inputText id="txtRentTypeOtherRemark" value="#{semmcp001Bean.contractCheckDoc.rentalTypeOtherRemark}" disabled="true" size="30"/>
									 		</td>
								 		</tr>
							 		</table>
								</td>
								<td width="60%" valign="top">
											<h:panelGroup id="pnlRentalType1" rendered="#{semmcp001Bean.renderChk1}">
												<table width="100%">
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType01']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc11']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse010" value="#{semmcp001Bean.chkDoc111}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss010" value="#{semmcp001Bean.chkDoc112}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse011" value="#{semmcp001Bean.chkDoc121}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss011" value="#{semmcp001Bean.chkDoc122}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse012" value="#{semmcp001Bean.chkDoc131}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss012" value="#{semmcp001Bean.chkDoc132}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse013" value="#{semmcp001Bean.chkDoc141}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss013" value="#{semmcp001Bean.chkDoc142}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse014" value="#{semmcp001Bean.chkDoc151}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss014" value="#{semmcp001Bean.chkDoc152}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse015" value="#{semmcp001Bean.chkDoc161}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss015" value="#{semmcp001Bean.chkDoc162}" styleClass="ms7"  disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse016" value="#{semmcp001Bean.chkDoc171}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss016" value="#{semmcp001Bean.chkDoc172}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse017" value="#{semmcp001Bean.chkDoc181}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss017" value="#{semmcp001Bean.chkDoc182}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark1}" size="30" disabled="true"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse018" value="#{semmcp001Bean.chkDoc191}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss018" value="#{semmcp001Bean.chkDoc192}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType2" rendered="#{semmcp001Bean.renderChk2}">
												<table width="100%" >
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType02']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc21']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse020" value="#{semmcp001Bean.chkDoc211}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss020" value="#{semmcp001Bean.chkDoc212}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc22']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse021" value="#{semmcp001Bean.chkDoc221}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss021" value="#{semmcp001Bean.chkDoc222}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc23']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse022" value="#{semmcp001Bean.chkDoc231}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss022" value="#{semmcp001Bean.chkDoc232}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse023" value="#{semmcp001Bean.chkDoc241}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss023" value="#{semmcp001Bean.chkDoc242}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td colspan="3">
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case1']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case2']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case3']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case4']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse024" value="#{semmcp001Bean.chkDoc251}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss024" value="#{semmcp001Bean.chkDoc252}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse025" value="#{semmcp001Bean.chkDoc261}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss025" value="#{semmcp001Bean.chkDoc262}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse026" value="#{semmcp001Bean.chkDoc271}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss026" value="#{semmcp001Bean.chkDoc272}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark2}" size="30" disabled="true"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse027" value="#{semmcp001Bean.chkDoc281}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss027" value="#{semmcp001Bean.chkDoc282}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType3" rendered="#{semmcp001Bean.renderChk3}">
											<table width="100%">
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType03']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc31']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse030" value="#{semmcp001Bean.chkDoc311}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss030" value="#{semmcp001Bean.chkDoc312}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc32']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse031" value="#{semmcp001Bean.chkDoc321}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss031" value="#{semmcp001Bean.chkDoc322}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc33']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse032" value="#{semmcp001Bean.chkDoc331}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss032" value="#{semmcp001Bean.chkDoc332}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc34']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse033" value="#{semmcp001Bean.chkDoc341}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss033" value="#{semmcp001Bean.chkDoc342}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse034" value="#{semmcp001Bean.chkDoc351}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss034" value="#{semmcp001Bean.chkDoc352}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td colspan="3">
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case1']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case2']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case3']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case4']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse035" value="#{semmcp001Bean.chkDoc361}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss035" value="#{semmcp001Bean.chkDoc362}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse036" value="#{semmcp001Bean.chkDoc371}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss036" value="#{semmcp001Bean.chkDoc372}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse037" value="#{semmcp001Bean.chkDoc381}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss037" value="#{semmcp001Bean.chkDoc382}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark3}" size="30" disabled="true"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse038" value="#{semmcp001Bean.chkDoc391}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss038" value="#{semmcp001Bean.chkDoc392}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType4" rendered="#{semmcp001Bean.renderChk4}">
											<table width="100%" >
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType04']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc41']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse040" value="#{semmcp001Bean.chkDoc411}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss040" value="#{semmcp001Bean.chkDoc412}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc42']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse041" value="#{semmcp001Bean.chkDoc421}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss041" value="#{semmcp001Bean.chkDoc422}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc43']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse042" value="#{semmcp001Bean.chkDoc431}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss042" value="#{semmcp001Bean.chkDoc432}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc44']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse043" value="#{semmcp001Bean.chkDoc441}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss043" value="#{semmcp001Bean.chkDoc442}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc45']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse044" value="#{semmcp001Bean.chkDoc451}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss044" value="#{semmcp001Bean.chkDoc452}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc46']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse045" value="#{semmcp001Bean.chkDoc461}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss045" value="#{semmcp001Bean.chkDoc462}" styleClass="ms7"  disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse046" value="#{semmcp001Bean.chkDoc471}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss046" value="#{semmcp001Bean.chkDoc472}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse047" value="#{semmcp001Bean.chkDoc481}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss047" value="#{semmcp001Bean.chkDoc482}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse048" value="#{semmcp001Bean.chkDoc491}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss048" value="#{semmcp001Bean.chkDoc492}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.case5']}" styleClass="ms7"/>
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark4}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse049" value="#{semmcp001Bean.chkDoc4101}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss049" value="#{semmcp001Bean.chkDoc4102}" styleClass="ms7"  disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType5" rendered="#{semmcp001Bean.renderChk5}">
											<table width="100%" >
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType05']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc11']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse050" value="#{semmcp001Bean.chkDoc511}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss050" value="#{semmcp001Bean.chkDoc512}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse051" value="#{semmcp001Bean.chkDoc521}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss051" value="#{semmcp001Bean.chkDoc522}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse052" value="#{semmcp001Bean.chkDoc531}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss052" value="#{semmcp001Bean.chkDoc532}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse053" value="#{semmcp001Bean.chkDoc541}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss053" value="#{semmcp001Bean.chkDoc542}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse054" value="#{semmcp001Bean.chkDoc551}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss054" value="#{semmcp001Bean.chkDoc552}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse055" value="#{semmcp001Bean.chkDoc561}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss055" value="#{semmcp001Bean.chkDoc562}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse056" value="#{semmcp001Bean.chkDoc571}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss056" value="#{semmcp001Bean.chkDoc572}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse057" value="#{semmcp001Bean.chkDoc581}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss057" value="#{semmcp001Bean.chkDoc582}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark5}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse058" value="#{semmcp001Bean.chkDoc591}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss058" value="#{semmcp001Bean.chkDoc592}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType6" rendered="#{semmcp001Bean.renderChk6}">
											<table width="100%" >
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType06']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc11']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse060" value="#{semmcp001Bean.chkDoc611}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss060" value="#{semmcp001Bean.chkDoc612}" styleClass="ms7" disabled="true"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse061" value="#{semmcp001Bean.chkDoc621}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss061" value="#{semmcp001Bean.chkDoc622}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse062" value="#{semmcp001Bean.chkDoc631}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss062" value="#{semmcp001Bean.chkDoc632}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse063" value="#{semmcp001Bean.chkDoc641}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss063" value="#{semmcp001Bean.chkDoc642}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse064" value="#{semmcp001Bean.chkDoc651}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss064" value="#{semmcp001Bean.chkDoc652}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse065" value="#{semmcp001Bean.chkDoc661}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss065" value="#{semmcp001Bean.chkDoc662}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse066" value="#{semmcp001Bean.chkDoc671}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss066" value="#{semmcp001Bean.chkDoc672}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse067" value="#{semmcp001Bean.chkDoc681}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss067" value="#{semmcp001Bean.chkDoc682}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark6}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse068" value="#{semmcp001Bean.chkDoc691}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss068" value="#{semmcp001Bean.chkDoc692}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType7" rendered="#{semmcp001Bean.renderChk7}">
											<table width="100%" >
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.other']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc71']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse990" value="#{semmcp001Bean.chkDoc711}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss990" value="#{semmcp001Bean.chkDoc712}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc72']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse991" value="#{semmcp001Bean.chkDoc721}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss991" value="#{semmcp001Bean.chkDoc722}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc73']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse992" value="#{semmcp001Bean.chkDoc731}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss992" value="#{semmcp001Bean.chkDoc732}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc74']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse993" value="#{semmcp001Bean.chkDoc741}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss993" value="#{semmcp001Bean.chkDoc742}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc75']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse994" value="#{semmcp001Bean.chkDoc751}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss994" value="#{semmcp001Bean.chkDoc752}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc76']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse995" value="#{semmcp001Bean.chkDoc761}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss995" value="#{semmcp001Bean.chkDoc762}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse996" value="#{semmcp001Bean.chkDoc771}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss996" value="#{semmcp001Bean.chkDoc772}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td colspan="3">
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case1']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case2']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case3']}" styleClass="ms7" /><br/><br/>
												<rich:spacer width="25" /><h:outputText value="#{jspMsg['label.case4']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse997" value="#{semmcp001Bean.chkDoc781}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss997" value="#{semmcp001Bean.chkDoc782}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse998" value="#{semmcp001Bean.chkDoc791}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss998" value="#{semmcp001Bean.chkDoc792}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse999" value="#{semmcp001Bean.chkDoc7101}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss999" value="#{semmcp001Bean.chkDoc7102}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark7}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse9910" value="#{semmcp001Bean.chkDoc7111}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss9910" value="#{semmcp001Bean.chkDoc7112}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
												</h:panelGroup>	
												<h:panelGroup id="pnlRentalType8" rendered="#{semmcp001Bean.renderChk8}">
												<table width="100%">
												<tr>
												<td colspan="3">
												<h:outputText value="#{jspMsg['label.contractDoc']} #{jspMsg['label.rentalType07']}" styleClass="ms7" style="text-decoration:underline;"/>
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc81']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse070" value="#{semmcp001Bean.chkDoc811}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss070" value="#{semmcp001Bean.chkDoc812}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse071" value="#{semmcp001Bean.chkDoc821}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss071" value="#{semmcp001Bean.chkDoc822}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse072" value="#{semmcp001Bean.chkDoc831}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss072" value="#{semmcp001Bean.chkDoc832}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse073" value="#{semmcp001Bean.chkDoc841}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss073" value="#{semmcp001Bean.chkDoc842}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmcp001Bean.rentalOtherRemark8}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse074" value="#{semmcp001Bean.chkDoc851}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss074" value="#{semmcp001Bean.chkDoc852}" styleClass="ms7" disabled="true" />
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
		</a4j:form>
	</rich:modalPanel>