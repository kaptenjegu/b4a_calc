package kj.calctahlilan.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_awal{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[awal/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 5;BA.debugLine="pnlSP.Top = 0%y"[awal/General script]
views.get("pnlsp").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 6;BA.debugLine="pnlSP.Left = 0%x"[awal/General script]
views.get("pnlsp").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="pnlSP.Width = 100%x"[awal/General script]
views.get("pnlsp").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 8;BA.debugLine="pnlSP.Height = 100%y"[awal/General script]
views.get("pnlsp").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="pnlSP.Visible = false"[awal/General script]
views.get("pnlsp").vw.setVisible(BA.parseBoolean("false"));
//BA.debugLineNum = 12;BA.debugLine="lblJudul.Top = 10%y"[awal/General script]
views.get("lbljudul").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 13;BA.debugLine="lblJudul.Left = 20%x"[awal/General script]
views.get("lbljudul").vw.setLeft((int)((20d / 100 * width)));
//BA.debugLineNum = 14;BA.debugLine="lblJudul.Width = 60%x"[awal/General script]
views.get("lbljudul").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 15;BA.debugLine="lblJudul.Height = 10%y"[awal/General script]
views.get("lbljudul").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 18;BA.debugLine="lblTglWafat.Top = 25%y"[awal/General script]
views.get("lbltglwafat").vw.setTop((int)((25d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="lblTglWafat.Left = 10%x"[awal/General script]
views.get("lbltglwafat").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 20;BA.debugLine="lblTglWafat.Width = 33%x"[awal/General script]
views.get("lbltglwafat").vw.setWidth((int)((33d / 100 * width)));
//BA.debugLineNum = 21;BA.debugLine="lblTglWafat.Height = 8%y"[awal/General script]
views.get("lbltglwafat").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 24;BA.debugLine="AnotherDatePicker1.Top = lblTglWafat.Top"[awal/General script]
views.get("anotherdatepicker1").vw.setTop((int)((views.get("lbltglwafat").vw.getTop())));
//BA.debugLineNum = 25;BA.debugLine="AnotherDatePicker1.Left = lblTglWafat.Right + 2%x"[awal/General script]
views.get("anotherdatepicker1").vw.setLeft((int)((views.get("lbltglwafat").vw.getLeft() + views.get("lbltglwafat").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 26;BA.debugLine="AnotherDatePicker1.Width = 45%x"[awal/General script]
views.get("anotherdatepicker1").vw.setWidth((int)((45d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="AnotherDatePicker1.Height = lblTglWafat.Height"[awal/General script]
views.get("anotherdatepicker1").vw.setHeight((int)((views.get("lbltglwafat").vw.getHeight())));
//BA.debugLineNum = 30;BA.debugLine="lblResult.Top = lblTglWafat.Bottom + 5%y"[awal/General script]
views.get("lblresult").vw.setTop((int)((views.get("lbltglwafat").vw.getTop() + views.get("lbltglwafat").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 31;BA.debugLine="lblResult.Left = lblTglWafat.Left"[awal/General script]
views.get("lblresult").vw.setLeft((int)((views.get("lbltglwafat").vw.getLeft())));
//BA.debugLineNum = 32;BA.debugLine="lblResult.Width = 80%x"[awal/General script]
views.get("lblresult").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="lblResult.Height = 45%y"[awal/General script]
views.get("lblresult").vw.setHeight((int)((45d / 100 * height)));
//BA.debugLineNum = 36;BA.debugLine="lblFooter.Bottom = 100%y"[awal/General script]
views.get("lblfooter").vw.setTop((int)((100d / 100 * height) - (views.get("lblfooter").vw.getHeight())));
//BA.debugLineNum = 37;BA.debugLine="lblFooter.Left = lblResult.Left"[awal/General script]
views.get("lblfooter").vw.setLeft((int)((views.get("lblresult").vw.getLeft())));
//BA.debugLineNum = 38;BA.debugLine="lblFooter.Width = lblResult.Width"[awal/General script]
views.get("lblfooter").vw.setWidth((int)((views.get("lblresult").vw.getWidth())));
//BA.debugLineNum = 39;BA.debugLine="lblFooter.Height = 10%y"[awal/General script]
views.get("lblfooter").vw.setHeight((int)((10d / 100 * height)));

}
}