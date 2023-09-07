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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.shokrgozari", "ir.taravatgroup.shokrgozari.download_activity");
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
public ir.taravatgroup.shokrgozari.tajrobiat_activity _tajrobiat_activity = null;
public ir.taravatgroup.shokrgozari.do_tamrin_roz_layout _do_tamrin_roz_layout = null;
public ir.taravatgroup.shokrgozari.reagbook_activity _reagbook_activity = null;
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
 //BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"download_layout\")";
mostCurrent._activity.LoadLayout("download_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 35;BA.debugLine="strFunc.Initialize";
mostCurrent._strfunc._initialize(processBA);
 //BA.debugLineNum = 36;BA.debugLine="j.Initialize(\"job\", Me)";
mostCurrent._j._initialize /*String*/ (processBA,"job",download_activity.getObject());
 //BA.debugLineNum = 38;BA.debugLine="list_download.Initialize";
mostCurrent._list_download.Initialize();
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 59;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 60;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 61;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 63;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 44;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _delete_filebyname(String _name) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Sub delete_fileByName(name As String)";
 //BA.debugLineNum = 211;BA.debugLine="If(File.Exists(File.DirInternal,name))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name))) { 
 //BA.debugLineNum = 212;BA.debugLine="File.Delete(File.DirInternal,name)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name);
 //BA.debugLineNum = 213;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 214;BA.debugLine="ToastMessageShow(\"فایل صوتی حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فایل صوتی حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public static void  _download_byname() throws Exception{
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

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 175;BA.debugLine="Try";
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
 //BA.debugLineNum = 178;BA.debugLine="j.Download(\"https://m2ebadi.iapp.ir/shokrgozari/";
parent.mostCurrent._j._download /*String*/ ("https://m2ebadi.iapp.ir/shokrgozari/sounds/"+parent.mostCurrent._current_down_name);
 //BA.debugLineNum = 181;BA.debugLine="Wait For JobDone(job As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, null);
this.state = 17;
return;
case 17:
//C
this.state = 4;
_job = (ir.taravatgroup.shokrgozari.httpjob) result[0];
;
 //BA.debugLineNum = 182;BA.debugLine="If j.Success Then";
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
 //BA.debugLineNum = 184;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._current_down_name,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 185;BA.debugLine="File.Copy2(job.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_job._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ ().getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 186;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 188;BA.debugLine="current_down_name=\"\"";
parent.mostCurrent._current_down_name = "";
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 190;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 192;BA.debugLine="If(list_download.Size<>0)Then";
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
 //BA.debugLineNum = 193;BA.debugLine="current_down_name=list_download.Get(0)";
parent.mostCurrent._current_down_name = BA.ObjectToString(parent.mostCurrent._list_download.Get((int) (0)));
 //BA.debugLineNum = 194;BA.debugLine="list_download.RemoveAt(0)";
parent.mostCurrent._list_download.RemoveAt((int) (0));
 //BA.debugLineNum = 195;BA.debugLine="download_byName";
_download_byname();
 if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 197;BA.debugLine="fill_list";
_fill_list();
 //BA.debugLineNum = 198;BA.debugLine="ToastMessageShow(\"فایلهای صوتی دانلود شدند.\", F";
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
 //BA.debugLineNum = 203;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("28585245",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 204;BA.debugLine="ToastMessageShow(\"منتظر باشید ..\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("منتظر باشید .."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
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
public static void  _jobdone(ir.taravatgroup.shokrgozari.httpjob _job) throws Exception{
}
public static String  _fill_list() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_fehrest = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _list_row = null;
 //BA.debugLineNum = 127;BA.debugLine="Sub fill_list";
 //BA.debugLineNum = 129;BA.debugLine="CustomListView1.Clear";
mostCurrent._customlistview1._clear();
 //BA.debugLineNum = 131;BA.debugLine="Dim list_fehrest As List";
_list_fehrest = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 132;BA.debugLine="list_fehrest.Initialize";
_list_fehrest.Initialize();
 //BA.debugLineNum = 133;BA.debugLine="list_fehrest=myFunc.get_download_list";
_list_fehrest = mostCurrent._myfunc._get_download_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 136;BA.debugLine="For i=0 To list_fehrest.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_list_fehrest.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 138;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 140;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
 //BA.debugLineNum = 141;BA.debugLine="p.LoadLayout(\"item_list_downloads\")";
mostCurrent._p.LoadLayout("item_list_downloads",mostCurrent.activityBA);
 //BA.debugLineNum = 144;BA.debugLine="CustomListView1.Add(p,i)";
mostCurrent._customlistview1._add(mostCurrent._p,(Object)(_i));
 //BA.debugLineNum = 147;BA.debugLine="Dim list_row As List";
_list_row = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 148;BA.debugLine="list_row.Initialize";
_list_row.Initialize();
 //BA.debugLineNum = 149;BA.debugLine="list_row=strFunc.Split(list_fehrest.Get(i) , \"@\"";
_list_row = mostCurrent._strfunc._vvvvvv5(BA.ObjectToString(_list_fehrest.Get(_i)),"@");
 //BA.debugLineNum = 152;BA.debugLine="lbl_donw_title.Text=\" \"&list_row.Get(1)";
mostCurrent._lbl_donw_title.setText(BA.ObjectToCharSequence(" "+BA.ObjectToString(_list_row.Get((int) (1)))));
 //BA.debugLineNum = 153;BA.debugLine="lbl_donw_detile.Text=\" \"&list_row.Get(2)";
mostCurrent._lbl_donw_detile.setText(BA.ObjectToCharSequence(" "+BA.ObjectToString(_list_row.Get((int) (2)))));
 //BA.debugLineNum = 155;BA.debugLine="pan_download.Tag=list_row.Get(0)";
mostCurrent._pan_download.setTag(_list_row.Get((int) (0)));
 //BA.debugLineNum = 157;BA.debugLine="If(File.Exists(File.DirInternal,list_row.Get(3))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_list_row.Get((int) (3)))))) { 
 //BA.debugLineNum = 158;BA.debugLine="lbl_down_del.Text=Chr(0xF014)  'delete icon";
mostCurrent._lbl_down_del.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf014))));
 //BA.debugLineNum = 159;BA.debugLine="lbl_down_del.textColor=0xFFFF5050";
mostCurrent._lbl_down_del.setTextColor(((int)0xffff5050));
 //BA.debugLineNum = 160;BA.debugLine="lbl_down_del.Tag=\"del@\"&list_row.Get(3)";
mostCurrent._lbl_down_del.setTag((Object)("del@"+BA.ObjectToString(_list_row.Get((int) (3)))));
 }else {
 //BA.debugLineNum = 163;BA.debugLine="lbl_down_del.Text=Chr(0xF019)  'download icon";
mostCurrent._lbl_down_del.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf019))));
 //BA.debugLineNum = 164;BA.debugLine="lbl_down_del.textColor=0xFF0CA300";
mostCurrent._lbl_down_del.setTextColor(((int)0xff0ca300));
 //BA.debugLineNum = 165;BA.debugLine="lbl_down_del.Tag=\"down@\"&list_row.Get(3)";
mostCurrent._lbl_down_del.setTag((Object)("down@"+BA.ObjectToString(_list_row.Get((int) (3)))));
 };
 }
};
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private CustomListView1 As CustomListView";
mostCurrent._customlistview1 = new b4a.example3.customlistview();
 //BA.debugLineNum = 20;BA.debugLine="Private pan_download As Panel";
mostCurrent._pan_download = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_down_del As Label";
mostCurrent._lbl_down_del = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_donw_title As Label";
mostCurrent._lbl_donw_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_donw_detile As Label";
mostCurrent._lbl_donw_detile = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim strFunc As StringFunctions";
mostCurrent._strfunc = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 26;BA.debugLine="Dim j As HttpJob";
mostCurrent._j = new ir.taravatgroup.shokrgozari.httpjob();
 //BA.debugLineNum = 27;BA.debugLine="Dim list_download As List";
mostCurrent._list_download = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 28;BA.debugLine="Dim current_down_name As String=\"\"";
mostCurrent._current_down_name = "";
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 54;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_down_del_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 70;BA.debugLine="Dim func_del_down As Label=Sender";
_func_del_down = new anywheresoftware.b4a.objects.LabelWrapper();
_func_del_down = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 73;BA.debugLine="Dim list_row_mod As List";
_list_row_mod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 74;BA.debugLine="list_row_mod.Initialize";
_list_row_mod.Initialize();
 //BA.debugLineNum = 75;BA.debugLine="list_row_mod=strFunc.Split(func_del_down.Tag , \"@";
_list_row_mod = parent.mostCurrent._strfunc._vvvvvv5(BA.ObjectToString(_func_del_down.getTag()),"@");
 //BA.debugLineNum = 77;BA.debugLine="If(list_row_mod.Get(0)=\"down\")Then";
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
 //BA.debugLineNum = 79;BA.debugLine="Dim rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 80;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
_rp.CheckAndRequest(processBA,_rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
 //BA.debugLineNum = 81;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 82;BA.debugLine="If Result Then";
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
 //BA.debugLineNum = 88;BA.debugLine="func_del_down.Text=Chr(0xF1CE)  'downloading";
_func_del_down.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf1ce))));
 //BA.debugLineNum = 89;BA.debugLine="myFunc.setRotation(func_del_down,10000,360)";
parent.mostCurrent._myfunc._setrotation /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_func_del_down.getObject())),(int) (10000),(float) (360));
 //BA.debugLineNum = 90;BA.debugLine="func_del_down.SetTextColorAnimated(300,Colors.Bl";
_func_del_down.SetTextColorAnimated((int) (300),anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 95;BA.debugLine="If (current_down_name=\"\")Then";
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
 //BA.debugLineNum = 96;BA.debugLine="current_down_name=list_row_mod.Get(1)";
parent.mostCurrent._current_down_name = BA.ObjectToString(_list_row_mod.Get((int) (1)));
 //BA.debugLineNum = 97;BA.debugLine="download_byName";
_download_byname();
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 99;BA.debugLine="list_download.Add(list_row_mod.Get(1))";
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
 //BA.debugLineNum = 109;BA.debugLine="delete_fileByName(list_row_mod.Get(1))";
_delete_filebyname(BA.ObjectToString(_list_row_mod.Get((int) (1))));
 if (true) break;

case 18:
//C
this.state = -1;
;
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _pan_download_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _go_to_readingbook = null;
 //BA.debugLineNum = 116;BA.debugLine="Private Sub pan_download_Click";
 //BA.debugLineNum = 117;BA.debugLine="Dim go_to_readingBook As Panel=Sender";
_go_to_readingbook = new anywheresoftware.b4a.objects.PanelWrapper();
_go_to_readingbook = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 119;BA.debugLine="Main.current_book_content_id=go_to_readingBook.Ta";
mostCurrent._main._current_book_content_id /*int*/  = (int)(BA.ObjectToNumber(_go_to_readingbook.getTag()));
 //BA.debugLineNum = 121;BA.debugLine="StartActivity(reagBook_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._reagbook_activity.getObject()));
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
