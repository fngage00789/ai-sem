function pageOnLoad(){}

function pageOnLoad_Temp(){
	var attributes = new Array();
	semAjax.getAllComponentStyle(null, function(data){
		
		if(data!=null && data.length>0){
			/*for(var i=0; i<data.length; i++){
				alert('data['+i+'].progCodeId='+data[i].progCodeId +
					  '\ndata['+i+'].compCode='+data[i].compCode +
					  '\ndata['+i+'].visible='+data[i].visible +
					  '\ndata['+i+'].enable='+data[i].enable);
			}*/			
			
			var ctrlTypes = [".rich-calendar-input",".rich-calendar-button",
			                 ".rich-panel",
			                 "input","select","table"];
			for(var c=0; c<ctrlTypes.length; c++){
				var type = ctrlTypes[c];
				var ctrls = jQuery(type);
				if(ctrls!='undefined'){
					for(var i=0; i<ctrls.length; i++){
						var ctrl = ctrls[i];
						var parts = ctrl.id.split(":"); //examples : incContent:frmSearch:txtSiteApproveNo
						var lastPart = parts[parts.length-1];
						for(var j=0; j<data.length; j++){
							if(lastPart == data[j].compCode){
								if(".rich-panel"==type){
									/** rich:panel **/
									/*if(ctrl.id.indexOf('pnlSearchResult')!=-1){
										alert('id='+ctrl.id+'\nvisible='+data[j].visible+'\nctrl.style.visibility='+ctrl.style.visibility);										
									}*/
									if(data[j].visible=='0' && ctrl.style.visibility!='hidden'){
										//change "incContent:frmSearch:pnlSearchResult" ==> "#incContent\\:frmSearch\\:pnlSearchResult"
										jQuery('#'+ctrl.id.replace(/:/g,'\\:')).hide();										
									}
								}else{ 
									/** general **/
									if(ctrl.style.visibility!='hidden'){
										//ctrl.style.visibility = data[j].visible=='1'?'visible':'hidden';
										if(data[j].visible=='1') jQuery('#'+ctrl.id.replace(/:/g,'\\:')).show();
										else jQuery('#'+ctrl.id.replace(/:/g,'\\:')).hide();
									}
									if(!ctrl.disabled) 
										ctrl.disabled = data[j].enable=='1'?false:true;
								}
							}else if(".rich-calendar-input"==type &&  
							   lastPart.lastIndexOf ("InputDate",lastPart.length-1)!=-1 && 
							   lastPart.indexOf(data[j].compCode)!=-1 ){
								/** rich:calendar input text **/
								if(ctrl.style.visibility!='hidden'){
									//ctrl.style.visibility = data[j].visible=='1'?'visible':'hidden';
									if(data[j].visible=='1') jQuery('#'+ctrl.id.replace(/:/g,'\\:')).show();
									else jQuery('#'+ctrl.id.replace(/:/g,'\\:')).hide();
								}
								if(!ctrl.disabled){
									ctrl.disabled = data[j].enable=='1'?false:true;
									ctrl.readOnly = ctrl.disabled;
								}
							}else if(".rich-calendar-button"==type && 
							   lastPart.lastIndexOf ("PopupButton",lastPart.length-1)!=-1 &&  
							   lastPart.indexOf(data[j].compCode)!=-1 ){
								/** rich:calendar img button **/
								if(ctrl.style.visibility!='hidden'){
									ctrl.style.visibility = data[j].enable=='1'?'visible':'hidden';
									if(ctrl.style.visibility!='hidden'){
										ctrl.style.visibility = data[j].visible=='1'?'visible':'hidden';
									}
								}
							}
						}//for data obj from server
					}//end for controls in jsp
				}//end if(ctrls!='undefined')
			}//end for type "input","select",".rich-panel"			
		}
	});	
}

