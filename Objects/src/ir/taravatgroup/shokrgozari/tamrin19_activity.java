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

public class tamrin19_activity extends Activity implements B4AActivity{
	public static tamrin19_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin19_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrin19_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin19_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrin19_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrin19_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrin19_activity) Resume **");
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
		return tamrin19_activity.class;
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
            BA.LogInfo("** Activity (tamrin19_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrin19_activity) Pause event (activity is not paused). **");
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
            tamrin19_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrin19_activity) Resume **");
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
public b4a.example3.customlistview _cuslistv_data = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_delet = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_import = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_new_item = null;
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
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=19136512;
 //BA.debugLineNum = 19136512;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=19136514;
 //BA.debugLineNum = 19136514;BA.debugLine="Activity.LoadLayout(\"tamrin19_layout\")";
mostCurrent._activity.LoadLayout("tamrin19_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=19136516;
 //BA.debugLineNum = 19136516;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=19136519;
 //BA.debugLineNum = 19136519;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list", null));}
RDebugUtils.currentLine=19333120;
 //BA.debugLineNum = 19333120;BA.debugLine="Sub fill_list";
RDebugUtils.currentLine=19333122;
 //BA.debugLineNum = 19333122;BA.debugLine="cusListV_data.Clear";
mostCurrent._cuslistv_data._clear();
RDebugUtils.currentLine=19333125;
 //BA.debugLineNum = 19333125;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=19333126;
 //BA.debugLineNum = 19333126;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin19;")));
RDebugUtils.currentLine=19333129;
 //BA.debugLineNum = 19333129;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=19333133;
 //BA.debugLineNum = 19333133;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=19333134;
 //BA.debugLineNum = 19333134;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 85dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (85)));
RDebugUtils.currentLine=19333135;
 //BA.debugLineNum = 19333135;BA.debugLine="p.LoadLayout(\"item_list_tamrin19\")";
mostCurrent._p.LoadLayout("item_list_tamrin19",mostCurrent.activityBA);
RDebugUtils.currentLine=19333136;
 //BA.debugLineNum = 19333136;BA.debugLine="cusListV_data.Add(p,Main.res.Position)";
mostCurrent._cuslistv_data._add(mostCurrent._p,(Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition()));
RDebugUtils.currentLine=19333138;
 //BA.debugLineNum = 19333138;BA.debugLine="lbl_roz.Text=Main.res.GetString(\"matn\")";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("matn")));
RDebugUtils.currentLine=19333139;
 //BA.debugLineNum = 19333139;BA.debugLine="lbl_delet.Tag=Main.res.Getint(\"id\")";
mostCurrent._lbl_delet.setTag((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id")));
RDebugUtils.currentLine=19333140;
 //BA.debugLineNum = 19333140;BA.debugLine="lbl_import.Tag=Main.res.Getint(\"id\")";
mostCurrent._lbl_import.setTag((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id")));
RDebugUtils.currentLine=19333143;
 //BA.debugLineNum = 19333143;BA.debugLine="If(Main.res.Getint(\"state\").As(Int)=0)Then";
if (((mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"))==0)) { 
RDebugUtils.currentLine=19333145;
 //BA.debugLineNum = 19333145;BA.debugLine="lbl_import.TextColor=Colors.Gray";
mostCurrent._lbl_import.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 }else {
RDebugUtils.currentLine=19333148;
 //BA.debugLineNum = 19333148;BA.debugLine="lbl_import.TextColor=Colors.Green";
mostCurrent._lbl_import.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 };
 }
;
RDebugUtils.currentLine=19333158;
 //BA.debugLineNum = 19333158;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=19333159;
 //BA.debugLineNum = 19333159;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=19333164;
 //BA.debugLineNum = 19333164;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=20840448;
 //BA.debugLineNum = 20840448;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=20840449;
 //BA.debugLineNum = 20840449;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=20840450;
 //BA.debugLineNum = 20840450;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=20840451;
 //BA.debugLineNum = 20840451;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=20840453;
 //BA.debugLineNum = 20840453;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=20840456;
 //BA.debugLineNum = 20840456;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=20840458;
 //BA.debugLineNum = 20840458;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=20840460;
 //BA.debugLineNum = 20840460;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=20905984;
 //BA.debugLineNum = 20905984;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=20905985;
 //BA.debugLineNum = 20905985;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=20905986;
 //BA.debugLineNum = 20905986;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
RDebugUtils.currentLine=19267584;
 //BA.debugLineNum = 19267584;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=19267586;
 //BA.debugLineNum = 19267586;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=19202048;
 //BA.debugLineNum = 19202048;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=19202050;
 //BA.debugLineNum = 19202050;BA.debugLine="End Sub";
return "";
}
public static int  _get_state_tamrin19_item(int _id) throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_state_tamrin19_item", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "get_state_tamrin19_item", new Object[] {_id}));}
int _result = 0;
RDebugUtils.currentLine=22478848;
 //BA.debugLineNum = 22478848;BA.debugLine="Sub get_state_tamrin19_item (id As Int) As Int";
RDebugUtils.currentLine=22478850;
 //BA.debugLineNum = 22478850;BA.debugLine="Dim result As Int=0";
_result = (int) (0);
RDebugUtils.currentLine=22478852;
 //BA.debugLineNum = 22478852;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=22478853;
 //BA.debugLineNum = 22478853;BA.debugLine="Main.res=Main.sql.ExecQuery(\"SELECT * FROM tamrin";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tamrin19 WHERE id="+BA.NumberToString(_id)+";")));
RDebugUtils.currentLine=22478854;
 //BA.debugLineNum = 22478854;BA.debugLine="Main.res.Position=0";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=22478857;
 //BA.debugLineNum = 22478857;BA.debugLine="result=Main.res.Getint(\"state\")";
_result = mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
RDebugUtils.currentLine=22478860;
 //BA.debugLineNum = 22478860;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=22478861;
 //BA.debugLineNum = 22478861;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=22478863;
 //BA.debugLineNum = 22478863;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=22478865;
 //BA.debugLineNum = 22478865;BA.debugLine="End Sub";
return 0;
}
public static String  _lbl_add_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_click", null));}
RDebugUtils.currentLine=20774912;
 //BA.debugLineNum = 20774912;BA.debugLine="Private Sub lbl_add_Click";
RDebugUtils.currentLine=20774913;
 //BA.debugLineNum = 20774913;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=20774914;
 //BA.debugLineNum = 20774914;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_delet_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_delet_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_delet_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_lbl = null;
RDebugUtils.currentLine=19529728;
 //BA.debugLineNum = 19529728;BA.debugLine="Private Sub lbl_delet_Click";
RDebugUtils.currentLine=19529729;
 //BA.debugLineNum = 19529729;BA.debugLine="Dim this_lbl As Label=Sender";
_this_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_this_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=19529732;
 //BA.debugLineNum = 19529732;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=19529733;
 //BA.debugLineNum = 19529733;BA.debugLine="Main.sql.ExecNonQuery(\"DELETE FROM tamrin19 WHERE";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tamrin19 WHERE id="+BA.ObjectToString(_this_lbl.getTag())+";");
RDebugUtils.currentLine=19529734;
 //BA.debugLineNum = 19529734;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=19529735;
 //BA.debugLineNum = 19529735;BA.debugLine="ToastMessageShow(\"حذف شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=19529738;
 //BA.debugLineNum = 19529738;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=19529742;
 //BA.debugLineNum = 19529742;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_import_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_import_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_import_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_lbl = null;
RDebugUtils.currentLine=20512768;
 //BA.debugLineNum = 20512768;BA.debugLine="Private Sub lbl_import_Click";
RDebugUtils.currentLine=20512770;
 //BA.debugLineNum = 20512770;BA.debugLine="Dim this_lbl As Label=Sender";
_this_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_this_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=20512773;
 //BA.debugLineNum = 20512773;BA.debugLine="If(get_state_tamrin19_item(this_lbl.Tag)=0)Then";
if ((_get_state_tamrin19_item((int)(BA.ObjectToNumber(_this_lbl.getTag())))==0)) { 
RDebugUtils.currentLine=20512774;
 //BA.debugLineNum = 20512774;BA.debugLine="this_lbl.TextColor=Colors.Green";
_this_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=20512775;
 //BA.debugLineNum = 20512775;BA.debugLine="update_stateById(this_lbl.Tag,1)";
_update_statebyid((int)(BA.ObjectToNumber(_this_lbl.getTag())),(int) (1));
 }else {
RDebugUtils.currentLine=20512778;
 //BA.debugLineNum = 20512778;BA.debugLine="this_lbl.TextColor=Colors.Gray";
_this_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=20512779;
 //BA.debugLineNum = 20512779;BA.debugLine="update_stateById(this_lbl.Tag,0)";
_update_statebyid((int)(BA.ObjectToNumber(_this_lbl.getTag())),(int) (0));
 };
RDebugUtils.currentLine=20512787;
 //BA.debugLineNum = 20512787;BA.debugLine="End Sub";
return "";
}
public static String  _update_statebyid(int _id,int _state) throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "update_statebyid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "update_statebyid", new Object[] {_id,_state}));}
RDebugUtils.currentLine=23527424;
 //BA.debugLineNum = 23527424;BA.debugLine="Sub update_stateById(id As Int,state As Int)";
RDebugUtils.currentLine=23527425;
 //BA.debugLineNum = 23527425;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=23527426;
 //BA.debugLineNum = 23527426;BA.debugLine="Main.sql.ExecNonQuery2(\"UPDATE tamrin19 SET state";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE tamrin19 SET state=? WHERE id=? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=23527427;
 //BA.debugLineNum = 23527427;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=23527429;
 //BA.debugLineNum = 23527429;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_new_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_new_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_new_click", null));}
RDebugUtils.currentLine=20709376;
 //BA.debugLineNum = 20709376;BA.debugLine="Private Sub lbl_save_new_Click";
RDebugUtils.currentLine=20709379;
 //BA.debugLineNum = 20709379;BA.debugLine="If(et_new_item.Text<>\"\" And et_new_item.Text<>Nul";
if (((mostCurrent._et_new_item.getText()).equals("") == false && mostCurrent._et_new_item.getText()!= null)) { 
RDebugUtils.currentLine=20709380;
 //BA.debugLineNum = 20709380;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=20709381;
 //BA.debugLineNum = 20709381;BA.debugLine="Main.sql.ExecNonQuery(\"INSERT INTO tamrin19 ('ma";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("INSERT INTO tamrin19 ('matn') VALUES ('"+mostCurrent._et_new_item.getText()+"');");
RDebugUtils.currentLine=20709382;
 //BA.debugLineNum = 20709382;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=20709383;
 //BA.debugLineNum = 20709383;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=20709385;
 //BA.debugLineNum = 20709385;BA.debugLine="pan_all_Click";
_pan_all_click();
RDebugUtils.currentLine=20709386;
 //BA.debugLineNum = 20709386;BA.debugLine="fill_list";
_fill_list();
 }else {
RDebugUtils.currentLine=20709389;
 //BA.debugLineNum = 20709389;BA.debugLine="MsgboxAsync(\"متن خالی است!\", \"توجه\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("متن خالی است!"),BA.ObjectToCharSequence("توجه"),processBA);
 };
RDebugUtils.currentLine=20709396;
 //BA.debugLineNum = 20709396;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="tamrin19_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=20643840;
 //BA.debugLineNum = 20643840;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=20643841;
 //BA.debugLineNum = 20643841;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=20643842;
 //BA.debugLineNum = 20643842;BA.debugLine="End Sub";
return "";
}
}