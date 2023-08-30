package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_all_tamrin_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 3;BA.debugLine="Panel1.HorizontalCenter=50%x"[all_tamrin_layout/General script]
views.get("panel1").vw.setLeft((int)((50d / 100 * width) - (views.get("panel1").vw.getWidth() / 2)));

}
}