B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle:   False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private lbl_title As Label
	Private xui As XUI
	Dim pic_addres As String=""
	Dim sound_addres As String=""
	Private WebView1 As WebView
	
	Dim dark_mod As Int =0
	Dim str_html_lite As String
	Dim str_html_dark As String
	
	Private lbl_dark_view As Label
	Private WebView_player As WebView
	Private lbl_fav As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("readBook_layout")

	Dim ls_content_book As List
	ls_content_book.Initialize

	ls_content_book=	myFunc.get_book_byId(Main.current_book_content_id)

	lbl_title.Text=ls_content_book.Get(5)
	
	
	pic_addres=ls_content_book.Get(2)
	sound_addres=ls_content_book.Get(3)
	
	ls_content_book.Get(4)
	If(ls_content_book.Get(4).As(Int)=1)Then
		lbl_fav.Text=Chr(0xF004)
		lbl_fav.TextColor=0xFFFF3838
	Else
		lbl_fav.Text=Chr(0xF08A)
		lbl_fav.TextColor=0xFF686868
	End If
	
	
	
	
	
	str_html_lite="<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color:  rgba(0, 0, 0, 0) ; color: black;'><img src='"&xui.FileUri(File.DirAssets,pic_addres)&"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"&ls_content_book.Get(0)&"</b><p>"&ls_content_book.Get(1)&"<br><br><br><br></p></body></html>"
	
	
	str_html_dark="<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word; background-color: rgba(0, 0, 0, 0); color: white;'><img src='"&xui.FileUri(File.DirAssets,pic_addres)&"' alt='pic' style=' display: block;margin-left: auto;margin-right: auto;width: 90%; border-radius: 8%;'><br><b>"&ls_content_book.Get(0)&"</b><p>"&ls_content_book.Get(1)&"<br><br><br><br></p></body></html>"
	
	
	''  webvew acces file ***************
	Private wvsetttings As WebViewSettings
	wvsetttings.setAllowFileAccess(WebView1,True)
	wvsetttings.setAllowFileAccess(WebView_player,True)
	''************************
	
	If(File.Exists(File.DirInternal,sound_addres))Then
		Dim str_html_pleyer As String="<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='"&xui.FileUri(File.DirInternal,sound_addres)&"' type='audio/mpeg' ></audio></html>"
		
		
		
	Else
		Dim str_html_pleyer As String="<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><audio style='width:100%;' controls><source src='https://m2ebadi.iapp.ir/shokrgozari/sounds/"&sound_addres&"' type='audio/mpeg' ></audio></html>"
		
		
			
	End If
	
	WebView_player.Color=Colors.ARGB(0,0,0,0)
	WebView_player.LoadHtml(str_html_pleyer)
	
	
	WebView1.Color=Colors.ARGB(0,0,0,0)
	
	
	
	
	
	
	
	If(File.Exists(File.DirInternal,"darkmod.txt"))Then
		dark_mod = File.ReadString(File.DirInternal,"darkmod.txt")
		If(dark_mod=1)Then
			' dark
			Activity.Color=Colors.Black
			WebView1.LoadHtml(str_html_dark)
			lbl_dark_view.Text=Chr(0xF185)
		Else
			'lite
			WebView1.LoadHtml(str_html_lite)	
		End If
		
		
	Else
		
		WebView1.LoadHtml(str_html_lite)
		
	End If
	
	
	
	
	
	
	
	
	
	'myFunc.update_bookState_byId(Main.current_book_content_id)
	File.WriteString(File.DirInternal,"temp_read.txt",Main.current_book_content_id)
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
	WebView1.LoadHtml("")
	WebView_player.LoadHtml("")
	Activity.Finish
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		lbl_back_Click
		Return True
	Else
		Return False
	End If
End Sub




Private Sub lbl_dark_view_Click
'	setter
	
	If(dark_mod=0)Then
		Activity.Color=Colors.Black
		WebView1.LoadHtml(str_html_dark)
		
		lbl_dark_view.Text=Chr(0xF185)
		dark_mod=1
	Else
		
		Activity.Color=Colors.White
		WebView1.LoadHtml(str_html_lite)
		
		lbl_dark_view.Text=Chr(0xF186)
		dark_mod=0
	End If
End Sub


Sub setter
	
	Dim rp As RuntimePermissions
	rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_STORAGE)
	Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
	If Result Then
		
		
   
	End If
	
End Sub

Private Sub lbl_go_tamrin_Click
	If((Main.current_book_content_id-1)=0)Then
		ToastMessageShow("بدون تمرین",False)
	Else If((Main.current_book_content_id-1)=29)Then
		ToastMessageShow("بدون تمرین",False)
	Else
		Main.current_roz_tamrin=Main.current_book_content_id-1
		WebView1.LoadHtml("")
		WebView_player.LoadHtml("")
		StartActivity(tamrin_roz_activity)
	End If
	
End Sub

Private Sub lbl_fav_Click
	
	Dim fav_state As Int = myFunc.get_fav_byId(Main.current_book_content_id)
	
	
	If(fav_state=1)Then
		
		myFunc.set_fav_book(Main.current_book_content_id,0)
		lbl_fav.Text=Chr(0xF08A)
		lbl_fav.TextColor=0xFF686868
	Else
		myFunc.set_fav_book(Main.current_book_content_id,1)
		lbl_fav.Text=Chr(0xF004)
		lbl_fav.TextColor=0xFFFF3838
		
	End If
	
End Sub