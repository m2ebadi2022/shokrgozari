package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",12,starter.processBA,starter.mostCurrent,30);
if (RapidSub.canDelegate("application_error")) { return ir.taravatgroup.shokrgozari.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 30;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
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
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",12,starter.processBA,starter.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return ir.taravatgroup.shokrgozari.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",12,starter.processBA,starter.mostCurrent,34);
if (RapidSub.canDelegate("service_destroy")) { return ir.taravatgroup.shokrgozari.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 34;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",12,starter.processBA,starter.mostCurrent,18);
if (RapidSub.canDelegate("service_start")) { return ir.taravatgroup.shokrgozari.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 22;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(2097152);
starter.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",12,starter.processBA,starter.mostCurrent,25);
if (RapidSub.canDelegate("service_taskremoved")) { return ir.taravatgroup.shokrgozari.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 25;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}