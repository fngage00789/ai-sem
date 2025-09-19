<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
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
	<h:panelGrid columnClasses="gridContent" width="100%">
		 <h:panelGrid id="pnlTab3" width="95%">
		 <!-- panel contract TOT -->
				<rich:spacer height="10"></rich:spacer>
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
										 		<h:selectOneRadio id="rbtRentType1"  value="#{semmco005tab3Bean.contractCheckDoc.rentalType}" layout="pageDirection" 
											 	 styleClass="ms7" rendered="true" onclick="rentTypeShow();">
					         					<a4j:jsFunction name="rentTypeShow" action="#{semmco005tab3Action.doShowRentType}" oncomplete="renderChkBox();"
					         					reRender="pnlRentalType,pnlRentalType1,pnlRentalType2,pnlRentalType3,pnlRentalType4,pnlRentalType5,pnlRentalType6,pnlRentalType7,pnlRentalType8"/>
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
										 		<h:selectOneRadio id="rbtRentType99"  value="#{semmco005tab3Bean.rentalType99}"  
											 	 styleClass="ms7" rendered="true" onclick="rentTypeShow99();" >
					         					<a4j:jsFunction name="rentTypeShow99" action="#{semmco005tab3Action.doShowRentType99}" oncomplete="renderChkBox();"
					         					reRender="pnlRentalType,pnlRentalType1,pnlRentalType2,pnlRentalType3,pnlRentalType4,pnlRentalType5,pnlRentalType6,pnlRentalType7"/>
							                				<f:selectItem itemValue="99" itemLabel="#{jspMsg['label.rentalType99']}" />
					                			</h:selectOneRadio>
									 		</td>
									 		<td>
									 			<h:inputText id="txtRentTypeOtherRemark" value="#{semmco005tab3Bean.contractCheckDoc.rentalTypeOtherRemark}" size="30"/>
									 		</td>
								 		</tr>
							 		</table>
								</td>
								<td width="60%" valign="top">
											<h:panelGroup id="pnlRentalType1" rendered="#{semmco005tab3Bean.renderChk1}">
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
												<h:selectBooleanCheckbox id="chkUse010" value="#{semmco005tab3Bean.chkDoc111}" styleClass="ms7" onclick="renderChkBox(01,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss010" value="#{semmco005tab3Bean.chkDoc112}" styleClass="ms7" onclick="renderChkBox(01,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse011" value="#{semmco005tab3Bean.chkDoc121}" styleClass="ms7" onclick="renderChkBox(01,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss011" value="#{semmco005tab3Bean.chkDoc122}" styleClass="ms7" onclick="renderChkBox(01,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse012" value="#{semmco005tab3Bean.chkDoc131}" styleClass="ms7" onclick="renderChkBox(01,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss012" value="#{semmco005tab3Bean.chkDoc132}" styleClass="ms7" onclick="renderChkBox(01,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse013" value="#{semmco005tab3Bean.chkDoc141}" styleClass="ms7" onclick="renderChkBox(01,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss013" value="#{semmco005tab3Bean.chkDoc142}" styleClass="ms7" onclick="renderChkBox(01,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse014" value="#{semmco005tab3Bean.chkDoc151}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss014" value="#{semmco005tab3Bean.chkDoc152}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse015" value="#{semmco005tab3Bean.chkDoc161}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss015" value="#{semmco005tab3Bean.chkDoc162}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse016" value="#{semmco005tab3Bean.chkDoc171}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss016" value="#{semmco005tab3Bean.chkDoc172}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse017" value="#{semmco005tab3Bean.chkDoc181}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss017" value="#{semmco005tab3Bean.chkDoc182}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark1}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse018" value="#{semmco005tab3Bean.chkDoc191}" styleClass="ms7" onclick="renderChkBox(01,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss018" value="#{semmco005tab3Bean.chkDoc192}" styleClass="ms7" onclick="renderChkBox(01,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType2" rendered="#{semmco005tab3Bean.renderChk2}">
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
												<h:selectBooleanCheckbox id="chkUse020" value="#{semmco005tab3Bean.chkDoc211}" styleClass="ms7" onclick="renderChkBox(02,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss020" value="#{semmco005tab3Bean.chkDoc212}" styleClass="ms7" onclick="renderChkBox(02,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc22']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse021" value="#{semmco005tab3Bean.chkDoc221}" styleClass="ms7" onclick="renderChkBox(02,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss021" value="#{semmco005tab3Bean.chkDoc222}" styleClass="ms7" onclick="renderChkBox(02,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc23']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse022" value="#{semmco005tab3Bean.chkDoc231}" styleClass="ms7" onclick="renderChkBox(02,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss022" value="#{semmco005tab3Bean.chkDoc232}" styleClass="ms7" onclick="renderChkBox(02,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse023" value="#{semmco005tab3Bean.chkDoc241}" styleClass="ms7" onclick="renderChkBox(02,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss023" value="#{semmco005tab3Bean.chkDoc242}" styleClass="ms7" onclick="renderChkBox(02,3);"/>
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
												<h:selectBooleanCheckbox id="chkUse024" value="#{semmco005tab3Bean.chkDoc251}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss024" value="#{semmco005tab3Bean.chkDoc252}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse025" value="#{semmco005tab3Bean.chkDoc261}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss025" value="#{semmco005tab3Bean.chkDoc262}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse026" value="#{semmco005tab3Bean.chkDoc271}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss026" value="#{semmco005tab3Bean.chkDoc272}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark2}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse027" value="#{semmco005tab3Bean.chkDoc281}" styleClass="ms7" onclick="renderChkBox(02,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss027" value="#{semmco005tab3Bean.chkDoc282}" styleClass="ms7" onclick="renderChkBox(02,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType3" rendered="#{semmco005tab3Bean.renderChk3}">
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
												<h:selectBooleanCheckbox id="chkUse030" value="#{semmco005tab3Bean.chkDoc311}" styleClass="ms7" onclick="renderChkBox(03,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss030" value="#{semmco005tab3Bean.chkDoc312}" styleClass="ms7" onclick="renderChkBox(03,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc32']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse031" value="#{semmco005tab3Bean.chkDoc321}" styleClass="ms7" onclick="renderChkBox(03,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss031" value="#{semmco005tab3Bean.chkDoc322}" styleClass="ms7" onclick="renderChkBox(03,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc33']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse032" value="#{semmco005tab3Bean.chkDoc331}" styleClass="ms7" onclick="renderChkBox(03,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss032" value="#{semmco005tab3Bean.chkDoc332}" styleClass="ms7" onclick="renderChkBox(03,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc34']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse033" value="#{semmco005tab3Bean.chkDoc341}" styleClass="ms7" onclick="renderChkBox(03,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss033" value="#{semmco005tab3Bean.chkDoc342}" styleClass="ms7" onclick="renderChkBox(03,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse034" value="#{semmco005tab3Bean.chkDoc351}" styleClass="ms7" onclick="renderChkBox(03,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss034" value="#{semmco005tab3Bean.chkDoc352}" styleClass="ms7" onclick="renderChkBox(03,4);"/>
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
												<h:selectBooleanCheckbox id="chkUse035" value="#{semmco005tab3Bean.chkDoc361}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss035" value="#{semmco005tab3Bean.chkDoc362}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse036" value="#{semmco005tab3Bean.chkDoc371}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss036" value="#{semmco005tab3Bean.chkDoc372}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse037" value="#{semmco005tab3Bean.chkDoc381}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss037" value="#{semmco005tab3Bean.chkDoc382}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark3}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse038" value="#{semmco005tab3Bean.chkDoc391}" styleClass="ms7" onclick="renderChkBox(03,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss038" value="#{semmco005tab3Bean.chkDoc392}" styleClass="ms7" onclick="renderChkBox(03,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType4" rendered="#{semmco005tab3Bean.renderChk4}">
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
												<h:selectBooleanCheckbox id="chkUse040" value="#{semmco005tab3Bean.chkDoc411}" styleClass="ms7" onclick="renderChkBox(04,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss040" value="#{semmco005tab3Bean.chkDoc412}" styleClass="ms7" onclick="renderChkBox(04,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc42']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse041" value="#{semmco005tab3Bean.chkDoc421}" styleClass="ms7" onclick="renderChkBox(04,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss041" value="#{semmco005tab3Bean.chkDoc422}" styleClass="ms7" onclick="renderChkBox(04,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc43']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse042" value="#{semmco005tab3Bean.chkDoc431}" styleClass="ms7" onclick="renderChkBox(04,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss042" value="#{semmco005tab3Bean.chkDoc432}" styleClass="ms7" onclick="renderChkBox(04,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc44']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse043" value="#{semmco005tab3Bean.chkDoc441}" styleClass="ms7" onclick="renderChkBox(04,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss043" value="#{semmco005tab3Bean.chkDoc442}" styleClass="ms7" onclick="renderChkBox(04,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc45']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse044" value="#{semmco005tab3Bean.chkDoc451}" styleClass="ms7" onclick="renderChkBox(04,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss044" value="#{semmco005tab3Bean.chkDoc452}" styleClass="ms7" onclick="renderChkBox(04,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc46']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse045" value="#{semmco005tab3Bean.chkDoc461}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss045" value="#{semmco005tab3Bean.chkDoc462}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse046" value="#{semmco005tab3Bean.chkDoc471}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss046" value="#{semmco005tab3Bean.chkDoc472}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse047" value="#{semmco005tab3Bean.chkDoc481}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss047" value="#{semmco005tab3Bean.chkDoc482}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse048" value="#{semmco005tab3Bean.chkDoc491}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss048" value="#{semmco005tab3Bean.chkDoc492}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
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
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark4}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse049" value="#{semmco005tab3Bean.chkDoc4101}" styleClass="ms7" onclick="renderChkBox(04,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss049" value="#{semmco005tab3Bean.chkDoc4102}" styleClass="ms7" onclick="renderChkBox(04,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>
											
											<h:panelGroup id="pnlRentalType5" rendered="#{semmco005tab3Bean.renderChk5}">
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
												<h:selectBooleanCheckbox id="chkUse050" value="#{semmco005tab3Bean.chkDoc511}" styleClass="ms7" onclick="renderChkBox(05,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss050" value="#{semmco005tab3Bean.chkDoc512}" styleClass="ms7" onclick="renderChkBox(05,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse051" value="#{semmco005tab3Bean.chkDoc521}" styleClass="ms7" onclick="renderChkBox(05,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss051" value="#{semmco005tab3Bean.chkDoc522}" styleClass="ms7" onclick="renderChkBox(05,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse052" value="#{semmco005tab3Bean.chkDoc531}" styleClass="ms7" onclick="renderChkBox(05,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss052" value="#{semmco005tab3Bean.chkDoc532}" styleClass="ms7" onclick="renderChkBox(05,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse053" value="#{semmco005tab3Bean.chkDoc541}" styleClass="ms7" onclick="renderChkBox(05,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss053" value="#{semmco005tab3Bean.chkDoc542}" styleClass="ms7" onclick="renderChkBox(05,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse054" value="#{semmco005tab3Bean.chkDoc551}" styleClass="ms7" onclick="renderChkBox(05,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss054" value="#{semmco005tab3Bean.chkDoc552}" styleClass="ms7" onclick="renderChkBox(05,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse055" value="#{semmco005tab3Bean.chkDoc561}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss055" value="#{semmco005tab3Bean.chkDoc562}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse056" value="#{semmco005tab3Bean.chkDoc571}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss056" value="#{semmco005tab3Bean.chkDoc572}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse057" value="#{semmco005tab3Bean.chkDoc581}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss057" value="#{semmco005tab3Bean.chkDoc582}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark5}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse058" value="#{semmco005tab3Bean.chkDoc591}" styleClass="ms7" onclick="renderChkBox(05,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss058" value="#{semmco005tab3Bean.chkDoc592}" styleClass="ms7" onclick="renderChkBox(05,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType6" rendered="#{semmco005tab3Bean.renderChk6}">
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
												<h:selectBooleanCheckbox id="chkUse060" value="#{semmco005tab3Bean.chkDoc611}" styleClass="ms7" onclick="renderChkBox(06,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss060" value="#{semmco005tab3Bean.chkDoc612}" styleClass="ms7" onclick="renderChkBox(06,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc12']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse061" value="#{semmco005tab3Bean.chkDoc621}" styleClass="ms7" onclick="renderChkBox(06,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss061" value="#{semmco005tab3Bean.chkDoc622}" styleClass="ms7" onclick="renderChkBox(06,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc13']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse062" value="#{semmco005tab3Bean.chkDoc631}" styleClass="ms7" onclick="renderChkBox(06,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss062" value="#{semmco005tab3Bean.chkDoc632}" styleClass="ms7" onclick="renderChkBox(06,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc14']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse063" value="#{semmco005tab3Bean.chkDoc641}" styleClass="ms7" onclick="renderChkBox(06,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss063" value="#{semmco005tab3Bean.chkDoc642}" styleClass="ms7" onclick="renderChkBox(06,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc15']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse064" value="#{semmco005tab3Bean.chkDoc651}" styleClass="ms7" onclick="renderChkBox(06,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss064" value="#{semmco005tab3Bean.chkDoc652}" styleClass="ms7" onclick="renderChkBox(06,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse065" value="#{semmco005tab3Bean.chkDoc661}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss065" value="#{semmco005tab3Bean.chkDoc662}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse066" value="#{semmco005tab3Bean.chkDoc671}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss066" value="#{semmco005tab3Bean.chkDoc672}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse067" value="#{semmco005tab3Bean.chkDoc681}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss067" value="#{semmco005tab3Bean.chkDoc682}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark6}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse068" value="#{semmco005tab3Bean.chkDoc691}" styleClass="ms7" onclick="renderChkBox(06,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss068" value="#{semmco005tab3Bean.chkDoc692}" styleClass="ms7" onclick="renderChkBox(06,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
											</h:panelGroup>	
											
											<h:panelGroup id="pnlRentalType7" rendered="#{semmco005tab3Bean.renderChk7}">
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
												<h:selectBooleanCheckbox id="chkUse990" value="#{semmco005tab3Bean.chkDoc711}" styleClass="ms7" onclick="renderChkBox(99,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss990" value="#{semmco005tab3Bean.chkDoc712}" styleClass="ms7" onclick="renderChkBox(99,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc72']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse991" value="#{semmco005tab3Bean.chkDoc721}" styleClass="ms7" onclick="renderChkBox(99,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss991" value="#{semmco005tab3Bean.chkDoc722}" styleClass="ms7" onclick="renderChkBox(99,1);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc73']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse992" value="#{semmco005tab3Bean.chkDoc731}" styleClass="ms7" onclick="renderChkBox(99,2);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss992" value="#{semmco005tab3Bean.chkDoc732}" styleClass="ms7" onclick="renderChkBox(99,2);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc74']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse993" value="#{semmco005tab3Bean.chkDoc741}" styleClass="ms7" onclick="renderChkBox(99,3);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss993" value="#{semmco005tab3Bean.chkDoc742}" styleClass="ms7" onclick="renderChkBox(99,3);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc75']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse994" value="#{semmco005tab3Bean.chkDoc751}" styleClass="ms7" onclick="renderChkBox(99,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss994" value="#{semmco005tab3Bean.chkDoc752}" styleClass="ms7" onclick="renderChkBox(99,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc76']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse995" value="#{semmco005tab3Bean.chkDoc761}" styleClass="ms7" onclick="renderChkBox(99,5);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss995" value="#{semmco005tab3Bean.chkDoc762}" styleClass="ms7" onclick="renderChkBox(99,5);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.doc24']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse996" value="#{semmco005tab3Bean.chkDoc771}" styleClass="ms7" onclick="renderChkBox(99,6);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss996" value="#{semmco005tab3Bean.chkDoc772}" styleClass="ms7" onclick="renderChkBox(099,6);"/>
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
												<h:selectBooleanCheckbox id="chkUse997" value="#{semmco005tab3Bean.chkDoc781}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss997" value="#{semmco005tab3Bean.chkDoc782}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse998" value="#{semmco005tab3Bean.chkDoc791}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss998" value="#{semmco005tab3Bean.chkDoc792}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse999" value="#{semmco005tab3Bean.chkDoc7101}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss999" value="#{semmco005tab3Bean.chkDoc7102}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark7}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse9910" value="#{semmco005tab3Bean.chkDoc7111}" styleClass="ms7" onclick="renderChkBox(99,7);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss9910" value="#{semmco005tab3Bean.chkDoc7112}" styleClass="ms7" onclick="renderChkBox(99,7);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												</table>
												</h:panelGroup>	
												<h:panelGroup id="pnlRentalType8" rendered="#{semmco005tab3Bean.renderChk8}">
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
												<h:selectBooleanCheckbox id="chkUse070" value="#{semmco005tab3Bean.chkDoc811}" styleClass="ms7" onclick="renderChkBox(07,0);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss070" value="#{semmco005tab3Bean.chkDoc812}" styleClass="ms7" onclick="renderChkBox(07,0);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX1']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse071" value="#{semmco005tab3Bean.chkDoc821}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss071" value="#{semmco005tab3Bean.chkDoc822}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX2']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse072" value="#{semmco005tab3Bean.chkDoc831}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss072" value="#{semmco005tab3Bean.chkDoc832}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.docX3']}" styleClass="ms7"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse073" value="#{semmco005tab3Bean.chkDoc841}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss073" value="#{semmco005tab3Bean.chkDoc842}" styleClass="ms7" onclick="renderChkBox(01,4);"/>
				                				<h:outputText value="#{jspMsg['label.miss']}" styleClass="ms7" />
												</td>
												</tr>
												
												<tr>
												<td width="80%" align="left">
												<h:outputText value="#{jspMsg['label.other']}" styleClass="ms7"/>
												<rich:spacer width="5"></rich:spacer>
												<h:inputText value="#{semmco005tab3Bean.rentalOtherRemark8}" size="30"/>
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkUse074" value="#{semmco005tab3Bean.chkDoc851}" styleClass="ms7" onclick="renderChkBox(07,1);"/>
				                				<h:outputText value="#{jspMsg['label.use']}" styleClass="ms7" />
												</td>
												<td width="10%">
												<h:selectBooleanCheckbox id="chkMiss074" value="#{semmco005tab3Bean.chkDoc852}" styleClass="ms7" onclick="renderChkBox(07,1);"/>
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
	</h:panelGrid>
</h:panelGrid>
