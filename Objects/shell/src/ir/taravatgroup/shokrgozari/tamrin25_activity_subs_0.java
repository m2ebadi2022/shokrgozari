package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tamrin25_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","activity_create", _firsttime);}
RemoteObject _ls_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"tamrin25_layout\")";
Debug.ShouldStop(536870912);
tamrin25_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tamrin25_layout")),tamrin25_activity.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="Chooser.Initialize(\"chooser\")";
Debug.ShouldStop(-2147483648);
tamrin25_activity._chooser.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("chooser")));
 BA.debugLineNum = 33;BA.debugLine="et_matn1.Color=0xABFFFFFF";
Debug.ShouldStop(1);
tamrin25_activity.mostCurrent._et_matn1.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 34;BA.debugLine="et_matn2.Color=0xABFFFFFF";
Debug.ShouldStop(2);
tamrin25_activity.mostCurrent._et_matn2.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 35;BA.debugLine="et_matn3.Color=0xABFFFFFF";
Debug.ShouldStop(4);
tamrin25_activity.mostCurrent._et_matn3.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xabffffff)));
 BA.debugLineNum = 37;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_1.j";
Debug.ShouldStop(16);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_1.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 38;BA.debugLine="pan_upload_pic1.SetBackgroundImage(LoadBitmapSam";
Debug.ShouldStop(32);
tamrin25_activity.mostCurrent._pan_upload_pic1.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_1.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 };
 BA.debugLineNum = 40;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_2.j";
Debug.ShouldStop(128);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_2.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 41;BA.debugLine="pan_upload_pic2.SetBackgroundImage(LoadBitmapSam";
Debug.ShouldStop(256);
tamrin25_activity.mostCurrent._pan_upload_pic2.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_2.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 };
 BA.debugLineNum = 43;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_3.j";
Debug.ShouldStop(1024);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_3.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 44;BA.debugLine="pan_upload_pic3.SetBackgroundImage(LoadBitmapSam";
Debug.ShouldStop(2048);
tamrin25_activity.mostCurrent._pan_upload_pic3.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_3.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 };
 BA.debugLineNum = 47;BA.debugLine="Dim ls_content As List";
Debug.ShouldStop(16384);
_ls_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 48;BA.debugLine="ls_content.Initialize";
Debug.ShouldStop(32768);
_ls_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 49;BA.debugLine="ls_content=myFunc.get_tamrinat_saved(Main.current";
Debug.ShouldStop(65536);
_ls_content = tamrin25_activity.mostCurrent._myfunc.runMethod(false,"_get_tamrinat_saved" /*RemoteObject*/ ,tamrin25_activity.mostCurrent.activityBA,(Object)(tamrin25_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(tamrin25_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ));Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 51;BA.debugLine="et_matn1.text=ls_content.Get(0)";
Debug.ShouldStop(262144);
tamrin25_activity.mostCurrent._et_matn1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 52;BA.debugLine="et_matn2.text=ls_content.Get(1)";
Debug.ShouldStop(524288);
tamrin25_activity.mostCurrent._et_matn2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 53;BA.debugLine="et_matn3.text=ls_content.Get(2)";
Debug.ShouldStop(1048576);
tamrin25_activity.mostCurrent._et_matn3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_content.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_KeyPress (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,96);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, tamrin25_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 98;BA.debugLine="If(pan_all_showPic.Visible=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"getVisible"),tamrin25_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 99;BA.debugLine="pan_all_showPic.Visible=False";
Debug.ShouldStop(4);
tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"setVisible",tamrin25_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 101;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16);
_lbl_back_click();
 };
 BA.debugLineNum = 106;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return tamrin25_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 108;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return tamrin25_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Pause (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,85);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,81);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","activity_resume");}
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chooser_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("chooser_Result (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,57);
if (RapidSub.canDelegate("chooser_result")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","chooser_result", _success, _dir, _filename);}
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 57;BA.debugLine="Sub chooser_Result (Success As Boolean, Dir As Str";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="If Success Then";
Debug.ShouldStop(33554432);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 60;BA.debugLine="Select pic_upload_index";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(tamrin25_activity._pic_upload_index,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 62;BA.debugLine="pan_upload_pic1.SetBackgroundImage(LoadBitmapS";
Debug.ShouldStop(536870912);
tamrin25_activity.mostCurrent._pan_upload_pic1.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 BA.debugLineNum = 63;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
Debug.ShouldStop(1073741824);
tamrin25_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_1.jpg")));
 break; }
case 1: {
 BA.debugLineNum = 65;BA.debugLine="pan_upload_pic2.SetBackgroundImage(LoadBitmapS";
Debug.ShouldStop(1);
tamrin25_activity.mostCurrent._pan_upload_pic2.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 BA.debugLineNum = 66;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
Debug.ShouldStop(2);
tamrin25_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_2.jpg")));
 break; }
case 2: {
 BA.debugLineNum = 68;BA.debugLine="pan_upload_pic3.SetBackgroundImage(LoadBitmapS";
Debug.ShouldStop(8);
tamrin25_activity.mostCurrent._pan_upload_pic3.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 BA.debugLineNum = 69;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
Debug.ShouldStop(16);
tamrin25_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_3.jpg")));
 break; }
}
;
 BA.debugLineNum = 73;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
Debug.ShouldStop(256);
tamrin25_activity.mostCurrent._pan_showpic.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(_dir),(Object)(_filename),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 }else {
 BA.debugLineNum = 76;BA.debugLine="ToastMessageShow(\"No image selected\", True)";
Debug.ShouldStop(2048);
tamrin25_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No image selected")),(Object)(tamrin25_activity.mostCurrent.__c.getField(true,"True")));
 };
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
public static RemoteObject  _et_matn1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_matn1_TextChanged (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,161);
if (RapidSub.canDelegate("et_matn1_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","et_matn1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 161;BA.debugLine="Private Sub et_matn1_TextChanged (Old As String, N";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
Debug.ShouldStop(2);
tamrin25_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrinat_saved" /*RemoteObject*/ ,tamrin25_activity.mostCurrent.activityBA,(Object)(tamrin25_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(tamrin25_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 1)),(Object)(_new),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("et_matn2_TextChanged (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,157);
if (RapidSub.canDelegate("et_matn2_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","et_matn2_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 157;BA.debugLine="Private Sub et_matn2_TextChanged (Old As String, N";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
Debug.ShouldStop(536870912);
tamrin25_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrinat_saved" /*RemoteObject*/ ,tamrin25_activity.mostCurrent.activityBA,(Object)(tamrin25_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(tamrin25_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 2)),(Object)(_new),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("et_matn3_TextChanged (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,153);
if (RapidSub.canDelegate("et_matn3_textchanged")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","et_matn3_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 153;BA.debugLine="Private Sub et_matn3_TextChanged (Old As String, N";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
Debug.ShouldStop(33554432);
tamrin25_activity.mostCurrent._myfunc.runVoidMethod ("_update_tamrinat_saved" /*RemoteObject*/ ,tamrin25_activity.mostCurrent.activityBA,(Object)(tamrin25_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/ ),(Object)(tamrin25_activity.mostCurrent._main._current_tamrin /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 3)),(Object)(_new),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_matn1 As EditText";
tamrin25_activity.mostCurrent._et_matn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_matn2 As EditText";
tamrin25_activity.mostCurrent._et_matn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_matn3 As EditText";
tamrin25_activity.mostCurrent._et_matn3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pan_upload_pic1 As Panel";
tamrin25_activity.mostCurrent._pan_upload_pic1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private pan_upload_pic2 As Panel";
tamrin25_activity.mostCurrent._pan_upload_pic2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pan_upload_pic3 As Panel";
tamrin25_activity.mostCurrent._pan_upload_pic3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim pic_upload_index As Int=0";
tamrin25_activity._pic_upload_index = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 24;BA.debugLine="Private pan_showPic As Panel";
tamrin25_activity.mostCurrent._pan_showpic = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pan_all_showPic As Panel";
tamrin25_activity.mostCurrent._pan_all_showpic = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,91);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","lbl_back_click");}
 BA.debugLineNum = 91;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
tamrin25_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_open_help_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_open_help_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,113);
if (RapidSub.canDelegate("lbl_open_help_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","lbl_open_help_click");}
 BA.debugLineNum = 113;BA.debugLine="Private Sub lbl_open_help_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_showpic_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_showPic_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,169);
if (RapidSub.canDelegate("pan_all_showpic_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","pan_all_showpic_click");}
 BA.debugLineNum = 169;BA.debugLine="Private Sub pan_all_showPic_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 170;BA.debugLine="pan_all_showPic.Visible=False";
Debug.ShouldStop(512);
tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"setVisible",tamrin25_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_showpic_click() throws Exception{
try {
		Debug.PushSubsStack("pan_showPic_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,165);
if (RapidSub.canDelegate("pan_showpic_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","pan_showpic_click");}
 BA.debugLineNum = 165;BA.debugLine="Private Sub pan_showPic_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
Debug.ShouldStop(32);
tamrin25_activity._chooser.runVoidMethod ("Show",tamrin25_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select an image")));
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
public static RemoteObject  _pan_upload_pic1_click() throws Exception{
try {
		Debug.PushSubsStack("pan_upload_pic1_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,141);
if (RapidSub.canDelegate("pan_upload_pic1_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","pan_upload_pic1_click");}
 BA.debugLineNum = 141;BA.debugLine="Private Sub pan_upload_pic1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="pic_upload_index=1";
Debug.ShouldStop(8192);
tamrin25_activity._pic_upload_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 144;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_1.j";
Debug.ShouldStop(32768);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_1.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 145;BA.debugLine="pan_all_showPic.Visible=True";
Debug.ShouldStop(65536);
tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"setVisible",tamrin25_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 146;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
Debug.ShouldStop(131072);
tamrin25_activity.mostCurrent._pan_showpic.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_1.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 }else {
 BA.debugLineNum = 148;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
Debug.ShouldStop(524288);
tamrin25_activity._chooser.runVoidMethod ("Show",tamrin25_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select an image")));
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_upload_pic2_click() throws Exception{
try {
		Debug.PushSubsStack("pan_upload_pic2_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,129);
if (RapidSub.canDelegate("pan_upload_pic2_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","pan_upload_pic2_click");}
 BA.debugLineNum = 129;BA.debugLine="Private Sub pan_upload_pic2_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="pic_upload_index=2";
Debug.ShouldStop(2);
tamrin25_activity._pic_upload_index = BA.numberCast(int.class, 2);
 BA.debugLineNum = 132;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_2.j";
Debug.ShouldStop(8);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_2.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 133;BA.debugLine="pan_all_showPic.Visible=True";
Debug.ShouldStop(16);
tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"setVisible",tamrin25_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 134;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
Debug.ShouldStop(32);
tamrin25_activity.mostCurrent._pan_showpic.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_2.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 }else {
 BA.debugLineNum = 136;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
Debug.ShouldStop(128);
tamrin25_activity._chooser.runVoidMethod ("Show",tamrin25_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select an image")));
 };
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
public static RemoteObject  _pan_upload_pic3_click() throws Exception{
try {
		Debug.PushSubsStack("pan_upload_pic3_Click (tamrin25_activity) ","tamrin25_activity",17,tamrin25_activity.mostCurrent.activityBA,tamrin25_activity.mostCurrent,117);
if (RapidSub.canDelegate("pan_upload_pic3_click")) { return ir.taravatgroup.shokrgozari.tamrin25_activity.remoteMe.runUserSub(false, "tamrin25_activity","pan_upload_pic3_click");}
 BA.debugLineNum = 117;BA.debugLine="Private Sub pan_upload_pic3_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="pic_upload_index=3";
Debug.ShouldStop(2097152);
tamrin25_activity._pic_upload_index = BA.numberCast(int.class, 3);
 BA.debugLineNum = 120;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin25_3.j";
Debug.ShouldStop(8388608);
if ((tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("pic_tamrin25_3.jpg")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 121;BA.debugLine="pan_all_showPic.Visible=True";
Debug.ShouldStop(16777216);
tamrin25_activity.mostCurrent._pan_all_showpic.runMethod(true,"setVisible",tamrin25_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 122;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
Debug.ShouldStop(33554432);
tamrin25_activity.mostCurrent._pan_showpic.runVoidMethod ("SetBackgroundImageNew",(Object)((tamrin25_activity.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(tamrin25_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("pic_tamrin25_3.jpg")),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tamrin25_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))))).getObject())));
 }else {
 BA.debugLineNum = 124;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
Debug.ShouldStop(134217728);
tamrin25_activity._chooser.runVoidMethod ("Show",tamrin25_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select an image")));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Chooser As ContentChooser";
tamrin25_activity._chooser = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}