package bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bookstore.Bookstore.web.BookController;
import bookstore.Bookstore.web.UserController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
