var cache = new Array();

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function validateElementFromTo(formRef, elementRef){	
	var _elementFrom = document.getElementById(formRef.name + ':' + elementRef + "From");
	var _elementTo = document.getElementById(formRef.name + ':' + elementRef + "To");	
	
	if(!commonfunction.isBlankValueObject(_elementFrom)){
		if(commonfunction.isBlankValueObject(_elementTo)){
			_elementTo.value = _elementFrom.value;
		}
	}
	return true;
}

function validateRichCalendarFromTo(formRef, fromElementRef, toElementRef){	
	var _elementFrom = document.getElementById('incContent:'+formRef+':'+fromElementRef+'InputDate');
	var _elementTo = document.getElementById('incContent:'+formRef+':'+toElementRef+'InputDate');	
	if(_elementFrom != null){ 
		if(!isBlankValueObject(_elementFrom)){
			if(isBlankValueObject(_elementTo)){
				_elementTo.value = _elementFrom.value;
			}
		}
	}
	return true;
}

function validateRichPeriodFromTo(formRef, fromElementRef, toElementRef ,expireDtRef){	
	var _elementFrom = document.getElementById('incContent:'+formRef+':'+fromElementRef+'InputDate');
	var _elementTo = document.getElementById('incContent:'+formRef+':'+toElementRef+'InputDate');	
	var _elementExpire = document.getElementById('incContent:'+formRef+':'+expireDtRef+'InputDate');	

	if(_elementExpire == null){ 
		_elementTo.value = null;
	}
	return true;
}

function validateAllCalendarFromTo(formRef, fromElementRef, toElementRef){	
	var _elementFrom = document.getElementById('incContent:'+formRef+':'+fromElementRef+'InputDate');
	var _elementTo = document.getElementById('incContent:'+formRef+':'+toElementRef+'InputDate');	
	
	if(_elementFrom != null){ 
		if(!isBlankValueObject(_elementFrom)){
			_elementTo.value = _elementFrom.value;
		}
	}
	return true;
}

function validateCalendarFromToWithPaymentType(formRef, fromElementRef, toElementRef, paymentType){	
	var _elementFrom = document.getElementById('incContent:'+formRef+':'+fromElementRef+'InputDate');
	var _elementTo = document.getElementById('incContent:'+formRef+':'+toElementRef+'InputDate');
	if(paymentType == '03' || paymentType == '02'){
		if(_elementFrom != null){ 
			if(!isBlankValueObject(_elementFrom)){
				if(isBlankValueObject(_elementTo)){
					_elementTo.value = _elementFrom.value;
				}
			}
		}
	}
	
	return true;
}

function isBlankValue( inputString )
{
    var result = false;
    
    if ( inputString == null || trimData(inputString) == "" || trimData(inputString).length == 0 )
    {
        result = true;
    }
    
    return result;
}

function isBlankValueObject( inputObj )
{
    return isBlankValue (inputObj.value);
}

function trimData(str) 
{
    return str.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,"");
}

function changeItemWithIndex(formName, elementId, index){
	var _eTarget = document.getElementById('incContent:'+formName+':'+elementId);
	
	if(_eTarget != null){
		_eTarget.value = index;
	}
}

function changeItemWithSelectedList(formItem, itemRefId, formName, elementId, index){
	var _eTarget = document.getElementById('incContent:'+formName+':'+elementId);
	var _eItem = document.getElementById('incContent:'+formItem+':'+itemRefId);
	
	if(_eTarget != null && _eItem != null){
		_eTarget.value = index[_eItem.selectedIndex - 1];
	}
}

function copyElementFromTo(firstFrom, fromId, secondFrom, secondId){
	var _eFrist = document.getElementById('incContent:'+firstFrom+':'+fromId);
	var _eSecond = document.getElementById('incContent:'+secondFrom+':'+secondId);
	
	if(_eFrist != null && _eSecond != null){
		_eSecond.value = _eTarget.value;
	}
}

function myScript(){
	//alert('test');
	console.log(5 + 6);
	return true;
}

function removeSpace(text){
	return text.replace(/ /g,'');
}

function upperCase(text){
	return text.toUpperCase();
}

//Cache Command

function putToCache(obj){
	if(!isBlankValue(cache)){
		cache[cache.length - 1] = cache; 
	}
}

function pop(){
	if(!isBlankValue(cache)){
		return cache[cache.length - 1]; 
	}
}

function getCache(){
	if(!isBlankValue(cache)){
		return cache;
	}
}

function getFromCacheWithIndex(index){
	if(!isBlankValue(cache)){
		return cache[index]; 
	}
}

function setFromCacheWithIndex(obj, index){
	if(!isBlankValue(cache)){
		cache[index] = obj; 
	}
}

function clearCache(){
	cache = new Array();
}

function setFormatContractNo(obj) {
	var str = obj.value;
	str = upperCase(str);
	obj.value = str;
}

function setFormatDocNo(obj) {
	var str = obj.value;
	str = removeSpace(str);
	str = upperCase(str);
	obj.value = str;
}

function showViewSiteInfoPopup()
{ 
  //window.open('../SEMWebFront/pages/popup/viewSiteInfo.jsf','','dependent=yes,width=900,height=650,resizable=no,toolbar=no,menubar=no,directories=no,status=no,location=no',true);
	window.showModalDialog('../SEMWebFront/pages/popup/viewSiteInfo.jsf?RID='+Math.floor(Math.random()*100000),null,'dialogWidth:1000px; dialogHeight:680px; resizable:no; status:no; help:no');
}

function resetElement(formName, elementId){
var _eTarget = document.getElementById('incContent:'+formName+':'+elementId);
	
	if(_eTarget != null){
		_eTarget.reset();
	}
}