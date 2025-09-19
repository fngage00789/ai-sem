var c;
var up;
var cmin1,csec1;

function doTimer(){
doClearTimer();
UpRepeat();
}

function UpRepeat() {
csec1++;
if(csec1==60) {
csec1=0; cmin1++;
}
document.getElementById('CounterTxt').innerHTML="<b>"+Display(cmin1,csec1)+" min.</b>";
up=setTimeout("UpRepeat()",1000);
}

function Display(min,sec) {
var disp;
if(min<=9) disp=" 0";
else disp=" ";
disp+=min+":";
if(sec<=9) disp+="0"+sec;
else disp+=sec;
return(disp);
}

function doClearTimer(){
clearTimeout(up);
c=0;
cmin1=0;
csec1=0;
}

function startTime()
{
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
var month = today.getMonth() + 1;
var day = today.getDate();
var year = today.getFullYear();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s+"  "+month + "/" + day + "/" + year;
t=setTimeout('startTime()',500);
}

function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}
