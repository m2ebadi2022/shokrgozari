package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_tamrin13_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("et_matn1").vw.setHeight((int)((100d / 100 * height)/4d));
views.get("et_name2").vw.setTop((int)((views.get("et_matn1").vw.getTop() + views.get("et_matn1").vw.getHeight())+(20d * scale)));
views.get("et_matn2").vw.setTop((int)((views.get("et_matn1").vw.getTop() + views.get("et_matn1").vw.getHeight())+(20d * scale)));
views.get("et_matn2").vw.setHeight((int)((100d / 100 * height)/4d));
views.get("et_name3").vw.setTop((int)((views.get("et_matn2").vw.getTop() + views.get("et_matn2").vw.getHeight())+(20d * scale)));
views.get("et_matn3").vw.setTop((int)((views.get("et_matn2").vw.getTop() + views.get("et_matn2").vw.getHeight())+(20d * scale)));
views.get("et_matn3").vw.setHeight((int)((100d / 100 * height)/4d));

}
}