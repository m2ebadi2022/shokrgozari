package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin19_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"tamrin19_layout\")";
Debug.ShouldStop(-2147483648);
tamrin19_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin19_layout")),tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="fill_list";
Debug.ShouldStop(2);
_fill_list();
 BA.debugLineNum = 37;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_KeyPress (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,197);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 197;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin19_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 199;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",tamrin19_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),tamrin19_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 200;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(128);
tamrin19_activity.mostCurrent._pan_all.runMethod(true,"setVisible",tamrin19_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 202;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(512);
_lbl_back_click();
 };
 BA.debugLineNum = 205;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return tamrin19_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 207;BA.debugLine="Return False";
Debug.ShouldStop(16384);
if (true) return tamrin19_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 209;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","activity_resume");}
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("fill_list (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,49);
if (RapidSub.canDelegate("fill_list")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","fill_list");}
 BA.debugLineNum = 49;BA.debugLine="Sub fill_list";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="cusListV_data.Clear";
Debug.ShouldStop(262144);
tamrin19_activity.mostCurrent._cuslistv_data.runVoidMethod ("_clear");
 BA.debugLineNum = 54;BA.debugLine="myFunc.connection_sql";
Debug.ShouldStop(2097152);
tamrin19_activity.mostCurrent._myfunc.runVoidMethod ("_connection_sql" /*RemoteObject*/ ,tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(4194304);
tamrin19_activity.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin19;"))));
 BA.debugLineNum = 58;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(33554432);
while (tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 62;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(536870912);
tamrin19_activity.mostCurrent._p = tamrin19_activity.mostCurrent._xui.runMethod(false,"CreatePanel",tamrin19_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 63;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 85dip)";
Debug.ShouldStop(1073741824);
tamrin19_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tamrin19_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),tamrin19_activity.mostCurrent.activityBA)),(Object)(tamrin19_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 85)))));
 BA.debugLineNum = 64;BA.debugLine="p.LoadLayout(\"item_list_tamrin19\")";
Debug.ShouldStop(-2147483648);
tamrin19_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_tamrin19")),tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 65;BA.debugLine="cusListV_data.Add(p,Main.res.Position)";
Debug.ShouldStop(1);
tamrin19_activity.mostCurrent._cuslistv_data.runVoidMethod ("_add",(Object)(tamrin19_activity.mostCurrent._p),(Object)((tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"getPosition"))));
 BA.debugLineNum = 67;BA.debugLine="lbl_roz.Text=Main.res.GetString(\"matn\")";
Debug.ShouldStop(4);
tamrin19_activity.mostCurrent._lbl_roz.runMethod(true,"setText",BA.ObjectToCharSequence(tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn")))));
 BA.debugLineNum = 68;BA.debugLine="lbl_delet.Tag=Main.res.Getint(\"id\")";
Debug.ShouldStop(8);
tamrin19_activity.mostCurrent._lbl_delet.runMethod(false,"setTag",(tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 69;BA.debugLine="lbl_import.Tag=Main.res.Getint(\"id\")";
Debug.ShouldStop(16);
tamrin19_activity.mostCurrent._lbl_import.runMethod(false,"setTag",(tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 72;BA.debugLine="If(Main.res.Getint(\"state\").As(Int)=0)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",(tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 74;BA.debugLine="lbl_import.TextColor=Colors.Gray";
Debug.ShouldStop(512);
tamrin19_activity.mostCurrent._lbl_import.runMethod(true,"setTextColor",tamrin19_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 }else {
 BA.debugLineNum = 77;BA.debugLine="lbl_import.TextColor=Colors.Green";
Debug.ShouldStop(4096);
tamrin19_activity.mostCurrent._lbl_import.runMethod(true,"setTextColor",tamrin19_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 };
 }
;
 BA.debugLineNum = 87;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(4194304);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 88;BA.debugLine="Main.res.Close";
Debug.ShouldStop(8388608);
tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin19_item(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin19_item (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,144);
if (RapidSub.canDelegate("get_state_tamrin19_item")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","get_state_tamrin19_item", _id);}
RemoteObject _result = RemoteObject.createImmutable(0);
Debug.locals.put("id", _id);
 BA.debugLineNum = 144;BA.debugLine="Sub get_state_tamrin19_item (id As Int) As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 146;BA.debugLine="Dim result As Int=0";
Debug.ShouldStop(131072);
_result = BA.numberCast(int.class, 0);Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 148;BA.debugLine="myFunc.connection_sql";
Debug.ShouldStop(524288);
tamrin19_activity.mostCurrent._myfunc.runVoidMethod ("_connection_sql" /*RemoteObject*/ ,tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 149;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(1048576);
tamrin19_activity.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrin19 WHERE id="),_id,RemoteObject.createImmutable(";")))));
 BA.debugLineNum = 150;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(2097152);
tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 153;BA.debugLine="result=Main.res.Getint(\"state\")";
Debug.ShouldStop(16777216);
_result = tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")));Debug.locals.put("result", _result);
 BA.debugLineNum = 156;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(134217728);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 157;BA.debugLine="Main.res.Close";
Debug.ShouldStop(268435456);
tamrin19_activity.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 159;BA.debugLine="Return result";
Debug.ShouldStop(1073741824);
if (true) return _result;
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
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
tamrin19_activity.mostCurrent._cuslistv_data = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
tamrin19_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
tamrin19_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_roz As Label";
tamrin19_activity.mostCurrent._lbl_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_delet As Label";
tamrin19_activity.mostCurrent._lbl_delet = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_import As Label";
tamrin19_activity.mostCurrent._lbl_import = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pan_all As Panel";
tamrin19_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private et_new_item As EditText";
tamrin19_activity.mostCurrent._et_new_item = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_add_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_add_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,191);
if (RapidSub.canDelegate("lbl_add_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","lbl_add_click");}
 BA.debugLineNum = 191;BA.debugLine="Private Sub lbl_add_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(-2147483648);
tamrin19_activity.mostCurrent._pan_all.runMethod(true,"setVisible",tamrin19_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,211);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","lbl_back_click");}
 BA.debugLineNum = 211;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 212;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
tamrin19_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_delet_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_delet_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,96);
if (RapidSub.canDelegate("lbl_delet_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","lbl_delet_click");}
RemoteObject _this_lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 96;BA.debugLine="Private Sub lbl_delet_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim this_lbl As Label=Sender";
Debug.ShouldStop(1);
_this_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_this_lbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), tamrin19_activity.mostCurrent.__c.runMethod(false,"Sender",tamrin19_activity.mostCurrent.activityBA));Debug.locals.put("this_lbl", _this_lbl);Debug.locals.put("this_lbl", _this_lbl);
 BA.debugLineNum = 100;BA.debugLine="myFunc.connection_sql";
Debug.ShouldStop(8);
tamrin19_activity.mostCurrent._myfunc.runVoidMethod ("_connection_sql" /*RemoteObject*/ ,tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 101;BA.debugLine="Main.sql.ExecNonQuery(\"DELETE FROM tamrin19 WHERE";
Debug.ShouldStop(16);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM tamrin19 WHERE id="),_this_lbl.runMethod(false,"getTag"),RemoteObject.createImmutable(";"))));
 BA.debugLineNum = 102;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(32);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 103;BA.debugLine="ToastMessageShow(\"حذف شد\",False)";
Debug.ShouldStop(64);
tamrin19_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد")),(Object)(tamrin19_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 106;BA.debugLine="fill_list";
Debug.ShouldStop(512);
_fill_list();
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
public static RemoteObject  _lbl_import_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_import_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,117);
if (RapidSub.canDelegate("lbl_import_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","lbl_import_click");}
RemoteObject _this_lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 117;BA.debugLine="Private Sub lbl_import_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="Dim this_lbl As Label=Sender";
Debug.ShouldStop(4194304);
_this_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_this_lbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), tamrin19_activity.mostCurrent.__c.runMethod(false,"Sender",tamrin19_activity.mostCurrent.activityBA));Debug.locals.put("this_lbl", _this_lbl);Debug.locals.put("this_lbl", _this_lbl);
 BA.debugLineNum = 122;BA.debugLine="If(get_state_tamrin19_item(this_lbl.Tag)=0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_get_state_tamrin19_item(BA.numberCast(int.class, _this_lbl.runMethod(false,"getTag"))),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 123;BA.debugLine="this_lbl.TextColor=Colors.Green";
Debug.ShouldStop(67108864);
_this_lbl.runMethod(true,"setTextColor",tamrin19_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 124;BA.debugLine="update_stateById(this_lbl.Tag,1)";
Debug.ShouldStop(134217728);
_update_statebyid(BA.numberCast(int.class, _this_lbl.runMethod(false,"getTag")),BA.numberCast(int.class, 1));
 }else {
 BA.debugLineNum = 127;BA.debugLine="this_lbl.TextColor=Colors.Gray";
Debug.ShouldStop(1073741824);
_this_lbl.runMethod(true,"setTextColor",tamrin19_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 128;BA.debugLine="update_stateById(this_lbl.Tag,0)";
Debug.ShouldStop(-2147483648);
_update_statebyid(BA.numberCast(int.class, _this_lbl.runMethod(false,"getTag")),BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_new_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_new_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,169);
if (RapidSub.canDelegate("lbl_save_new_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","lbl_save_new_click");}
 BA.debugLineNum = 169;BA.debugLine="Private Sub lbl_save_new_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 172;BA.debugLine="If(et_new_item.Text<>\"\" And et_new_item.Text<>Nul";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("!",tamrin19_activity.mostCurrent._et_new_item.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("N",tamrin19_activity.mostCurrent._et_new_item.runMethod(true,"getText")))) { 
 BA.debugLineNum = 173;BA.debugLine="myFunc.connection_sql";
Debug.ShouldStop(4096);
tamrin19_activity.mostCurrent._myfunc.runVoidMethod ("_connection_sql" /*RemoteObject*/ ,tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 174;BA.debugLine="Main.sql.ExecNonQuery(\"INSERT INTO tamrin19 ('ma";
Debug.ShouldStop(8192);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tamrin19 ('matn') VALUES ('"),tamrin19_activity.mostCurrent._et_new_item.runMethod(true,"getText"),RemoteObject.createImmutable("');"))));
 BA.debugLineNum = 175;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16384);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 176;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
Debug.ShouldStop(32768);
tamrin19_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(tamrin19_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 178;BA.debugLine="pan_all_Click";
Debug.ShouldStop(131072);
_pan_all_click();
 BA.debugLineNum = 179;BA.debugLine="fill_list";
Debug.ShouldStop(262144);
_fill_list();
 }else {
 BA.debugLineNum = 182;BA.debugLine="MsgboxAsync(\"متن خالی است!\", \"توجه\")";
Debug.ShouldStop(2097152);
tamrin19_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("متن خالی است!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("توجه"))),tamrin19_activity.processBA);
 };
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_Click (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,165);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","pan_all_click");}
 BA.debugLineNum = 165;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(32);
tamrin19_activity.mostCurrent._pan_all.runMethod(true,"setVisible",tamrin19_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
public static RemoteObject  _update_statebyid(RemoteObject _id,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("update_stateById (tamrin19_activity) ","tamrin19_activity",16,tamrin19_activity.mostCurrent.activityBA,tamrin19_activity.mostCurrent,137);
if (RapidSub.canDelegate("update_statebyid")) { return ir.taravatgroup.shokrgozari.tamrin19_activity.remoteMe.runUserSub(false, "tamrin19_activity","update_statebyid", _id, _state);}
Debug.locals.put("id", _id);
Debug.locals.put("state", _state);
 BA.debugLineNum = 137;BA.debugLine="Sub update_stateById(id As Int,state As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="myFunc.connection_sql";
Debug.ShouldStop(512);
tamrin19_activity.mostCurrent._myfunc.runVoidMethod ("_connection_sql" /*RemoteObject*/ ,tamrin19_activity.mostCurrent.activityBA);
 BA.debugLineNum = 139;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin19 SET state";
Debug.ShouldStop(1024);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin19 SET state=? WHERE id=? ;")),(Object)(tamrin19_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_state),(_id)})))));
 BA.debugLineNum = 140;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(2048);
tamrin19_activity.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}