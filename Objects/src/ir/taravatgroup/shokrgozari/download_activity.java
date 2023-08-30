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

public class download_activity extends Activity implements B4AActivity{
	public static download_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.download_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (download_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.download_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.download_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (download_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (download_activity) Resume **");
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
		return download_activity.class;
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
            BA.LogInfo("** Activity (download_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (download_activity) Pause event (activity is not paused). **");
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
            download_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (download_activity) Resume **");
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
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public b4a.example3.customlistview _customlistview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_download = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_down_del = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_donw_title = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_donw_detile = null;
public adr.stringfunctions.stringfunctions _strfunc = null;
public ir.taravatgroup.shokrgozari.httpjob _j = null;
public anywheresoftware.b4a.objects.collections.List _list_download = null;
public static String _current_down_name = "";
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
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
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="Activity.LoadLayout(\"download_layout\")";
mostCurrent._activity.LoadLayout("download_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="strFunc.Initialize";
mostCurrent._strfunc._initialize(processBA);
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="j.Initialize(\"job\", Me)";
mostCurrent._j._initialize /*String*/ (null,processBA,"job",download_activity.getObject());
RDebugUtils.currentLine=9371654;
 //BA.debugLineNum = 9371654;BA.debugLine="list_download.Initialize";
mostCurrent._list_download.Initialize();
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9633797;
 //BA.debugLineNum = 9633797;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=9633799;
 //BA.debugLineNum = 9633799;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="download_activity";
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list", null));}
anywheresoftware.b4a.objects.collections.List _list_fehrest = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_row = null;
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub fill_list";
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="CustomListView1.Clear";
mostCurrent._customlistview1._clear();
RDebugUtils.currentLine=9830404;
 //BA.debugLineNum = 9830404;BA.debugLine="Dim list_fehrest As List";
_list_fehrest = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="list_fehrest.Initialize";
_list_fehrest.Initialize();
RDebugUtils.currentLine=9830406;
 //BA.debugLineNum = 9830406;BA.debugLine="list_fehrest=myFunc.get_download_list";
_list_fehrest = mostCurrent._myfunc._get_download_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=9830409;
 //BA.debugLineNum = 9830409;BA.debugLine="For i=0 To list_fehrest.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_list_fehrest.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=9830411;
 //BA.debugLineNum = 9830411;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=9830413;
 //BA.debugLineNum = 9830413;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
RDebugUtils.currentLine=9830414;
 //BA.debugLineNum = 9830414;BA.debugLine="p.LoadLayout(\"item_list_downloads\")";
mostCurrent._p.LoadLayout("item_list_downloads",mostCurrent.activityBA);
RDebugUtils.currentLine=9830417;
 //BA.debugLineNum = 9830417;BA.debugLine="CustomListView1.Add(p,i)";
mostCurrent._customlistview1._add(mostCurrent._p,(Object)(_i));
RDebugUtils.currentLine=9830420;
 //BA.debugLineNum = 9830420;BA.debugLine="Dim list_row As List";
_list_row = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9830421;
 //BA.debugLineNum = 9830421;BA.debugLine="list_row.Initialize";
_list_row.Initialize();
RDebugUtils.currentLine=9830422;
 //BA.debugLineNum = 9830422;BA.debugLine="list_row=strFunc.Split(list_fehrest.Get(i) , \"@\"";
_list_row = mostCurrent._strfunc._vvvvvv5(BA.ObjectToString(_list_fehrest.Get(_i)),"@");
RDebugUtils.currentLine=9830425;
 //BA.debugLineNum = 9830425;BA.debugLine="lbl_donw_title.Text=\" \"&list_row.Get(1)";
mostCurrent._lbl_donw_title.setText(BA.ObjectToCharSequence(" "+BA.ObjectToString(_list_row.Get((int) (1)))));
RDebugUtils.currentLine=9830426;
 //BA.debugLineNum = 9830426;BA.debugLine="lbl_donw_detile.Text=\" \"&list_row.Get(2)";
mostCurrent._lbl_donw_detile.setText(BA.ObjectToCharSequence(" "+BA.ObjectToString(_list_row.Get((int) (2)))));
RDebugUtils.currentLine=9830428;
 //BA.debugLineNum = 9830428;BA.debugLine="pan_download.Tag=list_row.Get(0)";
mostCurrent._pan_download.setTag(_list_row.Get((int) (0)));
RDebugUtils.currentLine=9830430;
 //BA.debugLineNum = 9830430;BA.debugLine="If(File.Exists(File.DirInternal,list_row.Get(3))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_list_row.Get((int) (3)))))) { 
RDebugUtils.currentLine=9830431;
 //BA.debugLineNum = 9830431;BA.debugLine="lbl_down_del.Text=Chr(0xF014)  'delete icon";
mostCurrent._lbl_down_del.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf014))));
RDebugUtils.currentLine=9830432;
 //BA.debugLineNum = 9830432;BA.debugLine="lbl_down_del.textColor=0xFFFF5050";
mostCurrent._lbl_down_del.setTextColor(((int)0xffff5050));
RDebugUtils.currentLine=9830433;
 //BA.debugLineNum = 9830433;BA.debugLine="lbl_down_del.Tag=\"del@\"&list_row.Get(3)";
mostCurrent._lbl_down_del.setTag((Object)("del@"+BA.ObjectToString(_list_row.Get((int) (3)))));
 }else {
RDebugUtils.currentLine=9830436;
 //BA.debugLineNum = 9830436;BA.debugLine="lbl_down_del.Text=Chr(0xF019)  'download icon";
mostCurrent._lbl_down_del.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf019))));
RDebugUtils.currentLine=9830437;
 //BA.debugLineNum = 9830437;BA.debugLine="lbl_down_del.textColor=0xFF0CA300";
mostCurrent._lbl_down_del.setTextColor(((int)0xff0ca300));
RDebugUtils.currentLine=9830438;
 //BA.debugLineNum = 9830438;BA.debugLine="lbl_down_del.Tag=\"down@\"&list_row.Get(3)";
mostCurrent._lbl_down_del.setTag((Object)("down@"+BA.ObjectToString(_list_row.Get((int) (3)))));
 };
 }
};
RDebugUtils.currentLine=9830444;
 //BA.debugLineNum = 9830444;BA.debugLine="End Sub";
return "";
}
public static String  _delete_filebyname(String _name) throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "delete_filebyname", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "delete_filebyname", new Object[] {_name}));}
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub delete_fileByName(name As String)";
RDebugUtils.currentLine=9961473;
 //BA.debugLineNum = 9961473;BA.debugLine="If(File.Exists(File.DirInternal,name))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name))) { 
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="File.Delete(File.DirInternal,name)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name);
RDebugUtils.currentLine=9961475;
 //BA.debugLineNum = 9961475;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=9961476;
 //BA.debugLineNum = 9961476;BA.debugLine="ToastMessageShow(\"فایل صوتی حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فایل صوتی حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=9961481;
 //BA.debugLineNum = 9961481;BA.debugLine="End Sub";
return "";
}
public static void  _download_byname() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "download_byname", false))
	 {Debug.delegate(mostCurrent.activityBA, "download_byname", null); return;}
ResumableSub_download_byName rsub = new ResumableSub_download_byName(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_download_byName extends BA.ResumableSub {
public ResumableSub_download_byName(ir.taravatgroup.shokrgozari.download_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.download_activity parent;
ir.taravatgroup.shokrgozari.httpjob _job = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="download_activity";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="j.Download(\"https://m2ebadi.whi.ir/shokrgozari/s";
parent.mostCurrent._j._download /*String*/ (null,"https://m2ebadi.whi.ir/shokrgozari/sounds/"+parent.mostCurrent._current_down_name);
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="Wait For JobDone(job As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "download_activity", "download_byname"), null);
this.state = 17;
return;
case 17:
//C
this.state = 4;
_job = (ir.taravatgroup.shokrgozari.httpjob) result[0];
;
RDebugUtils.currentLine=9895944;
 //BA.debugLineNum = 9895944;BA.debugLine="If j.Success Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent.mostCurrent._j._success /*boolean*/ ) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=9895946;
 //BA.debugLineNum = 9895946;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._current_down_name,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9895947;
 //BA.debugLineNum = 9895947;BA.debugLine="File.Copy2(job.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_job._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (null).getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=9895948;
 //BA.debugLineNum = 9895948;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=9895950;
 //BA.debugLineNum = 9895950;BA.debugLine="current_down_name=\"\"";
parent.mostCurrent._current_down_name = "";
 if (true) break;

case 7:
//C
this.state = 8;
;
RDebugUtils.currentLine=9895952;
 //BA.debugLineNum = 9895952;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=9895954;
 //BA.debugLineNum = 9895954;BA.debugLine="If(list_download.Size<>0)Then";
if (true) break;

case 8:
//if
this.state = 13;
if ((parent.mostCurrent._list_download.getSize()!=0)) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 13;
RDebugUtils.currentLine=9895955;
 //BA.debugLineNum = 9895955;BA.debugLine="current_down_name=list_download.Get(0)";
parent.mostCurrent._current_down_name = BA.ObjectToString(parent.mostCurrent._list_download.Get((int) (0)));
RDebugUtils.currentLine=9895956;
 //BA.debugLineNum = 9895956;BA.debugLine="list_download.RemoveAt(0)";
parent.mostCurrent._list_download.RemoveAt((int) (0));
RDebugUtils.currentLine=9895957;
 //BA.debugLineNum = 9895957;BA.debugLine="download_byName";
_download_byname();
 if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=9895959;
 //BA.debugLineNum = 9895959;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=9895960;
 //BA.debugLineNum = 9895960;BA.debugLine="ToastMessageShow(\"فایلهای صوتی دانلود شدند.\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فایلهای صوتی دانلود شدند."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
RDebugUtils.currentLine=9895965;
 //BA.debugLineNum = 9895965;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("49895965",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=9895966;
 //BA.debugLineNum = 9895966;BA.debugLine="ToastMessageShow(\"منتظر باشید ..\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("منتظر باشید .."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=9895969;
 //BA.debugLineNum = 9895969;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _lbl_down_del_click() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_down_del_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lbl_down_del_click", null); return;}
ResumableSub_lbl_down_del_Click rsub = new ResumableSub_lbl_down_del_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_down_del_Click extends BA.ResumableSub {
public ResumableSub_lbl_down_del_Click(ir.taravatgroup.shokrgozari.download_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.download_activity parent;
anywheresoftware.b4a.objects.LabelWrapper _func_del_down = null;
anywheresoftware.b4a.objects.collections.List _list_row_mod = null;
anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="download_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="Dim func_del_down As Label=Sender";
_func_del_down = new anywheresoftware.b4a.objects.LabelWrapper();
_func_del_down = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=9699332;
 //BA.debugLineNum = 9699332;BA.debugLine="Dim list_row_mod As List";
_list_row_mod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9699333;
 //BA.debugLineNum = 9699333;BA.debugLine="list_row_mod.Initialize";
_list_row_mod.Initialize();
RDebugUtils.currentLine=9699334;
 //BA.debugLineNum = 9699334;BA.debugLine="list_row_mod=strFunc.Split(func_del_down.Tag , \"@";
_list_row_mod = parent.mostCurrent._strfunc._vvvvvv5(BA.ObjectToString(_func_del_down.getTag()),"@");
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="If(list_row_mod.Get(0)=\"down\")Then";
if (true) break;

case 1:
//if
this.state = 18;
if (((_list_row_mod.Get((int) (0))).equals((Object)("down")))) { 
this.state = 3;
}else {
this.state = 17;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=9699338;
 //BA.debugLineNum = 9699338;BA.debugLine="Dim rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=9699339;
 //BA.debugLineNum = 9699339;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
_rp.CheckAndRequest(processBA,_rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
RDebugUtils.currentLine=9699340;
 //BA.debugLineNum = 9699340;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "download_activity", "lbl_down_del_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=9699341;
 //BA.debugLineNum = 9699341;BA.debugLine="If Result Then";
if (true) break;

case 4:
//if
this.state = 9;
if (_result) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 if (true) break;

case 8:
//C
this.state = 9;
 if (true) break;

case 9:
//C
this.state = 10;
;
RDebugUtils.currentLine=9699347;
 //BA.debugLineNum = 9699347;BA.debugLine="func_del_down.Text=Chr(0xF1CE)  'downloading";
_func_del_down.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf1ce))));
RDebugUtils.currentLine=9699348;
 //BA.debugLineNum = 9699348;BA.debugLine="myFunc.setRotation(func_del_down,10000,360)";
parent.mostCurrent._myfunc._setrotation /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_func_del_down.getObject())),(int) (10000),(float) (360));
RDebugUtils.currentLine=9699349;
 //BA.debugLineNum = 9699349;BA.debugLine="func_del_down.SetTextColorAnimated(300,Colors.Bl";
_func_del_down.SetTextColorAnimated((int) (300),anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=9699354;
 //BA.debugLineNum = 9699354;BA.debugLine="If (current_down_name=\"\")Then";
if (true) break;

case 10:
//if
this.state = 15;
if (((parent.mostCurrent._current_down_name).equals(""))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
RDebugUtils.currentLine=9699355;
 //BA.debugLineNum = 9699355;BA.debugLine="current_down_name=list_row_mod.Get(1)";
parent.mostCurrent._current_down_name = BA.ObjectToString(_list_row_mod.Get((int) (1)));
RDebugUtils.currentLine=9699356;
 //BA.debugLineNum = 9699356;BA.debugLine="download_byName";
_download_byname();
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=9699358;
 //BA.debugLineNum = 9699358;BA.debugLine="list_download.Add(list_row_mod.Get(1))";
parent.mostCurrent._list_download.Add(_list_row_mod.Get((int) (1)));
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=9699368;
 //BA.debugLineNum = 9699368;BA.debugLine="delete_fileByName(list_row_mod.Get(1))";
_delete_filebyname(BA.ObjectToString(_list_row_mod.Get((int) (1))));
 if (true) break;

case 18:
//C
this.state = -1;
;
RDebugUtils.currentLine=9699371;
 //BA.debugLineNum = 9699371;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _pan_download_click() throws Exception{
RDebugUtils.currentModule="download_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_download_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_download_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _go_to_readingbook = null;
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Private Sub pan_download_Click";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="Dim go_to_readingBook As Panel=Sender";
_go_to_readingbook = new anywheresoftware.b4a.objects.PanelWrapper();
_go_to_readingbook = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=9764867;
 //BA.debugLineNum = 9764867;BA.debugLine="Main.current_book_content_id=go_to_readingBook.Ta";
mostCurrent._main._current_book_content_id /*int*/  = (int)(BA.ObjectToNumber(_go_to_readingbook.getTag()));
RDebugUtils.currentLine=9764869;
 //BA.debugLineNum = 9764869;BA.debugLine="StartActivity(reagBook_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._reagbook_activity.getObject()));
RDebugUtils.currentLine=9764871;
 //BA.debugLineNum = 9764871;BA.debugLine="End Sub";
return "";
}
}