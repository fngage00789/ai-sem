var numberformat = new Object ();

numberformat.keyPressIntegerOnly = function (myfield, e, dec) {
	var key;
	var keychar;

	if (window.event) key = window.event.keyCode;
	else if (e) key = e.which;
	else return true;
	keychar = String.fromCharCode(key);

	if ((key==null) || (key==0) || (key==8) ||
			(key==9) || (key==13) || (key==27) )
		return true;

	else if ((("0123456789").indexOf(keychar) > -1))
		return true;

	else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	}
	else return false;
}

numberformat.onblurTaxIdFormat = function (myfield) {
	var keychar;
	keychar = myfield.value;
	if (!isInteger(keychar)){
		myfield.value = '';
		return true;
	}
	
	else return false;
}

numberformat.keyPressDecimalOnly = function (myfield, e, dec) {
	var key;
	var keychar;

	if (window.event) key = window.event.keyCode;
	else if (e) key = e.which;
	else return true;
	keychar = String.fromCharCode(key);
	//alert(keychar);
	if ((key==null) || (key==0) || (key==8) ||
			(key==9) || (key==13) || (key==27) ) {
		return true;

	} else if ((("0123456789.").indexOf(keychar) > -1)) {
		if (keychar == "." && myfield.value.indexOf(".") > -1) {
			return false;
		} else {
			//alert(myfield.value.length);
			if (myfield.value.length == 13) {
				if(keychar == ".")
					return true;
				else
					return false;
			}
			return true;
		}

	} else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	} else return false;
	
}

numberformat.keyPressDecimal = function (myfield, e, dec) {
	var key;
	var keychar;
	if (window.event) key = window.event.keyCode;
	else if (e) key = e.which;
	else return true;
	keychar = String.fromCharCode(key);
	//alert(keychar);
	if ((key==null) || (key==0) || (key==8) ||
			(key==9) || (key==13) || (key==27) ) {
		return true;

	} else if ((("0123456789.-").indexOf(keychar) > -1)) {
		if (keychar == "." && myfield.value.indexOf(".") > -1) {
			return false;
		} else {
			//alert(myfield.value.length);
			if (myfield.value.length == 13) {
				if(keychar == ".")
					return true;
				else
					return false;
			}
			return true;
		}
		
		if (keychar == "-" && myfield.value.indexOf("-") > -1) {
			return false;
		} else {
			//alert(myfield.value.length);
			if (myfield.value.length == 13) {
				if(keychar == "-")
					return true;
				else
					return false;
			}
			return true;
		}

	} else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	} else if (dec && (keychar == "-")) {
		myfield.form.elements[dec].focus();
		return false;
	} else return false;
	
}

numberformat.keyPressDecimalAsterisk = function (myfield, e, dec)
{
    var key;
    var keychar;
    
    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);

    if ((key==null) || (key==0) || (key==8) || 
        (key==9) || (key==13) || (key==27) ) {
    	
       return true;

    } else if ((("0123456789.*").indexOf(keychar) > -1)) {
    	
    	if (keychar == "." && myfield.value.indexOf(".") > -1) {
    		
    		return false; 
    	} else if (keychar == "*" && myfield.value.indexOf(".") > -1) {
    		
    		return false; 
    	}else{
    	
       		return true;
       	}

    } else if (dec && (keychar == ".")) {
    	
	    myfield.form.elements[dec].focus();
	    return false;
    } else if (dec && (keychar == "*")) {
    	
	    myfield.form.elements[dec].focus();
	    return false;
    } else return false;
}

numberformat.keyPressFormatDateOnly = function (myfield, e, dec) {
	var key;
	var keychar;
	
	if (window.event) key = window.event.keyCode;
	else if (e) key = e.which;
	else return true;
	keychar = String.fromCharCode(key);
	
	if ((key==null) || (key==0) || (key==8) ||
			(key==9) || (key==13) || (key==27) ) {
		return true;

	} else if ((("0123456789/").indexOf(keychar) > -1)) {
//		if (keychar == "/" && myfield.value.indexOf("/") > -1) {
//			return false;
//		} else {
			return true;
//		}

	}else if (dec && (keychar == "/")) {
		myfield.form.elements[dec].focus();
		return false;
	} else return false;
}


 var dateformat = new Object ();

 var dtCh= "/";
 var minYear=2500;
 var maxYear=3000;


 dateformat.submitFomatDate = function (myfield) {
	
	var dtStr = myfield.value;
//	if(dtStr == null)
//		return true;
	
	var daysInMonth = DaysArray(12);
	var pos1=dtStr.indexOf(dtCh);
	var pos2=dtStr.indexOf(dtCh,pos1+1);
	var strDay=dtStr.substring(0,pos1);
	var strMonth=dtStr.substring(pos1+1,pos2);
	var strYear=dtStr.substring(pos2+1);
	strYr=strYear;
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
	}
	month=parseInt(strMonth);
	day=parseInt(strDay);
	year=parseInt(strYr);
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : dd/mm/yyyy");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month");
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day");
		return false;
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear);
		return false;
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date");
		return false;
	}
	return true;
 }


function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31;
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30};
		if (i==2) {this[i] = 29};
   } 
   return this;
}
numberformat.moneyFormat = function (myfield) {
	var newValue = myfield.value;
	var decAmount = "";
	var dolAmount = "";
	var decFlag = false;
	var aChar = "";

	// ignore all but digits and decimal points.
	for (i = 0; i < newValue.length; i++) {
		aChar = newValue.substring(i, i + 1);
		if (aChar >= "0" && aChar <= "9") {
			if (decFlag) {
				decAmount = "" + decAmount + aChar;
			} else {
				dolAmount = "" + dolAmount + aChar;
			}
		}
		if (aChar == ".") {
			if (decFlag) {
				dolAmount = "";
				break;
			}
			decFlag = true;
		}
	}

	// Ensure that at least a zero appears for the dollar amount.
	if (dolAmount == "") {
		dolAmount = "0";
	}
	// Strip leading zeros.
	if (dolAmount.length > 1) {
		while (dolAmount.length > 1 && dolAmount.substring(0, 1) == "0") {
			dolAmount = dolAmount.substring(1, dolAmount.length);
		}
	}

	// Round the decimal amount.
	if (decAmount.length > 2) {
		if (decAmount.substring(2, 3) > "4") {
			decAmount = parseInt(decAmount.substring(0, 2)) + 1;
			if (decAmount < 10) {
				decAmount = "0" + decAmount;
			} else {
				decAmount = "" + decAmount;
			}
		} else {
			decAmount = decAmount.substring(0, 2);
		}
		if (decAmount == 100) {
			decAmount = "00";
			dolAmount = parseInt(dolAmount) + 1;
		}
	}

	// Pad right side of decAmount
	if (decAmount.length == 1) {
		decAmount = decAmount + "0";
	}
	if (decAmount.length == 0) {
		decAmount = decAmount + "00";
	}
	
	// Check for negative values and reset myfield
	if (newValue.substring(0, 1) != '-'
			|| (dolAmount == "0" && decAmount == "00")) {
		myfield.value = dolAmount + "." + decAmount;

	} else {
		myfield.value = '-' + dolAmount + "." + decAmount;
	}
	
	if(myfield.value == '0.00')
	myfield.value = ''; // onblur to clear empty.
	addCommas(myfield.value, myfield);
}

function addCommas(newValue, myfield)
{	
	newValue.replace( ',','' );
	
	newValue += '';
	x = newValue.split('.');
	
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	myfield.value = x1 + x2;
	//alert('addCommas =' + myfield.value);
}
numberformat.addCommas = function (myfield)
{
	var newValue = myfield.value;
	newValue.replace( ',','' );
	//alert(newValue);
	newValue += '';
	x = newValue.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	myfield.value = x1 + x2;
}
numberformat.removeComma = function (myfield) 
{	var newValue = myfield.value;
	myfield.value = newValue.replace(/,/gi,"");
	
}
numberformat.setCursorPosToEnd = function (elemId)
{ 	numberformat.removeComma(elemId);
	var id_ = elemId.id;
    var elem = document.getElementById(id_);
    
    if (elem != null) {
        var caretPos = elem.value.length; 
        
        if (elem.createTextRange) {
            var range = elem.createTextRange();
            range.move('character', caretPos);
            range.select();
        }
        else {
            if (elem.selectionStart) {
                elem.focus();
                elem.setSelectionRange(caretPos, caretPos);
            }
            else
                elem.focus();
        }
    }
}

dateformat.checkDate = function (myfield) {
	
	var dtStr = myfield.value;
	if(dtStr==null || dtStr=="")
		return true;
	
	var daysInMonth = DaysArray(12);
	var pos1=dtStr.indexOf(dtCh);
	var pos2=dtStr.indexOf(dtCh,pos1+1);
	var strDay=dtStr.substring(0,pos1);
	var strMonth=dtStr.substring(pos1+1,pos2);
	var strYear=dtStr.substring(pos2+1);
	strYr=strYear;
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
	}
	month=parseInt(strMonth);
	day=parseInt(strDay);
	year=parseInt(strYr);
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : dd/mm/yyyy");
		myfield.focus();
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month");
		myfield.focus();
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day");
		myfield.focus();
		return false;
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear);
		myfield.focus();
		return false;
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date");
		myfield.focus();
		return false;
	}
	return true;
 }

function addSlashForDate(myField){
	var value = myField.value;
	if(checkKeyEvent()){
		if(value.indexOf('/') == -1){
			if(value.length == 2){
				value += '/';
			}
		}else{			
			if(value.indexOf('/') == 1){
				value = 0+value;
			}			
		}				
		myField.value = value;
	}
	
}
function autoAddYear(myField){		
	var value = myField.value;
	var splitStr = value.split('/');
	if(value.indexOf('/') == -1){
		value = value.substring(0,2);
	}else{
		if(splitStr[1].length == 2){
			splitStr[1] = '25' + splitStr[1];
		}		
		value = splitStr[0] + '/' + splitStr[1];		
	}
	myField.value = value;
}
//Check Key Arrow and Backspace
function checkKeyEvent(){
	var key;
	if (window.event) key = window.event.keyCode;
		else if (e) key = e.which;
		else return true;		
		
		if ((key!=null) && (key!=8) && (key!=37) && (key!=38) && (key!=39) && (key!=40)){
			return true;
		}else{
			return false;
		}
	}

//function ValidateForm(){
//	var dt=document.frmSample.txtDate
//	if (isDate(dt.value)==false){
//		dt.focus()
//		return false
//	}
//    return true
// }

	numberformat.keyPressDecimalCustomize = function (length, myfield, e, dec) {
		var key;
		var keychar;
	
		if (window.event) key = window.event.keyCode;
		else if (e) key = e.which;
		else return true;
		keychar = String.fromCharCode(key);
		
		
		if(myfield.value.indexOf(".") == 1)
			myfield.maxLength = 10;
		else
			myfield.maxLength = 11;
		
		//alert(keychar);
		if ((key==null) || (key==0) || (key==8) ||
				(key==9) || (key==13) || (key==27) ) {
			return true;
	
		} else if ((("0123456789.").indexOf(keychar) > -1)) {
			if (keychar == "." && myfield.value.indexOf(".") > -1) {
					return false;
		} else {
//		alert(myfield.value.length);
//		alert(keychar);
//		alert(myfield.value.indexOf("."));
			if (myfield.value.length == length) {
				if(keychar == "." || myfield.value.indexOf(".") != -1)
					return true;
				else
					return false;
				
			}
			return true;
		}
	
		} else if (dec && (keychar == ".")) {
			myfield.form.elements[dec].focus();
			return false;
		} else return false;
	}

	function addSlashFormat(myField){
		var value = myField.value;
		myField.maxLength = 10;
		if(checkKeyEvent()){
			if(value.length == 2 || value.length == 5){
				value += '/';
			}
			myField.value = value;
		}
	}
		
