package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin_roz_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,35);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"tamrin_roz_layout\")";
Debug.ShouldStop(16);
tamrin_roz_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin_roz_layout")),tamrin_roz_activity.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="lbl_titel_roz.Text=\"تمرین روز \"& Main.current_roz";
Debug.ShouldStop(32);
tamrin_roz_activity.mostCurrent._lbl_titel_roz.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تمرین روز "),tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ )));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_KeyPress (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,317);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 317;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 318;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin_roz_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 319;BA.debugLine="If(pan_all_tamrin2.Visible=True)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",tamrin_roz_activity.mostCurrent._pan_all_tamrin2.runMethod(true,"getVisible"),tamrin_roz_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 320;BA.debugLine="pan_all_tamrin2.Visible=False";
Debug.ShouldStop(-2147483648);
tamrin_roz_activity.mostCurrent._pan_all_tamrin2.runMethod(true,"setVisible",tamrin_roz_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 322;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2);
_lbl_back_click();
 };
 BA.debugLineNum = 325;BA.debugLine="Return True";
Debug.ShouldStop(16);
if (true) return tamrin_roz_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 327;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return tamrin_roz_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 329;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Pause (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,49);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Resume (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,45);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","activity_resume");}
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="fill_list";
Debug.ShouldStop(8192);
_fill_list();
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_list() throws Exception{
try {
		Debug.PushSubsStack("fill_list (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,71);
if (RapidSub.canDelegate("fill_list")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","fill_list");}
RemoteObject _list_rozha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str_html = RemoteObject.createImmutable("");
RemoteObject _strfunc = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _list_tamrinat = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_tamrinat_state = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _code_state = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin2 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin3 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin8 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin13 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin14 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin16 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin19 = RemoteObject.createImmutable(0);
RemoteObject _state_tamrin25 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 71;BA.debugLine="Sub fill_list";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="CustomLV_tamrinat.Clear";
Debug.ShouldStop(256);
tamrin_roz_activity.mostCurrent._customlv_tamrinat.runVoidMethod ("_clear");
 BA.debugLineNum = 75;BA.debugLine="Dim list_rozha As List";
Debug.ShouldStop(1024);
_list_rozha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_rozha", _list_rozha);
 BA.debugLineNum = 76;BA.debugLine="list_rozha.Initialize";
Debug.ShouldStop(2048);
_list_rozha.runVoidMethod ("Initialize");
 BA.debugLineNum = 77;BA.debugLine="list_rozha=myFunc.get_roz_byId(Main.current_roz_t";
Debug.ShouldStop(4096);
_list_rozha = tamrin_roz_activity.mostCurrent._myfunc.runMethod(false,"_get_roz_byid" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ));Debug.locals.put("list_rozha", _list_rozha);
 BA.debugLineNum = 80;BA.debugLine="Dim str_html As String";
Debug.ShouldStop(32768);
_str_html = RemoteObject.createImmutable("");Debug.locals.put("str_html", _str_html);
 BA.debugLineNum = 81;BA.debugLine="str_html=\"<html><head><meta name='viewport' conte";
Debug.ShouldStop(65536);
_str_html = RemoteObject.concat(RemoteObject.createImmutable("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word;'><b>"),_list_rozha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("</b><p>"),_list_rozha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("<br></body></html>"));Debug.locals.put("str_html", _str_html);
 BA.debugLineNum = 84;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(524288);
tamrin_roz_activity.mostCurrent._webview1.runVoidMethod ("setColor",tamrin_roz_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 85;BA.debugLine="WebView1.LoadHtml(str_html)";
Debug.ShouldStop(1048576);
tamrin_roz_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(_str_html));
 BA.debugLineNum = 87;BA.debugLine="Dim strFunc As StringFunctions";
Debug.ShouldStop(4194304);
_strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strFunc", _strfunc);
 BA.debugLineNum = 88;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(8388608);
_strfunc.runVoidMethod ("_initialize",tamrin_roz_activity.processBA);
 BA.debugLineNum = 90;BA.debugLine="Dim list_tamrinat As List";
Debug.ShouldStop(33554432);
_list_tamrinat = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_tamrinat", _list_tamrinat);
 BA.debugLineNum = 91;BA.debugLine="list_tamrinat.Initialize";
Debug.ShouldStop(67108864);
_list_tamrinat.runVoidMethod ("Initialize");
 BA.debugLineNum = 92;BA.debugLine="list_tamrinat=strFunc.Split(list_rozha.Get(2) , \"";
Debug.ShouldStop(134217728);
_list_tamrinat = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_list_rozha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))),(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("list_tamrinat", _list_tamrinat);
 BA.debugLineNum = 94;BA.debugLine="Dim list_tamrinat_state As List";
Debug.ShouldStop(536870912);
_list_tamrinat_state = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_tamrinat_state", _list_tamrinat_state);
 BA.debugLineNum = 95;BA.debugLine="list_tamrinat_state.Initialize";
Debug.ShouldStop(1073741824);
_list_tamrinat_state.runVoidMethod ("Initialize");
 BA.debugLineNum = 96;BA.debugLine="list_tamrinat_state=strFunc.Split(list_rozha.Get(";
Debug.ShouldStop(-2147483648);
_list_tamrinat_state = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_list_rozha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))))),(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("list_tamrinat_state", _list_tamrinat_state);
 BA.debugLineNum = 99;BA.debugLine="For i=0 To list_tamrinat.Size-1";
Debug.ShouldStop(4);
{
final int step17 = 1;
final int limit17 = RemoteObject.solve(new RemoteObject[] {_list_tamrinat.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step17 > 0 && _i <= limit17) || (step17 < 0 && _i >= limit17) ;_i = ((int)(0 + _i + step17))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 101;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(16);
tamrin_roz_activity.mostCurrent._p = tamrin_roz_activity.mostCurrent._xui.runMethod(false,"CreatePanel",tamrin_roz_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 103;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 80dip)";
Debug.ShouldStop(64);
tamrin_roz_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tamrin_roz_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),tamrin_roz_activity.mostCurrent.activityBA)),(Object)(tamrin_roz_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))));
 BA.debugLineNum = 105;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
Debug.ShouldStop(256);
tamrin_roz_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_rozha_tamrin")),tamrin_roz_activity.mostCurrent.activityBA);
 BA.debugLineNum = 106;BA.debugLine="lbl_icon_roz.Visible=True";
Debug.ShouldStop(512);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setVisible",tamrin_roz_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 108;BA.debugLine="CustomLV_tamrinat.Add(p,i)";
Debug.ShouldStop(2048);
tamrin_roz_activity.mostCurrent._customlv_tamrinat.runVoidMethod ("_add",(Object)(tamrin_roz_activity.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 109;BA.debugLine="pan_roz.Elevation=0";
Debug.ShouldStop(4096);
tamrin_roz_activity.mostCurrent._pan_roz.runMethod(true,"setElevation",BA.numberCast(float.class, 0));
 BA.debugLineNum = 111;BA.debugLine="pan_roz.Tag=list_tamrinat.Get(i).As(Int)";
Debug.ShouldStop(16384);
tamrin_roz_activity.mostCurrent._pan_roz.runMethod(false,"setTag",((BA.numberCast(int.class, _list_tamrinat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))));
 BA.debugLineNum = 113;BA.debugLine="lbl_roz.Text=\"تمرین \"&(i+1)& \" : \"&tamrin_name(p";
Debug.ShouldStop(65536);
tamrin_roz_activity.mostCurrent._lbl_roz.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تمرین "),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(" : "),_tamrin_name(BA.numberCast(int.class, tamrin_roz_activity.mostCurrent._pan_roz.runMethod(false,"getTag"))))));
 BA.debugLineNum = 128;BA.debugLine="Select pan_roz.Tag.As(Int)";
Debug.ShouldStop(-2147483648);
switch (BA.switchObjectToInt((BA.numberCast(int.class, tamrin_roz_activity.mostCurrent._pan_roz.runMethod(false,"getTag"))),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12),BA.numberCast(int.class, 15),BA.numberCast(int.class, 17),BA.numberCast(int.class, 18),BA.numberCast(int.class, 20),BA.numberCast(int.class, 21),BA.numberCast(int.class, 24),BA.numberCast(int.class, 26),BA.numberCast(int.class, 28),BA.numberCast(int.class, 29),BA.numberCast(int.class, 3),BA.numberCast(int.class, 8),BA.numberCast(int.class, 13),BA.numberCast(int.class, 14),BA.numberCast(int.class, 16),BA.numberCast(int.class, 19),BA.numberCast(int.class, 25))) {
case 0: {
 BA.debugLineNum = 130;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamri";
Debug.ShouldStop(2);
_code_state = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin1_byroz" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ));Debug.locals.put("code_state", _code_state);Debug.locals.put("code_state", _code_state);
 BA.debugLineNum = 131;BA.debugLine="If(code_state=10)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 132;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(8);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 133;BA.debugLine="Else If(code_state = 0 )Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 134;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(32);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 136;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(128);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: 
case 18: {
 BA.debugLineNum = 139;BA.debugLine="Dim state_tamrin2 As Int = myFunc.get_state(Ma";
Debug.ShouldStop(1024);
_state_tamrin2 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)((BA.numberCast(int.class, tamrin_roz_activity.mostCurrent._pan_roz.runMethod(false,"getTag")))));Debug.locals.put("state_tamrin2", _state_tamrin2);Debug.locals.put("state_tamrin2", _state_tamrin2);
 BA.debugLineNum = 140;BA.debugLine="If(state_tamrin2 = 0 )Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_state_tamrin2,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 141;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(4096);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 143;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(16384);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 };
 break; }
case 19: {
 BA.debugLineNum = 146;BA.debugLine="Dim state_tamrin3 As Int=myFunc.get_State_tamr";
Debug.ShouldStop(131072);
_state_tamrin3 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrinat_saved" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("state_tamrin3", _state_tamrin3);Debug.locals.put("state_tamrin3", _state_tamrin3);
 BA.debugLineNum = 147;BA.debugLine="If(state_tamrin3=3)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_state_tamrin3,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 148;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(524288);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 149;BA.debugLine="Else If(state_tamrin3 = 0 )Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_state_tamrin3,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 150;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(2097152);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 152;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 20: {
 BA.debugLineNum = 156;BA.debugLine="Dim state_tamrin8 As Int=myFunc.get_state_tamr";
Debug.ShouldStop(134217728);
_state_tamrin8 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin8" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA);Debug.locals.put("state_tamrin8", _state_tamrin8);Debug.locals.put("state_tamrin8", _state_tamrin8);
 BA.debugLineNum = 157;BA.debugLine="If(state_tamrin8>10)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",_state_tamrin8,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 158;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(536870912);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 159;BA.debugLine="Else If(state_tamrin8 = 0 )Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_state_tamrin8,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 160;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(-2147483648);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 162;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(2);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 21: {
 BA.debugLineNum = 167;BA.debugLine="Dim state_tamrin13 As Int=myFunc.get_state_tam";
Debug.ShouldStop(64);
_state_tamrin13 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin13" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA);Debug.locals.put("state_tamrin13", _state_tamrin13);Debug.locals.put("state_tamrin13", _state_tamrin13);
 BA.debugLineNum = 168;BA.debugLine="If(state_tamrin13=3)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_state_tamrin13,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 169;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(256);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 170;BA.debugLine="Else If(state_tamrin13 = 0 )Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_state_tamrin13,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 171;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(1024);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 173;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(4096);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 22: {
 BA.debugLineNum = 178;BA.debugLine="Dim state_tamrin14 As Int=myFunc.get_state_tam";
Debug.ShouldStop(131072);
_state_tamrin14 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin14" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA);Debug.locals.put("state_tamrin14", _state_tamrin14);Debug.locals.put("state_tamrin14", _state_tamrin14);
 BA.debugLineNum = 179;BA.debugLine="If(state_tamrin14=10)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_state_tamrin14,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 180;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(524288);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 181;BA.debugLine="Else If(state_tamrin14 = 0 )Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_state_tamrin14,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 182;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(2097152);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 184;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 23: {
 BA.debugLineNum = 188;BA.debugLine="Dim state_tamrin16 As Int=myFunc.get_state_tam";
Debug.ShouldStop(134217728);
_state_tamrin16 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin16" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA);Debug.locals.put("state_tamrin16", _state_tamrin16);Debug.locals.put("state_tamrin16", _state_tamrin16);
 BA.debugLineNum = 189;BA.debugLine="If(state_tamrin16>10)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",_state_tamrin16,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 190;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(536870912);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 191;BA.debugLine="Else If(state_tamrin16 = 0 )Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_state_tamrin16,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 192;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(-2147483648);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 194;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(2);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
case 24: {
 BA.debugLineNum = 199;BA.debugLine="Dim state_tamrin19 As Int=myFunc.get_state_tam";
Debug.ShouldStop(64);
_state_tamrin19 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin19" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA);Debug.locals.put("state_tamrin19", _state_tamrin19);Debug.locals.put("state_tamrin19", _state_tamrin19);
 BA.debugLineNum = 200;BA.debugLine="If(state_tamrin19>2)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",_state_tamrin19,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 201;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(256);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 202;BA.debugLine="Else If(state_tamrin19 = 0 )Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_state_tamrin19,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 203;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(1024);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 205;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(4096);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 BA.debugLineNum = 208;BA.debugLine="Log(state_tamrin19)";
Debug.ShouldStop(32768);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("LogImpl","44653193",BA.NumberToString(_state_tamrin19),0);
 break; }
case 25: {
 BA.debugLineNum = 210;BA.debugLine="Dim state_tamrin25 As Int=myFunc.get_State_tam";
Debug.ShouldStop(131072);
_state_tamrin25 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrinat_saved" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 25)));Debug.locals.put("state_tamrin25", _state_tamrin25);Debug.locals.put("state_tamrin25", _state_tamrin25);
 BA.debugLineNum = 211;BA.debugLine="If(state_tamrin25=3)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_state_tamrin25,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 212;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(524288);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 }else 
{ BA.debugLineNum = 213;BA.debugLine="Else If(state_tamrin25 = 0 )Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_state_tamrin25,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 214;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(2097152);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 }else {
 BA.debugLineNum = 216;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 break; }
}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_titel_roz As Label";
tamrin_roz_activity.mostCurrent._lbl_titel_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private CustomLV_tamrinat As CustomListView";
tamrin_roz_activity.mostCurrent._customlv_tamrinat = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 20;BA.debugLine="Private xui As XUI";
tamrin_roz_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 21;BA.debugLine="Dim p As B4XView";
tamrin_roz_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_roz As Label";
tamrin_roz_activity.mostCurrent._lbl_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_icon_roz As Label";
tamrin_roz_activity.mostCurrent._lbl_icon_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pan_roz As Panel";
tamrin_roz_activity.mostCurrent._pan_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private WebView1 As WebView";
tamrin_roz_activity.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private et_tamrin2 As EditText";
tamrin_roz_activity.mostCurrent._et_tamrin2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private pan_all_tamrin2 As Panel";
tamrin_roz_activity.mostCurrent._pan_all_tamrin2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_save_tamrin2 As Label";
tamrin_roz_activity.mostCurrent._lbl_save_tamrin2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,55);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","lbl_back_click");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_tamrin2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_tamrin2_Click (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,298);
if (RapidSub.canDelegate("lbl_save_tamrin2_click")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","lbl_save_tamrin2_click");}
 BA.debugLineNum = 298;BA.debugLine="Private Sub lbl_save_tamrin2_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 299;BA.debugLine="If(lbl_save_tamrin2.Tag.As(Int)=1)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",(BA.numberCast(int.class, tamrin_roz_activity.mostCurrent._lbl_save_tamrin2.runMethod(false,"getTag"))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 300;BA.debugLine="Select Main.current_tamrin";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ,BA.numberCast(int.class, 2),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12),BA.numberCast(int.class, 15),BA.numberCast(int.class, 17),BA.numberCast(int.class, 18),BA.numberCast(int.class, 20),BA.numberCast(int.class, 21),BA.numberCast(int.class, 24),BA.numberCast(int.class, 26),BA.numberCast(int.class, 28),BA.numberCast(int.class, 29))) {
case 0: 
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: {
 BA.debugLineNum = 302;BA.debugLine="myFunc.setState(Main.current_roz_tamrin,Main.c";
Debug.ShouldStop(8192);
tamrin_roz_activity.mostCurrent._myfunc.runVoidMethod ("_setstate" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ));
 BA.debugLineNum = 303;BA.debugLine="pan_all_tamrin2_Click";
Debug.ShouldStop(16384);
_pan_all_tamrin2_click();
 BA.debugLineNum = 304;BA.debugLine="fill_list";
Debug.ShouldStop(32768);
_fill_list();
 break; }
default: {
 BA.debugLineNum = 307;BA.debugLine="pan_all_tamrin2_Click";
Debug.ShouldStop(262144);
_pan_all_tamrin2_click();
 break; }
}
;
 }else {
 BA.debugLineNum = 310;BA.debugLine="pan_all_tamrin2_Click";
Debug.ShouldStop(2097152);
_pan_all_tamrin2_click();
 };
 BA.debugLineNum = 314;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_tamrin2_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_tamrin2_Click (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,66);
if (RapidSub.canDelegate("pan_all_tamrin2_click")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","pan_all_tamrin2_click");}
 BA.debugLineNum = 66;BA.debugLine="Private Sub pan_all_tamrin2_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="pan_all_tamrin2.Visible=False";
Debug.ShouldStop(4);
tamrin_roz_activity.mostCurrent._pan_all_tamrin2.runMethod(true,"setVisible",tamrin_roz_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pan_roz_click() throws Exception{
try {
		Debug.PushSubsStack("pan_roz_Click (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,236);
if (RapidSub.canDelegate("pan_roz_click")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","pan_roz_click");}
RemoteObject _this_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _state_tamrin2 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 236;BA.debugLine="Private Sub pan_roz_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 237;BA.debugLine="Dim this_tamrin As Panel=Sender";
Debug.ShouldStop(4096);
_this_tamrin = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_this_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), tamrin_roz_activity.mostCurrent.__c.runMethod(false,"Sender",tamrin_roz_activity.mostCurrent.activityBA));Debug.locals.put("this_tamrin", _this_tamrin);Debug.locals.put("this_tamrin", _this_tamrin);
 BA.debugLineNum = 241;BA.debugLine="Select this_tamrin.Tag";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(_this_tamrin.runMethod(false,"getTag"),RemoteObject.createImmutable((1)),RemoteObject.createImmutable((2)),RemoteObject.createImmutable((4)),RemoteObject.createImmutable((5)),RemoteObject.createImmutable((6)),RemoteObject.createImmutable((7)),RemoteObject.createImmutable((9)),RemoteObject.createImmutable((10)),RemoteObject.createImmutable((11)),RemoteObject.createImmutable((12)),RemoteObject.createImmutable((15)),RemoteObject.createImmutable((17)),RemoteObject.createImmutable((18)),RemoteObject.createImmutable((20)),RemoteObject.createImmutable((21)),RemoteObject.createImmutable((24)),RemoteObject.createImmutable((26)),RemoteObject.createImmutable((28)),RemoteObject.createImmutable((29)),RemoteObject.createImmutable((3)),RemoteObject.createImmutable((8)),RemoteObject.createImmutable((13)),RemoteObject.createImmutable((14)),RemoteObject.createImmutable((16)),RemoteObject.createImmutable((19)),RemoteObject.createImmutable((25)))) {
case 0: {
 BA.debugLineNum = 243;BA.debugLine="StartActivity(do_tamrin_roz_layout)";
Debug.ShouldStop(262144);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._do_tamrin_roz_layout.getObject())));
 break; }
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: 
case 18: {
 BA.debugLineNum = 245;BA.debugLine="Main.current_tamrin=this_tamrin.Tag";
Debug.ShouldStop(1048576);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, _this_tamrin.runMethod(false,"getTag"));
 BA.debugLineNum = 246;BA.debugLine="pan_all_tamrin2.Visible=True";
Debug.ShouldStop(2097152);
tamrin_roz_activity.mostCurrent._pan_all_tamrin2.runMethod(true,"setVisible",tamrin_roz_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 248;BA.debugLine="et_tamrin2.Text= myFunc.get_tamrinName(this_tam";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent._et_tamrin2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(tamrin_roz_activity.mostCurrent._myfunc.runMethod(false,"_get_tamrinname" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_tamrin.runMethod(false,"getTag")))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 250;BA.debugLine="Dim state_tamrin2 As Int = myFunc.get_state(Mai";
Debug.ShouldStop(33554432);
_state_tamrin2 = tamrin_roz_activity.mostCurrent._myfunc.runMethod(true,"_get_state" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(tamrin_roz_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, _this_tamrin.runMethod(false,"getTag"))));Debug.locals.put("state_tamrin2", _state_tamrin2);Debug.locals.put("state_tamrin2", _state_tamrin2);
 BA.debugLineNum = 251;BA.debugLine="If(state_tamrin2=0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_state_tamrin2,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 252;BA.debugLine="lbl_save_tamrin2.Color=Colors.Gray";
Debug.ShouldStop(134217728);
tamrin_roz_activity.mostCurrent._lbl_save_tamrin2.runVoidMethod ("setColor",tamrin_roz_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 254;BA.debugLine="lbl_save_tamrin2.Tag=1";
Debug.ShouldStop(536870912);
tamrin_roz_activity.mostCurrent._lbl_save_tamrin2.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 }else {
 BA.debugLineNum = 256;BA.debugLine="lbl_save_tamrin2.Color=Colors.Green";
Debug.ShouldStop(-2147483648);
tamrin_roz_activity.mostCurrent._lbl_save_tamrin2.runVoidMethod ("setColor",tamrin_roz_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 258;BA.debugLine="lbl_save_tamrin2.Tag=0";
Debug.ShouldStop(2);
tamrin_roz_activity.mostCurrent._lbl_save_tamrin2.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 break; }
case 19: {
 BA.debugLineNum = 264;BA.debugLine="Main.current_tamrin=3";
Debug.ShouldStop(128);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 3);
 BA.debugLineNum = 265;BA.debugLine="StartActivity(tamrin3_activity)";
Debug.ShouldStop(256);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin3_activity.getObject())));
 break; }
case 20: {
 BA.debugLineNum = 267;BA.debugLine="Main.current_tamrin=8";
Debug.ShouldStop(1024);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 8);
 BA.debugLineNum = 268;BA.debugLine="StartActivity(tamrin8_activity)";
Debug.ShouldStop(2048);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin8_activity.getObject())));
 break; }
case 21: {
 BA.debugLineNum = 270;BA.debugLine="Main.current_tamrin=13";
Debug.ShouldStop(8192);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 13);
 BA.debugLineNum = 271;BA.debugLine="StartActivity(tamrin13_activity)";
Debug.ShouldStop(16384);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin13_activity.getObject())));
 break; }
case 22: {
 BA.debugLineNum = 273;BA.debugLine="Main.current_tamrin=14";
Debug.ShouldStop(65536);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 14);
 BA.debugLineNum = 274;BA.debugLine="StartActivity(tamrin14_activity)";
Debug.ShouldStop(131072);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin14_activity.getObject())));
 break; }
case 23: {
 BA.debugLineNum = 276;BA.debugLine="Main.current_tamrin=16";
Debug.ShouldStop(524288);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 16);
 BA.debugLineNum = 277;BA.debugLine="StartActivity(tamrin16_activity)";
Debug.ShouldStop(1048576);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin16_activity.getObject())));
 break; }
case 24: {
 BA.debugLineNum = 279;BA.debugLine="Main.current_tamrin=19";
Debug.ShouldStop(4194304);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 19);
 BA.debugLineNum = 280;BA.debugLine="StartActivity(tamrin19_activity)";
Debug.ShouldStop(8388608);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin19_activity.getObject())));
 break; }
case 25: {
 BA.debugLineNum = 284;BA.debugLine="Main.current_tamrin=25";
Debug.ShouldStop(134217728);
tamrin_roz_activity.mostCurrent._main._current_tamrin /*RemoteObject*/  = BA.numberCast(int.class, 25);
 BA.debugLineNum = 285;BA.debugLine="StartActivity(tamrin25_activity)";
Debug.ShouldStop(268435456);
tamrin_roz_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrin_roz_activity.processBA,(Object)((tamrin_roz_activity.mostCurrent._tamrin25_activity.getObject())));
 break; }
}
;
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
public static RemoteObject  _tamrin_name(RemoteObject _num_tamrin) throws Exception{
try {
		Debug.PushSubsStack("tamrin_name (tamrin_roz_activity) ","tamrin_roz_activity",2,tamrin_roz_activity.mostCurrent.activityBA,tamrin_roz_activity.mostCurrent,61);
if (RapidSub.canDelegate("tamrin_name")) { return ir.taravatgroup.shokrgozari.tamrin_roz_activity.remoteMe.runUserSub(false, "tamrin_roz_activity","tamrin_name", _num_tamrin);}
Debug.locals.put("num_tamrin", _num_tamrin);
 BA.debugLineNum = 61;BA.debugLine="Sub tamrin_name (num_tamrin As Int) As String";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="Return myFunc.get_tamrinName(num_tamrin).Get(0)";
Debug.ShouldStop(1073741824);
if (true) return BA.ObjectToString(tamrin_roz_activity.mostCurrent._myfunc.runMethod(false,"_get_tamrinname" /*RemoteObject*/ ,tamrin_roz_activity.mostCurrent.activityBA,(Object)(_num_tamrin)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}