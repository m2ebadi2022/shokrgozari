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

public class tamrin_roz_activity extends Activity implements B4AActivity{
	public static tamrin_roz_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin_roz_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrin_roz_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin_roz_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrin_roz_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrin_roz_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrin_roz_activity) Resume **");
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
		return tamrin_roz_activity.class;
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
            BA.LogInfo("** Activity (tamrin_roz_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrin_roz_activity) Pause event (activity is not paused). **");
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
            tamrin_roz_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrin_roz_activity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_titel_roz = null;
public b4a.example3.customlistview _customlv_tamrinat = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_roz = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_roz = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tamrin2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_tamrin2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_save_tamrin2 = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
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
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"tamrin_roz_layout\")";
mostCurrent._activity.LoadLayout("tamrin_roz_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 38;BA.debugLine="lbl_titel_roz.Text=\"تمرین روز \"& Main.current_roz";
mostCurrent._lbl_titel_roz.setText(BA.ObjectToCharSequence("تمرین روز "+BA.NumberToString(mostCurrent._main._current_roz_tamrin /*int*/ )));
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 347;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 348;BA.debugLine="If(pan_all_tamrin2.Visible=True)Then";
if ((mostCurrent._pan_all_tamrin2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 349;BA.debugLine="pan_all_tamrin2.Visible=False";
mostCurrent._pan_all_tamrin2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 351;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 354;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 356;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 46;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_rozha = null;
String _str_html = "";
adr.stringfunctions.stringfunctions _strfunc = null;
anywheresoftware.b4a.objects.collections.List _list_tamrinat = null;
anywheresoftware.b4a.objects.collections.List _list_tamrinat_state = null;
int _i = 0;
int _code_state = 0;
int _state_tamrin2 = 0;
int _state_tamrin3 = 0;
int _state_tamrin8 = 0;
int _state_tamrin13 = 0;
int _state_tamrin14 = 0;
int _state_tamrin16 = 0;
int _state_tamrin19 = 0;
int _state_tamrin22 = 0;
int _state_tamrin25 = 0;
int _state_tamrin27 = 0;
 //BA.debugLineNum = 71;BA.debugLine="Sub fill_list";
 //BA.debugLineNum = 73;BA.debugLine="CustomLV_tamrinat.Clear";
mostCurrent._customlv_tamrinat._clear();
 //BA.debugLineNum = 75;BA.debugLine="Dim list_rozha As List";
_list_rozha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 76;BA.debugLine="list_rozha.Initialize";
_list_rozha.Initialize();
 //BA.debugLineNum = 77;BA.debugLine="list_rozha=myFunc.get_roz_byId(Main.current_roz_t";
_list_rozha = mostCurrent._myfunc._get_roz_byid /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ );
 //BA.debugLineNum = 80;BA.debugLine="Dim str_html As String";
_str_html = "";
 //BA.debugLineNum = 81;BA.debugLine="str_html=\"<html><head><meta name='viewport' conte";
_str_html = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word;'><b>"+BA.ObjectToString(_list_rozha.Get((int) (0)))+"</b><p>"+BA.ObjectToString(_list_rozha.Get((int) (1)))+"<br></body></html>";
 //BA.debugLineNum = 84;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 85;BA.debugLine="WebView1.LoadHtml(str_html)";
mostCurrent._webview1.LoadHtml(_str_html);
 //BA.debugLineNum = 87;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 88;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
 //BA.debugLineNum = 90;BA.debugLine="Dim list_tamrinat As List";
_list_tamrinat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 91;BA.debugLine="list_tamrinat.Initialize";
_list_tamrinat.Initialize();
 //BA.debugLineNum = 92;BA.debugLine="list_tamrinat=strFunc.Split(list_rozha.Get(2) , \"";
_list_tamrinat = _strfunc._vvvvvv5(BA.ObjectToString(_list_rozha.Get((int) (2))),",");
 //BA.debugLineNum = 94;BA.debugLine="Dim list_tamrinat_state As List";
_list_tamrinat_state = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 95;BA.debugLine="list_tamrinat_state.Initialize";
_list_tamrinat_state.Initialize();
 //BA.debugLineNum = 96;BA.debugLine="list_tamrinat_state=strFunc.Split(list_rozha.Get(";
_list_tamrinat_state = _strfunc._vvvvvv5(BA.ObjectToString(_list_rozha.Get((int) (3))),",");
 //BA.debugLineNum = 99;BA.debugLine="For i=0 To list_tamrinat.Size-1";
{
final int step17 = 1;
final int limit17 = (int) (_list_tamrinat.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit17 ;_i = _i + step17 ) {
 //BA.debugLineNum = 101;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 103;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 80dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 //BA.debugLineNum = 105;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
mostCurrent._p.LoadLayout("item_list_rozha_tamrin",mostCurrent.activityBA);
 //BA.debugLineNum = 106;BA.debugLine="lbl_icon_roz.Visible=True";
mostCurrent._lbl_icon_roz.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="CustomLV_tamrinat.Add(p,i)";
mostCurrent._customlv_tamrinat._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 109;BA.debugLine="pan_roz.Elevation=0";
mostCurrent._pan_roz.setElevation((float) (0));
 //BA.debugLineNum = 111;BA.debugLine="pan_roz.Tag=list_tamrinat.Get(i).As(Int)";
mostCurrent._pan_roz.setTag((Object)(((int)(BA.ObjectToNumber(_list_tamrinat.Get(_i))))));
 //BA.debugLineNum = 113;BA.debugLine="lbl_roz.Text=\"تمرین \"&(i+1)& \" : \"&tamrin_name(p";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence("تمرین "+BA.NumberToString((_i+1))+" : "+_tamrin_name((int)(BA.ObjectToNumber(mostCurrent._pan_roz.getTag())))));
 //BA.debugLineNum = 128;BA.debugLine="Select pan_roz.Tag.As(Int)";
switch (BA.switchObjectToInt(((int)(BA.ObjectToNumber(mostCurrent._pan_roz.getTag()))),(int) (1),(int) (2),(int) (4),(int) (5),(int) (6),(int) (7),(int) (9),(int) (10),(int) (11),(int) (12),(int) (15),(int) (17),(int) (18),(int) (20),(int) (21),(int) (24),(int) (26),(int) (28),(int) (29),(int) (3),(int) (8),(int) (13),(int) (14),(int) (16),(int) (19),(int) (22),(int) (25),(int) (27))) {
case 0: {
 //BA.debugLineNum = 130;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamri";
_code_state = mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ );
 //BA.debugLineNum = 131;BA.debugLine="If(code_state=10)Then";
if ((_code_state==10)) { 
 //BA.debugLineNum = 132;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_code_state==0)) { 
 //BA.debugLineNum = 134;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 136;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: 
case 18: {
 //BA.debugLineNum = 139;BA.debugLine="Dim state_tamrin2 As Int = myFunc.get_state(Ma";
_state_tamrin2 = mostCurrent._myfunc._get_state /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,((int)(BA.ObjectToNumber(mostCurrent._pan_roz.getTag()))));
 //BA.debugLineNum = 140;BA.debugLine="If(state_tamrin2 = 0 )Then";
if ((_state_tamrin2==0)) { 
 //BA.debugLineNum = 141;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 143;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 };
 break; }
case 19: {
 //BA.debugLineNum = 146;BA.debugLine="Dim state_tamrin3 As Int=myFunc.get_State_tamr";
_state_tamrin3 = mostCurrent._myfunc._get_state_tamrinat_saved /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,(int) (3));
 //BA.debugLineNum = 147;BA.debugLine="If(state_tamrin3=3)Then";
if ((_state_tamrin3==3)) { 
 //BA.debugLineNum = 148;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin3==0)) { 
 //BA.debugLineNum = 150;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 152;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 20: {
 //BA.debugLineNum = 156;BA.debugLine="Dim state_tamrin8 As Int=myFunc.get_state_tamr";
_state_tamrin8 = mostCurrent._myfunc._get_state_tamrin8 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 157;BA.debugLine="If(state_tamrin8>10)Then";
if ((_state_tamrin8>10)) { 
 //BA.debugLineNum = 158;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin8==0)) { 
 //BA.debugLineNum = 160;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 162;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 21: {
 //BA.debugLineNum = 167;BA.debugLine="Dim state_tamrin13 As Int=myFunc.get_state_tam";
_state_tamrin13 = mostCurrent._myfunc._get_state_tamrin13 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 168;BA.debugLine="If(state_tamrin13=3)Then";
if ((_state_tamrin13==3)) { 
 //BA.debugLineNum = 169;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin13==0)) { 
 //BA.debugLineNum = 171;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 173;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 22: {
 //BA.debugLineNum = 178;BA.debugLine="Dim state_tamrin14 As Int=myFunc.get_state_tam";
_state_tamrin14 = mostCurrent._myfunc._get_state_tamrin14 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 179;BA.debugLine="If(state_tamrin14=10)Then";
if ((_state_tamrin14==10)) { 
 //BA.debugLineNum = 180;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin14==0)) { 
 //BA.debugLineNum = 182;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 184;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 23: {
 //BA.debugLineNum = 188;BA.debugLine="Dim state_tamrin16 As Int=myFunc.get_state_tam";
_state_tamrin16 = mostCurrent._myfunc._get_state_tamrin16 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 189;BA.debugLine="If(state_tamrin16>10)Then";
if ((_state_tamrin16>10)) { 
 //BA.debugLineNum = 190;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin16==0)) { 
 //BA.debugLineNum = 192;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 194;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 24: {
 //BA.debugLineNum = 199;BA.debugLine="Dim state_tamrin19 As Int=myFunc.get_state_tam";
_state_tamrin19 = mostCurrent._myfunc._get_state_tamrin19 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 200;BA.debugLine="If(state_tamrin19>2)Then";
if ((_state_tamrin19>2)) { 
 //BA.debugLineNum = 201;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin19==0)) { 
 //BA.debugLineNum = 203;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 205;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 25: {
 //BA.debugLineNum = 209;BA.debugLine="Dim state_tamrin22 As Int=myFunc.get_State_tam";
_state_tamrin22 = mostCurrent._myfunc._get_state_tamrinat_saved /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,(int) (22));
 //BA.debugLineNum = 210;BA.debugLine="If(state_tamrin22=9)Then";
if ((_state_tamrin22==9)) { 
 //BA.debugLineNum = 211;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin22==0)) { 
 //BA.debugLineNum = 213;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 215;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 26: {
 //BA.debugLineNum = 222;BA.debugLine="Dim state_tamrin25 As Int=myFunc.get_State_tam";
_state_tamrin25 = mostCurrent._myfunc._get_state_tamrinat_saved /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,(int) (25));
 //BA.debugLineNum = 223;BA.debugLine="If(state_tamrin25=3)Then";
if ((_state_tamrin25==3)) { 
 //BA.debugLineNum = 224;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin25==0)) { 
 //BA.debugLineNum = 226;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 228;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
case 27: {
 //BA.debugLineNum = 233;BA.debugLine="Dim state_tamrin27 As Int=myFunc.get_state_tam";
_state_tamrin27 = mostCurrent._myfunc._get_state_tamrin27 /*int*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 234;BA.debugLine="If(state_tamrin27>10)Then";
if ((_state_tamrin27>10)) { 
 //BA.debugLineNum = 235;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 }else if((_state_tamrin27==0)) { 
 //BA.debugLineNum = 237;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
 }else {
 //BA.debugLineNum = 239;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 };
 break; }
}
;
 }
};
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_titel_roz As Label";
mostCurrent._lbl_titel_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private CustomLV_tamrinat As CustomListView";
mostCurrent._customlv_tamrinat = new b4a.example3.customlistview();
 //BA.debugLineNum = 20;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 21;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_roz As Label";
mostCurrent._lbl_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_icon_roz As Label";
mostCurrent._lbl_icon_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pan_roz As Panel";
mostCurrent._pan_roz = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private et_tamrin2 As EditText";
mostCurrent._et_tamrin2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private pan_all_tamrin2 As Panel";
mostCurrent._pan_all_tamrin2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_save_tamrin2 As Label";
mostCurrent._lbl_save_tamrin2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 56;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_tamrin2_click() throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Private Sub lbl_save_tamrin2_Click";
 //BA.debugLineNum = 328;BA.debugLine="If(lbl_save_tamrin2.Tag.As(Int)=1)Then";
if ((((int)(BA.ObjectToNumber(mostCurrent._lbl_save_tamrin2.getTag())))==1)) { 
 //BA.debugLineNum = 329;BA.debugLine="Select Main.current_tamrin";
switch (BA.switchObjectToInt(mostCurrent._main._current_tamrin /*int*/ ,(int) (2),(int) (4),(int) (5),(int) (6),(int) (7),(int) (9),(int) (10),(int) (11),(int) (12),(int) (15),(int) (17),(int) (18),(int) (20),(int) (21),(int) (24),(int) (26),(int) (28),(int) (29))) {
case 0: 
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: {
 //BA.debugLineNum = 331;BA.debugLine="myFunc.setState(Main.current_roz_tamrin,Main.c";
mostCurrent._myfunc._setstate /*String*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ );
 //BA.debugLineNum = 332;BA.debugLine="pan_all_tamrin2_Click";
_pan_all_tamrin2_click();
 //BA.debugLineNum = 333;BA.debugLine="fill_list";
_fill_list();
 break; }
default: {
 //BA.debugLineNum = 336;BA.debugLine="pan_all_tamrin2_Click";
_pan_all_tamrin2_click();
 break; }
}
;
 }else {
 //BA.debugLineNum = 339;BA.debugLine="pan_all_tamrin2_Click";
_pan_all_tamrin2_click();
 };
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_tamrin2_click() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Private Sub pan_all_tamrin2_Click";
 //BA.debugLineNum = 67;BA.debugLine="pan_all_tamrin2.Visible=False";
mostCurrent._pan_all_tamrin2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _pan_roz_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _this_tamrin = null;
int _state_tamrin2 = 0;
 //BA.debugLineNum = 258;BA.debugLine="Private Sub pan_roz_Click";
 //BA.debugLineNum = 259;BA.debugLine="Dim this_tamrin As Panel=Sender";
_this_tamrin = new anywheresoftware.b4a.objects.PanelWrapper();
_this_tamrin = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 263;BA.debugLine="Select this_tamrin.Tag";
switch (BA.switchObjectToInt(_this_tamrin.getTag(),(Object)(1),(Object)(2),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(9),(Object)(10),(Object)(11),(Object)(12),(Object)(15),(Object)(17),(Object)(18),(Object)(20),(Object)(21),(Object)(24),(Object)(26),(Object)(28),(Object)(29),(Object)(3),(Object)(8),(Object)(13),(Object)(14),(Object)(16),(Object)(19),(Object)(22),(Object)(25),(Object)(27))) {
case 0: {
 //BA.debugLineNum = 265;BA.debugLine="StartActivity(do_tamrin_roz_layout)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._do_tamrin_roz_layout.getObject()));
 break; }
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: 
case 18: {
 //BA.debugLineNum = 267;BA.debugLine="Main.current_tamrin=this_tamrin.Tag";
mostCurrent._main._current_tamrin /*int*/  = (int)(BA.ObjectToNumber(_this_tamrin.getTag()));
 //BA.debugLineNum = 268;BA.debugLine="pan_all_tamrin2.Visible=True";
mostCurrent._pan_all_tamrin2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 270;BA.debugLine="et_tamrin2.Text= myFunc.get_tamrinName(this_tam";
mostCurrent._et_tamrin2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_tamrinname /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_tamrin.getTag()))).Get((int) (1))));
 //BA.debugLineNum = 272;BA.debugLine="Dim state_tamrin2 As Int = myFunc.get_state(Mai";
_state_tamrin2 = mostCurrent._myfunc._get_state /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,(int)(BA.ObjectToNumber(_this_tamrin.getTag())));
 //BA.debugLineNum = 273;BA.debugLine="If(state_tamrin2=0)Then";
if ((_state_tamrin2==0)) { 
 //BA.debugLineNum = 274;BA.debugLine="lbl_save_tamrin2.Color=Colors.Gray";
mostCurrent._lbl_save_tamrin2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 276;BA.debugLine="lbl_save_tamrin2.Tag=1";
mostCurrent._lbl_save_tamrin2.setTag((Object)(1));
 }else {
 //BA.debugLineNum = 278;BA.debugLine="lbl_save_tamrin2.Color=Colors.Green";
mostCurrent._lbl_save_tamrin2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 280;BA.debugLine="lbl_save_tamrin2.Tag=0";
mostCurrent._lbl_save_tamrin2.setTag((Object)(0));
 };
 break; }
case 19: {
 //BA.debugLineNum = 286;BA.debugLine="Main.current_tamrin=3";
mostCurrent._main._current_tamrin /*int*/  = (int) (3);
 //BA.debugLineNum = 287;BA.debugLine="StartActivity(tamrin3_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin3_activity.getObject()));
 break; }
case 20: {
 //BA.debugLineNum = 289;BA.debugLine="Main.current_tamrin=8";
mostCurrent._main._current_tamrin /*int*/  = (int) (8);
 //BA.debugLineNum = 290;BA.debugLine="StartActivity(tamrin8_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin8_activity.getObject()));
 break; }
case 21: {
 //BA.debugLineNum = 292;BA.debugLine="Main.current_tamrin=13";
mostCurrent._main._current_tamrin /*int*/  = (int) (13);
 //BA.debugLineNum = 293;BA.debugLine="StartActivity(tamrin13_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin13_activity.getObject()));
 break; }
case 22: {
 //BA.debugLineNum = 295;BA.debugLine="Main.current_tamrin=14";
mostCurrent._main._current_tamrin /*int*/  = (int) (14);
 //BA.debugLineNum = 296;BA.debugLine="StartActivity(tamrin14_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin14_activity.getObject()));
 break; }
case 23: {
 //BA.debugLineNum = 298;BA.debugLine="Main.current_tamrin=16";
mostCurrent._main._current_tamrin /*int*/  = (int) (16);
 //BA.debugLineNum = 299;BA.debugLine="StartActivity(tamrin16_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin16_activity.getObject()));
 break; }
case 24: {
 //BA.debugLineNum = 301;BA.debugLine="Main.current_tamrin=19";
mostCurrent._main._current_tamrin /*int*/  = (int) (19);
 //BA.debugLineNum = 302;BA.debugLine="StartActivity(tamrin19_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin19_activity.getObject()));
 break; }
case 25: {
 //BA.debugLineNum = 304;BA.debugLine="Main.current_tamrin=22";
mostCurrent._main._current_tamrin /*int*/  = (int) (22);
 //BA.debugLineNum = 305;BA.debugLine="StartActivity(tamrin22_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin22_activity.getObject()));
 break; }
case 26: {
 //BA.debugLineNum = 308;BA.debugLine="Main.current_tamrin=25";
mostCurrent._main._current_tamrin /*int*/  = (int) (25);
 //BA.debugLineNum = 309;BA.debugLine="StartActivity(tamrin25_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin25_activity.getObject()));
 break; }
case 27: {
 //BA.debugLineNum = 311;BA.debugLine="Main.current_tamrin=27";
mostCurrent._main._current_tamrin /*int*/  = (int) (27);
 //BA.debugLineNum = 312;BA.debugLine="StartActivity(tamrin27_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin27_activity.getObject()));
 break; }
}
;
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _tamrin_name(int _num_tamrin) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub tamrin_name (num_tamrin As Int) As String";
 //BA.debugLineNum = 63;BA.debugLine="Return myFunc.get_tamrinName(num_tamrin).Get(0)";
if (true) return BA.ObjectToString(mostCurrent._myfunc._get_tamrinname /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_num_tamrin).Get((int) (0)));
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static boolean  _webview1_overrideurl(String _url) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 361;BA.debugLine="Private Sub WebView1_OverrideUrl (Url As String) A";
 //BA.debugLineNum = 363;BA.debugLine="If Url.EndsWith(\".pdf\") Then";
if (_url.endsWith(".pdf")) { 
 //BA.debugLineNum = 365;BA.debugLine="Private i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 366;BA.debugLine="i.Initialize(i.ACTION_VIEW,Url)";
_i.Initialize(_i.ACTION_VIEW,_url);
 //BA.debugLineNum = 367;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
 };
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
return false;
}
}
