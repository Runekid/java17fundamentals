package be.onurbugdayci.mvc.controller;

import be.onurbugdayci.mvc.domain.Book;
import be.onurbugdayci.mvc.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("list")
    public String bookList(ModelMap model) {
        model.addAttribute("booklist",bookRepository.getBooks());
        return "booklist";
    }

    @GetMapping("detail")
    public String bookDetail(@RequestParam("title") String title,
                             ModelMap model) {
        model.addAttribute("book",bookRepository.getBook(title));
        return "bookdetail";
    }
}
