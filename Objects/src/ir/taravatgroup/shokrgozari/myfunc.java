package ir.taravatgroup.shokrgozari;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class myfunc {
private static myfunc mostCurrent = new myfunc();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static int  _get_state_tamrin1_byroz(anywheresoftware.b4a.BA _ba,int _roz) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin1_byroz", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin1_byroz", new Object[] {_ba,_roz}));}
int _res_cod = 0;
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub get_State_tamrin1_byRoz (roz As Int) As Int";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 WHERE roz="+BA.NumberToString(_roz)+" ;")));
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Dim res_cod As Int=0";
_res_cod = (int) (0);
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="res_cod=res_cod+Main.res.Getint(\"state\")";
_res_cod = (int) (_res_cod+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="Return res_cod";
if (true) return _res_cod;
RDebugUtils.currentLine=3145745;
 //BA.debugLineNum = 3145745;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrin1_byroz(anywheresoftware.b4a.BA _ba,int _roz) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_tamrin1_byroz", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_tamrin1_byroz", new Object[] {_ba,_roz}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub get_tamrin1_byRoz (roz As Int) As List";
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 WHERE roz="+BA.NumberToString(_roz)+" ;")));
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("num"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mohebat")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("elat")+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"))));
 }
;
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2949136;
 //BA.debugLineNum = 2949136;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2949140;
 //BA.debugLineNum = 2949140;BA.debugLine="End Sub";
return null;
}
public static String  _connection_sql(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "connection_sql", false))
	 {return ((String) Debug.delegate(null, "connection_sql", new Object[] {_ba}));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub connection_sql";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="If(File.Exists(File.DirInternal,\"db.db\")=False)Th";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="If (Main.sql.IsInitialized=False)Then";
if ((mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Main.sql.Initialize(File.DirInternal,\"db.db\",Tru";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="End Sub";
return "";
}
public static String  _get_all_tamrin1(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_all_tamrin1", false))
	 {return ((String) Debug.delegate(null, "get_all_tamrin1", new Object[] {_ba}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub get_all_tamrin1";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 ")));
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Log(Main.res.Getint(\"id\")&\"	\"&Main.res.Getint(\"r";
anywheresoftware.b4a.keywords.Common.LogImpl("43211270",BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("roz"))+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("num"))+"	"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mohebat")+"	"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("elat")+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
 }
;
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin13_byid(anywheresoftware.b4a.BA _ba,int _id1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_all_tamrin13_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_all_tamrin13_byid", new Object[] {_ba,_id1}));}
anywheresoftware.b4a.objects.collections.List _ls_content = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub get_all_tamrin13_byId(id1 As Int) As List";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin13 WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="ls_content.Add(Main.res.GetString(\"name\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("name")));
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Return ls_content";
if (true) return _ls_content;
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin14(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_all_tamrin14", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_all_tamrin14", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _ls_content = null;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub get_all_tamrin14 As List";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin14 ")));
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="Return ls_content";
if (true) return _ls_content;
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin16(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_all_tamrin16", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_all_tamrin16", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _ls_content = null;
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Sub get_all_tamrin16 As List";
RDebugUtils.currentLine=18677761;
 //BA.debugLineNum = 18677761;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
RDebugUtils.currentLine=18677764;
 //BA.debugLineNum = 18677764;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=18677765;
 //BA.debugLineNum = 18677765;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin16 ")));
RDebugUtils.currentLine=18677767;
 //BA.debugLineNum = 18677767;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=18677768;
 //BA.debugLineNum = 18677768;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
RDebugUtils.currentLine=18677771;
 //BA.debugLineNum = 18677771;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=18677772;
 //BA.debugLineNum = 18677772;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=18677774;
 //BA.debugLineNum = 18677774;BA.debugLine="Return ls_content";
if (true) return _ls_content;
RDebugUtils.currentLine=18677776;
 //BA.debugLineNum = 18677776;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin8(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_all_tamrin8", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_all_tamrin8", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _ls_content = null;
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub get_all_tamrin8 As List";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin8 ")));
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
RDebugUtils.currentLine=3276811;
 //BA.debugLineNum = 3276811;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3276812;
 //BA.debugLineNum = 3276812;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3276814;
 //BA.debugLineNum = 3276814;BA.debugLine="Return ls_content";
if (true) return _ls_content;
RDebugUtils.currentLine=3276816;
 //BA.debugLineNum = 3276816;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_book_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_book_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_book_byid", new Object[] {_ba,_id}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub get_book_byId (id As Int) As List";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1 WHERE id="+BA.NumberToString(_id)+" ;")));
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
_list_result.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("content"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("pic"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound"),BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")}));
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2818062;
 //BA.debugLineNum = 2818062;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2818064;
 //BA.debugLineNum = 2818064;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2818066;
 //BA.debugLineNum = 2818066;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_download_list(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_download_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_download_list", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub get_download_list As List";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("detile_down")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound")));
 }
;
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2293783;
 //BA.debugLineNum = 2293783;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2293785;
 //BA.debugLineNum = 2293785;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2293787;
 //BA.debugLineNum = 2293787;BA.debugLine="End Sub";
return null;
}
public static int  _get_fav_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_fav_byid", false))
	 {return ((Integer) Debug.delegate(null, "get_fav_byid", new Object[] {_ba,_id}));}
int _fav_s = 0;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub get_fav_byId(id As Int) As Int";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1 WHERE id="+BA.NumberToString(_id)+" ;")));
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Dim fav_s As Int =Main.res.Getint(\"state\")";
_fav_s = mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="Return  fav_s";
if (true) return _fav_s;
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _get_fehrest(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_fehrest", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_fehrest", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub get_fehrest As List";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("pic")));
 }
;
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2228247;
 //BA.debugLineNum = 2228247;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2228249;
 //BA.debugLineNum = 2228249;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2228251;
 //BA.debugLineNum = 2228251;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_removeall_list(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_removeall_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_removeall_list", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub get_removeAll_list As List";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="list_result.Add(Main.res.GetString(\"sound\"))";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound")));
 }
;
RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2359309;
 //BA.debugLineNum = 2359309;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2359311;
 //BA.debugLineNum = 2359311;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2359313;
 //BA.debugLineNum = 2359313;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_roz_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_roz_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_roz_byid", new Object[] {_ba,_id}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub get_roz_byId (id As Int) As List";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin_roz WHERE id="+BA.NumberToString(_id)+" ;")));
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
_list_result.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("content"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tamrinat"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")}));
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2883602;
 //BA.debugLineNum = 2883602;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_rozha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_rozha", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_rozha", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub get_rozha As List";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM rozha;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM rozha;")));
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="list_result.Add(Main.res.GetString(\"name\")&\"@\"&M";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("name")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")));
 }
;
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="End Sub";
return null;
}
public static int  _get_state(anywheresoftware.b4a.BA _ba,int _roz1,int _tamrin1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state", false))
	 {return ((Integer) Debug.delegate(null, "get_state", new Object[] {_ba,_roz1,_tamrin1}));}
int _result_state = 0;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub get_state(roz1 As Int , tamrin1 As Int) As Int";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM states";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM states  WHERE roz="+BA.NumberToString(_roz1)+" AND tamrin="+BA.NumberToString(_tamrin1)+" ;")));
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Dim result_state As Int =0";
_result_state = (int) (0);
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="If(Main.res.RowCount>0)Then";
if ((mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="result_state=Main.res.GetInt(\"state\")";
_result_state = mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 };
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2555919;
 //BA.debugLineNum = 2555919;BA.debugLine="Return  result_state";
if (true) return _result_state;
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin13(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin13", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin13", new Object[] {_ba}));}
int _res_state = 0;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub get_state_tamrin13 As Int";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin13 ")));
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="res_state=res_state+Main.res.GetString(\"state\")";
_res_state = (int) (_res_state+(double)(Double.parseDouble(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
 }
;
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="Return res_state";
if (true) return _res_state;
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin14(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin14", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin14", new Object[] {_ba}));}
int _res_state = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub get_state_tamrin14 As Int";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin14 ")));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="Return res_state";
if (true) return _res_state;
RDebugUtils.currentLine=3604495;
 //BA.debugLineNum = 3604495;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin16(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin16", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin16", new Object[] {_ba}));}
int _res_state = 0;
RDebugUtils.currentLine=18939904;
 //BA.debugLineNum = 18939904;BA.debugLine="Sub get_state_tamrin16 As Int";
RDebugUtils.currentLine=18939905;
 //BA.debugLineNum = 18939905;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
RDebugUtils.currentLine=18939907;
 //BA.debugLineNum = 18939907;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=18939908;
 //BA.debugLineNum = 18939908;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin16 ")));
RDebugUtils.currentLine=18939910;
 //BA.debugLineNum = 18939910;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=18939911;
 //BA.debugLineNum = 18939911;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
RDebugUtils.currentLine=18939914;
 //BA.debugLineNum = 18939914;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=18939915;
 //BA.debugLineNum = 18939915;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=18939917;
 //BA.debugLineNum = 18939917;BA.debugLine="Return res_state";
if (true) return _res_state;
RDebugUtils.currentLine=18939919;
 //BA.debugLineNum = 18939919;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin19(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin19", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin19", new Object[] {_ba}));}
int _res_state = 0;
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Sub get_state_tamrin19 As Int";
RDebugUtils.currentLine=23592961;
 //BA.debugLineNum = 23592961;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
RDebugUtils.currentLine=23592963;
 //BA.debugLineNum = 23592963;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=23592964;
 //BA.debugLineNum = 23592964;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin19 ")));
RDebugUtils.currentLine=23592966;
 //BA.debugLineNum = 23592966;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=23592967;
 //BA.debugLineNum = 23592967;BA.debugLine="res_state=res_state+1";
_res_state = (int) (_res_state+1);
 }
;
RDebugUtils.currentLine=23592970;
 //BA.debugLineNum = 23592970;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=23592971;
 //BA.debugLineNum = 23592971;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=23592973;
 //BA.debugLineNum = 23592973;BA.debugLine="Return res_state";
if (true) return _res_state;
RDebugUtils.currentLine=23592975;
 //BA.debugLineNum = 23592975;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin8(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrin8", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrin8", new Object[] {_ba}));}
int _res_state = 0;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub get_state_tamrin8 As Int";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin8 ")));
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3407885;
 //BA.debugLineNum = 3407885;BA.debugLine="Return res_state";
if (true) return _res_state;
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_state_tamrinat_saved", false))
	 {return ((Integer) Debug.delegate(null, "get_state_tamrinat_saved", new Object[] {_ba,_roz,_tamrin}));}
int _state1 = 0;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub get_State_tamrinat_saved (roz As Int,tamrin As";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="+BA.NumberToString(_roz)+" AND tamrin="+BA.NumberToString(_tamrin)+" ;")));
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="state1=state1+Main.res.Getint(\"state\")";
_state1 = (int) (_state1+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=4063244;
 //BA.debugLineNum = 4063244;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="Return state1";
if (true) return _state1;
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_tamrinat_saved", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_tamrinat_saved", new Object[] {_ba,_roz,_tamrin}));}
anywheresoftware.b4a.objects.collections.List _list_result = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub get_tamrinat_saved (roz As Int,tamrin As Int)";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="+BA.NumberToString(_roz)+" AND tamrin="+BA.NumberToString(_tamrin)+" ;")));
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="list_result.Add(Main.res.GetString(\"matn\"))";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="Return list_result";
if (true) return _list_result;
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrinname(anywheresoftware.b4a.BA _ba,int _numtamrin) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_tamrinname", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "get_tamrinname", new Object[] {_ba,_numtamrin}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub get_tamrinName(numTamrin As Int) As List";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_name WHERE num_tamrin="+BA.NumberToString(_numtamrin)+" ;")));
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="ls_result.Add(Main.res.GetString(\"title\"))";
_ls_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="ls_result.Add(Main.res.GetString(\"help\"))";
_ls_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("help")));
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="Return  ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="End Sub";
return null;
}
public static String  _removeall_tamrinat(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "removeall_tamrinat", false))
	 {return ((String) Debug.delegate(null, "removeall_tamrinat", new Object[] {_ba}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub removeAll_tamrinat";
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE tamrin1 SET mohebat";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tamrin1 SET mohebat=\"\" , elat=\"\" , state=0 ;");
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="End Sub";
return "";
}
public static String  _set_fav_book(anywheresoftware.b4a.BA _ba,int _idrow,int _fav_state) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_fav_book", false))
	 {return ((String) Debug.delegate(null, "set_fav_book", new Object[] {_ba,_idrow,_fav_state}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub set_fav_book(idRow As Int,fav_state As Int)";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE book1 SET state=\"&f";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE book1 SET state="+BA.NumberToString(_fav_state)+" WHERE id="+BA.NumberToString(_idrow)+" ;");
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="End Sub";
return "";
}
public static String  _setrotation(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _v,int _time,float _angle) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "setrotation", false))
	 {return ((String) Debug.delegate(null, "setrotation", new Object[] {_ba,_v,_time,_angle}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub setRotation(v As B4XView, Time As Int, Angle A";
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="v.SetRotationAnimated(Time,Angle)";
_v.SetRotationAnimated(_time,_angle);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="End Sub";
return "";
}
public static String  _setstate(anywheresoftware.b4a.BA _ba,int _roz1,int _tamrin1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "setstate", false))
	 {return ((String) Debug.delegate(null, "setstate", new Object[] {_ba,_roz1,_tamrin1}));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub setState(roz1 As Int , tamrin1 As Int)";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Main.sql.ExecNonQuery2(\"INSERT INTO states (roz, t";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO states (roz, tamrin , state) VALUES (?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_roz1),(Object)(_tamrin1),(Object)(1)}));
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="End Sub";
return "";
}
public static boolean  _update_tamrin1_elat(anywheresoftware.b4a.BA _ba,int _id,String _elat,int _state) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin1_elat", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin1_elat", new Object[] {_ba,_id,_elat,_state}));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub update_tamrin1_elat(id As Int,elat As String,s";
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET elat=?";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin1 SET elat=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_elat),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin1_mohebat(anywheresoftware.b4a.BA _ba,int _id,String _mohebat,int _state) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin1_mohebat", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin1_mohebat", new Object[] {_ba,_id,_mohebat,_state}));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub update_tamrin1_mohebat(id As Int,mohebat As St";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="If(mohebat=\"\")Then";
if (((_mohebat).equals(""))) { 
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="state=0";
_state = (int) (0);
 };
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET moheba";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin1 SET mohebat=? , state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_mohebat),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3014667;
 //BA.debugLineNum = 3014667;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin13(anywheresoftware.b4a.BA _ba,int _id1,String _name1,String _matn1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin13", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin13", new Object[] {_ba,_id1,_name1,_matn1}));}
int _state1 = 0;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub update_tamrin13 (id1 As Int,name1 As String,m";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="If(matn1=\"\")Then";
if (((_matn1).equals(""))) { 
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="If(name1=Null)Then";
if ((_name1== null)) { 
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="name1=\"\"";
_name1 = "";
 };
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="If(matn1=Null)Then";
if ((_matn1== null)) { 
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="matn1=\"\"";
_matn1 = "";
 };
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin13 SET name=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin13 SET name=? , matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_name1),(Object)(_matn1),(Object)(_state1),(Object)(_id1)}));
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3735568;
 //BA.debugLineNum = 3735568;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin14(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin14", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin14", new Object[] {_ba,_id,_matn}));}
int _state1 = 0;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub update_tamrin14 (id As Int,matn As String) As";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin14 SET matn=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin14 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin16(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin16", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin16", new Object[] {_ba,_id,_matn}));}
int _state1 = 0;
RDebugUtils.currentLine=18808832;
 //BA.debugLineNum = 18808832;BA.debugLine="Sub update_tamrin16 (id As Int,matn As String) As";
RDebugUtils.currentLine=18808833;
 //BA.debugLineNum = 18808833;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
RDebugUtils.currentLine=18808834;
 //BA.debugLineNum = 18808834;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
RDebugUtils.currentLine=18808835;
 //BA.debugLineNum = 18808835;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
RDebugUtils.currentLine=18808838;
 //BA.debugLineNum = 18808838;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=18808839;
 //BA.debugLineNum = 18808839;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin16 SET matn=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin16 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
RDebugUtils.currentLine=18808840;
 //BA.debugLineNum = 18808840;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=18808842;
 //BA.debugLineNum = 18808842;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=18808843;
 //BA.debugLineNum = 18808843;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin8(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrin8", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrin8", new Object[] {_ba,_id,_matn}));}
int _state1 = 0;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub update_tamrin8 (id As Int,matn As String) As";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin8 SET matn=?";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin8 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3342346;
 //BA.debugLineNum = 3342346;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin,int _num,String _matn,int _state) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "update_tamrinat_saved", false))
	 {return ((Boolean) Debug.delegate(null, "update_tamrinat_saved", new Object[] {_ba,_roz,_tamrin,_num,_matn,_state}));}
int _state1 = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub update_tamrinat_saved( roz As Int,tamrin As In";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="If(matn<>\"\")Then";
if (((_matn).equals("") == false)) { 
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="state1=1";
_state1 = (int) (1);
 };
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="connection_sql";
_connection_sql(_ba);
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrinat_saved SET";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrinat_saved SET matn=?, state=? WHERE roz=? AND tamrin=? AND num=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_roz),(Object)(_tamrin),(Object)(_num)}));
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="End Sub";
return false;
}
}