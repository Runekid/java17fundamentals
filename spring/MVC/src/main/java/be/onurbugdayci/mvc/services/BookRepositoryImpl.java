package be.onurbugdayci.mvc.services;

import be.onurbugdayci.mvc.domain.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookRepositoryImpl implements BookRepository {

    private Map<String, Book> books = new HashMap();

    @PostConstruct
    public void init() {
        Book book1 = new Book();
        book1.setAuthor("onur");
        book1.setTitle("bugdayci");
        Book book2 = new Book();
        book2.setAuthor("runo");
        book2.setTitle("icyadgub");

        books.put(book1.getTitle(), book1);
        books.put(book2.getTitle(), book2);
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(String title) {
        return books.get(title);
    }
}
