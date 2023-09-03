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
	Private et_matn1 As EditText
	Private pan_upload_pic1 As Panel
	
	Dim pic_upload_index As Int=0
	Private pan_showPic As Panel
	Private pan_all_showPic As Panel
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("do_tamrin_roz_layout")
	lbl_add_new.Visible=True
	Main.Chooser.Initialize("chooser")


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
	ls_tamrin1_Roz=myFunc.get_daftar_ravabet_byShenase(Main.daftar_shenase)
	
	lbl_tamrin_roz.Text=myFunc.get_daftar_shenase_titel(Main.daftar_shenase)

	For i=0 To ls_tamrin1_Roz.Size-1
		
		p = xui.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 100%x, 146dip)
		p.LoadLayout("item_list_daftar_ravabet")
		
		et_matn1.Color=Colors.White
		
		
		CustomLV_tamrin.Add(p,i)
		
		
		Dim list_num As List
		list_num.Initialize
		list_num=strFunc.Split(ls_tamrin1_Roz.Get(i) , "@")
		
		pan_upload_pic1.Tag=list_num.Get(0)
		lbl_num.Tag=list_num.Get(0)
		lbl_num.Text=i+1
		
		If(list_num.Get(3)<>"null")Then
			et_matn1.Text=list_num.Get(3)
		End If
		
		If(list_num.Get(2)<>"null")Then
			If(File.Exists(File.DirInternal, list_num.Get(2)))Then
				pan_upload_pic1.SetBackgroundImage(LoadBitmapSample(File.DirInternal,list_num.Get(2),120dip,120dip))
			End If
			
			
			
		End If
		
		
		
		et_matn1.Tag=list_num.Get(0)
		
		
		
	Next

	
	
	list_reload=0
End Sub


Private Sub lbl_back_Click
	
	Activity.Finish
End Sub




Private Sub et_matn1_TextChanged (Old As String, New As String)
	If(list_reload=0)Then
		Dim this_num_tamrin As EditText=Sender
		If(et_matn1.Text<>"" Or et_matn1.Text<>Null)Then
			myFunc.update_daftar_ravabet(this_num_tamrin.Tag,this_num_tamrin.Text,1)
		End If
		
		
	End If
	

	
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_showPic.Visible=True)Then
			pan_all_showPic.Visible=False
		Else
			lbl_back_Click
		End If	
		Return True
	Else
		Return False
	End If
End Sub



Private Sub lbl_add_new_Click
	
	myFunc.connection_sql
	Main.sql.ExecNonQuery2("INSERT INTO daftar_ravabet ('shenase') VALUES (?)", Array As Object(Main.daftar_shenase))
	Main.sql.Close
	ToastMessageShow("اضافه شد",False)

	fill_list
	
End Sub

Private Sub lbl_num_LongClick
	
	Dim this_item As Label=Sender
	
	
	Msgbox2Async("مطمئن هستید که این مورد حذف شود؟", "حذف", "بله", "", "خیر", Null, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		myFunc.delet_daftar_ravabetById(this_item.Tag)
		fill_list
	End If
	
	
End Sub

Private Sub pan_upload_pic1_Click
	Dim this_item As Panel=Sender
	
	pic_upload_index=this_item.Tag
	
	If(File.Exists(File.DirInternal,"pic_"&pic_upload_index&".jpg"))Then
		pan_all_showPic.Visible=True
		pan_showPic.SetBackgroundImage(LoadBitmapSample(File.DirInternal,"pic_"&pic_upload_index&".jpg",120dip,120dip))
	Else
		Main.Chooser.Show("image/*", "Select an image")
	End If
	
	
End Sub

Sub chooser_Result (Success As Boolean, Dir As String, FileName As String)
	If Success Then
		
		myFunc.update_daftar_ravabet_pic(pic_upload_index,"pic_"&pic_upload_index&".jpg")
		
		
		File.Copy(Dir,FileName,File.DirInternal,"pic_"&pic_upload_index&".jpg")
			
		fill_list
	Else
		ToastMessageShow("No image selected", True)
	End If
End Sub



Private Sub pan_showPic_Click
	Main.Chooser.Show("image/*", "Select an image")
End Sub

Private Sub pan_all_showPic_Click
	pan_all_showPic.Visible=False
End Sub