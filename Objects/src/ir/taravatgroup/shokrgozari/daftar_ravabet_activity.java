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

public class daftar_ravabet_activity extends Activity implements B4AActivity{
	public static daftar_ravabet_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.daftar_ravabet_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (daftar_ravabet_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.daftar_ravabet_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.daftar_ravabet_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (daftar_ravabet_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (daftar_ravabet_activity) Resume **");
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
		return daftar_ravabet_activity.class;
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
            BA.LogInfo("** Activity (daftar_ravabet_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (daftar_ravabet_activity) Pause event (activity is not paused). **");
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
            daftar_ravabet_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (daftar_ravabet_activity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tamrin_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_add_new = null;
public static int _list_reload = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_upload_pic1 = null;
public static int _pic_upload_index = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_showpic = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_showpic = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tajrobiat_activity _tajrobiat_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.daftar_shokrgozari_activity _daftar_shokrgozari_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
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
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"do_tamrin_roz_layout\")";
mostCurrent._activity.LoadLayout("do_tamrin_roz_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 44;BA.debugLine="lbl_add_new.Visible=True";
mostCurrent._lbl_add_new.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 45;BA.debugLine="Main.Chooser.Initialize(\"chooser\")";
mostCurrent._main._chooser /*anywheresoftware.b4a.phone.Phone.ContentChooser*/ .Initialize("chooser");
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 145;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 146;BA.debugLine="If(pan_all_showPic.Visible=True)Then";
if ((mostCurrent._pan_all_showpic.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 147;BA.debugLine="pan_all_showPic.Visible=False";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 149;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 151;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 153;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 51;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _chooser_result(boolean _success,String _dir,String _filename) throws Exception{
 //BA.debugLineNum = 200;BA.debugLine="Sub chooser_Result (Success As Boolean, Dir As Str";
 //BA.debugLineNum = 201;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 203;BA.debugLine="myFunc.update_daftar_ravabet_pic(pic_upload_inde";
mostCurrent._myfunc._update_daftar_ravabet_pic /*boolean*/ (mostCurrent.activityBA,_pic_upload_index,"pic_"+BA.NumberToString(_pic_upload_index)+".jpg");
 //BA.debugLineNum = 206;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_\"&p";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_"+BA.NumberToString(_pic_upload_index)+".jpg");
 //BA.debugLineNum = 208;BA.debugLine="fill_list";
_fill_list();
 }else {
 //BA.debugLineNum = 210;BA.debugLine="ToastMessageShow(\"No image selected\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn1_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _this_num_tamrin = null;
 //BA.debugLineNum = 128;BA.debugLine="Private Sub et_matn1_TextChanged (Old As String, N";
 //BA.debugLineNum = 129;BA.debugLine="If(list_reload=0)Then";
if ((_list_reload==0)) { 
 //BA.debugLineNum = 130;BA.debugLine="Dim this_num_tamrin As EditText=Sender";
_this_num_tamrin = new anywheresoftware.b4a.objects.EditTextWrapper();
_this_num_tamrin = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 131;BA.debugLine="If(et_matn1.Text<>\"\" Or et_matn1.Text<>Null)Then";
if (((mostCurrent._et_matn1.getText()).equals("") == false || mostCurrent._et_matn1.getText()!= null)) { 
 //BA.debugLineNum = 132;BA.debugLine="myFunc.update_daftar_ravabet(this_num_tamrin.Ta";
mostCurrent._myfunc._update_daftar_ravabet /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_num_tamrin.getTag())),_this_num_tamrin.getText(),(int) (1));
 };
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list() throws Exception{
adr.stringfunctions.stringfunctions _strfunc = null;
anywheresoftware.b4a.objects.collections.List _ls_tamrin1_roz = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_num = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub fill_list";
 //BA.debugLineNum = 60;BA.debugLine="list_reload=1";
_list_reload = (int) (1);
 //BA.debugLineNum = 61;BA.debugLine="CustomLV_tamrin.Clear";
mostCurrent._customlv_tamrin._clear();
 //BA.debugLineNum = 63;BA.debugLine="Dim strFunc As StringFunctions";
_strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 64;BA.debugLine="strFunc.Initialize";
_strfunc._initialize(processBA);
 //BA.debugLineNum = 67;BA.debugLine="Dim ls_tamrin1_Roz As List";
_ls_tamrin1_roz = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 68;BA.debugLine="ls_tamrin1_Roz.Initialize";
_ls_tamrin1_roz.Initialize();
 //BA.debugLineNum = 69;BA.debugLine="ls_tamrin1_Roz=myFunc.get_daftar_ravabet_byShenas";
_ls_tamrin1_roz = mostCurrent._myfunc._get_daftar_ravabet_byshenase /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._daftar_shenase /*String*/ );
 //BA.debugLineNum = 71;BA.debugLine="lbl_tamrin_roz.Text=myFunc.get_daftar_shenase_tit";
mostCurrent._lbl_tamrin_roz.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_daftar_shenase_titel /*String*/ (mostCurrent.activityBA,mostCurrent._main._daftar_shenase /*String*/ )));
 //BA.debugLineNum = 73;BA.debugLine="For i=0 To ls_tamrin1_Roz.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_ls_tamrin1_roz.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 75;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 76;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 146dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (146)));
 //BA.debugLineNum = 77;BA.debugLine="p.LoadLayout(\"item_list_daftar_ravabet\")";
mostCurrent._p.LoadLayout("item_list_daftar_ravabet",mostCurrent.activityBA);
 //BA.debugLineNum = 79;BA.debugLine="et_matn1.Color=Colors.White";
mostCurrent._et_matn1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 82;BA.debugLine="CustomLV_tamrin.Add(p,i)";
mostCurrent._customlv_tamrin._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 85;BA.debugLine="Dim list_num As List";
_list_num = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 86;BA.debugLine="list_num.Initialize";
_list_num.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , \"";
_list_num = _strfunc._vvvvvv5(BA.ObjectToString(_ls_tamrin1_roz.Get(_i)),"@");
 //BA.debugLineNum = 89;BA.debugLine="pan_upload_pic1.Tag=list_num.Get(0)";
mostCurrent._pan_upload_pic1.setTag(_list_num.Get((int) (0)));
 //BA.debugLineNum = 90;BA.debugLine="lbl_num.Tag=list_num.Get(0)";
mostCurrent._lbl_num.setTag(_list_num.Get((int) (0)));
 //BA.debugLineNum = 91;BA.debugLine="lbl_num.Text=i+1";
mostCurrent._lbl_num.setText(BA.ObjectToCharSequence(_i+1));
 //BA.debugLineNum = 93;BA.debugLine="If(list_num.Get(3)<>\"null\")Then";
if (((_list_num.Get((int) (3))).equals((Object)("null")) == false)) { 
 //BA.debugLineNum = 94;BA.debugLine="et_matn1.Text=list_num.Get(3)";
mostCurrent._et_matn1.setText(BA.ObjectToCharSequence(_list_num.Get((int) (3))));
 };
 //BA.debugLineNum = 97;BA.debugLine="If(list_num.Get(2)<>\"null\")Then";
if (((_list_num.Get((int) (2))).equals((Object)("null")) == false)) { 
 //BA.debugLineNum = 98;BA.debugLine="If(File.Exists(File.DirInternal, list_num.Get(2";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_list_num.Get((int) (2)))))) { 
 //BA.debugLineNum = 99;BA.debugLine="pan_upload_pic1.SetBackgroundImage(LoadBitmapS";
mostCurrent._pan_upload_pic1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_list_num.Get((int) (2))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 };
 };
 //BA.debugLineNum = 108;BA.debugLine="et_matn1.Tag=list_num.Get(0)";
mostCurrent._et_matn1.setTag(_list_num.Get((int) (0)));
 }
};
 //BA.debugLineNum = 116;BA.debugLine="list_reload=0";
_list_reload = (int) (0);
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_tamrin_roz As Label";
mostCurrent._lbl_tamrin_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lbl_add_new As Label";
mostCurrent._lbl_add_new = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim list_reload As Int=0";
_list_reload = (int) (0);
 //BA.debugLineNum = 32;BA.debugLine="Private et_matn1 As EditText";
mostCurrent._et_matn1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pan_upload_pic1 As Panel";
mostCurrent._pan_upload_pic1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim pic_upload_index As Int=0";
_pic_upload_index = (int) (0);
 //BA.debugLineNum = 36;BA.debugLine="Private pan_showPic As Panel";
mostCurrent._pan_showpic = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private pan_all_showPic As Panel";
mostCurrent._pan_all_showpic = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_new_click() throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Private Sub lbl_add_new_Click";
 //BA.debugLineNum = 161;BA.debugLine="myFunc.connection_sql";
mostCurrent._myfunc._connection_sql /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 162;BA.debugLine="Main.sql.ExecNonQuery2(\"INSERT INTO daftar_ravabe";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO daftar_ravabet ('shenase') VALUES (?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._main._daftar_shenase /*String*/ )}));
 //BA.debugLineNum = 163;BA.debugLine="Main.sql.Close";
mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 164;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 166;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 122;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_num_longclick() throws Exception{
ResumableSub_lbl_num_LongClick rsub = new ResumableSub_lbl_num_LongClick(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_num_LongClick extends BA.ResumableSub {
public ResumableSub_lbl_num_LongClick(ir.taravatgroup.shokrgozari.daftar_ravabet_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.daftar_ravabet_activity parent;
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
 //BA.debugLineNum = 172;BA.debugLine="Dim this_item As Label=Sender";
_this_item = new anywheresoftware.b4a.objects.LabelWrapper();
_this_item = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 175;BA.debugLine="Msgbox2Async(\"مطمئن هستید که این مورد حذف شود؟\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("مطمئن هستید که این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 176;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 177;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 178;BA.debugLine="myFunc.delet_daftar_ravabetById(this_item.Tag)";
parent.mostCurrent._myfunc._delet_daftar_ravabetbyid /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_this_item.getTag())));
 //BA.debugLineNum = 179;BA.debugLine="fill_list";
_fill_list();
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _pan_all_showpic_click() throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Private Sub pan_all_showPic_Click";
 //BA.debugLineNum = 221;BA.debugLine="pan_all_showPic.Visible=False";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public static String  _pan_showpic_click() throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Private Sub pan_showPic_Click";
 //BA.debugLineNum = 217;BA.debugLine="Main.Chooser.Show(\"image/*\", \"Select an image\")";
mostCurrent._main._chooser /*anywheresoftware.b4a.phone.Phone.ContentChooser*/ .Show(processBA,"image/*","Select an image");
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public static String  _pan_upload_pic1_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _this_item = null;
 //BA.debugLineNum = 185;BA.debugLine="Private Sub pan_upload_pic1_Click";
 //BA.debugLineNum = 186;BA.debugLine="Dim this_item As Panel=Sender";
_this_item = new anywheresoftware.b4a.objects.PanelWrapper();
_this_item = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 188;BA.debugLine="pic_upload_index=this_item.Tag";
_pic_upload_index = (int)(BA.ObjectToNumber(_this_item.getTag()));
 //BA.debugLineNum = 190;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_\"&pic_upload";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_"+BA.NumberToString(_pic_upload_index)+".jpg"))) { 
 //BA.debugLineNum = 191;BA.debugLine="pan_all_showPic.Visible=True";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 192;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
mostCurrent._pan_showpic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_"+BA.NumberToString(_pic_upload_index)+".jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 }else {
 //BA.debugLineNum = 194;BA.debugLine="Main.Chooser.Show(\"image/*\", \"Select an image\")";
mostCurrent._main._chooser /*anywheresoftware.b4a.phone.Phone.ContentChooser*/ .Show(processBA,"image/*","Select an image");
 };
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
