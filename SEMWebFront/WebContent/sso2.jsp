<%@page import="java.util.ArrayList"%>
<%@page import="th.co.ais.util.SAPUtility"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="th.co.ais.web.util.WebUtil" %>
<html>

<%-- 
	List<File> xmlFiles = new ArrayList();
	try{
		String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath");
		xmlFiles = SAPUtility.listFile(ssoSerlzePath+"*_SM001");
	}catch(Exception e){
		out.println("List SSO XML files error: "+e.getMessage());	
	}	
--%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SEM</title>
	<style type="text/css"> 
		.clientArea { 
			 color: #000000; 
			 font-family: Verdana, Arial, Helvetica, sans-serif; 
			 font-size: 10pt; 
			 margin: 0px; 
			 overflow: auto; 
			 padding: 1px; 
			 scrollbar-face-color: #cacaca; 
			 scrollbar-highlight-color: #cacaca; 
			 /*scrollbar-3dlight-color: #cacaca; 
			 scrollbar-darkshadow-color: #cacaca; 
			 scrollbar-shadow-color: #cacaca;*/ 
			 scrollbar-arrow-color: #000000; 
			 scrollbar-track-color: #cacaca; 
			 width: 600px; 
			 height: 340px; 
		}
	</style>

	<script type="text/javascript">
		function goSSOPage() {
			window.close();
			window.opener.location = 'http://10.240.1.101:7201/EmployeeService/jsp/loginPage.jsp';
		}
		
		function formSubmit(){
			formName.action = "SSOLoginServlet?userName="+document.getElementById("userName").value+"&byPass="+document.getElementById("byPass").value;
			formName.submit();
		}

		function login(userRole){
			formName.action = "SSOLoginServlet?userName="+userRole;
			formName.submit();
		}
		/*function changeCostCenter(region, company){
			//alert('region='+region +', company='+company);
			CM101Service.getCostCenter(region, company, {
				callback:function(data) {
					//alert('region='+region+',company='+company+',data='+data);
					dwr.util.setValue('F_subM_costCenter_STRING',data);
				},
				errorHandler :function(){
	             	//dwr.util.setValue('F_subM_costCenter_STRING',''); 
	              	alert('Not found Data.');
	            }
	        });
		}*/
	</script>
</head>
<body>
<div style="vertical-align: middle; text-align: center;">
	<form name="formName" method="post" onsubmit="formSubmit();" target="">
	
		<%-- <input type="text" id="userName" value="rapeesuw_SM001"> --%>
		<select id="userName">
			<option value="rapeesuw_SM001" selected="selected">rapeesuw</option>
			<option value="siripc88_SM001" >siripc88</option>
			<option value="wilasins_SM001">wilasins</option>
			<option value="jirattau_SM001">jirattau</option>
			<option value="wararato_SM001">wararato</option>
			<option value="naiyaj45_SM001">naiyaj45</option>
			<option value="duangkaw_SM001">duangkaw</option>
			<option value="suebsakp_SM001">suebsakp</option>
			<option value="panidawi_SM001">panidawi</option>
			<option value="teeradam_SM001">teeradam</option>
			<option value="UAT_SM001">UAT001</option>
			<option value="UAT_SM002">UAT002</option>
			<option value="UAT_SM003">UAT003</option>
			<option value="UAT_SM004">UAT004</option>
			<option value="UAT_SM005">UAT005</option>
			<option value="UAT_SM006">UAT006</option>
			<option value="UAT_SM007">UAT007</option>
			<option value="UAT_SM008">UAT008</option>
			<option value="UAT_SM009">UAT009</option>
			<option value="UAT_SM010">UAT010</option>
			<option value="UAT_SM011">UAT011</option>
			<option value="UAT_SM012">UAT012</option>
			<option value="UAT_SM013">UAT013</option>
			<option value="UAT_SM014">UAT014</option>
			<option value="UAT_SM015">UAT015</option>
			<option value="UAT_SM016">UAT016</option>
			<option value="UAT_SM017">UAT017</option>
			<option value="UAT_SM018">UAT018</option>
			<option value="UAT_SM019">UAT019</option>
			<option value="UAT_SM020">UAT020</option>
			<option value="sanyac_SM001">jirayus</option>
			
			<!-- <option value="tippawpp_SM001">tippawpp</option> -->
			<!--<option value="umapornp_SM001">umapornp</option>
			<option value="tassanas_SM001">tassanas</option>
			<option value="nitchans_SM001">nitchans</option>
			<option value="monthikt_SM001">monthikt</option>
			
			<option value="pichetse_SM001">pichetse</option>
			<option value="ratchanw_SM001">ratchanw</option>
			<option value="sujitrap_SM001">sujitrap</option>
			<option value="aksarapc_SM001">aksarapc</option>
			<option value="verapors_SM001">verapors</option>
			<option value="anchaled_SM001">anchaled</option>
			<option value="pirotep_SM001">pirotep</option>
			<option value="prathnar_SM001">prathnar</option>
			<option value="thidarah_SM001">thidarah</option>
			<option value="rungnata_SM001">rungnata</option>
			<option value="natchayc_SM001">natchayc</option>
			<option value="suvimonj_SM001">suvimonj</option>-->
		</select>
		
		<input type="submit" value="Generate SSO Parameters (FIX)">
		<input type="hidden" id="byPass" value="byPass">
		<br></br>
		<%--div class="clientArea" style="height:sizepx;" align="center">
			<table border="2" style="width: 100%">
				<thead>
					<tr>
						<td align="center">No</td>
						<td align="center">User</td>
						<td align="center">Role</td>
						<td align="center">Action</td>
					</tr>
				</thead>
				<% 
					int row = 1;
					for(File f : xmlFiles){ 
						String fName0 = f.getName().split("\\.")[0];
						String[] fName  = fName0.split("\\_");
				%>
				<tbody>
					<tr>
						<td align="right"><%= row++ %></td>
						<td><%= fName[0] %></td>
						<td><%= fName[1] %></td>
						<td align="center"><a href="#" onclick="login('<%= fName0 %>')">Login</a></td>
					</tr>
				</tbody>
				<% 
					}
				%>
			</table>
		</div--%>
		<%--table border="2">
			<tr>
				<td colspan="2" style="text-align: center; font-weight: bold;">
					<font size="4"> 
					<!--Single Sign On (<a href="http://10.240.1.101:7201/EmployeeService/jsp/loginPage.jsp">SSO</a>)-->
					Single Sign On (<a href="#" onclick="goSSOPage();">SSO</a>)
					</font>
				</td>
			</tr>
			<tr>
				<td align="left">token</td>
				<td align="left"><input type="text" name="token"
					value="3xQsMQPTzpjWlhyWXxDyGT1S5Fh6225DyFMnvDmpp5yXY8cWJJn1!1200885014!1280315251031,vorapt49,141,175,null"
					style="width: 100%"></td>
			</tr>
			<tr>
				<td align="left">rid</td>
				<td align="left"><input type="text" name="rid" value="40"></td>
			</tr>
			<tr>
				<td align="left">sid</td>
				<td align="left"><input type="text" name="sid" value="175"></td>
			</tr>
			<tr>
				<td align="left">rn</td>
				<td align="left"><input type="text" name="rn" value="SEM_ROLE"></td>
			</tr>
			<tr>
				<td align="left">sn</td>
				<td align="left"><input type="text" name="sn" value="SM001"></td>
			</tr>
			<tr>
				<td align="left">fn</td>
				<td align="left"><input type="text" name="fn" value="Vorapon"></td>
			</tr>
			<tr>
				<td align="left">ln</td>
				<td align="left"><input type="text" name="ln"
					value="Thaepaamorndech"></td>
			</tr>
			<tr>
				<td align="left">theme</td>
				<td align="left"><input type="text" name="theme" value="theme01"></td>
			</tr>
			<tr>
				<td align="left">template</td>
				<td align="left"><input type="text" name="template"
					value="template01"></td>
			</tr>
			<tr>
				<td align="left">host</td>
				<td align="left"><input type="text" name="host"
					value="https://employeeservices.ais.co.th/EmployeeService/"></td>
			</tr>
			<tr>
				<td align="left">lc</td>
				<td align="left"><input type="text" name="lc" value=""></td>
			</tr>
			<tr>
				<td align="left">gl</td>
				<td align="left"><input type="text" name="gl" value=""></td>
			</tr>
			<tr>
				<td align="left">dc</td>
				<td align="left"><input type="text" name="dc" value="50063058"></td>
			</tr>
			<tr>
				<td align="left">sc</td>
				<td align="left"><input type="text" name="sc" value="50093761"></td>
			</tr>
			<tr>
				<td align="left">pt</td>
				<td align="left"><input type="text" name="pt" value="Call Center Jockey"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Generate SSO Parameters (FIX)"></td>
			</tr>
		</table--%>
	</form>
</div>
</body>
</html>
