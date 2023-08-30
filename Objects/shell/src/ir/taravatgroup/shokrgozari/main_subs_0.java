package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _viewimg_splash = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _viewlbl1_splash = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 71;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 75;BA.debugLine="tim_splash.Initialize(\"tim_splash\",100)";
Debug.ShouldStop(1024);
main._tim_splash.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_splash")),(Object)(BA.numberCast(long.class, 100)));
 BA.debugLineNum = 77;BA.debugLine="tim_splash.Enabled=True";
Debug.ShouldStop(4096);
main._tim_splash.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 79;BA.debugLine="Dim viewimg_splash As B4XView=ImageView1";
Debug.ShouldStop(16384);
_viewimg_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_viewimg_splash = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent._imageview1.getObject());Debug.locals.put("viewimg_splash", _viewimg_splash);Debug.locals.put("viewimg_splash", _viewimg_splash);
 BA.debugLineNum = 80;BA.debugLine="viewimg_splash.SetVisibleAnimated(500,True)";
Debug.ShouldStop(32768);
_viewimg_splash.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 81;BA.debugLine="viewimg_splash.SetLayoutAnimated(1000,viewimg_sp";
Debug.ShouldStop(65536);
_viewimg_splash.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 1000)),(Object)(RemoteObject.solve(new RemoteObject[] {_viewimg_splash.runMethod(true,"getLeft"),RemoteObject.createImmutable(40)}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_viewimg_splash.runMethod(true,"getTop"),RemoteObject.createImmutable(40)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))));
 BA.debugLineNum = 83;BA.debugLine="Dim viewlbl1_splash As B4XView=Label1";
Debug.ShouldStop(262144);
_viewlbl1_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_viewlbl1_splash = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent._label1.getObject());Debug.locals.put("viewlbl1_splash", _viewlbl1_splash);Debug.locals.put("viewlbl1_splash", _viewlbl1_splash);
 BA.debugLineNum = 84;BA.debugLine="viewlbl1_splash.SetTextSizeAnimated(1000,30)";
Debug.ShouldStop(524288);
_viewlbl1_splash.runVoidMethod ("SetTextSizeAnimated",(Object)(BA.numberCast(int.class, 1000)),(Object)(BA.numberCast(float.class, 30)));
 BA.debugLineNum = 88;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
Debug.ShouldStop(8388608);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("home_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 89;BA.debugLine="pan_main2.LoadLayout(\"all_tamrin_layout\")";
Debug.ShouldStop(16777216);
main.mostCurrent._pan_main2.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("all_tamrin_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 90;BA.debugLine="pan_main3.LoadLayout(\"dashboard_layout\")";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_main3.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("dashboard_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 91;BA.debugLine="ScrollView_dashboard.Panel.LoadLayout(\"item_dashb";
Debug.ShouldStop(67108864);
main.mostCurrent._scrollview_dashboard.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_dashboard")),main.mostCurrent.activityBA);
 BA.debugLineNum = 92;BA.debugLine="fill_list_tamrinat";
Debug.ShouldStop(134217728);
_fill_list_tamrinat();
 BA.debugLineNum = 94;BA.debugLine="pan_main2.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._pan_main2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 95;BA.debugLine="pan_main3.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._pan_main3.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 97;BA.debugLine="btn_home_Click";
Debug.ShouldStop(1);
_btn_home_click();
 BA.debugLineNum = 101;BA.debugLine="If(File.Exists(File.DirInternal,\"intro_pley\")=Fal";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("intro_pley"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 102;BA.debugLine="StartActivity(intro_activity)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._intro_activity.getObject())));
 };
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,409);
if (RapidSub.canDelegate("activity_keypress")) { ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode); return;}
ResumableSub_Activity_KeyPress rsub = new ResumableSub_Activity_KeyPress(null,_keycode);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_KeyPress extends BA.ResumableSub {
public ResumableSub_Activity_KeyPress(ir.taravatgroup.shokrgozari.main parent,RemoteObject _keycode) {
this.parent = parent;
this._keycode = _keycode;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.main parent;
RemoteObject _keycode;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,409);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 410;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
this.state = 3;
}else {
this.state = 15;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 413;BA.debugLine="If(current_indexPage<>1)Then";
Debug.ShouldStop(268435456);
if (true) break;

case 4:
//if
this.state = 13;
if ((RemoteObject.solveBoolean("!",parent._current_indexpage,BA.numberCast(double.class, 1)))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 414;BA.debugLine="btn_home_Click";
Debug.ShouldStop(536870912);
_btn_home_click();
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 417;BA.debugLine="Msgbox2Async(\"آیا از برنامه خارج میشوید!\", \"\",";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("آیا از برنامه خارج میشوید!")),(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("نه")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 418;BA.debugLine="Wait For Msgbox_Result (result As Int)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_keypress"), null);
this.state = 17;
return;
case 17:
//C
this.state = 9;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("result", _result);
;
 BA.debugLineNum = 419;BA.debugLine="If result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(4);
if (true) break;

case 9:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 420;BA.debugLine="ExitApplication";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ExitApplication");
 if (true) break;

case 12:
//C
this.state = 13;
;
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
 if (true) break;

case 16:
//C
this.state = -1;
;
 BA.debugLineNum = 432;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 126;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 122;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_all_tamrin_click() throws Exception{
try {
		Debug.PushSubsStack("btn_all_tamrin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,145);
if (RapidSub.canDelegate("btn_all_tamrin_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","btn_all_tamrin_click");}
 BA.debugLineNum = 145;BA.debugLine="Private Sub btn_all_tamrin_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 147;BA.debugLine="def_color_menu";
Debug.ShouldStop(262144);
_def_color_menu();
 BA.debugLineNum = 148;BA.debugLine="btn_all_tamrin.TextColor=0xFFFF4B4B";
Debug.ShouldStop(524288);
main.mostCurrent._btn_all_tamrin.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff4b4b)));
 BA.debugLineNum = 150;BA.debugLine="If(pan_all_lsv.Visible=True)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_lsv.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 151;BA.debugLine="pan_all_lsv.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 155;BA.debugLine="pan_main2.Visible=True";
Debug.ShouldStop(67108864);
main.mostCurrent._pan_main2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 157;BA.debugLine="pan_main2.SetLayoutAnimated(100,0,0,100%x,pan_mai";
Debug.ShouldStop(268435456);
main.mostCurrent._pan_main2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent._pan_main3.runMethod(true,"getHeight")));
 BA.debugLineNum = 158;BA.debugLine="pan_main3.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._pan_main3.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 161;BA.debugLine="current_indexPage=2";
Debug.ShouldStop(1);
main._current_indexpage = BA.numberCast(int.class, 2);
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_dashboard_click() throws Exception{
try {
		Debug.PushSubsStack("btn_dashboard_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,167);
if (RapidSub.canDelegate("btn_dashboard_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","btn_dashboard_click");}
 BA.debugLineNum = 167;BA.debugLine="Private Sub btn_dashboard_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 169;BA.debugLine="def_color_menu";
Debug.ShouldStop(256);
_def_color_menu();
 BA.debugLineNum = 170;BA.debugLine="btn_dashboard.TextColor=0xFFFF4B4B";
Debug.ShouldStop(512);
main.mostCurrent._btn_dashboard.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff4b4b)));
 BA.debugLineNum = 172;BA.debugLine="pan_main3.Visible=True";
Debug.ShouldStop(2048);
main.mostCurrent._pan_main3.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 174;BA.debugLine="pan_main3.SetLayoutAnimated(100,0,0,100%x,pan_mai";
Debug.ShouldStop(8192);
main.mostCurrent._pan_main3.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent._pan_main3.runMethod(true,"getHeight")));
 BA.debugLineNum = 175;BA.debugLine="pan_main2.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._pan_main2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 181;BA.debugLine="current_indexPage=0";
Debug.ShouldStop(1048576);
main._current_indexpage = BA.numberCast(int.class, 0);
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_home_click() throws Exception{
try {
		Debug.PushSubsStack("btn_home_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,185);
if (RapidSub.canDelegate("btn_home_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","btn_home_click");}
int _i = 0;
 BA.debugLineNum = 185;BA.debugLine="Private Sub btn_home_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 187;BA.debugLine="def_color_menu";
Debug.ShouldStop(67108864);
_def_color_menu();
 BA.debugLineNum = 188;BA.debugLine="btn_home.TextColor=0xFFFF4B4B";
Debug.ShouldStop(134217728);
main.mostCurrent._btn_home.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff4b4b)));
 BA.debugLineNum = 191;BA.debugLine="If(current_indexPage=2)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",main._current_indexpage,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 192;BA.debugLine="pan_main2.SetLayoutAnimated(100,100%x,0,100%x,pa";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pan_main2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent._pan_main3.runMethod(true,"getHeight")));
 }else 
{ BA.debugLineNum = 193;BA.debugLine="Else If (current_indexPage=0) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main._current_indexpage,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 194;BA.debugLine="pan_main3.SetLayoutAnimated(100,-(100%x),0,100%x";
Debug.ShouldStop(2);
main.mostCurrent._pan_main3.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, -(double) (0 + (main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent._pan_main3.runMethod(true,"getHeight")));
 }}
;
 BA.debugLineNum = 198;BA.debugLine="current_indexPage=1";
Debug.ShouldStop(32);
main._current_indexpage = BA.numberCast(int.class, 1);
 BA.debugLineNum = 203;BA.debugLine="For i=1 To 28";
Debug.ShouldStop(1024);
{
final int step9 = 1;
final int limit9 = 28;
_i = 1 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 205;BA.debugLine="If(myFunc.get_State_tamrin1_byRoz(i).As(Int)<10)";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",(main.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin1_byroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _i)))),BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 206;BA.debugLine="this_day=i";
Debug.ShouldStop(8192);
main._this_day = BA.numberCast(int.class, _i);
 BA.debugLineNum = 207;BA.debugLine="lbl_show_tamrin_roz.Text=i&\"/28\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_show_tamrin_roz.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable("/28"))));
 BA.debugLineNum = 208;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 215;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chek_state(RemoteObject _id_roz) throws Exception{
try {
		Debug.PushSubsStack("chek_state (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,294);
if (RapidSub.canDelegate("chek_state")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","chek_state", _id_roz);}
RemoteObject _color_str = RemoteObject.createImmutable("");
RemoteObject _code_state = RemoteObject.createImmutable(0);
Debug.locals.put("id_roz", _id_roz);
 BA.debugLineNum = 294;BA.debugLine="Sub chek_state (id_roz As Int) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 295;BA.debugLine="Dim color_str As String=\"\"";
Debug.ShouldStop(64);
_color_str = BA.ObjectToString("");Debug.locals.put("color_str", _color_str);Debug.locals.put("color_str", _color_str);
 BA.debugLineNum = 296;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamrin1_";
Debug.ShouldStop(128);
_code_state = main.mostCurrent._myfunc.runMethod(true,"_get_state_tamrin1_byroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_id_roz));Debug.locals.put("code_state", _code_state);Debug.locals.put("code_state", _code_state);
 BA.debugLineNum = 298;BA.debugLine="If(code_state=10)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 299;BA.debugLine="color_str=0xFF66DF64";
Debug.ShouldStop(1024);
_color_str = BA.NumberToString(((int)0xff66df64));Debug.locals.put("color_str", _color_str);
 }else 
{ BA.debugLineNum = 300;BA.debugLine="Else If(code_state = 0 )Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_code_state,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 301;BA.debugLine="color_str=0xFF919191";
Debug.ShouldStop(4096);
_color_str = BA.NumberToString(((int)0xff919191));Debug.locals.put("color_str", _color_str);
 }else {
 BA.debugLineNum = 303;BA.debugLine="color_str=0xFFDFCE64";
Debug.ShouldStop(16384);
_color_str = BA.NumberToString(((int)0xffdfce64));Debug.locals.put("color_str", _color_str);
 }}
;
 BA.debugLineNum = 306;BA.debugLine="Return color_str";
Debug.ShouldStop(131072);
if (true) return _color_str;
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _def_color_menu() throws Exception{
try {
		Debug.PushSubsStack("def_color_menu (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,232);
if (RapidSub.canDelegate("def_color_menu")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","def_color_menu");}
 BA.debugLineNum = 232;BA.debugLine="Sub def_color_menu";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="btn_home.TextColor=Colors.Gray";
Debug.ShouldStop(256);
main.mostCurrent._btn_home.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 234;BA.debugLine="btn_all_tamrin.TextColor=Colors.Gray";
Debug.ShouldStop(512);
main.mostCurrent._btn_all_tamrin.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 235;BA.debugLine="btn_dashboard.TextColor=Colors.Gray";
Debug.ShouldStop(1024);
main.mostCurrent._btn_dashboard.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_list_tamrinat() throws Exception{
try {
		Debug.PushSubsStack("fill_list_tamrinat (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,239);
if (RapidSub.canDelegate("fill_list_tamrinat")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","fill_list_tamrinat");}
RemoteObject _counter_id = RemoteObject.createImmutable(0);
int _i = 0;
 BA.debugLineNum = 239;BA.debugLine="Sub fill_list_tamrinat";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="Dim counter_id As Int=0";
Debug.ShouldStop(32768);
_counter_id = BA.numberCast(int.class, 0);Debug.locals.put("counter_id", _counter_id);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 241;BA.debugLine="For i=1 To 6";
Debug.ShouldStop(65536);
{
final int step2 = 1;
final int limit2 = 6;
_i = 1 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 243;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(262144);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 245;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 80dip)";
Debug.ShouldStop(1048576);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))));
 BA.debugLineNum = 246;BA.debugLine="p.LoadLayout(\"item_clv_tamrinat\")";
Debug.ShouldStop(2097152);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_clv_tamrinat")),main.mostCurrent.activityBA);
 BA.debugLineNum = 249;BA.debugLine="clv_tamrinat_tagvim.Add(p,i)";
Debug.ShouldStop(16777216);
main.mostCurrent._clv_tamrinat_tagvim.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 251;BA.debugLine="counter_id=counter_id+1";
Debug.ShouldStop(67108864);
_counter_id = RemoteObject.solve(new RemoteObject[] {_counter_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 252;BA.debugLine="L1.Text=counter_id";
Debug.ShouldStop(134217728);
main.mostCurrent._l1.runMethod(true,"setText",BA.ObjectToCharSequence(_counter_id));
 BA.debugLineNum = 253;BA.debugLine="r1.Tag=counter_id";
Debug.ShouldStop(268435456);
main.mostCurrent._r1.runMethod(false,"setTag",(_counter_id));
 BA.debugLineNum = 254;BA.debugLine="r1.Color=chek_state(counter_id)";
Debug.ShouldStop(536870912);
main.mostCurrent._r1.runVoidMethod ("setColor",BA.numberCast(int.class, _chek_state(_counter_id)));
 BA.debugLineNum = 256;BA.debugLine="counter_id=counter_id+1";
Debug.ShouldStop(-2147483648);
_counter_id = RemoteObject.solve(new RemoteObject[] {_counter_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 257;BA.debugLine="L2.Text=counter_id";
Debug.ShouldStop(1);
main.mostCurrent._l2.runMethod(true,"setText",BA.ObjectToCharSequence(_counter_id));
 BA.debugLineNum = 258;BA.debugLine="r2.Tag=counter_id";
Debug.ShouldStop(2);
main.mostCurrent._r2.runMethod(false,"setTag",(_counter_id));
 BA.debugLineNum = 259;BA.debugLine="r2.Color=chek_state(counter_id)";
Debug.ShouldStop(4);
main.mostCurrent._r2.runVoidMethod ("setColor",BA.numberCast(int.class, _chek_state(_counter_id)));
 BA.debugLineNum = 261;BA.debugLine="counter_id=counter_id+1";
Debug.ShouldStop(16);
_counter_id = RemoteObject.solve(new RemoteObject[] {_counter_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 262;BA.debugLine="L3.Text=counter_id";
Debug.ShouldStop(32);
main.mostCurrent._l3.runMethod(true,"setText",BA.ObjectToCharSequence(_counter_id));
 BA.debugLineNum = 263;BA.debugLine="r3.Tag=counter_id";
Debug.ShouldStop(64);
main.mostCurrent._r3.runMethod(false,"setTag",(_counter_id));
 BA.debugLineNum = 264;BA.debugLine="r3.Color=chek_state(counter_id)";
Debug.ShouldStop(128);
main.mostCurrent._r3.runVoidMethod ("setColor",BA.numberCast(int.class, _chek_state(_counter_id)));
 BA.debugLineNum = 266;BA.debugLine="counter_id=counter_id+1";
Debug.ShouldStop(512);
_counter_id = RemoteObject.solve(new RemoteObject[] {_counter_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 267;BA.debugLine="L4.Text=counter_id";
Debug.ShouldStop(1024);
main.mostCurrent._l4.runMethod(true,"setText",BA.ObjectToCharSequence(_counter_id));
 BA.debugLineNum = 268;BA.debugLine="r4.Tag=counter_id";
Debug.ShouldStop(2048);
main.mostCurrent._r4.runMethod(false,"setTag",(_counter_id));
 BA.debugLineNum = 269;BA.debugLine="r4.Color=chek_state(counter_id)";
Debug.ShouldStop(4096);
main.mostCurrent._r4.runVoidMethod ("setColor",BA.numberCast(int.class, _chek_state(_counter_id)));
 BA.debugLineNum = 271;BA.debugLine="counter_id=counter_id+1";
Debug.ShouldStop(16384);
_counter_id = RemoteObject.solve(new RemoteObject[] {_counter_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter_id", _counter_id);
 BA.debugLineNum = 272;BA.debugLine="L5.Text=counter_id";
Debug.ShouldStop(32768);
main.mostCurrent._l5.runMethod(true,"setText",BA.ObjectToCharSequence(_counter_id));
 BA.debugLineNum = 273;BA.debugLine="r5.Tag=counter_id";
Debug.ShouldStop(65536);
main.mostCurrent._r5.runMethod(false,"setTag",(_counter_id));
 BA.debugLineNum = 274;BA.debugLine="r5.Color=chek_state(counter_id)";
Debug.ShouldStop(131072);
main.mostCurrent._r5.runVoidMethod ("setColor",BA.numberCast(int.class, _chek_state(_counter_id)));
 BA.debugLineNum = 276;BA.debugLine="If(i=6)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 6)))) { 
 BA.debugLineNum = 277;BA.debugLine="r4.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._r4.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 278;BA.debugLine="r5.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._r5.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 }
}Debug.locals.put("i", _i);
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
public static void  _get_tamrin1_for_lsv(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_tamrin1_for_lsv (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,310);
if (RapidSub.canDelegate("get_tamrin1_for_lsv")) { ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","get_tamrin1_for_lsv", _id); return;}
ResumableSub_get_tamrin1_for_lsv rsub = new ResumableSub_get_tamrin1_for_lsv(null,_id);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_get_tamrin1_for_lsv extends BA.ResumableSub {
public ResumableSub_get_tamrin1_for_lsv(ir.taravatgroup.shokrgozari.main parent,RemoteObject _id) {
this.parent = parent;
this._id = _id;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.main parent;
RemoteObject _id;
RemoteObject _strfunc = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _ls_tamrin1_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _list_num = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _result = RemoteObject.createImmutable(0);
int step11;
int limit11;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("get_tamrin1_for_lsv (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,310);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("id", _id);
 BA.debugLineNum = 311;BA.debugLine="lsv_roz.Clear";
Debug.ShouldStop(4194304);
parent.mostCurrent._lsv_roz.runVoidMethod ("Clear");
 BA.debugLineNum = 312;BA.debugLine="lsv_roz.TwoLinesLayout.Label.Width=90%x";
Debug.ShouldStop(8388608);
parent.mostCurrent._lsv_roz.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setWidth",parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA));
 BA.debugLineNum = 313;BA.debugLine="lsv_roz.TwoLinesLayout.Label.TextColor=Colors.Gre";
Debug.ShouldStop(16777216);
parent.mostCurrent._lsv_roz.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 315;BA.debugLine="lsv_roz.TwoLinesLayout.SecondLabel.Width=90%x";
Debug.ShouldStop(67108864);
parent.mostCurrent._lsv_roz.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").runMethod(true,"setWidth",parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA));
 BA.debugLineNum = 317;BA.debugLine="lbl_roz_lsv.Text=\"روز \"&id";
Debug.ShouldStop(268435456);
parent.mostCurrent._lbl_roz_lsv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("روز "),_id)));
 BA.debugLineNum = 318;BA.debugLine="Dim strFunc As StringFunctions";
Debug.ShouldStop(536870912);
_strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strFunc", _strfunc);
 BA.debugLineNum = 319;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(1073741824);
_strfunc.runVoidMethod ("_initialize",main.processBA);
 BA.debugLineNum = 322;BA.debugLine="Dim ls_tamrin1_Roz As List";
Debug.ShouldStop(2);
_ls_tamrin1_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_tamrin1_Roz", _ls_tamrin1_roz);
 BA.debugLineNum = 323;BA.debugLine="ls_tamrin1_Roz.Initialize";
Debug.ShouldStop(4);
_ls_tamrin1_roz.runVoidMethod ("Initialize");
 BA.debugLineNum = 324;BA.debugLine="ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(id)";
Debug.ShouldStop(8);
_ls_tamrin1_roz = parent.mostCurrent._myfunc.runMethod(false,"_get_tamrin1_byroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_id));Debug.locals.put("ls_tamrin1_Roz", _ls_tamrin1_roz);
 BA.debugLineNum = 326;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
Debug.ShouldStop(32);
if (true) break;

case 1:
//for
this.state = 8;
step11 = 1;
limit11 = RemoteObject.solve(new RemoteObject[] {_ls_tamrin1_roz.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 16;
if (true) break;

case 16:
//C
this.state = 8;
if ((step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11)) this.state = 3;
if (true) break;

case 17:
//C
this.state = 16;
_i = ((int)(0 + _i + step11)) ;
Debug.locals.put("i", _i);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 328;BA.debugLine="Dim list_num As List";
Debug.ShouldStop(128);
_list_num = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_num", _list_num);
 BA.debugLineNum = 329;BA.debugLine="list_num.Initialize";
Debug.ShouldStop(256);
_list_num.runVoidMethod ("Initialize");
 BA.debugLineNum = 330;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
Debug.ShouldStop(512);
_list_num = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_ls_tamrin1_roz.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_num", _list_num);
 BA.debugLineNum = 332;BA.debugLine="If(list_num.Get(2)<>\"null\"  And list_num.Get(2)<";
Debug.ShouldStop(2048);
if (true) break;

case 4:
//if
this.state = 7;
if ((RemoteObject.solveBoolean("!",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(("null"))) && RemoteObject.solveBoolean("!",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable(""))))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 334;BA.debugLine="lsv_roz.AddTwoLines((i+1)&\" : \"&list_num.Get(2)";
Debug.ShouldStop(8192);
parent.mostCurrent._lsv_roz.runVoidMethod ("AddTwoLines",(Object)(BA.ObjectToCharSequence(RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(" : "),_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))))),(Object)(BA.ObjectToCharSequence(_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))))));
 if (true) break;

case 7:
//C
this.state = 17;
;
 if (true) break;
if (true) break;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 339;BA.debugLine="If(lsv_roz.Size=0)Then";
Debug.ShouldStop(262144);

case 8:
//if
this.state = 15;
if ((RemoteObject.solveBoolean("=",parent.mostCurrent._lsv_roz.runMethod(true,"getSize"),BA.numberCast(double.class, 0)))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 341;BA.debugLine="lbl_back_lsv_Click";
Debug.ShouldStop(1048576);
_lbl_back_lsv_click();
 BA.debugLineNum = 343;BA.debugLine="Msgbox2Async(\"اطلاعاتی ثبت نشده است!\", \"\", \"باشه";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("اطلاعاتی ثبت نشده است!")),(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 344;BA.debugLine="Wait For Msgbox_Result (result As Int)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "get_tamrin1_for_lsv"), null);
this.state = 18;
return;
case 18:
//C
this.state = 11;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("result", _result);
;
 BA.debugLineNum = 345;BA.debugLine="If result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(16777216);
if (true) break;

case 11:
//if
this.state = 14;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = -1;
;
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 31;BA.debugLine="Private btn_all_tamrin As Button";
main.mostCurrent._btn_all_tamrin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private btn_dashboard As Button";
main.mostCurrent._btn_dashboard = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private pan_main As Panel";
main.mostCurrent._pan_main = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private btn_home As Button";
main.mostCurrent._btn_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private clv_tamrinat_tagvim As CustomListView";
main.mostCurrent._clv_tamrinat_tagvim = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 36;BA.debugLine="Private xui As XUI";
main.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 37;BA.debugLine="Dim p As B4XView";
main.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private r1 As Panel";
main.mostCurrent._r1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private r2 As Panel";
main.mostCurrent._r2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private r3 As Panel";
main.mostCurrent._r3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private r4 As Panel";
main.mostCurrent._r4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private r5 As Panel";
main.mostCurrent._r5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private L1 As Label";
main.mostCurrent._l1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private L2 As Label";
main.mostCurrent._l2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private L3 As Label";
main.mostCurrent._l3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private L4 As Label";
main.mostCurrent._l4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private L5 As Label";
main.mostCurrent._l5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private lbl_roz_lsv As Label";
main.mostCurrent._lbl_roz_lsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private lsv_roz As ListView";
main.mostCurrent._lsv_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private pan_all_lsv As Panel";
main.mostCurrent._pan_all_lsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Dim current_indexPage As Int=1";
main._current_indexpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 53;BA.debugLine="Private pan_splash As Panel";
main.mostCurrent._pan_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private ScrollView_dashboard As ScrollView";
main.mostCurrent._scrollview_dashboard = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private lbl_show_tamrin_roz As Label";
main.mostCurrent._lbl_show_tamrin_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Dim this_day As Int=0";
main._this_day = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 59;BA.debugLine="Private pan_circle As Panel";
main.mostCurrent._pan_circle = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pan_main3 As Panel";
main.mostCurrent._pan_main3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private pan_main2 As Panel";
main.mostCurrent._pan_main2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_lsv_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_lsv_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,401);
if (RapidSub.canDelegate("lbl_back_lsv_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","lbl_back_lsv_click");}
 BA.debugLineNum = 401;BA.debugLine="Private Sub lbl_back_lsv_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 402;BA.debugLine="pan_all_lsv.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 403;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_lsv_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_lsv_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,397);
if (RapidSub.canDelegate("pan_all_lsv_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_all_lsv_click");}
 BA.debugLineNum = 397;BA.debugLine="Private Sub pan_all_lsv_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 399;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_book_click() throws Exception{
try {
		Debug.PushSubsStack("pan_book_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,136);
if (RapidSub.canDelegate("pan_book_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_book_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub pan_book_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="StartActivity(book_activity)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._book_activity.getObject())));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_comment_click() throws Exception{
try {
		Debug.PushSubsStack("pan_comment_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,458);
if (RapidSub.canDelegate("pan_comment_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_comment_click");}
RemoteObject _market = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _url = RemoteObject.createImmutable("");
 BA.debugLineNum = 458;BA.debugLine="Private Sub pan_comment_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 459;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 460;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(2048);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 461;BA.debugLine="Dim url As String";
Debug.ShouldStop(4096);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 462;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafeka";
Debug.ShouldStop(8192);
_url = BA.ObjectToString("bazaar://details?id=ir.taravatgroup.ezafekari2");Debug.locals.put("url", _url);
 BA.debugLineNum = 463;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
Debug.ShouldStop(16384);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_EDIT")),(Object)(_url));
 BA.debugLineNum = 464;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 468;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","41769482",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 474;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_donate_click() throws Exception{
try {
		Debug.PushSubsStack("pan_donate_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,480);
if (RapidSub.canDelegate("pan_donate_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_donate_click");}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _url = RemoteObject.createImmutable("");
 BA.debugLineNum = 480;BA.debugLine="Private Sub pan_donate_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 481;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(1);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 482;BA.debugLine="Dim url As String=\"https://zarinp.al/taravatgroup";
Debug.ShouldStop(2);
_url = BA.ObjectToString("https://zarinp.al/taravatgroup");Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 483;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
Debug.ShouldStop(4);
_i.runVoidMethod ("Initialize",(Object)(_i.getField(true,"ACTION_VIEW")),(Object)(_url));
 BA.debugLineNum = 484;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 485;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_download_click() throws Exception{
try {
		Debug.PushSubsStack("pan_download_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,219);
if (RapidSub.canDelegate("pan_download_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_download_click");}
 BA.debugLineNum = 219;BA.debugLine="Private Sub pan_download_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="StartActivity(download_activity)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._download_activity.getObject())));
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_info_click() throws Exception{
try {
		Debug.PushSubsStack("pan_info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,476);
if (RapidSub.canDelegate("pan_info_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_info_click");}
 BA.debugLineNum = 476;BA.debugLine="Private Sub pan_info_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 477;BA.debugLine="Msgbox(\"گروه برنامه نویسی طراوت\"&CRLF&\"v1.0\"&CRLF";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("گروه برنامه نویسی طراوت"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("v1.0"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("1402-05")))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("درباره ما"))),main.mostCurrent.activityBA);
 BA.debugLineNum = 478;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_othermyapps_click() throws Exception{
try {
		Debug.PushSubsStack("pan_otherMyApps_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,440);
if (RapidSub.canDelegate("pan_othermyapps_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_othermyapps_click");}
RemoteObject _market = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _url = RemoteObject.createImmutable("");
 BA.debugLineNum = 440;BA.debugLine="Private Sub pan_otherMyApps_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 441;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 442;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(33554432);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 443;BA.debugLine="Dim url As String";
Debug.ShouldStop(67108864);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 444;BA.debugLine="url=\"bazaar://collection?slug=by_author&aid=4074";
Debug.ShouldStop(134217728);
_url = BA.ObjectToString("bazaar://collection?slug=by_author&aid=407437645137");Debug.locals.put("url", _url);
 BA.debugLineNum = 445;BA.debugLine="market.Initialize(market.ACTION_VIEW,url)";
Debug.ShouldStop(268435456);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_VIEW")),(Object)(_url));
 BA.debugLineNum = 446;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 450;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","41703946",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 456;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_setting_click() throws Exception{
try {
		Debug.PushSubsStack("pan_setting_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,223);
if (RapidSub.canDelegate("pan_setting_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_setting_click");}
 BA.debugLineNum = 223;BA.debugLine="Private Sub pan_setting_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 225;BA.debugLine="StartActivity(setting_activity)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._setting_activity.getObject())));
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_splash_click() throws Exception{
try {
		Debug.PushSubsStack("pan_splash_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,436);
if (RapidSub.canDelegate("pan_splash_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_splash_click");}
 BA.debugLineNum = 436;BA.debugLine="Private Sub pan_splash_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 438;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_tamrin_roz_click() throws Exception{
try {
		Debug.PushSubsStack("pan_tamrin_roz_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,487);
if (RapidSub.canDelegate("pan_tamrin_roz_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_tamrin_roz_click");}
 BA.debugLineNum = 487;BA.debugLine="Private Sub pan_tamrin_roz_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 489;BA.debugLine="current_roz_tamrin=this_day";
Debug.ShouldStop(256);
main._current_roz_tamrin = main._this_day;
 BA.debugLineNum = 490;BA.debugLine="StartActivity(tamrin_roz_activity)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tamrin_roz_activity.getObject())));
 BA.debugLineNum = 491;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_tamrinat_click() throws Exception{
try {
		Debug.PushSubsStack("pan_tamrinat_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,132);
if (RapidSub.canDelegate("pan_tamrinat_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","pan_tamrinat_click");}
 BA.debugLineNum = 132;BA.debugLine="Private Sub pan_tamrinat_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="StartActivity(tamrinat_activity)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tamrinat_activity.getObject())));
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
myfunc_subs_0._process_globals();
tamrin_roz_activity_subs_0._process_globals();
book_activity_subs_0._process_globals();
tamrinat_activity_subs_0._process_globals();
tamrin14_activity_subs_0._process_globals();
tamrin8_activity_subs_0._process_globals();
do_tamrin_roz_layout_subs_0._process_globals();
download_activity_subs_0._process_globals();
intro_activity_subs_0._process_globals();
reagbook_activity_subs_0._process_globals();
setting_activity_subs_0._process_globals();
starter_subs_0._process_globals();
tamrin13_activity_subs_0._process_globals();
tamrin3_activity_subs_0._process_globals();
tamrin16_activity_subs_0._process_globals();
tamrin19_activity_subs_0._process_globals();
tamrin25_activity_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.main");
myfunc.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.myfunc");
tamrin_roz_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin_roz_activity");
book_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.book_activity");
tamrinat_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrinat_activity");
tamrin14_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin14_activity");
tamrin8_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin8_activity");
do_tamrin_roz_layout.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.do_tamrin_roz_layout");
download_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.download_activity");
intro_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.intro_activity");
reagbook_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.reagbook_activity");
setting_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.setting_activity");
starter.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.starter");
tamrin13_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin13_activity");
tamrin3_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin3_activity");
tamrin16_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin16_activity");
tamrin19_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin19_activity");
tamrin25_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.tamrin25_activity");
fileprovider.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.fileprovider");
httputils2service.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.httputils2service");
httpjob.myClass = BA.getDeviceClass ("ir.taravatgroup.shokrgozari.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim current_roz_tamrin As Int =0";
main._current_roz_tamrin = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 19;BA.debugLine="Dim current_tamrin As Int =0";
main._current_tamrin = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 20;BA.debugLine="Dim current_book_content_id As Int =0";
main._current_book_content_id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 23;BA.debugLine="Dim sql As SQL";
main._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 24;BA.debugLine="Dim res As ResultSet";
main._res = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim tim_splash As Timer";
main._tim_splash = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _r1_click() throws Exception{
try {
		Debug.PushSubsStack("r1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,387);
if (RapidSub.canDelegate("r1_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","r1_click");}
RemoteObject _pan_r = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 387;BA.debugLine="Private Sub r1_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 389;BA.debugLine="Dim pan_r As Panel=Sender";
Debug.ShouldStop(16);
_pan_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan_r = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("pan_r", _pan_r);Debug.locals.put("pan_r", _pan_r);
 BA.debugLineNum = 391;BA.debugLine="pan_all_lsv.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 392;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
Debug.ShouldStop(128);
_get_tamrin1_for_lsv(BA.numberCast(int.class, _pan_r.runMethod(false,"getTag")));
 BA.debugLineNum = 395;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _r2_click() throws Exception{
try {
		Debug.PushSubsStack("r2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,380);
if (RapidSub.canDelegate("r2_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","r2_click");}
RemoteObject _pan_r = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 380;BA.debugLine="Private Sub r2_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 381;BA.debugLine="Dim pan_r As Panel=Sender";
Debug.ShouldStop(268435456);
_pan_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan_r = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("pan_r", _pan_r);Debug.locals.put("pan_r", _pan_r);
 BA.debugLineNum = 383;BA.debugLine="pan_all_lsv.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 384;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
Debug.ShouldStop(-2147483648);
_get_tamrin1_for_lsv(BA.numberCast(int.class, _pan_r.runMethod(false,"getTag")));
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _r3_click() throws Exception{
try {
		Debug.PushSubsStack("r3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,373);
if (RapidSub.canDelegate("r3_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","r3_click");}
RemoteObject _pan_r = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 373;BA.debugLine="Private Sub r3_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 374;BA.debugLine="Dim pan_r As Panel=Sender";
Debug.ShouldStop(2097152);
_pan_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan_r = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("pan_r", _pan_r);Debug.locals.put("pan_r", _pan_r);
 BA.debugLineNum = 376;BA.debugLine="pan_all_lsv.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 377;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
Debug.ShouldStop(16777216);
_get_tamrin1_for_lsv(BA.numberCast(int.class, _pan_r.runMethod(false,"getTag")));
 BA.debugLineNum = 378;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _r4_click() throws Exception{
try {
		Debug.PushSubsStack("r4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,364);
if (RapidSub.canDelegate("r4_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","r4_click");}
RemoteObject _pan_r = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 364;BA.debugLine="Private Sub r4_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 365;BA.debugLine="Dim pan_r As Panel=Sender";
Debug.ShouldStop(4096);
_pan_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan_r = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("pan_r", _pan_r);Debug.locals.put("pan_r", _pan_r);
 BA.debugLineNum = 367;BA.debugLine="pan_all_lsv.Visible=True";
Debug.ShouldStop(16384);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 368;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
Debug.ShouldStop(32768);
_get_tamrin1_for_lsv(BA.numberCast(int.class, _pan_r.runMethod(false,"getTag")));
 BA.debugLineNum = 371;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _r5_click() throws Exception{
try {
		Debug.PushSubsStack("r5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,356);
if (RapidSub.canDelegate("r5_click")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","r5_click");}
RemoteObject _pan_r = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 356;BA.debugLine="Private Sub r5_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 357;BA.debugLine="Dim pan_r As Panel=Sender";
Debug.ShouldStop(16);
_pan_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan_r = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("pan_r", _pan_r);Debug.locals.put("pan_r", _pan_r);
 BA.debugLineNum = 359;BA.debugLine="pan_all_lsv.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._pan_all_lsv.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 360;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
Debug.ShouldStop(128);
_get_tamrin1_for_lsv(BA.numberCast(int.class, _pan_r.runMethod(false,"getTag")));
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_splash_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_splash_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,110);
if (RapidSub.canDelegate("tim_splash_tick")) { return ir.taravatgroup.shokrgozari.main.remoteMe.runUserSub(false, "main","tim_splash_tick");}
 BA.debugLineNum = 110;BA.debugLine="Sub tim_splash_Tick";
Debug.ShouldStop(8192);
 BA.debugLineNum = 114;BA.debugLine="btn_home_Click";
Debug.ShouldStop(131072);
_btn_home_click();
 BA.debugLineNum = 115;BA.debugLine="pan_splash.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._pan_splash.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 116;BA.debugLine="tim_splash.Enabled=False";
Debug.ShouldStop(524288);
main._tim_splash.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}