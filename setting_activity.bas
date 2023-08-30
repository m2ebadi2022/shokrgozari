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


	Private pan_off1 As Panel
	Private pan_on1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("setting_layout")
	
	
	If(File.Exists(File.DirInternal,"darkmod.txt"))Then
		Dim darkmod As Int = File.ReadString(File.DirInternal,"darkmod.txt")
		If(darkmod=0)Then
			
			pan_off1.Visible=True
			pan_on1.Visible=False
		Else
		
			pan_off1.Visible=False
			pan_on1.Visible=True
			
		End If
	Else
		File.WriteString(File.DirInternal,"darkmod.txt","0")
		
		pan_off1.Visible=True
		pan_on1.Visible=False
		
	End If

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


'Private Sub ToggleButton_darkMod_CheckedChange(Checked As Boolean)
'	pan_darkMod_Click
'End Sub

Private Sub pan_darkMod_Click
	
	If(pan_on1.Visible=False)Then
	
		pan_off1.Visible=False
		pan_on1.Visible=True
		
		File.WriteString(File.DirInternal,"darkmod.txt","1")
	Else
		
		pan_on1.Visible=False
		pan_off1.Visible=True
		File.WriteString(File.DirInternal,"darkmod.txt","0")
		
	End If
	
End Sub

Private Sub pan_remove_AllTamrinat_Click
	
	Msgbox2Async("آیا همه تمرینات من حذف شوند؟", "حذف", "بله", "", "خیر", Null, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		myFunc.removeAll_tamrinat
		ToastMessageShow("حذف شدند.",False)
	End If
	
	
	
End Sub

Private Sub pan_remove_allSounds_Click
	
	Msgbox2Async("آیا همه فایلهای صوتی دانلود شده حذف شوند؟", "حذف", "بله", "", "خیر", Null, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		
		Dim ls_removeAll As List
	ls_removeAll.Initialize
	ls_removeAll=myFunc.get_removeAll_list

	For i=0 To ls_removeAll.Size-1
		If(File.Exists(File.DirInternal,ls_removeAll.Get(i)))Then
			File.Delete(File.DirInternal,ls_removeAll.Get(i))
	End If
	Next
	ToastMessageShow("حذف شدند.",False)
	

	End If


	
	
	
End Sub





Private Sub lbl_back_Click
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
