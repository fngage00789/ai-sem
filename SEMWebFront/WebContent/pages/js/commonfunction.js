var commonfunction = new Object ();

commonfunction.getFormElementsByCssClass = function ( cssName, formObj )
{
    var elementArray;
    var result = new Array ();
    
    if ( formObj )
    {
        elementArray = formObj.elements;
    }
    else
    {
        elementArray = document.forms[0].elements;
    }
    
    for ( var i = 0; i < elementArray.length; i++ )
    {
        var elementObj = elementArray [i];
        if ( elementObj.className == cssName )
        {
            result.push ( elementObj );
        }
    }
    
    return result;
}

commonfunction.isBlankValue = function ( inputString )
{
    var result = false;
    
    if ( inputString == null || commonfunction.trim(inputString) == "" || commonfunction.trim(inputString).length == 0 )
    {
        result = true;
    }
    
    return result;
}

commonfunction.isBlankValueObject = function ( inputObj )
{
    return commonfunction.isBlankValue (inputObj.value);
}

commonfunction.selectDropdownValue = function (dropdown, value)
{
    dropdown.selectedIndex = 0;
    for (var i = 0; i < dropdown.options.length; i++)
    {
        if ( dropdown.options[i].value == value )
        {
            dropdown.selectedIndex = i;
            break;
        }
    }
}

commonfunction.generateDropdownOption = function ( dropdownObject, listOption, fieldName, fieldValue, startOptionIndex, selectedValue )
{
    if (!startOptionIndex) startOptionIndex = 0;
    dropdownObject.options.length = startOptionIndex;
    
    for (var i = 0; i < listOption.length; i++)
    {
        var optionObject = listOption[i];
        var text = optionObject[fieldName];
        var value = optionObject[fieldValue];
        var isSelected = false;
        if (value == selectedValue) isSelected = true;
        dropdownObject.options[dropdownObject.options.length] = new Option (text, value, false, isSelected);
    }
}

commonfunction.htmlConversionMap = {
    "amp" : "&"
    , "lt" : "<"
    , "gt" : ">"
    , "apos" : "'"
    , "quot" : '"'
}

commonfunction.decodeHtml = function (entityString)
{
    return entityString.replace(/&(\w+);/g, function(m,g) 
        {
            return commonfunction.htmlConversionMap[g]||m;
        });
}

commonfunction.isContentTypeImage = function (imageName)
{
    var imageExtensions = new Array ();
    imageExtensions[".gif"] = ".gif";
    imageExtensions[".png"] = ".png";
    imageExtensions[".jpg"] = ".jpg";
    imageExtensions[".jpeg"] = ".jpeg";
    imageExtensions[".jpe"] = ".jpe";
    imageExtensions[".tiff"] = ".tiff";
    imageExtensions[".tif"] = ".tif";
    imageExtensions[".bmp"] = ".bmp";
    
    var imageExtension = imageName.substring ( imageName.lastIndexOf (".") );
    
    if (imageExtensions[imageExtension.toLowerCase()])
    {
        return true;
    }
    return false;
}

commonfunction.isAlphaNumberic = function (str)
{
    var regex = /^[a-zA-Z0-9]*$/;
    if (regex.test(str)) return true;

    return false;
}

commonfunction.keyPressAlphaNumberic = function (myfield, e, dec)
{
	var key;
    var keychar;

    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);
    
	return commonfunction.isAlphaNumberic(keychar);
}

commonfunction.trim = function(str) 
{
    return str.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,"");
}

commonfunction.fulltrim = function(str) 
{
    return str.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,"").replace(/\s+/g," ");
}

commonfunction.submitForm = function (pageActionId, pageAction)
{
    document.getElementById(pageActionId).value = pageAction;
    document.forms[0].submit ();
}

commonfunction.formIsDirty = function (form)
{
    for (var i = 0; i < form.elements.length; i++)
    {
        var element = form.elements[i];
        var type = element.type;
        if (type == "checkbox" || type == "radio")
        {
            if (element.checked != element.defaultChecked)
            {
                return true;
            }
        }
        else if (type == "hidden" || type == "password" || type == "text" || type == "textarea")
        {
            if (element.value != element.defaultValue)
            {
                return true;
            }
        }
        else if (type == "select-one")
        {
            var defaultSelectedIndex = 0;
            for (var j = 0; j < element.options.length; j++)
            {
                if (element.options[j].defaultSelected)
                {
                    defaultSelectedIndex = j;
                }
            }
                    
            if (element.selectedIndex != defaultSelectedIndex)
            {
                return true;
            }
        }
        else if (type == "select-multiple")
        {
            for (var j = 0; j < element.options.length; j++)
            {
                if (element.options[j].selected != element.options[j].defaultSelected)
                {
                    return true;
                }
            }
        }
    }
    return false;
}

commonfunction.setElementValue = function (elementId, value)
{
    document.getElementById(elementId).value = value;
}

commonfunction.openReportView = function (url)
{
    window.open(url, "_blank");
}