package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_do_tamrin_roz_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pan_showpic").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_showpic").vw.getWidth() / 2)));
//BA.debugLineNum = 4;BA.debugLine="pan_showPic.VerticalCenter=30%y"[do_tamrin_roz_layout/General script]
views.get("pan_showpic").vw.setTop((int)((30d / 100 * height) - (views.get("pan_showpic").vw.getHeight() / 2)));

}
}