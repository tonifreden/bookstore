package bookstore.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByYear(Integer year);

    List<Book> findByIsbn(String isbn);

    List<Book> findByCategory(Category category);
}
