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

public class do_tamrin_roz_layout extends Activity implements B4AActivity{
	public static do_tamrin_roz_layout mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.do_tamrin_roz_layout");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (do_tamrin_roz_layout).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.do_tamrin_roz_layout");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.do_tamrin_roz_layout", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (do_tamrin_roz_layout) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (do_tamrin_roz_layout) Resume **");
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
		return do_tamrin_roz_layout.class;
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
            BA.LogInfo("** Activity (do_tamrin_roz_layout) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (do_tamrin_roz_layout) Pause event (activity is not paused). **");
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
            do_tamrin_roz_layout mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (do_tamrin_roz_layout) Resume **");
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
public b4a.example3.customlistview _customlv_tamrin = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_num = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mohebat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_ealt = null;
public static int _keyboard_detection = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tamrin_roz = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.daftar_shokrgozari_activity _daftar_shokrgozari_activity = null;
public ir.taravatgroup.shokrgozari.daftar_ravabet_activity _daftar_ravabet_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
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
adr.stringfunctions.stringfunctions _strfunc = null;
anywheresoftware.b4a.objects.collections.List _ls_tamrin1_roz = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_num = null;
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"do_tamrin_roz_layout\")";
mostCurrent._activity.LoadLayout("do_tamrin_roz_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 37;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
 //BA.debugLineNum = 40;BA.debugLine="Dim ls_tamrin1_Roz As List";
_ls_tamrin1_roz = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 41;BA.debugLine="ls_tamrin1_Roz.Initialize";
_ls_tamrin1_roz.Initialize();
 //BA.debugLineNum = 42;BA.debugLine="ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(Main.curr";
_ls_tamrin1_roz = mostCurrent._myfunc._get_tamrin1_byroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ );
 //BA.debugLineNum = 44;BA.debugLine="lbl_tamrin_roz.Text=\"تمرین روز \"&Main.current_roz";
mostCurrent._lbl_tamrin_roz.setText(BA.ObjectToCharSequence("تمرین روز "+BA.NumberToString(mostCurrent._main._current_roz_tamrin /*int*/ )));
 //BA.debugLineNum = 46;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
{
final int step8 = 1;
final int limit8 = (int) (_ls_tamrin1_roz.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 48;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 49;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 140dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (140)));
 //BA.debugLineNum = 50;BA.debugLine="p.LoadLayout(\"item_list_tamrin1\")";
mostCurrent._p.LoadLayout("item_list_tamrin1",mostCurrent.activityBA);
 //BA.debugLineNum = 52;BA.debugLine="et_mohebat.Color=Colors.White";
mostCurrent._et_mohebat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 53;BA.debugLine="et_ealt.Color=Colors.White";
mostCurrent._et_ealt.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 55;BA.debugLine="CustomLV_tamrin.Add(p,i)";
mostCurrent._customlv_tamrin._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 58;BA.debugLine="Dim list_num As List";
_list_num = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 59;BA.debugLine="list_num.Initialize";
_list_num.Initialize();
 //BA.debugLineNum = 60;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
_list_num = _strfunc._vvvvvv5(BA.ObjectToString(_ls_tamrin1_roz.Get(_i)),"@");
 //BA.debugLineNum = 64;BA.debugLine="lbl_num.Text=i+1";
mostCurrent._lbl_num.setText(BA.ObjectToCharSequence(_i+1));
 //BA.debugLineNum = 66;BA.debugLine="If(list_num.Get(2)<>\"null\")Then";
if (((_list_num.Get((int) (2))).equals((Object)("null")) == false)) { 
 //BA.debugLineNum = 67;BA.debugLine="et_mohebat.Text=list_num.Get(2)";
mostCurrent._et_mohebat.setText(BA.ObjectToCharSequence(_list_num.Get((int) (2))));
 };
 //BA.debugLineNum = 69;BA.debugLine="If(list_num.Get(3)<>\"null\")Then";
if (((_list_num.Get((int) (3))).equals((Object)("null")) == false)) { 
 //BA.debugLineNum = 70;BA.debugLine="et_ealt.Text=list_num.Get(3)";
mostCurrent._et_ealt.setText(BA.ObjectToCharSequence(_list_num.Get((int) (3))));
 };
 //BA.debugLineNum = 73;BA.debugLine="et_mohebat.Tag=list_num.Get(0)";
mostCurrent._et_mohebat.setTag(_list_num.Get((int) (0)));
 //BA.debugLineNum = 74;BA.debugLine="et_ealt.Tag=list_num.Get(0)";
mostCurrent._et_ealt.setTag(_list_num.Get((int) (0)));
 }
};
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 150;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 151;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 152;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 154;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _et_ealt_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Private Sub et_ealt_FocusChanged (HasFocus As Bool";
 //BA.debugLineNum = 132;BA.debugLine="If(HasFocus=True)Then";
if ((_hasfocus==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 133;BA.debugLine="If(keyboard_detection=0)Then";
if ((_keyboard_detection==0)) { 
 //BA.debugLineNum = 134;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 135;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 //BA.debugLineNum = 136;BA.debugLine="p.Color=0x81DADADA";
mostCurrent._p.setColor(((int)0x81dadada));
 //BA.debugLineNum = 137;BA.debugLine="CustomLV_tamrin.Add(p,\"\")";
mostCurrent._customlv_tamrin._add(mostCurrent._p,(Object)(""));
 //BA.debugLineNum = 138;BA.debugLine="keyboard_detection=1";
_keyboard_detection = (int) (1);
 };
 }else {
 //BA.debugLineNum = 141;BA.debugLine="If(keyboard_detection=1)Then";
if ((_keyboard_detection==1)) { 
 //BA.debugLineNum = 142;BA.debugLine="CustomLV_tamrin.RemoveAt(10)";
mostCurrent._customlv_tamrin._removeat((int) (10));
 //BA.debugLineNum = 143;BA.debugLine="keyboard_detection=0";
_keyboard_detection = (int) (0);
 };
 };
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public static String  _et_ealt_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _this_num_tamrin = null;
 //BA.debugLineNum = 98;BA.debugLine="Private Sub et_ealt_TextChanged (Old As String, Ne";
 //BA.debugLineNum = 100;BA.debugLine="Dim this_num_tamrin As EditText=Sender";
_this_num_tamrin = new anywheresoftware.b4a.objects.EditTextWrapper();
_this_num_tamrin = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 101;BA.debugLine="myFunc.update_tamrin1_elat(this_num_tamrin.Tag,th";
mostCurrent._myfunc._update_tamrin1_elat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_num_tamrin.getTag())),_this_num_tamrin.getText(),(int) (1));
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Private Sub et_mohebat_FocusChanged (HasFocus As B";
 //BA.debugLineNum = 115;BA.debugLine="If(HasFocus=True)Then";
if ((_hasfocus==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 116;BA.debugLine="If(keyboard_detection=0)Then";
if ((_keyboard_detection==0)) { 
 //BA.debugLineNum = 117;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 118;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 //BA.debugLineNum = 119;BA.debugLine="p.Color=0x81DADADA";
mostCurrent._p.setColor(((int)0x81dadada));
 //BA.debugLineNum = 120;BA.debugLine="CustomLV_tamrin.Add(p,\"\")";
mostCurrent._customlv_tamrin._add(mostCurrent._p,(Object)(""));
 //BA.debugLineNum = 121;BA.debugLine="keyboard_detection=1";
_keyboard_detection = (int) (1);
 };
 }else {
 //BA.debugLineNum = 124;BA.debugLine="If(keyboard_detection=1)Then";
if ((_keyboard_detection==1)) { 
 //BA.debugLineNum = 125;BA.debugLine="CustomLV_tamrin.RemoveAt(10)";
mostCurrent._customlv_tamrin._removeat((int) (10));
 //BA.debugLineNum = 126;BA.debugLine="keyboard_detection=0";
_keyboard_detection = (int) (0);
 };
 };
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _et_mohebat_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _this_num_tamrin = null;
 //BA.debugLineNum = 106;BA.debugLine="Private Sub et_mohebat_TextChanged (Old As String,";
 //BA.debugLineNum = 108;BA.debugLine="Dim this_num_tamrin As EditText=Sender";
_this_num_tamrin = new anywheresoftware.b4a.objects.EditTextWrapper();
_this_num_tamrin = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 109;BA.debugLine="myFunc.update_tamrin1_mohebat(this_num_tamrin.Tag";
mostCurrent._myfunc._update_tamrin1_mohebat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_num_tamrin.getTag())),_this_num_tamrin.getText(),(int) (1));
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private CustomLV_tamrin As CustomListView";
mostCurrent._customlv_tamrin = new b4a.example3.customlistview();
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 20;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_num As Label";
mostCurrent._lbl_num = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private et_mohebat As EditText";
mostCurrent._et_mohebat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private et_ealt As EditText";
mostCurrent._et_ealt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim keyboard_detection As Int=0";
_keyboard_detection = (int) (0);
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_tamrin_roz As Label";
mostCurrent._lbl_tamrin_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
