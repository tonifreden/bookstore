package bookstore.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;
import bookstore.Bookstore.domain.Category;
import bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Log.info("save a couple of categories and books");
			categoryRepository.save(new Category("Thriller"));
			categoryRepository.save(new Category("Autobiography"));
			categoryRepository.save(new Category("Parody"));

			bookRepository.save(new Book("My first best-seller", "Me", 2019, "123456-12", 200.99, categoryRepository.findByName("Thriller").get(0)));
			bookRepository.save(new Book("My second (attempt at a) best-seller", "Also me", 2020, "654321-13", 40.89, categoryRepository.findByName("Autobiography").get(0)));
			bookRepository.save(new Book("I guess I'm not writing best-sellers after all...", "Still me", 2021, "918273-14", 5.69, categoryRepository.findByName("Parody").get(0)));

			Log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				Log.info(book.toString());
			}
		};
	}
}