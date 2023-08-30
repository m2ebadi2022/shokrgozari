
package ir.taravatgroup.shokrgozari;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class book_activity implements IRemote{
	public static book_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public book_activity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("book_activity"), "ir.taravatgroup.shokrgozari.book_activity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, book_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _tim_scroll2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _customlistview1 = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lbl_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_icon_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_pic = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_icon_fav = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pos_scroll = RemoteObject.createImmutable(0);
public static RemoteObject _isfitest = RemoteObject.createImmutable(false);
public static ir.taravatgroup.shokrgozari.main _main = null;
public static ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public static ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
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
  public Object[] GetGlobals() {
		return new Object[] {"Activity",book_activity.mostCurrent._activity,"CustomListView1",book_activity.mostCurrent._customlistview1,"do_tamrin_roz_layout",Debug.moduleToString(ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.class),"download_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.download_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.shokrgozari.httputils2service.class),"intro_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.intro_activity.class),"isfitest",book_activity._isfitest,"lbl_icon_fav",book_activity.mostCurrent._lbl_icon_fav,"lbl_icon_roz",book_activity.mostCurrent._lbl_icon_roz,"lbl_roz",book_activity.mostCurrent._lbl_roz,"Main",Debug.moduleToString(ir.taravatgroup.shokrgozari.main.class),"myFunc",Debug.moduleToString(ir.taravatgroup.shokrgozari.myfunc.class),"p",book_activity.mostCurrent._p,"pan_pic",book_activity.mostCurrent._pan_pic,"pan_roz",book_activity.mostCurrent._pan_roz,"pos_scroll",book_activity._pos_scroll,"reagBook_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.reagbook_activity.class),"setting_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.setting_activity.class),"Starter",Debug.moduleToString(ir.taravatgroup.shokrgozari.starter.class),"tamrin_roz_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin_roz_activity.class),"tamrin13_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin13_activity.class),"tamrin14_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin14_activity.class),"tamrin16_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin16_activity.class),"tamrin19_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin19_activity.class),"tamrin25_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin25_activity.class),"tamrin3_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin3_activity.class),"tamrin8_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin8_activity.class),"tamrinat_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrinat_activity.class),"tim_scroll2",book_activity._tim_scroll2,"xui",book_activity.mostCurrent._xui};
}
}