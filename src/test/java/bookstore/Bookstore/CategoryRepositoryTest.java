package bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bookstore.Bookstore.domain.Category;
import bookstore.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
// @DataJpaTest <-- for in-memory database testing
@SpringBootTest
public class CategoryRepositoryTest {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewCategory() {
        Category category = new Category("Educational");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
        assertThat(categoryRepository.count()).isZero();
    }

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Thriller");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getBooks()).hasSize(1);
    }
}