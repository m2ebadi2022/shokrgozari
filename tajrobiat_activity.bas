B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pan_all_send_comment As Panel
	Private et_addComment_title As EditText
	Private et_addComment_content As EditText
	Private webV_tajrobiat As WebView
	Dim j As HttpJob
	
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tajrobiat_layout")
	j.Initialize("", Me)
	
		
		fill_webView
		
	check_internet
	

End Sub





Sub fill_webView 
	If(myFunc.check_internet=True)Then
		webV_tajrobiat.LoadHtml("")
		
		webV_tajrobiat.LoadUrl("https://m2ebadi.iapp.ir/shokrgozari/chat_shokrgozari.php?div_id="&Main.phon.GetSettings("android_id"))
	Else
		Dim result12 As Int
		result12 = Msgbox2Async("اتصال اینترنت را بررسی کنید", "توجه!", "تلاش دوباره", "", "", Null,False)
		
		If(result12=DialogResponse.POSITIVE)Then
			fill_webView
		End If
			
	End If

End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Private Sub lbl_back_Click
	Activity.Finish
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_send_comment.Visible=True)Then
			pan_all_send_comment.Visible=False
		Else
			lbl_back_Click
		End If
		
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub pan_send_comment_Click
	et_addComment_title.Text=""
	et_addComment_content.Text=""
	
	
	pan_all_send_comment.Visible=True
End Sub

Private Sub pan_all_send_comment_Click
	pan_all_send_comment.Visible=False
End Sub

Private Sub Panel2_Click
	
End Sub

Private Sub lbl_addComment_send_Click
	
	j.Download("https://m2ebadi.iapp.ir/shokrgozari/chat_shokrgozari_add.php?priv=pass2023&div_id="&Main.phon.GetSettings("android_id")&"&name="&et_addComment_title.Text&"&msg="&et_addComment_content.Text)
	Wait For JobDone(job As HttpJob)
	If job.Success Then
		
		ToastMessageShow("با تشکر ، نظر شما ارسال شد.",False)
	End If
	j.Release
	
	
	' refresh webview
	fill_webView
	pan_all_send_comment.Visible=False
End Sub



Sub check_internet As Boolean
	
	
	
	Dim connected As Boolean=False
	If Main.phon.GetDataState="CONNECTED" Then
		connected=True
	
		
		
		
'		Dim jo As HttpJob
'		jo.Initialize("jo", Me)
'		
'		jo.Download("https://m2ebadi.iapp.ir/shokrgozari/chek_internet.html")
		
'		Wait For JobDone(jo As HttpJob)
'		If jo.Success Then
'			
'			If(jo.GetString.Contains("connected")=True)Then
'				connected=True
'				ProgressDialogHide
'			Else
'				
'				
'				Dim result12 As Int
'				result12 = Msgbox2("اتصال اینترنت را بررسی کنید", "توجه!", "تلاش دوباره", "", "", Null)
'		
'				If(result12=DialogResponse.POSITIVE)Then
'					fill_webView
'				End If
'				
'				
'				connected=False
'				
'			End If
'			
'		End If
'		jo.Release

	Else
		
		
		
		
		
			
	End If
	
	
	
	Return connected
	
End Sub

