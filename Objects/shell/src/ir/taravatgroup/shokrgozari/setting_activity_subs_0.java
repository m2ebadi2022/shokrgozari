package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setting_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_create", _firsttime);}
RemoteObject _darkmod = RemoteObject.createImmutable(0);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="If(File.Exists(File.DirInternal,\"darkmod.txt\"))Th";
Debug.ShouldStop(33554432);
if ((setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("darkmod.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 27;BA.debugLine="Dim darkmod As Int = File.ReadString(File.DirInt";
Debug.ShouldStop(67108864);
_darkmod = BA.numberCast(int.class, setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("darkmod.txt"))));Debug.locals.put("darkmod", _darkmod);Debug.locals.put("darkmod", _darkmod);
 BA.debugLineNum = 28;BA.debugLine="If(darkmod=0)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_darkmod,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 30;BA.debugLine="pan_off1.Visible=True";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._pan_off1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 31;BA.debugLine="pan_on1.Visible=False";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._pan_on1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 34;BA.debugLine="pan_off1.Visible=False";
Debug.ShouldStop(2);
setting_activity.mostCurrent._pan_off1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 35;BA.debugLine="pan_on1.Visible=True";
Debug.ShouldStop(4);
setting_activity.mostCurrent._pan_on1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 };
 }else {
 BA.debugLineNum = 39;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
Debug.ShouldStop(64);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("darkmod.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 41;BA.debugLine="pan_off1.Visible=True";
Debug.ShouldStop(256);
setting_activity.mostCurrent._pan_off1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 42;BA.debugLine="pan_on1.Visible=False";
Debug.ShouldStop(512);
setting_activity.mostCurrent._pan_on1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
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
		Debug.PushSubsStack("Activity_KeyPress (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,127);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 127;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, setting_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 129;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(1);
_lbl_back_click();
 BA.debugLineNum = 130;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return setting_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 132;BA.debugLine="Return False";
Debug.ShouldStop(8);
if (true) return setting_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Pause (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,52);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Resume (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,48);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_resume");}
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 17;BA.debugLine="Private pan_off1 As Panel";
setting_activity.mostCurrent._pan_off1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pan_on1 As Panel";
setting_activity.mostCurrent._pan_on1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,122);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_back_click");}
 BA.debugLineNum = 122;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _pan_darkmod_click() throws Exception{
try {
		Debug.PushSubsStack("pan_darkMod_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,61);
if (RapidSub.canDelegate("pan_darkmod_click")) { return ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_darkmod_click");}
 BA.debugLineNum = 61;BA.debugLine="Private Sub pan_darkMod_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="If(pan_on1.Visible=False)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_on1.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 65;BA.debugLine="pan_off1.Visible=False";
Debug.ShouldStop(1);
setting_activity.mostCurrent._pan_off1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 66;BA.debugLine="pan_on1.Visible=True";
Debug.ShouldStop(2);
setting_activity.mostCurrent._pan_on1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 68;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
Debug.ShouldStop(8);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("darkmod.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 71;BA.debugLine="pan_on1.Visible=False";
Debug.ShouldStop(64);
setting_activity.mostCurrent._pan_on1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="pan_off1.Visible=True";
Debug.ShouldStop(128);
setting_activity.mostCurrent._pan_off1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 73;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
Debug.ShouldStop(256);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("darkmod.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
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
public static void  _pan_remove_allsounds_click() throws Exception{
try {
		Debug.PushSubsStack("pan_remove_allSounds_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,92);
if (RapidSub.canDelegate("pan_remove_allsounds_click")) { ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_remove_allsounds_click"); return;}
ResumableSub_pan_remove_allSounds_Click rsub = new ResumableSub_pan_remove_allSounds_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_pan_remove_allSounds_Click extends BA.ResumableSub {
public ResumableSub_pan_remove_allSounds_Click(ir.taravatgroup.shokrgozari.setting_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.setting_activity parent;
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _ls_removeall = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
int step7;
int limit7;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("pan_remove_allSounds_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,92);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 94;BA.debugLine="Msgbox2Async(\"آیا همه فایلهای صوتی دانلود شده حذف";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("آیا همه فایلهای صوتی دانلود شده حذف شوند؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),setting_activity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 95;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", setting_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "setting_activity", "pan_remove_allsounds_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 96;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 1:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 98;BA.debugLine="Dim ls_removeAll As List";
Debug.ShouldStop(2);
_ls_removeall = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_removeAll", _ls_removeall);
 BA.debugLineNum = 99;BA.debugLine="ls_removeAll.Initialize";
Debug.ShouldStop(4);
_ls_removeall.runVoidMethod ("Initialize");
 BA.debugLineNum = 100;BA.debugLine="ls_removeAll=myFunc.get_removeAll_list";
Debug.ShouldStop(8);
_ls_removeall = parent.mostCurrent._myfunc.runMethod(false,"_get_removeall_list" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA);Debug.locals.put("ls_removeAll", _ls_removeall);
 BA.debugLineNum = 102;BA.debugLine="For i=0 To ls_removeAll.Size-1";
Debug.ShouldStop(32);
if (true) break;

case 4:
//for
this.state = 11;
step7 = 1;
limit7 = RemoteObject.solve(new RemoteObject[] {_ls_removeall.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 14;
if (true) break;

case 14:
//C
this.state = 11;
if ((step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7)) this.state = 6;
if (true) break;

case 15:
//C
this.state = 14;
_i = ((int)(0 + _i + step7)) ;
Debug.locals.put("i", _i);
if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 103;BA.debugLine="If(File.Exists(File.DirInternal,ls_removeAll.Get";
Debug.ShouldStop(64);
if (true) break;

case 7:
//if
this.state = 10;
if ((parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString(_ls_removeall.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))))).<Boolean>get().booleanValue()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 104;BA.debugLine="File.Delete(File.DirInternal,ls_removeAll.Get(i";
Debug.ShouldStop(128);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString(_ls_removeall.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 if (true) break;

case 10:
//C
this.state = 15;
;
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"حذف شدند.\",False)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شدند.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
public static void  _pan_remove_alltamrinat_click() throws Exception{
try {
		Debug.PushSubsStack("pan_remove_AllTamrinat_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,79);
if (RapidSub.canDelegate("pan_remove_alltamrinat_click")) { ir.taravatgroup.shokrgozari.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_remove_alltamrinat_click"); return;}
ResumableSub_pan_remove_AllTamrinat_Click rsub = new ResumableSub_pan_remove_AllTamrinat_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_pan_remove_AllTamrinat_Click extends BA.ResumableSub {
public ResumableSub_pan_remove_AllTamrinat_Click(ir.taravatgroup.shokrgozari.setting_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.setting_activity parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("pan_remove_AllTamrinat_Click (setting_activity) ","setting_activity",11,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,79);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 81;BA.debugLine="Msgbox2Async(\"آیا همه تمرینات من حذف شوند؟\", \"حذف";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("آیا همه تمرینات من حذف شوند؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),setting_activity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 82;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", setting_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "setting_activity", "pan_remove_alltamrinat_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 83;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 84;BA.debugLine="myFunc.removeAll_tamrinat";
Debug.ShouldStop(524288);
parent.mostCurrent._myfunc.runVoidMethod ("_removeall_tamrinat" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 85;BA.debugLine="ToastMessageShow(\"حذف شدند.\",False)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شدند.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}