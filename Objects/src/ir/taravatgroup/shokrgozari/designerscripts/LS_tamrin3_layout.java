package ir.taravatgroup.shokrgozari.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_tamrin3_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pan_showpic").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_showpic").vw.getWidth() / 2)));
views.get("pan_showpic").vw.setTop((int)((50d / 100 * height) - (views.get("pan_showpic").vw.getHeight() / 2)));
views.get("et_matn1").vw.setHeight((int)((100d / 100 * height)/4d));
views.get("pan_upload_pic2").vw.setTop((int)((views.get("et_matn1").vw.getTop() + views.get("et_matn1").vw.getHeight())+(20d * scale)));
views.get("et_matn2").vw.setTop((int)((views.get("et_matn1").vw.getTop() + views.get("et_matn1").vw.getHeight())+(20d * scale)));
views.get("et_matn2").vw.setHeight((int)((100d / 100 * height)/4d));
views.get("pan_upload_pic3").vw.setTop((int)((views.get("et_matn2").vw.getTop() + views.get("et_matn2").vw.getHeight())+(20d * scale)));
views.get("et_matn3").vw.setTop((int)((views.get("et_matn2").vw.getTop() + views.get("et_matn2").vw.getHeight())+(20d * scale)));
views.get("et_matn3").vw.setHeight((int)((100d / 100 * height)/4d));

}
}