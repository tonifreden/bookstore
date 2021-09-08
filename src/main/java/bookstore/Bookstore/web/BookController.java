package bookstore.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bookstore.Bookstore.domain.Book;

@Controller
public class BookController {
    
    @GetMapping("/index")
    public String book(Model model) { // will later be named better and more accordingly
        model.addAttribute("book", new Book());
        return "index";
    }
}
