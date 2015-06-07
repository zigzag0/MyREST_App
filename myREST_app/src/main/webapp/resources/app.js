var book_from_server;

function Book() {
	this.name;
	this.author;
	this.pages;
	this.published;
}

function get_books() {

	$.ajaxSetup({
		cache : false
	});
	$.ajax({

		url : 'service/books',
		type : "GET",
		dataType : 'json',
		success : function(data) {
			display_books(data);
			console.log(JSON.stringify(data));

		}
	});

}

function get_book(id) {

	$.ajaxSetup({
		cache : false
	});
	$.ajax({

		url : 'service/book/' + id,
		type : "GET",
		dataType : 'json',
		success : function(data) {
			book_from_server = data;
			display_book(data);
			console.log(JSON.stringify(data));

		}
	});

}

function save_car() {

	book_from_server.name = document.forms[0].name.value;
	book_from_server.author = document.forms[0].author.value;
	book_from_server.pages = document.forms[0].pages.value;
	book_from_server.published = document.forms[0].published.value;

	var jsonData = JSON.stringify(book_from_server);
	$.ajaxSetup({
		cache : false
	});
	$.ajax({

		url : 'service/book/' + book_from_server.id,
		type : "POST",
		data : jsonData,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			show_message("Salvestatud");
			console.log(JSON.stringify(data));

		}
	});

}

function display_book(book) {
	var out_data = "";
	out_data = out_data
			+ "<table bgcolor=eeeeee><tr><td>Muutmine. Auto id: <b>" + book.id
			+ "</b></td></tr>";

	out_data = out_data
			+ "<tr><td>Mark:</td><td><input type=text name=name value='"
			+ book.name + "'></td></tr>";
	out_data = out_data
			+ "<tr><td>Mudel:</td><td><input type=text name=author value='"
			+ book.author + "'></td></tr>";
	out_data = out_data
			+ "<tr><td>Seeria:</td><td><input type=text name=pages value='"
			+ book.pages + "'></td></tr>";
	out_data = out_data
			+ "<tr><td>Aasta:</td><td><input type=text name=published value='"
			+ book.published + "'></td></tr>";
	out_data = out_data
			+ "<td><button type='button' class='btn'  onClick='javascript:save_car()'>Salvesta</button></td>";

	out_data = out_data + "</table>";

	$("#one_book").html(out_data);
}

function display_books(data) {
	var out_data = "";
	out_data = out_data
			+ "<table bgcolor=eeeeee><tr><td colspan=4>Autosid kokku: <b>"
			+ data.length + "</b></td></tr>";
	for ( var i in data) {
		var book = data[i];
		out_data = out_data + "<tr><td>mark:</td><td bgcolor=ffffff>"
				+ book.name + "</td><td>mudel:</td><td bgcolor=ffffff>"
				+ book.author + "</td>";
		out_data = out_data
				+ "<td><button type='button' class='btn'  onClick='javascript:get_book("
				+ book.id + ")'>Vali</button></td>";
		out_data = out_data
				+ "<td><button type='button' class='btn' onClick='javascript:delete_book("
				+ book.id + ")'>Kustuta</button></td></tr>";

	}
	out_data = out_data + "</table>";

	$("#books_table").html(out_data);
}

// samm 2. Lisan delete_book funktsiooni
function delete_book(id) {
	$.ajaxSetup({
		cache : false
	});
	$.ajax({
		url : 'service/book/' + id,
		type : "DELETE",
		contentType : 'application/json',
		success : function(data) {
			show_message("Kustutatud");
			// uuendame autode nimekirja vormil , yks auto on nyyd kustutatud
			get_books();
			console.log(JSON.stringify(data));
		}
	});
}

// samm 5 Uue auto lisamise võimalus.

function add_book() {
	var book_to_server = new Book();
	book_to_server.name = document.forms[0].new_book_name.value;
	book_to_server.author = document.forms[0].new_book_author.value;
	book_to_server.pages = document.forms[0].new_car_pages.value;
	book_to_server.published = document.forms[0].new_car_published.value;
	var jsonData = JSON.stringify(book_to_server);
	$.ajaxSetup({
		cache : false
	});
	$.ajax({
		url : 'service/book/',
		type : "PUT",
		data : jsonData,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			show_message("Sisestatud");
			console.log(JSON.stringify(data));
			// uuendame autode nimekirja vormil , yks auto on nyyd lisatud
			get_books();
		}
	});
}



function searchBooks(){
	display_books(document.forms[0].search.value);
}



function show_message(message) {

	$("#msg_text").html(message);
}
