<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=5" /> 
<title>Site Expense Management.</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="js/common.js"></script>
<script type="text/javascript" language="javascript" src="js/js_clock.js"></script>
<script type="text/javascript" language="javascript" src="js/js_validation.js"></script>

<!-- jQuery -->
<script type="text/javascript" language="javascript" src="js/jquery-latest.js"></script>
<script type="text/javascript" language="javascript" src="js/js_sso.js"></script>

<!-- auto scroll bar -->
<script type="text/javascript" language="javascript" src="js/js_cal_scrollbar.js"></script>

<script type="text/javascript">
	function onTopPage(){		
	    window.location.href="javascript:scroll(0,101)";
	}

	var BrowserDetect = {
			init: function () {
				this.browser = this.searchString(this.dataBrowser) || "An unknown browser";
				this.version = this.searchVersion(navigator.userAgent)
				|| this.searchVersion(navigator.appVersion)
				|| "an unknown version";
				this.OS = this.searchString(this.dataOS) || "an unknown OS";
				},
				searchString: function (data) {
					for (var i=0;i<data.length;i++) {
					var dataString = data[i].string;
					var dataProp = data[i].prop;
					this.versionSearchString = data[i].versionSearch || data[i].identity;
					if (dataString) {
						if (dataString.indexOf(data[i].subString) != -1)
							return data[i].identity;
					}
					else if (dataProp)
						return data[i].identity;
					}
				},
				searchVersion: function (dataString) {
					var index = dataString.indexOf(this.versionSearchString);
					if (index == -1) return;
					return parseFloat(dataString.substring(index+this.versionSearchString.length+1));
				},
				dataBrowser: [
				{
					string: navigator.userAgent,
					subString: "Chrome",
					identity: "Chrome"
				},
				{ string: navigator.userAgent,
					subString: "OmniWeb",
					versionSearch: "OmniWeb/",
					identity: "OmniWeb"
				},
				{
					string: navigator.vendor,
					subString: "Apple",
					identity: "Safari",
					versionSearch: "Version"
				},
				{
					prop: window.opera,
					identity: "Opera"
				},
				{
					string: navigator.vendor,
					subString: "iCab",
					identity: "iCab"
				},
				{
					string: navigator.vendor,
					subString: "KDE",
					identity: "Konqueror"
				},
				{
					string: navigator.userAgent,
					subString: "Firefox",
					identity: "Firefox"
				},
				{
					string: navigator.vendor,
					subString: "Camino",
					identity: "Camino"
				},
				{ // for newer Netscapes (6+)
					string: navigator.userAgent,
					subString: "Netscape",
					identity: "Netscape"
				},
				{
					string: navigator.userAgent,
					subString: "MSIE",
					identity: "Explorer",
					versionSearch: "MSIE"
				},
				{
					string: navigator.userAgent,
					subString: "Gecko",
					identity: "Mozilla",
					versionSearch: "rv"
				},
				{ // for older Netscapes (4-)
					string: navigator.userAgent,
					subString: "Mozilla",
					identity: "Netscape",
					versionSearch: "Mozilla"
				}
				],
				dataOS : [
				{
					string: navigator.platform,
					subString: "Win",
					identity: "Windows"
				},
				{
					string: navigator.platform,
					subString: "Mac",
					identity: "Mac"
				},
				{
					string: navigator.userAgent,
					subString: "iPhone",
					identity: "iPhone/iPod"
				},
				{
					string: navigator.platform,
					subString: "Linux",
					identity: "Linux"
				}
				]
				
			};

			BrowserDetect.init();
			window.onbeforeunload = confirmExit;

			function confirmExit(event){
				//alert(BrowserDetect.browser + "/" + BrowserDetect.version);
				if (BrowserDetect.browser=='Explorer' && BrowserDetect.version==8) {
					//alert(window.event.clientY)
					if (window.event.clientY < 0) { 
						//browser is closed
						window.location.href = '/SEMWebFront/SSOLoginServlet?flag=decreaseCounter';
					} else{
						//refresh
						
					}
				} else if (BrowserDetect.browser=='Firefox' && BrowserDetect.version==5) {
					// TODO
				}
			}
</script>

<%-- fixed by.. YUT 2016/02/11 --%>
<script type="text/javascript">
	document.attachEvent("onkeydown", keyDownTextField);
	function keyDownTextField(e) {
		var keyCode = e.keyCode;
		if (e.keyCode === 8) {
	        var d = e.srcElement || e.target;
	        if ((d.tagName.toUpperCase() === 'INPUT' && 
				(
	            	d.type.toUpperCase() === 'TEXT' ||
	                d.type.toUpperCase() === 'PASSWORD' || 
	                d.type.toUpperCase() === 'FILE' || 
	                d.type.toUpperCase() === 'EMAIL' || 
	                d.type.toUpperCase() === 'SEARCH' || 
	                d.type.toUpperCase() === 'DATE' )
				) || d.tagName.toUpperCase() === 'TEXTAREA') 
			{
				if(d.readOnly || d.disabled)
				{
					return false;
				}
	        	return true;
        	}
	        else {
	        	return false;
	        }
	    }
	}

	<%-- fixed by.. YUT 2016/02/11 --%>
	function funcDefaultStyle() {
	//alert('test');
		var inputs = document.getElementsByClassName("rich-button");

	    for(var i = 0; i < inputs.length; i++) {
				//alert('test '+i+'= '+inputs[i].disabled);
	    	   if( inputs[i].disabled){
	    		   	//alert(i+'= '+inputs[i].disabled);
	    		   	inputs[i].style.background = "#ffffff";
	    		   	inputs[i].style.fontWeight = "lighter";
	    	   }
	    }
	}

	window.onload = funcDefaultStyle;
</script>

</head>
<body style="margin: 0 0">
<script language="Javascript">
mapWidth();
mapWidthIn();
mapWidthIn80();
mapWidthInSA()
mapWidthHalf();
mapHeight();
mapWidthScaleHeight();
mapWidth5Rows();
mapWidthEL();
mapWidth10Rows();
mapWidth10RowsForPopup();
mapWidthInMM();
mapWidthInSATab1();
mapWidthInSI();
mapWidthInTodoSA();
mapWidthInTodoSASub();
</script>

<f:view>
<f:loadBundle basename="resources.application" var="msg" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      		<tr>
        		<td width="236" align="center" bgcolor=""><img src="images/h_logo.jpg"></td>
        		<td align="right" background="images/h_bg.jpg">&nbsp;</td>
      		</tr>
    	</table>
    </td>
  </tr>
</table>

<table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      		<tr>
        		<td>
        			<h:graphicImage value="/images/ic-user.gif" />
					<h:outputText id="txtNavProgram" value="#{userSession.navProgram}" styleClass="ms7"/>
				</td>
        		<td align="right">
					<h:outputText value="#{ssoBean.userName}" styleClass="ms7"/>
        		</td>
      		</tr>
    	</table>
    </td>
  </tr>
</table>

<h:panelGrid columns="1" width="100%">
	<h:panelGroup>
		<h:form id="frmMenu">
			<rich:toolBar id="home_toolBar" binding="#{navAction.toolBar}" >
			</rich:toolBar>
		</h:form>
	</h:panelGroup>
</h:panelGrid>

<h:panelGroup id="oppContent">
	<a4j:include id="incContent"  viewId="/pages/#{userSession.navModule}/#{userSession.navProgram}.jsp" />
</h:panelGroup>

<rich:spacer height="5"/>

<table width="100%" border="0" cellspacing="0" cellpadding="4">
  <tr>
    <td height="28" valign="middle" bgcolor="#666666">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      		<tr>
		        <td width="70" height="28" valign="top"><img src="images/logo-ais-s.png" width="67" height="26"></td>
		        <td height="28" valign="middle" class="copy">&copy; <h:outputLabel value="#{msg['home.copyright']}" /> &nbsp;<h:outputLabel value="#{msg['home.allright']}" /> </td>
				<td align="right" valign="middle">&nbsp;</td>
      		</tr>
    	</table>
    </td>
  </tr>
</table>

<a4j:status onstart="#{rich:component('mdpWait')}.show(); doTimer();" id="globalAjaxStatus"
	onstop="pageOnLoad(); doClearTimer(); #{rich:component('mdpWait')}.hide();funcDefaultStyle();" />

<rich:modalPanel id="mdpWait" autosized="true" width="180" height="70" 
	moveable="false" resizeable="false" styleClass="centered">
	<f:facet name="header">
		<h:outputText value="Processing" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="images/ico_close.png"
				id="gpiHidePopUpProgress" style="cursor:pointer" />
			<rich:componentControl for="mdpWait" attachTo="gpiHidePopUpProgress"
				operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>
	
	<div align="center" style="width:100%;">
		<table width="100%" border="0" cellpadding="1" cellspacing="0">
			<tr>
				<td align="right"><h:graphicImage value="images/loading.gif"/></td>
				<td><h:outputText styleClass="ms7" value="Wait Please..." /></td>
			</tr>
		</table>
	</div>
</rich:modalPanel>

</f:view>
</body>
</html>