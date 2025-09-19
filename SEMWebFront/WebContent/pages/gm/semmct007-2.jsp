<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid width="100%">
	<rich:panel id="pnlLovMaster">
		<f:facet name="header">
			<h:outputText id="outTxtDisplayMode" value="บันทึกค่าคงที่ในระบบ - #{semmct007Bean.actModeDisplay}" />
		</f:facet>
		
		<h:panelGrid columnClasses="gridContent" width="90%"> 
			
			<a4j:form id="frmSave">
				<h:panelGrid width="100%">
				<h:panelGroup>
						<table width="100%" border="0">
						<tr>
						<td width="50%" align="left">
						<h:panelGrid>
							<table width="100%" border="0">
									<tr>
									<td width="50%" align="left">
									<rich:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												   rendered="#{semmct007Bean.renderedMsgFormTop}" 
												   style="width : 822px; height : 21px;">
											<f:facet name="errorMarker">
								 				 <h:graphicImage value="images/error.gif" />  
						                    </f:facet>
									</rich:messages>
									</td>
									<td width="50%" align="right" valign="bottom">
									</td>
									</tr>
							</table>
						</h:panelGrid>
						</td>
						<td width="50%" align="right" valign="bottom">
							<table id="tblButton">
							<tr>
							<td>
							<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent" >
		            		<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT007-1" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
							<a4j:actionparam name="methodWithNavi" value="doBackPage" />
							<a4j:actionparam name="mode" value="SELECT" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
				            action="#{navAction.navi}" reRender="oppContent,btnSave,pnlLovMaster" 
				            rendered="#{!semmct007Bean.viewMode}">
				            <a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT007-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
							<a4j:actionparam name="methodWithNavi" value="doSave" />
							<a4j:actionparam name="mode" value="#{semmct007Bean.mode}" />
							</a4j:commandButton>
			           		</td>
			           		<td>
			           		<a4j:commandButton id="btnNew"  styleClass="rich-button" 
				            action="#{navAction.navi}" value="New"  reRender="oppContent"
				            rendered="#{!semmct007Bean.viewMode}">
			            	<a4j:actionparam name="navModule" value="gm" />
							<a4j:actionparam name="navProgram" value="SEMMCT007-2" />
							<a4j:actionparam name="moduleWithNavi" value="gm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCT007" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="mode" value="INSERT" />
							<a4j:actionparam name="eventType" value="Add" />
							</a4j:commandButton>
			           		
			           		</td>
			           		</tr>
			           		</table>
		           		</td>
		           		</tr>
						</table>
					</h:panelGroup>
				
				<rich:panel id="panDataVendor">
							<f:facet name="header">
								<h:outputText value="ข้อมูล Vendor" />
							</f:facet>
						
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
									<h:panelGroup>
		                			<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="ประเภทค่าคงที่ :" styleClass="ms7" />
		                			</h:panelGroup>
		                			</td>
		                			<td colspan="3" width="75%">
		                			 <!-- ddlLovType -->
				                	 <h:selectOneMenu id="ddlLovType" value="#{semmct007Bean.lovMaster.lovType}" 
				                	 				  disabled="#{semmct007Bean.viewMode}" rendered="#{semmct007Bean.mode eq 'INSERT'}">
			                			<f:selectItems value="#{semmct007Bean.lovTypeSelList}"/>
			                		 </h:selectOneMenu>
			                		 <!-- txtLovType -->
			                		  <h:inputText id="txtLovType" value="#{semmct007Bean.txtLovTypeDisplay}" 
												 disabled="#{semmct007Bean.viewMode || semmct007Bean.mode eq 'UPDATE'}" 
												 rendered="#{semmct007Bean.mode eq 'UPDATE' || semmct007Bean.mode eq 'SELECT'}"
												 maxlength="50"></h:inputText>
				                	 </td>
			                	 </tr>
								
								<tr>
									<td align="right">
									<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif" />
		                			<rich:spacer width="5"></rich:spacer>
		                			<h:outputText value="รหัสค่าคงที่ :" styleClass="ms7" />
		                			</h:panelGroup>
		                			</td>
		                			<td colspan="3">
									<h:inputText id="txtLovCode" value="#{semmct007Bean.lovMaster.lovCode}" 
												 disabled="#{semmct007Bean.viewMode || semmct007Bean.mode eq 'UPDATE'}" 
												 maxlength="50"></h:inputText>
									</td>
								</tr>
								
								<tr>
									<td align="right" width="25%">
									<h:panelGroup>
			                		<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
			                		<h:outputText value="Name 1 :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%"><h:inputText id="txtName1" value="#{semmct007Bean.lovMaster.lovName}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="250"/></td>
									<td align="right" width="25%"><h:outputText value="Value 1 :" styleClass="ms7" /></td>
			                		<td width="25%"><h:inputText id="txtValue1" value="#{semmct007Bean.lovMaster.lovVal}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="50"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="25%">
									<h:panelGroup>
			                		<h:outputText value="Name 2 :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%"><h:inputText id="txtName2" value="#{semmct007Bean.lovMaster.lovName2}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="250"/></td>
									<td align="right" width="25%"><h:outputText value="Value 2 :" styleClass="ms7" /></td>
			                		<td width="25%"><h:inputText id="txtValue2" value="#{semmct007Bean.lovMaster.lovVal2}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="50"/></td>
			                	</tr>
			                	
			                	<tr>
									<td align="right" width="25%">
									<h:panelGroup>
			                		<h:outputText value="Name 3 :" styleClass="ms7" />
			                		</h:panelGroup>
			                		</td>
			                		<td width="25%"><h:inputText id="txtName3" value="#{semmct007Bean.lovMaster.lovName3}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="250"/></td>
									<td align="right" width="25%"><h:outputText value="Value 3 :" styleClass="ms7" /></td>
			                		<td width="25%"><h:inputText id="txtValue3" value="#{semmct007Bean.lovMaster.lovVal3}"
			                									 disabled="#{semmct007Bean.viewMode}" 
			                									 size="45" maxlength="50"/></td>
			                	</tr>
		                		
		                		<tr>
								<td align="right" valign="top">
		                		<h:outputText value="ลำดับที่ในการแสดงผล :" styleClass="ms7" />
		                		</td>
		                		<td><h:inputText id="txtOrderNo" value="#{semmct007Bean.lovMaster.lovOrder}" 
		                						 size="5" maxlength="5"
		                						 disabled="#{semmct007Bean.viewMode}" 
		                						 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                		</td>
		                		<td align="right" valign="top"></td>
		                		<td></td>
		                		</tr>
		                		
								<tr>
								<td align="right" valign="top"><h:outputText value="หมายเหตุ :" styleClass="ms7" /></td>
				                <td colspan="3"><h:inputTextarea id="txtRemark" value="#{semmct007Bean.lovMaster.remark}" 
				                								 rows="3" cols="72"
																 label="หมายเหตุ"
																 disabled="#{semmct007Bean.viewMode}"  >
		                							<f:validateLength maximum="500" ></f:validateLength>
		                						</h:inputTextarea>
		                		</td>
				                </tr>
				                
				                <tr>
									<td align="right">
									<!--<h:graphicImage value="images/icon_required.gif" />
			                		<rich:spacer width="5"></rich:spacer>
									--><h:outputText value="Record Status :" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3"> 
		                			
			                		<h:selectOneRadio id="rbtRecStatus" value="#{semmct007Bean.lovMaster.recordStatus}" styleClass="ms7"
			                						  disabled="#{semmct007Bean.viewMode}" >
										<f:selectItem itemLabel="ปรกติ" itemValue="Y" />
										<f:selectItem itemLabel="ยกเลิก"  itemValue="N" />
									</h:selectOneRadio>
		                			</td>
			                	 </tr>
		                	</table>
								</h:panelGroup>
							</h:panelGrid>
						
		            </rich:panel>
		            
		            
		            <rich:panel id="pnlLog">
					<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table width="100%">
		                	<tr>
								<td align="right" width="25%">
									<h:outputText value="ผู้บันทึก :" styleClass="ms7"/>
		               			</td><td width="25%">
		               				<h:inputText id="txtCreateBy" value="#{semmct007Bean.lovMaster.createBy}" disabled="true" />
			                	</td><td align="right" width="20%">
									<h:outputText value="วันที่บันทึก :" styleClass="ms7"/>
		               			</td><td width="30%">
		                			<rich:calendar id="cldCreateDate" locale="th" 
									datePattern="dd/MM/yyyy hh:mm:ss" 
								    value="#{semmct007Bean.lovMaster.createDt}"
								    inputSize="20" 
								    cellWidth="20px" cellHeight="20px" 
								    buttonIcon="/images/hide-button.png"
								    buttonIconDisabled="/images/hide-button.png"
								    disabled="true" />
								</td>
		                	 </tr><tr>
								<td align="right" width="25%">
									<h:outputText value="ผู้แก้ไข :" styleClass="ms7"/>
		               			</td><td width="25%">
		                			<h:inputText id="txtUpdateBy" value="#{semmct007Bean.lovMaster.updateBy}" disabled="true" />
			                	</td><td align="right" width="20%">
									<h:outputText value="วันที่แก้ไข :" styleClass="ms7"/>
		               			</td><td width="30%">
		                			<rich:calendar id="cldUpdateDate" locale="th" 
									datePattern="dd/MM/yyyy hh:mm:ss" 
								    value="#{semmct007Bean.lovMaster.updateDt}"
								    showWeeksBar="false" 
								    inputSize="20" 
								    cellWidth="20px" cellHeight="20px" 
								    buttonIcon="/images/hide-button.png"
								    buttonIconDisabled="/images/hide-button.png"
								    disabled="true" 
								    />
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
        <!-- pop up -->
        
        
</h:panelGrid>






