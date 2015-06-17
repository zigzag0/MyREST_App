package ttu.idu0080.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ttu.idu0080.rest.data.Book;
@Service
public class RESTDataService  {





	public List<Book> getAllBooks()  {

		Book[] book_array = null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
		book_array = restTemplate.getForObject("http://localhost:8080/REST_service/service/books", Book[].class) ;
		System.out.println("Raamatud REST-teenusest:" + book_array.length);
		}
		catch(Exception ex)
		{
			System.out.println("RESTDataService.getAllBooks():"+ ex.getMessage());
		}

		List<Book> book_list= Arrays.asList(book_array);
		return book_list;
	}




}
