package kj.calctahlilan;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class anotherdatepicker extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "kj.calctahlilan.anotherdatepicker");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", kj.calctahlilan.anotherdatepicker.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _holder = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsbackground = null;
public anywheresoftware.b4a.objects.PanelWrapper _dayspanel = null;
public int _month = 0;
public int _year = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _months = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _years = null;
public float _boxw = 0f;
public float _boxh = 0f;
public float _vcorrection = 0f;
public int _action_up = 0;
public int _action_move = 0;
public int _action_down = 0;
public int _tempselectedday = 0;
public anywheresoftware.b4a.objects.PanelWrapper _dayspanelbackground = null;
public int _dayofweekoffset = 0;
public int _daysinmonth = 0;
public int _tempselectedcolor = 0;
public int _selectedcolor = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lblselectedday = null;
public long _selecteddate = 0L;
public anywheresoftware.b4a.objects.LabelWrapper _targetlabel = null;
public int _selectedyear = 0;
public int _selectedmonth = 0;
public int _selectedday = 0;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _daysnames = null;
public Object _mtarget = null;
public String _meventname = "";
public boolean _waitforaddtoactivity = false;
public int _minyear = 0;
public int _maxyear = 0;
public int _firstday = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntoday = null;
public b4a.example.dateutils _dateutils = null;
public kj.calctahlilan.main _main = null;
public kj.calctahlilan.home _home = null;
public kj.calctahlilan.starter _starter = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
anywheresoftware.b4a.objects.ActivityWrapper _act = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.EditTextWrapper _et = null;
int _y = 0;
String _m = "";
anywheresoftware.b4a.objects.collections.List _alldays = null;
anywheresoftware.b4a.objects.collections.List _days = null;
int _i = 0;
String _d = "";
 //BA.debugLineNum = 70;BA.debugLine="Public Sub AfterLoadLayout (Props As Map)";
 //BA.debugLineNum = 71;BA.debugLine="waitForAddToActivity = False";
_waitforaddtoactivity = __c.False;
 //BA.debugLineNum = 72;BA.debugLine="holder.Initialize(\"holder\")";
_holder.Initialize(ba,"holder");
 //BA.debugLineNum = 73;BA.debugLine="holder.Visible = False";
_holder.setVisible(__c.False);
 //BA.debugLineNum = 74;BA.debugLine="holder.Color = Colors.Transparent";
_holder.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 75;BA.debugLine="Dim act As Activity = Props.Get(\"activity\")";
_act = new anywheresoftware.b4a.objects.ActivityWrapper();
_act.setObject((anywheresoftware.b4a.BALayout)(_props.Get((Object)("activity"))));
 //BA.debugLineNum = 76;BA.debugLine="act.AddView(holder, 0, 0, 100%x, 100%y)";
_act.AddView((android.view.View)(_holder.getObject()),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
 //BA.debugLineNum = 77;BA.debugLine="holder.LoadLayout(\"DatePicker\")";
_holder.LoadLayout("DatePicker",ba);
 //BA.debugLineNum = 78;BA.debugLine="Dim p As Panel = holder.GetView(0)";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p.setObject((android.view.ViewGroup)(_holder.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 79;BA.debugLine="p.Color = Props.Get(\"BackgroundColor\")";
_p.setColor((int)(BA.ObjectToNumber(_props.Get((Object)("BackgroundColor")))));
 //BA.debugLineNum = 80;BA.debugLine="If Props.Get(\"CancelVisible\") = False And Props.G";
if ((_props.Get((Object)("CancelVisible"))).equals((Object)(__c.False)) && (_props.Get((Object)("TodayVisible"))).equals((Object)(__c.False))) { 
_p.setHeight((int) (_p.getHeight()-__c.DipToCurrent((int) (40))));};
 //BA.debugLineNum = 81;BA.debugLine="btnToday.Visible = Props.Get(\"TodayVisible\")";
_btntoday.setVisible(BA.ObjectToBoolean(_props.Get((Object)("TodayVisible"))));
 //BA.debugLineNum = 82;BA.debugLine="btnCancel.Visible = Props.Get(\"CancelVisible\")";
_btncancel.setVisible(BA.ObjectToBoolean(_props.Get((Object)("CancelVisible"))));
 //BA.debugLineNum = 83;BA.debugLine="daysNames = Array As Label(Label1, Label2, Label3";
_daysnames = new anywheresoftware.b4a.objects.LabelWrapper[]{_label1,_label2,_label3,_label4,_label5,_label6,_label7};
 //BA.debugLineNum = 84;BA.debugLine="Dim et As EditText";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 85;BA.debugLine="et.Initialize(\"\")";
_et.Initialize(ba,"");
 //BA.debugLineNum = 86;BA.debugLine="targetLabel.Background = et.Background 'make the";
_targetlabel.setBackground(_et.getBackground());
 //BA.debugLineNum = 87;BA.debugLine="cvs.Initialize(DaysPanel)";
_cvs.Initialize((android.view.View)(_dayspanel.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="cvsBackground.Initialize(DaysPanelBackground)";
_cvsbackground.Initialize((android.view.View)(_dayspanelbackground.getObject()));
 //BA.debugLineNum = 89;BA.debugLine="selectedColor = Props.Get(\"SelectedColor\")";
_selectedcolor = (int)(BA.ObjectToNumber(_props.Get((Object)("SelectedColor"))));
 //BA.debugLineNum = 90;BA.debugLine="tempSelectedColor = Props.Get(\"HighlightedColor\")";
_tempselectedcolor = (int)(BA.ObjectToNumber(_props.Get((Object)("HighlightedColor"))));
 //BA.debugLineNum = 91;BA.debugLine="month = DateTime.GetMonth(DateTime.Now)";
_month = __c.DateTime.GetMonth(__c.DateTime.getNow());
 //BA.debugLineNum = 92;BA.debugLine="year = DateTime.GetYear(DateTime.Now)";
_year = __c.DateTime.GetYear(__c.DateTime.getNow());
 //BA.debugLineNum = 93;BA.debugLine="minYear = Props.Get(\"MinYear\")";
_minyear = (int)(BA.ObjectToNumber(_props.Get((Object)("MinYear"))));
 //BA.debugLineNum = 94;BA.debugLine="maxYear = Props.Get(\"MaxYear\")";
_maxyear = (int)(BA.ObjectToNumber(_props.Get((Object)("MaxYear"))));
 //BA.debugLineNum = 95;BA.debugLine="For y = minYear To maxYear";
{
final int step25 = 1;
final int limit25 = _maxyear;
_y = _minyear ;
for (;_y <= limit25 ;_y = _y + step25 ) {
 //BA.debugLineNum = 96;BA.debugLine="Years.Add(y)";
_years.Add(BA.NumberToString(_y));
 }
};
 //BA.debugLineNum = 98;BA.debugLine="For Each m As String In DateUtils.GetMonthsNames";
{
final anywheresoftware.b4a.BA.IterableList group28 = _dateutils._getmonthsnames(ba);
final int groupLen28 = group28.getSize()
;int index28 = 0;
;
for (; index28 < groupLen28;index28++){
_m = BA.ObjectToString(group28.Get(index28));
 //BA.debugLineNum = 99;BA.debugLine="Months.Add(m)";
_months.Add(_m);
 }
};
 //BA.debugLineNum = 101;BA.debugLine="Dim alldays As List = Regex.Split(\"\\|\", \"Sunday|M";
_alldays = new anywheresoftware.b4a.objects.collections.List();
_alldays = anywheresoftware.b4a.keywords.Common.ArrayToList(__c.Regex.Split("\\|","Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday"));
 //BA.debugLineNum = 102;BA.debugLine="firstDay = alldays.IndexOf(Props.Get(\"FirstDay\"))";
_firstday = _alldays.IndexOf(_props.Get((Object)("FirstDay")));
 //BA.debugLineNum = 103;BA.debugLine="Dim days As List = DateUtils.GetDaysNames";
_days = new anywheresoftware.b4a.objects.collections.List();
_days = _dateutils._getdaysnames(ba);
 //BA.debugLineNum = 104;BA.debugLine="For i = firstDay To firstDay + 7 - 1";
{
final int step34 = 1;
final int limit34 = (int) (_firstday+7-1);
_i = _firstday ;
for (;_i <= limit34 ;_i = _i + step34 ) {
 //BA.debugLineNum = 105;BA.debugLine="Dim d As String = days.Get(i Mod 7)";
_d = BA.ObjectToString(_days.Get((int) (_i%7)));
 //BA.debugLineNum = 106;BA.debugLine="daysNames(i - firstDay).Text = d.SubString2(0, 2";
_daysnames[(int) (_i-_firstday)].setText(BA.ObjectToCharSequence(_d.substring((int) (0),(int) (2))));
 }
};
 //BA.debugLineNum = 108;BA.debugLine="SetDate(DateTime.Now, False)";
_setdate(__c.DateTime.getNow(),__c.False);
 //BA.debugLineNum = 109;BA.debugLine="vCorrection = cvs.MeasureStringHeight(\"1\", Typefa";
_vcorrection = (float) (_cvs.MeasureStringHeight("1",__c.Typeface.DEFAULT_BOLD,_label1.getTextSize())/(double)2);
 //BA.debugLineNum = 110;BA.debugLine="boxW = cvs.Bitmap.Width / 7";
_boxw = (float) (_cvs.getBitmap().getWidth()/(double)7);
 //BA.debugLineNum = 111;BA.debugLine="boxH = cvs.Bitmap.Height / 6";
_boxh = (float) (_cvs.getBitmap().getHeight()/(double)6);
 //BA.debugLineNum = 112;BA.debugLine="lblSelectedDay.Visible = False";
_lblselectedday.setVisible(__c.False);
 //BA.debugLineNum = 113;BA.debugLine="DrawDays";
_drawdays();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub btnCancel_Click";
 //BA.debugLineNum = 215;BA.debugLine="CallSub3(mTarget, mEventName & \"_Closed\", True, G";
__c.CallSubNew3(ba,_mtarget,_meventname+"_Closed",(Object)(__c.True),(Object)(_getdate()));
 //BA.debugLineNum = 216;BA.debugLine="Hide";
_hide();
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public String  _btntoday_click() throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Private Sub btnToday_Click";
 //BA.debugLineNum = 209;BA.debugLine="SetDate(DateTime.Now, True)";
_setdate(__c.DateTime.getNow(),__c.True);
 //BA.debugLineNum = 210;BA.debugLine="CallSub3(mTarget, mEventName & \"_Closed\", False,";
__c.CallSubNew3(ba,_mtarget,_meventname+"_Closed",(Object)(__c.False),(Object)(_getdate()));
 //BA.debugLineNum = 211;BA.debugLine="Hide";
_hide();
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private holder As Panel";
_holder = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private cvs, cvsBackground As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
_cvsbackground = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private DaysPanel As Panel";
_dayspanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private month, year As Int";
_month = 0;
_year = 0;
 //BA.debugLineNum = 16;BA.debugLine="Private Months As Spinner";
_months = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private Years As Spinner";
_years = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private boxW, boxH As Float";
_boxw = 0f;
_boxh = 0f;
 //BA.debugLineNum = 19;BA.debugLine="Private vCorrection As Float";
_vcorrection = 0f;
 //BA.debugLineNum = 20;BA.debugLine="Private ACTION_UP = 1, ACTION_MOVE = 2, ACTION_DO";
_action_up = (int) (1);
_action_move = (int) (2);
_action_down = (int) (0);
 //BA.debugLineNum = 21;BA.debugLine="Private tempSelectedDay As Int";
_tempselectedday = 0;
 //BA.debugLineNum = 22;BA.debugLine="Private DaysPanelBackground As Panel";
_dayspanelbackground = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private dayOfWeekOffset As Int";
_dayofweekoffset = 0;
 //BA.debugLineNum = 24;BA.debugLine="Private daysInMonth As Int 'jumlah hari dalam sat";
_daysinmonth = 0;
 //BA.debugLineNum = 25;BA.debugLine="Private tempSelectedColor As Int";
_tempselectedcolor = 0;
 //BA.debugLineNum = 26;BA.debugLine="Private selectedColor As Int";
_selectedcolor = 0;
 //BA.debugLineNum = 27;BA.debugLine="Private lblSelectedDay As Label";
_lblselectedday = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private selectedDate As Long";
_selecteddate = 0L;
 //BA.debugLineNum = 29;BA.debugLine="Private targetLabel As Label";
_targetlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private selectedYear, selectedMonth, selectedDay";
_selectedyear = 0;
_selectedmonth = 0;
_selectedday = 0;
 //BA.debugLineNum = 31;BA.debugLine="Private Label1 As Label";
_label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private Label2 As Label";
_label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private Label3 As Label";
_label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private Label4 As Label";
_label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private Label5 As Label";
_label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private Label6 As Label";
_label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private Label7 As Label";
_label7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private daysNames() As Label";
_daysnames = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _daysnames.length;
for (int i0 = 0;i0 < d0;i0++) {
_daysnames[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 39;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
 //BA.debugLineNum = 40;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 41;BA.debugLine="Private waitForAddToActivity As Boolean";
_waitforaddtoactivity = false;
 //BA.debugLineNum = 42;BA.debugLine="Private minYear, maxYear, firstDay As Int";
_minyear = 0;
_maxyear = 0;
_firstday = 0;
 //BA.debugLineNum = 43;BA.debugLine="Private btnCancel, btnToday As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
_btntoday = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _dayspanel_touch(int _action,float _x,float _y) throws Exception{
int _boxx = 0;
int _boxy = 0;
int _newselectedday = 0;
boolean _validday = false;
 //BA.debugLineNum = 171;BA.debugLine="Private Sub DaysPanel_Touch (ACTION As Int, X As F";
 //BA.debugLineNum = 172;BA.debugLine="Dim boxX = X / boxW, boxY = Y / boxH As Int";
_boxx = (int) (_x/(double)_boxw);
_boxy = (int) (_y/(double)_boxh);
 //BA.debugLineNum = 173;BA.debugLine="Dim newSelectedDay As Int = boxY * 7 + boxX + 1 -";
_newselectedday = (int) (_boxy*7+_boxx+1-_dayofweekoffset);
 //BA.debugLineNum = 174;BA.debugLine="Dim validDay As Boolean = newSelectedDay > 0 And";
_validday = _newselectedday>0 && _newselectedday<=_daysinmonth;
 //BA.debugLineNum = 175;BA.debugLine="If ACTION = ACTION_DOWN Or ACTION = ACTION_MOVE T";
if (_action==_action_down || _action==_action_move) { 
 //BA.debugLineNum = 176;BA.debugLine="If newSelectedDay = tempSelectedDay Then Return";
if (_newselectedday==_tempselectedday) { 
if (true) return "";};
 //BA.debugLineNum = 177;BA.debugLine="cvsBackground.DrawColor(Colors.Transparent) 'cle";
_cvsbackground.DrawColor(__c.Colors.Transparent);
 //BA.debugLineNum = 178;BA.debugLine="tempSelectedDay = newSelectedDay";
_tempselectedday = _newselectedday;
 //BA.debugLineNum = 179;BA.debugLine="If validDay Then";
if (_validday) { 
 //BA.debugLineNum = 180;BA.debugLine="DrawBox(cvsBackground, tempSelectedColor, boxX,";
_drawbox(_cvsbackground,_tempselectedcolor,_boxx,_boxy);
 //BA.debugLineNum = 181;BA.debugLine="lblSelectedDay.Text = newSelectedDay";
_lblselectedday.setText(BA.ObjectToCharSequence(_newselectedday));
 //BA.debugLineNum = 182;BA.debugLine="lblSelectedDay.Visible = True";
_lblselectedday.setVisible(__c.True);
 }else {
 //BA.debugLineNum = 184;BA.debugLine="lblSelectedDay.Visible = False";
_lblselectedday.setVisible(__c.False);
 };
 }else if(_action==_action_up) { 
 //BA.debugLineNum = 187;BA.debugLine="lblSelectedDay.Visible = False";
_lblselectedday.setVisible(__c.False);
 //BA.debugLineNum = 188;BA.debugLine="cvsBackground.DrawColor(Colors.Transparent)";
_cvsbackground.DrawColor(__c.Colors.Transparent);
 //BA.debugLineNum = 189;BA.debugLine="If validDay Then";
if (_validday) { 
 //BA.debugLineNum = 190;BA.debugLine="SelectDay(newSelectedDay, True)";
_selectday(_newselectedday,__c.True);
 //BA.debugLineNum = 191;BA.debugLine="CallSub3(mTarget, mEventName & \"_Closed\", False";
__c.CallSubNew3(ba,_mtarget,_meventname+"_Closed",(Object)(__c.False),(Object)(_getdate()));
 //BA.debugLineNum = 192;BA.debugLine="Hide";
_hide();
 };
 };
 //BA.debugLineNum = 195;BA.debugLine="DaysPanelBackground.Invalidate";
_dayspanelbackground.Invalidate();
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Public Sub DesignerCreateView(base As Panel, lbl A";
 //BA.debugLineNum = 54;BA.debugLine="Dim targetLabel As Label";
_targetlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="targetLabel.Initialize(\"lbl\")";
_targetlabel.Initialize(ba,"lbl");
 //BA.debugLineNum = 56;BA.debugLine="targetLabel.TextSize = lbl.TextSize";
_targetlabel.setTextSize(_lbl.getTextSize());
 //BA.debugLineNum = 57;BA.debugLine="targetLabel.TextColor = lbl.TextColor";
_targetlabel.setTextColor(_lbl.getTextColor());
 //BA.debugLineNum = 58;BA.debugLine="base.AddView(targetLabel, 0, 0, base.Width, base.";
_base.AddView((android.view.View)(_targetlabel.getObject()),(int) (0),(int) (0),_base.getWidth(),_base.getHeight());
 //BA.debugLineNum = 59;BA.debugLine="base.Color = Colors.Transparent";
_base.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 60;BA.debugLine="waitForAddToActivity = True";
_waitforaddtoactivity = __c.True;
 //BA.debugLineNum = 63;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _drawbox(anywheresoftware.b4a.objects.drawable.CanvasWrapper _c,int _clr,int _x,int _y) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
 //BA.debugLineNum = 165;BA.debugLine="Private Sub DrawBox(c As Canvas, clr As Int, x As";
 //BA.debugLineNum = 166;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 167;BA.debugLine="r.Initialize(x * boxW, y * boxH, (x + 1) * boxW,";
_r.Initialize((int) (_x*_boxw),(int) (_y*_boxh),(int) ((_x+1)*_boxw),(int) ((_y+1)*_boxh));
 //BA.debugLineNum = 168;BA.debugLine="c.DrawRect(r, clr, True, 0)";
_c.DrawRect((android.graphics.Rect)(_r.getObject()),_clr,__c.True,(float) (0));
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _drawdays() throws Exception{
long _firstdayofmonth = 0L;
int _day = 0;
int _row = 0;
 //BA.debugLineNum = 133;BA.debugLine="Private Sub DrawDays";
 //BA.debugLineNum = 134;BA.debugLine="cvsBackground.DrawColor(Colors.Transparent)";
_cvsbackground.DrawColor(__c.Colors.Transparent);
 //BA.debugLineNum = 135;BA.debugLine="cvs.DrawColor(Colors.Transparent)";
_cvs.DrawColor(__c.Colors.Transparent);
 //BA.debugLineNum = 136;BA.debugLine="Dim firstDayOfMonth As Long = DateUtils.SetDate(y";
_firstdayofmonth = (long) (_dateutils._setdate(ba,_year,_month,(int) (1))-1);
 //BA.debugLineNum = 137;BA.debugLine="dayOfWeekOffset = (7 + DateTime.GetDayOfWeek(firs";
_dayofweekoffset = (int) ((7+__c.DateTime.GetDayOfWeek(_firstdayofmonth)-_firstday)%7);
 //BA.debugLineNum = 138;BA.debugLine="daysInMonth = DateUtils.NumberOfDaysInMonth(month";
_daysinmonth = _dateutils._numberofdaysinmonth(ba,_month,_year);
 //BA.debugLineNum = 139;BA.debugLine="If year = selectedYear And month = selectedMonth";
if (_year==_selectedyear && _month==_selectedmonth) { 
 //BA.debugLineNum = 141;BA.debugLine="DrawBox(cvs, selectedColor, (selectedDay - 1 + d";
_drawbox(_cvs,_selectedcolor,(int) ((_selectedday-1+_dayofweekoffset)%7),(int) ((_selectedday-1+_dayofweekoffset)/(double)7));
 };
 //BA.debugLineNum = 144;BA.debugLine="For day = 1 To daysInMonth";
{
final int step9 = 1;
final int limit9 = _daysinmonth;
_day = (int) (1) ;
for (;_day <= limit9 ;_day = _day + step9 ) {
 //BA.debugLineNum = 145;BA.debugLine="Dim row As Int = (day - 1 + dayOfWeekOffset) / 7";
_row = (int) ((_day-1+_dayofweekoffset)/(double)7);
 //BA.debugLineNum = 146;BA.debugLine="cvs.DrawText(day, (((dayOfWeekOffset + day - 1)";
_cvs.DrawText(ba,BA.NumberToString(_day),(float) ((((_dayofweekoffset+_day-1)%7)+0.5)*_boxw),(float) ((_row+0.5)*_boxh+_vcorrection),__c.Typeface.DEFAULT_BOLD,_label1.getTextSize(),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
 //BA.debugLineNum = 149;BA.debugLine="DaysPanel.Invalidate";
_dayspanel.Invalidate();
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public long  _getdate() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub GetDate As Long";
 //BA.debugLineNum = 117;BA.debugLine="Return selectedDate";
if (true) return _selecteddate;
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return 0L;
}
public String  _hide() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub Hide";
 //BA.debugLineNum = 161;BA.debugLine="holder.SetVisibleAnimated(500, False)";
_holder.SetVisibleAnimated((int) (500),__c.False);
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public String  _holder_click() throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Private Sub holder_Click";
 //BA.debugLineNum = 232;BA.debugLine="btnCancel_Click";
_btncancel_click();
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 48;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
 //BA.debugLineNum = 49;BA.debugLine="mTarget = Target";
_mtarget = _target;
 //BA.debugLineNum = 50;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public boolean  _isvisible() throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Public Sub IsVisible As Boolean";
 //BA.debugLineNum = 229;BA.debugLine="Return holder.Visible";
if (true) return _holder.getVisible();
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return false;
}
public String  _lbl_click() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Private Sub lbl_Click";
 //BA.debugLineNum = 67;BA.debugLine="Show";
_show();
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _months_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Private Sub Months_ItemClick (Position As Int, Val";
 //BA.debugLineNum = 220;BA.debugLine="month = Position + 1";
_month = (int) (_position+1);
 //BA.debugLineNum = 221;BA.debugLine="DrawDays";
_drawdays();
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public String  _selectday(int _day,boolean _updatelabel) throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Private Sub SelectDay(day As Int, UpdateLabel As B";
 //BA.debugLineNum = 153;BA.debugLine="selectedDate = DateUtils.SetDate(year, month, day";
_selecteddate = _dateutils._setdate(ba,_year,_month,_day);
 //BA.debugLineNum = 154;BA.debugLine="selectedDay = day";
_selectedday = _day;
 //BA.debugLineNum = 155;BA.debugLine="selectedMonth = month";
_selectedmonth = _month;
 //BA.debugLineNum = 156;BA.debugLine="selectedYear = year";
_selectedyear = _year;
 //BA.debugLineNum = 157;BA.debugLine="If UpdateLabel Then targetLabel.Text = DateTime.D";
if (_updatelabel) { 
_targetlabel.setText(BA.ObjectToCharSequence(__c.DateTime.Date(_selecteddate)));};
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public String  _setdate(long _date,boolean _updatelabel) throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Public Sub SetDate(date As Long, UpdateLabel As Bo";
 //BA.debugLineNum = 122;BA.debugLine="If waitForAddToActivity Then";
if (_waitforaddtoactivity) { 
 //BA.debugLineNum = 123;BA.debugLine="CallSubDelayed3(Me, \"SetDate\", date, UpdateLabel";
__c.CallSubDelayed3(ba,this,"SetDate",(Object)(_date),(Object)(_updatelabel));
 //BA.debugLineNum = 124;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 126;BA.debugLine="year = DateTime.GetYear(date)";
_year = __c.DateTime.GetYear(_date);
 //BA.debugLineNum = 127;BA.debugLine="month = DateTime.GetMonth(date)";
_month = __c.DateTime.GetMonth(_date);
 //BA.debugLineNum = 128;BA.debugLine="SelectDay(DateTime.GetDayOfMonth(date), UpdateLab";
_selectday(__c.DateTime.GetDayOfMonth(_date),_updatelabel);
 //BA.debugLineNum = 129;BA.debugLine="Years.SelectedIndex = year - minYear";
_years.setSelectedIndex((int) (_year-_minyear));
 //BA.debugLineNum = 130;BA.debugLine="Months.SelectedIndex = month - 1";
_months.setSelectedIndex((int) (_month-1));
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public String  _show() throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Public Sub Show";
 //BA.debugLineNum = 199;BA.debugLine="If waitForAddToActivity Then";
if (_waitforaddtoactivity) { 
 //BA.debugLineNum = 201;BA.debugLine="CallSubDelayed(Me, \"show\")";
__c.CallSubDelayed(ba,this,"show");
 //BA.debugLineNum = 202;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 204;BA.debugLine="holder.SetVisibleAnimated(500, True)";
_holder.SetVisibleAnimated((int) (500),__c.True);
 //BA.debugLineNum = 205;BA.debugLine="DrawDays";
_drawdays();
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public String  _years_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 224;BA.debugLine="Private Sub Years_ItemClick (Position As Int, Valu";
 //BA.debugLineNum = 225;BA.debugLine="year = Value";
_year = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 226;BA.debugLine="DrawDays";
_drawdays();
 //BA.debugLineNum = 227;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
if (BA.fastSubCompare(sub, "SETDATE"))
	return _setdate(((Number)args[0]).longValue(), (Boolean) args[1]);
if (BA.fastSubCompare(sub, "SHOW"))
	return _show();
return BA.SubDelegator.SubNotFound;
}
}
