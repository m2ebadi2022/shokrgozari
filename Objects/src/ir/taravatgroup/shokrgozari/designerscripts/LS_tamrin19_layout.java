package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_tamrin19_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("lbl_add").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_add").vw.getWidth() / 2)));
views.get("panel2").vw.setTop((int)((30d / 100 * height) - (views.get("panel2").vw.getHeight() / 2)));

}
}