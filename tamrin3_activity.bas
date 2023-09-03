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

	Private et_matn1 As EditText
	Private et_matn2 As EditText
	Private et_matn3 As EditText
	Private pan_upload_pic1 As Panel
	Private pan_upload_pic2 As Panel
	Private pan_upload_pic3 As Panel
	
	Dim pic_upload_index As Int=0
	Private pan_showPic As Panel
	Private pan_all_showPic As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin3_layout")
	'pan_upload_pic1.Background=LoadBitmap(File.DirInternal,"pic_tamrin3.jpg")
	Main.Chooser.Initialize("chooser")
	et_matn1.Color=0xABFFFFFF
	et_matn2.Color=0xABFFFFFF
	et_matn3.Color=0xABFFFFFF
	
	If(File.Exists(File.DirInternal,"pic_tamrin1.jpg"))Then
		pan_upload_pic1.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin1.jpg",120dip,120dip))
	End If
	If(File.Exists(File.DirInternal,"pic_tamrin2.jpg"))Then
		pan_upload_pic2.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin2.jpg",120dip,120dip))
	End If
	If(File.Exists(File.DirInternal,"pic_tamrin3.jpg"))Then
		pan_upload_pic3.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin3.jpg",120dip,120dip))
	End If
	
	Dim ls_content As List
	ls_content.Initialize
	ls_content=myFunc.get_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin)
	
	et_matn1.text=ls_content.Get(0)
	et_matn2.text=ls_content.Get(1)
	et_matn3.text=ls_content.Get(2)
	
	
End Sub
Sub chooser_Result (Success As Boolean, Dir As String, FileName As String)
	If Success Then
		
		Select pic_upload_index
			Case 1
				pan_upload_pic1.SetBackgroundImage(LoadBitmapSample(Dir,FileName,120dip,120dip))
				File.Copy(Dir,FileName,File.DirInternal,"pic_tamrin1.jpg")
			Case 2
				pan_upload_pic2.SetBackgroundImage(LoadBitmapSample(Dir,FileName,120dip,120dip))
				File.Copy(Dir,FileName,File.DirInternal,"pic_tamrin2.jpg")
			Case 3
				pan_upload_pic3.SetBackgroundImage(LoadBitmapSample(Dir,FileName,120dip,120dip))
				File.Copy(Dir,FileName,File.DirInternal,"pic_tamrin3.jpg")
				
		End Select
		
		pan_showPic.SetBackgroundImage(LoadBitmapSample(Dir,FileName,120dip,120dip))
		
	Else
		ToastMessageShow("No image selected", True)
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
		If(pan_all_showPic.Visible=True)Then
			pan_all_showPic.Visible=False
		Else
			lbl_back_Click
		End If
		
	
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub pan_upload_pic3_Click
	pic_upload_index=3
	
	If(File.Exists(File.DirInternal,"pic_tamrin3.jpg"))Then
		pan_all_showPic.Visible=True
		pan_showPic.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin3.jpg",120dip,120dip))
	Else
		Main.Chooser.Show("image/*", "Select an image")
	End If
	
End Sub

Private Sub pan_upload_pic2_Click
	pic_upload_index=2
	
	If(File.Exists(File.DirInternal,"pic_tamrin2.jpg"))Then
		pan_all_showPic.Visible=True
		pan_showPic.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin2.jpg",120dip,120dip))
	Else
		Main.Chooser.Show("image/*", "Select an image")
	End If
	
End Sub

Private Sub pan_upload_pic1_Click
	pic_upload_index=1
	
	If(File.Exists(File.DirInternal,"pic_tamrin1.jpg"))Then
		pan_all_showPic.Visible=True
		pan_showPic.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_tamrin1.jpg",120dip,120dip))
	Else
		Main.Chooser.Show("image/*", "Select an image")
	End If
	
End Sub

Private Sub et_matn3_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,3,New,1)
End Sub

Private Sub et_matn2_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,2,New,1)
End Sub

Private Sub et_matn1_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,1,New,1)
End Sub

Private Sub pan_showPic_Click
	Main.Chooser.Show("image/*", "Select an image")
End Sub

Private Sub pan_all_showPic_Click
	pan_all_showPic.Visible=False
End Sub