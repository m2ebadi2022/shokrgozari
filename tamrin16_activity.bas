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
	Private et_mohebat1 As EditText
	Private et_mohebat2 As EditText
	Private et_mohebat3 As EditText
	Private et_mohebat4 As EditText
	Private et_mohebat5 As EditText
	Private et_mohebat6 As EditText
	Private et_mohebat7 As EditText
	Private et_mohebat8 As EditText
	Private et_mohebat9 As EditText
	Private et_mohebat10 As EditText
	Private et_moshkel As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin16_layout")
	ScrollView1.Panel.LoadLayout("tamrin8_items")
	

	Dim ls_get_content As List
	ls_get_content.Initialize
	ls_get_content=myFunc.get_all_tamrin16

	For i=0 To 10
		
		If(ls_get_content.Get(i)=Null)Then
			ls_get_content.Set(i,"")
		End If
	Next

	et_mohebat1.Text=ls_get_content.Get(0)
	et_mohebat2.Text=ls_get_content.Get(1)
	et_mohebat3.Text=ls_get_content.Get(2)
	et_mohebat4.Text=ls_get_content.Get(3)
	et_mohebat5.Text=ls_get_content.Get(4)
	et_mohebat6.Text=ls_get_content.Get(5)
	et_mohebat7.Text=ls_get_content.Get(6)
	et_mohebat8.Text=ls_get_content.Get(7)
	et_mohebat9.Text=ls_get_content.Get(8)
	et_mohebat10.Text=ls_get_content.Get(9)
	et_moshkel.Text=ls_get_content.Get(10)



End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub et_mohebat10_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(10,New)
End Sub

Private Sub et_mohebat9_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(9,New)
End Sub

Private Sub et_mohebat8_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(8,New)
End Sub

Private Sub et_mohebat7_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(7,New)
End Sub

Private Sub et_mohebat6_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(6,New)
End Sub

Private Sub et_mohebat5_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(5,New)
End Sub

Private Sub et_mohebat4_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(4,New)
End Sub

Private Sub et_mohebat3_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(3,New)
End Sub

Private Sub et_mohebat2_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(2,New)
End Sub

Private Sub et_mohebat1_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(1,New)
End Sub

Private Sub et_moshkel_TextChanged (Old As String, New As String)
	myFunc.update_tamrin16(11,New)
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