package bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bookstore.Bookstore.domain.User;
import bookstore.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
// @DataJpaTest <-- for in-memory database testing
@SpringBootTest
public class UserRepositoryTest {
    
    @Autowired
    UserRepository userRepository;

    @Test
    public void createNewUser() {
        User user = new User("testuser", "$2a$10$JXsZmTO7WJtEXvzEQlrlAuHWjnsYabah2oHMNVznCvHD8MG/LmmCW", "test@mail.com", "USER");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteAllUsers() {
        userRepository.deleteAll();
        assertThat(userRepository.count()).isZero();
    }

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = userRepository.findByUsername("Toni");
        assertThat(user.getEmail()).isEqualTo("toni@mymail.com");
        assertThat(user.getRole()).isEqualTo("ADMIN");
    }

    @Test
    public void findByEmailShouldReturnUser() {
        User user = userRepository.findByEmail("user@awesomemail.com");
        assertThat(user.getUsername()).isEqualTo("user");
        assertThat(user.getRole()).isEqualTo("USER");
    }
}