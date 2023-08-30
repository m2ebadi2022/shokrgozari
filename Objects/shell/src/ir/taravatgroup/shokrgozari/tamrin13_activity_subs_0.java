package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin13_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"tamrin13_layout\")";
Debug.ShouldStop(33554432);
tamrin13_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin13_layout")),tamrin13_activity.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="et_name1.Color=0xABFFFFFF";
Debug.ShouldStop(134217728);
tamrin13_activity.mostCurrent._et_name1.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 29;BA.debugLine="et_name2.Color=0xABFFFFFF";
Debug.ShouldStop(268435456);
tamrin13_activity.mostCurrent._et_name2.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 30;BA.debugLine="et_name3.Color=0xABFFFFFF";
Debug.ShouldStop(536870912);
tamrin13_activity.mostCurrent._et_name3.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 32;BA.debugLine="et_matn1.Color=0xABFFFFFF";
Debug.ShouldStop(-2147483648);
tamrin13_activity.mostCurrent._et_matn1.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 33;BA.debugLine="et_matn2.Color=0xABFFFFFF";
Debug.ShouldStop(1);
tamrin13_activity.mostCurrent._et_matn2.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 34;BA.debugLine="et_matn3.Color=0xABFFFFFF";
Debug.ShouldStop(2);
tamrin13_activity.mostCurrent._et_matn3.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 37;BA.debugLine="et_name1.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(16);
tamrin13_activity.mostCurrent._et_name1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))));
 BA.debugLineNum = 38;BA.debugLine="et_name2.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(32);
tamrin13_activity.mostCurrent._et_name2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))));
 BA.debugLineNum = 39;BA.debugLine="et_name3.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(64);
tamrin13_activity.mostCurrent._et_name3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))));
 BA.debugLineNum = 41;BA.debugLine="et_matn1.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(256);
tamrin13_activity.mostCurrent._et_matn1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))));
 BA.debugLineNum = 42;BA.debugLine="et_matn2.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(512);
tamrin13_activity.mostCurrent._et_matn2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))));
 BA.debugLineNum = 43;BA.debugLine="et_matn3.text=null_change(myFunc.get_all_tamrin13";
Debug.ShouldStop(1024);
tamrin13_activity.mostCurrent._et_matn3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_null_change(BA.ObjectToString(tamrin13_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin13_byid" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_KeyPress (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,102);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 102;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin13_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 104;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(128);
_lbl_back_click();
 BA.debugLineNum = 105;BA.debugLine="Return True";
Debug.ShouldStop(256);
if (true) return tamrin13_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 107;BA.debugLine="Return False";
Debug.ShouldStop(1024);
if (true) return tamrin13_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Pause (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,61);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,57);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","activity_resume");}
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_matn1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_matn1_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,75);
if (RapidSub.canDelegate("et_matn1_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_matn1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 75;BA.debugLine="Private Sub et_matn1_TextChanged (Old As String, N";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="myFunc.update_tamrin13(1,et_name1.Text,et_matn1.T";
Debug.ShouldStop(2048);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1)),(Object)(tamrin13_activity.mostCurrent._et_name1.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn1.runMethod(true,"getText")));
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
public static RemoteObject  _et_matn2_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_matn2_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,71);
if (RapidSub.canDelegate("et_matn2_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_matn2_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 71;BA.debugLine="Private Sub et_matn2_TextChanged (Old As String, N";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="myFunc.update_tamrin13(2,et_name2.Text,et_matn2.T";
Debug.ShouldStop(128);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2)),(Object)(tamrin13_activity.mostCurrent._et_name2.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn2.runMethod(true,"getText")));
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
public static RemoteObject  _et_matn3_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_matn3_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,66);
if (RapidSub.canDelegate("et_matn3_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_matn3_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 66;BA.debugLine="Private Sub et_matn3_TextChanged (Old As String, N";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="myFunc.update_tamrin13(3,et_name3.Text,et_matn3.T";
Debug.ShouldStop(4);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3)),(Object)(tamrin13_activity.mostCurrent._et_name3.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn3.runMethod(true,"getText")));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_name1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_name1_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,87);
if (RapidSub.canDelegate("et_name1_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_name1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 87;BA.debugLine="Private Sub et_name1_TextChanged (Old As String, N";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="myFunc.update_tamrin13(1,et_name1.Text,et_matn1.T";
Debug.ShouldStop(16777216);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1)),(Object)(tamrin13_activity.mostCurrent._et_name1.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn1.runMethod(true,"getText")));
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
public static RemoteObject  _et_name2_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_name2_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,83);
if (RapidSub.canDelegate("et_name2_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_name2_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 83;BA.debugLine="Private Sub et_name2_TextChanged (Old As String, N";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="myFunc.update_tamrin13(2,et_name2.Text,et_matn2.T";
Debug.ShouldStop(524288);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2)),(Object)(tamrin13_activity.mostCurrent._et_name2.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn2.runMethod(true,"getText")));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_name3_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_name3_TextChanged (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,79);
if (RapidSub.canDelegate("et_name3_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","et_name3_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 79;BA.debugLine="Private Sub et_name3_TextChanged (Old As String, N";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="myFunc.update_tamrin13(3,et_name3.Text,et_matn3.T";
Debug.ShouldStop(32768);
tamrin13_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin13" /*RemoteObject*/ ,tamrin13_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3)),(Object)(tamrin13_activity.mostCurrent._et_name3.runMethod(true,"getText")),(Object)(tamrin13_activity.mostCurrent._et_matn3.runMethod(true,"getText")));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_name1 As EditText";
tamrin13_activity.mostCurrent._et_name1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_matn1 As EditText";
tamrin13_activity.mostCurrent._et_matn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_matn2 As EditText";
tamrin13_activity.mostCurrent._et_matn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_name2 As EditText";
tamrin13_activity.mostCurrent._et_name2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_name3 As EditText";
tamrin13_activity.mostCurrent._et_name3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private et_matn3 As EditText";
tamrin13_activity.mostCurrent._et_matn3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,96);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","lbl_back_click");}
 BA.debugLineNum = 96;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
tamrin13_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _null_change(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("null_change (tamrin13_activity) ","tamrin13_activity",13,tamrin13_activity.mostCurrent.activityBA,tamrin13_activity.mostCurrent,48);
if (RapidSub.canDelegate("null_change")) { return ir.taravatgroup.shokrgozari.tamrin13_activity.remoteMe.runUserSub(false, "tamrin13_activity","null_change", _str);}
RemoteObject _res_str = RemoteObject.createImmutable("");
Debug.locals.put("str", _str);
 BA.debugLineNum = 48;BA.debugLine="Sub null_change (str As String) As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Dim res_str As String=str";
Debug.ShouldStop(65536);
_res_str = _str;Debug.locals.put("res_str", _res_str);Debug.locals.put("res_str", _res_str);
 BA.debugLineNum = 51;BA.debugLine="If(str=\"null\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_str,RemoteObject.createImmutable("null")))) { 
 BA.debugLineNum = 52;BA.debugLine="res_str=\"\"";
Debug.ShouldStop(524288);
_res_str = BA.ObjectToString("");Debug.locals.put("res_str", _res_str);
 };
 BA.debugLineNum = 54;BA.debugLine="Return  res_str";
Debug.ShouldStop(2097152);
if (true) return _res_str;
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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