package ttu.idu0080.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ttu.idu0080.rest.data.Book;
import ttu.idu0080.rest.service.DataService;
import ttu.idu0080.rest.service.RESTDataService;

@Controller
public class RESTController {

	@Autowired
	private DataService dataService;
	@Autowired
	private RESTDataService restDataService;

	@RequestMapping(value = "/service/books", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getBooks(HttpServletResponse response)
			throws IOException {

		List<Book> books = dataService.getAllBooks();
		return books;
	}

	@RequestMapping(value = "/service/book/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Book getBook(@PathVariable int id) throws IOException {

		Book book = dataService.getBookById(id);
		return book;
	}

	@Transactional
	@RequestMapping(value = "/service/book/{id}", method = RequestMethod.POST)
	public @ResponseBody void updateBook(@RequestBody Book book) {
		dataService.update(book);

	}

	@RequestMapping(value = "/service/external/books", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getExternalBooks(HttpServletResponse response)
			throws IOException {
		List<Book> books = restDataService.getAllBooks();
		return books;
	}

	// samm 3, lisame DELETE
	@Transactional
	@RequestMapping(value = "/service/book/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteBook(@PathVariable int id) {
		dataService.delete(id);
	}

	// samm 6 lisame Auto lisamise v�imalust
	@Transactional
	@RequestMapping(value = "/service/book/", method = RequestMethod.PUT)
	public @ResponseBody void insertBook(@RequestBody Book book) {
		dataService.save(book);
	}

	//samm 7
	@RequestMapping(value="/service/search",method = RequestMethod. GET, produces = "application/json" )
	public @ResponseBody List<Book> searchBooks( @RequestParam(value = "author" )
	String author) throws IOException{
	List<Book> books= dataService.searchByAuthor( author);
	return books;
	}

}
