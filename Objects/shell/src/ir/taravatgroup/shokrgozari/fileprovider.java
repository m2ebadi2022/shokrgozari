
package ir.taravatgroup.shokrgozari;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class fileprovider {
    public static RemoteObject myClass;
	public fileprovider() {
	}
    public static PCBA staticBA = new PCBA(null, fileprovider.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sharedfolder = RemoteObject.createImmutable("");
public static RemoteObject _usefileprovider = RemoteObject.createImmutable(false);
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
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
		return new Object[] {"rp",_ref.getField(false, "_rp"),"SharedFolder",_ref.getField(false, "_sharedfolder"),"UseFileProvider",_ref.getField(false, "_usefileprovider")};
}
}