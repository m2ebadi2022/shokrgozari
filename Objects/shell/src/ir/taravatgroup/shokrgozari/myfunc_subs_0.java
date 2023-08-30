package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class myfunc_subs_0 {


public static RemoteObject  _connection_sql(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("connection_sql (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,10);
if (RapidSub.canDelegate("connection_sql")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","connection_sql", _ba);}
;
 BA.debugLineNum = 10;BA.debugLine="Sub connection_sql";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="If(File.Exists(File.DirInternal,\"db.db\")=False)Th";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db"))),myfunc.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 12;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
Debug.ShouldStop(2048);
myfunc.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("db.db")),(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 };
 BA.debugLineNum = 14;BA.debugLine="If (Main.sql.IsInitialized=False)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(true,"IsInitialized"),myfunc.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 15;BA.debugLine="Main.sql.Initialize(File.DirInternal,\"db.db\",Tru";
Debug.ShouldStop(16384);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Initialize",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(myfunc.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_all_tamrin1(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_all_tamrin1 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,332);
if (RapidSub.canDelegate("get_all_tamrin1")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_all_tamrin1", _ba);}
;
 BA.debugLineNum = 332;BA.debugLine="Sub get_all_tamrin1";
Debug.ShouldStop(2048);
 BA.debugLineNum = 334;BA.debugLine="connection_sql";
Debug.ShouldStop(8192);
_connection_sql(_ba);
 BA.debugLineNum = 335;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(16384);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin1 "))));
 BA.debugLineNum = 337;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(65536);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 338;BA.debugLine="Log(Main.res.Getint(\"id\")&\"	\"&Main.res.Getint(\"r";
Debug.ShouldStop(131072);
myfunc.mostCurrent.__c.runVoidMethod ("LogImpl","43211270",RemoteObject.concat(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))),RemoteObject.createImmutable("	"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("roz"))),RemoteObject.createImmutable("	"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("num"))),RemoteObject.createImmutable("	"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mohebat"))),RemoteObject.createImmutable("	"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("elat"))),RemoteObject.createImmutable("	"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))),0);
 }
;
 BA.debugLineNum = 342;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 343;BA.debugLine="Main.res.Close";
Debug.ShouldStop(4194304);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 346;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_all_tamrin13_byid(RemoteObject _ba,RemoteObject _id1) throws Exception{
try {
		Debug.PushSubsStack("get_all_tamrin13_byId (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,458);
if (RapidSub.canDelegate("get_all_tamrin13_byid")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_all_tamrin13_byid", _ba, _id1);}
RemoteObject _ls_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("id1", _id1);
 BA.debugLineNum = 458;BA.debugLine="Sub get_all_tamrin13_byId(id1 As Int) As List";
Debug.ShouldStop(512);
 BA.debugLineNum = 459;BA.debugLine="Dim ls_content As List";
Debug.ShouldStop(1024);
_ls_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 460;BA.debugLine="ls_content.Initialize";
Debug.ShouldStop(2048);
_ls_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 462;BA.debugLine="connection_sql";
Debug.ShouldStop(8192);
_connection_sql(_ba);
 BA.debugLineNum = 463;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(16384);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrin13 WHERE id="),_id1))));
 BA.debugLineNum = 464;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(32768);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 466;BA.debugLine="ls_content.Add(Main.res.GetString(\"name\"))";
Debug.ShouldStop(131072);
_ls_content.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name"))))));
 BA.debugLineNum = 467;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
Debug.ShouldStop(262144);
_ls_content.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn"))))));
 BA.debugLineNum = 470;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 471;BA.debugLine="Main.res.Close";
Debug.ShouldStop(4194304);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 473;BA.debugLine="Return ls_content";
Debug.ShouldStop(16777216);
if (true) return _ls_content;
 BA.debugLineNum = 475;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_all_tamrin14(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_all_tamrin14 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,398);
if (RapidSub.canDelegate("get_all_tamrin14")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_all_tamrin14", _ba);}
RemoteObject _ls_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 398;BA.debugLine="Sub get_all_tamrin14 As List";
Debug.ShouldStop(8192);
 BA.debugLineNum = 399;BA.debugLine="Dim ls_content As List";
Debug.ShouldStop(16384);
_ls_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 400;BA.debugLine="ls_content.Initialize";
Debug.ShouldStop(32768);
_ls_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 402;BA.debugLine="connection_sql";
Debug.ShouldStop(131072);
_connection_sql(_ba);
 BA.debugLineNum = 403;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(262144);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin14 "))));
 BA.debugLineNum = 405;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(1048576);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 406;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
Debug.ShouldStop(2097152);
_ls_content.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn"))))));
 }
;
 BA.debugLineNum = 409;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16777216);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 410;BA.debugLine="Main.res.Close";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 412;BA.debugLine="Return ls_content";
Debug.ShouldStop(134217728);
if (true) return _ls_content;
 BA.debugLineNum = 414;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_all_tamrin16(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_all_tamrin16 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,516);
if (RapidSub.canDelegate("get_all_tamrin16")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_all_tamrin16", _ba);}
RemoteObject _ls_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 516;BA.debugLine="Sub get_all_tamrin16 As List";
Debug.ShouldStop(8);
 BA.debugLineNum = 517;BA.debugLine="Dim ls_content As List";
Debug.ShouldStop(16);
_ls_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 518;BA.debugLine="ls_content.Initialize";
Debug.ShouldStop(32);
_ls_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 520;BA.debugLine="connection_sql";
Debug.ShouldStop(128);
_connection_sql(_ba);
 BA.debugLineNum = 521;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(256);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin16 "))));
 BA.debugLineNum = 523;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(1024);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 524;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
Debug.ShouldStop(2048);
_ls_content.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn"))))));
 }
;
 BA.debugLineNum = 527;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16384);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 528;BA.debugLine="Main.res.Close";
Debug.ShouldStop(32768);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 530;BA.debugLine="Return ls_content";
Debug.ShouldStop(131072);
if (true) return _ls_content;
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_all_tamrin8(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_all_tamrin8 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,348);
if (RapidSub.canDelegate("get_all_tamrin8")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_all_tamrin8", _ba);}
RemoteObject _ls_content = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 348;BA.debugLine="Sub get_all_tamrin8 As List";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 349;BA.debugLine="Dim ls_content As List";
Debug.ShouldStop(268435456);
_ls_content = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_content", _ls_content);
 BA.debugLineNum = 350;BA.debugLine="ls_content.Initialize";
Debug.ShouldStop(536870912);
_ls_content.runVoidMethod ("Initialize");
 BA.debugLineNum = 352;BA.debugLine="connection_sql";
Debug.ShouldStop(-2147483648);
_connection_sql(_ba);
 BA.debugLineNum = 353;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(1);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin8 "))));
 BA.debugLineNum = 355;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(4);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 356;BA.debugLine="ls_content.Add(Main.res.GetString(\"matn\"))";
Debug.ShouldStop(8);
_ls_content.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn"))))));
 }
;
 BA.debugLineNum = 359;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(64);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 360;BA.debugLine="Main.res.Close";
Debug.ShouldStop(128);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 362;BA.debugLine="Return ls_content";
Debug.ShouldStop(512);
if (true) return _ls_content;
 BA.debugLineNum = 364;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_book_byid(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_book_byId (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,210);
if (RapidSub.canDelegate("get_book_byid")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_book_byid", _ba, _id);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 210;BA.debugLine="Sub get_book_byId (id As Int) As List";
Debug.ShouldStop(131072);
 BA.debugLineNum = 212;BA.debugLine="connection_sql";
Debug.ShouldStop(524288);
_connection_sql(_ba);
 BA.debugLineNum = 213;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
Debug.ShouldStop(1048576);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM book1 WHERE id="),_id,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 214;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 216;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(8388608);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 217;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(16777216);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 220;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
Debug.ShouldStop(134217728);
_list_result.runVoidMethod ("AddAll",(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("content"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("pic"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("sound"))),BA.NumberToString(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title_down")))})))));
 BA.debugLineNum = 223;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1073741824);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 224;BA.debugLine="Main.res.Close";
Debug.ShouldStop(-2147483648);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 226;BA.debugLine="Return list_result";
Debug.ShouldStop(2);
if (true) return _list_result;
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_download_list(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_download_list (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,75);
if (RapidSub.canDelegate("get_download_list")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_download_list", _ba);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 75;BA.debugLine="Sub get_download_list As List";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="connection_sql";
Debug.ShouldStop(4096);
_connection_sql(_ba);
 BA.debugLineNum = 78;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
Debug.ShouldStop(8192);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM book1;"))));
 BA.debugLineNum = 80;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(32768);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 81;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(65536);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 83;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(262144);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 91;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
Debug.ShouldStop(67108864);
_list_result.runVoidMethod ("Add",(Object)((RemoteObject.concat(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title_down"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("detile_down"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("sound")))))));
 }
;
 BA.debugLineNum = 97;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 98;BA.debugLine="Main.res.Close";
Debug.ShouldStop(2);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 100;BA.debugLine="Return list_result";
Debug.ShouldStop(8);
if (true) return _list_result;
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_fav_byid(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_fav_byId (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,179);
if (RapidSub.canDelegate("get_fav_byid")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_fav_byid", _ba, _id);}
RemoteObject _fav_s = RemoteObject.createImmutable(0);
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 179;BA.debugLine="Sub get_fav_byId(id As Int) As Int";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="connection_sql";
Debug.ShouldStop(524288);
_connection_sql(_ba);
 BA.debugLineNum = 181;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1";
Debug.ShouldStop(1048576);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM book1 WHERE id="),_id,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 182;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 183;BA.debugLine="Dim fav_s As Int =Main.res.Getint(\"state\")";
Debug.ShouldStop(4194304);
_fav_s = myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")));Debug.locals.put("fav_s", _fav_s);Debug.locals.put("fav_s", _fav_s);
 BA.debugLineNum = 185;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16777216);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 186;BA.debugLine="Main.res.Close";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 188;BA.debugLine="Return  fav_s";
Debug.ShouldStop(134217728);
if (true) return _fav_s;
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_fehrest(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_fehrest (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,45);
if (RapidSub.canDelegate("get_fehrest")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_fehrest", _ba);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 45;BA.debugLine="Sub get_fehrest As List";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="connection_sql";
Debug.ShouldStop(16384);
_connection_sql(_ba);
 BA.debugLineNum = 48;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
Debug.ShouldStop(32768);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM book1;"))));
 BA.debugLineNum = 50;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(131072);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 51;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(262144);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 53;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(1048576);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 61;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
Debug.ShouldStop(268435456);
_list_result.runVoidMethod ("Add",(Object)((RemoteObject.concat(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title_down"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("pic")))))));
 }
;
 BA.debugLineNum = 67;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(4);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 68;BA.debugLine="Main.res.Close";
Debug.ShouldStop(8);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 70;BA.debugLine="Return list_result";
Debug.ShouldStop(32);
if (true) return _list_result;
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_removeall_list(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_removeAll_list (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,105);
if (RapidSub.canDelegate("get_removeall_list")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_removeall_list", _ba);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 105;BA.debugLine="Sub get_removeAll_list As List";
Debug.ShouldStop(256);
 BA.debugLineNum = 107;BA.debugLine="connection_sql";
Debug.ShouldStop(1024);
_connection_sql(_ba);
 BA.debugLineNum = 108;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM book1;";
Debug.ShouldStop(2048);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM book1;"))));
 BA.debugLineNum = 110;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(8192);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 111;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(16384);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 113;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(65536);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 114;BA.debugLine="list_result.Add(Main.res.GetString(\"sound\"))";
Debug.ShouldStop(131072);
_list_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("sound"))))));
 }
;
 BA.debugLineNum = 117;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1048576);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 118;BA.debugLine="Main.res.Close";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 120;BA.debugLine="Return list_result";
Debug.ShouldStop(8388608);
if (true) return _list_result;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_roz_byid(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_roz_byId (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,240);
if (RapidSub.canDelegate("get_roz_byid")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_roz_byid", _ba, _id);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 240;BA.debugLine="Sub get_roz_byId (id As Int) As List";
Debug.ShouldStop(32768);
 BA.debugLineNum = 242;BA.debugLine="connection_sql";
Debug.ShouldStop(131072);
_connection_sql(_ba);
 BA.debugLineNum = 243;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(262144);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrin_roz WHERE id="),_id,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 244;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(524288);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 246;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(2097152);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 247;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(4194304);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 250;BA.debugLine="list_result.AddAll(Array As String(Main.res.GetSt";
Debug.ShouldStop(33554432);
_list_result.runVoidMethod ("AddAll",(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("content"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tamrinat"))),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))})))));
 BA.debugLineNum = 253;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 254;BA.debugLine="Main.res.Close";
Debug.ShouldStop(536870912);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 256;BA.debugLine="Return list_result";
Debug.ShouldStop(-2147483648);
if (true) return _list_result;
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_rozha(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_rozha (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,21);
if (RapidSub.canDelegate("get_rozha")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_rozha", _ba);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 21;BA.debugLine="Sub get_rozha As List";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="connection_sql";
Debug.ShouldStop(4194304);
_connection_sql(_ba);
 BA.debugLineNum = 24;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM rozha;";
Debug.ShouldStop(8388608);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM rozha;"))));
 BA.debugLineNum = 26;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(33554432);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 27;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(67108864);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 29;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(268435456);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 31;BA.debugLine="list_result.Add(Main.res.GetString(\"name\")&\"@\"&M";
Debug.ShouldStop(1073741824);
_list_result.runVoidMethod ("Add",(Object)((RemoteObject.concat(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))))));
 }
;
 BA.debugLineNum = 37;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 38;BA.debugLine="Main.res.Close";
Debug.ShouldStop(32);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 40;BA.debugLine="Return list_result";
Debug.ShouldStop(128);
if (true) return _list_result;
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state(RemoteObject _ba,RemoteObject _roz1,RemoteObject _tamrin1) throws Exception{
try {
		Debug.PushSubsStack("get_state (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,143);
if (RapidSub.canDelegate("get_state")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state", _ba, _roz1, _tamrin1);}
RemoteObject _result_state = RemoteObject.createImmutable(0);
;
Debug.locals.put("roz1", _roz1);
Debug.locals.put("tamrin1", _tamrin1);
 BA.debugLineNum = 143;BA.debugLine="Sub get_state(roz1 As Int , tamrin1 As Int) As Int";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="connection_sql";
Debug.ShouldStop(65536);
_connection_sql(_ba);
 BA.debugLineNum = 146;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM states";
Debug.ShouldStop(131072);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM states  WHERE roz="),_roz1,RemoteObject.createImmutable(" AND tamrin="),_tamrin1,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 148;BA.debugLine="Dim result_state As Int =0";
Debug.ShouldStop(524288);
_result_state = BA.numberCast(int.class, 0);Debug.locals.put("result_state", _result_state);Debug.locals.put("result_state", _result_state);
 BA.debugLineNum = 149;BA.debugLine="If(Main.res.RowCount>0)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 150;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 151;BA.debugLine="result_state=Main.res.GetInt(\"state\")";
Debug.ShouldStop(4194304);
_result_state = myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")));Debug.locals.put("result_state", _result_state);
 };
 BA.debugLineNum = 155;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(67108864);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 156;BA.debugLine="Main.res.Close";
Debug.ShouldStop(134217728);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 158;BA.debugLine="Return  result_state";
Debug.ShouldStop(536870912);
if (true) return _result_state;
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin1_byroz(RemoteObject _ba,RemoteObject _roz) throws Exception{
try {
		Debug.PushSubsStack("get_State_tamrin1_byRoz (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,311);
if (RapidSub.canDelegate("get_state_tamrin1_byroz")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin1_byroz", _ba, _roz);}
RemoteObject _res_cod = RemoteObject.createImmutable(0);
;
Debug.locals.put("roz", _roz);
 BA.debugLineNum = 311;BA.debugLine="Sub get_State_tamrin1_byRoz (roz As Int) As Int";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 313;BA.debugLine="connection_sql";
Debug.ShouldStop(16777216);
_connection_sql(_ba);
 BA.debugLineNum = 314;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrin1 WHERE roz="),_roz,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 317;BA.debugLine="Dim res_cod As Int=0";
Debug.ShouldStop(268435456);
_res_cod = BA.numberCast(int.class, 0);Debug.locals.put("res_cod", _res_cod);Debug.locals.put("res_cod", _res_cod);
 BA.debugLineNum = 319;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(1073741824);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 320;BA.debugLine="res_cod=res_cod+Main.res.Getint(\"state\")";
Debug.ShouldStop(-2147483648);
_res_cod = RemoteObject.solve(new RemoteObject[] {_res_cod,myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))}, "+",1, 1);Debug.locals.put("res_cod", _res_cod);
 }
;
 BA.debugLineNum = 323;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(4);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 324;BA.debugLine="Main.res.Close";
Debug.ShouldStop(8);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 326;BA.debugLine="Return res_cod";
Debug.ShouldStop(32);
if (true) return _res_cod;
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin13(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin13 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,496);
if (RapidSub.canDelegate("get_state_tamrin13")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin13", _ba);}
RemoteObject _res_state = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 496;BA.debugLine="Sub get_state_tamrin13 As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 497;BA.debugLine="Dim res_state As Int=0";
Debug.ShouldStop(65536);
_res_state = BA.numberCast(int.class, 0);Debug.locals.put("res_state", _res_state);Debug.locals.put("res_state", _res_state);
 BA.debugLineNum = 499;BA.debugLine="connection_sql";
Debug.ShouldStop(262144);
_connection_sql(_ba);
 BA.debugLineNum = 500;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(524288);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin13 "))));
 BA.debugLineNum = 502;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(2097152);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 503;BA.debugLine="res_state=res_state+Main.res.GetString(\"state\")";
Debug.ShouldStop(4194304);
_res_state = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_res_state,BA.numberCast(double.class, myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))))}, "+",1, 0));Debug.locals.put("res_state", _res_state);
 }
;
 BA.debugLineNum = 506;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 507;BA.debugLine="Main.res.Close";
Debug.ShouldStop(67108864);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 509;BA.debugLine="Return res_state";
Debug.ShouldStop(268435456);
if (true) return _res_state;
 BA.debugLineNum = 511;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin14(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin14 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,429);
if (RapidSub.canDelegate("get_state_tamrin14")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin14", _ba);}
RemoteObject _res_state = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 429;BA.debugLine="Sub get_state_tamrin14 As Int";
Debug.ShouldStop(4096);
 BA.debugLineNum = 430;BA.debugLine="Dim res_state As Int=0";
Debug.ShouldStop(8192);
_res_state = BA.numberCast(int.class, 0);Debug.locals.put("res_state", _res_state);Debug.locals.put("res_state", _res_state);
 BA.debugLineNum = 432;BA.debugLine="connection_sql";
Debug.ShouldStop(32768);
_connection_sql(_ba);
 BA.debugLineNum = 433;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(65536);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin14 "))));
 BA.debugLineNum = 435;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(262144);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 436;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
Debug.ShouldStop(524288);
_res_state = RemoteObject.solve(new RemoteObject[] {_res_state,myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))}, "+",1, 1);Debug.locals.put("res_state", _res_state);
 }
;
 BA.debugLineNum = 439;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(4194304);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 440;BA.debugLine="Main.res.Close";
Debug.ShouldStop(8388608);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 442;BA.debugLine="Return res_state";
Debug.ShouldStop(33554432);
if (true) return _res_state;
 BA.debugLineNum = 444;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin16(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin16 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,547);
if (RapidSub.canDelegate("get_state_tamrin16")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin16", _ba);}
RemoteObject _res_state = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 547;BA.debugLine="Sub get_state_tamrin16 As Int";
Debug.ShouldStop(4);
 BA.debugLineNum = 548;BA.debugLine="Dim res_state As Int=0";
Debug.ShouldStop(8);
_res_state = BA.numberCast(int.class, 0);Debug.locals.put("res_state", _res_state);Debug.locals.put("res_state", _res_state);
 BA.debugLineNum = 550;BA.debugLine="connection_sql";
Debug.ShouldStop(32);
_connection_sql(_ba);
 BA.debugLineNum = 551;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(64);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin16 "))));
 BA.debugLineNum = 553;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(256);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 554;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
Debug.ShouldStop(512);
_res_state = RemoteObject.solve(new RemoteObject[] {_res_state,myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))}, "+",1, 1);Debug.locals.put("res_state", _res_state);
 }
;
 BA.debugLineNum = 557;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(4096);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 558;BA.debugLine="Main.res.Close";
Debug.ShouldStop(8192);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 560;BA.debugLine="Return res_state";
Debug.ShouldStop(32768);
if (true) return _res_state;
 BA.debugLineNum = 562;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin19(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin19 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,566);
if (RapidSub.canDelegate("get_state_tamrin19")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin19", _ba);}
RemoteObject _res_state = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 566;BA.debugLine="Sub get_state_tamrin19 As Int";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 567;BA.debugLine="Dim res_state As Int=0";
Debug.ShouldStop(4194304);
_res_state = BA.numberCast(int.class, 0);Debug.locals.put("res_state", _res_state);Debug.locals.put("res_state", _res_state);
 BA.debugLineNum = 569;BA.debugLine="connection_sql";
Debug.ShouldStop(16777216);
_connection_sql(_ba);
 BA.debugLineNum = 570;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin19 "))));
 BA.debugLineNum = 572;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(134217728);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 573;BA.debugLine="res_state=res_state+1";
Debug.ShouldStop(268435456);
_res_state = RemoteObject.solve(new RemoteObject[] {_res_state,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("res_state", _res_state);
 }
;
 BA.debugLineNum = 576;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(-2147483648);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 577;BA.debugLine="Main.res.Close";
Debug.ShouldStop(1);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 579;BA.debugLine="Return res_state";
Debug.ShouldStop(4);
if (true) return _res_state;
 BA.debugLineNum = 581;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrin8(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get_state_tamrin8 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,379);
if (RapidSub.canDelegate("get_state_tamrin8")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrin8", _ba);}
RemoteObject _res_state = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 379;BA.debugLine="Sub get_state_tamrin8 As Int";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 380;BA.debugLine="Dim res_state As Int=0";
Debug.ShouldStop(134217728);
_res_state = BA.numberCast(int.class, 0);Debug.locals.put("res_state", _res_state);Debug.locals.put("res_state", _res_state);
 BA.debugLineNum = 382;BA.debugLine="connection_sql";
Debug.ShouldStop(536870912);
_connection_sql(_ba);
 BA.debugLineNum = 383;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(1073741824);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tamrin8 "))));
 BA.debugLineNum = 385;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(1);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 386;BA.debugLine="res_state=res_state+Main.res.Getint(\"state\")";
Debug.ShouldStop(2);
_res_state = RemoteObject.solve(new RemoteObject[] {_res_state,myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))}, "+",1, 1);Debug.locals.put("res_state", _res_state);
 }
;
 BA.debugLineNum = 389;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(16);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 390;BA.debugLine="Main.res.Close";
Debug.ShouldStop(32);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 392;BA.debugLine="Return res_state";
Debug.ShouldStop(128);
if (true) return _res_state;
 BA.debugLineNum = 394;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_state_tamrinat_saved(RemoteObject _ba,RemoteObject _roz,RemoteObject _tamrin) throws Exception{
try {
		Debug.PushSubsStack("get_State_tamrinat_saved (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,625);
if (RapidSub.canDelegate("get_state_tamrinat_saved")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_state_tamrinat_saved", _ba, _roz, _tamrin);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("roz", _roz);
Debug.locals.put("tamrin", _tamrin);
 BA.debugLineNum = 625;BA.debugLine="Sub get_State_tamrinat_saved (roz As Int,tamrin As";
Debug.ShouldStop(65536);
 BA.debugLineNum = 627;BA.debugLine="connection_sql";
Debug.ShouldStop(262144);
_connection_sql(_ba);
 BA.debugLineNum = 628;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(524288);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrinat_saved WHERE roz="),_roz,RemoteObject.createImmutable(" AND tamrin="),_tamrin,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 630;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(2097152);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 632;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(8388608);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 633;BA.debugLine="state1=state1+Main.res.Getint(\"state\")";
Debug.ShouldStop(16777216);
_state1 = RemoteObject.solve(new RemoteObject[] {_state1,myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))}, "+",1, 1);Debug.locals.put("state1", _state1);
 }
;
 BA.debugLineNum = 636;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(134217728);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 637;BA.debugLine="Main.res.Close";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 639;BA.debugLine="Return state1";
Debug.ShouldStop(1073741824);
if (true) return _state1;
 BA.debugLineNum = 641;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_tamrin1_byroz(RemoteObject _ba,RemoteObject _roz) throws Exception{
try {
		Debug.PushSubsStack("get_tamrin1_byRoz (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,261);
if (RapidSub.canDelegate("get_tamrin1_byroz")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_tamrin1_byroz", _ba, _roz);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("roz", _roz);
 BA.debugLineNum = 261;BA.debugLine="Sub get_tamrin1_byRoz (roz As Int) As List";
Debug.ShouldStop(16);
 BA.debugLineNum = 263;BA.debugLine="connection_sql";
Debug.ShouldStop(64);
_connection_sql(_ba);
 BA.debugLineNum = 264;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(128);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrin1 WHERE roz="),_roz,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 267;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(1024);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 268;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(2048);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 270;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(8192);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 272;BA.debugLine="list_result.Add(Main.res.Getint(\"id\")&\"@\"&Main.r";
Debug.ShouldStop(32768);
_list_result.runVoidMethod ("Add",(Object)((RemoteObject.concat(myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("num"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mohebat"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("elat"))),RemoteObject.createImmutable("@"),myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))))));
 }
;
 BA.debugLineNum = 276;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(524288);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 277;BA.debugLine="Main.res.Close";
Debug.ShouldStop(1048576);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 279;BA.debugLine="Return list_result";
Debug.ShouldStop(4194304);
if (true) return _list_result;
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_tamrinat_saved(RemoteObject _ba,RemoteObject _roz,RemoteObject _tamrin) throws Exception{
try {
		Debug.PushSubsStack("get_tamrinat_saved (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,607);
if (RapidSub.canDelegate("get_tamrinat_saved")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_tamrinat_saved", _ba, _roz, _tamrin);}
RemoteObject _list_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("roz", _roz);
Debug.locals.put("tamrin", _tamrin);
 BA.debugLineNum = 607;BA.debugLine="Sub get_tamrinat_saved (roz As Int,tamrin As Int)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 609;BA.debugLine="connection_sql";
Debug.ShouldStop(1);
_connection_sql(_ba);
 BA.debugLineNum = 610;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(2);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrinat_saved WHERE roz="),_roz,RemoteObject.createImmutable(" AND tamrin="),_tamrin,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 612;BA.debugLine="Dim list_result As List";
Debug.ShouldStop(8);
_list_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_result", _list_result);
 BA.debugLineNum = 613;BA.debugLine="list_result.Initialize";
Debug.ShouldStop(16);
_list_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 614;BA.debugLine="Do While Main.res.NextRow";
Debug.ShouldStop(32);
while (myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 615;BA.debugLine="list_result.Add(Main.res.GetString(\"matn\"))";
Debug.ShouldStop(64);
_list_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn"))))));
 }
;
 BA.debugLineNum = 618;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(512);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 619;BA.debugLine="Main.res.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 621;BA.debugLine="Return list_result";
Debug.ShouldStop(4096);
if (true) return _list_result;
 BA.debugLineNum = 623;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_tamrinname(RemoteObject _ba,RemoteObject _numtamrin) throws Exception{
try {
		Debug.PushSubsStack("get_tamrinName (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,192);
if (RapidSub.canDelegate("get_tamrinname")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","get_tamrinname", _ba, _numtamrin);}
RemoteObject _ls_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("numTamrin", _numtamrin);
 BA.debugLineNum = 192;BA.debugLine="Sub get_tamrinName(numTamrin As Int) As List";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="connection_sql";
Debug.ShouldStop(1);
_connection_sql(_ba);
 BA.debugLineNum = 194;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
Debug.ShouldStop(2);
myfunc.mostCurrent._main._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tamrinat_name WHERE num_tamrin="),_numtamrin,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 195;BA.debugLine="Main.res.Position=0";
Debug.ShouldStop(4);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 196;BA.debugLine="Dim ls_result As List";
Debug.ShouldStop(8);
_ls_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_result", _ls_result);
 BA.debugLineNum = 197;BA.debugLine="ls_result.Initialize";
Debug.ShouldStop(16);
_ls_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 198;BA.debugLine="ls_result.Add(Main.res.GetString(\"title\"))";
Debug.ShouldStop(32);
_ls_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title"))))));
 BA.debugLineNum = 199;BA.debugLine="ls_result.Add(Main.res.GetString(\"help\"))";
Debug.ShouldStop(64);
_ls_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._main._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("help"))))));
 BA.debugLineNum = 203;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 204;BA.debugLine="Main.res.Close";
Debug.ShouldStop(2048);
myfunc.mostCurrent._main._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 206;BA.debugLine="Return  ls_result";
Debug.ShouldStop(8192);
if (true) return _ls_result;
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _removeall_tamrinat(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("removeAll_tamrinat (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,125);
if (RapidSub.canDelegate("removeall_tamrinat")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","removeall_tamrinat", _ba);}
;
 BA.debugLineNum = 125;BA.debugLine="Sub removeAll_tamrinat";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 127;BA.debugLine="connection_sql";
Debug.ShouldStop(1073741824);
_connection_sql(_ba);
 BA.debugLineNum = 129;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE tamrin1 SET mohebat";
Debug.ShouldStop(1);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE tamrin1 SET mohebat=\"\" , elat=\"\" , state=0 ;")));
 BA.debugLineNum = 130;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(2);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_fav_book(RemoteObject _ba,RemoteObject _idrow,RemoteObject _fav_state) throws Exception{
try {
		Debug.PushSubsStack("set_fav_book (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,134);
if (RapidSub.canDelegate("set_fav_book")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","set_fav_book", _ba, _idrow, _fav_state);}
;
Debug.locals.put("idRow", _idrow);
Debug.locals.put("fav_state", _fav_state);
 BA.debugLineNum = 134;BA.debugLine="Sub set_fav_book(idRow As Int,fav_state As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 136;BA.debugLine="connection_sql";
Debug.ShouldStop(128);
_connection_sql(_ba);
 BA.debugLineNum = 138;BA.debugLine="Main.sql.ExecNonQuery(\"UPDATE book1 SET state=\"&f";
Debug.ShouldStop(512);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE book1 SET state="),_fav_state,RemoteObject.createImmutable(" WHERE id="),_idrow,RemoteObject.createImmutable(" ;"))));
 BA.debugLineNum = 139;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setrotation(RemoteObject _ba,RemoteObject _v,RemoteObject _time,RemoteObject _angle) throws Exception{
try {
		Debug.PushSubsStack("setRotation (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,588);
if (RapidSub.canDelegate("setrotation")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","setrotation", _ba, _v, _time, _angle);}
;
Debug.locals.put("v", _v);
Debug.locals.put("Time", _time);
Debug.locals.put("Angle", _angle);
 BA.debugLineNum = 588;BA.debugLine="Sub setRotation(v As B4XView, Time As Int, Angle A";
Debug.ShouldStop(2048);
 BA.debugLineNum = 591;BA.debugLine="v.SetRotationAnimated(Time,Angle)";
Debug.ShouldStop(16384);
_v.runVoidMethod ("SetRotationAnimated",(Object)(_time),(Object)(_angle));
 BA.debugLineNum = 592;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setstate(RemoteObject _ba,RemoteObject _roz1,RemoteObject _tamrin1) throws Exception{
try {
		Debug.PushSubsStack("setState (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,166);
if (RapidSub.canDelegate("setstate")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","setstate", _ba, _roz1, _tamrin1);}
;
Debug.locals.put("roz1", _roz1);
Debug.locals.put("tamrin1", _tamrin1);
 BA.debugLineNum = 166;BA.debugLine="Sub setState(roz1 As Int , tamrin1 As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 168;BA.debugLine="connection_sql";
Debug.ShouldStop(128);
_connection_sql(_ba);
 BA.debugLineNum = 169;BA.debugLine="Main.sql.ExecNonQuery2(\"INSERT INTO states (roz, t";
Debug.ShouldStop(256);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO states (roz, tamrin , state) VALUES (?, ?, ?)")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_roz1),(_tamrin1),RemoteObject.createImmutable((1))})))));
 BA.debugLineNum = 170;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(512);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin1_elat(RemoteObject _ba,RemoteObject _id,RemoteObject _elat,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin1_elat (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,300);
if (RapidSub.canDelegate("update_tamrin1_elat")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin1_elat", _ba, _id, _elat, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("elat", _elat);
Debug.locals.put("state", _state);
 BA.debugLineNum = 300;BA.debugLine="Sub update_tamrin1_elat(id As Int,elat As String,s";
Debug.ShouldStop(2048);
 BA.debugLineNum = 302;BA.debugLine="connection_sql";
Debug.ShouldStop(8192);
_connection_sql(_ba);
 BA.debugLineNum = 303;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET elat=?";
Debug.ShouldStop(16384);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin1 SET elat=?, state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_elat),(_state),(_id)})))));
 BA.debugLineNum = 304;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(32768);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 306;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin1_mohebat(RemoteObject _ba,RemoteObject _id,RemoteObject _mohebat,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin1_mohebat (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,285);
if (RapidSub.canDelegate("update_tamrin1_mohebat")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin1_mohebat", _ba, _id, _mohebat, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("mohebat", _mohebat);
Debug.locals.put("state", _state);
 BA.debugLineNum = 285;BA.debugLine="Sub update_tamrin1_mohebat(id As Int,mohebat As St";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 287;BA.debugLine="connection_sql";
Debug.ShouldStop(1073741824);
_connection_sql(_ba);
 BA.debugLineNum = 289;BA.debugLine="If(mohebat=\"\")Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_mohebat,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 290;BA.debugLine="state=0";
Debug.ShouldStop(2);
_state = BA.numberCast(int.class, 0);Debug.locals.put("state", _state);
 };
 BA.debugLineNum = 293;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin1 SET moheba";
Debug.ShouldStop(16);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin1 SET mohebat=? , state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_mohebat),(_state),(_id)})))));
 BA.debugLineNum = 294;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(32);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 296;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 297;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin13(RemoteObject _ba,RemoteObject _id1,RemoteObject _name1,RemoteObject _matn1) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin13 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,477);
if (RapidSub.canDelegate("update_tamrin13")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin13", _ba, _id1, _name1, _matn1);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("id1", _id1);
Debug.locals.put("name1", _name1);
Debug.locals.put("matn1", _matn1);
 BA.debugLineNum = 477;BA.debugLine="Sub update_tamrin13 (id1 As Int,name1 As String,m";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 478;BA.debugLine="Dim state1 As Int=1";
Debug.ShouldStop(536870912);
_state1 = BA.numberCast(int.class, 1);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 479;BA.debugLine="If(matn1=\"\")Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_matn1,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 480;BA.debugLine="state1=0";
Debug.ShouldStop(-2147483648);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 482;BA.debugLine="If(name1=Null)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("n",_name1))) { 
 BA.debugLineNum = 483;BA.debugLine="name1=\"\"";
Debug.ShouldStop(4);
_name1 = BA.ObjectToString("");Debug.locals.put("name1", _name1);
 };
 BA.debugLineNum = 485;BA.debugLine="If(matn1=Null)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("n",_matn1))) { 
 BA.debugLineNum = 486;BA.debugLine="matn1=\"\"";
Debug.ShouldStop(32);
_matn1 = BA.ObjectToString("");Debug.locals.put("matn1", _matn1);
 };
 BA.debugLineNum = 489;BA.debugLine="connection_sql";
Debug.ShouldStop(256);
_connection_sql(_ba);
 BA.debugLineNum = 490;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin13 SET name=";
Debug.ShouldStop(512);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin13 SET name=? , matn=?, state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_name1),(_matn1),(_state1),(_id1)})))));
 BA.debugLineNum = 491;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 493;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 494;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin14(RemoteObject _ba,RemoteObject _id,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin14 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,416);
if (RapidSub.canDelegate("update_tamrin14")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin14", _ba, _id, _matn);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("id", _id);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 416;BA.debugLine="Sub update_tamrin14 (id As Int,matn As String) As";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 417;BA.debugLine="Dim state1 As Int=1";
Debug.ShouldStop(1);
_state1 = BA.numberCast(int.class, 1);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 418;BA.debugLine="If(matn=\"\")Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_matn,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 419;BA.debugLine="state1=0";
Debug.ShouldStop(4);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 422;BA.debugLine="connection_sql";
Debug.ShouldStop(32);
_connection_sql(_ba);
 BA.debugLineNum = 423;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin14 SET matn=";
Debug.ShouldStop(64);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin14 SET matn=?, state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_matn),(_state1),(_id)})))));
 BA.debugLineNum = 424;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(128);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 426;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 427;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin16(RemoteObject _ba,RemoteObject _id,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin16 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,534);
if (RapidSub.canDelegate("update_tamrin16")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin16", _ba, _id, _matn);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("id", _id);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 534;BA.debugLine="Sub update_tamrin16 (id As Int,matn As String) As";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 535;BA.debugLine="Dim state1 As Int=1";
Debug.ShouldStop(4194304);
_state1 = BA.numberCast(int.class, 1);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 536;BA.debugLine="If(matn=\"\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_matn,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 537;BA.debugLine="state1=0";
Debug.ShouldStop(16777216);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 540;BA.debugLine="connection_sql";
Debug.ShouldStop(134217728);
_connection_sql(_ba);
 BA.debugLineNum = 541;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin16 SET matn=";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin16 SET matn=?, state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_matn),(_state1),(_id)})))));
 BA.debugLineNum = 542;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(536870912);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 544;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 545;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrin8(RemoteObject _ba,RemoteObject _id,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("update_tamrin8 (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,366);
if (RapidSub.canDelegate("update_tamrin8")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrin8", _ba, _id, _matn);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("id", _id);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 366;BA.debugLine="Sub update_tamrin8 (id As Int,matn As String) As";
Debug.ShouldStop(8192);
 BA.debugLineNum = 367;BA.debugLine="Dim state1 As Int=1";
Debug.ShouldStop(16384);
_state1 = BA.numberCast(int.class, 1);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 368;BA.debugLine="If(matn=\"\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_matn,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 369;BA.debugLine="state1=0";
Debug.ShouldStop(65536);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 372;BA.debugLine="connection_sql";
Debug.ShouldStop(524288);
_connection_sql(_ba);
 BA.debugLineNum = 373;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin8 SET matn=?";
Debug.ShouldStop(1048576);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrin8 SET matn=?, state=? WHERE id=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_matn),(_state1),(_id)})))));
 BA.debugLineNum = 374;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 376;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 377;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_tamrinat_saved(RemoteObject _ba,RemoteObject _roz,RemoteObject _tamrin,RemoteObject _num,RemoteObject _matn,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("update_tamrinat_saved (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,595);
if (RapidSub.canDelegate("update_tamrinat_saved")) { return ir.taravatgroup.shokrgozari.myfunc.remoteMe.runUserSub(false, "myfunc","update_tamrinat_saved", _ba, _roz, _tamrin, _num, _matn, _state);}
RemoteObject _state1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("roz", _roz);
Debug.locals.put("tamrin", _tamrin);
Debug.locals.put("num", _num);
Debug.locals.put("matn", _matn);
Debug.locals.put("state", _state);
 BA.debugLineNum = 595;BA.debugLine="Sub update_tamrinat_saved( roz As Int,tamrin As In";
Debug.ShouldStop(262144);
 BA.debugLineNum = 596;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(524288);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 597;BA.debugLine="If(matn<>\"\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",_matn,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 598;BA.debugLine="state1=1";
Debug.ShouldStop(2097152);
_state1 = BA.numberCast(int.class, 1);Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 600;BA.debugLine="connection_sql";
Debug.ShouldStop(8388608);
_connection_sql(_ba);
 BA.debugLineNum = 601;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrinat_saved SET";
Debug.ShouldStop(16777216);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tamrinat_saved SET matn=?, state=? WHERE roz=? AND tamrin=? AND num=?;")),(Object)(myfunc.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_matn),(_state1),(_roz),(_tamrin),(_num)})))));
 BA.debugLineNum = 602;BA.debugLine="Main.sql.Close";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 604;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 605;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}