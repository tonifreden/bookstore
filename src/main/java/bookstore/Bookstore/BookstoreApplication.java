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
import bookstore.Bookstore.domain.User;
import bookstore.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			Log.info("save a couple of categories and books");
			categoryRepository.save(new Category("Thriller"));
			categoryRepository.save(new Category("Autobiography"));
			categoryRepository.save(new Category("Parody"));

			bookRepository.save(new Book("My first best-seller", "Me", 2019, "123456-12", 200.99, categoryRepository.findByName("Thriller").get(0)));
			bookRepository.save(new Book("My second (attempt at a) best-seller", "Also me", 2020, "654321-13", 40.89, categoryRepository.findByName("Autobiography").get(0)));
			bookRepository.save(new Book("I guess I'm not writing best-sellers after all...", "Still me", 2021, "918273-14", 5.69, categoryRepository.findByName("Parody").get(0)));

			userRepository.deleteAll();
			userRepository.save(new User("Toni", "$2a$10$TsLgdl1ZXhEW6/yCAEysNeb.3yNvrVOhspZFKWZk6mQnOgW3aBQga", "toni@mymail.com", "ADMIN"));
			userRepository.save(new User("user", "$2a$10$3ETczh2wWdS8DKItS.M2lOXDPvGJgR1mFBhzrYYCXP8h2xlhVX.m.", "user@awesomemail.com", "USER"));
			userRepository.save(new User("admin", "$2a$10$x21wbs50/mK2eKQz8w0lEueSkJq/NwHj7PSmM4A5QtU60.0QqDC9G", "admin@bossmail.com", "ADMIN"));

			Log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				Log.info(book.toString());
			}
		};
	}
}
