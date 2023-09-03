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

Dim index_daftar As Int=0
Dim for_edit As Boolean=False
Dim this_shenase As String=""



	Private lbl_shokrgozari As Label
	Private lbl_ravabet As Label
	Private lbl_khasteha As Label
	
	Private pan_all_add As Panel
	Private et_date_add As EditText
	Private et_title_add As EditText
	Private lbl_title_add As Label

	Private lbl_title_items As Label
	Private lbl_date_items As Label
	Private pan_item As Panel
	
	Private cusListV_data As CustomListView
	Private xui As XUI
	Dim p As B4XView
	
	
	Private lbl_icon_edit As Label
	Private lbl_icon_delete As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("daftar_layout")
	rest_color
	lbl_shokrgozari_Click
	fill_list

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
		
		If(pan_all_add.Visible=True)Then
			pan_all_add.Visible=False
		Else
				lbl_back_Click
		End If
		
		
	
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_khasteha_Click
	index_daftar=2
	rest_color
	lbl_khasteha.Color=Colors.Green
	fill_list
	'fill shokrgozari
	
End Sub

Private Sub lbl_ravabet_Click
	index_daftar=1
	rest_color
	lbl_ravabet.Color=Colors.Green
	fill_list
	'fill shokrgozari
	
End Sub

Private Sub lbl_shokrgozari_Click
	index_daftar=0
	rest_color
	lbl_shokrgozari.Color=Colors.Green
	fill_list
	'fill shokrgozari
End Sub

Sub rest_color
	lbl_shokrgozari.Color=Colors.Gray
	lbl_ravabet.Color=Colors.Gray
	lbl_khasteha.Color=Colors.Gray
	
End Sub

Private Sub lbl_add_Click
	for_edit=False
	et_title_add.Text=""
	et_date_add.Text=""
	
	pan_all_add.Visible=True
End Sub

Private Sub pan_all_add_Click
	pan_all_add.Visible=False
End Sub

Private Sub lbl_save_add_Click
	If(et_title_add.Text="" Or et_date_add.Text="")Then
		ToastMessageShow("آیتم خالی",False)
		
	Else
		
		If(for_edit=True)Then
		
			myFunc.update_daftar_shenase(this_shenase,et_title_add.Text,et_date_add.Text)
		
	
		Else
		
			Dim random_shenase As String=myFunc.GetRandomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",9)
			Dim model_1 As Int =0
			Select index_daftar
				Case 0
					model_1=0
				Case 1
					model_1=1
				Case 2
					model_1=2
			End Select
	
	
			myFunc.connection_sql
			Main.sql.ExecNonQuery2("INSERT INTO daftar_shenase ('model' , 'shenase' , 'title','date') VALUES (?,?,?,?)", Array As Object(model_1,random_shenase, et_title_add.Text,et_date_add.Text))
			Main.sql.Close
			ToastMessageShow("اضافه شد",False)
	
		
		
			
		End If
	
	

		fill_list
		pan_all_add.Visible=False
	
			
	End If
	
End Sub


Private Sub lbl_icon_delete_Click
	
	Dim this_item As Label=Sender
	this_shenase=this_item.Tag
	
	Msgbox2Async("مطمئن هستید که حذف شود؟", "حذف", "بله", "", "خیر", Null, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		myFunc.delet_daftar_shenase(this_shenase,index_daftar)
		fill_list
	End If
	
	
	
	
End Sub


Private Sub pan_item_Click
	Dim this_item As Panel=Sender
	
	
	'Main.daftar_model=index_daftar
	Main.daftar_shenase=this_item.Tag
	
	Select index_daftar
		Case 0
			StartActivity(daftar_shokrgozari_activity)
		Case 1
			StartActivity(daftar_ravabet_activity)
		Case 2
			StartActivity(daftar_khasteha_activity)
		
		
	End Select
	
	
	'go to activity
End Sub


Sub fill_list
	Dim sql_ster As String=""
	Select index_daftar
		
		Case 0
			sql_ster="SELECT * FROM daftar_shenase WHERE model=0;"
		Case 1
			sql_ster="SELECT * FROM daftar_shenase WHERE model=1;"
		Case 2
			sql_ster="SELECT * FROM daftar_shenase WHERE model=2;"
		
	End Select
	
	cusListV_data.Clear



	myFunc.connection_sql
	Main.res=Main.sql.ExecQuery(sql_ster)
	
	
	Do While Main.res.NextRow
		
	
		p = xui.CreatePanel("p")
		
		p.SetLayoutAnimated(0, 0, 0, 100%x, 85dip)
		p.LoadLayout("item_list_daftar")
		
		
		cusListV_data.Add(p,Main.res.Position)
		
		lbl_title_items.Text=Main.res.GetString("title")
		lbl_date_items.Text=Main.res.GetString("date")
		
		
		lbl_icon_delete.Tag=Main.res.GetString("shenase")
		lbl_icon_edit.Tag=Main.res.GetString("shenase")
		pan_item.Tag=Main.res.GetString("shenase")
		
		
	Loop
	
	
	Main.sql.Close
	Main.res.Close
	



	
	
	
End Sub

Private Sub lbl_icon_edit_Click
	pan_all_add.Visible=True
	lbl_title_add.Text="ویرایش"
	for_edit=True
	
	Dim ls_this As List
	ls_this.Initialize
	Dim this_item As Label=Sender
	this_shenase=this_item.Tag
	
	
	ls_this=myFunc.get_name_date_daftar(this_item.Tag)
	
	
	et_title_add.Text=ls_this.Get(0)
	et_date_add.Text=ls_this.Get(1)
	
	
	
	
	
End Sub

Private Sub Panel3_Click
	
End Sub