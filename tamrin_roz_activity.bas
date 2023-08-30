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

	Private lbl_titel_roz As Label
	Private CustomLV_tamrinat As CustomListView
	
	
	Private xui As XUI
	Dim p As B4XView
	Private lbl_roz As Label
	Private lbl_icon_roz As Label
	Private pan_roz As Panel
	
	
	Private WebView1 As WebView
	Private et_tamrin2 As EditText
	Private pan_all_tamrin2 As Panel
	Private lbl_save_tamrin2 As Label
	
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin_roz_layout")
	lbl_titel_roz.Text="تمرین روز "& Main.current_roz_tamrin
	
	
	

End Sub

Sub Activity_Resume
	fill_list
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Private Sub lbl_back_Click
	Activity.Finish
End Sub



Sub tamrin_name (num_tamrin As Int) As String
	
	Return myFunc.get_tamrinName(num_tamrin).Get(0)
End Sub

Private Sub pan_all_tamrin2_Click
	pan_all_tamrin2.Visible=False
End Sub


Sub fill_list
	
	CustomLV_tamrinat.Clear
	
	Dim list_rozha As List
	list_rozha.Initialize
	list_rozha=myFunc.get_roz_byId(Main.current_roz_tamrin)
	
	
	Dim str_html As String
	str_html="<html><head><meta name='viewport' content='width=device-width, initial-scale=1'></head><body dir='rtl' style='text-align: justify;  text-justify: inter-word;'><b>"&list_rozha.Get(0)&"</b><p>"&list_rozha.Get(1)&"<br></body></html>"
	
	
	WebView1.Color=Colors.ARGB(0,0,0,0)
	WebView1.LoadHtml(str_html)
	
	Dim strFunc As StringFunctions
	strFunc.Initialize
	
	Dim list_tamrinat As List
	list_tamrinat.Initialize
	list_tamrinat=strFunc.Split(list_rozha.Get(2) , ",")
	
	Dim list_tamrinat_state As List
	list_tamrinat_state.Initialize
	list_tamrinat_state=strFunc.Split(list_rozha.Get(3) , ",")
	
	
	For i=0 To list_tamrinat.Size-1
		
		p = xui.CreatePanel("p")
		
		p.SetLayoutAnimated(0, 0, 0, 96%x, 80dip)
		
		p.LoadLayout("item_list_rozha_tamrin")
		lbl_icon_roz.Visible=True
		
		CustomLV_tamrinat.Add(p,i)
		pan_roz.Elevation=0
		
		pan_roz.Tag=list_tamrinat.Get(i).As(Int)
		
		lbl_roz.Text="تمرین "&(i+1)& " : "&tamrin_name(pan_roz.Tag)
		
		
		
		
'		Dim state_tamrin As Int =list_tamrinat_state.Get(i)
'		If(state_tamrin=1)Then
'			lbl_icon_roz.TextColor=Colors.Green
'		Else
'			lbl_icon_roz.TextColor=Colors.LightGray
'		End If
'		


		'tamrin1 state
		Select pan_roz.Tag.As(Int)
			Case 1
				Dim code_state As Int = myFunc.get_State_tamrin1_byRoz(Main.current_roz_tamrin)
				If(code_state=10)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(code_state = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			Case 	2,4,5,6,7,9,10,11,12,15,17,18,20,21,24,26,28,29
				Dim state_tamrin2 As Int = myFunc.get_state(Main.current_roz_tamrin,pan_roz.Tag.As(Int))
				If(state_tamrin2 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFF0FA900
				End If
			Case 3
				Dim state_tamrin3 As Int=myFunc.get_State_tamrinat_saved(Main.current_roz_tamrin,3)
				If(state_tamrin3=3)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin3 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			Case 8
				
				Dim state_tamrin8 As Int=myFunc.get_state_tamrin8
				If(state_tamrin8>10)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin8 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
				
			Case 13
				
				Dim state_tamrin13 As Int=myFunc.get_state_tamrin13
				If(state_tamrin13=3)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin13 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			
			Case 14
				
				Dim state_tamrin14 As Int=myFunc.get_state_tamrin14
				If(state_tamrin14=10)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin14 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			Case 16
				
				Dim state_tamrin16 As Int=myFunc.get_state_tamrin16
				If(state_tamrin16>10)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin16 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
				
			Case 19
				
				Dim state_tamrin19 As Int=myFunc.get_state_tamrin19
				If(state_tamrin19>2)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin19 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			
			Case 22
				Dim state_tamrin22 As Int=myFunc.get_State_tamrinat_saved(Main.current_roz_tamrin,22)
				If(state_tamrin22=9)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin22 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
				
				
			
				
			Case 25
				Dim state_tamrin25 As Int=myFunc.get_State_tamrinat_saved(Main.current_roz_tamrin,25)
				If(state_tamrin25=3)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin25 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			
			Case 27
				
				Dim state_tamrin27 As Int=myFunc.get_state_tamrin27
				If(state_tamrin27>10)Then
					lbl_icon_roz.TextColor=0xFF0FA900
				Else If(state_tamrin27 = 0 )Then
					lbl_icon_roz.TextColor=0xFFFF211F
				Else
					lbl_icon_roz.TextColor=0xFFFF9900
				End If
			
				
				
		End Select


		
	
		
	Next
	
	
	
	
End Sub


Private Sub pan_roz_Click
	Dim this_tamrin As Panel=Sender
	
	'Main.current_tamrin=this_tamrin.Tag
	
	Select this_tamrin.Tag
		Case 1
			StartActivity(do_tamrin_roz_layout)
		Case 2,4,5,6,7,9,10,11,12,15,17,18,20,21,24,26,28,29
			Main.current_tamrin=this_tamrin.Tag
			pan_all_tamrin2.Visible=True
			'et_tamrin2.Text= "اتفاقات امروز رو مرور کن و به خاط بهترین اتفاق شکرگزاری کن."
			et_tamrin2.Text= myFunc.get_tamrinName(this_tamrin.Tag).Get(1)
		
			Dim state_tamrin2 As Int = myFunc.get_state(Main.current_roz_tamrin,this_tamrin.Tag)
			If(state_tamrin2=0)Then
				lbl_save_tamrin2.Color=Colors.Gray
				'lbl_save_tamrin2.Enabled=True
				lbl_save_tamrin2.Tag=1
			Else
				lbl_save_tamrin2.Color=Colors.Green
				'lbl_save_tamrin2.Enabled=False
				lbl_save_tamrin2.Tag=0
			End If
			
			
			
		Case 3
			Main.current_tamrin=3
			StartActivity(tamrin3_activity)
		Case 8 
			Main.current_tamrin=8
			StartActivity(tamrin8_activity)
		Case 13
			Main.current_tamrin=13
			StartActivity(tamrin13_activity)
		Case 14
			Main.current_tamrin=14
			StartActivity(tamrin14_activity)
		Case 16
			Main.current_tamrin=16
			StartActivity(tamrin16_activity)
		Case 19
			Main.current_tamrin=19
			StartActivity(tamrin19_activity)
		Case 22
			Main.current_tamrin=22
			StartActivity(tamrin22_activity)
			
		Case 25
			Main.current_tamrin=25
			StartActivity(tamrin25_activity)
		Case 27
			Main.current_tamrin=27
			StartActivity(tamrin27_activity)
		
		
			
	End Select
	
	
	
End Sub






Private Sub lbl_save_tamrin2_Click
	If(lbl_save_tamrin2.Tag.As(Int)=1)Then
		Select Main.current_tamrin
			Case 2,4,5,6,7,9,10,11,12,15,17,18,20,21,24,26,28,29
				myFunc.setState(Main.current_roz_tamrin,Main.current_tamrin)
				pan_all_tamrin2_Click
				fill_list
			
			Case Else
				pan_all_tamrin2_Click
		End Select	
	Else
		pan_all_tamrin2_Click
	End If
	
	
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_tamrin2.Visible=True)Then
			pan_all_tamrin2.Visible=False
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub WebView1_OverrideUrl (Url As String) As Boolean
	
	If Url.EndsWith(".pdf") Then
		
		Private i As Intent
		i.Initialize(i.ACTION_VIEW,Url)
		StartActivity(i)
	End If
	
	
	
End Sub