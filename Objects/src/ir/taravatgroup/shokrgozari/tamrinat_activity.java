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

public class tamrinat_activity extends Activity implements B4AActivity{
	public static tamrinat_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrinat_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrinat_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrinat_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrinat_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrinat_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrinat_activity) Resume **");
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
		return tamrinat_activity.class;
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
            BA.LogInfo("** Activity (tamrinat_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrinat_activity) Pause event (activity is not paused). **");
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
            tamrinat_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrinat_activity) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _tim_scroll = null;
public b4a.example3.customlistview _cuslistv_data = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public static int _pos_scroll = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_roz = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_roz = null;
public static boolean _isfitest = false;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
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
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Activity.LoadLayout(\"tamrinat_layout\")";
mostCurrent._activity.LoadLayout("tamrinat_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="tim_scroll.Initialize(\"tim_scroll\",300)";
_tim_scroll.Initialize(processBA,"tim_scroll",(long) (300));
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="fill_list";
_fill_list();
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list", null));}
anywheresoftware.b4a.objects.collections.List _list_rozha = null;
adr.stringfunctions.stringfunctions _strfunc = null;
anywheresoftware.b4a.objects.collections.List _list_roz = null;
int _i = 0;
int _code_state = 0;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub fill_list";
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="cusListV_data.Clear";
mostCurrent._cuslistv_data._clear();
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Dim list_rozha As List";
_list_rozha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="list_rozha.Initialize";
_list_rozha.Initialize();
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="list_rozha=myFunc.get_rozha";
_list_rozha = mostCurrent._myfunc._get_rozha /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="Dim list_roz As List";
_list_roz = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="list_roz.Initialize";
_list_roz.Initialize();
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="For i=0 To list_rozha.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_list_rozha.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=6094864;
 //BA.debugLineNum = 6094864;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
RDebugUtils.currentLine=6094867;
 //BA.debugLineNum = 6094867;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
mostCurrent._p.LoadLayout("item_list_rozha_tamrin",mostCurrent.activityBA);
RDebugUtils.currentLine=6094870;
 //BA.debugLineNum = 6094870;BA.debugLine="cusListV_data.Add(p,i)";
mostCurrent._cuslistv_data._add(mostCurrent._p,(Object)(_i));
RDebugUtils.currentLine=6094873;
 //BA.debugLineNum = 6094873;BA.debugLine="Dim list_roz As List";
_list_roz = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6094874;
 //BA.debugLineNum = 6094874;BA.debugLine="list_roz.Initialize";
_list_roz.Initialize();
RDebugUtils.currentLine=6094875;
 //BA.debugLineNum = 6094875;BA.debugLine="list_roz=strFunc.Split(list_rozha.Get(i) , \"@\")";
_list_roz = _strfunc._vvvvvv5(BA.ObjectToString(_list_rozha.Get(_i)),"@");
RDebugUtils.currentLine=6094878;
 //BA.debugLineNum = 6094878;BA.debugLine="lbl_roz.Text=list_roz.Get(0)";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_list_roz.Get((int) (0))));
RDebugUtils.currentLine=6094880;
 //BA.debugLineNum = 6094880;BA.debugLine="pan_roz.Tag=i+1";
mostCurrent._pan_roz.setTag((Object)(_i+1));
RDebugUtils.currentLine=6094882;
 //BA.debugLineNum = 6094882;BA.debugLine="Dim code_state As Int = myFunc.get_State_tamrin1";
_code_state = mostCurrent._myfunc._get_state_tamrin1_byroz /*int*/ (mostCurrent.activityBA,(int) (_i+1));
RDebugUtils.currentLine=6094883;
 //BA.debugLineNum = 6094883;BA.debugLine="If(code_state=10)Then";
if ((_code_state==10)) { 
RDebugUtils.currentLine=6094884;
 //BA.debugLineNum = 6094884;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
RDebugUtils.currentLine=6094885;
 //BA.debugLineNum = 6094885;BA.debugLine="lbl_icon_roz.Visible=True";
mostCurrent._lbl_icon_roz.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=6094887;
 //BA.debugLineNum = 6094887;BA.debugLine="Else If(code_state = 0 )Then";
if ((_code_state==0)) { 
RDebugUtils.currentLine=6094888;
 //BA.debugLineNum = 6094888;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF211F";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff211f));
RDebugUtils.currentLine=6094890;
 //BA.debugLineNum = 6094890;BA.debugLine="If(pos_scroll= 0)Then";
if ((_pos_scroll==0)) { 
RDebugUtils.currentLine=6094891;
 //BA.debugLineNum = 6094891;BA.debugLine="pos_scroll=i";
_pos_scroll = _i;
 };
 }else {
RDebugUtils.currentLine=6094898;
 //BA.debugLineNum = 6094898;BA.debugLine="lbl_icon_roz.Visible=True";
mostCurrent._lbl_icon_roz.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6094899;
 //BA.debugLineNum = 6094899;BA.debugLine="lbl_icon_roz.TextColor=0xFFFF9900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xffff9900));
 }}
;
 }
};
RDebugUtils.currentLine=6094905;
 //BA.debugLineNum = 6094905;BA.debugLine="If (isfitest=True)Then";
if ((_isfitest==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=6094906;
 //BA.debugLineNum = 6094906;BA.debugLine="tim_scroll.Enabled=True";
_tim_scroll.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=6094911;
 //BA.debugLineNum = 6094911;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="End Sub";
return "";
}
public static String  _pan_roz_click() throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_roz_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _this_roz = null;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Private Sub pan_roz_Click";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim this_roz As Panel=Sender";
_this_roz = new anywheresoftware.b4a.objects.PanelWrapper();
_this_roz = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="Main.current_roz_tamrin=this_roz.Tag";
mostCurrent._main._current_roz_tamrin /*int*/  = (int)(BA.ObjectToNumber(_this_roz.getTag()));
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="isfitest=False";
_isfitest = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="StartActivity(tamrin_roz_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin_roz_activity.getObject()));
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="End Sub";
return "";
}
public static String  _tim_scroll_tick() throws Exception{
RDebugUtils.currentModule="tamrinat_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_scroll_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_scroll_tick", null));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub tim_scroll_Tick";
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="cusListV_data.ScrollToItem(pos_scroll)";
mostCurrent._cuslistv_data._scrolltoitem(_pos_scroll);
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="tim_scroll.Enabled=False";
_tim_scroll.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="End Sub";
return "";
}
}