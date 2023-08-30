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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (tamrin_roz_activity.mostCurrent != null);
vis = vis | (book_activity.mostCurrent != null);
vis = vis | (tamrinat_activity.mostCurrent != null);
vis = vis | (tamrin14_activity.mostCurrent != null);
vis = vis | (tamrin8_activity.mostCurrent != null);
vis = vis | (do_tamrin_roz_layout.mostCurrent != null);
vis = vis | (download_activity.mostCurrent != null);
vis = vis | (intro_activity.mostCurrent != null);
vis = vis | (reagbook_activity.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
vis = vis | (tamrin13_activity.mostCurrent != null);
vis = vis | (tamrin3_activity.mostCurrent != null);
vis = vis | (tamrin16_activity.mostCurrent != null);
vis = vis | (tamrin19_activity.mostCurrent != null);
vis = vis | (tamrin25_activity.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin_roz_activity.previousOne != null) {
				__a = tamrin_roz_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin_roz_activity.mostCurrent == null ? null : tamrin_roz_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (book_activity.previousOne != null) {
				__a = book_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(book_activity.mostCurrent == null ? null : book_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrinat_activity.previousOne != null) {
				__a = tamrinat_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrinat_activity.mostCurrent == null ? null : tamrinat_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin14_activity.previousOne != null) {
				__a = tamrin14_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin14_activity.mostCurrent == null ? null : tamrin14_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin8_activity.previousOne != null) {
				__a = tamrin8_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin8_activity.mostCurrent == null ? null : tamrin8_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (do_tamrin_roz_layout.previousOne != null) {
				__a = do_tamrin_roz_layout.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(do_tamrin_roz_layout.mostCurrent == null ? null : do_tamrin_roz_layout.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (download_activity.previousOne != null) {
				__a = download_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(download_activity.mostCurrent == null ? null : download_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (intro_activity.previousOne != null) {
				__a = intro_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(intro_activity.mostCurrent == null ? null : intro_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (reagbook_activity.previousOne != null) {
				__a = reagbook_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(reagbook_activity.mostCurrent == null ? null : reagbook_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (setting_activity.previousOne != null) {
				__a = setting_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(setting_activity.mostCurrent == null ? null : setting_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (tamrin13_activity.previousOne != null) {
				__a = tamrin13_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin13_activity.mostCurrent == null ? null : tamrin13_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin3_activity.previousOne != null) {
				__a = tamrin3_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin3_activity.mostCurrent == null ? null : tamrin3_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin16_activity.previousOne != null) {
				__a = tamrin16_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin16_activity.mostCurrent == null ? null : tamrin16_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin19_activity.previousOne != null) {
				__a = tamrin19_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin19_activity.mostCurrent == null ? null : tamrin19_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (tamrin25_activity.previousOne != null) {
				__a = tamrin25_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tamrin25_activity.mostCurrent == null ? null : tamrin25_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _current_roz_tamrin = 0;
public static int _current_tamrin = 0;
public static int _current_book_content_id = 0;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.sql.SQL.ResultSetWrapper _res = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.B4XViewWrapper _viewimg_splash = null;
anywheresoftware.b4a.objects.B4XViewWrapper _viewlbl1_splash = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="tim_splash.Initialize(\"tim_splash\",100)";
_tim_splash.Initialize(processBA,"tim_splash",(long) (100));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="tim_splash.Enabled=True";
_tim_splash.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="Dim viewimg_splash As B4XView=ImageView1";
_viewimg_splash = new anywheresoftware.b4a.objects.B4XViewWrapper();
_viewimg_splash = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imageview1.getObject()));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="viewimg_splash.SetVisibleAnimated(500,True)";
_viewimg_splash.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="viewimg_splash.SetLayoutAnimated(1000,viewimg_sp";
_viewimg_splash.SetLayoutAnimated((int) (1000),(int) (_viewimg_splash.getLeft()-40),(int) (_viewimg_splash.getTop()-40),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Dim viewlbl1_splash As B4XView=Label1";
_viewlbl1_splash = new anywheresoftware.b4a.objects.B4XViewWrapper();
_viewlbl1_splash = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._label1.getObject()));
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="viewlbl1_splash.SetTextSizeAnimated(1000,30)";
_viewlbl1_splash.SetTextSizeAnimated((int) (1000),(float) (30));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="pan_main2.LoadLayout(\"all_tamrin_layout\")";
mostCurrent._pan_main2.LoadLayout("all_tamrin_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="pan_main3.LoadLayout(\"dashboard_layout\")";
mostCurrent._pan_main3.LoadLayout("dashboard_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="ScrollView_dashboard.Panel.LoadLayout(\"item_dashb";
mostCurrent._scrollview_dashboard.getPanel().LoadLayout("item_dashboard",mostCurrent.activityBA);
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="fill_list_tamrinat";
_fill_list_tamrinat();
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="pan_main2.Visible=False";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="pan_main3.Visible=False";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="btn_home_Click";
_btn_home_click();
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="If(File.Exists(File.DirInternal,\"intro_pley\")=Fal";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"intro_pley")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="StartActivity(intro_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._intro_activity.getObject()));
 };
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_tamrinat() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_tamrinat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_tamrinat", null));}
int _counter_id = 0;
int _i = 0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub fill_list_tamrinat";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim counter_id As Int=0";
_counter_id = (int) (0);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="For i=1 To 6";
{
final int step2 = 1;
final int limit2 = (int) (6);
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 80dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="p.LoadLayout(\"item_clv_tamrinat\")";
mostCurrent._p.LoadLayout("item_clv_tamrinat",mostCurrent.activityBA);
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="clv_tamrinat_tagvim.Add(p,i)";
mostCurrent._clv_tamrinat_tagvim._add(mostCurrent._p,(Object)(_i));
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="L1.Text=counter_id";
mostCurrent._l1.setText(BA.ObjectToCharSequence(_counter_id));
RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="r1.Tag=counter_id";
mostCurrent._r1.setTag((Object)(_counter_id));
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="r1.Color=chek_state(counter_id)";
mostCurrent._r1.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="L2.Text=counter_id";
mostCurrent._l2.setText(BA.ObjectToCharSequence(_counter_id));
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="r2.Tag=counter_id";
mostCurrent._r2.setTag((Object)(_counter_id));
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="r2.Color=chek_state(counter_id)";
mostCurrent._r2.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
RDebugUtils.currentLine=917526;
 //BA.debugLineNum = 917526;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="L3.Text=counter_id";
mostCurrent._l3.setText(BA.ObjectToCharSequence(_counter_id));
RDebugUtils.currentLine=917528;
 //BA.debugLineNum = 917528;BA.debugLine="r3.Tag=counter_id";
mostCurrent._r3.setTag((Object)(_counter_id));
RDebugUtils.currentLine=917529;
 //BA.debugLineNum = 917529;BA.debugLine="r3.Color=chek_state(counter_id)";
mostCurrent._r3.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
RDebugUtils.currentLine=917531;
 //BA.debugLineNum = 917531;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
RDebugUtils.currentLine=917532;
 //BA.debugLineNum = 917532;BA.debugLine="L4.Text=counter_id";
mostCurrent._l4.setText(BA.ObjectToCharSequence(_counter_id));
RDebugUtils.currentLine=917533;
 //BA.debugLineNum = 917533;BA.debugLine="r4.Tag=counter_id";
mostCurrent._r4.setTag((Object)(_counter_id));
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="r4.Color=chek_state(counter_id)";
mostCurrent._r4.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
RDebugUtils.currentLine=917536;
 //BA.debugLineNum = 917536;BA.debugLine="counter_id=counter_id+1";
_counter_id = (int) (_counter_id+1);
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="L5.Text=counter_id";
mostCurrent._l5.setText(BA.ObjectToCharSequence(_counter_id));
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="r5.Tag=counter_id";
mostCurrent._r5.setTag((Object)(_counter_id));
RDebugUtils.currentLine=917539;
 //BA.debugLineNum = 917539;BA.debugLine="r5.Color=chek_state(counter_id)";
mostCurrent._r5.setColor((int)(Double.parseDouble(_chek_state(_counter_id))));
RDebugUtils.currentLine=917541;
 //BA.debugLineNum = 917541;BA.debugLine="If(i=6)Then";
if ((_i==6)) { 
RDebugUtils.currentLine=917542;
 //BA.debugLineNum = 917542;BA.debugLine="r4.Visible=False";
mostCurrent._r4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917543;
 //BA.debugLineNum = 917543;BA.debugLine="r5.Visible=False";
mostCurrent._r5.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=917556;
 //BA.debugLineNum = 917556;BA.debugLine="End Sub";
return "";
}
public static String  _btn_home_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_home_click", null));}
int _i = 0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub btn_home_Click";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="def_color_menu";
_def_color_menu();
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="btn_home.TextColor=0xFFFF4B4B";
mostCurrent._btn_home.setTextColor(((int)0xffff4b4b));
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="If(current_indexPage=2)Then";
if ((_current_indexpage==2)) { 
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="pan_main2.SetLayoutAnimated(100,100%x,0,100%x,pa";
mostCurrent._pan_main2.SetLayoutAnimated((int) (100),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 }else 
{RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="Else If (current_indexPage=0) Then";
if ((_current_indexpage==0)) { 
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="pan_main3.SetLayoutAnimated(100,-(100%x),0,100%x";
mostCurrent._pan_main3.SetLayoutAnimated((int) (100),(int) (-(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA))),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
 }}
;
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="current_indexPage=1";
_current_indexpage = (int) (1);
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="For i=1 To 28";
{
final int step9 = 1;
final int limit9 = (int) (28);
_i = (int) (1) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="If(myFunc.get_State_tamrin1_byRoz(i).As(Int)<10)";
if (((mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,_i))<10)) { 
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="this_day=i";
_this_day = _i;
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="lbl_show_tamrin_roz.Text=i&\"/28\"";
mostCurrent._lbl_show_tamrin_roz.setText(BA.ObjectToCharSequence(BA.NumberToString(_i)+"/28"));
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=655390;
 //BA.debugLineNum = 655390;BA.debugLine="End Sub";
return "";
}
public static void  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}); return;}
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
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (true) break;

case 1:
//if
this.state = 16;
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
this.state = 3;
}else {
this.state = 15;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="If(current_indexPage<>1)Then";
if (true) break;

case 4:
//if
this.state = 13;
if ((parent._current_indexpage!=1)) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="btn_home_Click";
_btn_home_click();
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="Msgbox2Async(\"آیا از برنامه خارج میشوید!\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("آیا از برنامه خارج میشوید!"),BA.ObjectToCharSequence(""),"بله","نه","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="Wait For Msgbox_Result (result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "activity_keypress"), null);
this.state = 17;
return;
case 17:
//C
this.state = 9;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="If result = DialogResponse.POSITIVE Then";
if (true) break;

case 9:
//if
this.state = 12;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 if (true) break;

case 12:
//C
this.state = 13;
;
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
 if (true) break;

case 16:
//C
this.state = -1;
;
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _btn_all_tamrin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_all_tamrin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_all_tamrin_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub btn_all_tamrin_Click";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="def_color_menu";
_def_color_menu();
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="btn_all_tamrin.TextColor=0xFFFF4B4B";
mostCurrent._btn_all_tamrin.setTextColor(((int)0xffff4b4b));
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="If(pan_all_lsv.Visible=True)Then";
if ((mostCurrent._pan_all_lsv.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="pan_all_lsv.Visible=False";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="pan_main2.Visible=True";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="pan_main2.SetLayoutAnimated(100,0,0,100%x,pan_mai";
mostCurrent._pan_main2.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="pan_main3.Visible=False";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="current_indexPage=2";
_current_indexpage = (int) (2);
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="End Sub";
return "";
}
public static String  _def_color_menu() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "def_color_menu", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "def_color_menu", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub def_color_menu";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="btn_home.TextColor=Colors.Gray";
mostCurrent._btn_home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="btn_all_tamrin.TextColor=Colors.Gray";
mostCurrent._btn_all_tamrin.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="btn_dashboard.TextColor=Colors.Gray";
mostCurrent._btn_dashboard.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="End Sub";
return "";
}
public static String  _btn_dashboard_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_dashboard_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_dashboard_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub btn_dashboard_Click";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="def_color_menu";
_def_color_menu();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="btn_dashboard.TextColor=0xFFFF4B4B";
mostCurrent._btn_dashboard.setTextColor(((int)0xffff4b4b));
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="pan_main3.Visible=True";
mostCurrent._pan_main3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="pan_main3.SetLayoutAnimated(100,0,0,100%x,pan_mai";
mostCurrent._pan_main3.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),mostCurrent._pan_main3.getHeight());
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="pan_main2.Visible=False";
mostCurrent._pan_main2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="current_indexPage=0";
_current_indexpage = (int) (0);
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="End Sub";
return "";
}
public static String  _chek_state(int _id_roz) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_state", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_state", new Object[] {_id_roz}));}
String _color_str = "";
int _code_state = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub chek_state (id_roz As Int) As String";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim color_str As String=\"\"";
_color_str = "";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamrin1_";
_code_state = mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,_id_roz);
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="If(code_state=10)Then";
if ((_code_state==10)) { 
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="color_str=0xFF66DF64";
_color_str = BA.NumberToString(((int)0xff66df64));
 }else 
{RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Else If(code_state = 0 )Then";
if ((_code_state==0)) { 
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="color_str=0xFF919191";
_color_str = BA.NumberToString(((int)0xff919191));
 }else {
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="color_str=0xFFDFCE64";
_color_str = BA.NumberToString(((int)0xffdfce64));
 }}
;
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="Return color_str";
if (true) return _color_str;
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="End Sub";
return "";
}
public static void  _get_tamrin1_for_lsv(int _id) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_tamrin1_for_lsv", false))
	 {Debug.delegate(mostCurrent.activityBA, "get_tamrin1_for_lsv", new Object[] {_id}); return;}
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
int step11;
int limit11;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="lsv_roz.Clear";
parent.mostCurrent._lsv_roz.Clear();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="lsv_roz.TwoLinesLayout.Label.Width=90%x";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().Label.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="lsv_roz.TwoLinesLayout.Label.TextColor=Colors.Gre";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="lsv_roz.TwoLinesLayout.SecondLabel.Width=90%x";
parent.mostCurrent._lsv_roz.getTwoLinesLayout().SecondLabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="lbl_roz_lsv.Text=\"روز \"&id";
parent.mostCurrent._lbl_roz_lsv.setText(BA.ObjectToCharSequence("روز "+BA.NumberToString(_id)));
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="Dim ls_tamrin1_Roz As List";
_ls_tamrin1_roz = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="ls_tamrin1_Roz.Initialize";
_ls_tamrin1_roz.Initialize();
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(id)";
_ls_tamrin1_roz = parent.mostCurrent._myfunc._get_tamrin1_byroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_id);
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
if (true) break;

case 1:
//for
this.state = 8;
step11 = 1;
limit11 = (int) (_ls_tamrin1_roz.getSize()-1);
_i = (int) (0) ;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 8;
if ((step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11)) this.state = 3;
if (true) break;

case 17:
//C
this.state = 16;
_i = ((int)(0 + _i + step11)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="Dim list_num As List";
_list_num = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="list_num.Initialize";
_list_num.Initialize();
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
_list_num = _strfunc._vvvvvv5(BA.ObjectToString(_ls_tamrin1_roz.Get(_i)),"@");
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="If(list_num.Get(2)<>\"null\"  And list_num.Get(2)<";
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
RDebugUtils.currentLine=1048600;
 //BA.debugLineNum = 1048600;BA.debugLine="lsv_roz.AddTwoLines((i+1)&\" : \"&list_num.Get(2)";
parent.mostCurrent._lsv_roz.AddTwoLines(BA.ObjectToCharSequence(BA.NumberToString((_i+1))+" : "+BA.ObjectToString(_list_num.Get((int) (2)))),BA.ObjectToCharSequence(_list_num.Get((int) (3))));
 if (true) break;

case 7:
//C
this.state = 17;
;
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=1048605;
 //BA.debugLineNum = 1048605;BA.debugLine="If(lsv_roz.Size=0)Then";

case 8:
//if
this.state = 15;
if ((parent.mostCurrent._lsv_roz.getSize()==0)) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="lbl_back_lsv_Click";
_lbl_back_lsv_click();
RDebugUtils.currentLine=1048609;
 //BA.debugLineNum = 1048609;BA.debugLine="Msgbox2Async(\"اطلاعاتی ثبت نشده است!\", \"\", \"باشه";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("اطلاعاتی ثبت نشده است!"),BA.ObjectToCharSequence(""),"باشه","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048610;
 //BA.debugLineNum = 1048610;BA.debugLine="Wait For Msgbox_Result (result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "get_tamrin1_for_lsv"), null);
this.state = 18;
return;
case 18:
//C
this.state = 11;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=1048611;
 //BA.debugLineNum = 1048611;BA.debugLine="If result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=1048620;
 //BA.debugLineNum = 1048620;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lbl_back_lsv_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_lsv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_lsv_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub lbl_back_lsv_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="pan_all_lsv.Visible=False";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lsv_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_lsv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_lsv_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub pan_all_lsv_Click";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _pan_book_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_book_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_book_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub pan_book_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="StartActivity(book_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._book_activity.getObject()));
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_comment_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_comment_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub pan_comment_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Try";
try {RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafeka";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=1769482;
 //BA.debugLineNum = 1769482;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("41769482",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=1769488;
 //BA.debugLineNum = 1769488;BA.debugLine="End Sub";
return "";
}
public static String  _pan_donate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_donate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_donate_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
String _url = "";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub pan_donate_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim url As String=\"https://zarinp.al/taravatgroup";
_url = "https://zarinp.al/taravatgroup";
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
_i.Initialize(_i.ACTION_VIEW,_url);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="End Sub";
return "";
}
public static String  _pan_download_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_download_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_download_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub pan_download_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="StartActivity(download_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._download_activity.getObject()));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_info_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub pan_info_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Msgbox(\"گروه برنامه نویسی طراوت\"&CRLF&\"v1.0\"&CRLF";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("گروه برنامه نویسی طراوت"+anywheresoftware.b4a.keywords.Common.CRLF+"v1.0"+anywheresoftware.b4a.keywords.Common.CRLF+"1402-05"),BA.ObjectToCharSequence("درباره ما"),mostCurrent.activityBA);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _pan_othermyapps_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_othermyapps_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_othermyapps_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub pan_otherMyApps_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="url=\"bazaar://collection?slug=by_author&aid=4074";
_url = "bazaar://collection?slug=by_author&aid=407437645137";
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="market.Initialize(market.ACTION_VIEW,url)";
_market.Initialize(_market.ACTION_VIEW,_url);
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("41703946",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub pan_setting_Click";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="End Sub";
return "";
}
public static String  _pan_splash_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_splash_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_splash_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub pan_splash_Click";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static String  _pan_tamrin_roz_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_tamrin_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_tamrin_roz_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub pan_tamrin_roz_Click";
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="current_roz_tamrin=this_day";
_current_roz_tamrin = _this_day;
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="StartActivity(tamrin_roz_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin_roz_activity.getObject()));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="End Sub";
return "";
}
public static String  _pan_tamrinat_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_tamrinat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_tamrinat_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub pan_tamrinat_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="StartActivity(tamrinat_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrinat_activity.getObject()));
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _r1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r1_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub r1_Click";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="End Sub";
return "";
}
public static String  _r2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r2_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub r2_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="End Sub";
return "";
}
public static String  _r3_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r3_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub r3_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="End Sub";
return "";
}
public static String  _r4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r4_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub r4_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="End Sub";
return "";
}
public static String  _r5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r5_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _pan_r = null;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub r5_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim pan_r As Panel=Sender";
_pan_r = new anywheresoftware.b4a.objects.PanelWrapper();
_pan_r = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="pan_all_lsv.Visible=True";
mostCurrent._pan_all_lsv.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="get_tamrin1_for_lsv(pan_r.Tag)";
_get_tamrin1_for_lsv((int)(BA.ObjectToNumber(_pan_r.getTag())));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="End Sub";
return "";
}
public static String  _tim_splash_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_splash_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_splash_tick", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub tim_splash_Tick";
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="btn_home_Click";
_btn_home_click();
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="pan_splash.Visible=False";
mostCurrent._pan_splash.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="tim_splash.Enabled=False";
_tim_splash.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="End Sub";
return "";
}
}