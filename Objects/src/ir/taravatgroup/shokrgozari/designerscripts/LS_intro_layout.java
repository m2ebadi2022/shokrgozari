package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_intro_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imageview1").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview1").vw.getWidth() / 2)));
//BA.debugLineNum = 4;BA.debugLine="ImageView2.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview2").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview2").vw.getWidth() / 2)));
//BA.debugLineNum = 5;BA.debugLine="ImageView3.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview3").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview3").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="ImageView4.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview4").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview4").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="Label5.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label5").vw.setLeft((int)((50d / 100 * width) - (views.get("label5").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="Label6.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label6").vw.setLeft((int)((50d / 100 * width) - (views.get("label6").vw.getWidth() / 2)));
//BA.debugLineNum = 9;BA.debugLine="Label9.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label9").vw.setLeft((int)((50d / 100 * width) - (views.get("label9").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="Label4.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label4").vw.setLeft((int)((50d / 100 * width) - (views.get("label4").vw.getWidth() / 2)));
//BA.debugLineNum = 11;BA.debugLine="Label14.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label14").vw.setLeft((int)((50d / 100 * width) - (views.get("label14").vw.getWidth() / 2)));
//BA.debugLineNum = 12;BA.debugLine="Panel5.HorizontalCenter=50%x"[intro_layout/General script]
views.get("panel5").vw.setLeft((int)((50d / 100 * width) - (views.get("panel5").vw.getWidth() / 2)));

}
}