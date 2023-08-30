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

	Private xui As XUI
	Dim p As B4XView

	Private CustomListView1 As CustomListView
	Private pan_download As Panel
	Private lbl_down_del As Label
	
	Private lbl_donw_title As Label
	Private lbl_donw_detile As Label
	Dim strFunc As StringFunctions
	Dim j As HttpJob
	Dim list_download As List
	Dim current_down_name As String=""
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("download_layout")
	strFunc.Initialize
	j.Initialize("job", Me)
	
	list_download.Initialize
	
	
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



Private Sub lbl_down_del_Click
	Dim func_del_down As Label=Sender
	
	
	Dim list_row_mod As List
	list_row_mod.Initialize
	list_row_mod=strFunc.Split(func_del_down.Tag , "@")
	
	If(list_row_mod.Get(0)="down")Then
		
		Dim rp As RuntimePermissions
		rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_STORAGE)
		Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
		If Result Then
			'access here
		Else
			'no permission
		End If
		
		func_del_down.Text=Chr(0xF1CE)  'downloading
		myFunc.setRotation(func_del_down,10000,360)
		func_del_down.SetTextColorAnimated(300,Colors.Blue)
		
		
		
		
		If (current_down_name="")Then
			current_down_name=list_row_mod.Get(1)
			download_byName
		Else
			list_download.Add(list_row_mod.Get(1))
			
				
		End If
		
		
		
		
		
	Else
		delete_fileByName(list_row_mod.Get(1))
	End If
	
End Sub

	

Private Sub pan_download_Click
	Dim go_to_readingBook As Panel=Sender
	
	Main.current_book_content_id=go_to_readingBook.Tag
	
	StartActivity(reagBook_activity)
	
End Sub



Sub fill_list
	
	CustomListView1.Clear

	Dim list_fehrest As List
	list_fehrest.Initialize
	list_fehrest=myFunc.get_download_list
	
	
	For i=0 To list_fehrest.Size-1
		
		p = xui.CreatePanel("p")
		
		p.SetLayoutAnimated(0, 0, 0, 100%x, 75dip)
		p.LoadLayout("item_list_downloads")
		
		
		CustomListView1.Add(p,i)
		
		
		Dim list_row As List
		list_row.Initialize
		list_row=strFunc.Split(list_fehrest.Get(i) , "@")
		
		
		lbl_donw_title.Text=" "&list_row.Get(1)
		lbl_donw_detile.Text=" "&list_row.Get(2)
		
		pan_download.Tag=list_row.Get(0)
		
		If(File.Exists(File.DirInternal,list_row.Get(3)))Then
			lbl_down_del.Text=Chr(0xF014)  'delete icon
			lbl_down_del.textColor=0xFFFF5050
			lbl_down_del.Tag="del@"&list_row.Get(3)
		Else
			
				lbl_down_del.Text=Chr(0xF019)  'download icon
				lbl_down_del.textColor=0xFF0CA300
				lbl_down_del.Tag="down@"&list_row.Get(3)
		
		End If
				
	Next
	
End Sub


Sub download_byName
	Try
	
		
		j.Download("https://m2ebadi.whi.ir/shokrgozari/sounds/"&current_down_name)
'	
			'Wait For (job) JobDone(job As HttpJob)
			Wait For JobDone(job As HttpJob)
			If j.Success Then
		
			Dim out As OutputStream = File.OpenOutput(File.DirInternal, current_down_name, False)
				File.Copy2(job.GetInputStream, out)
				out.Close
			
			current_down_name=""
			End If
			job.Release
	
		If(list_download.Size<>0)Then
			current_down_name=list_download.Get(0)
			list_download.RemoveAt(0)
			download_byName
		Else
			fill_list	
			ToastMessageShow("فایلهای صوتی دانلود شدند.", False)
		End If
		
		
	Catch
		Log(LastException)
		ToastMessageShow("منتظر باشید ..",False)
	End Try
	
End Sub


Sub delete_fileByName(name As String)
	If(File.Exists(File.DirInternal,name))Then
		File.Delete(File.DirInternal,name)
		fill_list
		ToastMessageShow("فایل صوتی حذف شد.",False)
	End If
	
	
	
End Sub
'

