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

public class tamrin3_activity extends Activity implements B4AActivity{
	public static tamrin3_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin3_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tamrin3_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.tamrin3_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.shokrgozari.tamrin3_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tamrin3_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tamrin3_activity) Resume **");
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
		return tamrin3_activity.class;
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
            BA.LogInfo("** Activity (tamrin3_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tamrin3_activity) Pause event (activity is not paused). **");
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
            tamrin3_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tamrin3_activity) Resume **");
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
public static anywheresoftware.b4a.phone.Phone.ContentChooser _chooser = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_matn3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_upload_pic1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_upload_pic2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_upload_pic3 = null;
public static int _pic_upload_index = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_showpic = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_showpic = null;
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
public ir.taravatgroup.shokrgozari.tamrin16_activity _tamrin16_activity = null;
public ir.taravatgroup.shokrgozari.tamrin19_activity _tamrin19_activity = null;
public ir.taravatgroup.shokrgozari.tamrin25_activity _tamrin25_activity = null;
public ir.taravatgroup.shokrgozari.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _ls_content = null;
RDebugUtils.currentLine=13762560;
 //BA.debugLineNum = 13762560;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=13762562;
 //BA.debugLineNum = 13762562;BA.debugLine="Activity.LoadLayout(\"tamrin3_layout\")";
mostCurrent._activity.LoadLayout("tamrin3_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=13762564;
 //BA.debugLineNum = 13762564;BA.debugLine="Chooser.Initialize(\"chooser\")";
_chooser.Initialize("chooser");
RDebugUtils.currentLine=13762565;
 //BA.debugLineNum = 13762565;BA.debugLine="et_matn1.Color=0xABFFFFFF";
mostCurrent._et_matn1.setColor(((int)0xabffffff));
RDebugUtils.currentLine=13762566;
 //BA.debugLineNum = 13762566;BA.debugLine="et_matn2.Color=0xABFFFFFF";
mostCurrent._et_matn2.setColor(((int)0xabffffff));
RDebugUtils.currentLine=13762567;
 //BA.debugLineNum = 13762567;BA.debugLine="et_matn3.Color=0xABFFFFFF";
mostCurrent._et_matn3.setColor(((int)0xabffffff));
RDebugUtils.currentLine=13762569;
 //BA.debugLineNum = 13762569;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin1.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin1.jpg"))) { 
RDebugUtils.currentLine=13762570;
 //BA.debugLineNum = 13762570;BA.debugLine="pan_upload_pic1.SetBackgroundImage(LoadBitmapSam";
mostCurrent._pan_upload_pic1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin1.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 };
RDebugUtils.currentLine=13762572;
 //BA.debugLineNum = 13762572;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin2.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin2.jpg"))) { 
RDebugUtils.currentLine=13762573;
 //BA.debugLineNum = 13762573;BA.debugLine="pan_upload_pic2.SetBackgroundImage(LoadBitmapSam";
mostCurrent._pan_upload_pic2.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin2.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 };
RDebugUtils.currentLine=13762575;
 //BA.debugLineNum = 13762575;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin3.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin3.jpg"))) { 
RDebugUtils.currentLine=13762576;
 //BA.debugLineNum = 13762576;BA.debugLine="pan_upload_pic3.SetBackgroundImage(LoadBitmapSam";
mostCurrent._pan_upload_pic3.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin3.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 };
RDebugUtils.currentLine=13762579;
 //BA.debugLineNum = 13762579;BA.debugLine="Dim ls_content As List";
_ls_content = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=13762580;
 //BA.debugLineNum = 13762580;BA.debugLine="ls_content.Initialize";
_ls_content.Initialize();
RDebugUtils.currentLine=13762581;
 //BA.debugLineNum = 13762581;BA.debugLine="ls_content=myFunc.get_tamrinat_saved(Main.current";
_ls_content = mostCurrent._myfunc._get_tamrinat_saved /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ );
RDebugUtils.currentLine=13762583;
 //BA.debugLineNum = 13762583;BA.debugLine="et_matn1.text=ls_content.Get(0)";
mostCurrent._et_matn1.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (0))));
RDebugUtils.currentLine=13762584;
 //BA.debugLineNum = 13762584;BA.debugLine="et_matn2.text=ls_content.Get(1)";
mostCurrent._et_matn2.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (1))));
RDebugUtils.currentLine=13762585;
 //BA.debugLineNum = 13762585;BA.debugLine="et_matn3.text=ls_content.Get(2)";
mostCurrent._et_matn3.setText(BA.ObjectToCharSequence(_ls_content.Get((int) (2))));
RDebugUtils.currentLine=13762588;
 //BA.debugLineNum = 13762588;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=14090240;
 //BA.debugLineNum = 14090240;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=14090241;
 //BA.debugLineNum = 14090241;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=14090242;
 //BA.debugLineNum = 14090242;BA.debugLine="If(pan_all_showPic.Visible=True)Then";
if ((mostCurrent._pan_all_showpic.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=14090243;
 //BA.debugLineNum = 14090243;BA.debugLine="pan_all_showPic.Visible=False";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=14090245;
 //BA.debugLineNum = 14090245;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=14090250;
 //BA.debugLineNum = 14090250;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=14090252;
 //BA.debugLineNum = 14090252;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=14090254;
 //BA.debugLineNum = 14090254;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=14024705;
 //BA.debugLineNum = 14024705;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=13893632;
 //BA.debugLineNum = 13893632;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=13893634;
 //BA.debugLineNum = 13893634;BA.debugLine="End Sub";
return "";
}
public static String  _chooser_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chooser_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chooser_result", new Object[] {_success,_dir,_filename}));}
RDebugUtils.currentLine=13828096;
 //BA.debugLineNum = 13828096;BA.debugLine="Sub chooser_Result (Success As Boolean, Dir As Str";
RDebugUtils.currentLine=13828097;
 //BA.debugLineNum = 13828097;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=13828099;
 //BA.debugLineNum = 13828099;BA.debugLine="Select pic_upload_index";
switch (_pic_upload_index) {
case 1: {
RDebugUtils.currentLine=13828101;
 //BA.debugLineNum = 13828101;BA.debugLine="pan_upload_pic1.SetBackgroundImage(LoadBitmapS";
mostCurrent._pan_upload_pic1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(_dir,_filename,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
RDebugUtils.currentLine=13828102;
 //BA.debugLineNum = 13828102;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin1.jpg");
 break; }
case 2: {
RDebugUtils.currentLine=13828104;
 //BA.debugLineNum = 13828104;BA.debugLine="pan_upload_pic2.SetBackgroundImage(LoadBitmapS";
mostCurrent._pan_upload_pic2.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(_dir,_filename,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
RDebugUtils.currentLine=13828105;
 //BA.debugLineNum = 13828105;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin2.jpg");
 break; }
case 3: {
RDebugUtils.currentLine=13828107;
 //BA.debugLineNum = 13828107;BA.debugLine="pan_upload_pic3.SetBackgroundImage(LoadBitmapS";
mostCurrent._pan_upload_pic3.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(_dir,_filename,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
RDebugUtils.currentLine=13828108;
 //BA.debugLineNum = 13828108;BA.debugLine="File.Copy(Dir,FileName,File.DirInternal,\"pic_t";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin3.jpg");
 break; }
}
;
RDebugUtils.currentLine=13828112;
 //BA.debugLineNum = 13828112;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
mostCurrent._pan_showpic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(_dir,_filename,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 }else {
RDebugUtils.currentLine=13828115;
 //BA.debugLineNum = 13828115;BA.debugLine="ToastMessageShow(\"No image selected\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=13828117;
 //BA.debugLineNum = 13828117;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_matn1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_matn1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14548992;
 //BA.debugLineNum = 14548992;BA.debugLine="Private Sub et_matn1_TextChanged (Old As String, N";
RDebugUtils.currentLine=14548993;
 //BA.debugLineNum = 14548993;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (1),_new,(int) (1));
RDebugUtils.currentLine=14548994;
 //BA.debugLineNum = 14548994;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn2_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_matn2_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_matn2_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14483456;
 //BA.debugLineNum = 14483456;BA.debugLine="Private Sub et_matn2_TextChanged (Old As String, N";
RDebugUtils.currentLine=14483457;
 //BA.debugLineNum = 14483457;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (2),_new,(int) (1));
RDebugUtils.currentLine=14483458;
 //BA.debugLineNum = 14483458;BA.debugLine="End Sub";
return "";
}
public static String  _et_matn3_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_matn3_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_matn3_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14417920;
 //BA.debugLineNum = 14417920;BA.debugLine="Private Sub et_matn3_TextChanged (Old As String, N";
RDebugUtils.currentLine=14417921;
 //BA.debugLineNum = 14417921;BA.debugLine="myFunc.update_tamrinat_saved(Main.current_roz_tam";
mostCurrent._myfunc._update_tamrinat_saved /*boolean*/ (mostCurrent.activityBA,mostCurrent._main._current_roz_tamrin /*int*/ ,mostCurrent._main._current_tamrin /*int*/ ,(int) (3),_new,(int) (1));
RDebugUtils.currentLine=14417922;
 //BA.debugLineNum = 14417922;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_open_help_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_open_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_open_help_click", null));}
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Private Sub lbl_open_help_Click";
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_showpic_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_showpic_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_showpic_click", null));}
RDebugUtils.currentLine=14680064;
 //BA.debugLineNum = 14680064;BA.debugLine="Private Sub pan_all_showPic_Click";
RDebugUtils.currentLine=14680065;
 //BA.debugLineNum = 14680065;BA.debugLine="pan_all_showPic.Visible=False";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14680066;
 //BA.debugLineNum = 14680066;BA.debugLine="End Sub";
return "";
}
public static String  _pan_showpic_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_showpic_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_showpic_click", null));}
RDebugUtils.currentLine=14614528;
 //BA.debugLineNum = 14614528;BA.debugLine="Private Sub pan_showPic_Click";
RDebugUtils.currentLine=14614529;
 //BA.debugLineNum = 14614529;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
_chooser.Show(processBA,"image/*","Select an image");
RDebugUtils.currentLine=14614530;
 //BA.debugLineNum = 14614530;BA.debugLine="End Sub";
return "";
}
public static String  _pan_upload_pic1_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_upload_pic1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_upload_pic1_click", null));}
RDebugUtils.currentLine=14352384;
 //BA.debugLineNum = 14352384;BA.debugLine="Private Sub pan_upload_pic1_Click";
RDebugUtils.currentLine=14352385;
 //BA.debugLineNum = 14352385;BA.debugLine="pic_upload_index=1";
_pic_upload_index = (int) (1);
RDebugUtils.currentLine=14352387;
 //BA.debugLineNum = 14352387;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin1.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin1.jpg"))) { 
RDebugUtils.currentLine=14352388;
 //BA.debugLineNum = 14352388;BA.debugLine="pan_all_showPic.Visible=True";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14352389;
 //BA.debugLineNum = 14352389;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
mostCurrent._pan_showpic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin1.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 }else {
RDebugUtils.currentLine=14352391;
 //BA.debugLineNum = 14352391;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
_chooser.Show(processBA,"image/*","Select an image");
 };
RDebugUtils.currentLine=14352394;
 //BA.debugLineNum = 14352394;BA.debugLine="End Sub";
return "";
}
public static String  _pan_upload_pic2_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_upload_pic2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_upload_pic2_click", null));}
RDebugUtils.currentLine=14286848;
 //BA.debugLineNum = 14286848;BA.debugLine="Private Sub pan_upload_pic2_Click";
RDebugUtils.currentLine=14286849;
 //BA.debugLineNum = 14286849;BA.debugLine="pic_upload_index=2";
_pic_upload_index = (int) (2);
RDebugUtils.currentLine=14286851;
 //BA.debugLineNum = 14286851;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin2.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin2.jpg"))) { 
RDebugUtils.currentLine=14286852;
 //BA.debugLineNum = 14286852;BA.debugLine="pan_all_showPic.Visible=True";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14286853;
 //BA.debugLineNum = 14286853;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
mostCurrent._pan_showpic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin2.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 }else {
RDebugUtils.currentLine=14286855;
 //BA.debugLineNum = 14286855;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
_chooser.Show(processBA,"image/*","Select an image");
 };
RDebugUtils.currentLine=14286858;
 //BA.debugLineNum = 14286858;BA.debugLine="End Sub";
return "";
}
public static String  _pan_upload_pic3_click() throws Exception{
RDebugUtils.currentModule="tamrin3_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_upload_pic3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_upload_pic3_click", null));}
RDebugUtils.currentLine=14221312;
 //BA.debugLineNum = 14221312;BA.debugLine="Private Sub pan_upload_pic3_Click";
RDebugUtils.currentLine=14221313;
 //BA.debugLineNum = 14221313;BA.debugLine="pic_upload_index=3";
_pic_upload_index = (int) (3);
RDebugUtils.currentLine=14221315;
 //BA.debugLineNum = 14221315;BA.debugLine="If(File.Exists(File.DirInternal,\"pic_tamrin3.jpg\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin3.jpg"))) { 
RDebugUtils.currentLine=14221316;
 //BA.debugLineNum = 14221316;BA.debugLine="pan_all_showPic.Visible=True";
mostCurrent._pan_all_showpic.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14221317;
 //BA.debugLineNum = 14221317;BA.debugLine="pan_showPic.SetBackgroundImage(LoadBitmapSample(";
mostCurrent._pan_showpic.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"pic_tamrin3.jpg",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))).getObject()));
 }else {
RDebugUtils.currentLine=14221319;
 //BA.debugLineNum = 14221319;BA.debugLine="Chooser.Show(\"image/*\", \"Select an image\")";
_chooser.Show(processBA,"image/*","Select an image");
 };
RDebugUtils.currentLine=14221322;
 //BA.debugLineNum = 14221322;BA.debugLine="End Sub";
return "";
}
}