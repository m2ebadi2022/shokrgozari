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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.reagbook_activity");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public ir.taravatgroup.shokrgozari.tamrin_roz_activity _tamrin_roz_activity = null;
public ir.taravatgroup.shokrgozari.book_activity _book_activity = null;
public ir.taravatgroup.shokrgozari.tamrinat_activity _tamrinat_activity = null;
public ir.taravatgroup.shokrgozari.tamrin14_activity _tamrin14_activity = null;
public ir.taravatgroup.shokrgozari.tamrin8_activity _tamrin8_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.download_activity _download_activity = null;
public ir.taravatgroup.shokrgozari.intro_activity _intro_activity = null;
public ir.taravatgroup.shokrgozari.setting_activity _setting_activity = null;
public ir.taravatgroup.shokrgozari.starter _starter = null;
public ir.taravatgroup.shokrgozari.tamrin13_activity _tamrin13_activity = null;
public ir.taravatgroup.shokrgozari.tamrin3_activity _tamrin3_activity = null;
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _ls_content_book = null;
uk.co.martinpearman.b4a.webviewsettings.WebViewSettings _wvsetttings = null;
String _str_html_pleyer = "";
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="Activity.LoadLayout(\"readBook_layout\")";
mostCurrent._activity.LoadLayout("readBook_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=11075588;
 //BA.debugLineNum = 11075588;BA.debugLine="Dim ls_content_book As List";
_ls_content_book = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11075589;
 //BA.debugLineNum = 11075589;BA.debugLine="ls_content_book.Initialize";
_ls_content_book.Initialize();
RDebugUtils.currentLine=11075591;
 //BA.debugLineNum = 11075591;BA.debugLine="ls_content_book=	myFunc.get_book_byId(Main.curren";
_ls_content_book = mostCurrent._myfunc._get_book_byid /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ );
RDebugUtils.currentLine=11075593;
 //BA.debugLineNum = 11075593;BA.debugLine="lbl_title.Text=ls_content_book.Get(5)";
mostCurrent._lbl_title.setText(BA.ObjectToCharSequence(_ls_content_book.Get((int) (5))));
RDebugUtils.currentLine=11075596;
 //BA.debugLineNum = 11075596;BA.debugLine="pic_addres=ls_content_book.Get(2)";
mostCurrent._pic_addres = BA.ObjectToString(_ls_content_book.Get((int) (2)));
RDebugUtils.currentLine=11075597;
 //BA.debugLineNum = 11075597;BA.debugLine="sound_addres=ls_content_book.Get(3)";
mostCurrent._sound_addres = BA.ObjectToString(_ls_content_book.Get((int) (3)));
RDebugUtils.currentLine=11075599;
 //BA.debugLineNum = 11075599;BA.debugLine="ls_content_book.Get(4)";
_ls_content_book.Get((int) (4));
RDebugUtils.currentLine=11075600;
 //BA.debugLineNum = 11075600;BA.debugLine="If(ls_content_book.Get(4).As(Int)=1)Then";
if ((((int)(BA.ObjectToNumber(_ls_content_book.Get((int) (4)))))==1)) { 
RDebugUtils.currentLine=11075601;
 //BA.debugLineNum = 11075601;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
RDebugUtils.currentLine=11075602;
 //BA.debugLineNum = 11075602;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
mostCurrent._lbl_fav.setTextColor(((int)0xffff3838));
 }else {
RDebugUtils.currentLine=11075604;
 //BA.debugLineNum = 11075604;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
RDebugUtils.currentLine=11075605;
 //BA.debugLineNum = 11075605;BA.debugLine="lbl_fav.TextColor=0xFF686868";
mostCurrent._lbl_fav.setTextColor(((int)0xff686868));
 };
RDebugUtils.currentLine=11075612;
 //BA.debugLineNum = 11075612;BA.debugLine="str_html_lite=\"<html><head><meta name='viewport'";
mostCurrent._str_html_lite = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color:  rgba(0, 0, 0, 0) ; color: black;'><img src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._pic_addres)+"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"+BA.ObjectToString(_ls_content_book.Get((int) (0)))+"</b><p>"+BA.ObjectToString(_ls_content_book.Get((int) (1)))+"<br><br><br><br></p></body></html>";
RDebugUtils.currentLine=11075615;
 //BA.debugLineNum = 11075615;BA.debugLine="str_html_dark=\"<html><head><meta name='viewport'";
mostCurrent._str_html_dark = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color: rgba(0, 0, 0, 0); color: white;'><img src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._pic_addres)+"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"+BA.ObjectToString(_ls_content_book.Get((int) (0)))+"</b><p>"+BA.ObjectToString(_ls_content_book.Get((int) (1)))+"<br><br><br><br></p></body></html>";
RDebugUtils.currentLine=11075619;
 //BA.debugLineNum = 11075619;BA.debugLine="Private wvsetttings As WebViewSettings";
_wvsetttings = new uk.co.martinpearman.b4a.webviewsettings.WebViewSettings();
RDebugUtils.currentLine=11075620;
 //BA.debugLineNum = 11075620;BA.debugLine="wvsetttings.setAllowFileAccess(WebView1,True)";
_wvsetttings.setAllowFileAccess((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11075621;
 //BA.debugLineNum = 11075621;BA.debugLine="wvsetttings.setAllowFileAccess(WebView_player,Tru";
_wvsetttings.setAllowFileAccess((android.webkit.WebView)(mostCurrent._webview_player.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=11075624;
 //BA.debugLineNum = 11075624;BA.debugLine="If(File.Exists(File.DirInternal,sound_addres))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._sound_addres))) { 
RDebugUtils.currentLine=11075625;
 //BA.debugLineNum = 11075625;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
_str_html_pleyer = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='"+mostCurrent._xui.FileUri(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._sound_addres)+"' type='audio/mpeg' ></audio></html>";
 }else {
RDebugUtils.currentLine=11075630;
 //BA.debugLineNum = 11075630;BA.debugLine="Dim str_html_pleyer As String=\"<html><head><meta";
_str_html_pleyer = "<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='https://m2ebadi.whi.ir/shokrgozari/sounds/"+mostCurrent._sound_addres+"' type='audio/mpeg' ></audio></html>";
 };
RDebugUtils.currentLine=11075636;
 //BA.debugLineNum = 11075636;BA.debugLine="WebView_player.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview_player.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=11075637;
 //BA.debugLineNum = 11075637;BA.debugLine="WebView_player.LoadHtml(str_html_pleyer)";
mostCurrent._webview_player.LoadHtml(_str_html_pleyer);
RDebugUtils.currentLine=11075640;
 //BA.debugLineNum = 11075640;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=11075648;
 //BA.debugLineNum = 11075648;BA.debugLine="If(File.Exists(File.DirInternal,\"darkmod.txt\"))Th";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt"))) { 
RDebugUtils.currentLine=11075649;
 //BA.debugLineNum = 11075649;BA.debugLine="dark_mod = File.ReadString(File.DirInternal,\"dar";
_dark_mod = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"darkmod.txt")));
RDebugUtils.currentLine=11075650;
 //BA.debugLineNum = 11075650;BA.debugLine="If(dark_mod=1)Then";
if ((_dark_mod==1)) { 
RDebugUtils.currentLine=11075652;
 //BA.debugLineNum = 11075652;BA.debugLine="Activity.Color=Colors.Black";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=11075653;
 //BA.debugLineNum = 11075653;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_dark);
RDebugUtils.currentLine=11075654;
 //BA.debugLineNum = 11075654;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf185))));
 }else {
RDebugUtils.currentLine=11075657;
 //BA.debugLineNum = 11075657;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
 };
 }else {
RDebugUtils.currentLine=11075663;
 //BA.debugLineNum = 11075663;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
 };
RDebugUtils.currentLine=11075676;
 //BA.debugLineNum = 11075676;BA.debugLine="File.WriteString(File.DirInternal,\"temp_read.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_read.txt",BA.NumberToString(mostCurrent._main._current_book_content_id /*int*/ ));
RDebugUtils.currentLine=11075678;
 //BA.debugLineNum = 11075678;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=11337731;
 //BA.debugLineNum = 11337731;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11337735;
 //BA.debugLineNum = 11337735;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="WebView1.LoadHtml(\"\")";
mostCurrent._webview1.LoadHtml("");
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="WebView_player.LoadHtml(\"\")";
mostCurrent._webview_player.LoadHtml("");
RDebugUtils.currentLine=11272195;
 //BA.debugLineNum = 11272195;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11272196;
 //BA.debugLineNum = 11272196;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="reagbook_activity";
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_dark_view_click() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_dark_view_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_dark_view_click", null));}
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Private Sub lbl_dark_view_Click";
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="If(dark_mod=0)Then";
if ((_dark_mod==0)) { 
RDebugUtils.currentLine=11403268;
 //BA.debugLineNum = 11403268;BA.debugLine="Activity.Color=Colors.Black";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="WebView1.LoadHtml(str_html_dark)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_dark);
RDebugUtils.currentLine=11403271;
 //BA.debugLineNum = 11403271;BA.debugLine="lbl_dark_view.Text=Chr(0xF185)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf185))));
RDebugUtils.currentLine=11403272;
 //BA.debugLineNum = 11403272;BA.debugLine="dark_mod=1";
_dark_mod = (int) (1);
 }else {
RDebugUtils.currentLine=11403275;
 //BA.debugLineNum = 11403275;BA.debugLine="Activity.Color=Colors.White";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11403276;
 //BA.debugLineNum = 11403276;BA.debugLine="WebView1.LoadHtml(str_html_lite)";
mostCurrent._webview1.LoadHtml(mostCurrent._str_html_lite);
RDebugUtils.currentLine=11403278;
 //BA.debugLineNum = 11403278;BA.debugLine="lbl_dark_view.Text=Chr(0xF186)";
mostCurrent._lbl_dark_view.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf186))));
RDebugUtils.currentLine=11403279;
 //BA.debugLineNum = 11403279;BA.debugLine="dark_mod=0";
_dark_mod = (int) (0);
 };
RDebugUtils.currentLine=11403281;
 //BA.debugLineNum = 11403281;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_fav_click() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_fav_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_fav_click", null));}
int _fav_state = 0;
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Private Sub lbl_fav_Click";
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="Dim fav_state As Int = myFunc.get_fav_byId(Main.c";
_fav_state = mostCurrent._myfunc._get_fav_byid /*int*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ );
RDebugUtils.currentLine=11599877;
 //BA.debugLineNum = 11599877;BA.debugLine="If(fav_state=1)Then";
if ((_fav_state==1)) { 
RDebugUtils.currentLine=11599879;
 //BA.debugLineNum = 11599879;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ ,(int) (0));
RDebugUtils.currentLine=11599880;
 //BA.debugLineNum = 11599880;BA.debugLine="lbl_fav.Text=Chr(0xF08A)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf08a))));
RDebugUtils.currentLine=11599881;
 //BA.debugLineNum = 11599881;BA.debugLine="lbl_fav.TextColor=0xFF686868";
mostCurrent._lbl_fav.setTextColor(((int)0xff686868));
 }else {
RDebugUtils.currentLine=11599883;
 //BA.debugLineNum = 11599883;BA.debugLine="myFunc.set_fav_book(Main.current_book_content_id";
mostCurrent._myfunc._set_fav_book /*String*/ (mostCurrent.activityBA,mostCurrent._main._current_book_content_id /*int*/ ,(int) (1));
RDebugUtils.currentLine=11599884;
 //BA.debugLineNum = 11599884;BA.debugLine="lbl_fav.Text=Chr(0xF004)";
mostCurrent._lbl_fav.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf004))));
RDebugUtils.currentLine=11599885;
 //BA.debugLineNum = 11599885;BA.debugLine="lbl_fav.TextColor=0xFFFF3838";
mostCurrent._lbl_fav.setTextColor(((int)0xffff3838));
 };
RDebugUtils.currentLine=11599889;
 //BA.debugLineNum = 11599889;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_tamrin_click() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_tamrin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_tamrin_click", null));}
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Private Sub lbl_go_tamrin_Click";
RDebugUtils.currentLine=11534337;
 //BA.debugLineNum = 11534337;BA.debugLine="If((Main.current_book_content_id-1)=0)Then";
if (((mostCurrent._main._current_book_content_id /*int*/ -1)==0)) { 
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("بدون تمرین"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=11534339;
 //BA.debugLineNum = 11534339;BA.debugLine="Else If((Main.current_book_content_id-1)=29)Then";
if (((mostCurrent._main._current_book_content_id /*int*/ -1)==29)) { 
RDebugUtils.currentLine=11534340;
 //BA.debugLineNum = 11534340;BA.debugLine="ToastMessageShow(\"بدون تمرین\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("بدون تمرین"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=11534342;
 //BA.debugLineNum = 11534342;BA.debugLine="Main.current_roz_tamrin=Main.current_book_conten";
mostCurrent._main._current_roz_tamrin /*int*/  = (int) (mostCurrent._main._current_book_content_id /*int*/ -1);
RDebugUtils.currentLine=11534343;
 //BA.debugLineNum = 11534343;BA.debugLine="WebView1.LoadHtml(\"\")";
mostCurrent._webview1.LoadHtml("");
RDebugUtils.currentLine=11534344;
 //BA.debugLineNum = 11534344;BA.debugLine="WebView_player.LoadHtml(\"\")";
mostCurrent._webview_player.LoadHtml("");
RDebugUtils.currentLine=11534345;
 //BA.debugLineNum = 11534345;BA.debugLine="StartActivity(tamrin_roz_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tamrin_roz_activity.getObject()));
 }}
;
RDebugUtils.currentLine=11534348;
 //BA.debugLineNum = 11534348;BA.debugLine="End Sub";
return "";
}
public static void  _setter() throws Exception{
RDebugUtils.currentModule="reagbook_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setter", false))
	 {Debug.delegate(mostCurrent.activityBA, "setter", null); return;}
ResumableSub_setter rsub = new ResumableSub_setter(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_setter extends BA.ResumableSub {
public ResumableSub_setter(ir.taravatgroup.shokrgozari.reagbook_activity parent) {
this.parent = parent;
}
ir.taravatgroup.shokrgozari.reagbook_activity parent;
anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="reagbook_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="Dim rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_S";
_rp.CheckAndRequest(processBA,_rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
RDebugUtils.currentLine=11468804;
 //BA.debugLineNum = 11468804;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "reagbook_activity", "setter"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="If Result Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=11468811;
 //BA.debugLineNum = 11468811;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}