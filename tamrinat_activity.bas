B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
Dim tim_scroll As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private cusListV_data As CustomListView
	Private xui As XUI
	Dim p As B4XView
	
	Dim pos_scroll As Int=0
	
	Private lbl_roz As Label
	Private lbl_icon_roz As Label
	Private pan_roz As Panel
	Dim isfitest As Boolean=True
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrinat_layout")

	tim_scroll.Initialize("tim_scroll",300)

	

End Sub

Sub Activity_Resume
	fill_list
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
Activity.Finish
End Sub




Private Sub pan_roz_Click
	Dim this_roz As Panel=Sender
	
	Main.current_roz_tamrin=this_roz.Tag
	isfitest=False
	
	If(Main.current_roz_tamrin=29)Then
		'Msgbox("در حال تکمیل ...","")
		StartActivity(daftar_activity)
	Else
		StartActivity(tamrin_roz_activity)
	End If
	
	
	
	
End Sub

Sub fill_list
	
	cusListV_data.Clear

	Dim list_rozha As List
	list_rozha.Initialize
	list_rozha=myFunc.get_rozha
	
	Dim strFunc As StringFunctions
	strFunc.Initialize
	Dim list_roz As List
	list_roz.Initialize
	

	For i=0 To list_rozha.Size-1
		
		p = xui.CreatePanel("p")
		
		p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)
		p.LoadLayout("item_list_rozha_tamrin")
		
		
		cusListV_data.Add(p,i)
		
		
		Dim list_roz As List
		list_roz.Initialize
		list_roz=strFunc.Split(list_rozha.Get(i) , "@")
		
	
		lbl_roz.Text=list_roz.Get(0)
		
		pan_roz.Tag=i+1
		
		Dim code_state As Int = myFunc.get_State_tamrin1_byRoz(i+1)
		If(code_state=10)Then
			lbl_icon_roz.TextColor=0xFF0FA900
			lbl_icon_roz.Visible=True
			
		Else If(code_state = 0 )Then
			lbl_icon_roz.TextColor=0xFFFF211F
			
			If(pos_scroll= 0)Then
				pos_scroll=i
				
			End If
			
			
			
		Else
			lbl_icon_roz.Visible=True
			lbl_icon_roz.TextColor=0xFFFF9900
		End If
		
	Next
	

	If (isfitest=True)Then
		tim_scroll.Enabled=True
	End If

	
	
End Sub


Sub tim_scroll_Tick
	
	cusListV_data.ScrollToItem(pos_scroll)
	
	tim_scroll.Enabled=False
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		
			lbl_back_Click
	
		Return True
	Else
		Return False
	End If
End Sub
