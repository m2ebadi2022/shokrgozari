package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class do_tamrin_roz_layout_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","activity_create", _firsttime);}
RemoteObject _strfunc = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _ls_tamrin1_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _list_num = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"do_tamrin_roz_layout\")";
Debug.ShouldStop(1);
do_tamrin_roz_layout.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("do_tamrin_roz_layout")),do_tamrin_roz_layout.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Dim strFunc As StringFunctions";
Debug.ShouldStop(8);
_strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strFunc", _strfunc);
 BA.debugLineNum = 37;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(16);
_strfunc.runVoidMethod ("_initialize",do_tamrin_roz_layout.processBA);
 BA.debugLineNum = 40;BA.debugLine="Dim ls_tamrin1_Roz As List";
Debug.ShouldStop(128);
_ls_tamrin1_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_tamrin1_Roz", _ls_tamrin1_roz);
 BA.debugLineNum = 41;BA.debugLine="ls_tamrin1_Roz.Initialize";
Debug.ShouldStop(256);
_ls_tamrin1_roz.runVoidMethod ("Initialize");
 BA.debugLineNum = 42;BA.debugLine="ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(Main.curr";
Debug.ShouldStop(512);
_ls_tamrin1_roz = do_tamrin_roz_layout.mostCurrent._myfunc.runMethod(false,"_get_tamrin1_byroz" /*RemoteObject*/ ,do_tamrin_roz_layout.mostCurrent.activityBA,(Object)(do_tamrin_roz_layout.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ));Debug.locals.put("ls_tamrin1_Roz", _ls_tamrin1_roz);
 BA.debugLineNum = 44;BA.debugLine="lbl_tamrin_roz.Text=\"تمرین روز \"&Main.current_roz";
Debug.ShouldStop(2048);
do_tamrin_roz_layout.mostCurrent._lbl_tamrin_roz.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تمرین روز "),do_tamrin_roz_layout.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ )));
 BA.debugLineNum = 46;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
Debug.ShouldStop(8192);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {_ls_tamrin1_roz.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 48;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(32768);
do_tamrin_roz_layout.mostCurrent._p = do_tamrin_roz_layout.mostCurrent._xui.runMethod(false,"CreatePanel",do_tamrin_roz_layout.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 49;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 140dip)";
Debug.ShouldStop(65536);
do_tamrin_roz_layout.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),do_tamrin_roz_layout.mostCurrent.activityBA)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 140)))));
 BA.debugLineNum = 50;BA.debugLine="p.LoadLayout(\"item_list_tamrin1\")";
Debug.ShouldStop(131072);
do_tamrin_roz_layout.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_tamrin1")),do_tamrin_roz_layout.mostCurrent.activityBA);
 BA.debugLineNum = 52;BA.debugLine="et_mohebat.Color=Colors.White";
Debug.ShouldStop(524288);
do_tamrin_roz_layout.mostCurrent._et_mohebat.runVoidMethod ("setColor",do_tamrin_roz_layout.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 53;BA.debugLine="et_ealt.Color=Colors.White";
Debug.ShouldStop(1048576);
do_tamrin_roz_layout.mostCurrent._et_ealt.runVoidMethod ("setColor",do_tamrin_roz_layout.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 55;BA.debugLine="CustomLV_tamrin.Add(p,i)";
Debug.ShouldStop(4194304);
do_tamrin_roz_layout.mostCurrent._customlv_tamrin.runVoidMethod ("_add",(Object)(do_tamrin_roz_layout.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 58;BA.debugLine="Dim list_num As List";
Debug.ShouldStop(33554432);
_list_num = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_num", _list_num);
 BA.debugLineNum = 59;BA.debugLine="list_num.Initialize";
Debug.ShouldStop(67108864);
_list_num.runVoidMethod ("Initialize");
 BA.debugLineNum = 60;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
Debug.ShouldStop(134217728);
_list_num = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_ls_tamrin1_roz.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_num", _list_num);
 BA.debugLineNum = 64;BA.debugLine="lbl_num.Text=i+1";
Debug.ShouldStop(-2147483648);
do_tamrin_roz_layout.mostCurrent._lbl_num.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 66;BA.debugLine="If(list_num.Get(2)<>\"null\")Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("null"))))) { 
 BA.debugLineNum = 67;BA.debugLine="et_mohebat.Text=list_num.Get(2)";
Debug.ShouldStop(4);
do_tamrin_roz_layout.mostCurrent._et_mohebat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 };
 BA.debugLineNum = 69;BA.debugLine="If(list_num.Get(3)<>\"null\")Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),(RemoteObject.createImmutable("null"))))) { 
 BA.debugLineNum = 70;BA.debugLine="et_ealt.Text=list_num.Get(3)";
Debug.ShouldStop(32);
do_tamrin_roz_layout.mostCurrent._et_ealt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 };
 BA.debugLineNum = 73;BA.debugLine="et_mohebat.Tag=list_num.Get(0)";
Debug.ShouldStop(256);
do_tamrin_roz_layout.mostCurrent._et_mohebat.runMethod(false,"setTag",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 74;BA.debugLine="et_ealt.Tag=list_num.Get(0)";
Debug.ShouldStop(512);
do_tamrin_roz_layout.mostCurrent._et_ealt.runMethod(false,"setTag",_list_num.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_KeyPress (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,149);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 149;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, do_tamrin_roz_layout.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 151;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(4194304);
_lbl_back_click();
 BA.debugLineNum = 152;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return do_tamrin_roz_layout.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 154;BA.debugLine="Return False";
Debug.ShouldStop(33554432);
if (true) return do_tamrin_roz_layout.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,86);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 86;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Resume (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,82);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","activity_resume");}
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_ealt_focuschanged(RemoteObject _hasfocus) throws Exception{
try {
		Debug.PushSubsStack("et_ealt_FocusChanged (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,131);
if (RapidSub.canDelegate("et_ealt_focuschanged")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","et_ealt_focuschanged", _hasfocus);}
Debug.locals.put("HasFocus", _hasfocus);
 BA.debugLineNum = 131;BA.debugLine="Private Sub et_ealt_FocusChanged (HasFocus As Bool";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If(HasFocus=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_hasfocus,do_tamrin_roz_layout.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 133;BA.debugLine="If(keyboard_detection=0)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",do_tamrin_roz_layout._keyboard_detection,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 134;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(32);
do_tamrin_roz_layout.mostCurrent._p = do_tamrin_roz_layout.mostCurrent._xui.runMethod(false,"CreatePanel",do_tamrin_roz_layout.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 135;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)";
Debug.ShouldStop(64);
do_tamrin_roz_layout.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),do_tamrin_roz_layout.mostCurrent.activityBA)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 BA.debugLineNum = 136;BA.debugLine="p.Color=0x81DADADA";
Debug.ShouldStop(128);
do_tamrin_roz_layout.mostCurrent._p.runMethod(true,"setColor",BA.numberCast(int.class, ((int)0x81dadada)));
 BA.debugLineNum = 137;BA.debugLine="CustomLV_tamrin.Add(p,\"\")";
Debug.ShouldStop(256);
do_tamrin_roz_layout.mostCurrent._customlv_tamrin.runVoidMethod ("_add",(Object)(do_tamrin_roz_layout.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 138;BA.debugLine="keyboard_detection=1";
Debug.ShouldStop(512);
do_tamrin_roz_layout._keyboard_detection = BA.numberCast(int.class, 1);
 };
 }else {
 BA.debugLineNum = 141;BA.debugLine="If(keyboard_detection=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",do_tamrin_roz_layout._keyboard_detection,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 142;BA.debugLine="CustomLV_tamrin.RemoveAt(10)";
Debug.ShouldStop(8192);
do_tamrin_roz_layout.mostCurrent._customlv_tamrin.runVoidMethod ("_removeat",(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 143;BA.debugLine="keyboard_detection=0";
Debug.ShouldStop(16384);
do_tamrin_roz_layout._keyboard_detection = BA.numberCast(int.class, 0);
 };
 };
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_ealt_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_ealt_TextChanged (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,98);
if (RapidSub.canDelegate("et_ealt_textchanged")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","et_ealt_textchanged", _old, _new);}
RemoteObject _this_num_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 98;BA.debugLine="Private Sub et_ealt_TextChanged (Old As String, Ne";
Debug.ShouldStop(2);
 BA.debugLineNum = 100;BA.debugLine="Dim this_num_tamrin As EditText=Sender";
Debug.ShouldStop(8);
_this_num_tamrin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
_this_num_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.EditTextWrapper"), do_tamrin_roz_layout.mostCurrent.__c.runMethod(false,"Sender",do_tamrin_roz_layout.mostCurrent.activityBA));Debug.locals.put("this_num_tamrin", _this_num_tamrin);Debug.locals.put("this_num_tamrin", _this_num_tamrin);
 BA.debugLineNum = 101;BA.debugLine="myFunc.update_tamrin1_elat(this_num_tamrin.Tag,th";
Debug.ShouldStop(16);
do_tamrin_roz_layout.mostCurrent._myfunc.runVoidMethod ("_update_tamrin1_elat" /*RemoteObject*/ ,do_tamrin_roz_layout.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_num_tamrin.runMethod(false,"getTag"))),(Object)(_this_num_tamrin.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat_focuschanged(RemoteObject _hasfocus) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat_FocusChanged (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,114);
if (RapidSub.canDelegate("et_mohebat_focuschanged")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","et_mohebat_focuschanged", _hasfocus);}
Debug.locals.put("HasFocus", _hasfocus);
 BA.debugLineNum = 114;BA.debugLine="Private Sub et_mohebat_FocusChanged (HasFocus As B";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="If(HasFocus=True)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_hasfocus,do_tamrin_roz_layout.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 116;BA.debugLine="If(keyboard_detection=0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",do_tamrin_roz_layout._keyboard_detection,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 117;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(1048576);
do_tamrin_roz_layout.mostCurrent._p = do_tamrin_roz_layout.mostCurrent._xui.runMethod(false,"CreatePanel",do_tamrin_roz_layout.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 118;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)";
Debug.ShouldStop(2097152);
do_tamrin_roz_layout.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),do_tamrin_roz_layout.mostCurrent.activityBA)),(Object)(do_tamrin_roz_layout.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 BA.debugLineNum = 119;BA.debugLine="p.Color=0x81DADADA";
Debug.ShouldStop(4194304);
do_tamrin_roz_layout.mostCurrent._p.runMethod(true,"setColor",BA.numberCast(int.class, ((int)0x81dadada)));
 BA.debugLineNum = 120;BA.debugLine="CustomLV_tamrin.Add(p,\"\")";
Debug.ShouldStop(8388608);
do_tamrin_roz_layout.mostCurrent._customlv_tamrin.runVoidMethod ("_add",(Object)(do_tamrin_roz_layout.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 121;BA.debugLine="keyboard_detection=1";
Debug.ShouldStop(16777216);
do_tamrin_roz_layout._keyboard_detection = BA.numberCast(int.class, 1);
 };
 }else {
 BA.debugLineNum = 124;BA.debugLine="If(keyboard_detection=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",do_tamrin_roz_layout._keyboard_detection,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 125;BA.debugLine="CustomLV_tamrin.RemoveAt(10)";
Debug.ShouldStop(268435456);
do_tamrin_roz_layout.mostCurrent._customlv_tamrin.runVoidMethod ("_removeat",(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 126;BA.debugLine="keyboard_detection=0";
Debug.ShouldStop(536870912);
do_tamrin_roz_layout._keyboard_detection = BA.numberCast(int.class, 0);
 };
 };
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mohebat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mohebat_TextChanged (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,106);
if (RapidSub.canDelegate("et_mohebat_textchanged")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","et_mohebat_textchanged", _old, _new);}
RemoteObject _this_num_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 106;BA.debugLine="Private Sub et_mohebat_TextChanged (Old As String,";
Debug.ShouldStop(512);
 BA.debugLineNum = 108;BA.debugLine="Dim this_num_tamrin As EditText=Sender";
Debug.ShouldStop(2048);
_this_num_tamrin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
_this_num_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.EditTextWrapper"), do_tamrin_roz_layout.mostCurrent.__c.runMethod(false,"Sender",do_tamrin_roz_layout.mostCurrent.activityBA));Debug.locals.put("this_num_tamrin", _this_num_tamrin);Debug.locals.put("this_num_tamrin", _this_num_tamrin);
 BA.debugLineNum = 109;BA.debugLine="myFunc.update_tamrin1_mohebat(this_num_tamrin.Tag";
Debug.ShouldStop(4096);
do_tamrin_roz_layout.mostCurrent._myfunc.runVoidMethod ("_update_tamrin1_mohebat" /*RemoteObject*/ ,do_tamrin_roz_layout.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_num_tamrin.runMethod(false,"getTag"))),(Object)(_this_num_tamrin.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
 //BA.debugLineNum = 16;BA.debugLine="Private CustomLV_tamrin As CustomListView";
do_tamrin_roz_layout.mostCurrent._customlv_tamrin = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
do_tamrin_roz_layout.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 20;BA.debugLine="Dim p As B4XView";
do_tamrin_roz_layout.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_num As Label";
do_tamrin_roz_layout.mostCurrent._lbl_num = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private et_mohebat As EditText";
do_tamrin_roz_layout.mostCurrent._et_mohebat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private et_ealt As EditText";
do_tamrin_roz_layout.mostCurrent._et_ealt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim keyboard_detection As Int=0";
do_tamrin_roz_layout._keyboard_detection = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_tamrin_roz As Label";
do_tamrin_roz_layout.mostCurrent._lbl_tamrin_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (do_tamrin_roz_layout) ","do_tamrin_roz_layout",7,do_tamrin_roz_layout.mostCurrent.activityBA,do_tamrin_roz_layout.mostCurrent,91);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.remoteMe.runUserSub(false, "do_tamrin_roz_layout","lbl_back_click");}
 BA.debugLineNum = 91;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
do_tamrin_roz_layout.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}