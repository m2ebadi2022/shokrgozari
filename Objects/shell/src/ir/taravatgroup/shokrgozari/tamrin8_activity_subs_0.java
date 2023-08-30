package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin8_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","activity_create", _firsttime);}
RemoteObject _ls_get_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"tamrin8_layout\")";
Debug.ShouldStop(-2147483648);
tamrin8_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin8_layout")),tamrin8_activity.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="ScrollView1.Panel.LoadLayout(\"tamrin8_items\")";
Debug.ShouldStop(1);
tamrin8_activity.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin8_items")),tamrin8_activity.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Dim ls_get_content As List";
Debug.ShouldStop(8);
_ls_get_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_get_content", _ls_get_content);
 BA.debugLineNum = 37;BA.debugLine="ls_get_content.Initialize";
Debug.ShouldStop(16);
_ls_get_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="ls_get_content=myFunc.get_all_tamrin8";
Debug.ShouldStop(32);
_ls_get_content = tamrin8_activity.mostCurrent._myfunc.runMethod(false,"_get_all_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA);Debug.locals.put("ls_get_content", _ls_get_content);
 BA.debugLineNum = 40;BA.debugLine="For i=0 To 10";
Debug.ShouldStop(128);
{
final int step6 = 1;
final int limit6 = 10;
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 42;BA.debugLine="If(ls_get_content.Get(i)=Null)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("n",_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))) { 
 BA.debugLineNum = 43;BA.debugLine="ls_get_content.Set(i,\"\")";
Debug.ShouldStop(1024);
_ls_get_content.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, _i)),(Object)((RemoteObject.createImmutable(""))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 47;BA.debugLine="et_mohebat1.Text=ls_get_content.Get(0)";
Debug.ShouldStop(16384);
tamrin8_activity.mostCurrent._et_mohebat1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 48;BA.debugLine="et_mohebat2.Text=ls_get_content.Get(1)";
Debug.ShouldStop(32768);
tamrin8_activity.mostCurrent._et_mohebat2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 49;BA.debugLine="et_mohebat3.Text=ls_get_content.Get(2)";
Debug.ShouldStop(65536);
tamrin8_activity.mostCurrent._et_mohebat3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 50;BA.debugLine="et_mohebat4.Text=ls_get_content.Get(3)";
Debug.ShouldStop(131072);
tamrin8_activity.mostCurrent._et_mohebat4.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 51;BA.debugLine="et_mohebat5.Text=ls_get_content.Get(4)";
Debug.ShouldStop(262144);
tamrin8_activity.mostCurrent._et_mohebat5.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 52;BA.debugLine="et_mohebat6.Text=ls_get_content.Get(5)";
Debug.ShouldStop(524288);
tamrin8_activity.mostCurrent._et_mohebat6.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 53;BA.debugLine="et_mohebat7.Text=ls_get_content.Get(6)";
Debug.ShouldStop(1048576);
tamrin8_activity.mostCurrent._et_mohebat7.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6)))));
 BA.debugLineNum = 54;BA.debugLine="et_mohebat8.Text=ls_get_content.Get(7)";
Debug.ShouldStop(2097152);
tamrin8_activity.mostCurrent._et_mohebat8.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7)))));
 BA.debugLineNum = 55;BA.debugLine="et_mohebat9.Text=ls_get_content.Get(8)";
Debug.ShouldStop(4194304);
tamrin8_activity.mostCurrent._et_mohebat9.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 56;BA.debugLine="et_mohebat10.Text=ls_get_content.Get(9)";
Debug.ShouldStop(8388608);
tamrin8_activity.mostCurrent._et_mohebat10.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9)))));
 BA.debugLineNum = 57;BA.debugLine="et_moshkel.Text=ls_get_content.Get(10)";
Debug.ShouldStop(16777216);
tamrin8_activity.mostCurrent._et_moshkel.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_get_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_KeyPress (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,126);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 126;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin8_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 128;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(-2147483648);
_lbl_back_click();
 BA.debugLineNum = 129;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return tamrin8_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 131;BA.debugLine="Return False";
Debug.ShouldStop(4);
if (true) return tamrin8_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,67);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,63);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","activity_resume");}
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("et_mohebat1_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,108);
if (RapidSub.canDelegate("et_mohebat1_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 108;BA.debugLine="Private Sub et_mohebat1_TextChanged (Old As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="myFunc.update_tamrin8(1,New)";
Debug.ShouldStop(4096);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 1)),(Object)(_new));
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
public static RemoteObject  _et_mohebat10_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat10_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,72);
if (RapidSub.canDelegate("et_mohebat10_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat10_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 72;BA.debugLine="Private Sub et_mohebat10_TextChanged (Old As Strin";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="myFunc.update_tamrin8(10,New)";
Debug.ShouldStop(256);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 10)),(Object)(_new));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("et_mohebat2_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,104);
if (RapidSub.canDelegate("et_mohebat2_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat2_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 104;BA.debugLine="Private Sub et_mohebat2_TextChanged (Old As String";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="myFunc.update_tamrin8(2,New)";
Debug.ShouldStop(256);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 2)),(Object)(_new));
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
public static RemoteObject  _et_mohebat3_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat3_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,100);
if (RapidSub.canDelegate("et_mohebat3_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat3_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 100;BA.debugLine="Private Sub et_mohebat3_TextChanged (Old As String";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="myFunc.update_tamrin8(3,New)";
Debug.ShouldStop(16);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 3)),(Object)(_new));
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
public static RemoteObject  _et_mohebat4_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat4_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,96);
if (RapidSub.canDelegate("et_mohebat4_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat4_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 96;BA.debugLine="Private Sub et_mohebat4_TextChanged (Old As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="myFunc.update_tamrin8(4,New)";
Debug.ShouldStop(1);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 4)),(Object)(_new));
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
public static RemoteObject  _et_mohebat5_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat5_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,92);
if (RapidSub.canDelegate("et_mohebat5_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat5_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 92;BA.debugLine="Private Sub et_mohebat5_TextChanged (Old As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="myFunc.update_tamrin8(5,New)";
Debug.ShouldStop(268435456);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 5)),(Object)(_new));
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
public static RemoteObject  _et_mohebat6_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat6_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,88);
if (RapidSub.canDelegate("et_mohebat6_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat6_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 88;BA.debugLine="Private Sub et_mohebat6_TextChanged (Old As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="myFunc.update_tamrin8(6,New)";
Debug.ShouldStop(16777216);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 6)),(Object)(_new));
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
public static RemoteObject  _et_mohebat7_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat7_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,84);
if (RapidSub.canDelegate("et_mohebat7_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat7_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 84;BA.debugLine="Private Sub et_mohebat7_TextChanged (Old As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="myFunc.update_tamrin8(7,New)";
Debug.ShouldStop(1048576);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 7)),(Object)(_new));
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
public static RemoteObject  _et_mohebat8_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat8_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,80);
if (RapidSub.canDelegate("et_mohebat8_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat8_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 80;BA.debugLine="Private Sub et_mohebat8_TextChanged (Old As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="myFunc.update_tamrin8(8,New)";
Debug.ShouldStop(65536);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 8)),(Object)(_new));
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
public static RemoteObject  _et_mohebat9_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat9_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,76);
if (RapidSub.canDelegate("et_mohebat9_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_mohebat9_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 76;BA.debugLine="Private Sub et_mohebat9_TextChanged (Old As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="myFunc.update_tamrin8(9,New)";
Debug.ShouldStop(4096);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 9)),(Object)(_new));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_moshkel_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_moshkel_TextChanged (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,112);
if (RapidSub.canDelegate("et_moshkel_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","et_moshkel_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 112;BA.debugLine="Private Sub et_moshkel_TextChanged (Old As String,";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="myFunc.update_tamrin8(11,New)";
Debug.ShouldStop(65536);
tamrin8_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrin8" /*RemoteObject*/ ,tamrin8_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 11)),(Object)(_new));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
tamrin8_activity.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_mohebat1 As EditText";
tamrin8_activity.mostCurrent._et_mohebat1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_mohebat2 As EditText";
tamrin8_activity.mostCurrent._et_mohebat2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_mohebat3 As EditText";
tamrin8_activity.mostCurrent._et_mohebat3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_mohebat4 As EditText";
tamrin8_activity.mostCurrent._et_mohebat4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private et_mohebat5 As EditText";
tamrin8_activity.mostCurrent._et_mohebat5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private et_mohebat6 As EditText";
tamrin8_activity.mostCurrent._et_mohebat6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private et_mohebat7 As EditText";
tamrin8_activity.mostCurrent._et_mohebat7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private et_mohebat8 As EditText";
tamrin8_activity.mostCurrent._et_mohebat8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private et_mohebat9 As EditText";
tamrin8_activity.mostCurrent._et_mohebat9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private et_mohebat10 As EditText";
tamrin8_activity.mostCurrent._et_mohebat10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private et_moshkel As EditText";
tamrin8_activity.mostCurrent._et_moshkel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin8_activity) ","tamrin8_activity",6,tamrin8_activity.mostCurrent.activityBA,tamrin8_activity.mostCurrent,119);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin8_activity.remoteMe.runUserSub(false, "tamrin8_activity","lbl_back_click");}
 BA.debugLineNum = 119;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 121;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
tamrin8_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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