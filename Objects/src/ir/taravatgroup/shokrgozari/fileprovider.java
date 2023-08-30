package ir.taravatgroup.shokrgozari;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fileprovider extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ir.taravatgroup.shokrgozari.fileprovider");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ir.taravatgroup.shokrgozari.fileprovider.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _sharedfolder = "";
public boolean _usefileprovider = false;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
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
public String  _class_globals(ir.taravatgroup.shokrgozari.fileprovider __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
RDebugUtils.currentLine=14745600;
 //BA.debugLineNum = 14745600;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=14745601;
 //BA.debugLineNum = 14745601;BA.debugLine="Public SharedFolder As String";
_sharedfolder = "";
RDebugUtils.currentLine=14745602;
 //BA.debugLineNum = 14745602;BA.debugLine="Public UseFileProvider As Boolean";
_usefileprovider = false;
RDebugUtils.currentLine=14745603;
 //BA.debugLineNum = 14745603;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=14745604;
 //BA.debugLineNum = 14745604;BA.debugLine="End Sub";
return "";
}
public Object  _getfileuri(ir.taravatgroup.shokrgozari.fileprovider __ref,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "getfileuri", true))
	 {return ((Object) Debug.delegate(ba, "getfileuri", new Object[] {_filename}));}
anywheresoftware.b4j.object.JavaObject _uri = null;
anywheresoftware.b4j.object.JavaObject _f = null;
anywheresoftware.b4j.object.JavaObject _fp = null;
anywheresoftware.b4j.object.JavaObject _context = null;
RDebugUtils.currentLine=14876672;
 //BA.debugLineNum = 14876672;BA.debugLine="Public Sub GetFileUri (FileName As String) As Obje";
RDebugUtils.currentLine=14876674;
 //BA.debugLineNum = 14876674;BA.debugLine="If UseFileProvider = False Then";
if (__ref._usefileprovider /*boolean*/ ==__c.False) { 
RDebugUtils.currentLine=14876675;
 //BA.debugLineNum = 14876675;BA.debugLine="Dim uri As JavaObject";
_uri = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=14876676;
 //BA.debugLineNum = 14876676;BA.debugLine="Return uri.InitializeStatic(\"android.net.Uri\").R";
if (true) return _uri.InitializeStatic("android.net.Uri").RunMethod("parse",new Object[]{(Object)("file://"+__c.File.Combine(__ref._sharedfolder /*String*/ ,_filename))});
 }else {
RDebugUtils.currentLine=14876678;
 //BA.debugLineNum = 14876678;BA.debugLine="Dim f As JavaObject";
_f = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=14876679;
 //BA.debugLineNum = 14876679;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Sh";
_f.InitializeNewInstance("java.io.File",new Object[]{(Object)(__ref._sharedfolder /*String*/ ),(Object)(_filename)});
RDebugUtils.currentLine=14876680;
 //BA.debugLineNum = 14876680;BA.debugLine="Dim fp As JavaObject";
_fp = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=14876681;
 //BA.debugLineNum = 14876681;BA.debugLine="Dim context As JavaObject";
_context = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=14876682;
 //BA.debugLineNum = 14876682;BA.debugLine="context.InitializeContext";
_context.InitializeContext(ba);
RDebugUtils.currentLine=14876683;
 //BA.debugLineNum = 14876683;BA.debugLine="fp.InitializeStatic(\"android.support.v4.content.";
_fp.InitializeStatic("androidx.core.content.FileProvider");
RDebugUtils.currentLine=14876684;
 //BA.debugLineNum = 14876684;BA.debugLine="Return fp.RunMethod(\"getUriForFile\", Array(conte";
if (true) return _fp.RunMethod("getUriForFile",new Object[]{(Object)(_context.getObject()),(Object)(__c.Application.getPackageName()+".provider"),(Object)(_f.getObject())});
 };
RDebugUtils.currentLine=14876686;
 //BA.debugLineNum = 14876686;BA.debugLine="End Sub";
return null;
}
public String  _initialize(ir.taravatgroup.shokrgozari.fileprovider __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=14811136;
 //BA.debugLineNum = 14811136;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=14811137;
 //BA.debugLineNum = 14811137;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=14811138;
 //BA.debugLineNum = 14811138;BA.debugLine="If p.SdkVersion >= 24 Or File.ExternalWritable =";
if (_p.getSdkVersion()>=24 || __c.File.getExternalWritable()==__c.False) { 
RDebugUtils.currentLine=14811139;
 //BA.debugLineNum = 14811139;BA.debugLine="UseFileProvider = True";
__ref._usefileprovider /*boolean*/  = __c.True;
RDebugUtils.currentLine=14811140;
 //BA.debugLineNum = 14811140;BA.debugLine="SharedFolder = File.Combine(File.DirInternal, \"s";
__ref._sharedfolder /*String*/  = __c.File.Combine(__c.File.getDirInternal(),"shared");
RDebugUtils.currentLine=14811141;
 //BA.debugLineNum = 14811141;BA.debugLine="File.MakeDir(\"\", SharedFolder)";
__c.File.MakeDir("",__ref._sharedfolder /*String*/ );
 }else {
RDebugUtils.currentLine=14811143;
 //BA.debugLineNum = 14811143;BA.debugLine="UseFileProvider = False";
__ref._usefileprovider /*boolean*/  = __c.False;
RDebugUtils.currentLine=14811144;
 //BA.debugLineNum = 14811144;BA.debugLine="SharedFolder = rp.GetSafeDirDefaultExternal(\"sha";
__ref._sharedfolder /*String*/  = __ref._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .GetSafeDirDefaultExternal("shared");
 };
RDebugUtils.currentLine=14811146;
 //BA.debugLineNum = 14811146;BA.debugLine="Log($\"Using FileProvider? ${UseFileProvider}\"$)";
__c.LogImpl("914811146",("Using FileProvider? "+__c.SmartStringFormatter("",(Object)(__ref._usefileprovider /*boolean*/ ))+""),0);
RDebugUtils.currentLine=14811147;
 //BA.debugLineNum = 14811147;BA.debugLine="End Sub";
return "";
}
public String  _setfileuriasintentdata(ir.taravatgroup.shokrgozari.fileprovider __ref,anywheresoftware.b4a.objects.IntentWrapper _intent,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "setfileuriasintentdata", true))
	 {return ((String) Debug.delegate(ba, "setfileuriasintentdata", new Object[] {_intent,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=14942208;
 //BA.debugLineNum = 14942208;BA.debugLine="Public Sub SetFileUriAsIntentData (Intent As Inten";
RDebugUtils.currentLine=14942209;
 //BA.debugLineNum = 14942209;BA.debugLine="Dim jo As JavaObject = Intent";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_intent.getObject()));
RDebugUtils.currentLine=14942210;
 //BA.debugLineNum = 14942210;BA.debugLine="jo.RunMethod(\"setData\", Array(GetFileUri(FileName";
_jo.RunMethod("setData",new Object[]{__ref._getfileuri /*Object*/ (null,_filename)});
RDebugUtils.currentLine=14942211;
 //BA.debugLineNum = 14942211;BA.debugLine="Intent.Flags = Bit.Or(Intent.Flags, 1) 'FLAG_GRAN";
_intent.setFlags(__c.Bit.Or(_intent.getFlags(),(int) (1)));
RDebugUtils.currentLine=14942212;
 //BA.debugLineNum = 14942212;BA.debugLine="End Sub";
return "";
}
}