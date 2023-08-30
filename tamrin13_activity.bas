B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen:  True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private et_name1 As EditText
	Private et_matn1 As EditText
	Private et_matn2 As EditText
	Private et_name2 As EditText
	Private et_name3 As EditText
	Private et_matn3 As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin13_layout")
	
	et_name1.Color=0xABFFFFFF
	et_name2.Color=0xABFFFFFF
	et_name3.Color=0xABFFFFFF
	
	et_matn1.Color=0xABFFFFFF
	et_matn2.Color=0xABFFFFFF
	et_matn3.Color=0xABFFFFFF


	et_name1.text=null_change(myFunc.get_all_tamrin13_byId(1).Get(0))
	et_name2.text=null_change(myFunc.get_all_tamrin13_byId(2).Get(0))
	et_name3.text=null_change(myFunc.get_all_tamrin13_byId(3).Get(0))
	
	et_matn1.text=null_change(myFunc.get_all_tamrin13_byId(1).Get(1))
	et_matn2.text=null_change(myFunc.get_all_tamrin13_byId(2).Get(1))
	et_matn3.text=null_change(myFunc.get_all_tamrin13_byId(3).Get(1))
'	
	
End Sub

Sub null_change (str As String) As String
	Dim res_str As String=str
	
	If(str="null")Then
		res_str=""
	End If
	Return  res_str
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub et_matn3_TextChanged (Old As String, New As String)
	myFunc.update_tamrin13(3,et_name3.Text,et_matn3.Text)
End Sub


Private Sub et_matn2_TextChanged (Old As String, New As String)
	myFunc.update_tamrin13(2,et_name2.Text,et_matn2.Text)
End Sub

Private Sub et_matn1_TextChanged (Old As String, New As String)
	myFunc.update_tamrin13(1,et_name1.Text,et_matn1.Text)
End Sub

Private Sub et_name3_TextChanged (Old As String, New As String)
	myFunc.update_tamrin13(3,et_name3.Text,et_matn3.Text)
End Sub

Private Sub et_name2_TextChanged (Old As String, New As String)
	myFunc.update_tamrin13(2,et_name2.Text,et_matn2.Text)
End Sub

Private Sub et_name1_TextChanged (Old As String, New As String)
	
	myFunc.update_tamrin13(1,et_name1.Text,et_matn1.Text)
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