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

public class tamrin8_activity extends Activity implements B4AActivity{
	public static tamrin8_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin8_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrin8_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin8_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrin8_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrin8_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrin8_activity) Resume **");
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
		return tamrin8_activity.class;
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
            BA.LogInfo("** Activity (tamrin8_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrin8_activity) Pause event (activity is not paused). **");
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
            tamrin8_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrin8_activity) Resume **");
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat5 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat6 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat7 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat8 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat9 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat10 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_moshkel = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
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
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _ls_get_content = null;
int _i = 0;
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="Activity.LoadLayout(\"tamrin8_layout\")";
mostCurrent._activity.LoadLayout("tamrin8_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="ScrollView1.Panel.LoadLayout(\"tamrin8_items\")";
mostCurrent._scrollview1.getPanel().LoadLayout("tamrin8_items",mostCurrent.activityBA);
RDebugUtils.currentLine=7471110;
 //BA.debugLineNum = 7471110;BA.debugLine="Dim ls_get_content As List";
_ls_get_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7471111;
 //BA.debugLineNum = 7471111;BA.debugLine="ls_get_content.Initialize";
_ls_get_content.Initialize();
RDebugUtils.currentLine=7471112;
 //BA.debugLineNum = 7471112;BA.debugLine="ls_get_content=myFunc.get_all_tamrin8";
_ls_get_content = mostCurrent._myfunc._get_all_tamrin8 /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=7471114;
 //BA.debugLineNum = 7471114;BA.debugLine="For i=0 To 10";
{
final int step6 = 1;
final int limit6 = (int) (10);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=7471116;
 //BA.debugLineNum = 7471116;BA.debugLine="If(ls_get_content.Get(i)=Null)Then";
if ((_ls_get_content.Get(_i)== null)) { 
RDebugUtils.currentLine=7471117;
 //BA.debugLineNum = 7471117;BA.debugLine="ls_get_content.Set(i,\"\")";
_ls_get_content.Set(_i,(Object)(""));
 };
 }
};
RDebugUtils.currentLine=7471121;
 //BA.debugLineNum = 7471121;BA.debugLine="et_mohebat1.Text=ls_get_content.Get(0)";
mostCurrent._et_mohebat1.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (0))));
RDebugUtils.currentLine=7471122;
 //BA.debugLineNum = 7471122;BA.debugLine="et_mohebat2.Text=ls_get_content.Get(1)";
mostCurrent._et_mohebat2.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (1))));
RDebugUtils.currentLine=7471123;
 //BA.debugLineNum = 7471123;BA.debugLine="et_mohebat3.Text=ls_get_content.Get(2)";
mostCurrent._et_mohebat3.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (2))));
RDebugUtils.currentLine=7471124;
 //BA.debugLineNum = 7471124;BA.debugLine="et_mohebat4.Text=ls_get_content.Get(3)";
mostCurrent._et_mohebat4.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (3))));
RDebugUtils.currentLine=7471125;
 //BA.debugLineNum = 7471125;BA.debugLine="et_mohebat5.Text=ls_get_content.Get(4)";
mostCurrent._et_mohebat5.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (4))));
RDebugUtils.currentLine=7471126;
 //BA.debugLineNum = 7471126;BA.debugLine="et_mohebat6.Text=ls_get_content.Get(5)";
mostCurrent._et_mohebat6.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (5))));
RDebugUtils.currentLine=7471127;
 //BA.debugLineNum = 7471127;BA.debugLine="et_mohebat7.Text=ls_get_content.Get(6)";
mostCurrent._et_mohebat7.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (6))));
RDebugUtils.currentLine=7471128;
 //BA.debugLineNum = 7471128;BA.debugLine="et_mohebat8.Text=ls_get_content.Get(7)";
mostCurrent._et_mohebat8.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (7))));
RDebugUtils.currentLine=7471129;
 //BA.debugLineNum = 7471129;BA.debugLine="et_mohebat9.Text=ls_get_content.Get(8)";
mostCurrent._et_mohebat9.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (8))));
RDebugUtils.currentLine=7471130;
 //BA.debugLineNum = 7471130;BA.debugLine="et_mohebat10.Text=ls_get_content.Get(9)";
mostCurrent._et_mohebat10.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (9))));
RDebugUtils.currentLine=7471131;
 //BA.debugLineNum = 7471131;BA.debugLine="et_moshkel.Text=ls_get_content.Get(10)";
mostCurrent._et_moshkel.setText(BA.ObjectToCharSequence(_ls_get_content.Get((int) (10))));
RDebugUtils.currentLine=7471135;
 //BA.debugLineNum = 7471135;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub et_mohebat1_TextChanged (Old As String";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="myFunc.update_tamrin8(1,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (1),_new);
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat10_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat10_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat10_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub et_mohebat10_TextChanged (Old As Strin";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="myFunc.update_tamrin8(10,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (10),_new);
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat2_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat2_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat2_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub et_mohebat2_TextChanged (Old As String";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="myFunc.update_tamrin8(2,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (2),_new);
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat3_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat3_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat3_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub et_mohebat3_TextChanged (Old As String";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="myFunc.update_tamrin8(3,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (3),_new);
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat4_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat4_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat4_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub et_mohebat4_TextChanged (Old As String";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="myFunc.update_tamrin8(4,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (4),_new);
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat5_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat5_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat5_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Private Sub et_mohebat5_TextChanged (Old As String";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="myFunc.update_tamrin8(5,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (5),_new);
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat6_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat6_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat6_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Private Sub et_mohebat6_TextChanged (Old As String";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="myFunc.update_tamrin8(6,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (6),_new);
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat7_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat7_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat7_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub et_mohebat7_TextChanged (Old As String";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="myFunc.update_tamrin8(7,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (7),_new);
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat8_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat8_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat8_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub et_mohebat8_TextChanged (Old As String";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="myFunc.update_tamrin8(8,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (8),_new);
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat9_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mohebat9_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mohebat9_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub et_mohebat9_TextChanged (Old As String";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="myFunc.update_tamrin8(9,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (9),_new);
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
return "";
}
public static String  _et_moshkel_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin8_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_moshkel_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_moshkel_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub et_moshkel_TextChanged (Old As String,";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="myFunc.update_tamrin8(11,New)";
mostCurrent._myfunc._update_tamrin8 /*boolean*/ (mostCurrent.activityBA,(int) (11),_new);
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="End Sub";
return "";
}
}