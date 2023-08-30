package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class reagbook_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","activity_create", _firsttime);}
RemoteObject _ls_content_book = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _wvsetttings = RemoteObject.declareNull("uk.co.martinpearman.b4a.webviewsettings.WebViewSettings");
RemoteObject _str_html_pleyer = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"readBook_layout\")";
Debug.ShouldStop(1);
reagbook_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("readBook_layout")),reagbook_activity.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Dim ls_content_book As List";
Debug.ShouldStop(4);
_ls_content_book = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content_book", _ls_content_book);
 BA.debugLineNum = 36;BA.debugLine="ls_content_book.Initialize";
Debug.ShouldStop(8);
_ls_content_book.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="ls_content_book=	myFunc.get_book_byId(Main.curren";
Debug.ShouldStop(32);
_ls_content_book = reagbook_activity.mostCurrent._myfunc.runMethod(false,"_get_book_byid" /*RemoteObject*/ ,reagbook_activity.mostCurrent.activityBA,(Object)(reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ));Debug.locals.put("ls_content_book", _ls_content_book);
 BA.debugLineNum = 40;BA.debugLine="lbl_title.Text=ls_content_book.Get(5)";
Debug.ShouldStop(128);
reagbook_activity.mostCurrent._lbl_title.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 43;BA.debugLine="pic_addres=ls_content_book.Get(2)";
Debug.ShouldStop(1024);
reagbook_activity.mostCurrent._pic_addres = BA.ObjectToString(_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 44;BA.debugLine="sound_addres=ls_content_book.Get(3)";
Debug.ShouldStop(2048);
reagbook_activity.mostCurrent._sound_addres = BA.ObjectToString(_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 BA.debugLineNum = 46;BA.debugLine="ls_content_book.Get(4)";
Debug.ShouldStop(8192);
_ls_content_book.runVoidMethod ("Get",(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 47;BA.debugLine="If(ls_content_book.Get(4).As(Int)=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",(BA.numberCast(int.class, _ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 48;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
Debug.ShouldStop(32768);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf004))))));
 BA.debugLineNum = 49;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
Debug.ShouldStop(65536);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff3838)));
 }else {
 BA.debugLineNum = 51;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
Debug.ShouldStop(262144);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf08a))))));
 BA.debugLineNum = 52;BA.debugLine="lbl_fav.TextColor=0xFF686868";
Debug.ShouldStop(524288);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff686868)));
 };
 BA.debugLineNum = 59;BA.debugLine="str_html_lite=\"<html><head><meta name='viewport'";
Debug.ShouldStop(67108864);
reagbook_activity.mostCurrent._str_html_lite = RemoteObject.concat(RemoteObject.createImmutable("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color:  rgba(0, 0, 0, 0) ; color: black;'><img src='"),reagbook_activity.mostCurrent._xui.runMethod(true,"FileUri",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(reagbook_activity.mostCurrent._pic_addres)),RemoteObject.createImmutable("' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"),_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("</b><p>"),_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("<br><br><br><br></p></body></html>"));
 BA.debugLineNum = 62;BA.debugLine="str_html_dark=\"<html><head><meta name='viewport'";
Debug.ShouldStop(536870912);
reagbook_activity.mostCurrent._str_html_dark = RemoteObject.concat(RemoteObject.createImmutable("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color: rgba(0, 0, 0, 0); color: white;'><img src='"),reagbook_activity.mostCurrent._xui.runMethod(true,"FileUri",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(reagbook_activity.mostCurrent._pic_addres)),RemoteObject.createImmutable("' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"),_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("</b><p>"),_ls_content_book.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("<br><br><br><br></p></body></html>"));
 BA.debugLineNum = 66;BA.debugLine="Private wvsetttings As WebViewSettings";
Debug.ShouldStop(2);
_wvsetttings = RemoteObject.createNew ("uk.co.martinpearman.b4a.webviewsettings.WebViewSettings");Debug.locals.put("wvsetttings", _wvsetttings);
 BA.debugLineNum = 67;BA.debugLine="wvsetttings.setAllowFileAccess(WebView1,True)";
Debug.ShouldStop(4);
_wvsetttings.runVoidMethod ("setAllowFileAccess",(Object)((reagbook_activity.mostCurrent._webview1.getObject())),(Object)(reagbook_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 68;BA.debugLine="wvsetttings.setAllowFileAccess(WebView_player,Tru";
Debug.ShouldStop(8);
_wvsetttings.runVoidMethod ("setAllowFileAccess",(Object)((reagbook_activity.mostCurrent._webview_player.getObject())),(Object)(reagbook_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 71;BA.debugLine="If(File.Exists(File.DirInternal,sound_addres))The";
Debug.ShouldStop(64);
if ((reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(reagbook_activity.mostCurrent._sound_addres))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 72;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
Debug.ShouldStop(128);
_str_html_pleyer = RemoteObject.concat(RemoteObject.createImmutable("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='"),reagbook_activity.mostCurrent._xui.runMethod(true,"FileUri",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(reagbook_activity.mostCurrent._sound_addres)),RemoteObject.createImmutable("' type='audio/mpeg' ></audio></html>"));Debug.locals.put("str_html_pleyer", _str_html_pleyer);Debug.locals.put("str_html_pleyer", _str_html_pleyer);
 }else {
 BA.debugLineNum = 77;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
Debug.ShouldStop(4096);
_str_html_pleyer = RemoteObject.concat(RemoteObject.createImmutable("<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='https://m2ebadi.whi.ir/shokrgozari/sounds/"),reagbook_activity.mostCurrent._sound_addres,RemoteObject.createImmutable("' type='audio/mpeg' ></audio></html>"));Debug.locals.put("str_html_pleyer", _str_html_pleyer);Debug.locals.put("str_html_pleyer", _str_html_pleyer);
 };
 BA.debugLineNum = 83;BA.debugLine="WebView_player.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(262144);
reagbook_activity.mostCurrent._webview_player.runVoidMethod ("setColor",reagbook_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 84;BA.debugLine="WebView_player.LoadHtml(str_html_pleyer)";
Debug.ShouldStop(524288);
reagbook_activity.mostCurrent._webview_player.runVoidMethod ("LoadHtml",(Object)(_str_html_pleyer));
 BA.debugLineNum = 87;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(4194304);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("setColor",reagbook_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 95;BA.debugLine="If(File.Exists(File.DirInternal,\"darkmod.txt\"))Th";
Debug.ShouldStop(1073741824);
if ((reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("darkmod.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 96;BA.debugLine="dark_mod = File.ReadString(File.DirInternal,\"dar";
Debug.ShouldStop(-2147483648);
reagbook_activity._dark_mod = BA.numberCast(int.class, reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("darkmod.txt"))));
 BA.debugLineNum = 97;BA.debugLine="If(dark_mod=1)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",reagbook_activity._dark_mod,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 99;BA.debugLine="Activity.Color=Colors.Black";
Debug.ShouldStop(4);
reagbook_activity.mostCurrent._activity.runVoidMethod ("setColor",reagbook_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 100;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
Debug.ShouldStop(8);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(reagbook_activity.mostCurrent._str_html_dark));
 BA.debugLineNum = 101;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
Debug.ShouldStop(16);
reagbook_activity.mostCurrent._lbl_dark_view.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf185))))));
 }else {
 BA.debugLineNum = 104;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
Debug.ShouldStop(128);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(reagbook_activity.mostCurrent._str_html_lite));
 };
 }else {
 BA.debugLineNum = 110;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
Debug.ShouldStop(8192);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(reagbook_activity.mostCurrent._str_html_lite));
 };
 BA.debugLineNum = 123;BA.debugLine="File.WriteString(File.DirInternal,\"temp_read.txt\"";
Debug.ShouldStop(67108864);
reagbook_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(reagbook_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_read.txt")),(Object)(BA.NumberToString(reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ )));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_KeyPress (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,143);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 143;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, reagbook_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 145;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(65536);
_lbl_back_click();
 BA.debugLineNum = 146;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return reagbook_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 148;BA.debugLine="Return False";
Debug.ShouldStop(524288);
if (true) return reagbook_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Pause (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,131);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 131;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 133;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,127);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","activity_resume");}
 BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_title As Label";
reagbook_activity.mostCurrent._lbl_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private xui As XUI";
reagbook_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 18;BA.debugLine="Dim pic_addres As String=\"\"";
reagbook_activity.mostCurrent._pic_addres = BA.ObjectToString("");
 //BA.debugLineNum = 19;BA.debugLine="Dim sound_addres As String=\"\"";
reagbook_activity.mostCurrent._sound_addres = BA.ObjectToString("");
 //BA.debugLineNum = 20;BA.debugLine="Private WebView1 As WebView";
reagbook_activity.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim dark_mod As Int =0";
reagbook_activity._dark_mod = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 23;BA.debugLine="Dim str_html_lite As String";
reagbook_activity.mostCurrent._str_html_lite = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim str_html_dark As String";
reagbook_activity.mostCurrent._str_html_dark = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_dark_view As Label";
reagbook_activity.mostCurrent._lbl_dark_view = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private WebView_player As WebView";
reagbook_activity.mostCurrent._webview_player = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_fav As Label";
reagbook_activity.mostCurrent._lbl_fav = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,136);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","lbl_back_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="WebView1.LoadHtml(\"\")";
Debug.ShouldStop(256);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 138;BA.debugLine="WebView_player.LoadHtml(\"\")";
Debug.ShouldStop(512);
reagbook_activity.mostCurrent._webview_player.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 139;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
reagbook_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_dark_view_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_dark_view_Click (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,155);
if (RapidSub.canDelegate("lbl_dark_view_click")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","lbl_dark_view_click");}
 BA.debugLineNum = 155;BA.debugLine="Private Sub lbl_dark_view_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 158;BA.debugLine="If(dark_mod=0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",reagbook_activity._dark_mod,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 159;BA.debugLine="Activity.Color=Colors.Black";
Debug.ShouldStop(1073741824);
reagbook_activity.mostCurrent._activity.runVoidMethod ("setColor",reagbook_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 160;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
Debug.ShouldStop(-2147483648);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(reagbook_activity.mostCurrent._str_html_dark));
 BA.debugLineNum = 162;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
Debug.ShouldStop(2);
reagbook_activity.mostCurrent._lbl_dark_view.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf185))))));
 BA.debugLineNum = 163;BA.debugLine="dark_mod=1";
Debug.ShouldStop(4);
reagbook_activity._dark_mod = BA.numberCast(int.class, 1);
 }else {
 BA.debugLineNum = 166;BA.debugLine="Activity.Color=Colors.White";
Debug.ShouldStop(32);
reagbook_activity.mostCurrent._activity.runVoidMethod ("setColor",reagbook_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 167;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
Debug.ShouldStop(64);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(reagbook_activity.mostCurrent._str_html_lite));
 BA.debugLineNum = 169;BA.debugLine="lbl_dark_view.Text=Chr(0xF186)";
Debug.ShouldStop(256);
reagbook_activity.mostCurrent._lbl_dark_view.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf186))))));
 BA.debugLineNum = 170;BA.debugLine="dark_mod=0";
Debug.ShouldStop(512);
reagbook_activity._dark_mod = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_fav_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_fav_Click (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,202);
if (RapidSub.canDelegate("lbl_fav_click")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","lbl_fav_click");}
RemoteObject _fav_state = RemoteObject.createImmutable(0);
 BA.debugLineNum = 202;BA.debugLine="Private Sub lbl_fav_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 204;BA.debugLine="Dim fav_state As Int = myFunc.get_fav_byId(Main.c";
Debug.ShouldStop(2048);
_fav_state = reagbook_activity.mostCurrent._myfunc.runMethod(true,"_get_fav_byid" /*RemoteObject*/ ,reagbook_activity.mostCurrent.activityBA,(Object)(reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ));Debug.locals.put("fav_state", _fav_state);Debug.locals.put("fav_state", _fav_state);
 BA.debugLineNum = 207;BA.debugLine="If(fav_state=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_fav_state,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 209;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
Debug.ShouldStop(65536);
reagbook_activity.mostCurrent._myfunc.runVoidMethod ("_set_fav_book" /*RemoteObject*/ ,reagbook_activity.mostCurrent.activityBA,(Object)(reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 210;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
Debug.ShouldStop(131072);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf08a))))));
 BA.debugLineNum = 211;BA.debugLine="lbl_fav.TextColor=0xFF686868";
Debug.ShouldStop(262144);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff686868)));
 }else {
 BA.debugLineNum = 213;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
Debug.ShouldStop(1048576);
reagbook_activity.mostCurrent._myfunc.runVoidMethod ("_set_fav_book" /*RemoteObject*/ ,reagbook_activity.mostCurrent.activityBA,(Object)(reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 214;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
Debug.ShouldStop(2097152);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setText",BA.ObjectToCharSequence(reagbook_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf004))))));
 BA.debugLineNum = 215;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
Debug.ShouldStop(4194304);
reagbook_activity.mostCurrent._lbl_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff3838)));
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
public static RemoteObject  _lbl_go_tamrin_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_go_tamrin_Click (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,188);
if (RapidSub.canDelegate("lbl_go_tamrin_click")) { return ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","lbl_go_tamrin_click");}
 BA.debugLineNum = 188;BA.debugLine="Private Sub lbl_go_tamrin_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="If((Main.current_book_content_id-1)=0)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ,RemoteObject.createImmutable(1)}, "-",1, 1)),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 190;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
Debug.ShouldStop(536870912);
reagbook_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("بدون تمرین")),(Object)(reagbook_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 191;BA.debugLine="Else If((Main.current_book_content_id-1)=29)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ,RemoteObject.createImmutable(1)}, "-",1, 1)),BA.numberCast(double.class, 29)))) { 
 BA.debugLineNum = 192;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
Debug.ShouldStop(-2147483648);
reagbook_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("بدون تمرین")),(Object)(reagbook_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 194;BA.debugLine="Main.current_roz_tamrin=Main.current_book_conten";
Debug.ShouldStop(2);
reagbook_activity.mostCurrent._main._current_roz_tamrin /*RemoteObject*/  = RemoteObject.solve(new RemoteObject[] {reagbook_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/ ,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 195;BA.debugLine="WebView1.LoadHtml(\"\")";
Debug.ShouldStop(4);
reagbook_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 196;BA.debugLine="WebView_player.LoadHtml(\"\")";
Debug.ShouldStop(8);
reagbook_activity.mostCurrent._webview_player.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 197;BA.debugLine="StartActivity(tamrin_roz_activity)";
Debug.ShouldStop(16);
reagbook_activity.mostCurrent.__c.runVoidMethod ("StartActivity",reagbook_activity.processBA,(Object)((reagbook_activity.mostCurrent._tamrin_roz_activity.getObject())));
 }}
;
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
public static void  _setter() throws Exception{
try {
		Debug.PushSubsStack("setter (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,175);
if (RapidSub.canDelegate("setter")) { ir.taravatgroup.shokrgozari.reagbook_activity.remoteMe.runUserSub(false, "reagbook_activity","setter"); return;}
ResumableSub_setter rsub = new ResumableSub_setter(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_setter extends BA.ResumableSub {
public ResumableSub_setter(ir.taravatgroup.shokrgozari.reagbook_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.shokrgozari.reagbook_activity parent;
RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("setter (reagbook_activity) ","reagbook_activity",10,reagbook_activity.mostCurrent.activityBA,reagbook_activity.mostCurrent,175);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 177;BA.debugLine="Dim rp As RuntimePermissions";
Debug.ShouldStop(65536);
_rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("rp", _rp);
 BA.debugLineNum = 178;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_S";
Debug.ShouldStop(131072);
_rp.runVoidMethod ("CheckAndRequest",reagbook_activity.processBA,(Object)(_rp.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 179;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", reagbook_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "reagbook_activity", "setter"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 180;BA.debugLine="If Result Then";
Debug.ShouldStop(524288);
if (true) break;

case 1:
//if
this.state = 4;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 186;BA.debugLine="End Sub";
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
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
}