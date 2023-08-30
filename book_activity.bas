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
	Dim tim_scroll2 As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private xui As XUI
	Dim p As B4XView


	Private CustomListView1 As CustomListView
	Private lbl_roz As Label
	Private lbl_icon_roz As Label
	Private pan_roz As Panel
	
	Private pan_pic As Panel
	Private lbl_icon_fav As Label
	
	Dim pos_scroll As Int=0
	Dim isfitest As Boolean=True
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	
	
	
	
	Activity.LoadLayout("book_layout")
	
	tim_scroll2.Initialize("tim_scroll2",300)

	

End Sub

Sub Activity_Resume
	fill_list
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


Private Sub pan_roz_Click
	Dim this_roz As Panel=Sender
	
	Main.current_book_content_id=this_roz.Tag
	isfitest=False
	StartActivity(reagBook_activity)
	
	
End Sub



Sub fill_list
	
	CustomListView1.Clear

	Dim list_fehrest As List
	list_fehrest.Initialize
	list_fehrest=myFunc.get_fehrest
	
	Dim strFunc As StringFunctions
	strFunc.Initialize
	

	For i=0 To list_fehrest.Size-1
		
		p = xui.CreatePanel("p")
		
		p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)
		p.LoadLayout("item_list_rozha_tamrin")
		
		
		CustomListView1.Add(p,i)
		
		
		Dim list_row As List
		list_row.Initialize
		list_row=strFunc.Split(list_fehrest.Get(i) , "@")
		
		
		
		lbl_roz.Text=list_row.Get(1)
		
		pan_roz.Tag=list_row.Get(0)
		
		

		pan_pic.Visible=True
		
		pan_pic.SetBackgroundImage(LoadBitmap(File.DirAssets,list_row.Get(3)))
		
		
		lbl_icon_fav.Visible=True
		lbl_icon_fav.Tag=list_row.Get(0)
		If(list_row.Get(2).As(Int)=1)Then
			lbl_icon_fav.Text=Chr(0xF004)
			lbl_icon_fav.TextColor=0xFFFF3838
		Else
			lbl_icon_fav.Text=Chr(0xF08A)
			lbl_icon_fav.TextColor=0xFF686868
				
		End If
		
		
		
		If(File.Exists(File.DirInternal,"temp_read.txt"))Then
				Dim temp_red As Int=File.ReadString(File.DirInternal,"temp_read.txt")
				Dim id_temp_read As Int=pan_roz.Tag
				
				If((id_temp_read)=temp_red)Then
				lbl_icon_roz.Typeface=Typeface.MATERIALICONS
				lbl_icon_roz.TextColor=0xFF0FA900
				lbl_icon_roz.Text=Chr(0xE866)
				
				lbl_icon_roz.Visible=True
				pos_scroll=i
				Else
				lbl_icon_roz.Visible=False
				End If	
				
		End If
		
	Next
	
	
	If (isfitest=True)Then
		tim_scroll2.Enabled=True
	End If
	
	
	
	
End Sub

Private Sub lbl_icon_fav_Click
	Dim this_roz_fav As Label=Sender
	
	
	
	Dim fav_state As Int = myFunc.get_fav_byId(this_roz_fav.Tag)
	
	
	If(fav_state=1)Then
		
		myFunc.set_fav_book(this_roz_fav.Tag,0)
		this_roz_fav.Text=Chr(0xF08A)
		this_roz_fav.TextColor=0xFF686868
	Else
		myFunc.set_fav_book(this_roz_fav.Tag,1)
		this_roz_fav.Text=Chr(0xF004)
		this_roz_fav.TextColor=0xFFFF3838	
		
	End If
	
	
	
	
	
End Sub


Sub tim_scroll2_Tick
	CustomListView1.ScrollToItem(pos_scroll)
	tim_scroll2.Enabled=False
End Sub