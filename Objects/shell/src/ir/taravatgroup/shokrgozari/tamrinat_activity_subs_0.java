package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrinat_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"tamrinat_layout\")";
Debug.ShouldStop(268435456);
tamrinat_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrinat_layout")),tamrinat_activity.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="tim_scroll.Initialize(\"tim_scroll\",300)";
Debug.ShouldStop(1073741824);
tamrinat_activity._tim_scroll.runVoidMethod ("Initialize",tamrinat_activity.processBA,(Object)(BA.ObjectToString("tim_scroll")),(Object)(BA.numberCast(long.class, 300)));
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,42);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,37);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","activity_resume");}
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="fill_list";
Debug.ShouldStop(32);
_fill_list();
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("fill_list (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,64);
if (RapidSub.canDelegate("fill_list")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","fill_list");}
RemoteObject _list_rozha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _strfunc = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _list_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _code_state = RemoteObject.createImmutable(0);
 BA.debugLineNum = 64;BA.debugLine="Sub fill_list";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="cusListV_data.Clear";
Debug.ShouldStop(2);
tamrinat_activity.mostCurrent._cuslistv_data.runVoidMethod ("_clear");
 BA.debugLineNum = 68;BA.debugLine="Dim list_rozha As List";
Debug.ShouldStop(8);
_list_rozha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_rozha", _list_rozha);
 BA.debugLineNum = 69;BA.debugLine="list_rozha.Initialize";
Debug.ShouldStop(16);
_list_rozha.runVoidMethod ("Initialize");
 BA.debugLineNum = 70;BA.debugLine="list_rozha=myFunc.get_rozha";
Debug.ShouldStop(32);
_list_rozha = tamrinat_activity.mostCurrent._myfunc.runMethod(false,"_get_rozha" /*RemoteObject*/ ,tamrinat_activity.mostCurrent.activityBA);Debug.locals.put("list_rozha", _list_rozha);
 BA.debugLineNum = 72;BA.debugLine="Dim strFunc As StringFunctions";
Debug.ShouldStop(128);
_strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strFunc", _strfunc);
 BA.debugLineNum = 73;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(256);
_strfunc.runVoidMethod ("_initialize",tamrinat_activity.processBA);
 BA.debugLineNum = 74;BA.debugLine="Dim list_roz As List";
Debug.ShouldStop(512);
_list_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_roz", _list_roz);
 BA.debugLineNum = 75;BA.debugLine="list_roz.Initialize";
Debug.ShouldStop(1024);
_list_roz.runVoidMethod ("Initialize");
 BA.debugLineNum = 78;BA.debugLine="For i=0 To list_rozha.Size-1";
Debug.ShouldStop(8192);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_list_rozha.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 80;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(32768);
tamrinat_activity.mostCurrent._p = tamrinat_activity.mostCurrent._xui.runMethod(false,"CreatePanel",tamrinat_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 82;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
Debug.ShouldStop(131072);
tamrinat_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tamrinat_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),tamrinat_activity.mostCurrent.activityBA)),(Object)(tamrinat_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))));
 BA.debugLineNum = 83;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
Debug.ShouldStop(262144);
tamrinat_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_rozha_tamrin")),tamrinat_activity.mostCurrent.activityBA);
 BA.debugLineNum = 86;BA.debugLine="cusListV_data.Add(p,i)";
Debug.ShouldStop(2097152);
tamrinat_activity.mostCurrent._cuslistv_data.runVoidMethod ("_add",(Object)(tamrinat_activity.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 89;BA.debugLine="Dim list_roz As List";
Debug.ShouldStop(16777216);
_list_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_roz", _list_roz);
 BA.debugLineNum = 90;BA.debugLine="list_roz.Initialize";
Debug.ShouldStop(33554432);
_list_roz.runVoidMethod ("Initialize");
 BA.debugLineNum = 91;BA.debugLine="list_roz=strFunc.Split(list_rozha.Get(i) , \"@\")";
Debug.ShouldStop(67108864);
_list_roz = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_list_rozha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_roz", _list_roz);
 BA.debugLineNum = 94;BA.debugLine="lbl_roz.Text=list_roz.Get(0)";
Debug.ShouldStop(536870912);
tamrinat_activity.mostCurrent._lbl_roz.runMethod(true,"setText",BA.ObjectToCharSequence(_list_roz.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 96;BA.debugLine="pan_roz.Tag=i+1";
Debug.ShouldStop(-2147483648);
tamrinat_activity.mostCurrent._pan_roz.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 98;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamrin1";
Debug.ShouldStop(2);
_code_state = tamrinat_activity.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin1_byroz" /*RemoteObject*/ ,tamrinat_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("code_state", _code_state);Debug.locals.put("code_state", _code_state);
 BA.debugLineNum = 99;BA.debugLine="If(code_state=10)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 100;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(8);
tamrinat_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 BA.debugLineNum = 101;BA.debugLine="lbl_icon_roz.Visible=True";
Debug.ShouldStop(16);
tamrinat_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setVisible",tamrinat_activity.mostCurrent.__c.getField(true,"True"));
 }else 
{ BA.debugLineNum = 103;BA.debugLine="Else If(code_state = 0 )Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 104;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
Debug.ShouldStop(128);
tamrinat_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff211f)));
 BA.debugLineNum = 106;BA.debugLine="If(pos_scroll= 0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",tamrinat_activity._pos_scroll,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 107;BA.debugLine="pos_scroll=i";
Debug.ShouldStop(1024);
tamrinat_activity._pos_scroll = BA.numberCast(int.class, _i);
 };
 }else {
 BA.debugLineNum = 114;BA.debugLine="lbl_icon_roz.Visible=True";
Debug.ShouldStop(131072);
tamrinat_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setVisible",tamrinat_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 115;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
Debug.ShouldStop(262144);
tamrinat_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff9900)));
 }}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 121;BA.debugLine="If (isfitest=True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",tamrinat_activity._isfitest,tamrinat_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 122;BA.debugLine="tim_scroll.Enabled=True";
Debug.ShouldStop(33554432);
tamrinat_activity._tim_scroll.runMethod(true,"setEnabled",tamrinat_activity.mostCurrent.__c.getField(true,"True"));
 };
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private cusListV_data As CustomListView";
tamrinat_activity.mostCurrent._cuslistv_data = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
tamrinat_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
tamrinat_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim pos_scroll As Int=0";
tamrinat_activity._pos_scroll = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_roz As Label";
tamrinat_activity.mostCurrent._lbl_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_icon_roz As Label";
tamrinat_activity.mostCurrent._lbl_icon_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pan_roz As Panel";
tamrinat_activity.mostCurrent._pan_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim isfitest As Boolean=True";
tamrinat_activity._isfitest = tamrinat_activity.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,47);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","lbl_back_click");}
 BA.debugLineNum = 47;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
tamrinat_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("pan_roz_Click (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,54);
if (RapidSub.canDelegate("pan_roz_click")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","pan_roz_click");}
RemoteObject _this_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 54;BA.debugLine="Private Sub pan_roz_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Dim this_roz As Panel=Sender";
Debug.ShouldStop(4194304);
_this_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_this_roz = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), tamrinat_activity.mostCurrent.__c.runMethod(false,"Sender",tamrinat_activity.mostCurrent.activityBA));Debug.locals.put("this_roz", _this_roz);Debug.locals.put("this_roz", _this_roz);
 BA.debugLineNum = 57;BA.debugLine="Main.current_roz_tamrin=this_roz.Tag";
Debug.ShouldStop(16777216);
tamrinat_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/  = BA.numberCast(int.class, _this_roz.runMethod(false,"getTag"));
 BA.debugLineNum = 58;BA.debugLine="isfitest=False";
Debug.ShouldStop(33554432);
tamrinat_activity._isfitest = tamrinat_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 59;BA.debugLine="StartActivity(tamrin_roz_activity)";
Debug.ShouldStop(67108864);
tamrinat_activity.mostCurrent.__c.runVoidMethod ("StartActivity",tamrinat_activity.processBA,(Object)((tamrinat_activity.mostCurrent._tamrin_roz_activity.getObject())));
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim tim_scroll As Timer";
tamrinat_activity._tim_scroll = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tim_scroll_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_scroll_Tick (tamrinat_activity) ","tamrinat_activity",4,tamrinat_activity.mostCurrent.activityBA,tamrinat_activity.mostCurrent,130);
if (RapidSub.canDelegate("tim_scroll_tick")) { return ir.taravatgroup.shokrgozari.tamrinat_activity.remoteMe.runUserSub(false, "tamrinat_activity","tim_scroll_tick");}
 BA.debugLineNum = 130;BA.debugLine="Sub tim_scroll_Tick";
Debug.ShouldStop(2);
 BA.debugLineNum = 132;BA.debugLine="cusListV_data.ScrollToItem(pos_scroll)";
Debug.ShouldStop(8);
tamrinat_activity.mostCurrent._cuslistv_data.runVoidMethod ("_scrolltoitem",(Object)(tamrinat_activity._pos_scroll));
 BA.debugLineNum = 134;BA.debugLine="tim_scroll.Enabled=False";
Debug.ShouldStop(32);
tamrinat_activity._tim_scroll.runMethod(true,"setEnabled",tamrinat_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}