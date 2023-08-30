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
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin22_activity _tamrin22_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.tamrin27_activity _tamrin27_activity = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static String  _connection_sql(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub connection_sql";
 //BA.debugLineNum = 11;BA.debugLine="If(File.Exists(File.DirInternal,\"db.db\")=False)Th";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 12;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
 //BA.debugLineNum = 14;BA.debugLine="If (Main.sql.IsInitialized=False)Then";
if ((mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 15;BA.debugLine="Main.sql.Initialize(File.DirInternal,\"db.db\",Tru";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _get_all_tamrin1(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Sub get_all_tamrin1";
 //BA.debugLineNum = 334;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 335;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 ")));
 //BA.debugLineNum = 337;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 338;BA.debugLine="Log(Main.res.Getint(\"id\")&\"	\"&Main.res.Getint(\"r";
anywheresoftware.b4a.keywords.Common.LogImpl("03211270",BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("roz"))+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("num"))+"	"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mohebat")+"	"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("elat")+"	"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
 }
;
 //BA.debugLineNum = 342;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 343;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin13_byid(anywheresoftware.b4a.BA _ba,int _id1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 458;BA.debugLine="Sub get_all_tamrin13_byId(id1 As Int) As List";
 //BA.debugLineNum = 459;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 460;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 462;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 463;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin13 WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 464;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 466;BA.debugLine="ls_content.Add(Main.res.GetString(\"name\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("name")));
 //BA.debugLineNum = 467;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 //BA.debugLineNum = 470;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 471;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 473;BA.debugLine="Return ls_content";
if (true) return _ls_content;
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin14(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 398;BA.debugLine="Sub get_all_tamrin14 As List";
 //BA.debugLineNum = 399;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 400;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 402;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 403;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin14 ")));
 //BA.debugLineNum = 405;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 406;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
 //BA.debugLineNum = 409;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 410;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 412;BA.debugLine="Return ls_content";
if (true) return _ls_content;
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin16(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 516;BA.debugLine="Sub get_all_tamrin16 As List";
 //BA.debugLineNum = 517;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 518;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 520;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 521;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin16 ")));
 //BA.debugLineNum = 523;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 524;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
 //BA.debugLineNum = 527;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 528;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 530;BA.debugLine="Return ls_content";
if (true) return _ls_content;
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin27(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 646;BA.debugLine="Sub get_all_tamrin27 As List";
 //BA.debugLineNum = 647;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 648;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 650;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 651;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin27 ")));
 //BA.debugLineNum = 653;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 654;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
 //BA.debugLineNum = 657;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 658;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 660;BA.debugLine="Return ls_content";
if (true) return _ls_content;
 //BA.debugLineNum = 662;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_all_tamrin8(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 348;BA.debugLine="Sub get_all_tamrin8 As List";
 //BA.debugLineNum = 349;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 350;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 352;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 353;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin8 ")));
 //BA.debugLineNum = 355;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 356;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
_ls_content.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
 //BA.debugLineNum = 359;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 360;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 362;BA.debugLine="Return ls_content";
if (true) return _ls_content;
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_book_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 210;BA.debugLine="Sub get_book_byId (id As Int) As List";
 //BA.debugLineNum = 212;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 213;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1 WHERE id="+BA.NumberToString(_id)+" ;")));
 //BA.debugLineNum = 214;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 216;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 217;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 220;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
_list_result.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("content"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("pic"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound"),BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")}));
 //BA.debugLineNum = 223;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 224;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 226;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_download_list(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 75;BA.debugLine="Sub get_download_list As List";
 //BA.debugLineNum = 77;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 78;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
 //BA.debugLineNum = 80;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 81;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 83;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 91;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("detile_down")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound")));
 }
;
 //BA.debugLineNum = 97;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 98;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 100;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return null;
}
public static int  _get_fav_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
int _fav_s = 0;
 //BA.debugLineNum = 179;BA.debugLine="Sub get_fav_byId(id As Int) As Int";
 //BA.debugLineNum = 180;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 181;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1 WHERE id="+BA.NumberToString(_id)+" ;")));
 //BA.debugLineNum = 182;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 183;BA.debugLine="Dim fav_s As Int =Main.res.Getint(\"state\")";
_fav_s = mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 //BA.debugLineNum = 185;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 186;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 188;BA.debugLine="Return  fav_s";
if (true) return _fav_s;
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _get_fehrest(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 45;BA.debugLine="Sub get_fehrest As List";
 //BA.debugLineNum = 47;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 48;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
 //BA.debugLineNum = 50;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 51;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 53;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 61;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title_down")+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("pic")));
 }
;
 //BA.debugLineNum = 67;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 68;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 70;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_removeall_list(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 105;BA.debugLine="Sub get_removeAll_list As List";
 //BA.debugLineNum = 107;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 108;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM book1;")));
 //BA.debugLineNum = 110;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 111;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 113;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 114;BA.debugLine="list_result.Add(Main.res.GetString(\"sound\"))";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("sound")));
 }
;
 //BA.debugLineNum = 117;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 118;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 120;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_roz_byid(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 240;BA.debugLine="Sub get_roz_byId (id As Int) As List";
 //BA.debugLineNum = 242;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 243;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin_roz WHERE id="+BA.NumberToString(_id)+" ;")));
 //BA.debugLineNum = 244;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 246;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 247;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 250;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
_list_result.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("content"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tamrinat"),mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")}));
 //BA.debugLineNum = 253;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 254;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 256;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_rozha(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 21;BA.debugLine="Sub get_rozha As List";
 //BA.debugLineNum = 23;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 24;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM rozha;";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM rozha;")));
 //BA.debugLineNum = 26;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 27;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 29;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 31;BA.debugLine="list_result.Add(Main.res.GetString(\"name\")&\"@\"&M";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("name")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")));
 }
;
 //BA.debugLineNum = 37;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 38;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 40;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return null;
}
public static int  _get_state(anywheresoftware.b4a.BA _ba,int _roz1,int _tamrin1) throws Exception{
int _result_state = 0;
 //BA.debugLineNum = 143;BA.debugLine="Sub get_state(roz1 As Int , tamrin1 As Int) As Int";
 //BA.debugLineNum = 145;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 146;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM states";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM states  WHERE roz="+BA.NumberToString(_roz1)+" AND tamrin="+BA.NumberToString(_tamrin1)+" ;")));
 //BA.debugLineNum = 148;BA.debugLine="Dim result_state As Int =0";
_result_state = (int) (0);
 //BA.debugLineNum = 149;BA.debugLine="If(Main.res.RowCount>0)Then";
if ((mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
 //BA.debugLineNum = 150;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 151;BA.debugLine="result_state=Main.res.GetInt(\"state\")";
_result_state = mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 };
 //BA.debugLineNum = 155;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 156;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 158;BA.debugLine="Return  result_state";
if (true) return _result_state;
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin1_byroz(anywheresoftware.b4a.BA _ba,int _roz) throws Exception{
int _res_cod = 0;
 //BA.debugLineNum = 311;BA.debugLine="Sub get_State_tamrin1_byRoz (roz As Int) As Int";
 //BA.debugLineNum = 313;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 314;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 WHERE roz="+BA.NumberToString(_roz)+" ;")));
 //BA.debugLineNum = 317;BA.debugLine="Dim res_cod As Int=0";
_res_cod = (int) (0);
 //BA.debugLineNum = 319;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 320;BA.debugLine="res_cod=res_cod+Main.res.Getint(\"state\")";
_res_cod = (int) (_res_cod+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 323;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 324;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 326;BA.debugLine="Return res_cod";
if (true) return _res_cod;
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin13(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 496;BA.debugLine="Sub get_state_tamrin13 As Int";
 //BA.debugLineNum = 497;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 499;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 500;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin13 ")));
 //BA.debugLineNum = 502;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 503;BA.debugLine="res_state=res_state+Main.res.GetString(\"state\")";
_res_state = (int) (_res_state+(double)(Double.parseDouble(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
 }
;
 //BA.debugLineNum = 506;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 507;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 509;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin14(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 429;BA.debugLine="Sub get_state_tamrin14 As Int";
 //BA.debugLineNum = 430;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 432;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 433;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin14 ")));
 //BA.debugLineNum = 435;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 436;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 439;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 440;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 442;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin16(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 547;BA.debugLine="Sub get_state_tamrin16 As Int";
 //BA.debugLineNum = 548;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 550;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 551;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin16 ")));
 //BA.debugLineNum = 553;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 554;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 557;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 558;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 560;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 562;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin19(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 566;BA.debugLine="Sub get_state_tamrin19 As Int";
 //BA.debugLineNum = 567;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 569;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 570;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin19 ")));
 //BA.debugLineNum = 572;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 573;BA.debugLine="res_state=res_state+1";
_res_state = (int) (_res_state+1);
 }
;
 //BA.debugLineNum = 576;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 577;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 579;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 581;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin27(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 677;BA.debugLine="Sub get_state_tamrin27 As Int";
 //BA.debugLineNum = 678;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 680;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 681;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin27 ")));
 //BA.debugLineNum = 683;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 684;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 687;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 688;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 690;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 692;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrin8(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_state = 0;
 //BA.debugLineNum = 379;BA.debugLine="Sub get_state_tamrin8 As Int";
 //BA.debugLineNum = 380;BA.debugLine="Dim res_state As Int=0";
_res_state = (int) (0);
 //BA.debugLineNum = 382;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 383;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin8 ")));
 //BA.debugLineNum = 385;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 386;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
_res_state = (int) (_res_state+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 389;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 390;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 392;BA.debugLine="Return res_state";
if (true) return _res_state;
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return 0;
}
public static int  _get_state_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 625;BA.debugLine="Sub get_State_tamrinat_saved (roz As Int,tamrin As";
 //BA.debugLineNum = 627;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 628;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="+BA.NumberToString(_roz)+" AND tamrin="+BA.NumberToString(_tamrin)+" ;")));
 //BA.debugLineNum = 630;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
 //BA.debugLineNum = 632;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 633;BA.debugLine="state1=state1+Main.res.Getint(\"state\")";
_state1 = (int) (_state1+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"));
 }
;
 //BA.debugLineNum = 636;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 637;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 639;BA.debugLine="Return state1";
if (true) return _state1;
 //BA.debugLineNum = 641;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrin1_byroz(anywheresoftware.b4a.BA _ba,int _roz) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 261;BA.debugLine="Sub get_tamrin1_byRoz (roz As Int) As List";
 //BA.debugLineNum = 263;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 264;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin1 WHERE roz="+BA.NumberToString(_roz)+" ;")));
 //BA.debugLineNum = 267;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 268;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 270;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 272;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
_list_result.Add((Object)(BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id"))+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("num"))+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mohebat")+"@"+mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("elat")+"@"+BA.NumberToString(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"))));
 }
;
 //BA.debugLineNum = 276;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 277;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 279;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_result = null;
 //BA.debugLineNum = 607;BA.debugLine="Sub get_tamrinat_saved (roz As Int,tamrin As Int)";
 //BA.debugLineNum = 609;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 610;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="+BA.NumberToString(_roz)+" AND tamrin="+BA.NumberToString(_tamrin)+" ;")));
 //BA.debugLineNum = 612;BA.debugLine="Dim list_result As List";
_list_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 613;BA.debugLine="list_result.Initialize";
_list_result.Initialize();
 //BA.debugLineNum = 614;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 615;BA.debugLine="list_result.Add(Main.res.GetString(\"matn\"))";
_list_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
 }
;
 //BA.debugLineNum = 618;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 619;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 621;BA.debugLine="Return list_result";
if (true) return _list_result;
 //BA.debugLineNum = 623;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _get_tamrinname(anywheresoftware.b4a.BA _ba,int _numtamrin) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_result = null;
 //BA.debugLineNum = 192;BA.debugLine="Sub get_tamrinName(numTamrin As Int) As List";
 //BA.debugLineNum = 193;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 194;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrinat_name WHERE num_tamrin="+BA.NumberToString(_numtamrin)+" ;")));
 //BA.debugLineNum = 195;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 196;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 197;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
 //BA.debugLineNum = 198;BA.debugLine="ls_result.Add(Main.res.GetString(\"title\"))";
_ls_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 199;BA.debugLine="ls_result.Add(Main.res.GetString(\"help\"))";
_ls_result.Add((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("help")));
 //BA.debugLineNum = 203;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 204;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 206;BA.debugLine="Return  ls_result";
if (true) return _ls_result;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _removeall_tamrinat(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub removeAll_tamrinat";
 //BA.debugLineNum = 127;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 129;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE tamrin1 SET mohebat";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tamrin1 SET mohebat=\"\" , elat=\"\" , state=0 ;");
 //BA.debugLineNum = 130;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _set_fav_book(anywheresoftware.b4a.BA _ba,int _idrow,int _fav_state) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Sub set_fav_book(idRow As Int,fav_state As Int)";
 //BA.debugLineNum = 136;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 138;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE book1 SET state=\"&f";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE book1 SET state="+BA.NumberToString(_fav_state)+" WHERE id="+BA.NumberToString(_idrow)+" ;");
 //BA.debugLineNum = 139;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static String  _setrotation(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _v,int _time,float _angle) throws Exception{
 //BA.debugLineNum = 588;BA.debugLine="Sub setRotation(v As B4XView, Time As Int, Angle A";
 //BA.debugLineNum = 591;BA.debugLine="v.SetRotationAnimated(Time,Angle)";
_v.SetRotationAnimated(_time,_angle);
 //BA.debugLineNum = 592;BA.debugLine="End Sub";
return "";
}
public static String  _setstate(anywheresoftware.b4a.BA _ba,int _roz1,int _tamrin1) throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Sub setState(roz1 As Int , tamrin1 As Int)";
 //BA.debugLineNum = 168;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 169;BA.debugLine="Main.sql.ExecNonQuery2(\"INSERT INTO states (roz, t";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO states (roz, tamrin , state) VALUES (?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_roz1),(Object)(_tamrin1),(Object)(1)}));
 //BA.debugLineNum = 170;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static boolean  _update_tamrin1_elat(anywheresoftware.b4a.BA _ba,int _id,String _elat,int _state) throws Exception{
 //BA.debugLineNum = 300;BA.debugLine="Sub update_tamrin1_elat(id As Int,elat As String,s";
 //BA.debugLineNum = 302;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 303;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET elat=?";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin1 SET elat=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_elat),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 304;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 306;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin1_mohebat(anywheresoftware.b4a.BA _ba,int _id,String _mohebat,int _state) throws Exception{
 //BA.debugLineNum = 285;BA.debugLine="Sub update_tamrin1_mohebat(id As Int,mohebat As St";
 //BA.debugLineNum = 287;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 289;BA.debugLine="If(mohebat=\"\")Then";
if (((_mohebat).equals(""))) { 
 //BA.debugLineNum = 290;BA.debugLine="state=0";
_state = (int) (0);
 };
 //BA.debugLineNum = 293;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET moheba";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin1 SET mohebat=? , state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_mohebat),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 294;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 296;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin13(anywheresoftware.b4a.BA _ba,int _id1,String _name1,String _matn1) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 477;BA.debugLine="Sub update_tamrin13 (id1 As Int,name1 As String,m";
 //BA.debugLineNum = 478;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
 //BA.debugLineNum = 479;BA.debugLine="If(matn1=\"\")Then";
if (((_matn1).equals(""))) { 
 //BA.debugLineNum = 480;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
 //BA.debugLineNum = 482;BA.debugLine="If(name1=Null)Then";
if ((_name1== null)) { 
 //BA.debugLineNum = 483;BA.debugLine="name1=\"\"";
_name1 = "";
 };
 //BA.debugLineNum = 485;BA.debugLine="If(matn1=Null)Then";
if ((_matn1== null)) { 
 //BA.debugLineNum = 486;BA.debugLine="matn1=\"\"";
_matn1 = "";
 };
 //BA.debugLineNum = 489;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 490;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin13 SET name=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin13 SET name=? , matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_name1),(Object)(_matn1),(Object)(_state1),(Object)(_id1)}));
 //BA.debugLineNum = 491;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 493;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 494;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin14(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 416;BA.debugLine="Sub update_tamrin14 (id As Int,matn As String) As";
 //BA.debugLineNum = 417;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
 //BA.debugLineNum = 418;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
 //BA.debugLineNum = 419;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
 //BA.debugLineNum = 422;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 423;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin14 SET matn=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin14 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
 //BA.debugLineNum = 424;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 426;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 427;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin16(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 534;BA.debugLine="Sub update_tamrin16 (id As Int,matn As String) As";
 //BA.debugLineNum = 535;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
 //BA.debugLineNum = 536;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
 //BA.debugLineNum = 537;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
 //BA.debugLineNum = 540;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 541;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin16 SET matn=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin16 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
 //BA.debugLineNum = 542;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 544;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin27(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 664;BA.debugLine="Sub update_tamrin27 (id As Int,matn As String) As";
 //BA.debugLineNum = 665;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
 //BA.debugLineNum = 666;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
 //BA.debugLineNum = 667;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
 //BA.debugLineNum = 670;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 671;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin27 SET matn=";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin27 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
 //BA.debugLineNum = 672;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 674;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 675;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrin8(anywheresoftware.b4a.BA _ba,int _id,String _matn) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 366;BA.debugLine="Sub update_tamrin8 (id As Int,matn As String) As";
 //BA.debugLineNum = 367;BA.debugLine="Dim state1 As Int=1";
_state1 = (int) (1);
 //BA.debugLineNum = 368;BA.debugLine="If(matn=\"\")Then";
if (((_matn).equals(""))) { 
 //BA.debugLineNum = 369;BA.debugLine="state1=0";
_state1 = (int) (0);
 };
 //BA.debugLineNum = 372;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 373;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin8 SET matn=?";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin8 SET matn=?, state=? WHERE id=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_id)}));
 //BA.debugLineNum = 374;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 376;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return false;
}
public static boolean  _update_tamrinat_saved(anywheresoftware.b4a.BA _ba,int _roz,int _tamrin,int _num,String _matn,int _state) throws Exception{
int _state1 = 0;
 //BA.debugLineNum = 595;BA.debugLine="Sub update_tamrinat_saved( roz As Int,tamrin As In";
 //BA.debugLineNum = 596;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
 //BA.debugLineNum = 597;BA.debugLine="If(matn<>\"\")Then";
if (((_matn).equals("") == false)) { 
 //BA.debugLineNum = 598;BA.debugLine="state1=1";
_state1 = (int) (1);
 };
 //BA.debugLineNum = 600;BA.debugLine="connection_sql";
_connection_sql(_ba);
 //BA.debugLineNum = 601;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrinat_saved SET";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrinat_saved SET matn=?, state=? WHERE roz=? AND tamrin=? AND num=?;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_matn),(Object)(_state1),(Object)(_roz),(Object)(_tamrin),(Object)(_num)}));
 //BA.debugLineNum = 602;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 604;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 605;BA.debugLine="End Sub";
return false;
}
}
