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

	Private Panel1 As Panel
	Private Panel2 As Panel
	Private Panel3 As Panel
	Dim startX, startY As Float '<-new global variables
	Dim current_page As Int =0
	Private Panel4 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("intro_layout")


End Sub
Sub Activity_Touch (Action As Int, X As Float, Y As Float)
	Select Action
		Case Activity.ACTION_DOWN
			startX = X
			startY = Y
		Case Activity.ACTION_UP
			If Abs(y - startY) > 20%y Then Return
			If X - startX > 30%x   Then
				previos_btn
			Else If startX - x > 30%x  Then
				next_btn
			End If
	End Select
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub next_btn
	current_page=current_page+1
	If(current_page=4)Then
		current_page=4
		lbl_next4_Click
	End If
	
	
	show_only_page(current_page)


End Sub


Sub previos_btn
	
	current_page=current_page-1
	If(current_page=-1)Then
		current_page=0
	End If
	
	show_only_page(current_page)
	
	
End Sub

Sub show_only_page(pageID As Int)
	Panel1.Visible=False
	Panel2.Visible=False
	Panel3.Visible=False
	Select pageID
		Case 0
			Panel1.Visible=True
			Panel2.Visible=False
			Panel3.Visible=False
			Panel4.Visible=False
		Case 1
			Panel1.Visible=False
			Panel2.Visible=True
			Panel3.Visible=False
			Panel4.Visible=False
			
		Case 2
			Panel1.Visible=False
			Panel2.Visible=False
			Panel3.Visible=True
			Panel4.Visible=False
		Case 3
			Panel1.Visible=False
			Panel2.Visible=False
			Panel3.Visible=False
			Panel4.Visible=True
			
	End Select
	
End Sub

Private Sub lbl_next3_Click
	next_btn
End Sub

Private Sub lbl_next2_Click
	next_btn
End Sub

Private Sub lbl_next4_Click
	File.WriteString(File.DirInternal,"intro_pley","1")
	Activity.Finish
End Sub

Private Sub lbl_next1_Click
	next_btn
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		Return True
	Else
		Return False
	End If
End Sub