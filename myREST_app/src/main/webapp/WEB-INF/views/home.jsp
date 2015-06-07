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
	<h2>
		<a href=${uri}>Raamatud.</a>
	</h2>
	<form>
		<input type=button value="Kõikide raamatute nimekiri."
			onClick="javascript:get_books()"> <br> <br> <br>
		<table bgcolor=000000>
			<tr>
				<td bgcolor=cccccc>Tesde:</td>
				<td bgcolor=ffffff><div id="msg_text"></div></td>
			</tr>
			<br>
			<tr>
				<br>
				<input type="text" name="search">
				<input type=button value="Raamatu otsing"
					onClick="javascript:search()">
				<br>
			</tr>
			<br>
		</table>
		<br> <br> <br>
		<! -- samm 4 Uue raamatu lisamise võimalus. -->
		<table bgcolor=eeeeee>
			<tr>
				<td>Uue raamatu lisamine</td>
			</tr>
			<tr>
				<td>Nimetus:</td>
				<td><input type=text name=new_book_name value=''></td>
			</tr>
			<tr>
				<td>Autor:</td>
				<td><input type=text name=new_book_author value=''></td>
			</tr>
			<tr>
				<td>Lehekülgi:</td>
				<td><input type=text name=new_book_pages value=''></td>
			</tr>
			<tr>
				<td>Väljatrük:</td>
				<td><input type=text name=new_book_published value=''></td>
			</tr>
			<tr>
				<td><button type='button' class='btn'
						onClick='javascript:add_book()'>Salvesta uue raamatu.</button></td>
			</tr>
		</table>
		<br> <br> <br>
		<div id="one_book"></div>
		<br> <br>
		<div id="books_table"></div>
		<br> <br>






	</form>

</body>
</html>
