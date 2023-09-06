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

public class daftar_activity extends Activity implements B4AActivity{
	public static daftar_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.daftar_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (daftar_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.daftar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.daftar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (daftar_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (daftar_activity) Resume **");
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
		return daftar_activity.class;
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
            BA.LogInfo("** Activity (daftar_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (daftar_activity) Pause event (activity is not paused). **");
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
            daftar_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (daftar_activity) Resume **");
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
public static int _index_daftar = 0;
public static boolean _for_edit = false;
public static String _this_shenase = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbl_shokrgozari = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ravabet = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_khasteha = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_add = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_date_add = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_title_add = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_add = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_items = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_items = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_item = null;
public b4a.example3.customlistview _cuslistv_data = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_edit = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_delete = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.daftar_shokrgozari_activity _daftar_shokrgozari_activity = null;
public ir.taravatgroup.shokrgozari.daftar_ravabet_activity _daftar_ravabet_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
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
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"daftar_layout\")";
mostCurrent._activity.LoadLayout("daftar_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 47;BA.debugLine="rest_color";
_rest_color();
 //BA.debugLineNum = 48;BA.debugLine="lbl_shokrgozari_Click";
_lbl_shokrgozari_click();
 //BA.debugLineNum = 49;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 67;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 69;BA.debugLine="If(pan_all_add.Visible=True)Then";
if ((mostCurrent._pan_all_add.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 70;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 72;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 77;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 79;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
String _sql_ster = "";
 //BA.debugLineNum = 215;BA.debugLine="Sub fill_list";
 //BA.debugLineNum = 216;BA.debugLine="Dim sql_ster As String=\"\"";
_sql_ster = "";
 //BA.debugLineNum = 217;BA.debugLine="Select index_daftar";
switch (_index_daftar) {
case 0: {
 //BA.debugLineNum = 220;BA.debugLine="sql_ster=\"SELECT * FROM daftar_shenase WHERE mo";
_sql_ster = "SELECT * FROM daftar_shenase WHERE model=0;";
 break; }
case 1: {
 //BA.debugLineNum = 222;BA.debugLine="sql_ster=\"SELECT * FROM daftar_shenase WHERE mo";
_sql_ster = "SELECT * FROM daftar_shenase WHERE model=1;";
 break; }
case 2: {
 //BA.debugLineNum = 224;BA.debugLine="sql_ster=\"SELECT * FROM daftar_shenase WHERE mo";
_sql_ster = "SELECT * FROM daftar_shenase WHERE model=2;";
 break; }
}
;
 //BA.debugLineNum = 228;BA.debugLine="cusListV_data.Clear";
mostCurrent._cuslistv_data._clear();
 //BA.debugLineNum = 232;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 233;BA.debugLine="Main.res=Main.sql.ExecQuery(sql_ster)";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery(_sql_ster)));
 //BA.debugLineNum = 236;BA.debugLine="Do While Main.res.NextRow";
while (mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 239;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 241;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 85dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (85)));
 //BA.debugLineNum = 242;BA.debugLine="p.LoadLayout(\"item_list_daftar\")";
mostCurrent._p.LoadLayout("item_list_daftar",mostCurrent.activityBA);
 //BA.debugLineNum = 245;BA.debugLine="cusListV_data.Add(p,Main.res.Position)";
mostCurrent._cuslistv_data._add(mostCurrent._p,(Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition()));
 //BA.debugLineNum = 247;BA.debugLine="lbl_title_items.Text=Main.res.GetString(\"title\")";
mostCurrent._lbl_title_items.setText(BA.ObjectToCharSequence(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 248;BA.debugLine="lbl_date_items.Text=Main.res.GetString(\"date\")";
mostCurrent._lbl_date_items.setText(BA.ObjectToCharSequence(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
 //BA.debugLineNum = 251;BA.debugLine="lbl_icon_delete.Tag=Main.res.GetString(\"shenase\"";
mostCurrent._lbl_icon_delete.setTag((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shenase")));
 //BA.debugLineNum = 252;BA.debugLine="lbl_icon_edit.Tag=Main.res.GetString(\"shenase\")";
mostCurrent._lbl_icon_edit.setTag((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shenase")));
 //BA.debugLineNum = 253;BA.debugLine="pan_item.Tag=Main.res.GetString(\"shenase\")";
mostCurrent._pan_item.setTag((Object)(mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shenase")));
 }
;
 //BA.debugLineNum = 259;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 260;BA.debugLine="Main.res.Close";
mostCurrent._main._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim index_daftar As Int=0";
_index_daftar = (int) (0);
 //BA.debugLineNum = 17;BA.debugLine="Dim for_edit As Boolean=False";
_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 18;BA.debugLine="Dim this_shenase As String=\"\"";
mostCurrent._this_shenase = "";
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_shokrgozari As Label";
mostCurrent._lbl_shokrgozari = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_ravabet As Label";
mostCurrent._lbl_ravabet = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_khasteha As Label";
mostCurrent._lbl_khasteha = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pan_all_add As Panel";
mostCurrent._pan_all_add = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private et_date_add As EditText";
mostCurrent._et_date_add = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private et_title_add As EditText";
mostCurrent._et_title_add = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lbl_title_add As Label";
mostCurrent._lbl_title_add = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_title_items As Label";
mostCurrent._lbl_title_items = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_date_items As Label";
mostCurrent._lbl_date_items = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pan_item As Panel";
mostCurrent._pan_item = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private cusListV_data As CustomListView";
mostCurrent._cuslistv_data = new b4a.example3.customlistview();
 //BA.debugLineNum = 36;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 37;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_icon_edit As Label";
mostCurrent._lbl_icon_edit = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lbl_icon_delete As Label";
mostCurrent._lbl_icon_delete = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_click() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Private Sub lbl_add_Click";
 //BA.debugLineNum = 117;BA.debugLine="for_edit=False";
_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 118;BA.debugLine="et_title_add.Text=\"\"";
mostCurrent._et_title_add.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 119;BA.debugLine="et_date_add.Text=\"\"";
mostCurrent._et_date_add.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 121;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 64;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_icon_delete_click() throws Exception{
ResumableSub_lbl_icon_delete_Click rsub = new ResumableSub_lbl_icon_delete_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_icon_delete_Click extends BA.ResumableSub {
public ResumableSub_lbl_icon_delete_Click(ir.taravatgroup.shokrgozari.daftar_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.daftar_activity parent;
anywheresoftware.b4a.objects.LabelWrapper _this_item = null;
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
 //BA.debugLineNum = 176;BA.debugLine="Dim this_item As Label=Sender";
_this_item = new anywheresoftware.b4a.objects.LabelWrapper();
_this_item = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 177;BA.debugLine="this_shenase=this_item.Tag";
parent.mostCurrent._this_shenase = BA.ObjectToString(_this_item.getTag());
 //BA.debugLineNum = 179;BA.debugLine="Msgbox2Async(\"مطمئن هستید که حذف شود؟\", \"حذف\", \"ب";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("مطمئن هستید که حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 180;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 181;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 182;BA.debugLine="myFunc.delet_daftar_shenase(this_shenase,index_d";
parent.mostCurrent._myfunc._delet_daftar_shenase /*String*/ (mostCurrent.activityBA,parent.mostCurrent._this_shenase,parent._index_daftar);
 //BA.debugLineNum = 183;BA.debugLine="fill_list";
_fill_list();
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _lbl_icon_edit_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_this = null;
anywheresoftware.b4a.objects.LabelWrapper _this_item = null;
 //BA.debugLineNum = 270;BA.debugLine="Private Sub lbl_icon_edit_Click";
 //BA.debugLineNum = 271;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 272;BA.debugLine="lbl_title_add.Text=\"ویرایش\"";
mostCurrent._lbl_title_add.setText(BA.ObjectToCharSequence("ویرایش"));
 //BA.debugLineNum = 273;BA.debugLine="for_edit=True";
_for_edit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 275;BA.debugLine="Dim ls_this As List";
_ls_this = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 276;BA.debugLine="ls_this.Initialize";
_ls_this.Initialize();
 //BA.debugLineNum = 277;BA.debugLine="Dim this_item As Label=Sender";
_this_item = new anywheresoftware.b4a.objects.LabelWrapper();
_this_item = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 278;BA.debugLine="this_shenase=this_item.Tag";
mostCurrent._this_shenase = BA.ObjectToString(_this_item.getTag());
 //BA.debugLineNum = 281;BA.debugLine="ls_this=myFunc.get_name_date_daftar(this_item.Tag";
_ls_this = mostCurrent._myfunc._get_name_date_daftar /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,BA.ObjectToString(_this_item.getTag()));
 //BA.debugLineNum = 284;BA.debugLine="et_title_add.Text=ls_this.Get(0)";
mostCurrent._et_title_add.setText(BA.ObjectToCharSequence(_ls_this.Get((int) (0))));
 //BA.debugLineNum = 285;BA.debugLine="et_date_add.Text=ls_this.Get(1)";
mostCurrent._et_date_add.setText(BA.ObjectToCharSequence(_ls_this.Get((int) (1))));
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khasteha_click() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Private Sub lbl_khasteha_Click";
 //BA.debugLineNum = 84;BA.debugLine="index_daftar=2";
_index_daftar = (int) (2);
 //BA.debugLineNum = 85;BA.debugLine="rest_color";
_rest_color();
 //BA.debugLineNum = 86;BA.debugLine="lbl_khasteha.Color=Colors.Green";
mostCurrent._lbl_khasteha.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 87;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ravabet_click() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Private Sub lbl_ravabet_Click";
 //BA.debugLineNum = 93;BA.debugLine="index_daftar=1";
_index_daftar = (int) (1);
 //BA.debugLineNum = 94;BA.debugLine="rest_color";
_rest_color();
 //BA.debugLineNum = 95;BA.debugLine="lbl_ravabet.Color=Colors.Green";
mostCurrent._lbl_ravabet.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 96;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_add_click() throws Exception{
String _random_shenase = "";
int _model_1 = 0;
 //BA.debugLineNum = 128;BA.debugLine="Private Sub lbl_save_add_Click";
 //BA.debugLineNum = 129;BA.debugLine="If(et_title_add.Text=\"\" Or et_date_add.Text=\"\")Th";
if (((mostCurrent._et_title_add.getText()).equals("") || (mostCurrent._et_date_add.getText()).equals(""))) { 
 //BA.debugLineNum = 130;BA.debugLine="ToastMessageShow(\"آیتم خالی\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("آیتم خالی"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 134;BA.debugLine="If(for_edit=True)Then";
if ((_for_edit==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 136;BA.debugLine="myFunc.update_daftar_shenase(this_shenase,et_ti";
mostCurrent._myfunc._update_daftar_shenase /*boolean*/ (mostCurrent.activityBA,mostCurrent._this_shenase,mostCurrent._et_title_add.getText(),mostCurrent._et_date_add.getText());
 }else {
 //BA.debugLineNum = 141;BA.debugLine="Dim random_shenase As String=myFunc.GetRandomSt";
_random_shenase = mostCurrent._myfunc._getrandomstring /*String*/ (mostCurrent.activityBA,"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",(int) (9));
 //BA.debugLineNum = 142;BA.debugLine="Dim model_1 As Int =0";
_model_1 = (int) (0);
 //BA.debugLineNum = 143;BA.debugLine="Select index_daftar";
switch (_index_daftar) {
case 0: {
 //BA.debugLineNum = 145;BA.debugLine="model_1=0";
_model_1 = (int) (0);
 break; }
case 1: {
 //BA.debugLineNum = 147;BA.debugLine="model_1=1";
_model_1 = (int) (1);
 break; }
case 2: {
 //BA.debugLineNum = 149;BA.debugLine="model_1=2";
_model_1 = (int) (2);
 break; }
}
;
 //BA.debugLineNum = 153;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 154;BA.debugLine="Main.sql.ExecNonQuery2(\"INSERT INTO daftar_shen";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO daftar_shenase ('model' , 'shenase' , 'title','date') VALUES (?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_model_1),(Object)(_random_shenase),(Object)(mostCurrent._et_title_add.getText()),(Object)(mostCurrent._et_date_add.getText())}));
 //BA.debugLineNum = 155;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 165;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 166;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_shokrgozari_click() throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub lbl_shokrgozari_Click";
 //BA.debugLineNum = 102;BA.debugLine="index_daftar=0";
_index_daftar = (int) (0);
 //BA.debugLineNum = 103;BA.debugLine="rest_color";
_rest_color();
 //BA.debugLineNum = 104;BA.debugLine="lbl_shokrgozari.Color=Colors.Green";
mostCurrent._lbl_shokrgozari.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 105;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_add_click() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Private Sub pan_all_add_Click";
 //BA.debugLineNum = 125;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _this_item = null;
 //BA.debugLineNum = 192;BA.debugLine="Private Sub pan_item_Click";
 //BA.debugLineNum = 193;BA.debugLine="Dim this_item As Panel=Sender";
_this_item = new anywheresoftware.b4a.objects.PanelWrapper();
_this_item = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 197;BA.debugLine="Main.daftar_shenase=this_item.Tag";
mostCurrent._main._daftar_shenase /*String*/  = BA.ObjectToString(_this_item.getTag());
 //BA.debugLineNum = 199;BA.debugLine="Select index_daftar";
switch (_index_daftar) {
case 0: {
 //BA.debugLineNum = 201;BA.debugLine="StartActivity(daftar_shokrgozari_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._daftar_shokrgozari_activity.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 203;BA.debugLine="StartActivity(daftar_ravabet_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._daftar_ravabet_activity.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 205;BA.debugLine="StartActivity(daftar_khasteha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._daftar_khasteha_activity.getObject()));
 break; }
}
;
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _panel3_click() throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Private Sub Panel3_Click";
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _rest_color() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Sub rest_color";
 //BA.debugLineNum = 110;BA.debugLine="lbl_shokrgozari.Color=Colors.Gray";
mostCurrent._lbl_shokrgozari.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 111;BA.debugLine="lbl_ravabet.Color=Colors.Gray";
mostCurrent._lbl_ravabet.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 112;BA.debugLine="lbl_khasteha.Color=Colors.Gray";
mostCurrent._lbl_khasteha.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
}
