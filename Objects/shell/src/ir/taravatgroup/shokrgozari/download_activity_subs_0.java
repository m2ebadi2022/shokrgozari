package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class download_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"download_layout\")";
Debug.ShouldStop(2);
download_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("download_layout")),download_activity.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(4);
download_activity.mostCurrent._strfunc.runVoidMethod ("_initialize",download_activity.processBA);
 BA.debugLineNum = 36;BA.debugLine="j.Initialize(\"job\", Me)";
Debug.ShouldStop(8);
download_activity.mostCurrent._j.runClassMethod (ir.taravatgroup.shokrgozari.httpjob.class, "_initialize" /*RemoteObject*/ ,download_activity.processBA,(Object)(BA.ObjectToString("job")),(Object)(download_activity.getObject()));
 BA.debugLineNum = 38;BA.debugLine="list_download.Initialize";
Debug.ShouldStop(32);
download_activity.mostCurrent._list_download.runVoidMethod ("Initialize");
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,58);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, download_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 60;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(134217728);
_lbl_back_click();
 BA.debugLineNum = 61;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
if (true) return download_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 63;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
if (true) return download_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Pause (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,47);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","activity_resume");}
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="fill_list";
Debug.ShouldStop(2048);
_fill_list();
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
public static RemoteObject  _delete_filebyname(RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("delete_fileByName (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,210);
if (RapidSub.canDelegate("delete_filebyname")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","delete_filebyname", _name);}
Debug.locals.put("name", _name);
 BA.debugLineNum = 210;BA.debugLine="Sub delete_fileByName(name As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 211;BA.debugLine="If(File.Exists(File.DirInternal,name))Then";
Debug.ShouldStop(262144);
if ((download_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(download_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 212;BA.debugLine="File.Delete(File.DirInternal,name)";
Debug.ShouldStop(524288);
download_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(download_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name));
 BA.debugLineNum = 213;BA.debugLine="fill_list";
Debug.ShouldStop(1048576);
_fill_list();
 BA.debugLineNum = 214;BA.debugLine="ToastMessageShow(\"فایل صوتی حذف شد.\",False)";
Debug.ShouldStop(2097152);
download_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("فایل صوتی حذف شد.")),(Object)(download_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _download_byname() throws Exception{
try {
		Debug.PushSubsStack("download_byName (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,174);
if (RapidSub.canDelegate("download_byname")) { ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","download_byname"); return;}
ResumableSub_download_byName rsub = new ResumableSub_download_byName(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_download_byName extends BA.ResumableSub {
public ResumableSub_download_byName(ir.taravatgroup.shokrgozari.download_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.download_activity parent;
RemoteObject _job = RemoteObject.declareNull("ir.taravatgroup.shokrgozari.httpjob");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("download_byName (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,174);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 175;BA.debugLine="Try";
Debug.ShouldStop(16384);
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
 BA.debugLineNum = 178;BA.debugLine="j.Download(\"https://m2ebadi.whi.ir/shokrgozari/s";
Debug.ShouldStop(131072);
parent.mostCurrent._j.runClassMethod (ir.taravatgroup.shokrgozari.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("https://m2ebadi.whi.ir/shokrgozari/sounds/"),parent.mostCurrent._current_down_name)));
 BA.debugLineNum = 181;BA.debugLine="Wait For JobDone(job As HttpJob)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", download_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "download_activity", "download_byname"), null);
this.state = 17;
return;
case 17:
//C
this.state = 4;
_job = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("job", _job);
;
 BA.debugLineNum = 182;BA.debugLine="If j.Success Then";
Debug.ShouldStop(2097152);
if (true) break;

case 4:
//if
this.state = 7;
if (parent.mostCurrent._j.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 184;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.";
Debug.ShouldStop(8388608);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = parent.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._current_down_name),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 185;BA.debugLine="File.Copy2(job.GetInputStream, out)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((_job.runClassMethod (ir.taravatgroup.shokrgozari.httpjob.class, "_getinputstream" /*RemoteObject*/ ).getObject())),(Object)((_out.getObject())));
 BA.debugLineNum = 186;BA.debugLine="out.Close";
Debug.ShouldStop(33554432);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 188;BA.debugLine="current_down_name=\"\"";
Debug.ShouldStop(134217728);
parent.mostCurrent._current_down_name = BA.ObjectToString("");
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 190;BA.debugLine="job.Release";
Debug.ShouldStop(536870912);
_job.runClassMethod (ir.taravatgroup.shokrgozari.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 192;BA.debugLine="If(list_download.Size<>0)Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 8:
//if
this.state = 13;
if ((RemoteObject.solveBoolean("!",parent.mostCurrent._list_download.runMethod(true,"getSize"),BA.numberCast(double.class, 0)))) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 13;
 BA.debugLineNum = 193;BA.debugLine="current_down_name=list_download.Get(0)";
Debug.ShouldStop(1);
parent.mostCurrent._current_down_name = BA.ObjectToString(parent.mostCurrent._list_download.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 194;BA.debugLine="list_download.RemoveAt(0)";
Debug.ShouldStop(2);
parent.mostCurrent._list_download.runVoidMethod ("RemoveAt",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 195;BA.debugLine="download_byName";
Debug.ShouldStop(4);
_download_byname();
 if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 197;BA.debugLine="fill_list";
Debug.ShouldStop(16);
_fill_list();
 BA.debugLineNum = 198;BA.debugLine="ToastMessageShow(\"فایلهای صوتی دانلود شدند.\", F";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("فایلهای صوتی دانلود شدند.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 203;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","49895965",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",download_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 204;BA.debugLine="ToastMessageShow(\"منتظر باشید ..\",False)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("منتظر باشید ..")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",download_activity.processBA, e0.toString());}
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
public static void  _jobdone(RemoteObject _job) throws Exception{
}
public static RemoteObject  _fill_list() throws Exception{
try {
		Debug.PushSubsStack("fill_list (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,127);
if (RapidSub.canDelegate("fill_list")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","fill_list");}
RemoteObject _list_fehrest = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _list_row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 127;BA.debugLine="Sub fill_list";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="CustomListView1.Clear";
Debug.ShouldStop(1);
download_activity.mostCurrent._customlistview1.runVoidMethod ("_clear");
 BA.debugLineNum = 131;BA.debugLine="Dim list_fehrest As List";
Debug.ShouldStop(4);
_list_fehrest = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_fehrest", _list_fehrest);
 BA.debugLineNum = 132;BA.debugLine="list_fehrest.Initialize";
Debug.ShouldStop(8);
_list_fehrest.runVoidMethod ("Initialize");
 BA.debugLineNum = 133;BA.debugLine="list_fehrest=myFunc.get_download_list";
Debug.ShouldStop(16);
_list_fehrest = download_activity.mostCurrent._myfunc.runMethod(false,"_get_download_list" /*RemoteObject*/ ,download_activity.mostCurrent.activityBA);Debug.locals.put("list_fehrest", _list_fehrest);
 BA.debugLineNum = 136;BA.debugLine="For i=0 To list_fehrest.Size-1";
Debug.ShouldStop(128);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_list_fehrest.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 138;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(512);
download_activity.mostCurrent._p = download_activity.mostCurrent._xui.runMethod(false,"CreatePanel",download_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 140;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
Debug.ShouldStop(2048);
download_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(download_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),download_activity.mostCurrent.activityBA)),(Object)(download_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))));
 BA.debugLineNum = 141;BA.debugLine="p.LoadLayout(\"item_list_downloads\")";
Debug.ShouldStop(4096);
download_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_downloads")),download_activity.mostCurrent.activityBA);
 BA.debugLineNum = 144;BA.debugLine="CustomListView1.Add(p,i)";
Debug.ShouldStop(32768);
download_activity.mostCurrent._customlistview1.runVoidMethod ("_add",(Object)(download_activity.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 147;BA.debugLine="Dim list_row As List";
Debug.ShouldStop(262144);
_list_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_row", _list_row);
 BA.debugLineNum = 148;BA.debugLine="list_row.Initialize";
Debug.ShouldStop(524288);
_list_row.runVoidMethod ("Initialize");
 BA.debugLineNum = 149;BA.debugLine="list_row=strFunc.Split(list_fehrest.Get(i) , \"@\"";
Debug.ShouldStop(1048576);
_list_row = download_activity.mostCurrent._strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_list_fehrest.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_row", _list_row);
 BA.debugLineNum = 152;BA.debugLine="lbl_donw_title.Text=\" \"&list_row.Get(1)";
Debug.ShouldStop(8388608);
download_activity.mostCurrent._lbl_donw_title.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" "),_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 153;BA.debugLine="lbl_donw_detile.Text=\" \"&list_row.Get(2)";
Debug.ShouldStop(16777216);
download_activity.mostCurrent._lbl_donw_detile.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" "),_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 155;BA.debugLine="pan_download.Tag=list_row.Get(0)";
Debug.ShouldStop(67108864);
download_activity.mostCurrent._pan_download.runMethod(false,"setTag",_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 157;BA.debugLine="If(File.Exists(File.DirInternal,list_row.Get(3))";
Debug.ShouldStop(268435456);
if ((download_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(download_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString(_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 158;BA.debugLine="lbl_down_del.Text=Chr(0xF014)  'delete icon";
Debug.ShouldStop(536870912);
download_activity.mostCurrent._lbl_down_del.runMethod(true,"setText",BA.ObjectToCharSequence(download_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf014))))));
 BA.debugLineNum = 159;BA.debugLine="lbl_down_del.textColor=0xFFFF5050";
Debug.ShouldStop(1073741824);
download_activity.mostCurrent._lbl_down_del.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff5050)));
 BA.debugLineNum = 160;BA.debugLine="lbl_down_del.Tag=\"del@\"&list_row.Get(3)";
Debug.ShouldStop(-2147483648);
download_activity.mostCurrent._lbl_down_del.runMethod(false,"setTag",(RemoteObject.concat(RemoteObject.createImmutable("del@"),_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))))));
 }else {
 BA.debugLineNum = 163;BA.debugLine="lbl_down_del.Text=Chr(0xF019)  'download icon";
Debug.ShouldStop(4);
download_activity.mostCurrent._lbl_down_del.runMethod(true,"setText",BA.ObjectToCharSequence(download_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf019))))));
 BA.debugLineNum = 164;BA.debugLine="lbl_down_del.textColor=0xFF0CA300";
Debug.ShouldStop(8);
download_activity.mostCurrent._lbl_down_del.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0ca300)));
 BA.debugLineNum = 165;BA.debugLine="lbl_down_del.Tag=\"down@\"&list_row.Get(3)";
Debug.ShouldStop(16);
download_activity.mostCurrent._lbl_down_del.runMethod(false,"setTag",(RemoteObject.concat(RemoteObject.createImmutable("down@"),_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))))));
 };
 }
}Debug.locals.put("i", _i);
;
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
download_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
download_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private CustomListView1 As CustomListView";
download_activity.mostCurrent._customlistview1 = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 20;BA.debugLine="Private pan_download As Panel";
download_activity.mostCurrent._pan_download = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_down_del As Label";
download_activity.mostCurrent._lbl_down_del = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_donw_title As Label";
download_activity.mostCurrent._lbl_donw_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_donw_detile As Label";
download_activity.mostCurrent._lbl_donw_detile = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim strFunc As StringFunctions";
download_activity.mostCurrent._strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");
 //BA.debugLineNum = 26;BA.debugLine="Dim j As HttpJob";
download_activity.mostCurrent._j = RemoteObject.createNew ("ir.taravatgroup.shokrgozari.httpjob");
 //BA.debugLineNum = 27;BA.debugLine="Dim list_download As List";
download_activity.mostCurrent._list_download = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 28;BA.debugLine="Dim current_down_name As String=\"\"";
download_activity.mostCurrent._current_down_name = BA.ObjectToString("");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,53);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","lbl_back_click");}
 BA.debugLineNum = 53;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
download_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static void  _lbl_down_del_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_down_del_Click (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,69);
if (RapidSub.canDelegate("lbl_down_del_click")) { ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","lbl_down_del_click"); return;}
ResumableSub_lbl_down_del_Click rsub = new ResumableSub_lbl_down_del_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lbl_down_del_Click extends BA.ResumableSub {
public ResumableSub_lbl_down_del_Click(ir.taravatgroup.shokrgozari.download_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.download_activity parent;
RemoteObject _func_del_down = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _list_row_mod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lbl_down_del_Click (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,69);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 70;BA.debugLine="Dim func_del_down As Label=Sender";
Debug.ShouldStop(32);
_func_del_down = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_func_del_down = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), parent.mostCurrent.__c.runMethod(false,"Sender",download_activity.mostCurrent.activityBA));Debug.locals.put("func_del_down", _func_del_down);Debug.locals.put("func_del_down", _func_del_down);
 BA.debugLineNum = 73;BA.debugLine="Dim list_row_mod As List";
Debug.ShouldStop(256);
_list_row_mod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_row_mod", _list_row_mod);
 BA.debugLineNum = 74;BA.debugLine="list_row_mod.Initialize";
Debug.ShouldStop(512);
_list_row_mod.runVoidMethod ("Initialize");
 BA.debugLineNum = 75;BA.debugLine="list_row_mod=strFunc.Split(func_del_down.Tag , \"@";
Debug.ShouldStop(1024);
_list_row_mod = parent.mostCurrent._strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_func_del_down.runMethod(false,"getTag"))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_row_mod", _list_row_mod);
 BA.debugLineNum = 77;BA.debugLine="If(list_row_mod.Get(0)=\"down\")Then";
Debug.ShouldStop(4096);
if (true) break;

case 1:
//if
this.state = 18;
if ((RemoteObject.solveBoolean("=",_list_row_mod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("down"))))) { 
this.state = 3;
}else {
this.state = 17;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 79;BA.debugLine="Dim rp As RuntimePermissions";
Debug.ShouldStop(16384);
_rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("rp", _rp);
 BA.debugLineNum = 80;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
Debug.ShouldStop(32768);
_rp.runVoidMethod ("CheckAndRequest",download_activity.processBA,(Object)(_rp.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 81;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", download_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "download_activity", "lbl_down_del_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 82;BA.debugLine="If Result Then";
Debug.ShouldStop(131072);
if (true) break;

case 4:
//if
this.state = 9;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 if (true) break;

case 8:
//C
this.state = 9;
 if (true) break;

case 9:
//C
this.state = 10;
;
 BA.debugLineNum = 88;BA.debugLine="func_del_down.Text=Chr(0xF1CE)  'downloading";
Debug.ShouldStop(8388608);
_func_del_down.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf1ce))))));
 BA.debugLineNum = 89;BA.debugLine="myFunc.setRotation(func_del_down,10000,360)";
Debug.ShouldStop(16777216);
parent.mostCurrent._myfunc.runVoidMethod ("_setrotation" /*RemoteObject*/ ,download_activity.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _func_del_down.getObject()),(Object)(BA.numberCast(int.class, 10000)),(Object)(BA.numberCast(float.class, 360)));
 BA.debugLineNum = 90;BA.debugLine="func_del_down.SetTextColorAnimated(300,Colors.Bl";
Debug.ShouldStop(33554432);
_func_del_down.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue")));
 BA.debugLineNum = 95;BA.debugLine="If (current_down_name=\"\")Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 10:
//if
this.state = 15;
if ((RemoteObject.solveBoolean("=",parent.mostCurrent._current_down_name,RemoteObject.createImmutable("")))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 96;BA.debugLine="current_down_name=list_row_mod.Get(1)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._current_down_name = BA.ObjectToString(_list_row_mod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 97;BA.debugLine="download_byName";
Debug.ShouldStop(1);
_download_byname();
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 99;BA.debugLine="list_download.Add(list_row_mod.Get(1))";
Debug.ShouldStop(4);
parent.mostCurrent._list_download.runVoidMethod ("Add",(Object)(_list_row_mod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 109;BA.debugLine="delete_fileByName(list_row_mod.Get(1))";
Debug.ShouldStop(4096);
_delete_filebyname(BA.ObjectToString(_list_row_mod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 if (true) break;

case 18:
//C
this.state = -1;
;
 BA.debugLineNum = 112;BA.debugLine="End Sub";
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
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _pan_download_click() throws Exception{
try {
		Debug.PushSubsStack("pan_download_Click (download_activity) ","download_activity",8,download_activity.mostCurrent.activityBA,download_activity.mostCurrent,116);
if (RapidSub.canDelegate("pan_download_click")) { return ir.taravatgroup.shokrgozari.download_activity.remoteMe.runUserSub(false, "download_activity","pan_download_click");}
RemoteObject _go_to_readingbook = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 116;BA.debugLine="Private Sub pan_download_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="Dim go_to_readingBook As Panel=Sender";
Debug.ShouldStop(1048576);
_go_to_readingbook = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_go_to_readingbook = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), download_activity.mostCurrent.__c.runMethod(false,"Sender",download_activity.mostCurrent.activityBA));Debug.locals.put("go_to_readingBook", _go_to_readingbook);Debug.locals.put("go_to_readingBook", _go_to_readingbook);
 BA.debugLineNum = 119;BA.debugLine="Main.current_book_content_id=go_to_readingBook.Ta";
Debug.ShouldStop(4194304);
download_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/  = BA.numberCast(int.class, _go_to_readingbook.runMethod(false,"getTag"));
 BA.debugLineNum = 121;BA.debugLine="StartActivity(reagBook_activity)";
Debug.ShouldStop(16777216);
download_activity.mostCurrent.__c.runVoidMethod ("StartActivity",download_activity.processBA,(Object)((download_activity.mostCurrent._reagbook_activity.getObject())));
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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