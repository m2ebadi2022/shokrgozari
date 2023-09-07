package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_intro_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imageview2").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview2").vw.getWidth() / 2)));
views.get("imageview3").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview3").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="ImageView4.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview4").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview4").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="Label9.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label9").vw.setLeft((int)((50d / 100 * width) - (views.get("label9").vw.getWidth() / 2)));
//BA.debugLineNum = 9;BA.debugLine="Label4.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label4").vw.setLeft((int)((50d / 100 * width) - (views.get("label4").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="Label14.HorizontalCenter=50%x"[intro_layout/General script]
views.get("label14").vw.setLeft((int)((50d / 100 * width) - (views.get("label14").vw.getWidth() / 2)));
//BA.debugLineNum = 11;BA.debugLine="Panel5.HorizontalCenter=50%x"[intro_layout/General script]
views.get("panel5").vw.setLeft((int)((50d / 100 * width) - (views.get("panel5").vw.getWidth() / 2)));
//BA.debugLineNum = 12;BA.debugLine="ImageView5.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview5").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview5").vw.getWidth() / 2)));
//BA.debugLineNum = 13;BA.debugLine="ImageView6.HorizontalCenter=50%x"[intro_layout/General script]
views.get("imageview6").vw.setLeft((int)((50d / 100 * width) - (views.get("imageview6").vw.getWidth() / 2)));
//BA.debugLineNum = 14;BA.debugLine="ImageView7.Width=100%x"[intro_layout/General script]
views.get("imageview7").vw.setWidth((int)((100d / 100 * width)));

}
}