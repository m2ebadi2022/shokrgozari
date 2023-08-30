B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=12.5
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
End Sub


Sub connection_sql
	If(File.Exists(File.DirInternal,"db.db")=False)Then
		File.Copy(File.DirAssets,"db.db",File.DirInternal,"db.db")
	End If
	If (Main.sql.IsInitialized=False)Then
		Main.sql.Initialize(File.DirInternal,"db.db",True)
	End If
	
	
End Sub

Sub get_rozha As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM rozha;")
	
	Dim list_result As List
	list_result.Initialize
	
	Do While Main.res.NextRow
		
		list_result.Add(Main.res.GetString("name")&"@"&Main.res.GetString("state"))
		
		
	Loop
	
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub


Sub get_fehrest As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM book1;")
	
	Dim list_result As List
	list_result.Initialize
	
	Do While Main.res.NextRow
'		Dim ls_r As List
'		ls_r.Initialize
'		ls_r.Add(Main.res.Getint("id"))
'		ls_r.Add(Main.res.GetString("title"))
'		ls_r.Add(Main.res.Getint("state"))
		
		
		list_result.Add(Main.res.Getint("id")&"@"&Main.res.GetString("title_down")&"@"&Main.res.Getint("state")&"@"&Main.res.GetString("pic"))
		
		
	Loop
	
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub


Sub get_download_list As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM book1;")
	
	Dim list_result As List
	list_result.Initialize
	
	Do While Main.res.NextRow
'		Dim ls_r As List
'		ls_r.Initialize
'		ls_r.Add(Main.res.Getint("id"))
'		ls_r.Add(Main.res.GetString("title"))
'		ls_r.Add(Main.res.Getint("state"))
		
		
		list_result.Add(Main.res.Getint("id")&"@"&Main.res.GetString("title_down")&"@"&Main.res.GetString("detile_down")&"@"&Main.res.GetString("sound"))
		
		
	Loop
	
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub


Sub get_removeAll_list As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM book1;")
	
	Dim list_result As List
	list_result.Initialize
	
	Do While Main.res.NextRow
		list_result.Add(Main.res.GetString("sound"))	
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub


Sub removeAll_tamrinat
	
	connection_sql
	
	Main.sql.ExecNonQuery("UPDATE tamrin1 SET mohebat="""" , elat="""" , state=0 ;")
	Main.sql.Close
	
End Sub

Sub set_fav_book(idRow As Int,fav_state As Int)
	
	connection_sql
	
	Main.sql.ExecNonQuery("UPDATE book1 SET state="&fav_state&" WHERE id="&idRow&" ;")
	Main.sql.Close
	
End Sub

Sub get_state(roz1 As Int , tamrin1 As Int) As Int
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM states  WHERE roz="&roz1&" AND tamrin="&tamrin1&" ;")
	
	Dim result_state As Int =0
	If(Main.res.RowCount>0)Then
		Main.res.Position=0
		result_state=Main.res.GetInt("state")
	End If
	
	
	Main.sql.Close
	Main.res.Close
	
	Return  result_state
	
	
End Sub




Sub setState(roz1 As Int , tamrin1 As Int)

	connection_sql
Main.sql.ExecNonQuery2("INSERT INTO states (roz, tamrin , state) VALUES (?, ?, ?)", Array As Object(roz1,tamrin1, 1))
	Main.sql.Close
	
	
	
	
End Sub



Sub get_fav_byId(id As Int) As Int
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM book1 WHERE id="&id&" ;")
	Main.res.Position=0
	Dim fav_s As Int =Main.res.Getint("state")
	
	Main.sql.Close
	Main.res.Close
	
	Return  fav_s
End Sub


Sub get_tamrinName(numTamrin As Int) As List
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrinat_name WHERE num_tamrin="&numTamrin&" ;")
	Main.res.Position=0
	Dim ls_result As List
	ls_result.Initialize
	ls_result.Add(Main.res.GetString("title"))
	ls_result.Add(Main.res.GetString("help"))
	
	
	
	Main.sql.Close
	Main.res.Close
	
	Return  ls_result
End Sub


Sub get_book_byId (id As Int) As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM book1 WHERE id="&id&" ;")
	Main.res.Position=0
	
	Dim list_result As List
	list_result.Initialize
	

	list_result.AddAll(Array As String(Main.res.GetString("title"),Main.res.GetString("content"),Main.res.GetString("pic"),Main.res.GetString("sound"),Main.res.Getint("state"),Main.res.GetString("title_down")))
	
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub
'
'Sub update_bookState_byId(id As Int) As Boolean
'	
'	connection_sql
'	Main.sql.ExecNonQuery2("UPDATE book1 SET state=? WHERE id=?;", Array As Object( 1,id))
'	Main.sql.Close
'	
'	Return True
'End Sub


Sub get_roz_byId (id As Int) As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin_roz WHERE id="&id&" ;")
	Main.res.Position=0
	
	Dim list_result As List
	list_result.Initialize
	

	list_result.AddAll(Array As String(Main.res.GetString("title"),Main.res.GetString("content"),Main.res.GetString("tamrinat"),Main.res.GetString("state")))
	
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub


Sub get_tamrin1_byRoz (roz As Int) As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin1 WHERE roz="&roz&" ;")
	
	
	Dim list_result As List
	list_result.Initialize
	
	Do While Main.res.NextRow
		
		list_result.Add(Main.res.Getint("id")&"@"&Main.res.Getint("num")&"@"&Main.res.GetString("mohebat")&"@"&Main.res.GetString("elat")&"@"&Main.res.Getint("state"))
		
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub



Sub update_tamrin1_mohebat(id As Int,mohebat As String,state As Int) As Boolean
	
	connection_sql
	
	If(mohebat="")Then
		state=0
	End If
	
	Main.sql.ExecNonQuery2("UPDATE tamrin1 SET mohebat=? , state=? WHERE id=?;", Array As Object(mohebat, state,id))
	Main.sql.Close
	
	Return True
End Sub


Sub update_tamrin1_elat(id As Int,elat As String,state As Int) As Boolean
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin1 SET elat=?, state=? WHERE id=?;", Array As Object(elat, state,id))
	Main.sql.Close
	
	Return True
End Sub



Sub get_State_tamrin1_byRoz (roz As Int) As Int
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin1 WHERE roz="&roz&" ;")
	

	Dim res_cod As Int=0
	
	Do While Main.res.NextRow
		res_cod=res_cod+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_cod
	
End Sub



Sub get_all_tamrin1
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin1 ")
	
	Do While Main.res.NextRow
		Log(Main.res.Getint("id")&"	"&Main.res.Getint("roz")&"	"&Main.res.Getint("num")&"	"&Main.res.GetString("mohebat")&"	"&Main.res.GetString("elat")&"	"&Main.res.Getint("state"))
		
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	
End Sub

Sub get_all_tamrin8 As List
	Dim ls_content As List
	ls_content.Initialize
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin8 ")
	
	Do While Main.res.NextRow
		ls_content.Add(Main.res.GetString("matn"))
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return ls_content
	
End Sub

 Sub update_tamrin8 (id As Int,matn As String) As Boolean
 	Dim state1 As Int=1
	If(matn="")Then
		state1=0
	End If
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin8 SET matn=?, state=? WHERE id=?;", Array As Object(matn, state1,id))
	Main.sql.Close
	
	Return True
End Sub

Sub get_state_tamrin8 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin8 ")
	
	Do While Main.res.NextRow
		res_state=res_state+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub



Sub get_all_tamrin14 As List
	Dim ls_content As List
	ls_content.Initialize
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin14 ")
	
	Do While Main.res.NextRow
		ls_content.Add(Main.res.GetString("matn"))
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return ls_content
	
End Sub

 Sub update_tamrin14 (id As Int,matn As String) As Boolean
 	Dim state1 As Int=1
	If(matn="")Then
		state1=0
	End If
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin14 SET matn=?, state=? WHERE id=?;", Array As Object(matn, state1,id))
	Main.sql.Close
	
	Return True
End Sub

Sub get_state_tamrin14 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin14 ")
	
	Do While Main.res.NextRow
		res_state=res_state+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub













Sub get_all_tamrin13_byId(id1 As Int) As List
	Dim ls_content As List
	ls_content.Initialize
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin13 WHERE id="&id1)
	Main.res.Position=0
	
	ls_content.Add(Main.res.GetString("name"))
	ls_content.Add(Main.res.GetString("matn"))

	
	Main.sql.Close
	Main.res.Close
	
	Return ls_content
	
End Sub

 Sub update_tamrin13 (id1 As Int,name1 As String,matn1 As String) As Boolean
 	Dim state1 As Int=1
	If(matn1="")Then
		state1=0
	End If
	If(name1=Null)Then
		name1=""
	End If
	If(matn1=Null)Then
		matn1=""
	End If
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin13 SET name=? , matn=?, state=? WHERE id=?;", Array As Object(name1, matn1, state1,id1))
	Main.sql.Close
	
	Return True
End Sub

Sub get_state_tamrin13 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin13 ")
	
	Do While Main.res.NextRow
		res_state=res_state+Main.res.GetString("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub




Sub get_all_tamrin16 As List
	Dim ls_content As List
	ls_content.Initialize
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin16 ")
	
	Do While Main.res.NextRow
		ls_content.Add(Main.res.GetString("matn"))
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return ls_content
	
End Sub

 Sub update_tamrin16 (id As Int,matn As String) As Boolean
 	Dim state1 As Int=1
	If(matn="")Then
		state1=0
	End If
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin16 SET matn=?, state=? WHERE id=?;", Array As Object(matn, state1,id))
	Main.sql.Close
	
	Return True
End Sub

Sub get_state_tamrin16 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin16 ")
	
	Do While Main.res.NextRow
		res_state=res_state+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub



Sub get_state_tamrin19 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin19 ")
	
	Do While Main.res.NextRow
		res_state=res_state+1
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub






Sub setRotation(v As B4XView, Time As Int, Angle As Float)


	v.SetRotationAnimated(Time,Angle)
End Sub


Sub update_tamrinat_saved( roz As Int,tamrin As Int,num As Int,matn As String,state As Int) As Boolean
	Dim state1 As Int=0
	If(matn<>"")Then
		state1=1
	End If
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrinat_saved SET matn=?, state=? WHERE roz=? AND tamrin=? AND num=?;", Array As Object(matn, state1,roz,tamrin,num))
	Main.sql.Close
	
	Return True
End Sub

Sub get_tamrinat_saved (roz As Int,tamrin As Int) As List
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="&roz&" AND tamrin="&tamrin&" ;")

	Dim list_result As List
	list_result.Initialize
	Do While Main.res.NextRow
		list_result.Add(Main.res.GetString("matn"))
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return list_result
	
End Sub

Sub get_State_tamrinat_saved (roz As Int,tamrin As Int) As Int
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrinat_saved WHERE roz="&roz&" AND tamrin="&tamrin&" ;")

	Dim state1 As Int=0
	
	Do While Main.res.NextRow
		state1=state1+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return state1
	
End Sub




Sub get_all_tamrin27 As List
	Dim ls_content As List
	ls_content.Initialize
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin27 ")
	
	Do While Main.res.NextRow
		ls_content.Add(Main.res.GetString("matn"))
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return ls_content
	
End Sub

 Sub update_tamrin27 (id As Int,matn As String) As Boolean
 	Dim state1 As Int=1
	If(matn="")Then
		state1=0
	End If
	
	connection_sql
	Main.sql.ExecNonQuery2("UPDATE tamrin27 SET matn=?, state=? WHERE id=?;", Array As Object(matn, state1,id))
	Main.sql.Close
	
	Return True
End Sub

Sub get_state_tamrin27 As Int
	Dim res_state As Int=0
	
	connection_sql
	Main.res=Main.sql.ExecQuery("SELECT * FROM tamrin27 ")
	
	Do While Main.res.NextRow
		res_state=res_state+Main.res.Getint("state")
	Loop
	
	Main.sql.Close
	Main.res.Close
	
	Return res_state
	
End Sub
