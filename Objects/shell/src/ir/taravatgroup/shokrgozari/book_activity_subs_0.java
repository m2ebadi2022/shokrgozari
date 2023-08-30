package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class book_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"book_layout\")";
Debug.ShouldStop(32);
book_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("book_layout")),book_activity.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="tim_scroll2.Initialize(\"tim_scroll2\",300)";
Debug.ShouldStop(128);
book_activity._tim_scroll2.runVoidMethod ("Initialize",book_activity.processBA,(Object)(BA.ObjectToString("tim_scroll2")),(Object)(BA.numberCast(long.class, 300)));
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,61);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, book_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 63;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(1073741824);
_lbl_back_click();
 BA.debugLineNum = 64;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return book_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 66;BA.debugLine="Return False";
Debug.ShouldStop(2);
if (true) return book_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="fill_list";
Debug.ShouldStop(16384);
_fill_list();
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
public static RemoteObject  _fill_list() throws Exception{
try {
		Debug.PushSubsStack("fill_list (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,83);
if (RapidSub.canDelegate("fill_list")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","fill_list");}
RemoteObject _list_fehrest = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _strfunc = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
int _i = 0;
RemoteObject _list_row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _temp_red = RemoteObject.createImmutable(0);
RemoteObject _id_temp_read = RemoteObject.createImmutable(0);
 BA.debugLineNum = 83;BA.debugLine="Sub fill_list";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="CustomListView1.Clear";
Debug.ShouldStop(1048576);
book_activity.mostCurrent._customlistview1.runVoidMethod ("_clear");
 BA.debugLineNum = 87;BA.debugLine="Dim list_fehrest As List";
Debug.ShouldStop(4194304);
_list_fehrest = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_fehrest", _list_fehrest);
 BA.debugLineNum = 88;BA.debugLine="list_fehrest.Initialize";
Debug.ShouldStop(8388608);
_list_fehrest.runVoidMethod ("Initialize");
 BA.debugLineNum = 89;BA.debugLine="list_fehrest=myFunc.get_fehrest";
Debug.ShouldStop(16777216);
_list_fehrest = book_activity.mostCurrent._myfunc.runMethod(false,"_get_fehrest" /*RemoteObject*/ ,book_activity.mostCurrent.activityBA);Debug.locals.put("list_fehrest", _list_fehrest);
 BA.debugLineNum = 91;BA.debugLine="Dim strFunc As StringFunctions";
Debug.ShouldStop(67108864);
_strfunc = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strFunc", _strfunc);
 BA.debugLineNum = 92;BA.debugLine="strFunc.Initialize";
Debug.ShouldStop(134217728);
_strfunc.runVoidMethod ("_initialize",book_activity.processBA);
 BA.debugLineNum = 95;BA.debugLine="For i=0 To list_fehrest.Size-1";
Debug.ShouldStop(1073741824);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_list_fehrest.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 97;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(1);
book_activity.mostCurrent._p = book_activity.mostCurrent._xui.runMethod(false,"CreatePanel",book_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 99;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
Debug.ShouldStop(4);
book_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(book_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),book_activity.mostCurrent.activityBA)),(Object)(book_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))));
 BA.debugLineNum = 100;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
Debug.ShouldStop(8);
book_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_rozha_tamrin")),book_activity.mostCurrent.activityBA);
 BA.debugLineNum = 103;BA.debugLine="CustomListView1.Add(p,i)";
Debug.ShouldStop(64);
book_activity.mostCurrent._customlistview1.runVoidMethod ("_add",(Object)(book_activity.mostCurrent._p),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 106;BA.debugLine="Dim list_row As List";
Debug.ShouldStop(512);
_list_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_row", _list_row);
 BA.debugLineNum = 107;BA.debugLine="list_row.Initialize";
Debug.ShouldStop(1024);
_list_row.runVoidMethod ("Initialize");
 BA.debugLineNum = 108;BA.debugLine="list_row=strFunc.Split(list_fehrest.Get(i) , \"@\"";
Debug.ShouldStop(2048);
_list_row = _strfunc.runMethod(false,"_vvvvvv5",(Object)(BA.ObjectToString(_list_fehrest.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(RemoteObject.createImmutable("@")));Debug.locals.put("list_row", _list_row);
 BA.debugLineNum = 112;BA.debugLine="lbl_roz.Text=list_row.Get(1)";
Debug.ShouldStop(32768);
book_activity.mostCurrent._lbl_roz.runMethod(true,"setText",BA.ObjectToCharSequence(_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 114;BA.debugLine="pan_roz.Tag=list_row.Get(0)";
Debug.ShouldStop(131072);
book_activity.mostCurrent._pan_roz.runMethod(false,"setTag",_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 118;BA.debugLine="pan_pic.Visible=True";
Debug.ShouldStop(2097152);
book_activity.mostCurrent._pan_pic.runMethod(true,"setVisible",book_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 120;BA.debugLine="pan_pic.SetBackgroundImage(LoadBitmap(File.DirAs";
Debug.ShouldStop(8388608);
book_activity.mostCurrent._pan_pic.runVoidMethod ("SetBackgroundImageNew",(Object)((book_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(book_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString(_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))))).getObject())));
 BA.debugLineNum = 123;BA.debugLine="lbl_icon_fav.Visible=True";
Debug.ShouldStop(67108864);
book_activity.mostCurrent._lbl_icon_fav.runMethod(true,"setVisible",book_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 124;BA.debugLine="lbl_icon_fav.Tag=list_row.Get(0)";
Debug.ShouldStop(134217728);
book_activity.mostCurrent._lbl_icon_fav.runMethod(false,"setTag",_list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 125;BA.debugLine="If(list_row.Get(2).As(Int)=1)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",(BA.numberCast(int.class, _list_row.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 126;BA.debugLine="lbl_icon_fav.Text=Chr(0xF004)";
Debug.ShouldStop(536870912);
book_activity.mostCurrent._lbl_icon_fav.runMethod(true,"setText",BA.ObjectToCharSequence(book_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf004))))));
 BA.debugLineNum = 127;BA.debugLine="lbl_icon_fav.TextColor=0xFFFF3838";
Debug.ShouldStop(1073741824);
book_activity.mostCurrent._lbl_icon_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff3838)));
 }else {
 BA.debugLineNum = 129;BA.debugLine="lbl_icon_fav.Text=Chr(0xF08A)";
Debug.ShouldStop(1);
book_activity.mostCurrent._lbl_icon_fav.runMethod(true,"setText",BA.ObjectToCharSequence(book_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf08a))))));
 BA.debugLineNum = 130;BA.debugLine="lbl_icon_fav.TextColor=0xFF686868";
Debug.ShouldStop(2);
book_activity.mostCurrent._lbl_icon_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff686868)));
 };
 BA.debugLineNum = 136;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_read.txt\")";
Debug.ShouldStop(128);
if ((book_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(book_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_read.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 137;BA.debugLine="Dim temp_red As Int=File.ReadString(File.DirIn";
Debug.ShouldStop(256);
_temp_red = BA.numberCast(int.class, book_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(book_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_read.txt"))));Debug.locals.put("temp_red", _temp_red);Debug.locals.put("temp_red", _temp_red);
 BA.debugLineNum = 138;BA.debugLine="Dim id_temp_read As Int=pan_roz.Tag";
Debug.ShouldStop(512);
_id_temp_read = BA.numberCast(int.class, book_activity.mostCurrent._pan_roz.runMethod(false,"getTag"));Debug.locals.put("id_temp_read", _id_temp_read);Debug.locals.put("id_temp_read", _id_temp_read);
 BA.debugLineNum = 140;BA.debugLine="If((id_temp_read)=temp_red)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",(_id_temp_read),BA.numberCast(double.class, _temp_red)))) { 
 BA.debugLineNum = 141;BA.debugLine="lbl_icon_roz.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(4096);
book_activity.mostCurrent._lbl_icon_roz.runMethod(false,"setTypeface",book_activity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 142;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
Debug.ShouldStop(8192);
book_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0fa900)));
 BA.debugLineNum = 143;BA.debugLine="lbl_icon_roz.Text=Chr(0xE866)";
Debug.ShouldStop(16384);
book_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setText",BA.ObjectToCharSequence(book_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xe866))))));
 BA.debugLineNum = 145;BA.debugLine="lbl_icon_roz.Visible=True";
Debug.ShouldStop(65536);
book_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setVisible",book_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 146;BA.debugLine="pos_scroll=i";
Debug.ShouldStop(131072);
book_activity._pos_scroll = BA.numberCast(int.class, _i);
 }else {
 BA.debugLineNum = 148;BA.debugLine="lbl_icon_roz.Visible=False";
Debug.ShouldStop(524288);
book_activity.mostCurrent._lbl_icon_roz.runMethod(true,"setVisible",book_activity.mostCurrent.__c.getField(true,"False"));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 156;BA.debugLine="If (isfitest=True)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",book_activity._isfitest,book_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 157;BA.debugLine="tim_scroll2.Enabled=True";
Debug.ShouldStop(268435456);
book_activity._tim_scroll2.runMethod(true,"setEnabled",book_activity.mostCurrent.__c.getField(true,"True"));
 };
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
book_activity.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
book_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private CustomListView1 As CustomListView";
book_activity.mostCurrent._customlistview1 = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_roz As Label";
book_activity.mostCurrent._lbl_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_icon_roz As Label";
book_activity.mostCurrent._lbl_icon_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pan_roz As Panel";
book_activity.mostCurrent._pan_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pan_pic As Panel";
book_activity.mostCurrent._pan_pic = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_icon_fav As Label";
book_activity.mostCurrent._lbl_icon_fav = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim pos_scroll As Int=0";
book_activity._pos_scroll = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 29;BA.debugLine="Dim isfitest As Boolean=True";
book_activity._isfitest = book_activity.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,55);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","lbl_back_click");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8388608);
book_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_icon_fav_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_icon_fav_Click (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,165);
if (RapidSub.canDelegate("lbl_icon_fav_click")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","lbl_icon_fav_click");}
RemoteObject _this_roz_fav = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _fav_state = RemoteObject.createImmutable(0);
 BA.debugLineNum = 165;BA.debugLine="Private Sub lbl_icon_fav_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Dim this_roz_fav As Label=Sender";
Debug.ShouldStop(32);
_this_roz_fav = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_this_roz_fav = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), book_activity.mostCurrent.__c.runMethod(false,"Sender",book_activity.mostCurrent.activityBA));Debug.locals.put("this_roz_fav", _this_roz_fav);Debug.locals.put("this_roz_fav", _this_roz_fav);
 BA.debugLineNum = 170;BA.debugLine="Dim fav_state As Int = myFunc.get_fav_byId(this_r";
Debug.ShouldStop(512);
_fav_state = book_activity.mostCurrent._myfunc.runMethod(true,"_get_fav_byid" /*RemoteObject*/ ,book_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_roz_fav.runMethod(false,"getTag"))));Debug.locals.put("fav_state", _fav_state);Debug.locals.put("fav_state", _fav_state);
 BA.debugLineNum = 173;BA.debugLine="If(fav_state=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_fav_state,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 175;BA.debugLine="myFunc.set_fav_book(this_roz_fav.Tag,0)";
Debug.ShouldStop(16384);
book_activity.mostCurrent._myfunc.runVoidMethod ("_set_fav_book" /*RemoteObject*/ ,book_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_roz_fav.runMethod(false,"getTag"))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 176;BA.debugLine="this_roz_fav.Text=Chr(0xF08A)";
Debug.ShouldStop(32768);
_this_roz_fav.runMethod(true,"setText",BA.ObjectToCharSequence(book_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf08a))))));
 BA.debugLineNum = 177;BA.debugLine="this_roz_fav.TextColor=0xFF686868";
Debug.ShouldStop(65536);
_this_roz_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff686868)));
 }else {
 BA.debugLineNum = 179;BA.debugLine="myFunc.set_fav_book(this_roz_fav.Tag,1)";
Debug.ShouldStop(262144);
book_activity.mostCurrent._myfunc.runVoidMethod ("_set_fav_book" /*RemoteObject*/ ,book_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _this_roz_fav.runMethod(false,"getTag"))),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 180;BA.debugLine="this_roz_fav.Text=Chr(0xF004)";
Debug.ShouldStop(524288);
_this_roz_fav.runMethod(true,"setText",BA.ObjectToCharSequence(book_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf004))))));
 BA.debugLineNum = 181;BA.debugLine="this_roz_fav.TextColor=0xFFFF3838";
Debug.ShouldStop(1048576);
_this_roz_fav.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff3838)));
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
public static RemoteObject  _pan_roz_click() throws Exception{
try {
		Debug.PushSubsStack("pan_roz_Click (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,71);
if (RapidSub.canDelegate("pan_roz_click")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","pan_roz_click");}
RemoteObject _this_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 71;BA.debugLine="Private Sub pan_roz_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="Dim this_roz As Panel=Sender";
Debug.ShouldStop(128);
_this_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_this_roz = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), book_activity.mostCurrent.__c.runMethod(false,"Sender",book_activity.mostCurrent.activityBA));Debug.locals.put("this_roz", _this_roz);Debug.locals.put("this_roz", _this_roz);
 BA.debugLineNum = 74;BA.debugLine="Main.current_book_content_id=this_roz.Tag";
Debug.ShouldStop(512);
book_activity.mostCurrent._main._current_book_content_id /*RemoteObject*/  = BA.numberCast(int.class, _this_roz.runMethod(false,"getTag"));
 BA.debugLineNum = 75;BA.debugLine="isfitest=False";
Debug.ShouldStop(1024);
book_activity._isfitest = book_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 76;BA.debugLine="StartActivity(reagBook_activity)";
Debug.ShouldStop(2048);
book_activity.mostCurrent.__c.runVoidMethod ("StartActivity",book_activity.processBA,(Object)((book_activity.mostCurrent._reagbook_activity.getObject())));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim tim_scroll2 As Timer";
book_activity._tim_scroll2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tim_scroll2_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_scroll2_Tick (book_activity) ","book_activity",3,book_activity.mostCurrent.activityBA,book_activity.mostCurrent,192);
if (RapidSub.canDelegate("tim_scroll2_tick")) { return ir.taravatgroup.shokrgozari.book_activity.remoteMe.runUserSub(false, "book_activity","tim_scroll2_tick");}
 BA.debugLineNum = 192;BA.debugLine="Sub tim_scroll2_Tick";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="CustomListView1.ScrollToItem(pos_scroll)";
Debug.ShouldStop(1);
book_activity.mostCurrent._customlistview1.runVoidMethod ("_scrolltoitem",(Object)(book_activity._pos_scroll));
 BA.debugLineNum = 194;BA.debugLine="tim_scroll2.Enabled=False";
Debug.ShouldStop(2);
book_activity._tim_scroll2.runMethod(true,"setEnabled",book_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}