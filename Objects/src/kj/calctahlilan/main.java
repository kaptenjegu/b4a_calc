package kj.calctahlilan;


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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "kj.calctahlilan", "kj.calctahlilan.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "kj.calctahlilan", "kj.calctahlilan.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "kj.calctahlilan.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public anywheresoftware.b4a.objects.Timer _sptimer = null;
public static long _tgl_meninggal = 0L;
public static long _tgl_7 = 0L;
public static long _tgl_40 = 0L;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsp = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblresult = null;
public kj.calctahlilan.anotherdatepicker _anotherdatepicker1 = null;
public b4a.example.dateutils _dateutils = null;
public kj.calctahlilan.home _home = null;
public kj.calctahlilan.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (home.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"awal\")";
mostCurrent._activity.LoadLayout("awal",mostCurrent.activityBA);
 //BA.debugLineNum = 35;BA.debugLine="pnlSP.Visible = True";
mostCurrent._pnlsp.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 36;BA.debugLine="sptimer.Initialize(\"sptimer\",5000)";
mostCurrent._sptimer.Initialize(processBA,"sptimer",(long) (5000));
 //BA.debugLineNum = 37;BA.debugLine="sptimer.Enabled = True";
mostCurrent._sptimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 46;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 47;BA.debugLine="If Msgbox2(\"Apakah Anda ingin keluar dari aplika";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Apakah Anda ingin keluar dari aplikasi ini?"),BA.ObjectToCharSequence("Pesan"),"Ya","","Tidak",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 48;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 50;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static String  _anotherdatepicker1_closed(boolean _cancelled,long _date) throws Exception{
int _year = 0;
int _month = 0;
int _day = 0;
int _hari = 0;
b4a.example.dateutils._period _p = null;
long _tgl_hasil = 0L;
String _h_ke = "";
int _a = 0;
 //BA.debugLineNum = 55;BA.debugLine="Sub AnotherDatePicker1_Closed (Cancelled As Boolea";
 //BA.debugLineNum = 56;BA.debugLine="If Not(Cancelled) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_cancelled)) { 
 //BA.debugLineNum = 57;BA.debugLine="Dim year As Int = DateTime.GetYear(Date) 	'get t";
_year = anywheresoftware.b4a.keywords.Common.DateTime.GetYear(_date);
 //BA.debugLineNum = 58;BA.debugLine="Dim month As Int = DateTime.GetMonth(Date)";
_month = anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(_date);
 //BA.debugLineNum = 59;BA.debugLine="Dim day As Int = DateTime.GetDayOfMonth(Date)";
_day = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(_date);
 //BA.debugLineNum = 60;BA.debugLine="Dim hari As Int = DateTime.GetDayOfWeek(Date)";
_hari = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_date);
 //BA.debugLineNum = 61;BA.debugLine="Dim p As Period";
_p = new b4a.example.dateutils._period();
 //BA.debugLineNum = 62;BA.debugLine="Dim tgl_hasil As Long";
_tgl_hasil = 0L;
 //BA.debugLineNum = 63;BA.debugLine="Dim h_ke As String";
_h_ke = "";
 //BA.debugLineNum = 67;BA.debugLine="lblResult.Text = \"Meninggal : \"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence("Meninggal : "));
 //BA.debugLineNum = 68;BA.debugLine="lblResult.Text = lblResult.Text & nama_hari(Date";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+_nama_hari(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_date))));
 //BA.debugLineNum = 69;BA.debugLine="lblResult.Text = lblResult.Text & \", \" & DateTim";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+", "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(_date))));
 //BA.debugLineNum = 70;BA.debugLine="lblResult.Text = lblResult.Text & \"/\" & DateTime";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(_date))));
 //BA.debugLineNum = 71;BA.debugLine="lblResult.Text = lblResult.Text & \"/\" & DateTime";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(_date))));
 //BA.debugLineNum = 72;BA.debugLine="lblResult.Text = lblResult.Text & CRLF";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 73;BA.debugLine="For a=1 To 6";
{
final int step15 = 1;
final int limit15 = (int) (6);
_a = (int) (1) ;
for (;_a <= limit15 ;_a = _a + step15 ) {
 //BA.debugLineNum = 74;BA.debugLine="Select a";
switch (_a) {
case 1: {
 //BA.debugLineNum = 76;BA.debugLine="p.Days = 5	'rumus fix";
_p.Days = (int) (5);
 //BA.debugLineNum = 77;BA.debugLine="h_ke = \"Hari ke-7\"";
_h_ke = "Hari ke-7";
 break; }
case 2: {
 //BA.debugLineNum = 79;BA.debugLine="p.Days = 38	'rumus fix";
_p.Days = (int) (38);
 //BA.debugLineNum = 80;BA.debugLine="h_ke = \"Hari ke-40\"";
_h_ke = "Hari ke-40";
 break; }
case 3: {
 //BA.debugLineNum = 82;BA.debugLine="p.Days = 98	'rumus fix";
_p.Days = (int) (98);
 //BA.debugLineNum = 83;BA.debugLine="h_ke = \"Hari ke-100\"";
_h_ke = "Hari ke-100";
 break; }
case 4: {
 //BA.debugLineNum = 85;BA.debugLine="p.Days = 360 - 7	'rumus fix";
_p.Days = (int) (360-7);
 //BA.debugLineNum = 86;BA.debugLine="h_ke = \"Pendak 1 tahun\"";
_h_ke = "Pendak 1 tahun";
 break; }
case 5: {
 //BA.debugLineNum = 88;BA.debugLine="p.Days = 720 - 7";
_p.Days = (int) (720-7);
 //BA.debugLineNum = 89;BA.debugLine="h_ke = \"Pendak 2 tahun\"";
_h_ke = "Pendak 2 tahun";
 break; }
case 6: {
 //BA.debugLineNum = 91;BA.debugLine="p.Days = 1000";
_p.Days = (int) (1000);
 //BA.debugLineNum = 92;BA.debugLine="h_ke = \"Hari ke-1000\"";
_h_ke = "Hari ke-1000";
 break; }
}
;
 //BA.debugLineNum = 95;BA.debugLine="tgl_hasil = DateUtils.AddPeriod(Date, p)";
_tgl_hasil = mostCurrent._dateutils._addperiod(mostCurrent.activityBA,_date,_p);
 //BA.debugLineNum = 97;BA.debugLine="If a = 5 Or a = 6 Then";
if (_a==5 || _a==6) { 
 //BA.debugLineNum = 98;BA.debugLine="lblResult.Text = lblResult.Text & h_ke & \" : \"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+_h_ke+" : "));
 //BA.debugLineNum = 99;BA.debugLine="lblResult.Text = lblResult.Text & \"---Tunggu u";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+"---Tunggu update apk---"));
 //BA.debugLineNum = 100;BA.debugLine="lblResult.Text = lblResult.Text & CRLF";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 }else {
 //BA.debugLineNum = 102;BA.debugLine="lblResult.Text = lblResult.Text & h_ke & \" : \"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+_h_ke+" : "));
 //BA.debugLineNum = 103;BA.debugLine="lblResult.Text = lblResult.Text & nama_hari(Da";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+_nama_hari(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_tgl_hasil))));
 //BA.debugLineNum = 104;BA.debugLine="lblResult.Text = lblResult.Text & \", \" & DateT";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+", "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(_tgl_hasil))));
 //BA.debugLineNum = 105;BA.debugLine="lblResult.Text = lblResult.Text & \"/\" & DateTi";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(_tgl_hasil))));
 //BA.debugLineNum = 106;BA.debugLine="lblResult.Text = lblResult.Text & \"/\" & DateTi";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(_tgl_hasil))));
 //BA.debugLineNum = 107;BA.debugLine="lblResult.Text = lblResult.Text & CRLF";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 };
 }
};
 };
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Dim sptimer As Timer";
mostCurrent._sptimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 25;BA.debugLine="Dim tgl_meninggal, tgl_7, tgl_40  As Long";
_tgl_meninggal = 0L;
_tgl_7 = 0L;
_tgl_40 = 0L;
 //BA.debugLineNum = 26;BA.debugLine="Private pnlSP As Panel";
mostCurrent._pnlsp = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lblResult As Label";
mostCurrent._lblresult = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private AnotherDatePicker1 As AnotherDatePicker";
mostCurrent._anotherdatepicker1 = new kj.calctahlilan.anotherdatepicker();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _nama_hari(int _x) throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub nama_hari(x As Int)";
 //BA.debugLineNum = 115;BA.debugLine="Select x";
switch (_x) {
case 1: {
 //BA.debugLineNum = 117;BA.debugLine="Return \"Minggu\"";
if (true) return "Minggu";
 break; }
case 2: {
 //BA.debugLineNum = 119;BA.debugLine="Return \"Senin\"";
if (true) return "Senin";
 break; }
case 3: {
 //BA.debugLineNum = 121;BA.debugLine="Return \"Selasa\"";
if (true) return "Selasa";
 break; }
case 4: {
 //BA.debugLineNum = 123;BA.debugLine="Return \"Rabu\"";
if (true) return "Rabu";
 break; }
case 5: {
 //BA.debugLineNum = 125;BA.debugLine="Return \"Kamis\"";
if (true) return "Kamis";
 break; }
case 6: {
 //BA.debugLineNum = 127;BA.debugLine="Return \"Jumat\"";
if (true) return "Jumat";
 break; }
case 7: {
 //BA.debugLineNum = 129;BA.debugLine="Return \"Sabtu\"";
if (true) return "Sabtu";
 break; }
}
;
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
home._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _sptimer_tick() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub sptimer_tick";
 //BA.debugLineNum = 41;BA.debugLine="pnlSP.Visible = False";
mostCurrent._pnlsp.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 42;BA.debugLine="sptimer.Enabled = False";
mostCurrent._sptimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
}
