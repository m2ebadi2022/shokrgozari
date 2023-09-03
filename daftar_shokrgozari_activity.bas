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
	
	
	
	Private lbl_tamrin_roz As Label
	Private lbl_add_new As Label
	
	Dim list_reload As Int=0
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("do_tamrin_roz_layout")
	lbl_add_new.Visible=True



End Sub

Sub Activity_Resume
	fill_list
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub fill_list
	list_reload=1
	CustomLV_tamrin.Clear

	Dim strFunc As StringFunctions
	strFunc.Initialize


	Dim ls_tamrin1_Roz As List
	ls_tamrin1_Roz.Initialize
	ls_tamrin1_Roz=myFunc.get_daftar_shokrgozari_byShenase(Main.daftar_shenase)
	
	lbl_tamrin_roz.Text=myFunc.get_daftar_shenase_titel(Main.daftar_shenase)

	For i=0 To ls_tamrin1_Roz.Size-1
		
		p = xui.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 100%x, 146dip)
		p.LoadLayout("item_list_tamrin1")
		
		et_mohebat.Color=Colors.White
		et_ealt.Color=Colors.White
		
		CustomLV_tamrin.Add(p,i)
		
		
		Dim list_num As List
		list_num.Initialize
		list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , "@")
		
		
		lbl_num.Tag=list_num.Get(0)
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

	
	
	list_reload=0
End Sub


Private Sub lbl_back_Click
	
	Activity.Finish
End Sub



Private Sub et_ealt_TextChanged (Old As String, New As String)
	If(list_reload=0)Then
		Dim this_num_tamrin As EditText=Sender
	If(et_ealt.Text<>"" Or et_ealt.Text<>Null)Then
		myFunc.update_daftar_shokrgozari_elat(this_num_tamrin.Tag,this_num_tamrin.Text,1)
	End If
		
	End If
	
	
	
	
	
End Sub

Private Sub et_mohebat_TextChanged (Old As String, New As String)
	If(list_reload=0)Then
		Dim this_num_tamrin As EditText=Sender
		If(et_ealt.Text<>"" Or et_ealt.Text<>Null)Then
			myFunc.update_daftar_shokrgozari_mohebat(this_num_tamrin.Tag,this_num_tamrin.Text,1)
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


Private Sub lbl_add_new_Click
	
	myFunc.connection_sql
	Main.sql.ExecNonQuery2("INSERT INTO daftar_shokrgozari ('shenase') VALUES (?)", Array As Object(Main.daftar_shenase))
	Main.sql.Close
	ToastMessageShow("اضافه شد",False)

fill_list
	
End Sub

Private Sub lbl_num_LongClick
	
	Dim this_item As Label=Sender
	
	
	Msgbox2Async("مطمئن هستید که این مورد حذف شود؟", "حذف", "بله", "", "خیر", Null, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		myFunc.delet_daftar_shokrgozariById(this_item.Tag)
		fill_list
	End If
	
	
End Sub