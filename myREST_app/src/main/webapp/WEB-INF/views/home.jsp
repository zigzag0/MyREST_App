<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="resources/app.js"></script>
</head>
<body>
	<h1>REST World!</h1>
	<a href=${uri}>Autoleht</a>
	<form>
		<input type=button value="Koik autod" onClick="javascript:get_books()">


		<br> <br>
		<table bgcolor=000000>
			<tr>
				<td bgcolor=cccccc>Teated</td>
			</tr>
			<tr>
				<td bgcolor=ffffff><div id="msg_text"></div></td>
			</tr>
		</table>
		<br>
		<div id="one_book"></div>
		<br> <br>
		<div id="books_table"></div>
		<br>
		<br>




		<! -- samm 4 Uue auto lisamise võimalus. -->
		<table bgcolor=eeeeee>
			<tr>
				<td>Uue auto lisamine</td>
			</tr>
			<tr>
				<td>Mark:</td>
				<td><input type=text name=new_book_name value=''></td>
			</tr>
			<tr>
				<td>Mudel:</td>
				<td><input type=text name=new_book_author value=''></td>
			</tr>
			<tr>
				<td>Seeria:</td>
				<td><input type=text name=new_car_pages value=''></td>
			</tr>
			<tr>
				<td>Aasta:</td>
				<td><input type=text name=new_car_published value=''></td>
			</tr>
			<tr>
				<td><button type='button' class='btn' onClick='javascript:add_book()'>Saada uus serverile</button></td>
			</tr>
		</table>
<br>
<br>
<input type="text" name="search">
				<input type=button value="Otsing"
			onClick="javascript:search()">
			<br>

		<br>
		<br>



	</form>

</body>
</html>
