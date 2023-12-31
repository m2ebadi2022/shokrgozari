package ir.taravatgroup.shokrgozari;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static int _current_roz_tamrin = 0;
public static int _current_tamrin = 0;
public static int _current_book_content_id = 0;
public static String _daftar_shenase = "";
public static anywheresoftware.b4a.phone.Phone _phon = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.sql.SQL.ResultSetWrapper _res = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _chooser = null;
public static anywheresoftware.b4a.objects.Timer _tim_splash = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_all_tamrin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_dashboard = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_main = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_home = null;
public b4a.example3.customlistview _clv_tamrinat_tagvim = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.PanelWrapper _r1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _r2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _r3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _r4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _r5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _l3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _l4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _l5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz_lsv = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lsv_roz = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_lsv = null;
public static int _current_indexpage = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_splash = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview_dashboard = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_show_tamrin_roz = null;
public static int _this_day = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_circle = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_main3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_main2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_donate = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tajrobiat_activity _tajrobiat_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.daftar_ravabet_activity _daftar_ravabet_activity = null;
public ir.taravatgroup.shokrgozari.daftar_shokrgozari_activity _daftar_shokrgozari_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin22_activity _tamrin22_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.tamrin27_activity _tamrin27_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (tajrobiat_activity.mostCurrent != null);
vis = vis | (do_tamrin_roz_layout.mostCurrent != null);
vis = vis | (reagbook_activity.mostCurrent != null);
vis = vis | (download_activity.mostCurrent != null);
vis = vis | (book_activity.mostCurrent != null);
vis = vis | (daftar_activity.mostCurrent != null);
vis = vis | (daftar_khasteha_activity.mostCurrent != null);
vis = vis | (daftar_ravabet_activity.mostCurrent != null);
vis = vis | (daftar_shokrgozari_activity.mostCurrent != null);
vis = vis | (intro_activity.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
vis = vis | (tamrin_roz_activity.mostCurrent != null);
vis = vis | (tamrin13_activity.mostCurrent != null);
vis = vis | (tamrin14_activity.mostCurrent != null);
vis = vis | (tamrin16_activity.mostCurrent != null);
vis = vis | (tamrin19_activity.mostCurrent != null);
vis = vis | (tamrin22_activity.mostCurrent != null);
vis = vis | (tamrin25_activity.mostCurrent != null);
vis = vis | (tamrin27_activity.mostCurrent != null);
vis = vis | (tamrin3_activity.mostCurrent != null);
vis = vis | (tamrin8_activity.mostCurrent != null);
vis = vis | (tamrinat_activity.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _viewimg_splash = null;
anywheresoftware.b4a.objects.B4XViewWrapper _viewlbl1_splash = null;
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 71;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 73;BA.debugLine="tim_splash.Initialize(\"tim_splash\",2700)";
_tim_splash.Initialize(processBA,"tim_splash",(long) (2700));
 //BA.debugLineNum = 75;BA.debugLine="tim_splash.Enabled=True";
_tim_splash.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 77;BA.debugLine="Dim viewimg_splash As B4XView=ImageView1";
_viewimg_splash = new anywheresoftware.b4a.objects.B4XViewWrapper();
_viewimg_splash = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imageview1.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="viewimg_splash.SetVisibleAnimated(500,True)";
_viewimg_splash.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 79;BA.debugLine="viewimg_splash.SetLayoutAnimated(1000,viewimg_sp";
_viewimg_splash.SetLayoutAnimated((int) (1000),(int) (_viewimg_splash.getLeft()-40),(int) (_viewimg_splash.getTop()-40),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)));
 //BA.debugLineNum = 81;BA.debugLine="Dim viewlbl1_splash As B4XView=Label1";
_viewlbl1_splash = new anywheresoftware.b4a.objects.B4XViewWrapper();
_viewlbl1_splash = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._label1.getObject()));
 //BA.debugLineNum = 82;BA.debugLine="viewlbl1_splash.SetTextSizeAnimated(1000,30)";
_viewlbl1_splash.SetTextSizeAnimated((int) (1000),(float) (30));
 //BA.debugLineNum = 85;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 86;BA.debugLine="pan_main2.LoadLayout(\"all_tamrin_layout\")";
mostCurrent._pan_main2.LoadLayout("all_tamrin_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 87;BA.debugLine="pan_main3.LoadLayout(\"dashboard_layout\")";
mostCurrent._pan_main3.LoadLayout("dashboard_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 88;BA.debugLine="ScrollView_dashboard.Panel.LoadLayout(\"item_dashb";
mostCurrent._scrollview_dashboard.getPanel().LoadLayout("item_dashboard",mostCurrent.activityBA);
 //BA.debugLineNum = 89;BA.debugLine="fill_list_tamrinat";
_fill_list_tamrinat();
 //BA.debugLineNum = 91;BA.debugLine="pan_main2.Visible=False";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 92;BA.debugLine="pan_main3.Visible=False";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 94;BA.debugLine="btn_home_Click";
_btn_home_click();
 //BA.debugLineNum = 98;BA.debugLine="If(File.Exists(File.DirInternal,\"intro_pley\")=Fal";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"intro_pley")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 99;BA.debugLine="StartActivity(intro_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._intro_activity.getObject()));
 };
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static void  _activity_keypress(int _keycode) throws Exception{
ResumableSub_Activity_KeyPress rsub = new ResumableSub_Activity_KeyPress(null,_keycode);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_KeyPress extends BA.ResumableSub {
public ResumableSub_Activity_KeyPress(ir.taravatgroup.shokrgozari.main parent,int _keycode) {
this.parent = parent;
this._keycode = _keycode;
}
ir.taravatgroup.shokrgozari.main parent;
int _keycode;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 413;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (true) break;

case 1:
//if
this.state = 24;
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
this.state = 3;
}else {
this.state = 23;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 416;BA.debugLine="If(current_indexPage<>1)Then";
if (true) break;

case 4:
//if
this.state = 21;
if ((parent._current_indexpage!=1)) { 
this.state = 6;
}else {
this.state = 16;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 417;BA.debugLine="If(pan_all_lsv.Visible=True)Then";
if (true) break;

case 7:
//if
this.state = 14;
if ((parent.mostCurrent._pan_all_lsv.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
this.state = 9;
}else if((parent.mostCurrent._pan_all_donate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
this.state = 11;
}else {
this.state = 13;
}if (true) break;

case 9:
//C
this.state = 14;
 //BA.debugLineNum = 418;BA.debugLine="pan_all_lsv.Visible=False";
parent.mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 11:
//C
this.state = 14;
 //BA.debugLineNum = 420;BA.debugLine="pan_all_donate.Visible=False";
parent.mostCurrent._pan_all_donate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 422;BA.debugLine="btn_home_Click";
_btn_home_click();
 if (true) break;

case 14:
//C
this.state = 21;
;
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 427;BA.debugLine="Msgbox2Async(\"آیا از برنامه خارج میشوید!\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("آیا از برنامه خارج میشوید!"),BA.ObjectToCharSequence(""),"بله","نه","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 428;BA.debugLine="Wait For Msgbox_Result (result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 25;
return;
case 25:
//C
this.state = 17;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 429;BA.debugLine="If result = DialogResponse.POSITIVE Then";
if (true) break;

case 17:
//if
this.state = 20;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 430;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 if (true) break;

case 20:
//C
this.state = 21;
;
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 if (true) break;

case 24:
//C
this.state = -1;
;
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public static String  _btn_all_tamrin_click() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Private Sub btn_all_tamrin_Click";
 //BA.debugLineNum = 139;BA.debugLine="def_color_menu";
_def_color_menu();
 //BA.debugLineNum = 140;BA.debugLine="btn_all_tamrin.TextColor=0xFFFF4B4B";
mostCurrent._btn_all_tamrin.setTextColor(((int)0xffff4b4b));
 //BA.debugLineNum = 142;BA.debugLine="If(pan_all_lsv.Visible=True)Then";
if ((mostCurrent._pan_all_lsv.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 143;BA.debugLine="pan_all_lsv.Visible=False";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 147;BA.debugLine="pan_main2.Visible=True";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 149;BA.debugLine="pan_main2.SetLayoutAnimated(100,0,0,100%x,pan_mai";
mostCurrent._pan_main2.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 //BA.debugLineNum = 150;BA.debugLine="pan_main3.Visible=False";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 153;BA.debugLine="current_indexPage=2";
_current_indexpage = (int) (2);
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _btn_dashboard_click() throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Private Sub btn_dashboard_Click";
 //BA.debugLineNum = 161;BA.debugLine="def_color_menu";
_def_color_menu();
 //BA.debugLineNum = 162;BA.debugLine="btn_dashboard.TextColor=0xFFFF4B4B";
mostCurrent._btn_dashboard.setTextColor(((int)0xffff4b4b));
 //BA.debugLineNum = 164;BA.debugLine="pan_main3.Visible=True";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 166;BA.debugLine="pan_main3.SetLayoutAnimated(100,0,0,100%x,pan_mai";
mostCurrent._pan_main3.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 //BA.debugLineNum = 167;BA.debugLine="pan_main2.Visible=False";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 173;BA.debugLine="current_indexPage=0";
_current_indexpage = (int) (0);
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _btn_home_click() throws Exception{
int _i = 0;
 //BA.debugLineNum = 177;BA.debugLine="Private Sub btn_home_Click";
 //BA.debugLineNum = 179;BA.debugLine="def_color_menu";
_def_color_menu();
 //BA.debugLineNum = 180;BA.debugLine="btn_home.TextColor=0xFFFF4B4B";
mostCurrent._btn_home.setTextColor(((int)0xffff4b4b));
 //BA.debugLineNum = 183;BA.debugLine="If(current_indexPage=2)Then";
if ((_current_indexpage==2)) { 
 //BA.debugLineNum = 184;BA.debugLine="pan_main2.SetLayoutAnimated(100,100%x,0,100%x,pa";
mostCurrent._pan_main2.SetLayoutAnimated((int) (100),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 }else if((_current_indexpage==0)) { 
 //BA.debugLineNum = 186;BA.debugLine="pan_main3.SetLayoutAnimated(100,-(100%x),0,100%x";
mostCurrent._pan_main3.SetLayoutAnimated((int) (100),(int) (-(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA))),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 };
 //BA.debugLineNum = 190;BA.debugLine="current_indexPage=1";
_current_indexpage = (int) (1);
 //BA.debugLineNum = 195;BA.debugLine="For i=1 To 28";
{
final int step9 = 1;
final int limit9 = (int) (28);
_i = (int) (1) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 197;BA.debugLine="If(myFunc.get_State_tamrin1_byRoz(i).As(Int)<10)";
if (((mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,_i))<10)) { 
 //BA.debugLineNum = 198;BA.debugLine="this_day=i";
_this_day = _i;
 //BA.debugLineNum = 199;BA.debugLine="lbl_show_tamrin_roz.Text=i&\"/28\"";
mostCurrent._lbl_show_tamrin_roz.setText(BA.ObjectToCharSequence(BA.NumberToString(_i)+"/28"));
 //BA.debugLineNum = 200;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 202;BA.debugLine="this_day=29";
_this_day = (int) (29);
 //BA.debugLineNum = 203;BA.debugLine="lbl_show_tamrin_roz.TextSize=22";
mostCurrent._lbl_show_tamrin_roz.setTextSize((float) (22));
 //BA.debugLineNum = 204;BA.debugLine="lbl_show_tamrin_roz.Text=\"دفتر شکرگزاری\"";
mostCurrent._lbl_show_tamrin_roz.setText(BA.ObjectToCharSequence("دفتر شکرگزاری"));
 };
 }
};
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public static String  _chek_state(int _id_roz) throws Exception{
String _color_str = "";
int _code_state = 0;
 //BA.debugLineNum = 290;BA.debugLine="Sub chek_state (id_roz As Int) As String";
 //BA.debugLineNum = 291;BA.debugLine="Dim color_str As String=\"\"";
_color_str = "";
 //BA.debugLineNum = 292;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamrin1_";
_code_state = mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,_id_roz);
 //BA.debugLineNum = 294;BA.debugLine="If(code_state=10)Then";
if ((_code_state==10)) { 
 //BA.debugLineNum = 295;BA.debugLine="color_str=0xFF66DF64";
_color_str = BA.NumberToString(((int)0xff66df64));
 }else if((_code_state==0)) { 
 //BA.debugLineNum = 297;BA.debugLine="color_str=0xFF919191";
_color_str = BA.NumberToString(((int)0xff919191));
 }else {
 //BA.debugLineNum = 299;BA.debugLine="color_str=0xFFDFCE64";
_color_str = BA.NumberToString(((int)0xffdfce64));
 };
 //BA.debugLineNum = 302;BA.debugLine="Return color_str";
if (true) return _color_str;
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public static String  _def_color_menu() throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Sub def_color_menu";
 //BA.debugLineNum = 229;BA.debugLine="btn_home.TextColor=Colors.Gray";
mostCurrent._btn_home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 230;BA.debugLine="btn_all_tamrin.TextColor=Colors.Gray";
mostCurrent._btn_all_tamrin.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 231;BA.debugLine="btn_dashboard.TextColor=Colors.Gray";
mostCurrent._btn_dashboard.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_tamrinat() throws Exception{
int _counter_id = 0;
int _i = 0;
 //BA.debugLineNum = 235;BA.debugLine="Sub fill_list_tamrinat";
 //BA.debugLineNum = 236;BA.debugLine="Dim counter_id As Int=0";
_counter_id = (int) (0);
 //BA.debugLineNum = 237;BA.debugLine="For i=1 To 6";
{
final int step2 = 1;
final int limit2 = (int) (6);
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 239;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 241;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 80dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 //BA.debugLineNum = 242;BA.debugLine="p.LoadLayout(\"item_clv_tamrinat\")";
mostCurrent._p.LoadLayout("item_clv_tamrinat",mostCurrent.activityBA);
 //BA.debugLineNum = 245;BA.debugLine="clv_tamrinat_tagvim.Add(p,i)";
mostCurrent._clv_tamrinat_tagvim._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 247;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
 //BA.debugLineNum = 248;BA.debugLine="L1.Text=counter_id";
mostCurrent._l1.setText(BA.ObjectToCharSequence(_counter_id));
 //BA.debugLineNum = 249;BA.debugLine="r1.Tag=counter_id";
mostCurrent._r1.setTag((Object)(_counter_id));
 //BA.debugLineNum = 250;BA.debugLine="r1.Color=chek_state(counter_id)";
mostCurrent._r1.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
 //BA.debugLineNum = 252;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
 //BA.debugLineNum = 253;BA.debugLine="L2.Text=counter_id";
mostCurrent._l2.setText(BA.ObjectToCharSequence(_counter_id));
 //BA.debugLineNum = 254;BA.debugLine="r2.Tag=counter_id";
mostCurrent._r2.setTag((Object)(_counter_id));
 //BA.debugLineNum = 255;BA.debugLine="r2.Color=chek_state(counter_id)";
mostCurrent._r2.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
 //BA.debugLineNum = 257;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
 //BA.debugLineNum = 258;BA.debugLine="L3.Text=counter_id";
mostCurrent._l3.setText(BA.ObjectToCharSequence(_counter_id));
 //BA.debugLineNum = 259;BA.debugLine="r3.Tag=counter_id";
mostCurrent._r3.setTag((Object)(_counter_id));
 //BA.debugLineNum = 260;BA.debugLine="r3.Color=chek_state(counter_id)";
mostCurrent._r3.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
 //BA.debugLineNum = 262;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
 //BA.debugLineNum = 263;BA.debugLine="L4.Text=counter_id";
mostCurrent._l4.setText(BA.ObjectToCharSequence(_counter_id));
 //BA.debugLineNum = 264;BA.debugLine="r4.Tag=counter_id";
mostCurrent._r4.setTag((Object)(_counter_id));
 //BA.debugLineNum = 265;BA.debugLine="r4.Color=chek_state(counter_id)";
mostCurrent._r4.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
 //BA.debugLineNum = 267;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
 //BA.debugLineNum = 268;BA.debugLine="L5.Text=counter_id";
mostCurrent._l5.setText(BA.ObjectToCharSequence(_counter_id));
 //BA.debugLineNum = 269;BA.debugLine="r5.Tag=counter_id";
mostCurrent._r5.setTag((Object)(_counter_id));
 //BA.debugLineNum = 270;BA.debugLine="r5.Color=chek_state(counter_id)";
mostCurrent._r5.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
 //BA.debugLineNum = 272;BA.debugLine="If(i=6)Then";
if ((_i==6)) { 
 //BA.debugLineNum = 273;BA.debugLine="r4.Visible=False";
mostCurrent._r4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 274;BA.debugLine="r5.Visible=False";
mostCurrent._r5.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public static void  _get_tamrin1_for_lsv(int _id) throws Exception{
ResumableSub_get_tamrin1_for_lsv rsub = new ResumableSub_get_tamrin1_for_lsv(null,_id);
rsub.resume(processBA, null);
}
public static class ResumableSub_get_tamrin1_for_lsv extends BA.ResumableSub {
public ResumableSub_get_tamrin1_for_lsv(ir.taravatgroup.shokrgozari.main parent,int _id) {
this.parent = parent;
this._id = _id;
}
ir.taravatgroup.shokrgozari.main parent;
int _id;
adr.stringfunctions.stringfunctions _strfunc = null;
anywheresoftware.b4a.objects.collections.List _ls_tamrin1_roz = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_num = null;
int _result = 0;
int step13;
int limit13;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 307;BA.debugLine="lsv_roz.Clear";
parent.mostCurrent._lsv_roz.Clear();
 //BA.debugLineNum = 308;BA.debugLine="lsv_roz.TwoLinesLayout.Label.Width=90%x";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().Label.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 311;BA.debugLine="lsv_roz.TwoLinesLayout.ItemHeight=80dip";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 //BA.debugLineNum = 314;BA.debugLine="lsv_roz.TwoLinesLayout.Label.TextColor=0xFF009C74";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().Label.setTextColor(((int)0xff009c74));
 //BA.debugLineNum = 316;BA.debugLine="lsv_roz.TwoLinesLayout.SecondLabel.Width=90%x";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().SecondLabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 317;BA.debugLine="lsv_roz.TwoLinesLayout.SecondLabel.Height=50dip";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().SecondLabel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 319;BA.debugLine="lbl_roz_lsv.Text=\"روز \"&id";
parent.mostCurrent._lbl_roz_lsv.setText(BA.ObjectToCharSequence("روز "+BA.NumberToString(_id)));
 //BA.debugLineNum = 320;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 321;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
 //BA.debugLineNum = 324;BA.debugLine="Dim ls_tamrin1_Roz As List";
_ls_tamrin1_roz = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 325;BA.debugLine="ls_tamrin1_Roz.Initialize";
_ls_tamrin1_roz.Initialize();
 //BA.debugLineNum = 326;BA.debugLine="ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(id)";
_ls_tamrin1_roz = parent.mostCurrent._myfunc._get_tamrin1_byroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_id);
 //BA.debugLineNum = 328;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
if (true) break;

case 1:
//for
this.state = 8;
step13 = 1;
limit13 = (int) (_ls_tamrin1_roz.getSize()-1);
_i = (int) (0) ;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 8;
if ((step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13)) this.state = 3;
if (true) break;

case 17:
//C
this.state = 16;
_i = ((int)(0 + _i + step13)) ;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 330;BA.debugLine="Dim list_num As List";
_list_num = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 331;BA.debugLine="list_num.Initialize";
_list_num.Initialize();
 //BA.debugLineNum = 332;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
_list_num = _strfunc._vvvvvv5(BA.ObjectToString(_ls_tamrin1_roz.Get(_i)),"@");
 //BA.debugLineNum = 334;BA.debugLine="If(list_num.Get(2)<>\"null\"  And list_num.Get(2)<";
if (true) break;

case 4:
//if
this.state = 7;
if (((_list_num.Get((int) (2))).equals((Object)("null")) == false && (_list_num.Get((int) (2))).equals((Object)("")) == false)) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 336;BA.debugLine="lsv_roz.AddTwoLines((i+1)&\" : \"&list_num.Get(2)";
parent.mostCurrent._lsv_roz.AddTwoLines(BA.ObjectToCharSequence(BA.NumberToString((_i+1))+" : "+BA.ObjectToString(_list_num.Get((int) (2)))),BA.ObjectToCharSequence(_list_num.Get((int) (3))));
 if (true) break;

case 7:
//C
this.state = 17;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 342;BA.debugLine="If(lsv_roz.Size=0)Then";

case 8:
//if
this.state = 15;
if ((parent.mostCurrent._lsv_roz.getSize()==0)) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 344;BA.debugLine="lbl_back_lsv_Click";
_lbl_back_lsv_click();
 //BA.debugLineNum = 346;BA.debugLine="Msgbox2Async(\"اطلاعاتی ثبت نشده است!\", \"\", \"باشه";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("اطلاعاتی ثبت نشده است!"),BA.ObjectToCharSequence(""),"باشه","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 347;BA.debugLine="Wait For Msgbox_Result (result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 18;
return;
case 18:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 348;BA.debugLine="If result = DialogResponse.POSITIVE Then";
if (true) break;

case 11:
//if
this.state = 14;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = -1;
;
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 35;BA.debugLine="Private btn_all_tamrin As Button";
mostCurrent._btn_all_tamrin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private btn_dashboard As Button";
mostCurrent._btn_dashboard = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private pan_main As Panel";
mostCurrent._pan_main = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btn_home As Button";
mostCurrent._btn_home = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private clv_tamrinat_tagvim As CustomListView";
mostCurrent._clv_tamrinat_tagvim = new b4a.example3.customlistview();
 //BA.debugLineNum = 40;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 41;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private r1 As Panel";
mostCurrent._r1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private r2 As Panel";
mostCurrent._r2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private r3 As Panel";
mostCurrent._r3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private r4 As Panel";
mostCurrent._r4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private r5 As Panel";
mostCurrent._r5 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private L1 As Label";
mostCurrent._l1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private L2 As Label";
mostCurrent._l2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private L3 As Label";
mostCurrent._l3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private L4 As Label";
mostCurrent._l4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private L5 As Label";
mostCurrent._l5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_roz_lsv As Label";
mostCurrent._lbl_roz_lsv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private lsv_roz As ListView";
mostCurrent._lsv_roz = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private pan_all_lsv As Panel";
mostCurrent._pan_all_lsv = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Dim current_indexPage As Int=1";
_current_indexpage = (int) (1);
 //BA.debugLineNum = 57;BA.debugLine="Private pan_splash As Panel";
mostCurrent._pan_splash = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private ScrollView_dashboard As ScrollView";
mostCurrent._scrollview_dashboard = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private lbl_show_tamrin_roz As Label";
mostCurrent._lbl_show_tamrin_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Dim this_day As Int=0";
_this_day = (int) (0);
 //BA.debugLineNum = 63;BA.debugLine="Private pan_circle As Panel";
mostCurrent._pan_circle = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private pan_main3 As Panel";
mostCurrent._pan_main3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private pan_main2 As Panel";
mostCurrent._pan_main2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private pan_all_donate As Panel";
mostCurrent._pan_all_donate = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_lsv_click() throws Exception{
 //BA.debugLineNum = 404;BA.debugLine="Private Sub lbl_back_lsv_Click";
 //BA.debugLineNum = 405;BA.debugLine="pan_all_lsv.Visible=False";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 406;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_godonate_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
String _url = "";
 //BA.debugLineNum = 539;BA.debugLine="Private Sub lbl_goDonate_Click";
 //BA.debugLineNum = 540;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 541;BA.debugLine="Dim url As String=\"https://zarinp.al/taravatgroup";
_url = "https://zarinp.al/taravatgroup";
 //BA.debugLineNum = 542;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
_i.Initialize(_i.ACTION_VIEW,_url);
 //BA.debugLineNum = 543;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
 //BA.debugLineNum = 544;BA.debugLine="pan_all_donate_Click";
_pan_all_donate_click();
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_donate_click() throws Exception{
 //BA.debugLineNum = 547;BA.debugLine="Private Sub pan_all_donate_Click";
 //BA.debugLineNum = 548;BA.debugLine="pan_all_donate.Visible=False";
mostCurrent._pan_all_donate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 549;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lsv_click() throws Exception{
 //BA.debugLineNum = 400;BA.debugLine="Private Sub pan_all_lsv_Click";
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public static String  _pan_book_click() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Private Sub pan_book_Click";
 //BA.debugLineNum = 129;BA.debugLine="StartActivity(book_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._book_activity.getObject()));
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 469;BA.debugLine="Private Sub pan_comment_Click";
 //BA.debugLineNum = 470;BA.debugLine="Try";
try { //BA.debugLineNum = 471;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 472;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 473;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.shokrgo";
_url = "bazaar://details?id=ir.taravatgroup.shokrgozari";
 //BA.debugLineNum = 474;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 475;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 479;BA.debugLine="MsgboxAsync(\"1- اتصال اینترنت را بررسی کنید.\"&CR";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- اتصال اینترنت را بررسی کنید."+anywheresoftware.b4a.keywords.Common.CRLF+"2- برنامه بازار را نصب کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 //BA.debugLineNum = 480;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("11769483",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public static String  _pan_donate_click() throws Exception{
 //BA.debugLineNum = 497;BA.debugLine="Private Sub pan_donate_Click";
 //BA.debugLineNum = 498;BA.debugLine="pan_all_donate.Visible=True";
mostCurrent._pan_all_donate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 501;BA.debugLine="End Sub";
return "";
}
public static String  _pan_download_click() throws Exception{
 //BA.debugLineNum = 215;BA.debugLine="Private Sub pan_download_Click";
 //BA.debugLineNum = 216;BA.debugLine="StartActivity(download_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._download_activity.getObject()));
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString _str_matn = null;
 //BA.debugLineNum = 488;BA.debugLine="Private Sub pan_info_Click";
 //BA.debugLineNum = 489;BA.debugLine="Dim str_matn As RichString";
_str_matn = new anywheresoftware.b4a.agraham.richstring.RichStringBuilder.RichString();
 //BA.debugLineNum = 490;BA.debugLine="str_matn.Initialize(\"گروه برنامه نویسی طراوت\"&CRL";
_str_matn.Initialize(BA.ObjectToCharSequence("گروه برنامه نویسی طراوت"+anywheresoftware.b4a.keywords.Common.CRLF+"{bl}v1.0"+anywheresoftware.b4a.keywords.Common.CRLF+"1402-06{bl}"+anywheresoftware.b4a.keywords.Common.CRLF+"ایمیل ارتباطی :"+anywheresoftware.b4a.keywords.Common.CRLF+"{gr}m2ebadi1369@outlook.com{gr}"));
 //BA.debugLineNum = 491;BA.debugLine="str_matn.Color2(Colors.Blue,\"{bl}\")";
_str_matn.Color2(anywheresoftware.b4a.keywords.Common.Colors.Blue,"{bl}");
 //BA.debugLineNum = 492;BA.debugLine="str_matn.Color2(Colors.Magenta,\"{gr}\")";
_str_matn.Color2(anywheresoftware.b4a.keywords.Common.Colors.Magenta,"{gr}");
 //BA.debugLineNum = 494;BA.debugLine="Msgbox2Async(str_matn,\"درباره ما\",\"باشه\",\"\",\"\",Nu";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence(_str_matn.getObject()),BA.ObjectToCharSequence("درباره ما"),"باشه","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 495;BA.debugLine="End Sub";
return "";
}
public static String  _pan_othermyapps_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 450;BA.debugLine="Private Sub pan_otherMyApps_Click";
 //BA.debugLineNum = 451;BA.debugLine="Try";
try { //BA.debugLineNum = 452;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 453;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 454;BA.debugLine="url=\"bazaar://collection?slug=by_author&aid=4074";
_url = "bazaar://collection?slug=by_author&aid=407437645137";
 //BA.debugLineNum = 455;BA.debugLine="market.Initialize(market.ACTION_VIEW,url)";
_market.Initialize(_market.ACTION_VIEW,_url);
 //BA.debugLineNum = 456;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 460;BA.debugLine="MsgboxAsync(\"1- اتصال اینترنت را بررسی کنید.\"&CR";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- اتصال اینترنت را بررسی کنید."+anywheresoftware.b4a.keywords.Common.CRLF+"2- برنامه بازار را نصب کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 //BA.debugLineNum = 461;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("11703947",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 467;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Private Sub pan_setting_Click";
 //BA.debugLineNum = 221;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public static String  _pan_splash_click() throws Exception{
 //BA.debugLineNum = 446;BA.debugLine="Private Sub pan_splash_Click";
 //BA.debugLineNum = 448;BA.debugLine="End Sub";
return "";
}
public static String  _pan_tajrobiat_click() throws Exception{
int _result12 = 0;
 //BA.debugLineNum = 519;BA.debugLine="Private Sub pan_tajrobiat_Click";
 //BA.debugLineNum = 522;BA.debugLine="If(myFunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 524;BA.debugLine="StartActivity(tajrobiat_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tajrobiat_activity.getObject()));
 }else {
 //BA.debugLineNum = 527;BA.debugLine="Dim result12 As Int";
_result12 = 0;
 //BA.debugLineNum = 528;BA.debugLine="result12 = Msgbox2Async(\"اتصال اینترنت را بررسی";
_result12 = (int)(BA.ObjectToNumber(anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید"),BA.ObjectToCharSequence("توجه!"),"تلاش دوباره","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 530;BA.debugLine="If(result12=DialogResponse.POSITIVE)Then";
if ((_result12==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
 //BA.debugLineNum = 531;BA.debugLine="pan_tajrobiat_Click";
_pan_tajrobiat_click();
 };
 };
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public static String  _pan_tamrin_roz_click() throws Exception{
 //BA.debugLineNum = 503;BA.debugLine="Private Sub pan_tamrin_roz_Click";
 //BA.debugLineNum = 505;BA.debugLine="If(this_day=29)Then";
if ((_this_day==29)) { 
 //BA.debugLineNum = 507;BA.debugLine="StartActivity(daftar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._daftar_activity.getObject()));
 }else {
 //BA.debugLineNum = 510;BA.debugLine="current_roz_tamrin=this_day";
_current_roz_tamrin = _this_day;
 //BA.debugLineNum = 511;BA.debugLine="StartActivity(tamrin_roz_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin_roz_activity.getObject()));
 };
 //BA.debugLineNum = 516;BA.debugLine="End Sub";
return "";
}
public static String  _pan_tamrinat_click() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Private Sub pan_tamrinat_Click";
 //BA.debugLineNum = 125;BA.debugLine="StartActivity(tamrinat_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrinat_activity.getObject()));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _panel2_click() throws Exception{
 //BA.debugLineNum = 551;BA.debugLine="Private Sub Panel2_Click";
 //BA.debugLineNum = 553;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
myfunc._process_globals();
tajrobiat_activity._process_globals();
do_tamrin_roz_layout._process_globals();
reagbook_activity._process_globals();
download_activity._process_globals();
book_activity._process_globals();
daftar_activity._process_globals();
daftar_khasteha_activity._process_globals();
daftar_ravabet_activity._process_globals();
daftar_shokrgozari_activity._process_globals();
intro_activity._process_globals();
setting_activity._process_globals();
starter._process_globals();
tamrin_roz_activity._process_globals();
tamrin13_activity._process_globals();
tamrin14_activity._process_globals();
tamrin16_activity._process_globals();
tamrin19_activity._process_globals();
tamrin22_activity._process_globals();
tamrin25_activity._process_globals();
tamrin27_activity._process_globals();
tamrin3_activity._process_globals();
tamrin8_activity._process_globals();
tamrinat_activity._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim current_roz_tamrin As Int =0";
_current_roz_tamrin = (int) (0);
 //BA.debugLineNum = 19;BA.debugLine="Dim current_tamrin As Int =0";
_current_tamrin = (int) (0);
 //BA.debugLineNum = 20;BA.debugLine="Dim current_book_content_id As Int =0";
_current_book_content_id = (int) (0);
 //BA.debugLineNum = 21;BA.debugLine="Dim daftar_shenase As String=\"\"";
_daftar_shenase = "";
 //BA.debugLineNum = 23;BA.debugLine="Dim phon As Phone";
_phon = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 25;BA.debugLine="Dim sql As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 26;BA.debugLine="Dim res As ResultSet";
_res = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim Chooser As ContentChooser";
_chooser = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 29;BA.debugLine="Dim tim_splash As Timer";
_tim_splash = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _r1_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
 //BA.debugLineNum = 390;BA.debugLine="Private Sub r1_Click";
 //BA.debugLineNum = 392;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 394;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 395;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
 //BA.debugLineNum = 398;BA.debugLine="End Sub";
return "";
}
public static String  _r2_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
 //BA.debugLineNum = 383;BA.debugLine="Private Sub r2_Click";
 //BA.debugLineNum = 384;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 386;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 387;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public static String  _r3_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
 //BA.debugLineNum = 376;BA.debugLine="Private Sub r3_Click";
 //BA.debugLineNum = 377;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 379;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 380;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public static String  _r4_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
 //BA.debugLineNum = 367;BA.debugLine="Private Sub r4_Click";
 //BA.debugLineNum = 368;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 370;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 371;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public static String  _r5_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
 //BA.debugLineNum = 359;BA.debugLine="Private Sub r5_Click";
 //BA.debugLineNum = 360;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 362;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 363;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _tim_splash_tick() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Sub tim_splash_Tick";
 //BA.debugLineNum = 107;BA.debugLine="btn_home_Click";
_btn_home_click();
 //BA.debugLineNum = 108;BA.debugLine="pan_splash.Visible=False";
mostCurrent._pan_splash.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 109;BA.debugLine="tim_splash.Enabled=False";
_tim_splash.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
}
