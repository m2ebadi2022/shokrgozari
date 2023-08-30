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

public class intro_activity extends Activity implements B4AActivity{
	public static intro_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.intro_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (intro_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.intro_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.intro_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (intro_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (intro_activity) Resume **");
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
		return intro_activity.class;
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
            BA.LogInfo("** Activity (intro_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (intro_activity) Pause event (activity is not paused). **");
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
            intro_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (intro_activity) Resume **");
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
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public static float _startx = 0f;
public static float _starty = 0f;
public static int _current_page = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel4 = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
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
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="Activity.LoadLayout(\"intro_layout\")";
mostCurrent._activity.LoadLayout("intro_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=10158085;
 //BA.debugLineNum = 10158085;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=10878980;
 //BA.debugLineNum = 10878980;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=10878982;
 //BA.debugLineNum = 10878982;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="intro_activity";
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="End Sub";
return "";
}
public static String  _activity_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_UP)) {
case 0: {
RDebugUtils.currentLine=10223619;
 //BA.debugLineNum = 10223619;BA.debugLine="startX = X";
_startx = _x;
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="startY = Y";
_starty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=10223622;
 //BA.debugLineNum = 10223622;BA.debugLine="If Abs(y - startY) > 20%y Then Return";
if (anywheresoftware.b4a.keywords.Common.Abs(_y-_starty)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)) { 
if (true) return "";};
RDebugUtils.currentLine=10223623;
 //BA.debugLineNum = 10223623;BA.debugLine="If X - startX > 30%x   Then";
if (_x-_startx>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
RDebugUtils.currentLine=10223624;
 //BA.debugLineNum = 10223624;BA.debugLine="previos_btn";
_previos_btn();
 }else 
{RDebugUtils.currentLine=10223625;
 //BA.debugLineNum = 10223625;BA.debugLine="Else If startX - x > 30%x  Then";
if (_startx-_x>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
RDebugUtils.currentLine=10223626;
 //BA.debugLineNum = 10223626;BA.debugLine="next_btn";
_next_btn();
 }}
;
 break; }
}
;
RDebugUtils.currentLine=10223630;
 //BA.debugLineNum = 10223630;BA.debugLine="End Sub";
return "";
}
public static String  _previos_btn() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "previos_btn", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "previos_btn", null));}
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Sub previos_btn";
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="current_page=current_page-1";
_current_page = (int) (_current_page-1);
RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="If(current_page=-1)Then";
if ((_current_page==-1)) { 
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="current_page=0";
_current_page = (int) (0);
 };
RDebugUtils.currentLine=10485767;
 //BA.debugLineNum = 10485767;BA.debugLine="show_only_page(current_page)";
_show_only_page(_current_page);
RDebugUtils.currentLine=10485770;
 //BA.debugLineNum = 10485770;BA.debugLine="End Sub";
return "";
}
public static String  _next_btn() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "next_btn", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "next_btn", null));}
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Sub next_btn";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="current_page=current_page+1";
_current_page = (int) (_current_page+1);
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="If(current_page=4)Then";
if ((_current_page==4)) { 
RDebugUtils.currentLine=10420227;
 //BA.debugLineNum = 10420227;BA.debugLine="current_page=4";
_current_page = (int) (4);
RDebugUtils.currentLine=10420228;
 //BA.debugLineNum = 10420228;BA.debugLine="lbl_next4_Click";
_lbl_next4_click();
 };
RDebugUtils.currentLine=10420232;
 //BA.debugLineNum = 10420232;BA.debugLine="show_only_page(current_page)";
_show_only_page(_current_page);
RDebugUtils.currentLine=10420235;
 //BA.debugLineNum = 10420235;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next1_click() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next1_click", null));}
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Private Sub lbl_next1_Click";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="next_btn";
_next_btn();
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next2_click() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next2_click", null));}
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Private Sub lbl_next2_Click";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="next_btn";
_next_btn();
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next3_click() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next3_click", null));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Private Sub lbl_next3_Click";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="next_btn";
_next_btn();
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next4_click() throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next4_click", null));}
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Private Sub lbl_next4_Click";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="File.WriteString(File.DirInternal,\"intro_pley\",\"1";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"intro_pley","1");
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10747907;
 //BA.debugLineNum = 10747907;BA.debugLine="End Sub";
return "";
}
public static String  _show_only_page(int _pageid) throws Exception{
RDebugUtils.currentModule="intro_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_only_page", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_only_page", new Object[] {_pageid}));}
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Sub show_only_page(pageID As Int)";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="Panel2.Visible=False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551299;
 //BA.debugLineNum = 10551299;BA.debugLine="Panel3.Visible=False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="Select pageID";
switch (_pageid) {
case 0: {
RDebugUtils.currentLine=10551302;
 //BA.debugLineNum = 10551302;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10551303;
 //BA.debugLineNum = 10551303;BA.debugLine="Panel2.Visible=False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551304;
 //BA.debugLineNum = 10551304;BA.debugLine="Panel3.Visible=False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551305;
 //BA.debugLineNum = 10551305;BA.debugLine="Panel4.Visible=False";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 1: {
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551308;
 //BA.debugLineNum = 10551308;BA.debugLine="Panel2.Visible=True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10551309;
 //BA.debugLineNum = 10551309;BA.debugLine="Panel3.Visible=False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551310;
 //BA.debugLineNum = 10551310;BA.debugLine="Panel4.Visible=False";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 2: {
RDebugUtils.currentLine=10551313;
 //BA.debugLineNum = 10551313;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551314;
 //BA.debugLineNum = 10551314;BA.debugLine="Panel2.Visible=False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551315;
 //BA.debugLineNum = 10551315;BA.debugLine="Panel3.Visible=True";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10551316;
 //BA.debugLineNum = 10551316;BA.debugLine="Panel4.Visible=False";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 3: {
RDebugUtils.currentLine=10551318;
 //BA.debugLineNum = 10551318;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551319;
 //BA.debugLineNum = 10551319;BA.debugLine="Panel2.Visible=False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551320;
 //BA.debugLineNum = 10551320;BA.debugLine="Panel3.Visible=False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551321;
 //BA.debugLineNum = 10551321;BA.debugLine="Panel4.Visible=True";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.True);
 break; }
}
;
RDebugUtils.currentLine=10551325;
 //BA.debugLineNum = 10551325;BA.debugLine="End Sub";
return "";
}
}