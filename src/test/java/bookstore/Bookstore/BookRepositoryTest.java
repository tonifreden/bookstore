package bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;
import bookstore.Bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createNewBook() {
        Book book = new Book("Litmanen 10", "Jari Litmanen", 2015, "10101010", 10.10, new Category("Autobiography"));
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteAllBooks() {
        bookRepository.deleteAll();
        assertThat(bookRepository.count()).isZero();
    }

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("My second (attempt at a) best-seller");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getYear()).isEqualTo(2020);
    }

    @Test
    public void findByIsbnShouldReturnBook() {
        List<Book> books = bookRepository.findByIsbn("918273-14");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Still me");
    }

    @Test
    public void findByYearShouldReturnBook() {
        List<Book> books = bookRepository.findByYear(2019);
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("My first best-seller");
    }
}