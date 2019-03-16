package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository brepository;
	
	@Test
	public void findByAuthorShouldReturnAuthor() {
        List<Book> books = brepository.findByAuthor("Ehsan Haidari");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Ehsan Haidari");
    }
	
	@Test
	public void createNewBook() {
    	Book book = new Book("Matti Mallikas", "Mallikkaan kirja", "1959", "1112223344-7", new Category("Trilleri"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
}
