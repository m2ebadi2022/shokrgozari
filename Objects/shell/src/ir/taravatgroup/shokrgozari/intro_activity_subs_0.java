package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class intro_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"intro_layout\")";
Debug.ShouldStop(33554432);
intro_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("intro_layout")),intro_activity.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_KeyPress (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,130);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 130;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, intro_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 132;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return intro_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 134;BA.debugLine="Return False";
Debug.ShouldStop(32);
if (true) return intro_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Pause (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Activity_Touch (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,30);
if (RapidSub.canDelegate("activity_touch")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","activity_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Select Action";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_action,intro_activity.mostCurrent._activity.getField(true,"ACTION_DOWN"),intro_activity.mostCurrent._activity.getField(true,"ACTION_UP"))) {
case 0: {
 BA.debugLineNum = 33;BA.debugLine="startX = X";
Debug.ShouldStop(1);
intro_activity._startx = _x;
 BA.debugLineNum = 34;BA.debugLine="startY = Y";
Debug.ShouldStop(2);
intro_activity._starty = _y;
 break; }
case 1: {
 BA.debugLineNum = 36;BA.debugLine="If Abs(y - startY) > 20%y Then Return";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",intro_activity.mostCurrent.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_y,intro_activity._starty}, "-",1, 0))),BA.numberCast(double.class, intro_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),intro_activity.mostCurrent.activityBA)))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 37;BA.debugLine="If X - startX > 30%x   Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",RemoteObject.solve(new RemoteObject[] {_x,intro_activity._startx}, "-",1, 0),BA.numberCast(double.class, intro_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),intro_activity.mostCurrent.activityBA)))) { 
 BA.debugLineNum = 38;BA.debugLine="previos_btn";
Debug.ShouldStop(32);
_previos_btn();
 }else 
{ BA.debugLineNum = 39;BA.debugLine="Else If startX - x > 30%x  Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",RemoteObject.solve(new RemoteObject[] {intro_activity._startx,_x}, "-",1, 0),BA.numberCast(double.class, intro_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),intro_activity.mostCurrent.activityBA)))) { 
 BA.debugLineNum = 40;BA.debugLine="next_btn";
Debug.ShouldStop(128);
_next_btn();
 }}
;
 break; }
}
;
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Panel1 As Panel";
intro_activity.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Panel2 As Panel";
intro_activity.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Panel3 As Panel";
intro_activity.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim startX, startY As Float '<-new global variabl";
intro_activity._startx = RemoteObject.createImmutable(0f);
intro_activity._starty = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 20;BA.debugLine="Dim current_page As Int =0";
intro_activity._current_page = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 21;BA.debugLine="Private Panel4 As Panel";
intro_activity.mostCurrent._panel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_next1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_next1_Click (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,124);
if (RapidSub.canDelegate("lbl_next1_click")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","lbl_next1_click");}
 BA.debugLineNum = 124;BA.debugLine="Private Sub lbl_next1_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="next_btn";
Debug.ShouldStop(268435456);
_next_btn();
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_next2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_next2_Click (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,115);
if (RapidSub.canDelegate("lbl_next2_click")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","lbl_next2_click");}
 BA.debugLineNum = 115;BA.debugLine="Private Sub lbl_next2_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="next_btn";
Debug.ShouldStop(524288);
_next_btn();
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_next3_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_next3_Click (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,111);
if (RapidSub.canDelegate("lbl_next3_click")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","lbl_next3_click");}
 BA.debugLineNum = 111;BA.debugLine="Private Sub lbl_next3_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="next_btn";
Debug.ShouldStop(32768);
_next_btn();
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_next4_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_next4_Click (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,119);
if (RapidSub.canDelegate("lbl_next4_click")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","lbl_next4_click");}
 BA.debugLineNum = 119;BA.debugLine="Private Sub lbl_next4_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="File.WriteString(File.DirInternal,\"intro_pley\",\"1";
Debug.ShouldStop(8388608);
intro_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(intro_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("intro_pley")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 121;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
intro_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _next_btn() throws Exception{
try {
		Debug.PushSubsStack("next_btn (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,54);
if (RapidSub.canDelegate("next_btn")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","next_btn");}
 BA.debugLineNum = 54;BA.debugLine="Sub next_btn";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="current_page=current_page+1";
Debug.ShouldStop(4194304);
intro_activity._current_page = RemoteObject.solve(new RemoteObject[] {intro_activity._current_page,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 56;BA.debugLine="If(current_page=4)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",intro_activity._current_page,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 57;BA.debugLine="current_page=4";
Debug.ShouldStop(16777216);
intro_activity._current_page = BA.numberCast(int.class, 4);
 BA.debugLineNum = 58;BA.debugLine="lbl_next4_Click";
Debug.ShouldStop(33554432);
_lbl_next4_click();
 };
 BA.debugLineNum = 62;BA.debugLine="show_only_page(current_page)";
Debug.ShouldStop(536870912);
_show_only_page(intro_activity._current_page);
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
public static RemoteObject  _previos_btn() throws Exception{
try {
		Debug.PushSubsStack("previos_btn (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,68);
if (RapidSub.canDelegate("previos_btn")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","previos_btn");}
 BA.debugLineNum = 68;BA.debugLine="Sub previos_btn";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="current_page=current_page-1";
Debug.ShouldStop(32);
intro_activity._current_page = RemoteObject.solve(new RemoteObject[] {intro_activity._current_page,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 71;BA.debugLine="If(current_page=-1)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",intro_activity._current_page,BA.numberCast(double.class, -(double) (0 + 1))))) { 
 BA.debugLineNum = 72;BA.debugLine="current_page=0";
Debug.ShouldStop(128);
intro_activity._current_page = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 75;BA.debugLine="show_only_page(current_page)";
Debug.ShouldStop(1024);
_show_only_page(intro_activity._current_page);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _show_only_page(RemoteObject _pageid) throws Exception{
try {
		Debug.PushSubsStack("show_only_page (intro_activity) ","intro_activity",9,intro_activity.mostCurrent.activityBA,intro_activity.mostCurrent,80);
if (RapidSub.canDelegate("show_only_page")) { return ir.taravatgroup.shokrgozari.intro_activity.remoteMe.runUserSub(false, "intro_activity","show_only_page", _pageid);}
Debug.locals.put("pageID", _pageid);
 BA.debugLineNum = 80;BA.debugLine="Sub show_only_page(pageID As Int)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(65536);
intro_activity.mostCurrent._panel1.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 82;BA.debugLine="Panel2.Visible=False";
Debug.ShouldStop(131072);
intro_activity.mostCurrent._panel2.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 83;BA.debugLine="Panel3.Visible=False";
Debug.ShouldStop(262144);
intro_activity.mostCurrent._panel3.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 84;BA.debugLine="Select pageID";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_pageid,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 86;BA.debugLine="Panel1.Visible=True";
Debug.ShouldStop(2097152);
intro_activity.mostCurrent._panel1.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 87;BA.debugLine="Panel2.Visible=False";
Debug.ShouldStop(4194304);
intro_activity.mostCurrent._panel2.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 88;BA.debugLine="Panel3.Visible=False";
Debug.ShouldStop(8388608);
intro_activity.mostCurrent._panel3.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 89;BA.debugLine="Panel4.Visible=False";
Debug.ShouldStop(16777216);
intro_activity.mostCurrent._panel4.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 break; }
case 1: {
 BA.debugLineNum = 91;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(67108864);
intro_activity.mostCurrent._panel1.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 92;BA.debugLine="Panel2.Visible=True";
Debug.ShouldStop(134217728);
intro_activity.mostCurrent._panel2.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 93;BA.debugLine="Panel3.Visible=False";
Debug.ShouldStop(268435456);
intro_activity.mostCurrent._panel3.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 94;BA.debugLine="Panel4.Visible=False";
Debug.ShouldStop(536870912);
intro_activity.mostCurrent._panel4.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 break; }
case 2: {
 BA.debugLineNum = 97;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(1);
intro_activity.mostCurrent._panel1.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 98;BA.debugLine="Panel2.Visible=False";
Debug.ShouldStop(2);
intro_activity.mostCurrent._panel2.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 99;BA.debugLine="Panel3.Visible=True";
Debug.ShouldStop(4);
intro_activity.mostCurrent._panel3.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 100;BA.debugLine="Panel4.Visible=False";
Debug.ShouldStop(8);
intro_activity.mostCurrent._panel4.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 break; }
case 3: {
 BA.debugLineNum = 102;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(32);
intro_activity.mostCurrent._panel1.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 103;BA.debugLine="Panel2.Visible=False";
Debug.ShouldStop(64);
intro_activity.mostCurrent._panel2.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="Panel3.Visible=False";
Debug.ShouldStop(128);
intro_activity.mostCurrent._panel3.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 105;BA.debugLine="Panel4.Visible=True";
Debug.ShouldStop(256);
intro_activity.mostCurrent._panel4.runMethod(true,"setVisible",intro_activity.mostCurrent.__c.getField(true,"True"));
 break; }
}
;
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}