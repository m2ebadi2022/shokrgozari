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

	Private ScrollView1 As ScrollView
	Private et_matn1 As EditText
	Private et_matn2 As EditText
	Private et_matn3 As EditText
	Private et_title1 As EditText
	Private et_title2 As EditText
	Private et_title3 As EditText
	Private et_etefag1 As EditText
	Private et_etefag2 As EditText
	Private et_etefag3 As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin22_layout")
	ScrollView1.Panel.LoadLayout("item_tamrin22")


	et_matn1.Color=0x00FF0000
	et_matn2.Color=0x00FF0000
	et_matn3.Color=0x00FF0000
	
	et_title1.Color=0x00FF0000
	et_title2.Color=0x00FF0000
	et_title3.Color=0x00FF0000
	
	et_etefag1.Color=0x00FF0000
	et_etefag2.Color=0x00FF0000
	et_etefag3.Color=0x00FF0000

	Dim ls_content As List
	ls_content.Initialize
	ls_content=myFunc.get_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin)
	
	
	
	et_title1.text=ls_content.Get(0)
	et_title2.text=ls_content.Get(1)
	et_title3.text=ls_content.Get(2)
	
	et_matn1.text=ls_content.Get(3)
	et_matn2.text=ls_content.Get(4)
	et_matn3.text=ls_content.Get(5)
	
	et_etefag1.text=ls_content.Get(6)
	et_etefag2.text=ls_content.Get(7)
	et_etefag3.text=ls_content.Get(8)
	
	
	



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
		
			lbl_back_Click
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub et_etefag3_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,9,New,1)
End Sub

Private Sub et_etefag2_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,8,New,1)
End Sub

Private Sub et_etefag1_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,7,New,1)
End Sub

Private Sub et_title3_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,3,New,1)
End Sub

Private Sub et_title2_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,2,New,1)
End Sub

Private Sub et_title1_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,1,New,1)
End Sub

Private Sub et_matn3_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,6,New,1)
End Sub

Private Sub et_matn2_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,5,New,1)
End Sub

Private Sub et_matn1_TextChanged (Old As String, New As String)
	myFunc.update_tamrinat_saved(Main.current_roz_tamrin,Main.current_tamrin,4,New,1)
End Sub