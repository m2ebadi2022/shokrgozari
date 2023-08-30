B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen:   True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private cusListV_data As CustomListView
	Private xui As XUI
	Dim p As B4XView



	Private lbl_roz As Label
	
	
	Private lbl_delet As Label
	Private lbl_import As Label
	Private pan_all As Panel
	Private et_new_item As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("tamrin19_layout")
	
	fill_list
	

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub fill_list
	
	cusListV_data.Clear

	
	myFunc.connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin19;")
	
	
	Do While Main.res.NextRow
		
		
		
		p = xui.CreatePanel("p")	
		p.SetLayoutAnimated(0, 0, 0, 100%x, 85dip)
		p.LoadLayout("item_list_tamrin19")
		cusListV_data.Add(p,Main.res.Position)
		
	lbl_roz.Text=Main.res.GetString("matn")
		lbl_delet.Tag=Main.res.Getint("id")
		lbl_import.Tag=Main.res.Getint("id")
		
		
		If(Main.res.Getint("state").As(Int)=0)Then
			
			lbl_import.TextColor=Colors.Gray
			
		Else
			lbl_import.TextColor=Colors.Green
				
		End If
		
		
		
		
	Loop
	
	
	Main.sql.Close
	Main.res.Close
	
	
	
	
End Sub


Private Sub lbl_delet_Click
	Dim this_lbl As Label=Sender
	
	
	myFunc.connection_sql
	Main.sql.ExecNonQuery("DELETE FROM tamrin19 WHERE id="&this_lbl.Tag&";")
	Main.sql.Close
	ToastMessageShow("حذف شد",False)
		
	
	fill_list
	
	
	
End Sub






Private Sub lbl_import_Click
	
	Dim this_lbl As Label=Sender
	

	If(get_state_tamrin19_item(this_lbl.Tag)=0)Then
		this_lbl.TextColor=Colors.Green
		update_stateById(this_lbl.Tag,1)
		
	Else
		this_lbl.TextColor=Colors.Gray
		update_stateById(this_lbl.Tag,0)
		
	End If

	

	
	
End Sub
Sub update_stateById(id As Int,state As Int)
	myFunc.connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin19 SET state=? WHERE id=? ;", Array As Object(state, id))
	Main.sql.Close
	
End Sub

Sub get_state_tamrin19_item (id As Int) As Int
	
	Dim result As Int=0
	
	myFunc.connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin19 WHERE id="&id&";")
	Main.res.Position=0
	
	
	result=Main.res.Getint("state")
	
	
	Main.sql.Close
	Main.res.Close
	
	Return result
	
End Sub



Private Sub pan_all_Click
	pan_all.Visible=False
End Sub

Private Sub lbl_save_new_Click
	
	
	If(et_new_item.Text<>"" And et_new_item.Text<>Null)Then
		myFunc.connection_sql
		Main.sql.ExecNonQuery("INSERT INTO tamrin19 ('matn') VALUES ('"&et_new_item.Text&"');")
		Main.sql.Close
		ToastMessageShow("اضافه شد",False)
		
		pan_all_Click
		fill_list
	Else
		
		MsgboxAsync("متن خالی است!", "توجه")
		
	End If
	
	
	
	
End Sub

Private Sub lbl_add_Click
	pan_all.Visible=True
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all.Visible=True)Then
			pan_all.Visible=False
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_back_Click
	Activity.Finish
End Sub


