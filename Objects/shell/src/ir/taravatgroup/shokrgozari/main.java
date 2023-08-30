
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "ir.taravatgroup.shokrgozari.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _current_roz_tamrin = RemoteObject.createImmutable(0);
public static RemoteObject _current_tamrin = RemoteObject.createImmutable(0);
public static RemoteObject _current_book_content_id = RemoteObject.createImmutable(0);
public static RemoteObject _sql = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
public static RemoteObject _tim_splash = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _btn_all_tamrin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_dashboard = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pan_main = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_home = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _clv_tamrinat_tagvim = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _r1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _r2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _r3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _r4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _r5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _l1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _l2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _l3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _l4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _l5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_roz_lsv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lsv_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _pan_all_lsv = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _current_indexpage = RemoteObject.createImmutable(0);
public static RemoteObject _pan_splash = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _scrollview_dashboard = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_show_tamrin_roz = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _this_day = RemoteObject.createImmutable(0);
public static RemoteObject _pan_circle = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_main3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_main2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
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
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"book_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.book_activity.class),"btn_all_tamrin",main.mostCurrent._btn_all_tamrin,"btn_dashboard",main.mostCurrent._btn_dashboard,"btn_home",main.mostCurrent._btn_home,"clv_tamrinat_tagvim",main.mostCurrent._clv_tamrinat_tagvim,"current_book_content_id",main._current_book_content_id,"current_indexPage",main._current_indexpage,"current_roz_tamrin",main._current_roz_tamrin,"current_tamrin",main._current_tamrin,"do_tamrin_roz_layout",Debug.moduleToString(ir.taravatgroup.shokrgozari.do_tamrin_roz_layout.class),"download_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.download_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.shokrgozari.httputils2service.class),"ImageView1",main.mostCurrent._imageview1,"intro_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.intro_activity.class),"L1",main.mostCurrent._l1,"L2",main.mostCurrent._l2,"L3",main.mostCurrent._l3,"L4",main.mostCurrent._l4,"L5",main.mostCurrent._l5,"Label1",main.mostCurrent._label1,"lbl_roz_lsv",main.mostCurrent._lbl_roz_lsv,"lbl_show_tamrin_roz",main.mostCurrent._lbl_show_tamrin_roz,"lsv_roz",main.mostCurrent._lsv_roz,"myFunc",Debug.moduleToString(ir.taravatgroup.shokrgozari.myfunc.class),"p",main.mostCurrent._p,"pan_all_lsv",main.mostCurrent._pan_all_lsv,"pan_circle",main.mostCurrent._pan_circle,"pan_main",main.mostCurrent._pan_main,"pan_main2",main.mostCurrent._pan_main2,"pan_main3",main.mostCurrent._pan_main3,"pan_splash",main.mostCurrent._pan_splash,"r1",main.mostCurrent._r1,"r2",main.mostCurrent._r2,"r3",main.mostCurrent._r3,"r4",main.mostCurrent._r4,"r5",main.mostCurrent._r5,"reagBook_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.reagbook_activity.class),"res",main._res,"ScrollView_dashboard",main.mostCurrent._scrollview_dashboard,"setting_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.setting_activity.class),"sql",main._sql,"Starter",Debug.moduleToString(ir.taravatgroup.shokrgozari.starter.class),"tamrin_roz_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin_roz_activity.class),"tamrin13_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin13_activity.class),"tamrin14_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin14_activity.class),"tamrin16_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin16_activity.class),"tamrin19_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin19_activity.class),"tamrin25_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin25_activity.class),"tamrin3_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin3_activity.class),"tamrin8_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrin8_activity.class),"tamrinat_activity",Debug.moduleToString(ir.taravatgroup.shokrgozari.tamrinat_activity.class),"this_day",main._this_day,"tim_splash",main._tim_splash,"xui",main.mostCurrent._xui};
}
}