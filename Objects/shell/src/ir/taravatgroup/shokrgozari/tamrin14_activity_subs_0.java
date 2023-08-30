package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin14_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","activity_create", _firsttime);}
RemoteObject _str_html = RemoteObject.createImmutable("");
RemoteObject _ls_get_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"tamrin14_layout\")";
Debug.ShouldStop(1);
tamrin14_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin14_layout")),tamrin14_activity.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="ScrollView1.Panel.LoadLayout(\"tamrin8_items\")";
Debug.ShouldStop(2);
tamrin14_activity.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin8_items")),tamrin14_activity.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Dim str_html As String";
Debug.ShouldStop(8);
_str_html = RemoteObject.createImmutable("");Debug.locals.put("str_html", _str_html);
 BA.debugLineNum = 37;BA.debugLine="str_html=\"<html><head><meta name='viewport' conte";
Debug.ShouldStop(16);
_str_html = BA.ObjectToString("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word;'><p>- در لیست زیر 10 آرزو و خواسته خود را بنویسید و از تخیل خود استفاده کنید و برای هر کدام به این پرسش های پاسخ دهید : <br>- وقتی به آرزوتان دست یافتید چه احساسی داشتید؟ <br>- وقتی به آرزوتان دست یافتید آن را برای نخستین بار با چه کسی در میان گذاشتید و چگونه آنها را بیان کردید؟ <br>- اولین کار بزرگی که بعد از دریافت آرزوتان انجام دادید چه بود؟ <br>بکوشید تا هرچه میتوانید جزئیات بیشتری را در ذهنتان به خاطر بیاورید. <br> در پایان، لیست آرزوهاتان را دوباره بخوانید و از صمیم قلب بر روی کلمه ی سپاسگزارم تأکید بورزید و تا میتوانید آن را احساس کنید.</p><br></body></html>");Debug.locals.put("str_html", _str_html);
 BA.debugLineNum = 41;BA.debugLine="WebView1.LoadHtml(str_html)";
Debug.ShouldStop(256);
tamrin14_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(_str_html));
 BA.debugLineNum = 44;BA.debugLine="Dim ls_get_content As List";
Debug.ShouldStop(2048);
_ls_get_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_get_content", _ls_get_content);
 BA.debugLineNum = 45;BA.debugLine="ls_get_content.Initialize";
Debug.ShouldStop(4096);
_ls_get_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 46;BA.debugLine="ls_get_content=myFunc.get_all_tamrin14";
Debug.ShouldStop(8192);
_ls_get_content = tamrin14_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA);Debug.locals.put("ls_get_content", _ls_get_content);
 BA.debugLineNum = 48;BA.debugLine="For i=0 To 9";
Debug.ShouldStop(32768);
{
final int step9 = 1;
final int limit9 = 9;
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 50;BA.debugLine="If(ls_get_content.Get(i)=Null)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("n",_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))) { 
 BA.debugLineNum = 51;BA.debugLine="ls_get_content.Set(i,\"\")";
Debug.ShouldStop(262144);
_ls_get_content.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, _i)),(Object)((RemoteObject.createImmutable(""))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 55;BA.debugLine="et_mohebat1.Text=ls_get_content.Get(0)";
Debug.ShouldStop(4194304);
tamrin14_activity.mostCurrent._et_mohebat1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 56;BA.debugLine="et_mohebat2.Text=ls_get_content.Get(1)";
Debug.ShouldStop(8388608);
tamrin14_activity.mostCurrent._et_mohebat2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 57;BA.debugLine="et_mohebat3.Text=ls_get_content.Get(2)";
Debug.ShouldStop(16777216);
tamrin14_activity.mostCurrent._et_mohebat3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 58;BA.debugLine="et_mohebat4.Text=ls_get_content.Get(3)";
Debug.ShouldStop(33554432);
tamrin14_activity.mostCurrent._et_mohebat4.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 59;BA.debugLine="et_mohebat5.Text=ls_get_content.Get(4)";
Debug.ShouldStop(67108864);
tamrin14_activity.mostCurrent._et_mohebat5.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 60;BA.debugLine="et_mohebat6.Text=ls_get_content.Get(5)";
Debug.ShouldStop(134217728);
tamrin14_activity.mostCurrent._et_mohebat6.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 61;BA.debugLine="et_mohebat7.Text=ls_get_content.Get(6)";
Debug.ShouldStop(268435456);
tamrin14_activity.mostCurrent._et_mohebat7.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6)))));
 BA.debugLineNum = 62;BA.debugLine="et_mohebat8.Text=ls_get_content.Get(7)";
Debug.ShouldStop(536870912);
tamrin14_activity.mostCurrent._et_mohebat8.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7)))));
 BA.debugLineNum = 63;BA.debugLine="et_mohebat9.Text=ls_get_content.Get(8)";
Debug.ShouldStop(1073741824);
tamrin14_activity.mostCurrent._et_mohebat9.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 64;BA.debugLine="et_mohebat10.Text=ls_get_content.Get(9)";
Debug.ShouldStop(-2147483648);
tamrin14_activity.mostCurrent._et_mohebat10.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9)))));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,131);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 131;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin14_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 133;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16);
_lbl_back_click();
 BA.debugLineNum = 134;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return tamrin14_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 136;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return tamrin14_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,75);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,71);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","activity_resume");}
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat1_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,116);
if (RapidSub.canDelegate("et_mohebat1_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 116;BA.debugLine="Private Sub et_mohebat1_TextChanged (Old As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="myFunc.update_tamrin14(1,New)";
Debug.ShouldStop(1048576);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1)),(Object)(_new));
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat10_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat10_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,80);
if (RapidSub.canDelegate("et_mohebat10_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat10_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 80;BA.debugLine="Private Sub et_mohebat10_TextChanged (Old As Strin";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="myFunc.update_tamrin14(10,New)";
Debug.ShouldStop(65536);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 10)),(Object)(_new));
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat2_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat2_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,112);
if (RapidSub.canDelegate("et_mohebat2_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat2_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 112;BA.debugLine="Private Sub et_mohebat2_TextChanged (Old As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="myFunc.update_tamrin14(2,New)";
Debug.ShouldStop(65536);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2)),(Object)(_new));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat3_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat3_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,108);
if (RapidSub.canDelegate("et_mohebat3_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat3_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 108;BA.debugLine="Private Sub et_mohebat3_TextChanged (Old As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="myFunc.update_tamrin14(3,New)";
Debug.ShouldStop(4096);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3)),(Object)(_new));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat4_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat4_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,104);
if (RapidSub.canDelegate("et_mohebat4_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat4_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 104;BA.debugLine="Private Sub et_mohebat4_TextChanged (Old As String";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="myFunc.update_tamrin14(4,New)";
Debug.ShouldStop(256);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 4)),(Object)(_new));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat5_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat5_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,100);
if (RapidSub.canDelegate("et_mohebat5_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat5_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 100;BA.debugLine="Private Sub et_mohebat5_TextChanged (Old As String";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="myFunc.update_tamrin14(5,New)";
Debug.ShouldStop(16);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 5)),(Object)(_new));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat6_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat6_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,96);
if (RapidSub.canDelegate("et_mohebat6_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat6_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 96;BA.debugLine="Private Sub et_mohebat6_TextChanged (Old As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="myFunc.update_tamrin14(6,New)";
Debug.ShouldStop(1);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 6)),(Object)(_new));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat7_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat7_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,92);
if (RapidSub.canDelegate("et_mohebat7_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat7_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 92;BA.debugLine="Private Sub et_mohebat7_TextChanged (Old As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="myFunc.update_tamrin14(7,New)";
Debug.ShouldStop(268435456);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 7)),(Object)(_new));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat8_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat8_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,88);
if (RapidSub.canDelegate("et_mohebat8_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat8_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 88;BA.debugLine="Private Sub et_mohebat8_TextChanged (Old As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="myFunc.update_tamrin14(8,New)";
Debug.ShouldStop(16777216);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 8)),(Object)(_new));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat9_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat9_TextChanged (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,84);
if (RapidSub.canDelegate("et_mohebat9_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","et_mohebat9_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 84;BA.debugLine="Private Sub et_mohebat9_TextChanged (Old As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="myFunc.update_tamrin14(9,New)";
Debug.ShouldStop(1048576);
tamrin14_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin14" /*RemoteObject*/ ,tamrin14_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 9)),(Object)(_new));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
tamrin14_activity.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_mohebat1 As EditText";
tamrin14_activity.mostCurrent._et_mohebat1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_mohebat2 As EditText";
tamrin14_activity.mostCurrent._et_mohebat2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_mohebat3 As EditText";
tamrin14_activity.mostCurrent._et_mohebat3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_mohebat4 As EditText";
tamrin14_activity.mostCurrent._et_mohebat4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private et_mohebat5 As EditText";
tamrin14_activity.mostCurrent._et_mohebat5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private et_mohebat6 As EditText";
tamrin14_activity.mostCurrent._et_mohebat6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private et_mohebat7 As EditText";
tamrin14_activity.mostCurrent._et_mohebat7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private et_mohebat8 As EditText";
tamrin14_activity.mostCurrent._et_mohebat8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private et_mohebat9 As EditText";
tamrin14_activity.mostCurrent._et_mohebat9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private et_mohebat10 As EditText";
tamrin14_activity.mostCurrent._et_mohebat10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private WebView1 As WebView";
tamrin14_activity.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin14_activity) ","tamrin14_activity",5,tamrin14_activity.mostCurrent.activityBA,tamrin14_activity.mostCurrent,124);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin14_activity.remoteMe.runUserSub(false, "tamrin14_activity","lbl_back_click");}
 BA.debugLineNum = 124;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 126;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
tamrin14_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}