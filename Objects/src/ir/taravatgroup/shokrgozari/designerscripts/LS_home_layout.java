package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_home_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel4").vw.setLeft((int)((50d / 100 * width) - (views.get("panel4").vw.getWidth() / 2)));
//BA.debugLineNum = 5;BA.debugLine="pan_tamrin_roz.HorizontalCenter=50%x"[home_layout/General script]
views.get("pan_tamrin_roz").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_tamrin_roz").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="pan_tajrobiat.HorizontalCenter=50%x"[home_layout/General script]
views.get("pan_tajrobiat").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_tajrobiat").vw.getWidth() / 2)));

}
}