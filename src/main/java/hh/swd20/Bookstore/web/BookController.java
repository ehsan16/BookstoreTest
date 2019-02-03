package hh.swd20.Bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.Bookstore.domain.Book;



@Controller
public class BookController {
	private ArrayList <Book> booklist = new ArrayList<Book>();
	@GetMapping(value="/index")
	public String newBook(Model model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("booklist", booklist);
		return "newbook";
	}
	@PostMapping("/index")
	public String addFriend(@ModelAttribute Book book, Model model) {
		booklist.add(book);
		model.addAttribute("book", book);
		return "redirect:/index";
}
}
