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

public class setting_activity extends Activity implements B4AActivity{
	public static setting_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.setting_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (setting_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.setting_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.setting_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (setting_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (setting_activity) Resume **");
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
		return setting_activity.class;
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
            BA.LogInfo("** Activity (setting_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (setting_activity) Pause event (activity is not paused). **");
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
            setting_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (setting_activity) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pan_off1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_on1 = null;
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
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _darkmod = 0;
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=11796485;
 //BA.debugLineNum = 11796485;BA.debugLine="If(File.Exists(File.DirInternal,\"darkmod.txt\"))Th";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt"))) { 
RDebugUtils.currentLine=11796486;
 //BA.debugLineNum = 11796486;BA.debugLine="Dim darkmod As Int = File.ReadString(File.DirInt";
_darkmod = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt")));
RDebugUtils.currentLine=11796487;
 //BA.debugLineNum = 11796487;BA.debugLine="If(darkmod=0)Then";
if ((_darkmod==0)) { 
RDebugUtils.currentLine=11796489;
 //BA.debugLineNum = 11796489;BA.debugLine="pan_off1.Visible=True";
mostCurrent._pan_off1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11796490;
 //BA.debugLineNum = 11796490;BA.debugLine="pan_on1.Visible=False";
mostCurrent._pan_on1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=11796493;
 //BA.debugLineNum = 11796493;BA.debugLine="pan_off1.Visible=False";
mostCurrent._pan_off1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=11796494;
 //BA.debugLineNum = 11796494;BA.debugLine="pan_on1.Visible=True";
mostCurrent._pan_on1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=11796498;
 //BA.debugLineNum = 11796498;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt","0");
RDebugUtils.currentLine=11796500;
 //BA.debugLineNum = 11796500;BA.debugLine="pan_off1.Visible=True";
mostCurrent._pan_off1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11796501;
 //BA.debugLineNum = 11796501;BA.debugLine="pan_on1.Visible=False";
mostCurrent._pan_on1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=11796505;
 //BA.debugLineNum = 11796505;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=12255232;
 //BA.debugLineNum = 12255232;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=12255233;
 //BA.debugLineNum = 12255233;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=12255234;
 //BA.debugLineNum = 12255234;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=12255235;
 //BA.debugLineNum = 12255235;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=12255237;
 //BA.debugLineNum = 12255237;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=12255239;
 //BA.debugLineNum = 12255239;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=12189696;
 //BA.debugLineNum = 12189696;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=12189697;
 //BA.debugLineNum = 12189697;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=12189698;
 //BA.debugLineNum = 12189698;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_activity";
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darkmod_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_darkmod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_darkmod_click", null));}
RDebugUtils.currentLine=11993088;
 //BA.debugLineNum = 11993088;BA.debugLine="Private Sub pan_darkMod_Click";
RDebugUtils.currentLine=11993090;
 //BA.debugLineNum = 11993090;BA.debugLine="If(pan_on1.Visible=False)Then";
if ((mostCurrent._pan_on1.getVisible()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=11993092;
 //BA.debugLineNum = 11993092;BA.debugLine="pan_off1.Visible=False";
mostCurrent._pan_off1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=11993093;
 //BA.debugLineNum = 11993093;BA.debugLine="pan_on1.Visible=True";
mostCurrent._pan_on1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11993095;
 //BA.debugLineNum = 11993095;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt","1");
 }else {
RDebugUtils.currentLine=11993098;
 //BA.debugLineNum = 11993098;BA.debugLine="pan_on1.Visible=False";
mostCurrent._pan_on1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=11993099;
 //BA.debugLineNum = 11993099;BA.debugLine="pan_off1.Visible=True";
mostCurrent._pan_off1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11993100;
 //BA.debugLineNum = 11993100;BA.debugLine="File.WriteString(File.DirInternal,\"darkmod.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt","0");
 };
RDebugUtils.currentLine=11993104;
 //BA.debugLineNum = 11993104;BA.debugLine="End Sub";
return "";
}
public static void  _pan_remove_allsounds_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_remove_allsounds_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "pan_remove_allsounds_click", null); return;}
ResumableSub_pan_remove_allSounds_Click rsub = new ResumableSub_pan_remove_allSounds_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_pan_remove_allSounds_Click extends BA.ResumableSub {
public ResumableSub_pan_remove_allSounds_Click(ir.taravatgroup.shokrgozari.setting_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.setting_activity parent;
int _result = 0;
anywheresoftware.b4a.objects.collections.List _ls_removeall = null;
int _i = 0;
int step7;
int limit7;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="setting_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=12124162;
 //BA.debugLineNum = 12124162;BA.debugLine="Msgbox2Async(\"آیا همه فایلهای صوتی دانلود شده حذف";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("آیا همه فایلهای صوتی دانلود شده حذف شوند؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=12124163;
 //BA.debugLineNum = 12124163;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "setting_activity", "pan_remove_allsounds_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=12124164;
 //BA.debugLineNum = 12124164;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 12;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=12124166;
 //BA.debugLineNum = 12124166;BA.debugLine="Dim ls_removeAll As List";
_ls_removeall = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12124167;
 //BA.debugLineNum = 12124167;BA.debugLine="ls_removeAll.Initialize";
_ls_removeall.Initialize();
RDebugUtils.currentLine=12124168;
 //BA.debugLineNum = 12124168;BA.debugLine="ls_removeAll=myFunc.get_removeAll_list";
_ls_removeall = parent.mostCurrent._myfunc._get_removeall_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=12124170;
 //BA.debugLineNum = 12124170;BA.debugLine="For i=0 To ls_removeAll.Size-1";
if (true) break;

case 4:
//for
this.state = 11;
step7 = 1;
limit7 = (int) (_ls_removeall.getSize()-1);
_i = (int) (0) ;
this.state = 14;
if (true) break;

case 14:
//C
this.state = 11;
if ((step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7)) this.state = 6;
if (true) break;

case 15:
//C
this.state = 14;
_i = ((int)(0 + _i + step7)) ;
if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=12124171;
 //BA.debugLineNum = 12124171;BA.debugLine="If(File.Exists(File.DirInternal,ls_removeAll.Get";
if (true) break;

case 7:
//if
this.state = 10;
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_ls_removeall.Get(_i))))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=12124172;
 //BA.debugLineNum = 12124172;BA.debugLine="File.Delete(File.DirInternal,ls_removeAll.Get(i";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_ls_removeall.Get(_i)));
 if (true) break;

case 10:
//C
this.state = 15;
;
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
;
RDebugUtils.currentLine=12124175;
 //BA.debugLineNum = 12124175;BA.debugLine="ToastMessageShow(\"حذف شدند.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شدند."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=12124184;
 //BA.debugLineNum = 12124184;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _pan_remove_alltamrinat_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_remove_alltamrinat_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "pan_remove_alltamrinat_click", null); return;}
ResumableSub_pan_remove_AllTamrinat_Click rsub = new ResumableSub_pan_remove_AllTamrinat_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_pan_remove_AllTamrinat_Click extends BA.ResumableSub {
public ResumableSub_pan_remove_AllTamrinat_Click(ir.taravatgroup.shokrgozari.setting_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.setting_activity parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="setting_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=12058626;
 //BA.debugLineNum = 12058626;BA.debugLine="Msgbox2Async(\"آیا همه تمرینات من حذف شوند؟\", \"حذف";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("آیا همه تمرینات من حذف شوند؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=12058627;
 //BA.debugLineNum = 12058627;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "setting_activity", "pan_remove_alltamrinat_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=12058628;
 //BA.debugLineNum = 12058628;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=12058629;
 //BA.debugLineNum = 12058629;BA.debugLine="myFunc.removeAll_tamrinat";
parent.mostCurrent._myfunc._removeall_tamrinat /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=12058630;
 //BA.debugLineNum = 12058630;BA.debugLine="ToastMessageShow(\"حذف شدند.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شدند."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=12058635;
 //BA.debugLineNum = 12058635;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}