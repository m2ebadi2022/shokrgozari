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

public class tamrin22_activity extends Activity implements B4AActivity{
	public static tamrin22_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin22_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrin22_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin22_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrin22_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrin22_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrin22_activity) Resume **");
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
		return tamrin22_activity.class;
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
            BA.LogInfo("** Activity (tamrin22_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrin22_activity) Pause event (activity is not paused). **");
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
            tamrin22_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrin22_activity) Resume **");
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_title1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_title2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_title3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_etefag1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_etefag2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_etefag3 = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.tamrin27_activity _tamrin27_activity = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_content = null;
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"tamrin22_layout\")";
mostCurrent._activity.LoadLayout("tamrin22_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="ScrollView1.Panel.LoadLayout(\"item_tamrin22\")";
mostCurrent._scrollview1.getPanel().LoadLayout("item_tamrin22",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="et_matn1.Color=0x00FF0000";
mostCurrent._et_matn1.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 35;BA.debugLine="et_matn2.Color=0x00FF0000";
mostCurrent._et_matn2.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 36;BA.debugLine="et_matn3.Color=0x00FF0000";
mostCurrent._et_matn3.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 38;BA.debugLine="et_title1.Color=0x00FF0000";
mostCurrent._et_title1.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 39;BA.debugLine="et_title2.Color=0x00FF0000";
mostCurrent._et_title2.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 40;BA.debugLine="et_title3.Color=0x00FF0000";
mostCurrent._et_title3.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 42;BA.debugLine="et_etefag1.Color=0x00FF0000";
mostCurrent._et_etefag1.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 43;BA.debugLine="et_etefag2.Color=0x00FF0000";
mostCurrent._et_etefag2.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 44;BA.debugLine="et_etefag3.Color=0x00FF0000";
mostCurrent._et_etefag3.setColor(((int)0x00ff0000));
 //BA.debugLineNum = 46;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 47;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
 //BA.debugLineNum = 48;BA.debugLine="ls_content=myFunc.get_tamrinat_saved(Main.current";
_ls_content = mostCurrent._myfunc._get_tamrinat_saved /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ );
 //BA.debugLineNum = 52;BA.debugLine="et_title1.text=ls_content.Get(0)";
mostCurrent._et_title1.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (0))));
 //BA.debugLineNum = 53;BA.debugLine="et_title2.text=ls_content.Get(1)";
mostCurrent._et_title2.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (1))));
 //BA.debugLineNum = 54;BA.debugLine="et_title3.text=ls_content.Get(2)";
mostCurrent._et_title3.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (2))));
 //BA.debugLineNum = 56;BA.debugLine="et_matn1.text=ls_content.Get(3)";
mostCurrent._et_matn1.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (3))));
 //BA.debugLineNum = 57;BA.debugLine="et_matn2.text=ls_content.Get(4)";
mostCurrent._et_matn2.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (4))));
 //BA.debugLineNum = 58;BA.debugLine="et_matn3.text=ls_content.Get(5)";
mostCurrent._et_matn3.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (5))));
 //BA.debugLineNum = 60;BA.debugLine="et_etefag1.text=ls_content.Get(6)";
mostCurrent._et_etefag1.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (6))));
 //BA.debugLineNum = 61;BA.debugLine="et_etefag2.text=ls_content.Get(7)";
mostCurrent._et_etefag2.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (7))));
 //BA.debugLineNum = 62;BA.debugLine="et_etefag3.text=ls_content.Get(8)";
mostCurrent._et_etefag3.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (8))));
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 88;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 90;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 92;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 94;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _et_etefag1_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub et_etefag1_TextChanged (Old As String,";
 //BA.debugLineNum = 108;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (7),_new,(int) (1));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _et_etefag2_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Private Sub et_etefag2_TextChanged (Old As String,";
 //BA.debugLineNum = 104;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (8),_new,(int) (1));
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _et_etefag3_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Private Sub et_etefag3_TextChanged (Old As String,";
 //BA.debugLineNum = 100;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (9),_new,(int) (1));
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn1_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Private Sub et_matn1_TextChanged (Old As String, N";
 //BA.debugLineNum = 132;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (4),_new,(int) (1));
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn2_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Private Sub et_matn2_TextChanged (Old As String, N";
 //BA.debugLineNum = 128;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (5),_new,(int) (1));
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn3_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Private Sub et_matn3_TextChanged (Old As String, N";
 //BA.debugLineNum = 124;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (6),_new,(int) (1));
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _et_title1_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Private Sub et_title1_TextChanged (Old As String,";
 //BA.debugLineNum = 120;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (1),_new,(int) (1));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _et_title2_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Private Sub et_title2_TextChanged (Old As String,";
 //BA.debugLineNum = 116;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (2),_new,(int) (1));
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _et_title3_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub et_title3_TextChanged (Old As String,";
 //BA.debugLineNum = 112;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (3),_new,(int) (1));
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private et_matn1 As EditText";
mostCurrent._et_matn1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private et_matn2 As EditText";
mostCurrent._et_matn2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private et_matn3 As EditText";
mostCurrent._et_matn3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private et_title1 As EditText";
mostCurrent._et_title1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private et_title2 As EditText";
mostCurrent._et_title2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private et_title3 As EditText";
mostCurrent._et_title3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private et_etefag1 As EditText";
mostCurrent._et_etefag1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private et_etefag2 As EditText";
mostCurrent._et_etefag2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private et_etefag3 As EditText";
mostCurrent._et_etefag3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 83;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
