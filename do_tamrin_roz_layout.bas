B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle:  False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private CustomLV_tamrin As CustomListView
	
	
	Private xui As XUI
	Dim p As B4XView

	Private lbl_num As Label
	Private et_mohebat As EditText
	Private et_ealt As EditText
	
	Dim keyboard_detection As Int=0
	
	Private lbl_tamrin_roz As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("do_tamrin_roz_layout")

	
	Dim strFunc As StringFunctions
	strFunc.Initialize


	Dim ls_tamrin1_Roz As List
	ls_tamrin1_Roz.Initialize
	ls_tamrin1_Roz=myFunc.get_tamrin1_byRoz(Main.current_roz_tamrin)
	
	lbl_tamrin_roz.Text="تمرین روز "&Main.current_roz_tamrin

	For i=0 To ls_tamrin1_Roz.Size-1
		
		p = xui.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 100%x, 140dip)
		p.LoadLayout("item_list_tamrin1")
		
		et_mohebat.Color=Colors.White
		et_ealt.Color=Colors.White
		
		CustomLV_tamrin.Add(p,i)
		
		
		Dim list_num As List
		list_num.Initialize
		list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , "@")
		
		
		
		lbl_num.Text=i+1
		
		If(list_num.Get(2)<>"null")Then
			et_mohebat.Text=list_num.Get(2)
		End If
		If(list_num.Get(3)<>"null")Then
			et_ealt.Text=list_num.Get(3)
		End If
		
		et_mohebat.Tag=list_num.Get(0)
		et_ealt.Tag=list_num.Get(0)
		
		
	Next


End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
	
	Activity.Finish
End Sub



Private Sub et_ealt_TextChanged (Old As String, New As String)
	
	Dim this_num_tamrin As EditText=Sender
	myFunc.update_tamrin1_elat(this_num_tamrin.Tag,this_num_tamrin.Text,1)
	
	
End Sub

Private Sub et_mohebat_TextChanged (Old As String, New As String)
	
	Dim this_num_tamrin As EditText=Sender
	myFunc.update_tamrin1_mohebat(this_num_tamrin.Tag,this_num_tamrin.Text,1)
'	
	
End Sub
'
Private Sub et_mohebat_FocusChanged (HasFocus As Boolean)
	If(HasFocus=True)Then
		If(keyboard_detection=0)Then
			p = xui.CreatePanel("p")
			p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)
			p.Color=0x81DADADA
			CustomLV_tamrin.Add(p,"")
			keyboard_detection=1
		End If
	Else
		If(keyboard_detection=1)Then
			CustomLV_tamrin.RemoveAt(10)
			keyboard_detection=0
		End If
	End If
End Sub

Private Sub et_ealt_FocusChanged (HasFocus As Boolean)
	If(HasFocus=True)Then
		If(keyboard_detection=0)Then
			p = xui.CreatePanel("p")
			p.SetLayoutAnimated(0, 0, 0, 100%x, 300dip)
			p.Color=0x81DADADA
			CustomLV_tamrin.Add(p,"")
			keyboard_detection=1
		End If
	Else
		If(keyboard_detection=1)Then
			CustomLV_tamrin.RemoveAt(10)
			keyboard_detection=0
		End If
	End If
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		lbl_back_Click
		Return True
	Else
		Return False
	End If
End Sub
