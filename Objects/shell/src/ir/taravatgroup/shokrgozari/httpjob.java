
package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class httpjob {
    public static RemoteObject myClass;
	public httpjob() {
	}
    public static PCBA staticBA = new PCBA(null, httpjob.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _jobname = RemoteObject.createImmutable("");
public static RemoteObject _success = RemoteObject.createImmutable(false);
public static RemoteObject _username = RemoteObject.createImmutable("");
public static RemoteObject _password = RemoteObject.createImmutable("");
public static RemoteObject _errormessage = RemoteObject.createImmutable("");
public static RemoteObject _target = RemoteObject.declareNull("Object");
public static RemoteObject _taskid = RemoteObject.createImmutable("");
public static RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest");
public static RemoteObject _response = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse");
public static RemoteObject _tag = RemoteObject.declareNull("Object");
public static RemoteObject _invalidurl = RemoteObject.createImmutable("");
public static RemoteObject _defaultscheme = RemoteObject.createImmutable("");
public static ir.taravatgroup.shokrgozari.main _main = null;
public static ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public static ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public static ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public static ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public static ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public static ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public static ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public static ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public static ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public static ir.taravatgroup.shokrgozari.starter _starter = null;
public static ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public static ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public static ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DefaultScheme",_ref.getField(false, "_defaultscheme"),"ErrorMessage",_ref.getField(false, "_errormessage"),"InvalidURL",_ref.getField(false, "_invalidurl"),"JobName",_ref.getField(false, "_jobname"),"Password",_ref.getField(false, "_password"),"req",_ref.getField(false, "_req"),"Response",_ref.getField(false, "_response"),"Success",_ref.getField(false, "_success"),"Tag",_ref.getField(false, "_tag"),"target",_ref.getField(false, "_target"),"taskId",_ref.getField(false, "_taskid"),"Username",_ref.getField(false, "_username")};
}
}