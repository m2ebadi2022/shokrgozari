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

public class book_activity extends Activity implements B4AActivity{
	public static book_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.book_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (book_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.book_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.book_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (book_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (book_activity) Resume **");
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
		return book_activity.class;
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
            BA.LogInfo("** Activity (book_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (book_activity) Pause event (activity is not paused). **");
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
            book_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (book_activity) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _tim_scroll2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public b4a.example3.customlistview _customlistview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_roz = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_roz = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_pic = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_fav = null;
public static int _pos_scroll = 0;
public static boolean _isfitest = false;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.daftar_shokrgozari_activity _daftar_shokrgozari_activity = null;
public ir.taravatgroup.shokrgozari.daftar_ravabet_activity _daftar_ravabet_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
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
 //BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"book_layout\")";
mostCurrent._activity.LoadLayout("book_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 40;BA.debugLine="tim_scroll2.Initialize(\"tim_scroll2\",300)";
_tim_scroll2.Initialize(processBA,"tim_scroll2",(long) (300));
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 62;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 63;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 64;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 66;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 47;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_fehrest = null;
adr.stringfunctions.stringfunctions _strfunc = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_row = null;
int _temp_red = 0;
int _id_temp_read = 0;
 //BA.debugLineNum = 83;BA.debugLine="Sub fill_list";
 //BA.debugLineNum = 85;BA.debugLine="CustomListView1.Clear";
mostCurrent._customlistview1._clear();
 //BA.debugLineNum = 87;BA.debugLine="Dim list_fehrest As List";
_list_fehrest = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 88;BA.debugLine="list_fehrest.Initialize";
_list_fehrest.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="list_fehrest=myFunc.get_fehrest";
_list_fehrest = mostCurrent._myfunc._get_fehrest /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 91;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 92;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
 //BA.debugLineNum = 95;BA.debugLine="For i=0 To list_fehrest.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (_list_fehrest.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 97;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 99;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
 //BA.debugLineNum = 100;BA.debugLine="p.LoadLayout(\"item_list_rozha_tamrin\")";
mostCurrent._p.LoadLayout("item_list_rozha_tamrin",mostCurrent.activityBA);
 //BA.debugLineNum = 103;BA.debugLine="CustomListView1.Add(p,i)";
mostCurrent._customlistview1._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 106;BA.debugLine="Dim list_row As List";
_list_row = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 107;BA.debugLine="list_row.Initialize";
_list_row.Initialize();
 //BA.debugLineNum = 108;BA.debugLine="list_row=strFunc.Split(list_fehrest.Get(i) , \"@\"";
_list_row = _strfunc._vvvvvv5(BA.ObjectToString(_list_fehrest.Get(_i)),"@");
 //BA.debugLineNum = 112;BA.debugLine="lbl_roz.Text=list_row.Get(1)";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_list_row.Get((int) (1))));
 //BA.debugLineNum = 114;BA.debugLine="pan_roz.Tag=list_row.Get(0)";
mostCurrent._pan_roz.setTag(_list_row.Get((int) (0)));
 //BA.debugLineNum = 118;BA.debugLine="pan_pic.Visible=True";
mostCurrent._pan_pic.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 120;BA.debugLine="pan_pic.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._pan_pic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.ObjectToString(_list_row.Get((int) (3)))).getObject()));
 //BA.debugLineNum = 123;BA.debugLine="lbl_icon_fav.Visible=True";
mostCurrent._lbl_icon_fav.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 124;BA.debugLine="lbl_icon_fav.Tag=list_row.Get(0)";
mostCurrent._lbl_icon_fav.setTag(_list_row.Get((int) (0)));
 //BA.debugLineNum = 125;BA.debugLine="If(list_row.Get(2).As(Int)=1)Then";
if ((((int)(BA.ObjectToNumber(_list_row.Get((int) (2)))))==1)) { 
 //BA.debugLineNum = 126;BA.debugLine="lbl_icon_fav.Text=Chr(0xF004)";
mostCurrent._lbl_icon_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
 //BA.debugLineNum = 127;BA.debugLine="lbl_icon_fav.TextColor=0xFFFF3838";
mostCurrent._lbl_icon_fav.setTextColor(((int)0xffff3838));
 }else {
 //BA.debugLineNum = 129;BA.debugLine="lbl_icon_fav.Text=Chr(0xF08A)";
mostCurrent._lbl_icon_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
 //BA.debugLineNum = 130;BA.debugLine="lbl_icon_fav.TextColor=0xFF686868";
mostCurrent._lbl_icon_fav.setTextColor(((int)0xff686868));
 };
 //BA.debugLineNum = 136;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_read.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_read.txt"))) { 
 //BA.debugLineNum = 137;BA.debugLine="Dim temp_red As Int=File.ReadString(File.DirIn";
_temp_red = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_read.txt")));
 //BA.debugLineNum = 138;BA.debugLine="Dim id_temp_read As Int=pan_roz.Tag";
_id_temp_read = (int)(BA.ObjectToNumber(mostCurrent._pan_roz.getTag()));
 //BA.debugLineNum = 140;BA.debugLine="If((id_temp_read)=temp_red)Then";
if (((_id_temp_read)==_temp_red)) { 
 //BA.debugLineNum = 141;BA.debugLine="lbl_icon_roz.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_icon_roz.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 142;BA.debugLine="lbl_icon_roz.TextColor=0xFF0FA900";
mostCurrent._lbl_icon_roz.setTextColor(((int)0xff0fa900));
 //BA.debugLineNum = 143;BA.debugLine="lbl_icon_roz.Text=Chr(0xE866)";
mostCurrent._lbl_icon_roz.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe866))));
 //BA.debugLineNum = 145;BA.debugLine="lbl_icon_roz.Visible=True";
mostCurrent._lbl_icon_roz.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 146;BA.debugLine="pos_scroll=i";
_pos_scroll = _i;
 }else {
 //BA.debugLineNum = 148;BA.debugLine="lbl_icon_roz.Visible=False";
mostCurrent._lbl_icon_roz.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 }
};
 //BA.debugLineNum = 156;BA.debugLine="If (isfitest=True)Then";
if ((_isfitest==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 157;BA.debugLine="tim_scroll2.Enabled=True";
_tim_scroll2.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private CustomListView1 As CustomListView";
mostCurrent._customlistview1 = new b4a.example3.customlistview();
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_roz As Label";
mostCurrent._lbl_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_icon_roz As Label";
mostCurrent._lbl_icon_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private pan_roz As Panel";
mostCurrent._pan_roz = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private pan_pic As Panel";
mostCurrent._pan_pic = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_icon_fav As Label";
mostCurrent._lbl_icon_fav = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim pos_scroll As Int=0";
_pos_scroll = (int) (0);
 //BA.debugLineNum = 29;BA.debugLine="Dim isfitest As Boolean=True";
_isfitest = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 56;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_icon_fav_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _this_roz_fav = null;
int _fav_state = 0;
 //BA.debugLineNum = 165;BA.debugLine="Private Sub lbl_icon_fav_Click";
 //BA.debugLineNum = 166;BA.debugLine="Dim this_roz_fav As Label=Sender";
_this_roz_fav = new anywheresoftware.b4a.objects.LabelWrapper();
_this_roz_fav = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 170;BA.debugLine="Dim fav_state As Int = myFunc.get_fav_byId(this_r";
_fav_state = mostCurrent._myfunc._get_fav_byid /*int*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_roz_fav.getTag())));
 //BA.debugLineNum = 173;BA.debugLine="If(fav_state=1)Then";
if ((_fav_state==1)) { 
 //BA.debugLineNum = 175;BA.debugLine="myFunc.set_fav_book(this_roz_fav.Tag,0)";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_roz_fav.getTag())),(int) (0));
 //BA.debugLineNum = 176;BA.debugLine="this_roz_fav.Text=Chr(0xF08A)";
_this_roz_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
 //BA.debugLineNum = 177;BA.debugLine="this_roz_fav.TextColor=0xFF686868";
_this_roz_fav.setTextColor(((int)0xff686868));
 }else {
 //BA.debugLineNum = 179;BA.debugLine="myFunc.set_fav_book(this_roz_fav.Tag,1)";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_roz_fav.getTag())),(int) (1));
 //BA.debugLineNum = 180;BA.debugLine="this_roz_fav.Text=Chr(0xF004)";
_this_roz_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
 //BA.debugLineNum = 181;BA.debugLine="this_roz_fav.TextColor=0xFFFF3838";
_this_roz_fav.setTextColor(((int)0xffff3838));
 };
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public static String  _pan_roz_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _this_roz = null;
 //BA.debugLineNum = 71;BA.debugLine="Private Sub pan_roz_Click";
 //BA.debugLineNum = 72;BA.debugLine="Dim this_roz As Panel=Sender";
_this_roz = new anywheresoftware.b4a.objects.PanelWrapper();
_this_roz = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 74;BA.debugLine="Main.current_book_content_id=this_roz.Tag";
mostCurrent._main._current_book_content_id /*int*/  = (int)(BA.ObjectToNumber(_this_roz.getTag()));
 //BA.debugLineNum = 75;BA.debugLine="isfitest=False";
_isfitest = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 76;BA.debugLine="StartActivity(reagBook_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._reagbook_activity.getObject()));
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim tim_scroll2 As Timer";
_tim_scroll2 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _tim_scroll2_tick() throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Sub tim_scroll2_Tick";
 //BA.debugLineNum = 193;BA.debugLine="CustomListView1.ScrollToItem(pos_scroll)";
mostCurrent._customlistview1._scrolltoitem(_pos_scroll);
 //BA.debugLineNum = 194;BA.debugLine="tim_scroll2.Enabled=False";
_tim_scroll2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
}
