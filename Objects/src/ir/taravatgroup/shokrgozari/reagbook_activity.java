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

public class reagbook_activity extends Activity implements B4AActivity{
	public static reagbook_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.reagbook_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (reagbook_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.reagbook_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.reagbook_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (reagbook_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (reagbook_activity) Resume **");
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
		return reagbook_activity.class;
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
            BA.LogInfo("** Activity (reagbook_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (reagbook_activity) Pause event (activity is not paused). **");
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
            reagbook_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (reagbook_activity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static String _pic_addres = "";
public static String _sound_addres = "";
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public static int _dark_mod = 0;
public static String _str_html_lite = "";
public static String _str_html_dark = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbl_dark_view = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview_player = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_fav = null;
public ir.taravatgroup.shokrgozari.main _main = null;
public ir.taravatgroup.shokrgozari.myfunc _myfunc = null;
public ir.taravatgroup.shokrgozari.tajrobiat_activity _tajrobiat_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.daftar_activity _daftar_activity = null;
public ir.taravatgroup.shokrgozari.daftar_khasteha_activity _daftar_khasteha_activity = null;
public ir.taravatgroup.shokrgozari.daftar_ravabet_activity _daftar_ravabet_activity = null;
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
anywheresoftware.b4a.objects.collections.List _ls_content_book = null;
uk.co.martinpearman.b4a.webviewsettings.WebViewSettings _wvsetttings = null;
String _str_html_pleyer = "";
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"readBook_layout\")";
mostCurrent._activity.LoadLayout("readBook_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 35;BA.debugLine="Dim ls_content_book As List";
_ls_content_book = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 36;BA.debugLine="ls_content_book.Initialize";
_ls_content_book.Initialize();
 //BA.debugLineNum = 38;BA.debugLine="ls_content_book=	myFunc.get_book_byId(Main.curren";
_ls_content_book = mostCurrent._myfunc._get_book_byid /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ );
 //BA.debugLineNum = 40;BA.debugLine="lbl_title.Text=ls_content_book.Get(5)";
mostCurrent._lbl_title.setText(BA.ObjectToCharSequence(_ls_content_book.Get((int) (5))));
 //BA.debugLineNum = 43;BA.debugLine="pic_addres=ls_content_book.Get(2)";
mostCurrent._pic_addres = BA.ObjectToString(_ls_content_book.Get((int) (2)));
 //BA.debugLineNum = 44;BA.debugLine="sound_addres=ls_content_book.Get(3)";
mostCurrent._sound_addres = BA.ObjectToString(_ls_content_book.Get((int) (3)));
 //BA.debugLineNum = 46;BA.debugLine="ls_content_book.Get(4)";
_ls_content_book.Get((int) (4));
 //BA.debugLineNum = 47;BA.debugLine="If(ls_content_book.Get(4).As(Int)=1)Then";
if ((((int)(BA.ObjectToNumber(_ls_content_book.Get((int) (4)))))==1)) { 
 //BA.debugLineNum = 48;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
 //BA.debugLineNum = 49;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
mostCurrent._lbl_fav.setTextColor(((int)0xffff3838));
 }else {
 //BA.debugLineNum = 51;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
 //BA.debugLineNum = 52;BA.debugLine="lbl_fav.TextColor=0xFF686868";
mostCurrent._lbl_fav.setTextColor(((int)0xff686868));
 };
 //BA.debugLineNum = 59;BA.debugLine="str_html_lite=\"<html><head><meta name='viewport'";
mostCurrent._str_html_lite = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color:  rgba(0, 0, 0, 0) ; color: black;'><img src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._pic_addres)+"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"+BA.ObjectToString(_ls_content_book.Get((int) (0)))+"</b><p>"+BA.ObjectToString(_ls_content_book.Get((int) (1)))+"<br><br><br><br></p></body></html>";
 //BA.debugLineNum = 62;BA.debugLine="str_html_dark=\"<html><head><meta name='viewport'";
mostCurrent._str_html_dark = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color: rgba(0, 0, 0, 0); color: white;'><img src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._pic_addres)+"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"+BA.ObjectToString(_ls_content_book.Get((int) (0)))+"</b><p>"+BA.ObjectToString(_ls_content_book.Get((int) (1)))+"<br><br><br><br></p></body></html>";
 //BA.debugLineNum = 66;BA.debugLine="Private wvsetttings As WebViewSettings";
_wvsetttings = new uk.co.martinpearman.b4a.webviewsettings.WebViewSettings();
 //BA.debugLineNum = 67;BA.debugLine="wvsetttings.setAllowFileAccess(WebView1,True)";
_wvsetttings.setAllowFileAccess((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 68;BA.debugLine="wvsetttings.setAllowFileAccess(WebView_player,Tru";
_wvsetttings.setAllowFileAccess((android.webkit.WebView)(mostCurrent._webview_player.getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 71;BA.debugLine="If(File.Exists(File.DirInternal,sound_addres))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._sound_addres))) { 
 //BA.debugLineNum = 72;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
_str_html_pleyer = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._sound_addres)+"' type='audio/mpeg' ></audio></html>";
 }else {
 //BA.debugLineNum = 77;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
_str_html_pleyer = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='https://m2ebadi.iapp.ir/shokrgozari/sounds/"+mostCurrent._sound_addres+"' type='audio/mpeg' ></audio></html>";
 };
 //BA.debugLineNum = 83;BA.debugLine="WebView_player.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview_player.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 84;BA.debugLine="WebView_player.LoadHtml(str_html_pleyer)";
mostCurrent._webview_player.LoadHtml(_str_html_pleyer);
 //BA.debugLineNum = 87;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 95;BA.debugLine="If(File.Exists(File.DirInternal,\"darkmod.txt\"))Th";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt"))) { 
 //BA.debugLineNum = 96;BA.debugLine="dark_mod = File.ReadString(File.DirInternal,\"dar";
_dark_mod = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt")));
 //BA.debugLineNum = 97;BA.debugLine="If(dark_mod=1)Then";
if ((_dark_mod==1)) { 
 //BA.debugLineNum = 99;BA.debugLine="Activity.Color=Colors.Black";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 100;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_dark);
 //BA.debugLineNum = 101;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf185))));
 }else {
 //BA.debugLineNum = 104;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
 };
 }else {
 //BA.debugLineNum = 110;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
 };
 //BA.debugLineNum = 123;BA.debugLine="File.WriteString(File.DirInternal,\"temp_read.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_read.txt",BA.NumberToString(mostCurrent._main._current_book_content_id /*int*/ ));
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 144;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 145;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 146;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 148;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_title As Label";
mostCurrent._lbl_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 18;BA.debugLine="Dim pic_addres As String=\"\"";
mostCurrent._pic_addres = "";
 //BA.debugLineNum = 19;BA.debugLine="Dim sound_addres As String=\"\"";
mostCurrent._sound_addres = "";
 //BA.debugLineNum = 20;BA.debugLine="Private WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim dark_mod As Int =0";
_dark_mod = (int) (0);
 //BA.debugLineNum = 23;BA.debugLine="Dim str_html_lite As String";
mostCurrent._str_html_lite = "";
 //BA.debugLineNum = 24;BA.debugLine="Dim str_html_dark As String";
mostCurrent._str_html_dark = "";
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_dark_view As Label";
mostCurrent._lbl_dark_view = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private WebView_player As WebView";
mostCurrent._webview_player = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_fav As Label";
mostCurrent._lbl_fav = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 137;BA.debugLine="WebView1.LoadHtml(\"\")";
mostCurrent._webview1.LoadHtml("");
 //BA.debugLineNum = 138;BA.debugLine="WebView_player.LoadHtml(\"\")";
mostCurrent._webview_player.LoadHtml("");
 //BA.debugLineNum = 139;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_dark_view_click() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Private Sub lbl_dark_view_Click";
 //BA.debugLineNum = 158;BA.debugLine="If(dark_mod=0)Then";
if ((_dark_mod==0)) { 
 //BA.debugLineNum = 159;BA.debugLine="Activity.Color=Colors.Black";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 160;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_dark);
 //BA.debugLineNum = 162;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf185))));
 //BA.debugLineNum = 163;BA.debugLine="dark_mod=1";
_dark_mod = (int) (1);
 }else {
 //BA.debugLineNum = 166;BA.debugLine="Activity.Color=Colors.White";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 167;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
 //BA.debugLineNum = 169;BA.debugLine="lbl_dark_view.Text=Chr(0xF186)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf186))));
 //BA.debugLineNum = 170;BA.debugLine="dark_mod=0";
_dark_mod = (int) (0);
 };
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_fav_click() throws Exception{
int _fav_state = 0;
 //BA.debugLineNum = 199;BA.debugLine="Private Sub lbl_fav_Click";
 //BA.debugLineNum = 201;BA.debugLine="Dim fav_state As Int = myFunc.get_fav_byId(Main.c";
_fav_state = mostCurrent._myfunc._get_fav_byid /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ );
 //BA.debugLineNum = 204;BA.debugLine="If(fav_state=1)Then";
if ((_fav_state==1)) { 
 //BA.debugLineNum = 206;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ ,(int) (0));
 //BA.debugLineNum = 207;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
 //BA.debugLineNum = 208;BA.debugLine="lbl_fav.TextColor=0xFF686868";
mostCurrent._lbl_fav.setTextColor(((int)0xff686868));
 }else {
 //BA.debugLineNum = 210;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ ,(int) (1));
 //BA.debugLineNum = 211;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
 //BA.debugLineNum = 212;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
mostCurrent._lbl_fav.setTextColor(((int)0xffff3838));
 };
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_tamrin_click() throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Private Sub lbl_go_tamrin_Click";
 //BA.debugLineNum = 186;BA.debugLine="If((Main.current_book_content_id-1)=0)Then";
if (((mostCurrent._main._current_book_content_id /*int*/ -1)==0)) { 
 //BA.debugLineNum = 187;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("بدون تمرین"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._main._current_book_content_id /*int*/ -1)==29)) { 
 //BA.debugLineNum = 189;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("بدون تمرین"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 191;BA.debugLine="Main.current_roz_tamrin=Main.current_book_conten";
mostCurrent._main._current_roz_tamrin /*int*/  = (int) (mostCurrent._main._current_book_content_id /*int*/ -1);
 //BA.debugLineNum = 192;BA.debugLine="WebView1.LoadHtml(\"\")";
mostCurrent._webview1.LoadHtml("");
 //BA.debugLineNum = 193;BA.debugLine="WebView_player.LoadHtml(\"\")";
mostCurrent._webview_player.LoadHtml("");
 //BA.debugLineNum = 194;BA.debugLine="StartActivity(tamrin_roz_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin_roz_activity.getObject()));
 };
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
